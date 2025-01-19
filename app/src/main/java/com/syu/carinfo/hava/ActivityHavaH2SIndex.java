package com.syu.carinfo.hava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_Toyota_prado_HP;
import com.syu.module.canbus.DataCanbus;

public class ActivityHavaH2SIndex extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_index_siyu);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[1000] == 196740) {
                    ActivityHavaH2SIndex.this.startActivity(new Intent(ActivityHavaH2SIndex.this, (Class<?>) Air_Activity_All_Toyota_prado_HP.class));
                } else {
                    ActivityHavaH2SIndex.this.startActivity(new Intent(ActivityHavaH2SIndex.this, (Class<?>) Air_Activity_All_Toyota_prado_HP.class));
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[1000] == 196740) {
                    ActivityHavaH2SIndex.this.startActivity(new Intent(ActivityHavaH2SIndex.this, (Class<?>) ActivityHavaH2SCarInfo.class));
                } else {
                    ActivityHavaH2SIndex.this.startActivity(new Intent(ActivityHavaH2SIndex.this, (Class<?>) ActivityHavaRZCH2SCarInfo.class));
                }
            }
        });
    }
}
