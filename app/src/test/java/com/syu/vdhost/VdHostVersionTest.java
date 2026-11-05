package com.syu.vdhost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VdHostVersionTest {

    @Test
    void theProtocolIs3AndTheOldestHostStillTakenIs2() {
        assertEquals(3, VdHostProtocol.VERSION);
        assertEquals(2, VdHostProtocol.MIN_VERSION);
    }

    @Test
    void aHostFrom2To3IsTaken() {
        assertTrue(VdHostVersion.accepts(2, 2, 3));
        assertTrue(VdHostVersion.accepts(3, 2, 3));
    }

    @Test
    void anOlderOrNewerHostIsRefused() {
        assertFalse(VdHostVersion.accepts(1, 2, 3));
        assertFalse(VdHostVersion.accepts(4, 2, 3));
        assertFalse(VdHostVersion.accepts(0, 2, 3));
    }

    @Test
    void theOptionalCallsNeedProtocol3() {
        assertFalse(VdHostVersion.supportsOptionalCalls(2));
        assertTrue(VdHostVersion.supportsOptionalCalls(3));
        assertTrue(VdHostVersion.supportsOptionalCalls(4));
    }
}
