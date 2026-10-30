package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZCFordCarAirUpdataSet extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_airupdate);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.RZCFordCarAirUpdataSet.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(25, new int[]{255, 0, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.ford.RZCFordCarAirUpdataSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(25, new int[]{255, 1, 0}, null, null);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }
}
