package com.syu.carinfo.rzc.qirui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityQiRuiXingtuTXLCarset extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiXingtuTXLCarset.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 177:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 178:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 179:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                            break;
                        case 1:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                            break;
                    }
                    break;
                case 180:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text2)).setText(R.string.str_remote_unlock2);
                            break;
                        case 1:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text2)).setText(R.string.str_remote_unlock1);
                            break;
                    }
                    break;
                case 181:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 182:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text3)).setText("10s");
                            break;
                        case 2:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text3)).setText("30s");
                            break;
                        case 3:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text3)).setText("60s");
                            break;
                    }
                    break;
                case 183:
                    ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value + 70) + "%");
                    break;
                case 184:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 185:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 186:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 187:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 188:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 189:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 190:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 191:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_3);
                            break;
                        case 1:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_5);
                            break;
                    }
                    break;
                case 192:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                            break;
                        case 1:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                            break;
                    }
                    break;
                case 193:
                    ((CheckedTextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 194:
                    switch (value) {
                        case 0:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text7)).setText("时尚时钟");
                            break;
                        case 1:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text7)).setText("电子时钟");
                            break;
                        case 2:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text7)).setText("模拟时钟");
                            break;
                        case 3:
                            ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text7)).setText("天气");
                            break;
                    }
                    break;
                case 195:
                    ((TextView) ActivityQiRuiXingtuTXLCarset.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_404_qirui_xingtutxl);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, 67, 0);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[179] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfoState(1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[179] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfoState(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[180] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfoState(0, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[180] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfoState(0, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[182] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfoState(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[182] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfoState(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[183] - 5;
                if (value7 < 0) {
                    value7 = 0;
                }
                setCarInfoState(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[183] + 5;
                if (value8 > 30) {
                    value8 = 30;
                }
                setCarInfoState(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[191] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfoState(16, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[191] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfoState(16, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[192] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfoState(15, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[192] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfoState(15, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[194] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfoState(17, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[194] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfoState(17, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[195] - 1;
                if (value15 < 1) {
                    value15 = 3;
                }
                setCarInfoState(18, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[195] + 1;
                if (value16 > 3) {
                    value16 = 1;
                }
                setCarInfoState(18, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfoState(3, DataCanbus.DATA[177] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfoState(8, DataCanbus.DATA[184] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfoState(7, DataCanbus.DATA[185] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfoState(2, DataCanbus.DATA[178] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfoState(5, DataCanbus.DATA[181] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfoState(13, DataCanbus.DATA[186] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfoState(12, DataCanbus.DATA[187] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfoState(11, DataCanbus.DATA[188] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfoState(10, DataCanbus.DATA[189] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfoState(9, DataCanbus.DATA[190] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfoState(14, DataCanbus.DATA[193] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                dialog(R.string.str_seat_position, 19, DataCanbus.DATA[195]);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd, final int value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.str_save)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiXingtuTXLCarset.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                final int i2 = value;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiXingtuTXLCarset.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i, i2}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiXingtuTXLCarset.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void setCarInfoState(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
    }
}
