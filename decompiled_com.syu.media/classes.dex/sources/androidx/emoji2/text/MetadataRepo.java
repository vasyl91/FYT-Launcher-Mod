package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final Node mRootNode = new Node(1024);
    private final Typeface mTypeface;

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        this.mEmojiCharArray = new char[metadataList.listLength() * 2];
        constructIndex(metadataList);
    }

    public static MetadataRepo create(Typeface typeface) {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, new MetadataList());
        } finally {
            TraceCompat.endSection();
        }
    }

    public static MetadataRepo create(Typeface typeface, InputStream inputStream) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, MetadataListReader.read(inputStream));
        } finally {
            TraceCompat.endSection();
        }
    }

    public static MetadataRepo create(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, MetadataListReader.read(byteBuffer));
        } finally {
            TraceCompat.endSection();
        }
    }

    public static MetadataRepo create(AssetManager assetManager, String str) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(Typeface.createFromAsset(assetManager, str), MetadataListReader.read(assetManager, str));
        } finally {
            TraceCompat.endSection();
        }
    }

    private void constructIndex(MetadataList metadataList) {
        int iListLength = metadataList.listLength();
        for (int i = 0; i < iListLength; i++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i);
            Character.toChars(emojiMetadata.getId(), this.mEmojiCharArray, i * 2);
            put(emojiMetadata);
        }
    }

    Typeface getTypeface() {
        return this.mTypeface;
    }

    int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    Node getRootNode() {
        return this.mRootNode;
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    void put(EmojiMetadata emojiMetadata) {
        Preconditions.checkNotNull(emojiMetadata, "emoji metadata cannot be null");
        Preconditions.checkArgument(emojiMetadata.getCodepointsLength() > 0, "invalid metadata codepoint length");
        this.mRootNode.put(emojiMetadata, 0, emojiMetadata.getCodepointsLength() - 1);
    }

    static class Node {
        private final SparseArray<Node> mChildren;
        private EmojiMetadata mData;

        private Node() {
            this(1);
        }

        Node(int i) {
            this.mChildren = new SparseArray<>(i);
        }

        Node get(int i) {
            SparseArray<Node> sparseArray = this.mChildren;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }

        final EmojiMetadata getData() {
            return this.mData;
        }

        void put(EmojiMetadata emojiMetadata, int i, int i2) {
            Node node = get(emojiMetadata.getCodepointAt(i));
            if (node == null) {
                node = new Node();
                this.mChildren.put(emojiMetadata.getCodepointAt(i), node);
            }
            if (i2 > i) {
                node.put(emojiMetadata, i + 1, i2);
            } else {
                node.mData = emojiMetadata;
            }
        }
    }
}
