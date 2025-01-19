package com.fyt.car;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class BtavService extends Service {
    public String mBtavAristName;
    public String mBtavMusicName;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle.getString("btav") != null && !bundle.getString("btav").equals("")) {
                this.mBtavMusicName = bundle.getString("btav");
            }
            if (bundle.getString("btav_art") != null && !bundle.getString("btav_art").equals("")) {
                this.mBtavAristName = bundle.getString("btav_art");
            }
            DataNotifier dataNotifier = LauncherNotify.NOTIFIER_BTAV;
            String[] strArr = new String[4];
            strArr[0] = this.mBtavMusicName;
            strArr[1] = this.mBtavAristName;
            dataNotifier.set(null, null, null, strArr, null, "fyt");
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
