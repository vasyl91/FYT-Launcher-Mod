package org.apache.poi.xssf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.UByte;
import org.apache.poi.POIXMLException;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSSFBStylesTable extends XSSFBParser {
    private boolean inCellXFS;
    private boolean inFmts;
    private final SortedMap<Short, String> numberFormats;
    private final List<Short> styleIds;

    public XSSFBStylesTable(InputStream inputStream) throws IOException {
        super(inputStream);
        this.numberFormats = new TreeMap();
        this.styleIds = new ArrayList();
        this.inCellXFS = false;
        this.inFmts = false;
        parse();
    }

    String getNumberFormatString(int i) {
        short numberFormatIndex = getNumberFormatIndex(i);
        if (this.numberFormats.containsKey(Short.valueOf(numberFormatIndex))) {
            return this.numberFormats.get(Short.valueOf(numberFormatIndex));
        }
        return BuiltinFormats.getBuiltinFormat(numberFormatIndex);
    }

    short getNumberFormatIndex(int i) {
        return this.styleIds.get(i).shortValue();
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBStylesTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtBeginCellXFs.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndCellXFs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtXf.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtBeginFmts.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndFmts.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmt.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // org.apache.poi.xssf.binary.XSSFBParser
    public void handleRecord(int i, byte[] bArr) throws XSSFBParseException {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i).ordinal()]) {
            case 1:
                this.inCellXFS = true;
                break;
            case 2:
                this.inCellXFS = false;
                break;
            case 3:
                if (this.inCellXFS) {
                    handleBrtXFInCellXF(bArr);
                }
                break;
            case 4:
                this.inFmts = true;
                break;
            case 5:
                this.inFmts = false;
                break;
            case 6:
                if (this.inFmts) {
                    handleFormat(bArr);
                }
                break;
        }
    }

    private void handleFormat(byte[] bArr) {
        int i = bArr[0] & UByte.MAX_VALUE;
        if (i > 32767) {
            throw new POIXMLException("Format id must be a short");
        }
        StringBuilder sb = new StringBuilder();
        XSSFBUtils.readXLWideString(bArr, 2, sb);
        this.numberFormats.put(Short.valueOf((short) i), sb.toString());
    }

    private void handleBrtXFInCellXF(byte[] bArr) {
        this.styleIds.add(Short.valueOf((short) (bArr[2] & UByte.MAX_VALUE)));
    }
}
