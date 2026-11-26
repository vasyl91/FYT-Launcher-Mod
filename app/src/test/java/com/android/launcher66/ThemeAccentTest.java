package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ThemeAccentTest {

    @Test
    void noStoredColourIsTheDefaultAndSoIsAnyColourWithTheStockLayout() {
        assertEquals(ThemeAccent.DEFAULT, ThemeAccent.resolve(false, 0, true, ThemeAccent.DEFAULT));
        assertEquals(ThemeAccent.DEFAULT, ThemeAccent.resolve(true, 0xffff0000, false, ThemeAccent.DEFAULT));
        assertEquals(0xffff0000, ThemeAccent.resolve(true, 0xffff0000, true, ThemeAccent.DEFAULT));
    }

    @Test
    void theColourIsOpaque() {
        assertEquals(0xff112233, ThemeAccent.resolve(true, 0x40112233, true, ThemeAccent.DEFAULT));
    }

    @Test
    void theDefaultIsTheBlueOfTheColourResource() {
        assertEquals(0xff4285f4, ThemeAccent.DEFAULT);
    }

    private static float[] hsl(int color) {
        float[] hsl = new float[3];
        ThemeAccent.toHsl(color, hsl);
        return hsl;
    }

    @Test
    void lighterRaisesTheLightnessByAQuarterAndKeepsTheHue() {
        int blue = ThemeAccent.DEFAULT;
        float[] before = hsl(blue);
        float[] after = hsl(ThemeAccent.lighter(blue));
        assertEquals(before[0], after[0], 1.5f);
        assertEquals(before[2] + 0.25f, after[2], 0.01f);
    }

    @Test
    void lighterIsHeldToOneAndKeepsAlpha() {
        float[] white = hsl(ThemeAccent.lighter(0x80ffffff));
        assertEquals(1f, white[2], 0.001f);
        assertEquals(0x80, ThemeAccent.lighter(0x80336699) >>> 24);
        // a light colour cannot go above white
        float[] pale = hsl(ThemeAccent.lighter(0xffcce0ff));
        assertEquals(1f, pale[2], 0.01f);
    }

    @Test
    void aGreyStaysGrey() {
        int grey = ThemeAccent.lighter(0xff606060);
        assertEquals((grey >> 16) & 0xff, (grey >> 8) & 0xff);
        assertEquals((grey >> 8) & 0xff, grey & 0xff);
    }

    @Test
    void withAlphaChangesOnlyTheAlpha() {
        assertEquals(0x804285f4, ThemeAccent.withAlpha(0xff4285f4, 0x80));
        assertEquals(0xff4285f4, ThemeAccent.withAlpha(0x004285f4, 300));
        assertEquals(0x004285f4, ThemeAccent.withAlpha(0xff4285f4, -5));
    }

    @Test
    void theHslRoundTripGivesTheColourBack() {
        int[] colours = {0xffff0000, 0xff00ff00, 0xff0000ff, 0xff4285f4, 0xff808080, 0xffc0392b};
        for (int c : colours) {
            float[] hsl = hsl(c);
            int back = ThemeAccent.fromHsl(hsl, 0xff);
            assertEquals((c >> 16) & 0xff, (back >> 16) & 0xff, 1, "red of " + Integer.toHexString(c));
            assertEquals((c >> 8) & 0xff, (back >> 8) & 0xff, 1, "green of " + Integer.toHexString(c));
            assertEquals(c & 0xff, back & 0xff, 1, "blue of " + Integer.toHexString(c));
        }
    }
}
