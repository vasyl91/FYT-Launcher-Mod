package com.android.launcher66

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.media.AudioManager
import android.media.MediaMetadata
import android.media.MediaMetadataRetriever
import android.media.session.MediaController
import android.media.session.MediaSessionManager
import android.media.session.PlaybackState
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.service.notification.NotificationListenerService
import android.util.Log
import androidx.annotation.CallSuper
import androidx.core.content.edit
import androidx.core.graphics.createBitmap
import androidx.preference.PreferenceManager
import com.android.launcher66.settings.Helpers
import com.fyt.car.LauncherNotify
import com.fyt.car.MusicService
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.lang.ref.WeakReference
import java.util.concurrent.atomic.AtomicBoolean

class NotificationListener : NotificationListenerService() {
    
    private lateinit var sessionListener: SessionListener
    private var contextRef = WeakReference<Context>(null)
    private var handler: Handler? = null
    private var handlerControllerTime: Handler? = null
    private var handlerFytTime: Handler? = null
    private var mediaSessionManager: MediaSessionManager? = null
    private var settings: SharedPreferences? = null
    private var audioManager: AudioManager? = null

    private var song: String? = ""
    private var songCur: String? = ""
    private var songFyt: String? = ""
    private var artist: String? = ""
    private var controllers: MutableList<MediaController>? = null
    private var mediaController: MediaController? = null
    private var meta: MediaMetadata? = null
    private var mState: Int? = 0
    private var count: Int = 0
    private var counter: Int = 0
    private var currentState: Int? = 0
    private var paused: Boolean = false
    private var componentName = ComponentName("com.android.launcher66", "com.android.launcher66.NotificationListener")
    private var helpers: Helpers = Helpers()

    private var fytState: Boolean = false
    private var fytSet: Boolean = false
    private var musicName: String? = ""
    private var authorName: String? = ""
    private var album: String? = ""
    private var fytData: Boolean = true
    private var isReceiverRegistered = false
    private var isSessionListenerRegistered = false
    private var isCleanedUp = false
    private var verifyIfLive = false
    private val destroyed = AtomicBoolean(false)

    var musicState: String? = ""
    var musicNamePrev: String = ""
    var curMinutes: Long = 0
    var prevCurFyt: Long = 0
    var prevMinutes: Long = 0

    var totalMinutes: Long = 0
    var musicPath = ""
    var albumCover: ByteArray? = null
    var source = ""    

    var fytAlbum = ""
    var fytMusicPath = ""
    var pathName = ""
    var fytAlbumCover: ByteArray? = null
    var fytSource = ""
    var fytTotalMinutes: Long = 0
    var fytCurMinutes: Long = 0
    var activeControllerPackage = ""

    override fun onCreate() {  
        super.onCreate()   
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onListenerConnected() {    
        super.onListenerConnected() 
        isCleanedUp = false
        contextRef = WeakReference(this)
        paused = false

        audioManager = getSystemService(AUDIO_SERVICE) as? AudioManager

        settings = PreferenceManager.getDefaultSharedPreferences(this)

        handlerControllerTime = Handler(Looper.getMainLooper())
        handlerFytTime = Handler(Looper.getMainLooper())

        mediaSessionManager = getSystemService(MEDIA_SESSION_SERVICE) as? MediaSessionManager
        sessionListener = SessionListener(this)
        if (!destroyed.get() && !isSessionListenerRegistered) {
            try {
                mediaSessionManager?.addOnActiveSessionsChangedListener(sessionListener, componentName)
                isSessionListenerRegistered = true
            } catch (e: Exception) {
                Log.e("NotificationListener", "Error registering session listener: ${e.message}")
            }
        }
        controllers = mediaSessionManager?.getActiveSessions(componentName)
        mediaController = pickController(controllers)
        mediaController?.let {
            it.registerCallback(callback)
            meta = it.metadata
            try {
                mState = it.playbackState?.state
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            }
            // update widget if the music is already playing
            if (meta != null && mState == PlaybackState.STATE_PLAYING) {
                Handler(Looper.getMainLooper()).postDelayed({
                    if (!helpers.returnControllerTimeBool()) {
                        helpers.updateControllerTimeBool(true)
                        handlerControllerTime?.post(updateControllerTime)
                    }
                    setStatus(2)
                }, 2000)
            }
            if (MusicService.state && MusicService.music_name != "" && MusicService.music_name != "Unknown") {
                Handler(Looper.getMainLooper()).postDelayed({
                    handlerFytTime?.post(updateFytTime)
                    setStatus(1)
                }, 2000)
            }
        }

        handler = Handler(Looper.getMainLooper())
        handler?.post(runTask)

        if (!isReceiverRegistered) {
            val intentFilter = IntentFilter().apply {
                addAction("titlesInternal")
                addAction("media.play.play")
                addAction("media.play.pause")
                addAction("media.play.next")
                addAction("media.play.previous")
            }
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    registerReceiver(mediaReceiver, intentFilter, RECEIVER_EXPORTED)
                } else {
                    registerReceiver(mediaReceiver, intentFilter)
                }
                isReceiverRegistered = true
            } catch (e: Exception) {
                Log.e("NotificationListener", "Error registering receiver: ${e.message}")
            }
        }
    }  

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        cleanupResources()
    }

    @CallSuper
    override fun onDestroy() {  
        destroyed.set(true)
        cleanupResources()  
        super.onDestroy()
    }

    private fun cleanupResources() { 
        if (isCleanedUp) return
        isCleanedUp = true

        safeUnregisterReceiver()
        safeUnregisterSessionListener()

        mediaController?.unregisterCallback(callback)
        mediaController = null

        handler?.removeCallbacksAndMessages(null)
        handlerControllerTime?.removeCallbacksAndMessages(null)
        handlerFytTime?.removeCallbacksAndMessages(null)

        handler = null
        handlerControllerTime = null
        handlerFytTime = null

        controllers?.clear()
        controllers = null

        helpers.updateControllerTimeBool(false)
        contextRef.clear()

        meta = null
        musicState = null
        musicName = null
        authorName = null
        album = null
        song = null
        songCur = null
        songFyt = null
        artist = null
        albumCover = null
        fytAlbumCover = null

        audioManager = null
        mediaSessionManager = null
        settings = null
    }

    private fun safeUnregisterReceiver() {
        if (isReceiverRegistered) {
            try {
                unregisterReceiver(mediaReceiver)
                isReceiverRegistered = false
            } catch (e: IllegalArgumentException) {
                Log.w("NotificationListener", "Receiver already unregistered: ${e.message}")
            }
        }
    } 

    private fun safeUnregisterSessionListener() {
        if (isSessionListenerRegistered) {
            try {
                mediaSessionManager?.removeOnActiveSessionsChangedListener(sessionListener)
                isSessionListenerRegistered = false
            } catch (e: IllegalArgumentException) {
                Log.w("NotificationListener", "Session listener already removed or not registered: ${e.message}")
            } catch (e: Exception) {
                Log.e("NotificationListener", "Error removing session listener: ${e.message}")
            }
        }
    } 
   
    private val mediaReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            /** data from the stock music player (com.syu.music) handled by com.fyt.car.MusicService
            *   It is essential to use MediaMetadataRetriever because stock music player doesn't process
            *   cheracters specific to particular language (ö, ó, ü, ß, ñ etc) and sends chinese signs instead.
            */
            if (intent.action == "titlesInternal") {
                val retriever = MediaMetadataRetriever()
                val bundle = intent.extras ?: return
                fytState = bundle.getBoolean("play_state", false) 
                fytMusicPath = bundle.getString("play_path") ?: ""
                fytSource = bundle.getString("source") ?: ""
                fytCurMinutes = bundle.getLong("play_cur", 0L)
                
                val file = File(fytMusicPath)
                if (file.exists()) {
                    try {
                        FileInputStream(file).use { fis ->
                            retriever.setDataSource(fis.fd, 0, file.length())
                        }    
                    } catch (e: IllegalArgumentException) {
                        e.printStackTrace()
                        retriever.setDataSource(fytMusicPath)
                    } finally {                   
                        musicName = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)
                        authorName = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
                        fytAlbum = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)
                            .toString()
                        retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
                            ?.let { fytTotalMinutes = it.toLong() }

                        if (musicNamePrev != musicName) {
                            musicNamePrev = musicName.toString()
                            prevCurFyt = 0
                        }

                        val filename = file.getName()
                        if (filename.isNotEmpty() && filename.contains(".")) {
                            pathName = filename.substring(0, filename.lastIndexOf("."))
                        }

                        if (currentState == PlaybackState.STATE_PLAYING) {
                            mediaController?.transportControls?.pause()
                        }

                        if (musicName!!.isNotEmpty() && !musicName!!.contains("Unknown")  && !musicName!!.contains("null")) {
                            fytSet = false
                        } 
                        if (fytState && !fytSet && helpers.isFytMusicAllowed()  && musicName!!.isNotEmpty() && musicName != "Unknown" && musicName != "null") {
                            handlerControllerTime?.removeCallbacks(updateControllerTime)  
                            helpers.updateControllerTimeBool(false)
                            fytSet = true
                            setStatus(1)
                            handlerFytTime?.post(updateFytTime)             
                        } 
                        retriever.release()
                    }
                }
            // commands for the media players (other than the stock one)
            } else if (intent.action == "media.play.play") {
                mediaController?.transportControls?.play()
            } else if (intent.action == "media.play.pause") {
                mediaController?.transportControls?.pause()
            } else if (intent.action == "media.play.next") {
                mediaController?.transportControls?.skipToNext()
            } else if (intent.action == "media.play.previous") {
                mediaController?.transportControls?.skipToPrevious()
            }
        }
    }   

    /** from what I tested, only killing the stock player will guarantee stopping it
    *   from playing music. Calling "com.syu.music.playpause" or killing just background 
    *   processes sometimes results in resuming the music and interrupting other players.
    */ 
    private fun stopFytMusic() {
        if (MusicService.state) { 
            val context = contextRef.get()
            val activityManager = context?.getSystemService(ACTIVITY_SERVICE) as? ActivityManager
            
            try {
                val method = activityManager?.javaClass?.getDeclaredMethod(
                    "forceStopPackage",
                    String::class.java
                )
                method?.invoke(activityManager, "com.syu.music")
            } catch (e: ReflectiveOperationException) {
                e.printStackTrace()
            } catch (e: SecurityException) {
                e.printStackTrace()
            }
            
            fytAlbum = ""
            fytMusicPath = ""
            pathName = ""
            fytAlbumCover = null
            fytSource = ""
            fytTotalMinutes = 0
            fytCurMinutes = 0
        }
    }

    // Stopping the radio is necessary for music apps that use media controller to gain the audio focus back
    private fun stopRadio(): Boolean {
        val context = contextRef.get() ?: return false
        val activityManager = context.getSystemService(ACTIVITY_SERVICE) as? ActivityManager ?: return false
        
        // Check if radio app is actually running
        val isRadioRunning = activityManager.runningAppProcesses?.any {
            it.processName == "com.syu.radio"
        } == true
        
        if (!isRadioRunning) return false

        try {
            val method = activityManager.javaClass.getDeclaredMethod(
                "forceStopPackage",
                String::class.java
            )
            method.invoke(activityManager, "com.syu.radio")
            
            return true
        } catch (e: Exception) {
            Log.e("NotificationListener", "Error stopping radio: ${e.message}")
            return false
        }
    }

    private val runTask = RunTaskRunnable(this)
    private val updateControllerTime = UpdateControllerTimeRunnable(this)
    private val updateFytTime = UpdateFytTimeRunnable(this)

    private class RunTaskRunnable(service: NotificationListener) : Runnable {
        private val serviceRef = WeakReference(service)
        override fun run() {
            val service = serviceRef.get() ?: return
            if (service.destroyed.get()) return
            val context = service.contextRef.get() ?: return
            val am = context.getSystemService(AUDIO_SERVICE) as? AudioManager ?: return
            if (am.isMusicActive) {
                service.checkActiveSessions()
            }
            service.handler?.postDelayed(this, 10)
        }
    }

    private class UpdateControllerTimeRunnable(service: NotificationListener) : Runnable {
        private val serviceRef = WeakReference(service)
        override fun run() {
            val service = serviceRef.get() ?: return
            if (service.destroyed.get()) return
            val context = service.contextRef.get() ?: return
            val am = context.getSystemService(AUDIO_SERVICE) as? AudioManager ?: return
            if (am.isMusicActive && service.musicState == "true") {
                if (service.curMinutes != service.prevMinutes) {
                    service.prevMinutes = service.curMinutes
                    service.setStatus(2)
                }
            }
            service.handlerControllerTime?.postDelayed(this, 1000)
        }
    }

    private class UpdateFytTimeRunnable(service: NotificationListener) : Runnable {
        private val serviceRef = WeakReference(service)
        override fun run() {
            val service = serviceRef.get() ?: return
            if (service.destroyed.get()) return
            if (MusicService.state) {
                if (service.fytCurMinutes != service.prevCurFyt) {
                    service.prevCurFyt = service.fytCurMinutes
                    service.setStatus(1)
                }
            }
            service.handlerFytTime?.postDelayed(this, 500)
        }
    }

    class StaticMediaControllerCallback(listenerRef: WeakReference<NotificationListener>) : MediaController.Callback() {
        private val serviceRef = listenerRef
        
        override fun onSessionDestroyed() {
            super.onSessionDestroyed()
        }

        override fun onMetadataChanged(metadata: MediaMetadata?) {
            val service = serviceRef.get() ?: return
            if (service.destroyed.get()) return
            super.onMetadataChanged(metadata)
            service.prevMinutes = 0
            service.helpers.setCounter(0)
            service.meta = metadata
            set()
        }

        override fun onPlaybackStateChanged(state: PlaybackState?) {
            val service = serviceRef.get() ?: return
            if (service.destroyed.get()) return
            super.onPlaybackStateChanged(state)
            service.currentState = state?.state
            service.prevMinutes = 0
            if (service.currentState == PlaybackState.STATE_PAUSED) {
                val intent = Intent("pause.button")
                service.sendBroadcast(intent)
                service.settings?.edit {
                    this.putInt("prevState", service.currentState!!)
                }
                service.helpers.setCounter(0)
            } else {
                set()
            }
        }

        fun set() {  
            val service = serviceRef.get() ?: return
            service.stopFytMusic()
            service.stopRadio()
            service.handlerFytTime?.removeCallbacks(service.updateFytTime)

            if (service.currentState == PlaybackState.STATE_PAUSED || service.currentState == PlaybackState.STATE_STOPPED) {  
                service.helpers.setCounter(0)
                service.handlerControllerTime?.removeCallbacks(service.updateControllerTime)
                service.helpers.updateControllerTimeBool(false)
                service.musicState = "false"
            } else if (service.currentState == PlaybackState.STATE_PLAYING) {
                // YoutubeMusic or Spotify (and probably some other music apps) need some delay to load the album art
                Handler(Looper.getMainLooper()).postDelayed({
                    // prevents youtube live to add view every ~second
                    var dur = service.meta?.getLong(MediaMetadata.METADATA_KEY_DURATION)
                    // prevents flickering on adding view
                    var songTest = service.meta?.getString(MediaMetadata.METADATA_KEY_TITLE) 
                    if (songTest != null) {
                        if (songTest.isNotEmpty()) {
                            service.songCur = service.meta?.getString(MediaMetadata.METADATA_KEY_TITLE)
                        }
                    }
                    // prevState: 1 - STOPPED, 2 - PAUSED, 3 - PLAYING
                    if (!service.songCur.equals(service.settings?.getString("songPrev", "prev")) || service.settings?.getInt("prevState", 1) == 2) {
                        service.settings?.edit {
                            this.putString("songPrev", service.songCur)
                            this.putInt("prevState", service.currentState!!)
                        }
                        if (dur != 0.toLong()) { // not live
                            service.musicState = "true"
                            service.setStatus(2)   
                            if (!service.helpers.returnControllerTimeBool()) {
                                service.helpers.updateControllerTimeBool(true)
                                service.handlerControllerTime?.post(service.updateControllerTime)
                            }  
                        } else { // live
                            if (service.helpers.returnCounter() == service.count) {
                                service.helpers.setCounter(service.counter++)
                                service.musicState = "true"
                                service.curMinutes = 0
                                service.setStatus(2)   
                                if (!service.helpers.returnControllerTimeBool()) {
                                    service.helpers.updateControllerTimeBool(true)
                                    service.handlerControllerTime?.post(service.updateControllerTime)
                                }             
                            }
                        }
                    }
                }, 700)
            }
        }
    }

    val callback = StaticMediaControllerCallback(WeakReference(this))

    // mediaSource: 1 - com.syu.music, 2 - other players that use media controller
    fun setStatus(mediaSource: Int) {
        if (mediaSource == 2) {
            fytState = false
            fytSet = true
        }

        if (songFyt != null && fytState && helpers.isFytMusicAllowed() && mediaSource == 1) {
            fytStatus()
        } 

        if (song != null && !fytState && mediaSource == 2)  {
            helpers.setFytMusicAllowed(false)
            Handler(Looper.getMainLooper()).postDelayed({
                helpers.setFytMusicAllowed(true)
            }, 1800) 
            activeControllerPackage = (mediaController?.getPackageName()).toString()
            mediaControllerStatus()
        }  
    }

    fun fytStatus() {
        fytData = settings?.getBoolean("fyt_data", true) != false

        if (fytData) { // from metadata
            songFyt = musicName
            artist = authorName
            if (artist == null || artist?.isEmpty() == true || artist == "Unknown"){
                artist = fytAlbum
            }
            if (artist == null || artist?.isEmpty() == true || artist == "Unknown") {
                artist = "\u0020"
            }       
        } else if (!fytData) { // from file title
            val file = File(fytMusicPath)
            val filename = file.getName()
            songFyt = filename.substring(0, filename.lastIndexOf("."))
            artist = null
        }
        activeControllerPackage = ""
        source = "fyt" 
        
        LauncherNotify.NOTIFIER_MUSIC.set(
            null,
            longArrayOf(fytTotalMinutes, fytCurMinutes),
            null,
            arrayOf((songFyt).toString(), (artist).toString(), (fytState).toString(), fytAlbum, fytMusicPath, activeControllerPackage),
            fytAlbumCover,
            source
        )
    }

    fun mediaControllerStatus() {
        val controller = mediaController ?: run {
            Log.e("NotificationListener", "mediaController is null in mediaControllerStatus")
            return
        }
        val currentMeta = meta ?: run {
            Log.e("NotificationListener", "meta is null in mediaControllerStatus")
            return
        }

        totalMinutes = currentMeta.getLong(MediaMetadata.METADATA_KEY_DURATION)

        controller.playbackState?.let { state ->
            curMinutes = if (totalMinutes == 0L) 0L else state.position
        } ?: run { curMinutes = 0 }

        song = currentMeta.getString(MediaMetadata.METADATA_KEY_TITLE) ?: ""
        artist = currentMeta.getString(MediaMetadata.METADATA_KEY_ARTIST)
        if (artist == null || artist!!.isEmpty()) {
            artist = currentMeta.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST)
        }
        if (artist == null || artist!!.isEmpty()) {
            artist = currentMeta.getString(MediaMetadata.METADATA_KEY_AUTHOR)
        }
        if (artist == null || artist!!.isEmpty()) {
            artist = currentMeta.getString(MediaMetadata.METADATA_KEY_WRITER)
        }
        if (artist == null || artist!!.isEmpty()) {
            artist = currentMeta.getString(MediaMetadata.METADATA_KEY_COMPOSER)
        }
        if (artist == null || artist!!.isEmpty()) {
            artist = "\u0020"
        }
        musicState = "true"
        album = currentMeta.getString(MediaMetadata.METADATA_KEY_ALBUM) ?: ""
        musicPath = ""
        activeControllerPackage = controller.packageName ?: ""

        var bitmap: Bitmap? = currentMeta.getBitmap(MediaMetadata.METADATA_KEY_ART)
        if (bitmap == null) {
            bitmap = currentMeta.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART)
        }
        if (bitmap == null) {
            bitmap = currentMeta.getBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON)
        }
        if (bitmap == null && activeControllerPackage.contains("youtube")) {
            val context = contextRef.get()
            if (context != null) {
                bitmap = getHighResAppIcon(context, activeControllerPackage)
            }
        }

        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 90, stream)
        albumCover = stream.toByteArray()

        source = "mediaController"

        LauncherNotify.NOTIFIER_MUSIC.set(
            null,
            longArrayOf(totalMinutes, curMinutes),
            null,
            arrayOf(song, artist, musicState, album, musicPath, activeControllerPackage),
            albumCover,
            source
        )
        paused = false

        if (totalMinutes == 0.toLong() && !verifyIfLive) {
            verifyIfLive = true
            Handler(Looper.getMainLooper()).postDelayed({
                mediaControllerStatus()
            }, 500)      
            Handler(Looper.getMainLooper()).postDelayed({
                verifyIfLive = false
            }, 700)    
        }
    }

    @Throws(PackageManager.NameNotFoundException::class)
    fun getHighResAppIcon(context: Context, packageName: String): Bitmap {
        val pm = context.packageManager
        val appInfo = pm.getApplicationInfo(packageName, 0)
        var iconDrawable: Drawable? = null

        if (appInfo.icon != 0) {
            try {
                val resources = pm.getResourcesForApplication(appInfo)
                val densities = intArrayOf(640, 480, 320, 240, 160)  // From XXXHIGH to MEDIUM

                for (density in densities) {
                    iconDrawable = try {
                        resources.getDrawableForDensity(appInfo.icon, density, context.theme)
                    } catch (e: Resources.NotFoundException) {
                        null
                    }
                    if (iconDrawable != null) break
                }
            } catch (e: Exception) {
                Log.e("NotificationListener", "Error getting high res icon: ${e.message}")
            }
        }

        // Fallback to default icon if there's no hugh res icon
        iconDrawable = iconDrawable ?: pm.getApplicationIcon(packageName)

        return drawableToBitmap(iconDrawable)
    }
    
    fun drawableToBitmap(drawable: Drawable?): Bitmap {
        val bitmap = createBitmap(drawable!!.intrinsicWidth, drawable.intrinsicHeight)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun checkActiveSessions() {
        val ctrlrs: MutableList<MediaController>? = mediaSessionManager?.getActiveSessions(componentName)
        sessionListener.onActiveSessionsChanged(ctrlrs)
    }

    private fun pickController(controllers: MutableList<MediaController>?): MediaController? {
        if (controllers == null) return null
        for (mc in controllers) {
            if (mc.playbackState != null && mc.playbackState?.state == PlaybackState.STATE_PLAYING) {
                return mc
            }
        }
        return if (controllers.isNotEmpty()) controllers[0] else null
    }

    class SessionListener(service: NotificationListener) : MediaSessionManager.OnActiveSessionsChangedListener {
        private val serviceRef = WeakReference(service)

        override fun onActiveSessionsChanged(controllers: MutableList<MediaController>?) {
            val service = serviceRef.get() ?: return
            if (service.destroyed.get() || service.isCleanedUp) return
            if (!controllers.isNullOrEmpty()) {
                if (service.mediaController != null && controllers[0].sessionToken != service.mediaController?.sessionToken) {
                    // Detach current controller
                    service.mediaController?.unregisterCallback(service.callback)
                    service.mediaController = null
                }

                if (service.mediaController == null) {
                    // Attach new controller
                    service.mediaController = service.pickController(controllers)
                    service.mediaController?.registerCallback(service.callback)
                    service.mediaController?.metadata?.let { service.callback.onMetadataChanged(it) }
                    service.mediaController?.playbackState?.let { service.callback.onPlaybackStateChanged(it) }
                }
            }
        }
    }
}