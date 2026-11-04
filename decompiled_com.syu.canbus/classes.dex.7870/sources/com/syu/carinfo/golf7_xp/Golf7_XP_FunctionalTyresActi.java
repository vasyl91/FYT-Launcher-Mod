package com.syu.carinfo.golf7_xp;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalTyresActi extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 124:
                    Golf7_XP_FunctionalTyresActi.this.mUpdaterTyresSpeedWarnning();
                    break;
                case 125:
                    Golf7_XP_FunctionalTyresActi.this.mUpdaterTyresSpeedWarnningValue();
                    break;
                case 225:
                    Golf7_XP_FunctionalTyresActi.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_tyres_setting);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Golf7_XP_FunctionalTyresActi.this.language_set = position;
                if (Golf7_XP_FunctionalTyresActi.this.language_set >= 0 && Golf7_XP_FunctionalTyresActi.this.language_set <= Golf7_XP_FunctionalTyresActi.this.mLauStylelist.size() && Golf7_XP_FunctionalTyresActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(107, new int[]{35, Golf7_XP_FunctionalTyresActi.this.send_lang[Golf7_XP_FunctionalTyresActi.this.language_set]}, null, null);
                }
                Golf7_XP_FunctionalTyresActi.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[225];
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
        this.mLauStylelist.add(getResources().getString(R.string.str_driving_comfort));
        this.mLauStylelist.add(getResources().getString(R.string.driver_system_standard));
        this.mLauStylelist.add(getResources().getString(R.string.str_tuang_str1));
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Golf7_XP_FunctionalTyresActi.this.mLauStyle == null) {
                    Golf7_XP_FunctionalTyresActi.this.initLauStyle();
                }
                if (Golf7_XP_FunctionalTyresActi.this.mLauStyle != null && Golf7_XP_FunctionalTyresActi.this.mPopShowView != null) {
                    Golf7_XP_FunctionalTyresActi.this.mLauStyle.showAtLocation(Golf7_XP_FunctionalTyresActi.this.mPopShowView, 17, 0, 0);
                    Golf7_XP_FunctionalTyresActi.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalTyresActi.this.dialog();
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 32;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] & 255;
                int unit = (65280 & value) >> 8;
                int mValue = value & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value > 240) {
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
                DataCanbus.PROXY.cmd(107, new int[]{33, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] & 255;
                int unit = (65280 & value) >> 8;
                int mValue = value & 255;
                if (unit == 0) {
                    if (mValue < 30) {
                        mValue = 30;
                    } else if (value > 240) {
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
                DataCanbus.PROXY.cmd(107, new int[]{33, mValue}, null, null);
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.reset_tpms));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(107, new int[]{34, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalTyresActi.9
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
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTyresSpeedWarnning() {
        int value = DataCanbus.DATA[124];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTyresSpeedWarnningValue() {
        int value = DataCanbus.DATA[125];
        int unit = (65280 & value) >> 8;
        int mValue = value & 255;
        if (unit == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(mValue) + "km/h");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(mValue) + "mph");
        }
    }
}
