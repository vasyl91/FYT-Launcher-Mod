package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0118_XP1_BiaoZhi2008;
import com.syu.module.canbus.Callback_0185_XP1_BiaoZhi408;
import com.syu.module.canbus.Callback_0278_XP1_BiaoZhi301;
import com.syu.module.canbus.Callback_0281_XP_PSA_ALL;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BZ408AlarmRecordActi extends BaseActivity {
    private static StringBuffer mStringBuffer = new StringBuffer(1000);
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.BZ408AlarmRecordActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 68:
                    BZ408AlarmRecordActi.this.mUpdaterValue1();
                    break;
                case 103:
                    BZ408AlarmRecordActi.this.mUpdaterValue1();
                    break;
            }
        }
    };
    private String mTempStr = "";

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_biaozhi408_alarm_record);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(48, new int[]{252}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mTempStr = "";
        mStringBuffer.delete(0, mStringBuffer.length());
        removeNotify();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(48, new int[]{253}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[103];
        int total = DataCanbus.DATA[43];
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
            if (value == 252) {
                ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.diagnostic_start);
            } else if (value > -1 && value < 177) {
                if (DataCanbus.DATA[1000] == 118 && this.mTempStr != Callback_0118_XP1_BiaoZhi2008.mCarId) {
                    this.mTempStr = Callback_0118_XP1_BiaoZhi2008.mCarId;
                    mStringBuffer.append(this.mTempStr);
                    mStringBuffer.append("\n");
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(mStringBuffer.toString());
                }
                if (DataCanbus.DATA[1000] == 185 && this.mTempStr != Callback_0185_XP1_BiaoZhi408.mCarId) {
                    this.mTempStr = Callback_0185_XP1_BiaoZhi408.mCarId;
                    mStringBuffer.append(this.mTempStr);
                    mStringBuffer.append("\n");
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(mStringBuffer.toString());
                }
                if (DataCanbus.DATA[1000] == 278 && this.mTempStr != Callback_0278_XP1_BiaoZhi301.mCarId) {
                    this.mTempStr = Callback_0278_XP1_BiaoZhi301.mCarId;
                    mStringBuffer.append(this.mTempStr);
                    mStringBuffer.append("\n");
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(mStringBuffer.toString());
                }
                if ((DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 65817) && this.mTempStr != Callback_0281_XP_PSA_ALL.mCarId) {
                    this.mTempStr = Callback_0281_XP_PSA_ALL.mCarId;
                    mStringBuffer.append(this.mTempStr);
                    mStringBuffer.append("\n");
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(mStringBuffer.toString());
                }
            } else if (value == 253) {
                ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.diagnostic_end);
            }
            if (total == 0) {
                ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_0);
            }
            return;
        }
        if (((TextView) findViewById(R.id.bz408_tv_alarm)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_1);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_4);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_5);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_8);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_a);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_b);
                    break;
                case 13:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_d);
                    break;
                case 15:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_f);
                    break;
                case 17:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_11);
                    break;
                case 18:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_12);
                    break;
                case 19:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_13);
                    break;
                case 20:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_14);
                    break;
                case 97:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_61);
                    break;
                case 98:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_62);
                    break;
                case 100:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_64);
                    break;
                case 103:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_67);
                    break;
                case 104:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_68);
                    break;
                case 105:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_69);
                    break;
                case 106:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_6a);
                    break;
                case 107:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_6b);
                    break;
                case 108:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_6c);
                    break;
                case 109:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_6d);
                    break;
                case 110:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_6e);
                    break;
                case 111:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_6f);
                    break;
                case 129:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_81);
                    break;
                case 131:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_83);
                    break;
                case 136:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_88);
                    break;
                case 137:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_89);
                    break;
                case 138:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_8a);
                    break;
                case 141:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_8d);
                    break;
                case 154:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_9a);
                    break;
                case 155:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_9b);
                    break;
                case 156:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_9c);
                    break;
                case 157:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_9d);
                    break;
                case 158:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_9e);
                    break;
                case 159:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_9f);
                    break;
                case 160:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_a0);
                    break;
                case 215:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_d7);
                    break;
                case 216:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_d8);
                    break;
                case 217:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_d9);
                    break;
                case 222:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_de);
                    break;
                case 223:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_df);
                    break;
                case 225:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_e1);
                    break;
                case 227:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_e3);
                    break;
                case 229:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_e5);
                    break;
                case 231:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_e7);
                    break;
                case 232:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_e8);
                    break;
                case 240:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_f0);
                    break;
                case 241:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_f1);
                    break;
                case 247:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_f7);
                    break;
                case 248:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_f8);
                    break;
                case 249:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_f9);
                    break;
                case 303:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_12f);
                    break;
                case 304:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_130);
                    break;
                case 305:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_131);
                    break;
                case 306:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_132);
                    break;
                case 307:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_133);
                    break;
                case 308:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_134);
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_RIGHT /* 506 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_1fa);
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_FRONT /* 507 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_1fb);
                    break;
                case ConstRzcAddData.U_CAR_LIGHT_REAR /* 508 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_1fc);
                    break;
                case ConstRzcAddData.U_CAR_WIPER_LEV /* 509 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_1fd);
                    break;
                case ConstRzcAddData.U_CAR_CUR_SPEED /* 510 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_1fe);
                    break;
                case ConstRzcAddData.U_CAR_AVG_SPEED /* 511 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_1ff);
                    break;
                case ConstRzcAddData.U_CAR_TOTAL_MILEAGE /* 512 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_200);
                    break;
                case ConstRzcAddData.U_CAR_SEAT_BELT_LEFT /* 514 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_202);
                    break;
                case ConstRzcAddData.U_CAR_SEAT_BELT_RIGHT /* 515 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_203);
                    break;
                case ConstRzcAddData.U_CAR_ACCON /* 516 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_204);
                    break;
                case ConstRzcAddData.U_CAR_LIGHT /* 517 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_205);
                    break;
                case ConstRzcAddData.U_CAR_REAR_BACK /* 518 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_206);
                    break;
                case ConstRzcAddData.U_CAR_AVG_FUEL /* 521 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_209);
                    break;
                case ConstRzcAddData.U_CAR_TEMP_WATER /* 522 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_20a);
                    break;
                case ConstRzcAddData.U_CAR_TEMP_MOTOR_OIL /* 523 */:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_20b);
                    break;
                case 32767:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.bz408_warning_7fff);
                    break;
                default:
                    ((TextView) findViewById(R.id.bz408_tv_alarm)).setText(R.string.start_stop_warning_14);
                    break;
            }
        }
    }
}
