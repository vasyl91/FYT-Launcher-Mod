package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Bg_ZiYouguang_Other extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    Bg_ZiYouguang_Other.this.mpower_off_delay();
                    break;
                case 111:
                    Bg_ZiYouguang_Other.this.mComfortSystens();
                    break;
                case 113:
                    Bg_ZiYouguang_Other.this.mCompassOffset();
                    break;
                case 114:
                    Bg_ZiYouguang_Other.this.mFormatSet();
                    break;
                case 115:
                    Bg_ZiYouguang_Other.this.mLanguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_other);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[107];
                switch (value) {
                    case 0:
                        value = 3;
                        break;
                    case 1:
                        value = 20;
                        break;
                    case 2:
                        value = 40;
                        break;
                    case 3:
                        value = 0;
                        break;
                }
                DataCanbus.PROXY.cmd(2, new int[]{50, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[107];
                switch (value) {
                    case 0:
                        value = 40;
                        break;
                    case 1:
                        value = 0;
                        break;
                    case 2:
                        value = 3;
                        break;
                    case 3:
                        value = 20;
                        break;
                }
                DataCanbus.PROXY.cmd(2, new int[]{50, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{66, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113];
                if (value < 15) {
                    value++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{66, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{82, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{82, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115];
                if (value2 == 0) {
                    value = 9;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{83, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115];
                if (value2 == 0) {
                    value = 9;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{83, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[111];
                if (value2 == 0) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{35, value}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    
    public void mComfortSystens() {
        int value = DataCanbus.DATA[111];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    
    public void mpower_off_delay() {
        int value = DataCanbus.DATA[107];
        if (findViewById(R.id.tv_text4) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(value + "s");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText("45s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText("5Min");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text4)).setText("10Min");
            }
        }
    }

    
    public void mCompassOffset() {
        int value = DataCanbus.DATA[113];
        if (findViewById(R.id.tv_text1) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value));
        }
    }

    
    public void mFormatSet() {
        int value = DataCanbus.DATA[114];
        if (findViewById(R.id.tv_text2) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_format_set1);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_format_set0);
            }
        }
    }

    
    public void mLanguageSet() {
        int value = DataCanbus.DATA[115];
        if (findViewById(R.id.tv_text3) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_language_set1);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_language_set0);
            }
        }
    }
}
