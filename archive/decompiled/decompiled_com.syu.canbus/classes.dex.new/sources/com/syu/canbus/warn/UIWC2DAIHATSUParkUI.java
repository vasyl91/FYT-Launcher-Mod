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
public class UIWC2DAIHATSUParkUI {
    private static UIWC2DAIHATSUParkUI mInstance;
    Context context;
    private View sWarnContent;

    public static UIWC2DAIHATSUParkUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIWC2DAIHATSUParkUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[4] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0444_wc2_daihatsu_parkui, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWC2DAIHATSUParkUI.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[3];
                    if (value2 != 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{2, 1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{2, 0}, null, null);
                    }
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWC2DAIHATSUParkUI.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[3];
                    if (value2 != 2) {
                        DataCanbus.PROXY.cmd(0, new int[]{3, 1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{3, 0}, null, null);
                    }
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWC2DAIHATSUParkUI.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[3];
                    if (value2 != 3) {
                        DataCanbus.PROXY.cmd(0, new int[]{4, 1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{4, 0}, null, null);
                    }
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWC2DAIHATSUParkUI.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[2];
                    if (value2 == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{5, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{5, 1}, null, null);
                    }
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWC2DAIHATSUParkUI.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[1];
                    if (value2 == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{6, 0}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{6, 1}, null, null);
                    }
                }
            });
        }
        switch (updateCode) {
            case 1:
                if (value == 0) {
                    this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_daihatsu_button_n);
                } else {
                    this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_daihatsu_button_p);
                }
                break;
            case 2:
                if (value == 0) {
                    this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_daihatsu_button_n);
                } else {
                    this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_daihatsu_button_p);
                }
                break;
            case 3:
                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_daihatsu_button_n);
                this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_daihatsu_button_n);
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_daihatsu_button_n);
                switch (value) {
                    case 1:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_daihatsu_button_p);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_daihatsu_button_p);
                        break;
                    case 3:
                        this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_daihatsu_button_p);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
