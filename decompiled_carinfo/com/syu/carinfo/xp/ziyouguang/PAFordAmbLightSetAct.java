package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAFordAmbLightSetAct extends Activity implements View.OnTouchListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D40_D1_B70 /* 474 */:
                    ((TextView) PAFordAmbLightSetAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(PAFordAmbLightSetAct.this.getString(R.string.xp_ylford_set_brightness)) + ": " + value);
                    ((ProgressBar) PAFordAmbLightSetAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                    ((ProgressBar) PAFordAmbLightSetAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D40_D2_B30 /* 475 */:
                    PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color1_n);
                    PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color2_n);
                    PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color3_n);
                    PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color4_n);
                    PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color5_n);
                    PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color6_n);
                    PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color7_n);
                    switch (value) {
                        case 0:
                            PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color1_p);
                            break;
                        case 1:
                            PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color2_p);
                            break;
                        case 2:
                            PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color3_p);
                            break;
                        case 3:
                            PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color4_p);
                            break;
                        case 4:
                            PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color5_p);
                            break;
                        case 5:
                            PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color6_p);
                            break;
                        case 6:
                            PAFordAmbLightSetAct.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_ford_amblight_color7_p);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_ford_amblightset);
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
        findViewById(R.id.btn_plus9).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427457 */:
                    DataCanbus.PROXY.cmd(0, new int[]{64}, null, null);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    DataCanbus.PROXY.cmd(0, new int[]{64, 1}, null, null);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    DataCanbus.PROXY.cmd(0, new int[]{65}, null, null);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    DataCanbus.PROXY.cmd(0, new int[]{65, 1}, null, null);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    DataCanbus.PROXY.cmd(0, new int[]{65, 2}, null, null);
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    DataCanbus.PROXY.cmd(0, new int[]{65, 3}, null, null);
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    DataCanbus.PROXY.cmd(0, new int[]{65, 4}, null, null);
                    break;
                case R.id.btn_plus8 /* 2131427478 */:
                    DataCanbus.PROXY.cmd(0, new int[]{65, 5}, null, null);
                    break;
                case R.id.btn_plus9 /* 2131427481 */:
                    DataCanbus.PROXY.cmd(0, new int[]{65, 6}, null, null);
                    break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[474].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[475].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[474].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[475].removeNotify(this.notifyCanbus);
    }
}
