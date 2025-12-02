package com.syu.carinfo.wc2.weichai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2WeiChaiAct extends BaseActivity {
    private CheckedTextView mBtnSettings;
    private CheckedTextView mBtnShowLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public void init() {
        if (this.mBtnShowLight != null) {
            this.mBtnShowLight.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        WC2WeiChaiAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (this.mBtnSettings != null) {
            this.mBtnSettings.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(WC2WeiChaiAct.this, WC2WeiChaiAirControlAct.class);
                        WC2WeiChaiAct.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
