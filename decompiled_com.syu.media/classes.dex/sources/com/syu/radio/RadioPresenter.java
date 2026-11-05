package com.syu.radio;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0002?@B[\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010.¢\u0006\u0004\b=\u0010>J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010%\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R$\u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R$\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u000207068\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lcom/syu/radio/RadioPresenter;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View;", "v", FinalChip.BSP_PLATFORM_Null, "onClick", FinalChip.BSP_PLATFORM_Null, "onLongClick", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/syu/manger/AutoManager;", "b", "Lcom/syu/manger/AutoManager;", "getManager", "()Lcom/syu/manger/AutoManager;", "manager", "Lcom/syu/manger/module/radio/RadioModel;", "c", "Lcom/syu/manger/module/radio/RadioModel;", "getRadioModel", "()Lcom/syu/manger/module/radio/RadioModel;", "radioModel", "d", "Landroid/view/View;", "getScanCtr", "()Landroid/view/View;", "setScanCtr", "(Landroid/view/View;)V", "scanCtr", "e", "getPrevCtr", "setPrevCtr", "prevCtr", "f", "getNextCtr", "setNextCtr", "nextCtr", "g", "getBandCtr", "setBandCtr", "bandCtr", "Landroid/widget/CompoundButton;", "h", "Landroid/widget/CompoundButton;", "getFavoriteCtr", "()Landroid/widget/CompoundButton;", "setFavoriteCtr", "(Landroid/widget/CompoundButton;)V", "favoriteCtr", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/radio/RadioPresenter$OnRadioListener;", "i", "Ljava/util/List;", "getMRadioListeners", "()Ljava/util/List;", "mRadioListeners", "<init>", "(Landroid/content/Context;Lcom/syu/manger/AutoManager;Lcom/syu/manger/module/radio/RadioModel;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/CompoundButton;)V", "OnRadioListener", "SimpleRadioListener", "radiolib_release"}, k = 1, mv = {1, 7, 1})
public final class RadioPresenter implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final AutoManager manager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final RadioModel radioModel;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public View scanCtr;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public View prevCtr;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public View nextCtr;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public View bandCtr;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public CompoundButton favoriteCtr;
    public final ArrayList i;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\nH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/syu/radio/RadioPresenter$OnRadioListener;", FinalChip.BSP_PLATFORM_Null, "onAfChanged", FinalChip.BSP_PLATFORM_Null, "on", FinalChip.BSP_PLATFORM_Null, "onBandChanged", "band", FinalChip.BSP_PLATFORM_Null, "freqUnit", FinalChip.BSP_PLATFORM_Null, "onFreqChanged", "freqText", "onLocal", "loc", "onPsNameChanged", "ps", "onPtyTextChanged", "ptyText", "onRdsEnable", "enable", "onTaChanged", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnRadioListener {
        void onAfChanged(boolean on);

        void onBandChanged(int band, String freqUnit);

        void onFreqChanged(String freqText);

        void onLocal(boolean loc);

        void onPsNameChanged(String ps);

        void onPtyTextChanged(String ptyText);

        void onRdsEnable(boolean enable);

        void onTaChanged(boolean on);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0017"}, d2 = {"Lcom/syu/radio/RadioPresenter$SimpleRadioListener;", "Lcom/syu/radio/RadioPresenter$OnRadioListener;", "()V", "onAfChanged", FinalChip.BSP_PLATFORM_Null, "on", FinalChip.BSP_PLATFORM_Null, "onBandChanged", "band", FinalChip.BSP_PLATFORM_Null, "freqUnit", FinalChip.BSP_PLATFORM_Null, "onFreqChanged", "freqText", "onLocal", "loc", "onPsNameChanged", "ps", "onPtyTextChanged", "ptyText", "onRdsEnable", "enable", "onTaChanged", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SimpleRadioListener implements OnRadioListener {
        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onAfChanged(boolean on) {
        }

        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onBandChanged(int band, String freqUnit) {
            Intrinsics.checkNotNullParameter(freqUnit, "freqUnit");
        }

        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onFreqChanged(String freqText) {
            Intrinsics.checkNotNullParameter(freqText, "freqText");
        }

        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onLocal(boolean loc) {
        }

        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onPsNameChanged(String ps) {
            Intrinsics.checkNotNullParameter(ps, "ps");
        }

        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onPtyTextChanged(String ptyText) {
            Intrinsics.checkNotNullParameter(ptyText, "ptyText");
        }

        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onRdsEnable(boolean enable) {
        }

        @Override // com.syu.radio.RadioPresenter.OnRadioListener
        public void onTaChanged(boolean on) {
        }
    }

    public RadioPresenter(Context context, AutoManager autoManager, RadioModel radioModel, View view, View view2, View view3, View view4, CompoundButton compoundButton) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(autoManager, "manager");
        Intrinsics.checkNotNullParameter(radioModel, "radioModel");
        this.context = context;
        this.manager = autoManager;
        this.radioModel = radioModel;
        this.scanCtr = view;
        this.prevCtr = view2;
        this.nextCtr = view3;
        this.bandCtr = view4;
        this.favoriteCtr = compoundButton;
        this.i = new ArrayList();
    }

    public final View getBandCtr() {
        return this.bandCtr;
    }

    public final Context getContext() {
        return this.context;
    }

    public final CompoundButton getFavoriteCtr() {
        return this.favoriteCtr;
    }

    public final List<OnRadioListener> getMRadioListeners() {
        return this.i;
    }

    public final AutoManager getManager() {
        return this.manager;
    }

    public final View getNextCtr() {
        return this.nextCtr;
    }

    public final View getPrevCtr() {
        return this.prevCtr;
    }

    public final RadioModel getRadioModel() {
        return this.radioModel;
    }

    public final View getScanCtr() {
        return this.scanCtr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        RadioController radioController = this.manager.getRadioController();
        if (radioController != null) {
            if (Intrinsics.areEqual(v, this.scanCtr)) {
                radioController.scanStation();
                return;
            }
            if (Intrinsics.areEqual(v, this.prevCtr)) {
                radioController.freqDown();
            } else if (Intrinsics.areEqual(v, this.nextCtr)) {
                radioController.freqUp();
            } else if (Intrinsics.areEqual(v, this.bandCtr)) {
                radioController.band();
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        RadioController radioController = this.manager.getRadioController();
        if (radioController != null) {
            if (Intrinsics.areEqual(v, this.nextCtr)) {
                radioController.seekPrevStation();
            } else if (Intrinsics.areEqual(v, this.bandCtr)) {
                radioController.seekNextStation();
            }
            return true;
        }
        return false;
    }

    public final void setBandCtr(View view) {
        this.bandCtr = view;
    }

    public final void setFavoriteCtr(CompoundButton compoundButton) {
        this.favoriteCtr = compoundButton;
    }

    public final void setNextCtr(View view) {
        this.nextCtr = view;
    }

    public final void setPrevCtr(View view) {
        this.prevCtr = view;
    }

    public final void setScanCtr(View view) {
        this.scanCtr = view;
    }

    public /* synthetic */ RadioPresenter(Context context, AutoManager autoManager, RadioModel radioModel, View view, View view2, View view3, View view4, CompoundButton compoundButton, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, autoManager, radioModel, (i & 8) != 0 ? null : view, (i & 16) != 0 ? null : view2, (i & 32) != 0 ? null : view3, (i & 64) != 0 ? null : view4, (i & 128) != 0 ? null : compoundButton);
    }
}
