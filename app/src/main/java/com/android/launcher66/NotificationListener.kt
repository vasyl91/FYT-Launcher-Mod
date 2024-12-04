package com.android.launcher66

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.AudioManager
import android.media.MediaMetadata
import android.media.MediaMetadataRetriever
import android.media.session.MediaController
import android.media.session.MediaSessionManager
import android.media.session.PlaybackState
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.service.notification.NotificationListenerService
import android.util.Log
import android.view.KeyEvent
import androidx.preference.PreferenceManager
import com.fyt.car.LauncherNotify
import com.syu.widget.Widget
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException


@Suppress("DEPRECATION")
class NotificationListener : NotificationListenerService() {
    
    private lateinit var context: Context
    private lateinit var handler: Handler
    private lateinit var handlerTime: Handler
    private lateinit var mediaSessionManager: MediaSessionManager
    private lateinit var settings: SharedPreferences

    private var song: String? = ""
    private var artist: String? = ""
    private var controllers: MutableList<MediaController>? = null
    private var mediaController: MediaController? = null
    private var meta: MediaMetadata? = null
    private val componentName = ComponentName("com.android.launcher66", "com.android.launcher66.NotificationListener")

    private var fytState: Boolean = false
    private var fytSet: Boolean = false
    private var musicName: String? = ""
    private var authorName: String? = ""
    private var album: String? = ""
    private var path: String? = ""
    private var fytData: Boolean = true
    private var fytAllowed: Boolean = true // FYT sometimes updates data with some delay. This Boolean exist to not to interrupt changed media source.

    var musicState: String? = ""
    var curMinutes: Long = 0
    var prevCur: Long = 0

    var totalMinutes: Long = 0
    var musicPath = ""
    var albumCover: ByteArray? = null
    var source = ""    

    var fytAlbum = ""
    var fytMusicPath = ""
    var fytAlbumCover: ByteArray? = null
    var fytSource = ""
    var fytTotalMinutes: Long = 0
    var fytCurMinutes: Long = 0
    var activeControllerPackage = ""


    private lateinit var event: KeyEvent

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        sessionListener.let {
            mediaSessionManager.removeOnActiveSessionsChangedListener(it)
        }
        handler.removeCallbacks(runTask)
        requestRebind(ComponentName(this, NotificationListenerService::class.java))
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate() {
        super.onCreate()
        this.context = this

        settings = PreferenceManager.getDefaultSharedPreferences(this)

        mediaSessionManager = getSystemService(MEDIA_SESSION_SERVICE) as MediaSessionManager
        mediaSessionManager.addOnActiveSessionsChangedListener(sessionListener, componentName)
        controllers = mediaSessionManager.getActiveSessions(componentName)
        mediaController = pickController(controllers!!)
        mediaController?.let {
            it.registerCallback(callback)
            meta = it.metadata
            if (meta != null) {
                Handler(Looper.getMainLooper()).postDelayed({
                    setStatus(2)
                }, 2000)
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    setStatus(1)
                }, 2000)
            }
            
        }

        handler = Handler()
        handler.post(runTask)

        handlerTime = Handler()
        

        val intentFilter = IntentFilter("titlesReceiver")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(fytReceiver, intentFilter, RECEIVER_EXPORTED)
        } else {
            registerReceiver(fytReceiver, intentFilter)
        }
    } 

    private val fytReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == "titlesReceiver") {
                val bundle: Bundle? = intent.extras!!
                musicName = bundle?.getString("title")!!
                authorName = bundle.getString("play_artist")!!
                fytState = bundle.getBoolean("play_state")
                fytAlbum = bundle.getString("play_album")!!     
                fytMusicPath = bundle.getString("play_path")!!
                fytSource = bundle.getString("source")!!
                fytTotalMinutes = bundle.getLong("play_total")
                fytCurMinutes = bundle.getLong("play_cur")

                val file = File(fytMusicPath)
                val filename = file.getName()
                val pathName = filename.substring(0, filename.lastIndexOf("."))
                if (musicName!!.isNotEmpty() && musicName != "Unknown" && song != musicName && song != pathName) {
                    fytSet = false
                } 
                if(fytState && !fytSet && fytAllowed  && musicName!!.isNotEmpty() && musicName != "Unknown") { 
                    handler.removeCallbacks(updateTime)  
                    fytSet = true
                    setStatus(1)             
                }   
            }
        }
    }   

    override fun onDestroy() {
        sessionListener.let {
            mediaSessionManager.removeOnActiveSessionsChangedListener(it)
        }
        handler.removeCallbacks(runTask)
        
        unregisterReceiver(fytReceiver)
    }

    private val runTask = object : Runnable {
        override fun run() {
            val am = context.getSystemService(AUDIO_SERVICE) as AudioManager

            if (am.isMusicActive) {
                // onActiveSessionsChanged switches between sources flawlessly as long as music continues to play,
                // it doesn't switch when user had paused previous music source before playing the new one
                checkActiveSessions()
            }
            handler.postDelayed(this, 10)
        }
    }

    private val updateTime = object : Runnable {
        override fun run() {
            val am = context.getSystemService(AUDIO_SERVICE) as AudioManager
            if (am.isMusicActive && musicState == "true") {
                if (curMinutes > prevCur) {
                    prevCur = curMinutes
                    setStatus(2)
                }
            }
            handlerTime.postDelayed(this, 500)
        }
    }

    private var callback: MediaController.Callback = object : MediaController.Callback() {
        override fun onSessionDestroyed() {
            super.onSessionDestroyed()
        }

        override fun onPlaybackStateChanged(state: PlaybackState?) {
            super.onPlaybackStateChanged(state)
            // 1 - STOPPED, 2 - PAUSED, 3 - PLAYING
            val currentState = state?.state
            if (currentState == 1) {
                handlerTime.removeCallbacks(updateTime)
                musicState = "false"
            } else if (currentState == 2) {
                handlerTime.removeCallbacks(updateTime)
                musicState = "false"
            } else if (currentState == 3) {
                musicState = "true"
                setStatus(2)
                handlerTime.post(updateTime)
            }
        }

        override fun onMetadataChanged(metadata: MediaMetadata?) {
            super.onMetadataChanged(metadata)
            if (meta == null) {
                prevCur = 0
                meta = metadata
                musicState = "true"
                //setStatus(2) 
                //handlerTime.post(updateTime)
            } else if (metadata != null && meta != null) {
                // Check if the new title is different from the previous one
                if (metadata.getString(MediaMetadata.METADATA_KEY_TITLE) != meta!!.getString(MediaMetadata.METADATA_KEY_TITLE)) {
                    prevCur = 0
                    meta = metadata
                    musicState = "true"
                    setStatus(2) 
                    handlerTime.post(updateTime)
                }
            }
        }
    }

    fun setStatus(mediaSource: Int) {
        if (mediaSource == 2) {
            fytState = false
            fytSet = true
        }

        if (song != null && fytState && fytAllowed && mediaSource == 1) {
            totalMinutes = fytTotalMinutes
            curMinutes = fytCurMinutes

            fytData = settings.getBoolean("fyt_data", true)

            if (fytData) { // from metadata
                song = musicName
                artist = authorName
                if(artist?.isEmpty() == true || artist == "Unknown"){
                    artist = album
                }       
            } else if (!fytData) { // from file title
                val file = File(fytMusicPath)
                val filename = file.getName()
                song = filename.substring(0, filename.lastIndexOf("."))
                artist = null
            }
            musicState = (fytState).toString()
            album = fytAlbum
            musicPath = fytMusicPath
            activeControllerPackage = ""
            
            albumCover = fytAlbumCover
            source = "fyt" 

            LauncherNotify.NOTIFIER_MUSIC.set(
                null,
                longArrayOf(totalMinutes, curMinutes),
                null,
                arrayOf((song).toString(), (artist).toString(), musicState, album, musicPath, activeControllerPackage),
                albumCover,
                source
            )
            Widget.update(LauncherApplication.sApp)   
        } 

        if (song != null && !fytState && mediaSource == 2)  {
            fytAllowed = false
            Handler(Looper.getMainLooper()).postDelayed({
                fytAllowed = true
            }, 2000) 

            totalMinutes = meta!!.getLong(MediaMetadata.METADATA_KEY_DURATION)
            mediaController!!.playbackState?.let { curMinutes = it.position }

            song = meta?.getString(MediaMetadata.METADATA_KEY_TITLE)
            artist = meta?.getString(MediaMetadata.METADATA_KEY_ARTIST) 
            if(artist == null || artist?.isEmpty() == true){
                artist = meta?.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST)
            }
            if(artist == null || artist?.isEmpty() == true) {
                artist = meta?.getString(MediaMetadata.METADATA_KEY_AUTHOR)
            }
            if(artist == null || artist?.isEmpty() == true) {
                artist = meta?.getString(MediaMetadata.METADATA_KEY_WRITER)
            }
            if(artist == null || artist?.isEmpty() == true) {
                artist = meta?.getString(MediaMetadata.METADATA_KEY_COMPOSER)
            }
            musicState = "true"   
            album = meta?.getString(MediaMetadata.METADATA_KEY_ALBUM)
            musicPath = ""
            activeControllerPackage = (mediaController?.getPackageName()).toString()
          
            var bitmap = meta?.getBitmap(MediaMetadata.METADATA_KEY_ART)
            if(bitmap == null) {
                bitmap = meta?.getBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART)
            }
            if(bitmap == null) {
                bitmap = meta?.getBitmap(MediaMetadata.METADATA_KEY_DISPLAY_ICON)
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
            Widget.update(LauncherApplication.sApp)
        }  
    }

    @Throws(IOException::class)
    private fun readBytes(context: Context, uri: Uri): ByteArray? = 
        context.contentResolver.openInputStream(uri)?.use { it.buffered().readBytes() }

    private fun getAlbumImage(path: String): Bitmap? {
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(path)
        val data = mmr.embeddedPicture
        return data?.let { BitmapFactory.decodeByteArray(it, 0, it.size) }
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