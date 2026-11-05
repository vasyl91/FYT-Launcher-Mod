package com.syu.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.VideoSource;
import com.syu.media.provider.Media;
import com.syu.utils.BitmapUtils;
import com.syu.utils.FolderObserver;
import com.syu.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FileWalkDirection;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.utils.StorageUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 X2\u00020\u0001:\u0006XYZ[\\]B\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0018\u0012\u0006\u0010'\u001a\u00020 ¢\u0006\u0004\bV\u0010WJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\nR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u00100\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R*\u0010F\u001a\u00020?2\u0006\u0010)\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010J\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010A\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER$\u0010R\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR*\u0010T\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010:\u001a\u0004\bT\u0010<\"\u0004\bU\u0010>¨\u0006^"}, d2 = {"Lcom/syu/media/MediaFiles;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", FinalChip.BSP_PLATFORM_Null, "monitorUDiskMount", "removeMonitorUDiskMount", "Landroid/content/Intent;", "intent", "onReceive", FinalChip.BSP_PLATFORM_Null, "rootFolder", FinalChip.BSP_PLATFORM_Null, "exists", "Landroid/os/Handler;", "workHandler", "scanMounted", Media.PATH, "stopAndRemoveTask", "Landroid/graphics/Bitmap;", "createAlbumCover", "isMounted", "fileName", "InsertIfExist", "Lcom/syu/media/MediaFiles$MediaFilter;", "a", "Lcom/syu/media/MediaFiles$MediaFilter;", "getMediaFilter", "()Lcom/syu/media/MediaFiles$MediaFilter;", "setMediaFilter", "(Lcom/syu/media/MediaFiles$MediaFilter;)V", "mediaFilter", "Lcom/syu/media/dao/MediaDao;", "b", "Lcom/syu/media/dao/MediaDao;", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "setMediaDao", "(Lcom/syu/media/dao/MediaDao;)V", "mediaDao", "Lcom/syu/media/MediaFiles$OnStorageDeviceChangeListener;", "value", "c", "Lcom/syu/media/MediaFiles$OnStorageDeviceChangeListener;", "getOnStorageDeviceChangeListener", "()Lcom/syu/media/MediaFiles$OnStorageDeviceChangeListener;", "setOnStorageDeviceChangeListener", "(Lcom/syu/media/MediaFiles$OnStorageDeviceChangeListener;)V", "onStorageDeviceChangeListener", FinalChip.BSP_PLATFORM_Null, "d", "J", "getMCheckDelay", "()J", "setMCheckDelay", "(J)V", "mCheckDelay", "e", "Z", "isRegistered", "()Z", "setRegistered", "(Z)V", FinalChip.BSP_PLATFORM_Null, "f", "I", "getScanPriority", "()I", "setScanPriority", "(I)V", "scanPriority", "g", "getSecondPriority", "setSecondPriority", "secondPriority", "Lcom/syu/media/MediaFiles$CoverHandler;", "h", "Lcom/syu/media/MediaFiles$CoverHandler;", "getMCoverHandler", "()Lcom/syu/media/MediaFiles$CoverHandler;", "setMCoverHandler", "(Lcom/syu/media/MediaFiles$CoverHandler;)V", "mCoverHandler", "o", "isWaiting", "setWaiting", "<init>", "(Lcom/syu/media/MediaFiles$MediaFilter;Lcom/syu/media/dao/MediaDao;)V", "Companion", "CoverHandler", "DeviceObserver", "MediaFilter", "OnStorageDeviceChangeListener", "Task", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class MediaFiles extends BroadcastReceiver {
    public static final int PRIORITY_AUDIO = 1;
    public static final int PRIORITY_NULL = 0;
    public static final int PRIORITY_VIDEO = 2;
    public static final String TAG = "MediaFiles";
    public static final int UPDATE_DELAY_MAX = 4000;
    public static final int UPDATE_DELAY_MIN = 1500;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public MediaFilter mediaFilter;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public MediaDao mediaDao;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public OnStorageDeviceChangeListener onStorageDeviceChangeListener;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public long mCheckDelay;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean isRegistered;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int scanPriority;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int secondPriority;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public CoverHandler mCoverHandler;
    public final Lazy i;
    public final ArrayList j;
    public final LinkedHashMap k;
    public final LinkedHashMap l;
    public final LinkedHashSet m;
    public final LinkedHashSet n;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public boolean isWaiting;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String p = "NULL";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/syu/media/MediaFiles$Companion;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "UNKNOWN", "Ljava/lang/String;", "getUNKNOWN", "()Ljava/lang/String;", FinalChip.BSP_PLATFORM_Null, "PRIORITY_AUDIO", "I", "PRIORITY_NULL", "PRIORITY_VIDEO", "TAG", "UPDATE_DELAY_MAX", "UPDATE_DELAY_MIN", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getUNKNOWN() {
            return MediaFiles.p;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/syu/media/MediaFiles$CoverHandler;", FinalChip.BSP_PLATFORM_Null, "handleAudioCover", "Landroid/graphics/Bitmap;", "bitmap", "handleVideoCover", "loadedCover", FinalChip.BSP_PLATFORM_Null, Media.PATH, FinalChip.BSP_PLATFORM_Null, "bitmapString", "removeWith", "dirPath", "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface CoverHandler {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void loadedCover$default(CoverHandler coverHandler, String str, String str2, Bitmap bitmap, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadedCover");
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    bitmap = null;
                }
                coverHandler.loadedCover(str, str2, bitmap);
            }
        }

        Bitmap handleAudioCover(Bitmap bitmap);

        Bitmap handleVideoCover(Bitmap bitmap);

        void loadedCover(String path, String bitmapString, Bitmap bitmap);

        void removeWith(String dirPath);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/syu/media/MediaFiles$DeviceObserver;", "Landroid/os/FileObserver;", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_EVENT, FinalChip.BSP_PLATFORM_Null, Media.PATH, FinalChip.BSP_PLATFORM_Null, "onEvent", "stopWatching", "startWatching", "a", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "<init>", "(Lcom/syu/media/MediaFiles;Ljava/lang/String;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
    public final class DeviceObserver extends FileObserver {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final String path;
        public final Lazy b;
        public FolderObserver c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceObserver(final MediaFiles mediaFiles, String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, Media.PATH);
            this.path = str;
            this.b = LazyKt.lazy(new Function0<MediaFiles$DeviceObserver$mEventHandler$2.AnonymousClass1>() { // from class: com.syu.media.MediaFiles$DeviceObserver$mEventHandler$2

                /* JADX INFO: renamed from: com.syu.media.MediaFiles$DeviceObserver$mEventHandler$2$1, reason: invalid class name */
                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/syu/media/MediaFiles$DeviceObserver$mEventHandler$2$1", "Lcom/syu/utils/FolderObserver$EventHandler;", "onEvent", FinalChip.BSP_PLATFORM_Null, NotificationCompat.CATEGORY_EVENT, FinalChip.BSP_PLATFORM_Null, Media.PATH, FinalChip.BSP_PLATFORM_Null, "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
                public static final class AnonymousClass1 implements FolderObserver.EventHandler {
                    public final /* synthetic */ MediaFiles.DeviceObserver a;
                    public final /* synthetic */ MediaFiles b;

                    public AnonymousClass1(MediaFiles.DeviceObserver deviceObserver, MediaFiles mediaFiles) {
                        this.a = deviceObserver;
                        this.b = mediaFiles;
                    }

                    public static final void a(MediaFiles mediaFiles, String str) {
                        Intrinsics.checkNotNullParameter(mediaFiles, "this$0");
                        Intrinsics.checkNotNullParameter(str, "$it");
                        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MediaFiles$DeviceObserver$mEventHandler$2$1$onEvent$1$1$1(mediaFiles, str, null), 3, (Object) null);
                        MediaFiles.CoverHandler mCoverHandler = mediaFiles.getMCoverHandler();
                        if (mCoverHandler != null) {
                            mCoverHandler.removeWith(str);
                        }
                    }

                    public void onEvent(int event, final String path) {
                        boolean z;
                        CoroutineScope CoroutineScope;
                        Function2 mediaFiles$DeviceObserver$mEventHandler$2$1$onEvent$2$2;
                        StringBuilder sb;
                        if (event != 8) {
                            if (event == 256) {
                                sb = new StringBuilder("------>>> CREATE -- path: ");
                            } else {
                                if (event == 512) {
                                    Log.e(MediaFiles.TAG, "------>>> DELETE -- Dev path: " + this.a.getPath() + " path: " + path);
                                    if (path != null) {
                                        final MediaFiles mediaFiles = this.b;
                                        MediaFiles.access$getWorkHandler(mediaFiles).post(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE 
                                              (wrap android.os.Handler:0x0042: INVOKE (r14v11 'mediaFiles' com.syu.media.MediaFiles) STATIC call: com.syu.media.MediaFiles.access$getWorkHandler(com.syu.media.MediaFiles):android.os.Handler A[MD:(com.syu.media.MediaFiles):android.os.Handler (m), WRAPPED])
                                              (wrap java.lang.Runnable:0x0048: CONSTRUCTOR (r14v11 'mediaFiles' com.syu.media.MediaFiles A[DONT_INLINE]), (r15v0 'path' java.lang.String A[DONT_INLINE]) A[MD:(com.syu.media.MediaFiles, java.lang.String):void (m), WRAPPED] call: com.syu.media.MediaFiles$DeviceObserver$mEventHandler$2$1$$ExternalSyntheticLambda0.<init>(com.syu.media.MediaFiles, java.lang.String):void type: CONSTRUCTOR)
                                             VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] in method: com.syu.media.MediaFiles$DeviceObserver$mEventHandler$2.1.onEvent(int, java.lang.String):void, file: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:487)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.syu.media.MediaFiles$DeviceObserver$mEventHandler$2$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 137 more
                                            */
                                        /*
                                            Method dump skipped, instruction units count: 253
                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.syu.media.MediaFiles$DeviceObserver$mEventHandler$2.AnonymousClass1.onEvent(int, java.lang.String):void");
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final AnonymousClass1 m95invoke() {
                                    return new AnonymousClass1(this.a, mediaFiles);
                                }
                            });
                            this.c = new FolderObserver(str, a());
                        }

                        public final MediaFiles$DeviceObserver$mEventHandler$2.AnonymousClass1 a() {
                            return (MediaFiles$DeviceObserver$mEventHandler$2.AnonymousClass1) this.b.getValue();
                        }

                        public final String getPath() {
                            return this.path;
                        }

                        @Override // android.os.FileObserver
                        public void onEvent(int event, String path) {
                        }

                        @Override // android.os.FileObserver
                        public void startWatching() {
                            Log.e(MediaFiles.TAG, "------>>>Dev startWatching path: " + this.path);
                            FolderObserver folderObserver = this.c;
                            if (folderObserver != null) {
                                folderObserver.startWatching();
                            }
                        }

                        @Override // android.os.FileObserver
                        public void stopWatching() {
                            Log.e(MediaFiles.TAG, "------>>> Dev stopWatching path: " + this.path);
                            FolderObserver folderObserver = this.c;
                            if (folderObserver != null) {
                                folderObserver.stopWatching();
                            }
                            this.c = null;
                        }
                    }

                    /* JADX INFO: renamed from: com.syu.media.MediaFiles$InsertIfExist$1, reason: invalid class name */
                    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
                    @DebugMetadata(c = "com.syu.media.MediaFiles$InsertIfExist$1", f = "MediaFiles.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        public final /* synthetic */ File b;
                        public final /* synthetic */ String c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(File file, String str, Continuation continuation) {
                            super(2, continuation);
                            this.b = file;
                            this.c = str;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return MediaFiles.this.new AnonymousClass1(this.b, this.c, continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            VideoSource videoSourceAccess$file2VideoSource;
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            ResultKt.throwOnFailure(obj);
                            boolean zAccess$isAudioSource = MediaFiles.access$isAudioSource(MediaFiles.this, this.b);
                            boolean zAccess$isVideoSource = MediaFiles.access$isVideoSource(MediaFiles.this, this.b);
                            if (zAccess$isAudioSource) {
                                AudioSource audioSourceAccess$file2AudioSource = MediaFiles.access$file2AudioSource(MediaFiles.this, this.b);
                                if (audioSourceAccess$file2AudioSource != null) {
                                    MediaFiles mediaFiles = MediaFiles.this;
                                    if (mediaFiles.getMediaDao().getExistsAudioSource(this.c) == null) {
                                        mediaFiles.getMediaDao().insert(audioSourceAccess$file2AudioSource);
                                    }
                                }
                            } else if (zAccess$isVideoSource && (videoSourceAccess$file2VideoSource = MediaFiles.access$file2VideoSource(MediaFiles.this, this.b)) != null) {
                                MediaFiles mediaFiles2 = MediaFiles.this;
                                if (mediaFiles2.getMediaDao().getExistsVideoSource(this.c) == null) {
                                    mediaFiles2.getMediaDao().insert(videoSourceAccess$file2VideoSource);
                                }
                            }
                            return Unit.INSTANCE;
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BA\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/syu/media/MediaFiles$MediaFilter;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "a", "[Ljava/lang/String;", "getIgnoreDirs", "()[Ljava/lang/String;", "ignoreDirs", FinalChip.BSP_PLATFORM_Null, "b", "I", "getFileMinLength", "()I", "fileMinLength", "c", "getAudioSuffixes", "audioSuffixes", "d", "getVideoSuffixes", "videoSuffixes", "<init>", "([Ljava/lang/String;I[Ljava/lang/String;[Ljava/lang/String;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
                    public static final class MediaFilter {

                        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
                        public final String[] ignoreDirs;

                        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
                        public final int fileMinLength;

                        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
                        public final String[] audioSuffixes;

                        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
                        public final String[] videoSuffixes;

                        public MediaFilter() {
                            this(null, 0, null, null, 15, null);
                        }

                        public final String[] getAudioSuffixes() {
                            return this.audioSuffixes;
                        }

                        public final int getFileMinLength() {
                            return this.fileMinLength;
                        }

                        public final String[] getIgnoreDirs() {
                            return this.ignoreDirs;
                        }

                        public final String[] getVideoSuffixes() {
                            return this.videoSuffixes;
                        }

                        public MediaFilter(String[] strArr, int i, String[] strArr2, String[] strArr3) {
                            Intrinsics.checkNotNullParameter(strArr, "ignoreDirs");
                            Intrinsics.checkNotNullParameter(strArr2, "audioSuffixes");
                            Intrinsics.checkNotNullParameter(strArr3, "videoSuffixes");
                            this.ignoreDirs = strArr;
                            this.fileMinLength = i;
                            this.audioSuffixes = strArr2;
                            this.videoSuffixes = strArr3;
                        }

                        public /* synthetic */ MediaFilter(String[] strArr, int i, String[] strArr2, String[] strArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i2 & 1) != 0 ? new String[0] : strArr, (i2 & 2) != 0 ? 1024 : i, (i2 & 4) != 0 ? new String[]{"mp3", "m4a", "ogg", "wav", "aac", "flac"} : strArr2, (i2 & 8) != 0 ? new String[]{"mp4", "mkv", "rm", "rmvb", "3gp"} : strArr3);
                        }
                    }

                    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH&¨\u0006\u000b"}, d2 = {"Lcom/syu/media/MediaFiles$OnStorageDeviceChangeListener;", FinalChip.BSP_PLATFORM_Null, "onScanStateChanged", FinalChip.BSP_PLATFORM_Null, "scanning", FinalChip.BSP_PLATFORM_Null, "rootFolder", FinalChip.BSP_PLATFORM_Null, "onStorageDeviceChange", "devices", FinalChip.BSP_PLATFORM_Null, "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
                    public interface OnStorageDeviceChangeListener {
                        void onScanStateChanged(boolean scanning, String rootFolder);

                        void onStorageDeviceChange(List<String> devices);
                    }

                    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/syu/media/MediaFiles$Task;", "Ljava/lang/Thread;", FinalChip.BSP_PLATFORM_Null, "start", "run", FinalChip.BSP_PLATFORM_Null, "hashCode", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "equals", FinalChip.BSP_PLATFORM_Null, "a", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", Media.PATH, "b", "Z", "isScanning", "()Z", "setScanning", "(Z)V", "<init>", "(Lcom/syu/media/MediaFiles;Ljava/lang/String;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
                    public final class Task extends Thread {

                        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
                        public final String path;

                        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
                        public boolean isScanning;
                        public final /* synthetic */ MediaFiles c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public Task(MediaFiles mediaFiles, String str) {
                            super(str);
                            Intrinsics.checkNotNullParameter(str, Media.PATH);
                            this.c = mediaFiles;
                            this.path = str;
                        }

                        public static final void a(MediaFiles mediaFiles) {
                            Intrinsics.checkNotNullParameter(mediaFiles, "this$0");
                            MediaFiles.access$checkMounted(mediaFiles);
                        }

                        public boolean equals(Object other) {
                            if (other instanceof Task) {
                                return ((Task) other).hashCode() == hashCode();
                            }
                            return super.equals(other);
                        }

                        public final String getPath() {
                            return this.path;
                        }

                        public int hashCode() {
                            return ("Job-" + this.path).hashCode();
                        }

                        /* JADX INFO: renamed from: isScanning, reason: from getter */
                        public final boolean getIsScanning() {
                            return this.isScanning;
                        }

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() throws IOException {
                            if (this.isScanning) {
                                Log.e(MediaFiles.TAG, "createTask path: " + this.path + "  isScanning: " + this.isScanning + XmlConsts.CHAR_SPACE);
                                MediaFiles mediaFiles = this.c;
                                MediaFiles.access$processLoadMediaSource(mediaFiles, this.path, mediaFiles.getScanPriority());
                                if (this.c.getSecondPriority() > 0) {
                                    MediaFiles mediaFiles2 = this.c;
                                    MediaFiles.access$processLoadMediaSource(mediaFiles2, this.path, mediaFiles2.getSecondPriority());
                                }
                                this.isScanning = false;
                                Log.e(MediaFiles.TAG, "createTask path: " + this.path + "  isScanning: " + this.isScanning + XmlConsts.CHAR_SPACE);
                                if (Intrinsics.areEqual(this.path, "/storage/emulated/0")) {
                                    Handler handlerAccess$getWorkHandler = MediaFiles.access$getWorkHandler(this.c);
                                    final MediaFiles mediaFiles3 = this.c;
                                    handlerAccess$getWorkHandler.postDelayed(new Runnable() { // from class: com.syu.media.MediaFiles$Task$$ExternalSyntheticLambda0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            MediaFiles.Task.a(mediaFiles3);
                                        }
                                    }, this.c.getMCheckDelay());
                                }
                                OnStorageDeviceChangeListener onStorageDeviceChangeListener = this.c.getOnStorageDeviceChangeListener();
                                if (onStorageDeviceChangeListener != null) {
                                    onStorageDeviceChangeListener.onScanStateChanged(this.isScanning, this.path);
                                }
                            }
                        }

                        public final void setScanning(boolean z) {
                            this.isScanning = z;
                        }

                        @Override // java.lang.Thread
                        public void start() {
                            if (this.isScanning) {
                                return;
                            }
                            this.isScanning = true;
                            OnStorageDeviceChangeListener onStorageDeviceChangeListener = this.c.getOnStorageDeviceChangeListener();
                            if (onStorageDeviceChangeListener != null) {
                                onStorageDeviceChangeListener.onScanStateChanged(this.isScanning, this.path);
                            }
                            super.start();
                        }
                    }

                    public MediaFiles(MediaFilter mediaFilter, MediaDao mediaDao) {
                        Intrinsics.checkNotNullParameter(mediaFilter, "mediaFilter");
                        Intrinsics.checkNotNullParameter(mediaDao, "mediaDao");
                        this.mediaFilter = mediaFilter;
                        this.mediaDao = mediaDao;
                        this.mCheckDelay = 3000L;
                        this.scanPriority = 1;
                        this.i = LazyKt.lazy(new Function0<Handler>() { // from class: com.syu.media.MediaFiles.workHandler.2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Handler m96invoke() {
                                HandlerThread handlerThread = new HandlerThread("media-scan");
                                handlerThread.start();
                                return new Handler(handlerThread.getLooper());
                            }
                        });
                        this.j = new ArrayList();
                        this.k = new LinkedHashMap();
                        this.l = new LinkedHashMap();
                        this.m = new LinkedHashSet();
                        this.n = new LinkedHashSet();
                    }

                    public static final void a(MediaFiles mediaFiles, String str) {
                        Intrinsics.checkNotNullParameter(mediaFiles, "this$0");
                        Intrinsics.checkNotNullParameter(str, "$it");
                        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MediaFiles$isWaiting$1$2$1$1(mediaFiles, str, null), 3, (Object) null);
                        CoverHandler coverHandler = mediaFiles.mCoverHandler;
                        if (coverHandler != null) {
                            coverHandler.removeWith(str);
                        }
                    }

                    public static final void access$checkMounted(MediaFiles mediaFiles) {
                        mediaFiles.getClass();
                        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MediaFiles$checkMounted$1(mediaFiles, null), 3, (Object) null);
                    }

                    public static final /* synthetic */ AudioSource access$file2AudioSource(MediaFiles mediaFiles, File file) {
                        mediaFiles.getClass();
                        return a(file);
                    }

                    public static final /* synthetic */ VideoSource access$file2VideoSource(MediaFiles mediaFiles, File file) {
                        mediaFiles.getClass();
                        return b(file);
                    }

                    public static final Handler access$getWorkHandler(MediaFiles mediaFiles) {
                        return (Handler) mediaFiles.i.getValue();
                    }

                    public static final boolean access$isAudioSource(MediaFiles mediaFiles, File file) {
                        String[] audioSuffixes = mediaFiles.mediaFilter.getAudioSuffixes();
                        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        return ArraysKt.contains(audioSuffixes, lowerCase);
                    }

                    public static final boolean access$isVideoSource(MediaFiles mediaFiles, File file) {
                        String[] videoSuffixes = mediaFiles.mediaFilter.getVideoSuffixes();
                        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        return ArraysKt.contains(videoSuffixes, lowerCase);
                    }

                    /* JADX WARN: Code duplicated, block: B:30:0x012e  */
                    /* JADX WARN: Code duplicated, block: B:32:0x0134  */
                    /* JADX WARN: Code duplicated, block: B:34:0x013a  */
                    /* JADX WARN: Code duplicated, block: B:38:0x0166  */
                    /* JADX WARN: Code duplicated, block: B:40:0x016c  */
                    /* JADX WARN: Code duplicated, block: B:44:0x019a  */
                    /* JADX WARN: Code duplicated, block: B:70:0x01a3 A[SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:71:0x01a3 A[SYNTHETIC] */
                    public static final int access$processLoadMediaSource(final MediaFiles mediaFiles, String str, final int i) throws IOException {
                        String str2;
                        Iterator it;
                        long j;
                        VideoSource videoSourceB;
                        mediaFiles.getClass();
                        String str3 = TAG;
                        Log.e(TAG, "processLoadMediaSource path: " + str + "  priority: " + i + "  START!!");
                        if (!mediaFiles.exists(str)) {
                            return 0;
                        }
                        File file = new File(str);
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        int i2 = 1;
                        Iterator it2 = SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(FilesKt.walk$default(file, (FileWalkDirection) null, 1, (Object) null).maxDepth(Integer.MAX_VALUE), new Function1<File, Boolean>() { // from class: com.syu.media.MediaFiles$processLoadMediaSource$1
                            public final Boolean invoke(File file2) {
                                Intrinsics.checkNotNullParameter(file2, "it");
                                String name = file2.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                                return Boolean.valueOf(!StringsKt.startsWith$default(name, ".", false, 2, (Object) null));
                            }
                        }), new Function1<File, Boolean>() { // from class: com.syu.media.MediaFiles$processLoadMediaSource$2
                            public final Boolean invoke(File file2) {
                                Intrinsics.checkNotNullParameter(file2, "it");
                                return Boolean.valueOf(file2.isDirectory());
                            }
                        }), new Function1<File, Boolean>() { // from class: com.syu.media.MediaFiles$processLoadMediaSource$3
                            {
                                super(1);
                            }

                            public final Boolean invoke(File file2) {
                                boolean zStartsWith$default;
                                Intrinsics.checkNotNullParameter(file2, "dir");
                                String[] ignoreDirs = this.a.getMediaFilter().getIgnoreDirs();
                                int length = ignoreDirs.length;
                                boolean z = false;
                                for (int i3 = 0; i3 < length; i3++) {
                                    String str4 = ignoreDirs[i3];
                                    if (str4 == null || str4.length() == 0) {
                                        zStartsWith$default = false;
                                    } else {
                                        String path = file2.getPath();
                                        Intrinsics.checkNotNullExpressionValue(path, "dir.path");
                                        zStartsWith$default = StringsKt.startsWith$default(path, str4, false, 2, (Object) null);
                                    }
                                    if (zStartsWith$default) {
                                        z = true;
                                        break;
                                    }
                                }
                                return Boolean.valueOf(!z);
                            }
                        }).iterator();
                        int i3 = UPDATE_DELAY_MIN;
                        long jElapsedRealtime2 = jElapsedRealtime;
                        int size = 0;
                        int size2 = 0;
                        while (it2.hasNext()) {
                            File file2 = (File) it2.next();
                            ArrayList arrayList = new ArrayList();
                            Iterator it3 = it2;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it4 = SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(FilesKt.walk$default(file2, (FileWalkDirection) null, i2, (Object) null).maxDepth(i2), new Function1<File, Boolean>() { // from class: com.syu.media.MediaFiles$processLoadMediaSource$4$1
                                public final Boolean invoke(File file3) {
                                    Intrinsics.checkNotNullParameter(file3, "it");
                                    return Boolean.valueOf(file3.isFile());
                                }
                            }), new Function1<File, Boolean>() { // from class: com.syu.media.MediaFiles$processLoadMediaSource$4$2
                                public final Boolean invoke(File file3) {
                                    Intrinsics.checkNotNullParameter(file3, "it");
                                    String name = file3.getName();
                                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                                    return Boolean.valueOf(!StringsKt.startsWith$default(name, ".", false, 2, (Object) null));
                                }
                            }), new Function1<File, Boolean>() { // from class: com.syu.media.MediaFiles$processLoadMediaSource$4$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Boolean invoke(File file3) {
                                    Intrinsics.checkNotNullParameter(file3, "it");
                                    boolean zAccess$isAudioSource = MediaFiles.access$isAudioSource(this.a, file3);
                                    boolean zAccess$isVideoSource = MediaFiles.access$isVideoSource(this.a, file3);
                                    int i4 = i;
                                    if (i4 != 1) {
                                        if (i4 != 2) {
                                            zAccess$isAudioSource = zAccess$isAudioSource || zAccess$isVideoSource;
                                        } else {
                                            zAccess$isAudioSource = zAccess$isVideoSource;
                                        }
                                    }
                                    return Boolean.valueOf(zAccess$isAudioSource);
                                }
                            }), new Function1<File, Boolean>() { // from class: com.syu.media.MediaFiles$processLoadMediaSource$4$4
                                {
                                    super(1);
                                }

                                public final Boolean invoke(File file3) {
                                    Intrinsics.checkNotNullParameter(file3, "it");
                                    return Boolean.valueOf(file3.length() >= ((long) this.a.getMediaFilter().getFileMinLength()));
                                }
                            }).iterator();
                            int i4 = i3;
                            while (it4.hasNext()) {
                                File file3 = (File) it4.next();
                                if (mediaFiles.exists(str)) {
                                    it = it4;
                                    if (file3.exists()) {
                                        str2 = str3;
                                        String[] audioSuffixes = mediaFiles.mediaFilter.getAudioSuffixes();
                                        j = jElapsedRealtime;
                                        String lowerCase = FilesKt.getExtension(file3).toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        if (ArraysKt.contains(audioSuffixes, lowerCase)) {
                                            AudioSource audioSourceA = a(file3);
                                            if (audioSourceA != null) {
                                                arrayList.add(audioSourceA);
                                            }
                                        }
                                        if (SystemClock.elapsedRealtime() - jElapsedRealtime2 < i4) {
                                            if (arrayList.size() > 0) {
                                                if (mediaFiles.exists(str)) {
                                                    MediaDao mediaDao = mediaFiles.mediaDao;
                                                    Object[] array = new ArrayList(arrayList).toArray(new AudioSource[0]);
                                                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                    AudioSource[] audioSourceArr = (AudioSource[]) array;
                                                    mediaDao.insert((AudioSource[]) Arrays.copyOf(audioSourceArr, audioSourceArr.length));
                                                }
                                                int size3 = arrayList.size() + size;
                                                arrayList.clear();
                                                size = size3;
                                            }
                                            if (arrayList2.size() > 0) {
                                                if (mediaFiles.exists(str)) {
                                                    MediaDao mediaDao2 = mediaFiles.mediaDao;
                                                    Object[] array2 = new ArrayList(arrayList2).toArray(new VideoSource[0]);
                                                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                    VideoSource[] videoSourceArr = (VideoSource[]) array2;
                                                    mediaDao2.insert((VideoSource[]) Arrays.copyOf(videoSourceArr, videoSourceArr.length));
                                                }
                                                int size4 = arrayList2.size() + size2;
                                                arrayList2.clear();
                                                size2 = size4;
                                            }
                                            jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                            if (i4 <= 4000) {
                                                i4 += 200;
                                            }
                                        }
                                    } else {
                                        str2 = str3;
                                        j = jElapsedRealtime;
                                    }
                                    if (file3.exists()) {
                                        String[] videoSuffixes = mediaFiles.mediaFilter.getVideoSuffixes();
                                        String lowerCase2 = FilesKt.getExtension(file3).toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        if (ArraysKt.contains(videoSuffixes, lowerCase2) && (videoSourceB = b(file3)) != null) {
                                            arrayList2.add(videoSourceB);
                                        }
                                    }
                                    if (SystemClock.elapsedRealtime() - jElapsedRealtime2 < i4) {
                                        if (arrayList.size() > 0) {
                                            if (mediaFiles.exists(str)) {
                                                MediaDao mediaDao3 = mediaFiles.mediaDao;
                                                Object[] array3 = new ArrayList(arrayList).toArray(new AudioSource[0]);
                                                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                AudioSource[] audioSourceArr2 = (AudioSource[]) array3;
                                                mediaDao3.insert((AudioSource[]) Arrays.copyOf(audioSourceArr2, audioSourceArr2.length));
                                            }
                                            int size5 = arrayList.size() + size;
                                            arrayList.clear();
                                            size = size5;
                                        }
                                        if (arrayList2.size() > 0) {
                                            if (mediaFiles.exists(str)) {
                                                MediaDao mediaDao4 = mediaFiles.mediaDao;
                                                Object[] array4 = new ArrayList(arrayList2).toArray(new VideoSource[0]);
                                                Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                VideoSource[] videoSourceArr2 = (VideoSource[]) array4;
                                                mediaDao4.insert((VideoSource[]) Arrays.copyOf(videoSourceArr2, videoSourceArr2.length));
                                            }
                                            int size6 = arrayList2.size() + size2;
                                            arrayList2.clear();
                                            size2 = size6;
                                        }
                                        jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                        if (i4 <= 4000) {
                                            i4 += 200;
                                        }
                                    }
                                } else {
                                    str2 = str3;
                                    it = it4;
                                    j = jElapsedRealtime;
                                }
                                str3 = str2;
                                it4 = it;
                                jElapsedRealtime = j;
                            }
                            String str4 = str3;
                            long j2 = jElapsedRealtime;
                            boolean zExists = mediaFiles.exists(str);
                            if (zExists && arrayList.size() > 0) {
                                MediaDao mediaDao5 = mediaFiles.mediaDao;
                                Object[] array5 = new ArrayList(arrayList).toArray(new AudioSource[0]);
                                Intrinsics.checkNotNull(array5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                AudioSource[] audioSourceArr3 = (AudioSource[]) array5;
                                mediaDao5.insert((AudioSource[]) Arrays.copyOf(audioSourceArr3, audioSourceArr3.length));
                                size = arrayList.size() + size;
                            }
                            arrayList.clear();
                            if (zExists && arrayList2.size() > 0) {
                                MediaDao mediaDao6 = mediaFiles.mediaDao;
                                Object[] array6 = new ArrayList(arrayList2).toArray(new VideoSource[0]);
                                Intrinsics.checkNotNull(array6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                VideoSource[] videoSourceArr3 = (VideoSource[]) array6;
                                mediaDao6.insert((VideoSource[]) Arrays.copyOf(videoSourceArr3, videoSourceArr3.length));
                                size2 = arrayList2.size() + size2;
                            }
                            arrayList2.clear();
                            jElapsedRealtime2 = SystemClock.elapsedRealtime();
                            i3 = i4 <= 4000 ? i4 + 200 : i4;
                            it2 = it3;
                            str3 = str4;
                            jElapsedRealtime = j2;
                            i2 = 1;
                        }
                        Log.e(str3, "processLoadMediaSource path: " + str + "  priority: " + i + " END used time: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                        return size + size2;
                    }

                    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
                    public static VideoSource b(File file) throws IOException {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (strExtractMetadata == null || !new Regex("\\d+").matches(strExtractMetadata)) {
                            return null;
                        }
                        int i = Integer.parseInt(strExtractMetadata);
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "file.name");
                        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(7);
                        if (strExtractMetadata2 != null) {
                            if (TextUtils.isEmpty(strExtractMetadata2)) {
                                strExtractMetadata2 = name;
                            }
                            if (strExtractMetadata2 != null) {
                                name = strExtractMetadata2;
                            }
                        }
                        String name2 = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
                        String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(7);
                        if (strExtractMetadata3 != null) {
                            if (TextUtils.isEmpty(strExtractMetadata3)) {
                                strExtractMetadata3 = name2;
                            }
                            if (strExtractMetadata3 != null) {
                                name2 = strExtractMetadata3;
                            }
                        }
                        String str = p;
                        String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(2);
                        if (strExtractMetadata4 == null) {
                            strExtractMetadata4 = str;
                        } else {
                            if (TextUtils.isEmpty(strExtractMetadata4)) {
                                strExtractMetadata4 = str;
                            }
                            if (strExtractMetadata4 == null) {
                                strExtractMetadata4 = str;
                            }
                        }
                        String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(1);
                        if (strExtractMetadata5 != null) {
                            if (TextUtils.isEmpty(strExtractMetadata5)) {
                                strExtractMetadata5 = str;
                            }
                            if (strExtractMetadata5 != null) {
                                str = strExtractMetadata5;
                            }
                        }
                        String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(18);
                        int i2 = 0;
                        int i3 = (strExtractMetadata6 == null || !new Regex("\\d+").matches(strExtractMetadata6)) ? 0 : Integer.parseInt(strExtractMetadata6);
                        String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(19);
                        if (strExtractMetadata7 != null && new Regex("\\d+").matches(strExtractMetadata7)) {
                            i2 = Integer.parseInt(strExtractMetadata7);
                        }
                        mediaMetadataRetriever.release();
                        VideoSource videoSource = new VideoSource(i3, i2);
                        videoSource.setTitle(name);
                        videoSource.setAlbum(str);
                        videoSource.setDisplayName(name2);
                        videoSource.setArtist(strExtractMetadata4);
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                        videoSource.setPath(absolutePath);
                        String parent = file.getParent();
                        Intrinsics.checkNotNullExpressionValue(parent, "file.parent");
                        videoSource.setFolder(parent);
                        videoSource.setDuration(i);
                        videoSource.setLength((int) file.length());
                        return videoSource;
                    }

                    public final void InsertIfExist(String fileName) {
                        Intrinsics.checkNotNullParameter(fileName, "fileName");
                        if (isMounted(fileName)) {
                            File file = new File(fileName);
                            if (file.exists()) {
                                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(file, fileName, null), 3, (Object) null);
                            }
                        }
                    }

                    public final Bitmap createAlbumCover(String path) throws IOException {
                        Bitmap bitmapDecodeByteArray;
                        Intrinsics.checkNotNullParameter(path, Media.PATH);
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(path);
                        } catch (Exception e) {
                            Log.e(TAG, "createAlbumCover " + path + " ------------>> " + e.getMessage());
                        }
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                        if (frameAtTime == null || (bitmapDecodeByteArray = BitmapUtils.scaleNotDeform$default(BitmapUtils.INSTANCE, frameAtTime, 120.0f, 120.0f, false, 8, (Object) null)) == null) {
                            byte[] embeddedPicture = mediaMetadataRetriever.getEmbeddedPicture();
                            bitmapDecodeByteArray = embeddedPicture != null ? BitmapFactory.decodeByteArray(embeddedPicture, 0, embeddedPicture.length) : null;
                        }
                        mediaMetadataRetriever.release();
                        return bitmapDecodeByteArray;
                    }

                    public final boolean exists(String rootFolder) {
                        Intrinsics.checkNotNullParameter(rootFolder, "rootFolder");
                        return this.j.contains(rootFolder);
                    }

                    public final long getMCheckDelay() {
                        return this.mCheckDelay;
                    }

                    public final CoverHandler getMCoverHandler() {
                        return this.mCoverHandler;
                    }

                    public final MediaDao getMediaDao() {
                        return this.mediaDao;
                    }

                    public final MediaFilter getMediaFilter() {
                        return this.mediaFilter;
                    }

                    public final OnStorageDeviceChangeListener getOnStorageDeviceChangeListener() {
                        return this.onStorageDeviceChangeListener;
                    }

                    public final int getScanPriority() {
                        return this.scanPriority;
                    }

                    public final int getSecondPriority() {
                        return this.secondPriority;
                    }

                    public final boolean isMounted(String path) {
                        Intrinsics.checkNotNullParameter(path, Media.PATH);
                        ArrayList<String> arrayList = new ArrayList(this.j);
                        if (arrayList.isEmpty()) {
                            return false;
                        }
                        for (String str : arrayList) {
                            Intrinsics.checkNotNullExpressionValue(str, "it");
                            if (StringsKt.startsWith$default(path, str, false, 2, (Object) null)) {
                                return true;
                            }
                        }
                        return false;
                    }

                    /* JADX INFO: renamed from: isRegistered, reason: from getter */
                    public final boolean getIsRegistered() {
                        return this.isRegistered;
                    }

                    /* JADX INFO: renamed from: isWaiting, reason: from getter */
                    public final boolean getIsWaiting() {
                        return this.isWaiting;
                    }

                    public final void monitorUDiskMount(Context context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        if (this.isRegistered) {
                            return;
                        }
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_UNMOUNTED");
                        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                        intentFilter.addDataScheme("file");
                        context.registerReceiver(this, intentFilter);
                        this.isRegistered = true;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        Uri data;
                        String path;
                        final String path2;
                        if (intent != null) {
                            StringBuilder sbAppend = new StringBuilder("action: ").append(intent.getAction()).append("  path: ");
                            Uri data2 = intent.getData();
                            Log.e(TAG, sbAppend.append(data2 != null ? data2.getPath() : null).append(" onStorageDeviceChangeListener:: ").append(this.onStorageDeviceChangeListener).toString());
                            String action = intent.getAction();
                            if (action != null) {
                                int iHashCode = action.hashCode();
                                if (iHashCode != -1514214344) {
                                    if (iHashCode != -963871873) {
                                        if (iHashCode != -625887599 || !action.equals("android.intent.action.MEDIA_EJECT")) {
                                            return;
                                        }
                                    } else if (!action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                                        return;
                                    }
                                    Uri data3 = intent.getData();
                                    if (data3 == null || (path2 = data3.getPath()) == null) {
                                        return;
                                    }
                                    Intrinsics.checkNotNullExpressionValue(path2, Media.PATH);
                                    synchronized (this) {
                                        if (this.isWaiting) {
                                            if (!this.n.contains(path2)) {
                                                this.n.add(path2);
                                            }
                                            if (this.m.contains(path2)) {
                                                this.m.remove(path2);
                                            }
                                        } else {
                                            if (this.j.contains(path2)) {
                                                this.j.remove(path2);
                                                OnStorageDeviceChangeListener onStorageDeviceChangeListener = this.onStorageDeviceChangeListener;
                                                if (onStorageDeviceChangeListener != null) {
                                                    onStorageDeviceChangeListener.onStorageDeviceChange(this.j);
                                                }
                                            }
                                            stopAndRemoveTask(path2);
                                            ((Handler) this.i.getValue()).post(new Runnable() { // from class: com.syu.media.MediaFiles$$ExternalSyntheticLambda1
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    MediaFiles.b(this.f$0, path2);
                                                }
                                            });
                                        }
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                                if (!action.equals("android.intent.action.MEDIA_MOUNTED") || (data = intent.getData()) == null || (path = data.getPath()) == null) {
                                    return;
                                }
                                Intrinsics.checkNotNullExpressionValue(path, Media.PATH);
                                synchronized (this) {
                                    if (this.isWaiting) {
                                        if (this.n.contains(path)) {
                                            this.n.remove(path);
                                        }
                                        if (!this.m.contains(path)) {
                                            this.m.add(path);
                                        }
                                    } else {
                                        if (!this.j.contains(path)) {
                                            this.j.add(path);
                                            OnStorageDeviceChangeListener onStorageDeviceChangeListener2 = this.onStorageDeviceChangeListener;
                                            if (onStorageDeviceChangeListener2 != null) {
                                                onStorageDeviceChangeListener2.onStorageDeviceChange(this.j);
                                            }
                                        }
                                        if (!this.k.containsKey(path)) {
                                            LinkedHashMap linkedHashMap = this.l;
                                            DeviceObserver deviceObserver = new DeviceObserver(this, path);
                                            deviceObserver.startWatching();
                                            linkedHashMap.put(path, deviceObserver);
                                            LinkedHashMap linkedHashMap2 = this.k;
                                            Task task = new Task(this, path);
                                            task.start();
                                            linkedHashMap2.put(path, task);
                                        }
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                        }
                    }

                    public final void removeMonitorUDiskMount(Context context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        if (this.isRegistered) {
                            context.unregisterReceiver(this);
                        }
                    }

                    public final void scanMounted(Context context) {
                        boolean z;
                        OnStorageDeviceChangeListener onStorageDeviceChangeListener;
                        Intrinsics.checkNotNullParameter(context, "context");
                        boolean z2 = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
                        Log.e(TAG, "scanMounted ---- start");
                        synchronized (this) {
                            try {
                                if (z2) {
                                    for (StorageUtils.StorageInfo storageInfo : StorageUtils.INSTANCE.getMountedStorages(context)) {
                                        if (storageInfo.getPath() != null) {
                                            if (!CollectionsKt.contains(this.j, storageInfo.getPath())) {
                                                ArrayList arrayList = this.j;
                                                String path = storageInfo.getPath();
                                                Intrinsics.checkNotNull(path);
                                                arrayList.add(path);
                                            }
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z && (onStorageDeviceChangeListener = this.onStorageDeviceChangeListener) != null) {
                                            onStorageDeviceChangeListener.onStorageDeviceChange(this.j);
                                        }
                                    }
                                    StringBuilder sbAppend = new StringBuilder().append("Mounted paths : ");
                                    Object[] array = this.j.toArray(new String[0]);
                                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                    String string = Arrays.toString(array);
                                    Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
                                    Log.e(TAG, sbAppend.append(string).toString());
                                    for (String str : this.j) {
                                        if (!this.k.containsKey(str)) {
                                            LinkedHashMap linkedHashMap = this.l;
                                            DeviceObserver deviceObserver = new DeviceObserver(this, str);
                                            deviceObserver.startWatching();
                                            linkedHashMap.put(str, deviceObserver);
                                            LinkedHashMap linkedHashMap2 = this.k;
                                            Task task = new Task(this, str);
                                            task.start();
                                            linkedHashMap2.put(str, task);
                                        }
                                    }
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    Log.e(TAG, "scanMounted not to do!! ");
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }

                    public final void setMCheckDelay(long j) {
                        this.mCheckDelay = j;
                    }

                    public final void setMCoverHandler(CoverHandler coverHandler) {
                        this.mCoverHandler = coverHandler;
                    }

                    public final void setMediaDao(MediaDao mediaDao) {
                        Intrinsics.checkNotNullParameter(mediaDao, "<set-?>");
                        this.mediaDao = mediaDao;
                    }

                    public final void setMediaFilter(MediaFilter mediaFilter) {
                        Intrinsics.checkNotNullParameter(mediaFilter, "<set-?>");
                        this.mediaFilter = mediaFilter;
                    }

                    public final void setOnStorageDeviceChangeListener(OnStorageDeviceChangeListener onStorageDeviceChangeListener) {
                        if (Intrinsics.areEqual(this.onStorageDeviceChangeListener, onStorageDeviceChangeListener)) {
                            return;
                        }
                        this.onStorageDeviceChangeListener = onStorageDeviceChangeListener;
                        if (onStorageDeviceChangeListener != null) {
                            onStorageDeviceChangeListener.onStorageDeviceChange(this.j);
                        }
                    }

                    public final void setRegistered(boolean z) {
                        this.isRegistered = z;
                    }

                    public final void setScanPriority(int i) {
                        int i2 = this.scanPriority;
                        if (i2 != i) {
                            this.secondPriority = i2;
                            this.scanPriority = i;
                        }
                    }

                    public final void setSecondPriority(int i) {
                        this.secondPriority = i;
                    }

                    public final void setWaiting(boolean z) {
                        if (this.isWaiting != z) {
                            this.isWaiting = z;
                            if (!z) {
                                synchronized (this) {
                                    if (!this.n.isEmpty()) {
                                        LinkedHashSet linkedHashSet = this.n;
                                        ArrayList<String> arrayList = new ArrayList();
                                        for (Object obj : linkedHashSet) {
                                            if (this.j.contains((String) obj)) {
                                                arrayList.add(obj);
                                            }
                                        }
                                        for (final String str : arrayList) {
                                            this.j.remove(str);
                                            OnStorageDeviceChangeListener onStorageDeviceChangeListener = this.onStorageDeviceChangeListener;
                                            if (onStorageDeviceChangeListener != null) {
                                                onStorageDeviceChangeListener.onStorageDeviceChange(this.j);
                                            }
                                            stopAndRemoveTask(str);
                                            ((Handler) this.i.getValue()).post(new Runnable() { // from class: com.syu.media.MediaFiles$$ExternalSyntheticLambda0
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    MediaFiles.a(this.f$0, str);
                                                }
                                            });
                                        }
                                    }
                                    if (!this.m.isEmpty()) {
                                        LinkedHashSet linkedHashSet2 = this.m;
                                        ArrayList<String> arrayList2 = new ArrayList();
                                        for (Object obj2 : linkedHashSet2) {
                                            if (!this.j.contains((String) obj2)) {
                                                arrayList2.add(obj2);
                                            }
                                        }
                                        for (String str2 : arrayList2) {
                                            this.j.add(str2);
                                            OnStorageDeviceChangeListener onStorageDeviceChangeListener2 = this.onStorageDeviceChangeListener;
                                            if (onStorageDeviceChangeListener2 != null) {
                                                onStorageDeviceChangeListener2.onStorageDeviceChange(this.j);
                                            }
                                            if (!this.k.containsKey(str2)) {
                                                LinkedHashMap linkedHashMap = this.l;
                                                DeviceObserver deviceObserver = new DeviceObserver(this, str2);
                                                deviceObserver.startWatching();
                                                linkedHashMap.put(str2, deviceObserver);
                                                LinkedHashMap linkedHashMap2 = this.k;
                                                Task task = new Task(this, str2);
                                                task.start();
                                                linkedHashMap2.put(str2, task);
                                            }
                                        }
                                    }
                                    this.m.clear();
                                    this.n.clear();
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                            synchronized (this) {
                                for (Map.Entry entry : new LinkedHashMap(this.k).entrySet()) {
                                    String str3 = (String) entry.getKey();
                                    if (((Task) entry.getValue()).getIsScanning()) {
                                        Intrinsics.checkNotNullExpressionValue(str3, Media.PATH);
                                        stopAndRemoveTask(str3);
                                        if (!this.n.contains(str3) && !this.m.contains(str3)) {
                                            this.m.remove(str3);
                                        }
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                    }

                    public final void stopAndRemoveTask(String path) {
                        Intrinsics.checkNotNullParameter(path, Media.PATH);
                        Task task = (Task) this.k.getOrDefault(path, null);
                        if (task != null) {
                            DeviceObserver deviceObserver = (DeviceObserver) this.l.get(path);
                            if (deviceObserver != null) {
                                deviceObserver.stopWatching();
                            }
                            this.l.remove(path);
                            task.setScanning(false);
                            task.interrupt();
                            this.k.remove(path);
                        }
                    }

                    public final Handler workHandler() {
                        return (Handler) this.i.getValue();
                    }

                    public /* synthetic */ MediaFiles(MediaFilter mediaFilter, MediaDao mediaDao, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? new MediaFilter(null, 0, null, null, 15, null) : mediaFilter, mediaDao);
                    }

                    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
                    public static AudioSource a(File file) throws IOException {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (strExtractMetadata == null || !new Regex("\\d+").matches(strExtractMetadata)) {
                            return null;
                        }
                        int i = Integer.parseInt(strExtractMetadata);
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "file.name");
                        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(7);
                        if (strExtractMetadata2 != null) {
                            if (TextUtils.isEmpty(strExtractMetadata2)) {
                                strExtractMetadata2 = name;
                            }
                            if (strExtractMetadata2 != null) {
                                name = strExtractMetadata2;
                            }
                        }
                        String name2 = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
                        String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(7);
                        if (strExtractMetadata3 != null) {
                            if (TextUtils.isEmpty(strExtractMetadata3)) {
                                strExtractMetadata3 = name2;
                            }
                            if (strExtractMetadata3 != null) {
                                name2 = strExtractMetadata3;
                            }
                        }
                        String str = p;
                        String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(2);
                        if (strExtractMetadata4 == null) {
                            strExtractMetadata4 = str;
                        } else {
                            if (TextUtils.isEmpty(strExtractMetadata4)) {
                                strExtractMetadata4 = str;
                            }
                            if (strExtractMetadata4 == null) {
                                strExtractMetadata4 = str;
                            }
                        }
                        String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(1);
                        if (strExtractMetadata5 != null) {
                            if (TextUtils.isEmpty(strExtractMetadata5)) {
                                strExtractMetadata5 = str;
                            }
                            if (strExtractMetadata5 != null) {
                                str = strExtractMetadata5;
                            }
                        }
                        if (Utils.equals(name, str) && Utils.equals(name2, str)) {
                            name = FilesKt.getNameWithoutExtension(file);
                            name2 = FilesKt.getNameWithoutExtension(file);
                        }
                        mediaMetadataRetriever.release();
                        AudioSource audioSource = new AudioSource();
                        audioSource.setTitle(name);
                        audioSource.setAlbum(str);
                        audioSource.setDisplayName(name2);
                        audioSource.setArtist(strExtractMetadata4);
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                        audioSource.setPath(absolutePath);
                        String parent = file.getParent();
                        Intrinsics.checkNotNullExpressionValue(parent, "file.parent");
                        audioSource.setFolder(parent);
                        audioSource.setDuration(i);
                        audioSource.setLength((int) file.length());
                        return audioSource;
                    }

                    public static final void b(MediaFiles mediaFiles, String str) {
                        Intrinsics.checkNotNullParameter(mediaFiles, "this$0");
                        Intrinsics.checkNotNullParameter(str, "$it");
                        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new MediaFiles$onReceive$1$1$1$1$1(mediaFiles, str, null), 3, (Object) null);
                        CoverHandler coverHandler = mediaFiles.mCoverHandler;
                        if (coverHandler != null) {
                            coverHandler.removeWith(str);
                        }
                    }
                }
