package com.syu.manger.module.radio;

import android.util.SparseIntArray;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.manger.module.main.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bj\u0010kR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0007R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002050\u00028\u0006¢\u0006\f\n\u0004\b6\u0010\u0005\u001a\u0004\b7\u0010\u0007R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u0002050\u00028\u0006¢\u0006\f\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010\u0007R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020<0\u00028\u0006¢\u0006\f\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010\u0007R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020<0\u00028\u0006¢\u0006\f\n\u0004\b@\u0010\u0005\u001a\u0004\bA\u0010\u0007R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0007R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bF\u0010\u0005\u001a\u0004\bG\u0010\u0007R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bI\u0010\u0005\u001a\u0004\bJ\u0010\u0007R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bL\u0010\u0005\u001a\u0004\bM\u0010\u0007R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bO\u0010\u0005\u001a\u0004\bP\u0010\u0007R\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bR\u0010\u0005\u001a\u0004\bS\u0010\u0007R\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bU\u0010\u0005\u001a\u0004\bV\u0010\u0007R\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bX\u0010\u0005\u001a\u0004\bY\u0010\u0007R\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\b[\u0010\u0005\u001a\u0004\b\\\u0010\u0007R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b^\u0010\u0005\u001a\u0004\b_\u0010\u0007R\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\ba\u0010\u0005\u001a\u0004\bb\u0010\u0007R\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006¢\u0006\f\n\u0004\bd\u0010\u0005\u001a\u0004\be\u0010\u0007R\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020f0\u00028\u0006¢\u0006\f\n\u0004\bg\u0010\u0005\u001a\u0004\bh\u0010\u0007¨\u0006l"}, d2 = {"Lcom/syu/manger/module/radio/RadioModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", FinalChip.BSP_PLATFORM_Null, "a", "Landroidx/lifecycle/MutableLiveData;", "getMBand", "()Landroidx/lifecycle/MutableLiveData;", "mBand", "b", "getMFreq", "mFreq", "c", "getMChannel", "mChannel", "d", "getMArea", "mArea", FinalChip.BSP_PLATFORM_Null, "e", "isScanning", "f", "isSearching", "g", "getMLoc", "mLoc", "h", "getRdsEnable", "rdsEnable", "i", "getRdsTaEnable", "rdsTaEnable", "j", "getRdsAfEnable", "rdsAfEnable", "k", "getRdsPsEnable", "rdsPsEnable", "l", "getRdsTpEnable", "rdsTpEnable", "m", "getAutoSens", "autoSens", "n", "getFmSens", "fmSens", "o", "getAmSens", "amSens", "p", "getPtyId", "ptyId", FinalChip.BSP_PLATFORM_Null, "q", "getPtyMsg", "ptyMsg", "r", "getPsMsg", "psMsg", "Landroid/util/SparseIntArray;", "s", "getMFmChannels", "mFmChannels", "t", "getMAmChannels", "mAmChannels", "u", "getFmChannelsChanged", "fmChannelsChanged", "v", "getAmChannelsChanged", "amChannelsChanged", "w", "getRdsShowing", "rdsShowing", "x", "getTaShowing", "taShowing", "y", "getAfShowing", "afShowing", "z", "getTpShowing", "tpShowing", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getPsShowing", "psShowing", "B", "getPtyShowing", "ptyShowing", "C", "getCurrentIsFm", "currentIsFm", "D", "getMStereo", "mStereo", ExifInterface.LONGITUDE_EAST, "getSupportAm", "supportAm", "F", "isPowerOn", "Lcom/syu/manger/module/radio/Rang;", "G", "getMRange", "mRange", "<init>", "()V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class RadioModel extends ViewModel {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final MutableLiveData psShowing;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public final MutableLiveData ptyShowing;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public final MutableLiveData currentIsFm;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public final MutableLiveData mStereo;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public final MutableLiveData supportAm;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public final MutableLiveData isPowerOn;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    public final MutableLiveData mRange;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final MutableLiveData mBand;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final MutableLiveData mFreq;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final MutableLiveData mChannel;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final MutableLiveData mArea;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final MutableLiveData isScanning;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final MutableLiveData isSearching;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final MutableLiveData mLoc;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final MutableLiveData rdsEnable;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final MutableLiveData rdsTaEnable;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final MutableLiveData rdsAfEnable;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final MutableLiveData rdsPsEnable;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final MutableLiveData rdsTpEnable;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final MutableLiveData autoSens;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final MutableLiveData fmSens;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final MutableLiveData amSens;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final MutableLiveData ptyId;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final MutableLiveData ptyMsg;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final MutableLiveData psMsg;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final MutableLiveData mFmChannels;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final MutableLiveData mAmChannels;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final MutableLiveData fmChannelsChanged;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final MutableLiveData amChannelsChanged;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public final MutableLiveData rdsShowing;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public final MutableLiveData taShowing;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public final MutableLiveData afShowing;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public final MutableLiveData tpShowing;

    public RadioModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(0);
        this.mBand = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        mutableLiveData2.setValue(8750);
        this.mFreq = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        mutableLiveData3.setValue(0);
        this.mChannel = mutableLiveData3;
        this.mArea = new MutableLiveData();
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        Boolean bool = Boolean.FALSE;
        mutableLiveData4.setValue(bool);
        this.isScanning = mutableLiveData4;
        this.isSearching = a.a(bool);
        this.mLoc = a.a(bool);
        this.rdsEnable = a.a(bool);
        this.rdsTaEnable = a.a(bool);
        this.rdsAfEnable = a.a(bool);
        this.rdsPsEnable = a.a(bool);
        this.rdsTpEnable = a.a(bool);
        this.autoSens = a.a(bool);
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        mutableLiveData5.setValue(22);
        this.fmSens = mutableLiveData5;
        MutableLiveData mutableLiveData6 = new MutableLiveData();
        mutableLiveData6.setValue(22);
        this.amSens = mutableLiveData6;
        MutableLiveData mutableLiveData7 = new MutableLiveData();
        mutableLiveData7.setValue(0);
        this.ptyId = mutableLiveData7;
        MutableLiveData mutableLiveData8 = new MutableLiveData();
        mutableLiveData8.setValue(RadioConstants.INSTANCE.getPTY_DISPLAY()[0]);
        this.ptyMsg = mutableLiveData8;
        MutableLiveData mutableLiveData9 = new MutableLiveData();
        mutableLiveData9.setValue(FinalChip.BSP_PLATFORM_Null);
        this.psMsg = mutableLiveData9;
        MutableLiveData mutableLiveData10 = new MutableLiveData();
        mutableLiveData10.setValue(new SparseIntArray());
        this.mFmChannels = mutableLiveData10;
        MutableLiveData mutableLiveData11 = new MutableLiveData();
        mutableLiveData11.setValue(new SparseIntArray());
        this.mAmChannels = mutableLiveData11;
        this.fmChannelsChanged = a.a(bool);
        this.amChannelsChanged = a.a(bool);
        this.rdsShowing = a.a(bool);
        this.taShowing = a.a(bool);
        this.afShowing = a.a(bool);
        this.tpShowing = a.a(bool);
        this.psShowing = a.a(bool);
        this.ptyShowing = a.a(bool);
        this.currentIsFm = a.a(bool);
        MutableLiveData mutableLiveData12 = new MutableLiveData();
        mutableLiveData12.setValue(0);
        this.mStereo = mutableLiveData12;
        this.supportAm = a.a(bool);
        this.isPowerOn = a.a(bool);
        MutableLiveData mutableLiveData13 = new MutableLiveData();
        mutableLiveData13.setValue(Rang.INSTANCE.getCHINA());
        this.mRange = mutableLiveData13;
    }

    public final MutableLiveData<Boolean> getAfShowing() {
        return this.afShowing;
    }

    public final MutableLiveData<Boolean> getAmChannelsChanged() {
        return this.amChannelsChanged;
    }

    public final MutableLiveData<Integer> getAmSens() {
        return this.amSens;
    }

    public final MutableLiveData<Boolean> getAutoSens() {
        return this.autoSens;
    }

    public final MutableLiveData<Boolean> getCurrentIsFm() {
        return this.currentIsFm;
    }

    public final MutableLiveData<Boolean> getFmChannelsChanged() {
        return this.fmChannelsChanged;
    }

    public final MutableLiveData<Integer> getFmSens() {
        return this.fmSens;
    }

    public final MutableLiveData<SparseIntArray> getMAmChannels() {
        return this.mAmChannels;
    }

    public final MutableLiveData<Integer> getMArea() {
        return this.mArea;
    }

    public final MutableLiveData<Integer> getMBand() {
        return this.mBand;
    }

    public final MutableLiveData<Integer> getMChannel() {
        return this.mChannel;
    }

    public final MutableLiveData<SparseIntArray> getMFmChannels() {
        return this.mFmChannels;
    }

    public final MutableLiveData<Integer> getMFreq() {
        return this.mFreq;
    }

    public final MutableLiveData<Boolean> getMLoc() {
        return this.mLoc;
    }

    public final MutableLiveData<Rang> getMRange() {
        return this.mRange;
    }

    public final MutableLiveData<Integer> getMStereo() {
        return this.mStereo;
    }

    public final MutableLiveData<String> getPsMsg() {
        return this.psMsg;
    }

    public final MutableLiveData<Boolean> getPsShowing() {
        return this.psShowing;
    }

    public final MutableLiveData<Integer> getPtyId() {
        return this.ptyId;
    }

    public final MutableLiveData<String> getPtyMsg() {
        return this.ptyMsg;
    }

    public final MutableLiveData<Boolean> getPtyShowing() {
        return this.ptyShowing;
    }

    public final MutableLiveData<Boolean> getRdsAfEnable() {
        return this.rdsAfEnable;
    }

    public final MutableLiveData<Boolean> getRdsEnable() {
        return this.rdsEnable;
    }

    public final MutableLiveData<Boolean> getRdsPsEnable() {
        return this.rdsPsEnable;
    }

    public final MutableLiveData<Boolean> getRdsShowing() {
        return this.rdsShowing;
    }

    public final MutableLiveData<Boolean> getRdsTaEnable() {
        return this.rdsTaEnable;
    }

    public final MutableLiveData<Boolean> getRdsTpEnable() {
        return this.rdsTpEnable;
    }

    public final MutableLiveData<Boolean> getSupportAm() {
        return this.supportAm;
    }

    public final MutableLiveData<Boolean> getTaShowing() {
        return this.taShowing;
    }

    public final MutableLiveData<Boolean> getTpShowing() {
        return this.tpShowing;
    }

    public final MutableLiveData<Boolean> isPowerOn() {
        return this.isPowerOn;
    }

    public final MutableLiveData<Boolean> isScanning() {
        return this.isScanning;
    }

    public final MutableLiveData<Boolean> isSearching() {
        return this.isSearching;
    }
}
