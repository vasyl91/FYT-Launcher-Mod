package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import chip.FinalChip;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", FinalChip.BSP_PLATFORM_Null, "getSize", "(Landroid/view/Menu;)I", "contains", FinalChip.BSP_PLATFORM_Null, "item", "forEach", FinalChip.BSP_PLATFORM_Null, "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", FinalChip.BSP_PLATFORM_Null, "minusAssign", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class MenuKt {
    public static final MenuItem get(Menu menu, int i) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$get");
        MenuItem item = menu.getItem(i);
        Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
        return item;
    }

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$contains");
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }

    public static final int getSize(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$size");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$isEmpty");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$isNotEmpty");
        return menu.size() != 0;
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            function1.invoke(item);
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            Integer numValueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            function2.invoke(numValueOf, item);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: Menu.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/MenuKt$iterator$1", FinalChip.BSP_PLATFORM_Null, "Landroid/view/MenuItem;", "index", FinalChip.BSP_PLATFORM_Null, "hasNext", FinalChip.BSP_PLATFORM_Null, "next", "remove", FinalChip.BSP_PLATFORM_Null, "core-ktx_release"}, k = 1, mv = {1, 1, 15})
    public static final class AnonymousClass1 implements Iterator<MenuItem>, KMutableIterator {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            MenuItem item = menu.getItem(i);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu menu = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            menu.removeItem(i);
        }
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$iterator");
        return new AnonymousClass1(menu);
    }

    public static final Sequence<MenuItem> getChildren(final Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$children");
        return new Sequence<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }
}
