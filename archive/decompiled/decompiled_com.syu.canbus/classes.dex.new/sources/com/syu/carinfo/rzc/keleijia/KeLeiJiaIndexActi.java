package com.syu.carinfo.rzc.keleijia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJiaIndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_keleijia_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 8978834 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 6554002) {
            findViewById(R.id.layout_view3).setVisibility(0);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 7209362 || DataCanbus.DATA[1000] == 7274898 || DataCanbus.DATA[1000] == 7340434 || DataCanbus.DATA[1000] == 7405970 || DataCanbus.DATA[1000] == 7471506 || DataCanbus.DATA[1000] == 7537042 || DataCanbus.DATA[1000] == 7995794 || DataCanbus.DATA[1000] == 8061330 || DataCanbus.DATA[1000] == 8126866) {
            findViewById(R.id.layout_view7).setVisibility(0);
        } else {
            findViewById(R.id.layout_view7).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndexActi.this, KeLeiJiaSetting.class);
                    KeLeiJiaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndexActi.this, KeLeiJiaHistroyAct.class);
                    KeLeiJiaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndexActi.this, KeLeiJiaEVHistroyAct.class);
                    KeLeiJiaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndexActi.this, KeLeiJiaIndex2.class);
                    KeLeiJiaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndexActi.this, Bnr17KeLeiJiaAnd17KeiLeiAoIndex.class);
                    KeLeiJiaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndexActi.this, KeLeiJiaCarTire.class);
                    KeLeiJiaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaIndexActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KeLeiJiaIndexActi.this, KeLeiJiaRadarSetting.class);
                    KeLeiJiaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
