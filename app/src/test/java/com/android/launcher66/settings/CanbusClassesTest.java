package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CanbusClassesTest {

    @Test
    void theFirstCarOfTheTable() {
        assertEquals("com.syu.carinfo.dasauto.DasAutoWcAct", CanbusClasses.className(1));
    }

    @Test
    void aCarInTheMiddleOfTheTable() {
        assertEquals("com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengIndex",
                CanbusClasses.className(273));
    }

    @Test
    void theLastCarsOfTheTable() {
        assertEquals("com.syu.carinfo.rzc.sanlin.ODModerninIndexAct",
                CanbusClasses.className(16384453));
        assertEquals("com.syu.carinfo.rzc.sanlin.ODBMWCarInfo",
                CanbusClasses.className(16646583));
    }

    @Test
    void aCarThatIsNotInTheTableHasNoClass() {
        assertNull(CanbusClasses.className(999999999));
    }
}
