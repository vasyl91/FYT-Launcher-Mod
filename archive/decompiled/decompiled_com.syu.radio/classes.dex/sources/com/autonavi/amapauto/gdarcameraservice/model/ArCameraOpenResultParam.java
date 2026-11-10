package com.autonavi.amapauto.gdarcameraservice.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ArCameraOpenResultParam implements Parcelable {
    public static final Parcelable.Creator<ArCameraOpenResultParam> CREATOR = new Parcelable.Creator<ArCameraOpenResultParam>() { // from class: com.autonavi.amapauto.gdarcameraservice.model.ArCameraOpenResultParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArCameraOpenResultParam createFromParcel(Parcel in) {
            return new ArCameraOpenResultParam(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArCameraOpenResultParam[] newArray(int size) {
            return new ArCameraOpenResultParam[size];
        }
    };
    public String cameraId;
    public int cameraUseType;
    public int dataType;
    public int imageFormat;
    public int imageHeight;
    public int imageSize;
    public int imageWidth;

    public ArCameraOpenResultParam() {
    }

    public ArCameraOpenResultParam(int imageWidth, int imageHeight, int imageSize) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize;
    }

    public ArCameraOpenResultParam(int imageFormat, int imageWidth, int imageHeight, int imageSize) {
        this.imageFormat = imageFormat;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize;
    }

    public ArCameraOpenResultParam(int imageFormat, int imageWidth, int imageHeight, int imageSize, String cameraId) {
        this.imageFormat = imageFormat;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize;
        this.cameraId = cameraId;
    }

    public ArCameraOpenResultParam(int imageFormat, int dataType, int cameraUseType, int imageWidth, int imageHeight, int imageSize, String cameraId) {
        this.imageFormat = imageFormat;
        this.dataType = dataType;
        this.cameraUseType = cameraUseType;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageSize = imageSize;
        this.cameraId = cameraId;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public void setImageFormat(int imageFormat) {
        this.imageFormat = imageFormat;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getCameraUseType() {
        return this.cameraUseType;
    }

    public void setCameraUseType(int cameraUseType) {
        this.cameraUseType = cameraUseType;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getCameraId() {
        return this.cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public int getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    protected ArCameraOpenResultParam(Parcel in) {
        this.imageFormat = in.readInt();
        this.dataType = in.readInt();
        this.cameraUseType = in.readInt();
        this.imageWidth = in.readInt();
        this.imageHeight = in.readInt();
        this.cameraId = in.readString();
        this.imageSize = in.readInt();
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
        dest.writeInt(this.imageSize);
    }

    public String toString() {
        return "ArCameraParam{imageFormat=" + this.imageFormat + ", dataType=" + this.dataType + ", cameraUseType=" + this.cameraUseType + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imageSize=" + this.imageSize + ", cameraId='" + this.cameraId + "'}";
    }
}
