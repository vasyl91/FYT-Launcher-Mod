package com.syu.manger.module.radio;

import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.BaseController;
import com.syu.media.provider.Media;
import com.syu.remote.ModuleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\rH\u0016¨\u0006)"}, d2 = {"Lcom/syu/manger/module/radio/RadioController;", "Lcom/syu/manger/module/BaseController;", "Lcom/syu/manger/module/radio/IRadio;", "manager", "Lcom/syu/remote/ModuleManager;", "(Lcom/syu/remote/ModuleManager;)V", "adaptiveSensitivity", FinalChip.BSP_PLATFORM_Null, "enable", FinalChip.BSP_PLATFORM_Null, "band", "configAmSensitivity", "value", FinalChip.BSP_PLATFORM_Null, "configFmSensitivity", "default", "freqDown", "freqUp", Media.LOCAL, "nextStation", "prevStation", "ptySeekStation", "ptyId", "rdsAfEanble", "rdsEnable", "rdsTaEanble", "save", "saveChannel", "channel", "scanStation", "searchStation", "seekNextStation", "seekPrevStation", "selectArea", "area", "stereo", "switchFmOrAm", "toBand", "toChannel", "toFreq", "freq", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RadioController extends BaseController implements IRadio {
    /* JADX WARN: Illegal instructions before constructor call */
    public RadioController() {
        ModuleManager moduleManager = null;
        this(moduleManager, 1, moduleManager);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void adaptiveSensitivity(boolean enable) {
        sendCmd(15, enable ? 1 : 0);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void band() {
        sendCmd(11, -1);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void configAmSensitivity(int value) {
        sendCmd(14, 0, value);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void configFmSensitivity(int value) {
        sendCmd(14, 1, value);
    }

    @Override // com.syu.manger.module.radio.IRadio
    /* JADX INFO: renamed from: default */
    public void mo73default() {
        BaseController.sendCmd$default(this, 34, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void freqDown() {
        BaseController.sendCmd$default(this, 4, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void freqUp() {
        BaseController.sendCmd$default(this, 3, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void local(boolean enable) {
        sendCmd(18, enable ? 1 : 0);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void nextStation() {
        BaseController.sendCmd$default(this, 0, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void prevStation() {
        BaseController.sendCmd$default(this, 1, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void ptySeekStation(int ptyId) {
        sendCmd(21, ptyId);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void rdsAfEanble(boolean enable) {
        sendCmd(20, enable ? 1 : 0);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void rdsEnable(boolean enable) {
        sendCmd(16, enable ? 1 : 0);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void rdsTaEanble(boolean enable) {
        sendCmd(19, enable ? 1 : 0);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void save() {
        BaseController.sendCmd$default(this, 10, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void saveChannel(int channel) {
        sendCmd(8, channel);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void scanStation() {
        BaseController.sendCmd$default(this, 9, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void searchStation() {
        sendCmd(22, 2);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void seekNextStation() {
        BaseController.sendCmd$default(this, 5, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void seekPrevStation() {
        BaseController.sendCmd$default(this, 6, null, null, null, 14, null);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void selectArea(int area) {
        sendCmd(12, area);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void stereo(boolean enable) {
        sendCmd(17, enable ? 1 : 0);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void switchFmOrAm() {
        sendCmd(11, -4);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void toBand(int band) {
        sendCmd(11, band);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void toChannel(int channel) {
        sendCmd(7, channel);
    }

    @Override // com.syu.manger.module.radio.IRadio
    public void toFreq(int freq) {
        sendCmd(13, 1, freq);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioController(ModuleManager moduleManager) {
        super(moduleManager, 1);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
    }

    public /* synthetic */ RadioController(ModuleManager moduleManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AutoManager.INSTANCE.requestInstance().getModuleManager() : moduleManager);
    }
}
