package com.android.launcher66;

/**
 * What to do when the workspace load has been silent for too long, and what to do with a reload that was asked
 * for while a load was running. Pure Java, so that the rules have a test; Launcher feeds it what the model says
 * ({@code LauncherModel.loadSnapshot()}) and acts on the answer.
 *
 * <p>The rules (R1): the state "a load is running" belongs to the model; a load that stopped is started again
 * and not just let go; a reload that was skipped is not lost; every stop of a load says why in the log.
 */
final class WorkspaceLoadWatch {

    /** What the watchdog does. */
    enum Decision {
        /** The load is alive on the worker thread: look again, once. */
        WAIT_MORE,
        /** There is no live load: start it again. */
        RESTART,
        /** Started again as often as allowed: let the loading state go, as before. */
        RELEASE
    }

    /** How often a return from the settings may restart the load before the state is released. */
    static final int MAX_RESTARTS = 2;
    /** How many extra waits a load that is alive on the worker gets, per return. */
    static final int MAX_EXTRA_WAITS = 1;

    /** What the model knows of the load at one moment (taken under its lock). */
    static final class Snapshot {
        final int loadId;
        final boolean taskExists;
        final boolean stopped;
        final boolean running;
        final boolean workspaceLoaded;
        final boolean allAppsLoaded;
        final int queuedBindSteps;
        /** uptimeMillis at which this load's startBinding() ran, 0 if it has not. */
        final long bindStartedMs;

        Snapshot(int loadId, boolean taskExists, boolean stopped, boolean running, boolean workspaceLoaded,
                 boolean allAppsLoaded, int queuedBindSteps, long bindStartedMs) {
            this.loadId = loadId;
            this.taskExists = taskExists;
            this.stopped = stopped;
            this.running = running;
            this.workspaceLoaded = workspaceLoaded;
            this.allAppsLoaded = allAppsLoaded;
            this.queuedBindSteps = queuedBindSteps;
            this.bindStartedMs = bindStartedMs;
        }

        /** A load that has a task which was not stopped, and either still works or has bind steps to run. */
        boolean alive() {
            return taskExists && !stopped && (running || queuedBindSteps > 0);
        }

        @Override
        public String toString() {
            return "load " + loadId + ": task " + (taskExists ? "yes" : "no") + ", stopped " + stopped
                    + ", running " + running + ", workspace loaded " + workspaceLoaded + ", all apps loaded "
                    + allAppsLoaded + ", bind steps queued " + queuedBindSteps;
        }
    }

    private WorkspaceLoadWatch() {
    }

    /**
     * @param restarts    how many times this return has already restarted the load
     * @param extraWaits  how many extra waits this return has already given a live load
     */
    static Decision decide(Snapshot snapshot, int restarts, int extraWaits) {
        if (restarts >= MAX_RESTARTS) {
            return Decision.RELEASE;
        }
        if (snapshot.alive() && extraWaits < MAX_EXTRA_WAITS) {
            return Decision.WAIT_MORE;
        }
        return Decision.RESTART;
    }

    /**
     * A reload was asked for ({@code skippedAtMs}) while a load was binding. When that load's bind began earlier,
     * it read the settings before the change and the reload must run when it finishes; when it began later it
     * has seen them.
     *
     * @param bindStartedMs uptimeMillis of the load's startBinding(); 0 if it had not begun to bind
     */
    static boolean mustRunSkippedReload(long bindStartedMs, long skippedAtMs) {
        return skippedAtMs > 0 && bindStartedMs < skippedAtMs;
    }
}
