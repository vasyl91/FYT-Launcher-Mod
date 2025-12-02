package com.android.launcher66;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class LauncherGlideBitmapLoader {

    public interface BitmapLoadListener {
        void onBitmapLoaded(@NonNull Bitmap bitmap);
        void onLoadFailed();
    }

    public static void loadBitmapAsync(int drawableResId, @NonNull BitmapLoadListener listener) {
        if (LauncherApplication.sApp == null) {
            listener.onLoadFailed();
            return;
        }

        Glide.with(LauncherApplication.sApp)
            .asBitmap()
            .load(drawableResId)
            .into(new CustomTarget<Bitmap>() {
                @Override
                public void onResourceReady(
                    @NonNull Bitmap bitmap,
                    @Nullable Transition<? super Bitmap> transition
                ) {
                    listener.onBitmapLoaded(bitmap);
                }

                @Override
                public void onLoadFailed(@Nullable Drawable errorDrawable) {
                    listener.onLoadFailed();
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                    if (placeholder != null) {
                        placeholder.setCallback(null);
                    }
                }
            });
    }
}