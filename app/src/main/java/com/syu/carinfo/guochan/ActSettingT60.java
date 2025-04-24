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

@SuppressWarnings({"deprecation", "unchecked"})
public class ActSettingT60 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    ActSettingT60.this.setCheckView((CheckedTextView) ActSettingT60.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 104:
                    ActSettingT60.this.uSeekCar(value);
                    break;
                case 105:
                    ActSettingT60.this.uLightOn(value);
                    break;
                case 106:
                    ActSettingT60.this.setCheckView((CheckedTextView) ActSettingT60.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 107:
                    ActSettingT60.this.setCheckView((CheckedTextView) ActSettingT60.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 108:
                    ActSettingT60.this.uLockFeedBack(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0139_oudi_t60);
        init();
    }

    @Override
    public void init() {
        Button btn = (Button) findViewById(R.id.btn_minus2);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[105] - 1;
                    if (val < 0) {
                        val = 2;
                    }
                    ActSettingT60.this.sendCmd(1, 2, val);
                }
            });
        }
        Button btn2 = (Button) findViewById(R.id.btn_plus2);
        if (btn2 != null) {
            btn2.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[105] + 1;
                    ActSettingT60.this.sendCmd(1, 2, val % 3);
                }
            });
        }
        Button btn3 = (Button) findViewById(R.id.btn_minus3);
        if (btn3 != null) {
            btn3.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[108] - 1;
                    if (val < 0) {
                        val = 2;
                    }
                    ActSettingT60.this.sendCmd(2, 3, val);
                }
            });
        }
        Button btn4 = (Button) findViewById(R.id.btn_plus3);
        if (btn4 != null) {
            btn4.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int val = DataCanbus.DATA[108] + 1;
                    ActSettingT60.this.sendCmd(2, 3, val % 3);
                }
            });
        }
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 1, 1, 103);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 1, 3, 104);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 2, 1, 106);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 2, 2, 107);
        sendClick((CheckedTextView) findViewById(R.id.id_reset), 3, 0, 0);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    private void sendClick(View v, final int type, final int cmd, final int id) {
        if (v != null) {
            if (v == ((CheckedTextView) findViewById(R.id.id_reset))) {
                v.setOnClickListener(new View.OnClickListener() { 
                    @Override
                    public void onClick(View v2) {
                        ActSettingT60.this.dialog();
                    }
                });
            } else {
                v.setOnClickListener(new View.OnClickListener() { 
                    @Override
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
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        ActSettingT60.this.sendCmd(3, 1, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActSettingT60.this.sendCmd(3, 0, 0);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    
    public void sendCmd(int type, int cmd, int i) {
        DataCanbus.PROXY.cmd(3, new int[]{type, cmd, i}, null, null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
