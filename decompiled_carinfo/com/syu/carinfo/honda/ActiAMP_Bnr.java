package com.syu.carinfo.honda;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

@SuppressWarnings({"deprecation", "unchecked"})
public class ActiAMP_Bnr extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value = DataCanbus.DATA[183];
                    if (value > 0) {
                        value--;
                    }
                    ActiAMP_Bnr.this.sendCMD(9, value);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value2 = DataCanbus.DATA[183];
                    if (value2 < 40) {
                        value2++;
                    }
                    ActiAMP_Bnr.this.sendCMD(9, value2);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    int value3 = DataCanbus.DATA[184];
                    if (value3 > 0) {
                        value3--;
                    }
                    ActiAMP_Bnr.this.sendCMD(1, value3);
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    int value4 = DataCanbus.DATA[184];
                    if (value4 < 18) {
                        value4++;
                    }
                    ActiAMP_Bnr.this.sendCMD(1, value4);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    int value5 = DataCanbus.DATA[185];
                    if (value5 > 0) {
                        value5--;
                    }
                    ActiAMP_Bnr.this.sendCMD(2, value5);
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    int value6 = DataCanbus.DATA[185];
                    if (value6 < 18) {
                        value6++;
                    }
                    ActiAMP_Bnr.this.sendCMD(2, value6);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value7 = DataCanbus.DATA[186];
                    if (value7 > 0) {
                        value7--;
                    }
                    ActiAMP_Bnr.this.sendCMD(3, value7);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value8 = DataCanbus.DATA[186];
                    if (value8 < 12) {
                        value8++;
                    }
                    ActiAMP_Bnr.this.sendCMD(3, value8);
                    break;
                case R.id.btn_minus5 /* 2131427467 */:
                    int value9 = DataCanbus.DATA[187];
                    if (value9 > 0) {
                        value9--;
                    }
                    ActiAMP_Bnr.this.sendCMD(4, value9);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    int value10 = DataCanbus.DATA[187];
                    if (value10 < 12) {
                        value10++;
                    }
                    ActiAMP_Bnr.this.sendCMD(4, value10);
                    break;
                case R.id.btn_minus6 /* 2131427470 */:
                    int value11 = DataCanbus.DATA[188];
                    if (value11 > 0) {
                        value11--;
                    }
                    ActiAMP_Bnr.this.sendCMD(5, value11);
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    int value12 = DataCanbus.DATA[188];
                    if (value12 < 12) {
                        value12++;
                    }
                    ActiAMP_Bnr.this.sendCMD(5, value12);
                    break;
                case R.id.btn_minus7 /* 2131427473 */:
                    int value13 = DataCanbus.DATA[189];
                    if (value13 > 0) {
                        value13--;
                    }
                    ActiAMP_Bnr.this.sendCMD(6, value13);
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    int value14 = DataCanbus.DATA[189];
                    if (value14 < 12) {
                        value14++;
                    }
                    ActiAMP_Bnr.this.sendCMD(6, value14);
                    break;
                case R.id.btn_minus8 /* 2131427476 */:
                    int value15 = DataCanbus.DATA[190];
                    if (value15 > 0) {
                        value15--;
                    }
                    ActiAMP_Bnr.this.sendCMD(7, value15);
                    break;
                case R.id.btn_plus8 /* 2131427478 */:
                    int value16 = DataCanbus.DATA[190];
                    if (value16 < 3) {
                        value16++;
                    }
                    ActiAMP_Bnr.this.sendCMD(7, value16);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    ActiAMP_Bnr.this.dialog(R.string.str_guandao_amp, 10);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 183:
                    ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 184:
                    if (value > 9) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text2)).setText("R" + (value - 9));
                        break;
                    } else if (value == 9) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text2)).setText("0");
                        break;
                    } else if (value < 9) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text2)).setText("F" + (9 - value));
                        break;
                    }
                case 185:
                    if (value > 9) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text3)).setText("R" + (value - 9));
                        break;
                    } else if (value == 9) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text3)).setText("0");
                        break;
                    } else if (value < 9) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text3)).setText("L" + (9 - value));
                        break;
                    }
                case 186:
                    if (value > 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text4)).setText("+" + (value - 6));
                        break;
                    } else if (value == 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text4)).setText("0");
                        break;
                    } else if (value < 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text4)).setText("-" + (6 - value));
                        break;
                    }
                case 187:
                    if (value > 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text5)).setText("+" + (value - 6));
                        break;
                    } else if (value == 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text5)).setText("0");
                        break;
                    } else if (value < 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text5)).setText("-" + (6 - value));
                        break;
                    }
                case 188:
                    if (value > 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text6)).setText("+" + (value - 6));
                        break;
                    } else if (value == 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text6)).setText("0");
                        break;
                    } else if (value < 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text6)).setText("-" + (6 - value));
                        break;
                    }
                case 189:
                    if (value > 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text7)).setText("+" + (value - 6));
                        break;
                    } else if (value == 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text7)).setText("0");
                        break;
                    } else if (value < 6) {
                        ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text7)).setText("-" + (6 - value));
                        break;
                    }
                case 190:
                    switch (value) {
                        case 0:
                            ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) ActiAMP_Bnr.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                            break;
                    }
                case 191:
                    if (((CheckedTextView) ActiAMP_Bnr.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActiAMP_Bnr.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_298_bnr_guandao);
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
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus8));
        setonClick((Button) findViewById(R.id.btn_minus8));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[191] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 8;
                    iArr[1] = value != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(108, iArr, null, null);
                }
            });
        }
    }

    
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(108, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(108, new int[]{i}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
    }
}
