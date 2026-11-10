package org.apache.poi.hssf.extractor;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.OldFormulaRecord;
import org.apache.poi.hssf.record.OldLabelRecord;
import org.apache.poi.hssf.record.OldSheetRecord;
import org.apache.poi.hssf.record.OldStringRecord;
import org.apache.poi.hssf.record.RKRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class OldExcelExtractor implements Closeable {
    private static final int FILE_PASS_RECORD_SID = 47;
    private int biffVersion;
    private int fileType;
    private RecordInputStream ris;
    private Closeable toClose;

    public OldExcelExtractor(InputStream inputStream) throws IOException {
        open(inputStream);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0033 A[PHI: r0
  0x0033: PHI (r0v4 org.apache.poi.poifs.filesystem.NPOIFSFileSystem) = (r0v2 org.apache.poi.poifs.filesystem.NPOIFSFileSystem), (r0v5 org.apache.poi.poifs.filesystem.NPOIFSFileSystem) binds: [B:25:0x002c, B:28:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    public OldExcelExtractor(File file) throws Throwable {
        FileInputStream fileInputStream;
        NPOIFSFileSystem nPOIFSFileSystem = null;
        try {
            try {
                NPOIFSFileSystem nPOIFSFileSystem2 = new NPOIFSFileSystem(file);
                try {
                    open(nPOIFSFileSystem2);
                    this.toClose = nPOIFSFileSystem2;
                } catch (OldExcelFormatException unused) {
                    nPOIFSFileSystem = nPOIFSFileSystem2;
                    if (this.toClose == null) {
                        IOUtils.closeQuietly(nPOIFSFileSystem);
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        open(fileInputStream);
                    } catch (IOException e) {
                        fileInputStream.close();
                        throw e;
                    } catch (RuntimeException e2) {
                        fileInputStream.close();
                        throw e2;
                    }
                } catch (NotOLE2FileException unused2) {
                    nPOIFSFileSystem = nPOIFSFileSystem2;
                    if (this.toClose == null) {
                        IOUtils.closeQuietly(nPOIFSFileSystem);
                    }
                    fileInputStream = new FileInputStream(file);
                    open(fileInputStream);
                } catch (IOException e3) {
                } catch (RuntimeException e4) {
                } catch (Throwable th) {
                    th = th;
                    nPOIFSFileSystem = nPOIFSFileSystem2;
                    if (this.toClose == null) {
                        IOUtils.closeQuietly(nPOIFSFileSystem);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            throw e5;
        } catch (OldExcelFormatException unused3) {
        } catch (RuntimeException e6) {
            throw e6;
        } catch (NotOLE2FileException unused4) {
        }
    }

    public OldExcelExtractor(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        open(nPOIFSFileSystem);
    }

    public OldExcelExtractor(DirectoryNode directoryNode) throws IOException {
        open(directoryNode);
    }

    private void open(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 8);
        if (NPOIFSFileSystem.hasPOIFSHeader(bufferedInputStream)) {
            NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(bufferedInputStream);
            try {
                open(nPOIFSFileSystem);
                return;
            } finally {
                nPOIFSFileSystem.close();
            }
        }
        this.ris = new RecordInputStream(bufferedInputStream);
        this.toClose = bufferedInputStream;
        prepare();
    }

    private void open(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        open(nPOIFSFileSystem.getRoot());
    }

    private void open(DirectoryNode directoryNode) throws IOException {
        DocumentNode documentNode;
        try {
            documentNode = (DocumentNode) directoryNode.getEntry(InternalWorkbook.OLD_WORKBOOK_DIR_ENTRY_NAME);
        } catch (FileNotFoundException unused) {
            documentNode = (DocumentNode) directoryNode.getEntry(InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES[0]);
        }
        if (documentNode == null) {
            throw new IOException("No Excel 5/95 Book stream found");
        }
        this.ris = new RecordInputStream(directoryNode.createDocumentInputStream(documentNode));
        prepare();
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("   OldExcelExtractor <filename>");
            System.exit(1);
        }
        OldExcelExtractor oldExcelExtractor = new OldExcelExtractor(new File(strArr[0]));
        System.out.println(oldExcelExtractor.getText());
        oldExcelExtractor.close();
    }

    private void prepare() {
        if (!this.ris.hasNextRecord()) {
            throw new IllegalArgumentException("File contains no records!");
        }
        this.ris.nextRecord();
        short sid = this.ris.getSid();
        if (sid == 9) {
            this.biffVersion = 2;
        } else if (sid == 521) {
            this.biffVersion = 3;
        } else if (sid == 1033) {
            this.biffVersion = 4;
        } else if (sid == 2057) {
            this.biffVersion = 5;
        } else {
            throw new IllegalArgumentException("File does not begin with a BOF, found sid of " + ((int) sid));
        }
        this.fileType = new BOFRecord(this.ris).getType();
    }

    public int getBiffVersion() {
        return this.biffVersion;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getText() {
        StringBuffer stringBuffer = new StringBuffer();
        CodepageRecord codepageRecord = null;
        while (this.ris.hasNextRecord()) {
            int nextSid = this.ris.getNextSid();
            this.ris.nextRecord();
            if (nextSid != 4) {
                if (nextSid == 47) {
                    throw new EncryptedDocumentException("Encryption not supported for Old Excel files");
                }
                if (nextSid == 66) {
                    codepageRecord = new CodepageRecord(this.ris);
                } else if (nextSid == 133) {
                    OldSheetRecord oldSheetRecord = new OldSheetRecord(this.ris);
                    oldSheetRecord.setCodePage(codepageRecord);
                    stringBuffer.append("Sheet: ");
                    stringBuffer.append(oldSheetRecord.getSheetname());
                    stringBuffer.append('\n');
                } else if (nextSid != 638) {
                    if (nextSid != 1030 && nextSid != 6) {
                        if (nextSid != 7) {
                            if (nextSid == 515) {
                                handleNumericCell(stringBuffer, new NumberRecord(this.ris).getValue());
                            } else if (nextSid != 516) {
                                if (nextSid != 518) {
                                    if (nextSid != 519) {
                                        RecordInputStream recordInputStream = this.ris;
                                        recordInputStream.readFully(new byte[recordInputStream.remaining()]);
                                    }
                                }
                            }
                        }
                        OldStringRecord oldStringRecord = new OldStringRecord(this.ris);
                        oldStringRecord.setCodePage(codepageRecord);
                        stringBuffer.append(oldStringRecord.getString());
                        stringBuffer.append('\n');
                    }
                    if (this.biffVersion == 5) {
                        FormulaRecord formulaRecord = new FormulaRecord(this.ris);
                        if (formulaRecord.getCachedResultType() == CellType.NUMERIC.getCode()) {
                            handleNumericCell(stringBuffer, formulaRecord.getValue());
                        }
                    } else {
                        OldFormulaRecord oldFormulaRecord = new OldFormulaRecord(this.ris);
                        if (oldFormulaRecord.getCachedResultType() == CellType.NUMERIC.getCode()) {
                            handleNumericCell(stringBuffer, oldFormulaRecord.getValue());
                        }
                    }
                } else {
                    handleNumericCell(stringBuffer, new RKRecord(this.ris).getRKNumber());
                }
            }
            OldLabelRecord oldLabelRecord = new OldLabelRecord(this.ris);
            oldLabelRecord.setCodePage(codepageRecord);
            stringBuffer.append(oldLabelRecord.getValue());
            stringBuffer.append('\n');
        }
        close();
        this.ris = null;
        return stringBuffer.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Closeable closeable = this.toClose;
        if (closeable != null) {
            IOUtils.closeQuietly(closeable);
            this.toClose = null;
        }
    }

    protected void handleNumericCell(StringBuffer stringBuffer, double d) {
        stringBuffer.append(d);
        stringBuffer.append('\n');
    }
}
