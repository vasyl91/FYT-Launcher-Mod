package org.apache.poi.ss.usermodel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.format.CellFormatResult;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DataFormatter implements Observer {
    private static final String defaultFractionFractionPartFormat = "#/##";
    private static final String defaultFractionWholePartFormat = "#";
    private static final String invalidDateTimeString;
    private static POILogger logger;
    private DateFormatSymbols dateSymbols;
    private DecimalFormatSymbols decimalSymbols;
    private DateFormat defaultDateformat;
    private Format defaultNumFormat;
    private final boolean emulateCSV;
    private final Map<String, Format> formats;
    private Format generalNumberFormat;
    private Locale locale;
    private final LocaleChangeObservable localeChangedObservable;
    private boolean localeIsAdapting;
    private static final Pattern numPattern = Pattern.compile("[0#]+");
    private static final Pattern daysAsText = Pattern.compile("([d]{3,})", 2);
    private static final Pattern amPmPattern = Pattern.compile("((A|P)[M/P]*)", 2);
    private static final Pattern rangeConditionalPattern = Pattern.compile(".*\\[\\s*(>|>=|<|<=|=)\\s*[0-9]*\\.*[0-9].*");
    private static final Pattern localePatternGroup = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+\\])");
    private static final Pattern colorPattern = Pattern.compile("(\\[BLACK\\])|(\\[BLUE\\])|(\\[CYAN\\])|(\\[GREEN\\])|(\\[MAGENTA\\])|(\\[RED\\])|(\\[WHITE\\])|(\\[YELLOW\\])|(\\[COLOR\\s*\\d\\])|(\\[COLOR\\s*[0-5]\\d\\])", 2);
    private static final Pattern fractionPattern = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*\\/\\s*([#\\d]+)");
    private static final Pattern fractionStripper = Pattern.compile("(\"[^\"]*\")|([^ \\?#\\d\\/]+)");
    private static final Pattern alternateGrouping = Pattern.compile("([#0]([^.#0])[#0]{3})");

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 255; i++) {
            sb.append('#');
        }
        invalidDateTimeString = sb.toString();
        logger = POILogFactory.getLogger((Class<?>) DataFormatter.class);
    }

    private class LocaleChangeObservable extends Observable {
        private LocaleChangeObservable() {
        }

        /* synthetic */ LocaleChangeObservable(DataFormatter dataFormatter, AnonymousClass1 anonymousClass1) {
            this();
        }

        void checkForLocaleChange() {
            checkForLocaleChange(LocaleUtil.getUserLocale());
        }

        void checkForLocaleChange(Locale locale) {
            if (DataFormatter.this.localeIsAdapting && !locale.equals(DataFormatter.this.locale)) {
                super.setChanged();
                notifyObservers(locale);
            }
        }
    }

    public DataFormatter() {
        this(false);
    }

    public DataFormatter(boolean z) {
        this(LocaleUtil.getUserLocale(), true, z);
    }

    public DataFormatter(Locale locale) {
        this(locale, false);
    }

    public DataFormatter(Locale locale, boolean z) {
        this(locale, false, z);
    }

    private DataFormatter(Locale locale, boolean z, boolean z2) {
        this.formats = new HashMap();
        LocaleChangeObservable localeChangeObservable = new LocaleChangeObservable(this, null);
        this.localeChangedObservable = localeChangeObservable;
        this.localeIsAdapting = true;
        localeChangeObservable.addObserver(this);
        localeChangeObservable.checkForLocaleChange(locale);
        this.localeIsAdapting = z;
        this.emulateCSV = z2;
    }

    private Format getFormat(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        ExcelNumberFormat excelNumberFormatFrom;
        if (cell == null || (excelNumberFormatFrom = ExcelNumberFormat.from(cell, conditionalFormattingEvaluator)) == null) {
            return null;
        }
        int idx = excelNumberFormatFrom.getIdx();
        String format = excelNumberFormatFrom.getFormat();
        if (format == null || format.trim().length() == 0) {
            return null;
        }
        return getFormat(cell.getNumericCellValue(), idx, format);
    }

    private Format getFormat(double d, int i, String str) {
        this.localeChangedObservable.checkForLocaleChange();
        if (str.contains(";") && (str.indexOf(59) != str.lastIndexOf(59) || rangeConditionalPattern.matcher(str).matches())) {
            try {
                CellFormat cellFormat = CellFormat.getInstance(this.locale, str);
                Double dValueOf = Double.valueOf(d);
                Object javaDate = dValueOf;
                if (DateUtil.isADateFormat(i, str)) {
                    Double d2 = dValueOf;
                    if (dValueOf.doubleValue() != 0.0d) {
                        javaDate = dValueOf;
                        javaDate = DateUtil.getJavaDate(d);
                    }
                }
                javaDate = dValueOf;
                return new CellFormatResultWrapper(this, cellFormat.apply(javaDate), null);
            } catch (Exception e) {
                logger.log(5, "Formatting failed for format " + str + ", falling back", e);
            }
        }
        if (this.emulateCSV && d == 0.0d && str.contains(defaultFractionWholePartFormat) && !str.contains("0")) {
            str = str.replaceAll(defaultFractionWholePartFormat, "");
        }
        Format format = this.formats.get(str);
        if (format != null) {
            return format;
        }
        if ("General".equalsIgnoreCase(str) || "@".equals(str)) {
            return this.generalNumberFormat;
        }
        Format formatCreateFormat = createFormat(d, i, str);
        this.formats.put(str, formatCreateFormat);
        return formatCreateFormat;
    }

    public Format createFormat(Cell cell) {
        return createFormat(cell.getNumericCellValue(), cell.getCellStyle().getDataFormat(), cell.getCellStyle().getDataFormatString());
    }

    private Format createFormat(double d, int i, String str) {
        int i2;
        String strGroup;
        int iIndexOf;
        this.localeChangedObservable.checkForLocaleChange();
        Matcher matcher = colorPattern.matcher(str);
        String str2 = str;
        while (true) {
            i2 = 0;
            if (!matcher.find() || (iIndexOf = str2.indexOf((strGroup = matcher.group()))) == -1) {
                break;
            }
            String str3 = str2.substring(0, iIndexOf) + str2.substring(iIndexOf + strGroup.length());
            if (str3.equals(str2)) {
                break;
            }
            matcher = colorPattern.matcher(str3);
            str2 = str3;
        }
        Matcher matcher2 = localePatternGroup.matcher(str2);
        String str4 = str2;
        while (matcher2.find()) {
            String strGroup2 = matcher2.group();
            String strSubstring = strGroup2.substring(strGroup2.indexOf(36) + 1, strGroup2.indexOf(45));
            if (strSubstring.indexOf(36) > -1) {
                strSubstring = strSubstring.substring(0, strSubstring.indexOf(36)) + '\\' + strSubstring.substring(strSubstring.indexOf(36), strSubstring.length());
            }
            String strReplaceAll = matcher2.replaceAll(strSubstring);
            matcher2 = localePatternGroup.matcher(strReplaceAll);
            str4 = strReplaceAll;
        }
        if (str4 == null || str4.trim().length() == 0) {
            return getDefaultFormat(d);
        }
        if ("General".equalsIgnoreCase(str4) || "@".equals(str4)) {
            return this.generalNumberFormat;
        }
        if (DateUtil.isADateFormat(i, str4) && DateUtil.isValidExcelDate(d)) {
            return createDateFormat(str4, d);
        }
        if (str4.contains("#/") || str4.contains("?/")) {
            String[] strArrSplit = str4.split(";");
            int length = strArrSplit.length;
            while (true) {
                String str5 = defaultFractionWholePartFormat;
                if (i2 < length) {
                    Matcher matcher3 = fractionPattern.matcher(fractionStripper.matcher(strArrSplit[i2].replaceAll("\\?", defaultFractionWholePartFormat)).replaceAll(" ").replaceAll(" +", " "));
                    if (matcher3.find()) {
                        if (matcher3.group(1) == null) {
                            str5 = "";
                        }
                        return new FractionFormat(str5, matcher3.group(3));
                    }
                    i2++;
                } else {
                    return new FractionFormat(defaultFractionWholePartFormat, defaultFractionFractionPartFormat);
                }
            }
        } else {
            if (numPattern.matcher(str4).find()) {
                return createNumberFormat(str4, d);
            }
            if (this.emulateCSV) {
                return new ConstantStringFormat(cleanFormatForNumber(str4));
            }
            return null;
        }
    }

    private Format createDateFormat(String str, double d) {
        char c;
        String strReplaceAll = str.replaceAll("\\\\-", "-").replaceAll("\\\\,", ",").replaceAll("\\\\\\.", ".").replaceAll("\\\\ ", " ").replaceAll("\\\\/", "/").replaceAll(";@", "").replaceAll("\"/\"", "/").replace("\"\"", "'").replaceAll("\\\\T", "'T'");
        Matcher matcher = amPmPattern.matcher(strReplaceAll);
        boolean z = false;
        boolean z2 = false;
        while (matcher.find()) {
            strReplaceAll = matcher.replaceAll("@");
            matcher = amPmPattern.matcher(strReplaceAll);
            z2 = true;
        }
        String strReplaceAll2 = strReplaceAll.replaceAll("@", "a");
        Matcher matcher2 = daysAsText.matcher(strReplaceAll2);
        if (matcher2.find()) {
            strReplaceAll2 = matcher2.replaceAll(matcher2.group(0).toUpperCase(Locale.ROOT).replaceAll("D", "E"));
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = strReplaceAll2.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z3 = false;
        boolean z4 = true;
        while (i < charArray.length) {
            char c2 = charArray[i];
            if (c2 == '\'') {
                sb.append(c2);
                do {
                    i++;
                    if (i >= charArray.length) {
                        break;
                    }
                    c = charArray[i];
                    sb.append(c);
                } while (c != '\'');
            } else if (c2 == '[' && !z3) {
                sb.append(c2);
                z4 = z;
                z3 = true;
            } else if (c2 == ']' && z3) {
                sb.append(c2);
                z3 = z;
            } else if (z3) {
                if (c2 == 'h' || c2 == 'H') {
                    sb.append('H');
                } else if (c2 == 'm' || c2 == 'M') {
                    sb.append('m');
                } else if (c2 == 's' || c2 == 'S') {
                    sb.append('s');
                } else {
                    sb.append(c2);
                }
            } else if (c2 == 'h' || c2 == 'H') {
                if (z2) {
                    sb.append('h');
                } else {
                    sb.append('H');
                }
                z4 = false;
            } else if (c2 != 'm' && c2 != 'M') {
                if (c2 == 's' || c2 == 'S') {
                    sb.append('s');
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        if (sb.charAt(iIntValue) == 'M') {
                            sb.replace(iIntValue, iIntValue + 1, "m");
                        }
                    }
                    arrayList.clear();
                } else if (Character.isLetter(c2)) {
                    arrayList.clear();
                    if (c2 == 'y' || c2 == 'Y') {
                        sb.append('y');
                    } else if (c2 == 'd' || c2 == 'D') {
                        sb.append('d');
                    } else {
                        sb.append(c2);
                    }
                } else {
                    if (Character.isWhitespace(c2)) {
                        arrayList.clear();
                    }
                    sb.append(c2);
                }
                z4 = true;
            } else if (z4) {
                sb.append('M');
                arrayList.add(Integer.valueOf(sb.length() - 1));
            } else {
                sb.append('m');
            }
            i++;
            z = false;
        }
        String string = sb.toString();
        try {
            return new ExcelStyleDateFormatter(string, this.dateSymbols);
        } catch (IllegalArgumentException e) {
            logger.log(1, "Formatting failed for format " + string + ", falling back", e);
            return getDefaultFormat(d);
        }
    }

    private String cleanFormatForNumber(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        if (this.emulateCSV) {
            int i2 = 0;
            while (i2 < sb.length()) {
                char cCharAt = sb.charAt(i2);
                if ((cCharAt == '_' || cCharAt == '*' || cCharAt == '?') && (i2 <= 0 || sb.charAt(i2 - 1) != '\\')) {
                    if (cCharAt == '?') {
                        sb.setCharAt(i2, ' ');
                    } else if (i2 < sb.length() - 1) {
                        if (cCharAt == '_') {
                            sb.setCharAt(i2 + 1, ' ');
                        } else {
                            sb.deleteCharAt(i2 + 1);
                        }
                        sb.deleteCharAt(i2);
                        i2--;
                    }
                }
                i2++;
            }
        } else {
            int i3 = 0;
            while (i3 < sb.length()) {
                char cCharAt2 = sb.charAt(i3);
                if ((cCharAt2 == '_' || cCharAt2 == '*') && (i3 <= 0 || sb.charAt(i3 - 1) != '\\')) {
                    if (i3 < sb.length() - 1) {
                        sb.deleteCharAt(i3 + 1);
                    }
                    sb.deleteCharAt(i3);
                    i3--;
                }
                i3++;
            }
        }
        while (i < sb.length()) {
            char cCharAt3 = sb.charAt(i);
            if (cCharAt3 == '\\' || cCharAt3 == '\"') {
                sb.deleteCharAt(i);
            } else {
                if (cCharAt3 == '+' && i > 0 && sb.charAt(i - 1) == 'E') {
                    sb.deleteCharAt(i);
                }
                i++;
            }
            i--;
            i++;
        }
        return sb.toString();
    }

    private static class InternalDecimalFormatWithScale extends Format {
        private final DecimalFormat df;
        private BigDecimal divider;
        private static final Pattern endsWithCommas = Pattern.compile("(,+)$");
        private static final BigDecimal ONE_THOUSAND = new BigDecimal(1000);

        private static final String trimTrailingCommas(String str) {
            return str.replaceAll(",+$", "");
        }

        public InternalDecimalFormatWithScale(String str, DecimalFormatSymbols decimalFormatSymbols) {
            DecimalFormat decimalFormat = new DecimalFormat(trimTrailingCommas(str), decimalFormatSymbols);
            this.df = decimalFormat;
            DataFormatter.setExcelStyleRoundingMode(decimalFormat);
            Matcher matcher = endsWithCommas.matcher(str);
            if (matcher.find()) {
                String strGroup = matcher.group(1);
                BigDecimal bigDecimalMultiply = BigDecimal.ONE;
                for (int i = 0; i < strGroup.length(); i++) {
                    bigDecimalMultiply = bigDecimalMultiply.multiply(ONE_THOUSAND);
                }
                this.divider = bigDecimalMultiply;
                return;
            }
            this.divider = null;
        }

        private Object scaleInput(Object obj) {
            BigDecimal bigDecimal = this.divider;
            if (bigDecimal == null) {
                return obj;
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).divide(bigDecimal, RoundingMode.HALF_UP);
            }
            if (obj instanceof Double) {
                return Double.valueOf(((Double) obj).doubleValue() / this.divider.doubleValue());
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return this.df.format(scaleInput(obj), stringBuffer, fieldPosition);
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            throw new UnsupportedOperationException();
        }
    }

    private Format createNumberFormat(String str, double d) {
        char cCharAt;
        String strCleanFormatForNumber = cleanFormatForNumber(str);
        DecimalFormatSymbols decimalFormatSymbols = this.decimalSymbols;
        Matcher matcher = alternateGrouping.matcher(strCleanFormatForNumber);
        if (matcher.find() && (cCharAt = matcher.group(2).charAt(0)) != ',') {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance(this.locale);
            decimalFormatSymbols.setGroupingSeparator(cCharAt);
            String strGroup = matcher.group(1);
            strCleanFormatForNumber = strCleanFormatForNumber.replace(strGroup, strGroup.replace(cCharAt, ','));
        }
        try {
            return new InternalDecimalFormatWithScale(strCleanFormatForNumber, decimalFormatSymbols);
        } catch (IllegalArgumentException e) {
            logger.log(1, "Formatting failed for format " + str + ", falling back", e);
            return getDefaultFormat(d);
        }
    }

    public Format getDefaultFormat(Cell cell) {
        return getDefaultFormat(cell.getNumericCellValue());
    }

    private Format getDefaultFormat(double d) {
        this.localeChangedObservable.checkForLocaleChange();
        Format format = this.defaultNumFormat;
        return format != null ? format : this.generalNumberFormat;
    }

    private String performDateFormatting(Date date, Format format) {
        if (format == null) {
            format = this.defaultDateformat;
        }
        return format.format(date);
    }

    private String getFormattedDateString(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        Format format = getFormat(cell, conditionalFormattingEvaluator);
        if (format instanceof ExcelStyleDateFormatter) {
            ((ExcelStyleDateFormatter) format).setDateToBeFormatted(cell.getNumericCellValue());
        }
        return performDateFormatting(cell.getDateCellValue(), format);
    }

    private String getFormattedNumberString(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        Format format = getFormat(cell, conditionalFormattingEvaluator);
        double numericCellValue = cell.getNumericCellValue();
        if (format == null) {
            return String.valueOf(numericCellValue);
        }
        return format.format(new Double(numericCellValue)).replaceFirst("E(\\d)", "E+$1");
    }

    public String formatRawCellContents(double d, int i, String str) {
        return formatRawCellContents(d, i, str, false);
    }

    public String formatRawCellContents(double d, int i, String str, boolean z) {
        String str2;
        this.localeChangedObservable.checkForLocaleChange();
        if (DateUtil.isADateFormat(i, str)) {
            if (DateUtil.isValidExcelDate(d)) {
                Format format = getFormat(d, i, str);
                if (format instanceof ExcelStyleDateFormatter) {
                    ((ExcelStyleDateFormatter) format).setDateToBeFormatted(d);
                }
                return performDateFormatting(DateUtil.getJavaDate(d, z), format);
            }
            if (this.emulateCSV) {
                return invalidDateTimeString;
            }
        }
        Format format2 = getFormat(d, i, str);
        if (format2 == null) {
            return String.valueOf(d);
        }
        String text = NumberToTextConverter.toText(d);
        if (text.indexOf(69) > -1) {
            str2 = format2.format(new Double(d));
        } else {
            str2 = format2.format(new BigDecimal(text));
        }
        return (str2.indexOf(69) <= -1 || str2.contains("E-")) ? str2 : str2.replaceFirst("E", "E+");
    }

    public String formatCellValue(Cell cell) {
        return formatCellValue(cell, null);
    }

    public String formatCellValue(Cell cell, FormulaEvaluator formulaEvaluator) {
        return formatCellValue(cell, formulaEvaluator, null);
    }

    public String formatCellValue(Cell cell, FormulaEvaluator formulaEvaluator, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        this.localeChangedObservable.checkForLocaleChange();
        if (cell == null) {
            return "";
        }
        CellType cellTypeEnum = cell.getCellTypeEnum();
        if (cellTypeEnum == CellType.FORMULA) {
            if (formulaEvaluator == null) {
                return cell.getCellFormula();
            }
            cellTypeEnum = formulaEvaluator.evaluateFormulaCellEnum(cell);
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            if (DateUtil.isCellDateFormatted(cell, conditionalFormattingEvaluator)) {
                return getFormattedDateString(cell, conditionalFormattingEvaluator);
            }
            return getFormattedNumberString(cell, conditionalFormattingEvaluator);
        }
        if (i == 2) {
            return cell.getRichStringCellValue().getString();
        }
        if (i == 3) {
            return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        }
        if (i == 4) {
            return "";
        }
        if (i == 5) {
            return FormulaError.forInt(cell.getErrorCellValue()).getString();
        }
        throw new RuntimeException("Unexpected celltype (" + cellTypeEnum + ")");
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.DataFormatter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void setDefaultNumberFormat(Format format) {
        for (Map.Entry<String, Format> entry : this.formats.entrySet()) {
            if (entry.getValue() == this.generalNumberFormat) {
                entry.setValue(format);
            }
        }
        this.defaultNumFormat = format;
    }

    public void addFormat(String str, Format format) {
        this.formats.put(str, format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DecimalFormat createIntegerOnlyFormat(String str) {
        DecimalFormat decimalFormat = new DecimalFormat(str, DecimalFormatSymbols.getInstance(Locale.ROOT));
        decimalFormat.setParseIntegerOnly(true);
        return decimalFormat;
    }

    public static void setExcelStyleRoundingMode(DecimalFormat decimalFormat) {
        setExcelStyleRoundingMode(decimalFormat, RoundingMode.HALF_UP);
    }

    public static void setExcelStyleRoundingMode(DecimalFormat decimalFormat, RoundingMode roundingMode) {
        decimalFormat.setRoundingMode(roundingMode);
    }

    public Observable getLocaleChangedObservable() {
        return this.localeChangedObservable;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof Locale) {
            Locale locale = (Locale) obj;
            if (!this.localeIsAdapting || locale.equals(this.locale)) {
                return;
            }
            this.locale = locale;
            this.dateSymbols = DateFormatSymbols.getInstance(locale);
            this.decimalSymbols = DecimalFormatSymbols.getInstance(this.locale);
            this.generalNumberFormat = new ExcelGeneralNumberFormat(this.locale);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", this.dateSymbols);
            this.defaultDateformat = simpleDateFormat;
            simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
            this.formats.clear();
            Format format = ZipPlusFourFormat.instance;
            addFormat("00000\\-0000", format);
            addFormat("00000-0000", format);
            Format format2 = PhoneFormat.instance;
            addFormat("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", format2);
            addFormat("[<=9999999]###-####;(###) ###-####", format2);
            addFormat("###\\-####;\\(###\\)\\ ###\\-####", format2);
            addFormat("###-####;(###) ###-####", format2);
            Format format3 = SSNFormat.instance;
            addFormat("000\\-00\\-0000", format3);
            addFormat("000-00-0000", format3);
        }
    }

    private static final class SSNFormat extends Format {
        public static final Format instance = new SSNFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private SSNFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            return str.substring(0, 3) + '-' + str.substring(3, 5) + '-' + str.substring(5, 9);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(format((Number) obj));
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    private static final class ZipPlusFourFormat extends Format {
        public static final Format instance = new ZipPlusFourFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private ZipPlusFourFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            return str.substring(0, 5) + '-' + str.substring(5, 9);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(format((Number) obj));
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    private static final class PhoneFormat extends Format {
        public static final Format instance = new PhoneFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");

        private PhoneFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            if (length <= 4) {
                return str;
            }
            int i = length - 4;
            String strSubstring = str.substring(i, length);
            int i2 = length - 7;
            String strSubstring2 = str.substring(Math.max(0, i2), i);
            String strSubstring3 = str.substring(Math.max(0, length - 10), Math.max(0, i2));
            if (strSubstring3.trim().length() > 0) {
                sb.append('(').append(strSubstring3).append(") ");
            }
            if (strSubstring2.trim().length() > 0) {
                sb.append(strSubstring2).append('-');
            }
            sb.append(strSubstring);
            return sb.toString();
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(format((Number) obj));
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    private static final class ConstantStringFormat extends Format {
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");
        private final String str;

        public ConstantStringFormat(String str) {
            this.str = str;
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return stringBuffer.append(this.str);
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }
    }

    private final class CellFormatResultWrapper extends Format {
        private final CellFormatResult result;

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return null;
        }

        /* synthetic */ CellFormatResultWrapper(DataFormatter dataFormatter, CellFormatResult cellFormatResult, AnonymousClass1 anonymousClass1) {
            this(cellFormatResult);
        }

        private CellFormatResultWrapper(CellFormatResult cellFormatResult) {
            this.result = cellFormatResult;
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            if (DataFormatter.this.emulateCSV) {
                return stringBuffer.append(this.result.text);
            }
            return stringBuffer.append(this.result.text.trim());
        }
    }
}
