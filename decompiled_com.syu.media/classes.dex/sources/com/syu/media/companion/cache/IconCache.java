package com.syu.media.companion.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import chip.FinalChip;
import com.syu.media.MediaFiles;
import com.syu.media.companion.utils.Random;
import com.syu.media.provider.Media;
import com.syu.utils.BitmapUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IconCache.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/syu/media/companion/cache/IconCache;", "Lcom/syu/media/MediaFiles$CoverHandler;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "albumPrefix", FinalChip.BSP_PLATFORM_Null, "covers", "Ljava/util/HashMap;", "Lcom/syu/media/companion/cache/IconCache$Cover;", "Lkotlin/collections/HashMap;", "nonce", FinalChip.BSP_PLATFORM_Null, "create", "Landroid/graphics/Bitmap;", "key", "createAlbumCover", Media.PATH, "get", "handleAudioCover", "bitmap", "handleVideoCover", "loadedCover", FinalChip.BSP_PLATFORM_Null, "bitmapString", "removeWith", "dirPath", "Cover", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IconCache implements MediaFiles.CoverHandler {
    private final String albumPrefix;
    private final HashMap<String, Cover> covers;
    private final Context ctx;
    private int nonce;

    @Override // com.syu.media.MediaFiles.CoverHandler
    public Bitmap handleAudioCover(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return bitmap;
    }

    /* JADX INFO: compiled from: IconCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006!"}, d2 = {"Lcom/syu/media/companion/cache/IconCache$Cover;", FinalChip.BSP_PLATFORM_Null, "source", FinalChip.BSP_PLATFORM_Null, "hasCover", FinalChip.BSP_PLATFORM_Null, "bitmapString", "bitmap", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;ZLjava/lang/String;Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getBitmapString", "()Ljava/lang/String;", "setBitmapString", "(Ljava/lang/String;)V", "getHasCover", "()Z", "setHasCover", "(Z)V", "getSource", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", FinalChip.BSP_PLATFORM_Null, "toString", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Cover {
        private Bitmap bitmap;
        private String bitmapString;
        private boolean hasCover;
        private final String source;

        public static /* synthetic */ Cover copy$default(Cover cover, String str, boolean z, String str2, Bitmap bitmap, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cover.source;
            }
            if ((i & 2) != 0) {
                z = cover.hasCover;
            }
            if ((i & 4) != 0) {
                str2 = cover.bitmapString;
            }
            if ((i & 8) != 0) {
                bitmap = cover.bitmap;
            }
            return cover.copy(str, z, str2, bitmap);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasCover() {
            return this.hasCover;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBitmapString() {
            return this.bitmapString;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Cover copy(String source, boolean hasCover, String bitmapString, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new Cover(source, hasCover, bitmapString, bitmap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cover)) {
                return false;
            }
            Cover cover = (Cover) other;
            return Intrinsics.areEqual(this.source, cover.source) && this.hasCover == cover.hasCover && Intrinsics.areEqual(this.bitmapString, cover.bitmapString) && Intrinsics.areEqual(this.bitmap, cover.bitmap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            int iHashCode = this.source.hashCode() * 31;
            boolean z = this.hasCover;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            String str = this.bitmapString;
            int iHashCode2 = (i + (str == null ? 0 : str.hashCode())) * 31;
            Bitmap bitmap = this.bitmap;
            return iHashCode2 + (bitmap != null ? bitmap.hashCode() : 0);
        }

        public String toString() {
            return "Cover(source=" + this.source + ", hasCover=" + this.hasCover + ", bitmapString=" + this.bitmapString + ", bitmap=" + this.bitmap + ')';
        }

        public Cover(String str, boolean z, String str2, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(str, "source");
            this.source = str;
            this.hasCover = z;
            this.bitmapString = str2;
            this.bitmap = bitmap;
        }

        public /* synthetic */ Cover(String str, boolean z, String str2, Bitmap bitmap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bitmap);
        }

        public final String getSource() {
            return this.source;
        }

        public final boolean getHasCover() {
            return this.hasCover;
        }

        public final void setHasCover(boolean z) {
            this.hasCover = z;
        }

        public final String getBitmapString() {
            return this.bitmapString;
        }

        public final void setBitmapString(String str) {
            this.bitmapString = str;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
        }
    }

    public IconCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        this.ctx = context;
        this.albumPrefix = Media.ALBUM;
        this.nonce = -1;
        this.covers = new HashMap<>();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0084 A[Catch: all -> 0x0103, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0014, B:7:0x0026, B:13:0x0042, B:16:0x0045, B:17:0x0046, B:18:0x0047, B:20:0x0052, B:22:0x0058, B:24:0x005e, B:26:0x006b, B:28:0x0073, B:36:0x0088, B:41:0x00f6, B:33:0x007e, B:35:0x0084, B:37:0x008c, B:40:0x00d3, B:42:0x00fd, B:8:0x0027, B:12:0x0034), top: B:48:0x0005, inners: #1 }] */
    public final synchronized Bitmap get(String key) {
        Bitmap bitmap;
        Bitmap bitmapCreate;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.covers.containsKey(key)) {
            Log.d("LZP", "!covers.containsKey(key)" + key);
            synchronized (this) {
                Bitmap bitmapCreate2 = create(key);
                this.covers.put(key, new Cover(key, bitmapCreate2 != null, null, bitmapCreate2, 4, null));
            }
        }
        Cover cover = this.covers.get(key);
        bitmap = null;
        if (cover != null) {
            if (cover.getBitmap() == null) {
                if (cover.getHasCover()) {
                    Log.d("LZP", "it.bitmap == null");
                    String bitmapString = cover.getBitmapString();
                    if (bitmapString != null) {
                        Bitmap bitmapBase64ToBitmap = BitmapUtils.INSTANCE.base64ToBitmap(bitmapString);
                        Bitmap bitmapHandleAudioCover = bitmapBase64ToBitmap != null ? handleAudioCover(bitmapBase64ToBitmap) : null;
                        if (bitmapHandleAudioCover == null) {
                            bitmapCreate = create(key);
                            if (bitmapCreate != null) {
                                bitmap = handleVideoCover(bitmapCreate);
                            }
                        } else {
                            bitmap = bitmapHandleAudioCover;
                        }
                    } else {
                        bitmapCreate = create(key);
                        if (bitmapCreate != null) {
                            bitmap = handleVideoCover(bitmapCreate);
                        }
                    }
                    cover.setBitmap(bitmap);
                } else {
                    this.nonce = Random.INSTANCE.random(1, 10, this.nonce);
                    cover.setBitmap(BitmapFactory.decodeResource(this.ctx.getResources(), this.ctx.getResources().getIdentifier(this.albumPrefix + this.nonce, "drawable", this.ctx.getPackageName())));
                    cover.setHasCover(cover.getBitmap() != null);
                    Log.d("LZP", "key:" + key + " ,it.hasCover:" + cover.getHasCover());
                }
                this.covers.put(key, cover);
            }
            bitmap = cover.getBitmap();
        }
        return bitmap;
    }

    private final Bitmap create(String key) {
        return createAlbumCover(key);
    }

    @Override // com.syu.media.MediaFiles.CoverHandler
    public synchronized Bitmap handleVideoCover(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return bitmap;
    }

    @Override // com.syu.media.MediaFiles.CoverHandler
    public void removeWith(String dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Cover> entry : this.covers.entrySet()) {
                if (StringsKt.startsWith$default(entry.getKey(), dirPath, false, 2, (Object) null)) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.covers.remove((String) it.next());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.MediaFiles.CoverHandler
    public void loadedCover(String path, String bitmapString, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        synchronized (this) {
            if (bitmap != null) {
                this.covers.put(path, new Cover(path, true, bitmapString, bitmap));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Bitmap createAlbumCover(String path) throws IOException {
        Bitmap bitmapDecodeByteArray;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(path);
        } catch (Exception unused) {
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
        if (frameAtTime == null || (bitmapDecodeByteArray = handleVideoCover(BitmapUtils.scaleNotDeform$default(BitmapUtils.INSTANCE, frameAtTime, 360.0f, 200.0f, false, 8, (Object) null))) == null) {
            byte[] embeddedPicture = mediaMetadataRetriever.getEmbeddedPicture();
            if (embeddedPicture != null) {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(embeddedPicture, 0, embeddedPicture.length);
                if (bitmapDecodeByteArray != null) {
                    handleAudioCover(bitmapDecodeByteArray);
                }
            } else {
                bitmapDecodeByteArray = null;
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            mediaMetadataRetriever.close();
        }
        mediaMetadataRetriever.release();
        return bitmapDecodeByteArray;
    }
}
