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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
    private int[] resid = {47, 48, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76};
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Act_LEDScreen_AoDeSai_wc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 47:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_dd), value == 1);
                    break;
                case 48:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_d_1), value == 1);
                    break;
                case 49:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_scan), value == 1);
                    break;
                case 50:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_rdm), value == 1);
                    break;
                case 51:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_d_2), value == 1);
                    break;
                case 52:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_rpt), value == 1);
                    break;
                case 53:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_wave), value == 1);
                    break;
                case 54:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_disc), value == 1);
                    break;
                case 55:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_asel), value == 1);
                    break;
                case 56:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_track), value == 1);
                    break;
                case 57:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_1), value == 1);
                    break;
                case 58:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_2), value == 1);
                    break;
                case 59:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_3), value == 1);
                    break;
                case 60:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_4), value == 1);
                    break;
                case 61:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_5), value == 1);
                    break;
                case 62:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_index_6), value == 1);
                    break;
                case 63:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_comment1), value == 1);
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_comment3), value == 1);
                    break;
                case 64:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_big_dot), value == 1);
                    break;
                case 65:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num1, ints);
                        break;
                    }
                case 66:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num2, ints);
                        break;
                    }
                case 67:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num3, ints);
                        break;
                    }
                case 68:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num4, ints);
                        break;
                    }
                case 69:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.num5, ints);
                        break;
                    }
                case 70:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setSTCHByCan(ints);
                        break;
                    }
                case 71:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum1, ints);
                        break;
                    }
                case 72:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum2, ints);
                        break;
                    }
                case 73:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum3, ints);
                        break;
                    }
                case 74:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum4, ints);
                        break;
                    }
                case 75:
                    if (ints != null) {
                        Act_LEDScreen_AoDeSai_wc.this.setNumByCan(Act_LEDScreen_AoDeSai_wc.this.bignum5, ints);
                        break;
                    }
                case 76:
                    Act_LEDScreen_AoDeSai_wc.this.checkViewVisible(Act_LEDScreen_AoDeSai_wc.this.findViewById(R.id.id_led_comment2), value == 1);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_166_led_screen);
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // android.app.Activity
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
