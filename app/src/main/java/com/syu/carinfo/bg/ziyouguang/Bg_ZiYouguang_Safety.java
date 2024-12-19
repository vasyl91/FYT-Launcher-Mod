package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Bg_ZiYouguang_Safety extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Bg_ZiYouguang_Safety.this.mParksense_brake_assist();
                    break;
                case 1:
                    Bg_ZiYouguang_Safety.this.mHill_start_assist();
                    break;
                case 2:
                    Bg_ZiYouguang_Safety.this.mAuto_park_brake();
                    break;
                case 11:
                    Bg_ZiYouguang_Safety.this.mParkSense();
                    break;
                case 12:
                    Bg_ZiYouguang_Safety.this.mFrontParkSenseVol();
                    break;
                case 13:
                    Bg_ZiYouguang_Safety.this.mRearParkSenseVol();
                    break;
                case 19:
                    Bg_ZiYouguang_Safety.this.mBrake_mode();
                    break;
                case 20:
                    Bg_ZiYouguang_Safety.this.mForwardCollision();
                    break;
                case 21:
                    Bg_ZiYouguang_Safety.this.mVideoMove();
                    break;
                case 22:
                    Bg_ZiYouguang_Safety.this.mVideoStatic();
                    break;
                case 23:
                    Bg_ZiYouguang_Safety.this.mViewRainAuto();
                    break;
                case 24:
                    Bg_ZiYouguang_Safety.this.mForwardCollisionWarn();
                    break;
                case 25:
                    Bg_ZiYouguang_Safety.this.mLanewar();
                    break;
                case 26:
                    Bg_ZiYouguang_Safety.this.mView_Lanedev();
                    break;
                case 27:
                    Bg_ZiYouguang_Safety.this.mBlindWarring();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_safety);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 371) {
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
        }
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[12];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[12];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[13];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[13];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[0];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[1];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[2];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int i = DataCanbus.DATA[19];
                DataCanbus.PROXY.cmd(2, new int[]{5, 2}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[21];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[22];
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(3, new int[]{7, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[23];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{8, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[20];
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[20];
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[24];
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[24];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[25];
                if (value2 == 3) {
                    value = 2;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[25];
                if (value2 == 1) {
                    value = 2;
                } else if (value2 == 2) {
                    value = 4;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[26];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[26];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_ZiYouguang_Safety.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value}, null, null);
            }
        });
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mParksense_brake_assist() {
        int value = DataCanbus.DATA[0];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mHill_start_assist() {
        int value = DataCanbus.DATA[1];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAuto_park_brake() {
        int value = DataCanbus.DATA[2];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mBrake_mode() {
        int value = DataCanbus.DATA[19];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mParkSense() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_factory_settings_select_models_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mFrontParkSenseVol() {
        int value = DataCanbus.DATA[12];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearParkSenseVol() {
        int value = DataCanbus.DATA[13];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.crv_source_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mForwardCollision() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_1);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_0);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.crv_source_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mVideoMove() {
        int value = DataCanbus.DATA[21];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mVideoStatic() {
        int value = DataCanbus.DATA[22];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mViewRainAuto() {
        int value = DataCanbus.DATA[23];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mForwardCollisionWarn() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText("ON");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("OFF");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.crv_source_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mLanewar() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_0);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_1);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_2);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.crv_source_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mView_Lanedev() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_372_low);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_372_mid);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_372_high);
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.crv_source_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mBlindWarring() {
        int value = DataCanbus.DATA[27];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_0);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_1);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_2);
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
            }
        }
    }
}
