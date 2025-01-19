package com.syu.esri;

public class Polygon {
    private final int mRecordNum;
    private final double mMinX;
    private final double mMinY;
    private final double mMaxX;
    private final double mMaxY;
    private double[][] mPoints = null;

    public Polygon(int recordNum, double minX, double minY, double maxX, double maxY, double[][] points) {
        this.mRecordNum = recordNum;
        this.mMinX = minX;
        this.mMinY = minY;
        this.mMaxX = maxX;
        this.mMaxY = maxY;
        this.mPoints = points;
    }

    public boolean hit(double x, double y) {
        for (int i = 0; i < this.mPoints.length; ++i) {
            if (this.hitPolygon(this.mPoints[i], x, y)) {
                return true;
            }
        }

        return false;
    }

    private boolean hitPolygon(double[] points, double x, double y) {
        int pointCnt = points.length >> 1;
        if (pointCnt <= 2) {
            return false;
        } else {
            int hits = 0;
            double lastX = points[(pointCnt << 1) - 2];
            double lastY = points[(pointCnt << 1) - 1];

            for (int i = 0; i < pointCnt; ++i) {
                double curX = points[i << 1];
                double curY = points[(i << 1) + 1];
                if (curY != lastY) {
                    label75:
                    {
                        double leftX;
                        if (curX < lastX) {
                            if (x >= lastX) {
                                break label75;
                            }

                            leftX = curX;
                        } else {
                            if (x >= curX) {
                                break label75;
                            }

                            leftX = lastX;
                        }

                        double test1;
                        double test2;
                        if (curY < lastY) {
                            if (y < curY || y >= lastY) {
                                break label75;
                            }

                            if (x < leftX) {
                                ++hits;
                                break label75;
                            }

                            test1 = x - curX;
                            test2 = y - curY;
                        } else {
                            if (y < lastY || y >= curY) {
                                break label75;
                            }

                            if (x < leftX) {
                                ++hits;
                                break label75;
                            }

                            test1 = x - lastX;
                            test2 = y - lastY;
                        }

                        if (test1 < test2 / (lastY - curY) * (lastX - curX)) {
                            ++hits;
                        }
                    }
                }

                lastX = curX;
                lastY = curY;
            }

            return (hits & 1) != 0;
        }
    }

    public boolean hitBound(double x, double y) {
        return !(x < this.mMinX) && !(x >= this.mMaxX) && !(y < this.mMinY) && !(y > this.mMaxY);
    }

    public int getRecordNum() {
        return this.mRecordNum;
    }
}
