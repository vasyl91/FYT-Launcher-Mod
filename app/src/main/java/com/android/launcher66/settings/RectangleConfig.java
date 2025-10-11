package com.android.launcher66.settings;

public class RectangleConfig {
    public String name;
    public String key;
    public String color;
    public boolean shouldIntersect;
    public int minWidth;
    public int minHeight;
    public boolean enabled;

    public RectangleConfig(String name, String key, String color, boolean shouldIntersect, 
                         int minWidth, int minHeight, boolean enabled) {
        this.name = name;
        this.key = key;
        this.color = color;
        this.shouldIntersect = shouldIntersect;
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.enabled = enabled;
    }
}