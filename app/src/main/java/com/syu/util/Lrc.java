package com.syu.util;

import android.text.TextUtils;
import android.util.SparseArray;
import com.syu.ipc.data.FinalCanbus;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HTTP;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class Lrc {
    private static Exception e;
    private static Throwable th;
    public static final int APE_FOOTER_SIZE = 32;
    public static final int ID3V22_FRAME_HEADER_SIZE = 6;
    public static final int ID3V23_FRAME_HEADER_SIZE = 10;
    public static final int ID3V2_HEADER_SIZE = 10;
    public static final int ID3_SIZE = 128;
    public static final int MODE_ANSI = 0;
    public static final int MODE_BIGENDIAN = 2;
    public static final int MODE_UNICODE = 1;
    public static final int MODE_UTF8 = 3;
    public static String strLrcSavePath;
    public List<SparseArray<String>> mLrcTimeSave1 = new ArrayList();
    public List<SparseArray<String>> mLrcTimeSave2 = new ArrayList();

    public Id3Info getId3Info(String strFile) {
        Id3Info id3Info = new Id3Info();
        if (!TextUtils.isEmpty(strFile)) {
            String strLower = strFile.toLowerCase();
            if (strLower.endsWith(".mp3")) {
                try {
                    if (!GetAPEv2Info(strFile, id3Info) && !GetId3v2Info(strFile, id3Info)) {
                        try {
                            GetId3v1Info(strFile, id3Info);
                        } catch (Throwable ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                } catch (Throwable ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    GetId3v2_APIC(strFile, id3Info);
                } catch (Throwable ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return id3Info;
    }

    void GetId3v2_APIC(String strFile, Id3Info id3Info) throws Throwable {
        RandomAccessFile randomFile = null;
        RandomAccessFile randomFile2 = null;
        try {
            try {
                randomFile = new RandomAccessFile(strFile, "r");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            ReadID3v2_APIC(randomFile, id3Info);
        } catch (Exception e2) {
            e = e2;
            randomFile2 = randomFile;
            e.printStackTrace();
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomFile2 = randomFile;
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (randomFile != null) {
            try {
                randomFile.close();
                randomFile2 = randomFile;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        randomFile2 = randomFile;
    }

    void ReadID3v2_APIC(RandomAccessFile randomFile, Id3Info id3Info) throws IOException {
        long dwLenFile = randomFile.length();
        byte[] id3v2Header = new byte[10];
        randomFile.read(id3v2Header, 0, 10);
        if (id3v2Header[0] == 73 && id3v2Header[1] == 68 && id3v2Header[2] == 51 && id3v2Header[4] != 2) {
            ParseFramesV23_APIC(randomFile, (int) (dwLenFile - randomFile.getFilePointer()), id3Info);
        }
    }

    boolean IsValidFrameV23(byte[] FrameID) {
        for (int i = 0; i < 4; i++) {
            if ((FrameID[i] < 65 || FrameID[i] > 90) && (FrameID[i] < 48 || FrameID[i] > 57)) {
                return false;
            }
        }
        return true;
    }

    void ParseFramesV23_APIC(RandomAccessFile randomFile, int length, Id3Info id3Info) throws IOException {
        int nFrameLength;
        boolean bParse = false;
        byte[] tmp = new byte[1];
        byte[] fhV23 = new byte[10];
        while (length > 10) {
            randomFile.read(tmp, 0, 1);
            if (tmp[0] == 0) {
                length--;
            } else {
                randomFile.read(tmp, 0, 1);
                if (tmp[0] == 0) {
                    length--;
                } else {
                    randomFile.seek(randomFile.getFilePointer() - 2);
                    int nReadByte = randomFile.read(fhV23, 0, 10);
                    if (nReadByte == 10 && IsValidFrameV23(fhV23) && (nFrameLength = getInt_way2(fhV23, 4)) >= 0 && nFrameLength <= length) {
                        byte[] iEncode = {0};
                        long dwPosNext = randomFile.getFilePointer() + nFrameLength;
                        if (fhV23[0] == 65 && fhV23[1] == 80 && fhV23[2] == 73 && fhV23[3] == 67) {
                            bParse = true;
                            if (nFrameLength > 13) {
                                randomFile.seek(randomFile.getFilePointer() + 13);
                                int iLen = nFrameLength - 13;
                                byte[] data = new byte[iLen];
                                if (data != null) {
                                    randomFile.read(data, 0, iLen);
                                    int imgStart = ByteUtil.indexOf(new byte[]{-1, -40}, data, data.length);
                                    int imgEnd = ByteUtil.lastIndexOf(new byte[]{-1, -39}, data, data.length) + 2;
                                    id3Info.dataPic = ByteUtil.cutBytes(imgStart, imgEnd, data);
                                }
                            }
                        }
                        if (!bParse) {
                            randomFile.seek(dwPosNext);
                            length -= nFrameLength + 10;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    boolean ReadID3v1(RandomAccessFile randomFile, Id3Info id3Info) throws IOException {
        long len = randomFile.length();
        if (len <= 128) {
            return false;
        }
        randomFile.seek(len - 128);
        byte[] chIdent = new byte[3];
        randomFile.read(chIdent, 0, 3);
        if (chIdent[0] != 84 || chIdent[1] != 65 || chIdent[2] != 71) {
            return false;
        }
        byte[] chTitle = new byte[30];
        byte[] chArtist = new byte[30];
        byte[] chAlbum = new byte[30];
        randomFile.read(chTitle, 0, 30);
        randomFile.read(chArtist, 0, 30);
        randomFile.read(chAlbum, 0, 30);
        chTitle[29] = 0;
        chArtist[29] = 0;
        chAlbum[29] = 0;
        for (int i = 29; i >= 0 && chArtist[i] == 32; i--) {
            chArtist[i] = 0;
        }
        if (chArtist[0] == 0) {
            return false;
        }
        id3Info.strTitle = GetBufferW(chTitle, 30, 0);
        if (!TextUtils.isEmpty(id3Info.strTitle)) {
            id3Info.strTitle = id3Info.strTitle.trim();
        }
        id3Info.strArtist = GetBufferW(chArtist, 30, 0);
        if (!TextUtils.isEmpty(id3Info.strArtist)) {
            id3Info.strArtist = id3Info.strArtist.trim();
        }
        id3Info.strAlbum = GetBufferW(chAlbum, 30, 0);
        if (!TextUtils.isEmpty(id3Info.strAlbum)) {
            id3Info.strAlbum = id3Info.strAlbum.trim();
        }
        return true;
    }

    String GetBufferW(byte[] pStream, int iLenBuf, int iTypeEncodeFile) {
        try {
            return new String(pStream, getCharSet(iTypeEncodeFile));
        } catch (Exception e) {
            return "";
        }
    }

    String getCharSet(int iTypeEncodeFile) {
        switch (iTypeEncodeFile) {
            case 1:
                return "UTF-16LE";
            case 2:
                return "UTF-16BE";
            case 3:
                return HTTP.UTF_8;
            default:
                String encoding = FuncUtils.getCharset(Locale.getDefault());
                return encoding;
        }
    }

    boolean GetId3v1Info(String strFile, Id3Info id3Info) throws Throwable {
        RandomAccessFile randomFile = null;
        boolean bSucc = false;
        RandomAccessFile randomFile2 = null;
        try {
            try {
                randomFile = new RandomAccessFile(strFile, "r");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            bSucc = ReadID3v1(randomFile, id3Info);
        } catch (Exception e2) {
            e = e2;
            randomFile2 = randomFile;
            e.printStackTrace();
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return bSucc;
        } catch (Throwable th2) {
            th = th2;
            randomFile2 = randomFile;
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (randomFile != null) {
            try {
                randomFile.close();
                randomFile2 = randomFile;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return bSucc;
        }
        randomFile2 = randomFile;
        return bSucc;
    }

    boolean ReadAPEv2(RandomAccessFile randomFile, Id3Info id3Info) throws IOException {
        boolean bHasID3v1 = false;
        if (randomFile.length() < 128) {
            return false;
        }
        byte[] id3v1tag = new byte[3];
        randomFile.seek(randomFile.length() - 128);
        randomFile.read(id3v1tag, 0, 3);
        if (id3v1tag[0] == 84 && id3v1tag[1] == 65 && id3v1tag[2] == 71) {
            bHasID3v1 = true;
        }
        int nOffset = bHasID3v1 ? FinalCanbus.CAR_RZC_XP1_DaZhong_GaoErFu7 : 32;
        randomFile.seek(randomFile.length() - nOffset);
        byte[] footer = new byte[32];
        randomFile.read(footer, 0, 32);
        if (footer[0] != 65 || footer[1] != 80 || footer[2] != 69 || footer[3] != 84 || footer[4] != 65 || footer[5] != 71 || footer[6] != 69 || footer[7] != 88) {
            return false;
        }
        int nFieldSize = getInt(footer, 12) - 32;
        randomFile.seek(randomFile.length() - (nFieldSize + nOffset));
        int nFieldFooter = getInt(footer, 16);
        ParseFields(randomFile, nFieldSize, nFieldFooter, id3Info);
        return !TextUtils.isEmpty(id3Info.strArtist);
    }

    public boolean GetAPEv2Info(String strFile, Id3Info id3Info) throws Throwable {
        RandomAccessFile randomFile = null;
        boolean bSucc = false;
        RandomAccessFile randomFile2 = null;
        try {
            try {
                randomFile = new RandomAccessFile(strFile, "r");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            bSucc = ReadAPEv2(randomFile, id3Info);
        } catch (Exception e2) {
            e = e2;
            randomFile2 = randomFile;
            e.printStackTrace();
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return bSucc;
        } catch (Throwable th2) {
            th = th2;
            randomFile2 = randomFile;
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (randomFile != null) {
            try {
                randomFile.close();
                randomFile2 = randomFile;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return bSucc;
        }
        randomFile2 = randomFile;
        return bSucc;
    }

    boolean GetId3v2Info(String strFile, Id3Info id3Info) throws Throwable {
        RandomAccessFile randomFile = null;
        boolean bSucc = false;
        RandomAccessFile randomFile2 = null;
        try {
            try {
                randomFile = new RandomAccessFile(strFile, "r");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            bSucc = ReadID3v2(randomFile, id3Info);
        } catch (Exception e2) {
            e = e2;
            randomFile2 = randomFile;
            e.printStackTrace();
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return bSucc;
        } catch (Throwable th2) {
            th = th2;
            randomFile2 = randomFile;
            if (randomFile2 != null) {
                try {
                    randomFile2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (randomFile != null) {
            try {
                randomFile.close();
                randomFile2 = randomFile;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return bSucc;
        }
        randomFile2 = randomFile;
        return bSucc;
    }

    public int getInt_way2(byte[] buf, int offset) {
        return ((buf[offset] & 255) << 24) + ((buf[offset + 1] & 255) << 16) + ((buf[offset + 2] & 255) << 8) + (buf[offset + 3] & 255);
    }

    public int getInt(byte[] buf, int offset) {
        return ((buf[offset + 3] & 255) << 24) + ((buf[offset + 2] & 255) << 16) + ((buf[offset + 1] & 255) << 8) + (buf[offset] & 255);
    }

    String ReadAsciiText(RandomAccessFile randomFile, int iLenMax, int[] iLenActual, int iEncode, boolean bDetectEncode) throws IOException {
        iLenActual[0] = 0;
        if (iLenMax <= 0 || iLenMax >= 1024) {
            return null;
        }
        long pos = randomFile.getFilePointer();
        if (bDetectEncode && iLenMax >= 3) {
            byte[] cTemp = new byte[3];
            randomFile.read(cTemp, 0, 3);
            int[] iTemp = new int[3];
            for (int i = 0; i < 3; i++) {
                iTemp[i] = cTemp[i] & 255;
            }
            if (iTemp[0] == 255 && iTemp[1] == 254) {
                iEncode = 1;
                randomFile.seek(randomFile.getFilePointer() - 1);
                iLenMax -= 2;
            } else if (iTemp[0] == 254 && iTemp[1] == 255) {
                iEncode = 2;
                randomFile.seek(randomFile.getFilePointer() - 1);
                iLenMax -= 2;
            } else if (iTemp[0] == 239 && iTemp[1] == 187 && iTemp[2] == 191) {
                iEncode = 3;
                iLenMax -= 3;
            } else {
                randomFile.seek(randomFile.getFilePointer() - 3);
            }
        }
        boolean b2ByteSeprator = iEncode == 1 || iEncode == 2;
        byte[] ch = new byte[1];
        byte[] pStream = new byte[iLenMax + 2];
        Arrays.fill(pStream, (byte) 0);
        int iLenTemp = iLenMax;
        while (true) {
            if (iLenTemp <= 0) {
                break;
            }
            randomFile.read(ch, 0, 1);
            pStream[iLenActual[0]] = ch[0];
            iLenActual[0] = iLenActual[0] + 1;
            iLenTemp--;
            if (iLenTemp > 0 && ch[0] == 0) {
                if (!b2ByteSeprator) {
                    break;
                }
                randomFile.read(ch, 0, 1);
                pStream[iLenActual[0]] = ch[0];
                iLenActual[0] = iLenActual[0] + 1;
                iLenTemp--;
                if (ch[0] == 0) {
                    if ((iLenActual[0] & 1) != 0) {
                        randomFile.read(pStream, iLenActual[0], 1);
                    }
                }
            }
        }
        iLenActual[0] = (int) (randomFile.getFilePointer() - pos);
        randomFile.seek(randomFile.getFilePointer() + iLenTemp);
        return GetBufferW(pStream, iLenMax + 2, iEncode);
    }

    public void ParseFields(RandomAccessFile randomFile, int nFieldsSize, int nFieldsNum, Id3Info id3Info) throws IOException {
        boolean[] bParse = new boolean[3];
        byte[] nValueSize = new byte[4];
        byte[] Flags = new byte[4];
        for (int i = 0; i < nFieldsNum && nFieldsSize > 10; i++) {
            randomFile.read(nValueSize, 0, 4);
            randomFile.read(Flags, 0, 4);
            int[] len = new int[1];
            int nFieldsSize2 = (nFieldsSize - 8) - getInt(nValueSize, 0);
            String strName = ReadAsciiText(randomFile, nFieldsSize2, len, 3, true);
            if (strName != null) {
                randomFile.seek(randomFile.getFilePointer() - (nFieldsSize2 - len[0]));
                if (strName.startsWith("Artist")) {
                    int[] iLenTemp = new int[1];
                    bParse[0] = true;
                    id3Info.strArtist = ReadAsciiText(randomFile, getInt(nValueSize, 0), iLenTemp, 3, true);
                    if (!TextUtils.isEmpty(id3Info.strArtist)) {
                        id3Info.strArtist = id3Info.strArtist.trim();
                    }
                } else if (strName.startsWith("Album")) {
                    int[] iLenTemp2 = new int[1];
                    bParse[1] = true;
                    id3Info.strAlbum = ReadAsciiText(randomFile, getInt(nValueSize, 0), iLenTemp2, 3, true);
                    if (!TextUtils.isEmpty(id3Info.strAlbum)) {
                        id3Info.strAlbum = id3Info.strAlbum.trim();
                    }
                } else if (strName.startsWith("Title")) {
                    int[] iLenTemp3 = new int[1];
                    bParse[2] = true;
                    id3Info.strTitle = ReadAsciiText(randomFile, getInt(nValueSize, 0), iLenTemp3, 3, true);
                    if (!TextUtils.isEmpty(id3Info.strTitle)) {
                        id3Info.strTitle = id3Info.strTitle.trim();
                    }
                } else {
                    int[] iLenTemp4 = new int[1];
                    ReadAsciiText(randomFile, getInt(nValueSize, 0), iLenTemp4, 3, true);
                }
            }
            if (!bParse[0] || !bParse[1] || !bParse[2]) {
                nFieldsSize = nFieldsSize2 - len[0];
            } else {
                return;
            }
        }
    }

    boolean ReadID3v2(RandomAccessFile randomFile, Id3Info id3Info) throws IOException {
        long dwLenFile = randomFile.length();
        byte[] id3v2Header = new byte[10];
        randomFile.read(id3v2Header, 0, 10);
        if (id3v2Header[0] != 73 || id3v2Header[1] != 68 || id3v2Header[2] != 51) {
            return false;
        }
        if (id3v2Header[4] == 2) {
            ParseFramesV22(randomFile, (int) (dwLenFile - randomFile.getFilePointer()), id3Info);
        } else {
            ParseFramesV23(randomFile, (int) (dwLenFile - randomFile.getFilePointer()), id3Info);
        }
        return !TextUtils.isEmpty(id3Info.strArtist);
    }

    boolean IsValidFrameV22(byte[] fhV22) {
        for (int i = 0; i < 3; i++) {
            if ((fhV22[i] < 65 || fhV22[i] > 90) && (fhV22[i] < 48 || fhV22[i] > 57)) {
                return false;
            }
        }
        return true;
    }

    void ParseFramesV22(RandomAccessFile randomFile, int length, Id3Info id3Info) throws IOException {
        int nFrameLength;
        boolean[] bParse = new boolean[3];
        byte[] tmp = new byte[1];
        byte[] fhV22 = new byte[6];
        while (length > 6) {
            randomFile.read(tmp, 0, 1);
            if (tmp[0] == 0) {
                length--;
            } else {
                randomFile.seek(randomFile.getFilePointer() - 1);
                int nReadByte = randomFile.read(fhV22, 0, 6);
                if (nReadByte == 6 && IsValidFrameV22(fhV22) && (nFrameLength = ((fhV22[3] & 255) << 16) + ((fhV22[4] & 255) << 8) + (fhV22[5] & 255)) >= 0 && nFrameLength <= length && nFrameLength != 0 && nFrameLength <= 100) {
                    byte[] iEncode = {0};
                    int[] iLenTemp = new int[1];
                    long dwPosNext = randomFile.getFilePointer() + nFrameLength;
                    if (fhV22[0] == 84 && fhV22[1] == 80 && fhV22[2] == 49) {
                        randomFile.read(iEncode, 0, 1);
                        int iLen = nFrameLength - 1;
                        bParse[0] = true;
                        id3Info.strArtist = ReadAsciiText(randomFile, iLen, iLenTemp, iEncode[0], true);
                        if (!TextUtils.isEmpty(id3Info.strArtist)) {
                            id3Info.strArtist = id3Info.strArtist.trim();
                        }
                    } else if (fhV22[0] == 84 && fhV22[1] == 65 && fhV22[2] == 76) {
                        randomFile.read(iEncode, 0, 1);
                        int iLen2 = nFrameLength - 1;
                        bParse[1] = true;
                        id3Info.strAlbum = ReadAsciiText(randomFile, iLen2, iLenTemp, iEncode[0], true);
                        if (!TextUtils.isEmpty(id3Info.strAlbum)) {
                            id3Info.strAlbum = id3Info.strAlbum.trim();
                        }
                    } else if (fhV22[0] == 84 && fhV22[1] == 84 && fhV22[2] == 50) {
                        randomFile.read(iEncode, 0, 1);
                        int iLen3 = nFrameLength - 1;
                        bParse[2] = true;
                        id3Info.strTitle = ReadAsciiText(randomFile, iLen3, iLenTemp, iEncode[0], true);
                        if (!TextUtils.isEmpty(id3Info.strTitle)) {
                            id3Info.strTitle = id3Info.strTitle.trim();
                        }
                    }
                    if (!bParse[0] || !bParse[1] || !bParse[2]) {
                        randomFile.seek(dwPosNext);
                        length -= nFrameLength + 6;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    void ParseFramesV23(RandomAccessFile randomFile, int length, Id3Info id3Info) throws IOException {
        int nFrameLength;
        boolean[] bParse = new boolean[3];
        byte[] tmp = new byte[1];
        byte[] fhV23 = new byte[10];
        while (length > 10) {
            randomFile.read(tmp, 0, 1);
            if (tmp[0] == 0) {
                length--;
            } else {
                randomFile.read(tmp, 0, 1);
                if (tmp[0] == 0) {
                    length--;
                } else {
                    randomFile.seek(randomFile.getFilePointer() - 2);
                    int nReadByte = randomFile.read(fhV23, 0, 10);
                    if (nReadByte == 10 && IsValidFrameV23(fhV23) && (nFrameLength = getInt_way2(fhV23, 4)) >= 0 && nFrameLength <= length) {
                        byte[] iEncode = {0};
                        int[] iLenTemp = new int[1];
                        long dwPosNext = randomFile.getFilePointer() + nFrameLength;
                        if (fhV23[0] == 84 && fhV23[1] == 80 && fhV23[2] == 69 && fhV23[3] == 49) {
                            bParse[0] = true;
                            randomFile.read(iEncode, 0, 1);
                            int iLen = nFrameLength - 1;
                            id3Info.strArtist = ReadAsciiText(randomFile, iLen, iLenTemp, iEncode[0], true);
                            if (!TextUtils.isEmpty(id3Info.strArtist)) {
                                id3Info.strArtist = id3Info.strArtist.trim();
                            }
                        } else if (fhV23[0] == 84 && fhV23[1] == 65 && fhV23[2] == 76 && fhV23[3] == 66) {
                            bParse[1] = true;
                            randomFile.read(iEncode, 0, 1);
                            int iLen2 = nFrameLength - 1;
                            id3Info.strAlbum = ReadAsciiText(randomFile, iLen2, iLenTemp, iEncode[0], true);
                            if (!TextUtils.isEmpty(id3Info.strAlbum)) {
                                id3Info.strAlbum = id3Info.strAlbum.trim();
                            }
                        } else if (fhV23[0] == 84 && fhV23[1] == 73 && fhV23[2] == 84 && fhV23[3] == 50) {
                            bParse[2] = true;
                            randomFile.read(iEncode, 0, 1);
                            int iLen3 = nFrameLength - 1;
                            id3Info.strTitle = ReadAsciiText(randomFile, iLen3, iLenTemp, iEncode[0], true);
                            if (!TextUtils.isEmpty(id3Info.strTitle)) {
                                id3Info.strTitle = id3Info.strTitle.trim();
                            }
                        }
                        if (!bParse[0] || !bParse[1] || !bParse[2]) {
                            randomFile.seek(dwPosNext);
                            length -= nFrameLength + 10;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
