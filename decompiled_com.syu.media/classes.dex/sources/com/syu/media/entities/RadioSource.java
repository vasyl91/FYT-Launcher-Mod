package com.syu.media.entities;

import android.os.Parcel;
import android.os.Parcelable;
import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\t\b\u0016¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b!\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006%"}, d2 = {"Lcom/syu/media/entities/RadioSource;", "Lcom/syu/media/entities/MediaSource;", "Landroid/os/Parcel;", "parcel", FinalChip.BSP_PLATFORM_Null, "flags", FinalChip.BSP_PLATFORM_Null, "writeToParcel", "describeContents", FinalChip.BSP_PLATFORM_Null, "k", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", Media.TYPE, "l", "getCountry", "setCountry", Media.COUNTRY, "m", "getLocal", "setLocal", Media.LOCAL, "n", "getFreqTitle", "setFreqTitle", "freqTitle", "o", "getIcon", "setIcon", Media.ICON, "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class RadioSource extends MediaSource {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public String type;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String country;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public String local;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public String freqTitle;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public String icon;

    /* JADX INFO: renamed from: com.syu.media.entities.RadioSource$CREATOR, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/syu/media/entities/RadioSource$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/syu/media/entities/RadioSource;", "Landroid/os/Parcel;", "parcel", "createFromParcel", FinalChip.BSP_PLATFORM_Null, "size", FinalChip.BSP_PLATFORM_Null, "newArray", "(I)[Lcom/syu/media/entities/RadioSource;", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements Parcelable.Creator<RadioSource> {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioSource createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RadioSource(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioSource[] newArray(int size) {
            return new RadioSource[size];
        }
    }

    public RadioSource() {
        this.type = FinalChip.BSP_PLATFORM_Null;
        this.country = FinalChip.BSP_PLATFORM_Null;
        this.local = FinalChip.BSP_PLATFORM_Null;
        this.freqTitle = FinalChip.BSP_PLATFORM_Null;
        this.icon = FinalChip.BSP_PLATFORM_Null;
    }

    @Override // com.syu.media.entities.MediaSource
    public Object clone() {
        return super.clone();
    }

    @Override // com.syu.media.entities.MediaSource, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getFreqTitle() {
        return this.freqTitle;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLocal() {
        return this.local;
    }

    public final String getType() {
        return this.type;
    }

    public final void setCountry(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.country = str;
    }

    public final void setFreqTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.freqTitle = str;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void setLocal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.local = str;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    @Override // com.syu.media.entities.MediaSource, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeString(this.type);
        parcel.writeString(this.country);
        parcel.writeString(this.local);
        parcel.writeString(this.freqTitle);
        parcel.writeString(this.icon);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioSource(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.type = FinalChip.BSP_PLATFORM_Null;
        this.country = FinalChip.BSP_PLATFORM_Null;
        this.local = FinalChip.BSP_PLATFORM_Null;
        this.freqTitle = FinalChip.BSP_PLATFORM_Null;
        this.icon = FinalChip.BSP_PLATFORM_Null;
        String string = parcel.readString();
        Intrinsics.checkNotNullExpressionValue(string, "parcel.readString()");
        this.type = string;
        String string2 = parcel.readString();
        Intrinsics.checkNotNullExpressionValue(string2, "parcel.readString()");
        this.country = string2;
        String string3 = parcel.readString();
        Intrinsics.checkNotNullExpressionValue(string3, "parcel.readString()");
        this.local = string3;
        String string4 = parcel.readString();
        Intrinsics.checkNotNullExpressionValue(string4, "parcel.readString()");
        this.freqTitle = string4;
        String string5 = parcel.readString();
        Intrinsics.checkNotNullExpressionValue(string5, "parcel.readString()");
        this.icon = string5;
    }
}
