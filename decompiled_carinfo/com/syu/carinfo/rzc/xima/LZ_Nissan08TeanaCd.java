package com.syu.carinfo.rzc.xima;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZ_Nissan08TeanaCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 151:
                    LZ_Nissan08TeanaCd.this.mUpdateCd6State();
                    break;
                case 152:
                    LZ_Nissan08TeanaCd.this.mUpdateCd5State();
                    break;
                case 153:
                    LZ_Nissan08TeanaCd.this.mUpdateCd4State();
                    break;
                case 154:
                    LZ_Nissan08TeanaCd.this.mUpdateCd3State();
                    break;
                case 155:
                    LZ_Nissan08TeanaCd.this.mUpdateCd2State();
                    break;
                case 156:
                    LZ_Nissan08TeanaCd.this.mUpdateCd1State();
                    break;
                case 157:
                    switch (value) {
                        case 0:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("NULL");
                            break;
                        case 1:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("LOAD");
                            break;
                        case 2:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("WAIT");
                            break;
                        case 3:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("READING");
                            break;
                        case 4:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("PLAY");
                            break;
                        case 5:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("EJECT");
                            break;
                        case 6:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("DISC CHANGING");
                            break;
                        case 7:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("FF");
                            break;
                        case 8:
                            ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.tv_text2)).setText("FR");
                            break;
                    }
                case 158:
                    LZ_Nissan08TeanaCd.this.updateDiscNum(value);
                    break;
                case 159:
                    LZ_Nissan08TeanaCd.this.mUpdateCdRpt();
                    break;
                case 160:
                    ((TextView) LZ_Nissan08TeanaCd.this.findViewById(R.id.dj_lexus_cd_track)).setText(String.format("Track:%d", Integer.valueOf(value)));
                    break;
                case 161:
                case 162:
                    LZ_Nissan08TeanaCd.this.updatecdTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_nissan_08teana_carcd);
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZ_Nissan08TeanaCd.this, LZ_Nissan08TeanaAmpCarSet.class);
                    LZ_Nissan08TeanaCd.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[156];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[155];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[154];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[153];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[152];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[151];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCdRpt() {
        int value = DataCanbus.DATA[159];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText("A-RPT");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText("D-RPT");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText("1-RPT");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText("D-RND");
                break;
        }
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[161];
        int value1 = DataCanbus.DATA[162];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d:%d", Integer.valueOf(value), Integer.valueOf(value1)));
    }

    public void updateDiscNum(int value) {
        ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-65536);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
