package syu.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lsyu/recyclerview/SimpleItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "a", "Ljava/lang/Integer;", "getSpace", "()Ljava/lang/Integer;", "setSpace", "(Ljava/lang/Integer;)V", "space", "left", "top", "right", "bottom", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class SimpleItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public Integer space;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final Integer e;

    public SimpleItemDecoration() {
        this(null, null, null, null, null, 31, null);
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        Integer num = this.b;
        outRect.left = (num == null && (num = this.space) == null) ? 0 : num.intValue();
        Integer num2 = this.c;
        outRect.top = (num2 == null && (num2 = this.space) == null) ? 0 : num2.intValue();
        Integer num3 = this.d;
        outRect.right = (num3 == null && (num3 = this.space) == null) ? 0 : num3.intValue();
        Integer num4 = this.e;
        outRect.bottom = (num4 == null && (num4 = this.space) == null) ? 0 : num4.intValue();
    }

    public final Integer getSpace() {
        return this.space;
    }

    public final void setSpace(Integer num) {
        this.space = num;
    }

    public SimpleItemDecoration(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.space = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = num5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SimpleItemDecoration(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        num = (i & 1) != 0 ? null : num;
        this(num, (i & 2) != 0 ? num : num2, (i & 4) != 0 ? num : num3, (i & 8) != 0 ? num : num4, (i & 16) != 0 ? num : num5);
    }
}
