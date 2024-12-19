package com.syu.carinfo.bg.fiat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.carinfo.xp.ziyouguang.Activity_374_FactorySetActivity;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityFiatIndex extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_index_xp_fiat);
        ((Button) findViewById(R.id.btn_usb_control)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.fiat.ActivityFiatIndex.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityFiatIndex.this.startActivity(new Intent(ActivityFiatIndex.this, (Class<?>) ActivityFiatCarUSB.class));
            }
        });
        ((Button) findViewById(R.id.btn_base_info)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.fiat.ActivityFiatIndex.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityFiatIndex.this.startActivity(new Intent(ActivityFiatIndex.this, (Class<?>) Activity_374_FactorySetActivity.class));
            }
        });
    }
}
