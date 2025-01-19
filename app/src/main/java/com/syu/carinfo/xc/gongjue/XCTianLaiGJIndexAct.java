package com.syu.carinfo.xc.gongjue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

public class XCTianLaiGJIndexAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_tianlai_gj_index);
        findViewById(R.id.id_amp_info).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(XCTianLaiGJIndexAct.this, XCTianLaiGjAmpInfoAct.class);
                XCTianLaiGJIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.id_center_control).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(XCTianLaiGJIndexAct.this, XCTianLaiGJCenterControlAct.class);
                XCTianLaiGJIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.id_cd_control).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(XCTianLaiGJIndexAct.this, XCTianLaiGjCdAct.class);
                XCTianLaiGJIndexAct.this.startActivity(intent);
            }
        });
    }
}
