package androidx.constraintlayout.solver.widgets.analyzer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(DependencyNode dependencyNode) {
        ((VerticalWidgetRun) this.run).baseline.margin = this.run.widget.getBaselineDistance();
        this.resolved = true;
    }
}
