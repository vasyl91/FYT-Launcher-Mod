package com.syu.carinfo.ansheng.mzd6;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0167_XBS_XP1_OLD_MZD6;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AnSheng_167_Mzd6_CarCdAct extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ansheng.mzd6.AnSheng_167_Mzd6_CarCdAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            AnSheng_167_Mzd6_CarCdAct.this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCdDevice(AnSheng_167_Mzd6_CarCdAct.this.value);
                    break;
                case 8:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCdErrorState(AnSheng_167_Mzd6_CarCdAct.this.value);
                    break;
                case 9:
                case 13:
                    AnSheng_167_Mzd6_CarCdAct.this.updateTotalAndCurTrack();
                    break;
                case 10:
                    AnSheng_167_Mzd6_CarCdAct.this.updatePlayState(AnSheng_167_Mzd6_CarCdAct.this.value);
                    break;
                case 11:
                    AnSheng_167_Mzd6_CarCdAct.this.updateRepeatMode(AnSheng_167_Mzd6_CarCdAct.this.value);
                    break;
                case 12:
                    AnSheng_167_Mzd6_CarCdAct.this.updateRadomMode(AnSheng_167_Mzd6_CarCdAct.this.value);
                    break;
                case 14:
                case 15:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCurPlayTime();
                    break;
                case 18:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCdId3Info();
                    break;
            }
        }
    };
    private int value;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_167_as_mzd6_cdinfo);
        setUI();
    }

    public void setUI() {
        for (int i = 34; i <= 39; i++) {
            DataCanbus.DATA[i] = -1;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCdDevice(int device) {
        if (((TextView) findViewById(R.id.as_mzd6_cd_dev_text)) != null) {
            if (device == 1) {
                ((TextView) findViewById(R.id.as_mzd6_cd_dev_text)).setText(R.string.str_167_carcddev2);
            } else {
                ((TextView) findViewById(R.id.as_mzd6_cd_dev_text)).setText(R.string.str_167_carcddev1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCdErrorState(int errorstate) {
        if (((TextView) findViewById(R.id.as_mzd6_cd_errorstate_text)) != null) {
            if (errorstate == 1) {
                ((TextView) findViewById(R.id.as_mzd6_cd_errorstate_text)).setText("Fault");
            } else {
                ((TextView) findViewById(R.id.as_mzd6_cd_errorstate_text)).setText("Normal");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayState(int playstate) {
        String str;
        if (((TextView) findViewById(R.id.as_mzd6_cd_playstate_text)) != null) {
            switch (playstate) {
                case 1:
                    str = getResources().getString(R.string.crv_state_pause);
                    break;
                case 2:
                    str = getResources().getString(R.string.crv_state_play);
                    break;
                case 3:
                    str = getResources().getString(R.string.str_167_playstate2);
                    break;
                case 4:
                    str = getResources().getString(R.string.str_167_playstate3);
                    break;
                default:
                    str = getResources().getString(R.string.str_167_playstate1);
                    break;
            }
            ((TextView) findViewById(R.id.as_mzd6_cd_playstate_text)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatMode(int repeatmode) {
        String str;
        if (((TextView) findViewById(R.id.as_mzd6_cd_repeatmode_text)) != null) {
            switch (repeatmode) {
                case 1:
                    str = "Repeat Track";
                    break;
                case 2:
                    str = "Repeat Folder";
                    break;
                default:
                    str = "Repeat Off";
                    break;
            }
            ((TextView) findViewById(R.id.as_mzd6_cd_repeatmode_text)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadomMode(int radommode) {
        String str;
        if (((TextView) findViewById(R.id.as_mzd6_cd_radommode_text)) != null) {
            switch (radommode) {
                case 1:
                    str = "Random Disc";
                    break;
                case 2:
                    str = "Random Folder";
                    break;
                default:
                    str = "Random Off";
                    break;
            }
            ((TextView) findViewById(R.id.as_mzd6_cd_radommode_text)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTotalAndCurTrack() {
        int totaltrack = DataCanbus.DATA[9];
        int currenttrack = DataCanbus.DATA[13];
        if (((TextView) findViewById(R.id.as_mzd6_cd_trackno)) != null) {
            ((TextView) findViewById(R.id.as_mzd6_cd_trackno)).setText(String.format("%d/%d", Integer.valueOf(totaltrack), Integer.valueOf(currenttrack)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurPlayTime() {
        int playminute = DataCanbus.DATA[14];
        int playsecond = DataCanbus.DATA[15];
        if (((TextView) findViewById(R.id.as_mzd6_cd_playtime)) != null) {
            ((TextView) findViewById(R.id.as_mzd6_cd_playtime)).setText(String.valueOf(playminute) + ":" + playsecond);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCdId3Info() {
        int i = Callback_0167_XBS_XP1_OLD_MZD6.cdid3type;
        int cdid3infoflag = Callback_0167_XBS_XP1_OLD_MZD6.id3infoflag;
        String cdId3Track = Callback_0167_XBS_XP1_OLD_MZD6.cdId3Track;
        String cdId3Album = Callback_0167_XBS_XP1_OLD_MZD6.cdId3Album;
        String cdId3Artist = Callback_0167_XBS_XP1_OLD_MZD6.cdId3Artist;
        if (cdid3infoflag == 1) {
            if (((TextView) findViewById(R.id.as_mzd6_cd_id3title)) != null) {
                ((TextView) findViewById(R.id.as_mzd6_cd_id3title)).setText(cdId3Track);
            }
            if (((TextView) findViewById(R.id.as_mzd6_cd_id3album)) != null) {
                ((TextView) findViewById(R.id.as_mzd6_cd_id3album)).setText(cdId3Album);
            }
            if (((TextView) findViewById(R.id.as_mzd6_cd_id3artist)) != null) {
                ((TextView) findViewById(R.id.as_mzd6_cd_id3artist)).setText(cdId3Artist);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.as_mzd6_cd_id3title)) != null) {
            ((TextView) findViewById(R.id.as_mzd6_cd_id3title)).setText("No Id3");
        }
        if (((TextView) findViewById(R.id.as_mzd6_cd_id3album)) != null) {
            ((TextView) findViewById(R.id.as_mzd6_cd_id3album)).setText("");
        }
        if (((TextView) findViewById(R.id.as_mzd6_cd_id3artist)) != null) {
            ((TextView) findViewById(R.id.as_mzd6_cd_id3artist)).setText("");
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View arg0) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
    }
}
