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

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcJianghuaiSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    RzcJianghuaiSetFunc.this.updateWinAutoDownOnoff(value);
                    break;
                case 111:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 125:
                    if (DataCanbus.DATA[1000] != 10879428 && DataCanbus.DATA[1000] != 10944964) {
                        RzcJianghuaiSetFunc.this.updateChargingmode(value);
                        break;
                    }
                case 136:
                    RzcJianghuaiSetFunc.this.updateTouchSensitivity(value);
                    break;
                case 137:
                    RzcJianghuaiSetFunc.this.updateOutSideLigtdelaytime(value);
                    break;
                case 138:
                    RzcJianghuaiSetFunc.this.updateInSideLigtdelaytime(value);
                    break;
                case 139:
                    RzcJianghuaiSetFunc.this.updateAutolockSpeed(value);
                    break;
                case 140:
                    RzcJianghuaiSetFunc.this.updateFortificationBeep(value);
                    break;
                case 141:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 142:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 143:
                    ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 144:
                    if (DataCanbus.DATA[1000] == 10879428 || DataCanbus.DATA[1000] == 10944964) {
                        RzcJianghuaiSetFunc.this.updateChargingmode(value);
                        break;
                    }
                case 145:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 146:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 147:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 148:
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
                case 149:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
                    break;
                case 150:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value == 1);
                    break;
                case 151:
                    if (((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 152:
                    if (((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 153:
                    if (((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) RzcJianghuaiSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append((value * 5) + 70).toString());
                        break;
                    }
                case 154:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value == 1);
                    break;
                case 155:
                    ((CheckedTextView) RzcJianghuaiSetFunc.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_jianghuai_setfunc);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[110];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[141];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[142];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[145];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{64, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[146];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{65, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[147];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{66, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[149];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{12, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[150];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{13, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[154];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[155];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[111];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[136] - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[136] + 1;
                    if (value > 2) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[137] - 1;
                    if (value < 0) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[137] + 1;
                    if (value > 4) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus3)) != null) {
            ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[138] - 1;
                    if (value < 0) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus3)) != null) {
            ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[138] + 1;
                    if (value > 4) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus4)) != null) {
            ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[139] - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus4)) != null) {
            ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[139] + 1;
                    if (value > 2) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus5)) != null) {
            ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[140] - 1;
                    if (value < 0) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus5)) != null) {
            ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[140] + 1;
                    if (value > 3) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[143];
                    if (value > 1) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[143];
                    if (value < 21) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[125] - 1;
                    if (value < 1) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[125] + 1;
                    if (value > 2) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[148] - 1;
                    if (value < 0) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[148] + 1;
                    if (value > 1) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[151] - 1;
                    if (value < 1) {
                        value = 5;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{14, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[151] + 1;
                    if (value > 5) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{14, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus10)) != null) {
            ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[152] - 1;
                    if (value < 1) {
                        value = 5;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus10)) != null) {
            ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[152] + 1;
                    if (value > 5) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{15, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus11)) != null) {
            ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[153];
                    if (value > 0) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus11)) != null) {
            ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[153];
                    if (value < 6) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{16, value}, null, null);
                }
            });
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
    }

    
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

    
    public void updateWinAutoDownOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }
}
