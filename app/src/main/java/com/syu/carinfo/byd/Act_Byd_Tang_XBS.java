package com.syu.carinfo.byd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Act_Byd_Tang_XBS extends Activity implements View.OnClickListener {
    int iDts;
    int iSoc;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    Act_Byd_Tang_XBS.this.uDts(this.value);
                    break;
                case 101:
                    Act_Byd_Tang_XBS.this.uSoc(this.value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_194_xbs_byd);
        setListener();
    }

    private void setListener() {
        if (((Button) findViewById(R.id.xbs_soc_m)) != null) {
            ((Button) findViewById(R.id.xbs_soc_m)).setOnClickListener(this);
        }
        if (((Button) findViewById(R.id.xbs_soc_p)) != null) {
            ((Button) findViewById(R.id.xbs_soc_p)).setOnClickListener(this);
        }
        if (((CheckedTextView) findViewById(R.id.xbs_dts)) != null) {
            ((CheckedTextView) findViewById(R.id.xbs_dts)).setOnClickListener(this);
        }
    }

    private void setAirControl(int cmdId, int val) {
        DataCanbus.PROXY.cmd(1, cmdId, val);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 131266) {
            setViewVisible(findViewById(R.id.xbs_dts_view), true);
            setViewVisible(findViewById(R.id.xbs_soc_view), false);
        } else if (DataCanbus.DATA[1000] == 196802) {
            setViewVisible(findViewById(R.id.xbs_dts_view), false);
            setViewVisible(findViewById(R.id.xbs_soc_view), true);
        }
    }

    private void setViewVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 8);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xbs_dts /* 2131428839 */:
                setAirControl(18, this.iDts != 1 ? 1 : 0);
                break;
            case R.id.xbs_soc_m /* 2131428841 */:
                this.iSoc -= 5;
                if (this.iSoc < 15) {
                    this.iSoc = 15;
                }
                setAirControl(0, this.iSoc);
                break;
            case R.id.xbs_soc_p /* 2131428843 */:
                this.iSoc += 5;
                if (this.iSoc > 75) {
                    this.iSoc = 75;
                }
                setAirControl(0, this.iSoc);
                break;
        }
    }

    protected void uDts(int value) {
        this.iDts = value;
        if (((CheckedTextView) findViewById(R.id.xbs_dts)) != null) {
            ((CheckedTextView) findViewById(R.id.xbs_dts)).setChecked(value == 1);
        }
    }

    protected void uSoc(int value) {
        this.iSoc = value;
        if (((TextView) findViewById(R.id.xbs_soc_txt)) != null) {
            ((TextView) findViewById(R.id.xbs_soc_txt)).setText(String.valueOf(value) + "%");
        }
    }
}
