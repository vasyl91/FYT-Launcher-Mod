package com.android.launcher66.settings;

import android.app.Application;
import android.os.SystemClock;

import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {
    private boolean mFirstUse;
    private long mLoaderStartTime = SystemClock.elapsedRealtime();

    public MainViewModel(Application application) {
        super(application);
    }

    // Checks if the loader should be stopped based on elapsed time
    public boolean shouldStopLoader() {
        int delay = mFirstUse ? 300000 : 0;
        return SystemClock.elapsedRealtime() > (mLoaderStartTime + delay);
    }

    // Setters/getters
    public void setFirstUse(boolean firstUse) { mFirstUse = firstUse; }
}