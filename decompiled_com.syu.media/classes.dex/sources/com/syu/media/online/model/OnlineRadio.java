package com.syu.media.online.model;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnlineJson.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u008f\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006A"}, d2 = {"Lcom/syu/media/online/model/OnlineRadio;", FinalChip.BSP_PLATFORM_Null, "radioId", FinalChip.BSP_PLATFORM_Null, "radioName", "radioIcon", "radioURI", "radioType", "countryName", "radioARea", "lanLocale", "lanValues", "radioNumber", "radioState", "radioFRequency", "radioSort", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryName", "()Ljava/lang/String;", "setCountryName", "(Ljava/lang/String;)V", "getLanLocale", "setLanLocale", "getLanValues", "setLanValues", "getRadioARea", "setRadioARea", "getRadioFRequency", "setRadioFRequency", "getRadioIcon", "setRadioIcon", "getRadioId", "setRadioId", "getRadioName", "setRadioName", "getRadioNumber", "setRadioNumber", "getRadioSort", "setRadioSort", "getRadioState", "setRadioState", "getRadioType", "setRadioType", "getRadioURI", "setRadioURI", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FinalChip.BSP_PLATFORM_Null, "other", "hashCode", FinalChip.BSP_PLATFORM_Null, "toString", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class OnlineRadio {
    private String countryName;
    private String lanLocale;
    private String lanValues;
    private String radioARea;
    private String radioFRequency;
    private String radioIcon;
    private String radioId;
    private String radioName;
    private String radioNumber;
    private String radioSort;
    private String radioState;
    private String radioType;
    private String radioURI;

    public OnlineRadio() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRadioId() {
        return this.radioId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRadioNumber() {
        return this.radioNumber;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRadioState() {
        return this.radioState;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRadioFRequency() {
        return this.radioFRequency;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getRadioSort() {
        return this.radioSort;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRadioName() {
        return this.radioName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRadioIcon() {
        return this.radioIcon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRadioURI() {
        return this.radioURI;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRadioType() {
        return this.radioType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRadioARea() {
        return this.radioARea;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLanLocale() {
        return this.lanLocale;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLanValues() {
        return this.lanValues;
    }

    public final OnlineRadio copy(String radioId, String radioName, String radioIcon, String radioURI, String radioType, String countryName, String radioARea, String lanLocale, String lanValues, String radioNumber, String radioState, String radioFRequency, String radioSort) {
        Intrinsics.checkNotNullParameter(radioId, "radioId");
        Intrinsics.checkNotNullParameter(radioName, "radioName");
        Intrinsics.checkNotNullParameter(radioIcon, "radioIcon");
        Intrinsics.checkNotNullParameter(radioURI, "radioURI");
        Intrinsics.checkNotNullParameter(radioType, "radioType");
        Intrinsics.checkNotNullParameter(countryName, "countryName");
        Intrinsics.checkNotNullParameter(radioARea, "radioARea");
        Intrinsics.checkNotNullParameter(lanLocale, "lanLocale");
        Intrinsics.checkNotNullParameter(lanValues, "lanValues");
        Intrinsics.checkNotNullParameter(radioFRequency, "radioFRequency");
        Intrinsics.checkNotNullParameter(radioSort, "radioSort");
        return new OnlineRadio(radioId, radioName, radioIcon, radioURI, radioType, countryName, radioARea, lanLocale, lanValues, radioNumber, radioState, radioFRequency, radioSort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineRadio)) {
            return false;
        }
        OnlineRadio onlineRadio = (OnlineRadio) other;
        return Intrinsics.areEqual(this.radioId, onlineRadio.radioId) && Intrinsics.areEqual(this.radioName, onlineRadio.radioName) && Intrinsics.areEqual(this.radioIcon, onlineRadio.radioIcon) && Intrinsics.areEqual(this.radioURI, onlineRadio.radioURI) && Intrinsics.areEqual(this.radioType, onlineRadio.radioType) && Intrinsics.areEqual(this.countryName, onlineRadio.countryName) && Intrinsics.areEqual(this.radioARea, onlineRadio.radioARea) && Intrinsics.areEqual(this.lanLocale, onlineRadio.lanLocale) && Intrinsics.areEqual(this.lanValues, onlineRadio.lanValues) && Intrinsics.areEqual(this.radioNumber, onlineRadio.radioNumber) && Intrinsics.areEqual(this.radioState, onlineRadio.radioState) && Intrinsics.areEqual(this.radioFRequency, onlineRadio.radioFRequency) && Intrinsics.areEqual(this.radioSort, onlineRadio.radioSort);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.radioId.hashCode() * 31) + this.radioName.hashCode()) * 31) + this.radioIcon.hashCode()) * 31) + this.radioURI.hashCode()) * 31) + this.radioType.hashCode()) * 31) + this.countryName.hashCode()) * 31) + this.radioARea.hashCode()) * 31) + this.lanLocale.hashCode()) * 31) + this.lanValues.hashCode()) * 31;
        String str = this.radioNumber;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.radioState;
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.radioFRequency.hashCode()) * 31) + this.radioSort.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OnlineRadio(radioId=");
        sb.append(this.radioId).append(", radioName=").append(this.radioName).append(", radioIcon=").append(this.radioIcon).append(", radioURI=").append(this.radioURI).append(", radioType=").append(this.radioType).append(", countryName=").append(this.countryName).append(", radioARea=").append(this.radioARea).append(", lanLocale=").append(this.lanLocale).append(", lanValues=").append(this.lanValues).append(", radioNumber=").append(this.radioNumber).append(", radioState=").append(this.radioState).append(", radioFRequency=");
        sb.append(this.radioFRequency).append(", radioSort=").append(this.radioSort).append(')');
        return sb.toString();
    }

    public OnlineRadio(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        Intrinsics.checkNotNullParameter(str, "radioId");
        Intrinsics.checkNotNullParameter(str2, "radioName");
        Intrinsics.checkNotNullParameter(str3, "radioIcon");
        Intrinsics.checkNotNullParameter(str4, "radioURI");
        Intrinsics.checkNotNullParameter(str5, "radioType");
        Intrinsics.checkNotNullParameter(str6, "countryName");
        Intrinsics.checkNotNullParameter(str7, "radioARea");
        Intrinsics.checkNotNullParameter(str8, "lanLocale");
        Intrinsics.checkNotNullParameter(str9, "lanValues");
        Intrinsics.checkNotNullParameter(str12, "radioFRequency");
        Intrinsics.checkNotNullParameter(str13, "radioSort");
        this.radioId = str;
        this.radioName = str2;
        this.radioIcon = str3;
        this.radioURI = str4;
        this.radioType = str5;
        this.countryName = str6;
        this.radioARea = str7;
        this.lanLocale = str8;
        this.lanValues = str9;
        this.radioNumber = str10;
        this.radioState = str11;
        this.radioFRequency = str12;
        this.radioSort = str13;
    }

    public /* synthetic */ OnlineRadio(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? FinalChip.BSP_PLATFORM_Null : str, (i & 2) != 0 ? FinalChip.BSP_PLATFORM_Null : str2, (i & 4) != 0 ? FinalChip.BSP_PLATFORM_Null : str3, (i & 8) != 0 ? FinalChip.BSP_PLATFORM_Null : str4, (i & 16) != 0 ? FinalChip.BSP_PLATFORM_Null : str5, (i & 32) != 0 ? FinalChip.BSP_PLATFORM_Null : str6, (i & 64) != 0 ? FinalChip.BSP_PLATFORM_Null : str7, (i & 128) != 0 ? FinalChip.BSP_PLATFORM_Null : str8, (i & 256) != 0 ? FinalChip.BSP_PLATFORM_Null : str9, (i & 512) != 0 ? null : str10, (i & 1024) == 0 ? str11 : null, (i & 2048) != 0 ? FinalChip.BSP_PLATFORM_Null : str12, (i & 4096) == 0 ? str13 : FinalChip.BSP_PLATFORM_Null);
    }

    public final String getRadioId() {
        return this.radioId;
    }

    public final void setRadioId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioId = str;
    }

    public final String getRadioName() {
        return this.radioName;
    }

    public final void setRadioName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioName = str;
    }

    public final String getRadioIcon() {
        return this.radioIcon;
    }

    public final void setRadioIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioIcon = str;
    }

    public final String getRadioURI() {
        return this.radioURI;
    }

    public final void setRadioURI(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioURI = str;
    }

    public final String getRadioType() {
        return this.radioType;
    }

    public final void setRadioType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioType = str;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final void setCountryName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryName = str;
    }

    public final String getRadioARea() {
        return this.radioARea;
    }

    public final void setRadioARea(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioARea = str;
    }

    public final String getLanLocale() {
        return this.lanLocale;
    }

    public final void setLanLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lanLocale = str;
    }

    public final String getLanValues() {
        return this.lanValues;
    }

    public final void setLanValues(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lanValues = str;
    }

    public final String getRadioNumber() {
        return this.radioNumber;
    }

    public final void setRadioNumber(String str) {
        this.radioNumber = str;
    }

    public final String getRadioState() {
        return this.radioState;
    }

    public final void setRadioState(String str) {
        this.radioState = str;
    }

    public final String getRadioFRequency() {
        return this.radioFRequency;
    }

    public final void setRadioFRequency(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioFRequency = str;
    }

    public final String getRadioSort() {
        return this.radioSort;
    }

    public final void setRadioSort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.radioSort = str;
    }
}
