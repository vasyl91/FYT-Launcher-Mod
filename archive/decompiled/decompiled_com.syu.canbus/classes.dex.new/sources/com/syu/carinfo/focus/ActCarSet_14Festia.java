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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActCarSet_14Festia extends BaseActivity {
    int[] ids = {101, 102, 103, 104, 105, 108, 117, 118, 119};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.focus.ActCarSet_14Festia.1
        @Override // com.syu.module.IUiNotify
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
                case 108:
                    ((TextView) ActCarSet_14Festia.this.findViewById(R.id.tv_text8)).setText(val == 0 ? "℉" : "℃");
                    ActCarSet_14Festia.this.check((CheckedTextView) ActCarSet_14Festia.this.findViewById(R.id.ctv_checkedtext8), val);
                    break;
                case 117:
                    TextView textView = (TextView) ActCarSet_14Festia.this.findViewById(R.id.tv_text6);
                    if (val == 0) {
                    }
                    textView.setText(R.string.rzc_c4l_close);
                    ActCarSet_14Festia.this.check((CheckedTextView) ActCarSet_14Festia.this.findViewById(R.id.ctv_checkedtext6), val);
                    break;
                case 118:
                    TextView textView2 = (TextView) ActCarSet_14Festia.this.findViewById(R.id.tv_text7);
                    if (val == 0) {
                    }
                    textView2.setText(R.string.rzc_c4l_close);
                    ActCarSet_14Festia.this.check((CheckedTextView) ActCarSet_14Festia.this.findViewById(R.id.ctv_checkedtext7), val);
                    break;
                case 119:
                    TextView textView3 = (TextView) ActCarSet_14Festia.this.findViewById(R.id.tv_text9);
                    if (val == 0) {
                    }
                    textView3.setText(R.string.rzc_c4l_close);
                    ActCarSet_14Festia.this.check((CheckedTextView) ActCarSet_14Festia.this.findViewById(R.id.ctv_checkedtext9), val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_319_festia_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 138, 3, 102);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 108, 3, 101);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 109, 1, 103);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 109, 2, 104);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 109, 3, 105);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 109, 17, 117);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 109, 16, 118);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 109, 4, 108);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), 109, 6, 119);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void check(CheckedTextView v, int val) {
        if (v != null) {
            v.setChecked(val != 0);
        }
    }

    private void sendClick(View v, final int type, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.ActCarSet_14Festia.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    ActCarSet_14Festia.this.sendCmd(type, cmd, value == 0 ? 1 : 0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int type, int cmd, int value) {
        DataCanbus.PROXY.cmd(6, new int[]{type, cmd, value}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
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
