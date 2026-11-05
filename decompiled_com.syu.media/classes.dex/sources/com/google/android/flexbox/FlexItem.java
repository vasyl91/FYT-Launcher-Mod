package com.google.android.flexbox;

import android.os.Parcelable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
interface FlexItem extends Parcelable {
    public static final float FLEX_BASIS_PERCENT_DEFAULT = -1.0f;
    public static final float FLEX_GROW_DEFAULT = 0.0f;
    public static final float FLEX_SHRINK_DEFAULT = 1.0f;
    public static final float FLEX_SHRINK_NOT_SET = 0.0f;
    public static final int MAX_SIZE = 16777215;
    public static final int ORDER_DEFAULT = 1;

    int getAlignSelf();

    float getFlexBasisPercent();

    float getFlexGrow();

    float getFlexShrink();

    int getHeight();

    int getMarginBottom();

    int getMarginEnd();

    int getMarginLeft();

    int getMarginRight();

    int getMarginStart();

    int getMarginTop();

    int getMaxHeight();

    int getMaxWidth();

    int getMinHeight();

    int getMinWidth();

    int getOrder();

    int getWidth();

    boolean isWrapBefore();

    void setAlignSelf(int alignSelf);

    void setFlexBasisPercent(float flexBasisPercent);

    void setFlexGrow(float flexGrow);

    void setFlexShrink(float flexShrink);

    void setHeight(int height);

    void setMaxHeight(int maxHeight);

    void setMaxWidth(int maxWidth);

    void setMinHeight(int minHeight);

    void setMinWidth(int minWidth);

    void setOrder(int order);

    void setWidth(int width);

    void setWrapBefore(boolean wrapBefore);
}
