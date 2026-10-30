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
public class UIODRaetonParkUI {
    private static UIODRaetonParkUI mInstance;
    Context context;
    private View sWarnContent;

    public static UIODRaetonParkUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIODRaetonParkUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[134] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0454_od_raeton_parkui, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{3}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{4}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{5}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                    DataCanbus.PROXY.cmd(3, new int[]{16}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{17}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{2}, null, null);
                    DataCanbus.PROXY.cmd(3, new int[]{16}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus9).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIODRaetonParkUI.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(3, new int[]{18}, null, null);
                }
            });
        }
        switch (updateCode) {
            case 131:
                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_raeton_front_n);
                this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_raeton_rear_n);
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_raeton_left_n);
                this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_raeton_right_n);
                this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_raeton_double_n);
                this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_raeton_f120_n);
                this.sWarnContent.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_raeton_f180_n);
                this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_raeton_r120_n);
                this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_raeton_r180_n);
                switch (value) {
                    case 1:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_raeton_front_p);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_raeton_left_p);
                        break;
                    case 3:
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_raeton_right_p);
                        break;
                    case 4:
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_raeton_rear_p);
                        break;
                    case 5:
                        this.sWarnContent.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_raeton_f120_p);
                        break;
                    case 6:
                        this.sWarnContent.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_raeton_f180_p);
                        break;
                    case 7:
                        this.sWarnContent.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_raeton_double_n);
                        break;
                    case 8:
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_raeton_r120_p);
                        break;
                    case 9:
                        this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_raeton_r180_p);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
