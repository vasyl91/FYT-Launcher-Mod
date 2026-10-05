package com.android.launcher66.settings;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SharedPreferences that live in memory only, for the launcher's session state (the former
 * "HelpersPrefs" file: pipsAdded, isInWidgets, isInAllApps and the like).
 *
 * That file was cleared on every Launcher.onCreate() and after a long sleep, so nothing in it was
 * meant to outlive the process -- yet each of its flags, flipped many times a second around a pane
 * rebuild, was an apply(): a disk write with an fsync. Android waits for pending apply() writes at
 * activity pause/stop and service start/stop, and on a cold boot the launcher's main thread sat
 * 1.5 s in that wait (QueuedWork "waited <2048 ms", capture 05-10-2026 21:10:55) and skipped 73
 * frames. Same API, so callers did not have to change; no listeners, as nobody registered any.
 */
public final class SessionPrefs implements SharedPreferences {

    private static final SessionPrefs INSTANCE = new SessionPrefs();

    private final Map<String, Object> mValues = new ConcurrentHashMap<>();

    private SessionPrefs() {
    }

    public static SessionPrefs get() {
        return INSTANCE;
    }

    @Override
    public Map<String, ?> getAll() {
        return new HashMap<>(mValues);
    }

    @Nullable
    @Override
    public String getString(String key, @Nullable String defValue) {
        Object v = mValues.get(key);
        return v instanceof String ? (String) v : defValue;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        Object v = mValues.get(key);
        return v instanceof Set ? new HashSet<>((Set<String>) v) : defValues;
    }

    @Override
    public int getInt(String key, int defValue) {
        Object v = mValues.get(key);
        return v instanceof Integer ? (Integer) v : defValue;
    }

    @Override
    public long getLong(String key, long defValue) {
        Object v = mValues.get(key);
        return v instanceof Long ? (Long) v : defValue;
    }

    @Override
    public float getFloat(String key, float defValue) {
        Object v = mValues.get(key);
        return v instanceof Float ? (Float) v : defValue;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        Object v = mValues.get(key);
        return v instanceof Boolean ? (Boolean) v : defValue;
    }

    @Override
    public boolean contains(String key) {
        return mValues.containsKey(key);
    }

    @Override
    public Editor edit() {
        return new MemoryEditor();
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("SessionPrefs has no change listeners");
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
    }

    /**
     * Like the real editor: changes are collected and take effect on apply()/commit(), clear()
     * first. The static editor Helpers keeps is reused, so the pending changes are reset on apply.
     */
    private final class MemoryEditor implements Editor {
        private final Map<String, Object> mPending = new HashMap<>();
        private final Set<String> mRemoved = new HashSet<>();
        private boolean mClear;

        @Override
        public synchronized Editor putString(String key, @Nullable String value) {
            return putValue(key, value);
        }

        @Override
        public synchronized Editor putStringSet(String key, @Nullable Set<String> values) {
            return putValue(key, values == null ? null : new HashSet<>(values));
        }

        @Override
        public synchronized Editor putInt(String key, int value) {
            return putValue(key, value);
        }

        @Override
        public synchronized Editor putLong(String key, long value) {
            return putValue(key, value);
        }

        @Override
        public synchronized Editor putFloat(String key, float value) {
            return putValue(key, value);
        }

        @Override
        public synchronized Editor putBoolean(String key, boolean value) {
            return putValue(key, value);
        }

        private Editor putValue(String key, @Nullable Object value) {
            if (value == null) {
                return remove(key);
            }
            mRemoved.remove(key);
            mPending.put(key, value);
            return this;
        }

        @Override
        public synchronized Editor remove(String key) {
            mPending.remove(key);
            mRemoved.add(key);
            return this;
        }

        @Override
        public synchronized Editor clear() {
            mClear = true;
            return this;
        }

        @Override
        public boolean commit() {
            apply();
            return true;
        }

        @Override
        public synchronized void apply() {
            if (mClear) {
                mValues.clear();
                mClear = false;
            }
            for (String key : mRemoved) {
                mValues.remove(key);
            }
            mValues.putAll(mPending);
            mRemoved.clear();
            mPending.clear();
        }
    }
}
