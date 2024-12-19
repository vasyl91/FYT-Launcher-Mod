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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ToyotaLexusActivityCarCD extends BaseActivity implements View.OnClickListener {
    public static ToyotaLexusActivityCarCD mInst;
    public static boolean mIsFront = false;
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.ToyotaLexusActivityCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 170:
                case 224:
                case 225:
                case 226:
                case 227:
                case 228:
                case 229:
                case 230:
                case 231:
                case 232:
                case 233:
                case 234:
                case 235:
                    ToyotaLexusActivityCarCD.this.updateDiscId();
                    break;
                case 171:
                    ToyotaLexusActivityCarCD.this.updatePlayTrack();
                    break;
                case 173:
                case 174:
                    ToyotaLexusActivityCarCD.this.updatePlayMode();
                    ToyotaLexusActivityCarCD.this.updateDiscMode();
                    break;
                case 177:
                    ToyotaLexusActivityCarCD.this.updaterPlayTime();
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jeep_btn_play /* 2131427575 */:
                DataCanbus.PROXY.cmd(42, 3, 0);
                break;
            case R.id.jeep_btn_pause /* 2131427576 */:
                DataCanbus.PROXY.cmd(42, 3, 0);
                break;
            case R.id.xuni_cd1_img /* 2131427598 */:
                if (DataCanbus.DATA[170] == 1) {
                    if (DataCanbus.DATA[230] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 1);
                    break;
                }
            case R.id.xuni_cd2_img /* 2131427599 */:
                if (DataCanbus.DATA[170] == 2) {
                    if (DataCanbus.DATA[231] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 2);
                    break;
                }
            case R.id.xuni_cd3_img /* 2131427600 */:
                if (DataCanbus.DATA[170] == 3) {
                    if (DataCanbus.DATA[232] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 3);
                    break;
                }
            case R.id.xuni_cd4_img /* 2131427601 */:
                if (DataCanbus.DATA[170] == 4) {
                    if (DataCanbus.DATA[233] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 4);
                    break;
                }
            case R.id.xuni_cd5_img /* 2131427602 */:
                if (DataCanbus.DATA[170] == 5) {
                    if (DataCanbus.DATA[234] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 5);
                    break;
                }
            case R.id.xuni_cd6_img /* 2131427603 */:
                if (DataCanbus.DATA[170] == 6) {
                    if (DataCanbus.DATA[235] == 1) {
                        DataCanbus.PROXY.cmd(42, 50, 0);
                        break;
                    }
                } else {
                    DataCanbus.PROXY.cmd(42, 8, 6);
                    break;
                }
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(42, 4, 0);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(42, 5, 0);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                DataCanbus.PROXY.cmd(42, 2, 0);
                break;
            case R.id.jeep_btn_random /* 2131428348 */:
                DataCanbus.PROXY.cmd(42, 1, 0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(43, 98, 0);
        FuncMain.setChannel(13);
        if (DataCanbus.DATA[178] != 2) {
            DataCanbus.PROXY.cmd(42, 32, 4);
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
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDiscId() {
        int disc = DataCanbus.DATA[170] & 255;
        int num1 = DataCanbus.DATA[224];
        int num2 = DataCanbus.DATA[225];
        int num3 = DataCanbus.DATA[226];
        int num4 = DataCanbus.DATA[227];
        int num5 = DataCanbus.DATA[228];
        int num6 = DataCanbus.DATA[229];
        int disctype1 = DataCanbus.DATA[230];
        int disctype2 = DataCanbus.DATA[231];
        int disctype3 = DataCanbus.DATA[232];
        int disctype4 = DataCanbus.DATA[233];
        int disctype5 = DataCanbus.DATA[234];
        int disctype6 = DataCanbus.DATA[235];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayTrack() {
        int track = DataCanbus.DATA[171] & 255;
        if (((TextView) findViewById(R.id.track_num_tv)) != null) {
            ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(track).toString());
        }
        if (((TextView) findViewById(R.id.cd_title_show)) != null) {
            ((TextView) findViewById(R.id.cd_title_show)).setText("TRACK: " + track);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayMode() {
        int rep = DataCanbus.DATA[173];
        int random = DataCanbus.DATA[174];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDiscMode() {
        int rep_disc = DataCanbus.DATA[173];
        if (((TextView) findViewById(R.id.file_num_tv)) != null) {
            if (rep_disc == 2) {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.jeep_loop_off);
            } else {
                ((TextView) findViewById(R.id.file_num_tv)).setText(R.string.str_388_disc_rep);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPlayTime() {
        int playminute = (DataCanbus.DATA[177] >> 8) & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[177] & 255;
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
