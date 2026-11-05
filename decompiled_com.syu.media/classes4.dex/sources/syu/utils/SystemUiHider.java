package syu.utils;

import android.app.ActivityManager;
import android.os.Handler;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class SystemUiHider {
    public Handler a;
    public final View b;
    public final View.OnSystemUiVisibilityChangeListener c = new View.OnSystemUiVisibilityChangeListener() { // from class: syu.utils.SystemUiHider.1
        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if ((i & 4) == 0) {
                SystemUiHider.this.delay();
            }
        }
    };
    public final Runnable d = new Runnable() { // from class: syu.utils.SystemUiHider.2
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

    public void clear() {
        this.b.setOnSystemUiVisibilityChangeListener(null);
        this.b.setSystemUiVisibility(0);
    }

    public void delay() {
        this.a.removeCallbacks(this.d);
        this.a.postDelayed(this.d, ActivityManager.isUserAMonkey() ? 0L : 2000L);
    }

    public void setup() {
        a();
        this.a = new Handler();
        this.b.setOnSystemUiVisibilityChangeListener(this.c);
    }
}
