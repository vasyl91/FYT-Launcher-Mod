package com.syu.carinfo.rzc.sanlin;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCBenzPanelButtonSet extends Activity implements View.OnTouchListener {
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.RZCBenzPanelButtonSet.1
        @Override // java.lang.Runnable
        public void run() {
            RZCBenzPanelButtonSet.this.num++;
            if (RZCBenzPanelButtonSet.this.num >= 3 && RZCBenzPanelButtonSet.this.curnum != 0) {
                RZCBenzPanelButtonSet.this.mSetCurFrq(RZCBenzPanelButtonSet.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(RZCBenzPanelButtonSet.this.mCalTime);
            HandlerUI.getInstance().postDelayed(RZCBenzPanelButtonSet.this.mCalTime, 500L);
        }
    };
    boolean flag = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCBenzPanelButtonSet.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 140:
                    switch (value) {
                        case 0:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_benz_button4_n);
                            break;
                        case 1:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_benz_button4_p);
                            break;
                    }
                    break;
                case 141:
                    switch (value) {
                        case 0:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_benz_button3_n);
                            break;
                        case 1:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_benz_button3_p);
                            break;
                    }
                    break;
                case 142:
                    switch (value) {
                        case 0:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_benz_button2_n);
                            break;
                        case 1:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_benz_button2_p);
                            break;
                    }
                    break;
                case 143:
                    switch (value) {
                        case 0:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_benz_button1_n);
                            break;
                        case 1:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_benz_button1_p);
                            break;
                    }
                    break;
                case 144:
                    switch (value) {
                        case 0:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_benz_passairbag_n);
                            break;
                        case 1:
                            RZCBenzPanelButtonSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_benz_passairbag_p);
                            break;
                    }
                    break;
                case 145:
                    ((TextView) RZCBenzPanelButtonSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 146:
                    ((TextView) RZCBenzPanelButtonSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_rzc_benz_panel_settings);
        init();
    }

    public void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_plus8).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427458 */:
                    setCarInfo(64, 1);
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    setCarInfo(65, 1);
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    setCarInfo(66, 1);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    setCarInfo(67, 1);
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    this.curnum = 77;
                    setCarInfo(77, 1);
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    this.curnum = 76;
                    setCarInfo(76, 1);
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    this.curnum = 79;
                    setCarInfo(79, 1);
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_plus8 /* 2131427479 */:
                    this.curnum = 78;
                    setCarInfo(78, 1);
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427458 */:
                    setCarInfo(64, 0);
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    setCarInfo(65, 0);
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    setCarInfo(66, 0);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    setCarInfo(67, 0);
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        setCarInfo(77, 0);
                    }
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        setCarInfo(76, 0);
                    }
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        setCarInfo(79, 0);
                    }
                    break;
                case R.id.btn_plus8 /* 2131427479 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        setCarInfo(78, 0);
                    }
                    break;
            }
        }
        return false;
    }

    private void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 500L);
            this.num = 0;
            this.flag = false;
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetCurFrq(int value) {
        this.flag = true;
        DataCanbus.PROXY.cmd(3, new int[]{value, 2}, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{65, 168}, null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
    }
}
