package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODRuichiC9CarSet extends BaseActivity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODRuichiC9CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    switch (val) {
                        case 0:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus1)).setText("智慧标准");
                            break;
                        case 1:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus1)).setText("智慧节能");
                            break;
                        case 2:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus1)).setText("智慧动力");
                            break;
                    }
                    break;
                case 101:
                    switch (val) {
                        case 0:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus2)).setTextColor(-1);
                            break;
                        case 1:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus2)).setTextColor(-65536);
                            break;
                    }
                    break;
                case 102:
                    switch (val) {
                        case 0:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus3)).setTextColor(-1);
                            break;
                        case 1:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus3)).setTextColor(-65536);
                            break;
                    }
                    break;
                case 103:
                    switch (val) {
                        case 0:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus4)).setTextColor(-1);
                            break;
                        case 1:
                            ((TextView) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus4)).setTextColor(-65536);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_od_ruichi_c9_set);
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.sanlin.ODRuichiC9CarSet.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(2, new int[]{3, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(2, new int[]{3, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.sanlin.ODRuichiC9CarSet.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(2, new int[]{4, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.sanlin.ODRuichiC9CarSet.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(2, new int[]{5, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(2, new int[]{5, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.sanlin.ODRuichiC9CarSet.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) ODRuichiC9CarSet.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(2, new int[]{6, 0}, null, null);
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }
}
