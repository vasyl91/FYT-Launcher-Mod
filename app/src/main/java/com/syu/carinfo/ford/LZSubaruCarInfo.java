package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZSubaruCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    LZSubaruCarInfo.this.updateCarinfo1();
                    break;
                case 105:
                    LZSubaruCarInfo.this.updateCarinfo4();
                    break;
                case 106:
                    LZSubaruCarInfo.this.updateCarinfo6();
                    break;
                case 107:
                    LZSubaruCarInfo.this.updateCarinfo2();
                    break;
                case 108:
                    LZSubaruCarInfo.this.updateCarinfo5();
                    break;
                case 109:
                    LZSubaruCarInfo.this.updateCarinfo7();
                    break;
                case 110:
                    ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 137:
                    switch (value) {
                        case 0:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text8)).setText("km");
                            break;
                        case 1:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text8)).setText("mile");
                            break;
                    }
                    LZSubaruCarInfo.this.updateCarinfo2();
                    LZSubaruCarInfo.this.updateCarinfo5();
                    LZSubaruCarInfo.this.updateCarinfo7();
                    break;
                case 138:
                    switch (value) {
                        case 0:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text9)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                            break;
                        case 1:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text9)).setText("mpg");
                            break;
                        case 2:
                            ((TextView) LZSubaruCarInfo.this.findViewById(R.id.tv_text9)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                            break;
                    }
                    LZSubaruCarInfo.this.updateCarinfo1();
                    LZSubaruCarInfo.this.updateCarinfo4();
                    LZSubaruCarInfo.this.updateCarinfo6();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_subaru_carinfo);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{53}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[137] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[137] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[138] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[138] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo7() {
        int value = DataCanbus.DATA[109];
        int unit = DataCanbus.DATA[137];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    
    public void updateCarinfo6() {
        int value = DataCanbus.DATA[106];
        int unit = DataCanbus.DATA[138];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " km/L");
                break;
        }
    }

    
    public void updateCarinfo5() {
        int value = DataCanbus.DATA[108];
        int unit = DataCanbus.DATA[137];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[105];
        int unit = DataCanbus.DATA[138];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " km/L");
                break;
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[107];
        int unit = DataCanbus.DATA[137];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " miles");
                break;
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[104];
        int unit = DataCanbus.DATA[138];
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " L/100km");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " mpg");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " km/L");
                break;
        }
    }
}
