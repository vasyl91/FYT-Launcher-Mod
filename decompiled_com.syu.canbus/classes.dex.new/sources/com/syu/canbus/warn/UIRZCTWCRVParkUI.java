package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIRZCTWCRVParkUI {
    private static UIRZCTWCRVParkUI mInstance;
    Context context;
    private View sWarnContent;

    public static UIRZCTWCRVParkUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCTWCRVParkUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[316] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            if (DataCanbus.DATA[1000] == 5505322) {
                this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0298_rzc_twcrv_parkui_ccd, (ViewGroup) null, false);
            } else {
                this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0298_rzc_twcrv_parkui, (ViewGroup) null, false);
            }
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCTWCRVParkUI.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(123, new int[1], null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCTWCRVParkUI.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(123, new int[]{1}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCTWCRVParkUI.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(123, new int[]{2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCTWCRVParkUI.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[216];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 58;
                    iArr[1] = value2 != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(105, iArr, null, null);
                }
            });
        }
        switch (updateCode) {
            case 216:
                switch (value) {
                    case 0:
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_rzc_honda_camera_4_n);
                        break;
                    case 1:
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_rzc_honda_camera_4_p);
                        break;
                }
                break;
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
            case 312:
                switch (value) {
                    case 0:
                        this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_jaguar_null);
                        break;
                    case 1:
                        this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_rzc_park_radar_left3);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_rzc_park_radar_left2);
                        break;
                    case 3:
                    case 4:
                        this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_rzc_park_radar_left1);
                        break;
                }
                break;
            case 313:
                switch (value) {
                    case 0:
                        this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_jaguar_null);
                        break;
                    case 1:
                        this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_rzc_park_radar_center3);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_rzc_park_radar_center2);
                        break;
                    case 3:
                    case 4:
                        this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_rzc_park_radar_center1);
                        break;
                }
                break;
            case 314:
                switch (value) {
                    case 0:
                        this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_jaguar_null);
                        break;
                    case 1:
                        this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_rzc_park_radar_center3);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_rzc_park_radar_center2);
                        break;
                    case 3:
                    case 4:
                        this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_rzc_park_radar_center1);
                        break;
                }
                break;
            case 315:
                switch (value) {
                    case 0:
                        this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_jaguar_null);
                        break;
                    case 1:
                        this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_rzc_park_radar_left3);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_rzc_park_radar_left2);
                        break;
                    case 3:
                    case 4:
                        this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_rzc_park_radar_left1);
                        break;
                }
                break;
            case 317:
                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_rzc_honda_camera_1_n);
                this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_rzc_honda_camera_2_n);
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_rzc_honda_camera_3_n);
                switch (value) {
                    case 0:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_rzc_honda_camera_1_p);
                        break;
                    case 1:
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_rzc_honda_camera_2_p);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_rzc_honda_camera_3_p);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
