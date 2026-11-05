package com.fasterxml.aalto.util;

import chip.FinalChip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class URLUtil {
    private URLUtil() {
    }

    public static URL urlFromSystemId(String str) throws IOException {
        try {
            int iIndexOf = str.indexOf(58, 0);
            if (iIndexOf >= 3 && iIndexOf <= 8) {
                return new URL(str);
            }
            return fileToURL(new File(str));
        } catch (MalformedURLException e) {
            throwIoException(e, str);
            return null;
        }
    }

    public static URL urlFromSystemId(String str, URL url) throws IOException {
        if (url == null) {
            return urlFromSystemId(str);
        }
        try {
            return new URL(url, str);
        } catch (MalformedURLException e) {
            throwIoException(e, str);
            return null;
        }
    }

    public static URL urlFromCurrentDir() throws IOException {
        return fileToURL(new File("a").getAbsoluteFile().getParentFile());
    }

    public static InputStream inputStreamFromURL(URL url) throws IOException {
        String host;
        if ("file".equals(url.getProtocol()) && ((host = url.getHost()) == null || host.length() == 0)) {
            return new FileInputStream(url.getPath());
        }
        return url.openStream();
    }

    public static OutputStream outputStreamFromURL(URL url) throws IOException {
        String host;
        if ("file".equals(url.getProtocol()) && ((host = url.getHost()) == null || host.length() == 0)) {
            return new FileOutputStream(url.getPath());
        }
        return url.openConnection().getOutputStream();
    }

    public static URL fileToURL(File file) throws IOException {
        String absolutePath = file.getAbsolutePath();
        char c = File.separatorChar;
        if (c != '/') {
            absolutePath = absolutePath.replace(c, '/');
        }
        if (absolutePath.length() > 0 && absolutePath.charAt(0) != '/') {
            absolutePath = "/" + absolutePath;
        }
        return new URL("file", FinalChip.BSP_PLATFORM_Null, absolutePath);
    }

    public static String fileToSystemId(File file) throws IOException {
        return fileToURL(file).toExternalForm();
    }

    public static String urlToSystemId(URL url) {
        return url.toExternalForm();
    }

    private static void throwIoException(MalformedURLException malformedURLException, String str) throws IOException {
        IOException iOException = new IOException("[resolving systemId '" + str + "']: " + malformedURLException.toString());
        iOException.initCause(malformedURLException);
        throw iOException;
    }
}
