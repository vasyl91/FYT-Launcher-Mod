package com.syu.carinfo.accord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityAccord7Index extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_274_accord7_index);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Air_Activity_All_NewAdd_HP.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, ActivityAccord7AirDiagnosis.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
        }
    }
}
