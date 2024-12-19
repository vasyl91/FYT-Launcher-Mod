package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcLandRoverCDAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_landrover_indexact);
        if (((Button) findViewById(R.id.btn_vol_add)) != null) {
            ((Button) findViewById(R.id.btn_vol_add)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcLandRoverCDAct.1
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_vol_sub)) != null) {
            ((Button) findViewById(R.id.btn_vol_sub)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcLandRoverCDAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
                }
            });
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
        FuncMain.setChannel(13);
    }
}
