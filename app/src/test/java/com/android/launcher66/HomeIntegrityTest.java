package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.HomeIntegrity.AppData;
import com.android.launcher66.HomeIntegrity.Episode;
import com.android.launcher66.HomeIntegrity.Fault;
import com.android.launcher66.HomeIntegrity.Repair;
import com.android.launcher66.HomeIntegrity.Size;
import com.android.launcher66.HomeIntegrity.Snapshot;
import com.android.launcher66.HomeIntegrity.Verdict;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.EnumSet;

class HomeIntegrityTest {

    /** The A55 in portrait, the home screen whole: both bars with their apps, every element in place. */
    private static Snapshot whole() {
        Snapshot s = new Snapshot();
        s.resumed = true;
        s.onWorkspace = true;
        s.workspaceVisible = true;
        s.bindingDone = true;
        s.appData = AppData.READY;
        s.displayWidth = 1080;
        s.displayHeight = 2340;
        s.decor = new Size(1080, 2340);
        s.workspace = new Size(1080, 2340);
        s.dragLayer = new Size(1080, 2340);
        s.horizontalBar.used = true;
        s.horizontalBar.hasAdapter = true;
        s.horizontalBar.hasLayoutManager = true;
        s.horizontalBar.size = new Size(473, 130);
        s.horizontalBar.items = 4;
        s.horizontalBar.firstChildSize = 118;
        s.verticalBar.used = true;
        s.verticalBar.hasAdapter = true;
        s.verticalBar.hasLayoutManager = true;
        s.verticalBar.size = new Size(128, 1986);
        s.verticalBar.items = 5;
        s.verticalBar.firstChildSize = 357;
        return s;
    }

    @Test
    void aWholeHomeScreenHasNoFault() {
        Verdict v = HomeIntegrity.judge(whole(), true);
        assertTrue(v.whole());
        assertTrue(new Episode().next(v).over);
    }

    @Test
    void atAColdStartTheBarsAreNotJudgedWhileThePagesAreBeingBound() {
        // KI-43: the bars without an adapter while the model binds were taken for a fault
        Snapshot s = whole();
        s.bindingDone = false;
        s.appData = AppData.STARTED;
        s.horizontalBar.hasAdapter = false;
        s.verticalBar.hasAdapter = false;
        Verdict v = HomeIntegrity.judge(s, false);
        assertTrue(v.faults.isEmpty());
        assertTrue(v.waiting);
        Episode.Step step = new Episode().next(v);
        assertTrue(step.repairs.isEmpty());
        assertFalse(step.over, "it waits for the next pass of the layout");
    }

    @Test
    void whileTheBarsAppsAreOnTheirWayNothingIsRebuilt() {
        Snapshot s = whole();
        s.appData = AppData.STARTED;
        s.horizontalBar.items = 0;
        Verdict v = HomeIntegrity.judge(s, false);
        assertTrue(v.faults.isEmpty());
        assertTrue(v.waiting);
    }

    @Test
    void boundPagesWithNothingAskingForTheBarsAppsStartThemOnce() {
        Snapshot s = whole();
        s.appData = AppData.NOT_STARTED;
        Episode episode = new Episode();
        Episode.Step first = episode.next(HomeIntegrity.judge(s, false));
        assertEquals(Collections.singletonList(Repair.START_APP_DATA), first.repairs);
        Episode.Step second = episode.next(HomeIntegrity.judge(s, false));
        assertTrue(second.repairs.isEmpty());
        assertEquals(EnumSet.of(Fault.APP_DATA_NOT_STARTED), second.givenUp);
        assertTrue(second.over);
    }

    @Test
    void aBarThatLostItsAdapterIsAttachedAgainThenItsAppsAreRebuilt() {
        Snapshot s = whole();
        s.verticalBar.hasAdapter = false;
        Episode episode = new Episode();
        assertEquals(Collections.singletonList(Repair.REATTACH_BARS),
                episode.next(HomeIntegrity.judge(s, false)).repairs);
        assertEquals(Collections.singletonList(Repair.REBUILD_APP_DATA),
                episode.next(HomeIntegrity.judge(s, false)).repairs);
        Episode.Step last = episode.next(HomeIntegrity.judge(s, false));
        assertTrue(last.repairs.isEmpty());
        assertTrue(last.over, "reported once and left until the next event");
        Episode.Step after = episode.next(HomeIntegrity.judge(s, false));
        assertTrue(after.givenUp.isEmpty(), "reported only once");
    }

    @Test
    void aRepairThatWorkedEndsTheEpisode() {
        Snapshot s = whole();
        s.horizontalBar.firstChildSize = 0;
        Episode episode = new Episode();
        assertEquals(Collections.singletonList(Repair.RELAYOUT_BARS),
                episode.next(HomeIntegrity.judge(s, false)).repairs);
        assertTrue(episode.next(HomeIntegrity.judge(whole(), false)).over);
    }

    @Test
    void aWindowTooSmallAfterAWakeIsLaidOutOnceThenWaitsForTheSystemsSize() {
        Snapshot s = whole();
        s.decor = new Size(1080, 600);
        Episode episode = new Episode();
        Verdict v = HomeIntegrity.judge(s, true);
        assertEquals(EnumSet.of(Fault.ROOT_TOO_SMALL), v.faults);
        assertEquals(Collections.singletonList(Repair.FORCE_LAYOUT), episode.next(v).repairs);
        Episode.Step next = episode.next(HomeIntegrity.judge(s, true));
        assertTrue(next.repairs.isEmpty());
        assertTrue(next.over);
    }

    @Test
    void allAppsIsNotJudgedAndAHomePressFromTheOverviewShowsTheHomeScreen() {
        Snapshot s = whole();
        s.allAppsShown = true;
        s.onWorkspace = false;
        assertFalse(HomeIntegrity.judge(s, false).judged, "all apps is not the home screen");
        assertFalse(HomeIntegrity.judge(s, true).judged, "a home press leaves all apps by its own way");
        s.allAppsShown = false;                   // the overview
        Verdict v = HomeIntegrity.judge(s, true);
        assertTrue(v.faults.contains(Fault.NOT_ON_WORKSPACE));
        assertEquals(Repair.SHOW_WORKSPACE, new Episode().next(v).repairs.get(0));
        assertTrue(HomeIntegrity.judge(s, false).faults.isEmpty(), "the overview by itself is no fault");
    }

    @Test
    void aHiddenHomeScreenIsShown() {
        Snapshot s = whole();
        s.workspaceVisible = false;
        assertEquals(EnumSet.of(Fault.WORKSPACE_HIDDEN), HomeIntegrity.judge(s, false).faults);
        assertEquals(EnumSet.of(Fault.NOT_ON_WORKSPACE), HomeIntegrity.judge(s, true).faults);
    }

    @Test
    void whileThePagesChangeTheirStateOnlyThatIsWaitedFor() {
        Snapshot s = whole();
        s.switchingState = true;
        s.decor = new Size(0, 0);
        Verdict v = HomeIntegrity.judge(s, false);
        assertTrue(v.faults.isEmpty());
        assertTrue(v.waiting);
    }

    @Test
    void elementsOnTheirWayAreNoFaultMissingOnesArePlaced() {
        Snapshot s = whole();
        s.elementsMissing = true;
        s.elementsOnTheirWay = true;
        assertTrue(HomeIntegrity.judge(s, false).faults.isEmpty());
        s.elementsOnTheirWay = false;
        assertEquals(Collections.singletonList(Repair.PLACE_ELEMENTS),
                new Episode().next(HomeIntegrity.judge(s, false)).repairs);
    }

    @Test
    void notInFrontNothingIsJudged() {
        Snapshot s = whole();
        s.resumed = false;
        s.decor = new Size(0, 0);
        Verdict v = HomeIntegrity.judge(s, true);
        assertFalse(v.judged);
        assertTrue(new Episode().next(v).over);
    }

    @Test
    void anEmptyHorizontalBarIsRebuiltOnceAndAVisibleHotseatWithoutSizeRefreshed() {
        Snapshot s = whole();
        s.horizontalBar.items = 0;
        s.hotseatShown = true;
        s.hotseat = new Size(0, 0);
        Episode.Step step = new Episode().next(HomeIntegrity.judge(s, false));
        assertTrue(step.repairs.contains(Repair.REBUILD_APP_DATA));
        assertTrue(step.repairs.contains(Repair.REFRESH_HOTSEAT));
    }

    @Test
    void oneRepairServesTwoFaultsOnce() {
        Snapshot s = whole();
        s.horizontalBar.items = 0;              // BAR_EMPTY: rebuild
        s.verticalBar.hasAdapter = false;       // BAR_DETACHED: attach first
        Episode episode = new Episode();
        episode.next(HomeIntegrity.judge(s, false));
        Episode.Step second = episode.next(HomeIntegrity.judge(s, false));
        assertEquals(Collections.singletonList(Repair.REBUILD_APP_DATA), second.repairs);
    }

    @Test
    void everyFaultHasALadder() {
        for (Fault fault : Fault.values()) {
            assertTrue(HomeIntegrity.ladder(fault).length > 0, fault.name());
        }
    }
}
