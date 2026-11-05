package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PropertySetFactory {
    public static PropertySet create(DirectoryEntry directoryEntry, String str) throws Throwable {
        DocumentInputStream documentInputStream = null;
        try {
            DocumentInputStream documentInputStream2 = new DocumentInputStream((DocumentEntry) directoryEntry.getEntry(str));
            try {
                PropertySet propertySetCreate = create(documentInputStream2);
                documentInputStream2.close();
                return propertySetCreate;
            } catch (MarkUnsupportedException unused) {
                documentInputStream2.close();
                return null;
            } catch (Throwable th) {
                th = th;
                documentInputStream = documentInputStream2;
                if (documentInputStream != null) {
                    documentInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static PropertySet create(InputStream inputStream) throws MarkUnsupportedException, NoPropertySetStreamException, IOException {
        inputStream.mark(45);
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(inputStream);
        int uShort = littleEndianInputStream.readUShort();
        int uShort2 = littleEndianInputStream.readUShort();
        littleEndianInputStream.readUInt();
        byte[] bArr = new byte[16];
        littleEndianInputStream.readFully(bArr);
        int uInt = (int) littleEndianInputStream.readUInt();
        if (uShort != 65534 || uShort2 != 0 || uInt < 0) {
            throw new NoPropertySetStreamException();
        }
        if (uInt > 0) {
            littleEndianInputStream.readFully(bArr);
        }
        inputStream.reset();
        ClassID classID = new ClassID(bArr, 0);
        if (uInt > 0 && PropertySet.matchesSummary(classID, SectionIDMap.SUMMARY_INFORMATION_ID)) {
            return new SummaryInformation(inputStream);
        }
        if (uInt > 0 && PropertySet.matchesSummary(classID, SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID)) {
            return new DocumentSummaryInformation(inputStream);
        }
        return new PropertySet(inputStream);
    }

    public static SummaryInformation newSummaryInformation() {
        return new SummaryInformation();
    }

    public static DocumentSummaryInformation newDocumentSummaryInformation() {
        return new DocumentSummaryInformation();
    }
}
