package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class UIWC07AoDeSai {
    private static UIWC07AoDeSai mInstance;
    ArrayList<View> bignum1;
    ArrayList<View> bignum2;
    ArrayList<View> bignum3;
    ArrayList<View> bignum4;
    ArrayList<View> bignum5;
    Context context;
    ArrayList<View> num1;
    ArrayList<View> num2;
    ArrayList<View> num3;
    ArrayList<View> num4;
    ArrayList<View> num5;
    private View sWarnContent;
    private View vasel;
    private View vbignum1;
    private View vbignum2;
    private View vbignum3;
    private View vbignum4;
    private View vbignum5;
    private View vch;
    private View vcomment1;
    private View vcomment2;
    private View vcomment3;
    private View vd_1;
    private View vd_2;
    private View vdd;
    private View vdisc;
    private View vdot;
    private View vindex1;
    private View vindex2;
    private View vindex3;
    private View vindex4;
    private View vindex5;
    private View vindex6;
    private View vnum1;
    private View vnum2;
    private View vnum3;
    private View vnum4;
    private View vnum5;
    private View vrdm;
    private View vrpt;
    private View vscan;
    private View vsignle;
    private View vst;
    private View vst1;
    private View vst2;
    private View vtrack;
    int[] idNumSlice = {R.id.iv_num_a, R.id.iv_num_b, R.id.iv_num_c, R.id.iv_num_d, R.id.iv_num_e, R.id.iv_num_f, R.id.iv_num_g, R.id.iv_num_h, R.id.iv_num_i, R.id.iv_num_j, R.id.iv_num_k, R.id.iv_num_l, R.id.iv_num_m, R.id.iv_num_n, R.id.iv_num_o, R.id.iv_num_p, R.id.iv_num_q, R.id.iv_num_r, R.id.iv_num_s};
    View vTempNumSlice = null;

    public static UIWC07AoDeSai getInstance() {
        if (mInstance == null) {
            mInstance = new UIWC07AoDeSai();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value, int[] ints) {
        WarnUtils.getWindow();
        initTip(updateCode, value, ints);
        if (this.sWarnContent != null) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void checkViewVisible(View v, boolean on) {
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

    private void setNumByCan(ArrayList<View> vs, int[] ints) {
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
            checkViewVisible(this.vst, ints[0] == 1);
            checkViewVisible(this.vst1, ints[1] == 1);
            checkViewVisible(this.vst2, ints[2] == 1);
            checkViewVisible(this.vch, ints[3] == 1);
        }
    }

    private void initTip(int updateCode, int value, int[] ints) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_166_led_screen, (ViewGroup) null, false);
            this.vdd = this.sWarnContent.findViewById(R.id.id_led_dd);
            this.vd_1 = this.sWarnContent.findViewById(R.id.id_led_d_1);
            this.vd_2 = this.sWarnContent.findViewById(R.id.id_led_d_2);
            this.vscan = this.sWarnContent.findViewById(R.id.id_led_scan);
            this.vrdm = this.sWarnContent.findViewById(R.id.id_led_rdm);
            this.vrpt = this.sWarnContent.findViewById(R.id.id_led_rpt);
            this.vsignle = this.sWarnContent.findViewById(R.id.id_led_wave);
            this.vdisc = this.sWarnContent.findViewById(R.id.id_led_disc);
            this.vasel = this.sWarnContent.findViewById(R.id.id_led_asel);
            this.vtrack = this.sWarnContent.findViewById(R.id.id_led_track);
            this.vindex1 = this.sWarnContent.findViewById(R.id.id_led_index_1);
            this.vindex2 = this.sWarnContent.findViewById(R.id.id_led_index_2);
            this.vindex3 = this.sWarnContent.findViewById(R.id.id_led_index_3);
            this.vindex4 = this.sWarnContent.findViewById(R.id.id_led_index_4);
            this.vindex5 = this.sWarnContent.findViewById(R.id.id_led_index_5);
            this.vindex6 = this.sWarnContent.findViewById(R.id.id_led_index_6);
            this.vst = this.sWarnContent.findViewById(R.id.id_led_st);
            this.vst1 = this.sWarnContent.findViewById(R.id.id_led_st1);
            this.vst2 = this.sWarnContent.findViewById(R.id.id_led_st2);
            this.vch = this.sWarnContent.findViewById(R.id.id_led_ch);
            this.vnum1 = this.sWarnContent.findViewById(R.id.id_led_num_1);
            this.vnum2 = this.sWarnContent.findViewById(R.id.id_led_num_2);
            this.vnum3 = this.sWarnContent.findViewById(R.id.id_led_num_3);
            this.vnum4 = this.sWarnContent.findViewById(R.id.id_led_num_4);
            this.vnum5 = this.sWarnContent.findViewById(R.id.id_led_num_5);
            this.vbignum1 = this.sWarnContent.findViewById(R.id.id_led_big_num1);
            this.vbignum2 = this.sWarnContent.findViewById(R.id.id_led_big_num2);
            this.vbignum3 = this.sWarnContent.findViewById(R.id.id_led_big_num3);
            this.vbignum4 = this.sWarnContent.findViewById(R.id.id_led_big_num4);
            this.vbignum5 = this.sWarnContent.findViewById(R.id.id_led_big_num5);
            this.vdot = this.sWarnContent.findViewById(R.id.id_led_big_dot);
            this.vcomment1 = this.sWarnContent.findViewById(R.id.id_led_comment1);
            this.vcomment2 = this.sWarnContent.findViewById(R.id.id_led_comment2);
            this.vcomment3 = this.sWarnContent.findViewById(R.id.id_led_comment3);
            this.num1 = getNumViews(this.vnum1);
            this.num2 = getNumViews(this.vnum2);
            this.num3 = getNumViews(this.vnum3);
            this.num4 = getNumViews(this.vnum4);
            this.num5 = getNumViews(this.vnum5);
            this.bignum1 = getNumViews(this.vbignum1);
            this.bignum2 = getNumViews(this.vbignum2);
            this.bignum3 = getNumViews(this.vbignum3);
            this.bignum4 = getNumViews(this.vbignum4);
            this.bignum5 = getNumViews(this.vbignum5);
        }
        switch (updateCode) {
            case 47:
                checkViewVisible(this.vdd, value == 1);
                break;
            case 48:
                checkViewVisible(this.vd_1, value == 1);
                break;
            case 49:
                checkViewVisible(this.vscan, value == 1);
                break;
            case 50:
                checkViewVisible(this.vrdm, value == 1);
                break;
            case 51:
                checkViewVisible(this.vd_2, value == 1);
                break;
            case 52:
                checkViewVisible(this.vrpt, value == 1);
                break;
            case 53:
                checkViewVisible(this.vsignle, value == 1);
                break;
            case 54:
                checkViewVisible(this.vdisc, value == 1);
                break;
            case 55:
                checkViewVisible(this.vasel, value == 1);
                break;
            case 56:
                checkViewVisible(this.vtrack, value == 1);
                break;
            case 57:
                checkViewVisible(this.vindex1, value == 1);
                break;
            case 58:
                checkViewVisible(this.vindex2, value == 1);
                break;
            case 59:
                checkViewVisible(this.vindex3, value == 1);
                break;
            case 60:
                checkViewVisible(this.vindex4, value == 1);
                break;
            case 61:
                checkViewVisible(this.vindex5, value == 1);
                break;
            case 62:
                checkViewVisible(this.vindex6, value == 1);
                break;
            case 63:
                checkViewVisible(this.vcomment1, value == 1);
                checkViewVisible(this.vcomment3, value == 1);
                break;
            case 64:
                checkViewVisible(this.vdot, value == 1);
                break;
            case 65:
                if (ints != null) {
                    setNumByCan(this.num1, ints);
                    break;
                }
            case 66:
                if (ints != null) {
                    setNumByCan(this.num2, ints);
                    break;
                }
            case 67:
                if (ints != null) {
                    setNumByCan(this.num3, ints);
                    break;
                }
            case 68:
                if (ints != null) {
                    setNumByCan(this.num4, ints);
                    break;
                }
            case 69:
                if (ints != null) {
                    setNumByCan(this.num5, ints);
                    break;
                }
            case 70:
                if (ints != null) {
                    setSTCHByCan(ints);
                    break;
                }
            case 71:
                if (ints != null) {
                    setNumByCan(this.bignum1, ints);
                    break;
                }
            case 72:
                if (ints != null) {
                    setNumByCan(this.bignum2, ints);
                    break;
                }
            case 73:
                if (ints != null) {
                    setNumByCan(this.bignum3, ints);
                    break;
                }
            case 74:
                if (ints != null) {
                    setNumByCan(this.bignum4, ints);
                    break;
                }
            case 75:
                if (ints != null) {
                    setNumByCan(this.bignum5, ints);
                    break;
                }
            case 76:
                checkViewVisible(this.vcomment2, value == 1);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
