package com.syu.vdhost;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    }

    @Test
    void theIconPackMayBeBiggerThanTwoMegabytesButNotThanSixtyFour() {
        assertTrue(ok("/odm/app/cabinet.data", HostFilePolicy.MAX_BYTES + 1));
        assertTrue(ok("/odm/app/cabinet.data", 30L * 1024 * 1024));
        assertTrue(ok("/odm/app/cabinet.data", HostFilePolicy.ICON_PACK_MAX_BYTES));
        assertFalse(ok("/odm/app/cabinet.data", HostFilePolicy.ICON_PACK_MAX_BYTES + 1));
        assertEquals(HostFilePolicy.MAX_BYTES, HostFilePolicy.maxBytes("/data/blink/cover.png"));
        assertEquals(HostFilePolicy.ICON_PACK_MAX_BYTES, HostFilePolicy.maxBytes("/odm/app/cabinet.data"));
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

    @Test
    void theOpenedFileIsJudgedByTheDescriptorNotByThePath() {
        String path = "/storage/emulated/0/radio_logo/BBC_9040.png";
        assertTrue(HostFilePolicy.allowedOpened(path, path, true, 5_000));
        // swapped for a link after the path was checked: the descriptor leads somewhere else
        assertFalse(HostFilePolicy.allowedOpened(path, "/data/system/users/0.xml", true, 100));
        assertFalse(HostFilePolicy.allowedOpened(path, "/storage/emulated/0/radio_logo/other.png", true, 100));
        // a directory or something that is not a regular file
        assertFalse(HostFilePolicy.allowedOpened(path, path, false, 4_096));
        // too big for the path's family
        assertFalse(HostFilePolicy.allowedOpened(path, path, true, HostFilePolicy.MAX_BYTES + 1));
        assertTrue(HostFilePolicy.allowedOpened("/odm/app/cabinet.data", "/odm/app/cabinet.data", true,
                HostFilePolicy.MAX_BYTES + 1));
        // the link could not be read
        assertFalse(HostFilePolicy.allowedOpened(path, null, true, 100));
        // a path outside the allowed ones, even if the descriptor agrees
        assertFalse(HostFilePolicy.allowedOpened("/data/system/users/0.xml", "/data/system/users/0.xml", true, 100));
    }

    @Test
    void theOtherNamesOfTheSharedStorageAreTheSameFile() {
        String path = "/storage/emulated/0/radio_logo/Warszawa/radio.png";
        assertTrue(HostFilePolicy.sameSharedStorageFile(path, "/data/media/0/radio_logo/Warszawa/radio.png"));
        assertTrue(HostFilePolicy.sameSharedStorageFile(path,
                "/mnt/user/0/emulated/0/radio_logo/Warszawa/radio.png"));
        assertTrue(HostFilePolicy.sameSharedStorageFile(path,
                "/mnt/pass_through/0/emulated/0/radio_logo/Warszawa/radio.png"));
        assertTrue(HostFilePolicy.sameSharedStorageFile(path, "/storage/self/primary/radio_logo/Warszawa/radio.png"));
        assertTrue(HostFilePolicy.allowedOpened(path, "/data/media/0/radio_logo/Warszawa/radio.png", true, 5_000));
    }

    @Test
    void anyOtherTargetOfTheDescriptorIsStillRefused() {
        String path = "/storage/emulated/0/radio_logo/radio.png";
        // the rest of the path differs
        assertFalse(HostFilePolicy.sameSharedStorageFile(path, "/data/media/0/radio_logo/other.png"));
        assertFalse(HostFilePolicy.sameSharedStorageFile(path, "/data/media/0/secret/radio.png"));
        // another user's storage, or a folder that only starts like one of the aliases
        assertFalse(HostFilePolicy.sameSharedStorageFile(path, "/data/media/10/radio_logo/radio.png"));
        assertFalse(HostFilePolicy.sameSharedStorageFile(path, "/mnt/user/0/emulated/10/radio_logo/radio.png"));
        assertFalse(HostFilePolicy.sameSharedStorageFile(path, "/data/media/0/radio_logo/radio.png.bak"));
        assertFalse(HostFilePolicy.sameSharedStorageFile(path, "/data/system/users/0.xml"));
        assertFalse(HostFilePolicy.sameSharedStorageFile(path, null));
        // paths outside the shared storage have no aliases
        assertFalse(HostFilePolicy.sameSharedStorageFile("/data/blink/c.jpg", "/data/media/0/c.jpg"));
        assertFalse(HostFilePolicy.allowedOpened(path, "/data/media/0/secret/radio.png", true, 100));
    }

    @Test
    void anAliasStillNeedsAnAllowedRequestedPathAndAnOrdinaryFile() {
        // the requested path is checked as before, whatever the descriptor leads to
        String notAllowed = "/storage/emulated/0/DCIM/photo.png";
        assertFalse(HostFilePolicy.allowedOpened(notAllowed, "/data/media/0/DCIM/photo.png", true, 100));
        String path = "/storage/emulated/0/radio_logo/radio.png";
        String alias = "/data/media/0/radio_logo/radio.png";
        assertFalse(HostFilePolicy.allowedOpened(path, alias, false, 100));
        assertFalse(HostFilePolicy.allowedOpened(path, alias, true, HostFilePolicy.MAX_BYTES + 1));
    }

    @Test
    void theHomeWallpaperIsTheOwnersShownPictureThenThePictureAsSet() {
        String[] paths = HostFilePolicy.homeWallpaperPaths(0);
        assertEquals(2, paths.length);
        assertEquals("/data/system/users/0/wallpaper", paths[0]);
        assertEquals("/data/system/users/0/wallpaper_orig", paths[1]);
    }

    @Test
    void theLockScreensWallpaperIsNeverAmongThem() {
        for (int user : new int[] {0, 10, 150}) {
            for (String path : HostFilePolicy.homeWallpaperPaths(user)) {
                assertFalse(path.contains("lock"), path);
                assertTrue(path.startsWith("/data/system/users/" + user + "/wallpaper"), path);
            }
        }
    }

    @Test
    void theUserComesFromTheCallersUid() {
        assertEquals(0, HostFilePolicy.userOfUid(10281));
        assertEquals(10, HostFilePolicy.userOfUid(1010281));
        assertEquals(0, HostFilePolicy.userOfUid(1000));
        assertEquals(0, HostFilePolicy.userOfUid(-1));
    }

    @Test
    void anOpenedWallpaperIsHandedOutOnlyAsARegularFileOfAPicturesSize() {
        String path = "/data/system/users/0/wallpaper";
        assertTrue(HostFilePolicy.homeWallpaperAllowed(path, path, true, 3_000_000));
        // a link that leads elsewhere, a directory, an empty file, one that is no picture's size
        assertFalse(HostFilePolicy.homeWallpaperAllowed(path, "/data/system/users/0/wallpaper_lock", true, 3_000_000));
        assertFalse(HostFilePolicy.homeWallpaperAllowed(path, path, false, 3_000_000));
        assertFalse(HostFilePolicy.homeWallpaperAllowed(path, path, true, 0));
        assertFalse(HostFilePolicy.homeWallpaperAllowed(path, path, true, HostFilePolicy.WALLPAPER_MAX_BYTES + 1));
    }
}
