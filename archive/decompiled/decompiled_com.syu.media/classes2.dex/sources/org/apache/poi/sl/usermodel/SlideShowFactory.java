package org.apache.poi.sl.usermodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.OldFileFormatException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SlideShowFactory {
    public static SlideShow<?, ?> create(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        return create(nPOIFSFileSystem, (String) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SlideShow<?, ?> create(NPOIFSFileSystem nPOIFSFileSystem, String str) throws IOException {
        Object[] objArr;
        InputStream decryptedStream = null;
        Object[] objArr2 = 0;
        if (nPOIFSFileSystem.getRoot().hasEntry(Decryptor.DEFAULT_POIFS_ENTRY)) {
            try {
                decryptedStream = DocumentFactoryHelper.getDecryptedStream(nPOIFSFileSystem, str);
                return createXSLFSlideShow(decryptedStream);
            } finally {
                IOUtils.closeQuietly(decryptedStream);
            }
        }
        if (str != null) {
            Biff8EncryptionKey.setCurrentUserPassword(str);
            objArr = true;
        } else {
            objArr = false;
        }
        try {
            return createHSLFSlideShow(nPOIFSFileSystem);
        } finally {
            if (objArr != false) {
                Biff8EncryptionKey.setCurrentUserPassword(null);
            }
        }
    }

    public static SlideShow<?, ?> create(InputStream inputStream) throws EncryptedDocumentException, IOException {
        return create(inputStream, (String) null);
    }

    public static SlideShow<?, ?> create(InputStream inputStream, String str) throws EncryptedDocumentException, IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.valueOf(inputStreamPrepareToCheckMagic).ordinal()];
        if (i == 1) {
            return create(new NPOIFSFileSystem(inputStreamPrepareToCheckMagic), str);
        }
        if (i == 2) {
            return createXSLFSlideShow(inputStreamPrepareToCheckMagic);
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.usermodel.SlideShowFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic;

        static {
            int[] iArr = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = iArr;
            try {
                iArr[FileMagic.OLE2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.OOXML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static SlideShow<?, ?> create(File file) throws EncryptedDocumentException, IOException {
        return create(file, (String) null);
    }

    public static SlideShow<?, ?> create(File file, String str) throws EncryptedDocumentException, IOException {
        return create(file, str, false);
    }

    public static SlideShow<?, ?> create(File file, String str, boolean z) throws EncryptedDocumentException, IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        NPOIFSFileSystem nPOIFSFileSystem = null;
        try {
            NPOIFSFileSystem nPOIFSFileSystem2 = new NPOIFSFileSystem(file, z);
            try {
                return create(nPOIFSFileSystem2, str);
            } catch (OfficeXmlFileException unused) {
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                return createXSLFSlideShow(file, Boolean.valueOf(z));
            } catch (RuntimeException e) {
                e = e;
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw e;
            }
        } catch (OfficeXmlFileException unused2) {
        } catch (RuntimeException e2) {
            e = e2;
        }
    }

    protected static SlideShow<?, ?> createHSLFSlideShow(Object... objArr) throws EncryptedDocumentException, IOException {
        return createSlideShow("org.apache.poi.hslf.usermodel.HSLFSlideShowFactory", objArr);
    }

    protected static SlideShow<?, ?> createXSLFSlideShow(Object... objArr) throws EncryptedDocumentException, IOException {
        return createSlideShow("org.apache.poi.xslf.usermodel.XSLFSlideShowFactory", objArr);
    }

    protected static SlideShow<?, ?> createSlideShow(String str, Object[] objArr) throws EncryptedDocumentException, IOException {
        try {
            Class<?> clsLoadClass = Thread.currentThread().getContextClassLoader().loadClass(str);
            Class<?>[] clsArr = new Class[objArr.length];
            int length = objArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Class<?> cls = objArr[i].getClass();
                if (Boolean.class.isAssignableFrom(cls)) {
                    cls = Boolean.TYPE;
                } else if (InputStream.class.isAssignableFrom(cls)) {
                    cls = InputStream.class;
                }
                clsArr[i2] = cls;
                i++;
                i2++;
            }
            return (SlideShow) clsLoadClass.getMethod("createSlideShow", clsArr).invoke(null, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof EncryptedDocumentException) {
                throw ((EncryptedDocumentException) cause);
            }
            if (cause instanceof OldFileFormatException) {
                throw ((OldFileFormatException) cause);
            }
            throw new IOException(cause);
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }
}
