package com.syu.carinfo.wc.jingyix5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class JYCarMaintanece extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_wc_jyx5_maintain);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.jy_maintain_1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.jy_maintain_2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.jy_maintain_3)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        Intent ii = new Intent(this, (Class<?>) JYCarMaintaneceOptions.class);
        switch (id) {
            case R.id.jy_maintain_1 /* 2131432055 */:
                ii.putExtra("ID", "Maintenance");
                break;
            case R.id.jy_maintain_2 /* 2131432056 */:
                ii.putExtra("ID", "tire");
                break;
            case R.id.jy_maintain_3 /* 2131432057 */:
                ii.putExtra("ID", "oil");
                break;
        }
        try {
            startActivity(ii);
            overridePendingTransition(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
