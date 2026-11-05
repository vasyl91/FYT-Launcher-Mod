package org.apache.poi.util;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultTempFileCreationStrategy implements TempFileCreationStrategy {
    private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    public static final String KEEP_FILES = "poi.keep.tmp.files";
    static final String POIFILES = "poifiles";
    private static final SecureRandom random = new SecureRandom();
    private File dir;

    public DefaultTempFileCreationStrategy() {
        this(null);
    }

    public DefaultTempFileCreationStrategy(File file) {
        this.dir = file;
    }

    private void createPOIFilesDirectory() throws IOException {
        if (this.dir == null) {
            String property = System.getProperty("java.io.tmpdir");
            if (property == null) {
                throw new IOException("Systems temporary directory not defined - set the -Djava.io.tmpdir jvm property!");
            }
            this.dir = new File(property, POIFILES);
        }
        createTempDirectory(this.dir);
    }

    private void createTempDirectory(File file) throws IOException {
        if (!(file.exists() || file.mkdirs())) {
            throw new IOException("Could not create temporary directory '" + file + "'");
        }
        if (!file.isDirectory()) {
            throw new IOException("Could not create temporary directory. '" + file + "' exists but is not a directory.");
        }
    }

    @Override // org.apache.poi.util.TempFileCreationStrategy
    public File createTempFile(String str, String str2) throws IOException {
        createPOIFilesDirectory();
        File fileCreateTempFile = File.createTempFile(str, str2, this.dir);
        if (System.getProperty(KEEP_FILES) == null) {
            fileCreateTempFile.deleteOnExit();
        }
        return fileCreateTempFile;
    }

    @Override // org.apache.poi.util.TempFileCreationStrategy
    public File createTempDirectory(String str) throws IOException {
        createPOIFilesDirectory();
        File file = new File(this.dir, str + Long.toString(random.nextLong()));
        createTempDirectory(file);
        if (System.getProperty(KEEP_FILES) == null) {
            file.deleteOnExit();
        }
        return file;
    }
}
