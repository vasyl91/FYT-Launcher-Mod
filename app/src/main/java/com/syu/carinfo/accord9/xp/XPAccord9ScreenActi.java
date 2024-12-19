package com.syu.carinfo.accord9.xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XPAccord9ScreenActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 29:
                    XPAccord9ScreenActi.this.mUpdaterScreenDisplay();
                    break;
                case 30:
                    XPAccord9ScreenActi.this.mUpdaterBrightness();
                    break;
                case 31:
                    XPAccord9ScreenActi.this.mUpdaterContrast();
                    break;
                case 32:
                    XPAccord9ScreenActi.this.mUpdaterSaturation();
                    break;
                case 34:
                    XPAccord9ScreenActi.this.mUpdaterScreenColor();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_xp_screen);
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_display_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[29];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(66, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(66, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(66, new int[]{2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_display_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[29];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(66, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(66, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(66, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[30] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(67, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[30] + 1;
                if (value < 2) {
                    value = 2;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(67, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[31] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(68, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[31] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(68, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(69, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(69, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_color_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(65, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_color_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9ScreenActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[34] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(65, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 41 || DataCanbus.DATA[1000] == 65577) {
            findViewById(R.id.xp_accord9_view_screen_1).setVisibility(8);
            findViewById(R.id.xp_accord9_view_screen_2).setVisibility(0);
            findViewById(R.id.xp_accord9_view_screen_3).setVisibility(0);
            findViewById(R.id.xp_accord9_view_screen_4).setVisibility(0);
            findViewById(R.id.xp_accord9_view_screen_5).setVisibility(0);
        } else if (DataCanbus.DATA[1000] == 77 || DataCanbus.DATA[1000] == 131149 || DataCanbus.DATA[1000] == 65613 || DataCanbus.DATA[1000] == 196685 || DataCanbus.DATA[1000] == 262221) {
            findViewById(R.id.xp_accord9_view_screen_1).setVisibility(0);
            findViewById(R.id.xp_accord9_view_screen_2).setVisibility(8);
            findViewById(R.id.xp_accord9_view_screen_3).setVisibility(8);
            findViewById(R.id.xp_accord9_view_screen_4).setVisibility(8);
            findViewById(R.id.xp_accord9_view_screen_5).setVisibility(8);
        }
        DataCanbus.PROXY.cmd(100, new int[]{211}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterScreenDisplay() {
        int value = DataCanbus.DATA[29];
        if (((TextView) findViewById(R.id.xp_accord9_tv_car_screen_display)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_display)).setText(R.string.xp_accord9_car_screen_display_darken);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_display)).setText(R.string.xp_accord9_car_screen_display_quanmie);
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_display)).setText(R.string.xp_accord9_car_screen_display_normal);
                    break;
            }
        }
        if (value == 2) {
            if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)) != null) {
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)).setClickable(false);
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)).setBackgroundResource(R.drawable.ic_btn_minus_un);
            }
            if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)) != null) {
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)).setClickable(false);
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)).setBackgroundResource(R.drawable.ic_btn_plus_un);
            }
            if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)) != null) {
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)).setClickable(false);
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)).setBackgroundResource(R.drawable.ic_btn_minus_un);
            }
            if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)) != null) {
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)).setClickable(false);
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)).setBackgroundResource(R.drawable.ic_btn_plus_un);
            }
            if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)) != null) {
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)).setClickable(false);
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)).setBackgroundResource(R.drawable.ic_btn_minus_un);
            }
            if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)) != null) {
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)).setClickable(false);
                ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)).setBackgroundResource(R.drawable.ic_btn_plus_un);
                return;
            }
            return;
        }
        if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)) != null) {
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)).setClickable(true);
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)).setBackgroundResource(R.drawable.d_btn_minus);
        }
        if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)) != null) {
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)).setClickable(true);
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)).setBackgroundResource(R.drawable.d_btn_plus);
        }
        if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)) != null) {
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)).setClickable(true);
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)).setBackgroundResource(R.drawable.d_btn_minus);
        }
        if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)) != null) {
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)).setClickable(true);
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)).setBackgroundResource(R.drawable.d_btn_plus);
        }
        if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)) != null) {
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)).setClickable(true);
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)).setBackgroundResource(R.drawable.d_btn_minus);
        }
        if (((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)) != null) {
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)).setClickable(true);
            ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)).setBackgroundResource(R.drawable.d_btn_plus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBrightness() {
        int value = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.xp_accord9_tv_car_screen_brightness)) != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_brightness)).setText("+" + value2);
            } else if (value2 == 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_brightness)).setText("0" + value2);
            } else {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_brightness)).setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterContrast() {
        int value = DataCanbus.DATA[31];
        if (((TextView) findViewById(R.id.xp_accord9_tv_car_screen_contrast)) != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_contrast)).setText("+" + value2);
            } else if (value2 == 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_contrast)).setText("0" + value2);
            } else {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_contrast)).setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSaturation() {
        int value = DataCanbus.DATA[32];
        if (((TextView) findViewById(R.id.xp_accord9_tv_car_screen_saturation)) != null) {
            int value2 = value - 5;
            if (value2 > 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_saturation)).setText("+" + value2);
            } else if (value2 == 0) {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_saturation)).setText("0" + value2);
            } else {
                ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_saturation)).setText(new StringBuilder().append(value2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterScreenColor() {
        int value = DataCanbus.DATA[34];
        if (((TextView) findViewById(R.id.xp_accord9_tv_car_screen_color)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_color)).setText(R.string.str_background_red);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_color)).setText(R.string.str_background_violet);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_color)).setText(R.string.str_background_blue);
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_accord9_tv_car_screen_color)).setText(R.string.str_background_amber);
                    break;
            }
        }
    }
}
