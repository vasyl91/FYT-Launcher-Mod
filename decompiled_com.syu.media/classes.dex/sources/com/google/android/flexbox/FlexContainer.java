package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
interface FlexContainer {
    public static final int NOT_SET = -1;

    void addView(View view);

    void addView(View view, int index);

    int getAlignContent();

    int getAlignItems();

    int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension);

    int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension);

    int getDecorationLengthCrossAxis(View view);

    int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine);

    int getFlexDirection();

    View getFlexItemAt(int index);

    int getFlexItemCount();

    List<FlexLine> getFlexLines();

    List<FlexLine> getFlexLinesInternal();

    int getFlexWrap();

    int getJustifyContent();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    View getReorderedFlexItemAt(int index);

    int getSumOfCrossSize();

    boolean isMainAxisDirectionHorizontal();

    void onNewFlexItemAdded(View view, int index, int indexInFlexLine, FlexLine flexLine);

    void onNewFlexLineAdded(FlexLine flexLine);

    void removeAllViews();

    void removeViewAt(int index);

    void setAlignContent(int alignContent);

    void setAlignItems(int alignItems);

    void setFlexDirection(int flexDirection);

    void setFlexLines(List<FlexLine> flexLines);

    void setFlexWrap(int flexWrap);

    void setJustifyContent(int justifyContent);

    void setMaxLine(int maxLine);

    void updateViewCache(int position, View view);
}
