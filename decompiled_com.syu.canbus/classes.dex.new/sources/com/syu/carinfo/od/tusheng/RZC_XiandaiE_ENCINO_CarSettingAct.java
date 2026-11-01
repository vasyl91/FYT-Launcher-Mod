package com.syu.carinfo.od.tusheng;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_XiandaiE_ENCINO_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_ENCINO_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 225:
                    int percent = (value & 63) * 2;
                    int mile = (value >> 6) & 1023;
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(percent) + "%");
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(mile) + "km");
                    break;
                case 226:
                    int percent2 = (value & 63) * 2;
                    int mile2 = (value >> 6) & 1023;
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(percent2) + "%");
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(mile2) + "km");
                    break;
                case 227:
                    int hour = value / 60;
                    int min = value % 60;
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour) + ":" + (min / 10) + (min % 10));
                    break;
                case 228:
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "KW");
                    break;
                case 229:
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10) + "KW");
                    break;
                case 230:
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10) + "KW");
                    break;
                case 231:
                    ((TextView) RZC_XiandaiE_ENCINO_CarSettingAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10) + "KW");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0447_rzc_xiandai_encino_e_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value1 = (DataCanbus.DATA[225] & 63) * 2;
                if (value1 > 50) {
                    value1 -= 10;
                }
                if (value1 < 50) {
                    value1 = 50;
                }
                DataCanbus.PROXY.cmd(13, new int[]{8, value1}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = (DataCanbus.DATA[225] & 63) * 2;
                if (value2 < 100) {
                    value2 += 10;
                }
                if (value2 > 100) {
                    value2 = 100;
                }
                DataCanbus.PROXY.cmd(13, new int[]{8, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = (DataCanbus.DATA[226] & 63) * 2;
                if (value3 > 50) {
                    value3 -= 10;
                }
                if (value3 < 50) {
                    value3 = 50;
                }
                DataCanbus.PROXY.cmd(13, new int[]{9, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = (DataCanbus.DATA[226] & 63) * 2;
                if (value4 < 100) {
                    value4 += 10;
                }
                if (value4 > 100) {
                    value4 = 100;
                }
                DataCanbus.PROXY.cmd(13, new int[]{9, value4}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZC_XiandaiE_ENCINO_PreChargeSettingAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, RZC_XiandaiE_ENCINO_ModeSettingAct.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{86, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
    }
}
