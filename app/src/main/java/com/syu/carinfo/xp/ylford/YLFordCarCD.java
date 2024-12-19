package com.syu.carinfo.xp.ylford;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0380_XP1_FocusKeepDVD;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLFordCarCD extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private FileAdapter adapter;
    private ArrayList<CDInfo> cdInfos;
    int totalTrackValue;
    int cycleState = 7;
    int carcd_ff = 1;
    int carcd_fb = 1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ylford.YLFordCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 15:
                    YLFordCarCD.this.updaterRandom();
                    break;
                case 17:
                    YLFordCarCD.this.updaterWorkState();
                    break;
                case 18:
                    YLFordCarCD.this.updaterTrack();
                    break;
                case 19:
                    YLFordCarCD.this.updaterCurTime();
                    break;
                case 20:
                    YLFordCarCD.this.updaterCdTextInfo();
                    break;
            }
        }
    };
    Toast toast = null;
    TextView view = null;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_380_ylford_cd);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.cdInfos = new ArrayList<>();
        this.adapter = new FileAdapter(this, this.cdInfos);
        ((ListView) findViewById(R.id.xp_ylford_cd_list_view)).setAdapter((ListAdapter) this.adapter);
        ((ListView) findViewById(R.id.xp_ylford_cd_list_view)).setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarCD.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                int trackIndex = ((CDInfo) YLFordCarCD.this.cdInfos.get(position)).getIndex() + 1;
                YLFordCarCD.CD_CONRTROL_CMD(176, 1, (trackIndex >> 8) & 255, trackIndex);
            }
        });
    }

    public void setUI() {
        findViewById(R.id.xp_ylford_cd_prev).setOnClickListener(this);
        findViewById(R.id.xp_ylford_cd_next).setOnClickListener(this);
        findViewById(R.id.xp_ylford_cd_repeat).setOnClickListener(this);
        findViewById(R.id.xp_ylford_cd_repeat_random).setOnClickListener(this);
        findViewById(R.id.xp_ylford_play).setOnClickListener(this);
        findViewById(R.id.xp_ylford_cd_pause).setOnClickListener(this);
        findViewById(R.id.xp_ylford_cd_fb).setOnClickListener(this);
        findViewById(R.id.xp_ylford_cd_ff).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(2, new int[]{178, 4}, null, null);
        mIsFront = true;
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
        finish();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRandom() {
        int randomState = DataCanbus.DATA[15] & 255;
        if (randomState == 0) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode0);
            return;
        }
        if (randomState == 1) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode1);
            return;
        }
        if (randomState == 2) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode2);
            return;
        }
        if (randomState == 3) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode3);
            return;
        }
        if (randomState == 4) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode4);
            return;
        }
        if (randomState == 5) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode5);
            return;
        }
        if (randomState == 6) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode6);
        } else if (randomState == 7) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode7);
        } else if (randomState == 8) {
            ((TextView) findViewById(R.id.xp_ylford_cd_randoms)).setText(R.string.xp_380_playmode8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWorkState() {
        int workStateValue = DataCanbus.DATA[17] & 255;
        if (workStateValue == 1) {
            tips(getResources().getString(R.string.str_car_cd_work_state_1));
            return;
        }
        if (workStateValue == 2) {
            tips(getResources().getString(R.string.str_car_cd_fb));
            return;
        }
        if (workStateValue == 3) {
            tips(getResources().getString(R.string.str_car_cd_ff));
            return;
        }
        if (workStateValue == 4) {
            tips(getResources().getString(R.string.str_car_cd_work_state_0));
        } else if (workStateValue == 5) {
            tips(getResources().getString(R.string.xp_380_disc_0));
        } else if (workStateValue == 6) {
            tips(getResources().getString(R.string.xp_380_disc_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrack() {
        int value = DataCanbus.DATA[18] & (-1);
        int curTrack = (value >> 16) & 65535;
        int temp = value & 65535;
        ((TextView) findViewById(R.id.xp_ylford_cd_track)).setText(String.valueOf(curTrack) + "/" + temp);
        if (this.totalTrackValue != temp) {
            for (int i = 0; i < this.totalTrackValue; i++) {
                this.cdInfos.clear();
                this.adapter.notifyDataSetChanged();
            }
            this.totalTrackValue = temp;
            for (int i2 = 0; i2 < this.totalTrackValue; i2++) {
                CDInfo info = new CDInfo(i2, "Track " + (i2 + 1));
                this.cdInfos.add(i2, info);
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCurTime() {
        int playtime = DataCanbus.DATA[19] & 16777215;
        ((TextView) findViewById(R.id.xp_ylford_cd_cur_time)).setText(String.valueOf(String.format("%02d", Integer.valueOf((playtime >> 16) & 255))) + ":" + String.format("%02d", Integer.valueOf((playtime >> 8) & 255)) + ":" + String.format("%02d", Integer.valueOf(playtime & 255)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo() {
        int infoType = Callback_0380_XP1_FocusKeepDVD.infoType & 65535;
        int infoIndex = Callback_0380_XP1_FocusKeepDVD.infoIndex & 65535;
        String strInfo = "";
        if (Callback_0380_XP1_FocusKeepDVD.Songname != null) {
            strInfo = Callback_0380_XP1_FocusKeepDVD.Songname;
        }
        switch (infoType) {
            case 1:
                ((TextView) findViewById(R.id.xp_ylford_cd_artist)).setText(strInfo);
                break;
            case 2:
                ((TextView) findViewById(R.id.xp_ylford_cd_title)).setText(strInfo);
                break;
            case 3:
                ((TextView) findViewById(R.id.xp_ylford_cd_album)).setText(strInfo);
                break;
            case 4:
                handlerList(infoIndex, strInfo);
                break;
        }
    }

    private void handlerList(int index, String str) {
        if (index < this.totalTrackValue) {
            CDInfo cdInfo = new CDInfo(index, str);
            this.cdInfos.set(index, cdInfo);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xp_ylford_cd_prev /* 2131429669 */:
                CD_CONRTROL_CMD(176, 3, 0, 0);
                break;
            case R.id.xp_ylford_cd_fb /* 2131429670 */:
                if (this.carcd_fb == 0) {
                    this.carcd_fb = 1;
                } else {
                    this.carcd_fb = 0;
                }
                CD_CONRTROL_CMD(176, 6, this.carcd_fb, 0);
                break;
            case R.id.xp_ylford_cd_repeat /* 2131429671 */:
                if (this.cycleState == 7) {
                    this.cycleState = 8;
                } else if (this.cycleState == 8) {
                    this.cycleState = 11;
                } else if (this.cycleState == 11) {
                    this.cycleState = 7;
                }
                CD_CONRTROL_CMD(176, this.cycleState, 0, 0);
                break;
            case R.id.xp_ylford_play /* 2131429672 */:
                CD_CONRTROL_CMD(176, 13, 1, 0);
                break;
            case R.id.xp_ylford_cd_pause /* 2131429673 */:
                CD_CONRTROL_CMD(176, 13, 0, 0);
                break;
            case R.id.xp_ylford_cd_repeat_random /* 2131429674 */:
                if (this.cycleState == 7) {
                    this.cycleState = 9;
                } else if (this.cycleState == 9) {
                    this.cycleState = 12;
                } else {
                    this.cycleState = 7;
                }
                CD_CONRTROL_CMD(176, this.cycleState, 0, 0);
                break;
            case R.id.xp_ylford_cd_ff /* 2131429675 */:
                if (this.carcd_ff == 0) {
                    this.carcd_ff = 1;
                } else {
                    this.carcd_ff = 0;
                }
                CD_CONRTROL_CMD(176, 5, this.carcd_ff, 0);
                break;
            case R.id.xp_ylford_cd_next /* 2131429676 */:
                CD_CONRTROL_CMD(176, 4, 0, 0);
                break;
        }
    }

    public void tips(String str) {
        if (this.toast != null) {
            this.toast.cancel();
            this.toast = null;
        }
        this.toast = new Toast(this);
        this.toast.setGravity(17, 0, 0);
        this.toast.setDuration(0);
        this.view = new TextView(this);
        this.view.setText(str);
        this.view.setGravity(17);
        this.view.setBackgroundResource(R.drawable.toast_bk);
        this.view.setTextSize(30.0f);
        this.toast.setView(this.view);
        this.toast.show();
    }

    public static void CD_CONRTROL_CMD(int val1, int val2, int val3, int val4) {
        DataCanbus.PROXY.cmd(2, new int[]{val1, val2, val3, val4}, null, null);
    }
}
