package com.syu.media;

import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.media.database.MediaDatabase;
import com.syu.media.model.MediaModel;
import com.syu.media.model.MediaModelFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import syu.base.BaseApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\r\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/syu/media/BaseMediaApp;", "Lsyu/base/BaseApp;", FinalChip.BSP_PLATFORM_Null, "onCreate", "Lcom/syu/media/BaseMediaApp$OnScanStateListener;", "listener", "addOnScanStateListener", "removeOnScanStateListener", "Lcom/syu/media/database/MediaDatabase;", "a", "Lkotlin/Lazy;", "getDatabase", "()Lcom/syu/media/database/MediaDatabase;", "database", "Lcom/syu/media/MediaFiles;", "b", "getMediaFiles", "()Lcom/syu/media/MediaFiles;", "mediaFiles", "Lcom/syu/media/model/MediaModel;", "c", "getMediaModel", "()Lcom/syu/media/model/MediaModel;", "mediaModel", "<init>", "()V", "OnScanStateListener", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public class BaseMediaApp extends BaseApp {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Lazy database = LazyKt.lazy(new Function0<MediaDatabase>() { // from class: com.syu.media.BaseMediaApp$database$2
        {
            super(0);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MediaDatabase m74invoke() {
            return MediaDatabase.INSTANCE.getDatabase(this.a);
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Lazy mediaFiles = LazyKt.lazy(new Function0<MediaFiles>() { // from class: com.syu.media.BaseMediaApp$mediaFiles$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MediaFiles m75invoke() {
            return new MediaFiles(null, this.a.getDatabase().mediaDao(), 1, null);
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy mediaModel = LazyKt.lazy(new Function0<MediaModel>() { // from class: com.syu.media.BaseMediaApp$mediaModel$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MediaModel m76invoke() {
            ViewModel viewModel = this.a.getViewModelProvider(new MediaModelFactory(MediaDatabase.INSTANCE.requireDatabase().mediaDao())).get(MediaModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModelProvider(factory).get(VM::class.java)");
            return (MediaModel) viewModel;
        }
    });
    public final ArrayList d = new ArrayList();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/syu/media/BaseMediaApp$OnScanStateListener;", FinalChip.BSP_PLATFORM_Null, "onScanStateChanged", FinalChip.BSP_PLATFORM_Null, "scanning", FinalChip.BSP_PLATFORM_Null, "rootFolder", FinalChip.BSP_PLATFORM_Null, "MediaLib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnScanStateListener {
        void onScanStateChanged(boolean scanning, String rootFolder);
    }

    public final void addOnScanStateListener(OnScanStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.d.contains(listener)) {
            return;
        }
        this.d.add(listener);
    }

    public final MediaDatabase getDatabase() {
        return (MediaDatabase) this.database.getValue();
    }

    public final MediaFiles getMediaFiles() {
        return (MediaFiles) this.mediaFiles.getValue();
    }

    public final MediaModel getMediaModel() {
        return (MediaModel) this.mediaModel.getValue();
    }

    public void onCreate() {
        super.onCreate();
        getMediaFiles().setOnStorageDeviceChangeListener(new MediaFiles.OnStorageDeviceChangeListener() { // from class: com.syu.media.BaseMediaApp.onCreate.1
            @Override // com.syu.media.MediaFiles.OnStorageDeviceChangeListener
            public void onScanStateChanged(boolean scanning, String rootFolder) {
                Intrinsics.checkNotNullParameter(rootFolder, "rootFolder");
                BaseMediaApp.this.getMediaModel().getScanning().postValue(Boolean.valueOf(scanning));
                Iterator it = BaseMediaApp.this.d.iterator();
                while (it.hasNext()) {
                    ((OnScanStateListener) it.next()).onScanStateChanged(scanning, rootFolder);
                }
            }

            @Override // com.syu.media.MediaFiles.OnStorageDeviceChangeListener
            public void onStorageDeviceChange(List<String> devices) {
                Intrinsics.checkNotNullParameter(devices, "devices");
                BaseMediaApp.this.getMediaModel().getStorageDevices().postValue(devices);
            }
        });
    }

    public final void removeOnScanStateListener(OnScanStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.d.contains(listener)) {
            this.d.remove(listener);
        }
    }
}
