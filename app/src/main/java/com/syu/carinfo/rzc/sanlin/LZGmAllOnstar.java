package com.syu.carinfo.rzc.sanlin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.klc.KlcFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZGmAllOnstar extends Activity {
    StringBuffer buffer;
    int[] showints;
    public static boolean mIsFront = false;
    public static boolean isChannle = true;
    boolean IsIntentOn = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZGmAllOnstar.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 52:
                    if (((TextView) LZGmAllOnstar.this.findViewById(R.id.showOnstarNum)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LZGmAllOnstar.this.findViewById(R.id.showOnstarNum)).setText(R.string.str_right_camera_open);
                                break;
                            case 2:
                                ((TextView) LZGmAllOnstar.this.findViewById(R.id.showOnstarNum)).setText(R.string.klc_onstar_on_call);
                                break;
                            case 3:
                                ((TextView) LZGmAllOnstar.this.findViewById(R.id.showOnstarNum)).setText(R.string.klc_onstar_going_out);
                                break;
                            case 4:
                                ((TextView) LZGmAllOnstar.this.findViewById(R.id.showOnstarNum)).setText(R.string.klc_onstar_Connected);
                                break;
                            default:
                                ((TextView) LZGmAllOnstar.this.findViewById(R.id.showOnstarNum)).setText(R.string.klc_onstar_close);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_gm_all_onstar);
    }

    public void onExtraClik(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.callanswer /* 2131428621 */:
                DataCanbus.PROXY.cmd(1, new int[]{0, 2}, null, null);
                break;
            case R.id.callhang /* 2131428622 */:
                DataCanbus.PROXY.cmd(1, new int[]{0, 3}, null, null);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        KlcFunc.SWITCH_MAIN_STATE(12);
        DataCanbus.PROXY.cmd(1, new int[]{0, 1}, null, null);
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
        KlcFunc.SWITCH_MAIN_STATE(0);
        DataCanbus.PROXY.cmd(1, new int[2], null, null);
        mIsFront = false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
    }
}
