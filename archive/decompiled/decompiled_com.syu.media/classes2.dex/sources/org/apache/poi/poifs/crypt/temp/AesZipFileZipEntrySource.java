package org.apache.poi.poifs.crypt.temp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AesZipFileZipEntrySource implements ZipEntrySource {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) AesZipFileZipEntrySource.class);
    private final Cipher ci;
    private boolean closed = false;
    private final File tmpFile;
    private final ZipFile zipFile;

    public AesZipFileZipEntrySource(File file, Cipher cipher) throws IOException {
        this.tmpFile = file;
        this.zipFile = new ZipFile(file);
        this.ci = cipher;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public Enumeration<? extends ZipEntry> getEntries() {
        return this.zipFile.entries();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        return new CipherInputStream(this.zipFile.getInputStream(zipEntry), this.ci);
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.zipFile.close();
            if (!this.tmpFile.delete()) {
                LOG.log(5, this.tmpFile.getAbsolutePath() + " can't be removed (or was already removed.");
            }
        }
        this.closed = true;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public boolean isClosed() {
        return this.closed;
    }

    public static AesZipFileZipEntrySource createZipEntrySource(InputStream inputStream) throws GeneralSecurityException, IOException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        File fileCreateTempFile = TempFile.createTempFile("protectedXlsx", ".zip");
        copyToFile(inputStream, fileCreateTempFile, CipherAlgorithm.aes128, bArr2, bArr);
        IOUtils.closeQuietly(inputStream);
        return fileToSource(fileCreateTempFile, CipherAlgorithm.aes128, bArr2, bArr);
    }

    private static void copyToFile(InputStream inputStream, File file, CipherAlgorithm cipherAlgorithm, byte[] bArr, byte[] bArr2) throws GeneralSecurityException, IOException {
        Cipher cipher = CryptoFunctions.getCipher(new SecretKeySpec(bArr, cipherAlgorithm.jceId), cipherAlgorithm, ChainingMode.cbc, bArr2, 1, "PKCS5Padding");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                ZipEntry zipEntry = new ZipEntry(nextEntry.getName());
                zipEntry.setComment(nextEntry.getComment());
                zipEntry.setExtra(nextEntry.getExtra());
                zipEntry.setTime(nextEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry);
                FilterOutputStream filterOutputStream = new FilterOutputStream(zipOutputStream) { // from class: org.apache.poi.poifs.crypt.temp.AesZipFileZipEntrySource.1
                    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }
                };
                CipherOutputStream cipherOutputStream = new CipherOutputStream(filterOutputStream, cipher);
                IOUtils.copy(zipInputStream, cipherOutputStream);
                cipherOutputStream.close();
                filterOutputStream.close();
                zipOutputStream.closeEntry();
                zipInputStream.closeEntry();
            } else {
                zipOutputStream.close();
                fileOutputStream.close();
                zipInputStream.close();
                return;
            }
        }
    }

    private static AesZipFileZipEntrySource fileToSource(File file, CipherAlgorithm cipherAlgorithm, byte[] bArr, byte[] bArr2) throws IOException {
        return new AesZipFileZipEntrySource(file, CryptoFunctions.getCipher(new SecretKeySpec(bArr, cipherAlgorithm.jceId), cipherAlgorithm, ChainingMode.cbc, bArr2, 2, "PKCS5Padding"));
    }
}
