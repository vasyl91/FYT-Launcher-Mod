package com.syu.carinfo.golf7;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7FunctionalHundongInfo1Acti extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 336:
                    Golf7FunctionalHundongInfo1Acti.this.updateLauguageSet();
                    Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view12), false);
                    Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view13), false);
                    Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view14), false);
                    Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view15), false);
                    if (value == 1) {
                        Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view12), true);
                        break;
                    } else if (value != 2 && value != 3) {
                        if (value == 4) {
                            Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view12), true);
                            Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view13), true);
                            Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view14), true);
                            Golf7FunctionalHundongInfo1Acti.this.setViewVisible(Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.layout_view15), true);
                            break;
                        } else if (value == 5) {
                        }
                    }
                    break;
                case 349:
                    String strid = "5A";
                    if (((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 1) {
                            strid = "10A";
                        } else if (value == 2) {
                            strid = "13A";
                        } else if (value == 3) {
                            strid = "MAX";
                        }
                        ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text6)).setText(strid);
                    }
                    break;
                case 350:
                    Golf7FunctionalHundongInfo1Acti.this.setCheck((CheckedTextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 351:
                    if (((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 352:
                    if (((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text7)) != null) {
                        if (value < 60) {
                            ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text7)).setText("LO");
                        } else if (value > 195 || value == 255) {
                            ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text7)).setText("HI");
                        } else {
                            int value2 = value + 100;
                            ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
                        }
                    }
                    break;
                case 486:
                    if (((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text9)).setText("4%");
                                break;
                            case 1:
                                ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text9)).setText("15%");
                                break;
                            case 2:
                                ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text9)).setText("35%");
                                break;
                            case 3:
                                ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text9)).setText("55%");
                                break;
                            case 4:
                                ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text9)).setText("75%");
                                break;
                            case 5:
                                ((TextView) Golf7FunctionalHundongInfo1Acti.this.findViewById(R.id.tv_text9)).setText("100%");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_hundong_info);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage4, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Golf7FunctionalHundongInfo1Acti.this.language_set = position;
                if (Golf7FunctionalHundongInfo1Acti.this.language_set >= 0 && Golf7FunctionalHundongInfo1Acti.this.language_set <= Golf7FunctionalHundongInfo1Acti.this.mLauStylelist.size() && Golf7FunctionalHundongInfo1Acti.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(160, new int[]{240, Golf7FunctionalHundongInfo1Acti.this.send_lang[Golf7FunctionalHundongInfo1Acti.this.language_set]}, null, null);
                }
                Golf7FunctionalHundongInfo1Acti.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[336];
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

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.str_17_driver_e_mode));
        this.mLauStylelist.add(getResources().getString(R.string.str_17_driver_hybrid_power_mode));
        this.mLauStylelist.add(getResources().getString(R.string.str_17_driver_battery_maintain_mode));
        this.mLauStylelist.add(getResources().getString(R.string.str_17_driver_battery_charge_mode));
        this.mLauStylelist.add(getResources().getString(R.string.str_hybird_electric_pages));
        this.mLauStylelist.add(getResources().getString(R.string.str_17_driver_gte_mode));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Golf7FunctionalHundongInfo1Acti.this.mLauStyle == null) {
                    Golf7FunctionalHundongInfo1Acti.this.initLauStyle();
                }
                if (Golf7FunctionalHundongInfo1Acti.this.mLauStyle != null && Golf7FunctionalHundongInfo1Acti.this.mPopShowView != null) {
                    Golf7FunctionalHundongInfo1Acti.this.mLauStyle.showAtLocation(Golf7FunctionalHundongInfo1Acti.this.mPopShowView, 17, 0, 0);
                    Golf7FunctionalHundongInfo1Acti.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[349] & 255) - 1;
                if (val < 0) {
                    val = 3;
                }
                DataCanbus.PROXY.cmd(160, new int[]{241, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[349] & 255) + 1;
                if (val > 3) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(160, new int[]{241, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[352] & 255;
                if (val > 60 && val <= 195 && val != 255) {
                    val -= 5;
                } else if (val > 195 || val == 255) {
                    val = 195;
                } else if (val <= 60) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(160, new int[]{242, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[352] & 255;
                if (val >= 60 && val < 195 && val != 255) {
                    val += 5;
                } else if (val >= 195) {
                    val = 255;
                } else if (val < 60) {
                    val = 60;
                }
                DataCanbus.PROXY.cmd(160, new int[]{242, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[351] & 255) - 10;
                if (val < 10) {
                    val = 10;
                }
                DataCanbus.PROXY.cmd(160, new int[]{244, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[351] & 255) + 10;
                if (val > 100) {
                    val = 100;
                }
                DataCanbus.PROXY.cmd(160, new int[]{244, val}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[350] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 243;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(160, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(160, new int[]{240, 240}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(160, new int[]{240, 241}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(160, new int[]{240, 242}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(160, new int[]{245, 0}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalHundongInfo1Acti.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(160, new int[]{245, 1}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(98, new int[]{6}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[336].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[486].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[349].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[350].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[351].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[352].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[336].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[486].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[349].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[350].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[351].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[352].removeNotify(this.mNotifyCanbus);
    }
}
