package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HomeFrontGuardTest {

    @Test
    void systemAppsAndHeadUnitAppsAreNeverPulledBackOver() {
        assertTrue(HomeFrontGuard.isProtected("com.android.systemui"));
        assertTrue(HomeFrontGuard.isProtected("com.syu.bt"));
        assertTrue(HomeFrontGuard.isProtected("com.syu.carlink"));
        assertTrue(HomeFrontGuard.isProtected("vasyl.fytrating"));
    }

    @Test
    void cameraAppsAreProtectedByName() {
        assertTrue(HomeFrontGuard.isProtected("com.syu.camera360"));
        assertTrue(HomeFrontGuard.isProtected("com.example.BackCar"));
        assertTrue(HomeFrontGuard.isProtected("com.fyt.reverse.view"));
        assertTrue(HomeFrontGuard.isCameraPackage("com.syu.panoramic"));
    }

    @Test
    void ordinaryAppsAndAnUnknownCoverAreNot() {
        assertFalse(HomeFrontGuard.isProtected("com.google.android.apps.maps"));
        assertFalse(HomeFrontGuard.isProtected("com.syu.music"));
        assertFalse(HomeFrontGuard.isProtected(""));
    }
}
