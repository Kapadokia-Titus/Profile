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
    private PostsAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final PostRowItemBinding binding;

        public MyViewHolder(final PostRowItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


    public PostAdapter(List<Post> postList, PostsAdapterListener listener) {
        this.postList = postList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        PostRowItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.binding.setPost(postList.get(position));
        holder.binding.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
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
