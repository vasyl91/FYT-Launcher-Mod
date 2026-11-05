package org.apache.xmlbeans;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaCodePrinter {
    void printLoader(Writer writer, SchemaTypeSystem schemaTypeSystem) throws IOException;

    void printType(Writer writer, SchemaType schemaType) throws IOException;

    void printTypeImpl(Writer writer, SchemaType schemaType) throws IOException;
}
