package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UIZHToyotaProace {
    private static UIZHToyotaProace mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIZHToyotaProace getInstance() {
        if (mInstance == null) {
            mInstance = new UIZHToyotaProace();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && DataCanbus.DATA[10] == 0 && DataCanbus.DATA[11] == 0 && DataCanbus.DATA[12] == 0 && DataCanbus.DATA[13] == 0 && DataCanbus.DATA[14] == 0 && DataCanbus.DATA[15] == 0 && DataCanbus.DATA[16] == 0 && DataCanbus.DATA[17] == 0 && DataCanbus.DATA[18] == 0 && DataCanbus.DATA[19] == 0 && DataCanbus.DATA[20] == 0 && DataCanbus.DATA[21] == 0 && DataCanbus.DATA[22] == 0 && DataCanbus.DATA[23] == 0 && DataCanbus.DATA[24] == 0 && DataCanbus.DATA[25] == 0 && DataCanbus.DATA[26] == 0 && DataCanbus.DATA[27] == 0 && DataCanbus.DATA[28] == 0 && DataCanbus.DATA[29] == 0 && DataCanbus.DATA[30] == 0 && DataCanbus.DATA[31] == 0 && DataCanbus.DATA[32] == 0 && DataCanbus.DATA[33] == 0 && DataCanbus.DATA[34] == 0 && DataCanbus.DATA[35] == 0 && DataCanbus.DATA[36] == 0 && DataCanbus.DATA[37] == 0 && DataCanbus.DATA[38] == 0 && DataCanbus.DATA[39] == 0 && DataCanbus.DATA[40] == 0 && DataCanbus.DATA[41] == 0 && DataCanbus.DATA[42] == 0 && DataCanbus.DATA[43] == 0 && DataCanbus.DATA[44] == 0 && DataCanbus.DATA[45] == 0 && DataCanbus.DATA[46] == 0 && DataCanbus.DATA[47] == 0 && DataCanbus.DATA[48] == 0 && DataCanbus.DATA[49] == 0 && DataCanbus.DATA[50] == 0 && DataCanbus.DATA[51] == 0) {
            this.mTextWarn.setText("");
            if (window.isShowing()) {
                window.dismiss();
                return;
            }
            return;
        }
        if (this.sWarnContent != null) {
            WarnUtils.showWindow();
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 10:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Engine fault: Repair needed");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Top up coolant level");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Top up engine oil levet");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Engine oil pressure fault: Stop the vehicle");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Braking system faulty");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Risk of particle filter clogging: see handbook");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Suspension faulty Max speed: 90km/h");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Power steering faulty");
                    break;
                }
            case 11:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Parking brake faulty");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Brake pads worn");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Adjustable wing fault");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("ABS braking system faulty");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("ESP/ASR system faulty");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Suspension faulty");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Power steering faulty");
                    break;
                }
            case 12:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Automatic headlamp adjustment faulty");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Directional Headlamp faulty");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Airbags or pretensioner seat belt faulty");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Gearbox fault: Repair needed");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Apply foot on brake and lever in position N");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Pressence of water in diesel filter: Repair needed");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Engine fault: Repair Needed");
                    break;
                }
            case 13:
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Particle filter additive level too low: Repair needed");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Battery charge or electrical supply faulty");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("车辆靠近");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("行车间距不可测量：巡航功能已激活");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("条件不满足，无法激活");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("巡航功能暂停，重新检测");
                    break;
                }
            case 14:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("速度>150km/h,速度调节关闭");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("记录胎压");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Under inflation Monitoring fault");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("请关门，以便启动自动释放手刹功能");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("请刹车");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Automatic braking deactivated");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Top up emissions additive: Starting prevented in 0km");
                    break;
                }
            case 15:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Top up emissions additive: Starting prevented");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Emissions control fault");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Emissions control fault: Starting prevented in 0km");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Emissions control fault: Starting prevented");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("发动机启动功能停用：环流温度不通");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Reinitialisation impossible when driving");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("动态模式关闭");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("无动态模式");
                    break;
                }
            case 16:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("关闭大灯");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("XX钥匙");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Cruise control not possible: Speed too low");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Control activated not possible: Enter the speed");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Place automatic gearbox in position P");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Risk of ice");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Handbrake!");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Screen wash fluid level too low");
                    break;
                }
            case 17:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Fuel level too low");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Fuel circuit Deactivated");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Remote control battery flat");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Place gearbox in posstion N");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Press the park button and the brake pedal");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Impossible to move roof: Outside temperature too low");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Impossible to move roof: Speed too high");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Impossible to move roof: Boot open");
                    break;
                }
            case 18:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Impossible to move roof: Screen not deployed");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Roof manoeuvre completed");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Complete roof manoeuvre immediately");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Folding roof mechanism faulty");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Operation impossible: Rear screen open");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Anti-rollback system faulty");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Inter-vehicles time measuring impossible: Poor visibility");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Inter-vehicles time measuring impossible: Init in progress");
                    break;
                }
            case 31:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Check the side lamps");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Puncture: Replace or repair the wheel");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Puncture: Replace or repair the wheel");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Puncture: Replace or repair the wheel");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Puncture: Replace or repair the wheel");
                    break;
                }
            case 32:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Check the rear right brake lamp");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Check the main beam lamp");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Check the main beam lamp");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Check the dipped beam lamp");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Check the dipped beam lamp");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Check the rear right brake lamp");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Check the rear right brake lamp");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Check the rear right brake lamp");
                    break;
                }
            case 33:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Check the direction indicators");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Check the direction indicators");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Check the direction indicators");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Check the rear fog lamps");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Check the rear fog lamps");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Check the front fog lamps");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Check the front fog lamps");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Check the rear left brake lamp");
                    break;
                }
            case 34:
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Check the reversing lamps");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Check the reversing lamps");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Check the direction indicators");
                    break;
                }
            case 35:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Adjust the pressure of the tyres");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Adjust the pressure of the tyres");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Parking assistance system fault");
                    break;
                }
            case 36:
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Emissions fault");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Emissions fault: starting prevented");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Emissions fault");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Switch off the lamps");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Adjust the pressure of the tyres");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Adjust the pressure of the tyres");
                    break;
                }
            case 37:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Rear left hand door open");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Rear right hand door open");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Front left hand door open");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Front right hand door open");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Risk of ice");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Place automatic gearbox position P");
                    break;
                }
            case 38:
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Rear screen open");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Collision risk detection open");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Boot open");
                    break;
                }
            case 39:
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Directional headlamps fault");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Automatic braking system fault");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Adjustable wing fault, Speed restricted see handbook");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Parking brake fault: Have the vehicle repaired");
                    break;
                }
            case 40:
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Gearbox fault: Repair needed");
                    break;
                }
            case 41:
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Suspension fault: Limit your speed to 90km/h");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Engine fault: Repair needed");
                    break;
                }
            case 42:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Sensor fault: Rear left tyre pressure not monitored");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Sensor fault: Rear right tyre pressure not monitored");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Sensor fault: Front left tyre pressure not monitored");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Sensor fault: Front right tyre pressure not monitored");
                    break;
                }
            case 43:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Tyre under-intflagtion detection fault");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Engine fault: Stop the vehicle");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Inter-vehicles time measuring fault");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Power steering fault: Have the vehicle repaired");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Suspension fault: Have the vehicle repaired");
                    break;
                }
            case 44:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Refill emissions additive: Start prevented");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Refill emissions additive");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Refill emissions additive");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Left hand front tyre under-inflated: adjust tyre pressures,then reinitialise");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Right hand front tyre under-inflated: adjust tyre pressures,then reinitialise");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Left hand rear tyre under-inflated: adjust tyre pressures,then reinitialise");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Right hand rear tyre under-inflated: adjust tyre pressures,then reinitialise");
                    break;
                }
            case 45:
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Top up coolant level");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Power steering fault: Stop the vehicle");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Braking system fault: Stop the vehicle");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Engine temperature fault: Stop the vehicle");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Engine oil pressures fault: Stop the vehicle");
                    break;
                }
            case 46:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Boot open");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Rear right hand door open");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Rear left hand door open");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Front right hand door open");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Front left hand door open");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Top up engine oil level");
                    break;
                }
            case 47:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Air bag or pretensioning seat belt fault");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Fule level too low");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Have the brake pads changed");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Presence of water in diesel filter: Repair needed");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Battery charge fault: Stop the vehicle");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("ESP/ASR system fault: Have the vehicle repaired");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Rear screen open");
                    break;
                }
            case 48:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Suspension fault: Have the vehicle repaired");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Particle filter additive level too low: Repair needed");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Risk of particle filter clogging: See handbook");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("ABS fault: Have the vehicle repaired");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Engine fault: Repair needed");
                    break;
                }
            case 49:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Roof manoeuvre impossible: System temperature too high");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Electronic engine immobiliser fault");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Steering lock fault: Have the vehicle repaired");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Retractabie roof mechanism fault");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Check the central STOP lamp");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Pre-heating/pre-ventilation deactivated: Fuel level low");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Pre-heating/pre-ventilation deactivated: Battery charge low");
                    break;
                }
            case 50:
                if (((value >> 0) & 1) == 1) {
                    this.mTextWarn.setText("Replace the rmote control battery");
                }
                if (((value >> 1) & 1) == 1) {
                    this.mTextWarn.setText("Top up the screenwash");
                }
                if (((value >> 2) & 1) == 1) {
                    this.mTextWarn.setText("Hybrid system fault: Speed restricted repair needed");
                }
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Hybrid system fault: Repair needed");
                }
                if (((value >> 4) & 1) == 1) {
                    this.mTextWarn.setText("Automatic headlamp height adjustment fault");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Hybrid system fault: Stop the vehicle,see handbook");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Roof manoeuvre impossible: Apply the handbrake");
                }
                if (((value >> 7) & 1) == 1) {
                    this.mTextWarn.setText("Roof manoeuvre impossible: Start the engine");
                    break;
                }
            case 51:
                if (((value >> 3) & 1) == 1) {
                    this.mTextWarn.setText("Tyre under-inflation monitoring fault");
                }
                if (((value >> 5) & 1) == 1) {
                    this.mTextWarn.setText("Trailer connection fault: Repair needed");
                }
                if (((value >> 6) & 1) == 1) {
                    this.mTextWarn.setText("Pre-heating/pre-ventilation deactivated: Set the clock");
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
