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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class HCQiyaKaizunK7Audio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.qiyakaizunk7.HCQiyaKaizunK7Audio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    HCQiyaKaizunK7Audio.this.updateVolvalue(value);
                    break;
                case 100:
                    HCQiyaKaizunK7Audio.this.updateBassbvalue(value);
                    break;
                case 101:
                    HCQiyaKaizunK7Audio.this.updateTrebvalue(value);
                    break;
                case 102:
                    HCQiyaKaizunK7Audio.this.updateBanvalue(value);
                    break;
                case 103:
                    HCQiyaKaizunK7Audio.this.updateFadvalue(value);
                    break;
                case 104:
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
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
        int bass = DataCanbus.DATA[100];
        int mid = DataCanbus.DATA[104];
        int treb = DataCanbus.DATA[101];
        int bal = DataCanbus.DATA[102];
        int fad = DataCanbus.DATA[103];
        int vol = DataCanbus.DATA[99];
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_lexus_vol_plus /* 2131430188 */:
                    if (vol < 35) {
                        vol++;
                    }
                    break;
                case R.id.btn_lexus_vol_munit /* 2131430189 */:
                    if (vol > 0) {
                        vol--;
                    }
                    break;
                case R.id.btn_lexus_treb_munit /* 2131430190 */:
                    if (treb > 6) {
                        treb--;
                    }
                    break;
                case R.id.btn_lexus_mid_munit /* 2131430191 */:
                    if (mid < 26) {
                        mid++;
                    }
                    break;
                case R.id.btn_lexus_bass_munit /* 2131430192 */:
                    if (bass < 26) {
                        bass++;
                    }
                    break;
                case R.id.btn_lexus_ban_munit /* 2131430193 */:
                    if (bal < 26) {
                        bal++;
                    }
                    break;
                case R.id.btn_lexus_fad_munit /* 2131430194 */:
                    if (fad < 26) {
                        fad++;
                    }
                    break;
                case R.id.btn_lexus_treb_plus /* 2131430195 */:
                    if (treb < 26) {
                        treb++;
                    }
                    break;
                case R.id.btn_lexus_mid_plus /* 2131430196 */:
                    if (mid > 6) {
                        mid--;
                    }
                    break;
                case R.id.btn_lexus_bass_plus /* 2131430197 */:
                    if (bass > 6) {
                        bass--;
                    }
                    break;
                case R.id.btn_lexus_ban_plus /* 2131430198 */:
                    if (bal > 6) {
                        bal--;
                    }
                    break;
                case R.id.btn_lexus_fad_plus /* 2131430199 */:
                    if (fad > 6) {
                        fad--;
                    }
                    break;
            }
            DataCanbus.PROXY.cmd(0, new int[]{vol, bass, treb, bal, fad, mid}, null, null);
        } else {
            event.getAction();
        }
        return false;
    }
}
