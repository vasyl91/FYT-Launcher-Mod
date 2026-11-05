package org.apache.poi.xslf.usermodel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.SlideShowFactory;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSLFSlideShowFactory extends SlideShowFactory {
    public static SlideShow<?, ?> createSlideShow(OPCPackage oPCPackage) throws IOException {
        try {
            return new XMLSlideShow(oPCPackage);
        } catch (IllegalArgumentException e) {
            oPCPackage.revert();
            throw e;
        }
    }

    public static SlideShow<?, ?> createSlideShow(File file, boolean z) throws InvalidFormatException, IOException {
        return createSlideShow(OPCPackage.open(file, z ? PackageAccess.READ : PackageAccess.READ_WRITE));
    }

    public static SlideShow<?, ?> createSlideShow(InputStream inputStream) throws InvalidFormatException, IOException {
        return createSlideShow(OPCPackage.open(inputStream));
    }
}
