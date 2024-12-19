package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_0314_DongfengE3_CarInfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengE3_CarInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 114:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 115:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 116:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 117:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 118:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 119:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 120:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 121:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 122:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setText(R.string.str_gs4_common);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0314_dongfenge3_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{66}, null, null);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }
}
