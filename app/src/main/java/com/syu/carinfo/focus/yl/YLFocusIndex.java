package com.syu.carinfo.focus.yl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.carinfo.focus.FocusSyncBtActi;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLFocusIndex extends Activity implements View.OnClickListener {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_yl_focus_index);
        ((CheckedTextView) findViewById(R.id.ctv_ylfocus_car_radio)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_ylfocus_car_cd)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_ylfocus_sync)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_ylfocus_sync /* 2131428047 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) FocusSyncBtActi.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_ylfocus_car_radio /* 2131433609 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) ActivityRadio.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_ylfocus_car_cd /* 2131433610 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) ActivityCD.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
        }
    }
}
