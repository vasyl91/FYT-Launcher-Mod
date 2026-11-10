package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FixedOrderComparator<T> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 82794675842863201L;
    private final Map<T, Integer> map = new HashMap();
    private int counter = 0;
    private boolean isLocked = false;
    private UnknownObjectBehavior unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;

    public enum UnknownObjectBehavior {
        BEFORE,
        AFTER,
        EXCEPTION
    }

    public FixedOrderComparator() {
    }

    public FixedOrderComparator(T... tArr) {
        if (tArr == null) {
            throw new NullPointerException("The list of items must not be null");
        }
        for (T t : tArr) {
            add(t);
        }
    }

    public FixedOrderComparator(List<T> list) {
        if (list == null) {
            throw new NullPointerException("The list of items must not be null");
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    protected void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior unknownObjectBehavior) {
        checkLocked();
        if (unknownObjectBehavior == null) {
            throw new NullPointerException("Unknown object behavior must not be null");
        }
        this.unknownObjectBehavior = unknownObjectBehavior;
    }

    public boolean add(T t) {
        checkLocked();
        Map<T, Integer> map = this.map;
        int i = this.counter;
        this.counter = i + 1;
        return map.put(t, Integer.valueOf(i)) == null;
    }

    public boolean addAsEqual(T t, T t2) {
        checkLocked();
        Integer num = this.map.get(t);
        if (num != null) {
            return this.map.put(t2, num) == null;
        }
        throw new IllegalArgumentException(t + " not known to " + this);
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        this.isLocked = true;
        Integer num = this.map.get(t);
        Integer num2 = this.map.get(t2);
        if (num == null || num2 == null) {
            int i = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[this.unknownObjectBehavior.ordinal()];
            if (i == 1) {
                if (num == null) {
                    return num2 == null ? 0 : -1;
                }
                return 1;
            }
            if (i == 2) {
                if (num == null) {
                    return num2 == null ? 0 : 1;
                }
                return -1;
            }
            if (i == 3) {
                if (num != null) {
                    t = t2;
                }
                throw new IllegalArgumentException("Attempting to compare unknown object " + t);
            }
            throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.unknownObjectBehavior);
        }
        return num.compareTo(num2);
    }

    /* JADX INFO: renamed from: org.apache.commons.collections4.comparators.FixedOrderComparator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior;

        static {
            int[] iArr = new int[UnknownObjectBehavior.values().length];
            $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior = iArr;
            try {
                iArr[UnknownObjectBehavior.BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int hashCode() {
        Map<T, Integer> map = this.map;
        int iHashCode = (629 + (map == null ? 0 : map.hashCode())) * 37;
        UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
        return ((((iHashCode + (unknownObjectBehavior != null ? unknownObjectBehavior.hashCode() : 0)) * 37) + this.counter) * 37) + (!this.isLocked ? 1 : 0);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FixedOrderComparator fixedOrderComparator = (FixedOrderComparator) obj;
        Map<T, Integer> map = this.map;
        if (map != null ? map.equals(fixedOrderComparator.map) : fixedOrderComparator.map == null) {
            UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
            if (unknownObjectBehavior != null) {
                UnknownObjectBehavior unknownObjectBehavior2 = fixedOrderComparator.unknownObjectBehavior;
                if (unknownObjectBehavior == unknownObjectBehavior2 && this.counter == fixedOrderComparator.counter && this.isLocked == fixedOrderComparator.isLocked && unknownObjectBehavior == unknownObjectBehavior2) {
                    return true;
                }
            } else if (fixedOrderComparator.unknownObjectBehavior == null) {
                return true;
            }
        }
        return false;
    }
}
