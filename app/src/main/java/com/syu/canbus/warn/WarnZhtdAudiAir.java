package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class WarnZhtdAudiAir {
    private static WarnZhtdAudiAir mInstance;
    Context context;
    private ImageView mImageAirLeft;
    private ImageView mImageAirRight;
    private TextView mTextTempLeft;
    private TextView mTextTempRight;
    private View sWarnContent;
    private final Runnable LeftTempTimeCnt = new Runnable() { 
        @Override
        public void run() {
            if (WarnZhtdAudiAir.this.ShowLeftTempTime <= 0) {
                return;
            }
            WarnZhtdAudiAir.this.ShowLeftTempTime = 0;
            if (WarnZhtdAudiAir.this.ShowLeftWinlevTime == 0 && WarnZhtdAudiAir.this.ShowLeftWinModeTime == 0) {
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("");
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("");
                WarnZhtdAudiAir.this.mTextTempLeft.setText("");
                WarnZhtdAudiAir.this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
            }
        }
    };
    private final Runnable LeftWinlevTimeCnt = new Runnable() { 
        @Override
        public void run() {
            if (WarnZhtdAudiAir.this.ShowLeftWinlevTime <= 0) {
                return;
            }
            WarnZhtdAudiAir.this.ShowLeftWinlevTime = 0;
            if (WarnZhtdAudiAir.this.ShowLeftTempTime == 0 && WarnZhtdAudiAir.this.ShowLeftWinModeTime == 0) {
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("");
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("");
                WarnZhtdAudiAir.this.mTextTempLeft.setText("");
                WarnZhtdAudiAir.this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
            }
        }
    };
    private final Runnable LeftWinModeTimeCnt = new Runnable() { 
        @Override
        public void run() {
            if (WarnZhtdAudiAir.this.ShowLeftWinModeTime <= 0) {
                return;
            }
            WarnZhtdAudiAir.this.ShowLeftWinModeTime = 0;
            if (WarnZhtdAudiAir.this.ShowLeftTempTime == 0 && WarnZhtdAudiAir.this.ShowLeftWinlevTime == 0) {
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("");
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("");
                WarnZhtdAudiAir.this.mTextTempLeft.setText("");
                WarnZhtdAudiAir.this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
            }
        }
    };
    private final Runnable RightTempTimeCnt = new Runnable() { 
        @Override
        public void run() {
            if (WarnZhtdAudiAir.this.ShowRightTempTime <= 0) {
                return;
            }
            WarnZhtdAudiAir.this.ShowRightTempTime = 0;
            if (WarnZhtdAudiAir.this.ShowRightWinlevTime == 0 && WarnZhtdAudiAir.this.ShowRightWinModeTime == 0) {
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("");
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("");
                WarnZhtdAudiAir.this.mTextTempRight.setText("");
                WarnZhtdAudiAir.this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
            }
        }
    };
    private final Runnable RightWinlevTimeCnt = new Runnable() { 
        @Override
        public void run() {
            if (WarnZhtdAudiAir.this.ShowRightWinlevTime <= 0) {
                return;
            }
            WarnZhtdAudiAir.this.ShowRightWinlevTime = 0;
            if (WarnZhtdAudiAir.this.ShowRightTempTime == 0 && WarnZhtdAudiAir.this.ShowRightWinModeTime == 0) {
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("");
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("");
                WarnZhtdAudiAir.this.mTextTempRight.setText("");
                WarnZhtdAudiAir.this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
            }
        }
    };
    private final Runnable RightWinModeTimeCnt = new Runnable() { 
        @Override
        public void run() {
            if (WarnZhtdAudiAir.this.ShowRightWinModeTime <= 0) {
                return;
            }
            WarnZhtdAudiAir.this.ShowRightWinModeTime = 0;
            if (WarnZhtdAudiAir.this.ShowRightTempTime == 0 && WarnZhtdAudiAir.this.ShowRightWinlevTime == 0) {
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("");
                ((TextView) WarnZhtdAudiAir.this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("");
                WarnZhtdAudiAir.this.mTextTempRight.setText("");
                WarnZhtdAudiAir.this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
            }
        }
    };
    private int ShowLeftTempTime = 0;
    private int ShowRightTempTime = 0;
    private int ShowLeftWinlevTime = 0;
    private int ShowRightWinlevTime = 0;
    private int ShowLeftWinModeTime = 0;
    private int ShowRightWinModeTime = 0;

    public static WarnZhtdAudiAir getInstance() {
        if (mInstance == null) {
            mInstance = new WarnZhtdAudiAir();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    public static void postDelayedShow(Runnable runnable, int delay) {
        if (runnable != null) {
            HandlerUI.getInstance().removeCallbacks(runnable);
            HandlerUI.getInstance().postDelayed(runnable, delay);
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_450_audi_air, null, false);
            this.mImageAirLeft = this.sWarnContent.findViewById(R.id.iv_air_left);
            this.mImageAirRight = this.sWarnContent.findViewById(R.id.iv_air_right);
            this.mTextTempLeft = this.sWarnContent.findViewById(R.id.tv_airtemp_left);
            this.mTextTempRight = this.sWarnContent.findViewById(R.id.tv_airtemp_right);
        }
        this.mTextTempLeft.setVisibility(0);
        this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit).setVisibility(0);
        switch (DataCanbus.DATA[80]) {
            case 2:
                this.ShowLeftTempTime = 1;
                postDelayedShow(this.LeftTempTimeCnt, 4000);
                this.ShowLeftWinlevTime = 0;
                this.ShowLeftWinModeTime = 0;
                ShowAirLeftTemp();
                if (this.ShowRightTempTime > 0) {
                    ShowAirRightTemp();
                    break;
                } else if (this.ShowRightWinlevTime > 0) {
                    ShowAirRightWinlev();
                    break;
                } else if (this.ShowRightWinModeTime > 0) {
                    ShowAirRightWinMode();
                    break;
                } else {
                    ClearTextRightShow();
                    this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
                    break;
                }
            case 3:
                this.ShowRightTempTime = 1;
                postDelayedShow(this.RightTempTimeCnt, 4000);
                this.ShowRightWinlevTime = 0;
                this.ShowRightWinModeTime = 0;
                ShowAirRightTemp();
                if (this.ShowLeftTempTime > 0) {
                    ShowAirLeftTemp();
                    break;
                } else if (this.ShowLeftWinlevTime > 0) {
                    ShowAirLeftWinlev();
                    break;
                } else if (this.ShowLeftWinModeTime > 0) {
                    ShowAirLeftWinMode();
                    break;
                } else {
                    ClearTextLeftShow();
                    this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
                    break;
                }
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 11:
            default:
                this.ShowLeftTempTime = 0;
                this.ShowLeftWinlevTime = 0;
                this.ShowLeftWinModeTime = 0;
                this.ShowRightTempTime = 0;
                this.ShowRightWinlevTime = 0;
                this.ShowRightWinModeTime = 0;
                ClearTextLeftShow();
                ClearTextRightShow();
                this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
                this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
                break;
            case 8:
                this.ShowLeftTempTime = 0;
                this.ShowLeftWinlevTime = 1;
                postDelayedShow(this.LeftWinlevTimeCnt, 4000);
                this.ShowLeftWinModeTime = 0;
                ClearTextLeftShow();
                ShowAirLeftWinlev();
                if (this.ShowRightTempTime > 0) {
                    ShowAirRightTemp();
                    break;
                } else if (this.ShowRightWinlevTime > 0) {
                    ShowAirRightWinlev();
                    break;
                } else if (this.ShowRightWinModeTime > 0) {
                    ShowAirRightWinMode();
                    break;
                } else {
                    ClearTextRightShow();
                    this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
                    break;
                }
            case 9:
                this.ShowLeftTempTime = 0;
                this.ShowLeftWinlevTime = 0;
                postDelayedShow(this.LeftWinModeTimeCnt, 4000);
                this.ShowLeftWinModeTime = 1;
                ClearTextLeftShow();
                ShowAirLeftWinMode();
                if (this.ShowRightTempTime > 0) {
                    ShowAirRightTemp();
                    break;
                } else if (this.ShowRightWinlevTime > 0) {
                    ShowAirRightWinlev();
                    break;
                } else if (this.ShowRightWinModeTime > 0) {
                    ShowAirRightWinMode();
                    break;
                } else {
                    ClearTextRightShow();
                    this.mImageAirRight.setBackgroundResource(R.drawable.bk_450_air);
                    break;
                }
            case 12:
                this.ShowRightTempTime = 0;
                postDelayedShow(this.RightWinlevTimeCnt, 4000);
                this.ShowRightWinlevTime = 1;
                this.ShowRightWinModeTime = 0;
                ClearTextRightShow();
                ShowAirRightWinlev();
                if (this.ShowLeftTempTime > 0) {
                    ShowAirLeftTemp();
                    break;
                } else if (this.ShowLeftWinlevTime > 0) {
                    ShowAirLeftWinlev();
                    break;
                } else if (this.ShowLeftWinModeTime > 0) {
                    ShowAirLeftWinMode();
                    break;
                } else {
                    ClearTextLeftShow();
                    this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
                    break;
                }
            case 13:
                this.ShowRightTempTime = 0;
                postDelayedShow(this.RightWinModeTimeCnt, 4000);
                this.ShowRightWinlevTime = 0;
                this.ShowRightWinModeTime = 1;
                ClearTextRightShow();
                ShowAirRightWinMode();
                if (this.ShowLeftTempTime > 0) {
                    ShowAirLeftTemp();
                    break;
                } else if (this.ShowLeftWinlevTime > 0) {
                    ShowAirLeftWinlev();
                    break;
                } else if (this.ShowLeftWinModeTime > 0) {
                    ShowAirLeftWinMode();
                    break;
                } else {
                    ClearTextLeftShow();
                    this.mImageAirLeft.setBackgroundResource(R.drawable.bk_450_air);
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }

    private void ShowAirLeftTemp() {
        switch (DataCanbus.DATA[27]) {
            case -3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left26);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("HI");
                break;
            case -2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("LO");
                break;
            case 32:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left1);
                this.mTextTempLeft.setText("16.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 33:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left2);
                this.mTextTempLeft.setText("16.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 34:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left3);
                this.mTextTempLeft.setText("17.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 35:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left4);
                this.mTextTempLeft.setText("17.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 36:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left5);
                this.mTextTempLeft.setText("18.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 37:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left6);
                this.mTextTempLeft.setText("18.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 38:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left7);
                this.mTextTempLeft.setText("19.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 39:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left8);
                this.mTextTempLeft.setText("19.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 40:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left9);
                this.mTextTempLeft.setText("20.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 41:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left10);
                this.mTextTempLeft.setText("20.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 42:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left11);
                this.mTextTempLeft.setText("21.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 43:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left12);
                this.mTextTempLeft.setText("21.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 44:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left13);
                this.mTextTempLeft.setText("22.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 45:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left14);
                this.mTextTempLeft.setText("22.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 46:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left15);
                this.mTextTempLeft.setText("23.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 47:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left16);
                this.mTextTempLeft.setText("23.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 48:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left17);
                this.mTextTempLeft.setText("24.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 49:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left18);
                this.mTextTempLeft.setText("24.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 50:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left19);
                this.mTextTempLeft.setText("25.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 51:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left20);
                this.mTextTempLeft.setText("25.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 52:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left21);
                this.mTextTempLeft.setText("26.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 53:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left22);
                this.mTextTempLeft.setText("26.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 54:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left23);
                this.mTextTempLeft.setText("27.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 55:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left24);
                this.mTextTempLeft.setText("27.5");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
            case 56:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_temp_left25);
                this.mTextTempLeft.setText("28.0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("℃");
                break;
        }
        if (DataCanbus.DATA[27] >= 0) {
            this.mTextTempLeft.setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit).setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic).setVisibility(8);
        } else {
            this.mTextTempLeft.setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit).setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic).setVisibility(0);
        }
    }

    private void ShowAirRightTemp() {
        switch (DataCanbus.DATA[28]) {
            case -3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right26);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("HI");
                break;
            case -2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("LO");
                break;
            case 32:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right1);
                this.mTextTempRight.setText("16.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 33:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right2);
                this.mTextTempRight.setText("16.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 34:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right3);
                this.mTextTempRight.setText("17.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 35:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right4);
                this.mTextTempRight.setText("17.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 36:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right5);
                this.mTextTempRight.setText("18.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 37:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right6);
                this.mTextTempRight.setText("18.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 38:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right7);
                this.mTextTempRight.setText("19.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 39:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right8);
                this.mTextTempRight.setText("19.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 40:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right9);
                this.mTextTempRight.setText("20.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 41:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right10);
                this.mTextTempRight.setText("20.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 42:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right11);
                this.mTextTempRight.setText("21.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 43:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right12);
                this.mTextTempRight.setText("21.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 44:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right13);
                this.mTextTempRight.setText("22.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 45:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right14);
                this.mTextTempRight.setText("22.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 46:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right15);
                this.mTextTempRight.setText("23.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 47:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right16);
                this.mTextTempRight.setText("23.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 48:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right17);
                this.mTextTempRight.setText("24.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 49:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right18);
                this.mTextTempRight.setText("24.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 50:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right19);
                this.mTextTempRight.setText("25.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 51:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right20);
                this.mTextTempRight.setText("25.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 52:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right21);
                this.mTextTempRight.setText("26.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 53:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right22);
                this.mTextTempRight.setText("26.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 54:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right23);
                this.mTextTempRight.setText("27.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 55:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right24);
                this.mTextTempRight.setText("27.5 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
            case 56:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_temp_right25);
                this.mTextTempRight.setText("28.0 ");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("℃");
                break;
        }
        if (DataCanbus.DATA[28] >= 0) {
            this.mTextTempRight.setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit).setVisibility(0);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic).setVisibility(8);
        } else {
            this.mTextTempRight.setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit).setVisibility(8);
            this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic).setVisibility(0);
        }
    }

    private void ShowAirLeftWinlev() {
        switch (DataCanbus.DATA[21]) {
            case 1:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left1);
                break;
            case 2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left2);
                break;
            case 3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left3);
                break;
            case 4:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left4);
                break;
            case 5:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left5);
                break;
            case 6:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left6);
                break;
            case 7:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left7);
                break;
            case 8:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left8);
                break;
            case 9:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left9);
                break;
            case 10:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left10);
                break;
            case 11:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left11);
                break;
            case 12:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winlev_left12);
                break;
        }
    }

    private void ShowAirRightWinlev() {
        switch (DataCanbus.DATA[25]) {
            case 1:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right1);
                break;
            case 2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right2);
                break;
            case 3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right3);
                break;
            case 4:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right4);
                break;
            case 5:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right5);
                break;
            case 6:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right6);
                break;
            case 7:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right7);
                break;
            case 8:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right8);
                break;
            case 9:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right9);
                break;
            case 10:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right10);
                break;
            case 11:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right11);
                break;
            case 12:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winlev_right12);
                break;
        }
    }

    private void ShowAirLeftWinMode() {
        switch (DataCanbus.DATA[77]) {
            case 0:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left0);
                break;
            case 1:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left1);
                break;
            case 2:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left2);
                break;
            case 3:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left3);
                break;
            case 4:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left4);
                break;
            case 5:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left5);
                break;
            case 6:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left6);
                break;
            case 7:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left7);
                break;
            case 8:
                this.mImageAirLeft.setBackgroundResource(R.drawable.audi_winmode_left8);
                break;
        }
    }

    private void ShowAirRightWinMode() {
        switch (DataCanbus.DATA[87]) {
            case 0:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right0);
                break;
            case 1:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right1);
                break;
            case 2:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right2);
                break;
            case 3:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right3);
                break;
            case 4:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right4);
                break;
            case 5:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right5);
                break;
            case 6:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right6);
                break;
            case 7:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right7);
                break;
            case 8:
                this.mImageAirRight.setBackgroundResource(R.drawable.audi_winmode_right8);
                break;
        }
    }

    private void ClearTextLeftShow() {
        this.mTextTempLeft.setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_unit)).setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_left_pic)).setText("");
    }

    private void ClearTextRightShow() {
        this.mTextTempRight.setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_unit)).setText("");
        ((TextView) this.sWarnContent.findViewById(R.id.tv_airtemp_right_pic)).setText("");
    }
}
