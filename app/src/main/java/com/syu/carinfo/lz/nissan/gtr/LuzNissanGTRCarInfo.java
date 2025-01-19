package com.syu.carinfo.lz.nissan.gtr;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LuzNissanGTRCarInfo extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text6)).setText(value + "%");
                    break;
                case 100:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text7)).setText(value + "%");
                    break;
                case 101:
                    LuzNissanGTRCarInfo.this.mUpdateEgnOilTemp();
                    break;
                case 102:
                    LuzNissanGTRCarInfo.this.mUpdateTransOilTemp();
                    break;
                case 103:
                    if (DataCanbus.DATA[1000] == 2621895) {
                        int value2 = (value * 145) / 100;
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text10)).setText(value2 / 10 + "." + (value2 % 10) + " psi");
                        break;
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        int value3 = (value * 145) / 100;
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text10)).setText(value3 / 10 + "." + (value3 % 10) + " psi");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text10)).setText(value + " Kpa");
                        break;
                    }
                case 104:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text11)).setText(value + "%");
                    break;
                case 105:
                    if (DataCanbus.DATA[1000] == 2621895) {
                        if ((value & 32768) != 0) {
                            int value4 = ((65536 - value) * 145) / 100;
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText("-" + (value4 / 10) + "." + (value4 % 10) + " psi");
                            break;
                        } else {
                            int value5 = (value * 145) / 100;
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText(value5 / 10 + "." + (value5 % 10) + " psi");
                            break;
                        }
                    } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                        if ((value & 32768) != 0) {
                            int value6 = ((65536 - value) * 145) / 100;
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText("-" + (value6 / 10) + "." + (value6 % 10) + " psi");
                            break;
                        } else {
                            int value7 = (value * 145) / 100;
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText(value7 / 10 + "." + (value7 % 10) + " psi");
                            break;
                        }
                    } else if ((value & 32768) != 0) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText("-" + (65536 - value) + " Kpa");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text12)).setText(value + " Kpa");
                        break;
                    }
                case 106:
                    switch (value) {
                        case 0:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("P");
                            break;
                        case 1:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("R");
                            break;
                        case 2:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("N");
                            break;
                        case 3:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("1");
                            break;
                        case 4:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("2");
                            break;
                        case 5:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("3");
                            break;
                        case 6:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("4");
                            break;
                        case 7:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("5");
                            break;
                        case 8:
                            ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text13)).setText("6");
                            break;
                    }
                case 107:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text14)).setText(value + "%");
                    break;
                case 108:
                    LuzNissanGTRCarInfo.this.mUpdateWaterTemp();
                    break;
                case 109:
                    LuzNissanGTRCarInfo.this.mUpdateSpeed();
                    break;
                case 110:
                    LuzNissanGTRCarInfo.this.mUpdateMile();
                    break;
                case 111:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text4)).setText(value + " Rpm");
                    break;
                case 113:
                    LuzNissanGTRCarInfo.this.mUpdateTotalMile();
                    break;
                case 158:
                    if ((value & 128) != 0) {
                        int value8 = value & 127;
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text15)).setText("L:" + (value8 / 10) + "." + (value8 % 10));
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text15)).setText("R:" + (value / 10) + "." + (value % 10));
                        break;
                    }
                case 159:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text16)).setText(value / 10 + "." + (value % 10));
                    break;
                case 160:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text17)).setText(value / 10 + "." + (value % 10));
                    break;
                case 161:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text18)).setText(value + "%");
                    break;
                case 162:
                    ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text19)).setText(String.valueOf(value));
                    break;
                case 163:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text20)).setText("ON");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text20)).setText("OFF");
                        break;
                    }
                case 164:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text21)).setText("ON");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text21)).setText("OFF");
                        break;
                    }
                case 165:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text22)).setText(R.string.str_driving_comfort);
                        break;
                    } else if (value == 2) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text22)).setText(R.string.str_driving_sport);
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text22)).setText(R.string.str_driving_normal);
                        break;
                    }
                case 166:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text23)).setText("once");
                        break;
                    } else if (value == 2) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text23)).setText("trigger");
                        break;
                    } else if (value == 3) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text23)).setText("fast");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text23)).setText(R.string.off);
                        break;
                    }
                case 167:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text24)).setText("ON");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text24)).setText("OFF");
                        break;
                    }
                case 168:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text25)).setText("ON");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text25)).setText("OFF");
                        break;
                    }
                case 169:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text26)).setText("ON");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text26)).setText("OFF");
                        break;
                    }
                case 170:
                    if (value == 1) {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text27)).setText("ON");
                        break;
                    } else {
                        ((TextView) LuzNissanGTRCarInfo.this.findViewById(R.id.tv_text27)).setText("OFF");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_nissan_gtr_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{52}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{51}, null, null);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
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
    }

    
    public void mUpdateTransOilTemp() {
        int value = DataCanbus.DATA[102];
        if (DataCanbus.DATA[1000] == 2621895) {
            if (value >= 40) {
                ((TextView) findViewById(R.id.tv_text9)).setText(value - 40 + " ℃");
                return;
            }
            ((TextView) findViewById(R.id.tv_text9)).setText("-" + (40 - value) + " ℃");
            return;
        }
        if (value >= 40) {
            int value2 = value - 40;
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(((value2 * 9) / 5) + 32 + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text9)).setText(value2 + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("-" + (((value3 * 9) / 5) + 32) + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text9)).setText("-" + value3 + " ℃");
        }
    }

    
    public void mUpdateEgnOilTemp() {
        int value = DataCanbus.DATA[101];
        if (DataCanbus.DATA[1000] == 2621895) {
            if (value >= 40) {
                ((TextView) findViewById(R.id.tv_text8)).setText(value - 40 + " ℃");
                return;
            }
            ((TextView) findViewById(R.id.tv_text8)).setText("-" + (40 - value) + " ℃");
            return;
        }
        if (value >= 40) {
            int value2 = value - 40;
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(((value2 * 9) / 5) + 32 + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(value2 + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setText("-" + (((value3 * 9) / 5) + 32) + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setText("-" + value3 + " ℃");
        }
    }

    
    public void mUpdateWaterTemp() {
        int value = DataCanbus.DATA[108];
        if (DataCanbus.DATA[1000] == 2621895) {
            if (value >= 40) {
                ((TextView) findViewById(R.id.tv_text1)).setText(value - 40 + " ℃");
                return;
            }
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + (40 - value) + " ℃");
            return;
        }
        if (value >= 40) {
            int value2 = value - 40;
            if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(((value2 * 9) / 5) + 32 + " ℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(value2 + " ℃");
                return;
            }
        }
        int value3 = 40 - value;
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + (((value3 * 9) / 5) + 32) + " ℉");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + value3 + " ℃");
        }
    }

    
    public void mUpdateSpeed() {
        int value = DataCanbus.DATA[109];
        if (DataCanbus.DATA[1000] == 2621895) {
            ((TextView) findViewById(R.id.tv_text2)).setText((value * 10) / 16 + " mph");
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText((value * 10) / 16 + " mph");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(value + " km/h");
        }
    }

    
    public void mUpdateMile() {
        int value = DataCanbus.DATA[110];
        if (DataCanbus.DATA[1000] == 2621895) {
            ((TextView) findViewById(R.id.tv_text3)).setText((value * 10) / 16 + " Mil");
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText((value * 10) / 16 + " Mil");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(value + " Km");
        }
    }

    
    public void mUpdateTotalMile() {
        int value = DataCanbus.DATA[113];
        if (DataCanbus.DATA[1000] == 2621895) {
            ((TextView) findViewById(R.id.tv_text5)).setText((value * 10) / 16 + " Mil");
        } else if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText((value * 10) / 16 + " Mil");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(value + " Km");
        }
    }
}
