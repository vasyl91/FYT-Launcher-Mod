package com.android.launcher66;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * What a whole home screen is, and what is done when a part of it is not whole. Plain Java (no android.*), so the
 * rules run in JVM tests; HomeLayoutRecovery takes the facts from the views and carries the repairs out.
 *
 * <p><b>The rules.</b>
 * <ul>
 *   <li>The home screen is judged after a pass of the launcher window's layout, the moment something in it may
 *       have changed, and repaired in that pass, before the frame is drawn. There are no delays, retries on a timer
 *       or time limits: the next judgement comes with the next pass of the layout or the next event (the owner,
 *       2026-11-19: a real fault is repaired as soon as it occurs, in any conditions).</li>
 *   <li>A part whose precondition is not met is not judged, and that is no fault: the bars before their apps are
 *       there (the model still binding, the bars' data on its way), the creator's elements on their way. Judging
 *       them then made the launcher repair what was only not ready yet, and build the bars' lists a second time at
 *       every start (KI-43).</li>
 *   <li>Nothing is judged while the launcher is not in front, nor while all apps are shown, unless the event asks
 *       for the home screen (a home press, a wake).</li>
 *   <li>Each fault has a ladder of repairs, the lightest first. A step is taken once per episode (the time from an
 *       event until the home screen is whole); a fault still there at the next judgement takes the next step. After
 *       the last step the fault is reported once and left until the next event, so nothing loops.</li>
 * </ul>
 */
public final class HomeIntegrity {

    /** What may be wrong. */
    public enum Fault {
        /** The event asks for the home screen, and the launcher is not on it (all apps, the overview) or it is hidden. */
        NOT_ON_WORKSPACE,
        /** On the home screen, and its view is not shown. */
        WORKSPACE_HIDDEN,
        /** The window, the pages or the drag layer are not laid out at the size of the display (half of it at least). */
        ROOT_TOO_SMALL,
        /** The hotseat is meant to be seen and has no size. */
        HOTSEAT_EMPTY,
        /** The pages are bound, and nothing has started to give the bars their apps. */
        APP_DATA_NOT_STARTED,
        /** A bar that is used has lost its adapter or its layout manager. */
        BAR_DETACHED,
        /** A bar that is used, or its first item, has no size. */
        BAR_NO_SIZE,
        /** The horizontal bar's list has no item at all, though its apps were given. */
        BAR_EMPTY,
        /** The buttons of the bottom (stock layout) or of the widgets (user layout) do not match the layout. */
        CHROME_MISMATCH,
        /** An element of the creator is missing from its page and is not on its way. */
        ELEMENTS_MISSING
    }

    /** What is done about a fault; HomeLayoutRecovery carries it out. */
    public enum Repair {
        SHOW_WORKSPACE, MAKE_WORKSPACE_VISIBLE, FORCE_LAYOUT, REFRESH_HOTSEAT, START_APP_DATA, REATTACH_BARS,
        RELAYOUT_BARS, REBUILD_APP_DATA, FIX_CHROME, PLACE_ELEMENTS
    }

    /** The state of the bars' apps. */
    public enum AppData {
        /** Nothing asked for them yet. */
        NOT_STARTED,
        /** Asked for, on their way (queued, waiting for the list of apps, being built). */
        STARTED,
        /** Given to the bars at least once. */
        READY
    }

    private static final Map<Fault, Repair[]> LADDERS = new EnumMap<>(Fault.class);

    static {
        LADDERS.put(Fault.NOT_ON_WORKSPACE, new Repair[] {Repair.SHOW_WORKSPACE});
        LADDERS.put(Fault.WORKSPACE_HIDDEN, new Repair[] {Repair.MAKE_WORKSPACE_VISIBLE});
        // The layout once; a window the system gave a wrong size is laid out again when the system resizes it,
        // which is an event of its own (a change of the window's size opens a new episode)
        LADDERS.put(Fault.ROOT_TOO_SMALL, new Repair[] {Repair.FORCE_LAYOUT});
        LADDERS.put(Fault.HOTSEAT_EMPTY, new Repair[] {Repair.REFRESH_HOTSEAT});
        LADDERS.put(Fault.APP_DATA_NOT_STARTED, new Repair[] {Repair.START_APP_DATA});
        LADDERS.put(Fault.BAR_DETACHED, new Repair[] {Repair.REATTACH_BARS, Repair.REBUILD_APP_DATA});
        LADDERS.put(Fault.BAR_NO_SIZE, new Repair[] {Repair.RELAYOUT_BARS, Repair.REBUILD_APP_DATA});
        LADDERS.put(Fault.BAR_EMPTY, new Repair[] {Repair.REBUILD_APP_DATA});
        LADDERS.put(Fault.CHROME_MISMATCH, new Repair[] {Repair.FIX_CHROME});
        LADDERS.put(Fault.ELEMENTS_MISSING, new Repair[] {Repair.PLACE_ELEMENTS});
    }

    private HomeIntegrity() {
    }

    /** The repairs of a fault, the lightest first. */
    public static Repair[] ladder(Fault fault) {
        return LADDERS.get(fault).clone();
    }

    /** A width and a height in pixels; a missing view is 0 x 0. */
    public static final class Size {
        public final int width;
        public final int height;

        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }

        boolean empty() {
            return width <= 0 || height <= 0;
        }

        @Override
        public String toString() {
            return width + "x" + height;
        }
    }

    /** One bar's list. */
    public static final class Bar {
        /** The bar is in the layout and its list is shown (not the auto-hide one, not a page without it). */
        public boolean used;
        public boolean hasAdapter;
        public boolean hasLayoutManager;
        public Size size = new Size(0, 0);
        /** Items of its adapter. */
        public int items;
        /** Width (horizontal bar) or height (vertical bar) of its first child; -1 when it has none laid out. */
        public int firstChildSize = -1;
    }

    /** What the views say at one pass of the layout. */
    public static final class Snapshot {
        public boolean resumed;
        /** All apps is shown or opening. */
        public boolean allAppsShown;
        /** The launcher's state is the home screen, and not the overview. */
        public boolean onWorkspace;
        public boolean workspaceVisible;
        /** The pages are on their way from one state to another (overview, spring loaded): judged at the end. */
        public boolean switchingState;
        /** The model has bound the pages and the list of apps. */
        public boolean bindingDone;
        public AppData appData = AppData.NOT_STARTED;
        public int displayWidth;
        public int displayHeight;
        public Size decor = new Size(0, 0);
        public Size workspace = new Size(0, 0);
        /** Null where there is no drag layer to judge. */
        public Size dragLayer;
        /** The hotseat is visible, opaque and not sized 0 by its parameters: it is meant to be seen. */
        public boolean hotseatShown;
        public Size hotseat = new Size(0, 0);
        public Bar horizontalBar = new Bar();
        public Bar verticalBar = new Bar();
        /** The stock layout's buttons and the user layout's widget buttons are shown as the layout says. */
        public boolean chromeMatches = true;
        public boolean elementsMissing;
        public boolean elementsOnTheirWay;
    }

    /** What a judgement found. */
    public static final class Verdict {
        /** False: nothing is judged now (not in front, all apps without a home press); the episode ends. */
        public final boolean judged;
        public final Set<Fault> faults;
        /** Something was not judged because its precondition is not met: the episode waits for the next pass. */
        public final boolean waiting;
        /** What waits, for the log. */
        public final String waitingFor;

        Verdict(boolean judged, Set<Fault> faults, boolean waiting, String waitingFor) {
            this.judged = judged;
            this.faults = faults;
            this.waiting = waiting;
            this.waitingFor = waitingFor;
        }

        public boolean whole() {
            return judged && faults.isEmpty() && !waiting;
        }
    }

    /**
     * Judges the home screen.
     *
     * @param wantsWorkspace the event of the episode asks for the home screen (a home press, a wake)
     */
    public static Verdict judge(Snapshot s, boolean wantsWorkspace) {
        if (!s.resumed || (s.allAppsShown && !wantsWorkspace)) {
            return new Verdict(false, EnumSet.noneOf(Fault.class), false, "");
        }
        Set<Fault> faults = EnumSet.noneOf(Fault.class);
        List<String> waiting = new ArrayList<>();
        if (wantsWorkspace && (!s.onWorkspace || s.allAppsShown || !s.workspaceVisible)) {
            faults.add(Fault.NOT_ON_WORKSPACE);
        } else if (s.onWorkspace && !s.workspaceVisible) {
            faults.add(Fault.WORKSPACE_HIDDEN);
        }
        if (s.switchingState) {
            // The pages are small or on their way: their sizes and the bars are judged when the change has ended
            waiting.add("the change of the pages' state");
        } else {
            if (tooSmall(s.decor, s) || tooSmall(s.workspace, s) || (s.dragLayer != null && tooSmall(s.dragLayer, s))) {
                faults.add(Fault.ROOT_TOO_SMALL);
            }
            if (s.hotseatShown && s.hotseat.empty()) {
                faults.add(Fault.HOTSEAT_EMPTY);
            }
            judgeBars(s, faults, waiting);
        }
        if (!s.chromeMatches) {
            faults.add(Fault.CHROME_MISMATCH);
        }
        if (s.elementsMissing) {
            if (s.elementsOnTheirWay) {
                waiting.add("the creator's elements on their way");
            } else {
                faults.add(Fault.ELEMENTS_MISSING);
            }
        }
        return new Verdict(true, faults, !waiting.isEmpty(), String.join(", ", waiting));
    }

    private static void judgeBars(Snapshot s, Set<Fault> faults, List<String> waiting) {
        boolean anyBar = s.horizontalBar.used || s.verticalBar.used;
        if (!anyBar) {
            return;
        }
        if (!s.bindingDone) {
            waiting.add("the pages being bound");
            return;
        }
        if (s.appData == AppData.NOT_STARTED) {
            faults.add(Fault.APP_DATA_NOT_STARTED);
            return;
        }
        if (s.appData == AppData.STARTED) {
            waiting.add("the bars' apps on their way");
            return;
        }
        for (Bar bar : new Bar[] {s.horizontalBar, s.verticalBar}) {
            if (!bar.used) {
                continue;
            }
            if (!bar.hasAdapter || !bar.hasLayoutManager) {
                faults.add(Fault.BAR_DETACHED);
            } else if (bar.size.empty() || (bar.items > 0 && bar.firstChildSize == 0)) {
                faults.add(Fault.BAR_NO_SIZE);
            }
        }
        if (s.horizontalBar.used && s.horizontalBar.hasAdapter && s.horizontalBar.items == 0) {
            faults.add(Fault.BAR_EMPTY);
        }
    }

    /** Smaller than half the display (and than 320 x 240), or not laid out at all. */
    static boolean tooSmall(Size size, Snapshot s) {
        if (size == null || size.empty()) {
            return true;
        }
        int minWidth = Math.max(320, s.displayWidth / 2);
        int minHeight = Math.max(240, s.displayHeight / 2);
        return size.width < minWidth || size.height < minHeight;
    }

    /**
     * The time from an event until the home screen is whole: the steps of the ladders taken so far, so that each is
     * taken once.
     */
    public static final class Episode {
        private final Map<Fault, Integer> steps = new EnumMap<>(Fault.class);
        private final Set<Fault> reported = EnumSet.noneOf(Fault.class);
        private int judgements;
        private int repairsDone;

        /** What one judgement leads to. */
        public static final class Step {
            /** The repairs to carry out now, each once, in the order of the faults. */
            public final List<Repair> repairs;
            /** Faults found with the repair taken for each, for the log ("fault -> repair (step n)"). */
            public final List<String> taken;
            /** Faults whose ladder is at its end, reported now for the first time. */
            public final Set<Fault> givenUp;
            /** The episode is over: whole, nothing to judge, or nothing left to try and nothing to wait for. */
            public final boolean over;

            Step(List<Repair> repairs, List<String> taken, Set<Fault> givenUp, boolean over) {
                this.repairs = repairs;
                this.taken = taken;
                this.givenUp = givenUp;
                this.over = over;
            }
        }

        public Step next(Verdict verdict) {
            judgements++;
            if (!verdict.judged) {
                return new Step(new ArrayList<>(), new ArrayList<>(), EnumSet.noneOf(Fault.class), true);
            }
            List<Repair> repairs = new ArrayList<>();
            List<String> taken = new ArrayList<>();
            Set<Fault> givenUp = EnumSet.noneOf(Fault.class);
            for (Fault fault : verdict.faults) {
                Repair[] ladder = LADDERS.get(fault);
                int step = steps.containsKey(fault) ? steps.get(fault) : 0;
                if (step < ladder.length) {
                    steps.put(fault, step + 1);
                    Repair repair = ladder[step];
                    if (!repairs.contains(repair)) {
                        repairs.add(repair);
                    }
                    taken.add(fault + " -> " + repair + " (step " + (step + 1) + " of " + ladder.length + ")");
                } else if (reported.add(fault)) {
                    givenUp.add(fault);
                }
            }
            repairsDone += repairs.size();
            boolean over = repairs.isEmpty() && !verdict.waiting;
            return new Step(repairs, taken, givenUp, over);
        }

        public int judgements() {
            return judgements;
        }

        public int repairsDone() {
            return repairsDone;
        }
    }
}
