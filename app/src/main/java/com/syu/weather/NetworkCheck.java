package com.syu.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

import java.util.ArrayList;
import java.util.List;

public class NetworkCheck extends BroadcastReceiver {
    public static final int DELAY = 30000;
    boolean hasNet;
    Context mContext;
    boolean isRegister = false;
    List<OnNetworkStateChangeLisenter> mLisenters = new ArrayList();

    public interface OnNetworkStateChangeLisenter {
        void onChanged(boolean z);
    }

    public NetworkCheck(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean hasNet = isConnectionAvailable(context);
        if (hasNet != this.hasNet) {
            this.hasNet = hasNet;
            if (this.mLisenters != null && this.mLisenters.size() > 0) {
                List<OnNetworkStateChangeLisenter> lisenters = new ArrayList<>(this.mLisenters);
                for (OnNetworkStateChangeLisenter lisenter : lisenters) {
                    lisenter.onChanged(this.hasNet);
                }
            }
        }
    }

    public void register(Context context) {
        Context sContext = context.getApplicationContext();
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        sContext.registerReceiver(this, filter);
        this.isRegister = true;
    }

    public void unregister(Context context) {
        if (this.isRegister) {
            Context sContext = context.getApplicationContext();
            sContext.unregisterReceiver(this);
            this.isRegister = false;
        }
    }

    private boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        }
        android.net.Network network = connectivityManager.getActiveNetwork();
        if (network == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
               networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
               networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
               networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH);
    }

    public void registerLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.mLisenters == null) {
            this.mLisenters = new ArrayList();
        }
        this.hasNet = isConnectionAvailable(this.mContext);
        if (lisenter != null && !this.mLisenters.contains(lisenter)) {
            this.mLisenters.add(lisenter);
            lisenter.onChanged(this.hasNet);
        }
    }

    public void unRegisterLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.mLisenters != null && lisenter != null && this.mLisenters.contains(lisenter)) {
            this.mLisenters.remove(lisenter);
        }
    }
}
