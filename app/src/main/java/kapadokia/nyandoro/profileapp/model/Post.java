package kapadokia.nyandoro.profileapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Post {

    // this model provides data to the recyclerView

   private String imageUrl;

   @BindingAdapter("imageUrl")
   public static void loadImage(ImageView view, String imageUrl){
       Glide.with(view.getContext())
               .load(imageUrl)
               .into(view);
   }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
