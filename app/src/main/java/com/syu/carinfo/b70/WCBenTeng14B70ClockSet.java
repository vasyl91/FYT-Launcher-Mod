package com.syu.carinfo.b70;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class WCBenTeng14B70ClockSet extends BaseActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    private Handler handler;
    private boolean is24Clock = true;
    private int ShowRunId = 0;
    private Runnable runTimeMinus = new Runnable() { 
        @Override
        public void run() {
            if (WCBenTeng14B70ClockSet.this.ShowRunId != 2) {
                return;
            }
            WCBenTeng14B70ClockSet.this.CmdToServer(6, 2);
            WCBenTeng14B70ClockSet.this.handler.postDelayed(this, 100L);
        }
    };
    private Runnable runTimePlus = new Runnable() { 
        @Override
        public void run() {
            if (WCBenTeng14B70ClockSet.this.ShowRunId != 1) {
                return;
            }
            WCBenTeng14B70ClockSet.this.CmdToServer(6, 1);
            WCBenTeng14B70ClockSet.this.handler.postDelayed(this, 100L);
        }
    };
    private Runnable runMunitsMinus = new Runnable() { 
        @Override
        public void run() {
            if (WCBenTeng14B70ClockSet.this.ShowRunId != 4) {
                return;
            }
            WCBenTeng14B70ClockSet.this.CmdToServer(7, 2);
            WCBenTeng14B70ClockSet.this.handler.postDelayed(this, 100L);
        }
    };
    private Runnable runMunitsPlus = new Runnable() { 
        @Override
        public void run() {
            if (WCBenTeng14B70ClockSet.this.ShowRunId != 3) {
                return;
            }
            WCBenTeng14B70ClockSet.this.CmdToServer(7, 1);
            WCBenTeng14B70ClockSet.this.handler.postDelayed(this, 100L);
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_benteng14b70clockset);
        this.handler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.time_set_munits).setOnClickListener(this);
        findViewById(R.id.time_set_munits).setOnLongClickListener(this);
        findViewById(R.id.time_set_munits).setOnTouchListener(this);
        findViewById(R.id.time_set_plus).setOnClickListener(this);
        findViewById(R.id.time_set_plus).setOnLongClickListener(this);
        findViewById(R.id.time_set_plus).setOnTouchListener(this);
        findViewById(R.id.minits_set_munits).setOnClickListener(this);
        findViewById(R.id.minits_set_munits).setOnLongClickListener(this);
        findViewById(R.id.minits_set_munits).setOnTouchListener(this);
        findViewById(R.id.minits_set_plus).setOnClickListener(this);
        findViewById(R.id.minits_set_plus).setOnLongClickListener(this);
        findViewById(R.id.minits_set_plus).setOnTouchListener(this);
        findViewById(R.id.colock_24_set).setOnClickListener(this);
        findViewById(R.id.colock_12_set).setOnClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.time_set_munits /* 2131430498 */:
                this.ShowRunId = 2;
                this.handler.post(this.runTimeMinus);
                return true;
            case R.id.time_set_plus /* 2131430499 */:
                this.ShowRunId = 1;
                this.handler.post(this.runTimePlus);
                return true;
            case R.id.minits_set_munits /* 2131430500 */:
                this.handler.post(this.runMunitsMinus);
                this.ShowRunId = 4;
                return true;
            case R.id.minits_set_plus /* 2131430501 */:
                this.ShowRunId = 3;
                this.handler.post(this.runMunitsPlus);
                return true;
            default:
                this.ShowRunId = 0;
                return true;
        }
    }

    @Override
    public void onClick(View v) {
        this.ShowRunId = 0;
        int id = v.getId();
        switch (id) {
            case R.id.time_set_munits /* 2131430498 */:
                CmdToServer(6, 2);
                break;
            case R.id.time_set_plus /* 2131430499 */:
                CmdToServer(6, 1);
                break;
            case R.id.minits_set_munits /* 2131430500 */:
                CmdToServer(7, 2);
                break;
            case R.id.minits_set_plus /* 2131430501 */:
                CmdToServer(7, 1);
                break;
            case R.id.colock_24_set /* 2131430502 */:
                this.is24Clock = true;
                if (this.is24Clock) {
                    findViewById(R.id.colock_24_set).setBackground(getResources().getDrawable(R.drawable.ic_accord9_back_car_btn_p));
                    findViewById(R.id.colock_12_set).setBackground(getResources().getDrawable(R.drawable.ic_accord9_back_car_btn_n));
                }
                CmdToServer(8, 1);
                break;
            case R.id.colock_12_set /* 2131430503 */:
                this.is24Clock = false;
                if (!this.is24Clock) {
                    findViewById(R.id.colock_24_set).setBackground(getResources().getDrawable(R.drawable.ic_accord9_back_car_btn_n));
                    findViewById(R.id.colock_12_set).setBackground(getResources().getDrawable(R.drawable.ic_accord9_back_car_btn_p));
                }
                CmdToServer(8, 2);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (this.is24Clock) {
            findViewById(R.id.colock_24_set).setBackground(getResources().getDrawable(R.drawable.ic_accord9_back_car_btn_p));
        } else {
            findViewById(R.id.colock_12_set).setBackground(getResources().getDrawable(R.drawable.ic_accord9_back_car_btn_p));
        }
    }

    
    public void CmdToServer(int int1, int int2) {
        DataCanbus.PROXY.cmd(19, new int[]{int1, int2}, null, null);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if (action == 1) {
            this.ShowRunId = 0;
        } else if (action == 0) {
            super.onTouchEvent(event);
        }
        return false;
    }
}
