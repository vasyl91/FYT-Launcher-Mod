package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fyt.car.SyuMediaReadPolicy.Outcome;
import com.syu.vdhost.HostFilePolicy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class SyuMediaReadPolicyTest {

    @Test
    void aMissingFileIsNotARefusal() {
        assertEquals(Outcome.MISSING, SyuMediaReadPolicy.fromErrno(2));   // ENOENT
        assertEquals(Outcome.MISSING, SyuMediaReadPolicy.fromErrno(20));  // ENOTDIR
    }

    @Test
    void noPermissionAndOtherErrorsLeaveTheNextWayToTry() {
        assertEquals(Outcome.DENIED, SyuMediaReadPolicy.fromErrno(13));   // EACCES
        assertEquals(Outcome.DENIED, SyuMediaReadPolicy.fromErrno(1));    // EPERM
        assertEquals(Outcome.DENIED, SyuMediaReadPolicy.fromErrno(5));    // EIO
    }

    @Test
    void theWayThatWorkedGoesFirstAndNeverTwice() {
        assertEquals(Arrays.asList("direct", "root", "host"), SyuMediaReadPolicy.order(null));
        assertEquals(Arrays.asList("root", "direct", "host"), SyuMediaReadPolicy.order("root"));
        assertEquals(Arrays.asList("host", "direct", "root"), SyuMediaReadPolicy.order("host"));
        assertEquals(3, SyuMediaReadPolicy.order("direct").size());
    }

    @Test
    void theNamesOfTheLogMapToTheWays() {
        assertEquals("direct", SyuMediaReadPolicy.wayOf("system"));
        assertEquals("direct", SyuMediaReadPolicy.wayOf("direct"));
        assertEquals("root", SyuMediaReadPolicy.wayOf("root"));
        assertEquals("host", SyuMediaReadPolicy.wayOf("shizuku"));
        assertEquals("host", SyuMediaReadPolicy.wayOf("daemon"));
    }

    @Test
    void aPathIsHeldOffOnlyWhenEveryWayRefusedIt() {
        List<Outcome> all = Arrays.asList(Outcome.DENIED, Outcome.DENIED, Outcome.DENIED);
        assertTrue(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_RADIO_LOGO, all));
        assertTrue(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_ICON_PACK, all));
        assertFalse(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_RADIO_LOGO,
                Arrays.asList(Outcome.DENIED, Outcome.MISSING)));
        assertFalse(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_RADIO_LOGO,
                Collections.singletonList(Outcome.MISSING)));
        assertFalse(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_RADIO_LOGO, Collections.emptyList()));
    }

    @Test
    void theBluetoothCoverIsNeverHeldOff() {
        assertFalse(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_BT_COVER,
                Arrays.asList(Outcome.DENIED, Outcome.DENIED, Outcome.DENIED)));
    }

    @Test
    void theIconPackHasItsOwnLimit() {
        assertEquals(HostFilePolicy.ICON_PACK_MAX_BYTES, SyuMediaReadPolicy.maxBytes(SyuMediaFiles.FAMILY_ICON_PACK));
        assertEquals(64L * 1024 * 1024, SyuMediaReadPolicy.maxBytes(SyuMediaFiles.FAMILY_ICON_PACK));
        assertEquals(2L * 1024 * 1024, SyuMediaReadPolicy.maxBytes(SyuMediaFiles.FAMILY_RADIO_LOGO));
        assertEquals(2L * 1024 * 1024, SyuMediaReadPolicy.maxBytes(SyuMediaFiles.FAMILY_BT_COVER));
    }

    @Test
    void aFileOverItsLimitEndsTheRoundLikeAMissingOne() {
        assertTrue(SyuMediaReadPolicy.endsRound(Outcome.MISSING));
        assertTrue(SyuMediaReadPolicy.endsRound(Outcome.TOO_LARGE));
        assertFalse(SyuMediaReadPolicy.endsRound(Outcome.DENIED));
        assertFalse(SyuMediaReadPolicy.endsRound(Outcome.OK));
    }

    @Test
    void aFileOverItsLimitIsNotHeldOff() {
        assertFalse(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_RADIO_LOGO,
                Collections.singletonList(Outcome.TOO_LARGE)));
        assertFalse(SyuMediaReadPolicy.holdOff(SyuMediaFiles.FAMILY_ICON_PACK,
                Arrays.asList(Outcome.DENIED, Outcome.TOO_LARGE)));
    }
}
