package com.syu.carinfo.sbd.x80;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0375_SBD_WC1_ReservedCdBenTengX80;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class X80Act extends BaseActivity {
    private MyButton[] myButtons = new MyButton[6];
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    MyProgressBar[] progressBar = new MyProgressBar[6];
    private TextView[] cd4infoTv = new TextView[4];
    ImageView[] systemImage = new ImageView[6];
    ImageView[] soundImage = new ImageView[6];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.sbd.x80.X80Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 26:
                    X80Act.this.updaterIsReceiverData();
                    break;
                case 27:
                    X80Act.this.updaterMediaState();
                    X80Act.this.updaterShowPage();
                    break;
                case 28:
                    X80Act.this.updaterdiantaiNum();
                    break;
                case 29:
                    X80Act.this.updaterband();
                    break;
                case 31:
                    X80Act.this.updaterFreq();
                    break;
                case 32:
                    X80Act.this.updaterChannelFreq1();
                    break;
                case 33:
                    X80Act.this.updaterChannelFreq2();
                    break;
                case 34:
                    X80Act.this.updaterChannelFreq3();
                    break;
                case 35:
                    X80Act.this.updaterChannelFreq4();
                    break;
                case 36:
                    X80Act.this.updaterChannelFreq5();
                    break;
                case 37:
                    X80Act.this.updaterChannelFreq6();
                    break;
                case 38:
                    X80Act.this.updaterFiles();
                    break;
                case 39:
                    X80Act.this.updaterMode();
                    break;
                case 40:
                    X80Act.this.updaterMediaState();
                    X80Act.this.updaterSongType();
                    break;
                case 41:
                    X80Act.this.updaterSongType();
                    break;
                case 42:
                    X80Act.this.updaterSongType();
                    X80Act.this.updaterTrackNum();
                    break;
                case 43:
                    X80Act.this.updaterSongType();
                    break;
                case 44:
                    X80Act.this.updaterPlayTime();
                    break;
                case 45:
                    X80Act.this.updaterPlayTime();
                    break;
                case 46:
                    X80Act.this.updaterInfo1();
                    break;
                case 47:
                    X80Act.this.updaterInfo2();
                    break;
                case 48:
                    X80Act.this.updaterInfo3();
                    break;
                case 49:
                    X80Act.this.updaterInfo4();
                    break;
                case 50:
                    X80Act.this.updaterxuniDie();
                    break;
                case 51:
                    X80Act.this.updaterxuniDie();
                    break;
                case 52:
                    X80Act.this.updaterxuniDie();
                    break;
                case 53:
                    X80Act.this.updaterxuniDie();
                    break;
                case 54:
                    X80Act.this.updaterxuniDie();
                    break;
                case 55:
                    X80Act.this.updaterxuniDie();
                    break;
                case 56:
                    X80Act.this.updaterxuniDie();
                    break;
                case 57:
                    X80Act.this.updaterxuniDie();
                    break;
                case 58:
                    X80Act.this.updaterxuniDie();
                    break;
                case 59:
                    X80Act.this.updaterVol();
                    break;
                case 60:
                    X80Act.this.updaterVol();
                    break;
                case 61:
                    X80Act.this.updaterWhichSet();
                    break;
                case 62:
                    X80Act.this.updaterAlc();
                    break;
                case 63:
                    X80Act.this.updaterXiangdu();
                    break;
                case 64:
                    X80Act.this.updaterPhoneVol();
                    break;
                case 65:
                    X80Act.this.updatertishiVol();
                    break;
                case 66:
                    X80Act.this.updaterlaidianShow();
                    break;
                case 67:
                    X80Act.this.updateryuyinSet();
                    break;
                case 68:
                    X80Act.this.updaterSoundShowID();
                    break;
                case 69:
                    X80Act.this.updaterSoundshengchang();
                    break;
                case 70:
                    X80Act.this.updaterSoundPrefect();
                    break;
                case 71:
                    X80Act.this.updaterSoundEQ();
                    break;
                case 72:
                    X80Act.this.updaterSoundLow();
                    break;
                case 73:
                    X80Act.this.updaterSoundMiddle();
                    break;
                case 74:
                    X80Act.this.updaterSoundHigh();
                    break;
            }
        }
    };
    Runnable volrun = new Runnable() { // from class: com.syu.carinfo.sbd.x80.X80Act.2
        @Override // java.lang.Runnable
        public void run() {
            ((TextView) X80Act.this.findViewById(R.id.cd_tip_vol)).setVisibility(8);
        }
    };
    Toast toast = null;
    TextView view = null;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_375_wc_sbd_x80);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
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
            this.myButtons[i].setTextSize_Freq(30);
            this.myButtons[i].setTextColor_Freq(-1);
            this.myButtons[i].setText_Freq("87.50");
            this.myButtons[i].setGravity_Freq(17);
            this.myButtons[i].setBackgroundResource(R.drawable.ic_sbd_freq_n);
        }
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
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterxuniDie() {
        int luzhiIndex = DataCanbus.DATA[50];
        int jindu = DataCanbus.DATA[52];
        int playIndex = DataCanbus.DATA[51];
        int[] dieInt = {DataCanbus.DATA[58], DataCanbus.DATA[57], DataCanbus.DATA[56], DataCanbus.DATA[55], DataCanbus.DATA[54], DataCanbus.DATA[53]};
        if (luzhiIndex >= 1 && luzhiIndex <= 6) {
            if (jindu >= 0 && jindu < 100) {
                if (findViewById(R.id.show_progress).getVisibility() != 0 && DataCanbus.DATA[27] == 2) {
                    findViewById(R.id.show_progress).setVisibility(0);
                }
                ((ProgressBar) findViewById(R.id.xuni_cd_progress)).setProgress(jindu);
                ((TextView) findViewById(R.id.xuni_kelu_progress_precent)).setText("CD" + luzhiIndex + getResources().getString(R.string.str_sbd_x80_media_state_23) + " " + jindu + "%");
                this.image[luzhiIndex - 1].setImageResource(R.drawable.ic_sbd_kelu);
            } else if (jindu >= 100) {
                if (findViewById(R.id.show_progress).getVisibility() != 8) {
                    findViewById(R.id.show_progress).setVisibility(8);
                }
                this.image[luzhiIndex - 1].setImageResource(R.drawable.ic_sbd_play1);
            }
        } else if (luzhiIndex == 0) {
            if (findViewById(R.id.show_progress).getVisibility() != 8) {
                findViewById(R.id.show_progress).setVisibility(8);
            }
            ((ProgressBar) findViewById(R.id.xuni_cd_progress)).setProgress(0);
        }
        if (playIndex >= 1 && playIndex <= 6) {
            for (int i = 0; i < 6; i++) {
                if (i == playIndex - 1) {
                    this.textView[playIndex - 1].setText(R.string.str_sbd_x80_media_state_22);
                } else {
                    this.textView[i].setText("CD" + (i + 1));
                }
            }
        }
        for (int i2 = 0; i2 < dieInt.length; i2++) {
            if (dieInt[i2] == 0 && luzhiIndex != i2 + 1 && playIndex != i2 + 1) {
                this.image[i2].setImageResource(R.drawable.ic_sbd_gray);
            }
            if (dieInt[i2] == 0 && luzhiIndex == i2 + 1 && playIndex != i2 + 1) {
                this.image[i2].setImageResource(R.drawable.ic_sbd_kelu);
            }
            if (dieInt[i2] == 0 && luzhiIndex != i2 + 1 && playIndex == i2 + 1) {
                this.image[i2].setImageResource(R.drawable.ic_sbd_play1);
            }
            if (dieInt[i2] == 1 && luzhiIndex != i2 + 1 && playIndex != i2 + 1) {
                this.image[i2].setImageResource(R.drawable.ic_sbd_ready);
            }
            if (dieInt[i2] == 1 && playIndex == i2 + 1) {
                this.image[i2].setImageResource(R.drawable.ic_sbd_play1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterShowPage() {
        int PageIndex = DataCanbus.DATA[27];
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
                return;
            }
            return;
        }
        if (PageIndex == 2) {
            ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setVisibility(8);
            if ((findViewById(R.id.cd_view).getVisibility() == 8 || findViewById(R.id.cd_view).getVisibility() == 4) && (DataCanbus.DATA[40] == 3 || DataCanbus.DATA[40] == 4)) {
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
                return;
            }
            return;
        }
        if (PageIndex == 3) {
            ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setVisibility(8);
            if (findViewById(R.id.system_set_info_view).getVisibility() == 8 || findViewById(R.id.system_set_info_view).getVisibility() == 4) {
                findViewById(R.id.system_set_info_view).setVisibility(0);
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
            if (findViewById(R.id.sound_set_info_view).getVisibility() == 0) {
                findViewById(R.id.sound_set_info_view).setVisibility(8);
            }
            if (findViewById(R.id.show_progress).getVisibility() != 8) {
                findViewById(R.id.show_progress).setVisibility(8);
                return;
            }
            return;
        }
        if (PageIndex == 4) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdiantaiNum() {
        int channel = DataCanbus.DATA[28];
        for (int i = 0; i < 6; i++) {
            if (i == channel - 1) {
                this.myButtons[channel - 1].setBackgroundResource(R.drawable.ic_sbd_freq_p);
            } else {
                this.myButtons[i].setBackgroundResource(R.drawable.ic_sbd_freq_n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterband() {
        int band = DataCanbus.DATA[29];
        if (band == 0) {
            ((TextView) findViewById(R.id.band)).setText("FM 1");
            ((TextView) findViewById(R.id.textshow)).setText("MHz");
            return;
        }
        if (band == 1) {
            ((TextView) findViewById(R.id.band)).setText("FM 2");
            ((TextView) findViewById(R.id.textshow)).setText("MHz");
            return;
        }
        if (band == 2) {
            ((TextView) findViewById(R.id.band)).setText("FM 3");
            ((TextView) findViewById(R.id.textshow)).setText("MHz");
        } else if (band == 3) {
            ((TextView) findViewById(R.id.band)).setText("AM 1");
            ((TextView) findViewById(R.id.textshow)).setText("KHz");
        } else if (band == 4) {
            ((TextView) findViewById(R.id.band)).setText("AM 2");
            ((TextView) findViewById(R.id.textshow)).setText("KHz");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFreq() {
        int freq = DataCanbus.DATA[31];
        if (freq > 5000) {
            ((TextView) findViewById(R.id.curfre)).setText(String.format("%.02f", Float.valueOf(freq / 100.0f)));
        } else if (freq > 500 && freq < 2000) {
            ((TextView) findViewById(R.id.curfre)).setText(new StringBuilder().append(freq).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChannelFreq1() {
        int channelfreq1 = DataCanbus.DATA[32];
        if (channelfreq1 > 5000) {
            this.myButtons[0].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq1 / 100.0f)));
        } else if (channelfreq1 > 500 && channelfreq1 < 2000) {
            this.myButtons[0].setText_Freq(new StringBuilder().append(channelfreq1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChannelFreq2() {
        int channelfreq2 = DataCanbus.DATA[33];
        if (channelfreq2 > 5000) {
            this.myButtons[1].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq2 / 100.0f)));
        } else if (channelfreq2 > 500 && channelfreq2 < 2000) {
            this.myButtons[1].setText_Freq(new StringBuilder().append(channelfreq2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChannelFreq3() {
        int channelfreq3 = DataCanbus.DATA[34];
        if (channelfreq3 > 5000) {
            this.myButtons[2].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq3 / 100.0f)));
        } else if (channelfreq3 > 500 && channelfreq3 < 2000) {
            this.myButtons[2].setText_Freq(new StringBuilder().append(channelfreq3).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChannelFreq4() {
        int channelfreq4 = DataCanbus.DATA[35];
        if (channelfreq4 > 5000) {
            this.myButtons[3].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq4 / 100.0f)));
        } else if (channelfreq4 > 500 && channelfreq4 < 2000) {
            this.myButtons[3].setText_Freq(new StringBuilder().append(channelfreq4).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChannelFreq5() {
        int channelfreq5 = DataCanbus.DATA[36];
        if (channelfreq5 > 5000) {
            this.myButtons[4].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq5 / 100.0f)));
        } else if (channelfreq5 > 500 && channelfreq5 < 2000) {
            this.myButtons[4].setText_Freq(new StringBuilder().append(channelfreq5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterChannelFreq6() {
        int channelfreq6 = DataCanbus.DATA[37];
        if (channelfreq6 > 5000) {
            this.myButtons[5].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq6 / 100.0f)));
        } else if (channelfreq6 > 500 && channelfreq6 < 2000) {
            this.myButtons[5].setText_Freq(new StringBuilder().append(channelfreq6).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMode() {
        int mode = DataCanbus.DATA[39];
        switch (mode) {
            case 0:
                ((TextView) findViewById(R.id.mode_text)).setVisibility(8);
                ((TextView) findViewById(R.id.mode_tv)).setVisibility(8);
                break;
            case 1:
                ((TextView) findViewById(R.id.mode_text)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_car_cd_remond);
                break;
            case 2:
                ((TextView) findViewById(R.id.mode_text)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_sbd_x80_file_random);
                break;
            case 3:
                ((TextView) findViewById(R.id.mode_text)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_sbd_x80_repeat);
                break;
            case 4:
                ((TextView) findViewById(R.id.mode_text)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_sbd_x80_file_repeat);
                break;
            case 5:
                ((TextView) findViewById(R.id.mode_text)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_sbd_x80_scan);
                break;
            case 6:
                ((TextView) findViewById(R.id.mode_text)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setVisibility(0);
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_sbd_x80_file_scan);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMediaState() {
        int pageIndex = DataCanbus.DATA[27];
        if (pageIndex == 2) {
            int mMediaState = DataCanbus.DATA[40];
            ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setVisibility(8);
            if (mMediaState == 5) {
                if (findViewById(R.id.cd_view).getVisibility() != 0) {
                    findViewById(R.id.cd_view).setVisibility(0);
                }
                if (findViewById(R.id.six_die_show_view).getVisibility() != 0) {
                    findViewById(R.id.six_die_show_view).setVisibility(0);
                }
                return;
            }
            if (findViewById(R.id.six_die_show_view).getVisibility() == 0) {
                findViewById(R.id.six_die_show_view).setVisibility(8);
            }
            if (findViewById(R.id.show_progress).getVisibility() != 8) {
                findViewById(R.id.show_progress).setVisibility(8);
            }
            if (mMediaState == 15) {
                if (findViewById(R.id.cd_view).getVisibility() == 0) {
                    findViewById(R.id.cd_view).setVisibility(8);
                }
                if (findViewById(R.id.radio_view).getVisibility() == 0) {
                    findViewById(R.id.radio_view).setVisibility(8);
                }
                if (findViewById(R.id.xuni_4info_view).getVisibility() != 0) {
                    findViewById(R.id.xuni_4info_view).setVisibility(0);
                    return;
                }
                return;
            }
            if (mMediaState == 3 || mMediaState == 4) {
                if (findViewById(R.id.cd_view).getVisibility() != 0) {
                    findViewById(R.id.cd_view).setVisibility(0);
                }
                if (findViewById(R.id.radio_view).getVisibility() == 0) {
                    findViewById(R.id.radio_view).setVisibility(8);
                }
                if (findViewById(R.id.xuni_4info_view).getVisibility() == 0) {
                    findViewById(R.id.xuni_4info_view).setVisibility(8);
                    return;
                }
                return;
            }
            if (findViewById(R.id.cd_view).getVisibility() == 0) {
                findViewById(R.id.cd_view).setVisibility(8);
            }
            if (findViewById(R.id.radio_view).getVisibility() == 0) {
                findViewById(R.id.radio_view).setVisibility(8);
            }
            if (findViewById(R.id.xuni_4info_view).getVisibility() == 0) {
                findViewById(R.id.xuni_4info_view).setVisibility(8);
            }
            ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setVisibility(0);
            switch (mMediaState) {
                case 0:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_2);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_6);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_7);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_8);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_9);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_10);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_11);
                    break;
                case 12:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_12);
                    break;
                case 13:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_13);
                    break;
                case 14:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_14);
                    break;
                case 16:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_15);
                    break;
                case 17:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_16);
                    break;
                case 18:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_17);
                    break;
                case 19:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_18);
                    break;
                case 20:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_19);
                    break;
                case 21:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_20);
                    break;
                case 22:
                    ((TextView) findViewById(R.id.cd_tip_show_center_tv)).setText(R.string.str_sbd_x80_media_state_21);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSongType() {
        int songType = DataCanbus.DATA[41];
        String mId3Info = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str1;
        int mMediaState = DataCanbus.DATA[40];
        int trackNum = DataCanbus.DATA[42];
        if (mMediaState == 3 || mMediaState == 4 || mMediaState == 5) {
            if (songType == 2 || songType == 3 || songType == 4) {
                if (mId3Info != null) {
                    ((TextView) findViewById(R.id.cd_title_show)).setText(mId3Info);
                }
            } else if (songType == 0 || songType == 1) {
                ((TextView) findViewById(R.id.cd_title_show)).setText("T" + trackNum);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrackNum() {
        int trackNum = DataCanbus.DATA[42];
        ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(trackNum).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFiles() {
        int files = DataCanbus.DATA[38];
        ((TextView) findViewById(R.id.file_num_tv)).setText(new StringBuilder().append(files).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPlayTime() {
        int playminute = DataCanbus.DATA[44];
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[45];
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        ((TextView) findViewById(R.id.time_tv)).setText(String.valueOf(playminute) + ":" + playsecond);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterInfo1() {
        String info1 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str2;
        this.cd4infoTv[0].setText(info1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterInfo2() {
        String info2 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str3;
        this.cd4infoTv[1].setText(info2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterInfo3() {
        String info3 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str4;
        this.cd4infoTv[2].setText(info3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterInfo4() {
        String info4 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str5;
        this.cd4infoTv[3].setText(info4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWhichSet() {
        int value = DataCanbus.DATA[61];
        if (value == 0) {
            for (int i = 0; i < 6; i++) {
                this.systemImage[i].setVisibility(8);
            }
            return;
        }
        for (int i2 = 1; i2 < 7; i2++) {
            if (value == i2) {
                this.systemImage[value - 1].setVisibility(0);
            } else {
                this.systemImage[i2 - 1].setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAlc() {
        int value = DataCanbus.DATA[62];
        if (value == 0) {
            ((TextView) findViewById(R.id.x80_alc_show_tv)).setText(R.string.klc_onstar_call_alarm_off);
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_alc_show_tv)).setText(R.string.str_sbd_x80_one_leavel);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.x80_alc_show_tv)).setText(R.string.str_sbd_x80_two_leavel);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.x80_alc_show_tv)).setText(R.string.str_sbd_x80_three_leavel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterXiangdu() {
        int value = DataCanbus.DATA[63];
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_deng_xiangdu_tv)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.x80_deng_xiangdu_tv)).setText(R.string.rzc_c4l_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPhoneVol() {
        int value = DataCanbus.DATA[64];
        ((TextView) findViewById(R.id.x80_phone_vol_tv)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatertishiVol() {
        int value = DataCanbus.DATA[65];
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_tishi_vo_tv)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.x80_tishi_vo_tv)).setText(R.string.rzc_c4l_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaidianShow() {
        int value = DataCanbus.DATA[66];
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_laidian_show_tv)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.x80_laidian_show_tv)).setText(R.string.rzc_c4l_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateryuyinSet() {
        int value = DataCanbus.DATA[67];
        if (value == 0) {
            ((TextView) findViewById(R.id.x80_yuyan_set_tv)).setText(R.string.xp_yinglang_car_set_first_str2);
        } else {
            ((TextView) findViewById(R.id.x80_yuyan_set_tv)).setText(R.string.xp_yinglang_car_set_first_str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterVol() {
        ((TextView) findViewById(R.id.cd_tip_vol)).setVisibility(0);
        LauncherApplication.getInstance().removeCallbacks(this.volrun);
        int muteValue = DataCanbus.DATA[60];
        if (muteValue == 1) {
            ((TextView) findViewById(R.id.cd_tip_vol)).setText(String.valueOf(getResources().getString(R.string.str_sbd_x80_yuanche_vol)) + "Mute");
        } else {
            int value = DataCanbus.DATA[59];
            ((TextView) findViewById(R.id.cd_tip_vol)).setText(String.valueOf(getResources().getString(R.string.str_sbd_x80_yuanche_vol)) + value);
        }
        LauncherApplication.getInstance().postDelayed(this.volrun, 3000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSoundShowID() {
        int value = DataCanbus.DATA[68];
        if (value == 0) {
            for (int i = 0; i < 6; i++) {
                this.soundImage[i].setVisibility(8);
            }
            return;
        }
        for (int i2 = 1; i2 < 7; i2++) {
            if (value == i2) {
                this.soundImage[value - 1].setVisibility(0);
            } else {
                this.soundImage[i2 - 1].setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSoundshengchang() {
        int value = DataCanbus.DATA[69];
        if (value == 0) {
            ((TextView) findViewById(R.id.x80_shengchang_tv)).setText(R.string.str_sbd_x80_shengchang_0);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.x80_shengchang_tv)).setText(R.string.str_sbd_x80_shengchang_1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.x80_shengchang_tv)).setText(R.string.str_sbd_x80_shengchang_2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSoundPrefect() {
        int value = DataCanbus.DATA[70];
        if (value == 0) {
            ((TextView) findViewById(R.id.x80_zuijiatingyinwei_tv)).setText(R.string.str_sbd_x80_zuijiatingyinwei_0);
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_zuijiatingyinwei_tv)).setText(R.string.str_sbd_x80_zuijiatingyinwei_1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.x80_zuijiatingyinwei_tv)).setText(R.string.str_sbd_x80_zuijiatingyinwei_2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.x80_zuijiatingyinwei_tv)).setText(R.string.str_sbd_x80_zuijiatingyinwei_3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSoundEQ() {
        int value = DataCanbus.DATA[71];
        if (value == 0) {
            ((TextView) findViewById(R.id.x80_eq_tv)).setText(R.string.str_sbd_x80_eq_0);
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_eq_tv)).setText(R.string.str_sbd_x80_eq_1);
            return;
        }
        if (value == 2) {
            ((TextView) findViewById(R.id.x80_eq_tv)).setText(R.string.str_sbd_x80_eq_2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.x80_eq_tv)).setText(R.string.str_sbd_x80_eq_3);
        } else if (value == 4) {
            ((TextView) findViewById(R.id.x80_eq_tv)).setText(R.string.str_sbd_x80_eq_4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSoundLow() {
        int value = DataCanbus.DATA[72];
        ((TextView) findViewById(R.id.x80_sound_low_tv)).setText(new StringBuilder().append(value - 7).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSoundMiddle() {
        int value = DataCanbus.DATA[73];
        ((TextView) findViewById(R.id.x80_sound_middle_tv)).setText(new StringBuilder().append(value - 7).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSoundHigh() {
        int value = DataCanbus.DATA[74];
        ((TextView) findViewById(R.id.x80_sound_high_tv)).setText(new StringBuilder().append(value - 7).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterIsReceiverData() {
        int value = DataCanbus.DATA[26];
        if (value == 1) {
            if (((TextView) findViewById(R.id.no_data_receiver_show)).getVisibility() != 0) {
                ((TextView) findViewById(R.id.no_data_receiver_show)).setVisibility(0);
            }
        } else if (((TextView) findViewById(R.id.no_data_receiver_show)).getVisibility() != 8) {
            ((TextView) findViewById(R.id.no_data_receiver_show)).setVisibility(8);
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
}
