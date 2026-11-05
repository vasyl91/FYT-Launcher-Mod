package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ViewModelStore {
    private final HashMap<String, ViewModel> mMap = new HashMap<>();

    final void put(String str, ViewModel viewModel) {
        ViewModel viewModelPut = this.mMap.put(str, viewModel);
        if (viewModelPut != null) {
            viewModelPut.onCleared();
        }
    }

    final ViewModel get(String str) {
        return this.mMap.get(str);
    }

    Set<String> keys() {
        return new HashSet(this.mMap.keySet());
    }

    public final void clear() {
        Iterator<ViewModel> it = this.mMap.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.mMap.clear();
    }
}
