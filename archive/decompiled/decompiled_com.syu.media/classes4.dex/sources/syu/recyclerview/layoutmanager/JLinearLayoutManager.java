package syu.recyclerview.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lsyu/recyclerview/layoutmanager/JLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JLinearLayoutManager extends LinearLayoutManager {
    public JLinearLayoutManager(Context context) {
        super(context);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception unused) {
        }
    }

    public JLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public JLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
