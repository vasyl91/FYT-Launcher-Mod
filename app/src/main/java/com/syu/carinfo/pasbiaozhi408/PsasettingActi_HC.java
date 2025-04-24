package com.syu.carinfo.pasbiaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PsasettingActi_HC extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psabz408_setting);
        init();
    }

    
    public void cmd(int cmd) {
        DataCanbus.PROXY.cmd(1, cmd);
    }

    @Override
    public void init() {
        if (((Button) findViewById(R.id.pasbz408_btn_down)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_down)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(9);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_up)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_up)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(5);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_left)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_left)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(6);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_right)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_right)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(8);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_ok)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_ok)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(7);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_mode)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_mode)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(1);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_esc)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_esc)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(4);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_park)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_park)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(2);
                }
            });
        }
        if (((Button) findViewById(R.id.pasbz408_btn_menu)) != null) {
            ((Button) findViewById(R.id.pasbz408_btn_menu)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    PsasettingActi_HC.this.cmd(5);
                }
            });
        }
    }
}
