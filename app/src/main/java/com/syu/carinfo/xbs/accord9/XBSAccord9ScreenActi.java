package com.syu.carinfo.xbs.accord9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBSAccord9ScreenActi extends BaseActivity {
    int brightness;
    int contrast;
    private TextView mBrightness;
    private Button mBtnBrightnessMinus;
    private Button mBtnBrightnessPlus;
    private Button mBtnContrastMinus;
    private Button mBtnContrastPlus;
    private Button mBtnSaturationsMinus;
    private Button mBtnSaturationsPlus;
    private Button mBtnScreenColorMinus;
    private Button mBtnScreenColorPlus;
    private Button mBtnScreenDisplayMinus;
    private Button mBtnScreenDisplayPlus;
    int mCameraLinkageLamp;
    private TextView mContrast;
    private CheckedTextView mCtvCameraLinkageLamp;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 29:
                case 79:
                    XBSAccord9ScreenActi.this.screenDisplay = DataCanbus.DATA[updateCode];
                    XBSAccord9ScreenActi.this.mUpdaterScreenDisplay(XBSAccord9ScreenActi.this.screenDisplay);
                    break;
                case 30:
                case 80:
                    XBSAccord9ScreenActi.this.brightness = DataCanbus.DATA[updateCode];
                    XBSAccord9ScreenActi.this.mUpdaterBrightness(DataCanbus.DATA[updateCode]);
                    break;
                case 31:
                case 81:
                    XBSAccord9ScreenActi.this.contrast = DataCanbus.DATA[updateCode];
                    XBSAccord9ScreenActi.this.mUpdaterContrast(DataCanbus.DATA[updateCode]);
                    break;
                case 32:
                case 82:
                    XBSAccord9ScreenActi.this.saturation = DataCanbus.DATA[updateCode];
                    XBSAccord9ScreenActi.this.mUpdaterSaturation(DataCanbus.DATA[updateCode]);
                    break;
                case 34:
                    XBSAccord9ScreenActi.this.screenColor = DataCanbus.DATA[updateCode];
                    XBSAccord9ScreenActi.this.mUpdaterScreenColor(DataCanbus.DATA[updateCode]);
                    break;
                case 83:
                    XBSAccord9ScreenActi.this.mCameraLinkageLamp = DataCanbus.DATA[updateCode];
                    XBSAccord9ScreenActi.this.updateCameraLinkageLamp(XBSAccord9ScreenActi.this.mCameraLinkageLamp);
                    break;
            }
        }
    };
    private TextView mSaturations;
    private TextView mScreenColor;
    private TextView mScreenDisplay;
    private View mView1;
    private View mView2;
    private View mView3;
    private View mView4;
    private View mView5;
    private View mView6;
    int saturation;
    int screenColor;
    int screenDisplay;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_xbs_screen);
        this.mView1 = findViewById(R.id.xp_accord9_view_screen_1);
        this.mView2 = findViewById(R.id.xp_accord9_view_screen_2);
        this.mView3 = findViewById(R.id.xp_accord9_view_screen_3);
        this.mView4 = findViewById(R.id.xp_accord9_view_screen_4);
        this.mView5 = findViewById(R.id.xp_accord9_view_screen_5);
        this.mView6 = findViewById(R.id.xp_accord9_view_screen_6);
        this.mScreenDisplay = (TextView) findViewById(R.id.xp_accord9_tv_car_screen_display);
        this.mBtnScreenDisplayMinus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_display_minus);
        this.mBtnScreenDisplayMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.screenDisplay;
                if (value == 2) {
                    DataCanbus.PROXY.cmd(22, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(22, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(22, new int[]{2}, null, null);
                }
            }
        });
        this.mBtnScreenDisplayPlus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_display_plus);
        this.mBtnScreenDisplayPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.screenDisplay;
                if (value == 0) {
                    DataCanbus.PROXY.cmd(22, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(22, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(22, new int[1], null, null);
                }
            }
        });
        this.mBrightness = (TextView) findViewById(R.id.xp_accord9_tv_car_screen_brightness);
        this.mBtnBrightnessMinus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus);
        this.mBtnBrightnessMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.brightness - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(23, new int[]{value}, null, null);
            }
        });
        this.mBtnBrightnessPlus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus);
        this.mBtnBrightnessPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.brightness + 1;
                if (value < 2) {
                    value = 2;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(23, new int[]{value}, null, null);
            }
        });
        this.mContrast = (TextView) findViewById(R.id.xp_accord9_tv_car_screen_contrast);
        this.mBtnContrastMinus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus);
        this.mBtnContrastMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.contrast - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(24, new int[]{value}, null, null);
            }
        });
        this.mBtnContrastPlus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus);
        this.mBtnContrastPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.contrast + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(24, new int[]{value}, null, null);
            }
        });
        this.mSaturations = (TextView) findViewById(R.id.xp_accord9_tv_car_screen_saturation);
        this.mBtnSaturationsMinus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus);
        this.mBtnSaturationsMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.saturation - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        this.mBtnSaturationsPlus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus);
        this.mBtnSaturationsPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.saturation + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(25, new int[]{value}, null, null);
            }
        });
        this.mScreenColor = (TextView) findViewById(R.id.xp_accord9_tv_car_screen_color);
        this.mBtnScreenColorMinus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_color_minus);
        this.mBtnScreenColorMinus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.screenColor - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(21, new int[]{value}, null, null);
            }
        });
        this.mBtnScreenColorPlus = (Button) findViewById(R.id.xp_accord9_btn_car_screen_color_plus);
        this.mBtnScreenColorPlus.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = XBSAccord9ScreenActi.this.screenColor + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 4) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(21, new int[]{value}, null, null);
            }
        });
        this.mCtvCameraLinkageLamp = (CheckedTextView) findViewById(R.id.xp_ctv_camera_linkage_lamp);
        this.mCtvCameraLinkageLamp.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xbs.accord9.XBSAccord9ScreenActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = XBSAccord9ScreenActi.this.mCameraLinkageLamp == 1 ? 0 : 1;
                remoteModuleProxy.cmd(35, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 41 || DataCanbus.DATA[1000] == 65577 || DataCanbus.DATA[1000] == 410) {
            this.mView1.setVisibility(8);
            this.mView2.setVisibility(0);
            this.mView3.setVisibility(0);
            this.mView4.setVisibility(0);
            this.mView5.setVisibility(0);
        } else if (DataCanbus.DATA[1000] == 77 || DataCanbus.DATA[1000] == 131149 || DataCanbus.DATA[1000] == 65613 || DataCanbus.DATA[1000] == 196685 || DataCanbus.DATA[1000] == 262221) {
            this.mView1.setVisibility(0);
            this.mView2.setVisibility(8);
            this.mView3.setVisibility(8);
            this.mView4.setVisibility(8);
            this.mView5.setVisibility(8);
        }
        DataCanbus.PROXY.cmd(100, new int[]{11}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 410) {
            DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 410) {
            DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCameraLinkageLamp(int value) {
        if (this.mCtvCameraLinkageLamp != null) {
            this.mCtvCameraLinkageLamp.setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterScreenDisplay(int value) {
        if (this.mScreenDisplay != null) {
            switch (value) {
                case 0:
                    this.mScreenDisplay.setText(R.string.xp_accord9_car_screen_display_quanmie);
                    break;
                case 1:
                default:
                    this.mScreenDisplay.setText(R.string.xp_accord9_car_screen_display_normal);
                    break;
                case 2:
                    this.mScreenDisplay.setText(R.string.xp_accord9_car_screen_display_darken);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBrightness(int value) {
        if (this.mBrightness != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                this.mBrightness.setText("+" + value2);
            } else if (value2 == 0) {
                this.mBrightness.setText("0" + value2);
            } else {
                this.mBrightness.setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterContrast(int value) {
        if (this.mContrast != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                this.mContrast.setText("+" + value2);
            } else if (value2 == 0) {
                this.mContrast.setText("0" + value2);
            } else {
                this.mContrast.setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSaturation(int value) {
        if (this.mSaturations != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                this.mSaturations.setText("+" + value2);
            } else if (value2 == 0) {
                this.mSaturations.setText("0" + value2);
            } else {
                this.mSaturations.setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterScreenColor(int value) {
        if (this.mScreenColor != null) {
            switch (value) {
                case 0:
                    this.mScreenColor.setText(R.string.str_background_blue);
                    break;
                case 1:
                    this.mScreenColor.setText(R.string.str_background_amber);
                    break;
                case 2:
                    this.mScreenColor.setText(R.string.str_background_red);
                    break;
                case 3:
                    this.mScreenColor.setText(R.string.str_background_green);
                    break;
                default:
                    this.mScreenColor.setText(R.string.str_background_violet);
                    break;
            }
        }
    }
}