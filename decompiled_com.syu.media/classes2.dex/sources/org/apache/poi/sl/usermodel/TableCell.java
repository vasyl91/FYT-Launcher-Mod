package org.apache.poi.sl.usermodel;

import java.awt.Color;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface TableCell<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends TextShape<S, P> {

    public enum BorderEdge {
        bottom,
        left,
        top,
        right
    }

    StrokeStyle getBorderStyle(BorderEdge borderEdge);

    int getGridSpan();

    int getRowSpan();

    boolean isMerged();

    void removeBorder(BorderEdge borderEdge);

    void setBorderColor(BorderEdge borderEdge, Color color);

    void setBorderCompound(BorderEdge borderEdge, StrokeStyle.LineCompound lineCompound);

    void setBorderDash(BorderEdge borderEdge, StrokeStyle.LineDash lineDash);

    void setBorderStyle(BorderEdge borderEdge, StrokeStyle strokeStyle);

    void setBorderWidth(BorderEdge borderEdge, double d);
}
