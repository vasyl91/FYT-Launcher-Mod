package com.lsec.core.sharememory;

import android.os.Build;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MemoryFileHelper {
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 3;
    private static final int PROT_READ = 1;
    private static final int PROT_WRITE = 2;

    public static MemoryFile createMemoryFile(String name, int length) {
        try {
            return new MemoryFile(name, length);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MemoryFile openMemoryFile(ParcelFileDescriptor pfd, int length, int mode) {
        if (pfd == null) {
            throw new IllegalArgumentException("ParcelFileDescriptor 涓嶈兘涓虹┖");
        }
        FileDescriptor fd = pfd.getFileDescriptor();
        return openMemoryFile(fd, length, mode);
    }

    private static MemoryFile openMemoryFile(FileDescriptor fd, int length, int mode) {
        if (mode == 1 || mode == 3) {
            return Build.VERSION.SDK_INT <= 26 ? openMemoryFileV26(fd, length, mode) : openMemoryFileV27(fd, mode);
        }
        throw new IllegalArgumentException("invalid mode, only support OPEN_READONLY and OPEN_READWRITE");
    }

    public static MemoryFile openMemoryFileV26(FileDescriptor fd, int length, int mode) {
        MemoryFile memoryFile = null;
        try {
            MemoryFile memoryFile2 = new MemoryFile("service.remote", 1);
            try {
                memoryFile2.close();
                InvokeUtil.setValueOfField(memoryFile2, "mFD", fd);
                InvokeUtil.setValueOfField(memoryFile2, "mLength", Integer.valueOf(length));
                long address = ((Long) InvokeUtil.invokeStaticMethod(MemoryFile.class, "native_mmap", fd, Integer.valueOf(length), Integer.valueOf(mode))).longValue();
                InvokeUtil.setValueOfField(memoryFile2, "mAddress", Long.valueOf(address));
                return memoryFile2;
            } catch (Exception e) {
                e = e;
                memoryFile = memoryFile2;
                e.printStackTrace();
                return memoryFile;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private static MemoryFile openMemoryFileV27(FileDescriptor fd, int mode) {
        ByteBuffer mapping;
        try {
            MemoryFile memoryFile = new MemoryFile("service.remote", 1);
            try {
                memoryFile.close();
                Class<?> c = Class.forName("android.os.SharedMemory");
                Object sharedMemory = InvokeUtil.newInstanceOrThrow(c, fd);
                if (mode == 1) {
                    mapping = (ByteBuffer) InvokeUtil.invokeMethod(sharedMemory, "mapReadOnly", new Object[0]);
                } else {
                    mapping = (ByteBuffer) InvokeUtil.invokeMethod(sharedMemory, "mapReadWrite", new Object[0]);
                }
                InvokeUtil.setValueOfField(memoryFile, "mSharedMemory", sharedMemory);
                InvokeUtil.setValueOfField(memoryFile, "mMapping", mapping);
                return memoryFile;
            } catch (Exception e) {
                e = e;
                throw new RuntimeException("openMemoryFile failed!", e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(MemoryFile memoryFile) {
        if (memoryFile == null) {
            throw new IllegalArgumentException("memoryFile is null");
        }
        try {
            FileDescriptor fd = getFileDescriptor(memoryFile);
            ParcelFileDescriptor pfd = (ParcelFileDescriptor) InvokeUtil.newInstanceOrThrow(ParcelFileDescriptor.class, fd);
            return pfd;
        } catch (Exception e) {
            throw new RuntimeException("InvokeUtil.newInstanceOrThrow failed", e);
        }
    }

    public static FileDescriptor getFileDescriptor(MemoryFile memoryFile) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (memoryFile == null) {
            throw new IllegalArgumentException("memoryFile is null");
        }
        FileDescriptor fd = (FileDescriptor) InvokeUtil.invokeMethod(memoryFile, "getFileDescriptor", new Object[0]);
        return fd;
    }
}
