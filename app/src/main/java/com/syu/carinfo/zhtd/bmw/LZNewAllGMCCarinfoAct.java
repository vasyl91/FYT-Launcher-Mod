package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.SystemProperties;
import android.view.View;
import android.widget.Button;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZNewAllGMCCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int pagenum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_lz_gmc_dashboard);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.pagenum = SystemProperties.getInt("persist.fyt.lzgmtype", 0);
        switch (this.pagenum) {
            case 0:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel1);
                break;
            case 1:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel2);
                break;
            case 2:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel3);
                break;
            case 3:
                findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel4);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                this.pagenum++;
                if (this.pagenum > 3) {
                    this.pagenum = 0;
                }
                switch (this.pagenum) {
                    case 0:
                        findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel1);
                        break;
                    case 1:
                        findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel2);
                        break;
                    case 2:
                        findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel3);
                        break;
                    case 3:
                        findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_gmc_pannel4);
                        break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                switch (this.pagenum) {
                    case 0:
                        SystemProperties.set("persist.fyt.lzgmtype", "0");
                        break;
                    case 1:
                        SystemProperties.set("persist.fyt.lzgmtype", "1");
                        break;
                    case 2:
                        SystemProperties.set("persist.fyt.lzgmtype", "2");
                        break;
                    case 3:
                        SystemProperties.set("persist.fyt.lzgmtype", "3");
                        break;
                }
        }
    }
}
