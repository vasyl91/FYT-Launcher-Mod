package com.syu.carinfo.xc.lexus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XCLexusAudio extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                            break;
                        } else if (value < 7) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)).setText("+" + (value - 5));
                            break;
                        } else if (value < 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)).setText("-" + (5 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)).setText("+" + (value - 5));
                            break;
                        } else if (value < 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)).setText("-" + (5 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)).setText("+" + (value - 5));
                            break;
                        } else if (value < 5) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)).setText("-" + (5 - value));
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 111:
                    XCLexusAudio.this.setCheck((CheckedTextView) XCLexusAudio.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 112:
                case 113:
                    if (((TextView) XCLexusAudio.this.findViewById(R.id.tv_text1)) != null) {
                        if (DataCanbus.DATA[112] == 1) {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text1)).setText("0");
                            break;
                        } else {
                            ((TextView) XCLexusAudio.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(DataCanbus.DATA[113]).toString());
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
        //setContentView(R.layout.layout_0452_xincheng_lexus_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setDCarInfo(1, 49);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setDCarInfo(1, 33);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setDCarInfo(2, 49);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setDCarInfo(2, 33);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setDCarInfo(6, 49);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setDCarInfo(6, 33);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setDCarInfo(3, 49);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setDCarInfo(3, 33);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setDCarInfo(4, 49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setDCarInfo(4, 33);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setDCarInfo(5, 49);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setDCarInfo(5, 33);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[111];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setDCarInfo(7, value);
                break;
        }
    }

    void setDCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }
}
