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
public class UIWCDatongD90ParkUI {
    private static UIWCDatongD90ParkUI mInstance;
    Context context;
    private View sWarnContent;

    public static UIWCDatongD90ParkUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCDatongD90ParkUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[192] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0416_wc_d90_parkui, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 7}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 8}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 6}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 5}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 12}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 10}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 11}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 13}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus9).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIWCDatongD90ParkUI.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(5, new int[]{15, 0}, null, null);
                }
            });
        }
        switch (updateCode) {
            case 193:
                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_raeton_front_n);
                this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_raeton_rear_n);
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_raeton_left_n);
                this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_raeton_right_n);
                this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_raeton_frontleft_n);
                this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_raeton_frontright_n);
                this.sWarnContent.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_raeton_rearleft_n);
                this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_raeton_rearright_n);
                switch (value) {
                    case 5:
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_raeton_right_p);
                        break;
                    case 6:
                        this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_raeton_left_p);
                        break;
                    case 7:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_raeton_front_p);
                        break;
                    case 8:
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_raeton_rear_p);
                        break;
                    case 10:
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_raeton_frontright_p);
                        break;
                    case 11:
                        this.sWarnContent.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_raeton_rearleft_p);
                        break;
                    case 12:
                        this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_raeton_frontleft_p);
                        break;
                    case 13:
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_raeton_rearright_p);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
