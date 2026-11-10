package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class ODDatongDana26V1CarInfo extends BaseActivity implements View.OnTouchListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0265_od_datong_dana26v1_carinfo);
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.zhongtai.ODDatongDana26V1CarInfo.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (DataCanbus.DATA[1000] == 1900809) {
                    if (action == 0) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                        DataCanbus.PROXY.cmd(8, new int[]{1, 1}, null, null);
                        return true;
                    }
                    if (action == 1) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                        DataCanbus.PROXY.cmd(8, new int[]{1, 0}, null, null);
                        return false;
                    }
                } else {
                    if (action == 0) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                        DataCanbus.PROXY.cmd(3, new int[]{32, 1}, null, null);
                        return true;
                    }
                    if (action == 1) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                        DataCanbus.PROXY.cmd(3, new int[]{32, 0}, null, null);
                        return false;
                    }
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.zhongtai.ODDatongDana26V1CarInfo.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (DataCanbus.DATA[1000] == 1900809) {
                    if (action == 0) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                        DataCanbus.PROXY.cmd(8, new int[]{2, 1}, null, null);
                        return true;
                    }
                    if (action == 1) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                        DataCanbus.PROXY.cmd(8, new int[]{2, 0}, null, null);
                        return false;
                    }
                } else {
                    if (action == 0) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                        DataCanbus.PROXY.cmd(3, new int[]{33, 1}, null, null);
                        return true;
                    }
                    if (action == 1) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                        DataCanbus.PROXY.cmd(3, new int[]{33, 0}, null, null);
                        return false;
                    }
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.rzc.zhongtai.ODDatongDana26V1CarInfo.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (DataCanbus.DATA[1000] == 1900809) {
                    if (action == 0) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                        DataCanbus.PROXY.cmd(8, new int[]{3, 1}, null, null);
                        return true;
                    }
                    if (action == 1) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                        DataCanbus.PROXY.cmd(8, new int[]{3, 0}, null, null);
                        return false;
                    }
                } else {
                    if (action == 0) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                        DataCanbus.PROXY.cmd(3, new int[]{34, 1}, null, null);
                        return true;
                    }
                    if (action == 1) {
                        ((Button) ODDatongDana26V1CarInfo.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                        DataCanbus.PROXY.cmd(3, new int[]{34, 0}, null, null);
                        return false;
                    }
                }
                return false;
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
