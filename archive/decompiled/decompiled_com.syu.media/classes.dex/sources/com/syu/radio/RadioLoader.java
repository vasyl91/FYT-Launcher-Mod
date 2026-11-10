package com.syu.radio;

import android.content.Context;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.google.gson.Gson;
import com.syu.media.provider.Media;
import com.syu.radio.dao.RadioDao;
import com.syu.radio.entities.RadioStation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/syu/radio/RadioLoader;", FinalChip.BSP_PLATFORM_Null, "Landroid/content/Context;", "context", "Ljava/io/InputStream;", "inputStream", FinalChip.BSP_PLATFORM_Null, "parse", FinalChip.BSP_PLATFORM_Null, Media.PATH, "fileName", "copyDbFile", "b", "Ljava/lang/String;", "getCoverDirPath", "()Ljava/lang/String;", "setCoverDirPath", "(Ljava/lang/String;)V", "coverDirPath", "Lcom/syu/radio/dao/RadioDao;", "radioDao", "<init>", "(Lcom/syu/radio/dao/RadioDao;)V", "JsonResult", "radiolib_release"}, k = 1, mv = {1, 7, 1})
public final class RadioLoader {
    public final RadioDao a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String coverDirPath;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/syu/radio/RadioLoader$JsonResult;", FinalChip.BSP_PLATFORM_Null, XmlConsts.XML_DECL_KW_VERSION, FinalChip.BSP_PLATFORM_Null, "radios", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/radio/entities/RadioStation;", "(Ljava/lang/String;Ljava/util/List;)V", "getRadios", "()Ljava/util/List;", "setRadios", "(Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", FinalChip.BSP_PLATFORM_Null, "toString", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final /* data */ class JsonResult {
        private List<RadioStation> radios;
        private String version;

        public JsonResult(String str, List<RadioStation> list) {
            Intrinsics.checkNotNullParameter(str, XmlConsts.XML_DECL_KW_VERSION);
            Intrinsics.checkNotNullParameter(list, "radios");
            this.version = str;
            this.radios = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JsonResult copy$default(JsonResult jsonResult, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jsonResult.version;
            }
            if ((i & 2) != 0) {
                list = jsonResult.radios;
            }
            return jsonResult.copy(str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        public final List<RadioStation> component2() {
            return this.radios;
        }

        public final JsonResult copy(String version, List<RadioStation> radios) {
            Intrinsics.checkNotNullParameter(version, XmlConsts.XML_DECL_KW_VERSION);
            Intrinsics.checkNotNullParameter(radios, "radios");
            return new JsonResult(version, radios);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JsonResult)) {
                return false;
            }
            JsonResult jsonResult = (JsonResult) other;
            return Intrinsics.areEqual(this.version, jsonResult.version) && Intrinsics.areEqual(this.radios, jsonResult.radios);
        }

        public final List<RadioStation> getRadios() {
            return this.radios;
        }

        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return this.radios.hashCode() + (this.version.hashCode() * 31);
        }

        public final void setRadios(List<RadioStation> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.radios = list;
        }

        public final void setVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.version = str;
        }

        public String toString() {
            return "JsonResult(version=" + this.version + ", radios=" + this.radios + ')';
        }
    }

    /* JADX INFO: renamed from: com.syu.radio.RadioLoader$copyDbFile$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.radio.RadioLoader$copyDbFile$1", f = "RadioLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String a;
        public final /* synthetic */ InputStream b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, InputStream inputStream, Continuation continuation) {
            super(2, continuation);
            this.a = str;
            this.b = inputStream;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.a, this.b, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:48:0x006a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:49:0x006c A[Catch: IOException -> 0x0068, TRY_LEAVE, TryCatch #2 {IOException -> 0x0068, blocks: (B:45:0x0064, B:49:0x006c), top: B:53:0x0064 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public final Object invokeSuspend(Object obj) throws Throwable {
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            File file = new File(this.a);
            if (file.exists()) {
                return Unit.INSTANCE;
            }
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            InputStream inputStream2 = null;
            try {
                try {
                    inputStream = this.b;
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            fileOutputStream.flush();
                            inputStream.close();
                            fileOutputStream.close();
                        } catch (Exception e) {
                            e = e;
                            inputStream2 = inputStream;
                            try {
                                e.printStackTrace();
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                fileOutputStream2 = fileOutputStream;
                                fileOutputStream = fileOutputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        throw th;
                                    }
                                } else if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStream != null) {
                                inputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } else if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.syu.radio.RadioLoader$parse$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.radio.RadioLoader$parse$1", f = "RadioLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ InputStream a;
        public final /* synthetic */ RadioLoader b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00761(InputStream inputStream, RadioLoader radioLoader, Continuation continuation) {
            super(2, continuation);
            this.a = inputStream;
            this.b = radioLoader;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00761(this.a, this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            try {
                Object objFromJson = new Gson().fromJson((Reader) new BufferedReader(new InputStreamReader(this.a)), (Class<Object>) JsonResult.class);
                RadioLoader radioLoader = this.b;
                JsonResult jsonResult = (JsonResult) objFromJson;
                Iterator<T> it = jsonResult.getRadios().iterator();
                while (true) {
                    boolean z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    RadioStation radioStation = (RadioStation) it.next();
                    String cover = radioStation.getCover();
                    if (cover != null) {
                        if (cover.length() > 0) {
                            z = true;
                        }
                    }
                    if (z) {
                        radioStation.setCover(radioLoader.getCoverDirPath() + radioStation.getCover());
                    }
                }
                RadioDao radioDao = radioLoader.a;
                Object[] array = jsonResult.getRadios().toArray(new RadioStation[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                RadioStation[] radioStationArr = (RadioStation[]) array;
                radioDao.insertNoExists((RadioStation[]) Arrays.copyOf(radioStationArr, radioStationArr.length));
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.syu.radio.RadioLoader$parse$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.radio.RadioLoader$parse$2", f = "RadioLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String a;
        public final /* synthetic */ RadioLoader b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, RadioLoader radioLoader, Continuation continuation) {
            super(2, continuation);
            this.a = str;
            this.b = radioLoader;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.a, this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            try {
                Object objFromJson = new Gson().fromJson((Reader) new FileReader(this.a), (Class<Object>) JsonResult.class);
                RadioLoader radioLoader = this.b;
                JsonResult jsonResult = (JsonResult) objFromJson;
                Iterator<T> it = jsonResult.getRadios().iterator();
                while (true) {
                    boolean z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    RadioStation radioStation = (RadioStation) it.next();
                    String cover = radioStation.getCover();
                    if (cover != null) {
                        if (cover.length() > 0) {
                            z = true;
                        }
                    }
                    if (z) {
                        radioStation.setCover(radioLoader.getCoverDirPath() + radioStation.getCover());
                    }
                }
                RadioDao radioDao = radioLoader.a;
                Object[] array = jsonResult.getRadios().toArray(new RadioStation[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                RadioStation[] radioStationArr = (RadioStation[]) array;
                radioDao.insertNoExists((RadioStation[]) Arrays.copyOf(radioStationArr, radioStationArr.length));
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    public RadioLoader(RadioDao radioDao) {
        Intrinsics.checkNotNullParameter(radioDao, "radioDao");
        this.a = radioDao;
        this.coverDirPath = FinalChip.BSP_PLATFORM_Null;
    }

    public final void copyDbFile(InputStream inputStream, String fileName) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(fileName, inputStream, null), 3, (Object) null);
    }

    public final String getCoverDirPath() {
        return this.coverDirPath;
    }

    public final void parse(Context context, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00761(inputStream, this, null), 3, (Object) null);
    }

    public final void setCoverDirPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverDirPath = str;
    }

    public final void parse(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, Media.PATH);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(path, this, null), 3, (Object) null);
    }
}
