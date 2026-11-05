package androidx.lifecycle;

import android.app.Application;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class AndroidViewModel extends ViewModel {
    private Application mApplication;

    public AndroidViewModel(Application application) {
        this.mApplication = application;
    }

    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
