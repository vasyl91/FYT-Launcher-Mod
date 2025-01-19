package com.syu.carinfo.wc.tianlai;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.Print;

public class ActivityWCTianLaiCarCD extends BaseActivity {
    public static ActivityWCTianLaiCarCD mInstance;
    public static boolean mIsFront;
    static int sHasDisc = 0;
    View cdView;
    View cdmiaosuShowView;
    TextView filesTv;
    TextView id3InfoTv;
    TextView modeTv;
    TextView modetext;
    View sixdieView;
    TextView timeTv;
    TextView trackNumTv;
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    int rep_disc = 0;
    int rep = 0;
    int random_disc = 0;
    int random = 0;
    int scan_disc = 0;
    int scan = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Print.log("LG", "updateCode=" + updateCode);
            switch (updateCode) {
                case 99:
                    ActivityWCTianLaiCarCD.this.updaterDiscState();
                    break;
                case 101:
                    ActivityWCTianLaiCarCD.this.updaterDiscState();
                    break;
                case 102:
                    ActivityWCTianLaiCarCD.this.updaterPlayTime();
                    break;
                case 103:
                    ActivityWCTianLaiCarCD.this.updaterFiles();
                    break;
                case 104:
                    ActivityWCTianLaiCarCD.this.updaterMode();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        mInstance = this;
        //setContentView(R.layout.layout_430_wc_tianlai_carcd);
        init();
    }

    @Override
    public void init() {
        this.cdView = findViewById(R.id.cd_view);
        this.cdmiaosuShowView = findViewById(R.id.cd_miaosu_view);
        this.sixdieView = findViewById(R.id.six_die_show_view);
        this.id3InfoTv = (TextView) findViewById(R.id.cd_title_show);
        this.filesTv = (TextView) findViewById(R.id.file_num_tv);
        this.trackNumTv = (TextView) findViewById(R.id.track_num_tv);
        this.timeTv = (TextView) findViewById(R.id.time_tv);
        this.modeTv = (TextView) findViewById(R.id.mode_tv);
        this.modetext = (TextView) findViewById(R.id.mode_text);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterDiscState() {
        int havedisc = DataCanbus.DATA[99] & 65535;
        int disc = (DataCanbus.DATA[101] >> 8) & 255;
        int track = DataCanbus.DATA[101] & 255;
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
        Print.screenMsg("havedisc = " + havedisc + " sHasDisc=" + sHasDisc);
        this.trackNumTv.setText(new StringBuilder().append(track).toString());
        this.id3InfoTv.setText("TRACK: " + track);
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
        int playminute = (DataCanbus.DATA[102] >> 8) & 255;
        int playsecond = DataCanbus.DATA[102] & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        this.timeTv.setText(String.format("%02d:%02d", Integer.valueOf(playminute), Integer.valueOf(playsecond)));
    }

    
    public void updaterFiles() {
        int files = DataCanbus.DATA[103];
        switch (files) {
            case 0:
                this.filesTv.setText("read TOC");
                break;
            case 1:
                this.filesTv.setText("Pause");
                break;
            case 2:
                this.filesTv.setText("Play");
                break;
            case 3:
                this.filesTv.setText("Fast");
                break;
            case 4:
                this.filesTv.setText("User search");
                break;
            case 5:
                this.filesTv.setText("Internal search");
                break;
            case 6:
                this.filesTv.setText("Stop");
                break;
            case 7:
                this.filesTv.setText("Rom read");
                break;
            case 8:
                this.filesTv.setText("Rom Search");
                break;
            case 9:
                this.filesTv.setText("Retrieving");
                break;
            case 10:
                this.filesTv.setText("Disc change(U)");
                break;
            case 11:
                this.filesTv.setText("Disc change(I)");
                break;
            case 12:
                this.filesTv.setText("Eject");
                break;
            case 13:
                this.filesTv.setText(R.string.str_327_change_disc);
                break;
            case 14:
                this.filesTv.setText(R.string.str_327_change_music);
                break;
            case 15:
                this.filesTv.setText("FF");
                break;
            case 16:
                this.filesTv.setText("FR");
                break;
            case 17:
                this.filesTv.setText("Load");
                break;
            case 18:
                this.filesTv.setText("Insert DISC");
                break;
            case 19:
                this.filesTv.setText("Wait");
                break;
            case 255:
                this.filesTv.setText("Invalid");
                break;
        }
    }

    
    public void updaterMode() {
        int mode = DataCanbus.DATA[104] & 255;
        if (this.rep_disc != ((mode >> 4) & 1) && ((mode >> 4) & 1) == 1) {
            this.modeTv.setText(R.string.str_388_all_disc_rep);
        }
        if (this.rep != ((mode >> 5) & 1) && ((mode >> 5) & 1) == 1) {
            this.modeTv.setText(R.string.str_388_disc_rep);
        }
        if (this.random != ((mode >> 3) & 1) && ((mode >> 3) & 1) == 1) {
            this.modeTv.setText(R.string.str_388_disc_random);
        }
        if (this.random_disc != ((mode >> 2) & 1) && ((mode >> 2) & 1) == 1) {
            this.modeTv.setText(R.string.str_388_all_disc_random);
        }
        if (this.scan != ((mode >> 7) & 1) && ((mode >> 7) & 1) == 1) {
            this.modeTv.setText(R.string.str_420_disc_scan);
        }
        if (this.scan_disc != ((mode >> 6) & 1) && ((mode >> 6) & 1) == 1) {
            this.modeTv.setText(R.string.str_420_all_disc_scan);
        }
        if (mode == 0) {
            this.modeTv.setText(R.string.xp_380_playmode1);
        }
        this.rep_disc = (mode >> 4) & 1;
        this.rep = (mode >> 5) & 1;
        this.random_disc = (mode >> 2) & 1;
        this.random = (mode >> 3) & 1;
        this.scan_disc = (mode >> 6) & 1;
        this.scan = (mode >> 7) & 1;
    }
}
