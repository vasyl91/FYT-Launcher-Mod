package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_0314_DongfengE3_CarInfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 126:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 127:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 128:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 129:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 130:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 131:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 132:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 133:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setText(R.string.setting_313_tv51str);
                        break;
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_gs4_common);
                        break;
                    }
                case 134:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0314_dongfenge3_carinfo);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{66}, null, null);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
    }
}
