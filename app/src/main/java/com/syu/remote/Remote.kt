package com.syu.remote

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Looper
import android.os.RemoteException
import android.util.SparseArray
import com.syu.ipc.IRemoteModule
import com.syu.ipc.IRemoteToolkit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import kotlin.random.Random

sealed class AppEvent {
    data class ConnectionEvent(val connected: Boolean) : AppEvent()
    data class UpdateEvent(
        val module: Int,
        val updateCode: Int,
        val ints: IntArray?,
        val flts: FloatArray?,
        val strs: Array<String>?
    ) : AppEvent()
}

// Global event stream
object GlobalEventStream {
    private val _events = MutableSharedFlow<AppEvent>(extraBufferCapacity = 64)
    val events = _events.asSharedFlow()

    fun tryEmit(event: AppEvent) = _events.tryEmit(event)
}

class Remote private constructor(
    private var mContext: Context,
    private val action: String,
    private val pkgName: String
) : ServiceConnection {
    companion object {
        private val mTools = HashMap<String, Remote>()
        
        fun getAutoTools(mContext: Context): Remote {
            return getAutoTools(mContext, "com.syu.ms.toolkit", "com.syu.ms")
        }

        fun getAutoTools(mContext: Context, action: String, pkgName: String): Remote {
            val key = "$pkgName#$action"
            return mTools.getOrPut(key) { Remote(mContext, action, pkgName) }
        }
    }

    private val CONN_DELAY_TIME_MAX = 1500
    private val CONN_DELAY_TIME_MIN = HttpURLConnection.HTTP_INTERNAL_ERROR
    private val mModules = SparseArray<Module>()
    private var autoConn = true
    private lateinit var looper: Looper
    private lateinit var mHandler: Handler
    private var mToolkit: IRemoteToolkit? = null
    private val commandJob: Job = Job()
    private val commandScope = CoroutineScope(Dispatchers.IO + commandJob)

    init {
        mContext = mContext.applicationContext
        val workThread = HandlerThread("remote connection")
        workThread.start()
        looper = workThread.looper
        mHandler = Handler(looper)
        bind()
    }

    private fun bind() {
        val intent = Intent(action).apply { `package` = pkgName }
        autoConn = true
        mContext.bindService(intent, this, Context.BIND_AUTO_CREATE)
        
        Handler(Looper.getMainLooper()).postDelayed({
            if (autoConn && mToolkit == null) {
                bind()
            }
        }, Random.nextInt(CONN_DELAY_TIME_MIN, CONN_DELAY_TIME_MAX).toLong())
    }

    fun unbind() {
        autoConn = false
        commandJob.cancel()
        mContext.unbindService(this)
    }

    private fun module(moduleid: Int): Module? = mModules.get(moduleid)

    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        mToolkit = IRemoteToolkit.Stub.asInterface(service)
        mToolkit?.let { toolkit ->
            for (moduleid in 0 until 20) {
                try {
                    toolkit.getRemoteModule(moduleid)?.let { imodule ->
                        val module = Module(imodule, RemoteCallback(moduleid))
                        mModules.put(moduleid, module)
                        module.register()
                    }
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }
            GlobalEventStream.tryEmit(AppEvent.ConnectionEvent(true))
        }
    }

    override fun onServiceDisconnected(name: ComponentName) {
        mToolkit = null
        if (autoConn) {
            bind()
        } else {
            GlobalEventStream.tryEmit(AppEvent.ConnectionEvent(false))
        }
    }

    fun observe(module: Int, vararg codes: Int) {
        module(module)?.observe(*codes)
    }

    fun disobserve(module: Int, vararg codes: Int) {
        module(module)?.disobserve(*codes)
    }

    fun command(module: Int, cmdid: Int, ints: IntArray?, flts: FloatArray?, strs: Array<String>?) {
        commandScope.launch {
            module(module)?.command(cmdid, ints, flts, strs)
        }
    }

    fun commad(module: Int, cmdid: Int, vararg params: Int) {
        command(module, cmdid, params, null, null)
    }

    fun isConnected(): Boolean = mToolkit != null

    inner class Module(
        private val module: IRemoteModule,
        private val callback: RemoteCallback
    ) {
        fun register() {
            callback.notifies.clone().let { maps ->
                for (i in 0 until maps.size()) {
                    val code = maps.keyAt(i)
                    val notify = maps.valueAt(i)
                    try {
                        module.register(callback, code, if (notify) 1 else 0)
                    } catch (e: RemoteException) {
                        e.printStackTrace()
                    }
                }
            }
        }

        fun unregister() {
            callback.notifies.clone().let { maps ->
                for (i in 0 until maps.size()) {
                    try {
                        module.unregister(callback, maps.keyAt(i))
                    } catch (e: RemoteException) {
                        e.printStackTrace()
                    }
                }
            }
        }

        fun observe(vararg codes: Int) {
            codes.forEach { code ->
                callback.enable(code)
                try {
                    module.register(callback, code, 1)
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }
        }

        fun disobserve(vararg codes: Int) {
            codes.forEach { code -> callback.disEnable(code) }
        }

        fun command(cmdid: Int, ints: IntArray?, flts: FloatArray?, strs: Array<String>?) {
            try {
                module.cmd(cmdid, ints, flts, strs)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }
}