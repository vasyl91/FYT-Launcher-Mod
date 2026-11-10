package com.autonavi.amapauto.gdarcameraservice.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class GDArCameraParam implements Parcelable {
    public static final Parcelable.Creator<GDArCameraParam> CREATOR = new Parcelable.Creator<GDArCameraParam>() { // from class: com.autonavi.amapauto.gdarcameraservice.model.GDArCameraParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GDArCameraParam createFromParcel(Parcel in) {
            return new GDArCameraParam(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GDArCameraParam[] newArray(int size) {
            return new GDArCameraParam[size];
        }
    };
    public String cameraId;
    public int cameraUseType;
    public int dataType;
    public int imageFormat;
    public int imageHeight;
    public int imageWidth;

    public GDArCameraParam() {
    }

    protected GDArCameraParam(Parcel in) {
        this.imageFormat = in.readInt();
        this.dataType = in.readInt();
        this.cameraUseType = in.readInt();
        this.imageWidth = in.readInt();
        this.imageHeight = in.readInt();
        this.cameraId = in.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imageFormat);
        dest.writeInt(this.dataType);
        dest.writeInt(this.cameraUseType);
        dest.writeInt(this.imageWidth);
        dest.writeInt(this.imageHeight);
        dest.writeString(this.cameraId);
    }

    public String toString() {
        return "ArCameraParam{imageFormat=" + this.imageFormat + ", dataType=" + this.dataType + ", cameraUseType=" + this.cameraUseType + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", cameraId='" + this.cameraId + "'}";
    }
}
