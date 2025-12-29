package com.syu.carinfo.xbs.tianlai;

import android.os.Bundle;
import android.SystemProperties;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_XBS_09Tianlai;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBS09TianlaiCarRadioAct extends BaseActivity {
    public static XBS09TianlaiCarRadioAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 100:
                        XBS09TianlaiCarRadioAct.this.updaterRadioRdsOnOff();
                        break;
                    case 101:
                        XBS09TianlaiCarRadioAct.this.updaterRadioSCANOnOff();
                        break;
                    case 102:
                        XBS09TianlaiCarRadioAct.this.updaterRadioSTOnOff();
                        break;
                    case 103:
                        XBS09TianlaiCarRadioAct.this.updaterRadioAUTOOnOff();
                        break;
                    case 104:
                        XBS09TianlaiCarRadioAct.this.updaterRadioText();
                        break;
                    case 105:
                        XBS09TianlaiCarRadioAct.this.updaterRadioBand();
                        break;
                    case 107:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq();
                        break;
                    case 108:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq1();
                        break;
                    case 109:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq2();
                        break;
                    case 110:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq3();
                        break;
                    case 111:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq4();
                        break;
                    case 112:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq5();
                        break;
                    case 113:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq6();
                        break;
                }
            }
            switch (updateCode) {
                case 100:
                    XBS09TianlaiCarRadioAct.this.updaterRadioRdsOnOff();
                    break;
                case 101:
                    XBS09TianlaiCarRadioAct.this.updaterRadioSCANOnOff();
                    break;
                case 102:
                    XBS09TianlaiCarRadioAct.this.updaterRadioSTOnOff();
                    break;
                case 103:
                    XBS09TianlaiCarRadioAct.this.updaterRadioAUTOOnOff();
                    break;
                case 104:
                    XBS09TianlaiCarRadioAct.this.updaterRadioText();
                    break;
                case 105:
                    XBS09TianlaiCarRadioAct.this.updaterRadioBand();
                    break;
                case 107:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq();
                    break;
                case 108:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq1();
                    break;
                case 109:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq2();
                    break;
                case 110:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq3();
                    break;
                case 111:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq4();
                    break;
                case 112:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq5();
                    break;
                case 113:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq6();
                    break;
            }
        }
    };
    int radioband = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
                //setContentView(R.layout.layout_xbs_09tianlai_carradio_9853);
            } else {
                //setContentView(R.layout.layout_xbs_09tianlai_carradio);
            }
        } else {
            //setContentView(R.layout.layout_xbs_09tianlai_carradio);
        }
        mInstance = this;
        init();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterRadioText() {
        int value = DataCanbus.DATA[104];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[104];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.radio_text)).setText(Callback_0439_XBS_09Tianlai.CarRadioText);
        } else {
            ((TextView) findViewById(R.id.radio_text)).setText("--------");
        }
    }

    
    public void updaterRadioFreq6() {
        int value;
        int value2 = DataCanbus.DATA[113];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[113];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq5() {
        int value;
        int value2 = DataCanbus.DATA[112];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[112];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq4() {
        int value;
        int value2 = DataCanbus.DATA[111];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[111];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq3() {
        int value;
        int value2 = DataCanbus.DATA[110];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[110];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq2() {
        int value;
        int value2 = DataCanbus.DATA[109];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[109];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq1() {
        int value;
        int value2 = DataCanbus.DATA[108];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[108];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    
    public void updaterRadioFreq() {
        int value;
        int value2 = DataCanbus.DATA[107];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[107];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder(String.valueOf(value)).toString());
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100));
                break;
        }
    }

    
    public void updaterRadioBand() {
        this.radioband = DataCanbus.DATA[105];
        if (DataCanbus.DATA[1000] == 458942) {
            this.radioband = DataCanbus.DATA[105];
        }
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm3");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
        }
    }

    
    public void updaterRadioAUTOOnOff() {
        int value = DataCanbus.DATA[103];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[103];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_auto)).setText("AUTO:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_auto)).setText("AUTO:Off");
                break;
        }
    }

    
    public void updaterRadioSTOnOff() {
        int value = DataCanbus.DATA[102];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[102];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_st)).setText("ST:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_st)).setText("ST:Off");
                break;
        }
    }

    
    public void updaterRadioSCANOnOff() {
        int value = DataCanbus.DATA[101];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[101];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_scan)).setText("SCAN:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_scan)).setText("SCAN:Off");
                break;
        }
    }

    
    public void updaterRadioRdsOnOff() {
        int value = DataCanbus.DATA[100];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[100];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_rds)).setText("RDS:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_rds)).setText("RDS:Off");
                break;
        }
    }
}
