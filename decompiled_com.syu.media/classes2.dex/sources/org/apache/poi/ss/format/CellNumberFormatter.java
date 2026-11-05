package org.apache.poi.ss.format;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CellNumberFormatter extends CellFormatter {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) CellNumberFormatter.class);
    private final CellFormatter SIMPLE_NUMBER;
    private final Special afterFractional;
    private final Special afterInteger;
    private final DecimalFormat decimalFmt;
    private final Special decimalPoint;
    private final String denominatorFmt;
    private final List<Special> denominatorSpecials;
    private final String desc;
    private final Special exponent;
    private final List<Special> exponentDigitSpecials;
    private final List<Special> exponentSpecials;
    private final List<Special> fractionalSpecials;
    private final boolean improperFraction;
    private final List<Special> integerSpecials;
    private final int maxDenominator;
    private final Special numerator;
    private final String numeratorFmt;
    private final List<Special> numeratorSpecials;
    private final String printfFmt;
    private final double scale;
    private final boolean showGroupingSeparator;
    private final Special slash;
    private final List<Special> specials;

    private static class GeneralNumberFormatter extends CellFormatter {
        private GeneralNumberFormatter(Locale locale) {
            super(locale, "General");
        }

        @Override // org.apache.poi.ss.format.CellFormatter
        public void formatValue(StringBuffer stringBuffer, Object obj) {
            CellFormatter cellNumberFormatter;
            if (obj == null) {
                return;
            }
            if (obj instanceof Number) {
                cellNumberFormatter = ((Number) obj).doubleValue() % 1.0d == 0.0d ? new CellNumberFormatter(this.locale, "#") : new CellNumberFormatter(this.locale, "#.#");
            } else {
                cellNumberFormatter = CellTextFormatter.SIMPLE_TEXT;
            }
            cellNumberFormatter.formatValue(stringBuffer, obj);
        }

        @Override // org.apache.poi.ss.format.CellFormatter
        public void simpleValue(StringBuffer stringBuffer, Object obj) {
            formatValue(stringBuffer, obj);
        }
    }

    static class Special {
        final char ch;
        int pos;

        Special(char c, int i) {
            this.ch = c;
            this.pos = i;
        }

        public String toString() {
            return "'" + this.ch + "' @ " + this.pos;
        }
    }

    public CellNumberFormatter(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    public CellNumberFormatter(Locale locale, String str) {
        int i;
        super(locale, str);
        ArrayList arrayList = new ArrayList();
        this.specials = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.integerSpecials = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.fractionalSpecials = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.numeratorSpecials = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.denominatorSpecials = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        this.exponentSpecials = arrayList6;
        ArrayList arrayList7 = new ArrayList();
        this.exponentDigitSpecials = arrayList7;
        this.SIMPLE_NUMBER = new GeneralNumberFormatter(this.locale);
        CellNumberPartHandler cellNumberPartHandler = new CellNumberPartHandler();
        StringBuffer format = CellFormatPart.parseFormat(str, CellFormatType.NUMBER, cellNumberPartHandler);
        Special exponent = cellNumberPartHandler.getExponent();
        this.exponent = exponent;
        arrayList.addAll(cellNumberPartHandler.getSpecials());
        this.improperFraction = cellNumberPartHandler.isImproperFraction();
        if ((cellNumberPartHandler.getDecimalPoint() != null || cellNumberPartHandler.getExponent() != null) && cellNumberPartHandler.getSlash() != null) {
            this.slash = null;
            this.numerator = null;
        } else {
            this.slash = cellNumberPartHandler.getSlash();
            this.numerator = cellNumberPartHandler.getNumerator();
        }
        int iInterpretPrecision = interpretPrecision(cellNumberPartHandler.getDecimalPoint(), arrayList);
        if (cellNumberPartHandler.getDecimalPoint() != null) {
            int i2 = iInterpretPrecision + 1;
            if (iInterpretPrecision == 0) {
                arrayList.remove(cellNumberPartHandler.getDecimalPoint());
                this.decimalPoint = null;
            } else {
                this.decimalPoint = cellNumberPartHandler.getDecimalPoint();
            }
            i = i2;
        } else {
            this.decimalPoint = null;
            i = 0;
        }
        Special special = this.decimalPoint;
        if (special != null) {
            this.afterInteger = special;
        } else if (exponent != null) {
            this.afterInteger = exponent;
        } else {
            Special special2 = this.numerator;
            if (special2 != null) {
                this.afterInteger = special2;
            } else {
                this.afterInteger = null;
            }
        }
        if (exponent != null) {
            this.afterFractional = exponent;
        } else {
            Special special3 = this.numerator;
            if (special3 != null) {
                this.afterFractional = special3;
            } else {
                this.afterFractional = null;
            }
        }
        double[] dArr = {cellNumberPartHandler.getScale()};
        this.showGroupingSeparator = interpretIntegerCommas(format, arrayList, this.decimalPoint, integerEnd(), fractionalEnd(), dArr);
        if (exponent == null) {
            this.scale = dArr[0];
        } else {
            this.scale = 1.0d;
        }
        if (iInterpretPrecision != 0) {
            arrayList3.addAll(arrayList.subList(arrayList.indexOf(this.decimalPoint) + 1, fractionalEnd()));
        }
        if (exponent != null) {
            int iIndexOf = arrayList.indexOf(exponent);
            arrayList6.addAll(specialsFor(iIndexOf, 2));
            arrayList7.addAll(specialsFor(iIndexOf + 2));
        }
        if (this.slash != null) {
            Special special4 = this.numerator;
            if (special4 != null) {
                arrayList4.addAll(specialsFor(arrayList.indexOf(special4)));
            }
            arrayList5.addAll(specialsFor(arrayList.indexOf(this.slash) + 1));
            if (arrayList5.isEmpty()) {
                arrayList4.clear();
                this.maxDenominator = 1;
                this.numeratorFmt = null;
                this.denominatorFmt = null;
            } else {
                this.maxDenominator = maxValue(arrayList5);
                this.numeratorFmt = singleNumberFormat(arrayList4);
                this.denominatorFmt = singleNumberFormat(arrayList5);
            }
        } else {
            this.maxDenominator = 1;
            this.numeratorFmt = null;
            this.denominatorFmt = null;
        }
        arrayList2.addAll(arrayList.subList(0, integerEnd()));
        if (exponent == null) {
            StringBuffer stringBuffer = new StringBuffer("%0");
            stringBuffer.append(calculateIntegerPartWidth() + i).append('.').append(iInterpretPrecision);
            stringBuffer.append("f");
            this.printfFmt = stringBuffer.toString();
            this.decimalFmt = null;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            boolean z = true;
            if (arrayList2.size() == 1) {
                stringBuffer2.append("0");
                z = false;
            } else {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (isDigitFmt((Special) it.next())) {
                        stringBuffer2.append(z ? '#' : '0');
                        z = false;
                    }
                }
            }
            if (this.fractionalSpecials.size() > 0) {
                stringBuffer2.append('.');
                Iterator<Special> it2 = this.fractionalSpecials.iterator();
                while (it2.hasNext()) {
                    if (isDigitFmt(it2.next())) {
                        if (!z) {
                            stringBuffer2.append('0');
                        }
                        z = false;
                    }
                }
            }
            stringBuffer2.append('E');
            List<Special> list = this.exponentSpecials;
            placeZeros(stringBuffer2, list.subList(2, list.size()));
            this.decimalFmt = new DecimalFormat(stringBuffer2.toString(), getDecimalFormatSymbols());
            this.printfFmt = null;
        }
        this.desc = format.toString();
    }

    private DecimalFormatSymbols getDecimalFormatSymbols() {
        return DecimalFormatSymbols.getInstance(this.locale);
    }

    private static void placeZeros(StringBuffer stringBuffer, List<Special> list) {
        Iterator<Special> it = list.iterator();
        while (it.hasNext()) {
            if (isDigitFmt(it.next())) {
                stringBuffer.append('0');
            }
        }
    }

    private static CellNumberStringMod insertMod(Special special, CharSequence charSequence, int i) {
        return new CellNumberStringMod(special, charSequence, i);
    }

    private static CellNumberStringMod deleteMod(Special special, boolean z, Special special2, boolean z2) {
        return new CellNumberStringMod(special, z, special2, z2);
    }

    private static CellNumberStringMod replaceMod(Special special, boolean z, Special special2, boolean z2, char c) {
        return new CellNumberStringMod(special, z, special2, z2, c);
    }

    private static String singleNumberFormat(List<Special> list) {
        return "%0" + list.size() + "d";
    }

    private static int maxValue(List<Special> list) {
        return (int) Math.round(Math.pow(10.0d, list.size()) - 1.0d);
    }

    private List<Special> specialsFor(int i, int i2) {
        if (i >= this.specials.size()) {
            return Collections.emptyList();
        }
        int i3 = i2 + i;
        ListIterator<Special> listIterator = this.specials.listIterator(i3);
        Special next = listIterator.next();
        while (listIterator.hasNext()) {
            Special next2 = listIterator.next();
            if (!isDigitFmt(next2) || next2.pos - next.pos > 1) {
                break;
            }
            i3++;
            next = next2;
        }
        return this.specials.subList(i, i3 + 1);
    }

    private List<Special> specialsFor(int i) {
        return specialsFor(i, 0);
    }

    private static boolean isDigitFmt(Special special) {
        return special.ch == '0' || special.ch == '?' || special.ch == '#';
    }

    private int calculateIntegerPartWidth() {
        Special next;
        Iterator<Special> it = this.specials.iterator();
        int i = 0;
        while (it.hasNext() && (next = it.next()) != this.afterInteger) {
            if (isDigitFmt(next)) {
                i++;
            }
        }
        return i;
    }

    private static int interpretPrecision(Special special, List<Special> list) {
        int iIndexOf = list.indexOf(special);
        int i = 0;
        if (iIndexOf != -1) {
            ListIterator<Special> listIterator = list.listIterator(iIndexOf + 1);
            while (listIterator.hasNext() && isDigitFmt(listIterator.next())) {
                i++;
            }
        }
        return i;
    }

    private static boolean interpretIntegerCommas(StringBuffer stringBuffer, List<Special> list, Special special, int i, int i2, double[] dArr) {
        ListIterator<Special> listIterator = list.listIterator(i);
        int i3 = 0;
        boolean z = true;
        boolean z2 = false;
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().ch != ',') {
                z = false;
            } else if (z) {
                dArr[0] = dArr[0] / 1000.0d;
            } else {
                z2 = true;
            }
        }
        if (special != null) {
            ListIterator<Special> listIterator2 = list.listIterator(i2);
            while (listIterator2.hasPrevious() && listIterator2.previous().ch == ',') {
                dArr[0] = dArr[0] / 1000.0d;
            }
        }
        ListIterator<Special> listIterator3 = list.listIterator();
        while (listIterator3.hasNext()) {
            Special next = listIterator3.next();
            next.pos -= i3;
            if (next.ch == ',') {
                i3++;
                listIterator3.remove();
                stringBuffer.deleteCharAt(next.pos);
            }
        }
        return z2;
    }

    private int integerEnd() {
        Special special = this.afterInteger;
        return special == null ? this.specials.size() : this.specials.indexOf(special);
    }

    private int fractionalEnd() {
        Special special = this.afterFractional;
        return special == null ? this.specials.size() : this.specials.indexOf(special);
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        double d;
        double d2;
        Iterator<Special> it;
        boolean z;
        double dDoubleValue = ((Number) obj).doubleValue() * this.scale;
        double d3 = 0.0d;
        boolean z2 = false;
        int i = 1;
        boolean z3 = dDoubleValue < 0.0d;
        if (z3) {
            dDoubleValue = -dDoubleValue;
        }
        if (this.slash == null) {
            d = d3;
            d2 = dDoubleValue;
        } else if (this.improperFraction) {
            d = dDoubleValue;
            d2 = 0.0d;
        } else {
            d3 = dDoubleValue % 1.0d;
            dDoubleValue = (long) dDoubleValue;
            d = d3;
            d2 = dDoubleValue;
        }
        TreeSet treeSet = new TreeSet();
        StringBuffer stringBuffer2 = new StringBuffer(localiseFormat(this.desc));
        if (this.exponent != null) {
            writeScientific(d2, stringBuffer2, treeSet);
        } else if (this.improperFraction) {
            writeFraction(d2, null, d, stringBuffer2, treeSet);
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            Formatter formatter = new Formatter(stringBuffer3, this.locale);
            try {
                formatter.format(this.locale, this.printfFmt, Double.valueOf(d2));
                formatter.close();
                if (this.numerator == null) {
                    writeFractional(stringBuffer3, stringBuffer2);
                    writeInteger(stringBuffer3, stringBuffer2, this.integerSpecials, treeSet, this.showGroupingSeparator);
                } else {
                    writeFraction(d2, stringBuffer3, d, stringBuffer2, treeSet);
                }
            } catch (Throwable th) {
                formatter.close();
                throw th;
            }
        }
        String string = Character.toString(getDecimalFormatSymbols().getGroupingSeparator());
        Iterator<CellNumberStringMod> it2 = treeSet.iterator();
        CellNumberStringMod next = it2.hasNext() ? it2.next() : null;
        BitSet bitSet = new BitSet();
        Iterator<Special> it3 = this.specials.iterator();
        int length = 0;
        while (it3.hasNext()) {
            Special next2 = it3.next();
            int i2 = next2.pos + length;
            if (!bitSet.get(next2.pos) && stringBuffer2.charAt(i2) == '#') {
                stringBuffer2.deleteCharAt(i2);
                length--;
                bitSet.set(next2.pos);
            }
            while (next != null && next2 == next.getSpecial()) {
                int length2 = stringBuffer2.length();
                int i3 = next2.pos + length;
                int op = next.getOp();
                if (op == i) {
                    it = it3;
                    z = z2;
                    stringBuffer2.insert(i3, next.getToAdd());
                } else if (op == 2) {
                    it = it3;
                    z = z2;
                    if (!next.getToAdd().equals(string) || !bitSet.get(next2.pos)) {
                        stringBuffer2.insert(i3 + 1, next.getToAdd());
                    }
                } else if (op == 3) {
                    int i4 = next2.pos;
                    if (!next.isStartInclusive()) {
                        i4++;
                        i3++;
                    }
                    while (bitSet.get(i4)) {
                        i4++;
                        i3++;
                    }
                    int i5 = next.getEnd().pos;
                    if (next.isEndInclusive()) {
                        i5++;
                    }
                    int i6 = i5 + length;
                    it = it3;
                    if (i3 < i6) {
                        if ("".equals(next.getToAdd())) {
                            stringBuffer2.delete(i3, i6);
                            z = false;
                        } else {
                            z = false;
                            char cCharAt = next.getToAdd().charAt(0);
                            while (i3 < i6) {
                                stringBuffer2.setCharAt(i3, cCharAt);
                                i3++;
                            }
                        }
                        bitSet.set(i4, i5);
                    } else {
                        z = false;
                    }
                } else {
                    throw new IllegalStateException("Unknown op: " + next.getOp());
                }
                length += stringBuffer2.length() - length2;
                next = it2.hasNext() ? it2.next() : null;
                z2 = z;
                it3 = it;
                i = 1;
            }
            z2 = z2;
            it3 = it3;
            i = 1;
        }
        if (z3) {
            stringBuffer.append('-');
        }
        stringBuffer.append(stringBuffer2);
    }

    private void writeScientific(double d, StringBuffer stringBuffer, Set<CellNumberStringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(1);
        this.decimalFmt.format(d, stringBuffer2, fieldPosition);
        writeInteger(stringBuffer2, stringBuffer, this.integerSpecials, set, this.showGroupingSeparator);
        writeFractional(stringBuffer2, stringBuffer);
        int endIndex = fieldPosition.getEndIndex() + 1;
        char cCharAt = stringBuffer2.charAt(endIndex);
        if (cCharAt != '-') {
            stringBuffer2.insert(endIndex, '+');
            cCharAt = '+';
        }
        Special next = this.exponentSpecials.listIterator(1).next();
        char c = next.ch;
        if (cCharAt == '-' || c == '+') {
            set.add(replaceMod(next, true, next, true, cCharAt));
        } else {
            set.add(deleteMod(next, true, next, true));
        }
        writeInteger(new StringBuffer(stringBuffer2.substring(endIndex + 1)), stringBuffer, this.exponentDigitSpecials, set, false);
    }

    private void writeFraction(double d, StringBuffer stringBuffer, double d2, StringBuffer stringBuffer2, Set<CellNumberStringMod> set) {
        int numerator;
        int denominator;
        if (!this.improperFraction) {
            if (d2 == 0.0d && !hasChar('0', this.numeratorSpecials)) {
                writeInteger(stringBuffer, stringBuffer2, this.integerSpecials, set, false);
                Special specialLastSpecial = lastSpecial(this.integerSpecials);
                Special specialLastSpecial2 = lastSpecial(this.denominatorSpecials);
                if (hasChar('?', this.integerSpecials, this.numeratorSpecials, this.denominatorSpecials)) {
                    set.add(replaceMod(specialLastSpecial, false, specialLastSpecial2, true, ' '));
                    return;
                } else {
                    set.add(deleteMod(specialLastSpecial, false, specialLastSpecial2, true));
                    return;
                }
            }
            boolean z = !hasChar('0', this.numeratorSpecials);
            boolean z2 = !hasChar('0', this.integerSpecials);
            boolean z3 = d2 == 0.0d && ((this.integerSpecials.isEmpty() || (this.integerSpecials.size() == 1 && hasChar('#', this.integerSpecials))) || z);
            boolean z4 = d2 != 0.0d && z2;
            if (d == 0.0d && (z3 || z4)) {
                Special specialLastSpecial3 = lastSpecial(this.integerSpecials);
                set.add(hasChar('?', this.integerSpecials, this.numeratorSpecials) ? replaceMod(specialLastSpecial3, true, this.numerator, false, ' ') : deleteMod(specialLastSpecial3, true, this.numerator, false));
            } else {
                writeInteger(stringBuffer, stringBuffer2, this.integerSpecials, set, false);
            }
        }
        if (d2 != 0.0d) {
            try {
                if (this.improperFraction && d2 % 1.0d == 0.0d) {
                    numerator = (int) Math.round(d2);
                    denominator = 1;
                } else {
                    SimpleFraction simpleFractionBuildFractionMaxDenominator = SimpleFraction.buildFractionMaxDenominator(d2, this.maxDenominator);
                    numerator = simpleFractionBuildFractionMaxDenominator.getNumerator();
                    denominator = simpleFractionBuildFractionMaxDenominator.getDenominator();
                }
            } catch (RuntimeException e) {
                LOG.log(7, "error while fraction evaluation", e);
                return;
            }
        } else {
            numerator = (int) Math.round(d2);
            denominator = 1;
        }
        writeSingleInteger(this.numeratorFmt, this.improperFraction ? (int) (((long) numerator) + Math.round(((double) denominator) * d)) : numerator, stringBuffer2, this.numeratorSpecials, set);
        writeSingleInteger(this.denominatorFmt, denominator, stringBuffer2, this.denominatorSpecials, set);
    }

    private String localiseFormat(String str) {
        DecimalFormatSymbols decimalFormatSymbols = getDecimalFormatSymbols();
        if (!str.contains(",") || decimalFormatSymbols.getGroupingSeparator() == ',') {
            return (!str.contains(".") || decimalFormatSymbols.getDecimalSeparator() == '.') ? str : str.replace('.', decimalFormatSymbols.getDecimalSeparator());
        }
        if (str.contains(".") && decimalFormatSymbols.getDecimalSeparator() != '.') {
            return replaceLast(str, "\\.", "[DECIMAL_SEPARATOR]").replace(',', decimalFormatSymbols.getGroupingSeparator()).replace("[DECIMAL_SEPARATOR]", Character.toString(decimalFormatSymbols.getDecimalSeparator()));
        }
        return str.replace(',', decimalFormatSymbols.getGroupingSeparator());
    }

    private static String replaceLast(String str, String str2, String str3) {
        return str.replaceFirst("(?s)(.*)" + str2, "$1" + str3);
    }

    private static boolean hasChar(char c, List<Special>... listArr) {
        for (List<Special> list : listArr) {
            Iterator<Special> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().ch == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private void writeSingleInteger(String str, int i, StringBuffer stringBuffer, List<Special> list, Set<CellNumberStringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        Formatter formatter = new Formatter(stringBuffer2, this.locale);
        try {
            formatter.format(this.locale, str, Integer.valueOf(i));
            formatter.close();
            writeInteger(stringBuffer2, stringBuffer, list, set, false);
        } catch (Throwable th) {
            formatter.close();
            throw th;
        }
    }

    private void writeInteger(StringBuffer stringBuffer, StringBuffer stringBuffer2, List<Special> list, Set<CellNumberStringMod> set, boolean z) {
        boolean z2;
        Special special;
        char cCharAt;
        int length;
        DecimalFormatSymbols decimalFormatSymbols = getDecimalFormatSymbols();
        String string = Character.toString(decimalFormatSymbols.getDecimalSeparator());
        String string2 = Character.toString(decimalFormatSymbols.getGroupingSeparator());
        int iIndexOf = stringBuffer.indexOf(string) - 1;
        if (iIndexOf < 0) {
            if (this.exponent != null && list == this.integerSpecials) {
                length = stringBuffer.indexOf("E");
            } else {
                length = stringBuffer.length();
            }
            iIndexOf = length - 1;
        }
        int i = 0;
        while (i < iIndexOf && ((cCharAt = stringBuffer.charAt(i)) == '0' || cCharAt == decimalFormatSymbols.getGroupingSeparator())) {
            i++;
        }
        ListIterator<Special> listIterator = list.listIterator(list.size());
        Special special2 = null;
        int i2 = 0;
        while (listIterator.hasPrevious()) {
            char cCharAt2 = iIndexOf >= 0 ? stringBuffer.charAt(iIndexOf) : '0';
            Special specialPrevious = listIterator.previous();
            boolean z3 = z && i2 > 0 && i2 % 3 == 0;
            if (cCharAt2 != '0' || specialPrevious.ch == '0' || specialPrevious.ch == '?' || iIndexOf >= i) {
                z2 = specialPrevious.ch == '?' && iIndexOf < i;
                int i3 = specialPrevious.pos;
                if (z2) {
                    cCharAt2 = ' ';
                }
                stringBuffer2.setCharAt(i3, cCharAt2);
                special = specialPrevious;
            } else {
                special = special2;
                z2 = false;
            }
            if (z3) {
                set.add(insertMod(specialPrevious, z2 ? " " : string2, 2));
            }
            i2++;
            iIndexOf--;
            special2 = special;
        }
        if (iIndexOf >= 0) {
            int i4 = iIndexOf + 1;
            StringBuffer stringBuffer3 = new StringBuffer(stringBuffer.substring(0, i4));
            if (z) {
                while (i4 > 0) {
                    if (i2 > 0 && i2 % 3 == 0) {
                        stringBuffer3.insert(i4, string2);
                    }
                    i2++;
                    i4--;
                }
            }
            set.add(insertMod(special2, stringBuffer3, 1));
        }
    }

    private void writeFractional(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        int length;
        if (this.fractionalSpecials.size() > 0) {
            int iIndexOf = stringBuffer.indexOf(Character.toString(getDecimalFormatSymbols().getDecimalSeparator())) + 1;
            if (this.exponent != null) {
                length = stringBuffer.indexOf("e");
            } else {
                length = stringBuffer.length();
            }
            do {
                length--;
                if (length <= iIndexOf) {
                    break;
                }
            } while (stringBuffer.charAt(length) == '0');
            for (Special special : this.fractionalSpecials) {
                char cCharAt = stringBuffer.charAt(iIndexOf);
                if (cCharAt != '0' || special.ch == '0' || iIndexOf < length) {
                    stringBuffer2.setCharAt(special.pos, cCharAt);
                } else if (special.ch == '?') {
                    stringBuffer2.setCharAt(special.pos, ' ');
                }
                iIndexOf++;
            }
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        this.SIMPLE_NUMBER.formatValue(stringBuffer, obj);
    }

    private static Special lastSpecial(List<Special> list) {
        return list.get(list.size() - 1);
    }
}
