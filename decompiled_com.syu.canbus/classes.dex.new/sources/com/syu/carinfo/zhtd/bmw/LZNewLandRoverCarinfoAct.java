package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZNewLandRoverCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext3).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    switch (value) {
                        case 0:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            break;
                        case 1:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            break;
                        case 2:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext3).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            break;
                    }
                    break;
                case 116:
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext4).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext5).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    switch (value) {
                        case 0:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext4).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            break;
                        case 1:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext5).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            break;
                    }
                    break;
                case 117:
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext6).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext7).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext8).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext9).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext10).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext11).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext12).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext13).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext14).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext15).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext16).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext17).setBackgroundResource(R.drawable.ic_lz_landrover_button_n);
                    switch (value) {
                        case 0:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext6).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view1);
                            break;
                        case 1:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext7).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view2);
                            break;
                        case 2:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext8).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view3);
                            break;
                        case 3:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext9).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view4);
                            break;
                        case 4:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext10).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view5);
                            break;
                        case 5:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext11).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view6);
                            break;
                        case 6:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext12).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view7);
                            break;
                        case 7:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext13).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view8);
                            break;
                        case 8:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext14).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view9);
                            break;
                        case 9:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext15).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view10);
                            break;
                        case 10:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext16).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view11);
                            break;
                        case 11:
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.ctv_checkedtext17).setBackgroundResource(R.drawable.ic_lz_landrover_button_p);
                            LZNewLandRoverCarinfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_lz_landrover_view12);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_landrover_dashboard);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((Button) findViewById(R.id.ctv_checkedtext17), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                DataCanbus.PROXY.cmd(0, new int[]{1, 0}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                DataCanbus.PROXY.cmd(0, new int[]{2, 0}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                DataCanbus.PROXY.cmd(0, new int[]{2, 1}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                DataCanbus.PROXY.cmd(0, new int[]{1, 2}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 0}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 1}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 2}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 3}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 4}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 5}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 6}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 7}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 8}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 9}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 10}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                DataCanbus.PROXY.cmd(0, new int[]{251, 11}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }
}
