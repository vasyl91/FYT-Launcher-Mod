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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC08TianlaiCarCDAct extends Activity implements View.OnTouchListener {
    public static WC08TianlaiCarCDAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                case 130:
                    WC08TianlaiCarCDAct.this.mUpdaterCdText();
                    break;
                case 122:
                    ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_track)).setText("Track:" + ((value >> 4) & 15) + ((value >> 0) & 15));
                    break;
                case 123:
                case 124:
                    int m = DataCanbus.DATA[123];
                    int s = DataCanbus.DATA[124];
                    ((TextView) WC08TianlaiCarCDAct.this.findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(m) + " : " + s);
                    break;
                case 125:
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
                case 126:
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
                case 127:
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
                case 128:
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
                case 129:
                    WC08TianlaiCarCDAct.this.mUpdaterCdState(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_08tianlai_carcd);
        mInstance = this;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdText() {
        int value = DataCanbus.DATA[109];
        if (value == 1) {
            ((TextView) findViewById(R.id.cd_title)).setText(Callback_0443_WC2_08_12Tianlai.CDText);
        } else {
            ((TextView) findViewById(R.id.cd_title)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
