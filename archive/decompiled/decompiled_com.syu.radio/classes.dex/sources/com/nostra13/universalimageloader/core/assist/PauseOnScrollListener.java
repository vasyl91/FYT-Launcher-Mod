package com.nostra13.universalimageloader.core.assist;

import android.widget.AbsListView;
import com.nostra13.universalimageloader.core.ImageLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class PauseOnScrollListener implements AbsListView.OnScrollListener {
    private final AbsListView.OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader, boolean pauseOnScroll, boolean pauseOnFling) {
        this(imageLoader, pauseOnScroll, pauseOnFling, null);
    }

    public PauseOnScrollListener(ImageLoader imageLoader, boolean pauseOnScroll, boolean pauseOnFling, AbsListView.OnScrollListener customListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = pauseOnScroll;
        this.pauseOnFling = pauseOnFling;
        this.externalListener = customListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case 0:
                this.imageLoader.resume();
                break;
            case 1:
                if (this.pauseOnScroll) {
                    this.imageLoader.pause();
                }
                break;
            case 2:
                if (this.pauseOnFling) {
                    this.imageLoader.pause();
                }
                break;
        }
        if (this.externalListener != null) {
            this.externalListener.onScrollStateChanged(view, scrollState);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (this.externalListener != null) {
            this.externalListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }
}
