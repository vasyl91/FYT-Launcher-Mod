package com.syu.carinfo.rzc.ziyouguang;

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
import com.syu.module.canbus.Callback_0373_RZC_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_CdAct extends BaseActivity implements View.OnClickListener {
    private com.syu.carinfo.wc.ziyouguang.FileAdapter adapter;
    private ArrayList<com.syu.carinfo.wc.ziyouguang.CDInfo> cdInfos;
    private ListView listView;
    int totalTrackValue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_CdAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 35:
                    Rzc_CdAct.this.updaterCdTextInfo();
                    break;
                case 36:
                    Rzc_CdAct.this.updaterPlayMode();
                    break;
                case 37:
                    Rzc_CdAct.this.updaterWorkState();
                    break;
                case 38:
                    Rzc_CdAct.this.updaterTrack();
                    break;
                case 39:
                    Rzc_CdAct.this.updaterAllTime();
                    break;
                case 40:
                    Rzc_CdAct.this.updaterCurTime();
                    break;
            }
        }
    };
    Toast toast = null;
    TextView view = null;

    public static void CD_CONRTROL_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(4, new int[]{val1, val2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_371_bagoo_ziyouguang_cd);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.listView = (ListView) findViewById(R.id.bagoo_ziyouguang_cd_list_view);
        this.cdInfos = new ArrayList<>();
        this.adapter = new com.syu.carinfo.wc.ziyouguang.FileAdapter(this, this.cdInfos);
        this.listView.setAdapter((ListAdapter) this.adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_CdAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                int trackIndex = ((com.syu.carinfo.wc.ziyouguang.CDInfo) Rzc_CdAct.this.cdInfos.get(position)).getIndex() + 1;
                Rzc_CdAct.CD_CONRTROL_CMD(15, trackIndex);
            }
        });
        setUI();
    }

    public void setUI() {
        findViewById(R.id.bagoo_ziyouguang_cd_prev).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_next).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_ff).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_fb).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_repeat).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_repeat_random).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_play).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_pause).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_list_btn).setOnClickListener(this);
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
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterPlayMode() {
        int playModeValue = DataCanbus.DATA[36];
        if (playModeValue == 0) {
            ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_playmode)).setText(R.string.str_car_cd_putong_mode);
        } else if (playModeValue == 1) {
            ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_playmode)).setText(R.string.str_car_cd_cycle_mode);
        } else if (playModeValue == 2) {
            ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_playmode)).setText(R.string.str_car_cd_random_mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWorkState() {
        int workStateValue = DataCanbus.DATA[37];
        if (workStateValue == 0) {
            tips(getResources().getString(R.string.str_car_cd_work_state_0));
            return;
        }
        if (workStateValue == 1) {
            tips(getResources().getString(R.string.str_car_cd_work_state_1));
            return;
        }
        if (workStateValue == 2) {
            tips(getResources().getString(R.string.str_car_cd_work_state_2));
            return;
        }
        if (workStateValue == 3) {
            tips(getResources().getString(R.string.str_car_cd_work_state_3));
            return;
        }
        if (workStateValue == 4) {
            tips(getResources().getString(R.string.str_car_cd_work_state_4));
            return;
        }
        if (workStateValue == 5) {
            tips(getResources().getString(R.string.str_car_cd_work_state_5));
            return;
        }
        if (workStateValue == 6) {
            tips(getResources().getString(R.string.str_car_cd_work_state_6));
        } else if (workStateValue == 8) {
            tips(getResources().getString(R.string.str_car_cd_work_state_8));
        } else if (workStateValue == 9) {
            tips(getResources().getString(R.string.str_car_cd_work_state_9));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrack() {
        int value = DataCanbus.DATA[38];
        int curTrack = (value >> 16) & 65535;
        int temp = value & 65535;
        if (this.totalTrackValue != temp) {
            for (int i = 0; i < this.totalTrackValue; i++) {
                this.cdInfos.clear();
                this.adapter.notifyDataSetChanged();
            }
            this.totalTrackValue = temp;
            for (int i2 = 0; i2 < this.totalTrackValue; i2++) {
                com.syu.carinfo.wc.ziyouguang.CDInfo info = new com.syu.carinfo.wc.ziyouguang.CDInfo(i2, "Track " + (i2 + 1));
                this.cdInfos.add(i2, info);
                this.adapter.notifyDataSetChanged();
            }
        }
        ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_track)).setText(String.valueOf(curTrack) + "/" + this.totalTrackValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAllTime() {
        int alltime = DataCanbus.DATA[39];
        ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_all_time)).setText(String.valueOf(alltime / 3600) + ":" + ((alltime % 3600) / 60) + ":" + ((alltime % 3600) % 60));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCurTime() {
        if (((TextView) findViewById(R.id.bagoo_ziyouguang_cd_cur_time)) != null) {
            ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_cur_time)).setText(Callback_0373_RZC_XP1_ZiYouGuang.current_playtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo() {
        int infoType = Callback_0373_RZC_XP1_ZiYouGuang.infoType;
        int infoIndex = Callback_0373_RZC_XP1_ZiYouGuang.infoIndex;
        String strInfo = "";
        if (Callback_0373_RZC_XP1_ZiYouGuang.Songname != null) {
            strInfo = Callback_0373_RZC_XP1_ZiYouGuang.Songname;
        }
        switch (infoType) {
            case 1:
                ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_title)).setText(strInfo);
                break;
            case 2:
                ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_album)).setText(strInfo);
                break;
            case 3:
                ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_artist)).setText(strInfo);
                break;
            case 128:
                handlerList(infoIndex, strInfo);
                break;
        }
    }

    private void handlerList(int index, String str) {
        if (index < this.totalTrackValue) {
            com.syu.carinfo.wc.ziyouguang.CDInfo cdInfo = new com.syu.carinfo.wc.ziyouguang.CDInfo(index, str);
            this.cdInfos.set(index, cdInfo);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bagoo_ziyouguang_cd_prev /* 2131429445 */:
                CD_CONRTROL_CMD(2, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_fb /* 2131429446 */:
                CD_CONRTROL_CMD(3, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_repeat /* 2131429447 */:
                CD_CONRTROL_CMD(8, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_repeat_random /* 2131429448 */:
                CD_CONRTROL_CMD(17, 0);
                break;
            case R.id.bagoo_ziyouguang_play /* 2131429449 */:
                CD_CONRTROL_CMD(19, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_pause /* 2131429450 */:
                CD_CONRTROL_CMD(20, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_ff /* 2131429451 */:
                CD_CONRTROL_CMD(4, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_next /* 2131429452 */:
                CD_CONRTROL_CMD(1, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_list_btn /* 2131429453 */:
                for (int i = 0; i < this.totalTrackValue; i++) {
                    CD_CONRTROL_CMD(130, i);
                }
                break;
        }
    }

    public void tips(String str) {
        if (this.toast != null) {
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
}
