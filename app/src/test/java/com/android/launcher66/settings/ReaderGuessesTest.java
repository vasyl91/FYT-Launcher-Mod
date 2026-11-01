package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.CanbusCodeEstimator.GpsFix;
import com.android.launcher66.settings.CanbusCodeEstimator.Result;
import com.android.launcher66.settings.CanbusCodeEstimator.Sample;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class ReaderGuessesTest {

    /** A city drive: fuel on 91, range on 92 and the speed in 1/100 km/h on 510, with the GPS. */
    private static Result cityDrive(boolean gps) {
        Random rnd = new Random(31);
        Map<Integer, List<Sample>> m = new HashMap<>();
        List<Sample> fuel = new ArrayList<>();
        List<Sample> speed = new ArrayList<>();
        List<GpsFix> fixes = new ArrayList<>();
        double v = 0;
        for (int sec = 0; sec < 300; sec++) {
            double target = (sec / 40) % 2 == 0 ? 43 : 0;
            v = Math.max(0, v + Math.max(-8, Math.min(6, target - v)) + rnd.nextInt(3) - 1);
            speed.add(new Sample(sec * 1000L, (int) Math.round(v) * 100));
            fixes.add(new GpsFix(sec * 1000L, (float) Math.round(v)));
            fuel.add(new Sample(sec * 1000L, v < 30 ? 65535 : 40 + rnd.nextInt(80)));
        }
        m.put(91, fuel);
        m.put(510, speed);
        List<Sample> range = new ArrayList<>();
        for (int sec = 0; sec <= 300; sec++) {
            range.add(new Sample(sec * 1000L, sec < 120 ? 310 : sec < 250 ? 300 : 290));
        }
        m.put(92, range);
        return CanbusCodeEstimator.estimate(m, gps ? fixes : null);
    }

    @Test
    void theBestGuessesOfAReadingAreKept() {
        ReaderGuesses g = ReaderGuesses.of(cityDrive(true), 1000L);
        assertEquals(91, g.fuel);
        assertEquals(92, g.range);
        assertEquals(510, g.speed);
        assertEquals(100, g.speedScale);
        assertEquals(-1, g.rpm);
        assertEquals("fuel 91, range 92, speed 510 (/100)", g.codesText());
    }

    @Test
    void aSpeedIsKeptOnlyWhenItFollowedTheGps() {
        ReaderGuesses g = ReaderGuesses.of(cityDrive(false), 1000L);
        assertEquals(-1, g.speed);
        // a later reading without the GPS keeps the speed of an earlier one
        ReaderGuesses earlier = ReaderGuesses.of(cityDrive(true), 500L);
        ReaderGuesses both = g.over(earlier);
        assertEquals(510, both.speed);
        assertEquals(100, both.speedScale);
        assertEquals(1000L, both.time);
        assertEquals(91, both.fuel);
    }

    @Test
    void theTextOfTheSettingsReadsBack() {
        ReaderGuesses g = new ReaderGuesses(1761772800000L, 91, 92, 510, 100, -1);
        ReaderGuesses back = ReaderGuesses.parse(g.serialize());
        assertEquals(g.serialize(), back.serialize());
        assertEquals("fuel 91, range 92, speed 510 (/100)", back.codesText());
        assertNull(ReaderGuesses.parse(null));
        assertNull(ReaderGuesses.parse(""));
        assertNull(ReaderGuesses.parse("1;2;3"));
        assertNull(ReaderGuesses.parse("a;b;c;d;e;f"));
        assertTrue(ReaderGuesses.of(null, 0).isEmpty());
        assertEquals("reader_guesses_1507667", ReaderGuesses.key(1507667));
    }
}
