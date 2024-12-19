package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet4 extends BaseFragment implements View.OnClickListener {
    int[] ids = {59, 60, 61, 62};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet4.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 59:
                    Fragment_Surui_CarSet4.this.uBlueWindDown(value);
                    break;
                case 60:
                    Fragment_Surui_CarSet4.this.uAutoCyclePark(value);
                    break;
                case 61:
                    Fragment_Surui_CarSet4.this.uAirAutoAc(value);
                    break;
                case 62:
                    Fragment_Surui_CarSet4.this.uAutoWindlev(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
        bindViewOnClick(R.id.btn_minus1, this);
        bindViewOnClick(R.id.btn_plus1, this);
        bindViewOnClick(R.id.btn_minus2, this);
        bindViewOnClick(R.id.btn_plus2, this);
        bindViewOnClick(R.id.ctv_checkedtext1, this);
        bindViewOnClick(R.id.ctv_checkedtext2, this);
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0439_xbs_byd_song_carset;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        if (DataCanbus.sCanbusId == 8782263) {
            DataCanbus.PROXY.cmd(5, 13);
        }
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value = 0;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[59] == 0) {
                    value = 1;
                    break;
                } else {
                    value = 2;
                    break;
                }
            case R.id.btn_minus1 /* 2131427480 */:
                value = 5;
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                value = 6;
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int data = DataCanbus.DATA[62];
                switch (data) {
                    case 0:
                        value = 7;
                        break;
                    case 1:
                        value = 9;
                        break;
                    case 2:
                        value = 8;
                        break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int data2 = DataCanbus.DATA[62];
                switch (data2) {
                    case 0:
                        value = 8;
                        break;
                    case 1:
                        value = 7;
                        break;
                    case 2:
                        value = 9;
                        break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[60] == 0) {
                    value = 3;
                    break;
                } else {
                    value = 4;
                    break;
                }
        }
        if (value != 0) {
            DataCanbus.PROXY.cmd(3, value);
        }
    }

    protected void uAutoWindlev(int value) {
        if (((TextView) findView(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text2)).setText(R.string.distance_close);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text2)).setText(R.string.klc_air_middle);
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text2)).setText(R.string.distance_far);
                    break;
            }
        }
    }

    protected void uBlueWindDown(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext1), value != 0);
    }

    protected void uAutoCyclePark(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext2), value != 0);
    }

    protected void uAirAutoAc(int value) {
        if (((TextView) findView(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text1)).setText(R.string.str_driving_eco);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text1)).setText(R.string.str_wc_174008_str17);
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text1)).setText(R.string.str_intelligent);
                    break;
            }
        }
    }
}
