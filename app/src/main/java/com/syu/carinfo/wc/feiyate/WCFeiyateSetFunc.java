package com.syu.carinfo.wc.feiyate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCFeiyateSetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 100:
                    WCFeiyateSetFunc.this.updateMileUnit(value);
                    break;
                case 101:
                    WCFeiyateSetFunc.this.updateOilUnit(value);
                    break;
                case 102:
                    WCFeiyateSetFunc.this.updateTempUnit(value);
                    break;
                case 103:
                    WCFeiyateSetFunc.this.updateAutoLockOnoff(value);
                    break;
                case 104:
                    WCFeiyateSetFunc.this.updateDayLightOnoff(value);
                    break;
                case 105:
                    WCFeiyateSetFunc.this.updateTripBOnoff(value);
                    break;
                case 106:
                    WCFeiyateSetFunc.this.updateMeasureUnit(value);
                    break;
                case 107:
                    WCFeiyateSetFunc.this.setCheck((CheckedTextView) WCFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 108:
                    WCFeiyateSetFunc.this.updateParkVol(value);
                    break;
                case 109:
                    WCFeiyateSetFunc.this.setCheck((CheckedTextView) WCFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 110:
                    WCFeiyateSetFunc.this.setCheck((CheckedTextView) WCFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 111:
                    WCFeiyateSetFunc.this.setCheck((CheckedTextView) WCFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 112:
                    WCFeiyateSetFunc.this.updateParkSense(value);
                    break;
                case 113:
                    WCFeiyateSetFunc.this.setCheck((CheckedTextView) WCFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 114:
                    WCFeiyateSetFunc.this.updateHeadLightDelay(value);
                    break;
                case 115:
                    WCFeiyateSetFunc.this.updateCourtesyLightDelay(value);
                    break;
                case 116:
                    WCFeiyateSetFunc.this.updateLauguageSet();
                    break;
                case 117:
                    if (((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value + 1).toString());
                        break;
                    }
                case 118:
                    WCFeiyateSetFunc.this.setCheck((CheckedTextView) WCFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 139:
                    if (((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text10)).setText("bar");
                                break;
                            case 2:
                                ((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text10)).setText("psi");
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text10)).setText("kPa");
                                break;
                        }
                    }
                    break;
                case 140:
                    WCFeiyateSetFunc.this.setCheck((CheckedTextView) WCFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext10), value != 0);
                    break;
                case 141:
                    if (((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) WCFeiyateSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                WCFeiyateSetFunc.this.language_set = position;
                if (WCFeiyateSetFunc.this.language_set >= 0 && WCFeiyateSetFunc.this.language_set <= WCFeiyateSetFunc.this.mLauStylelist.size() && WCFeiyateSetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{1, WCFeiyateSetFunc.this.send_lang[WCFeiyateSetFunc.this.language_set]}, null, null);
                }
                WCFeiyateSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[116];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_feiyate_setfunc);
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.send_lang = new int[]{1, 3, 4, 5, 7, 8, 9, 16, 18, 21, 29};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WCFeiyateSetFunc.this.mLauStyle == null) {
                    WCFeiyateSetFunc.this.initLauStyle();
                }
                if (WCFeiyateSetFunc.this.mLauStyle != null && WCFeiyateSetFunc.this.mPopShowView != null) {
                    WCFeiyateSetFunc.this.mLauStyle.showAtLocation(WCFeiyateSetFunc.this.mPopShowView, 17, 0, 0);
                    WCFeiyateSetFunc.this.updateLauguageSet();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[106] & 255) - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[106] & 255) + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[112] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[114] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[114] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[115] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[115] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{25, value}, null, null);
            }
        });
        if (((Button) findViewById(R.id.btn_minus6)) != null) {
            ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.14
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value;
                    int value2 = DataCanbus.DATA[100] & 255;
                    if (value2 == 1) {
                        value = 2;
                    } else {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus6)) != null) {
            ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.15
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value;
                    int value2 = DataCanbus.DATA[100] & 255;
                    if (value2 == 1) {
                        value = 2;
                    } else {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus7)) != null) {
            ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.16
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value;
                    int value2 = DataCanbus.DATA[102] & 255;
                    if (value2 == 1) {
                        value = 2;
                    } else {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus7)) != null) {
            ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.17
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value;
                    int value2 = DataCanbus.DATA[102] & 255;
                    if (value2 == 1) {
                        value = 2;
                    } else {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus8)) != null) {
            ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.18
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = ((DataCanbus.DATA[101] + 1) & 255) - 1;
                    if (value < 1) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus8)) != null) {
            ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.19
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = ((DataCanbus.DATA[101] + 1) & 255) + 1;
                    if (value > 4) {
                        value = 1;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus9)) != null) {
            ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.20
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[117] - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{26, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus9)) != null) {
            ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.21
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[117] + 1;
                    if (value > 2) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{26, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus10)) != null) {
            ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.22
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[139] & 255) - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus10)) != null) {
            ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.23
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = (DataCanbus.DATA[139] & 255) + 1;
                    if (value > 2) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus11)) != null) {
            ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.24
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[141];
                    if (value > 0) {
                        value--;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{10, value}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus11)) != null) {
            ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.25
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[141];
                    if (value < 5) {
                        value++;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{10, value}, null, null);
                }
            });
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[107];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{22, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[111];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[110];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{21, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[113];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{24, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[103];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[104];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{27, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[140];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WCFeiyateSetFunc.this.dialog(R.string.lights_set, 32);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WCFeiyateSetFunc.this.dialog(R.string.driver_assistance_settings, 33);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WCFeiyateSetFunc.this.dialog(R.string.str_door_lock, 34);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WCFeiyateSetFunc.this.dialog(R.string.str_107_str1, 35);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WCFeiyateSetFunc.this.dialog(R.string.str_dongjian_wc2_ds5_car_computer_unit_set, 36);
            }
        });
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.41
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.41.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.42
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateSetFunc.42.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripBOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDayLightOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLockOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOilUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("km/l");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("mpg(us)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText("mpg(uk)");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText("l/100km");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCourtesyLightDelay(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("60s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text5)).setText("90s");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText("0s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeadLightDelay(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("60s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText("90s");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText("0s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParkSense(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_1);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParkVol(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_372_mid);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_372_high);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_372_low);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMeasureUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Metric");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Custom");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Imperial");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText("℃");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText("℉");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMileUnit(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_format_set1);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_format_set0);
                    break;
            }
        }
    }
}
