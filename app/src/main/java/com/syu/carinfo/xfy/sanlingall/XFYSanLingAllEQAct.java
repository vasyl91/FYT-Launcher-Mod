package com.syu.carinfo.xfy.sanlingall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XFYSanLingAllEQAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 111:
                    XFYSanLingAllEQAct.this.updateCarEQFad();
                    break;
                case 112:
                    XFYSanLingAllEQAct.this.updateCarEQBal();
                    break;
                case 114:
                    XFYSanLingAllEQAct.this.updateCarEQBass();
                    break;
                case 115:
                    XFYSanLingAllEQAct.this.updateCarEQTre();
                    break;
                case 116:
                    XFYSanLingAllEQAct.this.updateCarEQMid();
                    break;
                case 117:
                    XFYSanLingAllEQAct.this.updateCarEQPunch();
                    break;
                case 118:
                    XFYSanLingAllEQAct.this.updateCarEQVol();
                    break;
                case 119:
                    XFYSanLingAllEQAct.this.updateCarEQSurround();
                    break;
                case 121:
                    XFYSanLingAllEQAct.this.updateCarEQPremidia();
                    break;
                case 122:
                    XFYSanLingAllEQAct.this.updateCarEQSCV();
                    break;
                case 123:
                    XFYSanLingAllEQAct.this.updateCarEQDolby();
                    break;
                case 124:
                    XFYSanLingAllEQAct.this.updateCarEQSpeedVol();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_xfy_sanling_eqsettings);
        setListener();
    }

    private void setListener() {
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[118];
                if (value > 0) {
                    value--;
                }
                setCarInfo(8, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[118];
                if (value2 < 45) {
                    value2++;
                }
                setCarInfo(8, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[112];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[112];
                if (value4 < 22) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[111];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[111];
                if (value6 < 22) {
                    value6++;
                }
                setCarInfo(1, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[114];
                if (value7 > 2) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[114];
                if (value8 < 12) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[116];
                if (value9 > 2) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[116];
                if (value10 < 12) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[115];
                if (value11 > 2) {
                    value11--;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[115];
                if (value12 < 12) {
                    value12++;
                }
                setCarInfo(5, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[117];
                if (value13 > 2) {
                    value13--;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[117];
                if (value14 < 8) {
                    value14++;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[119];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(10, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[119];
                if (value16 < 2) {
                    value16++;
                }
                setCarInfo(10, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[121];
                if (value17 > 0) {
                    value17--;
                }
                setCarInfo(12, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[121];
                if (value18 < 2) {
                    value18++;
                }
                setCarInfo(12, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[122];
                if (value19 > 0) {
                    value19--;
                }
                setCarInfo(13, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[122];
                if (value20 < 3) {
                    value20++;
                }
                setCarInfo(13, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[123];
                if (value21 > 0) {
                    value21--;
                }
                setCarInfo(14, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[123];
                if (value22 < 3) {
                    value22++;
                }
                setCarInfo(14, value22);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value23 = DataCanbus.DATA[124];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(9, value23);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarEQSCV() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText("Low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText("Middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text10)).setText("High");
                    break;
            }
        }
    }

    
    public void updateCarEQDolby() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text11)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text11)).setText("High");
                    break;
            }
        }
    }

    
    public void updateCarEQPremidia() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText("High");
                    break;
            }
        }
    }

    
    public void updateCarEQSurround() {
        int value = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("DTS Neural");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("PREMIDIA WIDE");
                    break;
            }
        }
    }

    
    public void updateCarEQPunch() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value >= 5) {
                ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value - 5).toString());
            } else if (value < 5) {
                ((TextView) findViewById(R.id.tv_text7)).setText("-" + (5 - value));
            }
        }
    }

    
    public void updateCarEQSpeedVol() {
        int value = DataCanbus.DATA[124];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
    }

    
    public void updateCarEQTre() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text6)).setText("-" + (7 - value));
            }
        }
    }

    
    public void updateCarEQMid() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText("-" + (7 - value));
            }
        }
    }

    
    public void updateCarEQBass() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value >= 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 7).toString());
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText("-" + (7 - value));
            }
        }
    }

    
    public void updateCarEQFad() {
        int value = DataCanbus.DATA[111];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value > 11) {
                ((TextView) findViewById(R.id.tv_text3)).setText("F" + (value - 11));
            } else if (value == 11) {
                ((TextView) findViewById(R.id.tv_text3)).setText("0");
            } else if (value < 11) {
                ((TextView) findViewById(R.id.tv_text3)).setText("R" + (11 - value));
            }
        }
    }

    
    public void updateCarEQBal() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value > 11) {
                ((TextView) findViewById(R.id.tv_text2)).setText("R" + (value - 11));
            } else if (value == 11) {
                ((TextView) findViewById(R.id.tv_text2)).setText("0");
            } else if (value < 11) {
                ((TextView) findViewById(R.id.tv_text2)).setText("L" + (11 - value));
            }
        }
    }

    
    public void updateCarEQVol() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
