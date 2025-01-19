package com.syu.carinfo.rzc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_JeepCarAUXPowerSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 208:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext7), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text7)).setText("Battery");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext7), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text7)).setText("Ignition");
                        break;
                    }
                case 209:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext4), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text4)).setText("Battery");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext4), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text4)).setText("Ignition");
                        break;
                    }
                case 210:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext1), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text1)).setText("Battery");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext1), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text1)).setText("Ignition");
                        break;
                    }
                case 211:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext11), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text11)).setText("Momentary");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext11), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text11)).setText("Latching");
                        break;
                    }
                case 212:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext8), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text8)).setText("Momentary");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext8), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text8)).setText("Latching");
                        break;
                    }
                case 213:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext5), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text5)).setText("Momentary");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext5), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text5)).setText("Latching");
                        break;
                    }
                case 214:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext2), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text2)).setText("Momentary");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext2), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text2)).setText("Latching");
                        break;
                    }
                case 215:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext12), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text12)).setText("Yes");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext12), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text12)).setText("Not");
                        break;
                    }
                case 216:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext9), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text9)).setText("Yes");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext9), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text9)).setText("Not");
                        break;
                    }
                case 217:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext6), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text6)).setText("Yes");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext6), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text6)).setText("Not");
                        break;
                    }
                case 218:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext3), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text3)).setText("Yes");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext3), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text3)).setText("Not");
                        break;
                    }
                case 219:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext10), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text10)).setText("Battery");
                        break;
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext10), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text10)).setText("Ignition");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0373_rzc_jeep_auxpower_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[210] == 1) {
                    setCarInfo(193, 2);
                    break;
                } else {
                    setCarInfo(193, 3);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[214] == 1) {
                    setCarInfo(193, 0);
                    break;
                } else {
                    setCarInfo(193, 1);
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[218] == 1) {
                    setCarInfo(193, 5);
                    break;
                } else {
                    setCarInfo(193, 4);
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[209] == 1) {
                    setCarInfo(194, 2);
                    break;
                } else {
                    setCarInfo(194, 3);
                    break;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[213] == 1) {
                    setCarInfo(194, 0);
                    break;
                } else {
                    setCarInfo(194, 1);
                    break;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[217] == 1) {
                    setCarInfo(194, 5);
                    break;
                } else {
                    setCarInfo(194, 4);
                    break;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (DataCanbus.DATA[208] == 1) {
                    setCarInfo(195, 2);
                    break;
                } else {
                    setCarInfo(195, 3);
                    break;
                }
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                if (DataCanbus.DATA[212] == 1) {
                    setCarInfo(195, 0);
                    break;
                } else {
                    setCarInfo(195, 1);
                    break;
                }
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                if (DataCanbus.DATA[216] == 1) {
                    setCarInfo(195, 5);
                    break;
                } else {
                    setCarInfo(195, 4);
                    break;
                }
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                if (DataCanbus.DATA[219] == 1) {
                    setCarInfo(196, 2);
                    break;
                } else {
                    setCarInfo(196, 3);
                    break;
                }
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                if (DataCanbus.DATA[211] == 1) {
                    setCarInfo(196, 0);
                    break;
                } else {
                    setCarInfo(196, 1);
                    break;
                }
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                if (DataCanbus.DATA[215] == 1) {
                    setCarInfo(196, 5);
                    break;
                } else {
                    setCarInfo(196, 4);
                    break;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{97}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
    }
}
