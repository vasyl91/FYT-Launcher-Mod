package androidx.room.util;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FileUtil {
    public static void copy(ReadableByteChannel input, FileChannel output) throws IOException {
        try {
            output.transferFrom(input, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
            output.force(false);
        } finally {
            input.close();
            output.close();
        }
    }

    private FileUtil() {
    }
}
