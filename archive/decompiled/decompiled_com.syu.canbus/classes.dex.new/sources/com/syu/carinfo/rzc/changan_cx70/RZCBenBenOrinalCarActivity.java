package com.syu.carinfo.rzc.changan_cx70;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCBenBenOrinalCarActivity extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_changan_benben_button);
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RZCBenBenOrinalCarActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(7, new int[]{1, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(7, new int[]{1, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RZCBenBenOrinalCarActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(7, new int[]{2, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(7, new int[]{2, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RZCBenBenOrinalCarActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(7, new int[]{3, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(7, new int[]{3, 0}, null, null);
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.changan_cx70.RZCBenBenOrinalCarActivity.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(7, new int[]{4, 1}, null, null);
                    return true;
                }
                if (action != 1) {
                    return false;
                }
                ((Button) RZCBenBenOrinalCarActivity.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                DataCanbus.PROXY.cmd(7, new int[]{4, 0}, null, null);
                return false;
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
