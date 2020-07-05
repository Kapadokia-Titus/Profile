package kapadokia.nyandoro.profileapp.model;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.databinding.library.baseAdapters.BR;

public class User extends BaseObservable {

/**
 * For variables name, email, profileImage and about., @Bindable annotation is used and notifyPropertyChanged is called upon setting new data
 * Variables numberOfPosts, numberOfFollowers, numberOfFollowing are declared as ObservableFields
 * @BindingAdapter is used to bind profileImage to ImageView in order to load the image from URL using Glide library.
 */

 //declarations
    private String name;
    private String email;
    private String profileImage;
    private String about;

    // profile meta-fields are observable fields and will update the UI
    public ObservableField<Long> numberOfPosts = new ObservableField<>();
    public ObservableField<Long> numberOfFollowers = new ObservableField<>();
    public ObservableField<Long> numberOfFollowing = new ObservableField<>();



    // empty constructor
    public User(){}

    // getters and setters
    // use @Bindable annotation for getters
    // and call the notifyPropertyChange method

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @BindingAdapter({"profileImage"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }
    @Bindable
    public String getProfileImage() {
        return profileImage;
    }


    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
    }

    @Bindable
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
        notifyPropertyChanged(androidx.databinding.library.baseAdapters.BR.about);
    }

    public ObservableField<Long> getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(ObservableField<Long> numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public ObservableField<Long> getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(ObservableField<Long> numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public ObservableField<Long> getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(ObservableField<Long> numberOfFollowing) {
        this.numberOfFollowing = numberOfFollowing;
    }
}
