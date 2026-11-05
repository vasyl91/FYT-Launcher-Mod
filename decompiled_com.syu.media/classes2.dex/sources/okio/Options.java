package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.UByte;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
        }
        if (((ByteString) arrayList.get(0)).size() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            ByteString byteString = (ByteString) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                ByteString byteString2 = (ByteString) arrayList.get(i5);
                if (!byteString2.startsWith(byteString)) {
                    break;
                }
                if (byteString2.size() == byteString.size()) {
                    throw new IllegalArgumentException("duplicate option: " + byteString2);
                }
                if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                    arrayList.remove(i5);
                    arrayList2.remove(i5);
                } else {
                    i5++;
                }
            }
            i3 = i4;
        }
        Buffer buffer = new Buffer();
        buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iIntCount = intCount(buffer);
        int[] iArr = new int[iIntCount];
        for (int i6 = 0; i6 < iIntCount; i6++) {
            iArr[i6] = buffer.readInt();
        }
        if (!buffer.exhausted()) {
            throw new AssertionError();
        }
        return new Options((ByteString[]) byteStringArr.clone(), iArr);
    }

    private static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int iIntValue;
        int i4;
        int i5;
        int i6;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i7 = i2; i7 < i3; i7++) {
            if (list.get(i7).size() < i) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i2);
        ByteString byteString2 = list.get(i3 - 1);
        if (i == byteString.size()) {
            int i8 = i2 + 1;
            i4 = i8;
            iIntValue = list2.get(i2).intValue();
            byteString = list.get(i8);
        } else {
            iIntValue = -1;
            i4 = i2;
        }
        if (byteString.getByte(i) != byteString2.getByte(i)) {
            int i9 = 1;
            for (int i10 = i4 + 1; i10 < i3; i10++) {
                if (list.get(i10 - 1).getByte(i) != list.get(i10).getByte(i)) {
                    i9++;
                }
            }
            long jIntCount = j + ((long) intCount(buffer)) + 2 + ((long) (i9 * 2));
            buffer.writeInt(i9);
            buffer.writeInt(iIntValue);
            for (int i11 = i4; i11 < i3; i11++) {
                byte b = list.get(i11).getByte(i);
                if (i11 == i4 || b != list.get(i11 - 1).getByte(i)) {
                    buffer.writeInt(b & UByte.MAX_VALUE);
                }
            }
            Buffer buffer2 = new Buffer();
            int i12 = i4;
            while (i12 < i3) {
                byte b2 = list.get(i12).getByte(i);
                int i13 = i12 + 1;
                int i14 = i13;
                while (true) {
                    if (i14 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (b2 != list.get(i14).getByte(i)) {
                            i6 = i14;
                            break;
                        }
                        i14++;
                    }
                }
                if (i13 == i6 && i + 1 == list.get(i12).size()) {
                    buffer.writeInt(list2.get(i12).intValue());
                } else {
                    buffer.writeInt((int) ((((long) intCount(buffer2)) + jIntCount) * (-1)));
                    buildTrieRecursive(jIntCount, buffer2, i + 1, list, i12, i6, list2);
                }
                buffer2 = buffer2;
                i12 = i6;
            }
            Buffer buffer3 = buffer2;
            buffer.write(buffer3, buffer3.size());
            return;
        }
        int iMin = Math.min(byteString.size(), byteString2.size());
        int i15 = 0;
        for (int i16 = i; i16 < iMin && byteString.getByte(i16) == byteString2.getByte(i16); i16++) {
            i15++;
        }
        long jIntCount2 = 1 + j + ((long) intCount(buffer)) + 2 + ((long) i15);
        buffer.writeInt(-i15);
        buffer.writeInt(iIntValue);
        int i17 = i;
        while (true) {
            i5 = i + i15;
            if (i17 >= i5) {
                break;
            }
            buffer.writeInt(byteString.getByte(i17) & UByte.MAX_VALUE);
            i17++;
        }
        if (i4 + 1 == i3) {
            if (i5 != list.get(i4).size()) {
                throw new AssertionError();
            }
            buffer.writeInt(list2.get(i4).intValue());
        } else {
            Buffer buffer4 = new Buffer();
            buffer.writeInt((int) ((((long) intCount(buffer4)) + jIntCount2) * (-1)));
            buildTrieRecursive(jIntCount2, buffer4, i5, list, i4, i3, list2);
            buffer.write(buffer4, buffer4.size());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
