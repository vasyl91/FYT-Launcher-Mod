package com.syu.esri;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class ShapeIndex {
    private int mFileCode;
    private int mFileLength;
    private int[] mIndices;
    private double mMaxX;
    private double mMaxY;
    private double mMinX;
    private double mMinY;
    private int mShapeType;
    private int mVersion;

    public ShapeIndex(int fileCode, int fileLength, int version, int shapeType, double minX, double minY, double maxX, double maxY, int[] indices) {
        this.mFileCode = fileCode;
        this.mFileLength = fileLength;
        this.mVersion = version;
        this.mShapeType = shapeType;
        this.mMinX = minX;
        this.mMinY = minY;
        this.mMaxX = maxX;
        this.mMaxY = maxY;
        this.mIndices = indices;
    }

    public int getFileCode() {
        return this.mFileCode;
    }

    public int getFileLength() {
        return this.mFileLength;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public int getShapeType() {
        return this.mShapeType;
    }

    public double getMinX() {
        return this.mMinX;
    }

    public double getMinY() {
        return this.mMinY;
    }

    public double getMaxX() {
        return this.mMaxX;
    }

    public double getMaxY() {
        return this.mMaxY;
    }

    public int[] getIndices() {
        return this.mIndices;
    }

    public String toString() {
        return String.format("fileCode: %d, fileLength: %d, version: %d, shapeType: %d, minX: %f, minY: %f, maxX: %f, maxY: %f", Integer.valueOf(this.mFileCode), Integer.valueOf(this.mFileLength), Integer.valueOf(this.mVersion), Integer.valueOf(this.mShapeType), Double.valueOf(this.mMinX), Double.valueOf(this.mMinY), Double.valueOf(this.mMaxX), Double.valueOf(this.mMaxY));
    }
}
