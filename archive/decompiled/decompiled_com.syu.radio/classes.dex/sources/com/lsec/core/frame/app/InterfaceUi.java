package com.lsec.core.frame.app;

import android.view.View;
import com.lsec.core.frame.ctrl.JPage;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface InterfaceUi {
    void InitMapPage(MyUi myUi);

    void InitPage(JPage jPage);

    View createUiItemOtherWay(JPage jPage, MyUiItem myUiItem);

    void setProperty(View view);
}
