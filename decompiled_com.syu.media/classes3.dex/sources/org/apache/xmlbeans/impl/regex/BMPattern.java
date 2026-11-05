package org.apache.xmlbeans.impl.regex;

import java.text.CharacterIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class BMPattern {
    boolean ignoreCase;
    char[] pattern;
    int[] shiftTable;

    public BMPattern(String str, boolean z) {
        this(str, 256, z);
    }

    public BMPattern(String str, int i, boolean z) {
        char[] charArray = str.toCharArray();
        this.pattern = charArray;
        this.shiftTable = new int[i];
        this.ignoreCase = z;
        int length = charArray.length;
        int i2 = 0;
        while (true) {
            int[] iArr = this.shiftTable;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = length;
            i2++;
        }
        for (int i3 = 0; i3 < length; i3++) {
            char c = this.pattern[i3];
            int i4 = (length - i3) - 1;
            int[] iArr2 = this.shiftTable;
            int length2 = c % iArr2.length;
            if (i4 < iArr2[length2]) {
                iArr2[length2] = i4;
            }
            if (this.ignoreCase) {
                char upperCase = Character.toUpperCase(c);
                int[] iArr3 = this.shiftTable;
                int length3 = upperCase % iArr3.length;
                if (i4 < iArr3[length3]) {
                    iArr3[length3] = i4;
                }
                char lowerCase = Character.toLowerCase(upperCase);
                int[] iArr4 = this.shiftTable;
                int length4 = lowerCase % iArr4.length;
                if (i4 < iArr4[length4]) {
                    iArr4[length4] = i4;
                }
            }
        }
    }

    public int matches(CharacterIterator characterIterator, int i, int i2) {
        char index;
        if (this.ignoreCase) {
            return matchesIgnoreCase(characterIterator, i, i2);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i;
        }
        int i3 = i + length;
        while (i3 <= i2) {
            int i4 = i3 + 1;
            int i5 = length;
            do {
                i3--;
                index = characterIterator.setIndex(i3);
                i5--;
                if (index != this.pattern[i5]) {
                    break;
                }
                if (i5 == 0) {
                    return i3;
                }
            } while (i5 > 0);
            int[] iArr = this.shiftTable;
            i3 += iArr[index % iArr.length] + 1;
            if (i3 < i4) {
                i3 = i4;
            }
        }
        return -1;
    }

    public int matches(String str, int i, int i2) {
        char cCharAt;
        if (this.ignoreCase) {
            return matchesIgnoreCase(str, i, i2);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i;
        }
        int i3 = i + length;
        while (i3 <= i2) {
            int i4 = i3 + 1;
            int i5 = length;
            do {
                i3--;
                cCharAt = str.charAt(i3);
                i5--;
                if (cCharAt != this.pattern[i5]) {
                    break;
                }
                if (i5 == 0) {
                    return i3;
                }
            } while (i5 > 0);
            int[] iArr = this.shiftTable;
            i3 += iArr[cCharAt % iArr.length] + 1;
            if (i3 < i4) {
                i3 = i4;
            }
        }
        return -1;
    }

    public int matches(char[] cArr, int i, int i2) {
        char c;
        if (this.ignoreCase) {
            return matchesIgnoreCase(cArr, i, i2);
        }
        int length = this.pattern.length;
        if (length == 0) {
            return i;
        }
        int i3 = i + length;
        while (i3 <= i2) {
            int i4 = i3 + 1;
            int i5 = length;
            do {
                i3--;
                c = cArr[i3];
                i5--;
                if (c != this.pattern[i5]) {
                    break;
                }
                if (i5 == 0) {
                    return i3;
                }
            } while (i5 > 0);
            int[] iArr = this.shiftTable;
            i3 += iArr[c % iArr.length] + 1;
            if (i3 < i4) {
                i3 = i4;
            }
        }
        return -1;
    }

    int matchesIgnoreCase(CharacterIterator characterIterator, int i, int i2) {
        char index;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i;
        }
        int i3 = i + length;
        while (i3 <= i2) {
            int i4 = i3 + 1;
            int i5 = length;
            do {
                i3--;
                index = characterIterator.setIndex(i3);
                i5--;
                char c = this.pattern[i5];
                if (index != c && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(c)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i5 == 0) {
                    return i3;
                }
            } while (i5 > 0);
            int[] iArr = this.shiftTable;
            i3 += iArr[index % iArr.length] + 1;
            if (i3 < i4) {
                i3 = i4;
            }
        }
        return -1;
    }

    int matchesIgnoreCase(String str, int i, int i2) {
        char cCharAt;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i;
        }
        int i3 = i + length;
        while (i3 <= i2) {
            int i4 = i3 + 1;
            int i5 = length;
            do {
                i3--;
                cCharAt = str.charAt(i3);
                i5--;
                char c = this.pattern[i5];
                if (cCharAt != c && (upperCase = Character.toUpperCase(cCharAt)) != (upperCase2 = Character.toUpperCase(c)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i5 == 0) {
                    return i3;
                }
            } while (i5 > 0);
            int[] iArr = this.shiftTable;
            i3 += iArr[cCharAt % iArr.length] + 1;
            if (i3 < i4) {
                i3 = i4;
            }
        }
        return -1;
    }

    int matchesIgnoreCase(char[] cArr, int i, int i2) {
        char c;
        char upperCase;
        char upperCase2;
        int length = this.pattern.length;
        if (length == 0) {
            return i;
        }
        int i3 = i + length;
        while (i3 <= i2) {
            int i4 = i3 + 1;
            int i5 = length;
            do {
                i3--;
                c = cArr[i3];
                i5--;
                char c2 = this.pattern[i5];
                if (c != c2 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    break;
                }
                if (i5 == 0) {
                    return i3;
                }
            } while (i5 > 0);
            int[] iArr = this.shiftTable;
            i3 += iArr[c % iArr.length] + 1;
            if (i3 < i4) {
                i3 = i4;
            }
        }
        return -1;
    }
}
