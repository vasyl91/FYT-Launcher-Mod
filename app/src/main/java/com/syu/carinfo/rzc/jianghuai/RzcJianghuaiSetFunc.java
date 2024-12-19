package com.syu.carinfo.rzc.jianghuai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcJianghuaiSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 32:
                    RzcJianghuaiSetFunc.this.updateWinAutoDownOnoff(value);
                    break;
                case 47:
                    if (DataCanbus.DATA[1000] != 10879428 && DataCanbus.DATA[1000] != 10944964) {
                        RzcJianghuaiSetFunc.this.updateChargingmode(value);
                        break;
                    }
                case 58:
                    RzcJianghuaiSetFunc.this.updateTouchSensitivity(value);
                    break;
                case 59:
                    RzcJianghuaiSetFunc.this.updateOutSideLigtdelaytime(value);
                    break;
                case 60:
                    RzcJianghuaiSetFunc.this.updateInSideLigtdelaytime(value);
                    break;
                case 61:
                    RzcJianghuaiSetFunc.this.updateAutolockSpeed(value);
                    break;
                case 62:
                    RzcJianghuaiSetFunc.this.updateFortificationBeep(value);
                    break;
                case 63:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 64:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 65:
                    ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 66:
                    if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
                        RzcJianghuaiSetFunc.this.updateChargingmode(value);
                        break;
                    }
                case 73:
                    if (((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text8)).setText("途记宝抓拍");
                                break;
                            default:
                                ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text8)).setText("仪表返回");
                                break;
                        }
                    }
                    break;
                case 74:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 75:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 76:
                    if (((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 77:
                    if (((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 78:
                    if (((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append((value * 5) + 70).toString());
                        break;
                    }
                case 79:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 80:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_jianghuai_setfunc);
        if (DataCanbus.DATA[1000] == 2621879 && DataCanbus.DATA[1000] == 11338167 && DataCanbus.DATA[1000] == 11403703) {
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[32];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[63];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[64];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RzcJianghuaiSetFunc.this, RzcJianghuaiChargingTime.class);
                    RzcJianghuaiSetFunc.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[67];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{64, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[68];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{65, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[69];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{66, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[74];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{12, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[75];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{13, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[79];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[80];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
            }
        });
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.13
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[58] - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.14
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[58] + 1;
                    if (value > 2) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[59] - 1;
                    if (value < 0) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[59] + 1;
                    if (value > 4) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.17
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[60] - 1;
                    if (value < 0) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.18
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[60] + 1;
                    if (value > 4) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.19
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[61] - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[61] + 1;
                    if (value > 2) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[62] - 1;
                    if (value < 0) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[62] + 1;
                    if (value > 3) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.23
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[65];
                    if (value > 1) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.24
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[65];
                    if (value < 21) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.25
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[47] - 1;
                    if (value < 1) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.26
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[47] + 1;
                    if (value > 2) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.27
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[73] - 1;
                    if (value < 0) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.28
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[73] + 1;
                    if (value > 1) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.29
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[76] - 1;
                    if (value < 1) {
                        value = 5;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{14, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.30
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[76] + 1;
                    if (value > 5) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{14, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus10)) != null) {
            ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.31
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[77] - 1;
                    if (value < 1) {
                        value = 5;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus10)) != null) {
            ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.32
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[77] + 1;
                    if (value > 5) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus11)) != null) {
            ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.33
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[78];
                    if (value > 0) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus11)) != null) {
            ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiSetFunc.34
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[78];
                    if (value < 6) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFortificationBeep(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_onstar_nomal_status);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutolockSpeed(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("15km/h");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("40km/h");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInSideLigtdelaytime(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_227_headlight_3);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_time_1);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_time_2);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_time_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_time_12);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutSideLigtdelaytime(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_227_headlight_3);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_1);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_2);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_12);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTouchSensitivity(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChargingmode(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
                switch (value) {
                    case 2:
                        ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_charging_mode_set2);
                        break;
                    default:
                        ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_charging_mode_set1);
                        break;
                }
            }
            switch (value) {
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_charging_mode_set2);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_charging_mode_set1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWinAutoDownOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }
}
