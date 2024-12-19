package com.syu.carinfo.xbs.tianlai;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_XBS_09Tianlai;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBS09TianlaiCarCDAct extends BaseActivity {
    public static XBS09TianlaiCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 45:
                        XBS09TianlaiCarCDAct.this.updaterCdFolderState();
                        break;
                    case 46:
                        XBS09TianlaiCarCDAct.this.updaterCdWmaState();
                        break;
                    case 47:
                        XBS09TianlaiCarCDAct.this.updaterCdMp3State();
                        break;
                    case 48:
                        XBS09TianlaiCarCDAct.this.updaterCdScaneState();
                        break;
                    case 49:
                        XBS09TianlaiCarCDAct.this.updaterCdText();
                        break;
                    case 50:
                        XBS09TianlaiCarCDAct.this.updaterCdWorkState();
                        break;
                    case 51:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc1State();
                        break;
                    case 52:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc2State();
                        break;
                    case 53:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc3State();
                        break;
                    case 54:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc4State();
                        break;
                    case 55:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc5State();
                        break;
                    case 56:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc6State();
                        break;
                    case 57:
                        XBS09TianlaiCarCDAct.this.updaterCdNum();
                        break;
                    case 58:
                        XBS09TianlaiCarCDAct.this.updaterCdTrack();
                        break;
                    case 59:
                    case 60:
                        XBS09TianlaiCarCDAct.this.updaterCdTime();
                        break;
                    case 61:
                        XBS09TianlaiCarCDAct.this.updaterCdPlayState();
                        break;
                }
            }
            switch (updateCode) {
                case 35:
                    XBS09TianlaiCarCDAct.this.updaterCdFolderState();
                    break;
                case 36:
                    XBS09TianlaiCarCDAct.this.updaterCdWmaState();
                    break;
                case 37:
                    XBS09TianlaiCarCDAct.this.updaterCdMp3State();
                    break;
                case 38:
                    XBS09TianlaiCarCDAct.this.updaterCdScaneState();
                    break;
                case 39:
                    XBS09TianlaiCarCDAct.this.updaterCdText();
                    break;
                case 40:
                    XBS09TianlaiCarCDAct.this.updaterCdWorkState();
                    break;
                case 41:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc1State();
                    break;
                case 42:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc2State();
                    break;
                case 43:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc3State();
                    break;
                case 44:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc4State();
                    break;
                case 45:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc5State();
                    break;
                case 46:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc6State();
                    break;
                case 47:
                    XBS09TianlaiCarCDAct.this.updaterCdNum();
                    break;
                case 48:
                    XBS09TianlaiCarCDAct.this.updaterCdTrack();
                    break;
                case 49:
                case 50:
                    XBS09TianlaiCarCDAct.this.updaterCdTime();
                    break;
                case 51:
                    XBS09TianlaiCarCDAct.this.updaterCdPlayState();
                    break;
            }
        }
    };
    int discnum = 1;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
                setContentView(R.layout.layout_xbs_09tianlai_carcd_9853);
            } else {
                setContentView(R.layout.layout_xbs_09tianlai_carcd);
            }
        } else {
            setContentView(R.layout.layout_xbs_09tianlai_carcd);
        }
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdText() {
        int value = DataCanbus.DATA[39];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[49];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.cd_text)).setText(Callback_0439_XBS_09Tianlai.CarCdText);
        } else {
            ((TextView) findViewById(R.id.cd_text)).setText("--------");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdPlayState() {
        int value = DataCanbus.DATA[51];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[61];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.str_388_disc_rep);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.str_388_rep_one);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.str_388_disc_random);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.str_388_all_disc_random);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.crv_playstate_3);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.crv_playstate_2);
                break;
            case 7:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.xp_380_playmode1);
                break;
            default:
                ((TextView) findViewById(R.id.dj_prado_cd_state)).setText(R.string.str_388_all_disc_rep);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTime() {
        int munite = DataCanbus.DATA[49];
        int second = DataCanbus.DATA[50];
        if (DataCanbus.DATA[1000] == 458942) {
            munite = DataCanbus.DATA[59];
            second = DataCanbus.DATA[60];
        }
        ((TextView) findViewById(R.id.dj_prado_cd_time)).setText(String.valueOf(munite) + ":" + second);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTrack() {
        int value = DataCanbus.DATA[48];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[58];
        }
        int B10 = (value >> 4) & 15;
        int B01 = value & 15;
        ((TextView) findViewById(R.id.dj_prado_cd_track)).setText("Track : " + B10 + B01);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdDisc6State() {
        int value = DataCanbus.DATA[46];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[56];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setText("Disc 6");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setText("Loading");
                break;
            default:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setText(R.string.jeep_playstate1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdDisc5State() {
        int value = DataCanbus.DATA[45];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[55];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setText("Disc 5");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setText("Loading");
                break;
            default:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setText(R.string.jeep_playstate1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdDisc4State() {
        int value = DataCanbus.DATA[44];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[54];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setText("Disc 4");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setText("Loading");
                break;
            default:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setText(R.string.jeep_playstate1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdDisc3State() {
        int value = DataCanbus.DATA[43];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[53];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setText("Disc 3");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setText("Loading");
                break;
            default:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setText(R.string.jeep_playstate1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdDisc2State() {
        int value = DataCanbus.DATA[42];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[52];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setText("Disc 2");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setText("Loading");
                break;
            default:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setText(R.string.jeep_playstate1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdDisc1State() {
        int value = DataCanbus.DATA[41];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[51];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setText("Disc 1");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setText("Loading");
                break;
            default:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setText(R.string.jeep_playstate1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdNum() {
        int value = DataCanbus.DATA[47];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[57];
        }
        this.discnum = value;
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd_titlenum)).setText("DISC : 1");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd_titlenum)).setText("DISC : 2");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd_titlenum)).setText("DISC : 3");
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd_titlenum)).setText("DISC : 4");
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd_titlenum)).setText("DISC : 5");
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-1);
                ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dj_prado_cd_titlenum)).setText("DISC : 6");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdWorkState() {
        int value = DataCanbus.DATA[40];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[50];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("reading disc" + this.discnum);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("loading disc" + this.discnum);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("insert disc");
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("busy");
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("ejecting disc");
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("select disc to load");
                break;
            case 7:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("select disc to eject");
                break;
            default:
                ((TextView) findViewById(R.id.cd_warkstate)).setText("play");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdScaneState() {
        int value = DataCanbus.DATA[38];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[48];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.cd_scane)).setText("Sacn : on");
                break;
            default:
                ((TextView) findViewById(R.id.cd_scane)).setText("Sacn : off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdMp3State() {
        int value = DataCanbus.DATA[37];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[47];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.cd_mp3)).setText("Mp3 : on");
                break;
            default:
                ((TextView) findViewById(R.id.cd_mp3)).setText("Mp3 : off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdWmaState() {
        int value = DataCanbus.DATA[36];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[46];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.cd_wma)).setText("Wma : on");
                break;
            default:
                ((TextView) findViewById(R.id.cd_wma)).setText("Wma : off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdFolderState() {
        int value = DataCanbus.DATA[35];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[45];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.cd_folder)).setText("Folder : on");
                break;
            default:
                ((TextView) findViewById(R.id.cd_folder)).setText("Folder : off");
                break;
        }
    }
}
