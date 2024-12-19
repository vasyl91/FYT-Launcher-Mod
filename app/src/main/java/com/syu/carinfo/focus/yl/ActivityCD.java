package com.syu.carinfo.focus.yl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToastInfo;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityCD extends Activity implements View.OnClickListener {
    private static final int msg_update_list = 0;
    FileAdapter adapter;
    private IUiNotify mNotifyDvd = new IUiNotify() { // from class: com.syu.carinfo.focus.yl.ActivityCD.1
        private int curTrack;
        private int folderId;
        private ListInfo info;
        private int playTime;
        private String str;
        private int totalTrack;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 18:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)) != null && ints != null && ints.length > 1) {
                        this.curTrack = ints[0];
                        this.totalTrack = ints[1];
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_track)) + this.curTrack + "/" + this.totalTrack);
                        break;
                    }
                case 19:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)) != null) {
                        this.folderId = DataCanbus.DATA[updateCode];
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_track)) + this.curTrack + "/" + this.totalTrack);
                        break;
                    }
                case 20:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_time)) != null) {
                        this.playTime = DataCanbus.DATA[updateCode];
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_time)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_playtime)) + String.format("%02d:%02d", Integer.valueOf(this.playTime / 60), Integer.valueOf(this.playTime % 60)));
                        break;
                    }
                case 21:
                    if (ints != null && ints.length >= 2 && strs != null && strs.length > 0) {
                        int type = ints[0];
                        int index = ints[1];
                        String name = strs[0];
                        this.info = new ListInfo();
                        this.info.setType(type);
                        this.info.setIndex(index);
                        this.info.setName(name);
                        ActivityCD.this.updateList(index, this.info);
                        break;
                    }
                case 25:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_title)) != null) {
                        this.str = "";
                        if (strs != null && strs.length > 0) {
                            this.str = strs[0];
                        }
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_title)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_title)) + this.str);
                        break;
                    }
                case 26:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_artist)) != null) {
                        this.str = "";
                        if (strs != null && strs.length > 0) {
                            this.str = strs[0];
                        }
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_artist)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_artist)) + this.str);
                        break;
                    }
            }
        }
    };
    ArrayList<ListInfo> mFileList = new ArrayList<>();
    Handler handler = new Handler() { // from class: com.syu.carinfo.focus.yl.ActivityCD.2
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ActivityCD.this.adapter.addList(msg.arg1, (ListInfo) msg.obj);
                    break;
            }
        }
    };
    int valueRemond = 0;
    int valueRepeat = 0;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_yl_focus_cd);
        this.adapter = new FileAdapter(this, this.mFileList);
        ((ListView) findViewById(R.id.focus_cd_list)).setAdapter((ListAdapter) this.adapter);
        ((ListView) findViewById(R.id.focus_cd_list)).setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityCD.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                FFuncYLFocus.C_CD_LIST_SELECT(position + 1);
            }
        });
        ((Button) findViewById(R.id.cd_prev)).setOnClickListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.cd_fb)).setOnClickListener(this);
        ((Button) findViewById(R.id.cd_ff)).setOnClickListener(this);
        ((Button) findViewById(R.id.cd_remond)).setOnClickListener(this);
        ((Button) findViewById(R.id.cd_repeat)).setOnClickListener(this);
        ((Button) findViewById(R.id.cd_eject)).setOnClickListener(this);
        ((Button) findViewById(R.id.cd_back)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FFuncYLFocus.C_SET_CONTROT(16, 1);
        FFuncYLFocus.C_CMD_REQUEST(48);
        FFuncYLFocus.C_CMD_REQUEST(50);
        FFuncYLFocus.C_CMD_REQUEST(51);
        FFuncYLFocus.C_CMD_REQUEST(52);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyDvd, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyDvd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateList(int index, ListInfo info) {
        Message msg = this.handler.obtainMessage();
        msg.what = 0;
        msg.arg1 = index;
        msg.obj = info;
        this.handler.sendMessage(msg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cd_repeat /* 2131427913 */:
                if (this.valueRepeat == 0) {
                    FFuncYLFocus.C_SET_CONTROT(16, 4);
                    ToastInfo.showToast(v.getContext(), "重复关闭");
                } else if (this.valueRepeat == 1) {
                    FFuncYLFocus.C_SET_CONTROT(16, 5);
                    ToastInfo.showToast(v.getContext(), "重复曲目");
                } else {
                    FFuncYLFocus.C_SET_CONTROT(16, 6);
                    ToastInfo.showToast(v.getContext(), "重复文件夹");
                }
                this.valueRepeat = (this.valueRepeat + 1) % 3;
                break;
            case R.id.cd_prev /* 2131427915 */:
                FFuncYLFocus.C_SET_CONTROT(16, 11);
                break;
            case R.id.cd_fb /* 2131427916 */:
                FFuncYLFocus.C_SET_CONTROT(16, 13);
                break;
            case R.id.cd_ff /* 2131427919 */:
                FFuncYLFocus.C_SET_CONTROT(16, 12);
                break;
            case R.id.cd_next /* 2131427920 */:
                FFuncYLFocus.C_SET_CONTROT(16, 10);
                break;
            case R.id.cd_remond /* 2131433600 */:
                if (this.valueRemond == 0) {
                    FFuncYLFocus.C_SET_CONTROT(16, 7);
                    ToastInfo.showToast(v.getContext(), "随机关闭");
                } else if (this.valueRemond == 1) {
                    FFuncYLFocus.C_SET_CONTROT(16, 8);
                    ToastInfo.showToast(v.getContext(), "随机播放文件夹");
                } else {
                    FFuncYLFocus.C_SET_CONTROT(16, 9);
                    ToastInfo.showToast(v.getContext(), "随机播放碟片");
                }
                this.valueRemond = (this.valueRemond + 1) % 3;
                break;
            case R.id.cd_eject /* 2131433601 */:
                FFuncYLFocus.C_SET_CONTROT(16, 14);
                break;
            case R.id.cd_back /* 2131433602 */:
                FFuncYLFocus.C_SET_CONTROT(16, 15);
                break;
        }
    }
}
