package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BZ408OilMilePage1Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    BZ408OilMilePage1Acti.this.mUpdaterStartStopTime();
                    break;
                case 102:
                    BZ408OilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 103:
                    BZ408OilMilePage1Acti.this.mUpdaterDrivingMileage();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_biaozhi408_oil_page1);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.bz408_btn_oil_page1_btn).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(24, new int[]{1}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mUpdaterCanbusType();
        DataCanbus.PROXY.cmd(57, new int[]{1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.PROXY.cmd(57, new int[1], null, null);
    }

    private void mUpdaterCanbusType() {
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(49, new int[1], null, null);
            DataCanbus.PROXY.cmd(53, new int[]{51}, null, null);
            if (((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)) != null) {
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)).setText(R.string.start_stop_time);
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)).setVisibility(0);
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setVisibility(0);
                return;
            }
            return;
        }
        if (DataCanbus.DATA[1000] == 187 || DataCanbus.DATA[1000] == 123) {
            if (((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)) != null) {
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)).setText(R.string.setting_mileage);
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)).setVisibility(0);
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setVisibility(0);
                return;
            }
            return;
        }
        if (DataCanbus.DATA[1000] == 278) {
            DataCanbus.PROXY.cmd(49, new int[1], null, null);
            DataCanbus.PROXY.cmd(53, new int[]{51}, null, null);
            if (((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)) != null) {
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)).setVisibility(4);
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setVisibility(4);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)) != null) {
            ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3_text)).setVisibility(4);
            ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setVisibility(4);
        }
    }

    
    public void mUpdaterOilExpend() {
        String str;
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.bz408_tv_oil_page1_tv1)) != null) {
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 281) {
                if (DataCanbus.DATA[131] == 2) {
                    str = CamryData.OIL_EXPEND_UNIT_MPG;
                } else if (DataCanbus.DATA[131] != 0) {
                    str = "L/100KM-KM";
                } else {
                    str = "KM/L-KM";
                }
                if (value > -1 && value < 3001) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " " + str);
                    return;
                } else {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv1)).setText("--.--");
                    return;
                }
            }
            if (value == 65535) {
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv1)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv1)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " L/100KM");
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.bz408_tv_oil_page1_tv2)) != null) {
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 281) {
                if (value > -1 && value < 2001) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
                    return;
                } else {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv2)).setText("--.--");
                    return;
                }
            }
            if (value == 65535) {
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv2)).setText("--.--");
            } else {
                ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv2)).setText(String.valueOf(value) + " KM");
            }
        }
    }

    
    public void mUpdaterStartStopTime() {
        int value = DataCanbus.DATA[98];
        int hour = (16711680 & value) >> 16;
        int min = (65280 & value) >> 8;
        int second = value & 255;
        if (((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)) != null) {
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 278 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 281) {
                if (hour == 255 || min == 255 || second == 255) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setText("--:--:--");
                    return;
                } else {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setText(String.format("%02d:%02d:%02d", Integer.valueOf(hour), Integer.valueOf(min), Integer.valueOf(second)));
                    return;
                }
            }
            if (DataCanbus.DATA[1000] == 187 || DataCanbus.DATA[1000] == 123) {
                if (value > -1 && value < 6001) {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setText(String.valueOf(value) + " KM");
                    return;
                } else {
                    ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setText("--.--");
                    return;
                }
            }
            ((TextView) findViewById(R.id.bz408_tv_oil_page1_tv3)).setText("");
        }
    }
}
