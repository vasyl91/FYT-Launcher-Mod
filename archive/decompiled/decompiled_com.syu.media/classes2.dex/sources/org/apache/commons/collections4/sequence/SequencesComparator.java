package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SequencesComparator<T> {
    private final Equator<? super T> equator;
    private final List<T> sequence1;
    private final List<T> sequence2;
    private final int[] vDown;
    private final int[] vUp;

    public SequencesComparator(List<T> list, List<T> list2) {
        this(list, list2, DefaultEquator.defaultEquator());
    }

    public SequencesComparator(List<T> list, List<T> list2, Equator<? super T> equator) {
        this.sequence1 = list;
        this.sequence2 = list2;
        this.equator = equator;
        int size = list.size() + list2.size() + 2;
        this.vDown = new int[size];
        this.vUp = new int[size];
    }

    public EditScript<T> getScript() {
        EditScript<T> editScript = new EditScript<>();
        buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), editScript);
        return editScript;
    }

    private Snake buildSnake(int i, int i2, int i3, int i4) {
        int i5 = i;
        while (true) {
            int i6 = i5 - i2;
            if (i6 >= i4 || i5 >= i3 || !this.equator.equate(this.sequence1.get(i5), this.sequence2.get(i6))) {
                break;
            }
            i5++;
        }
        return new Snake(i, i5, i2);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    private Snake getMiddleSnake(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = i2 - i;
        int i9 = i4 - i3;
        if (i8 == 0 || i9 == 0) {
            return null;
        }
        int i10 = i8 - i9;
        int i11 = i9 + i8;
        if (i11 % 2 != 0) {
            i11++;
        }
        int i12 = i11 / 2;
        int i13 = i12 + 1;
        this.vDown[i13] = i;
        this.vUp[i13] = i2 + 1;
        for (int i14 = 0; i14 <= i12; i14++) {
            int i15 = -i14;
            for (int i16 = i15; i16 <= i14; i16 += 2) {
                int i17 = i16 + i12;
                if (i16 == i15) {
                    int[] iArr = this.vDown;
                    iArr[i17] = iArr[i17 + 1];
                } else {
                    if (i16 != i14) {
                        int[] iArr2 = this.vDown;
                        if (iArr2[i17 - 1] < iArr2[i17 + 1]) {
                            int[] iArr3 = this.vDown;
                            iArr3[i17] = iArr3[i17 + 1];
                        }
                    }
                    int[] iArr4 = this.vDown;
                    iArr4[i17] = iArr4[i17 - 1] + 1;
                }
                int i18 = this.vDown[i17];
                for (int i19 = ((i18 - i) + i3) - i16; i18 < i2 && i19 < i4 && this.equator.equate(this.sequence1.get(i18), this.sequence2.get(i19)); i19++) {
                    i18++;
                    this.vDown[i17] = i18;
                }
                if (i10 % 2 != 0 && i10 - i14 <= i16 && i16 <= i10 + i14 && (i7 = this.vUp[i17 - i10]) <= this.vDown[i17]) {
                    return buildSnake(i7, (i16 + i) - i3, i2, i4);
                }
            }
            int i20 = i10 - i14;
            int i21 = i20;
            while (true) {
                int i22 = i10 + i14;
                if (i21 <= i22) {
                    int i23 = (i21 + i12) - i10;
                    if (i21 == i20) {
                        int[] iArr5 = this.vUp;
                        iArr5[i23] = iArr5[i23 + 1] - 1;
                    } else {
                        if (i21 != i22) {
                            int[] iArr6 = this.vUp;
                            if (iArr6[i23 + 1] <= iArr6[i23 - 1]) {
                                int[] iArr7 = this.vUp;
                                iArr7[i23] = iArr7[i23 + 1] - 1;
                            }
                        }
                        int[] iArr8 = this.vUp;
                        iArr8[i23] = iArr8[i23 - 1];
                    }
                    int i24 = this.vUp[i23] - 1;
                    int i25 = ((i24 - i) + i3) - i21;
                    while (true) {
                        if (i24 < i || i25 < i3) {
                            i5 = i12;
                            break;
                        }
                        i5 = i12;
                        if (!this.equator.equate(this.sequence1.get(i24), this.sequence2.get(i25))) {
                            break;
                        }
                        this.vUp[i23] = i24;
                        i25--;
                        i24--;
                        i12 = i5;
                    }
                    if (i10 % 2 == 0 && i15 <= i21 && i21 <= i14 && (i6 = this.vUp[i23]) <= this.vDown[i23 + i10]) {
                        return buildSnake(i6, (i21 + i) - i3, i2, i4);
                    }
                    i21 += 2;
                    i12 = i5;
                }
            }
        }
        throw new RuntimeException("Internal Error");
    }

    private void buildScript(int i, int i2, int i3, int i4, EditScript<T> editScript) {
        Snake middleSnake = getMiddleSnake(i, i2, i3, i4);
        if (middleSnake != null && ((middleSnake.getStart() != i2 || middleSnake.getDiag() != i2 - i4) && (middleSnake.getEnd() != i || middleSnake.getDiag() != i - i3))) {
            buildScript(i, middleSnake.getStart(), i3, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(this.sequence1.get(start)));
            }
            buildScript(middleSnake.getEnd(), i2, middleSnake.getEnd() - middleSnake.getDiag(), i4, editScript);
            return;
        }
        int i5 = i;
        int i6 = i3;
        while (true) {
            if (i5 >= i2 && i6 >= i4) {
                return;
            }
            if (i5 < i2 && i6 < i4 && this.equator.equate(this.sequence1.get(i5), this.sequence2.get(i6))) {
                editScript.append(new KeepCommand<>(this.sequence1.get(i5)));
                i5++;
            } else if (i2 - i > i4 - i3) {
                editScript.append(new DeleteCommand<>(this.sequence1.get(i5)));
                i5++;
            } else {
                editScript.append(new InsertCommand<>(this.sequence2.get(i6)));
            }
            i6++;
        }
    }

    private static class Snake {
        private final int diag;
        private final int end;
        private final int start;

        public Snake(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.diag = i3;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

        public int getDiag() {
            return this.diag;
        }
    }
}
