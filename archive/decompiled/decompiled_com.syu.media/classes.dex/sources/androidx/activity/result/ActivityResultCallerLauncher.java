package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import chip.FinalChip;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B/\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J!\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001c"}, d2 = {"Landroidx/activity/result/ActivityResultCallerLauncher;", "I", "O", "Landroidx/activity/result/ActivityResultLauncher;", FinalChip.BSP_PLATFORM_Null, "launcher", "callerContract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "(Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;)V", "getCallerContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "getInput", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "resultContract", "getResultContract", "resultContract$delegate", "Lkotlin/Lazy;", "getContract", "launch", "void", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Lkotlin/Unit;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {
    private final ActivityResultContract<I, O> callerContract;
    private final I input;
    private final ActivityResultLauncher<I> launcher;

    /* JADX INFO: renamed from: resultContract$delegate, reason: from kotlin metadata */
    private final Lazy resultContract;

    public final ActivityResultContract<Unit, O> getResultContract() {
        return (ActivityResultContract) this.resultContract.getValue();
    }

    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getInput() {
        return this.input;
    }

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> activityResultLauncher, ActivityResultContract<I, O> activityResultContract, I i) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "launcher");
        Intrinsics.checkNotNullParameter(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.input = i;
        this.resultContract = LazyKt.lazy(new Function0<ActivityResultCallerLauncher$resultContract$2.AnonymousClass1>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnonymousClass1 m2invoke() {
                return new ActivityResultContract<Unit, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public Intent createIntent(Context context, Unit unit) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intent intentCreateIntent = ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().createIntent(context, ActivityResultCallerLauncher$resultContract$2.this.this$0.getInput());
                        Intrinsics.checkNotNullExpressionValue(intentCreateIntent, "callerContract.createIntent(context, input)");
                        return intentCreateIntent;
                    }

                    @Override // androidx.activity.result.contract.ActivityResultContract
                    public O parseResult(int resultCode, Intent intent) {
                        return (O) ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().parseResult(resultCode, intent);
                    }
                };
            }
        });
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(Unit unit, ActivityOptionsCompat options) {
        this.launcher.launch(this.input, options);
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<Unit, ?> getContract() {
        return getResultContract();
    }
}
