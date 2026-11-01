package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCJiliWindowSetActi extends BaseActivity {
    private IUiNotify notifyUI = new IUiNotify() { // from class: com.syu.carinfo.mzd.WCJiliWindowSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 159:
                    ((TextView) WCJiliWindowSetActi.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_jili_window_set);
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.WCJiliWindowSetActi.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(1, new int[]{21, 1, 255, 255}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(1, new int[]{21, 0, 255, 255}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.WCJiliWindowSetActi.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(1, new int[]{23, 1, 255, 255}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(1, new int[]{23, 0, 255, 255}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.WCJiliWindowSetActi.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(1, new int[]{20, 1, 255, 255}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.WCJiliWindowSetActi.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(1, new int[]{20, 0, 255, 255}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.WCJiliWindowSetActi.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    int value = DataCanbus.DATA[159];
                    if (value > 0) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, value, 255, 255}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.WCJiliWindowSetActi.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    int value = DataCanbus.DATA[159];
                    if (value < 100) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{22, value, 255, 255}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) WCJiliWindowSetActi.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyUI, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyUI);
    }
}
