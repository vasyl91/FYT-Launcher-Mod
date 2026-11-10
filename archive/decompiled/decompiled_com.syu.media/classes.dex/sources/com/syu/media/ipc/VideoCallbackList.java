package com.syu.media.ipc;

import android.os.RemoteCallbackList;
import chip.FinalChip;
import com.syu.media.ICallback2;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¨\u0006\n"}, d2 = {"Lcom/syu/media/ipc/VideoCallbackList;", "Landroid/os/RemoteCallbackList;", "Lcom/syu/media/ICallback2;", FinalChip.BSP_PLATFORM_Null, Media.VIDEO_WIDTH, Media.VIDEO_HEIGHT, FinalChip.BSP_PLATFORM_Null, "onVideoSizeChanged", "<init>", "()V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class VideoCallbackList extends RemoteCallbackList<ICallback2> {
    public final Object a = new Object();

    public final void onVideoSizeChanged(int width, int height) {
        synchronized (this.a) {
            try {
                try {
                    int iBeginBroadcast = beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        getBroadcastItem(i).onVideoSizeChanged(width, height);
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
