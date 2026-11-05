package androidx.constraintlayout.motion.widget;

/* JADX INFO: compiled from: DesignTool.java */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
interface ProxyInterface {
    int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3);

    float getKeyFramePosition(Object obj, int i, float f, float f2);

    Object getKeyframeAtLocation(Object obj, float f, float f2);

    Boolean getPositionKeyframe(Object obj, Object obj2, float f, float f2, String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i, String str, Object obj, Object obj2);

    void setKeyFrame(Object obj, int i, String str, Object obj2);

    boolean setKeyFramePosition(Object obj, int i, int i2, float f, float f2);

    void setToolPosition(float f);
}
