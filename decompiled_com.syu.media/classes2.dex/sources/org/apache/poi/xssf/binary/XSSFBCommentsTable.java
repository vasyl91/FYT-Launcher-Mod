package org.apache.poi.xssf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSSFBCommentsTable extends XSSFBParser {
    private StringBuilder authorBuffer;
    private int authorId;
    private List<String> authors;
    private CellAddress cellAddress;
    private XSSFBCellRange cellRange;
    private String comment;
    private Queue<CellAddress> commentAddresses;
    private Map<CellAddress, XSSFBComment> comments;

    public XSSFBCommentsTable(InputStream inputStream) throws IOException {
        super(inputStream);
        this.comments = new TreeMap();
        this.commentAddresses = new LinkedList();
        this.authors = new ArrayList();
        this.authorId = -1;
        this.cellAddress = null;
        this.cellRange = null;
        this.comment = null;
        this.authorBuffer = new StringBuilder();
        parse();
        this.commentAddresses.addAll(this.comments.keySet());
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBCommentsTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtBeginComment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCommentText.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndComment.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCommentAuthor.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // org.apache.poi.xssf.binary.XSSFBParser
    public void handleRecord(int i, byte[] bArr) throws XSSFBParseException {
        int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i).ordinal()];
        if (i2 == 1) {
            this.authorId = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr));
            this.cellRange = XSSFBCellRange.parse(bArr, 4, this.cellRange);
            this.cellAddress = new CellAddress(this.cellRange.firstRow, this.cellRange.firstCol);
        } else {
            if (i2 == 2) {
                this.comment = XSSFBRichStr.build(bArr, 0).getString();
                return;
            }
            if (i2 == 3) {
                this.comments.put(this.cellAddress, new XSSFBComment(this.cellAddress, this.authors.get(this.authorId), this.comment));
                this.authorId = -1;
                this.cellAddress = null;
            } else {
                if (i2 != 4) {
                    return;
                }
                this.authorBuffer.setLength(0);
                XSSFBUtils.readXLWideString(bArr, 0, this.authorBuffer);
                this.authors.add(this.authorBuffer.toString());
            }
        }
    }

    public Queue<CellAddress> getAddresses() {
        return this.commentAddresses;
    }

    public XSSFBComment get(CellAddress cellAddress) {
        if (cellAddress == null) {
            return null;
        }
        return this.comments.get(cellAddress);
    }
}
