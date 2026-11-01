package com.syu.carinfo.dj.huangguan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityOldFx35CarSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.ActivityOldFx35CarSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 170:
                    ActivityOldFx35CarSettings.this.updateText1(val);
                    break;
                case 171:
                    ActivityOldFx35CarSettings.this.setCheck((CheckedTextView) ActivityOldFx35CarSettings.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 172:
                    ActivityOldFx35CarSettings.this.setCheck((CheckedTextView) ActivityOldFx35CarSettings.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 173:
                    ActivityOldFx35CarSettings.this.updateText2(val);
                    break;
                case 174:
                    ActivityOldFx35CarSettings.this.updateText3(val);
                    break;
                case 175:
                    ActivityOldFx35CarSettings.this.setCheck((CheckedTextView) ActivityOldFx35CarSettings.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 176:
                    ActivityOldFx35CarSettings.this.setCheck((CheckedTextView) ActivityOldFx35CarSettings.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 177:
                    ActivityOldFx35CarSettings.this.setCheck((CheckedTextView) ActivityOldFx35CarSettings.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 178:
                    ActivityOldFx35CarSettings.this.updateText4(val);
                    break;
                case 179:
                    ActivityOldFx35CarSettings.this.updateText5(val);
                    break;
                case 180:
                    ActivityOldFx35CarSettings.this.setCheck((CheckedTextView) ActivityOldFx35CarSettings.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0327_hc_yingfeinidi_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[170] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[170] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[173] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(21, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[173] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(21, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[174] - 1;
                if (value5 < 0) {
                    value5 = 7;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[174] + 1;
                if (value6 > 7) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[178] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(19, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[178] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(19, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[179] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(20, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[179] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(20, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value11 = DataCanbus.DATA[171];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(5, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value12 = DataCanbus.DATA[176];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(17, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value13 = DataCanbus.DATA[177];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(18, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value14 = DataCanbus.DATA[172];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(6, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value15 = DataCanbus.DATA[175];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(16, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value16 = DataCanbus.DATA[180];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(22, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                dialog(R.string.all_settings, 8);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(7, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.ActivityOldFx35CarSettings.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.dj.huangguan.ActivityOldFx35CarSettings.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.ActivityOldFx35CarSettings.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
