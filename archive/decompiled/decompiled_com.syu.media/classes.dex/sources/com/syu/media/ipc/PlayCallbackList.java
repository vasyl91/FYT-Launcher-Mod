package com.syu.media.ipc;

import android.os.RemoteCallbackList;
import chip.FinalChip;
import com.syu.media.ICallback;
import com.syu.media.entities.MediaSource;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lcom/syu/media/ipc/PlayCallbackList;", "Landroid/os/RemoteCallbackList;", "Lcom/syu/media/ICallback;", "Lcom/syu/media/entities/MediaSource;", "source", FinalChip.BSP_PLATFORM_Null, "onSongChanged", FinalChip.BSP_PLATFORM_Null, "isPlaying", "onPlayStatusChanged", FinalChip.BSP_PLATFORM_Null, "mode", "onPlayModeChanged", "<init>", "()V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class PlayCallbackList extends RemoteCallbackList<ICallback> {
    public final Object a = new Object();

    public final void onPlayModeChanged(int mode) {
        synchronized (this.a) {
            try {
                try {
                    int iBeginBroadcast = beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        getBroadcastItem(i).onPlayModeChanged(mode);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finishBroadcast();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                finishBroadcast();
                throw th;
            }
        }
    }

    public final void onPlayStatusChanged(boolean isPlaying) {
        synchronized (this.a) {
            try {
                try {
                    int iBeginBroadcast = beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        getBroadcastItem(i).onPlayStatusChanged(isPlaying);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finishBroadcast();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                finishBroadcast();
                throw th;
            }
        }
    }

    public final void onSongChanged(MediaSource source) {
        synchronized (this.a) {
            try {
                try {
                    int iBeginBroadcast = beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        getBroadcastItem(i).onSongChanged(source);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finishBroadcast();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                finishBroadcast();
                throw th;
            }
        }
    }
}
