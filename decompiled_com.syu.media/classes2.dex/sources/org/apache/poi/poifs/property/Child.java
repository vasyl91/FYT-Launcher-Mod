package org.apache.poi.poifs.property;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Child {
    Child getNextChild();

    Child getPreviousChild();

    void setNextChild(Child child);

    void setPreviousChild(Child child);
}
