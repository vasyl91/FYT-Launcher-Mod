package com.syu.carinfo.wc.crown;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_420_crown_CarCD extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    public static boolean mIsFront = false;
    static int sHasDisc = 0;
    static int sDiscNum = 0;
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    int rep_disc = 0;
    int rep = 0;
    int random_disc = 0;
    int random = 0;
    int scan_disc = 0;
    int scan = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.crown.Wc_420_crown_CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 67:
                    Wc_420_crown_CarCD.this.updaterDiscState();
                    break;
                case 69:
                    Wc_420_crown_CarCD.this.updaterDiscState();
                    break;
                case 70:
                    Wc_420_crown_CarCD.this.updaterPlayTime();
                    break;
                case 71:
                    Wc_420_crown_CarCD.this.updaterFiles();
                    break;
                case 72:
                    Wc_420_crown_CarCD.this.updaterMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_420_wc_crown_carcd);
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
        findViewById(R.id.jeep_btn_loop).setOnClickListener(this);
        findViewById(R.id.jeep_btn_ff).setOnClickListener(this);
        findViewById(R.id.jeep_btn_play).setOnClickListener(this);
        findViewById(R.id.jeep_btn_pause).setOnClickListener(this);
        findViewById(R.id.jeep_btn_fr).setOnClickListener(this);
        findViewById(R.id.jeep_btn_random).setOnClickListener(this);
        findViewById(R.id.jeep_btn_scan).setOnClickListener(this);
        findViewById(R.id.jeep_btn_ff).setOnLongClickListener(this);
        findViewById(R.id.jeep_btn_fr).setOnLongClickListener(this);
        findViewById(R.id.jeep_btn_play).setOnLongClickListener(this);
        findViewById(R.id.jeep_btn_pause).setOnLongClickListener(this);
        findViewById(R.id.jeep_btn_pause).setOnLongClickListener(this);
        findViewById(R.id.jeep_btn_disc_prev).setOnClickListener(this);
        findViewById(R.id.jeep_btn_disc_next).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.jeep_btn_play /* 2131427575 */:
                DataCanbus.PROXY.cmd(1, 1, 0);
                break;
            case R.id.jeep_btn_pause /* 2131427576 */:
                DataCanbus.PROXY.cmd(1, 2, 0);
                break;
            case R.id.jeep_btn_fr /* 2131427610 */:
                DataCanbus.PROXY.cmd(1, 7, 1);
                break;
            case R.id.jeep_btn_ff /* 2131427611 */:
                DataCanbus.PROXY.cmd(1, 7, 0);
                break;
            case R.id.jeep_btn_loop /* 2131428345 */:
                if (this.rep_disc == 1) {
                    DataCanbus.PROXY.cmd(1, 3, 0);
                    break;
                } else if (this.rep == 0) {
                    DataCanbus.PROXY.cmd(1, 3, 1);
                    break;
                } else if (this.rep == 1) {
                    DataCanbus.PROXY.cmd(1, 3, 2);
                    break;
                }
            case R.id.jeep_btn_random /* 2131428348 */:
                if (this.random_disc == 1) {
                    DataCanbus.PROXY.cmd(1, 5, 0);
                    break;
                } else if (this.random == 0) {
                    DataCanbus.PROXY.cmd(1, 5, 1);
                    break;
                } else if (this.random == 1) {
                    DataCanbus.PROXY.cmd(1, 5, 2);
                    break;
                }
            case R.id.jeep_btn_disc_prev /* 2131430046 */:
                DataCanbus.PROXY.cmd(1, 6, 1);
                break;
            case R.id.jeep_btn_disc_next /* 2131430047 */:
                DataCanbus.PROXY.cmd(1, 6, 0);
                break;
            case R.id.jeep_btn_scan /* 2131430048 */:
                if (this.scan_disc == 1) {
                    DataCanbus.PROXY.cmd(1, 4, 0);
                    break;
                } else if (this.scan == 0) {
                    DataCanbus.PROXY.cmd(1, 4, 1);
                    break;
                } else if (this.scan == 1) {
                    DataCanbus.PROXY.cmd(1, 4, 2);
                    break;
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        return true;
     */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onLongClick(android.view.View r7) {
        /*
            r6 = this;
            r5 = 8
            r4 = 6
            r3 = 0
            r2 = 1
            int r0 = r7.getId()
            switch(r0) {
                case 2131427575: goto Ld;
                case 2131427576: goto L1f;
                case 2131427610: goto L19;
                case 2131427611: goto L13;
                default: goto Lc;
            }
        Lc:
            return r2
        Ld:
            com.syu.ipc.RemoteModuleProxy r1 = com.syu.module.canbus.DataCanbus.PROXY
            r1.cmd(r2, r5, r3)
            goto Lc
        L13:
            com.syu.ipc.RemoteModuleProxy r1 = com.syu.module.canbus.DataCanbus.PROXY
            r1.cmd(r2, r4, r3)
            goto Lc
        L19:
            com.syu.ipc.RemoteModuleProxy r1 = com.syu.module.canbus.DataCanbus.PROXY
            r1.cmd(r2, r4, r2)
            goto Lc
        L1f:
            com.syu.ipc.RemoteModuleProxy r1 = com.syu.module.canbus.DataCanbus.PROXY
            r1.cmd(r2, r5, r2)
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.wc.crown.Wc_420_crown_CarCD.onLongClick(android.view.View):boolean");
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(3, 4);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDiscState() {
        int havedisc = DataCanbus.DATA[67] & 65535;
        int disc = (DataCanbus.DATA[69] >> 8) & 255;
        int track = DataCanbus.DATA[69] & 255;
        sDiscNum = (DataCanbus.DATA[69] >> 8) & 255;
        if (((havedisc >> 0) & 1) == 1) {
            sHasDisc |= 1;
        } else {
            sHasDisc &= 254;
        }
        if (((havedisc >> 1) & 1) == 1) {
            sHasDisc |= 2;
        } else {
            sHasDisc &= 253;
        }
        if (((havedisc >> 2) & 1) == 1) {
            sHasDisc |= 4;
        } else {
            sHasDisc &= 251;
        }
        if (((havedisc >> 3) & 1) == 1) {
            sHasDisc |= 8;
        } else {
            sHasDisc &= 247;
        }
        if (((havedisc >> 4) & 1) == 1) {
            sHasDisc |= 16;
        } else {
            sHasDisc &= 239;
        }
        if (((havedisc >> 5) & 1) == 1) {
            sHasDisc |= 32;
        } else {
            sHasDisc &= 223;
        }
        ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder().append(track).toString());
        ((TextView) findViewById(R.id.cd_title_show)).setText("TRACK: " + track);
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
        int playminute = (DataCanbus.DATA[70] >> 8) & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        int playsecond = DataCanbus.DATA[70] & 255;
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        ((TextView) findViewById(R.id.time_tv)).setText(String.valueOf(playminute) + ":" + playsecond);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFiles() {
        int files = DataCanbus.DATA[71];
        switch (files) {
            case 0:
                ((TextView) findViewById(R.id.file_num_tv)).setText("read TOC");
                break;
            case 1:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Pause");
                break;
            case 2:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Play");
                break;
            case 3:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Fast");
                break;
            case 4:
                ((TextView) findViewById(R.id.file_num_tv)).setText("User search");
                break;
            case 5:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Internal search");
                break;
            case 6:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Stop");
                break;
            case 7:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Rom read");
                break;
            case 8:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Rom Search");
                break;
            case 9:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Retrieving");
                break;
            case 10:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Disc change(U)");
                break;
            case 11:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Disc change(I)");
                break;
            case 12:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Eject");
                break;
            case 255:
                ((TextView) findViewById(R.id.file_num_tv)).setText("Invalid");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMode() {
        int mode = DataCanbus.DATA[72] & 255;
        if (this.rep_disc != ((mode >> 4) & 1) && ((mode >> 4) & 1) == 1) {
            ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_all_disc_rep);
        }
        if (this.rep != ((mode >> 5) & 1) && ((mode >> 5) & 1) == 1) {
            ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_disc_rep);
        }
        if (this.random != ((mode >> 3) & 1) && ((mode >> 3) & 1) == 1) {
            ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_disc_random);
        }
        if (this.random_disc != ((mode >> 2) & 1) && ((mode >> 2) & 1) == 1) {
            ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_388_all_disc_random);
        }
        if (this.scan != ((mode >> 7) & 1) && ((mode >> 7) & 1) == 1) {
            ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_420_disc_scan);
        }
        if (this.scan_disc != ((mode >> 6) & 1) && ((mode >> 6) & 1) == 1) {
            ((TextView) findViewById(R.id.mode_tv)).setText(R.string.str_420_all_disc_scan);
        }
        if (mode == 0) {
            ((TextView) findViewById(R.id.mode_tv)).setText(R.string.xp_380_playmode1);
        }
        this.rep_disc = (mode >> 4) & 1;
        this.rep = (mode >> 5) & 1;
        this.random_disc = (mode >> 2) & 1;
        this.random = (mode >> 3) & 1;
        this.scan_disc = (mode >> 6) & 1;
        this.scan = (mode >> 7) & 1;
    }
}
