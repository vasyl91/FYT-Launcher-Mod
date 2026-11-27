package com.android.launcher66;

/**
 * A value worked out from the settings once and kept until a setting changes ({@link #forget()}): the paths of
 * a touch ask the same settings for every move, and the search for a cell while an item is dragged asks them
 * hundreds of times for one move (TouchSettings).
 *
 * <p>The rule: {@link #get()} reads only the first time and after {@link #forget()}; between them it gives what
 * it read. A forget() during a reading is not lost: that reading's value is given to its caller but not kept, so
 * the next get() reads again.
 */
public final class KeptReading<T> {

    /** How the value is worked out from the settings. */
    public interface Reader<T> {
        T read();
    }

    private final Reader<T> mReader;
    private T mValue;
    private boolean mKept;
    private int mGeneration;

    public KeptReading(Reader<T> reader) {
        mReader = reader;
    }

    public T get() {
        int generation;
        synchronized (this) {
            if (mKept) {
                return mValue;
            }
            generation = mGeneration;
        }
        // Read outside the lock: a reader may take the settings' own lock
        T value = mReader.read();
        synchronized (this) {
            if (generation == mGeneration) {
                mValue = value;
                mKept = true;
            }
        }
        return value;
    }

    /** The settings changed: the next get() reads them again. */
    public synchronized void forget() {
        mKept = false;
        mValue = null;
        mGeneration++;
    }
}
