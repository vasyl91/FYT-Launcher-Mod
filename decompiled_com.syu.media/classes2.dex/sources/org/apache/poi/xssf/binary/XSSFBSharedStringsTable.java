package org.apache.poi.xssf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSSFBSharedStringsTable {
    private int count;
    private List<String> strings = new ArrayList();
    private int uniqueCount;

    public XSSFBSharedStringsTable(OPCPackage oPCPackage) throws SAXException, IOException {
        ArrayList<PackagePart> partsByContentType = oPCPackage.getPartsByContentType(XSSFBRelation.SHARED_STRINGS_BINARY.getContentType());
        if (partsByContentType.size() > 0) {
            readFrom(partsByContentType.get(0).getInputStream());
        }
    }

    XSSFBSharedStringsTable(PackagePart packagePart) throws SAXException, IOException {
        readFrom(packagePart.getInputStream());
    }

    private void readFrom(InputStream inputStream) throws IOException {
        new SSTBinaryReader(inputStream).parse();
    }

    public List<String> getItems() {
        ArrayList arrayList = new ArrayList(this.strings.size());
        arrayList.addAll(this.strings);
        return arrayList;
    }

    public String getEntryAt(int i) {
        return this.strings.get(i);
    }

    public int getCount() {
        return this.count;
    }

    public int getUniqueCount() {
        return this.uniqueCount;
    }

    private class SSTBinaryReader extends XSSFBParser {
        SSTBinaryReader(InputStream inputStream) {
            super(inputStream);
        }

        @Override // org.apache.poi.xssf.binary.XSSFBParser
        public void handleRecord(int i, byte[] bArr) throws XSSFBParseException {
            int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i).ordinal()];
            if (i2 == 1) {
                XSSFBSharedStringsTable.this.strings.add(XSSFBRichStr.build(bArr, 0).getString());
            } else {
                if (i2 != 2) {
                    return;
                }
                XSSFBSharedStringsTable.this.count = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, 0));
                XSSFBSharedStringsTable.this.uniqueCount = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, 4));
            }
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBSharedStringsTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtSstItem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtBeginSst.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
