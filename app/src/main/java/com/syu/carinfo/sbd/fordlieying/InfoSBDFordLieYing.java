package com.syu.carinfo.sbd.fordlieying;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class InfoSBDFordLieYing extends BaseActivity {
    public static boolean mIsFront = false;
    Handler mHandler;
    public int value_max_1 = 200;
    public int value_max_2 = 200;
    public int value_max_3 = 200;
    public int value_min_1 = 0;
    public int value_min_2 = 0;
    public int value_min_3 = 0;
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    if (strs != null) {
                        ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digital1)).setText(strs[0]);
                        InfoSBDFordLieYing.this.setShowWarningConfig("TABLE_STR_1", strs[0]);
                        break;
                    }
                case 99:
                    if (strs != null) {
                        ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digital2)).setText(strs[0]);
                        InfoSBDFordLieYing.this.setShowWarningConfig("TABLE_STR_2", strs[0]);
                        break;
                    }
                case 100:
                    if (strs != null) {
                        ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digital3)).setText(strs[0]);
                        InfoSBDFordLieYing.this.setShowWarningConfig("TABLE_STR_3", strs[0]);
                        break;
                    }
                case 101:
                    int value_1 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView1)).setSpeed(value_1);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digitalvalue1)).setText(String.valueOf(value_1) + ".0");
                    break;
                case 102:
                    int value_2 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView2)).setSpeed(value_2);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digitalvalue2)).setText(String.valueOf(value_2) + ".0");
                    break;
                case 103:
                    int value_3 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView3)).setSpeed(value_3);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.tv_digitalvalue3)).setText(String.valueOf(value_3) + ".0");
                    break;
                case 104:
                    if (DataCanbus.DATA[updateCode] > InfoSBDFordLieYing.this.value_min_1) {
                        InfoSBDFordLieYing.this.value_max_1 = DataCanbus.DATA[updateCode];
                        ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView1)).setMax(InfoSBDFordLieYing.this.value_max_1);
                    }
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_5)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 105:
                    if (DataCanbus.DATA[updateCode] > InfoSBDFordLieYing.this.value_min_2) {
                        InfoSBDFordLieYing.this.value_max_2 = DataCanbus.DATA[updateCode];
                        ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView2)).setMax(InfoSBDFordLieYing.this.value_max_2);
                    }
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_5)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 106:
                    if (DataCanbus.DATA[updateCode] > InfoSBDFordLieYing.this.value_min_3) {
                        InfoSBDFordLieYing.this.value_max_3 = DataCanbus.DATA[updateCode];
                        ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView3)).setMax(InfoSBDFordLieYing.this.value_max_3);
                    }
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_5)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 107:
                    InfoSBDFordLieYing.this.value_min_1 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView1)).setMin(InfoSBDFordLieYing.this.value_min_1);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_1)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 108:
                    InfoSBDFordLieYing.this.value_min_2 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView2)).setMin(InfoSBDFordLieYing.this.value_min_2);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_1)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 109:
                    InfoSBDFordLieYing.this.value_min_3 = DataCanbus.DATA[updateCode];
                    ((InfoView) InfoSBDFordLieYing.this.findViewById(R.id.infoView3)).setMin(InfoSBDFordLieYing.this.value_min_3);
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_1)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 110:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_2)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 111:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_3)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 112:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num1_4)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 113:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_2)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 114:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_3)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 115:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num2_4)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 116:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_2)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 117:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_3)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
                case 118:
                    ((TextView) InfoSBDFordLieYing.this.findViewById(R.id.lieying_table_num3_4)).setText(String.format("%d", Integer.valueOf(DataCanbus.DATA[updateCode])));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_398_fordlieying_info);
        initView();
        this.mHandler = new Handler(Looper.getMainLooper());
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

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        requestDigitalInfo(48);
        requestDigitalInfo(49);
        requestDigitalInfo(50);
    }

    @Override
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

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
    }

    @Override
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
