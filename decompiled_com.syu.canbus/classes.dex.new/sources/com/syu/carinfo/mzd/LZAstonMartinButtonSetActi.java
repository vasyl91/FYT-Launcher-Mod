package com.syu.carinfo.mzd;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZAstonMartinButtonSetActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_astonmartin_button);
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.LZAstonMartinButtonSetActi.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{12, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(0, new int[]{12, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.LZAstonMartinButtonSetActi.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{12, 3}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(0, new int[]{12, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.LZAstonMartinButtonSetActi.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{12, 4}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(0, new int[]{12, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.LZAstonMartinButtonSetActi.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{12, 2}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) LZAstonMartinButtonSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(0, new int[]{12, 0}, null, null);
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
