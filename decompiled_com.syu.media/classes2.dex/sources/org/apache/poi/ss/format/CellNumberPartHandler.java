package org.apache.poi.ss.format;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class CellNumberPartHandler implements CellFormatPart.PartHandler {
    private CellNumberFormatter.Special decimalPoint;
    private CellNumberFormatter.Special exponent;
    private boolean improperFraction;
    private char insertSignForExponent;
    private CellNumberFormatter.Special numerator;
    private CellNumberFormatter.Special slash;
    private double scale = 1.0d;
    private final List<CellNumberFormatter.Special> specials = new LinkedList();

    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:37:0x009b  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b6 A[LOOP:0: B:38:0x00b0->B:40:0x00b6, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
    public String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        char cCharAt = str.charAt(0);
        if (cCharAt == '#') {
            if (this.insertSignForExponent != 0) {
                this.specials.add(new CellNumberFormatter.Special(this.insertSignForExponent, length));
                stringBuffer.append(this.insertSignForExponent);
                this.insertSignForExponent = (char) 0;
                length++;
            }
            for (int i = 0; i < str.length(); i++) {
                this.specials.add(new CellNumberFormatter.Special(str.charAt(i), length + i));
            }
        } else if (cCharAt == '%') {
            this.scale *= 100.0d;
        } else if (cCharAt == '?') {
            if (this.insertSignForExponent != 0) {
                this.specials.add(new CellNumberFormatter.Special(this.insertSignForExponent, length));
                stringBuffer.append(this.insertSignForExponent);
                this.insertSignForExponent = (char) 0;
                length++;
            }
            while (i < str.length()) {
                this.specials.add(new CellNumberFormatter.Special(str.charAt(i), length + i));
            }
        } else if (cCharAt == 'E' || cCharAt == 'e') {
            if (this.exponent == null && this.specials.size() > 0) {
                CellNumberFormatter.Special special = new CellNumberFormatter.Special('.', length);
                this.exponent = special;
                this.specials.add(special);
                this.insertSignForExponent = str.charAt(1);
                return str.substring(0, 1);
            }
        } else {
            switch (cCharAt) {
                case '.':
                    if (this.decimalPoint == null && this.specials.size() > 0) {
                        CellNumberFormatter.Special special2 = new CellNumberFormatter.Special('.', length);
                        this.decimalPoint = special2;
                        this.specials.add(special2);
                    }
                    break;
                case '/':
                    if (this.slash == null && this.specials.size() > 0) {
                        CellNumberFormatter.Special specialPreviousNumber = previousNumber();
                        this.numerator = specialPreviousNumber;
                        this.improperFraction = (specialPreviousNumber == firstDigit(this.specials) ? 1 : 0) | (this.improperFraction ? 1 : 0);
                        CellNumberFormatter.Special special3 = new CellNumberFormatter.Special('.', length);
                        this.slash = special3;
                        this.specials.add(special3);
                    }
                    break;
                case '0':
                    if (this.insertSignForExponent != 0) {
                        this.specials.add(new CellNumberFormatter.Special(this.insertSignForExponent, length));
                        stringBuffer.append(this.insertSignForExponent);
                        this.insertSignForExponent = (char) 0;
                        length++;
                    }
                    while (i < str.length()) {
                        this.specials.add(new CellNumberFormatter.Special(str.charAt(i), length + i));
                    }
                    break;
                default:
                    return null;
            }
        }
        return str;
    }

    public double getScale() {
        return this.scale;
    }

    public CellNumberFormatter.Special getDecimalPoint() {
        return this.decimalPoint;
    }

    public CellNumberFormatter.Special getSlash() {
        return this.slash;
    }

    public CellNumberFormatter.Special getExponent() {
        return this.exponent;
    }

    public CellNumberFormatter.Special getNumerator() {
        return this.numerator;
    }

    public List<CellNumberFormatter.Special> getSpecials() {
        return this.specials;
    }

    public boolean isImproperFraction() {
        return this.improperFraction;
    }

    private CellNumberFormatter.Special previousNumber() {
        List<CellNumberFormatter.Special> list = this.specials;
        ListIterator<CellNumberFormatter.Special> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            CellNumberFormatter.Special specialPrevious = listIterator.previous();
            if (isDigitFmt(specialPrevious)) {
                while (listIterator.hasPrevious()) {
                    CellNumberFormatter.Special specialPrevious2 = listIterator.previous();
                    if (specialPrevious.pos - specialPrevious2.pos > 1 || !isDigitFmt(specialPrevious2)) {
                        break;
                    }
                    specialPrevious = specialPrevious2;
                }
                return specialPrevious;
            }
        }
        return null;
    }

    private static boolean isDigitFmt(CellNumberFormatter.Special special) {
        return special.ch == '0' || special.ch == '?' || special.ch == '#';
    }

    private static CellNumberFormatter.Special firstDigit(List<CellNumberFormatter.Special> list) {
        for (CellNumberFormatter.Special special : list) {
            if (isDigitFmt(special)) {
                return special;
            }
        }
        return null;
    }
}
