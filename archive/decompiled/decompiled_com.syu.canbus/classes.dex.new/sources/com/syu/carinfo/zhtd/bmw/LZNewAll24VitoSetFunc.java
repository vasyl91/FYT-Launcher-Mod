package com.syu.carinfo.zhtd.bmw;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZNewAll24VitoSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAll24VitoSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                    ((TextView) LZNewAll24VitoSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 110:
                    ((TextView) LZNewAll24VitoSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 111:
                    ((CheckedTextView) LZNewAll24VitoSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 112:
                    LZNewAll24VitoSetFunc.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lz_24vito_screen_setfunc);
        init();
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage2, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAll24VitoSetFunc.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewAll24VitoSetFunc.this.language_set = position;
                if (LZNewAll24VitoSetFunc.this.language_set >= 0 && LZNewAll24VitoSetFunc.this.language_set <= LZNewAll24VitoSetFunc.this.mLauStylelist.size() && LZNewAll24VitoSetFunc.this.send_lang != null) {
                    LZNewAll24VitoSetFunc.this.setCarInfo(5, LZNewAll24VitoSetFunc.this.send_lang[LZNewAll24VitoSetFunc.this.language_set]);
                }
                LZNewAll24VitoSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[112];
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

    private void updatemLauStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add("1920*720 1");
        this.mLauStylelist.add("1920*720 2");
        this.send_lang = new int[]{1, 2};
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        updatemLauStylelist();
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAll24VitoSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZNewAll24VitoSetFunc.this.mLauStyle == null) {
                    LZNewAll24VitoSetFunc.this.initLauStyle();
                }
                if (LZNewAll24VitoSetFunc.this.mLauStyle != null && LZNewAll24VitoSetFunc.this.mPopShowView != null) {
                    LZNewAll24VitoSetFunc.this.mLauStyle.showAtLocation(LZNewAll24VitoSetFunc.this.mPopShowView, 17, 0, 0);
                    LZNewAll24VitoSetFunc.this.updateLauguageSet();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus12 /* 2131427489 */:
                int value2 = DataCanbus.DATA[109];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(253, value2);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value3 = DataCanbus.DATA[109];
                if (value3 < 36) {
                    value3++;
                }
                setCarInfo(253, value3);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value4 = DataCanbus.DATA[110];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(252, value4);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value5 = DataCanbus.DATA[110];
                if (value5 < 36) {
                    value5++;
                }
                setCarInfo(252, value5);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[111] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(247, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
    }
}
