package org.apache.poi.xssf.binary;

import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public abstract class XSSFBParser {
    private final LittleEndianInputStream is;
    private final BitSet records;

    public abstract void handleRecord(int i, byte[] bArr) throws XSSFBParseException;

    public XSSFBParser(InputStream inputStream) {
        this.is = new LittleEndianInputStream(inputStream);
        this.records = null;
    }

    protected XSSFBParser(InputStream inputStream, BitSet bitSet) {
        this.is = new LittleEndianInputStream(inputStream);
        this.records = bitSet;
    }

    public void parse() throws IOException {
        while (true) {
            int i = this.is.read();
            if (i == -1) {
                return;
            } else {
                readNext((byte) i);
            }
        }
    }

    private void readNext(byte b) throws IOException {
        int i = (b >> 7) & 1;
        int i2 = b;
        if (i == 1) {
            i2 = ((byte) (b & ByteCompanionObject.MAX_VALUE)) + (((byte) (this.is.readByte() & ByteCompanionObject.MAX_VALUE)) << 7);
        }
        long j = 0;
        int i3 = 0;
        boolean z = false;
        while (i3 < 4 && !z) {
            byte b2 = this.is.readByte();
            boolean z2 = ((b2 >> 7) & 1) == 0;
            j += (long) (((byte) (b2 & ByteCompanionObject.MAX_VALUE)) << (i3 * 7));
            i3++;
            z = z2;
        }
        BitSet bitSet = this.records;
        if (bitSet == null || bitSet.get(i2)) {
            byte[] bArr = new byte[(int) j];
            this.is.readFully(bArr);
            handleRecord(i2, bArr);
        } else {
            long jSkip = this.is.skip(j);
            if (jSkip != j) {
                throw new XSSFBParseException("End of file reached before expected.\tTried to skip " + j + ", but only skipped " + jSkip);
            }
        }
    }
}
