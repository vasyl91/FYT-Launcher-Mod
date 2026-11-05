package com.syu.media.radio.fragment;

import android.graphics.drawable.Drawable;
import android.view.View;
import chip.FinalChip;
import com.syu.media.R;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.databinding.RadioFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RadioFragment.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/syu/media/radio/fragment/RadioFragment;", "Lcom/syu/media/radio/fragment/RadioBaseFragment;", "Lcom/syu/media/databinding/RadioFragmentBinding;", "()V", "allowScan", FinalChip.BSP_PLATFORM_Null, "getAllowScan", "()Z", "setAllowScan", "(Z)V", "initObserve", FinalChip.BSP_PLATFORM_Null, "initView", "view", "Landroid/view/View;", "moveTaskToBack", "onPaused", "onResumed", "openRadioAudio", "setBlurBk", "d", "Landroid/graphics/drawable/Drawable;", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioFragment extends RadioBaseFragment<RadioFragmentBinding> {
    public static final String TAG = "RadioFragment";
    private boolean allowScan;

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initObserve() {
    }

    @Override // com.syu.media.base.DataBindBaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public RadioFragment() {
        super(R.layout.radio_fragment);
        this.allowScan = true;
    }

    public final boolean getAllowScan() {
        return this.allowScan;
    }

    public final void setAllowScan(boolean z) {
        this.allowScan = z;
    }

    public final void setBlurBk(Drawable d) {
        Intrinsics.checkNotNullParameter(d, "d");
        if (isAdded()) {
            bkChanged(R.id.radio_frag_blur_img, d);
        }
    }

    @Override // com.syu.media.base.BaseFragment
    public void onResumed() {
        HiLog.INSTANCE.d(TAG, "onResumed");
        openRadioAudio();
    }

    @Override // com.syu.media.base.BaseFragment
    public void onPaused() {
        HiLog.INSTANCE.d(TAG, "onPaused");
    }

    @Override // com.syu.media.base.BaseFragment
    public void moveTaskToBack() {
        if (radioAudio()) {
            openAppId(0);
        }
    }

    public final void openRadioAudio() {
        if (radioAudio() || !getRadioAudio().requestAudioFocus()) {
            return;
        }
        openAppId(1);
    }
}
