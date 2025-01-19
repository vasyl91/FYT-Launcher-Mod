package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class LZBBAFenweiLightAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 163:
                    LZBBAFenweiLightAct.this.setCheck((CheckedTextView) LZBBAFenweiLightAct.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 164:
                    ((TextView) LZBBAFenweiLightAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 165:
                    ((TextView) LZBBAFenweiLightAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 166:
                    ((TextView) LZBBAFenweiLightAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 167:
                    ((TextView) LZBBAFenweiLightAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_bba_fwlight_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int d0_b7 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b70 = DataCanbus.DATA[164];
                int d2_b70 = DataCanbus.DATA[165];
                int d3_b70 = DataCanbus.DATA[166];
                int d4_b70 = DataCanbus.DATA[167];
                int d1_b702 = d1_b70 - 5;
                if (d1_b702 < 0) {
                    d1_b702 = 0;
                }
                setCarInfo((d0_b7 << 7) & 128, d1_b702, d2_b70, d3_b70, d4_b70);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int d0_b72 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b703 = DataCanbus.DATA[164];
                int d2_b702 = DataCanbus.DATA[165];
                int d3_b702 = DataCanbus.DATA[166];
                int d4_b702 = DataCanbus.DATA[167];
                int d1_b704 = d1_b703 + 5;
                if (d1_b704 > 100) {
                    d1_b704 = 100;
                }
                setCarInfo((d0_b72 << 7) & 128, d1_b704, d2_b702, d3_b702, d4_b702);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int d0_b73 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b705 = DataCanbus.DATA[164];
                int d2_b703 = DataCanbus.DATA[165];
                int d3_b703 = DataCanbus.DATA[166];
                int d4_b703 = DataCanbus.DATA[167];
                int d2_b704 = d2_b703 - 10;
                if (d2_b704 < 0) {
                    d2_b704 = 0;
                }
                setCarInfo((d0_b73 << 7) & 128, d1_b705, d2_b704, d3_b703, d4_b703);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int d0_b74 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b706 = DataCanbus.DATA[164];
                int d2_b705 = DataCanbus.DATA[165];
                int d3_b704 = DataCanbus.DATA[166];
                int d4_b704 = DataCanbus.DATA[167];
                int d2_b706 = d2_b705 + 10;
                if (d2_b706 > 255) {
                    d2_b706 = 255;
                }
                setCarInfo((d0_b74 << 7) & 128, d1_b706, d2_b706, d3_b704, d4_b704);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int d0_b75 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b707 = DataCanbus.DATA[164];
                int d2_b707 = DataCanbus.DATA[165];
                int d3_b705 = DataCanbus.DATA[166];
                int d4_b705 = DataCanbus.DATA[167];
                int d3_b706 = d3_b705 - 10;
                if (d3_b706 < 0) {
                    d3_b706 = 0;
                }
                setCarInfo((d0_b75 << 7) & 128, d1_b707, d2_b707, d3_b706, d4_b705);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int d0_b76 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b708 = DataCanbus.DATA[164];
                int d2_b708 = DataCanbus.DATA[165];
                int d3_b707 = DataCanbus.DATA[166];
                int d4_b706 = DataCanbus.DATA[167];
                int d3_b708 = d3_b707 + 10;
                if (d3_b708 > 255) {
                    d3_b708 = 255;
                }
                setCarInfo((d0_b76 << 7) & 128, d1_b708, d2_b708, d3_b708, d4_b706);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int d0_b77 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b709 = DataCanbus.DATA[164];
                int d2_b709 = DataCanbus.DATA[165];
                int d3_b709 = DataCanbus.DATA[166];
                int d4_b707 = DataCanbus.DATA[167] - 10;
                if (d4_b707 < 0) {
                    d4_b707 = 0;
                }
                setCarInfo((d0_b77 << 7) & 128, d1_b709, d2_b709, d3_b709, d4_b707);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int d0_b78 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b7010 = DataCanbus.DATA[164];
                int d2_b7010 = DataCanbus.DATA[165];
                int d3_b7010 = DataCanbus.DATA[166];
                int d4_b708 = DataCanbus.DATA[167] + 10;
                if (d4_b708 > 255) {
                    d4_b708 = 255;
                }
                setCarInfo((d0_b78 << 7) & 128, d1_b7010, d2_b7010, d3_b7010, d4_b708);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int d0_b79 = (DataCanbus.DATA[163] >> 7) & 1;
                int d1_b7011 = DataCanbus.DATA[164];
                int d2_b7011 = DataCanbus.DATA[165];
                int d3_b7011 = DataCanbus.DATA[166];
                int d4_b709 = DataCanbus.DATA[167];
                if (d0_b79 == 1) {
                    d0_b79 = 0;
                } else if (d0_b79 == 0) {
                    d0_b79 = 1;
                }
                setCarInfo((d0_b79 << 7) & 128, d1_b7011, d2_b7011, d3_b7011, d4_b709);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(7, new int[]{value1, value2, value3, value4, value5}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
    }
}
