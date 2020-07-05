package kapadokia.nyandoro.profileapp.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kapadokia.nyandoro.profileapp.R;
import kapadokia.nyandoro.profileapp.databinding.PostRowItemBinding;
import kapadokia.nyandoro.profileapp.model.Post;

import static android.content.ContentValues.TAG;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> postList;
    private LayoutInflater layoutInflater;
    private PostsAdapterListener listener ;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final PostRowItemBinding binding;

        public MyViewHolder(View itemBinding) {
            super(itemBinding);
            binding = DataBindingUtil.bind(itemBinding);
        }
    }

    public PostAdapter(Context context, List<Post> postList, PostsAdapterListener listener){

        this.postList = postList;
        this.listener = listener;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       PostRowItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.post_row_item,parent,false);
       return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.binding.setPost(postList.get(position));
        holder.binding.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onPostClicked(postList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public interface PostsAdapterListener {
        void onPostClicked(Post post);
    }
}
