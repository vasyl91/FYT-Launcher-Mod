package com.syu.carinfo.wc.ziyouguang;

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
import com.syu.module.canbus.Callback_0372_WC1_Jeep_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_372_CdAct extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private FileAdapter adapter;
    private ArrayList<CDInfo> cdInfos;
    int cycleState;
    private ListView listView;
    int playModeValue;
    int randomState;
    int totalTrackValue;
    int workStateValue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_CdAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 47:
                    Wc_372_CdAct.this.updaterCdTextInfo();
                    break;
                case 48:
                    Wc_372_CdAct.this.updaterCycle();
                    break;
                case 49:
                    Wc_372_CdAct.this.updaterWorkState();
                    break;
                case 50:
                    Wc_372_CdAct.this.updaterTrack();
                    break;
                case 51:
                    Wc_372_CdAct.this.updaterAllTime();
                    break;
                case 55:
                    Wc_372_CdAct.this.updaterRandom();
                    break;
                case 56:
                    Wc_372_CdAct.this.updaterCurTime();
                    break;
            }
        }
    };
    Toast toast = null;
    TextView view = null;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_cd);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.listView = (ListView) findViewById(R.id.wc_ziyouguang_cd_list_view);
        this.cdInfos = new ArrayList<>();
        this.adapter = new FileAdapter(this, this.cdInfos);
        this.listView.setAdapter((ListAdapter) this.adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_CdAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                int trackIndex = ((CDInfo) Wc_372_CdAct.this.cdInfos.get(position)).getIndex() + 1;
                Wc_372_CdAct.CD_CONRTROL_CMD(7, (trackIndex >> 8) & 255, trackIndex);
            }
        });
    }

    public void setUI() {
        findViewById(R.id.wc_ziyouguang_cd_prev).setOnClickListener(this);
        findViewById(R.id.wc_ziyouguang_cd_next).setOnClickListener(this);
        findViewById(R.id.wc_ziyouguang_cd_repeat).setOnClickListener(this);
        findViewById(R.id.wc_ziyouguang_cd_repeat_random).setOnClickListener(this);
        findViewById(R.id.wc_ziyouguang_play).setOnClickListener(this);
        findViewById(R.id.wc_ziyouguang_cd_pause).setOnClickListener(this);
        findViewById(R.id.wc_ziyouguang_play).setOnLongClickListener(this);
        findViewById(R.id.wc_ziyouguang_cd_pause).setOnLongClickListener(this);
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
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCycle() {
        this.cycleState = DataCanbus.DATA[48] & 255;
        if (this.cycleState == 0) {
            ((TextView) findViewById(R.id.wc_ziyouguang_cd_repeats)).setText(R.string.wc_372_repeatoff);
        } else if (this.cycleState == 1) {
            ((TextView) findViewById(R.id.wc_ziyouguang_cd_repeats)).setText(R.string.wc_372_repeaton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRandom() {
        this.randomState = DataCanbus.DATA[55] & 255;
        if (this.randomState == 0) {
            ((TextView) findViewById(R.id.wc_ziyouguang_cd_randoms)).setText(R.string.wc_372_randomoff);
        } else if (this.randomState == 1) {
            ((TextView) findViewById(R.id.wc_ziyouguang_cd_randoms)).setText(R.string.wc_372_randomon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWorkState() {
        this.workStateValue = DataCanbus.DATA[49] & 255;
        if (this.workStateValue == 0) {
            tips(getResources().getString(R.string.str_car_cd_work_state_0));
            return;
        }
        if (this.workStateValue == 1) {
            tips(getResources().getString(R.string.str_car_cd_work_state_1));
            return;
        }
        if (this.workStateValue == 2) {
            tips(getResources().getString(R.string.str_car_cd_work_state_2));
            return;
        }
        if (this.workStateValue == 3) {
            tips(getResources().getString(R.string.str_car_cd_work_state_3));
            return;
        }
        if (this.workStateValue == 4) {
            tips(getResources().getString(R.string.str_car_cd_work_state_4));
            return;
        }
        if (this.workStateValue == 5) {
            tips(getResources().getString(R.string.str_car_cd_work_state_5));
            return;
        }
        if (this.workStateValue == 6) {
            tips(getResources().getString(R.string.str_car_cd_work_state_6));
            return;
        }
        if (this.workStateValue == 7) {
            tips(getResources().getString(R.string.str_car_cd_work_state_7));
        } else if (this.workStateValue == 8) {
            tips(getResources().getString(R.string.str_car_cd_work_state_8));
        } else if (this.workStateValue == 9) {
            tips(getResources().getString(R.string.str_car_cd_work_state_9));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrack() {
        int value = DataCanbus.DATA[50] & (-1);
        int curTrack = (value >> 16) & 65535;
        int temp = value & 65535;
        ((TextView) findViewById(R.id.wc_ziyouguang_cd_track)).setText(String.valueOf(curTrack) + "/" + temp);
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
    public void updaterAllTime() {
        int alltime = DataCanbus.DATA[51] & (-1);
        ((TextView) findViewById(R.id.wc_ziyouguang_cd_all_time)).setText(String.valueOf(String.format("%02d", Integer.valueOf(alltime / 3600))) + ":" + String.format("%02d", Integer.valueOf((alltime % 3600) / 60)) + ":" + String.format("%02d", Integer.valueOf((alltime % 3600) % 60)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCurTime() {
        int curtime = DataCanbus.DATA[56] & (-1);
        ((TextView) findViewById(R.id.wc_ziyouguang_cd_cur_time)).setText(String.valueOf(String.format("%02d", Integer.valueOf(curtime / 3600))) + ":" + String.format("%02d", Integer.valueOf((curtime % 3600) / 60)) + ":" + String.format("%02d", Integer.valueOf((curtime % 3600) % 60)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo() {
        int infoType = Callback_0372_WC1_Jeep_ZiYouGuang.infoType & 65535;
        int infoIndex = Callback_0372_WC1_Jeep_ZiYouGuang.infoIndex & 65535;
        String strInfo = "";
        if (Callback_0372_WC1_Jeep_ZiYouGuang.Songname != null) {
            strInfo = Callback_0372_WC1_Jeep_ZiYouGuang.Songname;
        }
        switch (infoType) {
            case 1:
                ((TextView) findViewById(R.id.wc_ziyouguang_cd_title)).setText(strInfo);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ziyouguang_cd_title)).setText(strInfo);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ziyouguang_cd_title)).setText(strInfo);
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
            case R.id.wc_ziyouguang_cd_prev /* 2131429475 */:
                CD_CONRTROL_CMD(3, 0, 0);
                break;
            case R.id.wc_ziyouguang_cd_repeat /* 2131429476 */:
                CD_CONRTROL_CMD(5, this.cycleState == 1 ? 0 : 1, 0);
                break;
            case R.id.wc_ziyouguang_cd_repeat_random /* 2131429477 */:
                CD_CONRTROL_CMD(6, this.randomState == 1 ? 0 : 1, 0);
                break;
            case R.id.wc_ziyouguang_play /* 2131429478 */:
                CD_CONRTROL_CMD(1, 0, 0);
                break;
            case R.id.wc_ziyouguang_cd_pause /* 2131429479 */:
                CD_CONRTROL_CMD(2, 0, 0);
                break;
            case R.id.wc_ziyouguang_cd_next /* 2131429480 */:
                CD_CONRTROL_CMD(4, 0, 0);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
    
        return false;
     */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onLongClick(android.view.View r4) {
        /*
            r3 = this;
            r2 = 1
            r1 = 0
            int r0 = r4.getId()
            switch(r0) {
                case 2131429475: goto La;
                case 2131429480: goto Lf;
                default: goto L9;
            }
        L9:
            return r1
        La:
            r0 = 3
            CD_CONRTROL_CMD(r0, r2, r1)
            goto L9
        Lf:
            r0 = 4
            CD_CONRTROL_CMD(r0, r2, r1)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.wc.ziyouguang.Wc_372_CdAct.onLongClick(android.view.View):boolean");
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

    public static void CD_CONRTROL_CMD(int val1, int val2, int val3) {
        DataCanbus.PROXY.cmd(7, new int[]{val1, val2, val3}, null, null);
    }
}