package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIXPXiandai360View {
    private static UIXPXiandai360View mInstance;
    Context context;
    private View mLayoutImage;
    private View sWarnContent;
    boolean showflag = false;

    public static UIXPXiandai360View getInstance() {
        if (mInstance == null) {
            mInstance = new UIXPXiandai360View();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && DataCanbus.DATA[123] != 0 && DataCanbus.DATA[121] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0355_xiandai_mode_360view, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (!UIXPXiandai360View.this.showflag) {
                        UIXPXiandai360View.this.showflag = true;
                        UIXPXiandai360View.this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(0);
                    } else if (UIXPXiandai360View.this.showflag) {
                        UIXPXiandai360View.this.showflag = false;
                        UIXPXiandai360View.this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(8);
                    }
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus11).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (!UIXPXiandai360View.this.showflag) {
                        UIXPXiandai360View.this.showflag = true;
                        UIXPXiandai360View.this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(0);
                    } else if (UIXPXiandai360View.this.showflag) {
                        UIXPXiandai360View.this.showflag = false;
                        UIXPXiandai360View.this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(8);
                    }
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 5}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 6}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 7}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 8}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 1}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 1}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus9).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 3}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus10).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.11
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 4}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus16).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, 5}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus12).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2;
                    int value3 = DataCanbus.DATA[100];
                    if (value3 == 0) {
                        value2 = 1;
                    } else {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{2, value2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus13).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2;
                    int value3 = DataCanbus.DATA[101];
                    if (value3 == 0) {
                        value2 = 1;
                    } else {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{3, value2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_minus14).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.15
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[103] - 1;
                    if (value2 < 0) {
                        value2 = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{4, value2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus14).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.16
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[103] + 1;
                    if (value2 > 3) {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{4, value2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_minus15).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[102] - 1;
                    if (value2 < 0) {
                        value2 = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{5, value2}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus15).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIXPXiandai360View.18
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value2 = DataCanbus.DATA[102] + 1;
                    if (value2 > 3) {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{5, value2}, null, null);
                }
            });
        }
        switch (updateCode) {
            case 100:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_jeep_on2);
                } else {
                    this.sWarnContent.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_jeep_off2);
                }
                break;
            case 101:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_jeep_on2);
                } else {
                    this.sWarnContent.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_jeep_off2);
                }
                break;
            case 102:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText(R.string.str_394_all_view);
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_1);
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_2);
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_3);
                        break;
                }
                break;
            case 103:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(R.string.str_394_all_view);
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_1);
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_2);
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_3);
                        break;
                }
                break;
            case 121:
                if (value == 2) {
                    this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_view1).setVisibility(0);
                } else if (value == 1) {
                    this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(0);
                    this.sWarnContent.findViewById(R.id.layout_view1).setVisibility(8);
                } else {
                    this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_view1).setVisibility(8);
                }
                break;
            case 122:
                this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.front1);
                this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.front2);
                this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.front3);
                this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.front4);
                this.sWarnContent.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.front7);
                this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.rear2);
                this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.rear3);
                this.sWarnContent.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.rear4);
                switch (value) {
                    case 1:
                        this.sWarnContent.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.front7_p);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.rear2_p);
                        break;
                    case 3:
                        this.sWarnContent.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.rear3_p);
                        break;
                    case 4:
                        this.sWarnContent.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.rear4_p);
                        break;
                    case 5:
                        this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.front1_p);
                        break;
                    case 6:
                        this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.front2_p);
                        break;
                    case 7:
                        this.sWarnContent.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.front3_p);
                        break;
                    case 8:
                        this.sWarnContent.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.front4_p);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
