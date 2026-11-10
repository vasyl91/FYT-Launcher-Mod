package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface IStabilityClassifier {
    public static final IStabilityClassifier TOTALLY_IMMUTABLE = new IStabilityClassifier() { // from class: org.apache.poi.ss.formula.IStabilityClassifier.1
        @Override // org.apache.poi.ss.formula.IStabilityClassifier
        public boolean isCellFinal(int i, int i2, int i3) {
            return true;
        }
    };

    boolean isCellFinal(int i, int i2, int i3);
}
