package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Act_CarCD_AoDeSai extends Activity {
    public static boolean mIsFront = false;
    private int timeAMPM;
    private int timeFormat;
    private int timeH;
    private int timeM;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Act_CarCD_AoDeSai.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    Act_CarCD_AoDeSai.this.uInfoTitleIndex(value);
                    break;
                case 117:
                    Act_CarCD_AoDeSai.this.uInfoHilight(value);
                    break;
                case 118:
                    Act_CarCD_AoDeSai.this.uInfoContent(strs != null ? strs[0] : "");
                    break;
                case 120:
                    Act_CarCD_AoDeSai.this.uCarVol(value);
                    break;
                case 121:
                    Act_CarCD_AoDeSai.this.uRadioAutoSelect(value);
                    break;
                case 122:
                    Act_CarCD_AoDeSai.this.uRadioSt(value);
                    break;
                case 123:
                    Act_CarCD_AoDeSai.this.uRadioScan(value);
                    break;
                case 124:
                    Act_CarCD_AoDeSai.this.uCDState(value);
                    break;
                case 125:
                    Act_CarCD_AoDeSai.this.uUSBState(value);
                    break;
                case 126:
                    Act_CarCD_AoDeSai.this.uPlayState(value);
                    break;
                case 127:
                    Act_CarCD_AoDeSai.this.uBtState(value);
                    break;
                case 130:
                    Act_CarCD_AoDeSai.this.uTimeFormat(value);
                    break;
                case 131:
                    Act_CarCD_AoDeSai.this.uTimeAMPM(value);
                    break;
                case 132:
                    Act_CarCD_AoDeSai.this.uTimeHour(value);
                    break;
                case 133:
                    Act_CarCD_AoDeSai.this.uTimeMinitus(value);
                    break;
            }
        }
    };
    private int titleIndex = 0;
    private int hilight = 0;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_298_bnr_09aodesai_carcd);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(150, 1);
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }

    protected void uTimeMinitus(int value2) {
        this.timeM = value2;
        udpateTime();
    }

    protected void uTimeHour(int value2) {
        this.timeH = value2;
        udpateTime();
    }

    protected void uTimeAMPM(int value2) {
        this.timeAMPM = value2;
        udpateTime();
    }

    protected void uTimeFormat(int value2) {
        this.timeFormat = value2;
        udpateTime();
    }

    private void udpateTime() {
        if (((TextView) findViewById(R.id.tv_time)) != null) {
            String str = String.valueOf(this.timeH) + ":" + this.timeM;
            if (this.timeFormat == 1) {
                str = String.valueOf(str) + (this.timeAMPM == 0 ? "AM" : "PM");
            }
            ((TextView) findViewById(R.id.tv_time)).setText(str);
        }
    }

    protected void uBtState(int value2) {
        if (((TextView) findViewById(R.id.tv_bt)) != null) {
            ((TextView) findViewById(R.id.tv_bt)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    protected void uPlayState(int value2) {
        int id = R.string.str_car_cd_putong_mode;
        if (value2 == 1) {
            id = R.string.str_car_cd_repeattrack;
        } else if (value2 == 2) {
            id = R.string.crv_playstate_2;
        } else if (value2 == 3) {
            id = R.string.crv_playstate_3;
        } else if (value2 == 4) {
            id = R.string.crv_playstate_4;
        } else if (value2 == 5) {
            id = R.string.str_sbd_x80_scan;
        } else if (value2 == 6) {
            id = R.string.str_sbd_x80_file_scan;
        }
        if (((TextView) findViewById(R.id.tv_play_state)) != null) {
            ((TextView) findViewById(R.id.tv_play_state)).setText(id);
        }
    }

    protected void uUSBState(int value2) {
        if (((TextView) findViewById(R.id.tv_usb_pluginstate)) != null) {
            ((TextView) findViewById(R.id.tv_usb_pluginstate)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    protected void uCDState(int value2) {
        int id = R.string.str_car_cd_putong_mode;
        if (value2 == 1) {
            id = R.string.str_car_cd_repeattrack;
        } else if (value2 == 2) {
            id = R.string.str_car_cd_random_mode;
        } else if (value2 == 3) {
            id = R.string.str_sbd_x80_scan;
        }
        if (((TextView) findViewById(R.id.tv_play_state)) != null) {
            ((TextView) findViewById(R.id.tv_play_state)).setText(id);
        }
    }

    protected void uRadioScan(int value2) {
        if (((TextView) findViewById(R.id.tv_radio_scan)) != null) {
            ((TextView) findViewById(R.id.tv_radio_scan)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    protected void uRadioSt(int value2) {
        if (((TextView) findViewById(R.id.tv_radio_st)) != null) {
            ((TextView) findViewById(R.id.tv_radio_st)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    protected void uRadioAutoSelect(int value2) {
        if (((TextView) findViewById(R.id.tv_radio_autoselect)) != null) {
            ((TextView) findViewById(R.id.tv_radio_autoselect)).setVisibility(value2 == 0 ? 8 : 0);
        }
    }

    protected void uCarVol(int value2) {
        if (((TextView) findViewById(R.id.tv_carvol)) != null) {
            ((TextView) findViewById(R.id.tv_carvol)).setText("Vol:" + value2);
        }
    }

    protected void uInfoTitleIndex(int value2) {
        this.titleIndex = value2;
    }

    protected void uInfoHilight(int value2) {
        this.hilight = value2;
        int hilightcolor = getResources().getColor(R.color.blueviolet);
        int normalColor = getResources().getColor(android.R.color.transparent);
        if (this.titleIndex == 0) {
            if (((TextView) findViewById(R.id.tv_title)) != null) {
                TextView textView = (TextView) findViewById(R.id.tv_title);
                if (value2 != 1) {
                    hilightcolor = normalColor;
                }
                textView.setBackgroundColor(hilightcolor);
                return;
            }
            return;
        }
        if (this.titleIndex == 1) {
            if (((TextView) findViewById(R.id.tv_info1)) != null) {
                TextView textView2 = (TextView) findViewById(R.id.tv_info1);
                if (value2 != 1) {
                    hilightcolor = normalColor;
                }
                textView2.setBackgroundColor(hilightcolor);
                return;
            }
            return;
        }
        if (this.titleIndex == 2) {
            if (((TextView) findViewById(R.id.tv_info2)) != null) {
                TextView textView3 = (TextView) findViewById(R.id.tv_info2);
                if (value2 != 1) {
                    hilightcolor = normalColor;
                }
                textView3.setBackgroundColor(hilightcolor);
                return;
            }
            return;
        }
        if (this.titleIndex == 3 && ((TextView) findViewById(R.id.tv_info3)) != null) {
            TextView textView4 = (TextView) findViewById(R.id.tv_info3);
            if (value2 != 1) {
                hilightcolor = normalColor;
            }
            textView4.setBackgroundColor(hilightcolor);
        }
    }

    protected void uInfoContent(String strs) {
        uInfoTitleIndex(this.titleIndex);
        uInfoHilight(this.hilight);
        if (this.titleIndex == 0) {
            if (((TextView) findViewById(R.id.tv_title)) != null) {
                ((TextView) findViewById(R.id.tv_title)).setText(strs);
            }
        } else if (this.titleIndex == 1) {
            if (((TextView) findViewById(R.id.tv_info1)) != null) {
                ((TextView) findViewById(R.id.tv_info1)).setText(strs);
            }
        } else if (this.titleIndex == 2) {
            if (((TextView) findViewById(R.id.tv_info2)) != null) {
                ((TextView) findViewById(R.id.tv_info2)).setText(strs);
            }
        } else if (this.titleIndex == 3 && ((TextView) findViewById(R.id.tv_info3)) != null) {
            ((TextView) findViewById(R.id.tv_info3)).setText(strs);
        }
    }
}
