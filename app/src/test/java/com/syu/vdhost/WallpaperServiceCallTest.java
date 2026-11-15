package com.syu.vdhost;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import android.os.Bundle;

import org.junit.jupiter.api.Test;

class WallpaperServiceCallTest {

    private static final String SHELL = "com.android.shell";
    private static final Object BUNDLE = new Object();

    /** Stands for IWallpaperManagerCallback. */
    private interface Callback {
    }

    @Test
    void android14AndLater() {
        // getWallpaperWithFeature(callingPkg, callingFeatureId, cb, which, outParams, userId, getCropped)
        Class<?>[] types = {String.class, String.class, Callback.class, int.class, Bundle.class, int.class,
                boolean.class};
        assertArrayEquals(new Object[] {SHELL, null, null, 1, BUNDLE, 0, true},
                WallpaperServiceCall.arguments(types, SHELL, 0, BUNDLE));
    }

    @Test
    void android11To13() {
        // getWallpaperWithFeature(callingPkg, callingFeatureId, cb, which, outParams, userId)
        Class<?>[] types = {String.class, String.class, Callback.class, int.class, Bundle.class, int.class};
        assertArrayEquals(new Object[] {SHELL, null, null, 1, BUNDLE, 10},
                WallpaperServiceCall.arguments(types, SHELL, 10, BUNDLE));
    }

    @Test
    void android8To10() {
        // getWallpaper(callingPkg, cb, which, outParams, userId)
        Class<?>[] types = {String.class, Callback.class, int.class, Bundle.class, int.class};
        assertArrayEquals(new Object[] {SHELL, null, 1, BUNDLE, 0},
                WallpaperServiceCall.arguments(types, SHELL, 0, BUNDLE));
    }

    @Test
    void itIsAlwaysTheHomeScreensWallpaper() {
        Class<?>[] types = {String.class, int.class, int.class};
        Object[] args = WallpaperServiceCall.arguments(types, SHELL, 0, BUNDLE);
        assertArrayEquals(new Object[] {SHELL, WallpaperServiceCall.HOME_SCREEN, 0}, args);
    }

    @Test
    void aSignatureThatIsNotKnownIsNotCalled() {
        // a third int, a long, no package at all, no user
        assertNull(WallpaperServiceCall.arguments(new Class<?>[] {String.class, int.class, int.class, int.class},
                SHELL, 0, BUNDLE));
        assertNull(WallpaperServiceCall.arguments(new Class<?>[] {String.class, int.class, long.class, int.class},
                SHELL, 0, BUNDLE));
        assertNull(WallpaperServiceCall.arguments(new Class<?>[] {int.class, int.class}, SHELL, 0, BUNDLE));
        assertNull(WallpaperServiceCall.arguments(new Class<?>[] {String.class, int.class}, SHELL, 0, BUNDLE));
    }
}
