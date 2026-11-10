package com.syu.media.online.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import chip.FinalChip;
import com.syu.media.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImportStepDialogFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/syu/media/online/fragment/ImportStepDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "onCreate", FinalChip.BSP_PLATFORM_Null, "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "onViewCreated", "view", "Landroid/view/View;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImportStepDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImportStepDialogFragment me = new ImportStepDialogFragment();

    /* JADX INFO: compiled from: ImportStepDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/syu/media/online/fragment/ImportStepDialogFragment$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "me", "Lcom/syu/media/online/fragment/ImportStepDialogFragment;", "getMe", "()Lcom/syu/media/online/fragment/ImportStepDialogFragment;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImportStepDialogFragment getMe() {
            return ImportStepDialogFragment.me;
        }
    }

    public ImportStepDialogFragment() {
        super(R.layout.online_import_setp_dialog_frag);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        setStyle(2, R.style.RadioEditorDialog);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
        window.setWindowAnimations(R.style.RadioEditorDialog);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setStatusBarColor(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.online_import_setp_frag);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.online.fragment.ImportStepDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ImportStepDialogFragment.m201onViewCreated$lambda1(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-1, reason: not valid java name */
    public static final void m201onViewCreated$lambda1(ImportStepDialogFragment importStepDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(importStepDialogFragment, "this$0");
        importStepDialogFragment.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (isAdded()) {
            return;
        }
        show(manager, "import_step_dialog");
    }
}
