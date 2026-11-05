package org.apache.poi.sl.draw.geom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.sl.draw.binding.CTCustomGeometry2D;
import org.apache.poi.sl.draw.binding.CTGeomGuide;
import org.apache.poi.sl.draw.binding.CTGeomGuideList;
import org.apache.poi.sl.draw.binding.CTGeomRect;
import org.apache.poi.sl.draw.binding.CTPath2D;
import org.apache.poi.sl.draw.binding.CTPath2DList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CustomGeometry implements Iterable<Path> {
    final List<Guide> adjusts = new ArrayList();
    final List<Guide> guides = new ArrayList();
    final List<Path> paths = new ArrayList();
    Path textBounds;

    public CustomGeometry(CTCustomGeometry2D cTCustomGeometry2D) {
        CTGeomGuideList avLst = cTCustomGeometry2D.getAvLst();
        if (avLst != null) {
            Iterator<CTGeomGuide> it = avLst.getGd().iterator();
            while (it.hasNext()) {
                this.adjusts.add(new AdjustValue(it.next()));
            }
        }
        CTGeomGuideList gdLst = cTCustomGeometry2D.getGdLst();
        if (gdLst != null) {
            Iterator<CTGeomGuide> it2 = gdLst.getGd().iterator();
            while (it2.hasNext()) {
                this.guides.add(new Guide(it2.next()));
            }
        }
        CTPath2DList pathLst = cTCustomGeometry2D.getPathLst();
        if (pathLst != null) {
            Iterator<CTPath2D> it3 = pathLst.getPath().iterator();
            while (it3.hasNext()) {
                this.paths.add(new Path(it3.next()));
            }
        }
        CTGeomRect rect = cTCustomGeometry2D.getRect();
        if (rect != null) {
            Path path = new Path();
            this.textBounds = path;
            path.addCommand(new MoveToCommand(rect.getL(), rect.getT()));
            this.textBounds.addCommand(new LineToCommand(rect.getR(), rect.getT()));
            this.textBounds.addCommand(new LineToCommand(rect.getR(), rect.getB()));
            this.textBounds.addCommand(new LineToCommand(rect.getL(), rect.getB()));
            this.textBounds.addCommand(new ClosePathCommand());
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Path> iterator() {
        return this.paths.iterator();
    }

    public Path getTextBounds() {
        return this.textBounds;
    }
}
