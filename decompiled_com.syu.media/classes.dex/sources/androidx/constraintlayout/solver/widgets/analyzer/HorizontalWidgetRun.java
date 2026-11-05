package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        if (this.widget.measured) {
            this.dimension.resolve(this.widget.getWidth());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getHorizontalDimensionBehaviour();
            if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent2 = this.widget.getParent()) != null && parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    int width = (parent2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    addTarget(this.start, parent2.horizontalRun.start, this.widget.mLeft.getMargin());
                    addTarget(this.end, parent2.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(width);
                    return;
                }
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((parent = this.widget.getParent()) != null && parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            addTarget(this.start, parent.horizontalRun.start, this.widget.mLeft.getMargin());
            addTarget(this.end, parent.horizontalRun.end, -this.widget.mRight.getMargin());
            return;
        }
        if (this.dimension.resolved && this.widget.measured) {
            if (this.widget.mListAnchors[0].mTarget != null && this.widget.mListAnchors[1].mTarget != null) {
                if (this.widget.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                    return;
                }
                DependencyNode target = getTarget(this.widget.mListAnchors[0]);
                if (target != null) {
                    addTarget(this.start, target, this.widget.mListAnchors[0].getMargin());
                }
                DependencyNode target2 = getTarget(this.widget.mListAnchors[1]);
                if (target2 != null) {
                    addTarget(this.end, target2, -this.widget.mListAnchors[1].getMargin());
                }
                this.start.delegateToWidgetRun = true;
                this.end.delegateToWidgetRun = true;
                return;
            }
            if (this.widget.mListAnchors[0].mTarget != null) {
                DependencyNode target3 = getTarget(this.widget.mListAnchors[0]);
                if (target3 != null) {
                    addTarget(this.start, target3, this.widget.mListAnchors[0].getMargin());
                    addTarget(this.end, this.start, this.dimension.value);
                    return;
                }
                return;
            }
            if (this.widget.mListAnchors[1].mTarget != null) {
                DependencyNode target4 = getTarget(this.widget.mListAnchors[1]);
                if (target4 != null) {
                    addTarget(this.end, target4, -this.widget.mListAnchors[1].getMargin());
                    addTarget(this.start, this.end, -this.dimension.value);
                    return;
                }
                return;
            }
            if ((this.widget instanceof Helper) || this.widget.getParent() == null || this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                return;
            }
            addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
            addTarget(this.end, this.start, this.dimension.value);
            return;
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i = this.widget.mMatchConstraintDefaultWidth;
            if (i == 2) {
                ConstraintWidget parent3 = this.widget.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency = parent3.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency);
                    dimensionDependency.dependencies.add(this.dimension);
                    this.dimension.delegateToWidgetRun = true;
                    this.dimension.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            } else if (i == 3) {
                if (this.widget.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    this.widget.verticalRun.start.updateDelegate = this;
                    this.widget.verticalRun.end.updateDelegate = this;
                    this.dimension.updateDelegate = this;
                    if (this.widget.isInVerticalChain()) {
                        this.dimension.targets.add(this.widget.verticalRun.dimension);
                        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                        this.widget.verticalRun.dimension.updateDelegate = this;
                        this.dimension.targets.add(this.widget.verticalRun.start);
                        this.dimension.targets.add(this.widget.verticalRun.end);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                    } else if (this.widget.isInHorizontalChain()) {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                    } else {
                        this.widget.verticalRun.dimension.targets.add(this.dimension);
                    }
                } else {
                    DimensionDependency dimensionDependency2 = this.widget.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency2);
                    dimensionDependency2.dependencies.add(this.dimension);
                    this.widget.verticalRun.start.dependencies.add(this.dimension);
                    this.widget.verticalRun.end.dependencies.add(this.dimension);
                    this.dimension.delegateToWidgetRun = true;
                    this.dimension.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                    this.start.targets.add(this.dimension);
                    this.end.targets.add(this.dimension);
                }
            }
        }
        if (this.widget.mListAnchors[0].mTarget != null && this.widget.mListAnchors[1].mTarget != null) {
            if (this.widget.isInHorizontalChain()) {
                this.start.margin = this.widget.mListAnchors[0].getMargin();
                this.end.margin = -this.widget.mListAnchors[1].getMargin();
                return;
            }
            DependencyNode target5 = getTarget(this.widget.mListAnchors[0]);
            DependencyNode target6 = getTarget(this.widget.mListAnchors[1]);
            target5.addDependency(this);
            target6.addDependency(this);
            this.mRunType = WidgetRun.RunType.CENTER;
            return;
        }
        if (this.widget.mListAnchors[0].mTarget != null) {
            DependencyNode target7 = getTarget(this.widget.mListAnchors[0]);
            if (target7 != null) {
                addTarget(this.start, target7, this.widget.mListAnchors[0].getMargin());
                addTarget(this.end, this.start, 1, this.dimension);
                return;
            }
            return;
        }
        if (this.widget.mListAnchors[1].mTarget != null) {
            DependencyNode target8 = getTarget(this.widget.mListAnchors[1]);
            if (target8 != null) {
                addTarget(this.end, target8, -this.widget.mListAnchors[1].getMargin());
                addTarget(this.start, this.end, -1, this.dimension);
                return;
            }
            return;
        }
        if ((this.widget instanceof Helper) || this.widget.getParent() == null) {
            return;
        }
        addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
        addTarget(this.end, this.start, 1, this.dimension);
    }

    private void computeInsetRatio(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:126:0x030b  */
    /* JADX WARN: Code duplicated, block: B:128:0x031a  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int limitedDimension;
        int i;
        int limitedDimension2;
        float f;
        float dimensionRatio;
        float dimensionRatio2;
        int i2;
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (i3 == 1) {
            updateRunStart(dependency);
        } else if (i3 == 2) {
            updateRunEnd(dependency);
        } else if (i3 == 3) {
            updateRunCenter(dependency, this.widget.mLeft, this.widget.mRight, 0);
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i4 = this.widget.mMatchConstraintDefaultWidth;
            if (i4 == 2) {
                ConstraintWidget parent = this.widget.getParent();
                if (parent != null && parent.horizontalRun.dimension.resolved) {
                    this.dimension.resolve((int) ((parent.horizontalRun.dimension.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
                }
            } else if (i4 == 3) {
                if (this.widget.mMatchConstraintDefaultHeight == 0 || this.widget.mMatchConstraintDefaultHeight == 3) {
                    DependencyNode dependencyNode = this.widget.verticalRun.start;
                    DependencyNode dependencyNode2 = this.widget.verticalRun.end;
                    boolean z = this.widget.mLeft.mTarget != null;
                    boolean z2 = this.widget.mTop.mTarget != null;
                    boolean z3 = this.widget.mRight.mTarget != null;
                    boolean z4 = this.widget.mBottom.mTarget != null;
                    int dimensionRatioSide = this.widget.getDimensionRatioSide();
                    if (z && z2 && z3 && z4) {
                        float dimensionRatio3 = this.widget.getDimensionRatio();
                        if (dependencyNode.resolved && dependencyNode2.resolved) {
                            if (this.start.readyToSolve && this.end.readyToSolve) {
                                computeInsetRatio(tempDimensions, this.start.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, dimensionRatio3, dimensionRatioSide);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                return;
                            }
                            return;
                        }
                        if (this.start.resolved && this.end.resolved) {
                            if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                                return;
                            }
                            computeInsetRatio(tempDimensions, this.start.value + this.start.margin, this.end.value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio3, dimensionRatioSide);
                            this.dimension.resolve(tempDimensions[0]);
                            this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                        }
                        if (!this.start.readyToSolve || !this.end.readyToSolve || !dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                            return;
                        }
                        computeInsetRatio(tempDimensions, this.start.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio3, dimensionRatioSide);
                        this.dimension.resolve(tempDimensions[0]);
                        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                    } else if (z && z3) {
                        if (!this.start.readyToSolve || !this.end.readyToSolve) {
                            return;
                        }
                        float dimensionRatio4 = this.widget.getDimensionRatio();
                        int i5 = this.start.targets.get(0).value + this.start.margin;
                        int i6 = this.end.targets.get(0).value - this.end.margin;
                        if (dimensionRatioSide == -1 || dimensionRatioSide == 0) {
                            int limitedDimension3 = getLimitedDimension(i6 - i5, 0);
                            int i7 = (int) ((limitedDimension3 * dimensionRatio4) + 0.5f);
                            int limitedDimension4 = getLimitedDimension(i7, 1);
                            if (i7 != limitedDimension4) {
                                limitedDimension3 = (int) ((limitedDimension4 / dimensionRatio4) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension3);
                            this.widget.verticalRun.dimension.resolve(limitedDimension4);
                        } else if (dimensionRatioSide == 1) {
                            int limitedDimension5 = getLimitedDimension(i6 - i5, 0);
                            int i8 = (int) ((limitedDimension5 / dimensionRatio4) + 0.5f);
                            int limitedDimension6 = getLimitedDimension(i8, 1);
                            if (i8 != limitedDimension6) {
                                limitedDimension5 = (int) ((limitedDimension6 * dimensionRatio4) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension5);
                            this.widget.verticalRun.dimension.resolve(limitedDimension6);
                        }
                    } else if (z2 && z4) {
                        if (!dependencyNode.readyToSolve || !dependencyNode2.readyToSolve) {
                            return;
                        }
                        float dimensionRatio5 = this.widget.getDimensionRatio();
                        int i9 = dependencyNode.targets.get(0).value + dependencyNode.margin;
                        int i10 = dependencyNode2.targets.get(0).value - dependencyNode2.margin;
                        if (dimensionRatioSide == -1) {
                            limitedDimension = getLimitedDimension(i10 - i9, 1);
                            i = (int) ((limitedDimension / dimensionRatio5) + 0.5f);
                            limitedDimension2 = getLimitedDimension(i, 0);
                            if (i != limitedDimension2) {
                                limitedDimension = (int) ((limitedDimension2 * dimensionRatio5) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension2);
                            this.widget.verticalRun.dimension.resolve(limitedDimension);
                        } else if (dimensionRatioSide == 0) {
                            int limitedDimension7 = getLimitedDimension(i10 - i9, 1);
                            int i11 = (int) ((limitedDimension7 * dimensionRatio5) + 0.5f);
                            int limitedDimension8 = getLimitedDimension(i11, 0);
                            if (i11 != limitedDimension8) {
                                limitedDimension7 = (int) ((limitedDimension8 / dimensionRatio5) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension8);
                            this.widget.verticalRun.dimension.resolve(limitedDimension7);
                        } else if (dimensionRatioSide == 1) {
                            limitedDimension = getLimitedDimension(i10 - i9, 1);
                            i = (int) ((limitedDimension / dimensionRatio5) + 0.5f);
                            limitedDimension2 = getLimitedDimension(i, 0);
                            if (i != limitedDimension2) {
                                limitedDimension = (int) ((limitedDimension2 * dimensionRatio5) + 0.5f);
                            }
                            this.dimension.resolve(limitedDimension2);
                            this.widget.verticalRun.dimension.resolve(limitedDimension);
                        }
                    }
                } else {
                    int dimensionRatioSide2 = this.widget.getDimensionRatioSide();
                    if (dimensionRatioSide2 == -1) {
                        f = this.widget.verticalRun.dimension.value;
                        dimensionRatio = this.widget.getDimensionRatio();
                    } else {
                        if (dimensionRatioSide2 == 0) {
                            dimensionRatio2 = this.widget.verticalRun.dimension.value / this.widget.getDimensionRatio();
                            i2 = (int) (dimensionRatio2 + 0.5f);
                        } else if (dimensionRatioSide2 != 1) {
                            i2 = 0;
                        } else {
                            f = this.widget.verticalRun.dimension.value;
                            dimensionRatio = this.widget.getDimensionRatio();
                        }
                        this.dimension.resolve(i2);
                    }
                    dimensionRatio2 = f * dimensionRatio;
                    i2 = (int) (dimensionRatio2 + 0.5f);
                    this.dimension.resolve(i2);
                }
            }
        }
        if (this.start.readyToSolve && this.end.readyToSolve) {
            if (this.start.resolved && this.end.resolved && this.dimension.resolved) {
                return;
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.mMatchConstraintDefaultWidth == 0 && !this.widget.isInHorizontalChain()) {
                DependencyNode dependencyNode3 = this.start.targets.get(0);
                DependencyNode dependencyNode4 = this.end.targets.get(0);
                int i12 = dependencyNode3.value + this.start.margin;
                int i13 = dependencyNode4.value + this.end.margin;
                this.start.resolve(i12);
                this.end.resolve(i13);
                this.dimension.resolve(i13 - i12);
                return;
            }
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                int iMin = Math.min((this.end.targets.get(0).value + this.end.margin) - (this.start.targets.get(0).value + this.start.margin), this.dimension.wrapValue);
                int i14 = this.widget.mMatchConstraintMaxWidth;
                int iMax = Math.max(this.widget.mMatchConstraintMinWidth, iMin);
                if (i14 > 0) {
                    iMax = Math.min(i14, iMax);
                }
                this.dimension.resolve(iMax);
            }
            if (this.dimension.resolved) {
                DependencyNode dependencyNode5 = this.start.targets.get(0);
                DependencyNode dependencyNode6 = this.end.targets.get(0);
                int i15 = dependencyNode5.value + this.start.margin;
                int i16 = dependencyNode6.value + this.end.margin;
                float horizontalBiasPercent = this.widget.getHorizontalBiasPercent();
                if (dependencyNode5 == dependencyNode6) {
                    i15 = dependencyNode5.value;
                    i16 = dependencyNode6.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (i15 + 0.5f + (((i16 - i15) - this.dimension.value) * horizontalBiasPercent)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved) {
            this.widget.setX(this.start.value);
        }
    }
}
