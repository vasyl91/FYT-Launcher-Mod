package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NPOIFSStream implements Iterable<ByteBuffer> {
    private BlockStore blockStore;
    private OutputStream outStream;
    private int startBlock;

    public NPOIFSStream(BlockStore blockStore, int i) {
        this.blockStore = blockStore;
        this.startBlock = i;
    }

    public NPOIFSStream(BlockStore blockStore) {
        this.blockStore = blockStore;
        this.startBlock = -2;
    }

    public int getStartBlock() {
        return this.startBlock;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return getBlockIterator();
    }

    public Iterator<ByteBuffer> getBlockIterator() {
        if (this.startBlock == -2) {
            throw new IllegalStateException("Can't read from a new stream before it has been written to");
        }
        return new StreamBlockByteBufferIterator(this.startBlock);
    }

    public void updateContents(byte[] bArr) throws IOException {
        OutputStream outputStream = getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
    }

    public OutputStream getOutputStream() throws IOException {
        if (this.outStream == null) {
            this.outStream = new StreamBlockByteBuffer();
        }
        return this.outStream;
    }

    public void free() throws IOException {
        free(this.blockStore.getChainLoopDetector());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void free(BlockStore.ChainLoopDetector chainLoopDetector) {
        int i = this.startBlock;
        while (i != -2) {
            chainLoopDetector.claim(i);
            int nextBlock = this.blockStore.getNextBlock(i);
            this.blockStore.setNextBlock(i, -1);
            i = nextBlock;
        }
        this.startBlock = -2;
    }

    protected class StreamBlockByteBufferIterator implements Iterator<ByteBuffer> {
        private BlockStore.ChainLoopDetector loopDetector;
        private int nextBlock;

        protected StreamBlockByteBufferIterator(int i) {
            this.nextBlock = i;
            try {
                this.loopDetector = NPOIFSStream.this.blockStore.getChainLoopDetector();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextBlock != -2;
        }

        @Override // java.util.Iterator
        public ByteBuffer next() {
            int i = this.nextBlock;
            if (i == -2) {
                throw new IndexOutOfBoundsException("Can't read past the end of the stream");
            }
            try {
                this.loopDetector.claim(i);
                ByteBuffer blockAt = NPOIFSStream.this.blockStore.getBlockAt(this.nextBlock);
                this.nextBlock = NPOIFSStream.this.blockStore.getNextBlock(this.nextBlock);
                return blockAt;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected class StreamBlockByteBuffer extends OutputStream {
        ByteBuffer buffer;
        BlockStore.ChainLoopDetector loopDetector;
        int nextBlock;
        byte[] oneByte = new byte[1];
        int prevBlock = -2;

        protected StreamBlockByteBuffer() throws IOException {
            this.loopDetector = NPOIFSStream.this.blockStore.getChainLoopDetector();
            this.nextBlock = NPOIFSStream.this.startBlock;
        }

        protected void createBlockIfNeeded() throws IOException {
            ByteBuffer byteBuffer = this.buffer;
            if (byteBuffer == null || !byteBuffer.hasRemaining()) {
                int freeBlock = this.nextBlock;
                if (freeBlock == -2) {
                    freeBlock = NPOIFSStream.this.blockStore.getFreeBlock();
                    this.loopDetector.claim(freeBlock);
                    this.nextBlock = -2;
                    if (this.prevBlock != -2) {
                        NPOIFSStream.this.blockStore.setNextBlock(this.prevBlock, freeBlock);
                    }
                    NPOIFSStream.this.blockStore.setNextBlock(freeBlock, -2);
                    if (NPOIFSStream.this.startBlock == -2) {
                        NPOIFSStream.this.startBlock = freeBlock;
                    }
                } else {
                    this.loopDetector.claim(freeBlock);
                    this.nextBlock = NPOIFSStream.this.blockStore.getNextBlock(freeBlock);
                }
                this.buffer = NPOIFSStream.this.blockStore.createBlockIfNeeded(freeBlock);
                this.prevBlock = freeBlock;
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            byte[] bArr = this.oneByte;
            bArr[0] = (byte) (i & 255);
            write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            do {
                createBlockIfNeeded();
                int iMin = Math.min(this.buffer.remaining(), i2);
                this.buffer.put(bArr, i, iMin);
                i += iMin;
                i2 -= iMin;
            } while (i2 > 0);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            new NPOIFSStream(NPOIFSStream.this.blockStore, this.nextBlock).free(this.loopDetector);
            if (this.prevBlock != -2) {
                NPOIFSStream.this.blockStore.setNextBlock(this.prevBlock, -2);
            }
        }
    }
}
