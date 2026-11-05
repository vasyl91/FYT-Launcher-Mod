package com.fyt.car;

import com.android.launcher66.settings.FytCompat;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
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
 * On the 7870 the radio is part of com.syu.media, and its station logos are read as that app reads them:
 * from content://com.syu.radio/local_assert (the list its RadioIconCache loaded from /sdcard/radio_logo,
 * which it announces with a change notification once the list is filled), if that provider is not there
 * from the folder by the rules of that app (StockLogoNames); a station without a logo gets the picture the
 * app shows for it (radio1 .. radio3 of com.syu.media, the same one for a frequency).
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
    /** The FM favorites of com.syu.media's app (the 7870), read only. */
    private final SyuMediaRadioFavorites favorites;
    private boolean favoritesTickRunning;
    private static final long FAVORITES_TICK_MS = 5_000L;
    private final Runnable favoritesTick = new Runnable() {
        @Override
        public void run() {
            favoritesTickRunning = false;
            refreshFavorites();
        }
    };

    StockRadioSource(Context app) {
        this.app = app;
        this.favorites = new SyuMediaRadioFavorites(app);
    }

    /**
     * Reads the favorite state of the station tuned in, on the 7870: at a change of the station, about every
     * 5 s while the radio is shown, and when the launcher is back in front. Main thread.
     */
    void refreshFavorites() {
        if (!StockSources.isSyuMediaUnit() || !StockSources.isRadioShown()) {
            return;
        }
        favorites.refresh(freq, this::onFavoritesChanged);
        if (!favoritesTickRunning) {
            favoritesTickRunning = true;
            main.postDelayed(favoritesTick, FAVORITES_TICK_MS);
        }
    }

    /** The state or the cover path of the station changed in the app's list. Main thread. */
    private void onFavoritesChanged() {
        Lookup shown = lookupCache.get(freq);
        if (shown != null && !shown.realLogo && favorites.coverPathOf(freq) != null) {
            lookupCache.remove(freq);       // the list names a cover now
            requestLookup(freq);
        }
        if (StockSources.isRadioShown()) {
            scheduleBurst();
            com.android.launcher66.MediaFavoriteController.onStockFavoriteChanged(app);
        }
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
        refreshFavorites();
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
                    refreshFavorites();
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
        // The heart of FM on the 7870 shows what com.syu.media's app has; elsewhere the radio has none
        Boolean favorite = StockSources.isSyuMediaUnit() ? favorites.favoriteOf(freq) : null;
        return new StockTrack(Kind.RADIO, "stock-radio:/" + freq, title, artist, "",
                0, 0, playing, false, lookup != null ? lookup.logo : null, favorite);
    }

    // ---------------------------------------------------------------------------------------------
    // Names and logos of com.syu.radio (7862)
    // ---------------------------------------------------------------------------------------------

    private void requestLookup(int forFreq) {
        if (forFreq <= 0 || lookupCache.containsKey(forFreq) || !lookupsInFlight.add(forFreq)) {
            return;
        }
        final boolean mediaUnit = StockSources.isSyuMediaUnit();
        if (mediaUnit) {
            watchLocalAssert();
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
                found = mediaUnit ? lookupMedia(forFreq) : lookup(forFreq);
            } catch (RuntimeException e) {
                Log.w(TAG, "radio logo lookup failed for " + forFreq + ": " + e);
                FytCompat.report("radio.logo lookup", e);
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

    // ---------------------------------------------------------------------------------------------
    // Names and logos of com.syu.media (7870)
    // ---------------------------------------------------------------------------------------------

    private static final Uri LOCAL_ASSERT = Uri.parse("content://com.syu.radio/local_assert");
    private static final String RADIO_LOGO_DIR = "/storage/emulated/0/radio_logo";
    private static volatile Boolean sProviderIsMedia;
    private ContentObserver logoObserver;

    /**
     * The list of the logos is filled by com.syu.media a while after it starts and announced with a change
     * notification; it is watched while the radio is the source shown (then com.syu.media is running anyway,
     * the launcher starts nothing with it). Main thread.
     */
    private void watchLocalAssert() {
        if (logoObserver != null) {
            return;
        }
        logoObserver = new ContentObserver(main) {
            @Override
            public void onChange(boolean selfChange) {
                if (!StockSources.isRadioShown()) {
                    app.getContentResolver().unregisterContentObserver(this);
                    logoObserver = null;
                    return;
                }
                lookupCache.clear();
                requestLookup(freq);
            }
        };
        try {
            app.getContentResolver().registerContentObserver(LOCAL_ASSERT, false, logoObserver);
        } catch (RuntimeException e) {
            Log.w(TAG, "local_assert not watched: " + e);
            logoObserver = null;
        }
    }

    /**
     * The logo and name of a station as com.syu.media has them. The authority com.syu.radio is the 7870's
     * com.syu.media's own, but on the 7862 it is the nonexported provider of the radio app, so the owner is
     * checked, once. Worker thread.
     */
    private Lookup lookupMedia(int forFreq) {
        String name = null;
        byte[] logo = null;
        boolean scan = true;
        if (providerIsMedia()) {
            try {
                String[] hit = queryLocalAssert(forFreq);
                scan = false;
                if (hit != null) {
                    name = hit[0];
                    logo = readLogo(hit[1]);
                }
            } catch (RuntimeException e) {
                // another firmware: the folder is read by the rules of the app instead
                Log.w(TAG, "local_assert not readable, scanning radio_logo: " + e);
            }
        }
        if (scan) {
            File[] folders = {new File(RADIO_LOGO_DIR)};
            File[] top = folders[0].listFiles();
            java.util.List<File> all = new java.util.ArrayList<>();
            if (top != null) {
                for (File f : top) {
                    if (f.isDirectory()) {
                        File[] inner = f.listFiles();
                        if (inner != null) {
                            all.addAll(java.util.Arrays.asList(inner));
                        }
                    } else {
                        all.add(f);
                    }
                }
            }
            for (File f : all) {
                StockLogoNames.Logo l = f.isFile() ? StockLogoNames.parse(f.getName()) : null;
                if (l != null && l.freq == forFreq) {
                    name = l.name;
                    logo = readLogo(f.getPath());
                    break;
                }
            }
        }
        if (logo == null) {
            // the list of stations of the app (city_station) may name a cover for it
            logo = readLogo(favorites.coverPathOf(forFreq));
        }
        boolean real = logo != null;
        if (logo == null) {
            // what the app shows for a station without a logo; the same one for a frequency
            logo = StockCoverLoader.stationFallback(app, forFreq);
        }
        return new Lookup(name, logo, real);
    }

    private boolean providerIsMedia() {
        Boolean known = sProviderIsMedia;
        if (known != null) {
            return known;
        }
        ProviderInfo info = app.getPackageManager().resolveContentProvider("com.syu.radio", 0);
        String owner = info != null ? info.packageName : null;
        boolean media = MusicService.MEDIA_PKG.equals(owner);
        sProviderIsMedia = media;
        Log.i(TAG, "authority com.syu.radio is owned by " + owner + (media ? "" : " (not com.syu.media)"));
        return media;
    }

    /** {title, cover_path} of the station of the frequency in local_assert, null if the list has none. */
    private String[] queryLocalAssert(int forFreq) {
        try (Cursor c = app.getContentResolver().query(LOCAL_ASSERT,
                new String[]{"freq", "cover_path", "title"}, null, null, null)) {
            if (c == null) {
                throw new IllegalStateException("local_assert gave no cursor");
            }
            while (c.moveToNext()) {
                if (c.getInt(0) == forFreq) {
                    String cover = c.getString(1);
                    String title = c.getString(2);
                    return new String[]{title != null && !title.trim().isEmpty() ? title.trim() : null, cover};
                }
            }
        }
        return null;
    }

    /** A logo file as PNG bytes, read the ways SyuMediaFiles has; null if it cannot be. */
    private static byte[] readLogo(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }
        SyuMediaFiles.Data data = SyuMediaFiles.read(SyuMediaFiles.FAMILY_RADIO_LOGO, path);
        return data == null ? null : StockCoverLoader.toPng(data.bytes);
    }

    private static final class Lookup {
        final String name;
        final byte[] logo;
        /** The logo is a station's own, not the picture the app shows for a station without one. */
        final boolean realLogo;

        Lookup(String name, byte[] logo) {
            this(name, logo, logo != null);
        }

        Lookup(String name, byte[] logo, boolean realLogo) {
            this.name = name;
            this.logo = logo;
            this.realLogo = realLogo;
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
