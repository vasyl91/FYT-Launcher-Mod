package com.syu.carinfo.focus.yl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

public class ActivityCD extends Activity implements View.OnClickListener {
    private static final int msg_update_list = 0;
    FileAdapter adapter;
    private IUiNotify mNotifyDvd = new IUiNotify() { 
        private int curTrack;
        private int folderId;
        private ListInfo info;
        private int playTime;
        private String str;
        private int totalTrack;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)) != null && ints != null && ints.length > 1) {
                        this.curTrack = ints[0];
                        this.totalTrack = ints[1];
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_track)) + this.curTrack + "/" + this.totalTrack);
                        break;
                    }
                case 99:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)) != null) {
                        this.folderId = DataCanbus.DATA[updateCode];
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_track)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_track)) + this.curTrack + "/" + this.totalTrack);
                        break;
                    }
                case 100:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_time)) != null) {
                        this.playTime = DataCanbus.DATA[updateCode];
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_time)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_playtime)) + String.format("%02d:%02d", Integer.valueOf(this.playTime / 60), Integer.valueOf(this.playTime % 60)));
                        break;
                    }
                case 101:
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
                case 105:
                    if (((TextView) ActivityCD.this.findViewById(R.id.focus_cd_title)) != null) {
                        this.str = "";
                        if (strs != null && strs.length > 0) {
                            this.str = strs[0];
                        }
                        ((TextView) ActivityCD.this.findViewById(R.id.focus_cd_title)).setText(String.valueOf(ActivityCD.this.getString(R.string.str_car_cd_title)) + this.str);
                        break;
                    }
                case 106:
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
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_yl_focus_cd);
        this.adapter = new FileAdapter(this, this.mFileList);
        ((ListView) findViewById(R.id.focus_cd_list)).setAdapter((ListAdapter) this.adapter);
        ((ListView) findViewById(R.id.focus_cd_list)).setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FFuncYLFocus.C_SET_CONTROT(16, 1);
        FFuncYLFocus.C_CMD_REQUEST(48);
        FFuncYLFocus.C_CMD_REQUEST(50);
        FFuncYLFocus.C_CMD_REQUEST(51);
        FFuncYLFocus.C_CMD_REQUEST(52);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyDvd, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyDvd, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyDvd);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyDvd);
    }

    
    public void updateList(int index, ListInfo info) {
        Message msg = this.handler.obtainMessage();
        msg.what = 0;
        msg.arg1 = index;
        msg.obj = info;
        this.handler.sendMessage(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cd_repeat /* 2131427916 */:
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
            case R.id.cd_prev /* 2131427918 */:
                FFuncYLFocus.C_SET_CONTROT(16, 11);
                break;
            case R.id.cd_fb /* 2131427919 */:
                FFuncYLFocus.C_SET_CONTROT(16, 13);
                break;
            case R.id.cd_ff /* 2131427922 */:
                FFuncYLFocus.C_SET_CONTROT(16, 12);
                break;
            case R.id.cd_next /* 2131427923 */:
                FFuncYLFocus.C_SET_CONTROT(16, 10);
                break;
            case R.id.cd_remond /* 2131433524 */:
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
            case R.id.cd_eject /* 2131433525 */:
                FFuncYLFocus.C_SET_CONTROT(16, 14);
                break;
            case R.id.cd_back /* 2131433526 */:
                FFuncYLFocus.C_SET_CONTROT(16, 15);
                break;
        }
    }
}
