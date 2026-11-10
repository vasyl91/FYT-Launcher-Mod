package com.syu.radio.netchannel;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.IpcUtil;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;
import com.syu.radio.db.Radio_Info;
import com.syu.util.JSONUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class NetChannel {
    public static final String CHECK_NEW = "http://apk.carsql.com/CarMarke/findNewest.action";
    public static final String CURRENT_VERSION = "online_version";
    public static final String HOST = "http://apk.carsql.com";
    public static final String RADIO_FILE = "http://apk.carsql.com/CarMarke/downRadioAction.action?vid=%d";
    public static final String REPORTED_URL = "http://apk.carsql.com/CarMarke/addRadioRemarks.action?freq_num=%s&city=%s&remarks=%s";
    static NetChannel instance;
    public Runnable mRunnable_CheckNet = new Runnable() { // from class: com.syu.radio.netchannel.NetChannel.1
        @Override // java.lang.Runnable
        public void run() {
            JSONObject root;
            if (App_Radio.getInstance().mySharePreference2.getIntValue(NetChannel.CURRENT_VERSION, -1) != -1 && MyApplication.myApp.isNetworkAvailable()) {
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpGet get = new HttpGet(NetChannel.CHECK_NEW);
                    get.getParams().setIntParameter("http.connection.timeout", 3000);
                    get.getParams().setIntParameter("http.socket.timeout", 3000);
                    HttpResponse response = httpclient.execute(get);
                    int code = response.getStatusLine().getStatusCode();
                    if (code == 200) {
                        HttpEntity entity = response.getEntity();
                        String str = EntityUtils.toString(entity, "utf-8");
                        if (!TextUtils.isEmpty(str) && (root = new JSONObject(str)) != null) {
                            int status = JSONUtils.getInt(root, "status");
                            NetChannel.this.version = JSONUtils.getInt(root, "vid");
                            if (App_Radio.getInstance().mySharePreference2.getIntValue(NetChannel.CURRENT_VERSION, 0) < NetChannel.this.version && status != -1) {
                                NetChannel.this.download();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    int version;

    public static NetChannel getInstance(Context context) {
        if (instance == null) {
            instance = new NetChannel(context);
        }
        return instance;
    }

    NetChannel(Context context) {
        MyApplication.startThread(MyApplication.mStrZipTag, "NetChannel", new Runnable() { // from class: com.syu.radio.netchannel.NetChannel.2
            @Override // java.lang.Runnable
            public void run() {
                Log.d("logg", " 031 InsertNetChannel ");
                NetChannel.this.load1stDb();
            }
        }, false, 1);
    }

    public class InsertNetChannel implements Runnable {
        JSONArray array;
        boolean b1stLoad;

        public InsertNetChannel(JSONArray array, boolean b1stLoad) {
            this.array = array;
            this.b1stLoad = b1stLoad;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            boolean updated = false;
            App_Radio.getInstance().mRadioInfoManager.beginTransaction();
            App_Radio.getInstance().mRadioInfoManager.deleteFromNet();
            try {
                int count = this.array == null ? 0 : this.array.length();
                for (int i = 0; i < count; i++) {
                    JSONObject json = this.array.getJSONObject(i);
                    if (json != null) {
                        String city = JSONUtils.getStr(json, "cityName");
                        String title = JSONUtils.getStr(json, "freqName");
                        int freq = JSONUtils.getInt(json, "freqNum");
                        if (App_Radio.bRuRadioName) {
                            String logo = JSONUtils.getStr(json, "freqLogo");
                            App_Radio.getInstance().mRadioInfoManager.mDB.execSQL("insert into RadioInfo(freq, area, name, amfm, net, city, logo) values(?, ?, ?, ?, ?, ?, ?)", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(IpcUtil.int2freqStr(freq))), Integer.valueOf(FuncUtils.myParseInt(Integer.toString(3))), title, "MHz", Integer.toString(1), city, logo});
                            App_Radio.getInstance().mRadioInfoManager.mDB.execSQL("insert into RadioInfo(freq, area, name, amfm, net, city, logo) values(?, ?, ?, ?, ?, ?, ?)", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(IpcUtil.int2freqStr(freq))), Integer.valueOf(FuncUtils.myParseInt(Integer.toString(2))), title, "MHz", Integer.toString(1), city, logo});
                            Log.d(Radio_Info.CITY, "  InsertNetChannel city = " + city + " logo = " + logo);
                        } else {
                            App_Radio.getInstance().mRadioInfoManager.mDB.execSQL("insert into RadioInfo(freq, area, name, amfm, net, city) values(?, ?, ?, ?, ?, ?)", new Object[]{Integer.valueOf(IpcUtil.freqStr2Int(IpcUtil.int2freqStr(freq))), Integer.valueOf(FuncUtils.myParseInt(Integer.toString(2))), title, "MHZ", Integer.toString(1), city});
                        }
                        updated = true;
                    }
                }
                App_Radio.getInstance().mRadioInfoManager.setTransactionSuccessful();
            } catch (Exception e) {
            } finally {
                App_Radio.getInstance().mRadioInfoManager.endTransaction();
            }
            if (updated) {
                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.netchannel.NetChannel.InsertNetChannel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                            interfaceRadio.initlist(false, false, true);
                        }
                    }
                });
                App_Radio.getInstance().mySharePreference2.saveIntValue(NetChannel.CURRENT_VERSION, NetChannel.this.version);
            }
            if (this.b1stLoad) {
                MyApplication.startThread(MyApplication.mStrZipTag, App_Radio.StrThreadCheckNet, NetChannel.this.mRunnable_CheckNet, true, 1);
            }
        }
    }

    public List<Object> download() {
        JSONObject root;
        List<Object> stations = new ArrayList<>();
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet get = new HttpGet(String.format(Locale.US, RADIO_FILE, Integer.valueOf(this.version)));
            get.getParams().setIntParameter("http.connection.timeout", 3000);
            get.getParams().setIntParameter("http.socket.timeout", 3000);
            HttpResponse response = httpclient.execute(get);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity, "utf-8");
                if (!TextUtils.isEmpty(str) && (root = new JSONObject(str)) != null && root.has("radio")) {
                    if (root.has(ClientCookie.VERSION_ATTR)) {
                        this.version = JSONUtils.getInt(root, ClientCookie.VERSION_ATTR);
                    }
                    JSONArray array = root.getJSONArray("radio");
                    if (!App_Radio.bRuRadioName) {
                        MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new InsertNetChannel(array, false), false, 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }

    public InputStream open(String name) {
        try {
            int id = MyApplication.myApp.getResources().getIdentifier(name, "raw", MyApplication.myApp.getPackageName());
            if (id != 0) {
                return MyApplication.myApp.getResources().openRawResource(id);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String readStrFromStream(InputStream is) throws IOException {
        if (is == null) {
            return null;
        }
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        StringBuffer buffer = new StringBuffer();
        while (true) {
            String str = reader.readLine();
            if (str == null) {
                break;
            }
            buffer.append(str);
        }
        if (reader != null) {
            reader.close();
        }
        if (is != null) {
            is.close();
        }
        return buffer.toString();
    }

    public void load1stDb() {
        JSONObject root;
        try {
            InputStream inputStream = open("radio_freqs");
            if (inputStream != null) {
                String datas = readStrFromStream(inputStream);
                inputStream.close();
                if (!TextUtils.isEmpty(datas) && (root = new JSONObject(datas)) != null && root.has("radio") && root.has(ClientCookie.VERSION_ATTR)) {
                    this.version = JSONUtils.getInt(root, ClientCookie.VERSION_ATTR);
                    int saveVersion = App_Radio.getInstance().mySharePreference2.getIntValue(CURRENT_VERSION, -1);
                    if (saveVersion != this.version) {
                        JSONArray array = root.getJSONArray("radio");
                        MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new InsertNetChannel(array, true), false, 1);
                    }
                }
            } else {
                Log.d("logg", " 033 InsertNetChannel inputStream = null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
