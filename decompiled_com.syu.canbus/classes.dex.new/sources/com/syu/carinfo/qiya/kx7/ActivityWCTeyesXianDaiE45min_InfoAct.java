package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWCTeyesXianDaiE45min_InfoAct extends Activity implements View.OnClickListener {
    private VerticalProgressbar[] mProgressbar = new VerticalProgressbar[19];
    private VerticalProgressbar[] mProgressbar1 = new VerticalProgressbar[19];
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiE45min_InfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    if (value == 65535) {
                        ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text1)).setText("--.-");
                    } else {
                        ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    }
                    break;
                case 125:
                    switch (value) {
                        case 2:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text2)).setText("MPG(US)");
                            break;
                        case 3:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text2)).setText("MPG(UK)");
                            break;
                        case 4:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text2)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                            break;
                        default:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text2)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                            break;
                    }
                    break;
                case 132:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(0, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 133:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(1, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 134:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(2, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 135:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(3, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 136:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(4, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 137:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(5, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 138:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(6, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 139:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(7, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 140:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(8, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 141:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(9, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 142:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.unit = value;
                    switch (value) {
                        case 2:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text3)).setText("75");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text4)).setText("50");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text5)).setText("25");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text6)).setText("MPG US");
                            break;
                        case 3:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text3)).setText("75");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text4)).setText("50");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text5)).setText("25");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text6)).setText("MPG Uk");
                            break;
                        case 4:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text3)).setText("30");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text4)).setText("20");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text5)).setText("10");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text6)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                            break;
                        default:
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text3)).setText("15");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text4)).setText("10");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text5)).setText("5");
                            ((TextView) ActivityWCTeyesXianDaiE45min_InfoAct.this.findViewById(R.id.tv_text6)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                            break;
                    }
                    for (int n = 0; n < 9; n++) {
                        ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(n, DataCanbus.DATA[n + 132], ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    }
                    for (int n2 = 0; n2 < 9; n2++) {
                        ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(n2 + 9, DataCanbus.DATA[n2 + 153], ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    }
                    break;
                case 143:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(0, value);
                    break;
                case 144:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(1, value);
                    break;
                case 145:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(2, value);
                    break;
                case 146:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(3, value);
                    break;
                case 147:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(4, value);
                    break;
                case 148:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(5, value);
                    break;
                case 149:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(6, value);
                    break;
                case 150:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(7, value);
                    break;
                case 151:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(8, value);
                    break;
                case 152:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(9, value);
                    break;
                case 153:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(10, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 154:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(11, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 155:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(12, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 156:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(13, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 157:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(14, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 158:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(15, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 159:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(16, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 160:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(17, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 161:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue(18, value, ActivityWCTeyesXianDaiE45min_InfoAct.this.unit);
                    break;
                case 163:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(10, value);
                    break;
                case 164:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(11, value);
                    break;
                case 165:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(12, value);
                    break;
                case 166:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(13, value);
                    break;
                case 167:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(14, value);
                    break;
                case 168:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(15, value);
                    break;
                case 169:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(16, value);
                    break;
                case 170:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(17, value);
                    break;
                case 171:
                    ActivityWCTeyesXianDaiE45min_InfoAct.this.mUpdaterOilValue1(18, value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_teyes_xiandai_e45min_info);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        this.mProgressbar[0] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_0);
        this.mProgressbar[1] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_1);
        this.mProgressbar[2] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_2);
        this.mProgressbar[3] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_3);
        this.mProgressbar[4] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_4);
        this.mProgressbar[5] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_5);
        this.mProgressbar[6] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_6);
        this.mProgressbar[7] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_7);
        this.mProgressbar[8] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_8);
        this.mProgressbar[9] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_9);
        this.mProgressbar[10] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_10);
        this.mProgressbar[11] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_11);
        this.mProgressbar[12] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_12);
        this.mProgressbar[13] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_13);
        this.mProgressbar[14] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_14);
        this.mProgressbar[15] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_15);
        this.mProgressbar[16] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_16);
        this.mProgressbar[17] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_17);
        this.mProgressbar[18] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_18);
        this.mProgressbar1[0] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_0);
        this.mProgressbar1[1] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_1);
        this.mProgressbar1[2] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_2);
        this.mProgressbar1[3] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_3);
        this.mProgressbar1[4] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_4);
        this.mProgressbar1[5] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_5);
        this.mProgressbar1[6] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_6);
        this.mProgressbar1[7] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_7);
        this.mProgressbar1[8] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_8);
        this.mProgressbar1[9] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_9);
        this.mProgressbar1[10] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_10);
        this.mProgressbar1[11] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_11);
        this.mProgressbar1[12] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_12);
        this.mProgressbar1[13] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_13);
        this.mProgressbar1[14] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_14);
        this.mProgressbar1[15] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_15);
        this.mProgressbar1[16] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_16);
        this.mProgressbar1[17] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_17);
        this.mProgressbar1[18] = (VerticalProgressbar) findViewById(R.id.camry_progressbar1_18);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427458 */:
                DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                finish();
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                dialog(R.string.all_settings, 24);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiE45min_InfoAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiE45min_InfoAct.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i, 1, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiE45min_InfoAct.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCTeyesXianDaiE45min_InfoAct.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(4, new int[]{i, 0, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue(int num, int value, int unit) {
        int numMax;
        if (value != 65535) {
            int value2 = value / 10;
            if (unit == 2 || unit == 3) {
                numMax = 75;
            } else if (unit == 4) {
                numMax = 30;
            } else {
                numMax = 15;
            }
            if (this.mProgressbar[num] != null) {
                this.mProgressbar[num].setMax(numMax);
                if (value2 > numMax) {
                    value2 = numMax;
                }
                this.mProgressbar[num].setProgress(value2);
                this.mProgressbar[num].invalidate();
                return;
            }
            return;
        }
        this.mProgressbar[num].setProgress(0);
        this.mProgressbar[num].invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilValue1(int num, int value) {
        if (value != 65535) {
            int value2 = value / 10;
            if (this.mProgressbar1[num] != null) {
                this.mProgressbar1[num].setProgress(value2);
                this.mProgressbar1[num].invalidate();
                return;
            }
            return;
        }
        this.mProgressbar1[num].setProgress(0);
        this.mProgressbar1[num].invalidate();
    }
}
