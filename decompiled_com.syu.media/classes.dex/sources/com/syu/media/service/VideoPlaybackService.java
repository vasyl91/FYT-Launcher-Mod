package com.syu.media.service;

import android.content.Context;
import com.syu.media.player.Player;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/syu/media/service/VideoPlaybackService;", "Lcom/syu/media/service/PlaybackService;", "()V", "setupPlayer", "Lcom/syu/media/player/Player;", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class VideoPlaybackService extends PlaybackService {
    @Override // com.syu.media.service.PlaybackService
    public Player setupPlayer() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        Player player = new Player(applicationContext, 1);
        player.registerCallback(this);
        player.registerCallback2(this);
        return player;
    }
}
