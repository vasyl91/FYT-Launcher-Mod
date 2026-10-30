package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIRZC24Vito360ParkUI {
    private static UIRZC24Vito360ParkUI mInstance;
    Context context;
    private View sWarnContent;

    public static UIRZC24Vito360ParkUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZC24Vito360ParkUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[160] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_rzc_24vito_parkui, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 0}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 9}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 8}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 7}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 3}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 5}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 10}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus9).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 11}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus10).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 12}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus11).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZC24Vito360ParkUI.11
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1, 13}, null, null);
                }
            });
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
