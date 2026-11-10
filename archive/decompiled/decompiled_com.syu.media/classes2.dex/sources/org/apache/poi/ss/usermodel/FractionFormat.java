package org.apache.poi.ss.usermodel;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.format.SimpleFraction;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FractionFormat extends Format {
    private static final int MAX_DENOM_POW = 4;
    private final int exactDenom;
    private final int maxDenom;
    private final String wholePartFormatString;
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) FractionFormat.class);
    private static final Pattern DENOM_FORMAT_PATTERN = Pattern.compile("(?:(#+)|(\\d+))");

    public FractionFormat(String str, String str2) {
        int iPow;
        this.wholePartFormatString = str;
        Matcher matcher = DENOM_FORMAT_PATTERN.matcher(str2);
        int i = -1;
        if (!matcher.find()) {
            iPow = -1;
        } else if (matcher.group(2) != null) {
            try {
                int i2 = Integer.parseInt(matcher.group(2));
                i = i2 == 0 ? -1 : i2;
                iPow = -1;
            } catch (NumberFormatException unused) {
                iPow = -1;
            }
        } else if (matcher.group(1) != null) {
            int length = matcher.group(1).length();
            iPow = (int) Math.pow(10.0d, length > 4 ? 4 : length);
        } else {
            iPow = -1;
            i = 100;
        }
        this.exactDenom = (i > 0 || iPow > 0) ? i : 100;
        this.maxDenom = iPow;
    }

    public String format(Number number) {
        SimpleFraction simpleFractionBuildFractionMaxDenominator;
        double dDoubleValue = number.doubleValue();
        boolean z = dDoubleValue < 0.0d;
        double dAbs = Math.abs(dDoubleValue);
        double dFloor = Math.floor(dAbs);
        double d = dAbs - dFloor;
        if (dFloor + d == 0.0d) {
            return "0";
        }
        if (Double.compare(d, 0.0d) == 0) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("-");
            }
            sb.append((int) dFloor);
            return sb.toString();
        }
        try {
            int i = this.exactDenom;
            if (i > 0) {
                simpleFractionBuildFractionMaxDenominator = SimpleFraction.buildFractionExactDenominator(d, i);
            } else {
                simpleFractionBuildFractionMaxDenominator = SimpleFraction.buildFractionMaxDenominator(d, this.maxDenom);
            }
            StringBuilder sb2 = new StringBuilder();
            if (z) {
                sb2.append("-");
            }
            if ("".equals(this.wholePartFormatString)) {
                sb2.append((simpleFractionBuildFractionMaxDenominator.getDenominator() * ((int) dFloor)) + simpleFractionBuildFractionMaxDenominator.getNumerator()).append("/").append(simpleFractionBuildFractionMaxDenominator.getDenominator());
                return sb2.toString();
            }
            if (simpleFractionBuildFractionMaxDenominator.getNumerator() == 0) {
                sb2.append(Integer.toString((int) dFloor));
                return sb2.toString();
            }
            if (simpleFractionBuildFractionMaxDenominator.getNumerator() == simpleFractionBuildFractionMaxDenominator.getDenominator()) {
                sb2.append(Integer.toString(((int) dFloor) + 1));
                return sb2.toString();
            }
            if (dFloor > 0.0d) {
                sb2.append(Integer.toString((int) dFloor)).append(" ");
            }
            sb2.append(simpleFractionBuildFractionMaxDenominator.getNumerator()).append("/").append(simpleFractionBuildFractionMaxDenominator.getDenominator());
            return sb2.toString();
        } catch (RuntimeException e) {
            LOGGER.log(5, "Can't format fraction", e);
            return Double.toString(dDoubleValue);
        }
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return stringBuffer.append(format((Number) obj));
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new NotImplementedException("Reverse parsing not supported");
    }
}
