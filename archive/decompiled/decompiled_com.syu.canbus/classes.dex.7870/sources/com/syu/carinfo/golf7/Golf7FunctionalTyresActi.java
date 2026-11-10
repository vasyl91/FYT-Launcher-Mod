package com.syu.carinfo.golf7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Golf7FunctionalTyresActi extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 124:
                    Golf7FunctionalTyresActi.this.mUpdaterTyresSpeedWarnning();
                    break;
                case 125:
                    Golf7FunctionalTyresActi.this.mUpdaterTyresSpeedWarnningValue();
                    break;
                case 253:
                    if ((DataCanbus.DATA[1000] & 65535) == 17) {
                        int enable = (DataCanbus.DATA[updateCode] & 65280) >> 8;
                        Golf7FunctionalTyresActi.this.setViewVisible(Golf7FunctionalTyresActi.this.findViewById(R.id.layout_view3), enable != 0);
                    }
                    Golf7FunctionalTyresActi.this.updateLauguageSet();
                    break;
            }
        }
    };
    int language_set = 255;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.layout_golf7_functional_state_tyres_setting_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_tyres_setting);
        }
        init();
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.reset_tpms));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(45, null, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTyresSpeedWarnning() {
        int value = DataCanbus.DATA[124];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view1), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), switchOn != 0);
            if (enable != 0) {
                setViewVisible(findViewById(R.id.layout_view2), switchOn != 0);
                return;
            } else {
                setViewVisible(findViewById(R.id.layout_view2), true);
                return;
            }
        }
        setViewVisible(findViewById(R.id.layout_view1), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), value != 0);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Golf7FunctionalTyresActi.this.language_set = position;
                if (Golf7FunctionalTyresActi.this.language_set >= 0 && Golf7FunctionalTyresActi.this.language_set <= Golf7FunctionalTyresActi.this.mLauStylelist.size() && Golf7FunctionalTyresActi.this.send_lang != null) {
                    if ((DataCanbus.DATA[1000] & 65535) == 17) {
                        DataCanbus.PROXY.cmd(114, new int[]{Golf7FunctionalTyresActi.this.send_lang[Golf7FunctionalTyresActi.this.language_set]}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(103, new int[]{35, Golf7FunctionalTyresActi.this.send_lang[Golf7FunctionalTyresActi.this.language_set]}, null, null);
                    }
                }
                Golf7FunctionalTyresActi.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[253] & 255;
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
        if ((DataCanbus.DATA[1000] & 65535) == 17) {
            this.mLauStylelist.add(getResources().getString(R.string.driver_system_standard));
            this.mLauStylelist.add(getResources().getString(R.string.str_driving_comfort));
            this.mLauStylelist.add(getResources().getString(R.string.str_tuang_str1));
        } else {
            this.mLauStylelist.add(getResources().getString(R.string.str_driving_comfort));
            this.mLauStylelist.add(getResources().getString(R.string.driver_system_standard));
            this.mLauStylelist.add(getResources().getString(R.string.str_tuang_str1));
        }
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Golf7FunctionalTyresActi.this.mLauStyle == null) {
                    Golf7FunctionalTyresActi.this.initLauStyle();
                }
                if (Golf7FunctionalTyresActi.this.mLauStyle != null && Golf7FunctionalTyresActi.this.mPopShowView != null) {
                    Golf7FunctionalTyresActi.this.mLauStyle.showAtLocation(Golf7FunctionalTyresActi.this.mPopShowView, 17, 0, 0);
                    Golf7FunctionalTyresActi.this.updateLauguageSet();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalTyresActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalTyresActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7FunctionalTyresActi.this.dialog();
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(46, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ConstGolf.isWcGolf()) {
                    int value = DataCanbus.DATA[125] & 255;
                    if (value < 30) {
                        value = 30;
                    } else if (value > 240) {
                        value = 240;
                    }
                    if (value > 30) {
                        value -= 10;
                    }
                    DataCanbus.PROXY.cmd(47, new int[]{value}, null, null);
                    return;
                }
                int value2 = DataCanbus.DATA[125] & 255;
                int unit = (65280 & value2) >> 8;
                int mValue = value2 & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value2 > 240) {
                        mValue = 240;
                    }
                    if (mValue > 30) {
                        mValue -= 10;
                    }
                } else {
                    if (mValue < 20) {
                        mValue = 20;
                    } else if (mValue > 150) {
                        mValue = 150;
                    }
                    if (mValue > 20) {
                        mValue -= 5;
                    }
                }
                DataCanbus.PROXY.cmd(47, new int[]{mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalTyresActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ConstGolf.isWcGolf()) {
                    int value = DataCanbus.DATA[125] & 255;
                    if (value < 30) {
                        value = 30;
                    } else if (value > 240) {
                        value = 240;
                    }
                    if (value < 240) {
                        value += 10;
                    }
                    DataCanbus.PROXY.cmd(47, new int[]{value}, null, null);
                    return;
                }
                int value2 = DataCanbus.DATA[125] & 255;
                int unit = (65280 & value2) >> 8;
                int mValue = value2 & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value2 > 240) {
                        mValue = 240;
                    }
                    if (mValue < 240) {
                        mValue += 10;
                    }
                } else {
                    if (mValue < 20) {
                        mValue = 20;
                    } else if (mValue > 150) {
                        mValue = 150;
                    }
                    if (mValue < 150) {
                        mValue += 5;
                    }
                }
                DataCanbus.PROXY.cmd(47, new int[]{mValue}, null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTyresSpeedWarnningValue() {
        int value = DataCanbus.DATA[125];
        int unit = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(mValue) + "km/h");
        } else if (unit == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(mValue) + "km/h");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(mValue) + "mph");
        }
    }
}
