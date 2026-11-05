package com.syu.over;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000f\u0010\u0013B#\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u000f\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/syu/over/FragmentContainerHelper;", "Landroid/widget/FrameLayout;", FinalChip.BSP_PLATFORM_Null, "onAttachedToWindow", "onDetachedFromWindow", "Lcom/syu/over/FragmentContainerHelper$UiShowCallback;", "a", "Lcom/syu/over/FragmentContainerHelper$UiShowCallback;", "getMCallback", "()Lcom/syu/over/FragmentContainerHelper$UiShowCallback;", "setMCallback", "(Lcom/syu/over/FragmentContainerHelper$UiShowCallback;)V", "mCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", FinalChip.BSP_PLATFORM_Null, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "UiShowCallback", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class FragmentContainerHelper extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public UiShowCallback mCallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/syu/over/FragmentContainerHelper$UiShowCallback;", FinalChip.BSP_PLATFORM_Null, "onAttachedToWindow", FinalChip.BSP_PLATFORM_Null, "onDetachedFromWindow", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface UiShowCallback {
        void onAttachedToWindow();

        void onDetachedFromWindow();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerHelper(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final UiShowCallback getMCallback() {
        return this.mCallback;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        UiShowCallback uiShowCallback = this.mCallback;
        if (uiShowCallback != null) {
            uiShowCallback.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        UiShowCallback uiShowCallback = this.mCallback;
        if (uiShowCallback != null) {
            uiShowCallback.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    public final void setMCallback(UiShowCallback uiShowCallback) {
        this.mCallback = uiShowCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
