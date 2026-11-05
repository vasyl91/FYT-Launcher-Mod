package com.syu.vdhost;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HostFilePolicyTest {

    private static boolean ok(String path, long length) {
        return HostFilePolicy.allowed(path, path, true, length);
    }

    @Test
    void theCoverTheBluetoothAppWritesIsRead() {
        assertTrue(ok("/data/blink/Id3_CoverArt.JPEG", 40_000));
        assertTrue(ok("/data/blink/cover.png", 1));
        assertTrue(ok("/data/blink/x.webp", HostFilePolicy.MAX_BYTES));
    }

    @Test
    void onlyImagesDirectlyInTheBlinkFolder() {
        assertFalse(ok("/data/blink/settings.db", 100));
        assertFalse(ok("/data/blink/sub/cover.png", 100));
        assertFalse(ok("/data/blink/", 100));
        assertFalse(ok("/data/blink", 100));
        assertFalse(ok("/data/blinkx/cover.png", 100));
    }

    @Test
    void theRadioLogosAreReadWithOrWithoutACityFolder() {
        assertTrue(ok("/storage/emulated/0/radio_logo/BBC_9040.png", 5_000));
        assertTrue(ok("/storage/emulated/0/radio_logo/Warszawa/RMF_9040.png", 5_000));
        assertFalse(ok("/storage/emulated/0/radio_logo/a/b/RMF_9040.png", 5_000));
        assertFalse(ok("/storage/emulated/0/radio_logo/BBC_9040.jpg", 5_000));
        assertFalse(ok("/storage/emulated/0/radio_logo/BBC_9040.PNG", 5_000));
        assertFalse(ok("/storage/emulated/0/radio_logo/", 5_000));
        assertFalse(ok("/storage/emulated/0/DCIM/photo.png", 5_000));
    }

    @Test
    void theIconPackOfTheOnlineRadioIsReadAsItIs() {
        assertTrue(ok("/odm/app/cabinet.data", 1_000_000));
        assertFalse(ok("/odm/app/other.apk", 1_000_000));
        assertFalse(ok("/odm/app/cabinet.data.bak", 1_000));
    }

    @Test
    void aFileOverTwoMegabytesIsNotRead() {
        assertFalse(ok("/data/blink/cover.png", HostFilePolicy.MAX_BYTES + 1));
        assertFalse(ok("/odm/app/cabinet.data", HostFilePolicy.MAX_BYTES + 1));
    }

    @Test
    void aLinkOrADotDotIsNotTheCanonicalPath() {
        // the caller asked for the link, the canonical path is where it leads: another path, refused
        assertFalse(HostFilePolicy.allowed("/data/blink/link.png", "/data/system/users/0.xml", true, 100));
        assertFalse(HostFilePolicy.allowed("/data/blink/../system/x.png", "/data/system/x.png", true, 100));
        // a link inside the allowed folders is refused too: the requested path is not the canonical one
        assertFalse(HostFilePolicy.allowed("/data/blink/link.png", "/data/blink/real.png", true, 100));
        assertFalse(HostFilePolicy.allowed("/data/blink/a/../cover.png", "/data/blink/cover.png", true, 100));
        assertFalse(HostFilePolicy.pathAllowed("/data/blink/../x.png"));
    }

    @Test
    void onlyARegularFileWithAKnownSize() {
        assertFalse(HostFilePolicy.allowed("/data/blink/cover.png", "/data/blink/cover.png", false, 100));
        assertFalse(HostFilePolicy.allowed("/data/blink/cover.png", "/data/blink/cover.png", true, -1));
    }

    @Test
    void nothingForNullOrACanonicalPathThatCouldNotBeHad() {
        assertFalse(HostFilePolicy.allowed(null, null, true, 1));
        assertFalse(HostFilePolicy.allowed("/data/blink/cover.png", null, true, 1));
        assertFalse(HostFilePolicy.pathAllowed(null));
        assertFalse(HostFilePolicy.pathAllowed("/data/blink/cover\0.png"));
    }
}
