package com.syu.carinfo.xp.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Activity_287LzIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0287_lzjeep_indexact);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_287LzIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Activity_287LzIndexAct.this, Activity_287_Engine_Shotdown.class);
                    Activity_287LzIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_287LzIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Activity_287LzIndexAct.this, Activity_287LzPennelSetActi.class);
                    Activity_287LzIndexAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
