package com.syu.media.companion.utils;

import chip.FinalChip;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bJ\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¨\u0006\u000f"}, d2 = {"Lcom/syu/media/companion/utils/FileUtils;", FinalChip.BSP_PLATFORM_Null, "()V", "bufferedReader", FinalChip.BSP_PLATFORM_Null, "input", "Ljava/io/InputStream;", "callback", "Lkotlin/Function1;", "Ljava/io/BufferedReader;", "bufferedWriter", "str", FinalChip.BSP_PLATFORM_Null, "parent", "fileName", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x001f -> B:35:0x0041). Please report as a decompilation issue!!! */
    public final void bufferedReader(InputStream input, Function1<? super BufferedReader, Unit> callback) throws Throwable {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(input));
                    try {
                        callback.invoke(bufferedReader2);
                        bufferedReader2.close();
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public final void bufferedWriter(String str, String parent, String fileName) throws Throwable {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    File file = new File(parent, fileName);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                    try {
                        bufferedWriter2.write(str);
                        bufferedWriter2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        e.printStackTrace();
                        if (bufferedWriter == null) {
                        } else {
                            bufferedWriter.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
