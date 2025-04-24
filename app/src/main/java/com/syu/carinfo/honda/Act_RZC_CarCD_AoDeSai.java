package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Act_RZC_CarCD_AoDeSai extends Activity {
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
                case 100:
                    Act_RZC_CarCD_AoDeSai.this.uRadioSt(value);
                    break;
                case 101:
                    Act_RZC_CarCD_AoDeSai.this.uRadioScan(value);
                    break;
                case 103:
                    Act_RZC_CarCD_AoDeSai.this.uRadioFrq(value);
                    break;
                case 113:
                    Act_RZC_CarCD_AoDeSai.this.uInfoTitleIndex(value);
                    break;
                case 114:
                    Act_RZC_CarCD_AoDeSai.this.uInfoHilight(value);
                    break;
                case 115:
                    Act_RZC_CarCD_AoDeSai.this.uInfoContent(strs != null ? strs[0] : "");
                    break;
                case 117:
                    Act_RZC_CarCD_AoDeSai.this.uCarVol(value);
                    break;
                case 118:
                    Act_RZC_CarCD_AoDeSai.this.uTimeFormat(value);
                    break;
                case 119:
                    Act_RZC_CarCD_AoDeSai.this.uTimeAMPM(value);
                    break;
                case 120:
                    Act_RZC_CarCD_AoDeSai.this.uTimeHour(value);
                    break;
                case 121:
                    Act_RZC_CarCD_AoDeSai.this.uTimeMinitus(value);
                    break;
                case 123:
                    Act_RZC_CarCD_AoDeSai.this.uCDState(value);
                    break;
                case 124:
                    Act_RZC_CarCD_AoDeSai.this.uCDTrack(value);
                    break;
                case 125:
                    Act_RZC_CarCD_AoDeSai.this.uPlayState(value);
                    break;
                case 126:
                case 127:
                    Act_RZC_CarCD_AoDeSai.this.uCDTime();
                    break;
                case 128:
                    Act_RZC_CarCD_AoDeSai.this.uCDNum(value);
                    break;
                case 129:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd1_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd1_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 130:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd2_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd2_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 131:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd3_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd3_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 132:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd4_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd4_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 133:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd5_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd5_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 134:
                    if (value == 1) {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd6_img)).setImageResource(R.drawable.ic_sbd_ready);
                        break;
                    } else {
                        ((ImageView) Act_RZC_CarCD_AoDeSai.this.findViewById(R.id.xuni_cd6_img)).setImageResource(R.drawable.ic_sbd_gray);
                        break;
                    }
                case 135:
                    Act_RZC_CarCD_AoDeSai.this.uUSBFileNum(value);
                    break;
                case 136:
                    Act_RZC_CarCD_AoDeSai.this.uUSBTrack(value);
                    break;
                case 137:
                    Act_RZC_CarCD_AoDeSai.this.uPlayUSBState(value);
                    break;
                case 138:
                case 139:
                    Act_RZC_CarCD_AoDeSai.this.uUSBTime();
                    break;
                case 140:
                    Act_RZC_CarCD_AoDeSai.this.uDiscWorkState(value);
                    break;
                case 141:
                    Act_RZC_CarCD_AoDeSai.this.uWorkUSBState(value);
                    break;
                case 142:
                case 143:
                    int hour = DataCanbus.DATA[142];
                    int min = DataCanbus.DATA[143];
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_rzc_09aodesai_carcd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(0, new int[]{119}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{123}, null, null);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
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
            int min = DataCanbus.DATA[126];
            int sec = DataCanbus.DATA[127];
            if (((TextView) findViewById(R.id.tv_text7)) != null) {
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf((min / 10) + (min % 10)) + ":" + (sec / 10) + (sec % 10));
            }
        }
    }

    protected void uUSBTime() {
        if (this.CD_STATE == 6) {
            int min = DataCanbus.DATA[138];
            int sec = DataCanbus.DATA[139];
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
                uRadioSt(DataCanbus.DATA[100]);
                uRadioScan(DataCanbus.DATA[101]);
                uRadioFrq(DataCanbus.DATA[103]);
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
                uRadioSt(DataCanbus.DATA[100]);
                uRadioScan(DataCanbus.DATA[101]);
                uRadioFrq(DataCanbus.DATA[103]);
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
                uRadioSt(DataCanbus.DATA[100]);
                uRadioScan(DataCanbus.DATA[101]);
                uRadioFrq(DataCanbus.DATA[103]);
                break;
            case 4:
                findViewById(R.id.six_die_show_view).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.jeep_carcd);
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_385_carcdinfo1);
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_385_carcdinfo2);
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_385_carcdinfo3);
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_385_carcdinfo4);
                uPlayState(DataCanbus.DATA[125]);
                uDiscWorkState(DataCanbus.DATA[140]);
                uCDTime();
                uCDTrack(DataCanbus.DATA[124]);
                uCDNum(DataCanbus.DATA[128]);
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
                uPlayUSBState(DataCanbus.DATA[137]);
                uWorkUSBState(DataCanbus.DATA[141]);
                uUSBTime();
                uUSBTrack(DataCanbus.DATA[136]);
                uUSBFileNum(DataCanbus.DATA[135]);
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
