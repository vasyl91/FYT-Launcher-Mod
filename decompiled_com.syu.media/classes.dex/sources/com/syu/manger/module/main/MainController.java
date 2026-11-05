package com.syu.manger.module.main;

import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.BaseController;
import com.syu.manger.module.record.RecordObserver;
import com.syu.media.provider.Media;
import com.syu.remote.ModuleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0016J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bJ\u001e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0016J\u001e\u0010\"\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b¨\u0006%"}, d2 = {"Lcom/syu/manger/module/main/MainController;", "Lcom/syu/manger/module/BaseController;", "manager", "Lcom/syu/remote/ModuleManager;", "(Lcom/syu/remote/ModuleManager;)V", "boot", FinalChip.BSP_PLATFORM_Null, "on", "navi", "openAppId", RecordObserver.AppKey, FinalChip.BSP_PLATFORM_Null, "openVideoChannel", "videoId", "sendOnClick", "keyCode", "setBrightnessLevel", "level", "setUiMode", "mode", "syncAlbumOfId3", Media.ALBUM, FinalChip.BSP_PLATFORM_Null, "syncArtistOfId3", Media.ARTIST, "syncMediaType", Media.TYPE, "syncPlayProgress", "playTime", Media.DURATION, "syncPlayState", "playing", "syncTitleOfId3", "title", "syncTrackInfo", "index", "total", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MainController extends BaseController {
    /* JADX WARN: Illegal instructions before constructor call */
    public MainController() {
        ModuleManager moduleManager = null;
        this(moduleManager, 1, moduleManager);
    }

    public final boolean boot(boolean on) {
        return sendCmd(17, on ? 1 : 0);
    }

    public final boolean navi() {
        return sendCmd(24, 0);
    }

    public final boolean openAppId(int appid) {
        return sendCmd(0, appid);
    }

    public final boolean openVideoChannel(int videoId, boolean on) {
        int[] iArr = new int[2];
        iArr[0] = videoId;
        if (!on) {
            videoId = 0;
        }
        iArr[1] = videoId;
        return sendCmd(22, iArr);
    }

    public final boolean sendOnClick(int keyCode) {
        return sendCmd(133, keyCode);
    }

    public final boolean setBrightnessLevel(int level) {
        return sendCmd(10, level);
    }

    public final boolean setUiMode(int mode) {
        return sendCmd(178, mode);
    }

    public final boolean syncAlbumOfId3(int appid, String album) {
        Intrinsics.checkNotNullParameter(album, Media.ALBUM);
        return BaseController.sendCmd$default(this, 23, new int[]{appid, 2}, null, new String[]{album}, 4, null);
    }

    public final boolean syncArtistOfId3(int appid, String artist) {
        Intrinsics.checkNotNullParameter(artist, Media.ARTIST);
        return BaseController.sendCmd$default(this, 23, new int[]{appid, 1}, null, new String[]{artist}, 4, null);
    }

    public final boolean syncMediaType(int appid, int type) {
        return sendCmd(23, appid, 10, type);
    }

    public final boolean syncPlayProgress(int appid, int playTime, int duration) {
        return sendCmd(23, appid, 5, playTime, duration);
    }

    public final boolean syncPlayState(int appid, boolean playing) {
        int[] iArr = new int[3];
        iArr[0] = appid;
        iArr[1] = 3;
        iArr[2] = playing ? 0 : 2;
        return sendCmd(23, iArr);
    }

    public final boolean syncTitleOfId3(int appid, String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return BaseController.sendCmd$default(this, 23, new int[]{appid, 0}, null, new String[]{title}, 4, null);
    }

    public final boolean syncTrackInfo(int appid, int index, int total) {
        return sendCmd(23, appid, 4, index, total);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainController(ModuleManager moduleManager) {
        super(moduleManager, 0);
        Intrinsics.checkNotNullParameter(moduleManager, "manager");
    }

    public /* synthetic */ MainController(ModuleManager moduleManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AutoManager.INSTANCE.requestInstance().getModuleManager() : moduleManager);
    }
}
