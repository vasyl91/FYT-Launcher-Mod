package com.syu.carinfo.hc.tianlai;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityFx35CarSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    ActivityFx35CarSettings.this.updateText1(val);
                    break;
                case 109:
                    ActivityFx35CarSettings.this.setCheck(ActivityFx35CarSettings.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 110:
                    ActivityFx35CarSettings.this.setCheck(ActivityFx35CarSettings.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 111:
                    ActivityFx35CarSettings.this.updateText2(val);
                    break;
                case 112:
                    ActivityFx35CarSettings.this.updateText3(val);
                    break;
                case 113:
                    ActivityFx35CarSettings.this.setCheck(ActivityFx35CarSettings.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 114:
                    ActivityFx35CarSettings.this.setCheck(ActivityFx35CarSettings.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 115:
                    ActivityFx35CarSettings.this.setCheck(ActivityFx35CarSettings.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 116:
                    ActivityFx35CarSettings.this.updateText4(val);
                    break;
                case 117:
                    ActivityFx35CarSettings.this.updateText5(val);
                    break;
                case 118:
                    ActivityFx35CarSettings.this.setCheck(ActivityFx35CarSettings.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0327_hc_yingfeinidi_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.btn_minus4), this);
        setSelfClick(findViewById(R.id.btn_plus4), this);
        setSelfClick(findViewById(R.id.btn_minus5), this);
        setSelfClick(findViewById(R.id.btn_plus5), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[108] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[108] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[111] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(21, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[111] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(21, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[112] - 1;
                if (value5 < 0) {
                    value5 = 7;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[112] + 1;
                if (value6 > 7) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[116] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(19, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[116] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(19, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[117] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(20, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[117] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(20, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value11 = DataCanbus.DATA[109];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(5, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value12 = DataCanbus.DATA[110];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(6, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value13 = DataCanbus.DATA[113];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(16, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value14 = DataCanbus.DATA[114];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(17, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value15 = DataCanbus.DATA[115];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(18, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value16 = DataCanbus.DATA[118];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(22, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                dialog(R.string.all_settings, 8);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
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
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText5(int value) {
        if (findViewById(R.id.tv_text5) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("1 min");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("5 min");
                    break;
            }
        }
    }

    
    public void updateText4(int value) {
        if (findViewById(R.id.tv_text4) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Unlock");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Lock");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Lock and Unlock");
                    break;
            }
        }
    }

    
    public void updateText3(int value) {
        if (findViewById(R.id.tv_text3) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText("45s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText("60s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text3)).setText("90s");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text3)).setText("120s");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text3)).setText("150s");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text3)).setText("180s");
                    break;
            }
        }
    }

    
    public void updateText2(int value) {
        if (findViewById(R.id.tv_text2) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Beeper");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Horn Chirp");
                    break;
            }
        }
    }

    
    public void updateText1(int value) {
        if (findViewById(R.id.tv_text1) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value));
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_reset) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
