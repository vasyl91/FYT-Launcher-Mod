package com.syu.carinfo.rzc.jianghuai;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcJianghuaiFenweiLightSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiFenweiLightSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 172:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 173:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text2)).setText("静态模式");
                                break;
                            case 1:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text2)).setText("呼吸模式");
                                break;
                            case 2:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text2)).setText("流水模式");
                                break;
                        }
                    }
                    break;
                case 174:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("春意盎然");
                                break;
                            case 1:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("骄阳似火");
                                break;
                            case 2:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("秋色宜人");
                                break;
                            case 3:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("白雪皑皑");
                                break;
                            case 4:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("水碧山青");
                                break;
                            case 5:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("姹紫嫣红");
                                break;
                            case 6:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("金碧辉煌");
                                break;
                            case 7:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("碧海蓝天");
                                break;
                            case 8:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("紫气东来");
                                break;
                            case 9:
                                ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text3)).setText("自定义");
                                break;
                        }
                    }
                    break;
                case 175:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 176:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 177:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 178:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 179:
                    if (((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RzcJianghuaiFenweiLightSetFunc.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jianghuai_fwlight_setfunc);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int D0 = DataCanbus.DATA[172];
                int D1 = DataCanbus.DATA[173];
                int D2 = DataCanbus.DATA[174];
                int D3 = DataCanbus.DATA[175];
                int D4 = DataCanbus.DATA[176];
                int D5 = DataCanbus.DATA[177];
                int D6 = DataCanbus.DATA[178];
                int D7 = DataCanbus.DATA[179];
                if (D0 > 0) {
                    D0--;
                }
                setCarInfo(D0, D1, D2, D3, D4, D5, D6, D7);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int D8 = DataCanbus.DATA[172];
                int D9 = DataCanbus.DATA[173];
                int D10 = DataCanbus.DATA[174];
                int D11 = DataCanbus.DATA[175];
                int D12 = DataCanbus.DATA[176];
                int D13 = DataCanbus.DATA[177];
                int D14 = DataCanbus.DATA[178];
                int D15 = DataCanbus.DATA[179];
                if (D8 < 10) {
                    D8++;
                }
                setCarInfo(D8, D9, D10, D11, D12, D13, D14, D15);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int D16 = DataCanbus.DATA[172];
                int D17 = DataCanbus.DATA[173];
                int D18 = DataCanbus.DATA[174];
                int D19 = DataCanbus.DATA[175];
                int D20 = DataCanbus.DATA[176];
                int D21 = DataCanbus.DATA[177];
                int D22 = DataCanbus.DATA[178];
                int D23 = DataCanbus.DATA[179];
                if (D17 > 0) {
                    D17--;
                }
                setCarInfo(D16, D17, D18, D19, D20, D21, D22, D23);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int D24 = DataCanbus.DATA[172];
                int D25 = DataCanbus.DATA[173];
                int D26 = DataCanbus.DATA[174];
                int D27 = DataCanbus.DATA[175];
                int D28 = DataCanbus.DATA[176];
                int D29 = DataCanbus.DATA[177];
                int D30 = DataCanbus.DATA[178];
                int D31 = DataCanbus.DATA[179];
                if (D25 < 2) {
                    D25++;
                }
                setCarInfo(D24, D25, D26, D27, D28, D29, D30, D31);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int D32 = DataCanbus.DATA[172];
                int D33 = DataCanbus.DATA[173];
                int D34 = DataCanbus.DATA[174];
                int D35 = DataCanbus.DATA[175];
                int D36 = DataCanbus.DATA[176];
                int D37 = DataCanbus.DATA[177];
                int D38 = DataCanbus.DATA[178];
                int D39 = DataCanbus.DATA[179];
                if (D34 > 0) {
                    D34--;
                }
                setCarInfo(D32, D33, D34, D35, D36, D37, D38, D39);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int D40 = DataCanbus.DATA[172];
                int D41 = DataCanbus.DATA[173];
                int D42 = DataCanbus.DATA[174];
                int D43 = DataCanbus.DATA[175];
                int D44 = DataCanbus.DATA[176];
                int D45 = DataCanbus.DATA[177];
                int D46 = DataCanbus.DATA[178];
                int D47 = DataCanbus.DATA[179];
                if (D42 < 9) {
                    D42++;
                }
                setCarInfo(D40, D41, D42, D43, D44, D45, D46, D47);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int D48 = DataCanbus.DATA[172];
                int D49 = DataCanbus.DATA[173];
                int D50 = DataCanbus.DATA[174];
                int D51 = DataCanbus.DATA[175];
                int D52 = DataCanbus.DATA[176];
                int D53 = DataCanbus.DATA[177];
                int D54 = DataCanbus.DATA[178];
                int D55 = DataCanbus.DATA[179];
                if (D51 > 0) {
                    D51--;
                }
                setCarInfo(D48, D49, D50, D51, D52, D53, D54, D55);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int D56 = DataCanbus.DATA[172];
                int D57 = DataCanbus.DATA[173];
                int D58 = DataCanbus.DATA[174];
                int D59 = DataCanbus.DATA[175];
                int D60 = DataCanbus.DATA[176];
                int D61 = DataCanbus.DATA[177];
                int D62 = DataCanbus.DATA[178];
                int D63 = DataCanbus.DATA[179];
                if (D59 < 128) {
                    D59++;
                }
                setCarInfo(D56, D57, D58, D59, D60, D61, D62, D63);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int D64 = DataCanbus.DATA[172];
                int D65 = DataCanbus.DATA[173];
                int D66 = DataCanbus.DATA[174];
                int D67 = DataCanbus.DATA[175];
                int D68 = DataCanbus.DATA[176];
                int D69 = DataCanbus.DATA[177];
                int D70 = DataCanbus.DATA[178];
                int D71 = DataCanbus.DATA[179];
                if (D68 > 0) {
                    D68--;
                }
                setCarInfo(D64, D65, D66, D67, D68, D69, D70, D71);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int D72 = DataCanbus.DATA[172];
                int D73 = DataCanbus.DATA[173];
                int D74 = DataCanbus.DATA[174];
                int D75 = DataCanbus.DATA[175];
                int D76 = DataCanbus.DATA[176];
                int D77 = DataCanbus.DATA[177];
                int D78 = DataCanbus.DATA[178];
                int D79 = DataCanbus.DATA[179];
                if (D76 < 128) {
                    D76++;
                }
                setCarInfo(D72, D73, D74, D75, D76, D77, D78, D79);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int D80 = DataCanbus.DATA[172];
                int D81 = DataCanbus.DATA[173];
                int D82 = DataCanbus.DATA[174];
                int D83 = DataCanbus.DATA[175];
                int D84 = DataCanbus.DATA[176];
                int D85 = DataCanbus.DATA[177];
                int D86 = DataCanbus.DATA[178];
                int D87 = DataCanbus.DATA[179];
                if (D85 > 0) {
                    D85--;
                }
                setCarInfo(D80, D81, D82, D83, D84, D85, D86, D87);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int D88 = DataCanbus.DATA[172];
                int D89 = DataCanbus.DATA[173];
                int D90 = DataCanbus.DATA[174];
                int D91 = DataCanbus.DATA[175];
                int D92 = DataCanbus.DATA[176];
                int D93 = DataCanbus.DATA[177];
                int D94 = DataCanbus.DATA[178];
                int D95 = DataCanbus.DATA[179];
                if (D93 < 128) {
                    D93++;
                }
                setCarInfo(D88, D89, D90, D91, D92, D93, D94, D95);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int D96 = DataCanbus.DATA[172];
                int D97 = DataCanbus.DATA[173];
                int D98 = DataCanbus.DATA[174];
                int D99 = DataCanbus.DATA[175];
                int D100 = DataCanbus.DATA[176];
                int D101 = DataCanbus.DATA[177];
                int D102 = DataCanbus.DATA[178];
                int D103 = DataCanbus.DATA[179];
                if (D102 > 0) {
                    D102--;
                }
                setCarInfo(D96, D97, D98, D99, D100, D101, D102, D103);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int D104 = DataCanbus.DATA[172];
                int D105 = DataCanbus.DATA[173];
                int D106 = DataCanbus.DATA[174];
                int D107 = DataCanbus.DATA[175];
                int D108 = DataCanbus.DATA[176];
                int D109 = DataCanbus.DATA[177];
                int D110 = DataCanbus.DATA[178];
                int D111 = DataCanbus.DATA[179];
                if (D110 < 128) {
                    D110++;
                }
                setCarInfo(D104, D105, D106, D107, D108, D109, D110, D111);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int D112 = DataCanbus.DATA[172];
                int D113 = DataCanbus.DATA[173];
                int D114 = DataCanbus.DATA[174];
                int D115 = DataCanbus.DATA[175];
                int D116 = DataCanbus.DATA[176];
                int D117 = DataCanbus.DATA[177];
                int D118 = DataCanbus.DATA[178];
                int D119 = DataCanbus.DATA[179];
                if (D119 > 0) {
                    D119--;
                }
                setCarInfo(D112, D113, D114, D115, D116, D117, D118, D119);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int D120 = DataCanbus.DATA[172];
                int D121 = DataCanbus.DATA[173];
                int D122 = DataCanbus.DATA[174];
                int D123 = DataCanbus.DATA[175];
                int D124 = DataCanbus.DATA[176];
                int D125 = DataCanbus.DATA[177];
                int D126 = DataCanbus.DATA[178];
                int D127 = DataCanbus.DATA[179];
                if (D127 < 128) {
                    D127++;
                }
                setCarInfo(D120, D121, D122, D123, D124, D125, D126, D127);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6, int value7) {
        DataCanbus.PROXY.cmd(6, new int[]{value0, value1, value2, value3, value4, value5, value6, value7}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.notifyCanbus);
    }
}
