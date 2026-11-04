package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZCJeepAccessoryGaugesAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.RZCJeepAccessoryGaugesAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 261:
                    if (((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text1)) != null) {
                        int unit = DataCanbus.DATA[153];
                        int temp = value - 40;
                        if (unit == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(((temp * 9) / 5) + 32) + "℉");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        } else {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(temp) + "℃");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        }
                    }
                    break;
                case 262:
                    if (((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text2)) != null) {
                        int unit2 = DataCanbus.DATA[153];
                        int temp2 = value - 40;
                        if (unit2 == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(((temp2 * 9) / 5) + 32) + "℉");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                        } else {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(temp2) + "℃");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                        }
                    }
                    break;
                case 263:
                    if (((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + "V");
                        ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar5)).setProgress(value);
                        ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar5)).invalidate();
                    }
                    break;
                case 264:
                    if (((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text3)) != null) {
                        int unit3 = DataCanbus.DATA[153];
                        int temp3 = value - 40;
                        if (unit3 == 1 || SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(((temp3 * 9) / 5) + 32) + "℉");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar3)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar3)).invalidate();
                        } else {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp3) + "℃");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar3)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar3)).invalidate();
                        }
                    }
                    break;
                case 265:
                    if (((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text4)) != null) {
                        int TireUnit = DataCanbus.DATA[152];
                        int temp4 = value * 4;
                        if (TireUnit == 1) {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(temp4) + "Kpa");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                        } else if (TireUnit == 0) {
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(temp4 / 100) + "." + ((temp4 % 100) / 10) + "bar");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                        } else {
                            int temp5 = (temp4 * 10000) / 6895;
                            ((TextView) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(temp5 / 10) + "." + (temp5 % 10) + "psi");
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar4)).setProgress(value);
                            ((ProgressBar) RZCJeepAccessoryGaugesAct.this.findViewById(R.id.pa_jeep_seekbar4)).invalidate();
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_jeep_accessory_gauges);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{52}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }
}
