package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.unmarshallers.UnmarshallContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface PartUnmarshaller {
    PackagePart unmarshall(UnmarshallContext unmarshallContext, InputStream inputStream) throws InvalidFormatException, IOException;
}
