package com.syu.media.music;

import android.content.Context;
import chip.FinalChip;
import com.syu.media.ConstantsKt;
import com.syu.media.PlayState;
import com.syu.media.companion.utils.SharedPrefUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MusicStatic.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/syu/media/music/MusicStatic;", FinalChip.BSP_PLATFORM_Null, "()V", "pullPlayStateForSharePref", "Lcom/syu/media/PlayState;", "context", "Landroid/content/Context;", "playState", "pushPlayStateForSharePref", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MusicStatic {
    public static final MusicStatic INSTANCE = new MusicStatic();

    private MusicStatic() {
    }

    public final PlayState pullPlayStateForSharePref(Context context, PlayState playState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playState, "playState");
        playState.setDataId(((Number) SharedPrefUtils.INSTANCE.getParam(context, ConstantsKt.MUSIC_PLAY_DATA_ID, Integer.valueOf(playState.getDataId()))).intValue());
        playState.setPlayPath((String) SharedPrefUtils.INSTANCE.getParam(context, ConstantsKt.MUSIC_PLAY_PATH, playState.getPlayPath()));
        playState.setPlayMode(((Number) SharedPrefUtils.INSTANCE.getParam(context, ConstantsKt.MUSIC_PLAY_MODE, Integer.valueOf(playState.getPlayMode()))).intValue());
        playState.setLastPlayTime(((Number) SharedPrefUtils.INSTANCE.getParam(context, ConstantsKt.LAST_PLAY_TIME, Integer.valueOf(playState.getLastPlayTime()))).intValue());
        playState.setFragPage(((Number) SharedPrefUtils.INSTANCE.getParam(context, ConstantsKt.FRAG_CURRENT_PAGE, Integer.valueOf(playState.getFragPage()))).intValue());
        return playState;
    }

    public final void pushPlayStateForSharePref(Context context, PlayState playState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playState, "playState");
        SharedPrefUtils.INSTANCE.setParam(context, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(ConstantsKt.MUSIC_PLAY_DATA_ID, Integer.valueOf(playState.getDataId())), TuplesKt.to(ConstantsKt.MUSIC_PLAY_PATH, playState.getPlayPath()), TuplesKt.to(ConstantsKt.MUSIC_PLAY_MODE, Integer.valueOf(playState.getPlayMode())), TuplesKt.to(ConstantsKt.LAST_PLAY_TIME, Integer.valueOf(playState.getCurrentPlayTime()))}));
    }
}
