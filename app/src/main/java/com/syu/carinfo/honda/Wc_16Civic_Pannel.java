package com.syu.carinfo.honda;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Wc_16Civic_Pannel extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 65:
                    Wc_16Civic_Pannel.this.m69D05();
                    break;
                case 66:
                    Wc_16Civic_Pannel.this.m69D04();
                    break;
                case 67:
                    Wc_16Civic_Pannel.this.m69D03();
                    break;
                case 68:
                    Wc_16Civic_Pannel.this.m69D02();
                    break;
                case 69:
                    Wc_16Civic_Pannel.this.m69D00();
                    break;
                case 70:
                    Wc_16Civic_Pannel.this.m69D15();
                    break;
                case 71:
                    Wc_16Civic_Pannel.this.m69D13();
                    break;
                case 72:
                    Wc_16Civic_Pannel.this.m69D10();
                    break;
                case 88:
                    Wc_16Civic_Pannel.this.m69D06();
                    break;
                case 102:
                    Wc_16Civic_Pannel.this.m69D17();
                    break;
                case 109:
                    ((CheckedTextView) Wc_16Civic_Pannel.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    if (val == 1) {
                        ((TextView) Wc_16Civic_Pannel.this.findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
                        break;
                    } else {
                        ((TextView) Wc_16Civic_Pannel.this.findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
                        break;
                    }
                case 110:
                    ((CheckedTextView) Wc_16Civic_Pannel.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
                    if (val == 1) {
                        ((TextView) Wc_16Civic_Pannel.this.findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_open);
                        break;
                    } else {
                        ((TextView) Wc_16Civic_Pannel.this.findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_close);
                        break;
                    }
                case 111:
                    ((TextView) Wc_16Civic_Pannel.this.findViewById(R.id.tv_text3)).setText("Type " + (val + 1));
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_pannel);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Wc_16Civic_Pannel.this.language_set = position;
                if (Wc_16Civic_Pannel.this.language_set >= 0 && Wc_16Civic_Pannel.this.language_set <= Wc_16Civic_Pannel.this.mLauStylelist.size() && Wc_16Civic_Pannel.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(112, new int[]{1, Wc_16Civic_Pannel.this.send_lang[Wc_16Civic_Pannel.this.language_set]}, null, null);
                }
                Wc_16Civic_Pannel.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{1, 2, 3};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Wc_16Civic_Pannel.this.mLauStyle == null) {
                    Wc_16Civic_Pannel.this.initLauStyle();
                }
                if (Wc_16Civic_Pannel.this.mLauStyle != null && Wc_16Civic_Pannel.this.mPopShowView != null) {
                    Wc_16Civic_Pannel.this.mLauStyle.showAtLocation(Wc_16Civic_Pannel.this.mPopShowView, 17, 0, 0);
                    Wc_16Civic_Pannel.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[109] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 16;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 15;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 13;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[88] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[65] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[66] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[67] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[68] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(106, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[69] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[69] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[70] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[70] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[71] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[71] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[72] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(106, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_Pannel.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[72] & 255;
                if (value2 < 7) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{1, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 262465 || DataCanbus.DATA[1000] == 786753 || DataCanbus.DATA[1000] == 852289) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 328001 || DataCanbus.DATA[1000] == 393537) {
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 721217) {
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
        } else {
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(8);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D17() {
        int temp = DataCanbus.DATA[102] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_right_picture_open);
        } else {
            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_right_picture_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D06() {
        int temp = DataCanbus.DATA[88] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D05() {
        int temp = DataCanbus.DATA[65] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D04() {
        int temp = DataCanbus.DATA[66] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D03() {
        int temp = DataCanbus.DATA[67] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D02() {
        int temp = DataCanbus.DATA[68] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D00() {
        int temp = DataCanbus.DATA[69] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.xp_accord9_auto_light_3higher);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.xp_accord9_auto_light_1lower);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D15() {
        int temp = DataCanbus.DATA[70] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.xp_accord9_with_refuel);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.klc_air_Manual);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D13() {
        int temp = DataCanbus.DATA[71] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.xp_accord9_with_refuel);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text12)).setText(R.string.klc_air_Manual);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m69D10() {
        int temp = DataCanbus.DATA[72] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text13)).setText("-3");
                return;
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text13)).setText("-2");
                return;
            }
            if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text13)).setText("-1");
            } else if (switchOn == 4) {
                ((TextView) findViewById(R.id.tv_text13)).setText("0");
            } else {
                ((TextView) findViewById(R.id.tv_text13)).setText(new StringBuilder().append(switchOn - 4).toString());
            }
        }
    }
}
