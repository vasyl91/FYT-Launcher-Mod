package com.syu.carinfo.rzc.sanlin;

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
public class LzInfiniteScreenCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LzInfiniteScreenCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    ((TextView) LzInfiniteScreenCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 101:
                    ((TextView) LzInfiniteScreenCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 102:
                    ((CheckedTextView) LzInfiniteScreenCarSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_lz_infinite_screen_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LzInfiniteScreenCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LzInfiniteScreenCarSet.this.language_set = position;
                if (LzInfiniteScreenCarSet.this.language_set >= 0 && LzInfiniteScreenCarSet.this.language_set <= LzInfiniteScreenCarSet.this.mLauStylelist.size() && LzInfiniteScreenCarSet.this.send_lang != null) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[5];
                    iArr[0] = LzInfiniteScreenCarSet.this.send_lang[LzInfiniteScreenCarSet.this.language_set];
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
                LzInfiniteScreenCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add("800*480_1");
        this.mLauStylelist.add("800*480_2");
        this.mLauStylelist.add("800*480_3");
        this.mLauStylelist.add("800*480_4");
        this.mLauStylelist.add("800*480_5");
        this.mLauStylelist.add("800*480_6");
        this.mLauStylelist.add("800*480_7");
        this.mLauStylelist.add("800*480_8");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LzInfiniteScreenCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LzInfiniteScreenCarSet.this.mLauStyle == null) {
                    LzInfiniteScreenCarSet.this.initLauStyle();
                }
                if (LzInfiniteScreenCarSet.this.mLauStyle != null && LzInfiniteScreenCarSet.this.mPopShowView != null) {
                    LzInfiniteScreenCarSet.this.mLauStyle.showAtLocation(LzInfiniteScreenCarSet.this.mPopShowView, 17, 0, 0);
                    LzInfiniteScreenCarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_plus12 /* 2131427436 */:
                int value2 = DataCanbus.DATA[100];
                if (value2 < 36) {
                    value2++;
                }
                setCarInfo(253, value2);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value3 = DataCanbus.DATA[101];
                if (value3 < 36) {
                    value3++;
                }
                setCarInfo(252, value3);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value4 = DataCanbus.DATA[100];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(253, value4);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int value5 = DataCanbus.DATA[101];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(252, value5);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                if (DataCanbus.DATA[102] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(244, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }
}
