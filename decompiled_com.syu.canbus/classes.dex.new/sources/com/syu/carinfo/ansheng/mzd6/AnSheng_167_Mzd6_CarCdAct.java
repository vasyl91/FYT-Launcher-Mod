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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class AnSheng_167_Mzd6_CarCdAct extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ansheng.mzd6.AnSheng_167_Mzd6_CarCdAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCdDevice(value);
                    break;
                case 100:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCdErrorState(value);
                    break;
                case 101:
                case 105:
                    AnSheng_167_Mzd6_CarCdAct.this.updateTotalAndCurTrack();
                    break;
                case 102:
                    AnSheng_167_Mzd6_CarCdAct.this.updatePlayState(value);
                    break;
                case 103:
                    AnSheng_167_Mzd6_CarCdAct.this.updateRepeatMode(value);
                    break;
                case 104:
                    AnSheng_167_Mzd6_CarCdAct.this.updateRadomMode(value);
                    break;
                case 106:
                case 107:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCurPlayTime();
                    break;
                case 110:
                    AnSheng_167_Mzd6_CarCdAct.this.updateCdId3Info();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_167_as_mzd6_cdinfo);
        setUI();
    }

    public void setUI() {
        for (int i = 112; i <= 117; i++) {
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCdDevice(int device) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (device == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_167_carcddev2);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_167_carcddev1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCdErrorState(int errorstate) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (errorstate == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("Fault");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText("Normal");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayState(int playstate) {
        String str;
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
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
            ((TextView) findViewById(R.id.tv_text10)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatMode(int repeatmode) {
        String str;
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
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
            ((TextView) findViewById(R.id.tv_text7)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadomMode(int radommode) {
        String str;
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
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
            ((TextView) findViewById(R.id.tv_text9)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTotalAndCurTrack() {
        int totaltrack = DataCanbus.DATA[101];
        int currenttrack = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.tv_text14)) != null) {
            ((TextView) findViewById(R.id.tv_text14)).setText(String.format("%d/%d", Integer.valueOf(totaltrack), Integer.valueOf(currenttrack)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurPlayTime() {
        int playminute = DataCanbus.DATA[106];
        int playsecond = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.tv_text15)) != null) {
            ((TextView) findViewById(R.id.tv_text15)).setText(String.valueOf(playminute) + ":" + playsecond);
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
            if (((TextView) findViewById(R.id.tv_text11)) != null) {
                ((TextView) findViewById(R.id.tv_text11)).setText(cdId3Track);
            }
            if (((TextView) findViewById(R.id.tv_text12)) != null) {
                ((TextView) findViewById(R.id.tv_text12)).setText(cdId3Album);
            }
            if (((TextView) findViewById(R.id.tv_text13)) != null) {
                ((TextView) findViewById(R.id.tv_text13)).setText(cdId3Artist);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            ((TextView) findViewById(R.id.tv_text11)).setText("No Id3");
        }
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            ((TextView) findViewById(R.id.tv_text12)).setText("");
        }
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            ((TextView) findViewById(R.id.tv_text13)).setText("");
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
