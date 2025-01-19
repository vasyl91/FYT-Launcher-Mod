package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public class UIODModernin {
    private static UIODModernin mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIODModernin getInstance() {
        if (mInstance == null) {
            mInstance = new UIODModernin();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null) {
            if (DataCanbus.DATA[152] != 0 || DataCanbus.DATA[153] != 0) {
                WarnUtils.showWindow();
                return;
            }
            if (DataCanbus.DATA[154] != 0 || DataCanbus.DATA[155] != 0 || DataCanbus.DATA[156] != 0 || DataCanbus.DATA[157] != 0 || DataCanbus.DATA[158] != 0) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(5000);
            } else if (window.isShowing()) {
                window.dismiss();
            }
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0453_od_modernin_warn, null, false);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    if (WarnUtils.getWindow().isShowing()) {
                        WarnUtils.getWindow().dismiss();
                    }
                }
            });
        }
        this.mTextWarn.setTextColor(-256);
        if (((DataCanbus.DATA[152] >> 0) & 1) != 0) {
            this.mTextWarn.setText("动力电池：火灾危险!请立即远离车辆!");
        } else if (((DataCanbus.DATA[152] >> 1) & 1) != 0) {
            this.mTextWarn.setText("请踩下制动踏板!");
        } else if (((DataCanbus.DATA[152] >> 2) & 1) != 0) {
            this.mTextWarn.setText("动力系统严重故障，请停车并进行专业维修!");
        } else if (((DataCanbus.DATA[152] >> 3) & 1) != 0) {
            this.mTextWarn.setText("动力电池电量低，请尽快充电!");
        } else if (((DataCanbus.DATA[152] >> 4) & 1) != 0) {
            this.mTextWarn.setText("请踩下制动踏板并按下启动开关!");
        } else if (((DataCanbus.DATA[152] >> 5) & 1) != 0) {
            this.mTextWarn.setText("充电枪已连接，车辆无法启动，请拔下充电枪!");
        } else if (((DataCanbus.DATA[152] >> 6) & 1) != 0) {
            this.mTextWarn.setText("不可换挡，请确认换挡操作!");
        } else if (((DataCanbus.DATA[152] >> 7) & 1) != 0) {
            this.mTextWarn.setText("请将档位切换至P档!");
        } else if (((DataCanbus.DATA[153] >> 0) & 1) != 0) {
            this.mTextWarn.setText("电驱系统故障，请停车并进行专业维修!");
        } else if (((DataCanbus.DATA[153] >> 1) & 1) != 0) {
            this.mTextWarn.setText("电驱系统过热，请停车并进行专业维修!");
        } else if (((DataCanbus.DATA[153] >> 2) & 1) != 0) {
            this.mTextWarn.setText("动力电池故障，请停车并进行专业维修!");
        } else if (((DataCanbus.DATA[153] >> 3) & 1) != 0) {
            this.mTextWarn.setText("驱动功率受限，请去维修站!");
        } else if (((DataCanbus.DATA[153] >> 4) & 1) != 0) {
            this.mTextWarn.setText("OBC故障，请去维修站!");
        } else if (((DataCanbus.DATA[153] >> 5) & 1) != 0) {
            this.mTextWarn.setText("电驱冷却系统故障，请去维修站!");
        } else if (((DataCanbus.DATA[153] >> 6) & 1) != 0) {
            this.mTextWarn.setText("动力电池温控系统故障，请去维修站!");
        } else if (((DataCanbus.DATA[154] >> 0) & 1) != 0) {
            this.mTextWarn.setText("遥控钥匙落锁自动下电不满足，主驾未松开安全带!");
        } else if (((DataCanbus.DATA[154] >> 1) & 1) != 0) {
            this.mTextWarn.setText("遥控钥匙落锁自动下电不满足，副驾未松开安全带!");
        } else if (((DataCanbus.DATA[154] >> 2) & 1) != 0) {
            this.mTextWarn.setText("遥控钥匙落锁自动下电不满足，副驾人员或物体未离开!");
        } else if (((DataCanbus.DATA[154] >> 3) & 1) != 0) {
            this.mTextWarn.setText("钥匙拿出车外!");
        } else if (((DataCanbus.DATA[154] >> 4) & 1) != 0) {
            this.mTextWarn.setText("未检测到钥匙!");
        } else if (((DataCanbus.DATA[154] >> 5) & 1) != 0) {
            this.mTextWarn.setText("钥匙电池电量低!");
        } else if (((DataCanbus.DATA[154] >> 6) & 1) != 0) {
            this.mTextWarn.setText("钥匙还在车内!");
        } else if (((DataCanbus.DATA[154] >> 7) & 1) != 0) {
            this.mTextWarn.setText("充电失败，请去维修站!");
        } else if (((DataCanbus.DATA[155] >> 0) & 1) != 0) {
            this.mTextWarn.setText("左转向灯故障!");
        } else if (((DataCanbus.DATA[155] >> 1) & 1) != 0) {
            this.mTextWarn.setText("右转向灯故障!");
        } else if (((DataCanbus.DATA[155] >> 2) & 1) != 0) {
            this.mTextWarn.setText("左侧位置灯故障!");
        } else if (((DataCanbus.DATA[155] >> 3) & 1) != 0) {
            this.mTextWarn.setText("右侧位置灯故障!");
        } else if (((DataCanbus.DATA[155] >> 4) & 1) != 0) {
            this.mTextWarn.setText("前中位置灯故障!");
        } else if (((DataCanbus.DATA[155] >> 5) & 1) != 0) {
            this.mTextWarn.setText("后中位置灯故障!");
        } else if (((DataCanbus.DATA[155] >> 6) & 1) != 0) {
            this.mTextWarn.setText("倒车灯故障!");
        } else if (((DataCanbus.DATA[155] >> 7) & 1) != 0) {
            this.mTextWarn.setText("后雾灯故障!");
        } else if (((DataCanbus.DATA[156] >> 0) & 1) != 0) {
            this.mTextWarn.setText("左日间行车灯故障!");
        } else if (((DataCanbus.DATA[156] >> 1) & 1) != 0) {
            this.mTextWarn.setText("右日间行车灯故障!");
        } else if (((DataCanbus.DATA[156] >> 2) & 1) != 0) {
            this.mTextWarn.setText("刹车灯故障!");
        } else if (((DataCanbus.DATA[156] >> 3) & 1) != 0) {
            this.mTextWarn.setText("制动灯故障!");
        } else if (((DataCanbus.DATA[156] >> 4) & 1) != 0) {
            this.mTextWarn.setText("远光灯故障!");
        } else if (((DataCanbus.DATA[156] >> 5) & 1) != 0) {
            this.mTextWarn.setText("近光灯故障!");
        } else if (((DataCanbus.DATA[156] >> 6) & 1) != 0) {
            this.mTextWarn.setText("充电连接装置故障，请去维修站!");
        } else if (((DataCanbus.DATA[156] >> 7) & 1) != 0) {
            this.mTextWarn.setText("充电枪电子锁故障，请去维修站!");
        } else if (((DataCanbus.DATA[157] >> 0) & 1) != 0) {
            this.mTextWarn.setText("整车绝缘故障，请停车并参阅用户手册!");
        } else if (((DataCanbus.DATA[157] >> 1) & 1) != 0) {
            this.mTextWarn.setText("高压互锁故障，请停车并进行专业维修!");
        } else if (((DataCanbus.DATA[157] >> 2) & 1) != 0) {
            this.mTextWarn.setText("直流快充接触器故障，请去维修站!");
        } else if (((DataCanbus.DATA[157] >> 3) & 1) != 0) {
            this.mTextWarn.setText("车辆启动认证失败，请去维修站!");
        } else if (((DataCanbus.DATA[158] >> 0) & 1) != 0) {
            this.mTextWarn.setText("后左雷达故障!");
        } else if (((DataCanbus.DATA[158] >> 1) & 1) != 0) {
            this.mTextWarn.setText("后左中间雷达故障!");
        } else if (((DataCanbus.DATA[158] >> 2) & 1) != 0) {
            this.mTextWarn.setText("后右中间雷达故障!");
        } else if (((DataCanbus.DATA[158] >> 3) & 1) != 0) {
            this.mTextWarn.setText("后右雷达故障!");
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
