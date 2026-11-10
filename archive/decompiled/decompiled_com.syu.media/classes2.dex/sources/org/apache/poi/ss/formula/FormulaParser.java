package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AddPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ConcatPtg;
import org.apache.poi.ss.formula.ptg.DividePtg;
import org.apache.poi.ss.formula.ptg.EqualPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.FuncPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.apache.poi.ss.formula.ptg.LessThanPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.MultiplyPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.PowerPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.SubtractPtg;
import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class FormulaParser {
    private static final char CR = '\r';
    private static final char LF = '\n';
    private static final char TAB = '\t';
    private static final String specAll = "All";
    private static final String specData = "Data";
    private static final String specHeaders = "Headers";
    private static final String specThisRow = "This Row";
    private static final String specTotals = "Totals";
    private final FormulaParsingWorkbook _book;
    private final int _formulaLength;
    private final String _formulaString;
    private boolean _inIntersection;
    private int _pointer = 0;
    private ParseNode _rootNode;
    private final int _rowIndex;
    private final int _sheetIndex;
    private final SpreadsheetVersion _ssVersion;
    private int look;
    private static final POILogger log = POILogFactory.getLogger((Class<?>) FormulaParser.class);
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Za-z]+)?(\\$?[0-9]+)?");

    private static boolean IsWhite(int i) {
        return i == 32 || i == 9 || i == 13 || i == 10;
    }

    private static boolean isArgumentDelimiter(int i) {
        return i == 44 || i == 41;
    }

    private FormulaParser(String str, FormulaParsingWorkbook formulaParsingWorkbook, int i, int i2) {
        this._formulaString = str;
        this._book = formulaParsingWorkbook;
        this._ssVersion = formulaParsingWorkbook == null ? SpreadsheetVersion.EXCEL97 : formulaParsingWorkbook.getSpreadsheetVersion();
        this._formulaLength = str.length();
        this._sheetIndex = i;
        this._rowIndex = i2;
    }

    public static Ptg[] parse(String str, FormulaParsingWorkbook formulaParsingWorkbook, FormulaType formulaType, int i, int i2) {
        FormulaParser formulaParser = new FormulaParser(str, formulaParsingWorkbook, i, i2);
        formulaParser.parse();
        return formulaParser.getRPNPtg(formulaType);
    }

    public static Ptg[] parse(String str, FormulaParsingWorkbook formulaParsingWorkbook, FormulaType formulaType, int i) {
        return parse(str, formulaParsingWorkbook, formulaType, i, -1);
    }

    public static Area3DPxg parseStructuredReference(String str, FormulaParsingWorkbook formulaParsingWorkbook, int i) {
        Ptg[] ptgArr = parse(str, formulaParsingWorkbook, FormulaType.CELL, -1, i);
        if (ptgArr.length == 1) {
            Ptg ptg = ptgArr[0];
            if (ptg instanceof Area3DPxg) {
                return (Area3DPxg) ptg;
            }
        }
        throw new IllegalStateException("Illegal structured reference");
    }

    private void GetChar() {
        if (IsWhite(this.look)) {
            if (this.look == 32) {
                this._inIntersection = true;
            }
        } else {
            this._inIntersection = false;
        }
        int i = this._pointer;
        int i2 = this._formulaLength;
        if (i > i2) {
            throw new RuntimeException("too far");
        }
        if (i < i2) {
            this.look = this._formulaString.codePointAt(i);
        } else {
            this.look = 0;
            this._inIntersection = false;
        }
        this._pointer += Character.charCount(this.look);
    }

    private void resetPointer(int i) {
        this._pointer = i;
        if (i <= this._formulaLength) {
            this.look = this._formulaString.codePointAt(i - Character.charCount(this.look));
        } else {
            this.look = 0;
        }
    }

    private RuntimeException expected(String str) {
        String string;
        if (this.look == 61 && this._formulaString.substring(0, this._pointer - 1).trim().length() < 1) {
            string = "The specified formula '" + this._formulaString + "' starts with an equals sign which is not allowed.";
        } else {
            string = new StringBuilder("Parse error near char ").append(this._pointer - 1).append(" '").appendCodePoint(this.look).append("'").append(" in specified formula '").append(this._formulaString).append("'. Expected ").append(str).toString();
        }
        return new FormulaParseException(string);
    }

    private static boolean IsAlpha(int i) {
        return Character.isLetter(i) || i == 36 || i == 95;
    }

    private static boolean IsDigit(int i) {
        return Character.isDigit(i);
    }

    private void SkipWhite() {
        while (IsWhite(this.look)) {
            GetChar();
        }
    }

    private void Match(int i) {
        if (this.look != i) {
            throw expected(new StringBuilder().append("'").appendCodePoint(i).append("'").toString());
        }
        GetChar();
    }

    private String GetNum() {
        StringBuilder sb = new StringBuilder();
        while (IsDigit(this.look)) {
            sb.appendCodePoint(this.look);
            GetChar();
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private ParseNode parseRangeExpression() {
        ParseNode rangeable = parseRangeable();
        boolean z = false;
        while (this.look == 58) {
            int i = this._pointer;
            GetChar();
            ParseNode rangeable2 = parseRangeable();
            checkValidRangeOperand("LHS", i, rangeable);
            checkValidRangeOperand("RHS", i, rangeable2);
            z = true;
            rangeable = new ParseNode(RangePtg.instance, new ParseNode[]{rangeable, rangeable2});
        }
        return z ? augmentWithMemPtg(rangeable) : rangeable;
    }

    private static ParseNode augmentWithMemPtg(ParseNode parseNode) {
        Ptg memAreaPtg;
        if (needsMemFunc(parseNode)) {
            memAreaPtg = new MemFuncPtg(parseNode.getEncodedSize());
        } else {
            memAreaPtg = new MemAreaPtg(parseNode.getEncodedSize());
        }
        return new ParseNode(memAreaPtg, parseNode);
    }

    private static boolean needsMemFunc(ParseNode parseNode) {
        Ptg token = parseNode.getToken();
        if ((token instanceof AbstractFunctionPtg) || (token instanceof ExternSheetReferenceToken) || (token instanceof NamePtg) || (token instanceof NameXPtg)) {
            return true;
        }
        boolean z = token instanceof OperationPtg;
        if (!z && !(token instanceof ParenthesisPtg)) {
            return !(token instanceof OperandPtg) && z;
        }
        for (ParseNode parseNode2 : parseNode.getChildren()) {
            if (needsMemFunc(parseNode2)) {
                return true;
            }
        }
        return false;
    }

    private static void checkValidRangeOperand(String str, int i, ParseNode parseNode) {
        if (!isValidRangeOperand(parseNode)) {
            throw new FormulaParseException("The " + str + " of the range operator ':' at position " + i + " is not a proper reference.");
        }
    }

    private static boolean isValidRangeOperand(ParseNode parseNode) {
        Ptg token = parseNode.getToken();
        if (token instanceof OperandPtg) {
            return true;
        }
        if (token instanceof AbstractFunctionPtg) {
            return ((AbstractFunctionPtg) token).getDefaultOperandClass() == 0;
        }
        if (token instanceof ValueOperatorPtg) {
            return false;
        }
        if (token instanceof OperationPtg) {
            return true;
        }
        if (token instanceof ParenthesisPtg) {
            return isValidRangeOperand(parseNode.getChildren()[0]);
        }
        return token == ErrPtg.REF_INVALID;
    }

    private ParseNode parseRangeable() {
        int i;
        SkipWhite();
        int i2 = this._pointer;
        SheetIdentifier sheetName = parseSheetName();
        if (sheetName == null) {
            resetPointer(i2);
        } else {
            SkipWhite();
            i2 = this._pointer;
        }
        SimpleRangePart simpleRangePart = parseSimpleRangePart();
        if (simpleRangePart == null) {
            if (sheetName != null) {
                if (this.look == 35) {
                    return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
                }
                String asName = parseAsName();
                if (asName.length() == 0) {
                    throw new FormulaParseException("Cell reference or Named Range expected after sheet name at index " + this._pointer + ".");
                }
                Ptg nameXPtg = this._book.getNameXPtg(asName, sheetName);
                if (nameXPtg == null) {
                    throw new FormulaParseException("Specified name '" + asName + "' for sheet " + sheetName.asFormulaString() + " not found");
                }
                return new ParseNode(nameXPtg);
            }
            return parseNonRange(i2);
        }
        boolean zIsWhite = IsWhite(this.look);
        if (zIsWhite) {
            SkipWhite();
        }
        int i3 = this.look;
        if (i3 == 58) {
            int i4 = this._pointer;
            GetChar();
            SkipWhite();
            SimpleRangePart simpleRangePart2 = parseSimpleRangePart();
            SimpleRangePart simpleRangePart3 = (simpleRangePart2 == null || simpleRangePart.isCompatibleForArea(simpleRangePart2)) ? simpleRangePart2 : null;
            if (simpleRangePart3 == null) {
                resetPointer(i4);
                if (!simpleRangePart.isCell()) {
                    throw new FormulaParseException((sheetName != null ? "'" + sheetName.getSheetIdentifier().getName() + '!' : "") + simpleRangePart.getRep() + "' is not a proper reference.");
                }
            }
            return createAreaRefParseNode(sheetName, simpleRangePart, simpleRangePart3);
        }
        if (i3 == 46) {
            GetChar();
            int i5 = 1;
            while (true) {
                i = this.look;
                if (i != 46) {
                    break;
                }
                i5++;
                GetChar();
            }
            boolean zIsWhite2 = IsWhite(i);
            SkipWhite();
            SimpleRangePart simpleRangePart4 = parseSimpleRangePart();
            String strSubstring = this._formulaString.substring(i2 - 1, this._pointer - 1);
            if (simpleRangePart4 == null) {
                if (sheetName != null) {
                    throw new FormulaParseException("Complete area reference expected after sheet name at index " + this._pointer + ".");
                }
                return parseNonRange(i2);
            }
            if (zIsWhite || zIsWhite2) {
                if (simpleRangePart.isRowOrColumn() || simpleRangePart4.isRowOrColumn()) {
                    throw new FormulaParseException("Dotted range (full row or column) expression '" + strSubstring + "' must not contain whitespace.");
                }
                return createAreaRefParseNode(sheetName, simpleRangePart, simpleRangePart4);
            }
            if (i5 == 1 && simpleRangePart.isRow() && simpleRangePart4.isRow()) {
                return parseNonRange(i2);
            }
            if ((simpleRangePart.isRowOrColumn() || simpleRangePart4.isRowOrColumn()) && i5 != 2) {
                throw new FormulaParseException("Dotted range (full row or column) expression '" + strSubstring + "' must have exactly 2 dots.");
            }
            return createAreaRefParseNode(sheetName, simpleRangePart, simpleRangePart4);
        }
        if (simpleRangePart.isCell() && isValidCellReference(simpleRangePart.getRep())) {
            return createAreaRefParseNode(sheetName, simpleRangePart, null);
        }
        if (sheetName != null) {
            throw new FormulaParseException("Second part of cell reference expected after sheet name at index " + this._pointer + ".");
        }
        return parseNonRange(i2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:102:0x01b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:105:0x01be  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:107:0x01c2 A[DONT_INVERT, PHI: r7
  0x01c2: PHI (r7v5 int) = (r7v4 int), (r7v6 int) binds: [B:101:0x01b2, B:106:0x01c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:108:0x01c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:110:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x01c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:114:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:115:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:119:0x01ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:122:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:124:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:128:0x0208  */
    /* JADX WARN: Code duplicated, block: B:138:0x0250  */
    /* JADX WARN: Code duplicated, block: B:149:0x0288  */
    /* JADX WARN: Code duplicated, block: B:153:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:155:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x0171  */
    /* JADX WARN: Code duplicated, block: B:88:0x0196  */
    /* JADX WARN: Code duplicated, block: B:92:0x019d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x019f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x01aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x01ac A[ADDED_TO_REGION] */
    private ParseNode parseStructuredReference(String str) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str2;
        boolean z6;
        int i2;
        int i3;
        String str3;
        String str4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!this._ssVersion.equals(SpreadsheetVersion.EXCEL2007)) {
            throw new FormulaParseException("Structured references work only on XSSF (Excel 2007+)!");
        }
        Table table = this._book.getTable(str);
        if (table == null) {
            throw new FormulaParseException("Illegal table name: '" + str + "'");
        }
        String sheetName = table.getSheetName();
        int startColIndex = table.getStartColIndex();
        int endColIndex = table.getEndColIndex();
        int startRowIndex = table.getStartRowIndex();
        int endRowIndex = table.getEndRowIndex();
        int i9 = this._pointer;
        GetChar();
        int i10 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            int i11 = this._pointer;
            String asSpecialQuantifier = parseAsSpecialQuantifier();
            i = endColIndex;
            z = z7;
            z2 = z8;
            z3 = z9;
            z4 = z10;
            z5 = z11;
            str2 = sheetName;
            if (asSpecialQuantifier == null) {
                resetPointer(i11);
                break;
            }
            if (asSpecialQuantifier.equals(specAll)) {
                z3 = true;
            } else if (asSpecialQuantifier.equals(specData)) {
                z4 = true;
            } else if (asSpecialQuantifier.equals(specHeaders)) {
                z5 = true;
            } else if (asSpecialQuantifier.equals(specThisRow)) {
                z2 = true;
            } else {
                if (!asSpecialQuantifier.equals(specTotals)) {
                    throw new FormulaParseException("Unknown special quantifier " + asSpecialQuantifier);
                }
                z = true;
            }
            i10++;
            if (this.look != 44) {
                break;
            }
            GetChar();
            endColIndex = i;
            z7 = z;
            z8 = z2;
            z9 = z3;
            z10 = z4;
            z11 = z5;
            sheetName = str2;
        }
        SkipWhite();
        if (this.look == 64) {
            GetChar();
            z6 = true;
        } else {
            z6 = false;
        }
        int i12 = this._pointer;
        String asColumnQuantifier = parseAsColumnQuantifier();
        if (asColumnQuantifier == null) {
            resetPointer(i12);
            i2 = startColIndex;
            i3 = 0;
        } else {
            int i13 = this.look;
            i2 = startColIndex;
            if (i13 == 44) {
                throw new FormulaParseException("The formula " + this._formulaString + "is illegal: you should not use ',' with column quantifiers");
            }
            if (i13 == 58) {
                GetChar();
                String asColumnQuantifier2 = parseAsColumnQuantifier();
                if (asColumnQuantifier2 == null) {
                    throw new FormulaParseException("The formula " + this._formulaString + "is illegal: the string after ':' must be column quantifier");
                }
                str3 = asColumnQuantifier2;
                i3 = 2;
            } else {
                i3 = 1;
            }
            if (i3 != 0 && i10 == 0) {
                resetPointer(i9);
                int i14 = this._pointer;
                asColumnQuantifier = parseAsColumnQuantifier();
                if (asColumnQuantifier != null) {
                    i3++;
                } else {
                    resetPointer(i14);
                    String asSpecialQuantifier2 = parseAsSpecialQuantifier();
                    if (asSpecialQuantifier2 != null) {
                        if (asSpecialQuantifier2.equals(specAll)) {
                            z3 = true;
                        } else if (asSpecialQuantifier2.equals(specData)) {
                            z4 = true;
                        } else if (asSpecialQuantifier2.equals(specHeaders)) {
                            z5 = true;
                        } else if (asSpecialQuantifier2.equals(specThisRow)) {
                            z2 = true;
                        } else {
                            if (!asSpecialQuantifier2.equals(specTotals)) {
                                throw new FormulaParseException("Unknown special quantifier " + asSpecialQuantifier2);
                            }
                            z = true;
                        }
                        i10++;
                    } else {
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                    }
                }
            } else {
                Match(93);
            }
            str4 = asColumnQuantifier;
            if (!z && table.getTotalsRowCount() == 0) {
                return new ParseNode(ErrPtg.REF_INVALID);
            }
            if ((!z6 || z2) && ((i4 = this._rowIndex) < startRowIndex || endRowIndex < i4)) {
                if (i4 >= 0) {
                    return new ParseNode(ErrPtg.VALUE_INVALID);
                }
                throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
            }
            if (i10 > 0) {
                if (i10 == 1 || !z3) {
                    if (z4 || !z5) {
                        if (z4 || !z) {
                            i8 = 1;
                            if (i10 != 1) {
                                if (i10 != i8 && z5) {
                                    endRowIndex = startRowIndex;
                                } else if (i10 != i8 && z) {
                                    startRowIndex = endRowIndex;
                                } else if ((i10 != i8 && z2) || z6) {
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                            } else if (z4) {
                                startRowIndex++;
                                if (table.getTotalsRowCount() > 0) {
                                    i5 = endRowIndex - 1;
                                    endRowIndex = i5;
                                }
                            } else {
                                i8 = 1;
                                if (i10 != i8) {
                                    if (i10 != i8) {
                                    }
                                    if (i10 != i8) {
                                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                    }
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                } else {
                                    if (i10 != i8) {
                                    }
                                    if (i10 != i8) {
                                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                    }
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                    startRowIndex = this._rowIndex;
                                    endRowIndex = startRowIndex;
                                }
                            }
                        } else {
                            startRowIndex++;
                        }
                    } else if (table.getTotalsRowCount() > 0) {
                        endRowIndex--;
                    }
                }
            } else if (z6) {
                startRowIndex = this._rowIndex;
                endRowIndex = startRowIndex;
            } else {
                startRowIndex++;
                if (table.getTotalsRowCount() > 0) {
                    i5 = endRowIndex - 1;
                    endRowIndex = i5;
                }
            }
            if (i3 == 2) {
                if (str4 != null || str3 == null) {
                    throw new IllegalStateException("Fatal error");
                }
                int iFindColumnIndex = table.findColumnIndex(str4);
                String str5 = str3;
                int iFindColumnIndex2 = table.findColumnIndex(str5);
                if (iFindColumnIndex == -1 || iFindColumnIndex2 == -1) {
                    throw new FormulaParseException("One of the columns " + str4 + ", " + str5 + " doesn't exist in table " + table.getName());
                }
                i6 = i2 + iFindColumnIndex;
                i7 = i2 + iFindColumnIndex2;
            } else if (i3 == 1 || z6) {
                i6 = i2;
                i7 = i;
            } else {
                if (str4 == null) {
                    throw new IllegalStateException("Fatal error");
                }
                int iFindColumnIndex3 = table.findColumnIndex(str4);
                if (iFindColumnIndex3 == -1) {
                    throw new FormulaParseException("The column " + str4 + " doesn't exist in table " + table.getName());
                }
                i6 = i2 + iFindColumnIndex3;
                i7 = i6;
            }
            return new ParseNode(this._book.get3DReferencePtg(new AreaReference(new CellReference(startRowIndex, i6), new CellReference(endRowIndex, i7), this._ssVersion), new SheetIdentifier(null, new NameIdentifier(str2, true))));
        }
        str3 = null;
        if (i3 != 0) {
            Match(93);
        } else {
            Match(93);
        }
        str4 = asColumnQuantifier;
        if (!z) {
        }
        if (z6) {
            if (i4 >= 0) {
                return new ParseNode(ErrPtg.VALUE_INVALID);
            }
            throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
        }
        if (i4 >= 0) {
            return new ParseNode(ErrPtg.VALUE_INVALID);
        }
        throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
        if (i10 > 0) {
            if (i10 == 1) {
                if (z4) {
                    if (z4) {
                        i8 = 1;
                        if (i10 != 1) {
                            if (i10 != i8) {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        } else if (z4) {
                            startRowIndex++;
                            if (table.getTotalsRowCount() > 0) {
                                i5 = endRowIndex - 1;
                                endRowIndex = i5;
                            }
                        } else {
                            i8 = 1;
                            if (i10 != i8) {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        }
                    } else {
                        i8 = 1;
                        if (i10 != 1) {
                            if (i10 != i8) {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        } else if (z4) {
                            startRowIndex++;
                            if (table.getTotalsRowCount() > 0) {
                                i5 = endRowIndex - 1;
                                endRowIndex = i5;
                            }
                        } else {
                            i8 = 1;
                            if (i10 != i8) {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            } else {
                                if (i10 != i8) {
                                }
                                if (i10 != i8) {
                                    throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                }
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                                startRowIndex = this._rowIndex;
                                endRowIndex = startRowIndex;
                            }
                        }
                    }
                } else if (z4) {
                    i8 = 1;
                    if (i10 != 1) {
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    } else if (z4) {
                        startRowIndex++;
                        if (table.getTotalsRowCount() > 0) {
                            i5 = endRowIndex - 1;
                            endRowIndex = i5;
                        }
                    } else {
                        i8 = 1;
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    }
                } else {
                    i8 = 1;
                    if (i10 != 1) {
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    } else if (z4) {
                        startRowIndex++;
                        if (table.getTotalsRowCount() > 0) {
                            i5 = endRowIndex - 1;
                            endRowIndex = i5;
                        }
                    } else {
                        i8 = 1;
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    }
                }
            } else if (z4) {
                if (z4) {
                    i8 = 1;
                    if (i10 != 1) {
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    } else if (z4) {
                        startRowIndex++;
                        if (table.getTotalsRowCount() > 0) {
                            i5 = endRowIndex - 1;
                            endRowIndex = i5;
                        }
                    } else {
                        i8 = 1;
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    }
                } else {
                    i8 = 1;
                    if (i10 != 1) {
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    } else if (z4) {
                        startRowIndex++;
                        if (table.getTotalsRowCount() > 0) {
                            i5 = endRowIndex - 1;
                            endRowIndex = i5;
                        }
                    } else {
                        i8 = 1;
                        if (i10 != i8) {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        } else {
                            if (i10 != i8) {
                            }
                            if (i10 != i8) {
                                throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            }
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                            startRowIndex = this._rowIndex;
                            endRowIndex = startRowIndex;
                        }
                    }
                }
            } else if (z4) {
                i8 = 1;
                if (i10 != 1) {
                    if (i10 != i8) {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    } else {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    }
                } else if (z4) {
                    startRowIndex++;
                    if (table.getTotalsRowCount() > 0) {
                        i5 = endRowIndex - 1;
                        endRowIndex = i5;
                    }
                } else {
                    i8 = 1;
                    if (i10 != i8) {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    } else {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    }
                }
            } else {
                i8 = 1;
                if (i10 != 1) {
                    if (i10 != i8) {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    } else {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    }
                } else if (z4) {
                    startRowIndex++;
                    if (table.getTotalsRowCount() > 0) {
                        i5 = endRowIndex - 1;
                        endRowIndex = i5;
                    }
                } else {
                    i8 = 1;
                    if (i10 != i8) {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    } else {
                        if (i10 != i8) {
                        }
                        if (i10 != i8) {
                            throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        }
                        throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
                        startRowIndex = this._rowIndex;
                        endRowIndex = startRowIndex;
                    }
                }
            }
        } else if (z6) {
            startRowIndex = this._rowIndex;
            endRowIndex = startRowIndex;
        } else {
            startRowIndex++;
            if (table.getTotalsRowCount() > 0) {
                i5 = endRowIndex - 1;
                endRowIndex = i5;
            }
        }
        if (i3 == 2) {
            if (str4 != null) {
            }
            throw new IllegalStateException("Fatal error");
        }
        if (i3 == 1) {
            i6 = i2;
            i7 = i;
        } else {
            i6 = i2;
            i7 = i;
        }
        return new ParseNode(this._book.get3DReferencePtg(new AreaReference(new CellReference(startRowIndex, i6), new CellReference(endRowIndex, i7), this._ssVersion), new SheetIdentifier(null, new NameIdentifier(str2, true))));
    }

    private String parseAsColumnQuantifier() {
        if (this.look != 91) {
            return null;
        }
        GetChar();
        int i = this.look;
        if (i == 35) {
            return null;
        }
        if (i == 64) {
            GetChar();
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = this.look;
            if (i2 != 93) {
                sb.appendCodePoint(i2);
                GetChar();
            } else {
                Match(93);
                return sb.toString();
            }
        }
    }

    private String parseAsSpecialQuantifier() {
        if (this.look != 91) {
            return null;
        }
        GetChar();
        if (this.look != 35) {
            return null;
        }
        GetChar();
        String asName = parseAsName();
        if (asName.equals("This")) {
            asName = asName + ' ' + parseAsName();
        }
        Match(93);
        return asName;
    }

    private ParseNode parseNonRange(int i) {
        resetPointer(i);
        if (Character.isDigit(this.look)) {
            return new ParseNode(parseNumber());
        }
        if (this.look == 34) {
            return new ParseNode(new StringPtg(parseStringLiteral()));
        }
        String asName = parseAsName();
        int i2 = this.look;
        if (i2 == 40) {
            return function(asName);
        }
        if (i2 == 91) {
            return parseStructuredReference(asName);
        }
        if (asName.equalsIgnoreCase("TRUE") || asName.equalsIgnoreCase("FALSE")) {
            return new ParseNode(BoolPtg.valueOf(asName.equalsIgnoreCase("TRUE")));
        }
        FormulaParsingWorkbook formulaParsingWorkbook = this._book;
        if (formulaParsingWorkbook == null) {
            throw new IllegalStateException("Need book to evaluate name '" + asName + "'");
        }
        EvaluationName name = formulaParsingWorkbook.getName(asName, this._sheetIndex);
        if (name == null) {
            throw new FormulaParseException("Specified named range '" + asName + "' does not exist in the current workbook.");
        }
        if (name.isRange()) {
            return new ParseNode(name.createPtg());
        }
        throw new FormulaParseException("Specified name '" + asName + "' is not a range as expected.");
    }

    private String parseAsName() {
        int i;
        StringBuilder sb = new StringBuilder();
        if (!Character.isLetter(this.look) && (i = this.look) != 95 && i != 92) {
            throw expected("number, string, defined name, or data table");
        }
        while (isValidDefinedNameChar(this.look)) {
            sb.appendCodePoint(this.look);
            GetChar();
        }
        SkipWhite();
        return sb.toString();
    }

    private static boolean isValidDefinedNameChar(int i) {
        return Character.isLetterOrDigit(i) || i > 128 || i == 46 || i == 63 || i == 92 || i == 95;
    }

    private ParseNode createAreaRefParseNode(SheetIdentifier sheetIdentifier, SimpleRangePart simpleRangePart, SimpleRangePart simpleRangePart2) throws FormulaParseException {
        Ptg areaPtg;
        if (simpleRangePart2 == null) {
            CellReference cellReference = simpleRangePart.getCellReference();
            if (sheetIdentifier == null) {
                areaPtg = new RefPtg(cellReference);
            } else {
                areaPtg = this._book.get3DReferencePtg(cellReference, sheetIdentifier);
            }
        } else {
            AreaReference areaReferenceCreateAreaRef = createAreaRef(simpleRangePart, simpleRangePart2);
            if (sheetIdentifier == null) {
                areaPtg = new AreaPtg(areaReferenceCreateAreaRef);
            } else {
                areaPtg = this._book.get3DReferencePtg(areaReferenceCreateAreaRef, sheetIdentifier);
            }
        }
        return new ParseNode(areaPtg);
    }

    private AreaReference createAreaRef(SimpleRangePart simpleRangePart, SimpleRangePart simpleRangePart2) {
        if (!simpleRangePart.isCompatibleForArea(simpleRangePart2)) {
            throw new FormulaParseException("has incompatible parts: '" + simpleRangePart.getRep() + "' and '" + simpleRangePart2.getRep() + "'.");
        }
        if (simpleRangePart.isRow()) {
            return AreaReference.getWholeRow(this._ssVersion, simpleRangePart.getRep(), simpleRangePart2.getRep());
        }
        if (simpleRangePart.isColumn()) {
            return AreaReference.getWholeColumn(this._ssVersion, simpleRangePart.getRep(), simpleRangePart2.getRep());
        }
        return new AreaReference(simpleRangePart.getCellReference(), simpleRangePart2.getCellReference(), this._ssVersion);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0077, code lost:
    
        if (r5 <= r8._ssVersion.getMaxRows()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.poi.ss.formula.FormulaParser.SimpleRangePart parseSimpleRangePart() {
        /*
            r8 = this;
            int r0 = r8._pointer
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
        L6:
            int r4 = r8._formulaLength
            if (r0 >= r4) goto L2b
            java.lang.String r4 = r8._formulaString
            char r4 = r4.charAt(r0)
            boolean r5 = java.lang.Character.isDigit(r4)
            if (r5 == 0) goto L18
            r2 = r1
            goto L28
        L18:
            boolean r5 = java.lang.Character.isLetter(r4)
            if (r5 == 0) goto L20
            r3 = r1
            goto L28
        L20:
            r5 = 36
            if (r4 == r5) goto L28
            r5 = 95
            if (r4 != r5) goto L2b
        L28:
            int r0 = r0 + 1
            goto L6
        L2b:
            int r4 = r8._pointer
            int r5 = r4 + (-1)
            r6 = 0
            if (r0 > r5) goto L33
            return r6
        L33:
            java.lang.String r5 = r8._formulaString
            int r4 = r4 - r1
            java.lang.String r4 = r5.substring(r4, r0)
            java.util.regex.Pattern r5 = org.apache.poi.ss.formula.FormulaParser.CELL_REF_PATTERN
            java.util.regex.Matcher r5 = r5.matcher(r4)
            boolean r5 = r5.matches()
            if (r5 != 0) goto L47
            return r6
        L47:
            if (r3 == 0) goto L52
            if (r2 == 0) goto L52
            boolean r5 = r8.isValidCellReference(r4)
            if (r5 != 0) goto L7a
            return r6
        L52:
            java.lang.String r5 = ""
            java.lang.String r7 = "$"
            if (r3 == 0) goto L65
            java.lang.String r5 = r4.replace(r7, r5)
            org.apache.poi.ss.SpreadsheetVersion r7 = r8._ssVersion
            boolean r5 = org.apache.poi.ss.util.CellReference.isColumnWithinRange(r5, r7)
            if (r5 != 0) goto L7a
            return r6
        L65:
            if (r2 == 0) goto L84
            java.lang.String r5 = r4.replace(r7, r5)     // Catch: java.lang.NumberFormatException -> L84
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L84
            if (r5 < r1) goto L84
            org.apache.poi.ss.SpreadsheetVersion r7 = r8._ssVersion
            int r7 = r7.getMaxRows()
            if (r5 <= r7) goto L7a
            goto L84
        L7a:
            int r0 = r0 + r1
            r8.resetPointer(r0)
            org.apache.poi.ss.formula.FormulaParser$SimpleRangePart r0 = new org.apache.poi.ss.formula.FormulaParser$SimpleRangePart
            r0.<init>(r4, r3, r2)
            return r0
        L84:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.FormulaParser.parseSimpleRangePart():org.apache.poi.ss.formula.FormulaParser$SimpleRangePart");
    }

    private static final class SimpleRangePart {
        private final String _rep;
        private final Type _type;

        private enum Type {
            CELL,
            ROW,
            COLUMN;

            public static Type get(boolean z, boolean z2) {
                if (z) {
                    return z2 ? CELL : COLUMN;
                }
                if (!z2) {
                    throw new IllegalArgumentException("must have either letters or numbers");
                }
                return ROW;
            }
        }

        public SimpleRangePart(String str, boolean z, boolean z2) {
            this._rep = str;
            this._type = Type.get(z, z2);
        }

        public boolean isCell() {
            return this._type == Type.CELL;
        }

        public boolean isRowOrColumn() {
            return this._type != Type.CELL;
        }

        public CellReference getCellReference() {
            if (this._type != Type.CELL) {
                throw new IllegalStateException("Not applicable to this type");
            }
            return new CellReference(this._rep);
        }

        public boolean isColumn() {
            return this._type == Type.COLUMN;
        }

        public boolean isRow() {
            return this._type == Type.ROW;
        }

        public String getRep() {
            return this._rep;
        }

        public boolean isCompatibleForArea(SimpleRangePart simpleRangePart) {
            return this._type == simpleRangePart._type;
        }

        public String toString() {
            return getClass().getName() + " [" + this._rep + "]";
        }
    }

    private String getBookName() {
        StringBuilder sb = new StringBuilder();
        GetChar();
        while (true) {
            int i = this.look;
            if (i != 93) {
                sb.appendCodePoint(i);
                GetChar();
            } else {
                GetChar();
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0061  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x003e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x002d A[EDGE_INSN: B:55:0x002d->B:13:0x002d BREAK  A[LOOP:0: B:15:0x0030->B:56:0x0030], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0030 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0043 -> B:13:0x002d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x0056
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private org.apache.poi.ss.formula.SheetIdentifier parseSheetName() {
        /*
            r10 = this;
            int r0 = r10.look
            r1 = 0
            r2 = 91
            if (r0 != r2) goto Lc
            java.lang.String r0 = r10.getBookName()
            goto Ld
        Lc:
            r0 = r1
        Ld:
            int r3 = r10.look
            r4 = 58
            r5 = 0
            r6 = 33
            r7 = 39
            if (r3 != r7) goto L67
            r10.Match(r7)
            int r3 = r10.look
            if (r3 != r2) goto L23
            java.lang.String r0 = r10.getBookName()
        L23:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r10.look
            r8 = 1
            if (r3 != r7) goto L2f
        L2d:
            r3 = r8
            goto L30
        L2f:
            r3 = r5
        L30:
            if (r3 != 0) goto L46
            int r9 = r10.look
            r2.appendCodePoint(r9)
            r10.GetChar()
            int r9 = r10.look
            if (r9 != r7) goto L30
            r10.Match(r7)
            int r3 = r10.look
            if (r3 == r7) goto L2f
            goto L2d
        L46:
            org.apache.poi.ss.formula.NameIdentifier r3 = new org.apache.poi.ss.formula.NameIdentifier
            java.lang.String r2 = r2.toString()
            r3.<init>(r2, r8)
            r10.SkipWhite()
            int r2 = r10.look
            if (r2 != r6) goto L5f
            r10.GetChar()
            org.apache.poi.ss.formula.SheetIdentifier r1 = new org.apache.poi.ss.formula.SheetIdentifier
            r1.<init>(r0, r3)
            return r1
        L5f:
            if (r2 != r4) goto L66
            org.apache.poi.ss.formula.SheetIdentifier r0 = r10.parseSheetRange(r0, r3)
            return r0
        L66:
            return r1
        L67:
            r2 = 95
            if (r3 == r2) goto L82
            boolean r2 = java.lang.Character.isLetter(r3)
            if (r2 == 0) goto L72
            goto L82
        L72:
            int r2 = r10.look
            if (r2 != r6) goto L81
            if (r0 == 0) goto L81
            r10.GetChar()
            org.apache.poi.ss.formula.SheetIdentifier r2 = new org.apache.poi.ss.formula.SheetIdentifier
            r2.<init>(r0, r1)
            return r2
        L81:
            return r1
        L82:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L87:
            int r3 = r10.look
            boolean r3 = isUnquotedSheetNameChar(r3)
            if (r3 == 0) goto L98
            int r3 = r10.look
            r2.appendCodePoint(r3)
            r10.GetChar()
            goto L87
        L98:
            org.apache.poi.ss.formula.NameIdentifier r3 = new org.apache.poi.ss.formula.NameIdentifier
            java.lang.String r2 = r2.toString()
            r3.<init>(r2, r5)
            r10.SkipWhite()
            int r2 = r10.look
            if (r2 != r6) goto Lb1
            r10.GetChar()
            org.apache.poi.ss.formula.SheetIdentifier r1 = new org.apache.poi.ss.formula.SheetIdentifier
            r1.<init>(r0, r3)
            return r1
        Lb1:
            if (r2 != r4) goto Lb8
            org.apache.poi.ss.formula.SheetIdentifier r0 = r10.parseSheetRange(r0, r3)
            return r0
        Lb8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.FormulaParser.parseSheetName():org.apache.poi.ss.formula.SheetIdentifier");
    }

    private SheetIdentifier parseSheetRange(String str, NameIdentifier nameIdentifier) {
        GetChar();
        SheetIdentifier sheetName = parseSheetName();
        if (sheetName != null) {
            return new SheetRangeIdentifier(str, nameIdentifier, sheetName.getSheetIdentifier());
        }
        return null;
    }

    private static boolean isUnquotedSheetNameChar(int i) {
        return Character.isLetterOrDigit(i) || i > 128 || i == 46 || i == 95;
    }

    private boolean isValidCellReference(String str) {
        boolean z = CellReference.classifyCellReference(str, this._ssVersion) == CellReference.NameType.CELL;
        if (!z) {
            return z;
        }
        if (!(FunctionMetadataRegistry.getFunctionByName(str.toUpperCase(Locale.ROOT)) != null)) {
            return z;
        }
        int i = this._pointer;
        resetPointer(str.length() + i);
        SkipWhite();
        boolean z2 = this.look != 40;
        resetPointer(i);
        return z2;
    }

    private ParseNode function(String str) {
        Ptg nameXPtg = null;
        if (!AbstractFunctionPtg.isBuiltInFunctionName(str)) {
            FormulaParsingWorkbook formulaParsingWorkbook = this._book;
            if (formulaParsingWorkbook == null) {
                throw new IllegalStateException("Need book to evaluate name '" + str + "'");
            }
            EvaluationName name = formulaParsingWorkbook.getName(str, this._sheetIndex);
            if (name != null) {
                if (!name.isFunctionName()) {
                    throw new FormulaParseException("Attempt to use name '" + str + "' as a function, but defined name in workbook does not refer to a function");
                }
                nameXPtg = name.createPtg();
            } else {
                nameXPtg = this._book.getNameXPtg(str, null);
                if (nameXPtg == null) {
                    POILogger pOILogger = log;
                    if (pOILogger.check(5)) {
                        pOILogger.log(5, "FormulaParser.function: Name '" + str + "' is completely unknown in the current workbook.");
                    }
                    int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$SpreadsheetVersion[this._book.getSpreadsheetVersion().ordinal()];
                    if (i == 1) {
                        addName(str);
                        nameXPtg = this._book.getName(str, this._sheetIndex).createPtg();
                    } else if (i == 2) {
                        nameXPtg = new NameXPxg(str);
                    } else {
                        throw new IllegalStateException("Unexpected spreadsheet version: " + this._book.getSpreadsheetVersion().name());
                    }
                }
            }
        }
        Match(40);
        ParseNode[] parseNodeArrArguments = Arguments();
        Match(41);
        return getFunction(str, nameXPtg, parseNodeArrArguments);
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.FormulaParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$SpreadsheetVersion;

        static {
            int[] iArr = new int[SpreadsheetVersion.values().length];
            $SwitchMap$org$apache$poi$ss$SpreadsheetVersion = iArr;
            try {
                iArr[SpreadsheetVersion.EXCEL97.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$SpreadsheetVersion[SpreadsheetVersion.EXCEL2007.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void addName(String str) {
        Name nameCreateName = this._book.createName();
        nameCreateName.setFunction(true);
        nameCreateName.setNameName(str);
        nameCreateName.setSheetIndex(this._sheetIndex);
    }

    private ParseNode getFunction(String str, Ptg ptg, ParseNode[] parseNodeArr) {
        Ptg ptgCreate;
        FunctionMetadata functionByName = FunctionMetadataRegistry.getFunctionByName(str.toUpperCase(Locale.ROOT));
        int length = parseNodeArr.length;
        if (functionByName == null) {
            if (ptg == null) {
                throw new IllegalStateException("NamePtg must be supplied for external functions");
            }
            int i = length + 1;
            ParseNode[] parseNodeArr2 = new ParseNode[i];
            parseNodeArr2[0] = new ParseNode(ptg);
            System.arraycopy(parseNodeArr, 0, parseNodeArr2, 1, length);
            return new ParseNode(FuncVarPtg.create(str, i), parseNodeArr2);
        }
        if (ptg != null) {
            throw new IllegalStateException("NamePtg no applicable to internal functions");
        }
        boolean z = !functionByName.hasFixedArgsLength();
        int index = functionByName.getIndex();
        if (index == 4 && parseNodeArr.length == 1) {
            return new ParseNode(AttrPtg.getSumSingle(), parseNodeArr);
        }
        validateNumArgs(parseNodeArr.length, functionByName);
        if (z) {
            ptgCreate = FuncVarPtg.create(str, length);
        } else {
            ptgCreate = FuncPtg.create(index);
        }
        return new ParseNode(ptgCreate, parseNodeArr);
    }

    private void validateNumArgs(int i, FunctionMetadata functionMetadata) {
        int maxParams;
        String str;
        FormulaParsingWorkbook formulaParsingWorkbook;
        String str2;
        if (i < functionMetadata.getMinParams()) {
            String str3 = "Too few arguments to function '" + functionMetadata.getName() + "'. ";
            if (functionMetadata.hasFixedArgsLength()) {
                str2 = str3 + "Expected " + functionMetadata.getMinParams();
            } else {
                str2 = str3 + "At least " + functionMetadata.getMinParams() + " were expected";
            }
            throw new FormulaParseException(str2 + " but got " + i + ".");
        }
        if (functionMetadata.hasUnlimitedVarags() && (formulaParsingWorkbook = this._book) != null) {
            maxParams = formulaParsingWorkbook.getSpreadsheetVersion().getMaxFunctionArgs();
        } else {
            maxParams = functionMetadata.getMaxParams();
        }
        if (i > maxParams) {
            String str4 = "Too many arguments to function '" + functionMetadata.getName() + "'. ";
            if (functionMetadata.hasFixedArgsLength()) {
                str = str4 + "Expected " + maxParams;
            } else {
                str = str4 + "At most " + maxParams + " were expected";
            }
            throw new FormulaParseException(str + " but got " + i + ".");
        }
    }

    private ParseNode[] Arguments() {
        ArrayList arrayList = new ArrayList(2);
        SkipWhite();
        if (this.look == 41) {
            return ParseNode.EMPTY_ARRAY;
        }
        while (true) {
            boolean z = true;
            while (true) {
                SkipWhite();
                if (isArgumentDelimiter(this.look)) {
                    break;
                }
                arrayList.add(comparisonExpression());
                SkipWhite();
                if (!isArgumentDelimiter(this.look)) {
                    throw expected("',' or ')'");
                }
                z = false;
            }
            if (z) {
                arrayList.add(new ParseNode(MissingArgPtg.instance));
            }
            if (this.look != 41) {
                Match(44);
            } else {
                ParseNode[] parseNodeArr = new ParseNode[arrayList.size()];
                arrayList.toArray(parseNodeArr);
                return parseNodeArr;
            }
        }
    }

    private ParseNode powerFactor() {
        ParseNode parseNodePercentFactor = percentFactor();
        while (true) {
            SkipWhite();
            if (this.look != 94) {
                return parseNodePercentFactor;
            }
            Match(94);
            parseNodePercentFactor = new ParseNode(PowerPtg.instance, parseNodePercentFactor, percentFactor());
        }
    }

    private ParseNode percentFactor() {
        ParseNode simpleFactor = parseSimpleFactor();
        while (true) {
            SkipWhite();
            if (this.look != 37) {
                return simpleFactor;
            }
            Match(37);
            simpleFactor = new ParseNode(PercentPtg.instance, simpleFactor);
        }
    }

    private ParseNode parseSimpleFactor() {
        int i;
        SkipWhite();
        int i2 = this.look;
        if (i2 == 34) {
            return new ParseNode(new StringPtg(parseStringLiteral()));
        }
        if (i2 == 35) {
            return new ParseNode(ErrPtg.valueOf(parseErrorLiteral()));
        }
        if (i2 == 40) {
            Match(40);
            ParseNode parseNodeUnionExpression = unionExpression();
            Match(41);
            return new ParseNode(ParenthesisPtg.instance, parseNodeUnionExpression);
        }
        if (i2 == 43) {
            Match(43);
            return parseUnary(true);
        }
        if (i2 == 45) {
            Match(45);
            return parseUnary(false);
        }
        if (i2 == 123) {
            Match(123);
            ParseNode array = parseArray();
            Match(125);
            return array;
        }
        if (IsAlpha(i2) || Character.isDigit(this.look) || (i = this.look) == 39 || i == 91 || i == 95 || i == 92) {
            return parseRangeExpression();
        }
        if (i == 46) {
            return new ParseNode(parseNumber());
        }
        throw expected("cell ref or constant literal");
    }

    private ParseNode parseUnary(boolean z) {
        boolean z2 = IsDigit(this.look) || this.look == 46;
        ParseNode parseNodePowerFactor = powerFactor();
        if (z2) {
            Ptg token = parseNodePowerFactor.getToken();
            if (token instanceof NumberPtg) {
                return z ? parseNodePowerFactor : new ParseNode(new NumberPtg(-((NumberPtg) token).getValue()));
            }
            if (token instanceof IntPtg) {
                return z ? parseNodePowerFactor : new ParseNode(new NumberPtg(-((IntPtg) token).getValue()));
            }
        }
        return new ParseNode(z ? UnaryPlusPtg.instance : UnaryMinusPtg.instance, parseNodePowerFactor);
    }

    private ParseNode parseArray() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(parseArrayRow());
            int i = this.look;
            if (i == 125) {
                Object[][] objArr = new Object[arrayList.size()][];
                arrayList.toArray(objArr);
                checkRowLengths(objArr, objArr[0].length);
                return new ParseNode(new ArrayPtg(objArr));
            }
            if (i != 59) {
                throw expected("'}' or ';'");
            }
            Match(59);
        }
    }

    private void checkRowLengths(Object[][] objArr, int i) {
        for (int i2 = 0; i2 < objArr.length; i2++) {
            int length = objArr[i2].length;
            if (length != i) {
                throw new FormulaParseException("Array row " + i2 + " has length " + length + " but row 0 has length " + i);
            }
        }
    }

    private Object[] parseArrayRow() {
        int i;
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(parseArrayItem());
            SkipWhite();
            i = this.look;
            if (i != 44) {
                break;
            }
            Match(44);
        }
        if (i != 59 && i != 125) {
            throw expected("'}' or ','");
        }
        Object[] objArr = new Object[arrayList.size()];
        arrayList.toArray(objArr);
        return objArr;
    }

    private Object parseArrayItem() {
        SkipWhite();
        int i = this.look;
        if (i == 34) {
            return parseStringLiteral();
        }
        if (i == 35) {
            return ErrorConstant.valueOf(parseErrorLiteral());
        }
        if (i == 45) {
            Match(45);
            SkipWhite();
            return convertArrayNumber(parseNumber(), false);
        }
        if (i == 70 || i == 84 || i == 102 || i == 116) {
            return parseBooleanLiteral();
        }
        return convertArrayNumber(parseNumber(), true);
    }

    private Boolean parseBooleanLiteral() {
        String unquotedIdentifier = parseUnquotedIdentifier();
        if ("TRUE".equalsIgnoreCase(unquotedIdentifier)) {
            return Boolean.TRUE;
        }
        if ("FALSE".equalsIgnoreCase(unquotedIdentifier)) {
            return Boolean.FALSE;
        }
        throw expected("'TRUE' or 'FALSE'");
    }

    private static Double convertArrayNumber(Ptg ptg, boolean z) {
        double value;
        if (ptg instanceof IntPtg) {
            value = ((IntPtg) ptg).getValue();
        } else if (ptg instanceof NumberPtg) {
            value = ((NumberPtg) ptg).getValue();
        } else {
            throw new RuntimeException("Unexpected ptg (" + ptg.getClass().getName() + ")");
        }
        if (!z) {
            value = -value;
        }
        return new Double(value);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    private Ptg parseNumber() {
        String strGetNum;
        String str;
        String strGetNum2;
        String strGetNum3 = GetNum();
        String str2 = null;
        if (this.look == 46) {
            GetChar();
            strGetNum = GetNum();
        } else {
            strGetNum = null;
        }
        if (this.look == 69) {
            GetChar();
            int i = this.look;
            if (i == 43) {
                GetChar();
            } else {
                if (i == 45) {
                    GetChar();
                    str = "-";
                }
                strGetNum2 = GetNum();
                if (strGetNum2 != null) {
                    throw expected("Integer");
                }
                str2 = str + strGetNum2;
            }
            str = "";
            strGetNum2 = GetNum();
            if (strGetNum2 != null) {
                throw expected("Integer");
            }
            str2 = str + strGetNum2;
        }
        if (strGetNum3 == null && strGetNum == null) {
            throw expected("Integer");
        }
        return getNumberPtgFromString(strGetNum3, strGetNum, str2);
    }

    private int parseErrorLiteral() {
        Match(35);
        String upperCase = parseUnquotedIdentifier().toUpperCase(Locale.ROOT);
        if (upperCase == null) {
            throw expected("remainder of error constant literal");
        }
        char cCharAt = upperCase.charAt(0);
        if (cCharAt == 'D') {
            FormulaError formulaError = FormulaError.DIV0;
            if (upperCase.equals("DIV")) {
                Match(47);
                Match(48);
                Match(33);
                return formulaError.getCode();
            }
            throw expected(formulaError.getString());
        }
        if (cCharAt != 'N') {
            if (cCharAt == 'R') {
                FormulaError formulaError2 = FormulaError.REF;
                if (upperCase.equals(formulaError2.name())) {
                    Match(33);
                    return formulaError2.getCode();
                }
                throw expected(formulaError2.getString());
            }
            if (cCharAt == 'V') {
                FormulaError formulaError3 = FormulaError.VALUE;
                if (upperCase.equals(formulaError3.name())) {
                    Match(33);
                    return formulaError3.getCode();
                }
                throw expected(formulaError3.getString());
            }
            throw expected("#VALUE!, #REF!, #DIV/0!, #NAME?, #NUM!, #NULL! or #N/A");
        }
        FormulaError formulaError4 = FormulaError.NAME;
        if (upperCase.equals(formulaError4.name())) {
            Match(63);
            return formulaError4.getCode();
        }
        FormulaError formulaError5 = FormulaError.NUM;
        if (upperCase.equals(formulaError5.name())) {
            Match(33);
            return formulaError5.getCode();
        }
        FormulaError formulaError6 = FormulaError.NULL;
        if (upperCase.equals(formulaError6.name())) {
            Match(33);
            return formulaError6.getCode();
        }
        FormulaError formulaError7 = FormulaError.NA;
        if (upperCase.equals("N")) {
            Match(47);
            int i = this.look;
            if (i != 65 && i != 97) {
                throw expected(formulaError7.getString());
            }
            Match(i);
            return formulaError7.getCode();
        }
        throw expected("#NAME?, #NUM!, #NULL! or #N/A");
    }

    private String parseUnquotedIdentifier() {
        if (this.look == 39) {
            throw expected("unquoted identifier");
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!Character.isLetterOrDigit(this.look) && this.look != 46) {
                break;
            }
            sb.appendCodePoint(this.look);
            GetChar();
        }
        if (sb.length() < 1) {
            return null;
        }
        return sb.toString();
    }

    private static Ptg getNumberPtgFromString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (str2 == null) {
            sb.append(str);
            if (str3 != null) {
                sb.append('E');
                sb.append(str3);
            }
            String string = sb.toString();
            try {
                int i = Integer.parseInt(string);
                if (IntPtg.isInRange(i)) {
                    return new IntPtg(i);
                }
                return new NumberPtg(string);
            } catch (NumberFormatException unused) {
                return new NumberPtg(string);
            }
        }
        if (str != null) {
            sb.append(str);
        }
        sb.append('.');
        sb.append(str2);
        if (str3 != null) {
            sb.append('E');
            sb.append(str3);
        }
        return new NumberPtg(sb.toString());
    }

    private String parseStringLiteral() {
        Match(34);
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (this.look == 34) {
                GetChar();
                if (this.look != 34) {
                    return sb.toString();
                }
            }
            sb.appendCodePoint(this.look);
            GetChar();
        }
    }

    private ParseNode Term() {
        ValueOperatorPtg valueOperatorPtg;
        ParseNode parseNodePowerFactor = powerFactor();
        while (true) {
            SkipWhite();
            int i = this.look;
            if (i == 42) {
                Match(42);
                valueOperatorPtg = MultiplyPtg.instance;
            } else {
                if (i != 47) {
                    return parseNodePowerFactor;
                }
                Match(47);
                valueOperatorPtg = DividePtg.instance;
            }
            parseNodePowerFactor = new ParseNode(valueOperatorPtg, parseNodePowerFactor, powerFactor());
        }
    }

    private ParseNode unionExpression() {
        ParseNode parseNodeIntersectionExpression = intersectionExpression();
        boolean z = false;
        while (true) {
            SkipWhite();
            if (this.look != 44) {
                break;
            }
            GetChar();
            z = true;
            parseNodeIntersectionExpression = new ParseNode(UnionPtg.instance, parseNodeIntersectionExpression, intersectionExpression());
        }
        return z ? augmentWithMemPtg(parseNodeIntersectionExpression) : parseNodeIntersectionExpression;
    }

    private ParseNode intersectionExpression() {
        ParseNode parseNodeComparisonExpression = comparisonExpression();
        boolean z = false;
        while (true) {
            SkipWhite();
            if (!this._inIntersection) {
                break;
            }
            try {
                z = true;
                parseNodeComparisonExpression = new ParseNode(IntersectionPtg.instance, parseNodeComparisonExpression, comparisonExpression());
            } catch (FormulaParseException unused) {
                resetPointer(this._pointer);
            }
        }
        return z ? augmentWithMemPtg(parseNodeComparisonExpression) : parseNodeComparisonExpression;
    }

    private ParseNode comparisonExpression() {
        ParseNode parseNodeConcatExpression = concatExpression();
        while (true) {
            SkipWhite();
            switch (this.look) {
                case 60:
                case 61:
                case 62:
                    parseNodeConcatExpression = new ParseNode(getComparisonToken(), parseNodeConcatExpression, concatExpression());
                    break;
                default:
                    return parseNodeConcatExpression;
            }
        }
    }

    private Ptg getComparisonToken() {
        int i = this.look;
        if (i == 61) {
            Match(i);
            return EqualPtg.instance;
        }
        boolean z = i == 62;
        Match(i);
        if (z) {
            if (this.look == 61) {
                Match(61);
                return GreaterEqualPtg.instance;
            }
            return GreaterThanPtg.instance;
        }
        int i2 = this.look;
        if (i2 == 61) {
            Match(61);
            return LessEqualPtg.instance;
        }
        if (i2 == 62) {
            Match(62);
            return NotEqualPtg.instance;
        }
        return LessThanPtg.instance;
    }

    private ParseNode concatExpression() {
        ParseNode parseNodeAdditiveExpression = additiveExpression();
        while (true) {
            SkipWhite();
            if (this.look != 38) {
                return parseNodeAdditiveExpression;
            }
            Match(38);
            parseNodeAdditiveExpression = new ParseNode(ConcatPtg.instance, parseNodeAdditiveExpression, additiveExpression());
        }
    }

    private ParseNode additiveExpression() {
        ValueOperatorPtg valueOperatorPtg;
        ParseNode parseNodeTerm = Term();
        while (true) {
            SkipWhite();
            int i = this.look;
            if (i == 43) {
                Match(43);
                valueOperatorPtg = AddPtg.instance;
            } else {
                if (i != 45) {
                    return parseNodeTerm;
                }
                Match(45);
                valueOperatorPtg = SubtractPtg.instance;
            }
            parseNodeTerm = new ParseNode(valueOperatorPtg, parseNodeTerm, Term());
        }
    }

    private void parse() {
        this._pointer = 0;
        GetChar();
        this._rootNode = unionExpression();
        if (this._pointer <= this._formulaLength) {
            throw new FormulaParseException("Unused input [" + this._formulaString.substring(this._pointer - 1) + "] after attempting to parse the formula [" + this._formulaString + "]");
        }
    }

    private Ptg[] getRPNPtg(FormulaType formulaType) {
        new OperandClassTransformer(formulaType).transformFormula(this._rootNode);
        return ParseNode.toTokenArray(this._rootNode);
    }
}
