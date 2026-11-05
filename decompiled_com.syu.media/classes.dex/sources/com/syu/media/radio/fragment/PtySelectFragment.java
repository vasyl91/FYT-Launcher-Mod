package com.syu.media.radio.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.manger.module.radio.RadioConstants;
import com.syu.media.R;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.radio.items.PtyItem;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import syu.recyclerview.Node;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: PtySelectFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/syu/media/radio/fragment/PtySelectFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", FinalChip.BSP_PLATFORM_Null, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "onViewCreated", "view", "Landroid/view/View;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PtySelectFragment extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PtySelectFragment me = new PtySelectFragment();
    private NodeAdapter mAdapter;
    private RecyclerView recyclerView;

    /* JADX INFO: compiled from: PtySelectFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/syu/media/radio/fragment/PtySelectFragment$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "me", "Lcom/syu/media/radio/fragment/PtySelectFragment;", "getMe", "()Lcom/syu/media/radio/fragment/PtySelectFragment;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PtySelectFragment getMe() {
            return PtySelectFragment.me;
        }
    }

    public PtySelectFragment() {
        super(R.layout.pty_select_fragment);
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        setStyle(2, R.style.RadioEditorDialog);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View decorView;
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.RadioEditorDialog);
        }
        Window window2 = requireDialog().getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.rds_pty_list);
        this.mAdapter.setOnItemClickListener(new NodeAdapter.OnItemClickListener() { // from class: com.syu.media.radio.fragment.PtySelectFragment.onViewCreated.1
            public void onClick(int positionOfView, int positionOfData, Node<?> node) {
                Intrinsics.checkNotNullParameter(node, "node");
                PtySelectFragment.this.dismiss();
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
            recyclerView.setAdapter((RecyclerView.Adapter) this.mAdapter);
            recyclerView.addItemDecoration(new SimpleItemDecoration(6, null, null, null, null, 30, null));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setTag(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mAdapter.getMData().replace(Node.Companion.createNodes(ArraysKt.slice(RadioConstants.INSTANCE.getPTY_DISPLAY(), new IntRange(0, 32)), PtyItem.class, this.mAdapter.getMData()));
    }
}
