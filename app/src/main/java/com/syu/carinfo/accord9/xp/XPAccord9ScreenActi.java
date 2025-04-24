package com.syu.carinfo.accord9.xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XPAccord9ScreenActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 127:
                    XPAccord9ScreenActi.this.mUpdaterScreenDisplay();
                    break;
                case 128:
                    XPAccord9ScreenActi.this.mUpdaterBrightness();
                    break;
                case 129:
                    XPAccord9ScreenActi.this.mUpdaterContrast();
                    break;
                case 130:
                    XPAccord9ScreenActi.this.mUpdaterSaturation();
                    break;
                case 132:
                    XPAccord9ScreenActi.this.mUpdaterScreenColor();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_accord9_xp_screen);
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_display_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(66, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(66, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(66, new int[]{2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_display_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(66, new int[]{1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(66, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(66, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(67, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_brightness_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128] + 1;
                if (value < 2) {
                    value = 2;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(67, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(68, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_contrast_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(68, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(69, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_saturation_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 10) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(69, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_color_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(65, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_btn_car_screen_color_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(65, new int[]{value}, null, null);
            }
        });
    }

    @Override
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterScreenDisplay() {
        int value = DataCanbus.DATA[127];
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

    
    public void mUpdaterBrightness() {
        int value = DataCanbus.DATA[128];
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

    
    public void mUpdaterContrast() {
        int value = DataCanbus.DATA[129];
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

    
    public void mUpdaterSaturation() {
        int value = DataCanbus.DATA[130];
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

    
    public void mUpdaterScreenColor() {
        int value = DataCanbus.DATA[132];
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
