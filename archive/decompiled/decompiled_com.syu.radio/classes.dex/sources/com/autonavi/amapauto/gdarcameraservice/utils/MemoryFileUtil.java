package com.autonavi.amapauto.gdarcameraservice.utils;

import android.os.Build;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MemoryFileUtil {
    public static final String MEMORY_NAME = "CameraService";
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 3;
    private static final int PROT_READ = 1;
    private static final int PROT_WRITE = 2;

    public static MemoryFile openMemoryFile(ParcelFileDescriptor parcelFileDescriptor, int length, int mode) {
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (mode != 1 && mode != 3) {
            return null;
        }
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        if (Build.VERSION.SDK_INT <= 26) {
            return openMemoryFileV27(fileDescriptor, length, mode);
        }
        return openMemoryFileV28(fileDescriptor, mode);
    }

    private static MemoryFile openMemoryFileV27(FileDescriptor fileDescriptor, int length, int mode) {
        try {
            MemoryFile memoryFile = new MemoryFile(MEMORY_NAME, 1);
            try {
                memoryFile.close();
                InvokeUtil.setValueOfField(memoryFile, "mFD", fileDescriptor);
                InvokeUtil.setValueOfField(memoryFile, "mLength", Integer.valueOf(length));
                long address = ((Long) InvokeUtil.invokeStaticMethod(MemoryFile.class, "native_mmap", fileDescriptor, Integer.valueOf(length), Integer.valueOf(mode))).longValue();
                InvokeUtil.setValueOfField(memoryFile, "mAddress", Long.valueOf(address));
                return memoryFile;
            } catch (Exception e) {
                return memoryFile;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static MemoryFile openMemoryFileV28(FileDescriptor fileDescriptor, int mode) {
        ByteBuffer mapping;
        try {
            MemoryFile memoryFile = new MemoryFile(MEMORY_NAME, 1);
            try {
                memoryFile.close();
                Class<?> clz = Class.forName("android.os.SharedMemory");
                Object sharedMemory = InvokeUtil.newInstanceOrThrow(clz, fileDescriptor);
                if (mode == 1) {
                    mapping = (ByteBuffer) InvokeUtil.invokeMethod(sharedMemory, "mapReadOnly", new Object[0]);
                } else {
                    mapping = (ByteBuffer) InvokeUtil.invokeMethod(sharedMemory, "mapReadWrite", new Object[0]);
                }
                InvokeUtil.setValueOfField(memoryFile, "mSharedMemory", sharedMemory);
                InvokeUtil.setValueOfField(memoryFile, "mMapping", mapping);
                return memoryFile;
            } catch (Exception e) {
                return memoryFile;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
