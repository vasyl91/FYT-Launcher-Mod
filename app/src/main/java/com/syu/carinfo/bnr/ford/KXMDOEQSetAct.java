package com.syu.carinfo.bnr.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KXMDOEQSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value = DataCanbus.DATA[144];
                    if (value > 2) {
                        value--;
                    }
                    KXMDOEQSetAct.this.sendCMD(5, value);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value2 = DataCanbus.DATA[144];
                    if (value2 < 12) {
                        value2++;
                    }
                    KXMDOEQSetAct.this.sendCMD(5, value2);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int value3 = DataCanbus.DATA[143];
                    if (value3 > 2) {
                        value3--;
                    }
                    KXMDOEQSetAct.this.sendCMD(6, value3);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value4 = DataCanbus.DATA[143];
                    if (value4 < 12) {
                        value4++;
                    }
                    KXMDOEQSetAct.this.sendCMD(6, value4);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value5 = DataCanbus.DATA[142];
                    if (value5 > 2) {
                        value5--;
                    }
                    KXMDOEQSetAct.this.sendCMD(4, value5);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value6 = DataCanbus.DATA[142];
                    if (value6 < 12) {
                        value6++;
                    }
                    KXMDOEQSetAct.this.sendCMD(4, value6);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value7 = DataCanbus.DATA[140];
                    if (value7 > 0) {
                        value7--;
                    }
                    KXMDOEQSetAct.this.sendCMD(2, value7);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value8 = DataCanbus.DATA[140];
                    if (value8 < 14) {
                        value8++;
                    }
                    KXMDOEQSetAct.this.sendCMD(2, value8);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                    int value9 = DataCanbus.DATA[139];
                    if (value9 > 0) {
                        value9--;
                    }
                    KXMDOEQSetAct.this.sendCMD(1, value9);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    int value10 = DataCanbus.DATA[139];
                    if (value10 < 14) {
                        value10++;
                    }
                    KXMDOEQSetAct.this.sendCMD(1, value10);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                    int value11 = DataCanbus.DATA[145];
                    if (value11 > 0) {
                        value11--;
                    }
                    KXMDOEQSetAct.this.sendCMD(7, value11);
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    int value12 = DataCanbus.DATA[145];
                    if (value12 < 63) {
                        value12++;
                    }
                    KXMDOEQSetAct.this.sendCMD(7, value12);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 139:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (7 - value));
                        break;
                    }
                case 140:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (7 - value));
                        break;
                    }
                case 141:
                    if (((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 8);
                        break;
                    }
                case 142:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                        break;
                    }
                case 143:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (7 - value));
                        break;
                    }
                case 144:
                    if (value > 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 7));
                        break;
                    } else if (value == 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                        break;
                    } else if (value < 7) {
                        ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (7 - value));
                        break;
                    }
                case 145:
                    ((TextView) KXMDOEQSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 146:
                    if (((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) KXMDOEQSetAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0403_kx_mengdiou_eq_set);
        init();
    }

    @Override
    public void init() {
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus7));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[141];
                    if (value == 1) {
                        value = 8;
                    } else if (value == 8) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[146] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 9;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(2, iArr, null, null);
                }
            });
        }
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(2, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
    }
}
