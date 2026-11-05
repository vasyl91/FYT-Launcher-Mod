package com.syu.media.companion.cache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import chip.FinalChip;
import com.syu.media.MediaApp;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.Random;
import com.syu.media.provider.Media;
import com.syu.radio.Radio;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RadioIconCache.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0006H\u0003J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/syu/media/companion/cache/RadioIconCache;", FinalChip.BSP_PLATFORM_Null, "ctx", "Lcom/syu/media/MediaApp;", "(Lcom/syu/media/MediaApp;)V", "albumPrefix", FinalChip.BSP_PLATFORM_Null, "covers", "Ljava/util/HashMap;", FinalChip.BSP_PLATFORM_Null, "Lkotlin/collections/HashMap;", "covers2", "Lcom/syu/media/companion/cache/RadioIconCache$Cover;", "dir", "nonce", "coverSave", FinalChip.BSP_PLATFORM_Null, Media.PATH, "get", "Landroid/graphics/Bitmap;", "key", "getName", "resNameById", "name", "text2Freq", "freq", "Companion", "Cover", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioIconCache {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG;
    private final String albumPrefix;
    private final HashMap<Integer, String> covers;
    private final HashMap<Integer, Cover> covers2;
    private final MediaApp ctx;
    private String dir;
    private int nonce;

    /* JADX INFO: compiled from: RadioIconCache.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/syu/media/companion/cache/RadioIconCache$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "TAG", FinalChip.BSP_PLATFORM_Null, "getTAG", "()Ljava/lang/String;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return RadioIconCache.TAG;
        }
    }

    public RadioIconCache(MediaApp mediaApp) {
        Intrinsics.checkNotNullParameter(mediaApp, "ctx");
        this.ctx = mediaApp;
        this.albumPrefix = Media.ONLINE_TABLE;
        this.dir = FinalChip.BSP_PLATFORM_Null;
        this.nonce = -1;
        this.covers = new HashMap<>();
        this.covers2 = new HashMap<>();
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(RadioIconCache.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TAG = simpleName;
    }

    /* JADX INFO: compiled from: RadioIconCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/syu/media/companion/cache/RadioIconCache$Cover;", FinalChip.BSP_PLATFORM_Null, "freq", FinalChip.BSP_PLATFORM_Null, "name", FinalChip.BSP_PLATFORM_Null, "filePath", "(ILjava/lang/String;Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFreq", "()I", "getName", "setName", "component1", "component2", "component3", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", "toString", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Cover {
        private String filePath;
        private final int freq;
        private String name;

        public static /* synthetic */ Cover copy$default(Cover cover, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cover.freq;
            }
            if ((i2 & 2) != 0) {
                str = cover.name;
            }
            if ((i2 & 4) != 0) {
                str2 = cover.filePath;
            }
            return cover.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFreq() {
            return this.freq;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        public final Cover copy(int freq, String name, String filePath) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            return new Cover(freq, name, filePath);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cover)) {
                return false;
            }
            Cover cover = (Cover) other;
            return this.freq == cover.freq && Intrinsics.areEqual(this.name, cover.name) && Intrinsics.areEqual(this.filePath, cover.filePath);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.freq) * 31) + this.name.hashCode()) * 31) + this.filePath.hashCode();
        }

        public String toString() {
            return "Cover(freq=" + this.freq + ", name=" + this.name + ", filePath=" + this.filePath + ')';
        }

        public Cover(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "filePath");
            this.freq = i;
            this.name = str;
            this.filePath = str2;
        }

        public final int getFreq() {
            return this.freq;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final void setFilePath(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.filePath = str;
        }
    }

    public final synchronized Bitmap get(int key) {
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        StringBuilder sbAppend = new StringBuilder("key:").append(key).append(" ,path:");
        Cover cover = this.covers2.get(Integer.valueOf(key));
        hiLog.d(str, sbAppend.append(cover != null ? cover.getFilePath() : null).toString());
        if (this.covers2.containsKey(Integer.valueOf(key))) {
            HiLog hiLog2 = HiLog.INSTANCE;
            StringBuilder sbAppend2 = new StringBuilder("key:").append(key).append(" ,path:");
            Cover cover2 = this.covers2.get(Integer.valueOf(key));
            hiLog2.d(str, sbAppend2.append(cover2 != null ? cover2.getFilePath() : null).toString());
            Cover cover3 = this.covers2.get(Integer.valueOf(key));
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(cover3 != null ? cover3.getFilePath() : null);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeFile, "decodeFile(covers2[key]?.filePath)");
            return bitmapDecodeFile;
        }
        if (!this.covers.containsKey(Integer.valueOf(key))) {
            this.nonce = Random.INSTANCE.random(1, 3, this.nonce);
            this.covers.put(Integer.valueOf(key), this.albumPrefix + this.nonce);
        }
        Resources resources = this.ctx.getResources();
        String str2 = this.covers.get(Integer.valueOf(key));
        Intrinsics.checkNotNull(str2);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, resNameById(str2));
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(ctx.resou…sNameById(covers[key]!!))");
        return bitmapDecodeResource;
    }

    public final synchronized String getName(int key) {
        String str;
        Cover cover;
        String name;
        str = FinalChip.BSP_PLATFORM_Null;
        if (this.covers2.containsKey(Integer.valueOf(key)) && (cover = this.covers2.get(Integer.valueOf(key))) != null && (name = cover.getName()) != null) {
            str = name;
        }
        return str;
    }

    private final int resNameById(String name) {
        return this.ctx.getResources().getIdentifier(name, "drawable", this.ctx.getPackageName());
    }

    public static /* synthetic */ void coverSave$default(RadioIconCache radioIconCache, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = FinalChip.BSP_PLATFORM_Null;
        }
        radioIconCache.coverSave(str);
    }

    public final void coverSave(String path) {
        String str;
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        if (!Intrinsics.areEqual(path, this.dir)) {
            HiLog.INSTANCE.d(TAG, "coverSave path:" + path + ",dir:" + this.dir);
            this.covers2.clear();
        }
        if (path.length() > 0) {
            this.dir = path;
            str = File.separator + path;
        } else {
            str = FinalChip.BSP_PLATFORM_Null;
        }
        File file = new File(MediaApp.INSTANCE.getInternalPath(), "radio_logo" + str);
        HiLog.INSTANCE.d(TAG, "coverSave filename:" + file.getAbsolutePath());
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNull(fileArrListFiles);
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "fileName.name");
                    List listSplit$default = StringsKt.split$default(name, new String[]{"_"}, false, 0, 6, (Object) null);
                    if (listSplit$default.size() == 2) {
                        String name2 = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "fileName.name");
                        if (StringsKt.endsWith$default(name2, ".png", false, 2, (Object) null)) {
                            String str2 = (String) listSplit$default.get(0);
                            String strSubstring = ((String) listSplit$default.get(1)).substring(0, ((String) listSplit$default.get(1)).length() - 4);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                            HiLog.INSTANCE.d(TAG, "coverSave freq:" + strSubstring);
                            int iText2Freq = text2Freq(strSubstring);
                            String str3 = file.getAbsolutePath() + File.separator + file2.getName();
                            if (!this.covers2.containsKey(Integer.valueOf(iText2Freq)) && iText2Freq != -1) {
                                this.covers2.put(Integer.valueOf(iText2Freq), new Cover(iText2Freq, str2, str3));
                                arrayList.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("freq", Integer.valueOf(iText2Freq)), TuplesKt.to("title", str2), TuplesKt.to(Radio.COVER, str3)}));
                            }
                        }
                    }
                }
            }
        }
    }

    private final int text2Freq(String freq) {
        try {
            return Integer.parseInt(StringsKt.replace$default(freq, ".", FinalChip.BSP_PLATFORM_Null, false, 4, (Object) null));
        } catch (Exception unused) {
            return -1;
        }
    }
}
