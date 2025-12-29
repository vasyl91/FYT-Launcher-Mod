package com.android.launcher66.settings;

import static com.android.launcher66.settings.SettingsActivity.getSettingsActivity;

import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PreferenceScaleHelper {
    
    private static final int SCALE_TAG_KEY = "scale_applied".hashCode();
    private static final String TAG = "PreferenceScaleHelper";
    private static int navigationBarHeight;
    
    public static void scaleRecyclerView(RecyclerView recyclerView, float scale) {
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {
                // Check if already scaled
                if (view.getTag(SCALE_TAG_KEY) == null) {
                    scalePreferenceItem(view, scale);
                    view.setTag(SCALE_TAG_KEY, true);
                }
            }
            
            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {
                // Do nothing
            }
        });

        int statusBarHeight = getSettingsActivity().getStatusBarHeight();
        int actionBarHeight = getSettingsActivity().getActionBarHeight();
        navigationBarHeight = getSettingsActivity().getNavigationBarHeight();
        
        // Scale existing items
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View child = recyclerView.getChildAt(i);
            if (child.getTag(SCALE_TAG_KEY) == null) {
                scalePreferenceItem(child, scale);
                child.setTag(SCALE_TAG_KEY, true);
            }
        }
        
        Log.i(TAG, "Heights - Status: " + statusBarHeight +
              ", Nav: " + navigationBarHeight + 
              ", ActionBar: " + actionBarHeight +
              ", isPortrait: " + getSettingsActivity().isPortrait);
        
        int topPadding = statusBarHeight + actionBarHeight;
        Log.i(TAG, "Found RecyclerView! Applying padding - top: " + topPadding + ", bottom: " + navigationBarHeight);
        if (getSettingsActivity().isPortrait) {
            recyclerView.setPadding(
                recyclerView.getPaddingLeft(),
                topPadding,
                recyclerView.getPaddingRight(),
                navigationBarHeight
            );
        } else {
            recyclerView.setPadding(
                recyclerView.getPaddingLeft(),
                topPadding,
                recyclerView.getPaddingRight() + navigationBarHeight,
                recyclerView.getPaddingBottom()
            );
        }
        recyclerView.setClipToPadding(false);
        recyclerView.smoothScrollToPosition(0);
    }

    private static void scalePreferenceItem(View view, float scale) {        
        // Adjust scale for non-text elements in portrait
        float nonTextScale = getSettingsActivity().isPortrait ? scale / 1.5f : scale;
        
        // Scale padding and margins 
        scalePaddingAndMargins(view, nonTextScale);
        
        // Scale the entire preference item with adjusted scale
        view.setScaleX(nonTextScale);
        view.setScaleY(nonTextScale);
        
        // Adjust pivot to top-left so it scales from that corner
        view.setPivotX(0);
        view.setPivotY(0);

        int adjustedScreenWidth = (int) (getSettingsActivity().screenWidth / nonTextScale);
        if (!getSettingsActivity().isPortrait) {
            adjustedScreenWidth = (int) (getSettingsActivity().screenWidth / nonTextScale - navigationBarHeight - 20);
        }     
        
        // Compensate width to maintain full screen width
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null && params.width != ViewGroup.LayoutParams.WRAP_CONTENT) {
            // Calculate width needed to appear as full screen after scaling
            params.width = adjustedScreenWidth;
            view.setLayoutParams(params);
        }
        
        // If portrait, scale TextViews separately with original scale
        if (getSettingsActivity().isPortrait) {
            scaleTextViewsOnly(view, scale);
        }
    }

    private static void scalePaddingAndMargins(View view, float scale) {
        // Scale padding
        int paddingLeft = (int) (view.getPaddingLeft() * scale);
        int paddingTop = (int) (view.getPaddingTop() * scale);
        int paddingRight = (int) (view.getPaddingRight() * scale);
        int paddingBottom = (int) (view.getPaddingBottom() * scale);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        
        // Scale margins
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) params;
            marginParams.leftMargin = (int) (marginParams.leftMargin * scale);
            marginParams.topMargin = (int) (marginParams.topMargin * scale);
            marginParams.rightMargin = (int) (marginParams.rightMargin * scale);
            marginParams.bottomMargin = (int) (marginParams.bottomMargin * scale);
            view.setLayoutParams(params);
        }
        
        // Recursively scale padding and margins for children
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                scalePaddingAndMargins(viewGroup.getChildAt(i), scale);
            }
        }
    }

    private static void scaleTextViewsOnly(View view, float scale) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            float currentSizePx = textView.getTextSize();
            // Compensate for the parent's scale and apply the original scale
            float compensationFactor = 2.0f; // Since parent is scaled by scale/2
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSizePx * scale * compensationFactor);
        }
        
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                scaleTextViewsOnly(viewGroup.getChildAt(i), scale);
            }
        }
    }
    
    private static void scaleView(View view, float scale) {
        // Scale TextView
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            float currentSizePx = textView.getTextSize();
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSizePx * scale);
        }
        
        // Scale ImageView
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            if (params != null) {
                if (params.width > 0) {
                    params.width = (int) (params.width * scale);
                }
                if (params.height > 0) {
                    params.height = (int) (params.height * scale);
                }
                imageView.setLayoutParams(params);
            }
        }
        
        // Scale padding for all views
        int paddingLeft = (int) (view.getPaddingLeft() * scale);
        int paddingTop = (int) (view.getPaddingTop() * scale);
        int paddingRight = (int) (view.getPaddingRight() * scale);
        int paddingBottom = (int) (view.getPaddingBottom() * scale);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        
        // Scale layout params for all views
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params != null) {
            if (params.width > 0) {
                params.width = (int) (params.width * scale);
            }
            if (params.height > 0) {
                params.height = (int) (params.height * scale);
            }
            
            // Scale margins if present
            if (params instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) params;
                marginParams.leftMargin = (int) (marginParams.leftMargin * scale);
                marginParams.topMargin = (int) (marginParams.topMargin * scale);
                marginParams.rightMargin = (int) (marginParams.rightMargin * scale);
                marginParams.bottomMargin = (int) (marginParams.bottomMargin * scale);
            }
            
            view.setLayoutParams(params);
        }
        
        // Scale minimum height for all views
        if (view.getMinimumHeight() > 0) {
            view.setMinimumHeight((int) (view.getMinimumHeight() * scale));
        }
        
        // Scale minimum width for all views
        if (view.getMinimumWidth() > 0) {
            view.setMinimumWidth((int) (view.getMinimumWidth() * scale));
        }
        
        // Apply scale transformation to the view itself
        view.setScaleX(scale);
        view.setScaleY(scale);
        
        // Recursively scale children AFTER scaling the parent
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                scaleView(viewGroup.getChildAt(i), scale);
            }
        }
    }
}