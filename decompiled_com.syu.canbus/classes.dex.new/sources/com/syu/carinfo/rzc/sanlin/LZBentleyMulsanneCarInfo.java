package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_BBA_All;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZBentleyMulsanneCarInfo extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZBentleyMulsanneCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) LZBentleyMulsanneCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    break;
                case 100:
                    ((TextView) LZBentleyMulsanneCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                    break;
                case 101:
                    LZBentleyMulsanneCarInfo.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_bentley_mulsanne_carinfo);
        init();
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            findViewById(R.id.layout_view12).setVisibility(0);
        } else {
            findViewById(R.id.layout_view12).setVisibility(8);
        }
    }

    String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(String.valueOf(str) + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZBentleyMulsanneCarInfo.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZBentleyMulsanneCarInfo.this.language_set = position;
                if (LZBentleyMulsanneCarInfo.this.language_set >= 0 && LZBentleyMulsanneCarInfo.this.language_set <= LZBentleyMulsanneCarInfo.this.mLauStylelist.size() && LZBentleyMulsanneCarInfo.this.send_lang != null) {
                    DataMain.PROXY.cmd(36, new int[]{11, 4, 0, 0, 0}, null, null);
                    LZBentleyMulsanneCarInfo.this.setCarInfo(250, LZBentleyMulsanneCarInfo.this.language_set);
                    switch (LZBentleyMulsanneCarInfo.this.language_set) {
                        case 1:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            break;
                        case 2:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 4, 112, 0, 0}, null, null);
                            if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            break;
                    }
                }
                LZBentleyMulsanneCarInfo.this.mLauStyle.dismiss();
            }
        });
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[101];
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
        this.mLauStylelist.add("No select!");
        this.mLauStylelist.add("Audi 2009 A4L/Q5-H 800x480 T300");
        this.mLauStylelist.add("Audi 2009 A4L/Q5-H 800x480-1 T300");
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZBentleyMulsanneCarInfo.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZBentleyMulsanneCarInfo.this.mLauStyle == null) {
                    LZBentleyMulsanneCarInfo.this.initLauStyle();
                }
                if (LZBentleyMulsanneCarInfo.this.mLauStyle != null && LZBentleyMulsanneCarInfo.this.mPopShowView != null) {
                    LZBentleyMulsanneCarInfo.this.mLauStyle.showAtLocation(LZBentleyMulsanneCarInfo.this.mPopShowView, 17, 0, 0);
                    LZBentleyMulsanneCarInfo.this.updateLauguageSet();
                }
            }
        });
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
