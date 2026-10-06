package com.android.launcher66;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.syu.util.WeatherUtils;
import com.syu.weather.WeatherDescription;
import com.syu.weather.WeatherManager;

/**
 * The weather shown on the home screen: creating WeatherManager once the boot stall is over,
 * the periodic check while the launcher is in front, and pushing the weather into the bar views.
 * Split out of Launcher; the views themselves are still bound there (initBarWeatherView()).
 */
final class LauncherWeather {

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    LauncherWeather(Launcher launcher) {
        mLauncher = launcher;
    }

    static final long WEATHER_HOME_DEFER_MS = 1500L;

    WeatherManager weatherManager;

    private final Handler weatherHandler = new Handler(Looper.getMainLooper());

    private WeatherManager.OnWeatherChangedListener mWeatherChangedListener;

    private WeatherManager mWeatherListenerOwner;

    /**
     * Shows what WeatherManager has and lets it fetch whatever is due (5 km driven or 10 min old,
     * see WeatherManager.refreshIfDue()), then sleeps until the moment the next fetch can become
     * due by time. The distance is checked in WeatherManager's location callback, so nothing polls.
     * Runs only while the launcher is in front: scheduled from onPostResume(), cancelled in onStop().
     */
    final Runnable periodicWeatherCheck = new Runnable() {
        @Override
        public void run() {
            if (!ensureWeatherManager(this)) {
                return;
            }
            // Pushed first: rebuilt bar views start with placeholder text.
            showWeatherInfo();
            long next = weatherManager.refreshIfDue("home");
            weatherHandler.removeCallbacks(this);
            weatherHandler.postDelayed(this, next);
        }
    };

    void scheduleWeatherCheckAfterHome() {
        WeatherManager.setForeground(true);
        weatherHandler.removeCallbacks(periodicWeatherCheck);
        weatherHandler.postDelayed(periodicWeatherCheck, WEATHER_HOME_DEFER_MS);
    }

    /** Shows the cached weather in the (re)bound views and fetches only if something is due. */
    public void updateWeather() {
        if (!ensureWeatherManager(mDeferredWeatherInit)) {
            return;
        }
        showWeatherInfo();
        weatherManager.refreshIfDue("show");
    }

    final Runnable mDeferredWeatherInit = this::updateWeather;

    /**
     * WeatherManager.initialize() registers a receiver, a call into system_server: during the
     * boot-time stall that froze the launcher for twelve seconds (capture 23:13), with the
     * workspace binding queued behind it. The weather is not needed for the first screen, so at
     * boot the manager is created once the stall is over, and retry runs then.
     *
     * @return true when the manager exists
     */
    boolean ensureWeatherManager(Runnable retry) {
        if (weatherManager != null) {
            return true;
        }
        long wait = Launcher.bootStallDelayMs();
        if (wait > 0L) {
            weatherHandler.removeCallbacks(retry);
            weatherHandler.postDelayed(retry, wait);
            return false;
        }
        weatherManager = WeatherManager.initialize(mLauncher);
        return true;
    }

    /** onDestroy(): nothing scheduled any more, and the manager forgets this activity's listener. */
    void release() {
        cancelWeatherCallbacks();
        if (mWeatherListenerOwner != null && mWeatherChangedListener != null) {
            mWeatherListenerOwner.removeOnWeatherChangedListener(mWeatherChangedListener);
            mWeatherChangedListener = null;
            mWeatherListenerOwner = null;
        }
    }

    void cancelWeatherCallbacks() {
        WeatherManager.setForeground(false);
        weatherHandler.removeCallbacks(periodicWeatherCheck);
        weatherHandler.removeCallbacks(mDeferredWeatherInit);
    }

    public void showWeatherInfo() {
        if (this.weatherManager != null) {
            if (mWeatherChangedListener == null) {
                mWeatherChangedListener = new WeatherManager.OnWeatherChangedListener() {
                    @Override
                    public void onWeatherChanged(WeatherDescription weather) {
                        if (weather != null) {
                            if (mLauncher.weatherImg != null) {
                                mLauncher.weatherImg.setImageResource(WeatherUtils.getResId("weather" + weather.getIconCode()));
                            }
                            String range = weather.getTemDescription().replaceAll("\\.\\d", "");
                            String temp = weather.getCurTem().replaceAll("\\.\\d", "");
                            if (mLauncher.weatherCity != null) {
                                mLauncher.weatherCity.setText(new StringBuilder(String.valueOf(weather.getCity())).toString());
                            }
                            if (mLauncher.weatherWeather != null) {
                                mLauncher.weatherWeather.setText(new StringBuilder(WeatherUtils.translateDescription(String.valueOf(weather.getWeather()))).toString());
                            }
                            if (mLauncher.weatherTemp != null) {
                                mLauncher.weatherTemp.setText(new StringBuilder(String.valueOf(temp)).toString());
                            }
                            if (mLauncher.weatherTempRange != null) {
                                mLauncher.weatherTempRange.setText(new StringBuilder(String.valueOf(range)).toString());
                            }
                            if (mLauncher.weatherImg1 != null) {
                                mLauncher.weatherImg1.setImageResource(WeatherUtils.getResId("weather" + weather.getIconCode()));
                            }
                            if (mLauncher.weatherCity1 != null) {
                                mLauncher.weatherCity1.setText(new StringBuilder(String.valueOf(weather.getCity())).toString());
                            }
                            if (mLauncher.weatherWeather1 != null) {
                                mLauncher.weatherWeather1.setText(new StringBuilder(WeatherUtils.translateDescription(String.valueOf(weather.getWeather()))).toString());
                            }
                            if (mLauncher.weatherTemp1 != null) {
                                mLauncher.weatherTemp1.setText(new StringBuilder(String.valueOf(temp)).toString());
                            }
                            if (mLauncher.weatherTempRange1 != null) {
                                mLauncher.weatherTempRange1.setText(new StringBuilder(String.valueOf(range)).toString());
                            }
                            if (mLauncher.weatherWind != null) {
                                mLauncher.weatherWind.setText(new StringBuilder(String.valueOf(weather.getWind())).toString());
                            }
                        }
                    }
                };
            }
            if (mWeatherListenerOwner != this.weatherManager) {
                if (mWeatherListenerOwner != null) {
                    mWeatherListenerOwner.removeOnWeatherChangedListener(mWeatherChangedListener);
                }
                this.weatherManager.addOnWeatherChangedListener(mWeatherChangedListener);
                mWeatherListenerOwner = this.weatherManager;
            }
            // Always push the last known weather - also right after registering, so freshly
            // bound bar views do not stay empty until the next network update arrives.
            WeatherDescription weather = this.weatherManager.getThisWeather();
            if (weather != null) {
                try {
                    mWeatherChangedListener.onWeatherChanged(weather);
                } catch (Exception e) {
                    // WeatherManager guards its own listener calls the same way.
                    Log.w(Launcher.TAG, "showWeatherInfo: pushing cached weather failed", e);
                }
            }
        }
    }
}
