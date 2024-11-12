package com.syu.esri;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class ShapeReader {
    private static Exception e;
    private static Throwable th;
    public static final int SHAPE_TYPE_POINT = 1;
    public static final int SHAPE_TYPE_POLYGON = 5;
    public static final int SHAPE_TYPE_POLYLINE = 3;

    public static Object readReacod(byte[] data, int offset) {
        int offset2 = offset << 1;
        int recordType = littleInt(data, offset2 + 8);
        switch (recordType) {
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return null;
            case 5:
                return readPolygon(data, offset2);
        }
    }

    public static Polygon readPolygon(byte[] data, int offset) {
        int cnt;
        int recordNum = bigInt(data, offset);
        int offset2 = offset + 12;
        double minX = littleDouble(data, offset2);
        double minY = littleDouble(data, offset2 + 8);
        double maxX = littleDouble(data, offset2 + 16);
        double maxY = littleDouble(data, offset2 + 24);
        int partCnt = littleInt(data, offset2 + 32);
        int pointCnt = littleInt(data, offset2 + 36);
        int offset3 = offset2 + 40;
        int[] partIndices = new int[partCnt];
        for (int i = 0; i < partCnt; i++) {
            partIndices[i] = littleInt(data, (i * 4) + offset3);
        }
        int offset4 = offset3 + (partCnt * 4);
        double[][] points = new double[partCnt][];
        int i2 = 0;
        while (i2 < partCnt) {
            if (partCnt == 1) {
                cnt = pointCnt;
            } else {
                cnt = (i2 == partCnt + (-1) ? pointCnt : partIndices[i2 + 1]) - partIndices[i2];
            }
            points[i2] = new double[cnt << 1];
            for (int j = 0; j < cnt; j++) {
                points[i2][j << 1] = littleDouble(data, offset4);
                points[i2][(j << 1) + 1] = littleDouble(data, offset4 + 8);
                offset4 += 16;
            }
            i2++;
        }
        return new Polygon(recordNum, minX, minY, maxX, maxY, points);
    }

    public static ShapeIndex readShapeIndex(String path) {
        DataInputStream dis = null;
        ShapeIndex shx = null;
        DataInputStream dis2 = null;
        try {
            try {
                dis = new DataInputStream(new FileInputStream(path));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            shx = readShapeIndex(dis);
        } catch (Exception e2) {
            e = e2;
            dis2 = dis;
            e.printStackTrace();
            if (dis2 != null) {
                try {
                    dis2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return shx;
        } catch (Throwable th2) {
            th = th2;
            dis2 = dis;
            if (dis2 != null) {
                try {
                    dis2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            try {
                throw th;
            } catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
        if (dis != null) {
            try {
                dis.close();
                dis2 = dis;
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return shx;
        }
        dis2 = dis;
        return shx;
    }

    public static ShapeIndex readShapeIndex(DataInputStream dis) throws IOException {
        int fileCode = dis.readInt();
        dis.skipBytes(20);
        int fileLength = dis.readInt();
        byte[] data = new byte[4];
        dis.read(data, 0, 4);
        int version = littleInt(data, 0);
        dis.read(data, 0, 4);
        int shapeType = littleInt(data, 0);
        byte[] d = new byte[8];
        dis.read(d, 0, 8);
        double minX = littleDouble(d, 0);
        dis.read(d, 0, 8);
        double minY = littleDouble(d, 0);
        dis.read(d, 0, 8);
        double maxX = littleDouble(d, 0);
        dis.read(d, 0, 8);
        double maxY = littleDouble(d, 0);
        dis.skip(32L);
        List<Integer> list = new ArrayList<>(1024);
        while (dis.available() > 0) {
            int offset = dis.readInt();
            int length = dis.readInt();
            list.add(Integer.valueOf(offset));
            list.add(Integer.valueOf(length));
        }
        int[] indices = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            indices[i] = list.get(i).intValue();
        }
        return new ShapeIndex(fileCode, fileLength, version, shapeType, minX, minY, maxX, maxY, indices);
    }

    public static int bigInt(byte[] data, int offset) {
        return (data[offset + 0] << 24) | ((data[offset + 1] & 255) << 16) | ((data[offset + 2] & 255) << 8) | (data[offset + 3] & 255);
    }

    public static int littleInt(byte[] data, int offset) {
        return (data[offset + 3] << 24) | ((data[offset + 2] & 255) << 16) | ((data[offset + 1] & 255) << 8) | (data[offset + 0] & 255);
    }

    public static double littleDouble(byte[] data, int offset) {
        long lvalue = (data[offset + 7] << 56) | ((data[offset + 6] & 255) << 48) | ((data[offset + 5] & 255) << 40) | ((data[offset + 4] & 255) << 32) | ((data[offset + 3] & 255) << 24) | ((data[offset + 2] & 255) << 16) | ((data[offset + 1] & 255) << 8) | (data[offset + 0] & 255);
        return Double.longBitsToDouble(lvalue);
    }

    public static byte[] getFileData(String path) throws IOException {
        InputStream is = null;
        int size;
        byte[] data = null;
        InputStream is2 = null;
        try {
            try {
                is = new FileInputStream(path);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            size = is.available();
        } catch (Exception e2) {
            e = e2;
            is2 = is;
            e.printStackTrace();
            if (is2 != null) {
                try {
                    is2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return data;
        } catch (Throwable th2) {
            th = th2;
            is2 = is;
            if (is2 != null) {
                try {
                    is2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            try {
                throw th;
            } catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
        if (size <= 0) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        }
        data = new byte[size];
        is.read(data);
        if (is != null) {
            try {
                is.close();
                is2 = is;
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return data;
        }
        is2 = is;
        return data;
    }
}
