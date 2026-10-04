package com.fyt.skin.util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    private static final String TAG = "FileUtil";

    /**
     * Copies an asset to the given file, overwriting it. Returns whether the whole asset was
     * written. On failure (storage full, say) the target can be left incomplete, so a caller that
     * needs a complete file copies to a temporary name and renames it only after true.
     *
     * Both streams are closed on every path; they used to stay open after a failed write.
     */
    public static boolean copyFileFromAssets(Context context, String assetsFilePath, String targetFileFullPath) {
        Log.d(TAG, "copyFileFromAssets " + assetsFilePath + " -> " + targetFileFullPath);
        try (InputStream in = context.getAssets().open(assetsFilePath)) {
            return copyFile(in, targetFileFullPath);
        } catch (IOException e) {
            Log.w(TAG, "copyFileFromAssets failed for " + assetsFilePath, e);
            return false;
        }
    }

    private static boolean copyFile(InputStream in, String targetPath) {
        try (FileOutputStream fos = new FileOutputStream(new File(targetPath))) {
            byte[] buffer = new byte[8192];
            int byteCount;
            while ((byteCount = in.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
            return true;
        } catch (IOException e) {
            Log.w(TAG, "copyFile failed for " + targetPath, e);
            return false;
        }
    }
}
