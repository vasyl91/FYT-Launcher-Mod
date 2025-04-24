package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Act_CarCD_AoDeSai extends Activity {
    public static boolean mIsFront = false;
    private int timeAMPM;
    private int timeFormat;
    private int timeH;
    private int timeM;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 160:
                    Act_CarCD_AoDeSai.this.uInfoTitleIndex(value);
                    break;
                case 161:
                    Act_CarCD_AoDeSai.this.uInfoHilight(value);
                    break;
                case 162:
                    Act_CarCD_AoDeSai.this.uInfoContent(strs != null ? strs[0] : "");
                    break;
                case 164:
                    Act_CarCD_AoDeSai.this.uCarVol(value);
                    break;
                case 165:
                    Act_CarCD_AoDeSai.this.uRadioAutoSelect(value);
                    break;
                case 166:
                    Act_CarCD_AoDeSai.this.uRadioSt(value);
                    break;
                case 167:
                    Act_CarCD_AoDeSai.this.uRadioScan(value);
                    break;
                case 168:
                    Act_CarCD_AoDeSai.this.uCDState(value);
                    break;
                case 169:
                    Act_CarCD_AoDeSai.this.uUSBState(value);
                    break;
                case 170:
                    Act_CarCD_AoDeSai.this.uPlayState(value);
                    break;
                case 171:
                    Act_CarCD_AoDeSai.this.uBtState(value);
                    break;
                case 174:
                    Act_CarCD_AoDeSai.this.uTimeFormat(value);
                    break;
                case 175:
                    Act_CarCD_AoDeSai.this.uTimeAMPM(value);
                    break;
                case 176:
                    Act_CarCD_AoDeSai.this.uTimeHour(value);
                    break;
                case 177:
                    Act_CarCD_AoDeSai.this.uTimeMinitus(value);
                    break;
            }
        }
    };
    private int titleIndex = 0;
    private int hilight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_298_bnr_09aodesai_carcd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(150, 1);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
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
