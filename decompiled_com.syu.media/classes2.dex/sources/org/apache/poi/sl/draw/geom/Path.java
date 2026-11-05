package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.sl.draw.binding.CTPath2D;
import org.apache.poi.sl.draw.binding.CTPath2DArcTo;
import org.apache.poi.sl.draw.binding.CTPath2DClose;
import org.apache.poi.sl.draw.binding.CTPath2DCubicBezierTo;
import org.apache.poi.sl.draw.binding.CTPath2DLineTo;
import org.apache.poi.sl.draw.binding.CTPath2DMoveTo;
import org.apache.poi.sl.draw.binding.CTPath2DQuadBezierTo;
import org.apache.poi.sl.draw.binding.STPathFillMode;
import org.apache.poi.sl.usermodel.PaintStyle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Path {
    PaintStyle.PaintModifier _fill;
    long _h;
    boolean _stroke;
    long _w;
    private final List<PathCommand> commands;

    public Path() {
        this(true, true);
    }

    public Path(boolean z, boolean z2) {
        this.commands = new ArrayList();
        this._w = -1L;
        this._h = -1L;
        this._fill = z ? PaintStyle.PaintModifier.NORM : PaintStyle.PaintModifier.NONE;
        this._stroke = z2;
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.geom.Path$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode;

        static {
            int[] iArr = new int[STPathFillMode.values().length];
            $SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode = iArr;
            try {
                iArr[STPathFillMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode[STPathFillMode.DARKEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode[STPathFillMode.DARKEN_LESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode[STPathFillMode.LIGHTEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode[STPathFillMode.LIGHTEN_LESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode[STPathFillMode.NORM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public Path(CTPath2D cTPath2D) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$sl$draw$binding$STPathFillMode[cTPath2D.getFill().ordinal()];
        if (i == 1) {
            this._fill = PaintStyle.PaintModifier.NONE;
        } else if (i == 2) {
            this._fill = PaintStyle.PaintModifier.DARKEN;
        } else if (i == 3) {
            this._fill = PaintStyle.PaintModifier.DARKEN_LESS;
        } else if (i == 4) {
            this._fill = PaintStyle.PaintModifier.LIGHTEN;
        } else if (i == 5) {
            this._fill = PaintStyle.PaintModifier.LIGHTEN_LESS;
        } else {
            this._fill = PaintStyle.PaintModifier.NORM;
        }
        this._stroke = cTPath2D.isStroke();
        this._w = cTPath2D.isSetW() ? cTPath2D.getW() : -1L;
        this._h = cTPath2D.isSetH() ? cTPath2D.getH() : -1L;
        this.commands = new ArrayList();
        for (Object obj : cTPath2D.getCloseOrMoveToOrLnTo()) {
            if (obj instanceof CTPath2DMoveTo) {
                this.commands.add(new MoveToCommand(((CTPath2DMoveTo) obj).getPt()));
            } else if (obj instanceof CTPath2DLineTo) {
                this.commands.add(new LineToCommand(((CTPath2DLineTo) obj).getPt()));
            } else if (obj instanceof CTPath2DArcTo) {
                this.commands.add(new ArcToCommand((CTPath2DArcTo) obj));
            } else if (obj instanceof CTPath2DQuadBezierTo) {
                CTPath2DQuadBezierTo cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) obj;
                this.commands.add(new QuadToCommand(cTPath2DQuadBezierTo.getPt().get(0), cTPath2DQuadBezierTo.getPt().get(1)));
            } else if (obj instanceof CTPath2DCubicBezierTo) {
                CTPath2DCubicBezierTo cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) obj;
                this.commands.add(new CurveToCommand(cTPath2DCubicBezierTo.getPt().get(0), cTPath2DCubicBezierTo.getPt().get(1), cTPath2DCubicBezierTo.getPt().get(2)));
            } else if (obj instanceof CTPath2DClose) {
                this.commands.add(new ClosePathCommand());
            } else {
                throw new IllegalStateException("Unsupported path segment: " + obj);
            }
        }
    }

    public void addCommand(PathCommand pathCommand) {
        this.commands.add(pathCommand);
    }

    public Path2D.Double getPath(Context context) {
        Path2D.Double r0 = new Path2D.Double();
        Iterator<PathCommand> it = this.commands.iterator();
        while (it.hasNext()) {
            it.next().execute(r0, context);
        }
        return r0;
    }

    public boolean isStroked() {
        return this._stroke;
    }

    public boolean isFilled() {
        return this._fill != PaintStyle.PaintModifier.NONE;
    }

    public PaintStyle.PaintModifier getFill() {
        return this._fill;
    }

    public long getW() {
        return this._w;
    }

    public long getH() {
        return this._h;
    }
}
