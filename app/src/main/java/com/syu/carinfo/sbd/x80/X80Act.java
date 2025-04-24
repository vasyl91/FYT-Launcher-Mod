package com.syu.carinfo.sbd.x80;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.loopview.MessageHandler;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0375_SBD_WC1_ReservedCdBenTengX80;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class X80Act extends BaseActivity {
    private MyButton[] myButtons = new MyButton[6];
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    MyProgressBar[] progressBar = new MyProgressBar[6];
    private TextView[] cd4infoTv = new TextView[4];
    ImageView[] systemImage = new ImageView[6];
    ImageView[] soundImage = new ImageView[6];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    X80Act.this.updaterIsReceiverData();
                    break;
                case 100:
                    X80Act.this.updaterMediaState();
                    X80Act.this.updaterShowPage();
                    break;
                case 101:
                    X80Act.this.updaterdiantaiNum();
                    break;
                case 102:
                    X80Act.this.updaterband();
                    break;
                case 104:
                    X80Act.this.updaterFreq();
                    break;
                case 105:
                    X80Act.this.updaterChannelFreq1();
                    break;
                case 106:
                    X80Act.this.updaterChannelFreq2();
                    break;
                case 107:
                    X80Act.this.updaterChannelFreq3();
                    break;
                case 108:
                    X80Act.this.updaterChannelFreq4();
                    break;
                case 109:
                    X80Act.this.updaterChannelFreq5();
                    break;
                case 110:
                    X80Act.this.updaterChannelFreq6();
                    break;
                case 111:
                    X80Act.this.updaterFiles();
                    break;
                case 112:
                    X80Act.this.updaterMode();
                    break;
                case 113:
                    X80Act.this.updaterMediaState();
                    X80Act.this.updaterSongType();
                    break;
                case 114:
                    X80Act.this.updaterSongType();
                    break;
                case 115:
                    X80Act.this.updaterSongType();
                    X80Act.this.updaterTrackNum();
                    break;
                case 116:
                    X80Act.this.updaterSongType();
                    break;
                case 117:
                    X80Act.this.updaterPlayTime();
                    break;
                case 118:
                    X80Act.this.updaterPlayTime();
                    break;
                case 119:
                    X80Act.this.updaterInfo1();
                    break;
                case 120:
                    X80Act.this.updaterInfo2();
                    break;
                case 121:
                    X80Act.this.updaterInfo3();
                    break;
                case 122:
                    X80Act.this.updaterInfo4();
                    break;
                case 123:
                    X80Act.this.updaterxuniDie();
                    break;
                case 124:
                    X80Act.this.updaterxuniDie();
                    break;
                case 125:
                    X80Act.this.updaterxuniDie();
                    break;
                case 126:
                    X80Act.this.updaterxuniDie();
                    break;
                case 127:
                    X80Act.this.updaterxuniDie();
                    break;
                case 128:
                    X80Act.this.updaterxuniDie();
                    break;
                case 129:
                    X80Act.this.updaterxuniDie();
                    break;
                case 130:
                    X80Act.this.updaterxuniDie();
                    break;
                case 131:
                    X80Act.this.updaterxuniDie();
                    break;
                case 132:
                    X80Act.this.updaterVol();
                    break;
                case 133:
                    X80Act.this.updaterVol();
                    break;
                case 134:
                    X80Act.this.updaterWhichSet();
                    break;
                case 135:
                    X80Act.this.updaterAlc();
                    break;
                case 136:
                    X80Act.this.updaterXiangdu();
                    break;
                case 137:
                    X80Act.this.updaterPhoneVol();
                    break;
                case 138:
                    X80Act.this.updatertishiVol();
                    break;
                case 139:
                    X80Act.this.updaterlaidianShow();
                    break;
                case 140:
                    X80Act.this.updateryuyinSet();
                    break;
                case 141:
                    X80Act.this.updaterSoundShowID();
                    break;
                case 142:
                    X80Act.this.updaterSoundshengchang();
                    break;
                case 143:
                    X80Act.this.updaterSoundPrefect();
                    break;
                case 144:
                    X80Act.this.updaterSoundEQ();
                    break;
                case 145:
                    X80Act.this.updaterSoundLow();
                    break;
                case 146:
                    X80Act.this.updaterSoundMiddle();
                    break;
                case 147:
                    X80Act.this.updaterSoundHigh();
                    break;
            }
        }
    };
    Runnable volrun = new Runnable() { 
        @Override
        public void run() {
            ((TextView) X80Act.this.findViewById(R.id.cd_tip_vol)).setVisibility(8);
        }
    };
    Toast toast = null;
    TextView view = null;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_375_wc_sbd_x80);
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
            this.myButtons[i].setTextSize_Freq(30);
            this.myButtons[i].setTextColor_Freq(-1);
            this.myButtons[i].setText_Freq("87.50");
            this.myButtons[i].setGravity_Freq(17);
            this.myButtons[i].setBackgroundResource(R.drawable.ic_sbd_freq_n);
        }
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterxuniDie() {
        int luzhiIndex = DataCanbus.DATA[123];
        int jindu = DataCanbus.DATA[125];
        int playIndex = DataCanbus.DATA[124];
        int[] dieInt = {DataCanbus.DATA[131], DataCanbus.DATA[130], DataCanbus.DATA[129], DataCanbus.DATA[128], DataCanbus.DATA[127], DataCanbus.DATA[126]};
        if (luzhiIndex >= 1 && luzhiIndex <= 6) {
            if (jindu >= 0 && jindu < 100) {
                if (findViewById(R.id.show_progress).getVisibility() != 0 && DataCanbus.DATA[100] == 2) {
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

    
    public void updaterShowPage() {
        int PageIndex = DataCanbus.DATA[100];
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
            if ((findViewById(R.id.cd_view).getVisibility() == 8 || findViewById(R.id.cd_view).getVisibility() == 4) && (DataCanbus.DATA[113] == 3 || DataCanbus.DATA[113] == 4)) {
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

    
    public void updaterdiantaiNum() {
        int channel = DataCanbus.DATA[101];
        for (int i = 0; i < 6; i++) {
            if (i == channel - 1) {
                this.myButtons[channel - 1].setBackgroundResource(R.drawable.ic_sbd_freq_p);
            } else {
                this.myButtons[i].setBackgroundResource(R.drawable.ic_sbd_freq_n);
            }
        }
    }

    
    public void updaterband() {
        int band = DataCanbus.DATA[102];
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

    
    public void updaterFreq() {
        int freq = DataCanbus.DATA[104];
        if (freq > 5000) {
            ((TextView) findViewById(R.id.curfre)).setText(String.format("%.02f", Float.valueOf(freq / 100.0f)));
        } else if (freq > 500 && freq < 2000) {
            ((TextView) findViewById(R.id.curfre)).setText(new StringBuilder().append(freq).toString());
        }
    }

    
    public void updaterChannelFreq1() {
        int channelfreq1 = DataCanbus.DATA[105];
        if (channelfreq1 > 5000) {
            this.myButtons[0].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq1 / 100.0f)));
        } else if (channelfreq1 > 500 && channelfreq1 < 2000) {
            this.myButtons[0].setText_Freq(new StringBuilder().append(channelfreq1).toString());
        }
    }

    
    public void updaterChannelFreq2() {
        int channelfreq2 = DataCanbus.DATA[106];
        if (channelfreq2 > 5000) {
            this.myButtons[1].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq2 / 100.0f)));
        } else if (channelfreq2 > 500 && channelfreq2 < 2000) {
            this.myButtons[1].setText_Freq(new StringBuilder().append(channelfreq2).toString());
        }
    }

    
    public void updaterChannelFreq3() {
        int channelfreq3 = DataCanbus.DATA[107];
        if (channelfreq3 > 5000) {
            this.myButtons[2].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq3 / 100.0f)));
        } else if (channelfreq3 > 500 && channelfreq3 < 2000) {
            this.myButtons[2].setText_Freq(new StringBuilder().append(channelfreq3).toString());
        }
    }

    
    public void updaterChannelFreq4() {
        int channelfreq4 = DataCanbus.DATA[108];
        if (channelfreq4 > 5000) {
            this.myButtons[3].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq4 / 100.0f)));
        } else if (channelfreq4 > 500 && channelfreq4 < 2000) {
            this.myButtons[3].setText_Freq(new StringBuilder().append(channelfreq4).toString());
        }
    }

    
    public void updaterChannelFreq5() {
        int channelfreq5 = DataCanbus.DATA[109];
        if (channelfreq5 > 5000) {
            this.myButtons[4].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq5 / 100.0f)));
        } else if (channelfreq5 > 500 && channelfreq5 < 2000) {
            this.myButtons[4].setText_Freq(new StringBuilder().append(channelfreq5).toString());
        }
    }

    
    public void updaterChannelFreq6() {
        int channelfreq6 = DataCanbus.DATA[110];
        if (channelfreq6 > 5000) {
            this.myButtons[5].setText_Freq(String.format("%.02f", Float.valueOf(channelfreq6 / 100.0f)));
        } else if (channelfreq6 > 500 && channelfreq6 < 2000) {
            this.myButtons[5].setText_Freq(new StringBuilder().append(channelfreq6).toString());
        }
    }

    
    public void updaterMode() {
        int mode = DataCanbus.DATA[112];
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

    
    public void updaterMediaState() {
        int pageIndex = DataCanbus.DATA[100];
        if (pageIndex == 2) {
            int mMediaState = DataCanbus.DATA[113];
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

    
    public void updaterSongType() {
        int songType = DataCanbus.DATA[114];
        String mId3Info = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str1;
        int mMediaState = DataCanbus.DATA[113];
        int trackNum = DataCanbus.DATA[115];
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

    
    public void updaterTrackNum() {
        int trackNum = DataCanbus.DATA[115];
        ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(trackNum).toString());
    }

    
    public void updaterFiles() {
        int files = DataCanbus.DATA[111];
        ((TextView) findViewById(R.id.file_num_tv)).setText(new StringBuilder().append(files).toString());
    }

    
    public void updaterPlayTime() {
        int playminute = DataCanbus.DATA[117];
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[118];
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        ((TextView) findViewById(R.id.time_tv)).setText(String.valueOf(playminute) + ":" + playsecond);
    }

    
    public void updaterInfo1() {
        String info1 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str2;
        this.cd4infoTv[0].setText(info1);
    }

    
    public void updaterInfo2() {
        String info2 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str3;
        this.cd4infoTv[1].setText(info2);
    }

    
    public void updaterInfo3() {
        String info3 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str4;
        this.cd4infoTv[2].setText(info3);
    }

    
    public void updaterInfo4() {
        String info4 = Callback_0375_SBD_WC1_ReservedCdBenTengX80.Str5;
        this.cd4infoTv[3].setText(info4);
    }

    
    public void updaterWhichSet() {
        int value = DataCanbus.DATA[134];
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

    
    public void updaterAlc() {
        int value = DataCanbus.DATA[135];
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

    
    public void updaterXiangdu() {
        int value = DataCanbus.DATA[136];
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_deng_xiangdu_tv)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.x80_deng_xiangdu_tv)).setText(R.string.rzc_c4l_close);
        }
    }

    
    public void updaterPhoneVol() {
        int value = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.x80_phone_vol_tv)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updatertishiVol() {
        int value = DataCanbus.DATA[138];
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_tishi_vo_tv)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.x80_tishi_vo_tv)).setText(R.string.rzc_c4l_close);
        }
    }

    
    public void updaterlaidianShow() {
        int value = DataCanbus.DATA[139];
        if (value == 1) {
            ((TextView) findViewById(R.id.x80_laidian_show_tv)).setText(R.string.rzc_c4l_open);
        } else {
            ((TextView) findViewById(R.id.x80_laidian_show_tv)).setText(R.string.rzc_c4l_close);
        }
    }

    
    public void updateryuyinSet() {
        int value = DataCanbus.DATA[140];
        if (value == 0) {
            ((TextView) findViewById(R.id.x80_yuyan_set_tv)).setText(R.string.xp_yinglang_car_set_first_str2);
        } else {
            ((TextView) findViewById(R.id.x80_yuyan_set_tv)).setText(R.string.xp_yinglang_car_set_first_str3);
        }
    }

    
    public void updaterVol() {
        ((TextView) findViewById(R.id.cd_tip_vol)).setVisibility(0);
        LauncherApplication.getInstance().removeCallbacks(this.volrun);
        int muteValue = DataCanbus.DATA[133];
        if (muteValue == 1) {
            ((TextView) findViewById(R.id.cd_tip_vol)).setText(String.valueOf(getResources().getString(R.string.str_sbd_x80_yuanche_vol)) + "Mute");
        } else {
            int value = DataCanbus.DATA[132];
            ((TextView) findViewById(R.id.cd_tip_vol)).setText(String.valueOf(getResources().getString(R.string.str_sbd_x80_yuanche_vol)) + value);
        }
        LauncherApplication.getInstance().postDelayed(this.volrun, MessageHandler.WHAT_ITEM_SELECTED);
    }

    
    public void updaterSoundShowID() {
        int value = DataCanbus.DATA[141];
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

    
    public void updaterSoundshengchang() {
        int value = DataCanbus.DATA[142];
        if (value == 0) {
            ((TextView) findViewById(R.id.x80_shengchang_tv)).setText(R.string.str_sbd_x80_shengchang_0);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.x80_shengchang_tv)).setText(R.string.str_sbd_x80_shengchang_1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.x80_shengchang_tv)).setText(R.string.str_sbd_x80_shengchang_2);
        }
    }

    
    public void updaterSoundPrefect() {
        int value = DataCanbus.DATA[143];
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

    
    public void updaterSoundEQ() {
        int value = DataCanbus.DATA[144];
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

    
    public void updaterSoundLow() {
        int value = DataCanbus.DATA[145];
        ((TextView) findViewById(R.id.x80_sound_low_tv)).setText(new StringBuilder().append(value - 7).toString());
    }

    
    public void updaterSoundMiddle() {
        int value = DataCanbus.DATA[146];
        ((TextView) findViewById(R.id.x80_sound_middle_tv)).setText(new StringBuilder().append(value - 7).toString());
    }

    
    public void updaterSoundHigh() {
        int value = DataCanbus.DATA[147];
        ((TextView) findViewById(R.id.x80_sound_high_tv)).setText(new StringBuilder().append(value - 7).toString());
    }

    
    public void updaterIsReceiverData() {
        int value = DataCanbus.DATA[99];
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
