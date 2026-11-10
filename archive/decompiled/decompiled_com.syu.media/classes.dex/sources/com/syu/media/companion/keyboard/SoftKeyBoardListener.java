package com.syu.media.companion.keyboard;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SoftKeyBoardListener {
    private OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    private View rootView;
    int rootViewVisibleHeight;

    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i);

        void keyBoardShow(int i);
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.rootView = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.syu.media.companion.keyboard.SoftKeyBoardListener$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.m150lambda$new$0$comsyumediacompanionkeyboardSoftKeyBoardListener();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-syu-media-companion-keyboard-SoftKeyBoardListener, reason: not valid java name */
    /* synthetic */ void m150lambda$new$0$comsyumediacompanionkeyboardSoftKeyBoardListener() {
        Rect rect = new Rect();
        this.rootView.getWindowVisibleDisplayFrame(rect);
        int iHeight = rect.height();
        int i = this.rootViewVisibleHeight;
        if (i == 0) {
            this.rootViewVisibleHeight = iHeight;
            return;
        }
        if (i == iHeight) {
            return;
        }
        if (i - iHeight > 200) {
            OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener = this.onSoftKeyBoardChangeListener;
            if (onSoftKeyBoardChangeListener != null) {
                onSoftKeyBoardChangeListener.keyBoardShow(i - iHeight);
            }
            this.rootViewVisibleHeight = iHeight;
            return;
        }
        if (iHeight - i > 200) {
            OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener2 = this.onSoftKeyBoardChangeListener;
            if (onSoftKeyBoardChangeListener2 != null) {
                onSoftKeyBoardChangeListener2.keyBoardHide(iHeight - i);
            }
            this.rootViewVisibleHeight = iHeight;
        }
    }

    private void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener;
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener);
    }
}
