package com.syu.carinfo.dongjian.wc2.ds5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5IndexAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_302_dongjian_wc2_ds5_index);
        init();
        setUI();
    }

    public void setUI() {
        findViewById(R.id.dongjian_wc2_ds5_car_set_check).setOnClickListener(this);
        findViewById(R.id.dongjian_wc2_ds5_car_set_page1_check).setOnClickListener(this);
        findViewById(R.id.dongjian_wc2_ds5_car_set_page2_check).setOnClickListener(this);
        findViewById(R.id.dongjian_wc2_ds5_car_set_page3_check).setOnClickListener(this);
        findViewById(R.id.dongjian_wc2_ds5_car_system_set_check).setOnClickListener(this);
        findViewById(R.id.dongjian_wc2_ds5_unit_set_index_check).setOnClickListener(this);
        findViewById(R.id.dongjian_wc2_ds5_time_set_index_check).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_wc2_ds5_car_set_check /* 2131429219 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) DS5CarLogAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.dongjian_wc2_ds5_car_set_page1_check /* 2131429220 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) DS5CarLog1Act.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.dongjian_wc2_ds5_car_set_page2_check /* 2131429221 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) DS5CarLog2Act.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.dongjian_wc2_ds5_car_set_page3_check /* 2131429222 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) DS5CarLog3Act.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.dongjian_wc2_ds5_car_system_set_check /* 2131429223 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) DS5CarSetInfoAct.class);
                    startActivity(intent5);
                    break;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.dongjian_wc2_ds5_unit_set_index_check /* 2131429224 */:
                try {
                    Intent intent6 = new Intent(this, (Class<?>) DS5CarUnitSetAct.class);
                    startActivity(intent6);
                    break;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case R.id.dongjian_wc2_ds5_time_set_index_check /* 2131429225 */:
                try {
                    Intent intent7 = new Intent(this, (Class<?>) DS5CarTimeSetAct.class);
                    startActivity(intent7);
                    break;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
        }
    }
}
