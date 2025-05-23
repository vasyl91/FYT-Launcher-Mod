package com.syu.remote;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

import java.util.ArrayList;
import java.util.List;

public class Callback extends IModuleCallback.Stub {
    List<Lisenter> mLisenters = new ArrayList<>();
    Handler mHandler = new Handler(Looper.getMainLooper());

    public interface OnRefreshLisenter {
        void onRefresh(int i, int[] iArr, float[] fArr, String[] strArr);
    }

    void post(Runnable run) {
        if (this.mHandler != null) {
            this.mHandler.post(run);
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Massage state = new Massage(updateCode, ints, flts, strs);
        state.refresh();
    }

    void addOnRefreshLisenter(OnRefreshLisenter mLisenter, int update) {
        Lisenter lisenter = new Lisenter(mLisenter, update);
        if (!this.mLisenters.contains(lisenter)) {
            this.mLisenters.add(lisenter);
        }
    }

    void removeOnRefreshLisenter(OnRefreshLisenter mLisenter) {
        this.mLisenters.removeIf(lisenter -> lisenter.lisenter.equals(mLisenter));
    }

    static class Lisenter {
        int code;
        OnRefreshLisenter lisenter;

        public Lisenter(OnRefreshLisenter lisenter, int code) {
            this.lisenter = lisenter;
            this.code = code;
        }

        public boolean equals(Object o) {
            if (o instanceof Lisenter) {
                return this.code == ((Lisenter) o).code && ((Lisenter) o).lisenter.equals(this.lisenter);
            }
            return super.equals(o);
        }
    }

    class Massage {
        int code;
        float[] flts;
        int[] ints;
        Runnable refesh = () -> {
            for (Lisenter lisenter : Callback.this.mLisenters) {
                if (lisenter.code == Massage.this.code) {
                    lisenter.lisenter.onRefresh(Massage.this.code, Massage.this.ints, Massage.this.flts, Massage.this.strs);
                }
            }
        };
        String[] strs;

        public Massage(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.code = updateCode;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        void refresh() {
            if (Callback.this.mHandler != null) {
                Callback.this.mHandler.post(this.refesh);
            }
        }
    }
}
