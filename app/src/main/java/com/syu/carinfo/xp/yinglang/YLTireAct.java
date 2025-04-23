package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class YLTireAct extends Activity {
    public static YLTireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 138:
                case 172:
                    YLTireAct.this.mUpdaterTireFL();
                    break;
                case 139:
                case 173:
                    YLTireAct.this.mUpdaterTireFR();
                    break;
                case 140:
                case 174:
                    YLTireAct.this.mUpdaterTireRL();
                    break;
                case 141:
                case 175:
                    YLTireAct.this.mUpdaterTireRR();
                    break;
                case 142:
                case 143:
                case 144:
                case 176:
                case 177:
                case 178:
                    YLTireAct.this.updaterFlHighWalm();
                    break;
                case 145:
                case 146:
                case 147:
                case 179:
                case 180:
                case 181:
                    YLTireAct.this.updaterFRHighWalm();
                    break;
                case 148:
                case 149:
                case 150:
                case 182:
                case 183:
                case 184:
                    YLTireAct.this.updaterRLHighWalm();
                    break;
                case 151:
                case 152:
                case 153:
                case 185:
                case 186:
                case 187:
                    YLTireAct.this.updaterRRHighWalm();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_tire);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
        DataCanbus.PROXY.cmd(8, new int[]{74}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        if (Return_Wc_Canbus()) {
            DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        if (Return_Wc_Canbus()) {
            DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }

    private void init() {
        mInit = this;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    
    public void mUpdaterTireFL() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[172];
        } else {
            value = DataCanbus.DATA[138];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_0)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    
    public void updaterFlHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[176];
            value2 = DataCanbus.DATA[177];
            value3 = DataCanbus.DATA[178];
        } else {
            value1 = DataCanbus.DATA[142];
            value2 = DataCanbus.DATA[143];
            value3 = DataCanbus.DATA[144];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    
    public void mUpdaterTireFR() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[173];
        } else {
            value = DataCanbus.DATA[139];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_1)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    
    public void updaterFRHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[179];
            value2 = DataCanbus.DATA[180];
            value3 = DataCanbus.DATA[181];
        } else {
            value1 = DataCanbus.DATA[145];
            value2 = DataCanbus.DATA[146];
            value3 = DataCanbus.DATA[147];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    
    public void mUpdaterTireRL() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[174];
        } else {
            value = DataCanbus.DATA[140];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_2)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    
    public void updaterRLHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[182];
            value2 = DataCanbus.DATA[183];
            value3 = DataCanbus.DATA[184];
        } else {
            value1 = DataCanbus.DATA[148];
            value2 = DataCanbus.DATA[149];
            value3 = DataCanbus.DATA[150];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    
    public void mUpdaterTireRR() {
        int value;
        if (Return_Wc_Canbus()) {
            value = DataCanbus.DATA[175];
        } else {
            value = DataCanbus.DATA[141];
        }
        if (((TextView) findViewById(R.id.xp_yl_tv_car_tire_3)) != null) {
            if (DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087) {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3)).setText(String.valueOf(value) + "Kpa");
            } else {
                ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    
    public void updaterRRHighWalm() {
        int value1;
        int value2;
        int value3;
        if (Return_Wc_Canbus()) {
            value1 = DataCanbus.DATA[185];
            value2 = DataCanbus.DATA[186];
            value3 = DataCanbus.DATA[187];
        } else {
            value1 = DataCanbus.DATA[151];
            value2 = DataCanbus.DATA[152];
            value3 = DataCanbus.DATA[153];
        }
        if (value1 == 0 && value2 == 0 && value3 == 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(8);
            return;
        }
        if (value1 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value2 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str02);
        } else if (value3 == 1) {
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setVisibility(0);
            ((TextView) findViewById(R.id.xp_yl_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str03);
        }
    }

    private boolean Return_Wc_Canbus() {
        return (DataCanbus.DATA[1000] & 65535) == 36 || DataCanbus.DATA[1000] == 655396 || DataCanbus.DATA[1000] == 524324 || DataCanbus.DATA[1000] == 308 || DataCanbus.DATA[1000] == 254 || DataCanbus.DATA[1000] == 357 || DataCanbus.DATA[1000] == 345 || DataCanbus.DATA[1000] == 459097 || DataCanbus.DATA[1000] == 65881 || DataCanbus.DATA[1000] == 131417 || DataCanbus.DATA[1000] == 524633 || DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 262489 || DataCanbus.DATA[1000] == 393252 || DataCanbus.DATA[1000] == 458788;
    }
}
