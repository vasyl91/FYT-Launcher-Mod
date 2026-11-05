package org.apache.poi.hssf.dev;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.FuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FormulaViewer {
    private String file;
    private boolean list = false;

    public void run() throws IOException {
        NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(this.file), true);
        try {
            InputStream pOIFSInputStream = BiffViewer.getPOIFSInputStream(nPOIFSFileSystem);
            try {
                for (Record record : RecordFactory.createRecords(pOIFSInputStream)) {
                    if (record.getSid() == 6) {
                        if (this.list) {
                            listFormula((FormulaRecord) record);
                        } else {
                            parseFormulaRecord((FormulaRecord) record);
                        }
                    }
                }
                pOIFSInputStream.close();
                nPOIFSFileSystem.close();
            } catch (Throwable th) {
                pOIFSInputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            nPOIFSFileSystem.close();
            throw th2;
        }
    }

    private void listFormula(FormulaRecord formulaRecord) {
        String strValueOf;
        Ptg[] parsedExpression = formulaRecord.getParsedExpression();
        int length = parsedExpression.length;
        int i = length - 1;
        Ptg ptg = parsedExpression[i];
        if (ptg instanceof FuncPtg) {
            strValueOf = String.valueOf(i);
        } else {
            strValueOf = String.valueOf(-1);
        }
        StringBuilder sb = new StringBuilder();
        if (ptg instanceof ExpPtg) {
            return;
        }
        sb.append(ptg.toFormulaString());
        sb.append("~");
        byte ptgClass = ptg.getPtgClass();
        if (ptgClass == 0) {
            sb.append("REF");
        } else if (ptgClass == 32) {
            sb.append("VALUE");
        } else if (ptgClass == 64) {
            sb.append("ARRAY");
        } else {
            throwInvalidRVAToken(ptg);
        }
        sb.append("~");
        if (length > 1) {
            Ptg ptg2 = parsedExpression[length - 2];
            byte ptgClass2 = ptg2.getPtgClass();
            if (ptgClass2 == 0) {
                sb.append("REF");
            } else if (ptgClass2 == 32) {
                sb.append("VALUE");
            } else if (ptgClass2 == 64) {
                sb.append("ARRAY");
            } else {
                throwInvalidRVAToken(ptg2);
            }
        } else {
            sb.append("VALUE");
        }
        sb.append("~");
        sb.append(strValueOf);
        System.out.println(sb);
    }

    public void parseFormulaRecord(FormulaRecord formulaRecord) {
        System.out.println("==============================");
        System.out.print("row = " + formulaRecord.getRow());
        System.out.println(", col = " + ((int) formulaRecord.getColumn()));
        System.out.println("value = " + formulaRecord.getValue());
        System.out.print("xf = " + ((int) formulaRecord.getXFIndex()));
        System.out.print(", number of ptgs = " + formulaRecord.getParsedExpression().length);
        System.out.println(", options = " + ((int) formulaRecord.getOptions()));
        System.out.println("RPN List = " + formulaString(formulaRecord));
        System.out.println("Formula text = " + composeFormula(formulaRecord));
    }

    private String formulaString(FormulaRecord formulaRecord) {
        StringBuilder sb = new StringBuilder();
        for (Ptg ptg : formulaRecord.getParsedExpression()) {
            sb.append(ptg.toFormulaString());
            byte ptgClass = ptg.getPtgClass();
            if (ptgClass == 0) {
                sb.append("(R)");
            } else if (ptgClass == 32) {
                sb.append("(V)");
            } else if (ptgClass == 64) {
                sb.append("(A)");
            } else {
                throwInvalidRVAToken(ptg);
            }
            sb.append(' ');
        }
        return sb.toString();
    }

    private static void throwInvalidRVAToken(Ptg ptg) {
        throw new IllegalStateException("Invalid RVA type (" + ((int) ptg.getPtgClass()) + "). This should never happen.");
    }

    private static String composeFormula(FormulaRecord formulaRecord) {
        return HSSFFormulaParser.toFormulaString(null, formulaRecord.getParsedExpression());
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setList(boolean z) {
        this.list = z;
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr == null || strArr.length > 2 || strArr[0].equals("--help")) {
            System.out.println("FormulaViewer .8 proof that the devil lies in the details (or just in BIFF8 files in general)");
            System.out.println("usage: Give me a big fat file name");
        } else {
            if (strArr[0].equals("--listFunctions")) {
                FormulaViewer formulaViewer = new FormulaViewer();
                formulaViewer.setFile(strArr[1]);
                formulaViewer.setList(true);
                formulaViewer.run();
                return;
            }
            FormulaViewer formulaViewer2 = new FormulaViewer();
            formulaViewer2.setFile(strArr[0]);
            formulaViewer2.run();
        }
    }
}
