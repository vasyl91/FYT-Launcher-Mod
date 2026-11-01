package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class AirActi_TuRui extends BaseActivity {
    public static AirActi_TuRui mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.AirActi_TuRui.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    AirActi_TuRui.this.mUpdaterAirPowerOn();
                    AirActi_TuRui.this.mUpdaterAirTempLeft();
                    AirActi_TuRui.this.mUpdaterBlowUpLeftOn();
                    AirActi_TuRui.this.mUpdaterBlowBodyLeftOn();
                    AirActi_TuRui.this.mUpdaterBlowUpFootLeftOn();
                    AirActi_TuRui.this.mUpdaterAirTempRight();
                    AirActi_TuRui.this.mUpdaterBlowUpRightOn();
                    AirActi_TuRui.this.mUpdaterBlowUpRightOn();
                    AirActi_TuRui.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 13:
                    AirActi_TuRui.this.mUpdaterAirAutoOn();
                    break;
                case 18:
                    AirActi_TuRui.this.mUpdaterBlowUpLeftOn();
                    AirActi_TuRui.this.mUpdaterBlowUpRightOn();
                    break;
                case 19:
                    AirActi_TuRui.this.mUpdaterBlowBodyLeftOn();
                    AirActi_TuRui.this.mUpdaterBlowBodyRightOn();
                    break;
                case 20:
                    AirActi_TuRui.this.mUpdaterBlowUpFootLeftOn();
                    AirActi_TuRui.this.mUpdaterBlowFootRightOn();
                    break;
                case 27:
                    AirActi_TuRui.this.mUpdaterAirTempLeft();
                    AirActi_TuRui.this.mUpdaterBlowUpLeftOn();
                    AirActi_TuRui.this.mUpdaterBlowBodyLeftOn();
                    AirActi_TuRui.this.mUpdaterBlowUpFootLeftOn();
                    break;
                case 28:
                    AirActi_TuRui.this.mUpdaterAirTempRight();
                    AirActi_TuRui.this.mUpdaterBlowUpRightOn();
                    AirActi_TuRui.this.mUpdaterBlowUpRightOn();
                    AirActi_TuRui.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 37:
                    AirActi_TuRui.this.mUpdaterAirTempRight();
                    AirActi_TuRui.this.mUpdaterAirTempLeft();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_air);
        init();
        AirHelper.disableAirWindowLocal(true);
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.golf7_air_btn_power)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.AirActi_TuRui.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[10] != 0) {
                    DataCanbus.PROXY.cmd(38, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(38, new int[]{1}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPowerOn() {
        if (((Button) findViewById(R.id.golf7_air_btn_power)) != null) {
            ((Button) findViewById(R.id.golf7_air_btn_power)).setText(DataCanbus.DATA[10] == 0 ? "OFF" : "ON");
            ((TextView) findViewById(R.id.golf7_air_temp_left)).setText("");
            ((TextView) findViewById(R.id.golf7_air_auto)).setText("");
            ((TextView) findViewById(R.id.golf7_air_temp_right)).setText("");
            ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAutoOn() {
        if (((TextView) findViewById(R.id.golf7_air_auto)) != null) {
            if (DataCanbus.DATA[10] != 0 && DataCanbus.DATA[13] != 0) {
                ((TextView) findViewById(R.id.golf7_air_auto)).setText("AUTO");
            } else {
                ((TextView) findViewById(R.id.golf7_air_auto)).setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.golf7_air_temp_left)) != null) {
            if (DataCanbus.DATA[10] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setText("LOW");
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-1);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                        return;
                    }
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setText("HI");
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-65536);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                        return;
                    }
                    return;
                }
                if (unit == 1) {
                    int temp2 = temp + 59;
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setText(temp2 + "F");
                    if (temp2 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-65536);
                        if (DataCanbus.DATA[18] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                        }
                        if (DataCanbus.DATA[19] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                            ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                        }
                        if (DataCanbus.DATA[20] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                            return;
                        }
                        return;
                    }
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-1);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                        return;
                    }
                    return;
                }
                int temp3 = (temp * 5) + 155;
                ((TextView) findViewById(R.id.golf7_air_temp_left)).setText((temp3 / 10.0f) + "°C");
                if (temp3 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-65536);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-1);
                if (DataCanbus.DATA[18] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                }
                if (DataCanbus.DATA[19] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                }
                if (DataCanbus.DATA[20] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                    return;
                }
                return;
            }
            ((TextView) findViewById(R.id.golf7_air_temp_left)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.golf7_air_temp_right)) != null) {
            if (DataCanbus.DATA[10] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setText("LOW");
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-1);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                        return;
                    }
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setText("HI");
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-65536);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                        return;
                    }
                    return;
                }
                if (unit == 1) {
                    int temp2 = temp + 59;
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setText(temp2 + "F");
                    if (temp2 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-65536);
                        if (DataCanbus.DATA[18] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                        }
                        if (DataCanbus.DATA[19] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                            ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                        }
                        if (DataCanbus.DATA[20] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                            return;
                        }
                        return;
                    }
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-1);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                        return;
                    }
                    return;
                }
                int temp3 = (temp * 5) + 155;
                ((TextView) findViewById(R.id.golf7_air_temp_right)).setText((temp3 / 10.0f) + "°C");
                if (temp3 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-65536);
                    if (DataCanbus.DATA[18] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                    }
                    if (DataCanbus.DATA[19] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                    }
                    if (DataCanbus.DATA[20] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-1);
                if (DataCanbus.DATA[18] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                }
                if (DataCanbus.DATA[19] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                }
                if (DataCanbus.DATA[20] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                    return;
                }
                return;
            }
            ((TextView) findViewById(R.id.golf7_air_temp_right)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowUpLeftOn() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.golf7_air_blow_up_left)) != null) {
            if (DataCanbus.DATA[10] != 0 && DataCanbus.DATA[18] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                    return;
                }
                if (unit == 1) {
                    if (temp + 59 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                        return;
                    }
                }
                if ((temp * 5) + 155 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                    return;
                }
            }
            ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyLeftOn() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.golf7_air_blow_body_left1)) != null && ((TextView) findViewById(R.id.golf7_air_blow_body_left2)) != null) {
            if (DataCanbus.DATA[10] != 0 && DataCanbus.DATA[19] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                    return;
                }
                if (unit == 1) {
                    if (temp + 59 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                        return;
                    }
                }
                if ((temp * 5) + 155 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                    return;
                }
            }
            ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowUpFootLeftOn() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.golf7_air_blow_foot_left)) != null) {
            if (DataCanbus.DATA[10] != 0 && DataCanbus.DATA[20] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                    return;
                }
                if (unit == 1) {
                    if (temp + 59 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                        return;
                    }
                }
                if ((temp * 5) + 155 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                    return;
                }
            }
            ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowUpRightOn() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.golf7_air_blow_up_right)) != null) {
            if (DataCanbus.DATA[10] != 0 && DataCanbus.DATA[18] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                    return;
                }
                if (unit == 1) {
                    if (temp + 59 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                        return;
                    }
                }
                if ((temp * 5) + 155 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                    return;
                }
            }
            ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyRightOn() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.golf7_air_blow_body_right1)) != null && ((TextView) findViewById(R.id.golf7_air_blow_body_right2)) != null) {
            if (DataCanbus.DATA[10] != 0 && DataCanbus.DATA[19] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                    return;
                }
                if (unit == 1) {
                    if (temp + 59 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                        return;
                    }
                }
                if ((temp * 5) + 155 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                    return;
                }
            }
            ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundColor(0);
            ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootRightOn() {
        int unit = DataCanbus.DATA[37];
        int temp = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.golf7_air_blow_foot_right)) != null) {
            if (DataCanbus.DATA[10] != 0 && DataCanbus.DATA[20] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                    return;
                }
                if (unit == 1) {
                    if (temp + 59 > 72) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                        return;
                    }
                }
                if ((temp * 5) + 155 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                    return;
                }
            }
            ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundColor(0);
        }
    }
}
