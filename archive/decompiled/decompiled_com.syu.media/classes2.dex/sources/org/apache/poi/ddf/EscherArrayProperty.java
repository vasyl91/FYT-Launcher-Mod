package org.apache.poi.ddf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherArrayProperty extends EscherComplexProperty implements Iterable<byte[]> {
    private static final int FIXED_SIZE = 6;
    private boolean emptyComplexPart;
    private boolean sizeIncludesHeaderSize;

    private static int getActualSizeOfElements(short s) {
        return s < 0 ? (short) ((-s) >> 2) : s;
    }

    public EscherArrayProperty(short s, byte[] bArr) {
        super(s, checkComplexData(bArr));
        boolean z = true;
        this.sizeIncludesHeaderSize = true;
        if (bArr != null && bArr.length != 0) {
            z = false;
        }
        this.emptyComplexPart = z;
    }

    public EscherArrayProperty(short s, boolean z, byte[] bArr) {
        super(s, z, checkComplexData(bArr));
        this.sizeIncludesHeaderSize = true;
    }

    private static byte[] checkComplexData(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[6] : bArr;
    }

    public int getNumberOfElementsInArray() {
        if (this.emptyComplexPart) {
            return 0;
        }
        return LittleEndian.getUShort(getComplexData(), 0);
    }

    public void setNumberOfElementsInArray(int i) {
        int actualSizeOfElements = (getActualSizeOfElements(getSizeOfElements()) * i) + 6;
        if (actualSizeOfElements != getComplexData().length) {
            byte[] bArr = new byte[actualSizeOfElements];
            System.arraycopy(getComplexData(), 0, bArr, 0, getComplexData().length);
            setComplexData(bArr);
        }
        LittleEndian.putShort(getComplexData(), 0, (short) i);
    }

    public int getNumberOfElementsInMemory() {
        if (this.emptyComplexPart) {
            return 0;
        }
        return LittleEndian.getUShort(getComplexData(), 2);
    }

    public void setNumberOfElementsInMemory(int i) {
        int actualSizeOfElements = (getActualSizeOfElements(getSizeOfElements()) * i) + 6;
        if (actualSizeOfElements != getComplexData().length) {
            byte[] bArr = new byte[actualSizeOfElements];
            System.arraycopy(getComplexData(), 0, bArr, 0, actualSizeOfElements);
            setComplexData(bArr);
        }
        LittleEndian.putShort(getComplexData(), 2, (short) i);
    }

    public short getSizeOfElements() {
        if (this.emptyComplexPart) {
            return (short) 0;
        }
        return LittleEndian.getShort(getComplexData(), 4);
    }

    public void setSizeOfElements(int i) {
        LittleEndian.putShort(getComplexData(), 4, (short) i);
        int numberOfElementsInArray = (getNumberOfElementsInArray() * getActualSizeOfElements(getSizeOfElements())) + 6;
        if (numberOfElementsInArray != getComplexData().length) {
            byte[] bArr = new byte[numberOfElementsInArray];
            System.arraycopy(getComplexData(), 0, bArr, 0, 6);
            setComplexData(bArr);
        }
    }

    public byte[] getElement(int i) {
        int actualSizeOfElements = getActualSizeOfElements(getSizeOfElements());
        byte[] bArr = new byte[actualSizeOfElements];
        System.arraycopy(getComplexData(), (i * actualSizeOfElements) + 6, bArr, 0, actualSizeOfElements);
        return bArr;
    }

    public void setElement(int i, byte[] bArr) {
        int actualSizeOfElements = getActualSizeOfElements(getSizeOfElements());
        System.arraycopy(bArr, 0, getComplexData(), (i * actualSizeOfElements) + 6, actualSizeOfElements);
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty
    public String toString() {
        StringBuilder sb = new StringBuilder("propNum: ");
        sb.append((int) getPropertyNumber());
        sb.append(", propName: ").append(EscherProperties.getPropertyName(getPropertyNumber()));
        sb.append(", complex: ").append(isComplex());
        sb.append(", blipId: ").append(isBlipId());
        sb.append(", data: \n    {EscherArrayProperty:\n     Num Elements: ");
        sb.append(getNumberOfElementsInArray()).append("\n     Num Elements In Memory: ");
        sb.append(getNumberOfElementsInMemory()).append("\n     Size of elements: ");
        sb.append((int) getSizeOfElements()).append('\n');
        for (int i = 0; i < getNumberOfElementsInArray(); i++) {
            sb.append("     Element ").append(i).append(": ").append(HexDump.toHex(getElement(i))).append('\n');
        }
        sb.append("}\n");
        return sb.toString();
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\">\n");
        for (int i = 0; i < getNumberOfElementsInArray(); i++) {
            sb.append("\t").append(str).append("<Element>").append(HexDump.toHex(getElement(i))).append("</Element>\n");
        }
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">");
        return sb.toString();
    }

    public int setArrayData(byte[] bArr, int i) {
        if (this.emptyComplexPart) {
            setComplexData(new byte[0]);
        } else {
            int actualSizeOfElements = getActualSizeOfElements(LittleEndian.getShort(bArr, i + 4)) * LittleEndian.getShort(bArr, i);
            if (actualSizeOfElements == getComplexData().length) {
                setComplexData(new byte[actualSizeOfElements + 6]);
                this.sizeIncludesHeaderSize = false;
            }
            System.arraycopy(bArr, i, getComplexData(), 0, getComplexData().length);
        }
        return getComplexData().length;
    }

    @Override // org.apache.poi.ddf.EscherComplexProperty, org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] bArr, int i) {
        LittleEndian.putShort(bArr, i, getId());
        int length = getComplexData().length;
        if (!this.sizeIncludesHeaderSize) {
            length -= 6;
        }
        LittleEndian.putInt(bArr, i + 2, length);
        return 6;
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        return new Iterator<byte[]>() { // from class: org.apache.poi.ddf.EscherArrayProperty.1
            int idx;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.idx < EscherArrayProperty.this.getNumberOfElementsInArray();
            }

            @Override // java.util.Iterator
            public byte[] next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                EscherArrayProperty escherArrayProperty = EscherArrayProperty.this;
                int i = this.idx;
                this.idx = i + 1;
                return escherArrayProperty.getElement(i);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("not yet implemented");
            }
        };
    }
}
