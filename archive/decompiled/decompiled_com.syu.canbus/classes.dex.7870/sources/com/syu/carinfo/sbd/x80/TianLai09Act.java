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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class TianLai09Act extends BaseActivity {
    public static boolean mIsFront = false;
    static int sHasDisc = 0;
    private MyButton[] myButtons = new MyButton[6];
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd.x80.TianLai09Act.1
        @Override // com.syu.module.IUiNotify
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_388_hc_xp1_09tianlai);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.myButtons[0] = (MyButton) findViewById(R.id.btn_plus1);
        this.myButtons[1] = (MyButton) findViewById(R.id.btn_plus2);
        this.myButtons[2] = (MyButton) findViewById(R.id.btn_plus3);
        this.myButtons[3] = (MyButton) findViewById(R.id.btn_plus4);
        this.myButtons[4] = (MyButton) findViewById(R.id.btn_plus5);
        this.myButtons[5] = (MyButton) findViewById(R.id.btn_plus6);
        this.image[0] = (ImageView) findViewById(R.id.layout_view7);
        this.image[1] = (ImageView) findViewById(R.id.layout_view8);
        this.image[2] = (ImageView) findViewById(R.id.layout_view9);
        this.image[3] = (ImageView) findViewById(R.id.layout_view10);
        this.image[4] = (ImageView) findViewById(R.id.layout_view11);
        this.image[5] = (ImageView) findViewById(R.id.layout_view12);
        this.textView[0] = (TextView) findViewById(R.id.tv_text18);
        this.textView[1] = (TextView) findViewById(R.id.tv_text19);
        this.textView[2] = (TextView) findViewById(R.id.tv_text20);
        this.textView[3] = (TextView) findViewById(R.id.tv_text21);
        this.textView[4] = (TextView) findViewById(R.id.tv_text22);
        this.textView[5] = (TextView) findViewById(R.id.tv_text23);
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // com.syu.canbus.BaseActivity
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterShowPage() {
        int PageIndex = DataCanbus.DATA[116] & 3;
        if (PageIndex <= 3) {
            if (PageIndex == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setVisibility(8);
                if (findViewById(R.id.layout_view3).getVisibility() == 8 || findViewById(R.id.layout_view3).getVisibility() == 4) {
                    findViewById(R.id.layout_view3).setVisibility(0);
                }
                if (findViewById(R.id.layout_view4).getVisibility() == 0) {
                    findViewById(R.id.layout_view4).setVisibility(8);
                }
                if (findViewById(R.id.layout_view14).getVisibility() == 0) {
                    findViewById(R.id.layout_view14).setVisibility(8);
                }
                if (findViewById(R.id.layout_view15).getVisibility() == 0) {
                    findViewById(R.id.layout_view15).setVisibility(8);
                }
                if (findViewById(R.id.layout_view22).getVisibility() == 0) {
                    findViewById(R.id.layout_view22).setVisibility(8);
                }
                if (findViewById(R.id.layout_view1).getVisibility() != 8) {
                    findViewById(R.id.layout_view1).setVisibility(8);
                }
                if (findViewById(R.id.layout_view28).getVisibility() == 0) {
                    findViewById(R.id.layout_view28).setVisibility(8);
                    return;
                }
                return;
            }
            if (PageIndex == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setVisibility(8);
                if (findViewById(R.id.layout_view4).getVisibility() == 8 || findViewById(R.id.layout_view4).getVisibility() == 4) {
                    findViewById(R.id.layout_view4).setVisibility(0);
                }
                if (findViewById(R.id.layout_view3).getVisibility() == 0) {
                    findViewById(R.id.layout_view3).setVisibility(8);
                }
                if (findViewById(R.id.layout_view14).getVisibility() == 0) {
                    findViewById(R.id.layout_view14).setVisibility(8);
                }
                if (findViewById(R.id.layout_view15).getVisibility() == 0) {
                    findViewById(R.id.layout_view15).setVisibility(8);
                }
                if (findViewById(R.id.layout_view22).getVisibility() == 0) {
                    findViewById(R.id.layout_view22).setVisibility(8);
                }
                if (findViewById(R.id.layout_view28).getVisibility() == 0) {
                    findViewById(R.id.layout_view28).setVisibility(8);
                    return;
                }
                return;
            }
            if (PageIndex == 3) {
                if (findViewById(R.id.layout_view28).getVisibility() == 8 || findViewById(R.id.layout_view28).getVisibility() == 4) {
                    findViewById(R.id.layout_view28).setVisibility(0);
                }
                if (findViewById(R.id.layout_view4).getVisibility() == 0) {
                    findViewById(R.id.layout_view4).setVisibility(8);
                }
                if (findViewById(R.id.layout_view14).getVisibility() == 0) {
                    findViewById(R.id.layout_view14).setVisibility(8);
                }
                if (findViewById(R.id.layout_view3).getVisibility() == 0) {
                    findViewById(R.id.layout_view3).setVisibility(8);
                }
                if (findViewById(R.id.layout_view14).getVisibility() == 0) {
                    findViewById(R.id.layout_view14).setVisibility(8);
                }
                if (findViewById(R.id.layout_view15).getVisibility() == 0) {
                    findViewById(R.id.layout_view15).setVisibility(8);
                }
                if (findViewById(R.id.layout_view22).getVisibility() == 0) {
                    findViewById(R.id.layout_view22).setVisibility(8);
                }
            }
        }
    }

    private void updatesound(int state) {
        ((TextView) findViewById(R.id.tv_text1)).setVisibility(8);
        if (findViewById(R.id.layout_view22).getVisibility() == 8 || findViewById(R.id.layout_view22).getVisibility() == 4) {
            findViewById(R.id.layout_view22).setVisibility(0);
        }
        if (findViewById(R.id.layout_view3).getVisibility() == 0) {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
        if (findViewById(R.id.layout_view4).getVisibility() == 0) {
            findViewById(R.id.layout_view4).setVisibility(8);
        }
        if (findViewById(R.id.layout_view14).getVisibility() == 0) {
            findViewById(R.id.layout_view14).setVisibility(8);
        }
        if (findViewById(R.id.layout_view15).getVisibility() == 0) {
            findViewById(R.id.layout_view15).setVisibility(8);
        }
        if (findViewById(R.id.layout_view1).getVisibility() != 8) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        if (findViewById(R.id.layout_view28).getVisibility() == 0) {
            findViewById(R.id.layout_view28).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterVol() {
        int value = DataCanbus.DATA[115] & 255;
        int enable = (DataCanbus.DATA[115] >> 8) & 255;
        if (enable == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setVisibility(8);
        }
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(getResources().getString(R.string.str_sbd_x80_yuanche_vol)) + value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterradiostate() {
        int state = DataCanbus.DATA[99];
        int rds_state = (state >> 7) & 1;
        int scane_state = (state >> 6) & 1;
        int st_state = (state >> 5) & 1;
        int auto_state = (state >> 4) & 1;
        int text_state = (state >> 3) & 1;
        if (rds_state == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setVisibility(8);
        }
        if (scane_state == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setVisibility(8);
        }
        if (st_state == 1) {
            ((TextView) findViewById(R.id.tv_text6)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setVisibility(8);
        }
        if (auto_state == 1) {
            ((TextView) findViewById(R.id.tv_text7)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setVisibility(8);
        }
        if (text_state == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterradiotext(String[] strs) {
        if (strs != null) {
            ((TextView) findViewById(R.id.tv_text8)).setText(strs[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterband() {
        int band = DataCanbus.DATA[100];
        if (band == 3) {
            ((TextView) findViewById(R.id.tv_text9)).setText("FM 1");
            ((TextView) findViewById(R.id.tv_text11)).setText("MHz");
            return;
        }
        if (band == 4) {
            ((TextView) findViewById(R.id.tv_text9)).setText("FM 2");
            ((TextView) findViewById(R.id.tv_text11)).setText("MHz");
            return;
        }
        if (band == 5) {
            ((TextView) findViewById(R.id.tv_text9)).setText("FM AP");
            ((TextView) findViewById(R.id.tv_text11)).setText("MHz");
        } else if (band == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText("AM 1");
            ((TextView) findViewById(R.id.tv_text11)).setText("KHz");
        } else if (band == 2) {
            ((TextView) findViewById(R.id.tv_text9)).setText("AM AP");
            ((TextView) findViewById(R.id.tv_text11)).setText("KHz");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFreq(int[] ints) {
        if (ints != null && ints.length >= 2) {
            int currentband = ints[0] & 65535;
            int band = ints[1] & 65535;
            int freq = ints[2] & 65535;
            if (currentband == 3 || currentband == 4 || currentband == 5) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.format("%.02f", Float.valueOf(freq / 100.0f)));
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.format("%d", Integer.valueOf(freq)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercdtext(String[] strs) {
        if (strs != null) {
            ((TextView) findViewById(R.id.tv_text12)).setText(strs[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        ((TextView) findViewById(R.id.tv_text14)).setText(new StringBuilder().append(track).toString());
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

    /* JADX INFO: Access modifiers changed from: private */
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
        ((TextView) findViewById(R.id.tv_text15)).setText(String.valueOf(playminute) + ":" + playsecond);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFiles() {
        int files = DataCanbus.DATA[109];
        switch (files) {
            case 0:
                ((TextView) findViewById(R.id.tv_text13)).setText("Play");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text13)).setText("Read Disc");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text13)).setText("Load Disc");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text13)).setText("Insert Disc");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text13)).setText("Busy");
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text13)).setText("Eject");
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text13)).setText("To Load");
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_text13)).setText("To Eject");
                break;
            case 8:
                ((TextView) findViewById(R.id.tv_text13)).setText("Disc Error");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMode() {
        int mode = DataCanbus.DATA[105] & 7;
        ((TextView) findViewById(R.id.tv_text16)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_text17)).setVisibility(0);
        if (((DataCanbus.DATA[105] >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.tv_text12)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.tv_text12)).setVisibility(8);
        }
        switch (mode) {
            case 0:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_388_all_disc_rep);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_388_disc_rep);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_388_rep_one);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_388_disc_random);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_388_all_disc_random);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_sbd_x80_file_random);
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_sbd_x80_file_repeat);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text17)).setText(R.string.xp_380_playmode1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                ((TextView) findViewById(R.id.tv_text34)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.tv_text34)).setText("- " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text34)).setText("+ " + (media_data - 7));
                return;
            }
        }
        if (media_type == 2) {
            if (media_data == 7) {
                ((TextView) findViewById(R.id.tv_text35)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.tv_text35)).setText("- " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text35)).setText("+ " + (media_data - 7));
                return;
            }
        }
        if (media_type == 3) {
            if (media_data == 7) {
                ((TextView) findViewById(R.id.tv_text36)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.tv_text36)).setText("R " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text36)).setText("F " + (media_data - 7));
                return;
            }
        }
        if (media_type == 4) {
            if (media_data == 7) {
                ((TextView) findViewById(R.id.tv_text37)).setText("0");
                return;
            } else if (media_data < 7) {
                ((TextView) findViewById(R.id.tv_text37)).setText("L " + (7 - media_data));
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text37)).setText("R " + (media_data - 7));
                return;
            }
        }
        if (media_type == 5) {
            if (media_data == 1) {
                ((TextView) findViewById(R.id.tv_text38)).setText("ON ");
            } else {
                ((TextView) findViewById(R.id.tv_text38)).setText("OFF ");
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
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
