package com.syu.car;

import android.content.Context;
import com.syu.ipc.data.FinalCanbus;
import com.syu.remote.Callback;
import com.syu.remote.RemoteTools;
import com.syu.util.JTools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class CarStates {
    public static int mCanbusType;
    static CarStates mCar;
    Context mContext;
    public RemoteTools mTools;
    public static int mAppID = 0;
    public static int mAccState = 0;
    public static int mExistCarRadio = 0;
    final int[] MAIN_LOOK_CODE = {0, 28, 39, 50, 4, 101};
    final int[] TV_LOOK_CODE = new int[0];
    final int[] CANBUS_LOOK_CODE = {1000, FinalCanbus.U_EXIST_CAR_RADIO};
    final int[] RADIO_LOOK_CODE = {0, 1, 2, 20, 23, 21};
    final int[] BT_LOOK_CODE = {0, 1, 2, 28, 26, 13, 9};
    final int[] SOUND_LOOK_CODE = {2, 3};
    String mNaviPkg = "";
    int mTvStyle = 0;
    List<String> mHideApps = new ArrayList();
    List<String> mShowApps = new ArrayList();

    public static CarStates getCar(Context context) {
        if (mCar == null) {
            mCar = new CarStates(context);
        }
        return mCar;
    }

    private CarStates(Context context) {
        this.mContext = context;
        this.mTools = new RemoteTools(this.mContext);
        setupMainModule(this.mTools);
        setupTvModule(this.mTools);
        setupcanbusModule(this.mTools);
        setupRadioModule(this.mTools);
        setupBtModule(this.mTools);
        this.mTools.bind();
    }

    void setupMainModule(RemoteTools tools) {
        if (tools != null) {
            tools.enableModule(0, this.MAIN_LOOK_CODE);
            tools.enableModule(4, this.SOUND_LOOK_CODE);
            tools.addRefreshLisenter(0, new Callback.OnRefreshLisenter() { // from class: com.syu.car.CarStates.1
                @Override // com.syu.remote.Callback.OnRefreshLisenter
                public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
                    if (updateCode == 0 && JTools.check(ints, 1)) {
                        if (ints != null && ints.length > 0) {
                            CarStates.mAppID = ints[0];
                            return;
                        }
                        return;
                    }
                    if (updateCode == 50 && ints != null && ints.length > 0) {
                        CarStates.mAccState = ints[0];
                    }
                }
            }, 0, 28, 39, 50);
        }
    }

    void setupcanbusModule(RemoteTools tools) {
        if (tools != null) {
            tools.enableModule(7, this.CANBUS_LOOK_CODE);
            tools.addRefreshLisenter(7, new Callback.OnRefreshLisenter() { // from class: com.syu.car.CarStates.2
                @Override // com.syu.remote.Callback.OnRefreshLisenter
                public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
                    if (updateCode == 1000 && JTools.check(ints, 1)) {
                        CarStates.mCanbusType = ints[0];
                    } else if (updateCode == 1016 && JTools.check(ints, 1)) {
                        CarStates.mExistCarRadio = ints[0];
                    }
                }
            }, 1000, FinalCanbus.U_EXIST_CAR_RADIO);
        }
    }

    void setupTvModule(RemoteTools tools) {
        if (tools != null) {
            tools.enableModule(6, this.TV_LOOK_CODE);
        }
    }

    void setupRadioModule(RemoteTools tools) {
        if (tools != null) {
            tools.enableModule(1, this.RADIO_LOOK_CODE);
        }
    }

    void setupBtModule(RemoteTools tools) {
        if (tools != null) {
            tools.enableModule(2, this.BT_LOOK_CODE);
        }
    }

    public void setTvStyle(int style) {
        this.mTvStyle = style;
    }

    public int getmTvStyle() {
        return this.mTvStyle;
    }

    public void setmNaviPkg(String mNaviPkg) {
        this.mNaviPkg = mNaviPkg;
    }

    public String getmNaviPkg() {
        return this.mNaviPkg;
    }

    public List<String> getHideApps() {
        return this.mHideApps;
    }

    public List<String> getShowApps() {
        return this.mShowApps;
    }

    public RemoteTools getTools() {
        return this.mTools;
    }

    public void addHideApp(String app) {
        if (!this.mHideApps.contains(app)) {
            this.mHideApps.add(app);
        }
    }

    public void removeHideApp(String app) {
        if (this.mHideApps.contains(app)) {
            this.mHideApps.remove(app);
        }
    }

    public void addShowApp(String app) {
        if (!this.mShowApps.contains(app)) {
            this.mShowApps.add(app);
        }
    }

    public void removeShowApp(String app) {
        if (this.mShowApps.contains(app)) {
            this.mShowApps.remove(app);
        }
    }
}
