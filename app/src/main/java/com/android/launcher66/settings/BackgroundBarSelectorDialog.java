package com.android.launcher66.settings;

import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BackgroundBarSelectorDialog extends DialogFragment {
    
    private SharedPreferences sharedPreferences;
    private String selectedBackground;
    private List<String> backgroundNames;
    private GridLayout gridLayout;
    
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.bar_background_selector, null);

        setSystemWallpaperAsBackground(view);
        
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        selectedBackground = sharedPreferences.getString(Keys.BAR_SELECTED_BACKGROUND, "app_list_bg");
        
        gridLayout = view.findViewById(R.id.bar_background_grid);
        Button cancelButton = view.findViewById(R.id.bar_background_cancel_button);
        
        loadBackgrounds();
        setupGrid();
        
        cancelButton.setOnClickListener(v -> dismiss());
        
        builder.setView(view);
        
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        
        int orientation = requireContext().getResources().getConfiguration().orientation;
        int dialogWidth;
        int dialogHeight;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            dialogWidth = (int) (Launcher.screenWidth * 0.8);
            dialogHeight = (int) (Launcher.screenHeight * 0.7);
        } else {
            dialogWidth = (int) (Launcher.screenWidth * 0.7);
            dialogHeight = (int) (Launcher.screenHeight * 0.8);
        }
        
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setLayout(dialogWidth, dialogHeight);
        }
    }

    private void setSystemWallpaperAsBackground(View view) {
        try {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(requireContext());
            Drawable wallpaperDrawable = wallpaperManager.getDrawable();
            view.setBackground(wallpaperDrawable);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadBackgrounds() {
        backgroundNames = new ArrayList<>();
        Resources resources = requireContext().getResources();
        Field[] drawables = R.drawable.class.getFields();
        
        for (Field field : drawables) {
            try {
                String name = field.getName();
                if (name.contains("app_list_bg")) {
                    backgroundNames.add(name);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void setupGrid() {
        gridLayout.removeAllViews();
        gridLayout.setColumnCount(4);
        
        int padding = dpToPx(8);
        int cornerRadius = dpToPx(12);
        
        for (String bgName : backgroundNames) {
            CardView cardView = new CardView(requireContext());
            
            // Make CardView completely transparent
            cardView.setCardBackgroundColor(Color.TRANSPARENT);
            cardView.setRadius(cornerRadius);
            cardView.setCardElevation(0); // Remove shadow if not needed
            cardView.setUseCompatPadding(false);
            cardView.setPreventCornerOverlap(false);
            
            ImageView imageView = new ImageView(requireContext());
            int resId = getResources().getIdentifier(bgName, "drawable", requireContext().getPackageName());
            Drawable background = getResources().getDrawable(resId, null);
            
            // Apply corner radius directly to the drawable
            if (background instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) background).getBitmap();
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                roundedBitmapDrawable.setCornerRadius(cornerRadius);
                imageView.setImageDrawable(roundedBitmapDrawable);
            } else {
                // For other drawables, use a rounded drawable
                imageView.setImageDrawable(background);
                imageView.setClipToOutline(true);
                imageView.setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), cornerRadius);
                    }
                });
            }
            
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            
            // Add ImageView to CardView
            cardView.addView(imageView);
            
            GridLayout.LayoutParams cardParams = new GridLayout.LayoutParams();
            cardParams.width = dpToPx((int) (Launcher.screenWidth * 0.16f));
            cardParams.height = dpToPx((int) (Launcher.screenWidth * 0.16f));
            cardParams.setMargins(padding, padding, padding, padding);
            cardView.setLayoutParams(cardParams);
            
            // ImageView should match CardView size
            FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            );
            imageView.setLayoutParams(imageParams);
            
            if (bgName.equals(selectedBackground)) {
                addBlueFrame(cardView);
            }
            
            cardView.setOnClickListener(v -> {
                selectedBackground = bgName;
                sharedPreferences.edit().putString(Keys.BAR_SELECTED_BACKGROUND, bgName).apply();
                dismiss();
            });
            
            gridLayout.addView(cardView);
        }
    }
        
    private void addBlueFrame(CardView cardView) {
        GradientDrawable border = new GradientDrawable();
        border.setShape(GradientDrawable.RECTANGLE);
        border.setCornerRadius(cardView.getRadius());
        border.setStroke(dpToPx(8), Color.parseColor("#FC6B03"));
        cardView.setForeground(border);
    } 
    
    private int dpToPx(int dp) {
        float density = requireContext().getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}