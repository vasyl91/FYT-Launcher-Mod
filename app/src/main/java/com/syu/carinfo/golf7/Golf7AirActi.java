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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7AirActi extends BaseActivity {
    public static Golf7AirActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7AirActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 89:
                    Golf7AirActi.this.mUpdaterAirAutoOn();
                    break;
                case 94:
                    Golf7AirActi.this.mUpdaterBlowUpLeftOn();
                    Golf7AirActi.this.mUpdaterBlowUpRightOn();
                    break;
                case 95:
                    Golf7AirActi.this.mUpdaterBlowBodyLeftOn();
                    Golf7AirActi.this.mUpdaterBlowBodyRightOn();
                    break;
                case 96:
                    Golf7AirActi.this.mUpdaterBlowUpFootLeftOn();
                    Golf7AirActi.this.mUpdaterBlowFootRightOn();
                    break;
                case 98:
                    Golf7AirActi.this.mUpdaterAirTempLeft();
                    Golf7AirActi.this.mUpdaterBlowUpLeftOn();
                    Golf7AirActi.this.mUpdaterBlowBodyLeftOn();
                    Golf7AirActi.this.mUpdaterBlowUpFootLeftOn();
                    break;
                case 99:
                    Golf7AirActi.this.mUpdaterAirTempRight();
                    Golf7AirActi.this.mUpdaterBlowUpRightOn();
                    Golf7AirActi.this.mUpdaterBlowUpRightOn();
                    Golf7AirActi.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 103:
                    Golf7AirActi.this.mUpdaterAirTempRight();
                    Golf7AirActi.this.mUpdaterAirTempLeft();
                    break;
                case 105:
                    Golf7AirActi.this.mUpdaterAirPowerOn();
                    Golf7AirActi.this.mUpdaterAirTempLeft();
                    Golf7AirActi.this.mUpdaterBlowUpLeftOn();
                    Golf7AirActi.this.mUpdaterBlowBodyLeftOn();
                    Golf7AirActi.this.mUpdaterBlowUpFootLeftOn();
                    Golf7AirActi.this.mUpdaterAirTempRight();
                    Golf7AirActi.this.mUpdaterBlowUpRightOn();
                    Golf7AirActi.this.mUpdaterBlowUpRightOn();
                    Golf7AirActi.this.mUpdaterBlowBodyLeftOn();
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
        ((Button) findViewById(R.id.golf7_air_btn_power)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7AirActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[105] != 0) {
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPowerOn() {
        if (((Button) findViewById(R.id.golf7_air_btn_power)) != null) {
            ((Button) findViewById(R.id.golf7_air_btn_power)).setText(DataCanbus.DATA[105] == 0 ? "OFF" : "ON");
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
            if (DataCanbus.DATA[105] != 0 && DataCanbus.DATA[89] != 0) {
                ((TextView) findViewById(R.id.golf7_air_auto)).setText("AUTO");
            } else {
                ((TextView) findViewById(R.id.golf7_air_auto)).setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.golf7_air_temp_left)) != null) {
            if (DataCanbus.DATA[105] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setText("LOW");
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-1);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                    }
                    if (DataCanbus.DATA[96] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                        return;
                    }
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setText("HI");
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-65536);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                    }
                    if (DataCanbus.DATA[96] != 0) {
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
                        if (DataCanbus.DATA[94] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                        }
                        if (DataCanbus.DATA[95] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                            ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                        }
                        if (DataCanbus.DATA[96] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                            return;
                        }
                        return;
                    }
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-1);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                    }
                    if (DataCanbus.DATA[96] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_l);
                        return;
                    }
                    return;
                }
                int temp3 = (temp * 5) + 155;
                ((TextView) findViewById(R.id.golf7_air_temp_left)).setText((temp3 / 10.0f) + "°C");
                if (temp3 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-65536);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_h);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2h);
                    }
                    if (DataCanbus.DATA[96] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_foot_h);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.golf7_air_temp_left)).setTextColor(-1);
                if (DataCanbus.DATA[94] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_left)).setBackgroundResource(R.drawable.ic_golf7_blow_left_up_l);
                }
                if (DataCanbus.DATA[95] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left1)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_left2)).setBackgroundResource(R.drawable.ic_golf7_blow_left_body_2l);
                }
                if (DataCanbus.DATA[96] != 0) {
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
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.golf7_air_temp_right)) != null) {
            if (DataCanbus.DATA[105] != 0) {
                if (temp == 0) {
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setText("LOW");
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-1);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                    }
                    if (DataCanbus.DATA[96] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                        return;
                    }
                    return;
                }
                if (temp == 31) {
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setText("HI");
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-65536);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                    }
                    if (DataCanbus.DATA[96] != 0) {
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
                        if (DataCanbus.DATA[94] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                        }
                        if (DataCanbus.DATA[95] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                            ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                        }
                        if (DataCanbus.DATA[96] != 0) {
                            ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                            return;
                        }
                        return;
                    }
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-1);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                    }
                    if (DataCanbus.DATA[96] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_l);
                        return;
                    }
                    return;
                }
                int temp3 = (temp * 5) + 155;
                ((TextView) findViewById(R.id.golf7_air_temp_right)).setText((temp3 / 10.0f) + "°C");
                if (temp3 > 224) {
                    ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-65536);
                    if (DataCanbus.DATA[94] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_h);
                    }
                    if (DataCanbus.DATA[95] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1h);
                        ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2h);
                    }
                    if (DataCanbus.DATA[96] != 0) {
                        ((TextView) findViewById(R.id.golf7_air_blow_foot_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_foot_h);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById(R.id.golf7_air_temp_right)).setTextColor(-1);
                if (DataCanbus.DATA[94] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_up_right)).setBackgroundResource(R.drawable.ic_golf7_blow_right_up_l);
                }
                if (DataCanbus.DATA[95] != 0) {
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right1)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_1l);
                    ((TextView) findViewById(R.id.golf7_air_blow_body_right2)).setBackgroundResource(R.drawable.ic_golf7_blow_right_body_2l);
                }
                if (DataCanbus.DATA[96] != 0) {
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
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.golf7_air_blow_up_left)) != null) {
            if (DataCanbus.DATA[105] != 0 && DataCanbus.DATA[94] != 0) {
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
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.golf7_air_blow_body_left1)) != null && ((TextView) findViewById(R.id.golf7_air_blow_body_left2)) != null) {
            if (DataCanbus.DATA[105] != 0 && DataCanbus.DATA[95] != 0) {
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
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.golf7_air_blow_foot_left)) != null) {
            if (DataCanbus.DATA[105] != 0 && DataCanbus.DATA[96] != 0) {
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
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.golf7_air_blow_up_right)) != null) {
            if (DataCanbus.DATA[105] != 0 && DataCanbus.DATA[94] != 0) {
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
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.golf7_air_blow_body_right1)) != null && ((TextView) findViewById(R.id.golf7_air_blow_body_right2)) != null) {
            if (DataCanbus.DATA[105] != 0 && DataCanbus.DATA[95] != 0) {
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
        int unit = DataCanbus.DATA[103];
        int temp = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.golf7_air_blow_foot_right)) != null) {
            if (DataCanbus.DATA[105] != 0 && DataCanbus.DATA[96] != 0) {
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
