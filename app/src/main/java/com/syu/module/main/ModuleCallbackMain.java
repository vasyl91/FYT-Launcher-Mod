package com.syu.module.main;

import android.os.RemoteException;
import android.util.Log;

import com.syu.ipc.IModuleCallback;
import com.syu.module.canbus.Callback_0453_LZ_BBA_All;
import com.syu.module.canbus.Callback_0453_LZ_LandRover_KeepCD;

public class ModuleCallbackMain extends IModuleCallback.Stub {
    private static final ModuleCallbackMain INSTANCE = new ModuleCallbackMain();

    public static ModuleCallbackMain getInstance() {
        return INSTANCE;
    }

    private ModuleCallbackMain() {
    }

    public boolean intsOk(int[] ints, int min) {
        return ints != null && ints.length >= min;
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode < 200) {
            switch (updateCode) {
                case 174:
                    if (intsOk(ints, 1)) {
                        Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0]);
                        if (ints[1] == -2) {
                            Callback_0453_LZ_BBA_All.modevalue = ints[2];
                            Callback_0453_LZ_LandRover_KeepCD.modevalue = ints[2];
                            Log.v("zed", "174  Callback_0453_LZ_BBA_All.modevalue  == " + ints[2]);
                        }
                        HandlerMain.update(updateCode, ints, flts, strs);
                        break;
                    }
                default:
                    if (intsOk(ints, 1)) {
                        HandlerMain.update(updateCode, ints[0]);
                        break;
                    }
            }
        }
    }
}
