package com.syu.carinfo.luz.oubao;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0452_LZ_Oubao_Andela;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Luz_Oubao_CarCD extends BaseActivity implements View.OnClickListener {
    public static Luz_Oubao_CarCD mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (value == 1) {
                        ((TextView) Luz_Oubao_CarCD.this.findViewById(R.id.tv_text1)).setText("POWER: ON");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarCD.this.findViewById(R.id.tv_text1)).setText("POWER: Off");
                        break;
                    }
                case 99:
                case 101:
                    String str = Callback_0452_LZ_Oubao_Andela.D07Title;
                    switch (DataCanbus.DATA[99]) {
                        case 2:
                            str = "Settings: " + str;
                            break;
                        case 3:
                            str = "Sound: " + str;
                            break;
                        case 4:
                            str = "Stations: " + str;
                            break;
                        case 5:
                            str = "Store: " + str;
                            break;
                        case 6:
                            str = "Tracks: " + str;
                            break;
                        case 7:
                            str = "Extras: " + str;
                            break;
                    }
                    ((TextView) Luz_Oubao_CarCD.this.findViewById(R.id.tv_text2)).setText(str);
                    break;
                case 102:
                case 103:
                    String str2 = Callback_0452_LZ_Oubao_Andela.D0BTitle;
                    switch (DataCanbus.DATA[102]) {
                        case 10:
                            str2 = "Settings: " + str2;
                            break;
                        case 11:
                            str2 = "Sound: " + str2;
                            break;
                        case 12:
                            str2 = "Stations: " + str2;
                            break;
                        case 13:
                            str2 = "Store: " + str2;
                            break;
                        case 14:
                            str2 = "Tracks: " + str2;
                            break;
                        case 15:
                            str2 = "Extras: " + str2;
                            break;
                    }
                    ((TextView) Luz_Oubao_CarCD.this.findViewById(R.id.tv_text3)).setText(str2);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_luz_oubao_andela_carcd);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }
}
