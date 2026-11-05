package com.syu.radio.entities;

import chip.FinalChip;
import com.syu.radio.Radio;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006("}, d2 = {"Lcom/syu/radio/entities/RadioStation;", FinalChip.BSP_PLATFORM_Null, "()V", Radio.CITY, FinalChip.BSP_PLATFORM_Null, "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "cover", "getCover", "setCover", "favorite", FinalChip.BSP_PLATFORM_Null, "getFavorite", "()Z", "setFavorite", "(Z)V", "freq", FinalChip.BSP_PLATFORM_Null, "getFreq", "()Ljava/lang/Integer;", "setFreq", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "id", "getId", "setId", Radio.ONLINE, "getOnline", "setOnline", "title", "getTitle", "setTitle", Radio.URL, "getUrl", "setUrl", "equals", "other", "toString", "radiolib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class RadioStation {
    private String city = Radio.DEF_STR;
    private String cover;
    private boolean favorite;
    private Integer freq;
    private Integer id;
    private boolean online;
    private String title;
    private String url;

    public boolean equals(Object other) {
        if (!(other instanceof RadioStation)) {
            return super.equals(other);
        }
        RadioStation radioStation = (RadioStation) other;
        return Intrinsics.areEqual(radioStation.freq, this.freq) && Intrinsics.areEqual(this.city, radioStation.city);
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCover() {
        return this.cover;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }

    public final Integer getFreq() {
        return this.freq;
    }

    public final Integer getId() {
        return this.id;
    }

    public final boolean getOnline() {
        return this.online;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setCity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.city = str;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final void setFavorite(boolean z) {
        this.favorite = z;
    }

    public final void setFreq(Integer num) {
        this.freq = num;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setOnline(boolean z) {
        this.online = z;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "RadioStation: _id:" + this.id + ", title:" + this.title + " city:" + this.city + " freq:" + this.freq + " favorite:" + this.favorite + " cover_path:" + this.cover;
    }
}
