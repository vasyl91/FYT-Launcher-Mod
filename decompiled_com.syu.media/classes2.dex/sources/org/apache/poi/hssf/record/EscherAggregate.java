package org.apache.poi.hssf.record;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.ddf.EscherSerializationListener;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherAggregate extends AbstractEscherHolderRecord {
    public static final short ST_ACCENTBORDERCALLOUT1 = 50;
    public static final short ST_ACCENTBORDERCALLOUT2 = 51;
    public static final short ST_ACCENTBORDERCALLOUT3 = 52;
    public static final short ST_ACCENTBORDERCALLOUT90 = 181;
    public static final short ST_ACCENTCALLOUT1 = 44;
    public static final short ST_ACCENTCALLOUT2 = 45;
    public static final short ST_ACCENTCALLOUT3 = 46;
    public static final short ST_ACCENTCALLOUT90 = 179;
    public static final short ST_ACTIONBUTTONBACKPREVIOUS = 194;
    public static final short ST_ACTIONBUTTONBEGINNING = 196;
    public static final short ST_ACTIONBUTTONBLANK = 189;
    public static final short ST_ACTIONBUTTONDOCUMENT = 198;
    public static final short ST_ACTIONBUTTONEND = 195;
    public static final short ST_ACTIONBUTTONFORWARDNEXT = 193;
    public static final short ST_ACTIONBUTTONHELP = 191;
    public static final short ST_ACTIONBUTTONHOME = 190;
    public static final short ST_ACTIONBUTTONINFORMATION = 192;
    public static final short ST_ACTIONBUTTONMOVIE = 200;
    public static final short ST_ACTIONBUTTONRETURN = 197;
    public static final short ST_ACTIONBUTTONSOUND = 199;
    public static final short ST_ARC = 19;
    public static final short ST_ARROW = 13;
    public static final short ST_BALLOON = 17;
    public static final short ST_BENTARROW = 91;
    public static final short ST_BENTCONNECTOR2 = 33;
    public static final short ST_BENTCONNECTOR3 = 34;
    public static final short ST_BENTCONNECTOR4 = 35;
    public static final short ST_BENTCONNECTOR5 = 36;
    public static final short ST_BENTUPARROW = 90;
    public static final short ST_BEVEL = 84;
    public static final short ST_BLOCKARC = 95;
    public static final short ST_BORDERCALLOUT1 = 47;
    public static final short ST_BORDERCALLOUT2 = 48;
    public static final short ST_BORDERCALLOUT3 = 49;
    public static final short ST_BORDERCALLOUT90 = 180;
    public static final short ST_BRACEPAIR = 186;
    public static final short ST_BRACKETPAIR = 185;
    public static final short ST_CALLOUT1 = 41;
    public static final short ST_CALLOUT2 = 42;
    public static final short ST_CALLOUT3 = 43;
    public static final short ST_CALLOUT90 = 178;
    public static final short ST_CAN = 22;
    public static final short ST_CHEVRON = 55;
    public static final short ST_CIRCULARARROW = 99;
    public static final short ST_CLOUDCALLOUT = 106;
    public static final short ST_CUBE = 16;
    public static final short ST_CURVEDCONNECTOR2 = 37;
    public static final short ST_CURVEDCONNECTOR3 = 38;
    public static final short ST_CURVEDCONNECTOR4 = 39;
    public static final short ST_CURVEDCONNECTOR5 = 40;
    public static final short ST_CURVEDDOWNARROW = 105;
    public static final short ST_CURVEDLEFTARROW = 103;
    public static final short ST_CURVEDRIGHTARROW = 102;
    public static final short ST_CURVEDUPARROW = 104;
    public static final short ST_DIAMOND = 4;
    public static final short ST_DONUT = 23;
    public static final short ST_DOUBLEWAVE = 188;
    public static final short ST_DOWNARROW = 67;
    public static final short ST_DOWNARROWCALLOUT = 80;
    public static final short ST_ELLIPSE = 3;
    public static final short ST_ELLIPSERIBBON = 107;
    public static final short ST_ELLIPSERIBBON2 = 108;
    public static final short ST_FLOWCHARTALTERNATEPROCESS = 176;
    public static final short ST_FLOWCHARTCOLLATE = 125;
    public static final short ST_FLOWCHARTCONNECTOR = 120;
    public static final short ST_FLOWCHARTDECISION = 110;
    public static final short ST_FLOWCHARTDELAY = 135;
    public static final short ST_FLOWCHARTDISPLAY = 134;
    public static final short ST_FLOWCHARTDOCUMENT = 114;
    public static final short ST_FLOWCHARTEXTRACT = 127;
    public static final short ST_FLOWCHARTINPUTOUTPUT = 111;
    public static final short ST_FLOWCHARTINTERNALSTORAGE = 113;
    public static final short ST_FLOWCHARTMAGNETICDISK = 132;
    public static final short ST_FLOWCHARTMAGNETICDRUM = 133;
    public static final short ST_FLOWCHARTMAGNETICTAPE = 131;
    public static final short ST_FLOWCHARTMANUALINPUT = 118;
    public static final short ST_FLOWCHARTMANUALOPERATION = 119;
    public static final short ST_FLOWCHARTMERGE = 128;
    public static final short ST_FLOWCHARTMULTIDOCUMENT = 115;
    public static final short ST_FLOWCHARTOFFLINESTORAGE = 129;
    public static final short ST_FLOWCHARTOFFPAGECONNECTOR = 177;
    public static final short ST_FLOWCHARTONLINESTORAGE = 130;
    public static final short ST_FLOWCHARTOR = 124;
    public static final short ST_FLOWCHARTPREDEFINEDPROCESS = 112;
    public static final short ST_FLOWCHARTPREPARATION = 117;
    public static final short ST_FLOWCHARTPROCESS = 109;
    public static final short ST_FLOWCHARTPUNCHEDCARD = 121;
    public static final short ST_FLOWCHARTPUNCHEDTAPE = 122;
    public static final short ST_FLOWCHARTSORT = 126;
    public static final short ST_FLOWCHARTSUMMINGJUNCTION = 123;
    public static final short ST_FLOWCHARTTERMINATOR = 116;
    public static final short ST_FOLDEDCORNER = 65;
    public static final short ST_HEART = 74;
    public static final short ST_HEXAGON = 9;
    public static final short ST_HOMEPLATE = 15;
    public static final short ST_HORIZONTALSCROLL = 98;
    public static final short ST_HOSTCONTROL = 201;
    public static final short ST_IRREGULARSEAL1 = 71;
    public static final short ST_IRREGULARSEAL2 = 72;
    public static final short ST_ISOCELESTRIANGLE = 5;
    public static final short ST_LEFTARROW = 66;
    public static final short ST_LEFTARROWCALLOUT = 77;
    public static final short ST_LEFTBRACE = 87;
    public static final short ST_LEFTBRACKET = 85;
    public static final short ST_LEFTRIGHTARROW = 69;
    public static final short ST_LEFTRIGHTARROWCALLOUT = 81;
    public static final short ST_LEFTRIGHTUPARROW = 182;
    public static final short ST_LEFTUPARROW = 89;
    public static final short ST_LIGHTNINGBOLT = 73;
    public static final short ST_LINE = 20;
    public static final short ST_MIN = 0;
    public static final short ST_MOON = 184;
    public static final short ST_NIL = 4095;
    public static final short ST_NOSMOKING = 57;
    public static final short ST_NOTCHEDCIRCULARARROW = 100;
    public static final short ST_NOTCHEDRIGHTARROW = 94;
    public static final short ST_NOT_PRIMATIVE = 0;
    public static final short ST_OCTAGON = 10;
    public static final short ST_PARALLELOGRAM = 7;
    public static final short ST_PENTAGON = 56;
    public static final short ST_PICTUREFRAME = 75;
    public static final short ST_PLAQUE = 21;
    public static final short ST_PLUS = 11;
    public static final short ST_QUADARROW = 76;
    public static final short ST_QUADARROWCALLOUT = 83;
    public static final short ST_RECTANGLE = 1;
    public static final short ST_RIBBON = 53;
    public static final short ST_RIBBON2 = 54;
    public static final short ST_RIGHTARROWCALLOUT = 78;
    public static final short ST_RIGHTBRACE = 88;
    public static final short ST_RIGHTBRACKET = 86;
    public static final short ST_RIGHTTRIANGLE = 6;
    public static final short ST_ROUNDRECTANGLE = 2;
    public static final short ST_SEAL = 18;
    public static final short ST_SEAL16 = 59;
    public static final short ST_SEAL24 = 92;
    public static final short ST_SEAL32 = 60;
    public static final short ST_SEAL4 = 187;
    public static final short ST_SEAL8 = 58;
    public static final short ST_SMILEYFACE = 96;
    public static final short ST_STAR = 12;
    public static final short ST_STRAIGHTCONNECTOR1 = 32;
    public static final short ST_STRIPEDRIGHTARROW = 93;
    public static final short ST_SUN = 183;
    public static final short ST_TEXTARCHDOWNCURVE = 145;
    public static final short ST_TEXTARCHDOWNPOUR = 149;
    public static final short ST_TEXTARCHUPCURVE = 144;
    public static final short ST_TEXTARCHUPPOUR = 148;
    public static final short ST_TEXTBOX = 202;
    public static final short ST_TEXTBUTTONCURVE = 147;
    public static final short ST_TEXTBUTTONPOUR = 151;
    public static final short ST_TEXTCANDOWN = 175;
    public static final short ST_TEXTCANUP = 174;
    public static final short ST_TEXTCASCADEDOWN = 155;
    public static final short ST_TEXTCASCADEUP = 154;
    public static final short ST_TEXTCHEVRON = 140;
    public static final short ST_TEXTCHEVRONINVERTED = 141;
    public static final short ST_TEXTCIRCLECURVE = 146;
    public static final short ST_TEXTCIRCLEPOUR = 150;
    public static final short ST_TEXTCURVE = 27;
    public static final short ST_TEXTCURVEDOWN = 153;
    public static final short ST_TEXTCURVEUP = 152;
    public static final short ST_TEXTDEFLATE = 161;
    public static final short ST_TEXTDEFLATEBOTTOM = 163;
    public static final short ST_TEXTDEFLATEINFLATE = 166;
    public static final short ST_TEXTDEFLATEINFLATEDEFLATE = 167;
    public static final short ST_TEXTDEFLATETOP = 165;
    public static final short ST_TEXTFADEDOWN = 171;
    public static final short ST_TEXTFADELEFT = 169;
    public static final short ST_TEXTFADERIGHT = 168;
    public static final short ST_TEXTFADEUP = 170;
    public static final short ST_TEXTHEXAGON = 26;
    public static final short ST_TEXTINFLATE = 160;
    public static final short ST_TEXTINFLATEBOTTOM = 162;
    public static final short ST_TEXTINFLATETOP = 164;
    public static final short ST_TEXTOCTAGON = 25;
    public static final short ST_TEXTONCURVE = 30;
    public static final short ST_TEXTONRING = 31;
    public static final short ST_TEXTPLAINTEXT = 136;
    public static final short ST_TEXTRING = 29;
    public static final short ST_TEXTRINGINSIDE = 142;
    public static final short ST_TEXTRINGOUTSIDE = 143;
    public static final short ST_TEXTSIMPLE = 24;
    public static final short ST_TEXTSLANTDOWN = 173;
    public static final short ST_TEXTSLANTUP = 172;
    public static final short ST_TEXTSTOP = 137;
    public static final short ST_TEXTTRIANGLE = 138;
    public static final short ST_TEXTTRIANGLEINVERTED = 139;
    public static final short ST_TEXTWAVE = 28;
    public static final short ST_TEXTWAVE1 = 156;
    public static final short ST_TEXTWAVE2 = 157;
    public static final short ST_TEXTWAVE3 = 158;
    public static final short ST_TEXTWAVE4 = 159;
    public static final short ST_THICKARROW = 14;
    public static final short ST_TRAPEZOID = 8;
    public static final short ST_UPARROW = 68;
    public static final short ST_UPARROWCALLOUT = 79;
    public static final short ST_UPDOWNARROW = 70;
    public static final short ST_UPDOWNARROWCALLOUT = 82;
    public static final short ST_UTURNARROW = 101;
    public static final short ST_VERTICALSCROLL = 97;
    public static final short ST_WAVE = 64;
    public static final short ST_WEDGEELLIPSECALLOUT = 63;
    public static final short ST_WEDGERECTCALLOUT = 61;
    public static final short ST_WEDGERRECTCALLOUT = 62;
    private static POILogger log = POILogFactory.getLogger((Class<?>) EscherAggregate.class);
    public static final short sid = 9876;
    private final Map<EscherRecord, Record> shapeToObj = new HashMap();
    private final Map<Integer, NoteRecord> tailRec = new LinkedHashMap();

    private static boolean isDrawingLayerRecord(short s) {
        return s == 236 || s == 60 || s == 93 || s == 438;
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord
    protected String getRecordName() {
        return "ESCHERAGGREGATE";
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public EscherAggregate(boolean z) {
        if (z) {
            buildBaseTree();
        }
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record
    public String toString() {
        String property = System.getProperty("line.separtor");
        StringBuilder sb = new StringBuilder("[");
        sb.append(getRecordName()).append(']').append(property);
        Iterator<EscherRecord> it = getEscherRecords().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        sb.append("[/").append(getRecordName()).append(']').append(property);
        return sb.toString();
    }

    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("<").append(getRecordName()).append(">\n");
        Iterator<EscherRecord> it = getEscherRecords().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toXml(str + "\t"));
        }
        sb.append(str).append("</").append(getRecordName()).append(">\n");
        return sb.toString();
    }

    public static EscherAggregate createAggregate(List<RecordBase> list, int i) {
        final ArrayList arrayList = new ArrayList();
        EscherRecordFactory escherRecordFactory = new DefaultEscherRecordFactory() { // from class: org.apache.poi.hssf.record.EscherAggregate.1
            @Override // org.apache.poi.ddf.DefaultEscherRecordFactory, org.apache.poi.ddf.EscherRecordFactory
            public EscherRecord createRecord(byte[] bArr, int i2) {
                EscherRecord escherRecordCreateRecord = super.createRecord(bArr, i2);
                if (escherRecordCreateRecord.getRecordId() == -4079 || escherRecordCreateRecord.getRecordId() == -4083) {
                    arrayList.add(escherRecordCreateRecord);
                }
                return escherRecordCreateRecord;
            }
        };
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        EscherAggregate escherAggregate = new EscherAggregate(false);
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= list.size() || !isDrawingLayerRecord(sid(list, i3))) {
                break;
            }
            try {
                if (sid(list, i3) == 236 || sid(list, i3) == 60) {
                    if (sid(list, i3) == 236) {
                        byteArrayOutputStream.write(((DrawingRecord) list.get(i3)).getRecordData());
                    } else {
                        byteArrayOutputStream.write(((ContinueRecord) list.get(i3)).getData());
                    }
                }
                i3 = i4;
            } catch (IOException e) {
                throw new RuntimeException("Couldn't get data from drawing/continue records", e);
            }
        }
        int i5 = 0;
        while (i5 < byteArrayOutputStream.size()) {
            EscherRecord escherRecordCreateRecord = escherRecordFactory.createRecord(byteArrayOutputStream.toByteArray(), i5);
            int iFillFields = escherRecordCreateRecord.fillFields(byteArrayOutputStream.toByteArray(), i5, escherRecordFactory);
            escherAggregate.addEscherRecord(escherRecordCreateRecord);
            i5 += iFillFields;
        }
        int i6 = i + 1;
        while (i6 < list.size() && isDrawingLayerRecord(sid(list, i6))) {
            if (isObjectRecord(list, i6)) {
                escherAggregate.shapeToObj.put((EscherRecord) arrayList.get(i2), (Record) list.get(i6));
                i6++;
                i2++;
            } else {
                i6++;
            }
        }
        while (i6 < list.size() && sid(list, i6) == 28) {
            NoteRecord noteRecord = (NoteRecord) list.get(i6);
            escherAggregate.tailRec.put(Integer.valueOf(noteRecord.getShapeId()), noteRecord);
            i6++;
        }
        list.subList(i, i6).clear();
        list.add(i, escherAggregate);
        return escherAggregate;
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        List<EscherRecord> escherRecords = getEscherRecords();
        int escherRecordSize = getEscherRecordSize(escherRecords);
        byte[] bArr2 = new byte[escherRecordSize];
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<EscherRecord> it = escherRecords.iterator();
        int i2 = 0;
        int iSerialize = 0;
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr2, new EscherSerializationListener() { // from class: org.apache.poi.hssf.record.EscherAggregate.2
                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void beforeRecordSerialize(int i3, short s, EscherRecord escherRecord) {
                }

                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void afterRecordSerialize(int i3, short s, int i4, EscherRecord escherRecord) {
                    if (s == -4079 || s == -4083) {
                        arrayList.add(Integer.valueOf(i3));
                        arrayList2.add(escherRecord);
                    }
                }
            });
        }
        arrayList2.add(0, null);
        arrayList.add(0, 0);
        int iWriteDataIntoDrawingRecord = i;
        int i3 = 0;
        int i4 = 1;
        while (i4 < arrayList2.size()) {
            int iIntValue = ((Integer) arrayList.get(i4)).intValue() - 1;
            int iIntValue2 = i4 == 1 ? i2 : ((Integer) arrayList.get(i4 - 1)).intValue();
            int i5 = (iIntValue - iIntValue2) + 1;
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr2, iIntValue2, bArr3, i2, i5);
            int iWriteDataIntoDrawingRecord2 = iWriteDataIntoDrawingRecord + writeDataIntoDrawingRecord(bArr3, i3, iWriteDataIntoDrawingRecord, bArr, i4);
            i3 += i5;
            iWriteDataIntoDrawingRecord = iWriteDataIntoDrawingRecord2 + this.shapeToObj.get(arrayList2.get(i4)).serialize(iWriteDataIntoDrawingRecord2, bArr);
            if (i4 == arrayList2.size() - 1 && iIntValue < escherRecordSize - 1) {
                int i6 = (escherRecordSize - iIntValue) - 1;
                byte[] bArr4 = new byte[i6];
                System.arraycopy(bArr2, iIntValue + 1, bArr4, 0, i6);
                iWriteDataIntoDrawingRecord += writeDataIntoDrawingRecord(bArr4, i3, iWriteDataIntoDrawingRecord, bArr, i4);
            }
            i4++;
            i2 = 0;
        }
        int i7 = iWriteDataIntoDrawingRecord - i;
        if (i7 < escherRecordSize - 1) {
            int i8 = escherRecordSize - i7;
            byte[] bArr5 = new byte[i8];
            System.arraycopy(bArr2, i7, bArr5, 0, i8);
            iWriteDataIntoDrawingRecord += writeDataIntoDrawingRecord(bArr5, i3, iWriteDataIntoDrawingRecord, bArr, i4);
        }
        Iterator<NoteRecord> it2 = this.tailRec.values().iterator();
        int iSerialize2 = iWriteDataIntoDrawingRecord;
        while (it2.hasNext()) {
            iSerialize2 += it2.next().serialize(iSerialize2, bArr);
        }
        int i9 = iSerialize2 - i;
        if (i9 == getRecordSize()) {
            return i9;
        }
        throw new RecordFormatException(i9 + " bytes written but getRecordSize() reports " + getRecordSize());
    }

    private int writeDataIntoDrawingRecord(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int iSerialize;
        int iSerialize2;
        if (i + bArr.length > 8224 && i3 != 1) {
            iSerialize = 0;
            for (int i4 = 0; i4 < bArr.length; i4 += 8224) {
                byte[] bArr3 = new byte[Math.min(8224, bArr.length - i4)];
                System.arraycopy(bArr, i4, bArr3, 0, Math.min(8224, bArr.length - i4));
                iSerialize += new ContinueRecord(bArr3).serialize(i2 + iSerialize, bArr2);
            }
        } else {
            iSerialize = 0;
            for (int i5 = 0; i5 < bArr.length; i5 += 8224) {
                if (i5 == 0) {
                    DrawingRecord drawingRecord = new DrawingRecord();
                    byte[] bArr4 = new byte[Math.min(8224, bArr.length - i5)];
                    System.arraycopy(bArr, i5, bArr4, 0, Math.min(8224, bArr.length - i5));
                    drawingRecord.setData(bArr4);
                    iSerialize2 = drawingRecord.serialize(i2 + iSerialize, bArr2);
                } else {
                    byte[] bArr5 = new byte[Math.min(8224, bArr.length - i5)];
                    System.arraycopy(bArr, i5, bArr5, 0, Math.min(8224, bArr.length - i5));
                    iSerialize2 = new ContinueRecord(bArr5).serialize(i2 + iSerialize, bArr2);
                }
                iSerialize += iSerialize2;
            }
        }
        return iSerialize;
    }

    private int getEscherRecordSize(List<EscherRecord> list) {
        Iterator<EscherRecord> it = list.iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize;
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        List<EscherRecord> escherRecords = getEscherRecords();
        int escherRecordSize = getEscherRecordSize(escherRecords);
        byte[] bArr = new byte[escherRecordSize];
        final ArrayList arrayList = new ArrayList();
        Iterator<EscherRecord> it = escherRecords.iterator();
        int recordSize = 0;
        int iSerialize = 0;
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr, new EscherSerializationListener() { // from class: org.apache.poi.hssf.record.EscherAggregate.3
                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void beforeRecordSerialize(int i, short s, EscherRecord escherRecord) {
                }

                @Override // org.apache.poi.ddf.EscherSerializationListener
                public void afterRecordSerialize(int i, short s, int i2, EscherRecord escherRecord) {
                    if (s == -4079 || s == -4083) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
            });
        }
        arrayList.add(0, 0);
        int iIntValue = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            if (i == arrayList.size() - 1 && ((Integer) arrayList.get(i)).intValue() < iSerialize) {
                iIntValue += 4;
            }
            int i2 = i - 1;
            if (((Integer) arrayList.get(i)).intValue() - ((Integer) arrayList.get(i2)).intValue() > 8224) {
                iIntValue += ((((Integer) arrayList.get(i)).intValue() - ((Integer) arrayList.get(i2)).intValue()) / 8224) * 4;
            }
        }
        int size = (this.shapeToObj.size() * 4) + escherRecordSize;
        if (escherRecordSize != 0 && arrayList.size() == 1) {
            iIntValue += 4;
        }
        Iterator<Record> it2 = this.shapeToObj.values().iterator();
        int recordSize2 = 0;
        while (it2.hasNext()) {
            recordSize2 += it2.next().getRecordSize();
        }
        Iterator<NoteRecord> it3 = this.tailRec.values().iterator();
        while (it3.hasNext()) {
            recordSize += it3.next().getRecordSize();
        }
        return size + recordSize2 + recordSize + iIntValue;
    }

    public void associateShapeToObjRecord(EscherRecord escherRecord, Record record) {
        this.shapeToObj.put(escherRecord, record);
    }

    public void removeShapeToObjRecord(EscherRecord escherRecord) {
        this.shapeToObj.remove(escherRecord);
    }

    private static boolean isObjectRecord(List<RecordBase> list, int i) {
        return sid(list, i) == 93 || sid(list, i) == 438;
    }

    private void buildBaseTree() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
        EscherContainerRecord escherContainerRecord3 = new EscherContainerRecord();
        EscherSpgrRecord escherSpgrRecord = new EscherSpgrRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.DG_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        EscherDgRecord escherDgRecord = new EscherDgRecord();
        escherDgRecord.setRecordId(EscherDgRecord.RECORD_ID);
        escherDgRecord.setOptions((short) 16);
        escherDgRecord.setNumShapes(0);
        escherDgRecord.setLastMSOSPID(1024);
        escherContainerRecord2.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        escherContainerRecord2.setOptions((short) 15);
        escherContainerRecord3.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord3.setOptions((short) 15);
        escherSpgrRecord.setRecordId(EscherSpgrRecord.RECORD_ID);
        escherSpgrRecord.setOptions((short) 1);
        escherSpgrRecord.setRectX1(0);
        escherSpgrRecord.setRectY1(0);
        escherSpgrRecord.setRectX2(1023);
        escherSpgrRecord.setRectY2(255);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 2);
        escherSpRecord.setVersion((short) 2);
        escherSpRecord.setShapeId(-1);
        escherSpRecord.setFlags(5);
        escherContainerRecord.addChildRecord(escherDgRecord);
        escherContainerRecord.addChildRecord(escherContainerRecord2);
        escherContainerRecord2.addChildRecord(escherContainerRecord3);
        escherContainerRecord3.addChildRecord(escherSpgrRecord);
        escherContainerRecord3.addChildRecord(escherSpRecord);
        addEscherRecord(escherContainerRecord);
    }

    public void setDgId(short s) {
        ((EscherDgRecord) getEscherContainer().getChildById(EscherDgRecord.RECORD_ID)).setOptions((short) (s << 4));
    }

    public void setMainSpRecordId(int i) {
        ((EscherSpRecord) ((EscherContainerRecord) ((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SPGR_CONTAINER)).getChild(0)).getChildById(EscherSpRecord.RECORD_ID)).setShapeId(i);
    }

    private static short sid(List<RecordBase> list, int i) {
        RecordBase recordBase = list.get(i);
        if (recordBase instanceof Record) {
            return ((Record) recordBase).getSid();
        }
        return (short) -1;
    }

    public Map<EscherRecord, Record> getShapeToObjMapping() {
        return Collections.unmodifiableMap(this.shapeToObj);
    }

    public Map<Integer, NoteRecord> getTailRecords() {
        return Collections.unmodifiableMap(this.tailRec);
    }

    public NoteRecord getNoteRecordByObj(ObjRecord objRecord) {
        return this.tailRec.get(Integer.valueOf(((CommonObjectDataSubRecord) objRecord.getSubRecords().get(0)).getObjectId()));
    }

    public void addTailRecord(NoteRecord noteRecord) {
        this.tailRec.put(Integer.valueOf(noteRecord.getShapeId()), noteRecord);
    }

    public void removeTailRecord(NoteRecord noteRecord) {
        this.tailRec.remove(Integer.valueOf(noteRecord.getShapeId()));
    }
}
