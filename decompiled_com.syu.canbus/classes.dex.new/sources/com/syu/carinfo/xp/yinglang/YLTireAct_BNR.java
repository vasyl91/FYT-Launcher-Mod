package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLTireAct_BNR extends Activity {
    public static YLTireAct_BNR mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLTireAct_BNR.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 138:
                    YLTireAct_BNR.this.uTireFL(value);
                    break;
                case 139:
                    YLTireAct_BNR.this.uTireFR(value);
                    break;
                case 140:
                    YLTireAct_BNR.this.uTireRL(value);
                    break;
                case 141:
                    YLTireAct_BNR.this.uTireRR(value);
                    break;
                case 203:
                    YLTireAct_BNR.this.uTireExist(value);
                    break;
                case 204:
                    YLTireAct_BNR.this.uSpareTireExist(value);
                    break;
                case 205:
                    YLTireAct_BNR.this.uTireUnit(value);
                    break;
                case 206:
                    YLTireAct_BNR.this.uTireSpare(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_tire_bnr);
        init();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
    }

    private void init() {
        mInit = this;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    protected void uTireExist(int value) {
        if (findViewById(R.id.layout_view1) != null) {
            findViewById(R.id.layout_view1).setVisibility(value == 1 ? 0 : 8);
        }
    }

    protected void uTireSpare(int value) {
        TextView v = (TextView) findViewById(R.id.tv_text6);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireRR(int value) {
        TextView v = (TextView) findViewById(R.id.tv_text4);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireRL(int value) {
        TextView v = (TextView) findViewById(R.id.tv_text3);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireFR(int value) {
        TextView v = (TextView) findViewById(R.id.tv_text2);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireFL(int value) {
        TextView v = (TextView) findViewById(R.id.tv_text1);
        if (v != null) {
            String str = "----";
            if (value != 255) {
                str = new StringBuilder(String.valueOf(value)).toString();
            }
            v.setText(str);
        }
    }

    protected void uTireUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            String str = "Bar";
            if (value == 1) {
                str = "Psi";
            } else if (value == 2) {
                str = "Kpa";
            }
            ((TextView) findViewById(R.id.tv_text5)).setText(str);
        }
    }

    protected void uSpareTireExist(int value) {
        if (findViewById(R.id.layout_view2) != null) {
            findViewById(R.id.layout_view2).setVisibility(value == 1 ? 0 : 8);
        }
    }
}
