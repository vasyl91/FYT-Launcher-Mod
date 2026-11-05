package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Deprecated
public class FragmentManagerNonConfig {
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    private final Collection<Fragment> mFragments;
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(Collection<Fragment> collection, Map<String, FragmentManagerNonConfig> map, Map<String, ViewModelStore> map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    boolean isRetaining(Fragment fragment) {
        Collection<Fragment> collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }

    Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }
}
