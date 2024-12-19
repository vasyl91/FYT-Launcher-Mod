package com.syu.carinfo.accord9.xp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.honda.HondaIndexActi;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XPAccord9IndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_xp_index);
        ((Button) findViewById(R.id.xp_accord9_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9IndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XPAccord9IndexActi.this, HondaIndexActi.class);
                    XPAccord9IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9IndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XPAccord9IndexActi.this, XPAccord9SettingsActi.class);
                    XPAccord9IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_screen)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9IndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XPAccord9IndexActi.this, XPAccord9ScreenActi.class);
                    XPAccord9IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
