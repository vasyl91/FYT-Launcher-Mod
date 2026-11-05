package com.syu.utils;

import android.os.Build;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.UByte;
import syu.reflex.ReflexConstructor;
import syu.reflex.ReflexField;
import syu.reflex.ReflexMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MemoryFileUtil {
    public static final int CAN_READ = 1;
    public static final int CAN_WRITE = 0;
    public static final int HEADER_LENGTH_VER1 = 8;
    public static final String MEMORY_NAME = "Shared_Memory";
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 3;
    public static final int VERSION = 1;

    public static MemoryFile a(String str, FileDescriptor fileDescriptor, int i, int i2) {
        Log.e("test", "=================>>  openMemoryFileV27 filename : " + str);
        try {
            MemoryFile memoryFile = new MemoryFile(str, 1);
            try {
                memoryFile.close();
                new ReflexField(memoryFile.getClass(), "mFD").setField(memoryFile, fileDescriptor);
                new ReflexField(memoryFile.getClass(), "mLength").setField(memoryFile, Integer.valueOf(i));
                new ReflexField(memoryFile.getClass(), "mAddress").setField(memoryFile, Long.valueOf(((Long) new ReflexMethod("native_mmap").target(memoryFile).params(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}).call()).longValue()));
                return memoryFile;
            } catch (Exception unused) {
                return memoryFile;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static int appFlag(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return -1;
        }
        return bArr[2] & UByte.MAX_VALUE;
    }

    public static byte[] createArray(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[i4 + 8];
        bArr[0] = (byte) Utils.byteIndex(i, 1);
        bArr[1] = (byte) Utils.byteIndex(i, 0);
        bArr[2] = (byte) (i2 & 255);
        bArr[3] = (byte) (i3 & 255);
        bArr[4] = (byte) Utils.byteIndex(i4, 3);
        bArr[5] = (byte) Utils.byteIndex(i4, 2);
        bArr[6] = (byte) Utils.byteIndex(i4, 1);
        bArr[7] = (byte) Utils.byteIndex(i4, 0);
        return bArr;
    }

    public static MemoryFile createMemory(int i) {
        return createMemory(MEMORY_NAME, i);
    }

    public static FileDescriptor getFileDescriptor(MemoryFile memoryFile) {
        if (memoryFile == null) {
            return null;
        }
        return (FileDescriptor) new ReflexMethod("getFileDescriptor").target(memoryFile).call();
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(MemoryFile memoryFile) {
        if (memoryFile == null) {
            return null;
        }
        return (ParcelFileDescriptor) new ReflexConstructor(ParcelFileDescriptor.class).params(new Object[]{getFileDescriptor(memoryFile)}).newInstance();
    }

    public static boolean isCanRead(byte[] bArr) {
        return (bArr == null || bArr.length == 0 || (bArr[3] & UByte.MAX_VALUE) != 1) ? false : true;
    }

    public static boolean isCanWrite(byte[] bArr) {
        return (bArr == null || bArr.length == 0 || (bArr[3] & UByte.MAX_VALUE) != 0) ? false : true;
    }

    public static MemoryFile openMemoryFile(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) {
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (i2 != 1 && i2 != 3) {
            return null;
        }
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        return Build.VERSION.SDK_INT <= 26 ? a(MEMORY_NAME, fileDescriptor, i, i2) : a(MEMORY_NAME, fileDescriptor, i2);
    }

    public static boolean writeData(int i, byte[] bArr) {
        return writeData(createMemory(bArr.length + 8), i, bArr);
    }

    public static MemoryFile a(String str, FileDescriptor fileDescriptor, int i) {
        MemoryFile memoryFile;
        Log.e("test", "=================>>  openMemoryFileV27 filename : " + str);
        try {
            memoryFile = new MemoryFile(str, 1);
            try {
                memoryFile.close();
                Class<?> cls = Class.forName("android.os.SharedMemory");
                Object objNewInstance = new ReflexConstructor(cls).params(new Object[]{cls, fileDescriptor}).newInstance();
                ByteBuffer byteBuffer = (ByteBuffer) (i == 1 ? new ReflexMethod("mapReadOnly").target(objNewInstance) : new ReflexMethod("mapReadWrite").target(objNewInstance)).call();
                new ReflexField(memoryFile.getClass(), "mSharedMemory").setField(memoryFile, objNewInstance);
                new ReflexField(memoryFile.getClass(), "mMapping").setField(memoryFile, byteBuffer);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            memoryFile = null;
        }
        return memoryFile;
    }

    public static MemoryFile createMemory(String str, int i) {
        try {
            return new MemoryFile(str, i);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeData(MemoryFile memoryFile, int i, byte[] bArr) {
        if (bArr != null && bArr.length != 0 && memoryFile != null) {
            byte[] bArrCreateArray = createArray(1, i, 1, bArr.length);
            System.arraycopy(bArr, 0, bArrCreateArray, 8, bArr.length);
            try {
                memoryFile.writeBytes(bArrCreateArray, 0, 0, bArrCreateArray.length);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static MemoryFile openMemoryFile(String str, ParcelFileDescriptor parcelFileDescriptor, int i, int i2) {
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (i2 != 1 && i2 != 3) {
            return null;
        }
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        return Build.VERSION.SDK_INT <= 26 ? a(str, fileDescriptor, i, i2) : a(str, fileDescriptor, i2);
    }
}
