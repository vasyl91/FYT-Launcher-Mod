package com.syu.carinfo.hc.ruijie;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XCFordRuijieEQAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    XCFordRuijieEQAct.this.updateTempUnit();
                    break;
                case 103:
                    XCFordRuijieEQAct.this.updateCarEQVol();
                    break;
                case 104:
                    XCFordRuijieEQAct.this.updateCarEQBal();
                    break;
                case 105:
                    XCFordRuijieEQAct.this.updateCarEQFad();
                    break;
                case 106:
                    XCFordRuijieEQAct.this.updateCarEQBass();
                    break;
                case 107:
                    XCFordRuijieEQAct.this.updateCarEQMid();
                    break;
                case 108:
                    XCFordRuijieEQAct.this.updateCarEQTre();
                    break;
                case 109:
                    XCFordRuijieEQAct.this.updateCarEQSpeedVol();
                    break;
                case 111:
                    if (XCFordRuijieEQAct.this.findViewById(R.id.tv_text1) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_ice_blue);
                                break;
                            case 2:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_7);
                                break;
                            case 3:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_darkskyblue_str);
                                break;
                            case 4:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_red_str);
                                break;
                            case 5:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_background_green);
                                break;
                            case 6:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                                break;
                            case 7:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.color_pueple_str);
                                break;
                            default:
                                ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 112:
                    if (XCFordRuijieEQAct.this.findViewById(R.id.tv_text2) != null) {
                        ((TextView) XCFordRuijieEQAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value));
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_hc_ruijie_eqsettings);
        setListener();
    }

    private void setListener() {
        if (DataCanbus.DATA[1000] != 6881719) {
            setViewVisible(findViewById(R.id.layout_view1), false);
            setViewVisible(findViewById(R.id.layout_view2), false);
            setViewVisible(findViewById(R.id.layout_view4), false);
            setViewVisible(findViewById(R.id.layout_view5), false);
            setViewVisible(findViewById(R.id.layout_view6), false);
            setViewVisible(findViewById(R.id.layout_view7), false);
            setViewVisible(findViewById(R.id.layout_view8), false);
            setViewVisible(findViewById(R.id.layout_view9), false);
            setViewVisible(findViewById(R.id.layout_view10), false);
        }
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus6), this);
        setSelfClick(findViewById(R.id.btn_plus6), this);
        setSelfClick(findViewById(R.id.btn_minus7), this);
        setSelfClick(findViewById(R.id.btn_plus7), this);
        setSelfClick(findViewById(R.id.btn_minus8), this);
        setSelfClick(findViewById(R.id.btn_plus8), this);
        setSelfClick(findViewById(R.id.btn_minus9), this);
        setSelfClick(findViewById(R.id.btn_plus9), this);
        setSelfClick(findViewById(R.id.btn_minus10), this);
        setSelfClick(findViewById(R.id.btn_plus10), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int color = DataCanbus.DATA[111];
                int lev = DataCanbus.DATA[112];
                if (color > 0) {
                    color--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color, lev}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int color2 = DataCanbus.DATA[111];
                int lev2 = DataCanbus.DATA[112];
                if (color2 < 7) {
                    color2++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color2, lev2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int color3 = DataCanbus.DATA[111];
                int lev3 = DataCanbus.DATA[112];
                if (lev3 > 0) {
                    lev3--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color3, lev3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int color4 = DataCanbus.DATA[111];
                int lev4 = DataCanbus.DATA[112];
                if (lev4 < 15) {
                    lev4++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{color4, lev4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value = DataCanbus.DATA[99];
                if (value < 1) {
                    value++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value2 = DataCanbus.DATA[99];
                if (value2 > 0) {
                    value2--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value2}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value3 = DataCanbus.DATA[109];
                if (value3 > 0) {
                    value3--;
                }
                setCarEQ(6, value3);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value4 = DataCanbus.DATA[109];
                if (value4 < 7) {
                    value4++;
                }
                setCarEQ(6, value4);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value5 = DataCanbus.DATA[104];
                if (value5 > 0) {
                    value5--;
                }
                setCarEQ(1, value5);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value6 = DataCanbus.DATA[104];
                if (value6 < 14) {
                    value6++;
                }
                setCarEQ(1, value6);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value7 = DataCanbus.DATA[105];
                if (value7 > 0) {
                    value7--;
                }
                setCarEQ(2, value7);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value8 = DataCanbus.DATA[105];
                if (value8 < 14) {
                    value8++;
                }
                setCarEQ(2, value8);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value9 = DataCanbus.DATA[106];
                if (value9 > 0) {
                    value9--;
                }
                setCarEQ(3, value9);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value10 = DataCanbus.DATA[106];
                if (value10 < 14) {
                    value10++;
                }
                setCarEQ(3, value10);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value11 = DataCanbus.DATA[107];
                if (value11 > 0) {
                    value11--;
                }
                setCarEQ(4, value11);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value12 = DataCanbus.DATA[107];
                if (value12 < 14) {
                    value12++;
                }
                setCarEQ(4, value12);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value13 = DataCanbus.DATA[108];
                if (value13 > 0) {
                    value13--;
                }
                setCarEQ(5, value13);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value14 = DataCanbus.DATA[108];
                if (value14 < 14) {
                    value14++;
                }
                setCarEQ(5, value14);
                break;
        }
    }

    public void setCarEQ(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateTempUnit() {
        int value = DataCanbus.DATA[99];
        if (findViewById(R.id.tv_text3) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("℉");
                    break;
            }
        }
    }

    
    public void updateCarEQSpeedVol() {
        int value = DataCanbus.DATA[109];
        if (findViewById(R.id.tv_text4) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value));
        }
    }

    
    public void updateCarEQTre() {
        int value = DataCanbus.DATA[108];
        if (findViewById(R.id.tv_text10) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value - 7));
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text10)).setText("-" + (7 - value));
            }
        }
    }

    
    public void updateCarEQMid() {
        int value = DataCanbus.DATA[107];
        if (findViewById(R.id.tv_text9) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(value - 7));
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text9)).setText("-" + (7 - value));
            }
        }
    }

    
    public void updateCarEQBass() {
        int value = DataCanbus.DATA[106];
        if (findViewById(R.id.tv_text8) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value - 7));
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text8)).setText("-" + (7 - value));
            }
        }
    }

    
    public void updateCarEQFad() {
        int value = DataCanbus.DATA[105];
        if (findViewById(R.id.tv_text7) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text7)).setText("F" + (value - 7));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text7)).setText("0");
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text7)).setText("R" + (7 - value));
            }
        }
    }

    
    public void updateCarEQBal() {
        int value = DataCanbus.DATA[104];
        if (findViewById(R.id.tv_text6) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("R" + (value - 7));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("0");
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("L" + (7 - value));
            }
        }
    }

    
    public void updateCarEQVol() {
        int value = DataCanbus.DATA[103];
        if (findViewById(R.id.tv_text5) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value));
        }
    }
}
