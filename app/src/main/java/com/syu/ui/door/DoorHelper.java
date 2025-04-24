package com.syu.ui.door;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.SecondTickThread;

@SuppressWarnings({"deprecation", "unchecked"})
public class DoorHelper implements IUiNotify, Runnable {
    public static boolean sDisableDoorWindowLocal;
    private int mTick;
    private PopupWindow mWindow;
    public static int sUcDoorEngine = -1;
    public static int sUcDoorFl = -1;
    public static int sUcDoorFr = -1;
    public static int sUcDoorRl = -1;
    public static int sUcDoorRr = -1;
    public static int sUcDoorBack = -1;
    private static int sDoorWindowEnable = 1;
    public static boolean sFlagShowDoorWindow = true;
    private static final DoorHelper INSTANCE = new DoorHelper();
    private final Runnable mHideWindow = new Runnable() { 
        @Override
        public void run() {
            //DoorHelper.this.mWindow.dismiss();
        }
    };
    private final Runnable SHOW = new Runnable() { 
        @Override
        public void run() {
            if (DataCanbus.DATA[DoorHelper.sUcDoorEngine] != 0 || DataCanbus.DATA[DoorHelper.sUcDoorFl] != 0 || DataCanbus.DATA[DoorHelper.sUcDoorFr] != 0 || DataCanbus.DATA[DoorHelper.sUcDoorRl] != 0 || DataCanbus.DATA[DoorHelper.sUcDoorRr] != 0 || DataCanbus.DATA[DoorHelper.sUcDoorBack] != 0) {
                DoorHelper.this.mTick = 6;
                if (!DoorHelper.this.mWindow.isShowing()) {
                    LauncherApplication.addRootView(DoorHelper.this.mWindow);
                    if (LauncherApplication.rootViewWindowToken() != null) {
                        //LauncherApplication.showWindow(DoorHelper.this.mWindow, 17, 0, 0);
                    } else {
                        //HandlerUI.getInstance().postDelayed(this, 1L);
                        return;
                    }
                }
                View view = DoorHelper.this.mWindow.getContentView();
                if (view != null) {
                    view.invalidate();
                    return;
                }
                return;
            }
            DoorHelper.this.mTick = 0;
            if (DoorHelper.this.mWindow.isShowing()) {
                //DoorHelper.this.mWindow.dismiss();
            }
            DataCanbus.PROXY.cmd(FinalCanbus.C_CANBUS_CAR_DOOR, new int[1], null, null);
        }
    };

    public PopupWindow getWindow() {
        return this.mWindow;
    }

    public void initWindow(Context context) {
        if (this.mWindow == null) {
            SecondTickThread.getInstance().addTick(this);
            this.mWindow = new PopupWindow(context);
            this.mWindow.setWidth(-2);
            this.mWindow.setHeight(-2);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mWindow.setOutsideTouchable(true);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { 
                @Override
                public void onDismiss() {
                    //LauncherApplication.removeRootView(DoorHelper.this.mWindow);
                }
            });
        }
    }

    @Override
    public void run() {
        if (this.mTick > 0) {
            this.mTick--;
            if (this.mTick == 0) {
                //hideWindow();
            }
        }
    }

    private void hideWindow() {
        //HandlerUI.getInstance().post(this.mHideWindow);
    }

    public static void disableDoorWindowLocal(boolean flag) {
        if (sDisableDoorWindowLocal != flag) {
            sDisableDoorWindowLocal = flag;
            //calcFlagShowDoorWindow();
        }
    }

    public static void doorWindowEnable(int value) {
        if (sDoorWindowEnable != value) {
            sDoorWindowEnable = value;
            //calcFlagShowDoorWindow();
        }
    }

    private static void calcFlagShowDoorWindow() {
        boolean flag = !sDisableDoorWindowLocal && sDoorWindowEnable != 0;
        if (sFlagShowDoorWindow != flag) {
            sFlagShowDoorWindow = flag;
            if (!flag) {
                //getInstance().hideWindow();
            }
        }
    }

    public static void clearDoorUpdateCode() {
        sUcDoorEngine = -1;
        sUcDoorFl = -1;
        sUcDoorFr = -1;
        sUcDoorRl = -1;
        sUcDoorRr = -1;
        sUcDoorBack = -1;
    }

    public static DoorHelper getInstance() {
        return INSTANCE;
    }

    private DoorHelper() {
    }

    @Override
    public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (sFlagShowDoorWindow && sUcDoorEngine != -1 && sUcDoorFl != -1 && sUcDoorFr != -1 && sUcDoorRl != -1 && sUcDoorBack != -1) {
            showAndRefresh();
        }
        int door = 0;
        if (DataCanbus.DATA[sUcDoorEngine] != 0) {
            door = 0 | 1;
        }
        if (DataCanbus.DATA[sUcDoorFl] != 0) {
            door |= 4;
        }
        if (DataCanbus.DATA[sUcDoorFr] != 0) {
            door |= 8;
        }
        boolean flag = SystemProperties.getBoolean("persist.syu.reversedoor", false);
        if (flag) {
            if (DataCanbus.DATA[sUcDoorRl] != 0) {
                door |= 32;
            }
            if (DataCanbus.DATA[sUcDoorRr] != 0) {
                door |= 16;
            }
        } else {
            if (DataCanbus.DATA[sUcDoorRl] != 0) {
                door |= 16;
            }
            if (DataCanbus.DATA[sUcDoorRr] != 0) {
                door |= 32;
            }
        }
        if (DataCanbus.DATA[sUcDoorBack] != 0) {
            door |= 2;
        }
        DataCanbus.PROXY.cmd(FinalCanbus.C_CANBUS_CAR_DOOR, new int[]{door}, null, null);
        Log.v("zed", "FinalCanbus.C_CANBUS_CAR_DOOR  vallue = " + door);
    }

    public void showAndRefresh() {
        //HandlerUI.getInstance().post(this.SHOW);
    }

    public void buildUi() {
        /*View view = new Door_Default(LauncherApplication.getInstance());
        this.mWindow.dismiss();
        this.mWindow.setContentView(view);*/
    }

    public void destroyUi() {
        //this.mWindow.setContentView(null);
    }
}
