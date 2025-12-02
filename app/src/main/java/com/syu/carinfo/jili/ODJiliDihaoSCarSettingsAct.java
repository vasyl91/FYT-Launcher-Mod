package com.syu.carinfo.jili;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODJiliDihaoSCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 159:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("SPORT");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text1)).setText("COMFORT");
                            break;
                    }
                case 160:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 161:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 162:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 163:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("柔和");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("舒适");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text2)).setText("强劲");
                            break;
                    }
                case 164:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 165:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 166:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 167:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 168:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 169:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("关");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("10km/h");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text3)).setText("20km/h");
                            break;
                    }
                case 170:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("仅灯光");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("灯光和声音");
                            break;
                    }
                case 171:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 172:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 173:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 174:
                    ODJiliDihaoSCarSettingsAct.this.setCheck((CheckedTextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 176:
                    ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.layout_view19).setVisibility(8);
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("随驾驶模式联动");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("随车速联动");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("呼吸模式");
                            break;
                        case 3:
                            ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.layout_view19).setVisibility(0);
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("主题色");
                            break;
                        case 4:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("无极变色 ");
                            break;
                        case 5:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("自定义");
                            break;
                        case 6:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("音乐律动");
                            break;
                    }
                case 177:
                    ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 178:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("烈日红色");
                            break;
                        case 1:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("橙色");
                            break;
                        case 2:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("黄色");
                            break;
                        case 3:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("绿色");
                            break;
                        case 4:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("冰蓝 ");
                            break;
                        case 5:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("蓝色");
                            break;
                        case 6:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("紫色");
                            break;
                        case 7:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("粉红色");
                            break;
                        case 8:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("晚霞红");
                            break;
                        case 9:
                            ((TextView) ODJiliDihaoSCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("苹果绿");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_od_jili_dihaos_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[159] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[159] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[163] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(11, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[163] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(11, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[169] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(17, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[169] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(17, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[170] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[170] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[176] - 1;
                if (value9 < 0) {
                    value9 = 6;
                }
                setCarInfo(23, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[176] + 1;
                if (value10 > 6) {
                    value10 = 0;
                }
                setCarInfo(23, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[177] - 1;
                if (value11 < 1) {
                    value11 = 10;
                }
                setCarInfo(24, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[177] + 1;
                if (value12 > 10) {
                    value12 = 1;
                }
                setCarInfo(24, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[178] - 1;
                if (value13 < 0) {
                    value13 = 9;
                }
                setCarInfo(25, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[178] + 1;
                if (value14 > 9) {
                    value14 = 0;
                }
                setCarInfo(25, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(3, DataCanbus.DATA[160] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(4, DataCanbus.DATA[161] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(6, DataCanbus.DATA[162] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(12, DataCanbus.DATA[164] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(9, DataCanbus.DATA[165] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(10, DataCanbus.DATA[166] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(13, DataCanbus.DATA[167] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(8, DataCanbus.DATA[168] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(19, DataCanbus.DATA[171] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(18, DataCanbus.DATA[172] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(20, DataCanbus.DATA[173] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(21, DataCanbus.DATA[174] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ODJiliDihaoSSunSetActi.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{78}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
    }
}
