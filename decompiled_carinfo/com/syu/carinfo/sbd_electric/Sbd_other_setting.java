package com.syu.carinfo.sbd_electric;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Sbd_other_setting extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_313_electric_other);
        ((CheckedTextView) findViewById(R.id.Sbd_313_Info)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.Sbd_313_Charger)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.Sbd_313_Battery)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.Sbd_313_Motor)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.Sbd_313_voltage)).setOnClickListener(this);
        if (((CheckedTextView) findViewById(R.id.Sbd_313_soc_tachli)) != null) {
            ((CheckedTextView) findViewById(R.id.Sbd_313_soc_tachli)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Sbd_313_Info /* 2131429318 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Sbd_Settings_Basic_info.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.Sbd_313_Charger /* 2131429319 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Sbd_Settings_Charger_Status.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.Sbd_313_Battery /* 2131429320 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, Sbd_Settings_Battery_Status.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.Sbd_313_Motor /* 2131429321 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, Sbd_Settings_Motor_Status.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.Sbd_313_voltage /* 2131429322 */:
                Intent intent5 = new Intent();
                intent5.setClass(this, Sbd_Settings_Voltage_Status.class);
                startActivity(intent5);
                break;
            case R.id.Sbd_313_soc_tachli /* 2131429323 */:
                DataCanbus.PROXY.cmd(1, new int[]{1, 1}, null, null);
                break;
        }
    }
}
