package com.syu.carinfo.wc.feiyate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCFeiyateIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_feiyatei_indexact);
        if (DataCanbus.DATA[1000] != 8126907) {
            findViewById(R.id.rzc_jianghuai_car_tire_view).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 8126907 || DataCanbus.DATA[1000] == 8257979 || DataCanbus.DATA[1000] == 8192443 || DataCanbus.DATA[1000] == 8323515 || DataCanbus.DATA[1000] == 8389051 || DataCanbus.DATA[1000] == 14090683 || DataCanbus.DATA[1000] == 11600316 || DataCanbus.DATA[1000] == 11665852 || DataCanbus.DATA[1000] == 11731388 || DataCanbus.DATA[1000] == 11796924 || DataCanbus.DATA[1000] == 11862460 || DataCanbus.DATA[1000] == 11927996 || DataCanbus.DATA[1000] == 6685116 || DataCanbus.DATA[1000] == 6750652 || DataCanbus.DATA[1000] == 6816188 || DataCanbus.DATA[1000] == 6881724 || DataCanbus.DATA[1000] == 8454587 || DataCanbus.DATA[1000] == 8520123 || DataCanbus.DATA[1000] == 8520123 || DataCanbus.DATA[1000] == 3735995 || DataCanbus.DATA[1000] == 3932603 || DataCanbus.DATA[1000] == 3998139 || DataCanbus.DATA[1000] == 7864763 || DataCanbus.DATA[1000] == 12124603 || DataCanbus.DATA[1000] == 12190139 || DataCanbus.DATA[1000] == 12255675 || DataCanbus.DATA[1000] == 12321211 || DataCanbus.DATA[1000] == 12386747 || DataCanbus.DATA[1000] == 10420668 || DataCanbus.DATA[1000] == 11403708 || DataCanbus.DATA[1000] == 10486204 || DataCanbus.DATA[1000] == 11469244 || DataCanbus.DATA[1000] == 10551740 || DataCanbus.DATA[1000] == 11534780 || DataCanbus.DATA[1000] == 4653500 || DataCanbus.DATA[1000] == 4719036 || DataCanbus.DATA[1000] == 4784572 || DataCanbus.DATA[1000] == 4850108 || DataCanbus.DATA[1000] == 4915644 || DataCanbus.DATA[1000] == 4981180 || DataCanbus.DATA[1000] == 5046716 || DataCanbus.DATA[1000] == 5112252 || DataCanbus.DATA[1000] == 5177788 || DataCanbus.DATA[1000] == 5243324 || DataCanbus.DATA[1000] == 5308860 || DataCanbus.DATA[1000] == 5374396 || DataCanbus.DATA[1000] == 10224060 || DataCanbus.DATA[1000] == 10617276 || DataCanbus.DATA[1000] == 10813884 || DataCanbus.DATA[1000] == 11010492 || DataCanbus.DATA[1000] == 11207100 || DataCanbus.DATA[1000] == 10289596 || DataCanbus.DATA[1000] == 10682812 || DataCanbus.DATA[1000] == 10879420 || DataCanbus.DATA[1000] == 11076028 || DataCanbus.DATA[1000] == 11272636 || DataCanbus.DATA[1000] == 10355132 || DataCanbus.DATA[1000] == 10748348 || DataCanbus.DATA[1000] == 10944956 || DataCanbus.DATA[1000] == 11141564 || DataCanbus.DATA[1000] == 11338172) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        ((Button) findViewById(R.id.rzc_jianghuai_car_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, WCFeiyateSetFunc.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, WCFeiyateSetFunc2.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_carinfo)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, FYTOilMileIndexActi.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.rzc_jianghuai_car_tire)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(WCFeiyateIndexAct.this, WCFeiyateTireAct.class);
                    WCFeiyateIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
