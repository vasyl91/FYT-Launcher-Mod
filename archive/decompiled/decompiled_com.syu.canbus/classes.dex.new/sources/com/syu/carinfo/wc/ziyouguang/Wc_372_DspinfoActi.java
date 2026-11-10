package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_DspinfoActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 132:
                    Wc_372_DspinfoActi.this.ma6d61();
                    break;
                case 133:
                    Wc_372_DspinfoActi.this.ma6d60();
                    break;
                case 190:
                    if (((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 191:
                    if (((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text4)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text4)).setText("-" + (256 - value));
                        } else if ((value & 128) == 0 && value != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text4)).setText("+" + value);
                        } else {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 192:
                    if (((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text5)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text5)).setText("-" + (256 - value));
                        } else if ((value & 128) == 0 && value != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text5)).setText("+" + value);
                        } else {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 193:
                    if (((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text6)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text6)).setText("-" + (256 - value));
                        } else if ((value & 128) == 0 && value != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text6)).setText("+" + value);
                        } else {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text6)).setText("0");
                        }
                    }
                    break;
                case 194:
                    if (((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text7)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text7)).setText("-" + (256 - value));
                        } else if ((value & 128) == 0 && value != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text7)).setText("+" + value);
                        } else {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
                case 195:
                    if (((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text8)) != null) {
                        if ((value & 128) != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text8)).setText("-" + (256 - value));
                        } else if ((value & 128) == 0 && value != 0) {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text8)).setText("+" + value);
                        } else {
                            ((TextView) Wc_372_DspinfoActi.this.findViewById(R.id.tv_text8)).setText("0");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_dspinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[132] & 255;
                if (value2 <= 0) {
                    value = 3;
                } else {
                    value = value2 - 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[132] & 255;
                if (value2 >= 3) {
                    value = 0;
                } else {
                    value = value2 + 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[133] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[133] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[190] & 255;
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[190] & 255;
                if (value < 38) {
                    value++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[191];
                if (value > -9) {
                    value--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[191];
                if (value < 9) {
                    value++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[192];
                if (value > -9) {
                    value--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[192];
                if (value < 9) {
                    value++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[193];
                if (value > -9) {
                    value--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[193];
                if (value < 9) {
                    value++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[194];
                if (value > -9) {
                    value--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[194];
                if (value < 9) {
                    value++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[195];
                if (value > -9) {
                    value--;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_DspinfoActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[195];
                if (value < 9) {
                    value++;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma6d61() {
        int temp = DataCanbus.DATA[132] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr0);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr1);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr2);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma6d60() {
        int temp = DataCanbus.DATA[133] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_372_volumestr0);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_372_surroundstr0);
            }
        }
    }
}
