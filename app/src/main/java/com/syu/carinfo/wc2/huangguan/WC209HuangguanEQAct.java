package com.syu.carinfo.wc2.huangguan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC209HuangguanEQAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.huangguan.WC209HuangguanEQAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 23:
                    WC209HuangguanEQAct.this.updateCarEQVol();
                    break;
                case 24:
                    WC209HuangguanEQAct.this.updateCarEQBal();
                    break;
                case 25:
                    WC209HuangguanEQAct.this.updateCarEQFad();
                    break;
                case 26:
                    WC209HuangguanEQAct.this.updateCarEQBass();
                    break;
                case 27:
                    WC209HuangguanEQAct.this.updateCarEQMid();
                    break;
                case 28:
                    WC209HuangguanEQAct.this.updateCarEQTre();
                    break;
                case 29:
                    WC209HuangguanEQAct.this.updateCarEQSpeedVol();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_09huangguan_eqsettings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_wc2_09huangguan_volbyspeed), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_vol_minus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_vol_plus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_bal_minus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_bal_plus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_fad_minus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_fad_plus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_bass_minus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_bass_plus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_mid_minus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_mid_plus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_tre_minus), this);
        setSelfClick((Button) findViewById(R.id.wc2_09huangguan_btn_tre_plus), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_wc2_09huangguan_volbyspeed /* 2131428509 */:
                int value = DataCanbus.DATA[29];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(7, value);
                break;
            case R.id.wc2_09huangguan_btn_vol_minus /* 2131428510 */:
                int i = DataCanbus.DATA[23];
                setCarInfo(1, 255);
                break;
            case R.id.wc2_09huangguan_btn_vol_plus /* 2131428512 */:
                int i2 = DataCanbus.DATA[23];
                setCarInfo(1, 1);
                break;
            case R.id.wc2_09huangguan_btn_bal_minus /* 2131428513 */:
                int value2 = DataCanbus.DATA[24];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(2, value2);
                break;
            case R.id.wc2_09huangguan_btn_bal_plus /* 2131428515 */:
                int value3 = DataCanbus.DATA[24];
                if (value3 < 14) {
                    value3++;
                }
                setCarInfo(2, value3);
                break;
            case R.id.wc2_09huangguan_btn_fad_minus /* 2131428516 */:
                int value4 = DataCanbus.DATA[25];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(3, value4);
                break;
            case R.id.wc2_09huangguan_btn_fad_plus /* 2131428518 */:
                int value5 = DataCanbus.DATA[25];
                if (value5 < 14) {
                    value5++;
                }
                setCarInfo(3, value5);
                break;
            case R.id.wc2_09huangguan_btn_bass_minus /* 2131428519 */:
                int value6 = DataCanbus.DATA[26];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(4, value6);
                break;
            case R.id.wc2_09huangguan_btn_bass_plus /* 2131428521 */:
                int value7 = DataCanbus.DATA[26];
                if (value7 < 10) {
                    value7++;
                }
                setCarInfo(4, value7);
                break;
            case R.id.wc2_09huangguan_btn_mid_minus /* 2131428522 */:
                int value8 = DataCanbus.DATA[27];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(5, value8);
                break;
            case R.id.wc2_09huangguan_btn_mid_plus /* 2131428524 */:
                int value9 = DataCanbus.DATA[27];
                if (value9 < 10) {
                    value9++;
                }
                setCarInfo(5, value9);
                break;
            case R.id.wc2_09huangguan_btn_tre_minus /* 2131428525 */:
                int value10 = DataCanbus.DATA[28];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(6, value10);
                break;
            case R.id.wc2_09huangguan_btn_tre_plus /* 2131428527 */:
                int value11 = DataCanbus.DATA[28];
                if (value11 < 10) {
                    value11++;
                }
                setCarInfo(6, value11);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQSpeedVol() {
        int value = DataCanbus.DATA[29];
        ((CheckedTextView) findViewById(R.id.ctv_wc2_09huangguan_volbyspeed)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQTre() {
        int value = DataCanbus.DATA[28];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_tre_value)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_tre_value)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_tre_value)).setText("-" + (5 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQMid() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_mid_value)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_mid_value)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_mid_value)).setText("-" + (5 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQBass() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bass_value)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bass_value)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bass_value)).setText("-" + (5 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQFad() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_fad_value)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_fad_value)).setText("F" + (value - 7));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_fad_value)).setText("0");
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_fad_value)).setText("R" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQBal() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bal_value)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bal_value)).setText("R" + (value - 7));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bal_value)).setText("0");
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bal_value)).setText("L" + (7 - value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarEQVol() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_vol_value)) != null) {
            ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_vol_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
