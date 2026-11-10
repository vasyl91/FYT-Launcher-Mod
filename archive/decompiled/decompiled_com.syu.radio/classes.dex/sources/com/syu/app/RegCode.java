package com.syu.app;

import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.ipc.module.sys.Locate;
import com.lsec.core.ipc.module.sys.Sys;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RegCode {
    static final int[] CODE_Main = {50, 0, 60, 4, 113, 61, 57};
    static final int[] CODE_Radio = {2, 19, 0, 3, 4, 16, 1, 28, 23, 26, 5, 6, 14, 15, 7, 9, 13, 8, 20, 22, 17, 18, 21};
    static final int[] CODE_Locate = new int[1];
    static final int[] CODE_Sys = new int[1];
    public static IRegisterModuleCallBack mRegister_Main = new IRegisterModuleCallBack() { // from class: com.syu.app.RegCode.1
        @Override // com.lsec.core.ipc.IRegisterModuleCallBack
        public void register(IModuleCallback callback) {
            for (int updateCode : RegCode.CODE_Main) {
                Main.PROXY.register(callback, updateCode, 1);
            }
        }
    };
    public static IRegisterModuleCallBack mRegister_Radio = new IRegisterModuleCallBack() { // from class: com.syu.app.RegCode.2
        @Override // com.lsec.core.ipc.IRegisterModuleCallBack
        public void register(IModuleCallback callback) {
            for (int updateCode : RegCode.CODE_Radio) {
                RadioM.PROXY.register(callback, updateCode, 1);
            }
        }
    };
    public static IRegisterModuleCallBack mRegister_Locate = new IRegisterModuleCallBack() { // from class: com.syu.app.RegCode.3
        @Override // com.lsec.core.ipc.IRegisterModuleCallBack
        public void register(IModuleCallback callback) {
            for (int updateCode : RegCode.CODE_Locate) {
                Locate.PROXY.register(callback, updateCode, 1);
            }
        }
    };
    public static IRegisterModuleCallBack mRegister_Sys = new IRegisterModuleCallBack() { // from class: com.syu.app.RegCode.4
        @Override // com.lsec.core.ipc.IRegisterModuleCallBack
        public void register(IModuleCallback callback) {
            for (int updateCode : RegCode.CODE_Sys) {
                Sys.PROXY.register(callback, updateCode, 1);
            }
        }
    };
}
