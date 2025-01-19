package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.Iterator;

public class Act_LEDScreen_AoDeSai_wc extends Activity {
    public static boolean mIsFront = false;
    ArrayList<View> bignum1;
    ArrayList<View> bignum2;
    ArrayList<View> bignum3;
    ArrayList<View> bignum4;
    ArrayList<View> bignum5;
    ArrayList<View> num1;
    ArrayList<View> num2;
    ArrayList<View> num3;
    ArrayList<View> num4;
    ArrayList<View> num5;
    int[] idNumSlice = {R.id.iv_num_a, R.id.iv_num_b, R.id.iv_num_c, R.id.iv_num_d, R.id.iv_num_e, R.id.iv_num_f, R.id.iv_num_g, R.id.iv_num_h, R.id.iv_num_i, R.id.iv_num_j, R.id.iv_num_k, R.id.iv_num_l, R.id.iv_num_m, R.id.iv_num_n, R.id.iv_num_o, R.id.iv_num_p, R.id.iv_num_q, R.id.iv_num_r, R.id.iv_num_s};
    View vTempNumSlice = null;
    private int[] resid = {118, 119, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147};
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_dd), value == 1);
                    break;
                case 119:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_d_1), value == 1);
                    break;
                case 120:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_scan), value == 1);
                    break;
                case 121:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_rdm), value == 1);
                    break;
                case 122:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_d_2), value == 1);
                    break;
                case 123:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_rpt), value == 1);
                    break;
                case 124:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_wave), value == 1);
                    break;
                case 125:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_disc), value == 1);
                    break;
                case 126:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_asel), value == 1);
                    break;
                case 127:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_track), value == 1);
                    break;
                case 128:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_1), value == 1);
                    break;
                case 129:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_2), value == 1);
                    break;
                case 130:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_3), value == 1);
                    break;
                case 131:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_4), value == 1);
                    break;
                case 132:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_5), value == 1);
                    break;
                case 133:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_6), value == 1);
                    break;
                case 134:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_comment1), value == 1);
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_comment3), value == 1);
                    break;
                case 135:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_big_dot), value == 1);
                    break;
                case 136:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num1, ints);
                        break;
                    }
                case 137:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num2, ints);
                        break;
                    }
                case 138:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num3, ints);
                        break;
                    }
                case 139:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num4, ints);
                        break;
                    }
                case 140:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num5, ints);
                        break;
                    }
                case 141:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setSTCHByCan(ints);
                        break;
                    }
                case 142:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum1, ints);
                        break;
                    }
                case 143:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum2, ints);
                        break;
                    }
                case 144:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum3, ints);
                        break;
                    }
                case 145:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum4, ints);
                        break;
                    }
                case 146:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum5, ints);
                        break;
                    }
                case 147:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_comment2), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_166_led_screen);
        init();
    }

    private void init() {
        this.num1 = getNumViews(findViewById(R.id.id_led_num_1));
        this.num2 = getNumViews(findViewById(R.id.id_led_num_2));
        this.num3 = getNumViews(findViewById(R.id.id_led_num_3));
        this.num4 = getNumViews(findViewById(R.id.id_led_num_4));
        this.num5 = getNumViews(findViewById(R.id.id_led_num_5));
        this.bignum1 = getNumViews(findViewById(R.id.id_led_big_num1));
        this.bignum2 = getNumViews(findViewById(R.id.id_led_big_num2));
        this.bignum3 = getNumViews(findViewById(R.id.id_led_big_num3));
        this.bignum4 = getNumViews(findViewById(R.id.id_led_big_num4));
        this.bignum5 = getNumViews(findViewById(R.id.id_led_big_num5));
    }

    
    public void checkViewVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 4);
        }
    }

    private ArrayList<View> getNumViews(View v) {
        ArrayList<View> numSlice = new ArrayList<>();
        if (v != null) {
            for (int i = 0; i < this.idNumSlice.length; i++) {
                this.vTempNumSlice = v.findViewById(this.idNumSlice[i]);
                numSlice.add(this.vTempNumSlice);
            }
        }
        return numSlice;
    }

    
    public void setNumByCan(ArrayList<View> vs, int[] ints) {
        if (vs != null && vs.size() != 0 && ints != null) {
            int i = 0;
            Iterator<View> it = vs.iterator();
            while (it.hasNext()) {
                View v = it.next();
                if (v != null) {
                    try {
                        checkViewVisible(v, ints[i] == 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                i++;
            }
        }
    }

    protected void setSTCHByCan(int[] ints) {
        if (ints != null && ints.length == 4) {
            checkViewVisible(findViewById(R.id.id_led_st), ints[0] == 1);
            checkViewVisible(findViewById(R.id.id_led_st1), ints[1] == 1);
            checkViewVisible(findViewById(R.id.id_led_st2), ints[2] == 1);
            checkViewVisible(findViewById(R.id.id_led_ch), ints[3] == 1);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
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

    private void addNotify() {
        for (int i = 0; i < this.resid.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.resid[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeNotify() {
        for (int i = 0; i < this.resid.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.resid[i]].removeNotify(this.mNotifyCanbus);
        }
    }
}
