package org.apache.poi.xssf.util;

import java.io.InputStream;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.util.ReplacingInputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
@Internal
@Deprecated
public class EvilUnclosedBRFixingInputStream extends ReplacingInputStream {
    public EvilUnclosedBRFixingInputStream(InputStream inputStream) {
        super(inputStream, "<br>", "<br/>");
    }
}
