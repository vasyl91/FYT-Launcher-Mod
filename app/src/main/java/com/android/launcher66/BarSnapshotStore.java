package com.android.launcher66;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The bottom and left bars exactly as they were last shown, so that a start can draw them at once
 * instead of waiting until the whole app list is loaded (37.4 s and 45.7 s of uptime in captures
 * 29-09-2026 20:51 and 21:40, against a first frame at ~23 s).
 *
 * A snapshot carries the signature of what the bar was built from (its database rows and the
 * layout settings); Launcher uses it only when that signature still matches, and only until the
 * real list is built. Written from a background thread; read from one as well.
 */
final class BarSnapshotStore {

    static final String BOTTOM = "bottom";
    static final String LEFT = "left";

    private static final String TAG = "Launcher.BarSnapshot";
    private static final int MAGIC = 0x4C364253; // "L6BS"
    private static final int FORMAT = 1;

    private static final ExecutorService WRITER = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "BarSnapshotWrite");
        t.setDaemon(true);
        t.setPriority(Thread.MIN_PRIORITY);
        return t;
    });

    private BarSnapshotStore() {
    }

    /** One bar entry as shown: the database row it came from, what it launches, name and icon. */
    static final class Item {
        final long rowDbId;
        final String packageName;
        final String className;
        final String name;
        final Bitmap icon;

        Item(long rowDbId, String packageName, String className, String name, Bitmap icon) {
            this.rowDbId = rowDbId;
            this.packageName = packageName;
            this.className = className;
            this.name = name;
            this.icon = icon;
        }
    }

    static final class Snapshot {
        final long signature;
        final List<Item> items;

        Snapshot(long signature, List<Item> items) {
            this.signature = signature;
            this.items = items;
        }
    }

    static File file(Context context, String which) {
        return new File(context.getFilesDir(), "bar_snapshot_" + which + ".bin");
    }

    /** Reads and decodes a snapshot; null if there is none or it cannot be read. Not on the UI thread. */
    static Snapshot load(Context context, String which) {
        File f = file(context, which);
        if (!f.isFile()) {
            return null;
        }
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(f)))) {
            if (in.readInt() != MAGIC || in.readInt() != FORMAT) {
                return null;
            }
            long signature = in.readLong();
            int count = in.readInt();
            if (count < 0 || count > 64) {
                return null;
            }
            List<Item> items = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                long rowDbId = in.readLong();
                String packageName = readNullableUtf(in);
                String className = readNullableUtf(in);
                String name = readNullableUtf(in);
                int density = in.readInt();
                int length = in.readInt();
                Bitmap icon = null;
                if (length > 0) {
                    byte[] png = new byte[length];
                    in.readFully(png);
                    icon = BitmapFactory.decodeByteArray(png, 0, length);
                    if (icon == null) {
                        return null; // a bar with a missing icon is worse than waiting
                    }
                    icon.setDensity(density);
                }
                items.add(new Item(rowDbId, packageName, className, name, icon));
            }
            return new Snapshot(signature, Collections.unmodifiableList(items));
        } catch (IOException | RuntimeException e) {
            Log.w(TAG, "snapshot " + which + " unreadable", e);
            return null;
        }
    }

    /** Replaces the snapshot of that bar, in the background. */
    static void saveAsync(Context context, String which, long signature, List<Item> items) {
        final File f = file(context, which);
        final List<Item> copy = new ArrayList<>(items);
        WRITER.execute(() -> write(f, signature, copy));
    }

    static void write(File f, long signature, List<Item> items) {
        File tmp = new File(f.getPath() + ".tmp");
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tmp)))) {
            out.writeInt(MAGIC);
            out.writeInt(FORMAT);
            out.writeLong(signature);
            out.writeInt(items.size());
            for (Item item : items) {
                out.writeLong(item.rowDbId);
                writeNullableUtf(out, item.packageName);
                writeNullableUtf(out, item.className);
                writeNullableUtf(out, item.name);
                byte[] png = encode(item.icon);
                out.writeInt(item.icon != null ? item.icon.getDensity() : 0);
                out.writeInt(png != null ? png.length : 0);
                if (png != null) {
                    out.write(png);
                }
            }
        } catch (IOException | RuntimeException e) {
            Log.w(TAG, "snapshot not saved: " + f.getName(), e);
            //noinspection ResultOfMethodCallIgnored
            tmp.delete();
            return;
        }
        if (!tmp.renameTo(f)) {
            Log.w(TAG, "snapshot not saved: rename failed for " + f.getName());
            //noinspection ResultOfMethodCallIgnored
            tmp.delete();
        }
    }

    private static byte[] encode(Bitmap icon) {
        if (icon == null) {
            return null;
        }
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream(8192);
            return icon.compress(Bitmap.CompressFormat.PNG, 100, bytes) ? bytes.toByteArray() : null;
        } catch (RuntimeException e) {
            return null;
        }
    }

    private static void writeNullableUtf(DataOutputStream out, String s) throws IOException {
        out.writeBoolean(s != null);
        if (s != null) {
            out.writeUTF(s);
        }
    }

    private static String readNullableUtf(DataInputStream in) throws IOException {
        return in.readBoolean() ? in.readUTF() : null;
    }
}
