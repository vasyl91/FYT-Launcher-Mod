package androidx.lifecycle;

import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Transformations {
    private Transformations() {
    }

    public static <X, Y> LiveData<Y> map(LiveData<X> source, final Function<X, Y> mapFunction) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(source, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                mediatorLiveData.setValue(mapFunction.apply(x));
            }
        });
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> switchMap(LiveData<X> source, final Function<X, LiveData<Y>> switchMapFunction) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(source, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X x) {
                LiveData<Y> liveData = (LiveData) switchMapFunction.apply(x);
                Object obj = this.mSource;
                if (obj == liveData) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.mSource = liveData;
                if (liveData != 0) {
                    mediatorLiveData.addSource(liveData, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        @Override // androidx.lifecycle.Observer
                        public void onChanged(Y y) {
                            mediatorLiveData.setValue(y);
                        }
                    });
                }
            }
        });
        return mediatorLiveData;
    }

    public static <X> LiveData<X> distinctUntilChanged(LiveData<X> source) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(source, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            boolean mFirstTime = true;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X currentValue) {
                T value = mediatorLiveData.getValue();
                if (this.mFirstTime || ((value == 0 && currentValue != null) || !(value == 0 || value.equals(currentValue)))) {
                    this.mFirstTime = false;
                    mediatorLiveData.setValue(currentValue);
                }
            }
        });
        return mediatorLiveData;
    }
}
