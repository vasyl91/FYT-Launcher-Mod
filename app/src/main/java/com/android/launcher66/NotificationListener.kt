package com.android.launcher66

import android.annotation.SuppressLint
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
import android.media.session.MediaSession
import android.media.session.MediaSessionManager
import android.media.session.PlaybackState
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.service.notification.NotificationListenerService
import android.util.Log
import androidx.annotation.CallSuper
import androidx.core.content.edit
import androidx.core.graphics.createBitmap
import androidx.preference.PreferenceManager
import com.android.launcher66.settings.Helpers
import com.fyt.car.LauncherNotify
import com.fyt.car.MusicService
import com.syu.car.CarStates
import com.syu.remote.RemoteTools
import com.syu.widget.DateMusicProvider
import com.syu.widget.DateRadioProvider
import com.syu.widget.Widget
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.lang.ref.WeakReference
import java.util.concurrent.atomic.AtomicBoolean

private const val ACTIVE_SESSION_POLL_MS = 250L

/** Panes are up ~1.5 s after the rebuild starts; the channel is taken right after that. */
private const val PANE_RESTART_GRACE_MS = 2500L

private const val MAX_CHANNEL_RESTORES = 6

/**
 * While the MCU completes a handover we asked for, it reports the stock channel once more.
 * Acting on that echo pauses the player that just started -- the "first click does nothing,
 * second one plays" bug.
 */
private const val HANDOVER_SETTLE_MS = 1500L

/** No two stock-channel sends closer than this, no matter which path asks. */
private const val STOCK_SEND_MIN_INTERVAL_MS = 400L

private const val RESUME_ONCE_DELAY_MS = 1200L

/**
 * Recovery for a channel steal.
 *
 * The restore itself is immediate -- the audible gap is our detection latency plus however long
 * the MCU takes to propagate the id back, roughly 150 ms in the captures, instead of the 1.1 s a
 * delayed restore produced (logcat 04:03:50.343 steal -> 51.100 restore -> 51.480 music back).
 *
 * What the original immediate version lacked was the cooldown below. It fired on EVERY stock -> 10
 * transition, including the one com.syu.ms sends in answer to our own restore, so the two of them
 * traded the channel three times in 200 ms. Treating anything inside the cooldown as our own echo
 * removes the ping-pong without slowing the first restore down.
 */
private const val IDLE_STEAL_COOLDOWN_MS = 1500L

/**
 * Why this cannot be zero.
 *
 * The channel change arrives BEFORE the playback signal that explains it: logcat 33.900
 * "MCU channel 8 -> 10" but 33.983 "Playback started by youtube" -- 83 ms later. Restoring
 * immediately therefore undoes a perfectly legitimate handover, com.syu.music comes back, and the
 * player that was just started has no channel, so it pauses. That is the "have to press play
 * several times" regression.
 *
 * 250 ms is the smallest delay that clears the observed lag with margin, and still puts the total
 * audible gap around 350 ms rather than the 1.1 s a 700 ms delay produced.
 */
private const val IDLE_STEAL_SETTLE_MS = 150L

/**
 * For this long after a pane rebuild finishes, a steal needs no settle delay at all.
 *
 * The settle exists only to tell a steal apart from the user pressing play -- the playback signal
 * arrives ~83 ms after the channel change, so acting sooner risks undoing a legitimate handover.
 * Right after a rebuild nobody is pressing anything. Keeping the delay there cost 241 ms of a
 * 919 ms silence (logcat 05:15:15.376 detection -> 15.617 send); the remaining 507 ms is
 * com.syu.music's own resume and 136 ms is how long the channel change takes to reach us.
 */
private const val POST_REBUILD_FAST_MS = 3000L

/** How recently the player must have started for the resume above to apply. */
private const val STOCK_TO_THIRD_PARTY_RESUME_WINDOW_MS = 4000L

/** The 250 ms session poll is far too slow to hide a channel steal. */
private const val PANE_WATCH_INTERVAL_MS = 40L

/** MCU audio channel identifiers - the same value space as
 * CarStates.mAppID, RemoteTools.getInt(0, 0, 0, x) and RemoteTools.sendInt(0, 0, x).
 * Read from the stock launcher code: switchSoundChannelThirdPlayer(),
 * mRadioPauseButton and refreshMain (mPageRadio / mPageBTAV / mPageMusic).
 */
private const val MCU_CH_ANDROID = 0
private const val MCU_CH_RADIO = 1
private const val MCU_CH_BTAV = 3
private const val MCU_CH_FYT_MUSIC = 8
private const val MCU_CH_THIRD_PARTY = 10

class NotificationListener : NotificationListenerService() {
    
    private lateinit var sessionListener: SessionListener
    private var contextRef = WeakReference<Context>(null)
    private var handler: Handler? = null
    private var handlerControllerTime: Handler? = null
    private var handlerFytTime: Handler? = null

    private val mainHandler = Handler(Looper.getMainLooper())

    /** Last compressed album art, so the same bitmap is not re-encoded over and over. */
    private var lastArtBitmapRef: WeakReference<Bitmap>? = null
    private var lastArtBytes: ByteArray? = null
    private var mediaSessionManager: MediaSessionManager? = null
    private var settings: SharedPreferences? = null

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

    // Sessions belonging to these packages are not third party players
    private val ownSourcePackages = setOf("com.android.launcher66", "com.syu.radio", "com.syu.music")

    // Edge detection so the arbitration runs once per transition into PLAYING,
    // not on every callback
    private val playingTokens = mutableSetOf<MediaSession.Token>()

    /** Package that legitimately owns the audio right now, MCU sources included. */
    @Volatile
    private var currentSourcePackage: String? = null

    /** Until when a session going PLAYING is a pane being restarted, not a user action. */
    @Volatile
    private var paneRestartUntil: Long = 0L

    /** Last MCU channel seen, so a change is acted on exactly once. */
    @Volatile
    private var lastMcuChannel: Int = -1

    /** MCU channel that has to survive the pane rebuild, MCU_CH_ANDROID when there is none. */
    @Volatile
    private var channelToRestore: Int = MCU_CH_ANDROID
    private var channelRestores: Int = 0
    private var pendingRestore: Runnable? = null
    private var paneWatchdog: Runnable? = null

    /** When the channel was last handed to a third party player on our own initiative. */
    @Volatile
    private var handoverAtMs: Long = 0L

    /**
     * Last external session seen going PLAYING, and when.
     *
     * onMcuChannelChanged() fires ~60 ms BEFORE pickController() catches up, so resolving the
     * player at transition time finds the stock session and gives up. The target is resolved at
     * check time instead, against this record.
     */
    /** Collapses a burst of channel steals into one recovery. */
    private var idleStealGeneration = 0
    private var lastIdleStealRestoreMs = 0L
    /** When the steal being recovered from was first seen, for the timing log below. */
    private var stealSeenAtMs = 0L
    /** Hard floor between two sends of a stock channel, whichever path asks for them. */
    private var lastStockSendMs = 0L
    /** When the last pane rebuild window closed; steals just after it are unambiguous. */
    private var paneRebuildEndedAtMs = 0L

    @Volatile
    private var lastExternalPlayToken: MediaSession.Token? = null
    @Volatile
    private var lastExternalPlayAtMs: Long = 0L

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

    /**
     * Delayed work that backs out once the service has been cleaned up. Use this instead
     * of Handler(Looper.getMainLooper()).postDelayed, which outlives onDestroy().
     */
    private fun postDelayedIfAlive(delayMs: Long, block: () -> Unit) {
        if (destroyed.get() || isCleanedUp) return
        mainHandler.postDelayed({
            if (destroyed.get() || isCleanedUp) return@postDelayed
            block()
        }, delayMs)
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onListenerConnected() {    
        super.onListenerConnected() 
        isCleanedUp = false
        instance = this
        contextRef = WeakReference(this)
        paused = false

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
                postDelayedIfAlive(2000) {
                    if (!helpers.returnControllerTimeBool()) {
                        helpers.updateControllerTimeBool(true)
                        handlerControllerTime?.post(updateControllerTime)
                    }
                    setStatus(2)
                }
            }
            if (MusicService.state && MusicService.music_name != "" && MusicService.music_name != "Unknown") {
                postDelayedIfAlive(2000) {
                    handlerFytTime?.post(updateFytTime)
                    setStatus(1)
                }
            }
        }

        handler = Handler(Looper.getMainLooper())
        handler?.post(runTask)

        if (!isReceiverRegistered) {
            val intentFilter = IntentFilter().apply {
                addAction("titlesInternal")
                addAction("dumpMediaDebug")
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

        if (instance === this) instance = null

        safeUnregisterReceiver()
        safeUnregisterSessionListener()

        mediaController?.unregisterCallback(callback)
        mediaController = null

        handler?.removeCallbacksAndMessages(null)
        handlerControllerTime?.removeCallbacksAndMessages(null)
        handlerFytTime?.removeCallbacksAndMessages(null)
        // Otherwise the one-shot 700 / 1800 / 2000 ms posts keep holding the service.
        mainHandler.removeCallbacksAndMessages(null)

        handler = null
        handlerControllerTime = null
        handlerFytTime = null

        controllers?.clear()
        controllers = null

        playingTokens.clear()
        currentSourcePackage = null
        paneRestartUntil = 0L
        lastMcuChannel = -1
        channelToRestore = MCU_CH_ANDROID
        channelRestores = 0
        pendingRestore?.let { handler?.removeCallbacks(it) }
        pendingRestore = null
        paneWatchdog?.let { handler?.removeCallbacks(it) }
        paneWatchdog = null

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
        lastArtBitmapRef?.clear()
        lastArtBitmapRef = null
        lastArtBytes = null
        MediaWidgetState.clearExternal()

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
            *   characters specific to particular language (ö, ó, ü, ß, ñ etc) and sends chinese signs instead.
            */
            if (intent.action == "dumpMediaDebug") {
                MediaDebugDump.dumpAll()
                return
            }
            if (intent.action == "titlesInternal") {
                val bundle = intent.extras ?: return
                fytState = bundle.getBoolean("play_state", false) 
                fytMusicPath = bundle.getString("play_path") ?: ""
                fytSource = bundle.getString("source") ?: ""
                fytCurMinutes = bundle.getLong("play_cur", 0L)
                
                val file = File(fytMusicPath)
                if (!file.exists() || fytMusicPath.isEmpty()) return
                
                val retriever = MediaMetadataRetriever()
                try {
                    try {
                        FileInputStream(file).use { fis ->
                            retriever.setDataSource(fis.fd, 0, file.length())
                        }
                    } catch (e: IllegalArgumentException) {
                        e.printStackTrace()
                        retriever.setDataSource(fytMusicPath)
                    }
                    
                    // Extract metadata with null safety
                    musicName = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)
                    authorName = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)
                    fytAlbum = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM) ?: ""
                    retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
                        ?.let { fytTotalMinutes = it.toLong() }
                    
                    // Use safe calls for musicName - convert null to empty string
                    val currentMusicName = musicName ?: ""
                    if (musicNamePrev != currentMusicName) {
                        musicNamePrev = currentMusicName
                        prevCurFyt = 0
                    }
                    
                    val filename = file.name
                    if (filename.isNotEmpty() && filename.contains(".")) {
                        pathName = filename.substring(0, filename.lastIndexOf("."))
                    }

                    // The stock player has an audio channel, so MediaSession gives way -
                    // once, rather than on every playback position tick.
                    if (fytState) {
                        takeSourceForMcu(MusicService.MUSIC_PKG)
                    }
                    
                    // Safe validation of musicName
                    val isValidMusicName = currentMusicName.isNotEmpty() && 
                                          !currentMusicName.contains("Unknown", ignoreCase = true) && 
                                          !currentMusicName.contains("null", ignoreCase = true)
                    
                    if (isValidMusicName) {
                        fytSet = false
                    }
                    
                    if (fytState && !fytSet && helpers.isFytMusicAllowed() && isValidMusicName) {
                        handlerControllerTime?.removeCallbacks(updateControllerTime)  
                        helpers.updateControllerTimeBool(false)
                        fytSet = true
                        setStatus(1)
                        handlerFytTime?.post(updateFytTime)             
                    }
                    
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    try {
                        retriever.release()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    // ---------------------------------------------------------------------
    //  MCU audio channel
    //
    //  Apps in com.syu.* do not use MediaSession - they communicate with the MCU through
    //  com.syu.ms. This is why switching music <-> radio works correctly, while
    //  music/radio <-> a MediaSession player does not: these are two independent
    //  arbitration mechanisms that are unaware of each other.
    //
    //  The launcher can nevertheless participate in MCU arbitration - the stock code does this
    //  in switchSoundChannelThirdPlayer() before starting Kuwo. Setting the channel
    //  to MCU_CH_THIRD_PARTY is a "the Android application is taking over the audio"
    //  message; the MCU then stops the radio, stock player and BT audio
    //  exactly as when switching between them. Nothing is killed,
    //  so each of these sources can be resumed later.
    // ---------------------------------------------------------------------

    private fun mcuTools(): RemoteTools? {
        val context = contextRef.get() ?: return null
        return try {
            CarStates.getCar(context)?.tools
        } catch (t: Throwable) {
            Log.w("NotificationListener", "RemoteTools unavailable: ${t.message}")
            null
        }
    }

    /** Maintained in the process by the syu library, so reading it costs nothing. */
    private fun mcuChannel(): Int = CarStates.mAppID

    private fun isMcuChannelPlaying(): Boolean {
        val channel = mcuChannel()
        return channel == MCU_CH_RADIO || channel == MCU_CH_BTAV || channel == MCU_CH_FYT_MUSIC
    }

    private fun handOverToThirdPartyPlayer() {
        // com.syu.ms hands the channel over by itself as soon as it sees a third party player
        // start, so by the time we get here the MCU is normally already on 10. Sending it again
        // makes com.syu.ms re-run the whole source switch, and that second switch is what pauses
        // the player that just started. CarStates.mAppID is the value our own channel logging
        // uses, so it is the one to trust -- tools.getInt() did not report 10 even when it was.
        if (mcuChannel() == MCU_CH_THIRD_PARTY) {
            Log.d("NotificationListener", "MCU already on channel $MCU_CH_THIRD_PARTY - not switching again")
            return
        }

        val tools = mcuTools() ?: return
        try {
            tools.sendInt(0, 0, MCU_CH_THIRD_PARTY)
        } catch (t: Throwable) {
            Log.w("NotificationListener", "MCU handover failed: ${t.message}")
            return
        }
        // Not every MCU firmware reacts to channel 10. Channel 0 sends the stock radio
        // widget pause button, so it is a safe fallback.
        postDelayedIfAlive(900) {
            if (isMcuChannelPlaying()) {
                Log.d("NotificationListener", "MCU still on channel ${mcuChannel()} - releasing it")
                try {
                    mcuTools()?.sendInt(0, 0, MCU_CH_ANDROID)
                } catch (t: Throwable) {
                    Log.w("NotificationListener", "MCU release failed: ${t.message}")
                }
            }
        }
    }

    private fun pauseCurrentController(reason: String) {
        val controller = mediaController ?: return
        if (controller.playbackState?.state != PlaybackState.STATE_PLAYING) return
        Log.d("NotificationListener", "Pausing ${controller.packageName} - $reason")
        try {
            controller.transportControls.pause()
        } catch (e: Exception) {
            Log.w("NotificationListener", "Failed to pause ${controller.packageName}: ${e.message}")
        }
    }

    /** An MCU source took the sound channel, so whatever runs on a MediaSession gives way. */
    private fun takeSourceForMcu(packageName: String) {
        if (currentSourcePackage == packageName) return

        // The handover was our own decision; the stock channel showing up again right after it is
        // the MCU finishing that switch, not the user choosing the stock player. Pausing here is
        // what killed the first play.
        if (SystemClock.elapsedRealtime() - handoverAtMs < HANDOVER_SETTLE_MS) {
            Log.d("NotificationListener", "Ignoring $packageName - handover still settling")
            return
        }

        currentSourcePackage = packageName
        // Players hosted in the panes are never touched while the panes are being rebuilt.
        if (SystemClock.elapsedRealtime() < paneRestartUntil) return
        pauseCurrentController("$packageName took the sound channel")
    }

    /**
     * Mirror image of maybeStopOtherSources(). Called from the runTask loop every
     * ACTIVE_SESSION_POLL_MS; can also be called from Launcher.refreshMain (updateCode == 0).
     */
    fun onMcuChannelChanged(channel: Int) {
        if (destroyed.get() || isCleanedUp) return
        val previous = lastMcuChannel
        if (channel == previous) return
        lastMcuChannel = channel
        if (previous == -1) return
        Log.d("NotificationListener", "MCU channel $previous -> $channel")

        if (isPaneChannelSteal(channel)) {
            if (stealSeenAtMs == 0L) stealSeenAtMs = SystemClock.elapsedRealtime()
            scheduleChannelRestore()
            return
        }

        // Switching from a stock source to the third party channel silently pauses the player
        // that caused the switch. Reproduced in every capture: "youtube status: 1" -> "MCU
        // channel 8 -> 10" -> "youtube status: 0" ~80 ms later, while a second press with the
        // channel already on 10 plays normally.
        // Only one thing happens on a stock -> third party switch: the player that caused it gets
        // put back up once, because com.syu.ms pauses it while completing the switch.
        //
        // restoreIdleSteal() used to sit here too, sending the stock channel back whenever nothing
        // appeared to be playing. It raced with com.syu.ms sending 10 again, and that ping-pong is
        // what made com.syu.music grab playback back at random.
        if (channel == MCU_CH_THIRD_PARTY && isStockChannel(previous)) {
            if (isAnyExternalSessionPlaying()) {
                // A real handover: undo only the pause com.syu.ms performs while switching.
                scheduleResumeAfterSourceSwitch()
            } else {
                // Nothing is playing, so the channel was taken just because an app reached the
                // top, which is com.syu.ms reacting to a pane activity resuming.
                scheduleIdleStealRecovery(previous)
            }
        }

        when (channel) {
            MCU_CH_RADIO -> { stealSeenAtMs = 0L; takeSourceForMcu("com.syu.radio") }
            MCU_CH_FYT_MUSIC -> { stealSeenAtMs = 0L; takeSourceForMcu(MusicService.MUSIC_PKG) }
            MCU_CH_BTAV -> { stealSeenAtMs = 0L; takeSourceForMcu("com.syu.bt") }
        }
    }

    /**
     * The ROM switches the source when a recognised media app is LAUNCHED, not when it plays,
     * so a pane rebuild produces a burst of switches that ends only once the last app has
     * started. Answering each one loses the race and burns MAX_CHANNEL_RESTORES; one restore
     * after the burst goes quiet sticks.
     */
    private fun scheduleChannelRestore() {
        val h = handler ?: return

        // Already on its way -- do not push it further out. Restarting the timer on every flip is
        // what made a burst take a second instead of a quarter of one.
        if (pendingRestore != null) return

        // Anything arriving right after our own restore is com.syu.ms answering it, not a new
        // steal; the same rule the idle-steal path uses.
        if (SystemClock.elapsedRealtime() - lastIdleStealRestoreMs < IDLE_STEAL_COOLDOWN_MS) {
            Log.d("NotificationListener", "Pane steal within cooldown - leaving it alone")
            return
        }

        // No settle delay on this path. The settle exists only to tell a steal apart from the
        // user pressing play, and during a pane rebuild nobody is pressing anything -- the whole
        // branch is gated on isPaneChannelSteal(), which already requires the rebuild window and
        // no external session playing.
        val r = Runnable {
            pendingRestore = null
            lastIdleStealRestoreMs = SystemClock.elapsedRealtime()
            restoreChannelNow("Pane rebuild steal")
        }
        pendingRestore = r
        h.post(r)
    }

    private fun isStockChannel(channel: Int): Boolean =
        channel == MCU_CH_RADIO || channel == MCU_CH_BTAV || channel == MCU_CH_FYT_MUSIC


    /**
     * Undoes the pause com.syu.ms performs while switching from a stock source to channel 10.
     *
     * Only the session that was playing at the moment of the switch is considered, only while the
     * channel is still on 10, and only once per transition -- so a deliberate pause a second later
     * is never overridden.
     */
    /**
     * Puts a stock channel back the moment it is taken with nothing playing.
     *
     * Anything arriving inside IDLE_STEAL_COOLDOWN_MS of our own restore is com.syu.ms answering
     * it, not a fresh steal; fighting that is what produced the audible ping-pong. At most two
     * sends leave this method per steal: one now, one verification.
     */
    private fun scheduleIdleStealRecovery(stockChannel: Int) {
        val now = SystemClock.elapsedRealtime()
        if (stealSeenAtMs == 0L) stealSeenAtMs = now

        if (now - lastIdleStealRestoreMs < IDLE_STEAL_COOLDOWN_MS) {
            Log.d("NotificationListener", "Channel taken again within cooldown - leaving it alone")
            return
        }

        idleStealGeneration++
        val gen = idleStealGeneration

        // No ambiguity right after a rebuild, so no settle: that delay is pure added silence.
        val settle = if (now - paneRebuildEndedAtMs < POST_REBUILD_FAST_MS) 0L else IDLE_STEAL_SETTLE_MS

        postDelayedIfAlive(settle) {
            if (gen != idleStealGeneration) return@postDelayedIfAlive
            if (mcuChannel() != MCU_CH_THIRD_PARTY) return@postDelayedIfAlive

            // By now the playback signal has caught up with the channel change. Any of these means
            // the switch was legitimate and the channel belongs where it is.
            if (isAnyExternalSessionPlaying()) return@postDelayedIfAlive
            if (SystemClock.elapsedRealtime() - lastExternalPlayAtMs < 1000L) return@postDelayedIfAlive
            if (SystemClock.elapsedRealtime() - handoverAtMs < 1000L) return@postDelayedIfAlive

            lastIdleStealRestoreMs = SystemClock.elapsedRealtime()
            restoreStockChannel(stockChannel, "restoring")

        }
    }

    private fun restoreStockChannel(stockChannel: Int, reason: String) {
        if (isAnyExternalSessionPlaying()) return
        if (mcuChannel() == stockChannel) return
        sendStockChannel(stockChannel, reason)
    }

    private fun sendStockChannel(stockChannel: Int, reason: String) {
        // Every path that wants the stock channel back funnels through here, so this is the one
        // place a rate limit actually holds: scheduleIdleStealRecovery, scheduleChannelRestore and
        // paneRebuildSettled each have their own guard, and none of them sees the others.
        val now = SystemClock.elapsedRealtime()
        if (now - lastStockSendMs < STOCK_SEND_MIN_INTERVAL_MS) return
        lastStockSendMs = now

        val ourDelay = if (stealSeenAtMs > 0L) now - stealSeenAtMs else -1L
        Log.d("NotificationListener", "Channel taken with nothing playing - $reason $stockChannel"
                + " (our delay ${ourDelay}ms; com.syu.music then needs ~370ms of its own)")

        // Cleared here rather than in the when(channel) branches: with the channel flapping those
        // branches are never reached, and "our delay" grew to 33 seconds of nonsense.
        stealSeenAtMs = 0L

        try {
            mcuTools()?.sendInt(0, 0, stockChannel)
            lastMcuChannel = stockChannel
        } catch (t: Throwable) {
            Log.w("NotificationListener", "Idle steal recovery failed: ${t.message}")
        }
    }

    private fun scheduleResumeAfterSourceSwitch() {
        postDelayedIfAlive(RESUME_ONCE_DELAY_MS) {
            if (mcuChannel() != MCU_CH_THIRD_PARTY) return@postDelayedIfAlive

            val token = lastExternalPlayToken ?: return@postDelayedIfAlive
            if (SystemClock.elapsedRealtime() - lastExternalPlayAtMs > STOCK_TO_THIRD_PARTY_RESUME_WINDOW_MS) {
                return@postDelayedIfAlive
            }

            val c = mediaController ?: return@postDelayedIfAlive
            if (c.sessionToken != token) return@postDelayedIfAlive
            if (c.packageName in ownSourcePackages) return@postDelayedIfAlive
            if (c.playbackState?.state == PlaybackState.STATE_PLAYING) return@postDelayedIfAlive

            Log.d("NotificationListener", "Resuming ${c.packageName} - paused by the switch to channel $MCU_CH_THIRD_PARTY")
            try {
                c.transportControls.play()
            } catch (e: Exception) {
                Log.w("NotificationListener", "Failed to resume ${c.packageName}: ${e.message}")
            }
        }
    }

    /**
     * Puts the channel the panes stole back, then stops whatever started playing meanwhile.
     */
    private fun restoreChannelNow(reason: String) {
        val target = channelToRestore
        if (target == MCU_CH_ANDROID) return
        if (mcuChannel() == target) return

        channelRestores++
        restoreStockChannel(target, reason)

        postDelayedIfAlive(250L) {
            if (mcuChannel() == target && isAnyExternalSessionPlaying()) {
                pauseCurrentController("channel restored to $target after pane rebuild")
            }
        }
    }

    /**
     * Relaunching a media app into a pane makes the framework hand the sound channel to
     * the third party player within a few hundred ms, with nothing playing there. All
     * three conditions have to hold, and a real source switch fails at least one of them:
     * switching to radio or the stock player lands on channel 1 / 8, and switching to a
     * MediaSession player leaves that player PLAYING.
     */
    private fun isPaneChannelSteal(channel: Int): Boolean {
        if (channelToRestore == MCU_CH_ANDROID) return false
        if (channel != MCU_CH_THIRD_PARTY && channel != MCU_CH_ANDROID) return false
        if (SystemClock.elapsedRealtime() >= paneRestartUntil) return false
        if (channelRestores >= MAX_CHANNEL_RESTORES) return false
        return !isAnyExternalSessionPlaying()
    }


    private fun isAnyExternalSessionPlaying(): Boolean {
        val sessions = try {
            mediaSessionManager?.getActiveSessions(componentName)
        } catch (e: SecurityException) {
            null
        } ?: return false
        return sessions.any { isRealExternalPlayback(it) }
    }

    private fun isRealExternalPlayback(controller: MediaController?): Boolean {
        val c = controller ?: return false
        val pkg = c.packageName ?: return false
        if (pkg in ownSourcePackages) return false
        val st = c.playbackState ?: return false
        if (st.state != PlaybackState.STATE_PLAYING) return false
        // a session reporting PLAYING with speed 0 is not producing audio
        if (st.playbackSpeed == 0f) return false
        return true
    }

    /** Called by the launcher right before it rebuilds the PIP panes. */
    fun suppressAutoSourceSwitch() {
        val now = SystemClock.elapsedRealtime()
        val rearming = now >= paneRestartUntil
        paneRestartUntil = now + PANE_RESTART_GRACE_MS
        if (rearming) channelRestores = 0
        if (!isMcuChannelPlaying()) return
        channelToRestore = mcuChannel()
        if (rearming) {
            Log.d("NotificationListener", "Pane rebuild starting - channel $channelToRestore")
            startPaneWatchdog()
        }
    }

    /**
     * Launching an app into a pane makes it ask for audio focus, and the MCU answers by
     * handing the sound channel to the third party player 50-300 ms later. Watching the
     * channel at the normal 250 ms cadence would leave an audible hole, so for the length
     * of the rebuild it is checked every PANE_WATCH_INTERVAL_MS. Reading CarStates.mAppID
     * is an in process field read, so the tick costs nothing.
     */
    private fun startPaneWatchdog() {
        val h = handler ?: return
        paneWatchdog?.let { h.removeCallbacks(it) }
        val watchdog = object : Runnable {
            override fun run() {
                if (destroyed.get() || isCleanedUp) return
                if (SystemClock.elapsedRealtime() >= paneRestartUntil) return
                val channel = mcuChannel()
                if (channel != lastMcuChannel) onMcuChannelChanged(channel)
                handler?.postDelayed(this, PANE_WATCH_INTERVAL_MS)
            }
        }
        paneWatchdog = watchdog
        h.post(watchdog)
    }

    /**
     * The launcher going to the background ends the rebuild. Anything the MCU does from
     * here on is the user opening a source app, and must not be second guessed.
     */
    fun endPaneRestart() {
        paneRebuildEndedAtMs = SystemClock.elapsedRealtime()
        paneRestartUntil = 0L
        channelToRestore = MCU_CH_ANDROID
        pendingRestore?.let { handler?.removeCallbacks(it) }
        pendingRestore = null
        paneWatchdog?.let { handler?.removeCallbacks(it) }
        paneWatchdog = null
    }

    /** Runs once per transition into PLAYING, not on every repeat of the same state. */
    private fun maybeStopOtherSources() {
        val controller = mediaController ?: return
        if (!isRealExternalPlayback(controller)) return

        // Recorded before the edge filter below, so it is set even on the paths that return early.
        lastExternalPlayToken = controller.sessionToken
        lastExternalPlayAtMs = SystemClock.elapsedRealtime()

        val pkg = controller.packageName ?: return
        if (!playingTokens.add(controller.sessionToken)) return
        if (pkg == currentSourcePackage) return

        // A player announcing playback right after the launcher rebuilt its panes is the
        // launcher restarting it, not the user picking a new source. Its playback is left
        // running; onMcuChannelChanged() puts the sound channel back.
        if (SystemClock.elapsedRealtime() < paneRestartUntil && channelToRestore != MCU_CH_ANDROID) {
            Log.d("NotificationListener", "Ignoring $pkg - pane rebuild, not a source switch")
            return
        }

        Log.d("NotificationListener", "Playback started by $pkg - handing the sound channel over")
        currentSourcePackage = pkg
        channelToRestore = MCU_CH_ANDROID
        handoverAtMs = SystemClock.elapsedRealtime()
        handOverToThirdPartyPlayer()
    }

    private fun markNotPlaying(controller: MediaController?) {
        val token = controller?.sessionToken ?: return
        playingTokens.remove(token)
    }

    private val runTask = RunTaskRunnable(this)
    private val updateControllerTime = UpdateControllerTimeRunnable(this)
    private val updateFytTime = UpdateFytTimeRunnable(this)

    private class RunTaskRunnable(service: NotificationListener) : Runnable {
        private val serviceRef = WeakReference(service)
        override fun run() {
            val service = serviceRef.get() ?: return
            if (service.destroyed.get()) return
            // CarStates.mAppID is maintained in the process, so reading it costs nothing
            service.onMcuChannelChanged(CarStates.mAppID)
            val context = service.contextRef.get() ?: return
            val am = context.getSystemService(AUDIO_SERVICE) as? AudioManager ?: return
            if (am.isMusicActive) {
                service.checkActiveSessions()
            }
            service.handler?.postDelayed(this, ACTIVE_SESSION_POLL_MS)
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
            val service = serviceRef.get() ?: return
            service.markNotPlaying(service.mediaController)
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
            if (service.currentState == PlaybackState.STATE_PAUSED
                || service.currentState == PlaybackState.STATE_STOPPED
                || service.currentState == PlaybackState.STATE_BUFFERING) {
                service.markNotPlaying(service.mediaController)
                // Closed out here rather than relying on set() being reached
                // through a re-attach: while musicState stays "true" the
                // updateControllerTime tick keeps pushing a playing state and
                // the widget flips back to the pause icon.
                service.musicState = "false"
                service.handlerControllerTime?.removeCallbacks(service.updateControllerTime)
                service.helpers.updateControllerTimeBool(false)
                val intent = Intent("pause.button")
                service.sendBroadcast(intent)
                service.settings?.edit {
                    this.putInt("prevState", service.currentState!!)
                }
                service.helpers.setCounter(0)
                service.updateExternalMediaWidgetState(false)
            } else {
                set()
            }
        }

        fun set() {  
            val service = serviceRef.get() ?: return
            service.maybeStopOtherSources()
            service.handlerFytTime?.removeCallbacks(service.updateFytTime)

            if (service.currentState == PlaybackState.STATE_PAUSED || service.currentState == PlaybackState.STATE_STOPPED) {  
                service.helpers.setCounter(0)
                service.handlerControllerTime?.removeCallbacks(service.updateControllerTime)
                service.helpers.updateControllerTimeBool(false)
                service.musicState = "false"
            } else if (service.currentState == PlaybackState.STATE_PLAYING) {
                // YoutubeMusic or Spotify (and probably some other music apps) need some delay to load the album art
                service.postDelayedIfAlive(700) {
                    // playback may have stopped during the delay; this write
                    // would then report it as still playing
                    if (service.currentState != PlaybackState.STATE_PLAYING) return@postDelayedIfAlive
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
                    if (!service.songCur.equals(service.settings?.getString("songPrev", "prev")) 
                        || service.settings!!.getInt("prevState", PlaybackState.STATE_STOPPED) == PlaybackState.STATE_STOPPED 
                        || service.settings!!.getInt("prevState", PlaybackState.STATE_STOPPED) == PlaybackState.STATE_PAUSED
                        || service.settings!!.getInt("prevState", PlaybackState.STATE_STOPPED) == PlaybackState.STATE_BUFFERING) {
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
                }
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
            postDelayedIfAlive(1800) {
                helpers.setFytMusicAllowed(true)
            }
            activeControllerPackage = (mediaController?.packageName).toString()
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
            val filename = file.name
            songFyt = filename.substring(0, filename.lastIndexOf("."))
            artist = null
        }
        activeControllerPackage = ""
        source = "fyt" 
        MediaWidgetState.clearExternal()
        
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

        // PNG-encoding a full-size cover costs tens of ms and a fresh ByteArray each time,
        // and mediaControllerStatus() can run several times a second. Identity comparison,
        // held weakly so the cache never extends the bitmap's life.
        val cachedBitmap = lastArtBitmapRef?.get()
        val cachedBytes = lastArtBytes
        if (bitmap != null && cachedBitmap === bitmap && cachedBytes != null) {
            albumCover = cachedBytes
        } else {
            val stream = ByteArrayOutputStream()
            bitmap?.compress(Bitmap.CompressFormat.PNG, 90, stream)
            albumCover = stream.toByteArray()
            lastArtBitmapRef = if (bitmap != null) WeakReference(bitmap) else null
            lastArtBytes = albumCover
        }

        source = "mediaController"

        LauncherNotify.NOTIFIER_MUSIC.set(
            null,
            longArrayOf(totalMinutes, curMinutes),
            null,
            arrayOf(song, artist, musicState, album, musicPath, activeControllerPackage),
            albumCover,
            source
        )
        updateExternalMediaWidgetState(true)
        paused = false

        if (totalMinutes == 0.toLong() && !verifyIfLive) {
            verifyIfLive = true
            postDelayedIfAlive(500) {
                mediaControllerStatus()
            }
            postDelayedIfAlive(700) {
                verifyIfLive = false
            }
        }
    }

    private fun updateExternalMediaWidgetState(isPlaying: Boolean) {
        val controller = mediaController ?: return
        val currentMeta = meta ?: controller.metadata ?: return

        val title = currentMeta.getString(MediaMetadata.METADATA_KEY_TITLE) ?: song ?: ""
        var resolvedArtist = currentMeta.getString(MediaMetadata.METADATA_KEY_ARTIST)
        if (resolvedArtist.isNullOrEmpty()) {
            resolvedArtist = currentMeta.getString(MediaMetadata.METADATA_KEY_ALBUM_ARTIST)
        }
        if (resolvedArtist.isNullOrEmpty()) {
            resolvedArtist = currentMeta.getString(MediaMetadata.METADATA_KEY_AUTHOR)
        }
        if (resolvedArtist.isNullOrEmpty()) {
            resolvedArtist = artist ?: ""
        }

        val resolvedAlbum = currentMeta.getString(MediaMetadata.METADATA_KEY_ALBUM) ?: album ?: ""
        val duration = currentMeta.getLong(MediaMetadata.METADATA_KEY_DURATION)
        val position = if (duration == 0L) 0L else controller.playbackState?.position ?: curMinutes
        val packageName = controller.packageName ?: activeControllerPackage

        MediaWidgetState.updateExternal(
            title,
            resolvedArtist,
            resolvedAlbum,
            packageName,
            isPlaying,
            duration,
            position,
            albumCover
        )
        Widget.widgetUpdate(this, DateMusicProvider::class.java)
        Widget.widgetUpdate(this, DateRadioProvider::class.java)
    }

    fun getHighResAppIcon(context: Context, packageName: String): Bitmap? {
        return try {
            val pm = context.packageManager
            val appInfo = pm.getApplicationInfo(packageName, 0)
            var iconDrawable: Drawable? = null

            if (appInfo.icon != 0) {
                try {
                    val resources = pm.getResourcesForApplication(appInfo)
                    val densities = intArrayOf(640, 480, 320, 240, 160)

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
            iconDrawable = iconDrawable ?: pm.getApplicationIcon(packageName)
            drawableToBitmap(iconDrawable)
        } catch (e: PackageManager.NameNotFoundException) {
            Log.w("NotificationListener", "Application not found: $packageName")
            null
        } catch (e: Exception) {
            Log.e("NotificationListener", "Error retrieving app icon for $packageName: ${e.message}")
            null
        }
    }
    
    fun drawableToBitmap(drawable: Drawable?): Bitmap? {
        if (drawable == null || drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            return null
        }
        val bitmap = createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun checkActiveSessions() {
        // onListenerDisconnected() can arrive before onListenerConnected(), in which case
        // the lateinit sessionListener throws UninitializedPropertyAccessException.
        if (destroyed.get() || isCleanedUp || !::sessionListener.isInitialized) return
        val ctrlrs: MutableList<MediaController>? = try {
            mediaSessionManager?.getActiveSessions(componentName)
        } catch (e: SecurityException) {
            Log.w("NotificationListener", "getActiveSessions denied: ${e.message}")
            null
        }
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
                // keep the PLAYING bookkeeping in sync so a later play is seen as a new transition
                val liveTokens = controllers.map { it.sessionToken }.toSet()
                service.playingTokens.retainAll { it in liveTokens }
                controllers.forEach { c ->
                    if (c.playbackState?.state != PlaybackState.STATE_PLAYING) {
                        service.playingTokens.remove(c.sessionToken)
                    }
                }

                // Compare against the controller we would actually pick (pickController
                // prefers a PLAYING session), not controllers[0]. When the playing session
                // was not first in the list the tokens never matched, so every 250 ms
                // (ACTIVE_SESSION_POLL_MS) brought an unregisterCallback + registerCallback
                // pair, the metadata/playback callbacks behind it, and a full
                // mediaControllerStatus() pass including album art compression.
                val desired = service.pickController(controllers)
                if (service.mediaController != null && desired?.sessionToken != service.mediaController?.sessionToken) {
                    // Detach current controller
                    service.mediaController?.unregisterCallback(service.callback)
                    service.mediaController = null
                }

                if (service.mediaController == null) {
                    // Attach new controller
                    service.mediaController = desired
                    service.mediaController?.registerCallback(service.callback)
                    service.mediaController?.metadata?.let { service.callback.onMetadataChanged(it) }
                    service.mediaController?.playbackState?.let { service.callback.onPlaybackStateChanged(it) }
                }
            }
        }
    }

    /**
     * Ends the pane rebuild window as soon as the panes are genuinely up.
     *
     * PANE_RESTART_GRACE_MS is a fixed timer, and whether an auto-resume gets suppressed came
     * down to landing inside it: in one capture a user press arrived 64 ms after the window
     * closed and was handled correctly, in another an auto-resume arrived just inside it and was
     * suppressed correctly -- both by luck. What actually separates the two is whether the
     * rebuild is still running, which WindowHost.areAllPanesRendering() answers exactly.
     */
    private fun paneRebuildSettled() {
        if (destroyed.get() || isCleanedUp) return
        if (paneRestartUntil == 0L) return
        Log.d("NotificationListener", "Panes settled - ending rebuild window early")
        pendingRestore?.let { handler?.removeCallbacks(it) }
        pendingRestore = null
        restoreChannelNow("Panes settled")
        endPaneRestart()
    }

    companion object {
        @Volatile
        @JvmStatic
        var instance: NotificationListener? = null
            private set

        /** Called by WindowUtil once every pane has produced a frame. */
        @JvmStatic
        fun onPaneRebuildSettled() {
            val listener = instance ?: return
            listener.mainHandler.post { listener.paneRebuildSettled() }
        }
    }
}
