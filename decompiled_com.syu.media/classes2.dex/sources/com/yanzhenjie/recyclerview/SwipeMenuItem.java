package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwipeMenuItem {
    private Drawable background;
    private Drawable icon;
    private Context mContext;
    private int textAppearance;
    private Typeface textTypeface;
    private String title;
    private ColorStateList titleColor;
    private int titleSize;
    private int width = -2;
    private int height = -2;
    private int weight = 0;

    public SwipeMenuItem(Context context) {
        this.mContext = context;
    }

    public SwipeMenuItem setBackground(int i) {
        return setBackground(ContextCompat.getDrawable(this.mContext, i));
    }

    public SwipeMenuItem setBackground(Drawable drawable) {
        this.background = drawable;
        return this;
    }

    public SwipeMenuItem setBackgroundColorResource(int i) {
        return setBackgroundColor(ContextCompat.getColor(this.mContext, i));
    }

    public SwipeMenuItem setBackgroundColor(int i) {
        this.background = new ColorDrawable(i);
        return this;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public SwipeMenuItem setImage(int i) {
        return setImage(ContextCompat.getDrawable(this.mContext, i));
    }

    public SwipeMenuItem setImage(Drawable drawable) {
        this.icon = drawable;
        return this;
    }

    public Drawable getImage() {
        return this.icon;
    }

    public SwipeMenuItem setText(int i) {
        return setText(this.mContext.getString(i));
    }

    public SwipeMenuItem setText(String str) {
        this.title = str;
        return this;
    }

    public String getText() {
        return this.title;
    }

    public SwipeMenuItem setTextColorResource(int i) {
        return setTextColor(ContextCompat.getColor(this.mContext, i));
    }

    public SwipeMenuItem setTextColor(int i) {
        this.titleColor = ColorStateList.valueOf(i);
        return this;
    }

    public ColorStateList getTitleColor() {
        return this.titleColor;
    }

    public SwipeMenuItem setTextSize(int i) {
        this.titleSize = i;
        return this;
    }

    public int getTextSize() {
        return this.titleSize;
    }

    public SwipeMenuItem setTextAppearance(int i) {
        this.textAppearance = i;
        return this;
    }

    public int getTextAppearance() {
        return this.textAppearance;
    }

    public SwipeMenuItem setTextTypeface(Typeface typeface) {
        this.textTypeface = typeface;
        return this;
    }

    public Typeface getTextTypeface() {
        return this.textTypeface;
    }

    public SwipeMenuItem setWidth(int i) {
        this.width = i;
        return this;
    }

    public int getWidth() {
        return this.width;
    }

    public SwipeMenuItem setHeight(int i) {
        this.height = i;
        return this;
    }

    public int getHeight() {
        return this.height;
    }

    public SwipeMenuItem setWeight(int i) {
        this.weight = i;
        return this;
    }

    public int getWeight() {
        return this.weight;
    }
}
