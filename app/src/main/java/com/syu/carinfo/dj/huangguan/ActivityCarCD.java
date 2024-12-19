package com.syu.carinfo.dj.huangguan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityCarCD extends BaseActivity implements View.OnClickListener {
    public static ActivityCarCD mInst;
    public static boolean mIsFront = false;
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.ActivityCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 57:
                    ActivityCarCD.this.updateDiscId();
                    break;
                case 58:
                    ActivityCarCD.this.updatePlayTrack();
                    break;
                case 60:
                case 61:
                    ActivityCarCD.this.updatePlayMode();
                    break;
                case 62:
                case 63:
                    ActivityCarCD.this.updateDiscMode();
                    break;
                case 64:
                    ActivityCarCD.this.updaterPlayTime();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_429_dj_crown_carcd);
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
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_random)).setOnClickListener(this);
        setViewVisible(findViewById(R.id.jeep_btn_pause), false);
        setViewVisible(findViewById(R.id.jeep_btn_play), false);
        setSelfClick((Button) findViewById(R.id.jeep_btn_ff), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_fr), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xuni_cd1_img /* 2131427598 */:
                DataCanbus.PROXY.cmd(0, 6, 1);
                break;
            case R.id.xuni_cd2_img /* 2131427599 */:
                DataCanbus.PROXY.cmd(0, 6, 2);
                break;
            case R.id.xuni_cd3_img /* 2131427600 */:
                DataCanbus.PROXY.cmd(0, 6, 3);
                break;
            case R.id.xuni_cd4_img /* 2131427601 */:
                DataCanbus.PROXY.cmd(0, 6, 4);
                break;
            case R.id.xuni_cd5_img /* 2131427602 */:
                DataCanbus.PROXY.cmd(0, 6, 5);
                break;
            case R.id.xuni_cd6_img /* 2131427603 */:
                DataCanbus.PROXY.cmd(0, 6, 6);
                break;
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(2, 8, 1);
                DataCanbus.PROXY.cmd(2, 8, 0);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(2, 9, 1);
                DataCanbus.PROXY.cmd(2, 9, 0);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                if ((DataCanbus.DATA[60] & 1) == 1) {
                    DataCanbus.PROXY.cmd(0, 11, 0);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(0, 11, 1);
                    break;
                }
            case R.id.jeep_btn_random /* 2131428348 */:
                if (((DataCanbus.DATA[61] >> 1) & 1) == 1) {
                    DataCanbus.PROXY.cmd(0, 12, 0);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(0, 12, 1);
                    break;
                }
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(1, 16);
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[1000] != 590253 && DataCanbus.DATA[1000] != 655789 && DataCanbus.DATA[1000] != 721325 && DataCanbus.DATA[1000] != 786861 && DataCanbus.DATA[1000] != 852397 && DataCanbus.DATA[1000] != 917933 && DataCanbus.DATA[1000] != 983469 && DataCanbus.DATA[50] != 2) {
            DataCanbus.PROXY.cmd(2, 7, 1);
            DataCanbus.PROXY.cmd(2, 7, 0);
        }
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
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDiscId() {
        int disc = DataCanbus.DATA[57] & 255;
        if (disc >= 1 && disc <= 6) {
            for (int i = 0; i < 6; i++) {
                if (i == disc - 1) {
                    if (this.textView[disc - 1] != null) {
                        this.textView[disc - 1].setText(R.string.str_sbd_x80_media_state_22);
                    }
                    if (this.image[disc - 1] != null) {
                        this.image[disc - 1].setImageResource(R.drawable.ic_sbd_play1);
                    }
                } else {
                    if (this.textView[disc - 1] != null) {
                        this.textView[i].setText("CD" + (i + 1));
                    }
                    if (this.image[disc - 1] != null) {
                        this.image[i].setImageResource(R.drawable.ic_sbd_gray);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayTrack() {
        int track = DataCanbus.DATA[58] & 255;
        if (((TextView) findViewById(R.id.track_num_tv)) != null) {
            ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(track).toString());
        }
        if (((TextView) findViewById(R.id.cd_title_show)) != null) {
            ((TextView) findViewById(R.id.cd_title_show)).setText("TRACK: " + track);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayMode() {
        int rep = DataCanbus.DATA[60];
        int random = DataCanbus.DATA[61];
        if (((TextView) findViewById(R.id.mode_tv)) != null) {
            if (rep == 1) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_rep_one);
            } else if (random == 1) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_disc_random);
            } else {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDiscMode() {
        int rep_disc = DataCanbus.DATA[62];
        int random_disc = DataCanbus.DATA[63];
        if (((TextView) findViewById(R.id.file_num_tv)) != null) {
            if (rep_disc == 1) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_all_disc_rep);
            } else if (random_disc == 1) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_all_disc_random);
            } else {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_disc_rep);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPlayTime() {
        int playminute = (DataCanbus.DATA[64] >> 8) & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[64] & 255;
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        if (((TextView) findViewById(R.id.time_tv)) != null) {
            ((TextView) findViewById(R.id.time_tv)).setText(String.format("%02d:%02d", Integer.valueOf(playminute), Integer.valueOf(playsecond)));
        }
    }
}
