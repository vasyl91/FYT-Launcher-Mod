package com.android.launcher66.baselineprofile

import androidx.benchmark.macro.BaselineProfileMode
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Optional verification: cold start without compilation vs. with the Baseline Profile.
 * Runs on the fytBenchmarkRelease variant (minified, signed with the release key).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class StartupBenchmark {

    @get:Rule
    val rule = MacrobenchmarkRule()

    @Test
    fun startupNoCompilation() = startup(CompilationMode.None())

    @Test
    fun startupWithBaselineProfile() =
        startup(CompilationMode.Partial(BaselineProfileMode.Require))

    private fun startup(mode: CompilationMode) = rule.measureRepeated(
        packageName = targetPackage,
        metrics = listOf(StartupTimingMetric()),
        compilationMode = mode,
        startupMode = StartupMode.COLD,
        iterations = 10,
        setupBlock = {
            // COLD mode kills the process before setupBlock, but the launcher is the visible
            // HOME app, so the system restarts it right away and the measured start would be
            // warm. Put system Settings on top first, then kill the launcher again.
            bringSystemSettingsToFront()
            killProcess()
        },
    ) {
        startActivityAndWait(homeIntent())
        waitForLauncher()
    }
}
