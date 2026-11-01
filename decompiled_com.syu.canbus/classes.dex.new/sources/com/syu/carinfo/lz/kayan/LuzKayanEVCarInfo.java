package com.syu.carinfo.lz.kayan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzKayanEVCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.kayan.LuzKayanEVCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_btn_null;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 131:
                    switch (value) {
                        case 1:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev1);
                            break;
                        case 2:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev2);
                            break;
                        case 3:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev3);
                            break;
                        case 4:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev4);
                            break;
                        case 5:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev5);
                            break;
                        case 6:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev6);
                            break;
                        case 7:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev7);
                            break;
                        case 8:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev8);
                            break;
                        case 9:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev9);
                            break;
                        case 10:
                            LuzKayanEVCarInfo.this.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_lz_cayan_lev10);
                            break;
                    }
                    break;
                case 132:
                    switch (value) {
                        case 0:
                            ((TextView) LuzKayanEVCarInfo.this.findViewById(R.id.tv_text2)).setText("eboost:   OFF");
                            break;
                        case 1:
                            ((TextView) LuzKayanEVCarInfo.this.findViewById(R.id.tv_text2)).setText("eboost:   ON");
                            break;
                    }
                    break;
                case 134:
                    View viewFindViewById = LuzKayanEVCarInfo.this.findViewById(R.id.layout_view6);
                    if (value == 1) {
                        i = R.drawable.ic_lz_cayan_ui5;
                    }
                    viewFindViewById.setBackgroundResource(i);
                    break;
                case 135:
                    View viewFindViewById2 = LuzKayanEVCarInfo.this.findViewById(R.id.layout_view7);
                    if (value == 1) {
                        i = R.drawable.ic_lz_cayan_ui6;
                    }
                    viewFindViewById2.setBackgroundResource(i);
                    break;
                case 136:
                    View viewFindViewById3 = LuzKayanEVCarInfo.this.findViewById(R.id.layout_view4);
                    if (value == 1) {
                        i = R.drawable.ic_lz_cayan_ui3;
                    }
                    viewFindViewById3.setBackgroundResource(i);
                    break;
                case 137:
                    View viewFindViewById4 = LuzKayanEVCarInfo.this.findViewById(R.id.layout_view3);
                    if (value == 1) {
                        i = R.drawable.ic_lz_cayan_ui2;
                    }
                    viewFindViewById4.setBackgroundResource(i);
                    break;
                case 138:
                    View viewFindViewById5 = LuzKayanEVCarInfo.this.findViewById(R.id.layout_view2);
                    if (value == 1) {
                        i = R.drawable.ic_lz_cayan_ui1;
                    }
                    viewFindViewById5.setBackgroundResource(i);
                    break;
                case 139:
                    View viewFindViewById6 = LuzKayanEVCarInfo.this.findViewById(R.id.layout_view5);
                    if (value == 1) {
                        i = R.drawable.ic_lz_cayan_ui4;
                    }
                    viewFindViewById6.setBackgroundResource(i);
                    break;
                case 140:
                    ((TextView) LuzKayanEVCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    break;
                case 141:
                    if (value == 65535) {
                        ((TextView) LuzKayanEVCarInfo.this.findViewById(R.id.tv_text3)).setText("----km");
                    } else {
                        ((TextView) LuzKayanEVCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_luz_kayan_ev_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
    }
}
