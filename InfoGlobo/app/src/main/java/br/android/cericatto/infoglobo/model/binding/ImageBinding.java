package br.android.cericatto.infoglobo.model.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import br.android.cericatto.infoglobo.R;

/**
 * ImageBinding.java.
 *
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class ImageBinding {
    @BindingAdapter({"android:src"})
    public static void setImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
            .load(url)
            .placeholder(R.drawable.placeholder)
            .into(imageView);
    }
}