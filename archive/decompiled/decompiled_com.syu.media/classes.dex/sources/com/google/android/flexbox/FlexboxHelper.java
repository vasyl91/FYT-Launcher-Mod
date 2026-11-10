package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class FlexboxHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;
    int[] mIndexToFlexLine;
    long[] mMeasureSpecCache;
    private long[] mMeasuredSizeCache;

    int extractHigherInt(long longValue) {
        return (int) (longValue >> 32);
    }

    int extractLowerInt(long longValue) {
        return (int) longValue;
    }

    long makeCombinedLong(int widthMeasureSpec, int heightMeasureSpec) {
        return (((long) widthMeasureSpec) & MEASURE_SPEC_WIDTH_MASK) | (((long) heightMeasureSpec) << 32);
    }

    FlexboxHelper(FlexContainer flexContainer) {
        this.mFlexContainer = flexContainer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] createReorderedIndices(View viewBeforeAdded, int indexForViewBeforeAdded, ViewGroup.LayoutParams paramsForViewBeforeAdded, SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        List<Order> listCreateOrders = createOrders(flexItemCount);
        Order order = new Order();
        if (viewBeforeAdded != null && (paramsForViewBeforeAdded instanceof FlexItem)) {
            order.order = ((FlexItem) paramsForViewBeforeAdded).getOrder();
        } else {
            order.order = 1;
        }
        if (indexForViewBeforeAdded != -1 && indexForViewBeforeAdded != flexItemCount && indexForViewBeforeAdded < this.mFlexContainer.getFlexItemCount()) {
            order.index = indexForViewBeforeAdded;
            while (indexForViewBeforeAdded < flexItemCount) {
                listCreateOrders.get(indexForViewBeforeAdded).index++;
                indexForViewBeforeAdded++;
            }
        } else {
            order.index = flexItemCount;
        }
        listCreateOrders.add(order);
        return sortOrdersIntoReorderedIndices(flexItemCount + 1, listCreateOrders, orderCache);
    }

    int[] createReorderedIndices(SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        return sortOrdersIntoReorderedIndices(flexItemCount, createOrders(flexItemCount), orderCache);
    }

    private List<Order> createOrders(int childCount) {
        ArrayList arrayList = new ArrayList(childCount);
        for (int i = 0; i < childCount; i++) {
            FlexItem flexItem = (FlexItem) this.mFlexContainer.getFlexItemAt(i).getLayoutParams();
            Order order = new Order();
            order.order = flexItem.getOrder();
            order.index = i;
            arrayList.add(order);
        }
        return arrayList;
    }

    boolean isOrderChangedFromLastMeasurement(SparseIntArray orderCache) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        if (orderCache.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.mFlexContainer.getFlexItemAt(i);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != orderCache.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] sortOrdersIntoReorderedIndices(int childCount, List<Order> orders, SparseIntArray orderCache) {
        Collections.sort(orders);
        orderCache.clear();
        int[] iArr = new int[childCount];
        int i = 0;
        for (Order order : orders) {
            iArr[i] = order.index;
            orderCache.append(order.index, order.order);
            i++;
        }
        return iArr;
    }

    void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    void calculateHorizontalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    void calculateVerticalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void calculateFlexLines(FlexLinesResult flexLinesResult, int i, int i2, int i3, int i4, int i5, List<FlexLine> list) {
        int i6;
        int i7;
        List<FlexLine> list2;
        int i8;
        View view;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i2;
        int i16 = i5;
        boolean zIsMainAxisDirectionHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<FlexLine> arrayList = list == null ? new ArrayList() : list;
        flexLinesResult.mFlexLines = arrayList;
        int i17 = i16 == -1 ? 1 : 0;
        int paddingStartMain = getPaddingStartMain(zIsMainAxisDirectionHorizontal);
        int paddingEndMain = getPaddingEndMain(zIsMainAxisDirectionHorizontal);
        int paddingStartCross = getPaddingStartCross(zIsMainAxisDirectionHorizontal);
        int paddingEndCross = getPaddingEndCross(zIsMainAxisDirectionHorizontal);
        FlexLine flexLine = new FlexLine();
        int i18 = i4;
        flexLine.mFirstIndex = i18;
        int i19 = paddingEndMain + paddingStartMain;
        flexLine.mMainSize = i19;
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        int i20 = i17;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        int iCombineMeasuredStates = 0;
        int i23 = 0;
        while (i18 < flexItemCount) {
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i18);
            if (reorderedFlexItemAt == null) {
                if (isLastFlexItem(i18, flexItemCount, flexLine)) {
                    addFlexLine(arrayList, flexLine, i18, i22);
                }
            } else {
                if (reorderedFlexItemAt.getVisibility() == 8) {
                    flexLine.mGoneItemCount++;
                    flexLine.mItemCount++;
                    if (isLastFlexItem(i18, flexItemCount, flexLine)) {
                        addFlexLine(arrayList, flexLine, i18, i22);
                    }
                } else {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        evaluateMinimumSizeForCompoundButton((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i24 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        flexLine.mIndicesAlignSelfStretch.add(Integer.valueOf(i18));
                    }
                    int flexItemSizeMain = getFlexItemSizeMain(flexItem, zIsMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        flexItemSizeMain = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (zIsMainAxisDirectionHorizontal) {
                        int childWidthMeasureSpec = this.mFlexContainer.getChildWidthMeasureSpec(i, i19 + getFlexItemMarginStartMain(flexItem, true) + getFlexItemMarginEndMain(flexItem, true), flexItemSizeMain);
                        int childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(i15, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, true) + getFlexItemMarginEndCross(flexItem, true) + i22, getFlexItemSizeCross(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        updateMeasureCache(i18, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i7 = childWidthMeasureSpec;
                    } else {
                        int childWidthMeasureSpec2 = this.mFlexContainer.getChildWidthMeasureSpec(i15, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, false) + getFlexItemMarginEndCross(flexItem, false) + i22, getFlexItemSizeCross(flexItem, false));
                        int childHeightMeasureSpec2 = this.mFlexContainer.getChildHeightMeasureSpec(i, getFlexItemMarginStartMain(flexItem, false) + i19 + getFlexItemMarginEndMain(flexItem, false), flexItemSizeMain);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        updateMeasureCache(i18, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i7 = childHeightMeasureSpec2;
                    }
                    this.mFlexContainer.updateViewCache(i18, reorderedFlexItemAt);
                    checkSizeConstraints(reorderedFlexItemAt, i18);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                    int i25 = flexLine.mMainSize;
                    int i26 = i22;
                    int i27 = i19;
                    FlexLine flexLine2 = flexLine;
                    int i28 = size;
                    int i29 = i18;
                    list2 = arrayList;
                    int i30 = i7;
                    if (isWrapRequired(reorderedFlexItemAt, mode, i28, i25, getFlexItemMarginEndMain(flexItem, zIsMainAxisDirectionHorizontal) + getViewMeasuredSizeMain(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, zIsMainAxisDirectionHorizontal), flexItem, i29, i23, arrayList.size())) {
                        if (flexLine2.getItemCountNotGone() > 0) {
                            addFlexLine(list2, flexLine2, i29 > 0 ? i29 - 1 : 0, i26);
                            i22 = flexLine2.mCrossSize + i26;
                        } else {
                            i22 = i26;
                        }
                        if (zIsMainAxisDirectionHorizontal) {
                            if (flexItem.getHeight() == -1) {
                                FlexContainer flexContainer = this.mFlexContainer;
                                i8 = i2;
                                i18 = i29;
                                view = reorderedFlexItemAt;
                                view.measure(i30, flexContainer.getChildHeightMeasureSpec(i8, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i22, flexItem.getHeight()));
                                checkSizeConstraints(view, i18);
                            } else {
                                i8 = i2;
                                view = reorderedFlexItemAt;
                                i18 = i29;
                            }
                        } else {
                            i8 = i2;
                            view = reorderedFlexItemAt;
                            i18 = i29;
                            if (flexItem.getWidth() == -1) {
                                FlexContainer flexContainer2 = this.mFlexContainer;
                                view.measure(flexContainer2.getChildWidthMeasureSpec(i8, flexContainer2.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i22, flexItem.getWidth()), i30);
                                checkSizeConstraints(view, i18);
                            }
                        }
                        flexLine = new FlexLine();
                        i10 = 1;
                        flexLine.mItemCount = 1;
                        i9 = i27;
                        flexLine.mMainSize = i9;
                        flexLine.mFirstIndex = i18;
                        i12 = Integer.MIN_VALUE;
                        i11 = 0;
                    } else {
                        i8 = i2;
                        view = reorderedFlexItemAt;
                        i18 = i29;
                        flexLine = flexLine2;
                        i9 = i27;
                        i10 = 1;
                        flexLine.mItemCount++;
                        i11 = i23 + 1;
                        i22 = i26;
                        i12 = i21;
                    }
                    flexLine.mAnyItemsHaveFlexGrow = (flexLine.mAnyItemsHaveFlexGrow ? 1 : 0) | (flexItem.getFlexGrow() != 0.0f ? i10 : 0);
                    flexLine.mAnyItemsHaveFlexShrink = (flexLine.mAnyItemsHaveFlexShrink ? 1 : 0) | (flexItem.getFlexShrink() != 0.0f ? i10 : 0);
                    int[] iArr = this.mIndexToFlexLine;
                    if (iArr != null) {
                        iArr[i18] = list2.size();
                    }
                    flexLine.mMainSize += getViewMeasuredSizeMain(view, zIsMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, zIsMainAxisDirectionHorizontal) + getFlexItemMarginEndMain(flexItem, zIsMainAxisDirectionHorizontal);
                    flexLine.mTotalFlexGrow += flexItem.getFlexGrow();
                    flexLine.mTotalFlexShrink += flexItem.getFlexShrink();
                    this.mFlexContainer.onNewFlexItemAdded(view, i18, i11, flexLine);
                    int iMax = Math.max(i12, getViewMeasuredSizeCross(view, zIsMainAxisDirectionHorizontal) + getFlexItemMarginStartCross(flexItem, zIsMainAxisDirectionHorizontal) + getFlexItemMarginEndCross(flexItem, zIsMainAxisDirectionHorizontal) + this.mFlexContainer.getDecorationLengthCrossAxis(view));
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                    if (zIsMainAxisDirectionHorizontal) {
                        if (this.mFlexContainer.getFlexWrap() != 2) {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i13 = i24;
                    if (isLastFlexItem(i18, i13, flexLine)) {
                        addFlexLine(list2, flexLine, i18, i22);
                        i22 += flexLine.mCrossSize;
                    }
                    i14 = i5;
                    if (i14 != -1 && list2.size() > 0 && list2.get(list2.size() - i10).mLastIndex >= i14 && i18 >= i14 && i20 == 0) {
                        i22 = -flexLine.getCrossSize();
                        i20 = i10;
                    }
                    if (i22 > i3 && i20 != 0) {
                        i6 = iCombineMeasuredStates;
                        flexLinesResult.mChildState = i6;
                    } else {
                        i23 = i11;
                        i21 = iMax;
                    }
                }
                i18++;
                flexItemCount = i13;
                i15 = i8;
                i19 = i9;
                arrayList = list2;
                size = size;
                i16 = i14;
                mode = mode;
            }
            size = size;
            mode = mode;
            i8 = i15;
            i14 = i16;
            list2 = arrayList;
            i9 = i19;
            i13 = flexItemCount;
            i18++;
            flexItemCount = i13;
            i15 = i8;
            i19 = i9;
            arrayList = list2;
            size = size;
            i16 = i14;
            mode = mode;
        }
        i6 = iCombineMeasuredStates;
        flexLinesResult.mChildState = i6;
    }

    private void evaluateMinimumSizeForCompoundButton(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    private int getPaddingStartMain(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingStart();
        }
        return this.mFlexContainer.getPaddingTop();
    }

    private int getPaddingEndMain(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingEnd();
        }
        return this.mFlexContainer.getPaddingBottom();
    }

    private int getPaddingStartCross(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingTop();
        }
        return this.mFlexContainer.getPaddingStart();
    }

    private int getPaddingEndCross(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingBottom();
        }
        return this.mFlexContainer.getPaddingEnd();
    }

    private int getViewMeasuredSizeMain(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int getViewMeasuredSizeCross(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int getFlexItemSizeMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int getFlexItemSizeCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int getFlexItemMarginStartMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int getFlexItemMarginEndMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int getFlexItemMarginStartCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int getFlexItemMarginEndCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private boolean isWrapRequired(View view, int mode, int maxSize, int currentLength, int childLength, FlexItem flexItem, int index, int indexInFlexLine, int flexLinesSize) {
        if (this.mFlexContainer.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (mode == 0) {
            return false;
        }
        int maxLine = this.mFlexContainer.getMaxLine();
        if (maxLine != -1 && maxLine <= flexLinesSize + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.mFlexContainer.getDecorationLengthMainAxis(view, index, indexInFlexLine);
        if (decorationLengthMainAxis > 0) {
            childLength += decorationLengthMainAxis;
        }
        return maxSize < currentLength + childLength;
    }

    private boolean isLastFlexItem(int childIndex, int childCount, FlexLine flexLine) {
        return childIndex == childCount - 1 && flexLine.getItemCountNotGone() != 0;
    }

    private void addFlexLine(List<FlexLine> flexLines, FlexLine flexLine, int viewIndex, int usedCrossSizeSoFar) {
        flexLine.mSumCrossSizeBefore = usedCrossSizeSoFar;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = viewIndex;
        flexLines.add(flexLine);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void checkSizeConstraints(View view, int index) {
        boolean z;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
        } else {
            if (measuredWidth > flexItem.getMaxWidth()) {
                measuredWidth = flexItem.getMaxWidth();
            } else {
                z = false;
            }
            if (measuredHeight < flexItem.getMinHeight()) {
                measuredHeight = flexItem.getMinHeight();
            } else if (measuredHeight > flexItem.getMaxHeight()) {
                measuredHeight = flexItem.getMaxHeight();
            } else {
                z2 = z;
            }
            if (z2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                updateMeasureCache(index, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.mFlexContainer.updateViewCache(index, view);
            }
        }
        z = true;
        if (measuredHeight < flexItem.getMinHeight()) {
            measuredHeight = flexItem.getMinHeight();
        } else if (measuredHeight > flexItem.getMaxHeight()) {
            measuredHeight = flexItem.getMaxHeight();
        } else {
            z2 = z;
        }
        if (z2) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            updateMeasureCache(index, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
            this.mFlexContainer.updateViewCache(index, view);
        }
    }

    void determineMainSize(int widthMeasureSpec, int heightMeasureSpec) {
        determineMainSize(widthMeasureSpec, heightMeasureSpec, 0);
    }

    void determineMainSize(int widthMeasureSpec, int heightMeasureSpec, int fromIndex) {
        int size;
        int paddingLeft;
        int paddingRight;
        ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (fromIndex >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        int flexDirection2 = this.mFlexContainer.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
            int largestMainSize = this.mFlexContainer.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.mFlexContainer.getPaddingLeft();
            paddingRight = this.mFlexContainer.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode2 != 1073741824) {
                size = this.mFlexContainer.getLargestMainSize();
            }
            paddingLeft = this.mFlexContainer.getPaddingTop();
            paddingRight = this.mFlexContainer.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        int i = paddingLeft + paddingRight;
        int[] iArr = this.mIndexToFlexLine;
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[fromIndex] : 0; i2 < size2; i2++) {
            FlexLine flexLine = flexLinesInternal.get(i2);
            if (flexLine.mMainSize < size && flexLine.mAnyItemsHaveFlexGrow) {
                expandFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, size, i, false);
            } else if (flexLine.mMainSize > size && flexLine.mAnyItemsHaveFlexShrink) {
                shrinkFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, size, i, false);
            }
        }
    }

    private void ensureChildrenFrozen(int size) {
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null) {
            this.mChildrenFrozen = new boolean[Math.max(size, 10)];
        } else if (zArr.length < size) {
            this.mChildrenFrozen = new boolean[Math.max(zArr.length * 2, size)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void expandFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i;
        int iMax;
        double d;
        int i2;
        double d2;
        float f = 0.0f;
        if (flexLine.mTotalFlexGrow <= 0.0f || maxMainSize < flexLine.mMainSize) {
            return;
        }
        int i3 = flexLine.mMainSize;
        float f2 = (maxMainSize - flexLine.mMainSize) / flexLine.mTotalFlexGrow;
        flexLine.mMainSize = paddingAlongMainAxis + flexLine.mDividerLengthInMainSize;
        if (!calledRecursively) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i4 = 0;
        float f3 = 0.0f;
        boolean z = false;
        int i5 = 0;
        while (i4 < flexLine.mItemCount) {
            int i6 = flexLine.mFirstIndex + i4;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i6);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i = i3;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i7 = i3;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i6]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    i = i7;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i6]);
                    }
                    if (!this.mChildrenFrozen[i6] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f2);
                        if (i4 == flexLine.mItemCount - 1) {
                            flexGrow += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.mChildrenFrozen[i6] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            z = true;
                        } else {
                            f3 += flexGrow - iRound;
                            double d3 = f3;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f3 = (float) d;
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i6, iMakeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i6, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i5, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i6]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i6]);
                    }
                    if (this.mChildrenFrozen[i6] || flexItem.getFlexGrow() <= f) {
                        i2 = i3;
                    } else {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f2);
                        if (i4 == flexLine.mItemCount - 1) {
                            flexGrow2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.mChildrenFrozen[i6] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            i2 = i3;
                            z = true;
                        } else {
                            f3 += flexGrow2 - iRound2;
                            i2 = i3;
                            double d4 = f3;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f3 = (float) d2;
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i6, childWidthMeasureSpecInternal, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i6, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i5, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i = i2;
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                i5 = iMax;
            }
            i4++;
            i3 = i;
            f = 0.0f;
        }
        int i8 = i3;
        if (!z || i8 == flexLine.mMainSize) {
            return;
        }
        expandFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    private void shrinkFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i;
        int iMax;
        int i2 = flexLine.mMainSize;
        float f = 0.0f;
        if (flexLine.mTotalFlexShrink <= 0.0f || maxMainSize > flexLine.mMainSize) {
            return;
        }
        float f2 = (flexLine.mMainSize - maxMainSize) / flexLine.mTotalFlexShrink;
        flexLine.mMainSize = paddingAlongMainAxis + flexLine.mDividerLengthInMainSize;
        if (!calledRecursively) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i3 = 0;
        float f3 = 0.0f;
        boolean z = false;
        int i4 = 0;
        while (i3 < flexLine.mItemCount) {
            int i5 = flexLine.mFirstIndex + i3;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i5);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i = i3;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i = i3;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i5]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i5]);
                    }
                    if (!this.mChildrenFrozen[i5] && flexItem.getFlexShrink() > 0.0f) {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f2);
                        if (i == flexLine.mItemCount - 1) {
                            flexShrink += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            iRound = flexItem.getMinWidth();
                            this.mChildrenFrozen[i5] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            z = true;
                        } else {
                            f3 += flexShrink - iRound;
                            double d = f3;
                            if (d > 1.0d) {
                                iRound++;
                                f3 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f3 += 1.0f;
                            }
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i5, iMakeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i5, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i4, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i5]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i5]);
                    }
                    if (this.mChildrenFrozen[i5] || flexItem.getFlexShrink() <= f) {
                        i = i3;
                    } else {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f2);
                        if (i3 == flexLine.mItemCount - 1) {
                            flexShrink2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.mChildrenFrozen[i5] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            i = i3;
                            z = true;
                        } else {
                            f3 += flexShrink2 - iRound2;
                            i = i3;
                            double d2 = f3;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f3 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f3 += 1.0f;
                            }
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i5, childWidthMeasureSpecInternal, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i5, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i4, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                i4 = iMax;
            }
            i3 = i + 1;
            f = 0.0f;
        }
        if (!z || i2 == flexLine.mMainSize) {
            return;
        }
        shrinkFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    private int getChildWidthMeasureSpecInternal(int widthMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(widthMeasureSpec, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + padding, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    private int getChildHeightMeasureSpecInternal(int heightMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(heightMeasureSpec, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + padding, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    void determineCrossSize(int widthMeasureSpec, int heightMeasureSpec, int paddingAlongCrossAxis) {
        int mode;
        int size;
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            mode = mode2;
            size = size2;
        } else if (flexDirection == 2 || flexDirection == 3) {
            mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mFlexContainer.getSumOfCrossSize() + paddingAlongCrossAxis;
            int i = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mCrossSize = size - paddingAlongCrossAxis;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.mFlexContainer.getAlignContent();
                if (alignContent == 1) {
                    int i2 = size - sumOfCrossSize;
                    FlexLine flexLine = new FlexLine();
                    flexLine.mCrossSize = i2;
                    flexLinesInternal.add(0, flexLine);
                    return;
                }
                if (alignContent == 2) {
                    this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i < size4) {
                        arrayList.add(flexLinesInternal.get(i));
                        if (i != flexLinesInternal.size() - 1) {
                            FlexLine flexLine2 = new FlexLine();
                            if (i == flexLinesInternal.size() - 2) {
                                flexLine2.mCrossSize = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                flexLine2.mCrossSize = Math.round(size3);
                            }
                            f += size3 - flexLine2.mCrossSize;
                            if (f > 1.0f) {
                                flexLine2.mCrossSize++;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                flexLine2.mCrossSize--;
                                f += 1.0f;
                            }
                            arrayList.add(flexLine2);
                        }
                        i++;
                    }
                    this.mFlexContainer.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    FlexLine flexLine3 = new FlexLine();
                    flexLine3.mCrossSize = size5;
                    for (FlexLine flexLine4 : flexLinesInternal) {
                        arrayList2.add(flexLine3);
                        arrayList2.add(flexLine4);
                        arrayList2.add(flexLine3);
                    }
                    this.mFlexContainer.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i < size7) {
                        FlexLine flexLine5 = flexLinesInternal.get(i);
                        float f3 = flexLine5.mCrossSize + size6;
                        if (i == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        flexLine5.mCrossSize = iRound;
                        i++;
                    }
                }
            }
        }
    }

    private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> flexLines, int size, int totalCrossSize) {
        int i = (size - totalCrossSize) / 2;
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.mCrossSize = i;
        int size2 = flexLines.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(flexLines.get(i2));
            if (i2 == flexLines.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    void stretchViews() {
        stretchViews(0);
    }

    void stretchViews(int fromIndex) {
        View reorderedFlexItemAt;
        if (fromIndex >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (this.mFlexContainer.getAlignItems() == 4) {
            int[] iArr = this.mIndexToFlexLine;
            List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i = iArr != null ? iArr[fromIndex] : 0; i < size; i++) {
                FlexLine flexLine = flexLinesInternal.get(i);
                int i2 = flexLine.mItemCount;
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = flexLine.mFirstIndex + i3;
                    if (i3 < this.mFlexContainer.getFlexItemCount() && (reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i4)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                        if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                stretchViewVertically(reorderedFlexItemAt, flexLine.mCrossSize, i4);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                stretchViewHorizontally(reorderedFlexItemAt, flexLine.mCrossSize, i4);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (FlexLine flexLine2 : this.mFlexContainer.getFlexLinesInternal()) {
            for (Integer num : flexLine2.mIndicesAlignSelfStretch) {
                View reorderedFlexItemAt2 = this.mFlexContainer.getReorderedFlexItemAt(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    stretchViewVertically(reorderedFlexItemAt2, flexLine2.mCrossSize, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    stretchViewHorizontally(reorderedFlexItemAt2, flexLine2.mCrossSize, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                }
            }
        }
    }

    private void stretchViewVertically(View view, int crossSize, int index) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((crossSize - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredWidth = extractLowerInt(jArr[index]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        updateMeasureCache(index, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    private void stretchViewHorizontally(View view, int crossSize, int index) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((crossSize - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredHeight = extractHigherInt(jArr[index]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        updateMeasureCache(index, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    void layoutSingleChildHorizontal(View view, FlexLine flexLine, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i2 = top + i;
                    view.layout(left, (i2 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), right, i2 - flexItem.getMarginBottom());
                    return;
                } else {
                    view.layout(left, (top - i) + view.getMeasuredHeight() + flexItem.getMarginTop(), right, (bottom - i) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i3 = top + measuredHeight;
                    view.layout(left, i3, right, view.getMeasuredHeight() + i3);
                    return;
                } else {
                    int i4 = top - measuredHeight;
                    view.layout(left, i4, right, view.getMeasuredHeight() + i4);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int iMax = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(left, top + iMax, right, bottom + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((flexLine.mMaxBaseline - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(left, top - iMax2, right, bottom - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.mFlexContainer.getFlexWrap() != 2) {
            view.layout(left, top + flexItem.getMarginTop(), right, bottom + flexItem.getMarginTop());
        } else {
            view.layout(left, top - flexItem.getMarginBottom(), right, bottom - flexItem.getMarginBottom());
        }
    }

    void layoutSingleChildVertical(View view, FlexLine flexLine, boolean isRtl, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!isRtl) {
                    view.layout(((left + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), top, ((right + i) - view.getMeasuredWidth()) - flexItem.getMarginRight(), bottom);
                    return;
                } else {
                    view.layout((left - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), top, (right - i) + view.getMeasuredWidth() + flexItem.getMarginLeft(), bottom);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (!isRtl) {
                    view.layout(left + measuredWidth, top, right + measuredWidth, bottom);
                    return;
                } else {
                    view.layout(left - measuredWidth, top, right - measuredWidth, bottom);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!isRtl) {
            view.layout(left + flexItem.getMarginLeft(), top, right + flexItem.getMarginLeft(), bottom);
        } else {
            view.layout(left - flexItem.getMarginRight(), top, right - flexItem.getMarginRight(), bottom);
        }
    }

    void ensureMeasuredSizeCache(int size) {
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr == null) {
            this.mMeasuredSizeCache = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, Math.max(jArr.length * 2, size));
        }
    }

    void ensureMeasureSpecCache(int size) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr == null) {
            this.mMeasureSpecCache = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, Math.max(jArr.length * 2, size));
        }
    }

    private void updateMeasureCache(int index, int widthMeasureSpec, int heightMeasureSpec, View view) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr != null) {
            jArr[index] = makeCombinedLong(widthMeasureSpec, heightMeasureSpec);
        }
        long[] jArr2 = this.mMeasuredSizeCache;
        if (jArr2 != null) {
            jArr2[index] = makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    void ensureIndexToFlexLine(int size) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            this.mIndexToFlexLine = new int[Math.max(size, 10)];
        } else if (iArr.length < size) {
            this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, Math.max(iArr.length * 2, size));
        }
    }

    void clearFlexLines(List<FlexLine> flexLines, int fromFlexItem) {
        int i = this.mIndexToFlexLine[fromFlexItem];
        if (i == -1) {
            i = 0;
        }
        if (flexLines.size() > i) {
            flexLines.subList(i, flexLines.size()).clear();
        }
        int[] iArr = this.mIndexToFlexLine;
        int length = iArr.length - 1;
        if (fromFlexItem > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, fromFlexItem, length, -1);
        }
        long[] jArr = this.mMeasureSpecCache;
        int length2 = jArr.length - 1;
        if (fromFlexItem > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, fromFlexItem, length2, 0L);
        }
    }

    private static class Order implements Comparable<Order> {
        int index;
        int order;

        private Order() {
        }

        @Override // java.lang.Comparable
        public int compareTo(Order another) {
            int i = this.order;
            int i2 = another.order;
            return i != i2 ? i - i2 : this.index - another.index;
        }

        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }
    }

    static class FlexLinesResult {
        int mChildState;
        List<FlexLine> mFlexLines;

        FlexLinesResult() {
        }

        void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }
}
