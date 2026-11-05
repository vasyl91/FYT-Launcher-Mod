package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.ConnectType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFConnection {
    public static final int visBegin = 9;
    public static final int visBeginX = 7;
    public static final int visBeginY = 8;
    public static final int visBottomEdge = 4;
    public static final int visCenterEdge = 2;
    public static final int visConnectFromError = -1;
    public static final int visConnectToError = -1;
    public static final int visEnd = 12;
    public static final int visEndX = 10;
    public static final int visEndY = 11;
    public static final int visFromAngle = 13;
    public static final int visFromNone = 0;
    public static final int visFromPin = 14;
    public static final int visGuideIntersect = 4;
    public static final int visGuideX = 1;
    public static final int visGuideY = 2;
    public static final int visLeftEdge = 1;
    public static final int visMiddleEdge = 5;
    public static final int visRightEdge = 3;
    public static final int visToAngle = 7;
    public static final int visToNone = 0;
    public static final int visTopEdge = 6;
    public static final int visWholeShape = 3;
    private ConnectType _connect;
    private XDGFShape _from;
    private XDGFShape _to;

    public XDGFConnection(ConnectType connectType, XDGFShape xDGFShape, XDGFShape xDGFShape2) {
        this._connect = connectType;
        this._from = xDGFShape;
        this._to = xDGFShape2;
    }

    public XDGFShape getFromShape() {
        return this._from;
    }

    public XDGFCell getFromCell() {
        return this._from.getCell(this._connect.getFromCell());
    }

    public String getFromCellName() {
        return this._connect.getFromCell();
    }

    public XDGFShape getToShape() {
        return this._to;
    }

    public String getToCellName() {
        return this._connect.getToCell();
    }

    public Integer getFromPart() {
        if (this._connect.isSetFromPart()) {
            return Integer.valueOf(this._connect.getFromPart());
        }
        return null;
    }

    public Integer getToPart() {
        if (this._connect.isSetToPart()) {
            return Integer.valueOf(this._connect.getToPart());
        }
        return null;
    }
}
