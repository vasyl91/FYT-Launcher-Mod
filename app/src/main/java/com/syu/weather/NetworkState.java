package com.syu.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.syu.log.LogPreview;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class NetworkState extends BroadcastReceiver {
    private static Exception e;
    private static Throwable th;
    private static final int DELAY = 15000;
    private static final String URL_ = "http://www.json.org";
    static NetworkState instance;
    boolean isNetworkAvailable;
    List<OnNetworkStateChangeLisenter> lisenters;
    Context mContext;
    Handler mHandler;
    int space = DELAY;
    Runnable checkNetwork = new Runnable() { // from class: com.syu.weather.NetworkState.1
        @Override // java.lang.Runnable
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

    public NetworkState(Context context) {
        this.mContext = context.getApplicationContext();
        this.workThread.start();
        this.mHandler = new Handler(this.workThread.getLooper());
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this, filter);
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(1);
        boolean mobVaild = mobNetInfo != null && mobNetInfo.isConnected();
        boolean wifiVaild = wifiNetInfo != null && wifiNetInfo.isConnected();
        if (mobVaild || wifiVaild) {
            this.mHandler.removeCallbacks(this.checkNetwork);
            this.mHandler.post(this.checkNetwork);
        } else {
            this.isNetworkAvailable = false;
            this.mHandler.removeCallbacks(this.checkNetwork);
        }
    }

    public final boolean ping() {
        boolean baidu = ping("www.baidu.com");
        boolean vaild = 0 != 0 || baidu;
        if (!vaild) {
            boolean json = ping("www.json.org");
            vaild = vaild || json;
            if (!vaild) {
                boolean sina = ping("sina.cn");
                vaild = vaild || sina;
                if (!vaild) {
                    boolean google = ping("www.google.com");
                    vaild = vaild || google;
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
        BufferedReader in2 = null;
        try {
            p = Runtime.getRuntime().exec("ping -c 2 -W 10 " + www);
            input = p.getInputStream();
            in = new BufferedReader(new InputStreamReader(input));
        } catch (Throwable th) {
            th = th;
        }
        try {
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
            if (status == 0) {
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            e = e4;
            in2 = in;
            e.printStackTrace();
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            if (in2 != null) {
                try {
                    in2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return success;
        } catch (InterruptedException e7) {
            e = e7;
            in2 = in;
            e.printStackTrace();
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (in2 != null) {
                try {
                    in2.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            return success;
        } catch (Throwable th2) {
            th = th2;
            in2 = in;
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            if (in2 != null) {
                try {
                    in2.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            try {
                throw th;
            } catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
        if (in != null) {
            try {
                in.close();
                in2 = in;
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return success;
        }
        in2 = in;
        return success;
    }

    public void checkNetUrl() {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet get = new HttpGet(URL_);
            get.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
            HttpResponse response = httpclient.execute(get);
            Header[] reqHeaders = get.getAllHeaders();
            for (int i = 0; i < reqHeaders.length; i++) {
                reqHeaders[i].getName();
                reqHeaders[i].getValue();
            }
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == 200 || responseCode == 206 || responseCode == 404) {
                if (responseCode == 200) {
                    HttpEntity entity = response.getEntity();
                    EntityUtils.toString(entity, "utf-8");
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

    public void registerReceiver() {
        if (isNetworkConnected()) {
            this.mHandler.post(this.checkNetwork);
        }
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this, filter);
    }

    public void unregisterReceiver() {
        this.mContext.unregisterReceiver(this);
    }

    boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(1);
        return (mobNetInfo != null && mobNetInfo.isConnected()) || (wifiNetInfo != null && wifiNetInfo.isConnected());
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
            this.lisenters = new ArrayList();
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
