package com.syu.carinfo.daojun.tianlai;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class djTianlaiAudio extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiAudio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    djTianlaiAudio.this.updateText4(value);
                    break;
                case 113:
                    djTianlaiAudio.this.updateText5(value);
                    break;
                case 114:
                    djTianlaiAudio.this.updateText2(value);
                    break;
                case 115:
                    djTianlaiAudio.this.updateText3(value);
                    break;
                case 117:
                    djTianlaiAudio.this.updateText1(value);
                    break;
                case 120:
                    if (((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L");
                    }
                    break;
                case 121:
                    if (((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    }
                    break;
                case 122:
                    if (((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    }
                    break;
                case 123:
                    if (((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) djTianlaiAudio.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + " km");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_daojun_tianlai_audio_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        v.getId();
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{49}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText("+" + (value - 7));
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText("-" + (7 - value));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text5)).setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText("+" + (value - 7));
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText("-" + (7 - value));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text4)).setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text3)).setText("F" + (value - 7));
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text3)).setText("R" + (7 - value));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text3)).setText("0");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value > 7) {
                ((TextView) findViewById(R.id.tv_text2)).setText("R" + (value - 7));
            } else if (value < 7) {
                ((TextView) findViewById(R.id.tv_text2)).setText("L" + (7 - value));
            } else if (value == 7) {
                ((TextView) findViewById(R.id.tv_text2)).setText("0");
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiAudio.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiAudio.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.daojun.tianlai.djTianlaiAudio.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
