package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ZXVinfastLuxAirControlAct extends Activity implements View.OnTouchListener {
    public static ZXVinfastLuxAirControlAct mInstance;
    public static boolean mIsFront = false;
    public ArrayList<String> mLauStylelist;
    int curscrollState = -1;
    int curscrollcnt = 0;
    int tempdata = 0;
    int winlevdata = 0;
    boolean recvflag = false;
    boolean seekbartouch = false;
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { // from class: com.syu.carinfo.xp.ziyouguang.ZXVinfastLuxAirControlAct.1
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.layout_view2 /* 2131427557 */:
                    ZXVinfastLuxAirControlAct.this.seekbartouch = false;
                    break;
                case R.id.layout_view4 /* 2131427564 */:
                    ZXVinfastLuxAirControlAct.this.seekbartouch = false;
                    break;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            int value = arg0.getProgress();
            if (value < 1) {
                value = 1;
            }
            if (ZXVinfastLuxAirControlAct.this.seekbartouch) {
                switch (arg0.getId()) {
                    case R.id.layout_view2 /* 2131427557 */:
                        DataCanbus.PROXY.cmd(41, new int[]{1, value}, null, null);
                        break;
                    case R.id.layout_view4 /* 2131427564 */:
                        DataCanbus.PROXY.cmd(41, new int[]{2, value}, null, null);
                        break;
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar arg0) {
            switch (arg0.getId()) {
                case R.id.layout_view2 /* 2131427557 */:
                    ZXVinfastLuxAirControlAct.this.seekbartouch = true;
                    break;
                case R.id.layout_view4 /* 2131427564 */:
                    ZXVinfastLuxAirControlAct.this.seekbartouch = true;
                    break;
            }
        }
    };
    int touchcnt = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.ZXVinfastLuxAirControlAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    ZXVinfastLuxAirControlAct.this.mUpdateAcOn();
                    break;
                case 12:
                    ZXVinfastLuxAirControlAct.this.mUpdateCycle();
                    break;
                case 14:
                    ZXVinfastLuxAirControlAct.this.mUpdateSyncOn();
                    break;
                case 18:
                case 19:
                case 20:
                case 22:
                case 23:
                case 24:
                    ZXVinfastLuxAirControlAct.this.updateBtnSource();
                    break;
                case 21:
                    ZXVinfastLuxAirControlAct.this.mUpdaterAirWindLevelLeft();
                    break;
                case 25:
                    ZXVinfastLuxAirControlAct.this.mUpdaterAirWindLevelRight();
                    break;
                case 49:
                    ZXVinfastLuxAirControlAct.this.mUpdateAutoOn();
                    break;
                case 50:
                    ZXVinfastLuxAirControlAct.this.mUpdateAutoRightOn();
                    break;
                case 53:
                    ZXVinfastLuxAirControlAct.this.mUpdateAcMaxOn();
                    break;
                case 58:
                    ZXVinfastLuxAirControlAct.this.mUpdateIonOn();
                    break;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(38, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0448_zx_vinfast_lux_air);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_sync).setOnTouchListener(this);
        findViewById(R.id.air_xts_auto_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_ac).setOnTouchListener(this);
        findViewById(R.id.air_xts_ion).setOnTouchListener(this);
        findViewById(R.id.air_xts_cycle).setOnTouchListener(this);
        findViewById(R.id.air_xts_maxac).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.veiw_air_frontmode).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.xp.ziyouguang.ZXVinfastLuxAirControlAct.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int touchX = (int) event.getX();
                int touchY = (int) event.getY();
                int Xvalue = Math.abs(touchX - 257);
                int Yvalue = Math.abs(touchY - 171);
                Log.v("zed", " touchX == " + touchX + "  touchY = " + touchY + "  Xvalue = " + Xvalue + "  Yvalue = " + Yvalue);
                Log.v("zed", " Math.tan((40 * Math.PI) / 180.f) == " + Math.tan(0.6981317007977318d));
                if (touchX < 257 && touchY < 171) {
                    if (Yvalue < Math.tan(0.6981317007977318d) * ((double) Xvalue)) {
                        switch (event.getAction()) {
                            case 0:
                                ZXVinfastLuxAirControlAct.this.sendCmd(6, 1);
                                break;
                            case 1:
                                ZXVinfastLuxAirControlAct.this.sendCmd(6, 0);
                                break;
                        }
                    } else {
                        switch (event.getAction()) {
                            case 0:
                                ZXVinfastLuxAirControlAct.this.sendCmd(5, 1);
                                break;
                            case 1:
                                ZXVinfastLuxAirControlAct.this.sendCmd(5, 0);
                                break;
                        }
                    }
                }
                if (touchX < 257 && touchY > 171 && Yvalue < Math.tan(0.6981317007977318d) * ((double) Xvalue)) {
                    switch (event.getAction()) {
                        case 0:
                            ZXVinfastLuxAirControlAct.this.sendCmd(7, 1);
                            break;
                        case 1:
                            ZXVinfastLuxAirControlAct.this.sendCmd(7, 0);
                            break;
                    }
                }
                if (touchX > 257 && touchY < 171) {
                    if (Yvalue < Math.tan(0.6981317007977318d) * ((double) Xvalue)) {
                        switch (event.getAction()) {
                            case 0:
                                ZXVinfastLuxAirControlAct.this.sendCmd(19, 1);
                                break;
                            case 1:
                                ZXVinfastLuxAirControlAct.this.sendCmd(19, 0);
                                break;
                        }
                    } else {
                        switch (event.getAction()) {
                            case 0:
                                ZXVinfastLuxAirControlAct.this.sendCmd(5, 1);
                                break;
                            case 1:
                                ZXVinfastLuxAirControlAct.this.sendCmd(5, 0);
                                break;
                        }
                    }
                }
                if (touchX > 257 && touchY > 171 && Yvalue < Math.tan(0.6981317007977318d) * ((double) Xvalue)) {
                    switch (event.getAction()) {
                        case 0:
                            ZXVinfastLuxAirControlAct.this.sendCmd(20, 1);
                            break;
                        case 1:
                            ZXVinfastLuxAirControlAct.this.sendCmd(20, 0);
                            break;
                    }
                    return true;
                }
                return true;
            }
        });
        seekbaronClick((SeekBar) findViewById(R.id.layout_view2));
        seekbaronClick((SeekBar) findViewById(R.id.layout_view4));
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        this.recvflag = false;
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        boolean flag = false;
        switch (id) {
            case R.id.air_xts_auto /* 2131427436 */:
                data0 = 16;
                break;
            case R.id.air_xts_cycle /* 2131427437 */:
                data0 = 15;
                break;
            case R.id.air_xts_ac /* 2131427440 */:
                data0 = 14;
                break;
            case R.id.air_xts_maxac /* 2131427441 */:
                data0 = 23;
                break;
            case R.id.air_xts_sync /* 2131427442 */:
                data0 = 13;
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                data0 = 1;
                flag = true;
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                data0 = 2;
                flag = true;
                break;
            case R.id.air_xts_ion /* 2131427674 */:
                data0 = 18;
                break;
            case R.id.air_xts_auto_right /* 2131428720 */:
                data0 = 17;
                break;
        }
        if (data0 != 0) {
            if (flag) {
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{data0, 0}, null, null);
                }
            } else if (event.getAction() == 0) {
                sendCmd(data0, 1);
            } else if (event.getAction() == 1) {
                sendCmd(data0, 0);
            }
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCycle() {
        int cycle = DataCanbus.DATA[12];
        if (findViewById(R.id.air_xts_cycle) != null) {
            if (cycle == 0) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_vinfast_lux_cycle_n);
            } else if (cycle == 1) {
                findViewById(R.id.air_xts_cycle).setBackgroundResource(R.drawable.ic_air_vinfast_lux_cycle_p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoOn() {
        int acOn = DataCanbus.DATA[49];
        findViewById(R.id.air_xts_auto).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_vinfast_lux_auto_n : R.drawable.ic_air_vinfast_lux_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAutoRightOn() {
        int acOn = DataCanbus.DATA[50];
        findViewById(R.id.air_xts_auto_right).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_vinfast_lux_auto_n : R.drawable.ic_air_vinfast_lux_auto_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcOn() {
        int acOn = DataCanbus.DATA[11];
        findViewById(R.id.air_xts_ac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_vinfast_lux_ac_n : R.drawable.ic_air_vinfast_lux_ac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAcMaxOn() {
        int acOn = DataCanbus.DATA[53];
        findViewById(R.id.air_xts_maxac).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_vinfast_lux_maxac_n : R.drawable.ic_air_vinfast_lux_maxac_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSyncOn() {
        int acOn = DataCanbus.DATA[14];
        findViewById(R.id.air_xts_sync).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_vinfast_lux_sync_n : R.drawable.ic_air_vinfast_lux_sync_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateIonOn() {
        int acOn = DataCanbus.DATA[58];
        findViewById(R.id.air_xts_ion).setBackgroundResource(acOn == 0 ? R.drawable.ic_air_vinfast_lux_ion_n : R.drawable.ic_air_vinfast_lux_ion_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        if (leave != 0) {
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_air_vinfast_lux_power_p);
        } else {
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_air_vinfast_lux_power_n);
        }
        switch (leave) {
            case 0:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind0);
                break;
            case 1:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind1);
                break;
            case 2:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind2);
                break;
            case 3:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind3);
                break;
            case 4:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind4);
                break;
            case 5:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind5);
                break;
            case 6:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind6);
                break;
            case 7:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_wind7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelRight() {
        int leave = DataCanbus.DATA[25];
        if (leave != 0) {
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_air_vinfast_lux_power_p);
        } else {
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_air_vinfast_lux_power_n);
        }
        switch (leave) {
            case 0:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind0);
                break;
            case 1:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind1);
                break;
            case 2:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind2);
                break;
            case 3:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind3);
                break;
            case 4:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind4);
                break;
            case 5:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind5);
                break;
            case 6:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind6);
                break;
            case 7:
                findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_air_zx_vinfast_lux_rightwind7);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtnSource() {
        int body = DataCanbus.DATA[19];
        int window = DataCanbus.DATA[18];
        int foot = DataCanbus.DATA[20];
        int rbody = DataCanbus.DATA[23];
        int rwindow = DataCanbus.DATA[22];
        int rfoot = DataCanbus.DATA[24];
        if (window == 1 || rwindow == 1) {
            findViewById(R.id.air_sp_mode_up).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_mode_up).setVisibility(8);
        }
        if (body == 1) {
            findViewById(R.id.air_sp_mode_body).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_mode_body).setVisibility(8);
        }
        if (foot == 1) {
            findViewById(R.id.air_sp_mode_foot).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_mode_foot).setVisibility(8);
        }
        if (rbody == 1) {
            findViewById(R.id.air_sp_mode_body_right).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_mode_body_right).setVisibility(8);
        }
        if (rfoot == 1) {
            findViewById(R.id.air_sp_mode_foot_right).setVisibility(0);
        } else {
            findViewById(R.id.air_sp_mode_foot_right).setVisibility(8);
        }
    }
}
