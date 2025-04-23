package com.syu.carinfo.bnr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Acti_Nissan_Bnr extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    Acti_Nissan_Bnr.this.sendCMD(33, 49);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    Acti_Nissan_Bnr.this.sendCMD(33, 33);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    Acti_Nissan_Bnr.this.sendCMD(35, 49);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    Acti_Nissan_Bnr.this.sendCMD(35, 33);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    Acti_Nissan_Bnr.this.sendCMD(34, 49);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    Acti_Nissan_Bnr.this.sendCMD(34, 33);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    Acti_Nissan_Bnr.this.sendCMD(36, 49);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    Acti_Nissan_Bnr.this.sendCMD(36, 33);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                    Acti_Nissan_Bnr.this.sendCMD(37, 49);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    Acti_Nissan_Bnr.this.sendCMD(37, 33);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                    Acti_Nissan_Bnr.this.sendCMD(38, 49);
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    Acti_Nissan_Bnr.this.sendCMD(38, 33);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                    Acti_Nissan_Bnr.this.sendCMD(40, 49);
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    Acti_Nissan_Bnr.this.sendCMD(40, 33);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    Acti_Nissan_Bnr.this.sendCMD(41, DataCanbus.DATA[108] == 0 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    Acti_Nissan_Bnr.this.sendCMD(39, DataCanbus.DATA[106] == 0 ? 1 : 0);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    DataCanbus.PROXY.cmd(3, new int[]{33}, null, null);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    DataCanbus.PROXY.cmd(3, new int[]{34}, null, null);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427547 */:
                    DataCanbus.PROXY.cmd(3, new int[]{35}, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    Acti_Nissan_Bnr.this.uCarSound(val);
                    break;
                case 101:
                    Acti_Nissan_Bnr.this.uCarSoundL(val);
                    break;
                case 102:
                    Acti_Nissan_Bnr.this.uCarSoundH(val);
                    break;
                case 103:
                    Acti_Nissan_Bnr.this.uCarFieldLR(val);
                    break;
                case 104:
                    Acti_Nissan_Bnr.this.uCarFieldFB(val);
                    break;
                case 105:
                    Acti_Nissan_Bnr.this.uCarSpeedLink(val);
                    break;
                case 106:
                    Acti_Nissan_Bnr.this.uCarBose(val);
                    break;
                case 107:
                    Acti_Nissan_Bnr.this.uCarRoundVol(val);
                    break;
                case 108:
                    Acti_Nissan_Bnr.this.uCarFieldDriver(val);
                    break;
                case 109:
                    Acti_Nissan_Bnr.this.setCheck((CheckedTextView) Acti_Nissan_Bnr.this.findViewById(R.id.ctv_checkedtext3), false);
                    Acti_Nissan_Bnr.this.setCheck((CheckedTextView) Acti_Nissan_Bnr.this.findViewById(R.id.ctv_checkedtext4), false);
                    Acti_Nissan_Bnr.this.setCheck((CheckedTextView) Acti_Nissan_Bnr.this.findViewById(R.id.ctv_checkedtext5), false);
                    switch (val) {
                        case 1:
                            Acti_Nissan_Bnr.this.setCheck((CheckedTextView) Acti_Nissan_Bnr.this.findViewById(R.id.ctv_checkedtext3), true);
                            break;
                        case 2:
                            Acti_Nissan_Bnr.this.setCheck((CheckedTextView) Acti_Nissan_Bnr.this.findViewById(R.id.ctv_checkedtext4), true);
                            break;
                        case 3:
                            Acti_Nissan_Bnr.this.setCheck((CheckedTextView) Acti_Nissan_Bnr.this.findViewById(R.id.ctv_checkedtext5), true);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_324_bnr_nissan);
        init();
    }

    @Override
    public void init() {
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5));
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }

    protected void uCarSoundL(int val) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSound(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSoundH(int val) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarRoundVol(int val) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSpeedLink(int val) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldLR(int val) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldFB(int val) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarBose(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
        }
    }

    protected void uCarFieldDriver(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
        }
    }
}
