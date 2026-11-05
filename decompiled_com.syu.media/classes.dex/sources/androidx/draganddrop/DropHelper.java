package androidx.draganddrop;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.view.DragEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.util.Predicate;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class DropHelper {
    private static final String TAG = "DropHelper";

    private DropHelper() {
    }

    public static void configureView(Activity activity, View view, String[] strArr, OnReceiveContentListener onReceiveContentListener) {
        configureView(activity, view, strArr, new Options.Builder().build(), onReceiveContentListener);
    }

    public static void configureView(Activity activity, View view, final String[] strArr, Options options, OnReceiveContentListener onReceiveContentListener) {
        DropAffordanceHighlighter.Builder builderForView = DropAffordanceHighlighter.forView(view, new Predicate() { // from class: androidx.draganddrop.DropHelper$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return DropHelper.lambda$configureView$0(strArr, (ClipDescription) obj);
            }
        });
        if (options.hasHighlightColor()) {
            builderForView.setHighlightColor(options.getHighlightColor());
        }
        if (options.hasHighlightCornerRadiusPx()) {
            builderForView.setHighlightCornerRadiusPx(options.getHighlightCornerRadiusPx());
        }
        builderForView.shouldAcceptDragsWithLocalState(options.shouldAcceptDragsWithLocalState());
        DropAffordanceHighlighter dropAffordanceHighlighterBuild = builderForView.build();
        List<EditText> innerEditTexts = options.getInnerEditTexts();
        if (!innerEditTexts.isEmpty()) {
            Iterator<EditText> it = innerEditTexts.iterator();
            while (it.hasNext()) {
                setHighlightingAndHandling(it.next(), strArr, dropAffordanceHighlighterBuild, onReceiveContentListener, activity);
            }
            view.setOnDragListener(createDelegatingHighlightingOnDragListener(activity, dropAffordanceHighlighterBuild, innerEditTexts));
            return;
        }
        setHighlightingAndHandling(view, strArr, dropAffordanceHighlighterBuild, onReceiveContentListener, activity);
    }

    static /* synthetic */ boolean lambda$configureView$0(String[] strArr, ClipDescription clipDescription) {
        if (clipDescription == null) {
            return false;
        }
        for (String str : strArr) {
            if (clipDescription.hasMimeType(str)) {
                return true;
            }
        }
        return false;
    }

    private static void setHighlightingAndHandling(View view, String[] strArr, final DropAffordanceHighlighter dropAffordanceHighlighter, OnReceiveContentListener onReceiveContentListener, Activity activity) {
        ViewCompat.setOnReceiveContentListener(view, strArr, onReceiveContentListener);
        if (Build.VERSION.SDK_INT >= 31 || (view instanceof AppCompatEditText)) {
            Objects.requireNonNull(dropAffordanceHighlighter);
            view.setOnDragListener(new View.OnDragListener() { // from class: androidx.draganddrop.DropHelper$$ExternalSyntheticLambda0
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view2, DragEvent dragEvent) {
                    return dropAffordanceHighlighter.onDrag(view2, dragEvent);
                }
            });
        } else {
            view.setOnDragListener(createHighlightingOnDragListener(dropAffordanceHighlighter, activity));
        }
    }

    private static View.OnDragListener createHighlightingOnDragListener(final DropAffordanceHighlighter dropAffordanceHighlighter, final Activity activity) {
        return new View.OnDragListener() { // from class: androidx.draganddrop.DropHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return DropHelper.lambda$createHighlightingOnDragListener$1(activity, dropAffordanceHighlighter, view, dragEvent);
            }
        };
    }

    static /* synthetic */ boolean lambda$createHighlightingOnDragListener$1(Activity activity, DropAffordanceHighlighter dropAffordanceHighlighter, View view, DragEvent dragEvent) {
        if (dragEvent.getAction() == 3) {
            ContentInfoCompat contentInfoCompatBuild = new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build();
            try {
                requestPermissionsIfNeeded(activity, dragEvent);
                ViewCompat.performReceiveContent(view, contentInfoCompatBuild);
            } catch (CouldNotObtainPermissionsException unused) {
                return false;
            }
        }
        return dropAffordanceHighlighter.onDrag(view, dragEvent);
    }

    private static void requestPermissionsIfNeeded(Activity activity, DragEvent dragEvent) throws CouldNotObtainPermissionsException {
        ClipData clipData = dragEvent.getClipData();
        if (clipData != null && hasUris(clipData) && activity.requestDragAndDropPermissions(dragEvent) == null) {
            throw new CouldNotObtainPermissionsException("Couldn't get DragAndDropPermissions");
        }
    }

    private static class CouldNotObtainPermissionsException extends Exception {
        CouldNotObtainPermissionsException(String str) {
            super(str);
        }
    }

    private static boolean hasUris(ClipData clipData) {
        for (int i = 0; i < clipData.getItemCount(); i++) {
            if (clipData.getItemAt(i).getUri() != null) {
                return true;
            }
        }
        return false;
    }

    private static View.OnDragListener createDelegatingHighlightingOnDragListener(final Activity activity, final DropAffordanceHighlighter dropAffordanceHighlighter, final List<EditText> list) {
        return new View.OnDragListener() { // from class: androidx.draganddrop.DropHelper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return DropHelper.lambda$createDelegatingHighlightingOnDragListener$2(activity, list, dropAffordanceHighlighter, view, dragEvent);
            }
        };
    }

    static /* synthetic */ boolean lambda$createDelegatingHighlightingOnDragListener$2(Activity activity, List list, DropAffordanceHighlighter dropAffordanceHighlighter, View view, DragEvent dragEvent) {
        if (dragEvent.getAction() == 3) {
            ContentInfoCompat contentInfoCompatBuild = new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build();
            try {
                requestPermissionsIfNeeded(activity, dragEvent);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    EditText editText = (EditText) it.next();
                    if (editText.hasFocus()) {
                        ViewCompat.performReceiveContent(editText, contentInfoCompatBuild);
                        return true;
                    }
                }
                ViewCompat.performReceiveContent((View) list.get(0), contentInfoCompatBuild);
                return true;
            } catch (CouldNotObtainPermissionsException unused) {
                return false;
            }
        }
        return dropAffordanceHighlighter.onDrag(view, dragEvent);
    }

    public static final class Options {
        private final boolean mAcceptDragsWithLocalState;
        private final int mHighlightColor;
        private final boolean mHighlightColorHasBeenSupplied;
        private final int mHighlightCornerRadiusPx;
        private final boolean mHighlightCornerRadiusPxHasBeenSupplied;
        private final List<EditText> mInnerEditTexts;

        Options(int i, boolean z, int i2, boolean z2, boolean z3, List<EditText> list) {
            this.mHighlightColor = i;
            this.mHighlightColorHasBeenSupplied = z;
            this.mHighlightCornerRadiusPx = i2;
            this.mHighlightCornerRadiusPxHasBeenSupplied = z2;
            this.mAcceptDragsWithLocalState = z3;
            this.mInnerEditTexts = list != null ? new ArrayList(list) : new ArrayList();
        }

        public int getHighlightColor() {
            return this.mHighlightColor;
        }

        public boolean hasHighlightColor() {
            return this.mHighlightColorHasBeenSupplied;
        }

        public int getHighlightCornerRadiusPx() {
            return this.mHighlightCornerRadiusPx;
        }

        public boolean hasHighlightCornerRadiusPx() {
            return this.mHighlightCornerRadiusPxHasBeenSupplied;
        }

        public boolean shouldAcceptDragsWithLocalState() {
            return this.mAcceptDragsWithLocalState;
        }

        public List<EditText> getInnerEditTexts() {
            return Collections.unmodifiableList(this.mInnerEditTexts);
        }

        public static final class Builder {
            private int mHighlightColor;
            private int mHighlightCornerRadiusPx;
            private List<EditText> mInnerEditTexts;
            private boolean mHighlightColorHasBeenSupplied = false;
            private boolean mHighlightCornerRadiusPxHasBeenSupplied = false;
            private boolean mAcceptDragsWithLocalState = false;

            public Options build() {
                return new Options(this.mHighlightColor, this.mHighlightColorHasBeenSupplied, this.mHighlightCornerRadiusPx, this.mHighlightCornerRadiusPxHasBeenSupplied, this.mAcceptDragsWithLocalState, this.mInnerEditTexts);
            }

            public Builder addInnerEditTexts(EditText... editTextArr) {
                if (this.mInnerEditTexts == null) {
                    this.mInnerEditTexts = new ArrayList();
                }
                Collections.addAll(this.mInnerEditTexts, editTextArr);
                return this;
            }

            public Builder setHighlightColor(int i) {
                this.mHighlightColor = i;
                this.mHighlightColorHasBeenSupplied = true;
                return this;
            }

            public Builder setHighlightCornerRadiusPx(int i) {
                this.mHighlightCornerRadiusPx = i;
                this.mHighlightCornerRadiusPxHasBeenSupplied = true;
                return this;
            }

            public Builder setAcceptDragsWithLocalState(boolean z) {
                this.mAcceptDragsWithLocalState = z;
                return this;
            }
        }
    }
}
