package com.yanzhenjie.recyclerview;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwipeMenuBridge {
    private final Controller mController;
    private final int mDirection;
    private final int mPosition;

    public SwipeMenuBridge(Controller controller, int i, int i2) {
        this.mController = controller;
        this.mDirection = i;
        this.mPosition = i2;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void closeMenu() {
        this.mController.smoothCloseMenu();
    }
}
