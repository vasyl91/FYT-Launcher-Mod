package com.syu.carinfo.zhtd.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZH2PilotcarWARNCodeinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    ((TextView) ZH2PilotcarWARNCodeinfoAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    if (value == 0) {
                        ZH2PilotcarWARNCodeinfoAct.this.finish();
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0454_zh_pilotcar_warcode_info);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
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
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        Intent i = new Intent("android.fyt.action.360HIDE");
        i.setPackage("com.fyt.screenbutton");
        LauncherApplication.getInstance().startService(i);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent i = new Intent("android.fyt.action.360SHOW");
        i.setPackage("com.fyt.screenbutton");
        LauncherApplication.getInstance().startService(i);
        removeNotify();
        mIsFront = false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    String getcode(int i) {
        String str = new StringBuilder().append(i).toString();
        switch (i) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return str;
        }
    }
}
