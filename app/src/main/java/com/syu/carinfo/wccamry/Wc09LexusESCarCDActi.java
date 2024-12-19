package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0294_WC2_TOYOTA_ALL;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc09LexusESCarCDActi extends BaseActivity implements View.OnClickListener {
    public static Wc09LexusESCarCDActi mInst;
    public static boolean mIsFront = false;
    protected Handler mHandler;
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.Wc09LexusESCarCDActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_sbd_play1;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 96:
                case 109:
                    Wc09LexusESCarCDActi.this.updateDiscId();
                    break;
                case 97:
                    ImageView imageView = (ImageView) Wc09LexusESCarCDActi.this.findViewById(R.id.xuni_cd1_img);
                    if (value != 1) {
                        i = 2130840836;
                    }
                    imageView.setImageResource(i);
                    break;
                case 98:
                    ImageView imageView2 = (ImageView) Wc09LexusESCarCDActi.this.findViewById(R.id.xuni_cd2_img);
                    if (value != 1) {
                        i = 2130840836;
                    }
                    imageView2.setImageResource(i);
                    break;
                case 99:
                    ImageView imageView3 = (ImageView) Wc09LexusESCarCDActi.this.findViewById(R.id.xuni_cd3_img);
                    if (value != 1) {
                        i = 2130840836;
                    }
                    imageView3.setImageResource(i);
                    break;
                case 100:
                    ImageView imageView4 = (ImageView) Wc09LexusESCarCDActi.this.findViewById(R.id.xuni_cd4_img);
                    if (value != 1) {
                        i = 2130840836;
                    }
                    imageView4.setImageResource(i);
                    break;
                case 101:
                    ImageView imageView5 = (ImageView) Wc09LexusESCarCDActi.this.findViewById(R.id.xuni_cd5_img);
                    if (value != 1) {
                        i = 2130840836;
                    }
                    imageView5.setImageResource(i);
                    break;
                case 102:
                    ImageView imageView6 = (ImageView) Wc09LexusESCarCDActi.this.findViewById(R.id.xuni_cd6_img);
                    if (value != 1) {
                        i = 2130840836;
                    }
                    imageView6.setImageResource(i);
                    break;
                case 103:
                case 105:
                case 107:
                    Wc09LexusESCarCDActi.this.updatePlayMode();
                    break;
                case 104:
                case 106:
                case 108:
                    Wc09LexusESCarCDActi.this.updateDiscMode();
                    break;
                case 110:
                    Wc09LexusESCarCDActi.this.updatePlayTrack();
                    break;
                case 111:
                case 112:
                    Wc09LexusESCarCDActi.this.updaterPlayTime();
                    break;
                case 113:
                    Wc09LexusESCarCDActi.this.updateCDTitle();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_429_dj_crown_carcd);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        this.textView[5] = (TextView) findViewById(R.id.xuni_cd6_text);
        for (ImageView i : this.image) {
            if (i != null) {
                i.setOnClickListener(this);
            }
        }
        findViewById(R.id.jeep_btn_prev).setVisibility(0);
        findViewById(R.id.jeep_btn_next).setVisibility(0);
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_random)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_prev)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_next)).setOnClickListener(this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_ff), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_fr), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_pause), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_play), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jeep_btn_prev /* 2131427574 */:
                DataCanbus.PROXY.cmd(30, 6, 1);
                break;
            case R.id.jeep_btn_play /* 2131427575 */:
                DataCanbus.PROXY.cmd(30, 1, 0);
                break;
            case R.id.jeep_btn_pause /* 2131427576 */:
                DataCanbus.PROXY.cmd(30, 2, 0);
                break;
            case R.id.jeep_btn_next /* 2131427577 */:
                DataCanbus.PROXY.cmd(30, 6, 0);
                break;
            case R.id.xuni_cd1_img /* 2131427598 */:
                DataCanbus.PROXY.cmd(30, 9, 1);
                break;
            case R.id.xuni_cd2_img /* 2131427599 */:
                DataCanbus.PROXY.cmd(30, 9, 2);
                break;
            case R.id.xuni_cd3_img /* 2131427600 */:
                DataCanbus.PROXY.cmd(30, 9, 3);
                break;
            case R.id.xuni_cd4_img /* 2131427601 */:
                DataCanbus.PROXY.cmd(30, 9, 4);
                break;
            case R.id.xuni_cd5_img /* 2131427602 */:
                DataCanbus.PROXY.cmd(30, 9, 5);
                break;
            case R.id.xuni_cd6_img /* 2131427603 */:
                DataCanbus.PROXY.cmd(30, 9, 6);
                break;
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(30, 7, 1);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(30, 7, 0);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                if (DataCanbus.DATA[105] == 0) {
                    DataCanbus.PROXY.cmd(30, 3, 1);
                    break;
                } else if (DataCanbus.DATA[105] == 1) {
                    DataCanbus.PROXY.cmd(30, 3, 2);
                    break;
                } else if (DataCanbus.DATA[106] == 1) {
                    DataCanbus.PROXY.cmd(30, 3, 0);
                    break;
                }
            case R.id.jeep_btn_random /* 2131428348 */:
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(30, 5, 1);
                    break;
                } else if (DataCanbus.DATA[107] == 1) {
                    DataCanbus.PROXY.cmd(30, 5, 2);
                    break;
                } else if (DataCanbus.DATA[108] == 1) {
                    DataCanbus.PROXY.cmd(30, 5, 0);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDiscId() {
        int disc = DataCanbus.DATA[96];
        int workstate = DataCanbus.DATA[109];
        ((TextView) findViewById(R.id.xuni_cd1_text)).setText("CD1");
        ((TextView) findViewById(R.id.xuni_cd2_text)).setText("CD2");
        ((TextView) findViewById(R.id.xuni_cd3_text)).setText("CD3");
        ((TextView) findViewById(R.id.xuni_cd4_text)).setText("CD4");
        ((TextView) findViewById(R.id.xuni_cd5_text)).setText("CD5");
        ((TextView) findViewById(R.id.xuni_cd6_text)).setText("CD6");
        ((TextView) findViewById(R.id.xuni_cd1_text)).setTextColor(-1);
        ((TextView) findViewById(R.id.xuni_cd2_text)).setTextColor(-1);
        ((TextView) findViewById(R.id.xuni_cd3_text)).setTextColor(-1);
        ((TextView) findViewById(R.id.xuni_cd4_text)).setTextColor(-1);
        ((TextView) findViewById(R.id.xuni_cd5_text)).setTextColor(-1);
        ((TextView) findViewById(R.id.xuni_cd6_text)).setTextColor(-1);
        switch (disc) {
            case 1:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("CD1");
                ((TextView) findViewById(R.id.xuni_cd1_text)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("CD2");
                ((TextView) findViewById(R.id.xuni_cd2_text)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("CD3");
                ((TextView) findViewById(R.id.xuni_cd3_text)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("CD4");
                ((TextView) findViewById(R.id.xuni_cd4_text)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("CD5");
                ((TextView) findViewById(R.id.xuni_cd5_text)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("CD6");
                ((TextView) findViewById(R.id.xuni_cd6_text)).setTextColor(-65536);
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            default:
                ((TextView) findViewById(R.id.cd_title_show)).setText("CD");
                break;
            case 15:
                ((TextView) findViewById(R.id.cd_title_show)).setText("CD");
                break;
        }
        switch (workstate) {
            case 0:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Reading TOC");
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Play");
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Fast");
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("User search");
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Internal search");
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Stop");
                break;
            case 7:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Rom read");
                break;
            case 8:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Rom search");
                break;
            case 9:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Retrieving");
                break;
            case 10:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Disc changing(User)");
                break;
            case 11:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Disc changing(Internal)");
                break;
            case 12:
                ((TextView) findViewById(R.id.cd_disc_num)).setText("Eject");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCDTitle() {
        if (((TextView) findViewById(R.id.cd_title_show)) != null) {
            ((TextView) findViewById(R.id.cd_title_show)).setText(Callback_0294_WC2_TOYOTA_ALL.CarCdTitle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayTrack() {
        int track = DataCanbus.DATA[110] & 255;
        if (((TextView) findViewById(R.id.track_num_tv)) != null) {
            ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(track).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayMode() {
        int scan = DataCanbus.DATA[103];
        int repeat = DataCanbus.DATA[105];
        int random = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.mode_tv)) != null) {
            if (scan != 0) {
                ((TextView) findViewById(R.id.mode_tv)).setText("Scan");
                return;
            }
            if (repeat != 0) {
                ((TextView) findViewById(R.id.mode_tv)).setText("Repeat");
            } else if (random != 0) {
                ((TextView) findViewById(R.id.mode_tv)).setText("Random");
            } else {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDiscMode() {
        int scan = DataCanbus.DATA[104];
        int repeat = DataCanbus.DATA[106];
        int random = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.file_num_tv)) != null) {
            if (scan != 0) {
                ((TextView) findViewById(R.id.file_num_tv)).setText("Scan");
                return;
            }
            if (repeat != 0) {
                ((TextView) findViewById(R.id.file_num_tv)).setText("Repeat");
            } else if (random != 0) {
                ((TextView) findViewById(R.id.file_num_tv)).setText("Random");
            } else {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.xp_380_playmode1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPlayTime() {
        int playminute = DataCanbus.DATA[111] & 255;
        int playsecond = DataCanbus.DATA[112] & 255;
        if (((TextView) findViewById(R.id.time_tv)) != null) {
            ((TextView) findViewById(R.id.time_tv)).setText(String.format("%02d:%02d", Integer.valueOf(playminute), Integer.valueOf(playsecond)));
        }
    }
}
