package syu.utils;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002¨\u0006\u0014"}, d2 = {"Lsyu/utils/FileUtils;", "", "", "path", "", "exists", "isDirectory", "newFile", "deleteFile", "source", "dest", "copy", "Ljava/io/InputStream;", "ios", "Ljava/io/OutputStream;", "outers", "Landroid/content/Context;", "context", "fileName", "makeAppDirPath", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    public static void a(InputStream inputStream, OutputStream outputStream) {
        try {
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, (Throwable) null);
                        outputStream.flush();
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, (Throwable) null);
                        return;
                    }
                    outputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStream, th3);
                throw th4;
            }
        }
    }

    public final boolean copy(InputStream ios, String dest) {
        Intrinsics.checkNotNullParameter(ios, "ios");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (!newFile(dest)) {
            return false;
        }
        a(ios, new BufferedOutputStream(new FileOutputStream(dest)));
        return true;
    }

    public final boolean deleteFile(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public final boolean exists(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new File(path).exists();
    }

    public final boolean isDirectory(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new File(path).isDirectory();
    }

    public final String makeAppDirPath(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return context.getFilesDir().getAbsolutePath() + '/' + fileName;
    }

    public final boolean newFile(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new File(path).createNewFile();
    }

    public final boolean copy(String source, OutputStream outers) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(outers, "outers");
        if (!exists(source) || isDirectory(source)) {
            return false;
        }
        a(new BufferedInputStream(new FileInputStream(source)), outers);
        return true;
    }

    public final boolean copy(String source, String dest) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (!exists(source) || isDirectory(source) || !newFile(dest)) {
            return false;
        }
        a(new BufferedInputStream(new FileInputStream(source)), new BufferedOutputStream(new FileOutputStream(dest)));
        return true;
    }
}
