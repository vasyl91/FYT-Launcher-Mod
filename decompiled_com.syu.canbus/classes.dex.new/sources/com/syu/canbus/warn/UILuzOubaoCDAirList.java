package com.syu.canbus.warn;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0452_LZ_Oubao_Andela;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UILuzOubaoCDAirList {
    private static UILuzOubaoCDAirList mInstance;
    Context context;
    int lightvlaue = 1;
    private View sWarnContent;

    public static UILuzOubaoCDAirList getInstance() {
        if (mInstance == null) {
            mInstance = new UILuzOubaoCDAirList();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[119] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            this.lightvlaue = 1;
            window.dismiss();
            DataCanbus.PROXY.cmd(0, new int[]{15}, null, null);
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.lightvlaue = 1;
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_lz_oubao_airlist, (ViewGroup) null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UILuzOubaoCDAirList.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{15}, null, null);
                        WarnUtils.getWindow().dismiss();
                    }
                    return true;
                }
            });
        }
        switch (updateCode) {
            case 118:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.layout_text_view1).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_text_view2).setVisibility(0);
                } else {
                    this.sWarnContent.findViewById(R.id.layout_text_view2).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.layout_text_view1).setVisibility(0);
                }
                updadatelight(this.lightvlaue);
                break;
            case 121:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(Callback_0452_LZ_Oubao_Andela.D0CAirStr1);
                break;
            case 122:
                if (DataCanbus.DATA[118] == 1) {
                    switch (value) {
                        case 1:
                            if (this.lightvlaue == 2) {
                                this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_2);
                            } else {
                                this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_0);
                            }
                            break;
                        case 2:
                            if (this.lightvlaue == 2) {
                                this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_3);
                            } else {
                                this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_1);
                            }
                            break;
                    }
                }
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText(Callback_0452_LZ_Oubao_Andela.D0CAirStr2);
                break;
            case 123:
                if (DataCanbus.DATA[118] == 1) {
                    switch (value) {
                        case 1:
                            if (this.lightvlaue == 3) {
                                this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_2);
                            } else {
                                this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_0);
                            }
                            break;
                        case 2:
                            if (this.lightvlaue == 3) {
                                this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_3);
                            } else {
                                this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_1);
                            }
                            break;
                    }
                }
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText(Callback_0452_LZ_Oubao_Andela.D0CAirStr3);
                break;
            case 124:
                if (DataCanbus.DATA[118] == 1) {
                    switch (value) {
                        case 1:
                            if (this.lightvlaue == 4) {
                                this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_2);
                            } else {
                                this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_0);
                            }
                            break;
                        case 2:
                            if (this.lightvlaue == 4) {
                                this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_3);
                            } else {
                                this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_1);
                            }
                            break;
                    }
                }
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText(Callback_0452_LZ_Oubao_Andela.D0CAirStr4);
                break;
            case 125:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText(Callback_0452_LZ_Oubao_Andela.D0CAirStr5);
                break;
            case 126:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setText(Callback_0452_LZ_Oubao_Andela.D0CAirStr6);
                break;
            case 127:
                if (((value >> 8) & 255) == 1) {
                    switch (value & 255) {
                        case 11:
                            DataCanbus.PROXY.cmd(0, new int[]{this.lightvlaue + 15}, null, null);
                            break;
                        case 14:
                            if (this.lightvlaue > 1) {
                                this.lightvlaue--;
                            }
                            updadatelight(this.lightvlaue);
                            break;
                        case 15:
                            if (this.lightvlaue < 6) {
                                this.lightvlaue++;
                            }
                            updadatelight(this.lightvlaue);
                            break;
                    }
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }

    private void updadatelight(int index) {
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#057cf0"));
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setTextColor(Color.parseColor("#057cf0"));
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setTextColor(Color.parseColor("#057cf0"));
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setTextColor(Color.parseColor("#057cf0"));
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setTextColor(Color.parseColor("#057cf0"));
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setTextColor(Color.parseColor("#057cf0"));
        if (DataCanbus.DATA[118] == 1) {
            switch (DataCanbus.DATA[122]) {
                case 1:
                    this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_0);
                    break;
                case 2:
                    this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_1);
                    break;
            }
            switch (DataCanbus.DATA[123]) {
                case 1:
                    this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_0);
                    break;
                case 2:
                    this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_1);
                    break;
            }
            switch (DataCanbus.DATA[124]) {
                case 1:
                    this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_0);
                    break;
                case 2:
                    this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_1);
                    break;
            }
        }
        switch (index) {
            case 1:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setTextColor(-256);
                break;
            case 2:
                if (DataCanbus.DATA[118] == 1) {
                    switch (DataCanbus.DATA[122]) {
                        case 1:
                            this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_2);
                            break;
                        case 2:
                            this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_oubao_ico_up_3);
                            break;
                    }
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setTextColor(-256);
                    break;
                }
                break;
            case 3:
                if (DataCanbus.DATA[118] == 1) {
                    switch (DataCanbus.DATA[123]) {
                        case 1:
                            this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_2);
                            break;
                        case 2:
                            this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_lz_oubao_ico_body_3);
                            break;
                    }
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setTextColor(-256);
                    break;
                }
                break;
            case 4:
                if (DataCanbus.DATA[118] == 1) {
                    switch (DataCanbus.DATA[124]) {
                        case 1:
                            this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_2);
                            break;
                        case 2:
                            this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_lz_oubao_ico_foot_3);
                            break;
                    }
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setTextColor(-256);
                    break;
                }
                break;
            case 5:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setTextColor(-256);
                break;
            case 6:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setTextColor(-256);
                break;
        }
    }
}
