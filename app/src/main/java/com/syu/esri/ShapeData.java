package com.syu.esri;

import java.util.ArrayList;
import java.util.List;

public class ShapeData {
    private final List<Polygon> mPolygonList = new ArrayList();

    public ShapeData(byte[] data, ShapeIndex shapeIndex) {
        int[] indices;
        if (data != null && shapeIndex != null && (indices = shapeIndex.getIndices()) != null) {
            for (int i = 0; i < indices.length / 2; i++) {
                Object obj = ShapeReader.readReacod(data, indices[i << 1]);
                if (obj instanceof Polygon) {
                    this.mPolygonList.add((Polygon) obj);
                }
            }
        }
    }

    public List<Polygon> hitBound(double x, double y) {
        List<Polygon> list = new ArrayList<>();
        for (Polygon polygon : this.mPolygonList) {
            if (polygon.hitBound(x, y)) {
                list.add(polygon);
            }
        }
        return list;
    }

    public Polygon hit(double x, double y) {
        List<Polygon> list = hitBound(x, y);
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        for (Polygon polygon : list) {
            if (polygon.hit(x, y)) {
                return polygon;
            }
        }
        return null;
    }

    public String getHitCity(double x, double y) {
        int index = 0;
        Polygon polygon = hit(x, y);
        if (polygon == null || polygon.getRecordNum() - 1 < 0 || index >= ShapeDB.CITY.length) {
            return null;
        }
        return ShapeDB.CITY[index];
    }
}
