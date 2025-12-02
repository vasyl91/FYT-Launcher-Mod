package com.syu.carinfo.focus;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActCarSet_14Festia extends BaseActivity {
    int[] ids = {101, 102, 103, 104, 105};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    ActCarSet_14Festia.this.uFlashLight(val);
                    break;
                case 102:
                    ActCarSet_14Festia.this.uPull(val);
                    break;
                case 103:
                    ActCarSet_14Festia.this.uMilesUnit(val);
                    break;
                case 104:
                    ActCarSet_14Festia.this.uMsgSound(val);
                    break;
                case 105:
                    ActCarSet_14Festia.this.uWarnSound(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_319_festia_set);
        init();
    }

    @Override
    public void init() {
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 138, 3, 102);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 108, 3, 101);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 109, 1, 103);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 109, 2, 104);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 109, 3, 105);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    private void check(CheckedTextView v, int val) {
        if (v != null) {
            v.setChecked(val != 0);
        }
    }

    private void sendClick(View v, final int type, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    ActCarSet_14Festia.this.sendCmd(type, cmd, value == 0 ? 1 : 0);
                }
            });
        }
    }

    
    public void sendCmd(int type, int cmd, int value) {
        DataCanbus.PROXY.cmd(6, new int[]{type, cmd, value}, null, null);
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    protected void uWarnSound(int val) {
        TextView txt = (TextView) findViewById(R.id.tv_text5);
        if (txt != null) {
            if (val == 0) {
            }
            txt.setText(R.string.rzc_c4l_close);
        }
        check((CheckedTextView) findViewById(R.id.ctv_checkedtext5), val);
    }

    protected void uMsgSound(int val) {
        TextView txt = (TextView) findViewById(R.id.tv_text4);
        if (txt != null) {
            if (val == 0) {
            }
            txt.setText(R.string.rzc_c4l_close);
        }
        check((CheckedTextView) findViewById(R.id.ctv_checkedtext4), val);
    }

    protected void uMilesUnit(int val) {
        TextView txt = (TextView) findViewById(R.id.tv_text3);
        if (txt != null) {
            txt.setText(val == 0 ? R.string.jeep_format_set1 : R.string.jeep_format_set0);
        }
        check((CheckedTextView) findViewById(R.id.ctv_checkedtext3), val);
    }

    protected void uPull(int val) {
        TextView txt = (TextView) findViewById(R.id.tv_text1);
        if (txt != null) {
            if (val == 0) {
            }
            txt.setText(R.string.rzc_c4l_close);
        }
        check((CheckedTextView) findViewById(R.id.ctv_checkedtext1), val);
    }

    protected void uFlashLight(int val) {
        TextView txt = (TextView) findViewById(R.id.tv_text2);
        if (txt != null) {
            txt.setText(val == 0 ? R.string.wc_jianianhua_show_turnlights_point_0 : R.string.wc_jianianhua_show_turnlights_point_1);
        }
        check((CheckedTextView) findViewById(R.id.ctv_checkedtext2), val);
    }
}
