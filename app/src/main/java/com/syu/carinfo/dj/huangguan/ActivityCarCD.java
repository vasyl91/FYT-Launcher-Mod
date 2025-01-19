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

public class ActivityCarCD extends BaseActivity implements View.OnClickListener {
    public static ActivityCarCD mInst;
    public static boolean mIsFront = false;
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 105:
                    ActivityCarCD.this.updateDiscId();
                    break;
                case 106:
                    ActivityCarCD.this.updatePlayTrack();
                    break;
                case 108:
                case 109:
                    ActivityCarCD.this.updatePlayMode();
                    break;
                case 110:
                case 111:
                    ActivityCarCD.this.updateDiscMode();
                    break;
                case 112:
                    ActivityCarCD.this.updaterPlayTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_429_dj_crown_carcd);
        init();
    }

    @Override
    public void init() {
        this.image[0] = findViewById(R.id.xuni_cd1_img);
        this.image[1] = findViewById(R.id.xuni_cd2_img);
        this.image[2] = findViewById(R.id.xuni_cd3_img);
        this.image[3] = findViewById(R.id.xuni_cd4_img);
        this.image[4] = findViewById(R.id.xuni_cd5_img);
        this.image[5] = findViewById(R.id.xuni_cd6_img);
        this.textView[0] = findViewById(R.id.xuni_cd1_text);
        this.textView[1] = findViewById(R.id.xuni_cd2_text);
        this.textView[2] = findViewById(R.id.xuni_cd3_text);
        this.textView[3] = findViewById(R.id.xuni_cd4_text);
        this.textView[4] = findViewById(R.id.xuni_cd5_text);
        this.textView[5] = findViewById(R.id.xuni_cd6_text);
        for (ImageView i : this.image) {
            if (i != null) {
                i.setOnClickListener(this);
            }
        }
        findViewById(R.id.jeep_btn_loop).setOnClickListener(this);
        findViewById(R.id.jeep_btn_random).setOnClickListener(this);
        setViewVisible(findViewById(R.id.jeep_btn_pause), false);
        setViewVisible(findViewById(R.id.jeep_btn_play), false);
        setSelfClick(findViewById(R.id.jeep_btn_ff), this);
        setSelfClick(findViewById(R.id.jeep_btn_fr), this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xuni_cd1_img /* 2131427610 */:
                DataCanbus.PROXY.cmd(0, 6, 1);
                break;
            case R.id.xuni_cd2_img /* 2131427611 */:
                DataCanbus.PROXY.cmd(0, 6, 2);
                break;
            case R.id.xuni_cd3_img /* 2131427612 */:
                DataCanbus.PROXY.cmd(0, 6, 3);
                break;
            case R.id.xuni_cd4_img /* 2131427613 */:
                DataCanbus.PROXY.cmd(0, 6, 4);
                break;
            case R.id.xuni_cd5_img /* 2131427614 */:
                DataCanbus.PROXY.cmd(0, 6, 5);
                break;
            case R.id.xuni_cd6_img /* 2131427615 */:
                DataCanbus.PROXY.cmd(0, 6, 6);
                break;
            case R.id.jeep_btn_fr /* 2131427622 */:
                DataCanbus.PROXY.cmd(2, 8, 1);
                DataCanbus.PROXY.cmd(2, 8, 0);
                break;
            case R.id.jeep_btn_ff /* 2131427623 */:
                DataCanbus.PROXY.cmd(2, 9, 1);
                DataCanbus.PROXY.cmd(2, 9, 0);
                break;
            case R.id.jeep_btn_loop /* 2131427737 */:
                if ((DataCanbus.DATA[108] & 1) == 1) {
                    DataCanbus.PROXY.cmd(0, 11, 0);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(0, 11, 1);
                    break;
                }
            case R.id.jeep_btn_random /* 2131427740 */:
                if (((DataCanbus.DATA[109] >> 1) & 1) == 1) {
                    DataCanbus.PROXY.cmd(0, 12, 0);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(0, 12, 1);
                    break;
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(1, 16);
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[1000] != 590253 && DataCanbus.DATA[1000] != 655789 && DataCanbus.DATA[1000] != 721325 && DataCanbus.DATA[1000] != 786861 && DataCanbus.DATA[1000] != 852397 && DataCanbus.DATA[1000] != 917933 && DataCanbus.DATA[1000] != 983469 && DataCanbus.DATA[98] != 2) {
            DataCanbus.PROXY.cmd(2, 7, 1);
            DataCanbus.PROXY.cmd(2, 7, 0);
        }
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateDiscId() {
        int disc = DataCanbus.DATA[105] & 255;
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

    
    public void updatePlayTrack() {
        int track = DataCanbus.DATA[106] & 255;
        if (findViewById(R.id.track_num_tv) != null) {
            ((TextView) findViewById(R.id.track_num_tv)).setText(String.valueOf(track));
        }
        if (findViewById(R.id.cd_title_show) != null) {
            ((TextView) findViewById(R.id.cd_title_show)).setText("TRACK: " + track);
        }
    }

    
    public void updatePlayMode() {
        int rep = DataCanbus.DATA[108];
        int random = DataCanbus.DATA[109];
        if (findViewById(R.id.mode_tv) != null) {
            if (rep == 1) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_rep_one);
            } else if (random == 1) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_disc_random);
            } else {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode1);
            }
        }
    }

    
    public void updateDiscMode() {
        int rep_disc = DataCanbus.DATA[110];
        int random_disc = DataCanbus.DATA[111];
        if (findViewById(R.id.file_num_tv) != null) {
            if (rep_disc == 1) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_all_disc_rep);
            } else if (random_disc == 1) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_all_disc_random);
            } else {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_disc_rep);
            }
        }
    }

    
    public void updaterPlayTime() {
        int playminute = (DataCanbus.DATA[112] >> 8) & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[112] & 255;
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        if (findViewById(R.id.time_tv) != null) {
            ((TextView) findViewById(R.id.time_tv)).setText(String.format("%02d:%02d", Integer.valueOf(playminute), Integer.valueOf(playsecond)));
        }
    }
}
