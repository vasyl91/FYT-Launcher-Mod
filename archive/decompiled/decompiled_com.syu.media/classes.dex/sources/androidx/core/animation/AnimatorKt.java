package androidx.core.animation;

import android.animation.Animator;
import chip.FinalChip;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aW\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0013\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0015\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", FinalChip.BSP_PLATFORM_Null, "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class AnimatorKt {
    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Animator animator2) {
                    Intrinsics.checkParameterIsNotNull(animator2, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            function2 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Animator animator2) {
                    Intrinsics.checkParameterIsNotNull(animator2, "it");
                }
            };
        }
        if ((i & 4) != 0) {
            function3 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Animator animator2) {
                    Intrinsics.checkParameterIsNotNull(animator2, "it");
                }
            };
        }
        if ((i & 8) != 0) {
            function4 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.4
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Animator animator2) {
                    Intrinsics.checkParameterIsNotNull(animator2, "it");
                }
            };
        }
        Intrinsics.checkParameterIsNotNull(animator, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(function1, "onEnd");
        Intrinsics.checkParameterIsNotNull(function2, "onStart");
        Intrinsics.checkParameterIsNotNull(function3, "onCancel");
        Intrinsics.checkParameterIsNotNull(function4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function4, function1, function3, function2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static final Animator.AnimatorListener addListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2, Function1<? super Animator, Unit> function3, Function1<? super Animator, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(function1, "onEnd");
        Intrinsics.checkParameterIsNotNull(function2, "onStart");
        Intrinsics.checkParameterIsNotNull(function3, "onCancel");
        Intrinsics.checkParameterIsNotNull(function4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function4, function1, function3, function2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addPauseListener.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Animator animator2) {
                    Intrinsics.checkParameterIsNotNull(animator2, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            function2 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addPauseListener.2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Animator animator2) {
                    Intrinsics.checkParameterIsNotNull(animator2, "it");
                }
            };
        }
        Intrinsics.checkParameterIsNotNull(animator, "$this$addPauseListener");
        Intrinsics.checkParameterIsNotNull(function1, "onResume");
        Intrinsics.checkParameterIsNotNull(function2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function2, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$addPauseListener");
        Intrinsics.checkParameterIsNotNull(function1, "onResume");
        Intrinsics.checkParameterIsNotNull(function2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function2, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnEnd");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnStart");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnCancel");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnRepeat");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnResume");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(animator, "$this$doOnPause");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                Intrinsics.checkParameterIsNotNull(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }
}
