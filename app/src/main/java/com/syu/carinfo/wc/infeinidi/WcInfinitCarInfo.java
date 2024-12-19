package com.syu.carinfo.wc.infeinidi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WcInfinitCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.infeinidi.WcInfinitCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                    WcInfinitCarInfo.this.mUpdateTx1(value);
                    break;
                case 25:
                    WcInfinitCarInfo.this.mUpdateTx2(value);
                    break;
                case 26:
                    WcInfinitCarInfo.this.mUpdateTx3(value);
                    break;
                case 27:
                    WcInfinitCarInfo.this.mUpdateTx4(value);
                    break;
                case 28:
                    WcInfinitCarInfo.this.mUpdateTx5(value);
                    break;
                case 29:
                    WcInfinitCarInfo.this.mUpdateTx6(value);
                    break;
                case 30:
                    WcInfinitCarInfo.this.mUpdateTx7(value);
                    break;
                case 31:
                    WcInfinitCarInfo.this.mUpdateTx8(value);
                    break;
                case 32:
                    WcInfinitCarInfo.this.mUpdateTx9(value);
                    break;
                case 33:
                    WcInfinitCarInfo.this.mUpdateTx10(value);
                    break;
                case 34:
                    WcInfinitCarInfo.this.mUpdateTx11(value);
                    break;
                case 35:
                    WcInfinitCarInfo.this.mUpdateTx12(value);
                    break;
                case 36:
                    WcInfinitCarInfo.this.mUpdateTx13(value);
                    break;
                case 37:
                    WcInfinitCarInfo.this.mUpdateTx14(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_infeinidi_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                showResetDlg();
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    protected void showResetDlg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.bmw_cleanoil)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.infeinidi.WcInfinitCarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.infeinidi.WcInfinitCarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 1, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.infeinidi.WcInfinitCarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{12, 0, 255, 255}, null, null);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx14(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text14)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx13(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text13)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx12(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text12)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx11(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text11)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx10(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text10)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx9(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text9)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx8(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text8)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx7(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text7)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx6(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text6)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx5(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text5)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx4(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx3(int value) {
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx2(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateTx1(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }
}
