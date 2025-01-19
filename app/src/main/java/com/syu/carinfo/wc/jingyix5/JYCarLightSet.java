package com.syu.carinfo.wc.jingyix5;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class JYCarLightSet extends BaseActivity implements View.OnClickListener {
    int[] eventIds = {138, 139};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 138:
                    JYCarLightSet.this.u_66d0b1(updateCode);
                    break;
                case 139:
                    JYCarLightSet.this.u_66d0b0(updateCode);
                    break;
            }
        }
    };
    static int[] strId67d0b1 = {R.string.off, R.string.str_wc_jy_str8, R.string.str_wc_jy_str9, R.string.str_wc_jy_str10};
    static int[] strId67d0b0 = {R.string.str_wc_jy_str11, R.string.str_wc_jy_str12, R.string.str_wc_jy_str13};

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_wc_jyx5_light);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_toplight_delay)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_time2savepower)).setOnClickListener(this);
        findViewById(R.id.ctv_toplight_delay_view).setOnClickListener(this);
        findViewById(R.id.ctv_time2savepower_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_toplight_delay_view /* 2131432982 */:
            case R.id.ctv_toplight_delay /* 2131432983 */:
                int id67d0b1 = (DataCanbus.DATA[138] & 15) + 1;
                DataCanbus.PROXY.cmd(1, new int[]{2, id67d0b1 % strId67d0b1.length}, null, null);
                break;
            case R.id.ctv_time2savepower_view /* 2131432985 */:
            case R.id.ctv_time2savepower /* 2131432986 */:
                int id67d0b0 = (DataCanbus.DATA[139] & 15) + 1;
                DataCanbus.PROXY.cmd(1, new int[]{1, (id67d0b0 % strId67d0b0.length) + 1}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    protected void u_66d0b1(int updateCode) {
        int id67d0b1 = DataCanbus.DATA[updateCode];
        boolean on = ((id67d0b1 >> 4) & 1) != 0;
        if (findViewById(R.id.ctv_toplight_delay_view) != null) {
            findViewById(R.id.ctv_toplight_delay_view).setVisibility(on ? 0 : 8);
        }
        int id67d0b12 = id67d0b1 & 3;
        if (id67d0b12 >= strId67d0b1.length) {
            id67d0b12 = 0;
        }
        if (((TextView) findViewById(R.id.ctv_toplight_delay_dec)) != null && id67d0b12 < strId67d0b1.length) {
            ((TextView) findViewById(R.id.ctv_toplight_delay_dec)).setText(strId67d0b1[id67d0b12]);
        }
    }

    protected void u_66d0b0(int updateCode) {
        int id67d0b0 = DataCanbus.DATA[updateCode];
        boolean on = ((id67d0b0 >> 4) & 1) != 0;
        if (findViewById(R.id.ctv_time2savepower_view) != null) {
            findViewById(R.id.ctv_time2savepower_view).setVisibility(on ? 0 : 8);
        }
        int id67d0b02 = id67d0b0 & 3;
        if (id67d0b02 >= strId67d0b0.length) {
            id67d0b02 = 0;
        }
        if (((TextView) findViewById(R.id.ctv_time2savepower_dec)) != null && id67d0b02 < strId67d0b0.length) {
            ((TextView) findViewById(R.id.ctv_time2savepower_dec)).setText(strId67d0b0[id67d0b02]);
        }
    }
}
