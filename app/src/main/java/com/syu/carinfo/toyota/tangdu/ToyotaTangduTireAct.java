package com.syu.carinfo.toyota.tangdu;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ToyotaTangduTireAct extends BaseActivity {
    public static ToyotaTangduTireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.toyota.tangdu.ToyotaTangduTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    ToyotaTangduTireAct.this.mUpdaterExistTpms();
                    break;
                case 101:
                    ToyotaTangduTireAct.this.mUpdaterShowTireBackup();
                    break;
                case 102:
                    ToyotaTangduTireAct.this.mUpdaterExistTpms();
                    break;
                case 103:
                    ToyotaTangduTireAct.this.mUpdaterTireFL();
                    break;
                case 104:
                    ToyotaTangduTireAct.this.mUpdaterTireFR();
                    break;
                case 105:
                    ToyotaTangduTireAct.this.mUpdaterTireRL();
                    break;
                case 106:
                    ToyotaTangduTireAct.this.mUpdaterTireRR();
                    break;
                case 107:
                    ToyotaTangduTireAct.this.mUpdaterTireBackup();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        mInit = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[103];
        int unit = (value >> 24) & 255;
        float num = 16777215 & value;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_0)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_0)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("BAR");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("BAR");
                if (num != 1.6777215E7f) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num / 10.0f)), Integer.valueOf((int) (num % 10.0f))));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) (num / 10.0f)), Integer.valueOf((int) (num % 10.0f))));
                    return;
                }
                return;
            }
            if (unit == 1) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("PSI");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("PSI");
                if (num != 1.6777215E7f) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d", Integer.valueOf((int) num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d", Integer.valueOf((int) num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("KPA");
                if (num != 1.6777215E7f) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) ((num * 25.0f) / 10.0f)), Integer.valueOf((int) ((num * 25.0f) % 10.0f))));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_0)).setText(String.format("%d.%d", Integer.valueOf((int) ((num * 25.0f) / 10.0f)), Integer.valueOf((int) ((num * 25.0f) % 10.0f))));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[104];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_1)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_1)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("BAR");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("BAR");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("PSI");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("PSI");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("KPA");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_1)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[105];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_2)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_2)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("BAR");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("BAR");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("PSI");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("PSI");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("KPA");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_2)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[106];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_3)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_3)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("BAR");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("BAR");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("PSI");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("PSI");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("KPA");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_3)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireBackup() {
        int value = DataCanbus.DATA[107];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        if (((TextView) findViewById(R.id.camry_tv_car_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_car_tire_unit)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_unit)) != null) {
            if (unit == 0) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("BAR");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("BAR");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10)));
                    return;
                }
                return;
            }
            if (unit == 1) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("PSI");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("PSI");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d", Integer.valueOf(num)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d", Integer.valueOf(num)));
                    return;
                }
                return;
            }
            if (unit == 2) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
                ((TextView) findViewById(R.id.camry_tv_line_tire_unit)).setText("KPA");
                if (num != 16777215) {
                    ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                    ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setText(String.format("%d.%d", Integer.valueOf((num * 25) / 10), Integer.valueOf((num * 25) % 10)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterExistTpms() {
        int existTpms = DataCanbus.DATA[99];
        int type = DataCanbus.DATA[102];
        if (findViewById(R.id.camry_layout_car) != null && findViewById(R.id.camry_layout_line) != null && findViewById(R.id.camry_layout_none) != null) {
            if (existTpms == 0) {
                findViewById(R.id.camry_layout_car).setVisibility(8);
                findViewById(R.id.camry_layout_line).setVisibility(8);
                findViewById(R.id.camry_layout_none).setVisibility(0);
            } else if (existTpms == 1) {
                if (type == 0) {
                    findViewById(R.id.camry_layout_car).setVisibility(8);
                    findViewById(R.id.camry_layout_line).setVisibility(0);
                    findViewById(R.id.camry_layout_none).setVisibility(8);
                } else if (type == 1) {
                    findViewById(R.id.camry_layout_car).setVisibility(0);
                    findViewById(R.id.camry_layout_line).setVisibility(8);
                    findViewById(R.id.camry_layout_none).setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterShowTireBackup() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.camry_tv_car_tire_4)) != null && ((TextView) findViewById(R.id.camry_tv_line_tire_4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setVisibility(8);
                ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setVisibility(8);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.camry_tv_car_tire_4)).setVisibility(0);
                ((TextView) findViewById(R.id.camry_tv_line_tire_4)).setVisibility(0);
            }
        }
    }
}