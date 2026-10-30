package com.syu.carinfo.jili;

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
public class ODZhonghuaHUDSetActi extends BaseActivity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODZhonghuaHUDSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    if (value > 4) {
                        ((TextView) ODZhonghuaHUDSetActi.this.findViewById(R.id.tv_text1)).setText("HUD亮度: +" + (value - 4));
                    } else if (value < 4) {
                        ((TextView) ODZhonghuaHUDSetActi.this.findViewById(R.id.tv_text1)).setText("HUD亮度: -" + (4 - value));
                    } else {
                        ((TextView) ODZhonghuaHUDSetActi.this.findViewById(R.id.tv_text1)).setText("HUD亮度: 0 ");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_od_zhonghua_hudsettings);
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.jili.ODZhonghuaHUDSetActi.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    int value = DataCanbus.DATA[116] - 1;
                    if (value < 0) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{23, value}, null, null);
                    return true;
                }
                if (action == 1) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.jili.ODZhonghuaHUDSetActi.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    int value = DataCanbus.DATA[116] + 1;
                    if (value > 8) {
                        value = 8;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{23, value}, null, null);
                    return true;
                }
                if (action == 1) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.jili.ODZhonghuaHUDSetActi.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{24, 0}, null, null);
                    return true;
                }
                if (action == 1) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                }
                return false;
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.jili.ODZhonghuaHUDSetActi.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                    DataCanbus.PROXY.cmd(0, new int[]{24, 1}, null, null);
                    return true;
                }
                if (action == 1) {
                    ((Button) ODZhonghuaHUDSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }
}
