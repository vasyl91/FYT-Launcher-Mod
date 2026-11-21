package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FileCoverRetryTest {

    @Test
    void aFileThatCouldNotBeOpenedIsReadOnceMore() {
        assertTrue(FileCoverRetry.readAgain(false, 1));
        assertFalse(FileCoverRetry.readAgain(false, 2), "then the result stands, not a read every second");
    }

    @Test
    void aFileThatWasOpenedIsNotReadAgainWithOrWithoutAPicture() {
        assertFalse(FileCoverRetry.readAgain(true, 1));
        assertFalse(FileCoverRetry.readAgain(true, 2));
    }
}
