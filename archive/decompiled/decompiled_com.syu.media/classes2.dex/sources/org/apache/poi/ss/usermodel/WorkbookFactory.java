package org.apache.poi.ss.usermodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class WorkbookFactory {
    public static Workbook create(POIFSFileSystem pOIFSFileSystem) throws IOException {
        return new HSSFWorkbook(pOIFSFileSystem);
    }

    public static Workbook create(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        try {
            return create(nPOIFSFileSystem, (String) null);
        } catch (InvalidFormatException e) {
            throw new IOException(e);
        }
    }

    private static Workbook create(NPOIFSFileSystem nPOIFSFileSystem, String str) throws InvalidFormatException, IOException {
        boolean z;
        DirectoryNode root = nPOIFSFileSystem.getRoot();
        if (root.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY)) {
            return create(OPCPackage.open(DocumentFactoryHelper.getDecryptedStream(nPOIFSFileSystem, str)));
        }
        if (str != null) {
            Biff8EncryptionKey.setCurrentUserPassword(str);
            z = true;
        } else {
            z = false;
        }
        try {
            return new HSSFWorkbook(root, true);
        } finally {
            if (z) {
                Biff8EncryptionKey.setCurrentUserPassword(null);
            }
        }
    }

    public static Workbook create(OPCPackage oPCPackage) throws IOException {
        return new XSSFWorkbook(oPCPackage);
    }

    public static Workbook create(InputStream inputStream) throws InvalidFormatException, EncryptedDocumentException, IOException {
        return create(inputStream, (String) null);
    }

    public static Workbook create(InputStream inputStream, String str) throws InvalidFormatException, EncryptedDocumentException, IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.valueOf(inputStreamPrepareToCheckMagic).ordinal()];
        if (i == 1) {
            return create(new NPOIFSFileSystem(inputStreamPrepareToCheckMagic), str);
        }
        if (i == 2) {
            return new XSSFWorkbook(OPCPackage.open(inputStreamPrepareToCheckMagic));
        }
        throw new InvalidFormatException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.WorkbookFactory$1, reason: invalid class name */
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

    public static Workbook create(File file) throws InvalidFormatException, EncryptedDocumentException, IOException {
        return create(file, (String) null);
    }

    public static Workbook create(File file, String str) throws InvalidFormatException, EncryptedDocumentException, IOException {
        return create(file, str, false);
    }

    public static Workbook create(File file, String str, boolean z) throws InvalidFormatException, EncryptedDocumentException, IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        try {
            NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(file, z);
            try {
                return create(nPOIFSFileSystem, str);
            } catch (RuntimeException e) {
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw e;
            }
        } catch (OfficeXmlFileException unused) {
            OPCPackage oPCPackageOpen = OPCPackage.open(file, z ? PackageAccess.READ : PackageAccess.READ_WRITE);
            try {
                return new XSSFWorkbook(oPCPackageOpen);
            } catch (Exception e2) {
                oPCPackageOpen.revert();
                if (e2 instanceof IOException) {
                    throw ((IOException) e2);
                }
                if (e2 instanceof RuntimeException) {
                    throw ((RuntimeException) e2);
                }
                throw new IOException(e2);
            }
        }
    }
}
