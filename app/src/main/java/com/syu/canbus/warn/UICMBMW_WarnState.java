package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class UICMBMW_WarnState {
    private static UICMBMW_WarnState mInstance;
    Context context;
    private View sWarnContent;

    public static UICMBMW_WarnState getInstance() {
        if (mInstance == null) {
            mInstance = new UICMBMW_WarnState();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (DataCanbus.DATA[99] != 1 && DataCanbus.DATA[13] == 0 && DataCanbus.DATA[98] == 0) {
            if (window.isShowing()) {
                window.dismiss();
            }
        } else if (this.sWarnContent != null) {
            WarnUtils.setLocation(0, -320);
            WarnUtils.showWindow();
        }
    }

    private void initTip(int updateCode, int value) {
        int i = R.drawable.ic_dashboard_car_null;
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0450_cm_carstate_warn, (ViewGroup) null, false);
        }
        switch (updateCode) {
            case 13:
                ImageView imageView = (ImageView) this.sWarnContent.findViewById(R.id.layout_view2);
                if (value != 0) {
                    i = R.drawable.ic_cm_bmw_handbrake_p;
                }
                imageView.setBackgroundResource(i);
                break;
            case 98:
                ImageView imageView2 = (ImageView) this.sWarnContent.findViewById(R.id.layout_view3);
                if (value != 0) {
                    i = R.drawable.ic_cm_bmw_oillow_p;
                }
                imageView2.setBackgroundResource(i);
                break;
            case 99:
                ImageView imageView3 = (ImageView) this.sWarnContent.findViewById(R.id.layout_view1);
                if (value == 1) {
                    i = R.drawable.ic_cm_bmw_belt_p;
                }
                imageView3.setBackgroundResource(i);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
