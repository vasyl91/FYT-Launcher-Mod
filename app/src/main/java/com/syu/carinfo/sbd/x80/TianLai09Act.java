package com.syu.carinfo.sbd.x80;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class TianLai09Act extends BaseActivity {
    public static boolean mIsFront = false;
    static int sHasDisc = 0;
    private MyButton[] myButtons = new MyButton[6];
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    MyProgressBar[] progressBar = new MyProgressBar[6];
    private int band = 3;
    private TextView[] cd4infoTv = new TextView[4];
    ImageView[] systemImage = new ImageView[6];
    ImageView[] soundImage = new ImageView[6];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    TianLai09Act.this.updaterradiostate();
                    break;
                case 100:
                    TianLai09Act.this.updaterband();
                    break;
                case 101:
                    TianLai09Act.this.updaterFreq(ints);
                    break;
                case 102:
                    TianLai09Act.this.updaterradiotext(strs);
                    break;
                case 105:
                    TianLai09Act.this.updaterMode();
                    break;
                case 106:
                    TianLai09Act.this.updaterDiscState();
                    break;
                case 107:
                    TianLai09Act.this.updaterDiscState();
                    break;
                case 108:
                    TianLai09Act.this.updaterPlayTime();
                    break;
                case 109:
                    TianLai09Act.this.updaterFiles();
                    break;
                case 110:
                    TianLai09Act.this.updatercdtext(strs);
                    break;
                case 113:
                    TianLai09Act.this.updaterMediaState();
                    break;
                case 115:
                    TianLai09Act.this.updaterVol();
                    break;
                case 116:
                    TianLai09Act.this.updaterShowPage();
                    break;
            }
        }
    };
    Toast toast = null;
    TextView view = null;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_388_hc_xp1_09tianlai);
        init();
        setUI();
    }

    @Override
    public void init() {
        this.myButtons[0] = (MyButton) findViewById(R.id.freq1);
        this.myButtons[1] = (MyButton) findViewById(R.id.freq2);
        this.myButtons[2] = (MyButton) findViewById(R.id.freq3);
        this.myButtons[3] = (MyButton) findViewById(R.id.freq4);
        this.myButtons[4] = (MyButton) findViewById(R.id.freq5);
        this.myButtons[5] = (MyButton) findViewById(R.id.freq6);
        this.image[0] = (ImageView) findViewById(R.id.xuni_cd1_img);
        this.image[1] = (ImageView) findViewById(R.id.xuni_cd2_img);
        this.image[2] = (ImageView) findViewById(R.id.xuni_cd3_img);
        this.image[3] = (ImageView) findViewById(R.id.xuni_cd4_img);
        this.image[4] = (ImageView) findViewById(R.id.xuni_cd5_img);
        this.image[5] = (ImageView) findViewById(R.id.xuni_cd6_img);
        this.textView[0] = (TextView) findViewById(R.id.xuni_cd1_text);
        this.textView[1] = (TextView) findViewById(R.id.xuni_cd2_text);
        this.textView[2] = (TextView) findViewById(R.id.xuni_cd3_text);
        this.textView[3] = (TextView) findViewById(R.id.xuni_cd4_text);
        this.textView[4] = (TextView) findViewById(R.id.xuni_cd5_text);
        this.textView[5] = (TextView) findViewById(R.id.xuni_cd5_text);
        this.progressBar[0] = (MyProgressBar) findViewById(R.id.xuni_cd1_progress);
        this.progressBar[1] = (MyProgressBar) findViewById(R.id.xuni_cd2_progress);
        this.progressBar[2] = (MyProgressBar) findViewById(R.id.xuni_cd3_progress);
        this.progressBar[3] = (MyProgressBar) findViewById(R.id.xuni_cd4_progress);
        this.progressBar[4] = (MyProgressBar) findViewById(R.id.xuni_cd5_progress);
        this.progressBar[5] = (MyProgressBar) findViewById(R.id.xuni_cd6_progress);
        this.cd4infoTv[0] = (TextView) findViewById(R.id.x80_sbd_info1);
        this.cd4infoTv[1] = (TextView) findViewById(R.id.x80_sbd_info2);
        this.cd4infoTv[2] = (TextView) findViewById(R.id.x80_sbd_info3);
        this.cd4infoTv[3] = (TextView) findViewById(R.id.x80_sbd_info4);
        this.systemImage[0] = (ImageView) findViewById(R.id.x80_system_set_img0);
        this.systemImage[1] = (ImageView) findViewById(R.id.x80_system_set_img1);
        this.systemImage[2] = (ImageView) findViewById(R.id.x80_system_set_img2);
        this.systemImage[3] = (ImageView) findViewById(R.id.x80_system_set_img3);
        this.systemImage[4] = (ImageView) findViewById(R.id.x80_system_set_img4);
        this.systemImage[5] = (ImageView) findViewById(R.id.x80_system_set_img5);
        this.soundImage[0] = (ImageView) findViewById(R.id.x80_sound_set_img0);
        this.soundImage[1] = (ImageView) findViewById(R.id.x80_sound_set_img1);
        this.soundImage[2] = (ImageView) findViewById(R.id.x80_sound_set_img2);
        this.soundImage[3] = (ImageView) findViewById(R.id.x80_sound_set_img3);
        this.soundImage[4] = (ImageView) findViewById(R.id.x80_sound_set_img4);
        this.soundImage[5] = (ImageView) findViewById(R.id.x80_sound_set_img5);
    }

    public void setUI() {
        for (int i = 0; i < 6; i++) {
            this.myButtons[i].setText_FreqName("P" + (i + 1));
            this.myButtons[i].setGravity_FreqName(17);
            this.myButtons[i].setTextColor_FreqName(-1);
            this.myButtons[i].setTextSize_FreqName(25);
            this.myButtons[i].setBackgroundResource(R.drawable.ic_sbd_freq_n);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterShowPage() {
        int PageIndex = DataCanbus.DATA[116] & 3;
        if (PageIndex <= 3) {
            if (PageIndex == 1) {
                ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setVisibility(8);
                if (findViewById(R.id.radio_view).getVisibility() == 8 || findViewById(R.id.radio_view).getVisibility() == 4) {
                    findViewById(R.id.radio_view).setVisibility(0);
                }
                if (findViewById(R.id.cd_view).getVisibility() == 0) {
                    findViewById(R.id.cd_view).setVisibility(8);
                }
                if (findViewById(R.id.xuni_4info_view).getVisibility() == 0) {
                    findViewById(R.id.xuni_4info_view).setVisibility(8);
                }
                if (findViewById(R.id.system_set_info_view).getVisibility() == 0) {
                    findViewById(R.id.system_set_info_view).setVisibility(8);
                }
                if (findViewById(R.id.sound_set_info_view).getVisibility() == 0) {
                    findViewById(R.id.sound_set_info_view).setVisibility(8);
                }
                if (findViewById(R.id.show_progress).getVisibility() != 8) {
                    findViewById(R.id.show_progress).setVisibility(8);
                }
                if (findViewById(R.id.aux_info_view).getVisibility() == 0) {
                    findViewById(R.id.aux_info_view).setVisibility(8);
                    return;
                }
                return;
            }
            if (PageIndex == 2) {
                ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setVisibility(8);
                if (findViewById(R.id.cd_view).getVisibility() == 8 || findViewById(R.id.cd_view).getVisibility() == 4) {
                    findViewById(R.id.cd_view).setVisibility(0);
                }
                if (findViewById(R.id.radio_view).getVisibility() == 0) {
                    findViewById(R.id.radio_view).setVisibility(8);
                }
                if (findViewById(R.id.xuni_4info_view).getVisibility() == 0) {
                    findViewById(R.id.xuni_4info_view).setVisibility(8);
                }
                if (findViewById(R.id.system_set_info_view).getVisibility() == 0) {
                    findViewById(R.id.system_set_info_view).setVisibility(8);
                }
                if (findViewById(R.id.sound_set_info_view).getVisibility() == 0) {
                    findViewById(R.id.sound_set_info_view).setVisibility(8);
                }
                if (findViewById(R.id.aux_info_view).getVisibility() == 0) {
                    findViewById(R.id.aux_info_view).setVisibility(8);
                    return;
                }
                return;
            }
            if (PageIndex == 3) {
                if (findViewById(R.id.aux_info_view).getVisibility() == 8 || findViewById(R.id.aux_info_view).getVisibility() == 4) {
                    findViewById(R.id.aux_info_view).setVisibility(0);
                }
                if (findViewById(R.id.cd_view).getVisibility() == 0) {
                    findViewById(R.id.cd_view).setVisibility(8);
                }
                if (findViewById(R.id.xuni_4info_view).getVisibility() == 0) {
                    findViewById(R.id.xuni_4info_view).setVisibility(8);
                }
                if (findViewById(R.id.radio_view).getVisibility() == 0) {
                    findViewById(R.id.radio_view).setVisibility(8);
                }
                if (findViewById(R.id.xuni_4info_view).getVisibility() == 0) {
                    findViewById(R.id.xuni_4info_view).setVisibility(8);
                }
                if (findViewById(R.id.system_set_info_view).getVisibility() == 0) {
                    findViewById(R.id.system_set_info_view).setVisibility(8);
                }
                if (findViewById(R.id.sound_set_info_view).getVisibility() == 0) {
                    findViewById(R.id.sound_set_info_view).setVisibility(8);
                }
            }
        }
    }

    private void updatesound(int state) {
        ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setVisibility(8);
        if (findViewById(R.id.sound_set_info_view).getVisibility() == 8 || findViewById(R.id.sound_set_info_view).getVisibility() == 4) {
            findViewById(R.id.sound_set_info_view).setVisibility(0);
        }
        if (findViewById(R.id.radio_view).getVisibility() == 0) {
            findViewById(R.id.radio_view).setVisibility(8);
        }
        if (findViewById(R.id.cd_view).getVisibility() == 0) {
            findViewById(R.id.cd_view).setVisibility(8);
        }
        if (findViewById(R.id.xuni_4info_view).getVisibility() == 0) {
            findViewById(R.id.xuni_4info_view).setVisibility(8);
        }
        if (findViewById(R.id.system_set_info_view).getVisibility() == 0) {
            findViewById(R.id.system_set_info_view).setVisibility(8);
        }
        if (findViewById(R.id.show_progress).getVisibility() != 8) {
            findViewById(R.id.show_progress).setVisibility(8);
        }
        if (findViewById(R.id.aux_info_view).getVisibility() == 0) {
            findViewById(R.id.aux_info_view).setVisibility(8);
        }
    }

    
    public void updaterVol() {
        int value = DataCanbus.DATA[115] & 255;
        int enable = (DataCanbus.DATA[115] >> 8) & 255;
        if (enable == 1) {
            ((TextView) findViewById(R.id.cd_tip_vol)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.cd_tip_vol)).setVisibility(8);
        }
        ((TextView) findViewById(R.id.cd_tip_vol)).setText(String.valueOf(getResources().getString(R.string.str_sbd_x80_yuanche_vol)) + value);
    }

    
    public void updaterradiostate() {
        int state = DataCanbus.DATA[99];
        int rds_state = (state >> 7) & 1;
        int scane_state = (state >> 6) & 1;
        int st_state = (state >> 5) & 1;
        int auto_state = (state >> 4) & 1;
        int text_state = (state >> 3) & 1;
        if (rds_state == 1) {
            ((TextView) findViewById(R.id.radio_rds)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.radio_rds)).setVisibility(8);
        }
        if (scane_state == 1) {
            ((TextView) findViewById(R.id.radio_scane)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.radio_scane)).setVisibility(8);
        }
        if (st_state == 1) {
            ((TextView) findViewById(R.id.radio_st)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.radio_st)).setVisibility(8);
        }
        if (auto_state == 1) {
            ((TextView) findViewById(R.id.radio_auto)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.radio_auto)).setVisibility(8);
        }
        if (text_state == 1) {
            ((TextView) findViewById(R.id.radio_text)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.radio_text)).setVisibility(8);
        }
    }

    
    public void updaterradiotext(String[] strs) {
        if (strs != null) {
            ((TextView) findViewById(R.id.radio_text)).setText(strs[0]);
        }
    }

    
    public void updaterband() {
        this.band = DataCanbus.DATA[100];
        if (this.band == 3) {
            ((TextView) findViewById(R.id.band)).setText("FM 1");
            ((TextView) findViewById(R.id.textshow)).setText("MHz");
            return;
        }
        if (this.band == 4) {
            ((TextView) findViewById(R.id.band)).setText("FM 2");
            ((TextView) findViewById(R.id.textshow)).setText("MHz");
            return;
        }
        if (this.band == 5) {
            ((TextView) findViewById(R.id.band)).setText("FM AP");
            ((TextView) findViewById(R.id.textshow)).setText("MHz");
        } else if (this.band == 1) {
            ((TextView) findViewById(R.id.band)).setText("AM 1");
            ((TextView) findViewById(R.id.textshow)).setText("KHz");
        } else if (this.band == 2) {
            ((TextView) findViewById(R.id.band)).setText("AM AP");
            ((TextView) findViewById(R.id.textshow)).setText("KHz");
        }
    }

    
    public void updaterFreq(int[] ints) {
        if (ints != null && ints.length >= 2) {
            int currentband = ints[0] & 65535;
            int band = ints[1] & 65535;
            int freq = ints[2] & 65535;
            if (currentband == 3 || currentband == 4 || currentband == 5) {
                ((TextView) findViewById(R.id.curfre)).setText(String.format("%.02f", Float.valueOf(freq / 100.0f)));
            } else {
                ((TextView) findViewById(R.id.curfre)).setText(String.format("%d", Integer.valueOf(freq)));
            }
            for (int i = 0; i < 6; i++) {
                if (i == band - 1) {
                    this.myButtons[band - 1].setBackgroundResource(R.drawable.ic_sbd_freq_p);
                } else {
                    this.myButtons[i].setBackgroundResource(R.drawable.ic_sbd_freq_n);
                }
            }
        }
    }

    
    public void updatercdtext(String[] strs) {
        if (strs != null) {
            ((TextView) findViewById(R.id.cd_title_show)).setText(strs[0]);
        }
    }

    
    public void updaterDiscState() {
        int havedisc = DataCanbus.DATA[106] & 65535;
        int disc = (DataCanbus.DATA[107] >> 8) & 255;
        int track = DataCanbus.DATA[107] & 255;
        if (((havedisc >> 14) & 1) == 1) {
            sHasDisc |= 1;
        } else {
            sHasDisc &= 254;
        }
        if (((havedisc >> 12) & 1) == 1) {
            sHasDisc |= 2;
        } else {
            sHasDisc &= 253;
        }
        if (((havedisc >> 10) & 1) == 1) {
            sHasDisc |= 4;
        } else {
            sHasDisc &= 251;
        }
        if (((havedisc >> 8) & 1) == 1) {
            sHasDisc |= 8;
        } else {
            sHasDisc &= 247;
        }
        if (((havedisc >> 6) & 1) == 1) {
            sHasDisc |= 16;
        } else {
            sHasDisc &= 239;
        }
        if (((havedisc >> 4) & 1) == 1) {
            sHasDisc |= 32;
        } else {
            sHasDisc &= 223;
        }
        ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(track).toString());
        if (disc >= 1 && disc <= 6) {
            for (int i = 0; i < 6; i++) {
                if (i == disc - 1) {
                    this.textView[disc - 1].setText(R.string.str_sbd_x80_media_state_22);
                    this.image[disc - 1].setImageResource(R.drawable.ic_sbd_play1);
                } else {
                    this.textView[i].setText("CD" + (i + 1));
                    if (((sHasDisc >> i) & 1) == 1) {
                        this.image[i].setImageResource(R.drawable.ic_sbd_ready);
                    } else {
                        this.image[i].setImageResource(R.drawable.ic_sbd_gray);
                    }
                }
            }
        }
    }

    
    public void updaterPlayTime() {
        int playminute = (DataCanbus.DATA[108] >> 8) & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[108] & 255;
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        ((TextView) findViewById(R.id.time_tv)).setText(String.valueOf(playminute) + ":" + playsecond);
    }

    
    public void updaterFiles() {
        int files = DataCanbus.DATA[109];
        switch (files) {
            case 0:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Play");
                break;
            case 1:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Read Disc");
                break;
            case 2:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Load Disc");
                break;
            case 3:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Insert Disc");
                break;
            case 4:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Busy");
                break;
            case 5:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Eject");
                break;
            case 6:
                ((TextView) findViewById(R.id.file_num_tv)).setText("To Load");
                break;
            case 7:
                ((TextView) findViewById(R.id.file_num_tv)).setText("To Eject");
                break;
            case 8:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Disc Error");
                break;
        }
    }

    
    public void updaterMode() {
        int mode = DataCanbus.DATA[105] & 7;
        ((TextView) findViewById(R.id.mode_text)).setVisibility(0);
        ((TextView) findViewById(R.id.mode_tv)).setVisibility(0);
        if (((DataCanbus.DATA[105] >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.cd_title_show)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.cd_title_show)).setVisibility(8);
        }
        switch (mode) {
            case 0:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_all_disc_rep);
                break;
            case 1:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_disc_rep);
                break;
            case 2:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_rep_one);
                break;
            case 3:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_disc_random);
                break;
            case 4:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_all_disc_random);
                break;
            case 5:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_sbd_x80_file_random);
                break;
            case 6:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_sbd_x80_file_repeat);
                break;
            default:
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode1);
                break;
        }
    }

    
    public void updaterMediaState() {
        int media_type = (DataCanbus.DATA[113] >> 5) & 255;
        int media_data = DataCanbus.DATA[113] & 31;
        if (media_type != 0) {
            updatesound(1);
        } else {
            updaterShowPage();
        }
        if (media_type == 1) {
            if (media_data == 7) {
                ((TextView) findViewById(R.id.sound_bass_tv)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.sound_bass_tv)).setText("- " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.sound_bass_tv)).setText("+ " + (media_data - 7));
                return;
            }
        }
        if (media_type == 2) {
            if (media_data == 7) {
                ((TextView) findViewById(R.id.sound_treble_tv)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.sound_treble_tv)).setText("- " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.sound_treble_tv)).setText("+ " + (media_data - 7));
                return;
            }
        }
        if (media_type == 3) {
            if (media_data == 7) {
                ((TextView) findViewById(R.id.sound_fade_tv)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.sound_fade_tv)).setText("R " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.sound_fade_tv)).setText("F " + (media_data - 7));
                return;
            }
        }
        if (media_type == 4) {
            if (media_data == 7) {
                ((TextView) findViewById(R.id.sound_balance_tv)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.sound_balance_tv)).setText("L " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.sound_balance_tv)).setText("R " + (media_data - 7));
                return;
            }
        }
        if (media_type == 5) {
            if (media_data == 1) {
                ((TextView) findViewById(R.id.sound_beep_tv)).setText("ON ");
            } else {
                ((TextView) findViewById(R.id.sound_beep_tv)).setText("OFF ");
            }
        }
    }

    public void tips(String str) {
        if (this.toast != null) {
            this.toast.cancel();
            this.toast = null;
        }
        this.toast = new Toast(this);
        this.toast.setGravity(17, 0, 0);
        this.toast.setDuration(0);
        this.view = new TextView(this);
        this.view.setText(str);
        this.view.setGravity(17);
        this.view.setBackgroundResource(R.drawable.toast_bk);
        this.view.setTextSize(30.0f);
        this.toast.setView(this.view);
        this.toast.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 3:
            case 5:
            case 17:
            case 24:
            case 25:
            case 63:
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }
}
