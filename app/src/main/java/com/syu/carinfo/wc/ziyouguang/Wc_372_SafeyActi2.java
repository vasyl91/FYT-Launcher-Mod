package com.syu.carinfo.wc.ziyouguang;

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

public class Wc_372_SafeyActi2 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 165:
                    Wc_372_SafeyActi2.this.mTx1();
                    break;
                case 166:
                    Wc_372_SafeyActi2.this.mTx2();
                    break;
                case 167:
                    Wc_372_SafeyActi2.this.mTx3();
                    break;
                case 168:
                    Wc_372_SafeyActi2.this.mTx4();
                    break;
                case 169:
                    Wc_372_SafeyActi2.this.mCtv1();
                    break;
                case 170:
                    Wc_372_SafeyActi2.this.mCtv2();
                    break;
                case 171:
                    Wc_372_SafeyActi2.this.mCtv3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_zyg_safetyassist2);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[165] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[165] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[166] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[166] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[167] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[167] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[168] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{22, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[168] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{22, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[169] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 23;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[170] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 24;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[171] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 25;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
    }

    protected void mCtv3() {
        int temp = DataCanbus.DATA[171] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view7).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    protected void mCtv2() {
        int temp = DataCanbus.DATA[170] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view6).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
    }

    protected void mCtv1() {
        int temp = DataCanbus.DATA[169] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view5).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    
    public void mTx4() {
        int temp = DataCanbus.DATA[168] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view4).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText("low");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText("mid");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText("high");
            }
        }
    }

    
    public void mTx3() {
        int temp = DataCanbus.DATA[167] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view3).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText("Off");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText("sound");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText("sound + display");
            }
        }
    }

    
    public void mTx2() {
        int temp = DataCanbus.DATA[166] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view2).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText("near");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText("mid");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText("far");
            }
        }
    }

    
    public void mTx1() {
        int temp = DataCanbus.DATA[165] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.layout_view1).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText("Only active braking");
            } else if (value == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText("Off");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText("warn+active braking");
            }
        }
    }
}
