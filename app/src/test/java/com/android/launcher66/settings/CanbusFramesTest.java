package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.CanbusCodeEstimator.Sample;
import com.android.launcher66.settings.CanbusFrames.Channel;
import com.android.launcher66.settings.CanbusFrames.Event;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class CanbusFramesTest {

    /** {@code FD len cmd data checksum}, the way the CAN box of the owner's car sends it. */
    private static int[] frame(int cmd, int... data) {
        int len = data.length + 3;
        int[] out = new int[len + 1];
        out[0] = 0xFD;
        out[1] = len;
        out[2] = cmd;
        int sum = len + cmd;
        for (int i = 0; i < data.length; i++) {
            out[3 + i] = data[i];
            sum += data[i];
        }
        out[len] = sum & 0xFF;
        return out;
    }

    private static int[] concat(int[]... parts) {
        int n = 0;
        for (int[] p : parts) {
            n += p.length;
        }
        int[] out = new int[n];
        int k = 0;
        for (int[] p : parts) {
            System.arraycopy(p, 0, out, k, p.length);
            k += p.length;
        }
        return out;
    }

    @Test
    void theFramesOfTheOwnersLogsHaveTheRightChecksum() {
        assertTrue(Arrays.equals(new int[]{253, 8, 125, 3, 184, 11, 0, 0, 75}, frame(0x7D, 3, 184, 11, 0, 0)));
        assertTrue(Arrays.equals(new int[]{253, 7, 125, 4, 238, 168, 1, 31}, frame(0x7D, 4, 238, 168, 1)));
        assertTrue(Arrays.equals(new int[]{253, 12, 51, 0, 70, 1, 54, 0, 0, 0, 0, 0, 188},
                frame(0x33, 0, 70, 1, 54, 0, 0, 0, 0, 0)));
    }

    // ---- a drive: speed (510), mileage (512), fuel (91) and range (92) as frames and as ordinary codes

    private static final class Drive {
        final List<Event> frames = new ArrayList<>();
        final Map<Integer, List<Sample>> codes = new HashMap<>();
        int frameCount;

        Drive(boolean split, boolean combine) {
            Random rnd = new Random(5);
            List<Sample> speed = new ArrayList<>();
            List<Sample> mileage = new ArrayList<>();
            List<Sample> fuel = new ArrayList<>();
            List<Sample> range = new ArrayList<>();
            int kmh = 30;
            int odo = 108782;
            int rangeKm = 310;
            long base = 1_000_000L;
            for (int sec = 0; sec < 120; sec++) {
                long t = base + sec * 1000L;
                kmh = sec % 40 >= 30 ? 0 : Math.max(25, Math.min(43, kmh + rnd.nextInt(7) - 3));
                if (sec % 15 == 14) {
                    odo++;
                }
                if (sec == 60) {
                    rangeKm = 300;
                }
                int fuelValue = kmh < 20 ? 65535 : 40 + rnd.nextInt(60);
                int speedValue = kmh * 100;

                int[] f510 = frame(0x7D, 3, speedValue & 0xFF, speedValue >> 8, 0, 0);
                int[] f512 = frame(0x7D, 4, odo & 0xFF, (odo >> 8) & 0xFF, odo >> 16);
                int[] f33 = frame(0x33, fuelValue >> 8, fuelValue & 0xFF, rangeKm >> 8, rangeKm & 0xFF, 0, 0, 0, 0, 0);
                int small = rnd.nextInt(9) - 3;
                int[] f08 = frame(0x7D, 8, small & 0xFF, small < 0 ? 0xFF : 0);
                frameCount += 4;

                add(t, f510, split && sec % 3 == 0);
                if (combine && sec % 2 == 0) {
                    frames.add(new Event(t + 100, concat(f512, f33)));
                } else {
                    add(t + 100, f512, false);
                    add(t + 200, f33, split && sec % 5 == 0);
                }
                add(t + 250, f08, false);

                // the ordinary codes come right after the frames
                speed.add(new Sample(t + 120, speedValue));
                mileage.add(new Sample(t + 120, odo));
                fuel.add(new Sample(t + 220, fuelValue));
                range.add(new Sample(t + 220, rangeKm));
            }
            codes.put(510, speed);
            codes.put(512, mileage);
            codes.put(91, fuel);
            codes.put(92, range);
        }

        private void add(long t, int[] ints, boolean split) {
            if (split) {
                frames.add(new Event(t, Arrays.copyOfRange(ints, 0, 4)));
                frames.add(new Event(t + 10, Arrays.copyOfRange(ints, 4, ints.length)));
            } else {
                frames.add(new Event(t, ints));
            }
        }
    }

    @Test
    void framesSplitOverTwoUpdatesAndSeveralInOneAreAssembled() {
        Drive d = new Drive(true, true);
        Channel c = CanbusFrames.assemble(1019, d.frames);
        assertEquals(d.frameCount, c.frames.size());
        assertEquals(d.frameCount, c.checksumOk);
        assertTrue(c.isChannel());
        assertEquals(1.0, c.checksumShare(), 1e-9);
        assertEquals(0x7D, c.frames.get(0).cmd);
        assertEquals(8, c.frames.get(0).len);
        assertEquals(5, c.frames.get(0).data.length);
    }

    @Test
    void theSectionNamesTheTypesAndTheFieldsThatEqualACode() {
        Drive d = new Drive(true, true);
        Map<Integer, List<CanbusFrames.Event>> events = new HashMap<>();
        events.put(1019, d.frames);
        Map<Integer, Channel> channels = CanbusFrames.detect(events);
        assertEquals(1, channels.size());
        List<String> lines = CanbusFrames.report(channels, d.codes);
        String text = String.join("\n", lines);

        assertTrue(lines.get(0).startsWith("Raw frames on code 1019 (RZC format: FD len cmd data checksum), "
                + d.frameCount + " frames, checksum ok 100%"), lines.get(0));
        assertTrue(text.contains("Frame 0x7D/03 (len 8): 120 frames, 1.0/s"), text);
        assertTrue(text.contains("Frame 0x7D/04 (len 7): 120 frames"), text);
        assertTrue(text.contains("Frame 0x33 (len 12): 120 frames"), text);
        assertTrue(text.contains("Frame 0x7D/08 (len 6): 120 frames"), text);
        assertTrue(text.matches("(?s).*data\\[1\\.\\.2\\] LE16: \\d+-\\d+ = code 510.*"), text);
        assertTrue(text.matches("(?s).*data\\[1\\.\\.3\\] LE24: 108782-\\d+ = code 512.*"), text);
        assertTrue(text.matches("(?s).*data\\[0\\.\\.1\\] BE16: \\d+-\\d+, 65535 = code 91.*"), text);
        assertTrue(text.matches("(?s).*data\\[2\\.\\.3\\] BE16: 300-310 = code 92.*"), text);
        // small numbers with a sign
        assertTrue(text.matches("(?s).*Frame 0x7D/08 \\(len 6\\)[^\\n]*\\n  data\\[1\\.\\.2\\] LE16 signed: -\\d+\\.\\.\\d+.*"), text);
    }

    @Test
    void theSameFramesUnderAnotherNumberAreAChannelToo() {
        Drive d = new Drive(false, false);
        Map<Integer, List<CanbusFrames.Event>> events = new HashMap<>();
        events.put(77, d.frames);
        Map<Integer, Channel> channels = CanbusFrames.detect(events);
        assertEquals(1, channels.size());
        assertNotNull(channels.get(77));
        String text = String.join("\n", CanbusFrames.report(channels, d.codes));
        assertTrue(text.startsWith("Raw frames on code 77 "), text);
        assertTrue(text.contains("= code 510"), text);
    }

    @Test
    void aCodeWithOrdinaryValuesIsNotAChannel() {
        Random rnd = new Random(6);
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            int[] ints = new int[2 + rnd.nextInt(8)];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = rnd.nextInt(253);       // never 0xFD
            }
            events.add(new Event(i * 100L, ints));
        }
        Map<Integer, List<Event>> map = new HashMap<>();
        map.put(1019, events);
        assertTrue(CanbusFrames.detect(map).isEmpty());
        assertFalse(CanbusFrames.assemble(1019, events).isChannel());
    }

    @Test
    void framesWithAWrongChecksumInMoreThanAFifthAreNotAChannel() {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int[] f = frame(0x7D, 3, i & 0xFF, 0, 0, 0);
            if (i % 4 == 0 || i % 7 == 0) {       // 36 of 100
                f[f.length - 1] ^= 0x55;
            }
            events.add(new Event(i * 500L, f));
        }
        Channel c = CanbusFrames.assemble(1019, events);
        assertEquals(100, c.frames.size());
        assertTrue(c.checksumShare() < 0.8);
        assertFalse(c.isChannel());

        List<Event> mostlyGood = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int[] f = frame(0x7D, 3, i & 0xFF, 0, 0, 0);
            if (i % 10 == 0) {       // 10 of 100
                f[f.length - 1] ^= 0x55;
            }
            mostlyGood.add(new Event(i * 500L, f));
        }
        assertTrue(CanbusFrames.assemble(1019, mostlyGood).isChannel());
    }

    @Test
    void fewerThanTwentyFramesAreNotAChannel() {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            events.add(new Event(i * 500L, frame(0x7D, 3, i, 0, 0, 0)));
        }
        assertFalse(CanbusFrames.assemble(1019, events).isChannel());
    }

    @Test
    void aChannelLeavesTheEstimatesAndTheOrdinaryCodesStay() {
        Drive d = new Drive(false, false);
        // what the code reader would hand over: the ordinary codes only, the channel left out
        Map<Integer, List<Sample>> samples = new HashMap<>(d.codes);
        List<Sample> channelSamples = new ArrayList<>();
        for (Event e : d.frames) {
            channelSamples.add(new Sample(e.t, e.ints[0]));       // 253 every time
        }
        samples.put(1019, channelSamples);
        Map<Integer, List<Event>> events = new HashMap<>();
        events.put(1019, d.frames);
        for (Integer code : CanbusFrames.detect(events).keySet()) {
            samples.remove(code);
        }
        CanbusCodeEstimator.Result r = CanbusCodeEstimator.estimate(samples, null);
        for (CanbusCodeEstimator.Guess g : r.guesses) {
            assertTrue(g.code != 1019, g.toString());
        }
    }

    // ---- matching at the end of the frame, bits, rare and constant fields

    private static Map<Integer, List<Event>> on1019(List<Event> events) {
        Map<Integer, List<Event>> m = new HashMap<>();
        m.put(1019, events);
        return m;
    }

    @Test
    void inTheCityTheCodeIsTakenWhenTheFrameIsCompleteNotLater() {
        // speed frames every 200 ms, each finished by a separate update of its checksum, and code 510 updated
        // the moment the frame is complete: 300 ms after the start of a frame the next one is already there
        Random rnd = new Random(7);
        List<Event> events = new ArrayList<>();
        List<Sample> speed = new ArrayList<>();
        int kmh = 20;
        for (int i = 0; i < 300; i++) {
            long t = 10_000L + i * 200L;
            kmh = Math.max(0, Math.min(45, kmh + rnd.nextInt(5) - 2));
            int value = kmh * 100;
            int[] f = frame(0x7D, 3, value & 0xFF, value >> 8, 0, 0);
            events.add(new Event(t, Arrays.copyOfRange(f, 0, f.length - 1)));
            events.add(new Event(t + 6, new int[]{f[f.length - 1]}));
            speed.add(new Sample(t + 6, value));
        }
        Channel c = CanbusFrames.assemble(1019, events);
        assertEquals(300, c.frames.size());
        assertEquals(10_006L, c.frames.get(0).t);
        Map<Integer, List<Sample>> codes = new HashMap<>();
        codes.put(510, speed);
        String text = String.join("\n", CanbusFrames.report(CanbusFrames.detect(on1019(events)), codes));
        assertTrue(text.matches("(?s).*data\\[1\\.\\.2\\] LE16: \\d+-\\d+ = code 510.*"), text);
    }

    @Test
    void aFrameFinishedByAnUpdateOfOneNumberIsAssembled() {
        int[] f = frame(0x7D, 3, 184, 11, 0, 0);
        List<Event> events = new ArrayList<>();
        events.add(new Event(0, Arrays.copyOfRange(f, 0, 8)));
        events.add(new Event(7, new int[]{f[8]}));
        Channel c = CanbusFrames.assemble(1019, events);
        assertEquals(1, c.frames.size());
        assertTrue(c.frames.get(0).checksumOk);
        assertEquals(7, c.frames.get(0).t);
    }

    @Test
    void theBitsOfAByteEqualTheSwitches() {
        // 0x7D/01: data[1] = 0xC0 with bit 4 for the left and bit 3 for the right turn signal
        List<Event> events = new ArrayList<>();
        List<Sample> left = new ArrayList<>();
        List<Sample> right = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            long t = i * 400L;
            int l = i >= 10 && i < 20 ? i % 2 : 0;
            int r = i >= 40 && i < 50 ? i % 2 : 0;
            events.add(new Event(t, frame(0x7D, 1, 0xC0 | (l << 4) | (r << 3))));
            left.add(new Sample(t + 3, l));
            right.add(new Sample(t + 3, r));
        }
        // and a frame of another length, so that 0x7D has sub-commands
        for (int i = 0; i < 30; i++) {
            events.add(new Event(i * 400L + 200, frame(0x7D, 8, i & 7, 0)));
        }
        events.sort((a, b) -> Long.compare(a.t, b.t));
        Map<Integer, List<Sample>> codes = new HashMap<>();
        codes.put(505, left);
        codes.put(506, right);
        String text = String.join("\n", CanbusFrames.report(CanbusFrames.detect(on1019(events)), codes));
        assertTrue(text.contains("  data[1] bit 4 = code 505"), text);
        assertTrue(text.contains("  data[1] bit 3 = code 506"), text);
        // every bit of the byte that changes is explained: no line for the byte itself
        String block = text.substring(text.indexOf("Frame 0x7D/01"));
        block = block.substring(0, block.indexOf("\nFrame ") > 0 ? block.indexOf("\nFrame ") : block.length());
        assertFalse(block.contains("  data[1]: "), block);
    }

    @Test
    void aFewFramesOfTheMileageStillEqualItsCode() {
        for (int frames : new int[]{1, 8}) {
            List<Event> events = new ArrayList<>();
            List<Sample> mileage = new ArrayList<>();
            mileage.add(new Sample(0, 108858));
            // enough other frames for a channel
            for (int i = 0; i < 40; i++) {
                events.add(new Event(i * 1000L + 500, frame(0x7D, 8, i & 7, 0)));
            }
            for (int i = 0; i < frames; i++) {
                int km = 108859 + i;
                long t = 1000L + i * 4000L;
                events.add(new Event(t, frame(0x7D, 4, km & 0xFF, (km >> 8) & 0xFF, km >> 16)));
                mileage.add(new Sample(t + 5, km));
            }
            events.sort((a, b) -> Long.compare(a.t, b.t));
            Map<Integer, List<Sample>> codes = new HashMap<>();
            codes.put(512, mileage);
            String text = String.join("\n", CanbusFrames.report(CanbusFrames.detect(on1019(events)), codes));
            assertTrue(text.matches("(?s).*data\\[1\\.\\.3\\] LE24: 108859(-\\d+)? = code 512.*"), frames + " frames: " + text);
        }
    }

    @Test
    void aFewFramesOfSmallNumbersDoNotEqualACodeByChance() {
        List<Event> events = new ArrayList<>();
        List<Sample> small = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            events.add(new Event(i * 1000L, frame(0x7D, 8, i & 7, 0)));
        }
        for (int i = 0; i < 3; i++) {
            events.add(new Event(i * 1000L + 500, frame(0x36, 9 + i, 0)));
            small.add(new Sample(i * 1000L + 505, (9 + i) << 8));      // BE16 of data[0..1]: 2304..2816
        }
        events.sort((a, b) -> Long.compare(a.t, b.t));
        Map<Integer, List<Sample>> codes = new HashMap<>();
        codes.put(300, small);
        String text = String.join("\n", CanbusFrames.report(CanbusFrames.detect(on1019(events)), codes));
        // a field of at least 256 in all of the few frames does match
        assertTrue(text.contains("= code 300"), text);

        List<Sample> tiny = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tiny.add(new Sample(i * 1000L + 505, 9 + i));
        }
        codes.put(300, tiny);
        text = String.join("\n", CanbusFrames.report(CanbusFrames.detect(on1019(events)), codes));
        assertFalse(text.contains("= code 300"), text);
    }

    @Test
    void aConstantFieldEqualsTheOnlyConstantCodeOfItsValue() {
        List<Event> events = new ArrayList<>();
        List<Sample> fuel = new ArrayList<>();
        Random rnd = new Random(8);
        for (int i = 0; i < 50; i++) {
            long t = i * 1000L;
            int f = 40 + rnd.nextInt(60);
            events.add(new Event(t, frame(0x33, 0, f, 300 >> 8, 300 & 0xFF, 0, 0, 0, 0, 0)));
            fuel.add(new Sample(t + 5, f));
        }
        Map<Integer, List<Sample>> codes = new HashMap<>();
        codes.put(91, fuel);
        codes.put(92, Collections.singletonList(new Sample(0, 300)));
        codes.put(103, Collections.singletonList(new Sample(0, 62)));       // too small to tell
        String text = String.join("\n", CanbusFrames.report(CanbusFrames.detect(on1019(events)), codes));
        assertTrue(text.contains("  data[2..3] BE16: 300 = code 92 (both constant)"), text);
        assertTrue(text.contains("= code 91"), text);
        assertFalse(text.contains("code 103"), text);

        // two constant codes of that value: no telling which
        codes.put(400, Collections.singletonList(new Sample(0, 300)));
        text = String.join("\n", CanbusFrames.report(CanbusFrames.detect(on1019(events)), codes));
        assertFalse(text.contains("(both constant)"), text);
    }
}
