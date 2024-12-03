package com.android.launcher66.settings;

import android.graphics.Point;

public class Rectangle {
    private final Point topLeft;
    private final Point topRight;
    private final Point bottomLeft;
    private final Point bottomRight;

    public Rectangle(Point topL, Point topR, Point bottomR, Point bottomL) {
        super();
        this.topLeft = topL;
        this.topRight = topR;
        this.bottomLeft = bottomL;
        this.bottomRight = bottomR;
    }

    public boolean intersect(Rectangle r) {
        int minX = Math.min(this.topLeft.x, this.bottomRight.x);
        int maxX = Math.max(this.topLeft.x, this.bottomRight.x);
        int minY = Math.min(this.topLeft.y, this.bottomRight.y);
        int maxY = Math.max(this.topLeft.y, this.bottomRight.y);
        return ((this.topLeft.x <= r.topRight.x && r.topRight.x <= this.topRight.x) && (r.topRight.y <= this.topLeft.y && this.topLeft.y <= r.bottomRight.y))
                || ((r.bottomLeft.x <= this.topRight.x && this.topRight.x <= r.bottomRight.x) && (this.topRight.y <= r.bottomLeft.y && r.bottomLeft.y <= this.bottomRight.y))
                || ((r.topLeft.x <= this.topLeft.x && this.topLeft.x <= r.topRight.x) && (this.topLeft.y <= r.topLeft.y && r.topLeft.y <= this.bottomLeft.y))
                || ((this.bottomLeft.x <= r.topLeft.x && r.topLeft.x <= this.bottomRight.x) && (r.topLeft.y <= this.bottomLeft.y && this.bottomLeft.y <= r.bottomLeft.y)
                || ((minX < r.topLeft.x && r.topLeft.x < maxX) && (minY < r.topLeft.y && r.topLeft.y < maxY)));
    }
}