package com.syu.carinfo.sbd.fordlieying;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class InfoSBDFordLieYing extends BaseActivity {
    public static boolean mIsFront = false;
    Handler mHandler;
    public int value_max_1 = 200;
    public int value_max_2 = 200;
    public int value_max_3 = 200;
    public int value_min_1 = 0;
    public int value_min_2 = 0;
    public int value_min_3 = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.sbd.fordlieying.InfoSBDFordLieYing.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    if (strs != null) {
                        ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digital1)).setText(strs[0]);
                        InfoSBDFordLieYing.this.setShowWarningConfig("TABLE_STR_1", strs[0]);
                        break;
                    }
                case 1:
                    if (strs != null) {
                        ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digital2)).setText(strs[0]);
                        InfoSBDFordLieYing.this.setShowWarningConfig("TABLE_STR_2", strs[0]);
                        break;
                    }
                case 2:
                    if (strs != null) {
                        ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digital3)).setText(strs[0]);
                        InfoSBDFordLieYing.this.setShowWarningConfig("TABLE_STR_3", strs[0]);
                        break;
                    }
                case 3:
                    int value_1 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView1)).setSpeed(value_1);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digitalvalue1)).setText(String.valueOf(value_1) + ".0");
                    break;
                case 4:
                    int value_2 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView2)).setSpeed(value_2);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digitalvalue2)).setText(String.valueOf(value_2) + ".0");
                    break;
                case 5:
                    int value_3 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView3)).setSpeed(value_3);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digitalvalue3)).setText(String.valueOf(value_3) + ".0");
                    break;
                case 6:
                    if (DataCanbus.DATA[updateCode] > InfoSBDFordLieYing.this.value_min_1) {
                        InfoSBDFordLieYing.this.value_max_1 = DataCanbus.DATA[updateCode];
                        ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView1)).setMax(InfoSBDFordLieYing.this.value_max_1);
                    }
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_5)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 7:
                    if (DataCanbus.DATA[updateCode] > InfoSBDFordLieYing.this.value_min_2) {
                        InfoSBDFordLieYing.this.value_max_2 = DataCanbus.DATA[updateCode];
                        ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView2)).setMax(InfoSBDFordLieYing.this.value_max_2);
                    }
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_5)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 8:
                    if (DataCanbus.DATA[updateCode] > InfoSBDFordLieYing.this.value_min_3) {
                        InfoSBDFordLieYing.this.value_max_3 = DataCanbus.DATA[updateCode];
                        ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView3)).setMax(InfoSBDFordLieYing.this.value_max_3);
                    }
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_5)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 9:
                    InfoSBDFordLieYing.this.value_min_1 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView1)).setMin(InfoSBDFordLieYing.this.value_min_1);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_1)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 10:
                    InfoSBDFordLieYing.this.value_min_2 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView2)).setMin(InfoSBDFordLieYing.this.value_min_2);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_1)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 11:
                    InfoSBDFordLieYing.this.value_min_3 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView3)).setMin(InfoSBDFordLieYing.this.value_min_3);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_1)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 12:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_2)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 13:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_3)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 14:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_4)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 15:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_2)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 16:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_3)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 17:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_4)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 18:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_2)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 19:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_3)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 20:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_4)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_398_fordlieying_info);
        initView();
        this.mHandler = new Handler();
    }

    private void initView() {
        requestDigitalInfo(48);
        requestDigitalInfo(49);
        requestDigitalInfo(50);
        if (getShowWarningConfig("TABLE_STR_1") != null) {
            ((TextView) findViewById(R.id.tv_digital1)).setText(getShowWarningConfig("TABLE_STR_1"));
        }
        if (getShowWarningConfig("TABLE_STR_2") != null) {
            ((TextView) findViewById(R.id.tv_digital2)).setText(getShowWarningConfig("TABLE_STR_2"));
        }
        if (getShowWarningConfig("TABLE_STR_3") != null) {
            ((TextView) findViewById(R.id.tv_digital3)).setText(getShowWarningConfig("TABLE_STR_3"));
        }
        this.value_max_1 = getMaxConfig("TABLE_MAX_INT_1", this.value_max_1);
        this.value_max_2 = getMaxConfig("TABLE_MAX_INT_2", this.value_max_2);
        this.value_max_3 = getMaxConfig("TABLE_MAX_INT_3", this.value_max_3);
        this.value_min_1 = getMaxConfig("TABLE_MIN_INT_1", this.value_min_1);
        this.value_min_2 = getMaxConfig("TABLE_MIN_INT_2", this.value_min_2);
        this.value_min_3 = getMaxConfig("TABLE_MIN_INT_3", this.value_min_3);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        requestDigitalInfo(48);
        requestDigitalInfo(49);
        requestDigitalInfo(50);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
        DataCanbus.PROXY.cmd(1, 255);
    }

    private void requestDigitalInfo(int cmd) {
        DataCanbus.PROXY.cmd(2, cmd);
    }

    String getShowWarningConfig(String key) {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("SBD_LieYing", 0);
        if (sp == null) {
            return "";
        }
        String bShow = sp.getString(key, "");
        return bShow;
    }

    void setShowWarningConfig(String key, String Data) {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("SBD_LieYing", 0);
        if (sp != null) {
            sp.edit().putString(key, Data).commit();
        }
    }

    int getMaxConfig(String key, int vel) {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("SBD_LieYing", 0);
        if (sp == null) {
            return 0;
        }
        int i = sp.getInt(key, vel);
        return i;
    }

    void setMaxConfig(String key, int Data) {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("SBD_LieYing", 0);
        if (sp != null) {
            sp.edit().putInt(key, Data).commit();
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mCanbusNotify, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mCanbusNotify);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        }
        return true;
    }
}
