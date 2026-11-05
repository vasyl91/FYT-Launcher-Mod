package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwipeMenuView extends LinearLayout implements View.OnClickListener {
    private OnItemMenuClickListener mItemClickListener;
    private RecyclerView.ViewHolder mViewHolder;

    public SwipeMenuView(Context context) {
        this(context, null);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setGravity(16);
    }

    public void createMenu(RecyclerView.ViewHolder viewHolder, SwipeMenu swipeMenu, Controller controller, int i, OnItemMenuClickListener onItemMenuClickListener) {
        removeAllViews();
        this.mViewHolder = viewHolder;
        this.mItemClickListener = onItemMenuClickListener;
        List<SwipeMenuItem> menuItems = swipeMenu.getMenuItems();
        for (int i2 = 0; i2 < menuItems.size(); i2++) {
            SwipeMenuItem swipeMenuItem = menuItems.get(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(swipeMenuItem.getWidth(), swipeMenuItem.getHeight());
            layoutParams.weight = swipeMenuItem.getWeight();
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(i2);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            ViewCompat.setBackground(linearLayout, swipeMenuItem.getBackground());
            linearLayout.setOnClickListener(this);
            addView(linearLayout);
            linearLayout.setTag(new SwipeMenuBridge(controller, i, i2));
            if (swipeMenuItem.getImage() != null) {
                linearLayout.addView(createIcon(swipeMenuItem));
            }
            if (!TextUtils.isEmpty(swipeMenuItem.getText())) {
                linearLayout.addView(createTitle(swipeMenuItem));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemMenuClickListener onItemMenuClickListener = this.mItemClickListener;
        if (onItemMenuClickListener != null) {
            onItemMenuClickListener.onItemClick((SwipeMenuBridge) view.getTag(), this.mViewHolder.getAdapterPosition());
        }
    }

    private ImageView createIcon(SwipeMenuItem swipeMenuItem) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(swipeMenuItem.getImage());
        return imageView;
    }

    private TextView createTitle(SwipeMenuItem swipeMenuItem) {
        TextView textView = new TextView(getContext());
        textView.setText(swipeMenuItem.getText());
        textView.setGravity(17);
        int textSize = swipeMenuItem.getTextSize();
        if (textSize > 0) {
            textView.setTextSize(2, textSize);
        }
        ColorStateList titleColor = swipeMenuItem.getTitleColor();
        if (titleColor != null) {
            textView.setTextColor(titleColor);
        }
        int textAppearance = swipeMenuItem.getTextAppearance();
        if (textAppearance != 0) {
            TextViewCompat.setTextAppearance(textView, textAppearance);
        }
        Typeface textTypeface = swipeMenuItem.getTextTypeface();
        if (textTypeface != null) {
            textView.setTypeface(textTypeface);
        }
        return textView;
    }
}
