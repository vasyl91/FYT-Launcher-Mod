package com.syu.carinfo.xbs.accord9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.honda.HondaIndexActi;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBSAccord9IndexActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_xp_index);
        ((Button) findViewById(R.id.xp_accord9_btn_trip)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9IndexActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBSAccord9IndexActi.this, HondaIndexActi.class);
                    XBSAccord9IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9IndexActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBSAccord9IndexActi.this, XBSAccord9SettingsActi.class);
                    XBSAccord9IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_screen)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9IndexActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XBSAccord9IndexActi.this, XBSAccord9ScreenActi.class);
                    XBSAccord9IndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
