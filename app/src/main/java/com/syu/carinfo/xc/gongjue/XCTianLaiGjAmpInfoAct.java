package com.syu.carinfo.xc.gongjue;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XCTianLaiGjAmpInfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 111:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text2)).setText("L" + Math.abs(val - 256));
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text2)).setText(val == 0 ? new StringBuilder().append(val).toString() : "R" + val);
                            break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text3)).setText("R" + Math.abs(val - 256));
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text3)).setText(val == 0 ? new StringBuilder().append(val).toString() : "F" + val);
                            break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val - 256).toString());
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                            break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val - 256).toString());
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                            break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val - 256).toString());
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_tianlai_gj_amp_info);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override
    public void onClick(View v) {
        int data = 0;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                data = 2;
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                data = 1;
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                data = 6;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data = 7;
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                data = 10;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data = 9;
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                data = 4;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                data = 3;
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                data = 12;
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                data = 11;
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                data = 6;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                data = 5;
                break;
        }
        cmd(data);
    }

    private void cmd(int data0) {
        DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }
}
