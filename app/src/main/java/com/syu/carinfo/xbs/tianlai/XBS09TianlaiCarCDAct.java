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

@SuppressWarnings({"deprecation", "unchecked"})
public class XBS09TianlaiCarCDAct extends BaseActivity {
    public static XBS09TianlaiCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 118:
                        XBS09TianlaiCarCDAct.this.updaterCdFolderState();
                        break;
                    case 119:
                        XBS09TianlaiCarCDAct.this.updaterCdWmaState();
                        break;
                    case 120:
                        XBS09TianlaiCarCDAct.this.updaterCdMp3State();
                        break;
                    case 121:
                        XBS09TianlaiCarCDAct.this.updaterCdScaneState();
                        break;
                    case 122:
                        XBS09TianlaiCarCDAct.this.updaterCdText();
                        break;
                    case 123:
                        XBS09TianlaiCarCDAct.this.updaterCdWorkState();
                        break;
                    case 124:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc1State();
                        break;
                    case 125:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc2State();
                        break;
                    case 126:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc3State();
                        break;
                    case 127:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc4State();
                        break;
                    case 128:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc5State();
                        break;
                    case 129:
                        XBS09TianlaiCarCDAct.this.updaterCdDisc6State();
                        break;
                    case 130:
                        XBS09TianlaiCarCDAct.this.updaterCdNum();
                        break;
                    case 131:
                        XBS09TianlaiCarCDAct.this.updaterCdTrack();
                        break;
                    case 132:
                    case 133:
                        XBS09TianlaiCarCDAct.this.updaterCdTime();
                        break;
                    case 134:
                        XBS09TianlaiCarCDAct.this.updaterCdPlayState();
                        break;
                }
            }
            switch (updateCode) {
                case 118:
                    XBS09TianlaiCarCDAct.this.updaterCdFolderState();
                    break;
                case 119:
                    XBS09TianlaiCarCDAct.this.updaterCdWmaState();
                    break;
                case 120:
                    XBS09TianlaiCarCDAct.this.updaterCdMp3State();
                    break;
                case 121:
                    XBS09TianlaiCarCDAct.this.updaterCdScaneState();
                    break;
                case 122:
                    XBS09TianlaiCarCDAct.this.updaterCdText();
                    break;
                case 123:
                    XBS09TianlaiCarCDAct.this.updaterCdWorkState();
                    break;
                case 124:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc1State();
                    break;
                case 125:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc2State();
                    break;
                case 126:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc3State();
                    break;
                case 127:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc4State();
                    break;
                case 128:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc5State();
                    break;
                case 129:
                    XBS09TianlaiCarCDAct.this.updaterCdDisc6State();
                    break;
                case 130:
                    XBS09TianlaiCarCDAct.this.updaterCdNum();
                    break;
                case 131:
                    XBS09TianlaiCarCDAct.this.updaterCdTrack();
                    break;
                case 132:
                case 133:
                    XBS09TianlaiCarCDAct.this.updaterCdTime();
                    break;
                case 134:
                    XBS09TianlaiCarCDAct.this.updaterCdPlayState();
                    break;
            }
        }
    };
    int discnum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
                //setContentView(R.layout.layout_xbs_09tianlai_carcd_9853);
            } else {
                //setContentView(R.layout.layout_xbs_09tianlai_carcd);
            }
        } else {
            //setContentView(R.layout.layout_xbs_09tianlai_carcd);
        }
        mInstance = this;
        init();
    }

    @Override
    public void init() {
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
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterCdText() {
        int value = DataCanbus.DATA[122];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[122];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.cd_text)).setText(Callback_0439_XBS_09Tianlai.CarCdText);
        } else {
            ((TextView) findViewById(R.id.cd_text)).setText("--------");
        }
    }

    
    public void updaterCdPlayState() {
        int value = DataCanbus.DATA[134];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[134];
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

    
    public void updaterCdTime() {
        int munite = DataCanbus.DATA[132];
        int second = DataCanbus.DATA[133];
        if (DataCanbus.DATA[1000] == 458942) {
            munite = DataCanbus.DATA[132];
            second = DataCanbus.DATA[133];
        }
        ((TextView) findViewById(R.id.dj_prado_cd_time)).setText(String.valueOf(munite) + ":" + second);
    }

    
    public void updaterCdTrack() {
        int value = DataCanbus.DATA[131];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[131];
        }
        int B10 = (value >> 4) & 15;
        int B01 = value & 15;
        ((TextView) findViewById(R.id.dj_prado_cd_track)).setText("Track : " + B10 + B01);
    }

    
    public void updaterCdDisc6State() {
        int value = DataCanbus.DATA[129];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[129];
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

    
    public void updaterCdDisc5State() {
        int value = DataCanbus.DATA[128];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[128];
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

    
    public void updaterCdDisc4State() {
        int value = DataCanbus.DATA[127];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[127];
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

    
    public void updaterCdDisc3State() {
        int value = DataCanbus.DATA[126];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[126];
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

    
    public void updaterCdDisc2State() {
        int value = DataCanbus.DATA[125];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[125];
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

    
    public void updaterCdDisc1State() {
        int value = DataCanbus.DATA[124];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[124];
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

    
    public void updaterCdNum() {
        int value = DataCanbus.DATA[130];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[130];
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

    
    public void updaterCdWorkState() {
        int value = DataCanbus.DATA[123];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[123];
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

    
    public void updaterCdScaneState() {
        int value = DataCanbus.DATA[121];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[121];
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

    
    public void updaterCdMp3State() {
        int value = DataCanbus.DATA[120];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[120];
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

    
    public void updaterCdWmaState() {
        int value = DataCanbus.DATA[119];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[119];
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

    
    public void updaterCdFolderState() {
        int value = DataCanbus.DATA[118];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[118];
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
