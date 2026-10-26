package com.fyt.car;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.android.launcher66.R;
import com.fyt.car.StockKindArbiter.Kind;
import com.syu.car.CarStates;
import com.syu.remote.Callback;
import com.syu.remote.RemoteTools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The radio (FM / AM) as a source of the music widget: the current station, read from com.syu.ms
 * (module 1, as com.syu.radio and com.syu.media read it) and held apart from MusicService's
 * fields, see {@link Kind#overlay}.
 *
 * <pre>
 *   code 0  band            code 13 RDS text (strs)
 *   code 1  frequency       code 26 name, RDS PS (strs)
 *   code 2  region
 * </pre>
 * The name of a station, in this order: its RDS PS; on the 7862 a name the user keeps for it in
 * the files of com.syu.radio (/sdcard/radio_logo, /sdcard/fmbd); the frequency. The lists of
 * stations by city (content://com.syu.radio/city_station, radio_freqs.json) hold the stations of
 * Chinese cities, not what is tuned in here, and are not used. The names the user edited in
 * com.syu.radio are in its private database (radio.db), out of reach without root.
 *
 * Callbacks come on the main thread, so everything here is on it; the files are read on a thread
 * of their own.
 */
final class StockRadioSource {

    private static final String TAG = "StockSources";

    /** Frequency and PS arrive in separate updates; one publication follows a burst of them. */
    private static final long DEBOUNCE_MS = 300L;
    /** The widget's listener is not connected yet (a start): asked again after this. */
    private static final long RETRY_MS = 2000L;
    private static final int LOGO_MAX_PX = 512;
    private static final long LOGO_MAX_BYTES = 8L << 20;

    private final Context app;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final Runnable publishRunnable = this::publishNow;
    private ExecutorService lookups;

    // main thread
    private int freq;
    private String ps = "";
    private String rds = "";
    private final Map<Integer, Lookup> lookupCache = new HashMap<>();
    private final java.util.Set<Integer> lookupsInFlight = new java.util.HashSet<>();
    private StockTrack lastPublished;
    private boolean burstPending;

    private volatile StockTrack current;

    StockRadioSource(Context app) {
        this.app = app;
    }

    /** Registers for the radio's codes (on the main thread, like Callback delivers them). */
    void start(RemoteTools tools) {
        Callback.OnRefreshLisenter listener = this::onRadioUpdate;
        tools.addRefreshLisenter(1, listener, 0, 1, 2, 13, 26);
    }

    /** The station as the widget shows it; null while no frequency has been reported. */
    StockTrack current() {
        return current;
    }

    /** The radio just became the source shown: read what is there and publish it. */
    void onActivated() {
        lookupCache.clear(); // the files may have changed since
        lastPublished = null; // published again whatever it was: another source had the widget
        RemoteTools tools = StockSources.tools();
        if (tools != null) {
            // Registering again makes com.syu.ms report the current values; the radio may have
            // been tuned long before the launcher looked
            tools.notify(1, 1, 26, 13);
        }
        requestLookup(freq);
        scheduleBurst();
    }

    /** The sound channel moved (playing or not changes with it). */
    void onChannelChanged() {
        scheduleBurst();
    }

    /** Pause, from the button of the widget, is a channel change too; nothing else to do. */
    private void onRadioUpdate(int code, int[] ints, float[] flts, String[] strs) {
        switch (code) {
            case 1:
                if (ints != null && ints.length > 0 && ints[0] != freq) {
                    freq = ints[0];
                    // The name and text of the station left behind are not this one's
                    ps = "";
                    rds = "";
                    requestLookup(freq);
                }
                break;
            case 26:
                ps = firstString(strs);
                break;
            case 13:
                rds = firstString(strs);
                break;
            case 0:
            case 2:
            default:
                break;
        }
        if (StockSources.isRadioShown()) {
            scheduleBurst();
        }
    }

    private void scheduleBurst() {
        if (!StockSources.isRadioShown()) {
            return;
        }
        // Not restarted by every update: the RDS text changes all the time, and the track would
        // wait for it to stop
        if (!burstPending) {
            burstPending = true;
            main.postDelayed(publishRunnable, DEBOUNCE_MS);
        }
    }

    private void publishNow() {
        burstPending = false;
        if (!StockSources.isRadioShown()) {
            return; // the channel went back meanwhile
        }
        StockTrack t = buildTrack();
        current = t;
        if (t.sameShown(lastPublished)) {
            return;
        }
        if (!StockSources.publish(t)) {
            burstPending = true;
            main.postDelayed(publishRunnable, RETRY_MS);
            return;
        }
        lastPublished = t;
        Log.d(TAG, "radio " + t);
    }

    /** The widget's view of the station as it is now. */
    private StockTrack buildTrack() {
        boolean playing = CarStates.mAppID == Kind.RADIO.channel;
        Lookup lookup = lookupCache.get(freq);
        String psName = ps.trim();
        String title;
        boolean named;
        if (freq <= 0) {
            title = app.getString(R.string.car_radio);
            named = false;
        } else if (!psName.isEmpty()) {
            title = psName;
            named = true;
        } else if (lookup != null && lookup.name != null) {
            title = lookup.name;
            named = true;
        } else {
            title = StockFreq.title(freq);
            named = false;
        }
        String artist;
        if (freq > 0 && named) {
            artist = StockFreq.titleWithUnit(freq);
        } else {
            String text = rds.trim();
            artist = !text.isEmpty() ? text : (freq > 0 ? StockFreq.band(freq) : "");
        }
        return new StockTrack(Kind.RADIO, "stock-radio:/" + freq, title, artist, "",
                0, 0, playing, false, lookup != null ? lookup.logo : null, null);
    }

    // ---------------------------------------------------------------------------------------------
    // Names and logos of com.syu.radio (7862)
    // ---------------------------------------------------------------------------------------------

    private void requestLookup(int forFreq) {
        // Only where com.syu.radio is the radio: com.syu.media keeps no such files
        if (forFreq <= 0 || StockSources.isSyuMediaUnit() || lookupCache.containsKey(forFreq)
                || !lookupsInFlight.add(forFreq)) {
            return;
        }
        if (lookups == null) {
            lookups = Executors.newSingleThreadExecutor(r -> {
                Thread t = new Thread(r, "StockRadioLookup");
                t.setPriority(Thread.MIN_PRIORITY);
                t.setDaemon(true);
                return t;
            });
        }
        lookups.execute(() -> {
            Lookup found;
            try {
                found = lookup(forFreq);
            } catch (RuntimeException e) {
                Log.w(TAG, "radio logo lookup failed for " + forFreq + ": " + e);
                found = new Lookup(null, null);
            }
            Lookup result = found;
            main.post(() -> {
                lookupsInFlight.remove(forFreq);
                lookupCache.put(forFreq, result);
                if (forFreq == freq && (result.name != null || result.logo != null)) {
                    scheduleBurst();
                }
            });
        });
    }

    private static final class Lookup {
        final String name;
        final byte[] logo;

        Lookup(String name, byte[] logo) {
            this.name = name;
            this.logo = logo;
        }
    }

    /** Worker thread. */
    private static Lookup lookup(int freq) {
        File root = Environment.getExternalStorageDirectory();
        // /radio_logo/<Name>_<freq>.png, as com.syu.radio names them
        File[] files = new File(root, "radio_logo").listFiles();
        if (files != null) {
            for (File f : files) {
                String[] nameAndFreq = StockFreq.parseLogoFileName(f.getName());
                if (nameAndFreq != null && StockFreq.sameFrequency(nameAndFreq[1], freq)) {
                    return new Lookup(nameAndFreq[0], readImage(f));
                }
            }
        }
        // /fmbd/fmbd.txt: id,city,logo,name,rate | ... (the lines run on into each other)
        File fmbd = new File(root, "fmbd");
        File list = new File(fmbd, "fmbd.txt");
        if (list.isFile() && list.length() < LOGO_MAX_BYTES) {
            String text = readText(list);
            if (text != null) {
                for (String entry : text.split("\\|")) {
                    String[] f = entry.split(",");
                    if (f.length >= 5 && StockFreq.sameFrequency(f[4], freq) && !f[3].trim().isEmpty()) {
                        File logo = new File(fmbd, f[2].trim());
                        if (!logo.isFile()) {
                            logo = new File(fmbd, f[2].trim() + ".bmp");
                        }
                        return new Lookup(f[3].trim(), logo.isFile() ? readImage(logo) : null);
                    }
                }
            }
        }
        return new Lookup(null, null);
    }

    /** An image file as PNG bytes no larger than LOGO_MAX_PX; null if it cannot be read. */
    private static byte[] readImage(File file) {
        if (file.length() > LOGO_MAX_BYTES) {
            return null;
        }
        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), bounds);
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) {
            return null;
        }
        int sample = 1;
        while (bounds.outWidth / (sample * 2) >= LOGO_MAX_PX
                && bounds.outHeight / (sample * 2) >= LOGO_MAX_PX) {
            sample *= 2;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sample;
        Bitmap bitmap = BitmapFactory.decodeFile(file.getPath(), options);
        if (bitmap == null) {
            return null;
        }
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            return out.toByteArray();
        } finally {
            bitmap.recycle();
        }
    }

    private static String readText(File file) {
        try (InputStream in = new FileInputStream(file)) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int n;
            while ((n = in.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }
            return new String(out.toByteArray(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return null;
        }
    }

    private static String firstString(String[] strs) {
        return strs != null && strs.length > 0 && strs[0] != null ? strs[0] : "";
    }

    String dump() {
        StockTrack t = current;
        return "RADIO: freq=" + freq + " ps='" + ps + "' rds='" + rds + "' " + (t != null ? t : "no track")
                + " lookups=" + lookupCache.size();
    }
}
