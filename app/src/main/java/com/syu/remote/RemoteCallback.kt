package com.syu.remote

import android.os.RemoteException
import android.util.SparseArray
import com.syu.ipc.IModuleCallback

class RemoteCallback(private val module: Int) : IModuleCallback.Stub() {
    val notifies = SparseArray<Boolean>()

    @Throws(RemoteException::class)
    override fun update(updateCode: Int, ints: IntArray?, flts: FloatArray?, strs: Array<String>?) {
        if (notifies.get(updateCode, false)) {
            GlobalEventStream.tryEmit(
                AppEvent.UpdateEvent(module, updateCode, ints, flts, strs)
            )
        }
    }

    fun enable(code: Int) {
        if (!notifies.get(code, false)) {
            notifies.put(code, true)
        }
    }

    fun disEnable(code: Int) {
        if (notifies.indexOfKey(code) >= 0) {
            notifies.put(code, false)
        }
    }
}