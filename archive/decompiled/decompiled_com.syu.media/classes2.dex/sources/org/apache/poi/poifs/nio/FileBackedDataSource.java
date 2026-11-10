package org.apache.poi.poifs.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FileBackedDataSource extends DataSource {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) FileBackedDataSource.class);
    private List<ByteBuffer> buffersToClean;
    private FileChannel channel;
    private RandomAccessFile srcFile;
    private boolean writable;

    public FileBackedDataSource(File file) throws FileNotFoundException {
        this(newSrcFile(file, "r"), true);
    }

    public FileBackedDataSource(File file, boolean z) throws FileNotFoundException {
        this(newSrcFile(file, z ? "r" : "rw"), z);
    }

    public FileBackedDataSource(RandomAccessFile randomAccessFile, boolean z) {
        this(randomAccessFile.getChannel(), z);
        this.srcFile = randomAccessFile;
    }

    public FileBackedDataSource(FileChannel fileChannel, boolean z) {
        this.buffersToClean = new ArrayList();
        this.channel = fileChannel;
        this.writable = !z;
    }

    public boolean isWriteable() {
        return this.writable;
    }

    public FileChannel getChannel() {
        return this.channel;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int i, long j) throws IOException {
        ByteBuffer byteBufferAllocate;
        if (j >= size()) {
            throw new IndexOutOfBoundsException("Position " + j + " past the end of the file");
        }
        if (this.writable) {
            byteBufferAllocate = this.channel.map(FileChannel.MapMode.READ_WRITE, j, i);
            this.buffersToClean.add(byteBufferAllocate);
        } else {
            this.channel.position(j);
            byteBufferAllocate = ByteBuffer.allocate(i);
            if (IOUtils.readFully(this.channel, byteBufferAllocate) == -1) {
                throw new IndexOutOfBoundsException("Position " + j + " past the end of the file");
            }
        }
        byteBufferAllocate.position(0);
        return byteBufferAllocate;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer byteBuffer, long j) throws IOException {
        this.channel.write(byteBuffer, j);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void copyTo(OutputStream outputStream) throws IOException {
        WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(outputStream);
        FileChannel fileChannel = this.channel;
        fileChannel.transferTo(0L, fileChannel.size(), writableByteChannelNewChannel);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() throws IOException {
        return this.channel.size();
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() throws IOException {
        Iterator<ByteBuffer> it = this.buffersToClean.iterator();
        while (it.hasNext()) {
            unmap(it.next());
        }
        this.buffersToClean.clear();
        RandomAccessFile randomAccessFile = this.srcFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        } else {
            this.channel.close();
        }
    }

    private static RandomAccessFile newSrcFile(File file, String str) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        return new RandomAccessFile(file, str);
    }

    private static void unmap(final ByteBuffer byteBuffer) {
        if (byteBuffer.getClass().getName().endsWith("HeapByteBuffer")) {
            return;
        }
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: org.apache.poi.poifs.nio.FileBackedDataSource.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                try {
                    Method method = byteBuffer.getClass().getMethod("cleaner", new Class[0]);
                    method.setAccessible(true);
                    Object objInvoke = method.invoke(byteBuffer, new Object[0]);
                    if (objInvoke == null) {
                        return null;
                    }
                    objInvoke.getClass().getMethod("clean", new Class[0]).invoke(objInvoke, new Object[0]);
                    return null;
                } catch (Exception e) {
                    FileBackedDataSource.logger.log(5, "Unable to unmap memory mapped ByteBuffer.", e);
                    return null;
                }
            }
        });
    }
}
