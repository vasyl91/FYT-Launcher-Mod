package org.apache.poi.sl.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.apache.poi.sl.draw.binding.CTCustomGeometry2D;
import org.apache.poi.sl.draw.geom.Context;
import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.apache.poi.sl.draw.geom.Outline;
import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.sl.usermodel.LineDecoration;
import org.apache.poi.sl.usermodel.Shadow;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.StaxHelper;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawSimpleShape extends DrawShape {
    private static final double DECO_SIZE_POW = 1.5d;

    public DrawSimpleShape(SimpleShape<?, ?> simpleShape) {
        super(simpleShape);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Paint paint;
        DrawPaint paint2 = DrawFactory.getInstance(graphics2D).getPaint(getShape());
        Paint paint3 = paint2.getPaint(graphics2D, getShape().getFillStyle().getPaint());
        Paint paint4 = paint2.getPaint(graphics2D, getShape().getStrokeStyle().getPaint());
        BasicStroke stroke = getStroke();
        graphics2D.setStroke(stroke);
        Collection<Outline> collectionComputeOutlines = computeOutlines(graphics2D);
        drawShadow(graphics2D, collectionComputeOutlines, paint3, paint4);
        if (paint3 != null) {
            for (Outline outline : collectionComputeOutlines) {
                if (outline.getPath().isFilled() && (paint = paint2.getPaint(graphics2D, getShape().getFillStyle().getPaint(), outline.getPath().getFill())) != null) {
                    graphics2D.setPaint(paint);
                    Shape outline2 = outline.getOutline();
                    graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
                    graphics2D.fill(outline2);
                }
            }
        }
        drawContent(graphics2D);
        if (paint4 != null) {
            graphics2D.setPaint(paint4);
            graphics2D.setStroke(stroke);
            for (Outline outline3 : collectionComputeOutlines) {
                if (outline3.getPath().isStroked()) {
                    Shape outline4 = outline3.getOutline();
                    graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline4);
                    graphics2D.draw(outline4);
                }
            }
        }
        drawDecoration(graphics2D, paint4, stroke);
    }

    protected void drawDecoration(Graphics2D graphics2D, Paint paint, BasicStroke basicStroke) {
        if (paint == null) {
            return;
        }
        graphics2D.setPaint(paint);
        ArrayList<Outline> arrayList = new ArrayList();
        LineDecoration lineDecoration = getShape().getLineDecoration();
        Outline headDecoration = getHeadDecoration(graphics2D, lineDecoration, basicStroke);
        if (headDecoration != null) {
            arrayList.add(headDecoration);
        }
        Outline tailDecoration = getTailDecoration(graphics2D, lineDecoration, basicStroke);
        if (tailDecoration != null) {
            arrayList.add(tailDecoration);
        }
        for (Outline outline : arrayList) {
            Shape outline2 = outline.getOutline();
            Path path = outline.getPath();
            graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
            if (path.isFilled()) {
                graphics2D.fill(outline2);
            }
            if (path.isStroked()) {
                graphics2D.draw(outline2);
            }
        }
    }

    protected Outline getTailDecoration(Graphics2D graphics2D, LineDecoration lineDecoration, BasicStroke basicStroke) {
        Path path;
        Shape shapeCreateTransformedShape;
        if (lineDecoration == null || basicStroke == null) {
            return null;
        }
        LineDecoration.DecorationSize tailLength = lineDecoration.getTailLength();
        if (tailLength == null) {
            tailLength = LineDecoration.DecorationSize.MEDIUM;
        }
        LineDecoration.DecorationSize tailWidth = lineDecoration.getTailWidth();
        if (tailWidth == null) {
            tailWidth = LineDecoration.DecorationSize.MEDIUM;
        }
        double dMax = Math.max(2.5d, basicStroke.getLineWidth());
        Rectangle2D anchor = getAnchor(graphics2D, getShape());
        double x = anchor.getX() + anchor.getWidth();
        double y = anchor.getY() + anchor.getHeight();
        double dAtan = Math.atan(anchor.getHeight() / anchor.getWidth());
        AffineTransform affineTransform = new AffineTransform();
        double dPow = Math.pow(DECO_SIZE_POW, ((double) tailWidth.ordinal()) + 1.0d);
        double dPow2 = Math.pow(DECO_SIZE_POW, ((double) tailLength.ordinal()) + 1.0d);
        LineDecoration.DecorationShape tailShape = lineDecoration.getTailShape();
        if (tailShape == null) {
            return null;
        }
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[tailShape.ordinal()];
        if (i == 1) {
            path = new Path();
            Shape shape = new Ellipse2D.Double(0.0d, 0.0d, dMax * dPow2, dMax * dPow);
            Rectangle2D bounds2D = shape.getBounds2D();
            affineTransform.translate(x - (bounds2D.getWidth() / 2.0d), y - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(dAtan, bounds2D.getX() + (bounds2D.getWidth() / 2.0d), bounds2D.getY() + (bounds2D.getHeight() / 2.0d));
            shapeCreateTransformedShape = shape;
        } else if (i == 2 || i == 3) {
            path = new Path(false, true);
            shapeCreateTransformedShape = new Path2D.Double();
            double d = -dMax;
            double d2 = dPow2 * d;
            shapeCreateTransformedShape.moveTo(d2, (d * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d2, (dMax * dPow) / 2.0d);
            affineTransform.translate(x, y);
            affineTransform.rotate(dAtan);
        } else if (i != 4) {
            path = null;
            shapeCreateTransformedShape = null;
        } else {
            path = new Path();
            shapeCreateTransformedShape = new Path2D.Double();
            double d3 = -dMax;
            double d4 = dPow2 * d3;
            shapeCreateTransformedShape.moveTo(d4, (d3 * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d4, (dMax * dPow) / 2.0d);
            shapeCreateTransformedShape.closePath();
            affineTransform.translate(x, y);
            affineTransform.rotate(dAtan);
        }
        if (shapeCreateTransformedShape != null) {
            shapeCreateTransformedShape = affineTransform.createTransformedShape(shapeCreateTransformedShape);
        }
        if (shapeCreateTransformedShape == null) {
            return null;
        }
        return new Outline(shapeCreateTransformedShape, path);
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawSimpleShape$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape;

        static {
            int[] iArr = new int[LineDecoration.DecorationShape.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape = iArr;
            try {
                iArr[LineDecoration.DecorationShape.OVAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[LineDecoration.DecorationShape.STEALTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[LineDecoration.DecorationShape.ARROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[LineDecoration.DecorationShape.TRIANGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected Outline getHeadDecoration(Graphics2D graphics2D, LineDecoration lineDecoration, BasicStroke basicStroke) {
        Path path;
        Shape shapeCreateTransformedShape;
        if (lineDecoration == null || basicStroke == null) {
            return null;
        }
        LineDecoration.DecorationSize headLength = lineDecoration.getHeadLength();
        if (headLength == null) {
            headLength = LineDecoration.DecorationSize.MEDIUM;
        }
        LineDecoration.DecorationSize headWidth = lineDecoration.getHeadWidth();
        if (headWidth == null) {
            headWidth = LineDecoration.DecorationSize.MEDIUM;
        }
        double dMax = Math.max(2.5d, basicStroke.getLineWidth());
        Rectangle2D anchor = getAnchor(graphics2D, getShape());
        double x = anchor.getX();
        double y = anchor.getY();
        double dAtan = Math.atan(anchor.getHeight() / anchor.getWidth());
        AffineTransform affineTransform = new AffineTransform();
        double dPow = Math.pow(DECO_SIZE_POW, ((double) headWidth.ordinal()) + 1.0d);
        double dPow2 = Math.pow(DECO_SIZE_POW, ((double) headLength.ordinal()) + 1.0d);
        LineDecoration.DecorationShape headShape = lineDecoration.getHeadShape();
        if (headShape == null) {
            return null;
        }
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[headShape.ordinal()];
        if (i == 1) {
            path = new Path();
            Shape shape = new Ellipse2D.Double(0.0d, 0.0d, dMax * dPow2, dMax * dPow);
            Rectangle2D bounds2D = shape.getBounds2D();
            affineTransform.translate(x - (bounds2D.getWidth() / 2.0d), y - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(dAtan, bounds2D.getX() + (bounds2D.getWidth() / 2.0d), bounds2D.getY() + (bounds2D.getHeight() / 2.0d));
            shapeCreateTransformedShape = shape;
        } else if (i == 2 || i == 3) {
            path = new Path(false, true);
            shapeCreateTransformedShape = new Path2D.Double();
            double d = dPow2 * dMax;
            shapeCreateTransformedShape.moveTo(d, ((-dMax) * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d, (dMax * dPow) / 2.0d);
            affineTransform.translate(x, y);
            affineTransform.rotate(dAtan);
        } else if (i != 4) {
            path = null;
            shapeCreateTransformedShape = null;
        } else {
            path = new Path();
            shapeCreateTransformedShape = new Path2D.Double();
            double d2 = dPow2 * dMax;
            shapeCreateTransformedShape.moveTo(d2, ((-dMax) * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d2, (dMax * dPow) / 2.0d);
            shapeCreateTransformedShape.closePath();
            affineTransform.translate(x, y);
            affineTransform.rotate(dAtan);
        }
        if (shapeCreateTransformedShape != null) {
            shapeCreateTransformedShape = affineTransform.createTransformedShape(shapeCreateTransformedShape);
        }
        if (shapeCreateTransformedShape == null) {
            return null;
        }
        return new Outline(shapeCreateTransformedShape, path);
    }

    public BasicStroke getStroke() {
        return getStroke(getShape().getStrokeStyle());
    }

    protected void drawShadow(Graphics2D graphics2D, Collection<Outline> collection, Paint paint, Paint paint2) {
        Shadow<S, P> shadow = getShape().getShadow();
        if (shadow != 0) {
            if (paint == null && paint2 == null) {
                return;
            }
            Color colorApplyColorTransform = DrawPaint.applyColorTransform(shadow.getFillStyle().getSolidColor());
            double rotation = getShape().getRotation();
            if (getShape().getFlipVertical()) {
                rotation += 180.0d;
            }
            double angle = shadow.getAngle() - rotation;
            double distance = shadow.getDistance();
            double dCos = Math.cos(Math.toRadians(angle)) * distance;
            double dSin = distance * Math.sin(Math.toRadians(angle));
            graphics2D.translate(dCos, dSin);
            for (Outline outline : collection) {
                Shape outline2 = outline.getOutline();
                Path path = outline.getPath();
                graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
                graphics2D.setPaint(colorApplyColorTransform);
                if (paint != null && path.isFilled()) {
                    graphics2D.fill(outline2);
                } else if (paint2 != null && path.isStroked()) {
                    graphics2D.draw(outline2);
                }
            }
            graphics2D.translate(-dCos, -dSin);
        }
    }

    protected static CustomGeometry getCustomGeometry(String str) {
        return getCustomGeometry(str, null);
    }

    protected static CustomGeometry getCustomGeometry(String str, Graphics2D graphics2D) {
        Map map = graphics2D == null ? null : (Map) graphics2D.getRenderingHint(Drawable.PRESET_GEOMETRY_CACHE);
        if (map == null) {
            map = new HashMap();
            if (graphics2D != null) {
                graphics2D.setRenderingHint(Drawable.PRESET_GEOMETRY_CACHE, map);
            }
            InputStream resourceAsStream = Drawable.class.getResourceAsStream("presetShapeDefinitions.xml");
            EventFilter eventFilter = new EventFilter() { // from class: org.apache.poi.sl.draw.DrawSimpleShape.1
                @Override // javax.xml.stream.EventFilter
                public boolean accept(XMLEvent xMLEvent) {
                    return xMLEvent.isStartElement();
                }
            };
            try {
                try {
                    XMLInputFactory xMLInputFactoryNewXMLInputFactory = StaxHelper.newXMLInputFactory();
                    XMLEventReader xMLEventReaderCreateXMLEventReader = xMLInputFactoryNewXMLInputFactory.createXMLEventReader(resourceAsStream);
                    XMLEventReader xMLEventReaderCreateFilteredReader = xMLInputFactoryNewXMLInputFactory.createFilteredReader(xMLEventReaderCreateXMLEventReader, eventFilter);
                    xMLEventReaderCreateFilteredReader.nextEvent();
                    Unmarshaller unmarshallerCreateUnmarshaller = JAXBContext.newInstance("org.apache.poi.sl.draw.binding").createUnmarshaller();
                    while (xMLEventReaderCreateFilteredReader.peek() != null) {
                        map.put(((StartElement) xMLEventReaderCreateFilteredReader.peek()).getName().getLocalPart(), new CustomGeometry((CTCustomGeometry2D) unmarshallerCreateUnmarshaller.unmarshal(xMLEventReaderCreateXMLEventReader, CTCustomGeometry2D.class).getValue()));
                    }
                    xMLEventReaderCreateFilteredReader.close();
                    xMLEventReaderCreateXMLEventReader.close();
                    IOUtils.closeQuietly(resourceAsStream);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to load preset geometries.", e);
                }
            } catch (Throwable th) {
                IOUtils.closeQuietly(resourceAsStream);
                throw th;
            }
        }
        return (CustomGeometry) map.get(str);
    }

    protected Collection<Outline> computeOutlines(Graphics2D graphics2D) {
        double width;
        double emu;
        SimpleShape<?, ?> shape = getShape();
        ArrayList arrayList = new ArrayList();
        CustomGeometry geometry = shape.getGeometry();
        if (geometry == null) {
            return arrayList;
        }
        Rectangle2D anchor = getAnchor(graphics2D, shape);
        for (Path path : geometry) {
            double w = path.getW();
            double h = path.getH();
            double points = Units.toPoints(1L);
            if (w == -1.0d) {
                emu = Units.toEMU(anchor.getWidth());
                width = points;
            } else {
                width = anchor.getWidth() / w;
                emu = w;
            }
            if (h == -1.0d) {
                h = Units.toEMU(anchor.getHeight());
            } else {
                points = anchor.getHeight() / h;
            }
            Path2D.Double path2 = path.getPath(new Context(geometry, new Rectangle2D.Double(0.0d, 0.0d, emu, h), shape));
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.translate(anchor.getX(), anchor.getY());
            affineTransform.scale(width, points);
            arrayList.add(new Outline(affineTransform.createTransformedShape(path2), path));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.sl.draw.DrawShape
    public SimpleShape<?, ?> getShape() {
        return (SimpleShape) this.shape;
    }
}
