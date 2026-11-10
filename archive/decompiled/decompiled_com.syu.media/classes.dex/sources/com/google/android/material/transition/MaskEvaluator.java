package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class MaskEvaluator {
    private ShapeAppearanceModel currentShapeAppearanceModel;
    private final Path path = new Path();
    private final Path startPath = new Path();
    private final Path endPath = new Path();
    private final ShapeAppearancePathProvider pathProvider = ShapeAppearancePathProvider.getInstance();

    MaskEvaluator() {
    }

    void evaluate(float f, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel shapeAppearanceModelLerp = TransitionUtils.lerp(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f);
        this.currentShapeAppearanceModel = shapeAppearanceModelLerp;
        this.pathProvider.calculatePath(shapeAppearanceModelLerp, 1.0f, rectF2, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, rectF3, this.endPath);
        this.path.op(this.startPath, this.endPath, Path.Op.UNION);
    }

    void clip(Canvas canvas) {
        canvas.clipPath(this.path);
    }

    Path getPath() {
        return this.path;
    }

    ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }
}
