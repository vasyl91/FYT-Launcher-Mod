package com.syu.radar;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Radar {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public static class ID {
        public static final int FRONT_L = 0;
        public static final int FRONT_ML = 1;
        public static final int FRONT_MR = 2;
        public static final int FRONT_R = 3;
        public static final int LEFT_F = 8;
        public static final int LEFT_MF = 9;
        public static final int LEFT_MR = 10;
        public static final int LEFT_R = 11;
        public static final int REAR_L = 4;
        public static final int REAR_ML = 5;
        public static final int REAR_MR = 6;
        public static final int REAR_R = 7;
        public static final int RIGHT_F = 12;
        public static final int RIGHT_MF = 13;
        public static final int RIGHT_MR = 14;
        public static final int RIGHT_R = 15;
    }

    public Radar(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = z;
        this.f = z2;
    }

    public int getEndColor() {
        return this.d;
    }

    public int getIntensity() {
        return this.b;
    }

    public int getMax() {
        return this.a;
    }

    public int getStartColor() {
        return this.c;
    }

    public boolean isEnable() {
        return this.f;
    }

    public boolean isSelfColor() {
        return this.e;
    }

    public void setColor(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public void setEnable(boolean z) {
        this.f = z;
    }

    public void setIntensity(int i) {
        this.b = i;
    }

    public void setMax(int i) {
        this.a = i;
    }

    public void setSelfColor(boolean z) {
        this.e = z;
    }

    public Radar(int i, int i2, int i3, boolean z) {
        this(i, i2, i3, -1, -1, false, true);
    }
}
