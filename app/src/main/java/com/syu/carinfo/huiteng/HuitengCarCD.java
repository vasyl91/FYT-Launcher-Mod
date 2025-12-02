package com.syu.carinfo.huiteng;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class HuitengCarCD extends Activity implements View.OnTouchListener {
    public static HuitengCarCD mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    Runnable CdControl = new Runnable() { 
        @Override
        public void run() {
            HuitengCarCD.this.setCdControl(HuitengCarCD.this.cmdId, 0);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                    ((TextView) HuitengCarCD.this.findViewById(R.id.huiteng_cd_num)).setText(String.format("CD: %d", Integer.valueOf(value)));
                    break;
                case 110:
                    ((TextView) HuitengCarCD.this.findViewById(R.id.huiteng_cd_track)).setText(String.format("Track: %d", Integer.valueOf(value)));
                    break;
                case 111:
                case 112:
                    HuitengCarCD.this.mUpdaterCdTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
            //setContentView(R.layout.layout_0439_huiteng_carcd_9853);
        } else {
            //setContentView(R.layout.layout_0439_huiteng_carcd);
        }
        mInstance = this;
        init();
    }

    private void init() {
        findViewById(R.id.huiteng_cd_prev).setOnTouchListener(this);
        findViewById(R.id.huiteng_cd_playpause).setOnTouchListener(this);
        findViewById(R.id.huiteng_cd_next).setOnTouchListener(this);
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

    
    public void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(5, cmdId, touchState);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.huiteng_cd_prev /* 2131428207 */:
                this.cmdId = 19;
                break;
            case R.id.huiteng_cd_playpause /* 2131428208 */:
                this.cmdId = 17;
                break;
            case R.id.huiteng_cd_next /* 2131428209 */:
                this.cmdId = 20;
                break;
        }
        switch (event.getAction()) {
            case 0:
                this.touchState = 1;
                this.bNeedSend = true;
                setCdControl(this.cmdId, this.touchState);
                break;
            case 1:
                this.bNeedSend = false;
                this.touchState = 0;
                HandlerUI.getInstance().postDelayed(this.CdControl, 100L);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdTime() {
        int value = DataCanbus.DATA[111];
        int value1 = DataCanbus.DATA[112];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value1) + ":" + value);
    }
}
