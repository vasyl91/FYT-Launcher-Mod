package com.android.launcher66;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Stats {
    private FileNotFoundException e;
    private Throwable th;
    public static final String ACTION_LAUNCH = "com.android.launcher66.action.LAUNCH";
    private static final boolean DEBUG_BROADCASTS = false;
    public static final String EXTRA_CELLX = "cellX";
    public static final String EXTRA_CELLY = "cellY";
    public static final String EXTRA_CONTAINER = "container";
    public static final String EXTRA_INTENT = "intent";
    public static final String EXTRA_SCREEN = "screen";
    private static final boolean FLUSH_IMMEDIATELY = true;
    private static final int INITIAL_STATS_SIZE = 100;
    private static final boolean LOCAL_LAUNCH_LOG = true;
    private static final String LOG_FILE_NAME = "launches.log";
    private static final int LOG_TAG_LAUNCH = 4096;
    private static final int LOG_TAG_VERSION = 1;
    private static final int LOG_VERSION = 1;
    public static final String PERM_LAUNCH = "com.android.launcher66.permission.RECEIVE_LAUNCH_BROADCASTS";
    private static final String STATS_FILE_NAME = "stats.log";
    private static final int STATS_VERSION = 1;
    private static final String TAG = "launcher66/Stats";
    ArrayList<Integer> mHistogram;
    ArrayList<String> mIntents;
    private final Launcher mLauncher;
    DataOutputStream mLog;

    public Stats(Launcher launcher) {
        this.mLauncher = launcher;
        loadStats();
        try {
            this.mLog = new DataOutputStream(this.mLauncher.openFileOutput(LOG_FILE_NAME, Context.MODE_APPEND));
            this.mLog.writeInt(1);
            this.mLog.writeInt(1);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "unable to create stats log: " + e);
            this.mLog = null;
        } catch (IOException e2) {
            Log.e(TAG, "unable to write to stats log: " + e2);
            this.mLog = null;
        }
    }

    public void incrementLaunch(String intentStr) {
        int pos = this.mIntents.indexOf(intentStr);
        if (pos < 0) {
            this.mIntents.add(intentStr);
            this.mHistogram.add(1);
        } else {
            this.mHistogram.set(pos, Integer.valueOf(this.mHistogram.get(pos).intValue() + 1));
        }
    }

    public void recordLaunch(Intent intent) {
        recordLaunch(intent, null);
    }

    public void recordLaunch(Intent intent, ShortcutInfo shortcut) {
        Intent intent2 = new Intent(intent);
        intent2.setSourceBounds(null);
        String flat = intent2.toUri(0);
        Intent broadcastIntent = new Intent(ACTION_LAUNCH).putExtra("intent", flat);
        if (shortcut != null) {
            broadcastIntent.putExtra(EXTRA_CONTAINER, shortcut.container).putExtra(EXTRA_SCREEN, shortcut.screenId).putExtra(EXTRA_CELLX, shortcut.cellX).putExtra(EXTRA_CELLY, shortcut.cellY);
        }
        this.mLauncher.sendBroadcast(broadcastIntent, "com.android.launcher66.permission.RECEIVE_LAUNCH_BROADCASTS");
        incrementLaunch(flat);
        saveStats();
        if (this.mLog != null) {
            try {
                this.mLog.writeInt(4096);
                this.mLog.writeLong(System.currentTimeMillis());
                if (shortcut == null) {
                    this.mLog.writeShort(0);
                    this.mLog.writeShort(0);
                    this.mLog.writeShort(0);
                    this.mLog.writeShort(0);
                } else {
                    this.mLog.writeShort((short) shortcut.container);
                    this.mLog.writeShort((short) shortcut.screenId);
                    this.mLog.writeShort((short) shortcut.cellX);
                    this.mLog.writeShort((short) shortcut.cellY);
                }
                this.mLog.writeUTF(flat);
                this.mLog.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveStats() {
        DataOutputStream stats = null;
        DataOutputStream stats2 = null;
        try {
            stats = new DataOutputStream(this.mLauncher.openFileOutput("stats.log.tmp", 0));
        } catch (Throwable th) {
            th = th;
        }
        try {
            stats.writeInt(1);
            int N = this.mHistogram.size();
            stats.writeInt(N);
            for (int i = 0; i < N; i++) {
                stats.writeUTF(this.mIntents.get(i));
                stats.writeInt(this.mHistogram.get(i).intValue());
            }
            stats.close();
            stats2 = null;
            this.mLauncher.getFileStreamPath("stats.log.tmp").renameTo(this.mLauncher.getFileStreamPath(STATS_FILE_NAME));
            if (0 != 0) {
                try {
                    stats2.close();
                } catch (IOException e3) {
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            stats2 = stats;
            Log.e(TAG, "unable to create stats data: " + e);
            if (stats2 != null) {
                try {
                    stats2.close();
                } catch (IOException e5) {
                }
            }
        } catch (IOException e6) {
            e = (FileNotFoundException) e6;
            stats2 = stats;
            Log.e(TAG, "unable to write to stats data: " + e);
            if (stats2 != null) {
                try {
                    stats2.close();
                } catch (IOException e7) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            stats2 = stats;
            if (stats2 != null) {
                try {
                    stats2.close();
                } catch (IOException e8) {
                }
            }
            try {
                throw th;
            } catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void loadStats() {
        this.mIntents = new ArrayList<>(100);
        this.mHistogram = new ArrayList<>(100);
        DataInputStream stats = null;
        try {
            DataInputStream stats2 = new DataInputStream(this.mLauncher.openFileInput(STATS_FILE_NAME));
            try {
                int version = stats2.readInt();
                if (version == 1) {
                    int N = stats2.readInt();
                    for (int i = 0; i < N; i++) {
                        String pkg = stats2.readUTF();
                        int count = stats2.readInt();
                        this.mIntents.add(pkg);
                        this.mHistogram.add(Integer.valueOf(count));
                    }
                }
                if (stats2 != null) {
                    try {
                        stats2.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                stats = stats2;
                if (stats != null) {
                    try {
                        stats.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                stats = stats2;
                if (stats != null) {
                    try {
                        stats.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                stats = stats2;
                if (stats != null) {
                    try {
                        stats.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
        } catch (IOException e8) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
