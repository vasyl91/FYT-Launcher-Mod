package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DesignTool implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> allAttributes;
    static final HashMap<String, String> allMargins;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;
    private String mLastStartState = null;
    private String mLastEndState = null;
    private int mLastStartStateId = -1;
    private int mLastEndStateId = -1;

    public DesignTool(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    static {
        HashMap<Pair<Integer, Integer>, String> map = new HashMap<>();
        allAttributes = map;
        HashMap<String, String> map2 = new HashMap<>();
        allMargins = map2;
        map.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        map.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        map.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        map.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        map.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        map.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        map.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        map.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        map.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        map.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        map.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        map.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        map.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        map2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        map2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        map2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        map2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        map2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        map2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        map2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        map2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        map2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        map2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        map2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        map2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    private static int GetPxFromDp(int i, String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(str.substring(0, iIndexOf)).intValue() * i) / 160.0f);
    }

    private static void Connect(int i, ConstraintSet constraintSet, View view, HashMap<String, String> map, int i2, int i3) {
        String str = allAttributes.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
        String str2 = map.get(str);
        if (str2 != null) {
            String str3 = allMargins.get(str);
            int iGetPxFromDp = str3 != null ? GetPxFromDp(i, map.get(str3)) : 0;
            constraintSet.connect(view.getId(), i2, Integer.parseInt(str2), i3, iGetPxFromDp);
        }
    }

    private static void SetBias(ConstraintSet constraintSet, View view, HashMap<String, String> map, int i) {
        String str = map.get(i == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (i == 0) {
                constraintSet.setHorizontalBias(view.getId(), Float.parseFloat(str));
            } else if (i == 1) {
                constraintSet.setVerticalBias(view.getId(), Float.parseFloat(str));
            }
        }
    }

    private static void SetDimensions(int i, ConstraintSet constraintSet, View view, HashMap<String, String> map, int i2) {
        String str = map.get(i2 == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int iGetPxFromDp = !str.equalsIgnoreCase("wrap_content") ? GetPxFromDp(i, str) : -2;
            if (i2 == 0) {
                constraintSet.constrainWidth(view.getId(), iGetPxFromDp);
            } else {
                constraintSet.constrainHeight(view.getId(), iGetPxFromDp);
            }
        }
    }

    private static void SetAbsolutePositions(int i, ConstraintSet constraintSet, View view, HashMap<String, String> map) {
        String str = map.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.setEditorAbsoluteX(view.getId(), GetPxFromDp(i, str));
        }
        String str2 = map.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.setEditorAbsoluteY(view.getId(), GetPxFromDp(i, str2));
        }
    }

    public int getAnimationPath(Object obj, float[] fArr, int i) {
        if (this.mMotionLayout.mScene == null) {
            return -1;
        }
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildPath(fArr, i);
        return i;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        if (this.mMotionLayout.mScene == null) {
            return;
        }
        int duration = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return;
        }
        motionController.buildRectangles(fArr, duration);
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        if (this.mMotionLayout.mScene == null) {
            return -1;
        }
        int duration = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildKeyFrames(fArr, null);
        return duration;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float f) {
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        this.mMotionLayout.setProgress(f);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setState(String str) {
        if (str == null) {
            str = "motion_base";
        }
        if (this.mLastStartState == str) {
            return;
        }
        this.mLastStartState = str;
        this.mLastEndState = null;
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        int iLookUpConstraintId = str != null ? this.mMotionLayout.lookUpConstraintId(str) : R.id.motion_base;
        this.mLastStartStateId = iLookUpConstraintId;
        if (iLookUpConstraintId != 0) {
            if (iLookUpConstraintId == this.mMotionLayout.getStartState()) {
                this.mMotionLayout.setProgress(0.0f);
            } else if (iLookUpConstraintId == this.mMotionLayout.getEndState()) {
                this.mMotionLayout.setProgress(1.0f);
            } else {
                this.mMotionLayout.transitionToState(iLookUpConstraintId);
                this.mMotionLayout.setProgress(1.0f);
            }
        }
        this.mMotionLayout.requestLayout();
    }

    public String getStartState() {
        int startState = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == startState) {
            return this.mLastStartState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(startState);
        if (constraintSetNames != null) {
            this.mLastStartState = constraintSetNames;
            this.mLastStartStateId = startState;
        }
        return this.mMotionLayout.getConstraintSetNames(startState);
    }

    public String getEndState() {
        int endState = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == endState) {
            return this.mLastEndState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(endState);
        if (constraintSetNames != null) {
            this.mLastEndState = constraintSetNames;
            this.mLastEndStateId = endState;
        }
        return constraintSetNames;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getState() {
        if (this.mLastStartState != null && this.mLastEndState != null) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.mLastStartState;
            }
            if (progress >= 0.99f) {
                return this.mLastEndState;
            }
        }
        return this.mLastStartState;
    }

    public boolean isInTransition() {
        return (this.mLastStartState == null || this.mLastEndState == null) ? false : true;
    }

    public void setTransition(String str, String str2) {
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        int iLookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
        int iLookUpConstraintId2 = this.mMotionLayout.lookUpConstraintId(str2);
        this.mMotionLayout.setTransition(iLookUpConstraintId, iLookUpConstraintId2);
        this.mLastStartStateId = iLookUpConstraintId;
        this.mLastEndStateId = iLookUpConstraintId2;
        this.mLastStartState = str;
        this.mLastEndState = str2;
    }

    public void disableAutoTransition(boolean z) {
        this.mMotionLayout.disableAutoTransition(z);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getkeyFramePositions(iArr, fArr);
    }

    public int getKeyFrameInfo(Object obj, int i, int[] iArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i, iArr);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object obj, int i, float f, float f2) {
        return this.mMotionLayout.mFrameArrayList.get((View) obj).getKeyFrameParameter(i, f, f2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object obj, int i, String str, Object obj2) {
        if (this.mMotionLayout.mScene != null) {
            this.mMotionLayout.mScene.setKeyframe((View) obj, i, str, obj2);
            this.mMotionLayout.mTransitionGoalPosition = i / 100.0f;
            this.mMotionLayout.mTransitionLastPosition = 0.0f;
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object obj, int i, int i2, float f, float f2) {
        if (this.mMotionLayout.mScene == null) {
            return false;
        }
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        int i3 = (int) (this.mMotionLayout.mTransitionPosition * 100.0f);
        if (motionController == null) {
            return false;
        }
        View view = (View) obj;
        if (!this.mMotionLayout.mScene.hasKeyFramePosition(view, i3)) {
            return false;
        }
        float keyFrameParameter = motionController.getKeyFrameParameter(2, f, f2);
        float keyFrameParameter2 = motionController.getKeyFrameParameter(5, f, f2);
        this.mMotionLayout.mScene.setKeyframe(view, i3, "motion:percentX", Float.valueOf(keyFrameParameter));
        this.mMotionLayout.mScene.setKeyframe(view, i3, "motion:percentY", Float.valueOf(keyFrameParameter2));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    }

    public void setViewDebug(Object obj, int i) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController != null) {
            motionController.setDrawPath(i);
            this.mMotionLayout.invalidate();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        MotionController motionController;
        View view = (View) obj;
        if (i == 0) {
            motionController = null;
        } else if (this.mMotionLayout.mScene == null || view == null || (motionController = this.mMotionLayout.mFrameArrayList.get(view)) == null) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            int duration = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildPath(fArr2, duration);
            return duration;
        }
        if (i == 2) {
            int duration2 = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildKeyFrames(fArr2, null);
            return duration2;
        }
        if (i != 3) {
            return -1;
        }
        int duration3 = this.mMotionLayout.mScene.getDuration() / 16;
        return motionController.getAttributeValues(str, fArr2, i3);
    }

    public Object getKeyframe(int i, int i2, int i3) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), i, i2, i3);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object obj, float f, float f2) {
        MotionController motionController;
        View view = (View) obj;
        if (this.mMotionLayout.mScene == null) {
            return -1;
        }
        if (view == null || (motionController = this.mMotionLayout.mFrameArrayList.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return motionController.getPositionKeyframe(viewGroup.getWidth(), viewGroup.getHeight(), f, f2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object obj, Object obj2, float f, float f2, String[] strArr, float[] fArr) {
        if (obj instanceof KeyPositionBase) {
            View view = (View) obj2;
            this.mMotionLayout.mFrameArrayList.get(view).positionKeyframe(view, (KeyPositionBase) obj, f, f2, strArr, fArr);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
            return true;
        }
        return false;
    }

    public Object getKeyframe(Object obj, int i, int i2) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), i, ((View) obj).getId(), i2);
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int i, String str, Object obj, Object obj2) {
        View view = (View) obj;
        HashMap map = (HashMap) obj2;
        int iLookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
        ConstraintSet constraintSet = this.mMotionLayout.mScene.getConstraintSet(iLookUpConstraintId);
        if (constraintSet == null) {
            return;
        }
        constraintSet.clear(view.getId());
        SetDimensions(i, constraintSet, view, map, 0);
        SetDimensions(i, constraintSet, view, map, 1);
        Connect(i, constraintSet, view, map, 6, 6);
        Connect(i, constraintSet, view, map, 6, 7);
        Connect(i, constraintSet, view, map, 7, 7);
        Connect(i, constraintSet, view, map, 7, 6);
        Connect(i, constraintSet, view, map, 1, 1);
        Connect(i, constraintSet, view, map, 1, 2);
        Connect(i, constraintSet, view, map, 2, 2);
        Connect(i, constraintSet, view, map, 2, 1);
        Connect(i, constraintSet, view, map, 3, 3);
        Connect(i, constraintSet, view, map, 3, 4);
        Connect(i, constraintSet, view, map, 4, 3);
        Connect(i, constraintSet, view, map, 4, 4);
        Connect(i, constraintSet, view, map, 5, 5);
        SetBias(constraintSet, view, map, 0);
        SetBias(constraintSet, view, map, 1);
        SetAbsolutePositions(i, constraintSet, view, map);
        this.mMotionLayout.updateState(iLookUpConstraintId, constraintSet);
        this.mMotionLayout.requestLayout();
    }

    public void dumpConstraintSet(String str) {
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        int iLookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
        System.out.println(" dumping  " + str + " (" + iLookUpConstraintId + ")");
        try {
            this.mMotionLayout.mScene.getConstraintSet(iLookUpConstraintId).dump(this.mMotionLayout.mScene, new int[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
