package com.syu.carinfo.rzc.zhongtai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcLandRoverCDAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_landrover_indexact);
        if (((Button) findViewById(R.id.btn_vol_add)) != null) {
            ((Button) findViewById(R.id.btn_vol_add)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_vol_sub)) != null) {
            ((Button) findViewById(R.id.btn_vol_sub)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
        FuncMain.setChannel(13);
    }
}
