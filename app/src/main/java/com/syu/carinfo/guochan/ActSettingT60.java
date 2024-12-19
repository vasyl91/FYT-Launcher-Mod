package com.syu.carinfo.guochan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActSettingT60 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActSettingT60.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 91:
                    ActSettingT60.this.setCheckView((CheckedTextView) ActSettingT60.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 92:
                    ActSettingT60.this.uSeekCar(value);
                    break;
                case 93:
                    ActSettingT60.this.uLightOn(value);
                    break;
                case 94:
                    ActSettingT60.this.setCheckView((CheckedTextView) ActSettingT60.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 95:
                    ActSettingT60.this.setCheckView((CheckedTextView) ActSettingT60.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 96:
                    ActSettingT60.this.uLockFeedBack(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0139_oudi_t60);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        Button btn = (Button) findViewById(R.id.btn_minus2);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[93] - 1;
                    if (val < 0) {
                        val = 2;
                    }
                    ActSettingT60.this.sendCmd(1, 2, val);
                }
            });
        }
        Button btn2 = (Button) findViewById(R.id.btn_plus2);
        if (btn2 != null) {
            btn2.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[93] + 1;
                    ActSettingT60.this.sendCmd(1, 2, val % 3);
                }
            });
        }
        Button btn3 = (Button) findViewById(R.id.btn_minus3);
        if (btn3 != null) {
            btn3.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[96] - 1;
                    if (val < 0) {
                        val = 2;
                    }
                    ActSettingT60.this.sendCmd(2, 3, val);
                }
            });
        }
        Button btn4 = (Button) findViewById(R.id.btn_plus3);
        if (btn4 != null) {
            btn4.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[96] + 1;
                    ActSettingT60.this.sendCmd(2, 3, val % 3);
                }
            });
        }
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 1, 1, 91);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 1, 3, 92);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 2, 1, 94);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 2, 2, 95);
        sendClick((CheckedTextView) findViewById(R.id.id_reset), 3, 0, 0);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
    }

    private void sendClick(View v, final int type, final int cmd, final int id) {
        if (v != null) {
            if (v == ((CheckedTextView) findViewById(R.id.id_reset))) {
                v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v2) {
                        ActSettingT60.this.dialog();
                    }
                });
            } else {
                v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v2) {
                        int value = DataCanbus.DATA[id];
                        ActSettingT60.this.sendCmd(type, cmd, value == 0 ? 1 : 0);
                    }
                });
            }
        }
    }

    protected void uLockFeedBack(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text6);
        if (txt != null) {
            int id = R.string.klc_remote_Remote_control_latch_light_Speaker;
            if (value == 1) {
                id = R.string.klc_remote_Remote_control_latch_only_light;
            } else if (value == 2) {
                id = R.string.klc_remote_Remote_control_latch_speaker;
            }
            txt.setText(id);
        }
    }

    protected void uLightOn(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text4);
        if (txt != null) {
            String str = "30s";
            if (value == 1) {
                str = "60s";
            } else if (value == 2) {
                str = "90s";
            }
            txt.setText(str);
        }
    }

    protected void uSeekCar(int value) {
        TextView txt = (TextView) findViewById(R.id.tv_text3);
        if (txt != null) {
            int id = R.string.klc_remote_Remote_control_latch_only_light;
            if (value == 1) {
                id = R.string.klc_remote_Remote_control_latch_light_Speaker;
            }
            txt.setText(id);
        }
        setCheckView((CheckedTextView) findViewById(R.id.ctv_checkedtext5), value == 1);
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(R.string.rzc_klc_default_set_str));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.guochan.ActSettingT60.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActSettingT60.this.sendCmd(3, 1, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.guochan.ActSettingT60.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                ActSettingT60.this.sendCmd(3, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int type, int cmd, int i) {
        DataCanbus.PROXY.cmd(3, new int[]{type, cmd, i}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
