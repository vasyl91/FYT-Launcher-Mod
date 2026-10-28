package com.syu.carinfo.landrover;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityWCLandRover extends Activity implements View.OnTouchListener {
    int touchState;
    int x;
    int y;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode != 10 && DataCanbus.DATA[10] == 0) {
            }
            switch (updateCode) {
                case 10:
                    ActivityWCLandRover.this.updatePower(DataCanbus.DATA[updateCode]);
                    break;
                case 14:
                    ActivityWCLandRover.this.updateDual(DataCanbus.DATA[updateCode]);
                    break;
                case 18:
                    ActivityWCLandRover.this.updateBlowWin(DataCanbus.DATA[updateCode]);
                    break;
                case 19:
                    ActivityWCLandRover.this.updateBlowBody(DataCanbus.DATA[updateCode]);
                    break;
                case 20:
                    ActivityWCLandRover.this.updateBlowFoot(DataCanbus.DATA[updateCode]);
                    break;
                case 55:
                    if (DataCanbus.DATA[updateCode] == 0) {
                        ActivityWCLandRover.this.back();
                        break;
                    }
            }
        }
    };
    Handler handler = new Handler(Looper.getMainLooper()) { 
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case R.id.btn_land_blow_win /* 2131429832 */:
                    ActivityWCLandRover.this.updateBlowWin(DataCanbus.DATA[18]);
                    break;
                case R.id.btn_land_blow_body /* 2131429833 */:
                    ActivityWCLandRover.this.updateBlowBody(DataCanbus.DATA[19]);
                    break;
                case R.id.btn_land_blow_foot /* 2131429834 */:
                    ActivityWCLandRover.this.updateBlowFoot(DataCanbus.DATA[20]);
                    break;
                case R.id.btn_power /* 2131429835 */:
                    ActivityWCLandRover.this.updatePower(DataCanbus.DATA[10]);
                    break;
                case R.id.btn_dual /* 2131429836 */:
                    ActivityWCLandRover.this.updateDual(DataCanbus.DATA[14]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_411_landrover);
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_land_blow_win)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_land_blow_body)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_land_blow_foot)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_power)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_dual)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.PROXY.cmd(2, new int[]{240, 255}, null, null);
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        finish();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mCanbusNotify);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (DataCanbus.DATA[10] != 0 || v.getId() == 2131429835) {
            this.touchState = getTouchMode(event.getAction());
            switch (v.getId()) {
                case R.id.btn_land_blow_win /* 2131429832 */:
                    if (this.touchState == 0) {
                        ((Button) findViewById(R.id.btn_land_blow_win)).setBackgroundResource(R.drawable.ic_landrover_win_press);
                    }
                    this.x = 397;
                    this.y = 86;
                    break;
                case R.id.btn_land_blow_body /* 2131429833 */:
                    if (this.touchState == 0) {
                        ((Button) findViewById(R.id.btn_land_blow_body)).setBackgroundResource(R.drawable.ic_landrover_body_press);
                    }
                    this.x = 386;
                    this.y = 171;
                    break;
                case R.id.btn_land_blow_foot /* 2131429834 */:
                    if (this.touchState == 0) {
                        ((Button) findViewById(R.id.btn_land_blow_foot)).setBackgroundResource(R.drawable.ic_landrover_foot_press);
                    }
                    this.x = 381;
                    this.y = 249;
                    break;
                case R.id.btn_power /* 2131429835 */:
                    if (this.touchState == 0) {
                        ((Button) findViewById(R.id.btn_power)).setBackgroundResource(R.drawable.ic_landrover_power_press);
                    }
                    this.x = 299;
                    this.y = 360;
                    if (DataCanbus.DATA[1000] == 65947) {
                        this.x = Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B76;
                        this.y = 360;
                        break;
                    }
                case R.id.btn_dual /* 2131429836 */:
                    if (this.touchState == 0) {
                        ((Button) findViewById(R.id.btn_dual)).setBackgroundResource(R.drawable.ic_landrover_btn_press);
                    }
                    this.x = Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B76;
                    this.y = 360;
                    if (DataCanbus.DATA[1000] == 65947) {
                        this.x = 675;
                        this.y = 360;
                        break;
                    }
            }
            if (this.touchState == 1) {
                this.handler.sendEmptyMessageDelayed(v.getId(), 1000L);
            }
            if (this.touchState >= 0) {
                DataCanbus.PROXY.cmd(1, new int[]{this.x, this.y, this.touchState}, null, null);
            }
        }
        return false;
    }

    private int getTouchMode(int touchAction) {
        if (touchAction == 0) {
            return 0;
        }
        if (touchAction != 1) {
            return touchAction == 2 ? 2 : -1;
        }
        return 1;
    }

    
    public void back() {
        finish();
    }

    
    public void updatePower(int value) {
        if (value == 1) {
            ((Button) findViewById(R.id.btn_power)).setBackgroundResource(R.drawable.d_btn_landrover_power_p);
            ((Button) findViewById(R.id.btn_dual)).setTextColor(-1);
            updateBlowWin(DataCanbus.DATA[18]);
            updateBlowBody(DataCanbus.DATA[19]);
            updateBlowFoot(DataCanbus.DATA[20]);
            updateDual(DataCanbus.DATA[14]);
            return;
        }
        ((Button) findViewById(R.id.btn_power)).setBackgroundResource(R.drawable.d_btn_landrover_power);
        ((Button) findViewById(R.id.btn_dual)).setTextColor(Color.parseColor("#ACBFD2"));
        ((Button) findViewById(R.id.btn_land_blow_win)).setBackgroundResource(R.drawable.ic_landrover_win_n);
        ((Button) findViewById(R.id.btn_land_blow_body)).setBackgroundResource(R.drawable.ic_landrover_body_n);
        ((Button) findViewById(R.id.btn_land_blow_foot)).setBackgroundResource(R.drawable.ic_landrover_foot_n);
        ((Button) findViewById(R.id.btn_dual)).setBackgroundResource(R.drawable.ic_landrover_btn);
    }

    
    public void updateDual(int value) {
        if (DataCanbus.DATA[10] > 0) {
            if (value == 1) {
                ((Button) findViewById(R.id.btn_dual)).setBackgroundResource(R.drawable.d_btn_landrover_p);
            } else {
                ((Button) findViewById(R.id.btn_dual)).setBackgroundResource(R.drawable.d_btn_landrover);
            }
        }
    }

    
    public void updateBlowWin(int value) {
        if (DataCanbus.DATA[10] > 0) {
            if (value == 1) {
                ((Button) findViewById(R.id.btn_land_blow_win)).setBackgroundResource(R.drawable.d_btn_landrover_win_p);
            } else {
                ((Button) findViewById(R.id.btn_land_blow_win)).setBackgroundResource(R.drawable.d_btn_landrover_win);
            }
        }
    }

    
    public void updateBlowBody(int value) {
        if (DataCanbus.DATA[10] > 0) {
            if (value == 1) {
                ((Button) findViewById(R.id.btn_land_blow_body)).setBackgroundResource(R.drawable.d_btn_landrover_body_p);
            } else {
                ((Button) findViewById(R.id.btn_land_blow_body)).setBackgroundResource(R.drawable.d_btn_landrover_body);
            }
        }
    }

    
    public void updateBlowFoot(int value) {
        if (DataCanbus.DATA[10] > 0) {
            if (value == 1) {
                ((Button) findViewById(R.id.btn_land_blow_foot)).setBackgroundResource(R.drawable.d_btn_landrover_foot_p);
            } else {
                ((Button) findViewById(R.id.btn_land_blow_foot)).setBackgroundResource(R.drawable.d_btn_landrover_foot);
            }
        }
    }
}
