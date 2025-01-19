package com.syu.module.canbus;

import com.syu.ipc.IModuleCallback;

public abstract class CallbackCanbusBase extends IModuleCallback.Stub {
    public abstract void in();

    public abstract void out();
}
