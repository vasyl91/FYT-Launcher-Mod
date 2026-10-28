package com.syu.carinfo.rzc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Rzc_ZiYouguang_Light extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 102:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 106:
                    if (((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text1)).setText((value * 30) + "s");
                        break;
                    }
                case 107:
                    if (((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text2)).setText((value * 30) + "s");
                        break;
                    }
                case 127:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 128:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 142:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 155:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 159:
                    if (((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 160:
                    if (((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 166:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 182:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 198:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 199:
                    ((CheckedTextView) Rzc_ZiYouguang_Light.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_rzc_light);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[101];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{20, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[182];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{135, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[102];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{21, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[127];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[128];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{22, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[155];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{144, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[166];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{149, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[198];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{23, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[142];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{24, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[199];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{150, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[106] * 30;
                if (value2 >= 30) {
                    value = value2 - 30;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[106] * 30;
                if (value2 < 90) {
                    value = value2 + 30;
                } else {
                    value = 90;
                }
                DataCanbus.PROXY.cmd(2, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[107] * 30;
                if (value2 >= 30) {
                    value = value2 - 30;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[107] * 30;
                if (value2 < 90) {
                    value = value2 + 30;
                } else {
                    value = 90;
                }
                DataCanbus.PROXY.cmd(2, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] - 1;
                if (value <= 1) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{147, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] + 1;
                if (value >= 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{147, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[160] - 1;
                if (value <= 0) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{146, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[160] + 1;
                if (value >= 6) {
                    value = 6;
                }
                DataCanbus.PROXY.cmd(2, new int[]{146, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
    }
}
