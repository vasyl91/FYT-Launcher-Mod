package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KeptReadingTest {

    @Test
    void manyAsksReadOnce() {
        int[] reads = {0};
        KeptReading<Integer> kept = new KeptReading<>(() -> ++reads[0]);
        for (int i = 0; i < 500; i++) {
            assertEquals(1, kept.get());
        }
        assertEquals(1, reads[0]);
    }

    @Test
    void afterAChangeTheNextAskReadsAgain() {
        int[] reads = {0};
        KeptReading<Integer> kept = new KeptReading<>(() -> ++reads[0]);
        kept.get();
        kept.forget();
        assertEquals(2, kept.get());
        assertEquals(2, kept.get());
        assertEquals(2, reads[0]);
    }

    @Test
    void aChangeDuringAReadingIsNotLost() {
        int[] reads = {0};
        KeptReading<Integer>[] holder = new KeptReading[1];
        holder[0] = new KeptReading<>(() -> {
            reads[0]++;
            if (reads[0] == 1) {
                // The setting changes while the first reading is under way
                holder[0].forget();
            }
            return reads[0];
        });
        assertEquals(1, holder[0].get());
        assertEquals(2, holder[0].get(), "the reading that raced the change was not kept");
        assertEquals(2, holder[0].get());
        assertEquals(2, reads[0]);
    }

    @Test
    void aNullValueIsKeptToo() {
        int[] reads = {0};
        KeptReading<String> kept = new KeptReading<>(() -> {
            reads[0]++;
            return null;
        });
        kept.get();
        kept.get();
        assertEquals(1, reads[0]);
    }
}
