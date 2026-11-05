package org.apache.poi.sl.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.StrokeStyle;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TableShape;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawTableShape extends DrawShape {

    @Internal
    public static final int borderSize = 2;

    public DrawTableShape(TableShape<?, ?> tableShape) {
        super(tableShape);
    }

    protected Drawable getGroupShape(Graphics2D graphics2D) {
        if (this.shape instanceof GroupShape) {
            return DrawFactory.getInstance(graphics2D).getDrawable((GroupShape<?, ?>) this.shape);
        }
        return null;
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
        Drawable groupShape = getGroupShape(graphics2D);
        if (groupShape != null) {
            groupShape.applyTransform(graphics2D);
        } else {
            super.applyTransform(graphics2D);
        }
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Line2D.Double r5;
        Drawable groupShape = getGroupShape(graphics2D);
        if (groupShape != null) {
            groupShape.draw(graphics2D);
            return;
        }
        TableShape<?, ?> shape = getShape();
        DrawPaint paint = DrawFactory.getInstance(graphics2D).getPaint(shape);
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        for (int i = 0; i < numberOfRows; i++) {
            for (int i2 = 0; i2 < numberOfColumns; i2++) {
                TableCell<S, P> cell = shape.getCell(i, i2);
                if (cell != 0 && !cell.isMerged()) {
                    graphics2D.setPaint(paint.getPaint(graphics2D, cell.getFillStyle().getPaint()));
                    Rectangle2D anchor = cell.getAnchor();
                    graphics2D.fill(anchor);
                    for (TableCell.BorderEdge borderEdge : TableCell.BorderEdge.values()) {
                        StrokeStyle borderStyle = cell.getBorderStyle(borderEdge);
                        if (borderStyle != null) {
                            graphics2D.setStroke(getStroke(borderStyle));
                            graphics2D.setPaint(paint.getPaint(graphics2D, borderStyle.getPaint()));
                            double x = anchor.getX();
                            double y = anchor.getY();
                            double width = anchor.getWidth();
                            double height = anchor.getHeight();
                            int i3 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[borderEdge.ordinal()];
                            if (i3 == 2) {
                                r5 = new Line2D.Double(x, y, x, y + height + 2.0d);
                            } else if (i3 == 3) {
                                double d = x + width;
                                r5 = new Line2D.Double(d, y, d, y + height + 2.0d);
                            } else if (i3 != 4) {
                                double d2 = y + height;
                                r5 = new Line2D.Double(x - 2.0d, d2, x + width + 2.0d, d2);
                            } else {
                                r5 = new Line2D.Double(x - 2.0d, y, x + width + 2.0d, y);
                            }
                            graphics2D.draw(r5);
                        }
                    }
                }
            }
        }
        drawContent(graphics2D);
    }

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawTableShape$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge;

        static {
            int[] iArr = new int[TableCell.BorderEdge.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge = iArr;
            try {
                iArr[TableCell.BorderEdge.bottom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.top.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
        Drawable groupShape = getGroupShape(graphics2D);
        if (groupShape != null) {
            groupShape.drawContent(graphics2D);
            return;
        }
        TableShape<?, ?> shape = getShape();
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        for (int i = 0; i < numberOfRows; i++) {
            for (int i2 = 0; i2 < numberOfColumns; i2++) {
                TextShape<?, ?> cell = shape.getCell(i, i2);
                if (cell != null) {
                    drawFactory.getDrawable(cell).drawContent(graphics2D);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.sl.draw.DrawShape
    public TableShape<?, ?> getShape() {
        return (TableShape) this.shape;
    }

    public void setAllBorders(Object... objArr) {
        TableShape<?, ?> shape = getShape();
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        TableCell.BorderEdge[] borderEdgeArr = {TableCell.BorderEdge.top, TableCell.BorderEdge.left, null, null};
        int i = 0;
        while (i < numberOfRows) {
            int i2 = 0;
            while (i2 < numberOfColumns) {
                borderEdgeArr[2] = i2 == numberOfColumns + (-1) ? TableCell.BorderEdge.right : null;
                borderEdgeArr[3] = i == numberOfRows + (-1) ? TableCell.BorderEdge.bottom : null;
                setEdges(shape.getCell(i, i2), borderEdgeArr, objArr);
                i2++;
            }
            i++;
        }
    }

    public void setOutsideBorders(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        TableShape<?, ?> shape = getShape();
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        TableCell.BorderEdge[] borderEdgeArr = new TableCell.BorderEdge[4];
        int i = 0;
        while (i < numberOfRows) {
            int i2 = 0;
            while (i2 < numberOfColumns) {
                TableCell.BorderEdge borderEdge = null;
                borderEdgeArr[0] = i2 == 0 ? TableCell.BorderEdge.left : null;
                borderEdgeArr[1] = i2 == numberOfColumns + (-1) ? TableCell.BorderEdge.right : null;
                borderEdgeArr[2] = i == 0 ? TableCell.BorderEdge.top : null;
                if (i == numberOfRows - 1) {
                    borderEdge = TableCell.BorderEdge.bottom;
                }
                borderEdgeArr[3] = borderEdge;
                setEdges(shape.getCell(i, i2), borderEdgeArr, objArr);
                i2++;
            }
            i++;
        }
    }

    public void setInsideBorders(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        TableShape<?, ?> shape = getShape();
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        TableCell.BorderEdge[] borderEdgeArr = new TableCell.BorderEdge[2];
        for (int i = 0; i < numberOfRows; i++) {
            int i2 = 0;
            while (i2 < numberOfColumns) {
                TableCell.BorderEdge borderEdge = null;
                borderEdgeArr[0] = (i2 <= 0 || i2 >= numberOfColumns + (-1)) ? null : TableCell.BorderEdge.right;
                if (i > 0 && i < numberOfRows - 1) {
                    borderEdge = TableCell.BorderEdge.bottom;
                }
                borderEdgeArr[1] = borderEdge;
                setEdges(shape.getCell(i, i2), borderEdgeArr, objArr);
                i2++;
            }
        }
    }

    private static void setEdges(TableCell<?, ?> tableCell, TableCell.BorderEdge[] borderEdgeArr, Object... objArr) {
        if (tableCell == null) {
            return;
        }
        for (TableCell.BorderEdge borderEdge : borderEdgeArr) {
            if (borderEdge != null) {
                if (objArr.length == 0) {
                    tableCell.removeBorder(borderEdge);
                } else {
                    for (Object obj : objArr) {
                        if (obj instanceof Double) {
                            tableCell.setBorderWidth(borderEdge, ((Double) obj).doubleValue());
                        } else if (obj instanceof Color) {
                            tableCell.setBorderColor(borderEdge, (Color) obj);
                        } else if (obj instanceof StrokeStyle.LineDash) {
                            tableCell.setBorderDash(borderEdge, (StrokeStyle.LineDash) obj);
                        } else if (obj instanceof StrokeStyle.LineCompound) {
                            tableCell.setBorderCompound(borderEdge, (StrokeStyle.LineCompound) obj);
                        }
                    }
                }
            }
        }
    }
}
