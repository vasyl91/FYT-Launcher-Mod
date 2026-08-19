package com.android.launcher66

import android.content.ComponentName
import android.content.Context
import android.media.MediaMetadata
import android.media.session.MediaController
import android.media.session.MediaSessionManager
import android.media.session.PlaybackState
import android.os.Bundle
import android.util.Log
import android.graphics.drawable.Icon
import android.os.Build

object MediaDebugDump {

    private const val TAG = "MediaDebug"

    private val VIDEO_ID_IN_URL = Regex("(?:/vi/|/vi_webp/|[?&]v=)([A-Za-z0-9_-]{11})")
    private val BARE_VIDEO_ID = Regex("^[A-Za-z0-9_-]{11}$")

    @JvmStatic
    fun dumpAll() {
        val service = NotificationListener.instance
        if (service == null) {
            Log.d(TAG, "listener NOT bound")
            return
        }
        dumpNotifications(service)
        dumpSessions(service)
    }

    private fun dumpNotifications(service: NotificationListener) {
        val active = try {
            service.activeNotifications ?: emptyArray()
        } catch (e: Exception) {
            Log.w(TAG, "getActiveNotifications failed: ${e.message}")
            return
        }

        Log.d(TAG, "=========== NOTIFICATIONS: ${active.size} ===========")
        for (sbn in active) {
            Log.d(TAG, "notif pkg=${sbn.packageName} id=${sbn.id}")
            val actions = sbn.notification.actions ?: continue
            val res = try {
                service.packageManager.getResourcesForApplication(sbn.packageName)
            } catch (e: Exception) {
                null
            }
            for (a in actions) {
                var iconRes = 0

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    try {
                        val icon = a.getIcon()
                        if (icon != null && icon.type == Icon.TYPE_RESOURCE) {
                            iconRes = icon.resId
                        }
                    } catch (_: Exception) {
                    }
                }

                if (iconRes == 0) {
                    @Suppress("DEPRECATION")
                    iconRes = a.icon
                }

                var iconName = "res#$iconRes"
                if (iconRes != 0 && res != null) {
                    try {
                        iconName = res.getResourceEntryName(iconRes)
                    } catch (_: Exception) {
                    }
                }

                Log.d(TAG, "    action title='${a.title}' icon=$iconName")
            }
        }
    }

    private fun dumpSessions(service: NotificationListener) {
        val msm = service.getSystemService(Context.MEDIA_SESSION_SERVICE) as? MediaSessionManager
            ?: return
        val component = ComponentName(service, NotificationListener::class.java)
        val controllers = try {
            msm.getActiveSessions(component)
        } catch (e: SecurityException) {
            Log.w(TAG, "no notification listener access: ${e.message}")
            return
        }

        Log.d(TAG, "=========== SESSIONS: ${controllers.size} ===========")
        for (c in controllers) dumpController(c)
    }

    @JvmStatic
    fun dumpController(c: MediaController) {
        Log.d(TAG, "===== ${c.packageName} =====")

        val md = c.metadata
        if (md == null) {
            Log.d(TAG, "  metadata = null")
        } else {
            for (key in md.keySet()) {
                Log.d(TAG, "  META $key = ${describe(md, key)}")
            }
            val d = md.description
            Log.d(TAG, "  desc.mediaId = ${d.mediaId}")
            Log.d(TAG, "  desc.iconUri = ${d.iconUri}")
            try {
                Log.d(TAG, "  desc.mediaUri = ${d.mediaUri}")
            } catch (_: Exception) {
            }
        }

        dumpBundle("controller.extras", c.extras)

        val ps = c.playbackState
        if (ps == null) {
            Log.d(TAG, "  playbackState = null")
        } else {
            Log.d(TAG, "  state = ${ps.state}")
            Log.d(TAG, "  actions = 0x${java.lang.Long.toHexString(ps.actions)}")
            Log.d(TAG, "  SET_RATING = ${(ps.actions and PlaybackState.ACTION_SET_RATING) != 0L}")
            val custom = ps.customActions
            if (custom.isEmpty()) {
                Log.d(TAG, "  customActions: NONE")
            } else {
                for (a in custom) {
                    Log.d(TAG, "  customAction id=${a.action} name=${a.name} icon=${a.icon}")
                }
            }
            dumpBundle("playbackState.extras", ps.extras)
        }

        val queue = c.queue
        if (queue.isNullOrEmpty()) {
            Log.d(TAG, "  queue: empty")
        } else {
            for (q in queue) {
                Log.d(
                    TAG,
                    "  queue mediaId=${q.description.mediaId}" +
                        " title=${q.description.title}" +
                        " iconUri=${q.description.iconUri}"
                )
            }
        }

        Log.d(TAG, "  >>> videoId candidate = ${findVideoId(c)}")
    }

    @JvmStatic
    fun findVideoId(c: MediaController): String? {
        val candidates = ArrayList<String>()

        c.metadata?.let { md ->
            for (key in md.keySet()) {
                try {
                    md.getString(key)?.let { candidates.add(it) }
                } catch (_: Exception) {
                }
            }
            val d = md.description
            d.mediaId?.let { candidates.add(it) }
            d.iconUri?.let { candidates.add(it.toString()) }
            try {
                d.mediaUri?.let { candidates.add(it.toString()) }
            } catch (_: Exception) {
            }
        }

        c.queue?.forEach { q ->
            q.description.mediaId?.let { candidates.add(it) }
            q.description.iconUri?.let { candidates.add(it.toString()) }
        }

        for (s in candidates) {
            VIDEO_ID_IN_URL.find(s)?.let { return it.groupValues[1] }
        }
        for (s in candidates) {
            if (BARE_VIDEO_ID.matches(s)) return s
        }
        return null
    }

    private fun describe(md: MediaMetadata, key: String): String {
        try {
            md.getString(key)?.let { return "String: $it" }
        } catch (_: Exception) {
        }
        try {
            md.getRating(key)?.let {
                return "Rating: style=${it.ratingStyle} rated=${it.isRated}"
            }
        } catch (_: Exception) {
        }
        try {
            md.getBitmap(key)?.let { return "Bitmap ${it.width}x${it.height}" }
        } catch (_: Exception) {
        }
        try {
            val l = md.getLong(key)
            if (l != 0L) return "Long: $l"
        } catch (_: Exception) {
        }
        return "(empty)"
    }

    @Suppress("DEPRECATION")
    private fun dumpBundle(label: String, b: Bundle?) {
        if (b == null) {
            Log.d(TAG, "  $label = null")
            return
        }
        try {
            if (b.keySet().isEmpty()) {
                Log.d(TAG, "  $label = empty")
                return
            }
            for (k in b.keySet()) {
                Log.d(TAG, "  $label[$k] = ${b.get(k)}")
            }
        } catch (e: Exception) {
            Log.w(TAG, "  $label unreadable: ${e.message}")
        }
    }
}