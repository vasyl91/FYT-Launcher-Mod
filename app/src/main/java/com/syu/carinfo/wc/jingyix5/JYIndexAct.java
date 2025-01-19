package com.syu.carinfo.wc.jingyix5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class JYIndexAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_jyx5_index);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.index_lock_set).setOnClickListener(this);
        findViewById(R.id.index_carlight_set).setOnClickListener(this);
        findViewById(R.id.index_maintenance_set).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Class<?> cls = null;
        switch (id) {
            case R.id.index_lock_set /* 2131432979 */:
                cls = JYCarLockSet.class;
                break;
            case R.id.index_carlight_set /* 2131432980 */:
                cls = JYCarLightSet.class;
                break;
            case R.id.index_maintenance_set /* 2131432981 */:
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
