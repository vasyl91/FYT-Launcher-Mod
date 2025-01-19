package com.syu.carinfo.wc.tianlaicd;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0443_WC2_08_12Tianlai;
import com.syu.module.canbus.DataCanbus;

public class WC08TianlaiCarCDAct extends Activity implements View.OnTouchListener {
    public static WC08TianlaiCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 121:
                case 142:
                    WC08TianlaiCarCDAct.this.mUpdaterCdText();
                    break;
                case 134:
                    ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_track)).setText("Track:" + ((value >> 4) & 15) + ((value >> 0) & 15));
                    break;
                case 135:
                case 136:
                    int m = DataCanbus.DATA[135];
                    int s = DataCanbus.DATA[136];
                    ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(m) + " : " + s);
                    break;
                case 137:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text1)).setText("Scan: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text1)).setText("Scan....");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text1)).setText("Disc Scan");
                            break;
                    }
                case 138:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_repeat)).setText("Repeat: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_repeat)).setText("Track Repeat");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_repeat)).setText("Disc Repeat");
                            break;
                        case 3:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_repeat)).setText("All Disc Repeat");
                            break;
                    }
                case 139:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text2)).setText("Random: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text2)).setText("Random: on");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text2)).setText("Disc Random");
                            break;
                        case 3:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text2)).setText("All Disc Random");
                            break;
                    }
                case 140:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text3)).setText("Floder: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text3)).setText("Floder: RPT");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.tv_text3)).setText("Floder: RDM");
                            break;
                    }
                case 141:
                    WC08TianlaiCarCDAct.this.mUpdaterCdState(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_08tianlai_carcd);
        mInstance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdText() {
        int value = DataCanbus.DATA[121];
        if (value == 1) {
            ((TextView) findViewById(R.id.cd_title)).setText(Callback_0443_WC2_08_12Tianlai.CDText);
        } else {
            ((TextView) findViewById(R.id.cd_title)).setText("");
        }
    }

    
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText("Reading");
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText("Play");
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_state)).setText("Stop");
                break;
            case 12:
                ((TextView) findViewById(R.id.cd_state)).setText("Eject");
                break;
            case 17:
                ((TextView) findViewById(R.id.cd_state)).setText("Loading");
                break;
            case 18:
                ((TextView) findViewById(R.id.cd_state)).setText("Insert Disc");
                break;
            case 19:
                ((TextView) findViewById(R.id.cd_state)).setText("Wait");
                break;
            case 20:
                ((TextView) findViewById(R.id.cd_state)).setText("Busy");
                break;
            case 21:
                ((TextView) findViewById(R.id.cd_state)).setText("Select disc to load");
                break;
            case 22:
                ((TextView) findViewById(R.id.cd_state)).setText("Select disc to eject");
                break;
            case 23:
                ((TextView) findViewById(R.id.cd_state)).setText("Disc Error");
                break;
        }
    }
}
