package com.syu.carinfo.camry2012.xp;

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
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ToyotaLexusActivityCarCD extends BaseActivity implements View.OnClickListener {
    public static ToyotaLexusActivityCarCD mInst;
    public static boolean mIsFront = false;
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 173:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                    ToyotaLexusActivityCarCD.this.updateDiscId();
                    break;
                case 174:
                    ToyotaLexusActivityCarCD.this.updatePlayTrack();
                    break;
                case 176:
                case 177:
                    ToyotaLexusActivityCarCD.this.updatePlayMode();
                    ToyotaLexusActivityCarCD.this.updateDiscMode();
                    break;
                case 180:
                    ToyotaLexusActivityCarCD.this.updaterPlayTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_429_dj_crown_carcd);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override
    public void init() {
        ((ImageView) findViewById(R.id.xuni_cd1_img)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.xuni_cd2_img)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.xuni_cd3_img)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.xuni_cd4_img)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.xuni_cd5_img)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.xuni_cd6_img)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnClickListener(this);
        ((Button) findViewById(R.id.jeep_btn_random)).setOnClickListener(this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_ff), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_fr), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_pause), this);
        setSelfClick((Button) findViewById(R.id.jeep_btn_play), this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jeep_btn_play /* 2131427585 */:
                DataCanbus.PROXY.cmd(42, 3, 0);
                break;
            case R.id.jeep_btn_pause /* 2131427586 */:
                DataCanbus.PROXY.cmd(42, 3, 0);
                break;
            case R.id.xuni_cd1_img /* 2131427610 */:
                if (DataCanbus.DATA[173] == 1) {
                    if (DataCanbus.DATA[214] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 1);
                    break;
                }
            case R.id.xuni_cd2_img /* 2131427611 */:
                if (DataCanbus.DATA[173] == 2) {
                    if (DataCanbus.DATA[215] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 2);
                    break;
                }
            case R.id.xuni_cd3_img /* 2131427612 */:
                if (DataCanbus.DATA[173] == 3) {
                    if (DataCanbus.DATA[216] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 3);
                    break;
                }
            case R.id.xuni_cd4_img /* 2131427613 */:
                if (DataCanbus.DATA[173] == 4) {
                    if (DataCanbus.DATA[217] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 4);
                    break;
                }
            case R.id.xuni_cd5_img /* 2131427614 */:
                if (DataCanbus.DATA[173] == 5) {
                    if (DataCanbus.DATA[218] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 5);
                    break;
                }
            case R.id.xuni_cd6_img /* 2131427615 */:
                if (DataCanbus.DATA[173] == 6) {
                    if (DataCanbus.DATA[219] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 6);
                    break;
                }
            case R.id.jeep_btn_fr /* 2131427622 */:
                DataCanbus.PROXY.cmd(42, 4, 0);
                break;
            case R.id.jeep_btn_ff /* 2131427623 */:
                DataCanbus.PROXY.cmd(42, 5, 0);
                break;
            case R.id.jeep_btn_loop /* 2131427737 */:
                DataCanbus.PROXY.cmd(42, 2, 0);
                break;
            case R.id.jeep_btn_random /* 2131427740 */:
                DataCanbus.PROXY.cmd(42, 1, 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(43, 98, 0);
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[181] != 2) {
            DataCanbus.PROXY.cmd(42, 32, 4);
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
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateDiscId() {
        int disc = DataCanbus.DATA[173] & 255;
        int num1 = DataCanbus.DATA[208];
        int num2 = DataCanbus.DATA[209];
        int num3 = DataCanbus.DATA[210];
        int num4 = DataCanbus.DATA[211];
        int num5 = DataCanbus.DATA[212];
        int num6 = DataCanbus.DATA[213];
        int disctype1 = DataCanbus.DATA[214];
        int disctype2 = DataCanbus.DATA[215];
        int disctype3 = DataCanbus.DATA[216];
        int disctype4 = DataCanbus.DATA[217];
        int disctype5 = DataCanbus.DATA[218];
        int disctype6 = DataCanbus.DATA[219];
        ((ImageView) findViewById(R.id.xuni_cd1_img)).setImageResource(R.drawable.ic_sbd_gray);
        ((TextView) findViewById(R.id.xuni_cd1_text)).setText(R.string.jeep_playstate1);
        ((ImageView) findViewById(R.id.xuni_cd2_img)).setImageResource(R.drawable.ic_sbd_gray);
        ((TextView) findViewById(R.id.xuni_cd2_text)).setText(R.string.jeep_playstate1);
        ((ImageView) findViewById(R.id.xuni_cd3_img)).setImageResource(R.drawable.ic_sbd_gray);
        ((TextView) findViewById(R.id.xuni_cd3_text)).setText(R.string.jeep_playstate1);
        ((ImageView) findViewById(R.id.xuni_cd4_img)).setImageResource(R.drawable.ic_sbd_gray);
        ((TextView) findViewById(R.id.xuni_cd4_text)).setText(R.string.jeep_playstate1);
        ((ImageView) findViewById(R.id.xuni_cd5_img)).setImageResource(R.drawable.ic_sbd_gray);
        ((TextView) findViewById(R.id.xuni_cd5_text)).setText(R.string.jeep_playstate1);
        ((ImageView) findViewById(R.id.xuni_cd6_img)).setImageResource(R.drawable.ic_sbd_gray);
        ((TextView) findViewById(R.id.xuni_cd6_text)).setText(R.string.jeep_playstate1);
        if (num1 == 1) {
            ((ImageView) findViewById(R.id.xuni_cd1_img)).setImageResource(R.drawable.ic_sbd_ready);
            if (disctype1 != 1) {
                ((TextView) findViewById(R.id.xuni_cd1_text)).setText("CD1");
            } else {
                ((TextView) findViewById(R.id.xuni_cd1_text)).setText("DVD1");
            }
        }
        if (num2 == 1) {
            ((ImageView) findViewById(R.id.xuni_cd2_img)).setImageResource(R.drawable.ic_sbd_ready);
            if (disctype2 != 1) {
                ((TextView) findViewById(R.id.xuni_cd2_text)).setText("CD2");
            } else {
                ((TextView) findViewById(R.id.xuni_cd2_text)).setText("DVD2");
            }
        }
        if (num3 == 1) {
            ((ImageView) findViewById(R.id.xuni_cd3_img)).setImageResource(R.drawable.ic_sbd_ready);
            if (disctype3 != 1) {
                ((TextView) findViewById(R.id.xuni_cd3_text)).setText("CD3");
            } else {
                ((TextView) findViewById(R.id.xuni_cd3_text)).setText("DVD3");
            }
        }
        if (num4 == 1) {
            ((ImageView) findViewById(R.id.xuni_cd4_img)).setImageResource(R.drawable.ic_sbd_ready);
            if (disctype4 != 1) {
                ((TextView) findViewById(R.id.xuni_cd4_text)).setText("CD4");
            } else {
                ((TextView) findViewById(R.id.xuni_cd4_text)).setText("DVD4");
            }
        }
        if (num5 == 1) {
            ((ImageView) findViewById(R.id.xuni_cd5_img)).setImageResource(R.drawable.ic_sbd_ready);
            if (disctype5 != 1) {
                ((TextView) findViewById(R.id.xuni_cd5_text)).setText("CD5");
            } else {
                ((TextView) findViewById(R.id.xuni_cd5_text)).setText("DVD5");
            }
        }
        if (num6 == 1) {
            ((ImageView) findViewById(R.id.xuni_cd6_img)).setImageResource(R.drawable.ic_sbd_ready);
            if (disctype6 != 1) {
                ((TextView) findViewById(R.id.xuni_cd6_text)).setText("CD6");
            } else {
                ((TextView) findViewById(R.id.xuni_cd6_text)).setText("DVD6");
            }
        }
        switch (disc) {
            case 1:
                ((ImageView) findViewById(R.id.xuni_cd1_img)).setImageResource(R.drawable.ic_sbd_play1);
                break;
            case 2:
                ((ImageView) findViewById(R.id.xuni_cd2_img)).setImageResource(R.drawable.ic_sbd_play1);
                break;
            case 3:
                ((ImageView) findViewById(R.id.xuni_cd3_img)).setImageResource(R.drawable.ic_sbd_play1);
                break;
            case 4:
                ((ImageView) findViewById(R.id.xuni_cd4_img)).setImageResource(R.drawable.ic_sbd_play1);
                break;
            case 5:
                ((ImageView) findViewById(R.id.xuni_cd5_img)).setImageResource(R.drawable.ic_sbd_play1);
                break;
            case 6:
                ((ImageView) findViewById(R.id.xuni_cd6_img)).setImageResource(R.drawable.ic_sbd_play1);
                break;
        }
    }

    
    public void updatePlayTrack() {
        int track = DataCanbus.DATA[174] & 255;
        if (((TextView) findViewById(R.id.track_num_tv)) != null) {
            ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(track).toString());
        }
        if (((TextView) findViewById(R.id.cd_title_show)) != null) {
            ((TextView) findViewById(R.id.cd_title_show)).setText("TRACK: " + track);
        }
    }

    
    public void updatePlayMode() {
        int rep = DataCanbus.DATA[176];
        int random = DataCanbus.DATA[177];
        if (((TextView) findViewById(R.id.mode_tv)) != null) {
            if (rep == 2) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_rep_one);
            } else if (random == 1) {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode4);
            } else {
                ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode1);
            }
        }
    }

    
    public void updateDiscMode() {
        int rep_disc = DataCanbus.DATA[176];
        if (((TextView) findViewById(R.id.file_num_tv)) != null) {
            if (rep_disc == 2) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.jeep_loop_off);
            } else {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_disc_rep);
            }
        }
    }

    
    public void updaterPlayTime() {
        int playminute = (DataCanbus.DATA[180] >> 8) & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[180] & 255;
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
