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
public class UIRZCJiangHuaiS7ParkUI {
    private static UIRZCJiangHuaiS7ParkUI mInstance;
    Context context;
    private View sWarnContent;

    public static UIRZCJiangHuaiS7ParkUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCJiangHuaiS7ParkUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[166] != 0 && DataCanbus.DATA[167] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_rzc_jianghuais7_parkui, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{5}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{7}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{8}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{6}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{3}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{4}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCJiangHuaiS7ParkUI.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                }
            });
        }
        switch (updateCode) {
            case 164:
                this.sWarnContent.findViewById(R.id.btn_plus1).setVisibility(8);
                this.sWarnContent.findViewById(R.id.btn_plus2).setVisibility(8);
                this.sWarnContent.findViewById(R.id.btn_plus3).setVisibility(8);
                this.sWarnContent.findViewById(R.id.btn_plus4).setVisibility(8);
                this.sWarnContent.findViewById(R.id.btn_plus5).setVisibility(8);
                this.sWarnContent.findViewById(R.id.btn_plus6).setVisibility(8);
                this.sWarnContent.findViewById(R.id.btn_plus7).setVisibility(8);
                this.sWarnContent.findViewById(R.id.btn_plus8).setVisibility(8);
                switch (value) {
                    case 1:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus2).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus3).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus4).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus5).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus8).setVisibility(0);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus2).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus3).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus4).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus5).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus7).setVisibility(0);
                        break;
                    case 3:
                        this.sWarnContent.findViewById(R.id.btn_plus6).setVisibility(0);
                        break;
                    default:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus2).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus3).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus4).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus5).setVisibility(0);
                        this.sWarnContent.findViewById(R.id.btn_plus7).setVisibility(0);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
