package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Act_RZC_CarCD_AoDeSai extends Activity {
    public static boolean mIsFront = false;
    private int timeAMPM;
    private int timeFormat;
    private int timeH;
    private int timeM;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Act_RZC_CarCD_AoDeSai.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 9:
                    Act_RZC_CarCD_AoDeSai.this.uRadioSt(value);
                    break;
                case 10:
                    Act_RZC_CarCD_AoDeSai.this.uRadioScan(value);
                    break;
                case 12:
                    Act_RZC_CarCD_AoDeSai.this.uRadioFrq(value);
                    break;
                case 22:
                    Act_RZC_CarCD_AoDeSai.this.uInfoTitleIndex(value);
                    break;
                case 23:
                    Act_RZC_CarCD_AoDeSai.this.uInfoHilight(value);
                    break;
                case 24:
                    Act_RZC_CarCD_AoDeSai.this.uInfoContent(strs != null ? strs[0] : "");
                    break;
                case 26:
                    Act_RZC_CarCD_AoDeSai.this.uCarVol(value);
                    break;
                case 27:
                    Act_RZC_CarCD_AoDeSai.this.uTimeFormat(value);
                    break;
                case 28:
                    Act_RZC_CarCD_AoDeSai.this.uTimeAMPM(value);
                    break;
                case 29:
                    Act_RZC_CarCD_AoDeSai.this.uTimeHour(value);
                    break;
                case 30:
                    Act_RZC_CarCD_AoDeSai.this.uTimeMinitus(value);
                    break;
                case 32:
                    Act_RZC_CarCD_AoDeSai.this.uCDState(value);
                    break;
                case 33:
                    Act_RZC_CarCD_AoDeSai.this.uCDTrack(value);
                    break;
                case 34:
                    Act_RZC_CarCD_AoDeSai.this.uPlayState(value);
                    break;
                case 35:
                case 36:
                    Act_RZC_CarCD_AoDeSai.this.uCDTime();
                    break;
                case 37:
                    Act_RZC_CarCD_AoDeSai.this.uCDNum(value);
                    break;
                case 38:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd1_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd1_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 39:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd2_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd2_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 40:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd3_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd3_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 41:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd4_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd4_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 42:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd5_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd5_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 43:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd6_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd6_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 76:
                    Act_RZC_CarCD_AoDeSai.this.uUSBFileNum(value);
                    break;
                case 77:
                    Act_RZC_CarCD_AoDeSai.this.uUSBTrack(value);
                    break;
                case 78:
                    Act_RZC_CarCD_AoDeSai.this.uPlayUSBState(value);
                    break;
                case 79:
                case 80:
                    Act_RZC_CarCD_AoDeSai.this.uUSBTime();
                    break;
                case 81:
                    Act_RZC_CarCD_AoDeSai.this.uDiscWorkState(value);
                    break;
                case 82:
                    Act_RZC_CarCD_AoDeSai.this.uWorkUSBState(value);
                    break;
                case 83:
                case 84:
                    int hour = DataCanbus.DATA[83];
                    int min = DataCanbus.DATA[84];
                    if (((TextView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                        break;
                    }
            }
        }
    };
    private int titleIndex = 0;
    private int hilight = 0;
    int CD_STATE = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_rzc_09aodesai_carcd);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(0, new int[]{119}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{123}, null, null);
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
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

    protected void uDiscWorkState(int value2) {
        int id = R.string.str_car_cd_work_state_1;
        if (value2 == 1) {
            id = R.string.str_sbd_x80_media_state_10;
        } else if (value2 == 2) {
            id = R.string.str_327_change_disc;
        } else if (value2 == 3) {
            id = R.string.str_car_cd_eject;
        }
        if (this.CD_STATE == 4 && ((TextView) findViewById(R.id.tv_text10)) != null) {
            ((TextView) findViewById(R.id.tv_text10)).setText(id);
        }
    }

    protected void uPlayState(int value2) {
        int id = R.string.str_car_cd_putong_mode;
        if (value2 == 1) {
            id = R.string.str_car_cd_repeattrack;
        } else if (value2 == 2) {
            id = R.string.xp_380_playmode4;
        } else if (value2 == 3) {
            id = R.string.str_status_scan;
        } else if (value2 == 4) {
            id = R.string.str_420_disc_scan;
        }
        if (this.CD_STATE == 4 && ((TextView) findViewById(R.id.tv_text8)) != null) {
            ((TextView) findViewById(R.id.tv_text8)).setText(id);
        }
    }

    protected void uWorkUSBState(int value2) {
        int id = R.string.str_car_cd_work_state_1;
        if (value2 == 1) {
            id = R.string.str_connected_device;
        } else if (value2 == 2) {
            id = R.string.str_no_usb_device;
        } else if (value2 == 3) {
            id = R.string.jeep_playstate4;
        }
        if (this.CD_STATE == 6 && ((TextView) findViewById(R.id.tv_text10)) != null) {
            ((TextView) findViewById(R.id.tv_text10)).setText(id);
        }
    }

    protected void uPlayUSBState(int value2) {
        int id = R.string.str_car_cd_putong_mode;
        if (value2 == 1) {
            id = R.string.str_car_cd_repeattrack;
        } else if (value2 == 2) {
            id = R.string.xp_380_playmode4;
        } else if (value2 == 3) {
            id = R.string.str_status_scan;
        } else if (value2 == 4) {
            id = R.string.crv_state_ScanFld;
        }
        if (this.CD_STATE == 6 && ((TextView) findViewById(R.id.tv_text8)) != null) {
            ((TextView) findViewById(R.id.tv_text8)).setText(id);
        }
    }

    protected void uCDTime() {
        if (this.CD_STATE == 4) {
            int min = DataCanbus.DATA[35];
            int sec = DataCanbus.DATA[36];
            if (((TextView) findViewById(R.id.tv_text7)) != null) {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf((min / 10) + (min % 10)) + ":" + (sec / 10) + (sec % 10));
            }
        }
    }

    protected void uUSBTime() {
        if (this.CD_STATE == 6) {
            int min = DataCanbus.DATA[79];
            int sec = DataCanbus.DATA[80];
            if (((TextView) findViewById(R.id.tv_text7)) != null) {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf((min / 10) + (min % 10)) + ":" + (sec / 10) + (sec % 10));
            }
        }
    }

    protected void uCDTrack(int value2) {
        if (this.CD_STATE == 4 && ((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value2).toString());
        }
    }

    protected void uUSBTrack(int value2) {
        if (this.CD_STATE == 6 && ((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value2).toString());
        }
    }

    protected void uCDNum(int value2) {
        if (this.CD_STATE == 4 && ((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText("CD" + value2);
        }
    }

    protected void uUSBFileNum(int value2) {
        if (this.CD_STATE == 6 && ((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText("File" + value2);
        }
    }

    protected void uRadioFrq(int value2) {
        if ((this.CD_STATE == 1 || this.CD_STATE == 2 || this.CD_STATE == 3) && ((TextView) findViewById(R.id.tv_text8)) != null) {
            if (this.CD_STATE == 1 || this.CD_STATE == 2) {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "Mhz");
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value2) + "Khz");
            }
        }
    }

    protected void uRadioScan(int value2) {
        if ((this.CD_STATE == 1 || this.CD_STATE == 2 || this.CD_STATE == 3) && ((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value2 == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText("On");
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText("Off");
            }
        }
    }

    protected void uRadioSt(int value2) {
        if ((this.CD_STATE == 1 || this.CD_STATE == 2 || this.CD_STATE == 3) && ((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value2 == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("On");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText("Off");
            }
        }
    }

    protected void uCDState(int value2) {
        this.CD_STATE = value2;
        switch (this.CD_STATE) {
            case 1:
                findViewById(R.id.six_die_show_view).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.radio_car);
                ((TextView) findViewById(R.id.tv_text10)).setText("");
                ((TextView) findViewById(R.id.tv_text1)).setText("ST Status");
                ((TextView) findViewById(R.id.tv_text2)).setText("SCan Status");
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_385_carradioinfo1);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_385_carradioinfo2);
                ((TextView) findViewById(R.id.tv_text7)).setText("FM1");
                uRadioSt(DataCanbus.DATA[9]);
                uRadioScan(DataCanbus.DATA[10]);
                uRadioFrq(DataCanbus.DATA[12]);
                break;
            case 2:
                findViewById(R.id.six_die_show_view).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.radio_car);
                ((TextView) findViewById(R.id.tv_text10)).setText("");
                ((TextView) findViewById(R.id.tv_text1)).setText("ST Status");
                ((TextView) findViewById(R.id.tv_text2)).setText("SCan Status");
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_385_carradioinfo1);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_385_carradioinfo2);
                ((TextView) findViewById(R.id.tv_text7)).setText("FM2");
                uRadioSt(DataCanbus.DATA[9]);
                uRadioScan(DataCanbus.DATA[10]);
                uRadioFrq(DataCanbus.DATA[12]);
                break;
            case 3:
                findViewById(R.id.six_die_show_view).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.radio_car);
                ((TextView) findViewById(R.id.tv_text10)).setText("");
                ((TextView) findViewById(R.id.tv_text1)).setText("ST Status");
                ((TextView) findViewById(R.id.tv_text2)).setText("SCan Status");
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_385_carradioinfo1);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_385_carradioinfo2);
                ((TextView) findViewById(R.id.tv_text7)).setText("AM1");
                uRadioSt(DataCanbus.DATA[9]);
                uRadioScan(DataCanbus.DATA[10]);
                uRadioFrq(DataCanbus.DATA[12]);
                break;
            case 4:
                findViewById(R.id.six_die_show_view).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.jeep_carcd);
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_385_carcdinfo1);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_385_carcdinfo2);
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_385_carcdinfo3);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_385_carcdinfo4);
                uPlayState(DataCanbus.DATA[34]);
                uDiscWorkState(DataCanbus.DATA[81]);
                uCDTime();
                uCDTrack(DataCanbus.DATA[33]);
                uCDNum(DataCanbus.DATA[37]);
                break;
            case 5:
            default:
                findViewById(R.id.six_die_show_view).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text10)).setText("");
                ((TextView) findViewById(R.id.tv_text9)).setText("AUX");
                ((TextView) findViewById(R.id.tv_text1)).setText("----");
                ((TextView) findViewById(R.id.tv_text2)).setText("----");
                ((TextView) findViewById(R.id.tv_text3)).setText("----");
                ((TextView) findViewById(R.id.tv_text4)).setText("----");
                ((TextView) findViewById(R.id.tv_text5)).setText("----");
                ((TextView) findViewById(R.id.tv_text6)).setText("----");
                ((TextView) findViewById(R.id.tv_text7)).setText("----");
                ((TextView) findViewById(R.id.tv_text8)).setText("----");
                break;
            case 6:
                findViewById(R.id.six_die_show_view).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.crv_source_usb);
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_385_carcdinfo6);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_385_carcdinfo2);
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_385_carcdinfo3);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_385_carcdinfo4);
                uPlayUSBState(DataCanbus.DATA[78]);
                uWorkUSBState(DataCanbus.DATA[82]);
                uUSBTime();
                uUSBTrack(DataCanbus.DATA[77]);
                uUSBFileNum(DataCanbus.DATA[76]);
                break;
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
