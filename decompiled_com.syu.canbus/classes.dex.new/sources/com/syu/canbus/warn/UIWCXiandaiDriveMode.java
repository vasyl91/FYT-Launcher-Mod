package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIWCXiandaiDriveMode {
    private static UIWCXiandaiDriveMode mInstance;
    Context context;
    private View sWarnContent;

    public static UIWCXiandaiDriveMode getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCXiandaiDriveMode();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && value != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
        }
        switch (value) {
            case 1:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText("Comfort");
                break;
            case 2:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText("ECO");
                break;
            case 3:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText("Sport");
                break;
            case 4:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText("Smart");
                break;
            case 5:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText("Custom");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
