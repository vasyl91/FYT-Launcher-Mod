package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class ZipHelper {
    private static final String FORWARD_SLASH = "/";

    @Removal(version = "3.18")
    @Deprecated
    public static final int READ_WRITE_FILE_BUFFER_SIZE = 8192;

    private ZipHelper() {
    }

    public static ZipEntry getCorePropertiesZipEntry(ZipPackage zipPackage) {
        PackageRelationship relationship = zipPackage.getRelationshipsByType(PackageRelationshipTypes.CORE_PROPERTIES).getRelationship(0);
        if (relationship == null) {
            return null;
        }
        return new ZipEntry(relationship.getTargetURI().getPath());
    }

    public static ZipEntry getContentTypeZipEntry(ZipPackage zipPackage) {
        Enumeration<? extends ZipEntry> entries = zipPackage.getZipArchive().getEntries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = entries.nextElement();
            if (zipEntryNextElement.getName().equals(ContentTypeManager.CONTENT_TYPES_PART_NAME)) {
                return zipEntryNextElement;
            }
        }
        return null;
    }

    public static String getOPCNameFromZipItemName(String str) {
        if (str != null) {
            return str.startsWith(FORWARD_SLASH) ? str : FORWARD_SLASH + str;
        }
        throw new IllegalArgumentException("zipItemName cannot be null");
    }

    public static String getZipItemNameFromOPCName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName cannot be null");
        }
        while (str.startsWith(FORWARD_SLASH)) {
            str = str.substring(1);
        }
        return str;
    }

    public static URI getZipURIFromOPCName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("opcItemName");
        }
        while (str.startsWith(FORWARD_SLASH)) {
            str = str.substring(1);
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static void verifyZipHeader(InputStream inputStream) throws NotOfficeXmlFileException, IOException {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.valueOf(FileMagic.prepareToCheckMagic(inputStream)).ordinal()];
        if (i == 1) {
            throw new OLE2NotOfficeXmlFileException("The supplied data appears to be in the OLE2 Format. You are calling the part of POI that deals with OOXML (Office Open XML) Documents. You need to call a different part of POI to process this data (eg HSSF instead of XSSF)");
        }
        if (i == 2) {
            throw new NotOfficeXmlFileException("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.openxml4j.opc.internal.ZipHelper$1, reason: invalid class name */
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
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.XML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.OOXML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static ZipSecureFile.ThresholdInputStream openZipStream(InputStream inputStream) throws IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        verifyZipHeader(inputStreamPrepareToCheckMagic);
        return ZipSecureFile.addThreshold(new ZipInputStream(inputStreamPrepareToCheckMagic));
    }

    public static ZipFile openZipFile(File file) throws NotOfficeXmlFileException, IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            verifyZipHeader(fileInputStream);
            return new ZipSecureFile(file);
        } finally {
            fileInputStream.close();
        }
    }

    public static ZipFile openZipFile(String str) throws IOException {
        return openZipFile(new File(str));
    }
}
