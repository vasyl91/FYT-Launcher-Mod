package com.syu.carinfo.ford;

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

public class LZSubaruCarCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 130:
                    LZSubaruCarCd.this.updateDiscNum(value);
                    break;
                case 131:
                    LZSubaruCarCd.this.mUpdateCdRpt();
                    break;
                case 132:
                    LZSubaruCarCd.this.mUpdateCdRandom();
                    break;
                case 133:
                    ((TextView) LZSubaruCarCd.this.findViewById(R.id.dj_lexus_cd_track)).setText(String.format("Track:%d", Integer.valueOf(value)));
                    break;
                case 134:
                case 135:
                    LZSubaruCarCd.this.updatecdTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_subaru_carcd);
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LZSubaruCarCd.this, LZSubaruCarSet.class);
                    LZSubaruCarCd.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[131];
        findViewById(R.id.lexus_cd_rpt).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
    }

    
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[132];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[134];
        int value1 = DataCanbus.DATA[135];
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
        FuncMain.setChannel(13);
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
