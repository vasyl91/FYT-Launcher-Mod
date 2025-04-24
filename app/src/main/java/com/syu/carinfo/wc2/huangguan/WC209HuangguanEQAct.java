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

@SuppressWarnings({"deprecation", "unchecked"})
public class WC209HuangguanEQAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    WC209HuangguanEQAct.this.updateCarEQVol();
                    break;
                case 99:
                    WC209HuangguanEQAct.this.updateCarEQBal();
                    break;
                case 100:
                    WC209HuangguanEQAct.this.updateCarEQFad();
                    break;
                case 101:
                    WC209HuangguanEQAct.this.updateCarEQBass();
                    break;
                case 102:
                    WC209HuangguanEQAct.this.updateCarEQMid();
                    break;
                case 103:
                    WC209HuangguanEQAct.this.updateCarEQTre();
                    break;
                case 104:
                    WC209HuangguanEQAct.this.updateCarEQSpeedVol();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_09huangguan_eqsettings);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_wc2_09huangguan_volbyspeed /* 2131428515 */:
                int value = DataCanbus.DATA[104];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(7, value);
                break;
            case R.id.wc2_09huangguan_btn_vol_minus /* 2131428516 */:
                int i = DataCanbus.DATA[98];
                setCarInfo(1, 255);
                break;
            case R.id.wc2_09huangguan_btn_vol_plus /* 2131428518 */:
                int i2 = DataCanbus.DATA[98];
                setCarInfo(1, 1);
                break;
            case R.id.wc2_09huangguan_btn_bal_minus /* 2131428519 */:
                int value2 = DataCanbus.DATA[99];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(2, value2);
                break;
            case R.id.wc2_09huangguan_btn_bal_plus /* 2131428521 */:
                int value3 = DataCanbus.DATA[99];
                if (value3 < 14) {
                    value3++;
                }
                setCarInfo(2, value3);
                break;
            case R.id.wc2_09huangguan_btn_fad_minus /* 2131428522 */:
                int value4 = DataCanbus.DATA[100];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(3, value4);
                break;
            case R.id.wc2_09huangguan_btn_fad_plus /* 2131428524 */:
                int value5 = DataCanbus.DATA[100];
                if (value5 < 14) {
                    value5++;
                }
                setCarInfo(3, value5);
                break;
            case R.id.wc2_09huangguan_btn_bass_minus /* 2131428525 */:
                int value6 = DataCanbus.DATA[101];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(4, value6);
                break;
            case R.id.wc2_09huangguan_btn_bass_plus /* 2131428527 */:
                int value7 = DataCanbus.DATA[101];
                if (value7 < 10) {
                    value7++;
                }
                setCarInfo(4, value7);
                break;
            case R.id.wc2_09huangguan_btn_mid_minus /* 2131428528 */:
                int value8 = DataCanbus.DATA[102];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(5, value8);
                break;
            case R.id.wc2_09huangguan_btn_mid_plus /* 2131428530 */:
                int value9 = DataCanbus.DATA[102];
                if (value9 < 10) {
                    value9++;
                }
                setCarInfo(5, value9);
                break;
            case R.id.wc2_09huangguan_btn_tre_minus /* 2131428531 */:
                int value10 = DataCanbus.DATA[103];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(6, value10);
                break;
            case R.id.wc2_09huangguan_btn_tre_plus /* 2131428533 */:
                int value11 = DataCanbus.DATA[103];
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarEQSpeedVol() {
        int value = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.ctv_wc2_09huangguan_volbyspeed)).setChecked(value == 1);
    }

    
    public void updateCarEQTre() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_tre_value)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_tre_value)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_tre_value)).setText("-" + (5 - value));
            }
        }
    }

    
    public void updateCarEQMid() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_mid_value)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_mid_value)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_mid_value)).setText("-" + (5 - value));
            }
        }
    }

    
    public void updateCarEQBass() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bass_value)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bass_value)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_bass_value)).setText("-" + (5 - value));
            }
        }
    }

    
    public void updateCarEQFad() {
        int value = DataCanbus.DATA[100];
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

    
    public void updateCarEQBal() {
        int value = DataCanbus.DATA[99];
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

    
    public void updateCarEQVol() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_vol_value)) != null) {
            ((TextView) findViewById(R.id.tv_wc2_09huangguan_btn_vol_value)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
