package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class UIRZCCRVParkUI {
    private static UIRZCCRVParkUI mInstance;
    Context context;
    private View sWarnContent;

    public static UIRZCCRVParkUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCCRVParkUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[316] != 0 && DataCanbus.DATA[203] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0298_rzc_crv_parkui, (ViewGroup) null, false);
        }
        switch (updateCode) {
            case 311:
                if ((value & 1) != 0) {
                    ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_rzc_park_warn_left);
                } else {
                    ((ImageView) this.sWarnContent.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                }
                if ((value & 2) != 0) {
                    ((ImageView) this.sWarnContent.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_rzc_park_warn_right);
                } else {
                    ((ImageView) this.sWarnContent.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
