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
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.service.notification.NotificationListenerService
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.android.launcher66.settings.Helpers
import com.fyt.car.LauncherNotify
import com.fyt.car.MusicService
import share.ResValue
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.charset.StandardCharsets

class NotificationListener : NotificationListenerService() {
    
    private lateinit var context: Context
    private lateinit var handler: Handler
    private lateinit var handlerControllerTime: Handler
    private lateinit var handlerFytTime: Handler
    private lateinit var mediaSessionManager: MediaSessionManager
    private lateinit var settings: SharedPreferences

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
    private var componentName: ComponentName? = null
    private var helpers: Helpers = Helpers()

    private var fytState: Boolean = false
    private var fytSet: Boolean = false
    private var musicName: String? = ""
    private var authorName: String? = ""
    private var album: String? = ""
    private var fytData: Boolean = true

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

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {  
        super.onStartCommand(intent, flags, startId)
        
        if (componentName == null) {
            componentName = ComponentName(this, this::class.java)
        }
        
        componentName?.let {  
            requestRebind(it)  
            toggleNotificationListenerService(it)  
        }  
        return START_REDELIVER_INTENT  
    }

    private fun toggleNotificationListenerService(componentName: ComponentName) {  
        val pm = packageManager  
        pm.setComponentEnabledSetting(
            componentName,  
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP   
        )  
        pm.setComponentEnabledSetting(
            componentName,  
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP  
        )  
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        sessionListener.let {
            mediaSessionManager.removeOnActiveSessionsChangedListener(it)
        }
        handler.removeCallbacks(runTask)
        if (componentName == null) {  
            componentName = ComponentName(this, this::class.java)  
        }  
        componentName?.let { requestRebind(it) }
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onListenerConnected() {    
        super.onListenerConnected()  
        this.context = this
        paused = false

        settings = PreferenceManager.getDefaultSharedPreferences(this)

        handlerControllerTime = Handler(Looper.getMainLooper())
        handlerFytTime = Handler(Looper.getMainLooper())

        mediaSessionManager = getSystemService(MEDIA_SESSION_SERVICE) as MediaSessionManager
        mediaSessionManager.addOnActiveSessionsChangedListener(sessionListener, componentName)
        controllers = mediaSessionManager.getActiveSessions(componentName)
        mediaController = pickController(controllers!!)
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
                        handlerControllerTime.post(updateControllerTime)
                    }
                    setStatus(2)
                }, 2000)
            }
            if (MusicService.state && MusicService.music_name != "" && MusicService.music_name != "Unknown") {
                Handler(Looper.getMainLooper()).postDelayed({
                    handlerFytTime.post(updateFytTime)
                    setStatus(1)
                }, 2000)
            }
            
        }

        handler = Handler(Looper.getMainLooper())
        handler.post(runTask)

        val intentFilter = IntentFilter("titlesInternal")
        intentFilter.addAction("media.play.play")
        intentFilter.addAction("media.play.pause")
        intentFilter.addAction("media.play.next")
        intentFilter.addAction("media.play.previous")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(mediaReceiver, intentFilter, RECEIVER_EXPORTED)
        } else {
            registerReceiver(mediaReceiver, intentFilter)
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
                val bundle: Bundle? = intent.extras!!
                fytState = bundle?.getBoolean("play_state")!!
                fytMusicPath = bundle.getString("play_path")!!
                fytSource = bundle.getString("source")!!
                fytCurMinutes = bundle.getLong("play_cur")

                try {
                    retriever.setDataSource(fytMusicPath)
                    
                    musicName = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)
                    authorName = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
                    fytAlbum = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)
                    fytTotalMinutes = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION).toLong()


                    if (musicNamePrev != musicName) {
                        musicNamePrev = musicName.toString()
                        prevCurFyt = 0
                    }

                    val file = File(fytMusicPath)
                    val filename = file.getName()
                    if (filename.isNotEmpty() && filename.contains(".")) {
                        pathName = filename.substring(0, filename.lastIndexOf("."))
                    }

                    if (currentState == PlaybackState.STATE_PLAYING) {
                        mediaController?.getTransportControls()?.pause()
                    }

                    if (musicName!!.isNotEmpty() && !musicName!!.contains("Unknown")  && !musicName!!.contains("null")) {
                        fytSet = false
                    } 
                    if (fytState && !fytSet && helpers.isFytMusicAllowed()  && musicName!!.isNotEmpty() && musicName != "Unknown" && musicName != "null") {
                        handlerControllerTime.removeCallbacks(updateControllerTime)  
                        helpers.updateControllerTimeBool(false)
                        fytSet = true
                        setStatus(1)
                        handlerFytTime.post(updateFytTime)             
                    }  
                } catch (e: IllegalArgumentException) {
                    e.printStackTrace()
                } finally {
                    retriever.release()
                }
            // commands for madia players (other than the stock one)
            } else if (intent.action == "media.play.play") {
                mediaController?.getTransportControls()?.play()
            } else if (intent.action == "media.play.pause") {
                mediaController?.getTransportControls()?.pause()
            } else if (intent.action == "media.play.next") {
                mediaController?.getTransportControls()?.skipToNext()
            } else if (intent.action == "media.play.previous") {
                mediaController?.getTransportControls()?.skipToPrevious()
            }
        }
    }   

    /** from what I tested, only killing the stock player will guarantee stopping it
    *   from playing music. Calling "com.syu.music.playpause" or killing just background 
    *   processes sometimes results in resuming the music and interrupting other players.
    */ 
    private fun stopFytMusic() {
        if (MusicService.state) { 
            val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
            //activityManager?.killBackgroundProcesses("com.syu.music")
            try {
                val method = activityManager?.javaClass?.getDeclaredMethod(
                    "forceStopPackage",
                    String::class.java
                )
                method?.invoke(activityManager, "com.syu.music")
            } catch (e: ReflectiveOperationException) {
                // Handle exceptions (e.g., method not found, permission denied)
                e.printStackTrace()
            } catch (e: SecurityException) {
                // Handle security exceptions
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

    override fun onDestroy() {
        sessionListener.let {
            if (this::mediaSessionManager.isInitialized) {
                mediaSessionManager.removeOnActiveSessionsChangedListener(it)
            }
        }
        if (this::handler.isInitialized) {
            handler.removeCallbacks(runTask)
        }
        if (this:: handlerControllerTime.isInitialized) {
            handlerControllerTime.removeCallbacks(updateControllerTime)
        }
        if (this::handlerFytTime.isInitialized) {
            handlerFytTime.removeCallbacks(updateFytTime)
        }
        helpers.updateControllerTimeBool(false)
        unregisterReceiver(mediaReceiver)
    }

    private val runTask = object : Runnable {
        override fun run() {
            val am = context.getSystemService(AUDIO_SERVICE) as AudioManager
            if (am.isMusicActive) {
                // onActiveSessionsChanged switches between sources flawlessly as long as music continues to play,
                // it doesn't switch when user has paused the track from previous music source before playing the new one
                checkActiveSessions()
            }
            handler.postDelayed(this, 10)
        }
    }

    private val updateControllerTime = object : Runnable {
        override fun run() {
            val am = context.getSystemService(AUDIO_SERVICE) as AudioManager
            if (am.isMusicActive && musicState == "true") {
                if (curMinutes != prevMinutes) {
                    prevMinutes = curMinutes
                    setStatus(2)
                }
            }
            handlerControllerTime.postDelayed(this, 1000)
        }
    }

    private val updateFytTime = object : Runnable {
        override fun run() {
            if (MusicService.state) {
                if (fytCurMinutes != prevCurFyt) {
                    prevCurFyt = fytCurMinutes
                    setStatus(1)
                }
            }
            handlerFytTime.postDelayed(this, 500)
        }
    }

    private var callback: MediaController.Callback = object : MediaController.Callback() {
        override fun onSessionDestroyed() {
            super.onSessionDestroyed()
        }

        override fun onMetadataChanged(metadata: MediaMetadata?) {
            super.onMetadataChanged(metadata)
            prevMinutes = 0
            helpers.setCounter(0)
            meta = metadata
            set()
        }

        override fun onPlaybackStateChanged(state: PlaybackState?) {
            super.onPlaybackStateChanged(state)
            currentState = state?.state
            prevMinutes = 0
            if (currentState == PlaybackState.STATE_PAUSED) {
                val editor = settings.edit()
                editor.putInt("prevState", currentState!!)
                editor.apply()
                helpers.setCounter(0)
            } else {
                set()
            }
        }

        fun set() {  
            stopFytMusic()
            handlerFytTime.removeCallbacks(updateFytTime)
            if (currentState == PlaybackState.STATE_PAUSED || currentState == PlaybackState.STATE_STOPPED) {  
                helpers.setCounter(0)
                handlerControllerTime.removeCallbacks(updateControllerTime)
                helpers.updateControllerTimeBool(false)
                musicState = "false"
            } else if (currentState == PlaybackState.STATE_PLAYING) {
                // prevents youtube live to add view every ~second
                var dur = meta?.getLong(MediaMetadata.METADATA_KEY_DURATION)
                // prevents flickering on adding view
                var songTest = meta?.getString(MediaMetadata.METADATA_KEY_TITLE) 
                if (songTest != null) {
                    if (songTest.isNotEmpty()) {
                        songCur = meta?.getString(MediaMetadata.METADATA_KEY_TITLE)
                    }
                }
                // prevState: 1 - STOPPED, 2 - PAUSED, 3 - PLAYING
                if (!songCur.equals(settings.getString("songPrev", "prev")) || settings.getInt("prevState", 1) == 2) {
                    val editor = settings.edit()
                    editor.putString("songPrev", songCur)
                    editor.putInt("prevState", currentState!!)
                    editor.apply()
                    if (dur != 0.toLong()) { // not live
                        musicState = "true"
                        setStatus(2)   
                        if (!helpers.returnControllerTimeBool()) {
                            helpers.updateControllerTimeBool(true)
                            handlerControllerTime.post(updateControllerTime)
                        }  
                    } else { // live
                        if (helpers.returnCounter() == count) {
                            helpers.setCounter(counter++)
                            musicState = "true"
                            curMinutes = 0
                            setStatus(2)   
                            if (!helpers.returnControllerTimeBool()) {
                                helpers.updateControllerTimeBool(true)
                                handlerControllerTime.post(updateControllerTime)
                            }             
                        }
                    }
                }
            }
        }
    }

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
            }, 2500) 
            activeControllerPackage = (mediaController?.getPackageName()).toString()
            if (activeControllerPackage.contains("com.spotify.music") || activeControllerPackage.contains("youtube.music")) {
                Handler(Looper.getMainLooper()).postDelayed({
                    mediaControllerStatus()
                }, 700)
            } else {
                mediaControllerStatus()
            }
            
        }  
    }

    fun fytStatus() {
        fytData = settings.getBoolean("fyt_data", true)

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
        totalMinutes = meta!!.getLong(MediaMetadata.METADATA_KEY_DURATION)
        mediaController!!.playbackState?.let {
            curMinutes = if (totalMinutes == 0.toLong()) {
                0.toLong()
            } else {
                it.position
            }
        }
        song = meta?.getString(MediaMetadata.METADATA_KEY_TITLE) 
        artist = meta?.getString(MediaMetadata.METADATA_KEY_ARTIST) 
        if (artist == null || artist?.isEmpty() == true){
            artist = meta?.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST)
        }
        if (artist == null || artist?.isEmpty() == true) {
            artist = meta?.getString(MediaMetadata.METADATA_KEY_AUTHOR)
        }
        if (artist == null || artist?.isEmpty() == true) {
            artist = meta?.getString(MediaMetadata.METADATA_KEY_WRITER)
        }
        if (artist == null || artist?.isEmpty() == true) {
            artist = meta?.getString(MediaMetadata.METADATA_KEY_COMPOSER)
        }
        if (artist == null || artist?.isEmpty() == true) {
            artist = "\u0020"
        }
        musicState = "true"   
        album = meta?.getString(MediaMetadata.METADATA_KEY_ALBUM)
        musicPath = ""
        activeControllerPackage = (mediaController?.getPackageName()).toString()
      
        var bitmap = meta?.getBitmap(MediaMetadata.METADATA_KEY_ART)
        if (bitmap == null) {
            bitmap = meta?.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART)
        }
        if (bitmap == null) {
            bitmap = meta?.getBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON)
        }
        // youtube bitmap is always null
        if (bitmap == null && activeControllerPackage.contains("youtube")) {
            bitmap = drawableToBitmap(ContextCompat.getDrawable(this, ResValue.getInstance().youtube_logo))
        }

        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 90, stream)
        albumCover = stream.toByteArray()
        
        source = "mediaController"

        LauncherNotify.NOTIFIER_MUSIC.set(
            null,
            longArrayOf(totalMinutes, curMinutes),
            null,
            arrayOf((song).toString(), (artist).toString(), musicState, album, musicPath, activeControllerPackage),
            albumCover,
            source
        )
        paused = false
    }
    
    fun drawableToBitmap(drawable: Drawable?): Bitmap {
        val bitmap = Bitmap.createBitmap(drawable!!.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun checkActiveSessions() {
        val ctrlrs: MutableList<MediaController> = mediaSessionManager.getActiveSessions(componentName)
        sessionListener.onActiveSessionsChanged(ctrlrs)
    }

    private fun pickController(controllers: MutableList<MediaController>?): MediaController? {
        for (mc in controllers!!) {
            if (mc.playbackState != null && mc.playbackState?.state == PlaybackState.STATE_PLAYING) {
                return mc
            }
        }
        return if (controllers.isNotEmpty()) controllers[0] else null
    }

    private val sessionListener = MediaSessionManager.OnActiveSessionsChangedListener { controllers ->
        if (controllers!!.isNotEmpty()) {
            if (mediaController != null && controllers[0].sessionToken != mediaController?.sessionToken) {
                // Detach current controller
                mediaController?.unregisterCallback(callback)
                mediaController = null
            }

            if (mediaController == null) {
                // Attach new controller
                mediaController = pickController(controllers)
                mediaController?.registerCallback(callback)
                callback.onMetadataChanged(mediaController?.metadata)
                mediaController?.playbackState?.let { callback.onPlaybackStateChanged(it) }
            }
        }
    }
}