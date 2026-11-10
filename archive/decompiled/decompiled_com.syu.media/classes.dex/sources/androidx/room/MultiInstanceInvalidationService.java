package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MultiInstanceInvalidationService extends Service {
    int mMaxClientId = 0;
    final HashMap<Integer, String> mClientNames = new HashMap<>();
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IMultiInstanceInvalidationCallback callback, Object cookie) {
            MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(((Integer) cookie).intValue()));
        }
    };
    private final IMultiInstanceInvalidationService.Stub mBinder = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(IMultiInstanceInvalidationCallback callback, String name) {
            if (name == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.mMaxClientId + 1;
                multiInstanceInvalidationService.mMaxClientId = i;
                if (MultiInstanceInvalidationService.this.mCallbackList.register(callback, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(i), name);
                    return i;
                }
                MultiInstanceInvalidationService.this.mMaxClientId--;
                return 0;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(IMultiInstanceInvalidationCallback callback, int clientId) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService.this.mCallbackList.unregister(callback);
                MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(clientId));
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int clientId, String[] tables) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                try {
                    String str = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(clientId));
                    if (str == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    int iBeginBroadcast = MultiInstanceInvalidationService.this.mCallbackList.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            int iIntValue = ((Integer) MultiInstanceInvalidationService.this.mCallbackList.getBroadcastCookie(i)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(iIntValue));
                            if (clientId != iIntValue && str.equals(str2)) {
                                try {
                                    ((IMultiInstanceInvalidationCallback) MultiInstanceInvalidationService.this.mCallbackList.getBroadcastItem(i)).onInvalidation(tables);
                                } catch (RemoteException e) {
                                    Log.w("ROOM", "Error invoking a remote callback", e);
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
