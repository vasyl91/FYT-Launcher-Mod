package com.syu.carinfo.wc.jingyix5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JYIndexAct extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_jyx5_index);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.index_lock_set).setOnClickListener(this);
        findViewById(R.id.index_carlight_set).setOnClickListener(this);
        findViewById(R.id.index_maintenance_set).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        Class<?> cls = null;
        switch (id) {
            case R.id.index_lock_set /* 2131433080 */:
                cls = JYCarLockSet.class;
                break;
            case R.id.index_carlight_set /* 2131433081 */:
                cls = JYCarLightSet.class;
                break;
            case R.id.index_maintenance_set /* 2131433082 */:
                cls = JYCarMaintanece.class;
                break;
        }
        if (cls != null) {
            try {
                Intent intent = new Intent(this, cls);
                startActivity(intent);
                overridePendingTransition(0, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
