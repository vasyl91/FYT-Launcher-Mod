package com.syu.weather;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.syu.log.LogPreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkState extends BroadcastReceiver {
    private static final int DELAY = 15000;
    private static final String URL_ = "http://www.json.org";
    static NetworkState instance;
    boolean isNetworkAvailable;
    List<OnNetworkStateChangeLisenter> lisenters;
    Context mContext;
    Handler mHandler;
    int space = DELAY;
    
    private OkHttpClient okHttpClient;
    
    Runnable checkNetwork = new Runnable() { 
        @Override
        public void run() {
            NetworkState.this.ping();
            if (NetworkState.this.isNetworkConnected()) {
                if (NetworkState.this.mHandler != null) {
                    NetworkState.this.mHandler.removeCallbacks(NetworkState.this.checkNetwork);
                    NetworkState.this.mHandler.postDelayed(NetworkState.this.checkNetwork, NetworkState.this.space);
                } else {
                    NetworkState.this.mHandler.removeCallbacks(NetworkState.this.checkNetwork);
                }
            }
        }
    };
    
    HandlerThread workThread = new HandlerThread("ping network");

    public interface OnNetworkStateChangeLisenter {
        void onChanged(boolean z);
    }

    public static NetworkState getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkState(context);
        }
        return instance;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public NetworkState(Context context) {
        this.mContext = context.getApplicationContext();
        
        // Initialize OkHttpClient
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
        
        this.workThread.start();
        this.mHandler = new Handler(this.workThread.getLooper());
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            this.mContext.registerReceiver(this, filter, Context.RECEIVER_EXPORTED);
        } else {
            this.mContext.registerReceiver(this, filter);
        }
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Override 
    public void onReceive(Context context, Intent intent) {
        if (isConnected(context)) {
            this.mHandler.removeCallbacks(this.checkNetwork);
            this.mHandler.post(this.checkNetwork);
        } else {
            this.isNetworkAvailable = false;
            this.mHandler.removeCallbacks(this.checkNetwork);
        }
    }

    private boolean isConnected(Context context) {
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

    public final boolean ping() {
        boolean baidu = ping("www.baidu.com");
        boolean vaild = baidu;
        if (!vaild) {
            boolean json = ping("www.json.org");
            vaild = json;
            if (!vaild) {
                boolean sina = ping("sina.cn");
                vaild = sina;
                if (!vaild) {
                    boolean google = ping("www.google.com");
                    vaild = google;
                }
            }
        }
        if (vaild != this.isNetworkAvailable) {
            this.isNetworkAvailable = vaild;
            if (this.lisenters != null && this.lisenters.size() > 0) {
                for (OnNetworkStateChangeLisenter lisenter : this.lisenters) {
                    lisenter.onChanged(vaild);
                }
            }
        }
        return this.isNetworkAvailable;
    }

    boolean ping(String www) {
        Process p = null;
        BufferedReader in = null;
        boolean success = false;
        InputStream input = null;
        
        try {
            p = Runtime.getRuntime().exec("ping -c 2 -W 10 " + www);
            input = p.getInputStream();
            in = new BufferedReader(new InputStreamReader(input));
            
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String content = in.readLine();
                if (content == null) {
                    break;
                }
                stringBuffer.append(content);
            }
            int status = p.waitFor();
            success = status == 0;
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public void checkNetUrl() {
        Request request = new Request.Builder()
                .url(URL_)
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4")
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            int responseCode = response.code();
            if (responseCode == 200 || responseCode == 206 || responseCode == 404) {
                if (responseCode == 200 && response.body() != null) {
                    String responseBody = response.body().string();
                    // Process response if needed
                }
                this.isNetworkAvailable = true;
            } else {
                this.isNetworkAvailable = false;
            }
        } catch (Exception e) {
            this.isNetworkAvailable = false;
        }
        LogPreview.show("isNetworkAvailable =============== " + this.isNetworkAvailable);
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void registerReceiver() {
        if (isNetworkConnected()) {
            this.mHandler.post(this.checkNetwork);
        }
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            this.mContext.registerReceiver(this, filter, Context.RECEIVER_EXPORTED);
        } else {
            this.mContext.registerReceiver(this, filter);
        }
    }

    public void unregisterReceiver() {
        this.mContext.unregisterReceiver(this);
    }

    boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
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

    public boolean isNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    public void stop() {
        this.mContext.unregisterReceiver(this);
        if (this.workThread != null && this.workThread.isAlive()) {
            this.workThread.getLooper().quit();
        }
    }

    public void registerLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.lisenters == null) {
            this.lisenters = new ArrayList<>();
        }
        if (lisenter != null && !this.lisenters.contains(lisenter)) {
            this.lisenters.add(lisenter);
            lisenter.onChanged(this.isNetworkAvailable);
        }
    }

    public void unRegisterLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.lisenters != null && lisenter != null && this.lisenters.contains(lisenter)) {
            this.lisenters.remove(lisenter);
        }
    }
}