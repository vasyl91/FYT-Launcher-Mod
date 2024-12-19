package com.syu.carinfo.hc.qiyakaizunk7;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HCQiyaKaizunK7Audio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.qiyakaizunk7.HCQiyaKaizunK7Audio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 16:
                    HCQiyaKaizunK7Audio.this.updateVolvalue(value);
                    break;
                case 17:
                    HCQiyaKaizunK7Audio.this.updateBassbvalue(value);
                    break;
                case 18:
                    HCQiyaKaizunK7Audio.this.updateTrebvalue(value);
                    break;
                case 19:
                    HCQiyaKaizunK7Audio.this.updateBanvalue(value);
                    break;
                case 20:
                    HCQiyaKaizunK7Audio.this.updateFadvalue(value);
                    break;
                case 21:
                    HCQiyaKaizunK7Audio.this.updateMidbvalue(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djlexus_caraudio);
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
    }

    public void updateVolvalue(int value) {
        ((TextView) findViewById(R.id.dj_lexus_audio_vol)).setText(String.format("%d", Integer.valueOf(value)));
    }

    public void updateBassbvalue(int value) {
        if (value >= 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("%d", Integer.valueOf(value - 16)));
        } else if (value < 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(String.format("-%d", Integer.valueOf(16 - value)));
        }
    }

    public void updateMidbvalue(int value) {
        if (value >= 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("%d", Integer.valueOf(value - 16)));
        } else if (value < 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_mid)).setText(String.format("-%d", Integer.valueOf(16 - value)));
        }
    }

    public void updateTrebvalue(int value) {
        if (value >= 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("%d", Integer.valueOf(value - 16)));
        } else if (value < 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(String.format("-%d", Integer.valueOf(16 - value)));
        }
    }

    public void updateFadvalue(int value) {
        if (value == 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("%d", Integer.valueOf(value - 16)));
        } else if (value > 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("R%d", Integer.valueOf(value - 16)));
        } else if (value < 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText(String.format("F%d", Integer.valueOf(16 - value)));
        }
    }

    public void updateBanvalue(int value) {
        if (value == 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("%d", Integer.valueOf(value - 16)));
        } else if (value > 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("R%d", Integer.valueOf(value - 16)));
        } else if (value < 16) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText(String.format("L%d", Integer.valueOf(16 - value)));
        }
    }

    public void init() {
        ((Button) findViewById(R.id.btn_lexus_vol_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_vol_munit)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_treb_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_treb_munit)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_mid_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_mid_munit)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_bass_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_bass_munit)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_fad_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_fad_munit)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_ban_plus)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_ban_munit)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int bass = DataCanbus.DATA[17];
        int mid = DataCanbus.DATA[21];
        int treb = DataCanbus.DATA[18];
        int bal = DataCanbus.DATA[19];
        int fad = DataCanbus.DATA[20];
        int vol = DataCanbus.DATA[16];
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_lexus_vol_plus /* 2131430913 */:
                    if (vol < 35) {
                        vol++;
                        break;
                    }
                case R.id.btn_lexus_vol_munit /* 2131430914 */:
                    if (vol > 0) {
                        vol--;
                        break;
                    }
                case R.id.btn_lexus_treb_munit /* 2131430915 */:
                    if (treb > 6) {
                        treb--;
                        break;
                    }
                case R.id.btn_lexus_mid_munit /* 2131430916 */:
                    if (mid < 26) {
                        mid++;
                        break;
                    }
                case R.id.btn_lexus_bass_munit /* 2131430917 */:
                    if (bass < 26) {
                        bass++;
                        break;
                    }
                case R.id.btn_lexus_ban_munit /* 2131430918 */:
                    if (bal < 26) {
                        bal++;
                        break;
                    }
                case R.id.btn_lexus_fad_munit /* 2131430919 */:
                    if (fad < 26) {
                        fad++;
                        break;
                    }
                case R.id.btn_lexus_treb_plus /* 2131430920 */:
                    if (treb < 26) {
                        treb++;
                        break;
                    }
                case R.id.btn_lexus_mid_plus /* 2131430921 */:
                    if (mid > 6) {
                        mid--;
                        break;
                    }
                case R.id.btn_lexus_bass_plus /* 2131430922 */:
                    if (bass > 6) {
                        bass--;
                        break;
                    }
                case R.id.btn_lexus_ban_plus /* 2131430923 */:
                    if (bal > 6) {
                        bal--;
                        break;
                    }
                case R.id.btn_lexus_fad_plus /* 2131430924 */:
                    if (fad > 6) {
                        fad--;
                        break;
                    }
            }
            DataCanbus.PROXY.cmd(0, new int[]{vol, bass, treb, bal, fad, mid}, null, null);
        } else {
            event.getAction();
        }
        return false;
    }
}
