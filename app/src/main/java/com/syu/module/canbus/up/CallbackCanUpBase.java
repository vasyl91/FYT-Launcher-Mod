package com.syu.module.canbus.up;

import com.syu.ipc.IModuleCallback;

public abstract class CallbackCanUpBase extends IModuleCallback.Stub {
    public abstract void in();

    public abstract void out();
}
