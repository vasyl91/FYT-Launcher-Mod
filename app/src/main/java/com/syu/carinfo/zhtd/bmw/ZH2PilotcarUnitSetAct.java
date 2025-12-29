package com.syu.carinfo.zhtd.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.SystemProperties;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZH2PilotcarUnitSetAct extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0454_zh_pilotcar_unitset);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ZH2PilotcarCarinfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                if (SystemProperties.getInt("persist.fyt.mileunit", 0) == 0) {
                    SystemProperties.set("persist.fyt.mileunit", "1");
                    findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pilotcar_unitmi_p);
                    findViewById(R.id.btn_minus3).setBackgroundResource(R.drawable.ic_pilotcar_unitkm_n);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                if (SystemProperties.getInt("persist.fyt.mileunit", 0) == 1) {
                    SystemProperties.set("persist.fyt.mileunit", "0");
                    findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pilotcar_unitmi_n);
                    findViewById(R.id.btn_minus3).setBackgroundResource(R.drawable.ic_pilotcar_unitkm_p);
                    break;
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SystemProperties.getInt("persist.fyt.mileunit", 0) == 1) {
            findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pilotcar_unitmi_p);
            findViewById(R.id.btn_minus3).setBackgroundResource(R.drawable.ic_pilotcar_unitkm_n);
        } else {
            findViewById(R.id.btn_minus2).setBackgroundResource(R.drawable.ic_pilotcar_unitmi_n);
            findViewById(R.id.btn_minus3).setBackgroundResource(R.drawable.ic_pilotcar_unitkm_p);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
