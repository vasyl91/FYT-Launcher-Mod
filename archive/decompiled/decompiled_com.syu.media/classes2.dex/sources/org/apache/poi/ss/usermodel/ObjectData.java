package org.apache.poi.ss.usermodel;

import java.io.IOException;
import org.apache.poi.poifs.filesystem.DirectoryEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ObjectData extends SimpleShape {
    DirectoryEntry getDirectory() throws IOException;

    String getFileName();

    String getOLE2ClassName();

    byte[] getObjectData() throws IOException;

    PictureData getPictureData();

    boolean hasDirectoryEntry();
}
