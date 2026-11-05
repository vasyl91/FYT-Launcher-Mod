package com.syu.media.companion.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import androidx.collection.LruCache;
import chip.FinalChip;
import com.jakewharton.disklrucache.DiskLruCache;
import com.syu.media.MediaApp;
import com.syu.media.MediaFiles;
import com.syu.media.companion.utils.Random;
import com.syu.media.provider.Media;
import com.syu.utils.BitmapUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CoverCache.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u0002H\u0014J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010%\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u0003J$\u0010&\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0002H\u0016J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0003H\u0014J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002R\u000e\u0010\b\u001a\u00020\u0002X\u0082D¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/syu/media/companion/cache/CoverCache;", "Landroidx/collection/LruCache;", FinalChip.BSP_PLATFORM_Null, "Landroid/graphics/Bitmap;", "Lcom/syu/media/MediaFiles$CoverHandler;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "albumPrefix", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cacheList$delegate", "Lkotlin/Lazy;", "mCache", "Lcom/jakewharton/disklrucache/DiskLruCache;", "kotlin.jvm.PlatformType", "getMCache", "()Lcom/jakewharton/disklrucache/DiskLruCache;", "mCache$delegate", "nonce", FinalChip.BSP_PLATFORM_Null, "create", "key", "createAlbumCover", Media.PATH, "entryRemoved", FinalChip.BSP_PLATFORM_Null, "evicted", FinalChip.BSP_PLATFORM_Null, "oldValue", "newValue", "handleAudioCover", "bitmap", "handleVideoCover", "inFile", "loadedCover", "bitmapString", "removeWith", "dirPath", "sizeOf", "value", "toHexString", "string", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoverCache extends LruCache<String, Bitmap> implements MediaFiles.CoverHandler {
    private final String albumPrefix;

    /* JADX INFO: renamed from: cacheList$delegate, reason: from kotlin metadata */
    private final Lazy cacheList;
    private final Context ctx;

    /* JADX INFO: renamed from: mCache$delegate, reason: from kotlin metadata */
    private final Lazy mCache;
    private int nonce;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
    }

    @Override // com.syu.media.MediaFiles.CoverHandler
    public Bitmap handleAudioCover(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return bitmap;
    }

    @Override // com.syu.media.MediaFiles.CoverHandler
    public void loadedCover(String path, String bitmapString, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(path, Media.PATH);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverCache(Context context) {
        super(16777216);
        Intrinsics.checkNotNullParameter(context, "ctx");
        this.ctx = context;
        this.albumPrefix = Media.ALBUM;
        this.nonce = -1;
        this.cacheList = LazyKt.lazy(new Function0<ArrayList<String>>() { // from class: com.syu.media.companion.cache.CoverCache$cacheList$2
            public final ArrayList<String> invoke() {
                return new ArrayList<>();
            }
        });
        this.mCache = LazyKt.lazy(new Function0<DiskLruCache>() { // from class: com.syu.media.companion.cache.CoverCache$mCache$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final DiskLruCache m138invoke() {
                return DiskLruCache.open(this.this$0.ctx.getCacheDir(), 1, 1, 134217728L);
            }
        });
    }

    private final ArrayList<String> getCacheList() {
        return (ArrayList) this.cacheList.getValue();
    }

    private final DiskLruCache getMCache() {
        return (DiskLruCache) this.mCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public int sizeOf(String key, Bitmap value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return value.getByteCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public Bitmap create(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        toHexString(key);
        Bitmap bitmapCreateAlbumCover = createAlbumCover(key);
        if (bitmapCreateAlbumCover == null) {
            this.nonce = Random.INSTANCE.random(1, 10, this.nonce);
            bitmapCreateAlbumCover = BitmapFactory.decodeResource(this.ctx.getResources(), this.ctx.getResources().getIdentifier(this.albumPrefix + this.nonce, "drawable", this.ctx.getPackageName()));
        }
        if (bitmapCreateAlbumCover == null) {
            return null;
        }
        if (getCacheList().contains(key)) {
            return bitmapCreateAlbumCover;
        }
        getCacheList().add(key);
        return bitmapCreateAlbumCover;
    }

    public final void inFile(Bitmap bitmap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/my_image.jpg");
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println((Object) "成功将位图写入文件目录！");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("无法将位图写入文件目录。错误信息：" + e.getMessage());
        }
    }

    @Override // com.syu.media.MediaFiles.CoverHandler
    public void removeWith(String dirPath) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        synchronized (this) {
            ArrayList<String> cacheList = getCacheList();
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : cacheList) {
                if (StringsKt.startsWith$default((String) obj, dirPath, false, 2, (Object) null)) {
                    arrayList.add(obj);
                }
            }
            for (String str : arrayList) {
                remove(str);
                getCacheList().remove(str);
                getMCache().remove(toHexString(str));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.syu.media.MediaFiles.CoverHandler
    public synchronized Bitmap handleVideoCover(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return bitmap;
    }

    private final Bitmap createAlbumCover(String path) throws IOException {
        Bitmap bitmapDecodeByteArray;
        Bitmap bitmap = null;
        if (!MediaApp.INSTANCE.getMe().isMounted(path)) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(path);
        } catch (Exception unused) {
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
        if (frameAtTime == null || (bitmapHandleAudioCover = handleVideoCover(BitmapUtils.INSTANCE.scaleNotDeform(frameAtTime, 360.0f, 200.0f, false))) == null) {
            byte[] embeddedPicture = mediaMetadataRetriever.getEmbeddedPicture();
            if (embeddedPicture != null && (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(embeddedPicture, 0, embeddedPicture.length)) != null) {
                Intrinsics.checkNotNullExpressionValue(bitmapDecodeByteArray, "decodeByteArray(it, 0, it.size)");
                Bitmap bitmapHandleAudioCover = handleAudioCover(bitmapDecodeByteArray);
                bitmap = bitmapHandleAudioCover;
            }
        } else {
            bitmap = bitmapHandleAudioCover;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            mediaMetadataRetriever.close();
        }
        return bitmap;
    }

    public final String toHexString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return String.valueOf(string.hashCode());
    }
}
