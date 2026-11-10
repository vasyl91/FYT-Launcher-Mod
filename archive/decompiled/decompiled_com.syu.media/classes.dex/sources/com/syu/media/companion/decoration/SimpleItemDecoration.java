package com.syu.media.companion.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleItemDecoration.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/syu/media/companion/decoration/SimpleItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", FinalChip.BSP_PLATFORM_Null, "left", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSpace", "()Ljava/lang/Integer;", "setSpace", "(Ljava/lang/Integer;)V", "getItemOffsets", FinalChip.BSP_PLATFORM_Null, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SimpleItemDecoration extends RecyclerView.ItemDecoration {
    private final Integer bottom;
    private final Integer left;
    private final Integer right;
    private Integer space;
    private final Integer top;

    public SimpleItemDecoration() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SimpleItemDecoration(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        num = (i & 1) != 0 ? null : num;
        this(num, (i & 2) != 0 ? num : num2, (i & 4) != 0 ? num : num3, (i & 8) != 0 ? num : num4, (i & 16) != 0 ? num : num5);
    }

    public final Integer getSpace() {
        return this.space;
    }

    public final void setSpace(Integer num) {
        this.space = num;
    }

    public SimpleItemDecoration(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.space = num;
        this.left = num2;
        this.top = num3;
        this.right = num4;
        this.bottom = num5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        Integer num = this.left;
        outRect.left = (num == null && (num = this.space) == null) ? 0 : num.intValue();
        Integer num2 = this.top;
        outRect.top = (num2 == null && (num2 = this.space) == null) ? 0 : num2.intValue();
        Integer num3 = this.right;
        outRect.right = (num3 == null && (num3 = this.space) == null) ? 0 : num3.intValue();
        Integer num4 = this.bottom;
        outRect.bottom = (num4 == null && (num4 = this.space) == null) ? 0 : num4.intValue();
    }
}
