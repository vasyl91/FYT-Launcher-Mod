package com.yanzhenjie.recyclerview;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
interface Controller {
    boolean isCompleteOpen();

    boolean isLeftCompleteOpen();

    boolean isLeftMenuOpen();

    boolean isLeftMenuOpenNotEqual();

    boolean isMenuOpen();

    boolean isMenuOpenNotEqual();

    boolean isRightCompleteOpen();

    boolean isRightMenuOpen();

    boolean isRightMenuOpenNotEqual();

    void smoothCloseLeftMenu();

    void smoothCloseMenu();

    void smoothCloseMenu(int i);

    void smoothCloseRightMenu();

    void smoothOpenLeftMenu();

    void smoothOpenLeftMenu(int i);

    void smoothOpenMenu();

    void smoothOpenRightMenu();

    void smoothOpenRightMenu(int i);
}
