package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_BZ408EVMilePage2Acti extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408EVMilePage2Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 280:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text1)).setText("0-5(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text3)).setText("5-10(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text5)).setText("10-15(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text7)).setText("15-20(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text9)).setText("20-25(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text11)).setText("25-30(min)");
                            break;
                        case 1:
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text1)).setText("0-10(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text3)).setText("10-20(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text5)).setText("20-30(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text7)).setText("30-40(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text9)).setText("40-50(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text11)).setText("50-60(min)");
                            break;
                        case 2:
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text1)).setText("0-20(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text3)).setText("20-40(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text5)).setText("40-60(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text7)).setText("60-80(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text9)).setText("80-100(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text11)).setText("100-120(min)");
                            break;
                    }
                    break;
                case 281:
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text25)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 282:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 283:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 284:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 285:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 286:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 287:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 288:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text13)).setText("0-5(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text15)).setText("5-10(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text17)).setText("10-15(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text19)).setText("15-20(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text21)).setText("20-25(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text23)).setText("25-30(min)");
                            break;
                        case 1:
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text13)).setText("0-10(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text15)).setText("10-20(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text17)).setText("20-30(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text19)).setText("30-40(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text21)).setText("40-50(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text23)).setText("50-60(min)");
                            break;
                        case 2:
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text13)).setText("0-20(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text15)).setText("20-40(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text17)).setText("40-60(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text19)).setText("60-80(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text21)).setText("80-100(min)");
                            ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text23)).setText("100-120(min)");
                            break;
                    }
                    break;
                case 289:
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text26)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    break;
                case 290:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text14)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 291:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text16)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 292:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text18)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 293:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text20)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 294:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text22)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 295:
                    if (value > 30) {
                        value = 30;
                    }
                    ((TextView) RZC_BZ408EVMilePage2Acti.this.findViewById(R.id.tv_text24)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0339_rzc_psa_ev2_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[280] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(100, new int[]{0, value, 0}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[280] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(100, new int[]{0, value2, 0}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(70, new int[]{81}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[283].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[284].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[285].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[286].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[290].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[291].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[283].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[284].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[285].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[286].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[290].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[291].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
    }
}
