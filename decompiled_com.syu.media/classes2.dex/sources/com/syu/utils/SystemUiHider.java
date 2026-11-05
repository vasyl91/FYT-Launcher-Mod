package com.syu.utils;

import android.app.ActivityManager;
import android.os.Handler;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SystemUiHider {
    public Handler a;
    public final View b;
    public final Runnable c = new Runnable() { // from class: com.syu.utils.SystemUiHider.2
        @Override // java.lang.Runnable
        public void run() {
            SystemUiHider.this.a();
        }
    };

    public SystemUiHider(View view) {
        this.b = view;
    }

    public final void a() {
        this.b.setSystemUiVisibility(3076);
    }

    public void delay() {
        this.a.removeCallbacks(this.c);
        this.a.postDelayed(this.c, ActivityManager.isUserAMonkey() ? 0L : 2000L);
    }

    public void setup() {
        a();
        this.a = new Handler();
        this.b.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.syu.utils.SystemUiHider.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 2) == 0) {
                    SystemUiHider.this.delay();
                }
            }
        });
    }
}
