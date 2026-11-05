package com.syu.utils;

import android.os.FileObserver;
import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/syu/utils/FolderObserver;", "Landroid/os/FileObserver;", "", "event", "", "path", "", "onEvent", "startWatching", "stopWatching", "a", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "Lcom/syu/utils/FolderObserver$EventHandler;", "mEventHandler", "<init>", "(Ljava/lang/String;Lcom/syu/utils/FolderObserver$EventHandler;)V", "Companion", "EventHandler", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class FolderObserver extends FileObserver {
    public static final String TAG = "FolderObserver";

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final String path;
    public final EventHandler b;
    public final LinkedHashMap c;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/syu/utils/FolderObserver$EventHandler;", "", "onEvent", "", "event", "", "path", "", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface EventHandler {
        void onEvent(int event, String path);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderObserver(String path, EventHandler eventHandler) {
        super(path, 776);
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.b = eventHandler;
        this.c = new LinkedHashMap();
    }

    public final String getPath() {
        return this.path;
    }

    @Override // android.os.FileObserver
    public void onEvent(int event, String path) {
        String str;
        FolderObserver folderObserver;
        if (path == null || (str = this.path + '/' + path) == null) {
            str = null;
        }
        Log.e(TAG, "------>>> onEvent path: " + path + " file: " + str + " event: " + event);
        File file = new File(str);
        if (event == 1073742080) {
            Log.e(TAG, "------>>> Folder Create path: " + path + " dir: " + file.isDirectory() + " exists:" + file.exists());
            if (str != null) {
                FolderObserver folderObserver2 = new FolderObserver(str, this.b);
                folderObserver2.startWatching();
                this.c.put(str, folderObserver2);
                return;
            }
            return;
        }
        if (event != 1073742336) {
            EventHandler eventHandler = this.b;
            if (eventHandler != null) {
                eventHandler.onEvent(event, str);
                return;
            }
            return;
        }
        Log.e(TAG, "------>>> Folder Delete path: " + path + " dir: " + file.isDirectory() + " exists:" + file.exists());
        if (str == null || (folderObserver = (FolderObserver) TypeIntrinsics.asMutableMap(this.c).remove(path)) == null) {
            return;
        }
        folderObserver.stopWatching();
    }

    @Override // android.os.FileObserver
    public void startWatching() {
        super.startWatching();
        Log.e(TAG, "------>>> startWatching path: " + this.path);
        for (File file : SequencesKt.filter(FilesKt.walk$default(new File(this.path), null, 1, null).maxDepth(1), new Function1<File, Boolean>() { // from class: com.syu.utils.FolderObserver.startWatching.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((!it.isDirectory() || it.isHidden() || Intrinsics.areEqual(it.getAbsolutePath(), FolderObserver.this.getPath())) ? false : true);
            }
        })) {
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "dir.path");
            FolderObserver folderObserver = new FolderObserver(path, this.b);
            LinkedHashMap linkedHashMap = this.c;
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "dir.path");
            linkedHashMap.put(path2, folderObserver);
        }
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            FolderObserver folderObserver2 = (FolderObserver) this.c.get((String) it.next());
            if (folderObserver2 != null) {
                folderObserver2.startWatching();
            }
        }
    }

    @Override // android.os.FileObserver
    public void stopWatching() {
        super.stopWatching();
        Log.e(TAG, "------>>> stopWatching path: " + this.path);
        if (this.c.isEmpty()) {
            return;
        }
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            FolderObserver folderObserver = (FolderObserver) this.c.get((String) it.next());
            if (folderObserver != null) {
                folderObserver.stopWatching();
            }
        }
        this.c.clear();
    }

    public /* synthetic */ FolderObserver(String str, EventHandler eventHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : eventHandler);
    }
}
