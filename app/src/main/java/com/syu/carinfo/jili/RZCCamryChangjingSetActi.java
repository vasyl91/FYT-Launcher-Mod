package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCCamryChangjingSetActi extends BaseActivity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 254:
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus6)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_n);
                    switch (value) {
                        case 1:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus1)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("开启空调Auto模式，播放动感音乐，执行成语接龙（语音助手），关闭车窗");
                            break;
                        case 2:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus2)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("暂停播放多媒体,关闭车窗");
                            break;
                        case 3:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus3)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("暂停播放多媒体,关闭车窗,关闭空调,停止成语接龙 ");
                            break;
                        case 4:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus4)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("所有车窗开一点,开启空调Auto模式");
                            break;
                        case 5:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus5)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("开启空调最大风量,打开主驾驶车窗");
                            break;
                        case 6:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus6)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("开启空调Auto模式,关闭车窗");
                            break;
                        case 7:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus7)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("开启空调Auto模式,主驾驶温度Low");
                            break;
                        case 8:
                            ((Button) RZCCamryChangjingSetActi.this.findViewById(R.id.btn_plus8)).setBackgroundResource(R.drawable.ic_bz408_btn_oil_p);
                            ((TextView) RZCCamryChangjingSetActi.this.findViewById(R.id.tv_text1)).setText("开启空调Auto模式,主驾驶温度HI,关闭车窗");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0112_rzc_camry_changjingsettings);
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 1}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 2}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 3}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 4}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 5}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 6}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 7}, null, null);
                return true;
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action != 0) {
                    return false;
                }
                DataCanbus.PROXY.cmd(40, new int[]{62, 8}, null, null);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
    }
}
