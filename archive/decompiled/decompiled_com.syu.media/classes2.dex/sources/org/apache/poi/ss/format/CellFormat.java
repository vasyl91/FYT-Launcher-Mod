package org.apache.poi.ss.format;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellFormat {
    private static final String INVALID_VALUE_FOR_FORMAT = "###############################################################################################################################################################################################################################################################";
    private final String format;
    private final int formatPartCount;
    private final Locale locale;
    private final CellFormatPart negNumFmt;
    private final CellFormatPart posNumFmt;
    private final CellFormatPart textFmt;
    private final CellFormatPart zeroNumFmt;
    private static final Pattern ONE_PART = Pattern.compile(CellFormatPart.FORMAT_PAT.pattern() + "(;|$)", 6);
    private static String QUOTE = "\"";

    @Removal(version = "3.18")
    @Deprecated
    public static final CellFormat GENERAL_FORMAT = createGeneralFormat(LocaleUtil.getUserLocale());
    private static final Map<Locale, Map<String, CellFormat>> formatCache = new WeakHashMap();

    private static CellFormat createGeneralFormat(final Locale locale) {
        return new CellFormat(locale, "General") { // from class: org.apache.poi.ss.format.CellFormat.1
            @Override // org.apache.poi.ss.format.CellFormat
            public CellFormatResult apply(Object obj) {
                return new CellFormatResult(true, new CellGeneralFormatter(locale).format(obj), null);
            }
        };
    }

    public static CellFormat getInstance(String str) {
        return getInstance(LocaleUtil.getUserLocale(), str);
    }

    public static synchronized CellFormat getInstance(Locale locale, String str) {
        CellFormat cellFormatCreateGeneralFormat;
        Map<Locale, Map<String, CellFormat>> map = formatCache;
        Map<String, CellFormat> weakHashMap = map.get(locale);
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap<>();
            map.put(locale, weakHashMap);
        }
        cellFormatCreateGeneralFormat = weakHashMap.get(str);
        if (cellFormatCreateGeneralFormat == null) {
            if (str.equals("General") || str.equals("@")) {
                cellFormatCreateGeneralFormat = createGeneralFormat(locale);
            } else {
                cellFormatCreateGeneralFormat = new CellFormat(locale, str);
            }
            weakHashMap.put(str, cellFormatCreateGeneralFormat);
        }
        return cellFormatCreateGeneralFormat;
    }

    private CellFormat(Locale locale, String str) {
        this.locale = locale;
        this.format = str;
        CellFormatPart cellFormatPart = new CellFormatPart(locale, "@");
        Matcher matcher = ONE_PART.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            try {
                String strGroup = matcher.group();
                arrayList.add(new CellFormatPart(locale, strGroup.endsWith(";") ? strGroup.substring(0, strGroup.length() - 1) : strGroup));
            } catch (RuntimeException e) {
                CellFormatter.logger.log(Level.WARNING, "Invalid format: " + CellFormatter.quote(matcher.group()), (Throwable) e);
                arrayList.add(null);
            }
        }
        int size = arrayList.size();
        this.formatPartCount = size;
        if (size == 1) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = null;
            this.zeroNumFmt = null;
            this.textFmt = cellFormatPart;
            return;
        }
        if (size == 2) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = (CellFormatPart) arrayList.get(1);
            this.zeroNumFmt = null;
            this.textFmt = cellFormatPart;
            return;
        }
        if (size == 3) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = (CellFormatPart) arrayList.get(1);
            this.zeroNumFmt = (CellFormatPart) arrayList.get(2);
            this.textFmt = cellFormatPart;
            return;
        }
        this.posNumFmt = (CellFormatPart) arrayList.get(0);
        this.negNumFmt = (CellFormatPart) arrayList.get(1);
        this.zeroNumFmt = (CellFormatPart) arrayList.get(2);
        this.textFmt = (CellFormatPart) arrayList.get(3);
    }

    public CellFormatResult apply(Object obj) {
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            if (dDoubleValue < 0.0d && ((this.formatPartCount == 2 && !this.posNumFmt.hasCondition() && !this.negNumFmt.hasCondition()) || ((this.formatPartCount == 3 && !this.negNumFmt.hasCondition()) || (this.formatPartCount == 4 && !this.negNumFmt.hasCondition())))) {
                return this.negNumFmt.apply(Double.valueOf(-dDoubleValue));
            }
            return getApplicableFormatPart(Double.valueOf(dDoubleValue)).apply(Double.valueOf(dDoubleValue));
        }
        if (obj instanceof Date) {
            Double dValueOf = Double.valueOf(DateUtil.getExcelDate((Date) obj));
            if (DateUtil.isValidExcelDate(dValueOf.doubleValue())) {
                return getApplicableFormatPart(dValueOf).apply(obj);
            }
            throw new IllegalArgumentException("value " + dValueOf + " of date " + obj + " is not a valid Excel date");
        }
        return this.textFmt.apply(obj);
    }

    private CellFormatResult apply(Date date, double d) {
        return getApplicableFormatPart(Double.valueOf(d)).apply(date);
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.format.CellFormat$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BLANK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public CellFormatResult apply(Cell cell) {
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$CellType[ultimateTypeEnum(cell).ordinal()];
        if (i == 1) {
            return apply("");
        }
        if (i == 2) {
            return apply(Boolean.valueOf(cell.getBooleanCellValue()));
        }
        if (i != 3) {
            if (i == 4) {
                return apply(cell.getStringCellValue());
            }
            return apply("?");
        }
        Double dValueOf = Double.valueOf(cell.getNumericCellValue());
        if (getApplicableFormatPart(dValueOf).getCellFormatType() == CellFormatType.DATE) {
            if (DateUtil.isValidExcelDate(dValueOf.doubleValue())) {
                return apply(cell.getDateCellValue(), dValueOf.doubleValue());
            }
            return apply(INVALID_VALUE_FOR_FORMAT);
        }
        return apply(dValueOf);
    }

    public CellFormatResult apply(JLabel jLabel, Object obj) {
        CellFormatResult cellFormatResultApply = apply(obj);
        jLabel.setText(cellFormatResultApply.text);
        if (cellFormatResultApply.textColor != null) {
            jLabel.setForeground(cellFormatResultApply.textColor);
        }
        return cellFormatResultApply;
    }

    private CellFormatResult apply(JLabel jLabel, Date date, double d) {
        CellFormatResult cellFormatResultApply = apply(date, d);
        jLabel.setText(cellFormatResultApply.text);
        if (cellFormatResultApply.textColor != null) {
            jLabel.setForeground(cellFormatResultApply.textColor);
        }
        return cellFormatResultApply;
    }

    public CellFormatResult apply(JLabel jLabel, Cell cell) {
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$CellType[ultimateTypeEnum(cell).ordinal()];
        if (i == 1) {
            return apply(jLabel, "");
        }
        if (i == 2) {
            return apply(jLabel, Boolean.valueOf(cell.getBooleanCellValue()));
        }
        if (i != 3) {
            if (i == 4) {
                return apply(jLabel, cell.getStringCellValue());
            }
            return apply(jLabel, "?");
        }
        Double dValueOf = Double.valueOf(cell.getNumericCellValue());
        if (getApplicableFormatPart(dValueOf).getCellFormatType() == CellFormatType.DATE) {
            if (DateUtil.isValidExcelDate(dValueOf.doubleValue())) {
                return apply(jLabel, cell.getDateCellValue(), dValueOf.doubleValue());
            }
            return apply(jLabel, INVALID_VALUE_FOR_FORMAT);
        }
        return apply(jLabel, dValueOf);
    }

    private CellFormatPart getApplicableFormatPart(Object obj) {
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            int i = this.formatPartCount;
            if (i == 1) {
                if (!this.posNumFmt.hasCondition() || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(dDoubleValue)))) {
                    return this.posNumFmt;
                }
                return new CellFormatPart(this.locale, "General");
            }
            if (i == 2) {
                if ((!this.posNumFmt.hasCondition() && dDoubleValue >= 0.0d) || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(dDoubleValue)))) {
                    return this.posNumFmt;
                }
                if (!this.negNumFmt.hasCondition() || (this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(dDoubleValue)))) {
                    return this.negNumFmt;
                }
                return new CellFormatPart(QUOTE + INVALID_VALUE_FOR_FORMAT + QUOTE);
            }
            if ((!this.posNumFmt.hasCondition() && dDoubleValue > 0.0d) || (this.posNumFmt.hasCondition() && this.posNumFmt.applies(Double.valueOf(dDoubleValue)))) {
                return this.posNumFmt;
            }
            if ((!this.negNumFmt.hasCondition() && dDoubleValue < 0.0d) || (this.negNumFmt.hasCondition() && this.negNumFmt.applies(Double.valueOf(dDoubleValue)))) {
                return this.negNumFmt;
            }
            return this.zeroNumFmt;
        }
        throw new IllegalArgumentException("value must be a Number");
    }

    public static int ultimateType(Cell cell) {
        return ultimateTypeEnum(cell).getCode();
    }

    public static CellType ultimateTypeEnum(Cell cell) {
        CellType cellTypeEnum = cell.getCellTypeEnum();
        return cellTypeEnum == CellType.FORMULA ? cell.getCachedFormulaResultTypeEnum() : cellTypeEnum;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CellFormat) {
            return this.format.equals(((CellFormat) obj).format);
        }
        return false;
    }

    public int hashCode() {
        return this.format.hashCode();
    }
}
