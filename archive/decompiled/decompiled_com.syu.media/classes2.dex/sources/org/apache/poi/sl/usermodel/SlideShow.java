package org.apache.poi.sl.usermodel;

import java.awt.Dimension;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SlideShow<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Closeable {
    PictureData addPicture(File file, PictureData.PictureType pictureType) throws IOException;

    PictureData addPicture(InputStream inputStream, PictureData.PictureType pictureType) throws IOException;

    PictureData addPicture(byte[] bArr, PictureData.PictureType pictureType) throws IOException;

    MasterSheet<S, P> createMasterSheet() throws IOException;

    Slide<S, P> createSlide() throws IOException;

    PictureData findPictureData(byte[] bArr);

    Dimension getPageSize();

    List<? extends PictureData> getPictureData();

    Resources getResources();

    List<? extends MasterSheet<S, P>> getSlideMasters();

    List<? extends Slide<S, P>> getSlides();

    void setPageSize(Dimension dimension);

    void write(OutputStream outputStream) throws IOException;
}
