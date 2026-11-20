package com.android.launcher66;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.launcher66.settings.Keys;
import com.syu.util.WindowUtil;

/**
 * Keeps the home screen whole: the workspace, the hotseat, the bars and the creator's elements. Split out of
 * Launcher, whose views and state it works on; the rules are HomeIntegrity's.
 *
 * <p><b>When it looks.</b> An event opens an episode ({@link #check}): a home press, a resume, a new intent, the
 * focus, a change of the configuration, a phase of a wake, the end of the binding, the bars' apps given, and a
 * change of the size of the launcher's window (its own listener, so a window the system sized wrongly after a wake
 * is seen without anyone asking). While an episode is open, the home screen is judged after every pass of the
 * window's layout, which is where a fault shows and where whatever it waits for arrives (an adapter set, the
 * bars' apps, the elements placed, the window resized), and the repairs run in that pass, before the frame is
 * drawn. They ask for one more pass, which judges what they did. There is no delay, retry timer or time limit
 * (the owner, 2026-11-19): the episode ends when the home screen is whole, when nothing is to be judged (not in
 * front, all apps), or when every repair of what is left was tried, which is said once in the log; the next event
 * opens a new one. Outside an episode nothing listens to the layout.
 *
 * <p>A part that is not ready yet is not judged (HomeIntegrity): at a start the bars were taken for broken while the
 * model was binding, and their lists were built a second time (KI-43).
 */
final class HomeLayoutRecovery {

    private static final String TAG = "HomeCheck";

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    /** The episode in progress, null when none. */
    private HomeIntegrity.Episode mEpisode;
    private String mReason = "";
    private boolean mWantsWorkspace;
    private boolean mWorkspaceRefreshed;
    private long mOpenedAt;
    private boolean mSomethingDone;
    private String mWaitingFor;
    private boolean mRepairing;
    private View mListenedDecor;
    private View mSizeWatchedDecor;

    private final ViewTreeObserver.OnGlobalLayoutListener mLayoutPass = this::onLayoutPass;

    /** A change of the window's size opens an episode: after a wake the system may size the window late or wrongly. */
    private final View.OnLayoutChangeListener mWindowSize = (v, left, top, right, bottom,
            oldLeft, oldTop, oldRight, oldBottom) -> {
        int width = right - left;
        int height = bottom - top;
        int oldWidth = oldRight - oldLeft;
        int oldHeight = oldBottom - oldTop;
        if ((width != oldWidth || height != oldHeight) && oldWidth > 0 && oldHeight > 0) {
            check("window " + oldWidth + "x" + oldHeight + " -> " + width + "x" + height, false);
        }
    };

    HomeLayoutRecovery(Launcher launcher) {
        mLauncher = launcher;
    }

    /**
     * An event after which the home screen may not be whole: opens an episode. During one in progress the event joins
     * it and the steps taken stay taken: the events a repair itself brings about (the bars' apps given after a rebuild)
     * must not start its ladder again, or a fault that no repair cures would be repaired for ever. The first judgement
     * comes with the next pass of the layout, which is asked for.
     *
     * @param wantsWorkspace the event asks for the home screen (a home press, a wake): the launcher goes back to it
     *                       (out of the overview, the workspace shown) once, at the first judgement
     */
    void check(String reason, boolean wantsWorkspace) {
        if (mLauncher.mWorkspace == null) {
            Log.w(TAG, "no workspace (" + reason + "): reloading it");
            mLauncher.requestWorkspaceReloadFromRecovery("home check:" + reason);
            return;
        }
        View decor = mLauncher.getWindow() != null ? mLauncher.getWindow().getDecorView() : null;
        if (decor == null) {
            return;
        }
        watchWindowSize(decor);
        if (mEpisode == null) {
            mOpenedAt = SystemClock.uptimeMillis();
            mSomethingDone = false;
            mWaitingFor = null;
            mWorkspaceRefreshed = false;
            mWantsWorkspace = wantsWorkspace;
            mReason = reason;
        } else {
            mWantsWorkspace |= wantsWorkspace;
            if (!mReason.contains(reason) && mReason.length() < 160) {
                mReason = mReason + ", " + reason;
            }
        }
        if (mEpisode == null) {
            mEpisode = new HomeIntegrity.Episode();
        }
        listen(decor);
        decor.requestLayout();
    }

    /** A phase of a wake: the home screen and the widget bar are checked again. */
    void onWake(String phase) {
        String wakePhase = phase == null ? "unknown" : phase;
        check("wake:" + wakePhase, true);
        mLauncher.mDeviceWake.scheduleWidgetBarWakeRefresh("wake:" + wakePhase);
    }

    /**
     * Something changed that takes no pass of the layout by itself (the end of a change of the pages' state): an
     * episode in progress is judged again.
     */
    void onHomeChanged() {
        if (mEpisode != null && mListenedDecor != null) {
            mListenedDecor.requestLayout();
        }
    }

    /** All apps is opened (it is not the home screen), or the launcher is going away: the episode ends. */
    void stop(String why) {
        if (mEpisode != null && mSomethingDone) {
            Log.i(TAG, "ended (" + why + ") during " + mReason);
        }
        end();
    }

    private void end() {
        mEpisode = null;
        unlisten();
    }

    private void unlisten() {
        if (mListenedDecor != null) {
            ViewTreeObserver observer = mListenedDecor.getViewTreeObserver();
            if (observer.isAlive()) {
                observer.removeOnGlobalLayoutListener(mLayoutPass);
            }
            mListenedDecor = null;
        }
    }

    private void listen(View decor) {
        if (mListenedDecor == decor && decor.getViewTreeObserver().isAlive()) {
            return;
        }
        unlisten();
        ViewTreeObserver observer = decor.getViewTreeObserver();
        if (observer.isAlive()) {
            observer.addOnGlobalLayoutListener(mLayoutPass);
            mListenedDecor = decor;
        }
    }

    private void watchWindowSize(View decor) {
        if (mSizeWatchedDecor == decor) {
            return;
        }
        if (mSizeWatchedDecor != null) {
            mSizeWatchedDecor.removeOnLayoutChangeListener(mWindowSize);
        }
        decor.addOnLayoutChangeListener(mWindowSize);
        mSizeWatchedDecor = decor;
    }

    /** After a pass of the window's layout while an episode is open: the judgement and the repairs. */
    private void onLayoutPass() {
        HomeIntegrity.Episode episode = mEpisode;
        if (episode == null || mRepairing || mLauncher.mWorkspace == null) {
            return;
        }
        HomeIntegrity.Snapshot snapshot = snapshot();
        HomeIntegrity.Verdict verdict = HomeIntegrity.judge(snapshot, mWantsWorkspace);
        HomeIntegrity.Episode.Step step = episode.next(verdict);
        boolean refresh = verdict.judged && mWantsWorkspace && !mWorkspaceRefreshed && !snapshot.switchingState;
        if (verdict.waiting && !verdict.waitingFor.equals(mWaitingFor)) {
            mWaitingFor = verdict.waitingFor;
            Log.d(TAG, "waits for " + verdict.waitingFor + " (" + mReason + ")");
        }
        if (!step.taken.isEmpty()) {
            Log.w(TAG, String.join("; ", step.taken) + " (" + mReason + "; " + facts(snapshot) + ")");
        }
        for (HomeIntegrity.Fault fault : step.givenUp) {
            Log.w(TAG, fault + " remains after every repair (" + mReason + "); left until the next change");
        }
        if (refresh || !step.repairs.isEmpty()) {
            mRepairing = true;
            try {
                if (refresh) {
                    // A home press or a wake: back to the home screen once, as the launcher always did for them
                    mWorkspaceRefreshed = true;
                    refreshWorkspaceAfterHome();
                }
                for (HomeIntegrity.Repair repair : step.repairs) {
                    if (repair == HomeIntegrity.Repair.SHOW_WORKSPACE && refresh) {
                        continue;   // done just above
                    }
                    run(repair);
                }
                WindowUtil.updatePipPositionsForScroll(mLauncher.mWorkspace.mUnboundedScrollX);
            } finally {
                mRepairing = false;
            }
            mSomethingDone |= !step.repairs.isEmpty();
            if (mListenedDecor != null) {
                mListenedDecor.requestLayout();   // the next pass judges what the repairs did
            }
            return;
        }
        if (step.over) {
            if (mSomethingDone || mWaitingFor != null) {
                Log.i(TAG, (verdict.whole() ? "whole" : verdict.judged ? "left as it is" : "not judged")
                        + " after " + episode.judgements() + " passes, "
                        + (SystemClock.uptimeMillis() - mOpenedAt) + " ms (" + mReason + ")");
            }
            end();
        }
    }

    private void run(HomeIntegrity.Repair repair) {
        switch (repair) {
            case SHOW_WORKSPACE:
                refreshWorkspaceAfterHome();
                break;
            case MAKE_WORKSPACE_VISIBLE:
                mLauncher.mWorkspace.setVisibility(View.VISIBLE);
                forceWorkspaceLayoutPass();
                break;
            case FORCE_LAYOUT:
                forceWorkspaceLayoutPass();
                break;
            case REFRESH_HOTSEAT:
                if (mLauncher.mHotseat != null) {
                    mLauncher.mHotseat.refreshLayoutAfterWake();
                }
                break;
            case START_APP_DATA:
                mLauncher.mAppBars.triggerAppData();
                break;
            case REATTACH_BARS:
                restoreBottomRecyclerAfterHome("home check");
                break;
            case RELAYOUT_BARS:
                relayoutBars();
                break;
            case REBUILD_APP_DATA:
                mLauncher.mAppBars.markAppDataDirty();
                if (mLauncher.mAppBars.atomicInitAppData.get()) {
                    mLauncher.mAppBars.requestPostResumeAppDataRefresh();
                } else {
                    mLauncher.mAppBars.triggerAppData();
                }
                break;
            case FIX_CHROME:
                fixChrome();
                break;
            case PLACE_ELEMENTS:
                mLauncher.placeCustomElements("home check");
                break;
        }
    }

    // ------------------------------------------------------------------------------------- the facts

    private HomeIntegrity.Snapshot snapshot() {
        Workspace workspace = mLauncher.mWorkspace;
        HomeIntegrity.Snapshot s = new HomeIntegrity.Snapshot();
        s.resumed = !mLauncher.mPaused;
        s.allAppsShown = mLauncher.isAppsCustomizeVisibleOrOpening();
        s.onWorkspace = mLauncher.mState == Launcher.State.WORKSPACE && !workspace.isInOverviewMode();
        s.workspaceVisible = workspace.getVisibility() == View.VISIBLE;
        s.switchingState = workspace.isSwitchingState();
        s.bindingDone = !mLauncher.mWorkspaceLoading && AllAppsList.data != null && !AllAppsList.data.isEmpty();
        s.appData = mLauncher.mAppBars.appDataState();
        DisplayMetrics metrics = mLauncher.getResources().getDisplayMetrics();
        s.displayWidth = Math.max(Launcher.screenWidth, metrics.widthPixels);
        s.displayHeight = Math.max(Launcher.screenHeight, metrics.heightPixels);
        View decor = mLauncher.getWindow() != null ? mLauncher.getWindow().getDecorView() : null;
        s.decor = size(decor);
        s.workspace = size(workspace);
        s.dragLayer = mLauncher.mDragLayer != null ? size(mLauncher.mDragLayer) : null;
        s.hotseatShown = shouldValidateHotseatForHealth();
        s.hotseat = size(mLauncher.mHotseat);
        boolean autoHide = mLauncher.mPrefs.getBoolean(Keys.AUTO_HIDE_HORIZONTAL_BAR, false);
        RecyclerView bottom = (RecyclerView) workspace.findViewById(R.id.recycler_view);
        bar(s.horizontalBar, bottom, bottom != null && !autoHide, false);
        RecyclerView left = (RecyclerView) workspace.findViewById(R.id.vertical_recycler_view);
        bar(s.verticalBar, left, left != null && mLauncher.mAppBars.shouldUseLeftRecycler(), true);
        s.chromeMatches = chromeMatches();
        s.elementsMissing = !areCustomElementsInPlace();
        s.elementsOnTheirWay = s.elementsMissing && isCustomElementsSetupInFlight();
        return s;
    }

    private static HomeIntegrity.Size size(View view) {
        return view == null ? new HomeIntegrity.Size(0, 0) : new HomeIntegrity.Size(view.getWidth(), view.getHeight());
    }

    private static void bar(HomeIntegrity.Bar bar, RecyclerView recycler, boolean used, boolean vertical) {
        bar.used = used;
        if (!used) {
            return;
        }
        bar.hasAdapter = recycler.getAdapter() != null;
        bar.hasLayoutManager = recycler.getLayoutManager() != null;
        bar.size = size(recycler);
        bar.items = recycler.getAdapter() != null ? recycler.getAdapter().getItemCount() : 0;
        if (recycler.getChildCount() > 0) {
            View child = recycler.getChildAt(0);
            bar.firstChildSize = vertical ? child.getHeight() : child.getWidth();
        }
    }

    /** The buttons of the stock layout and of the user layout's widgets are shown as the layout says. */
    private boolean chromeMatches() {
        if (mLauncher.bottomButtons == null || mLauncher.bottomButtonsWidgets == null) {
            return true;
        }
        boolean userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        return mLauncher.bottomButtons.getVisibility() == (userLayout ? View.GONE : View.VISIBLE)
                && mLauncher.bottomButtonsWidgets.getVisibility() == (userLayout ? View.VISIBLE : View.GONE);
    }

    private void fixChrome() {
        boolean userLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        if (mLauncher.bottomButtons != null && mLauncher.bottomButtonsWidgets != null) {
            mLauncher.bottomButtons.setVisibility(userLayout ? View.GONE : View.VISIBLE);
            mLauncher.bottomButtonsWidgets.setVisibility(userLayout ? View.VISIBLE : View.GONE);
        }
    }

    /** The bars' lists laid out again, with their spacing. */
    private void relayoutBars() {
        for (int id : new int[] {R.id.recycler_view, R.id.vertical_recycler_view}) {
            RecyclerView recycler = (RecyclerView) mLauncher.mWorkspace.findViewById(id);
            if (recycler != null) {
                recycler.requestLayout();
                mLauncher.mAppBars.refreshRecyclerDecorationsAfterLayout(recycler);
            }
        }
    }

    /** The sizes in a fault's line of the log. */
    private static String facts(HomeIntegrity.Snapshot s) {
        return "decor " + s.decor + ", workspace " + s.workspace + ", bars " + s.horizontalBar.size + "/"
                + s.verticalBar.size + ", apps " + s.appData;
    }

    // ------------------------------------------------------------------------------------- the repairs

    boolean refreshWorkspaceAfterHome() {
        if (mLauncher.mWorkspace == null) {
            return false;
        }

        if (mLauncher.mState != Launcher.State.WORKSPACE) {
            mLauncher.showWorkspace(false, null);
        } else if (mLauncher.mWorkspace.isInOverviewMode()) {
            mLauncher.mWorkspace.exitOverviewMode(false);
            mLauncher.helpers.setInOverviewMode(false);
        }

        mLauncher.mWorkspace.setVisibility(View.VISIBLE);
        mLauncher.mWorkspace.requestLayout();
        mLauncher.mWorkspace.invalidate();

        if (mLauncher.mAppsCustomizeTabHost != null) {
            mLauncher.mAppsCustomizeTabHost.setVisibility(View.GONE);
        }
        mLauncher.showHotseat(false, true);
        mLauncher.updateWallpaperVisibility(true);
        forceWorkspaceLayoutPass();
        return true;
    }

    /**
     * A page has custom elements assigned that are not on it yet, and what they wait for is the
     * size of the page or the post that places them: not a fault, they are waited for (HomeIntegrity).
     */
    boolean isCustomElementsSetupInFlight() {
        if (mLauncher.mWorkspace == null) {
            return false;
        }
        for (int i = 0; i < mLauncher.mWorkspace.getChildCount(); i++) {
            View child = mLauncher.mWorkspace.getChildAt(i);
            if (child instanceof CellLayout && ((CellLayout) child).isCustomElementPlacementPending()) {
                return true;
            }
        }
        return false;
    }

    /** Every configured custom element is attached, or on its way, on its page. */
    boolean areCustomElementsInPlace() {
        if (mLauncher.mWorkspace == null) {
            return false;
        }
        for (int i = 0; i < mLauncher.mWorkspace.getChildCount(); i++) {
            View child = mLauncher.mWorkspace.getChildAt(i);
            if (child instanceof CellLayout && !((CellLayout) child).hasHealthyCustomElements()) {
                return false;
            }
        }
        return true;
    }

    boolean shouldValidateHotseatForHealth() {
        if (mLauncher.mHotseat == null || mLauncher.mHotseat.getVisibility() != View.VISIBLE || mLauncher.mHotseat.getAlpha() == 0.0f) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = mLauncher.mHotseat.getLayoutParams();
        if (layoutParams != null && (layoutParams.width == 0 || layoutParams.height == 0)) {
            return false;
        }
        return true;
    }

    void restoreBottomRecyclerAfterHome(String source) {
        if (mLauncher.mWorkspace == null) return;

        RecyclerView recycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
        if (recycler != null) {
            mLauncher.mAppBars.mRecyclerView = recycler;
            mLauncher.mAppBars.ensureResizableHorizontalBar("restore:" + source);
            boolean autoHideHorizontalBar = mLauncher.mPrefs.getBoolean(Keys.AUTO_HIDE_HORIZONTAL_BAR, false);
            if (mLauncher.mAppBars.mAppListAdapter != null && recycler.getAdapter() != mLauncher.mAppBars.mAppListAdapter) {
                recycler.setAdapter(mLauncher.mAppBars.mAppListAdapter);
            }
            if (recycler.getLayoutManager() == null) {
                recycler.setLayoutManager(new LinearLayoutManager(mLauncher.getApplicationContext(), RecyclerView.HORIZONTAL, false));
            }
            mLauncher.mAppBars.installBottomRecyclerDecorations(recycler);
            recycler.clearAnimation();
            if (!autoHideHorizontalBar) {
                recycler.setVisibility(View.VISIBLE);
            }
            recycler.setEnabled(true);
            recycler.setClickable(true);
            recycler.setLongClickable(true);
            mLauncher.mAppBars.refreshRecyclerDecorationsAfterLayout(recycler);
        }

        RecyclerView leftRecycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.vertical_recycler_view);
        if (leftRecycler != null && mLauncher.mAppBars.shouldUseLeftRecycler()) {
            if (mLauncher.mAppBars.mVerticalAppListAdapter != null && leftRecycler.getAdapter() != mLauncher.mAppBars.mVerticalAppListAdapter) {
                leftRecycler.setAdapter(mLauncher.mAppBars.mVerticalAppListAdapter);
            }
            if (!(leftRecycler.getLayoutManager() instanceof Launcher.EvenVerticalLayoutManager)) {
                leftRecycler.setLayoutManager(mLauncher.mAppBars.newLeftLayoutManager());
            }
            mLauncher.mAppBars.installLeftRecyclerDecorations(leftRecycler);
            leftRecycler.clearAnimation();
            leftRecycler.setVisibility(View.VISIBLE);
        }
        Log.d(Launcher.TAG, "Wake home recycler restore: " + source);
    }

    void forceWorkspaceLayoutPass() {
        if (mLauncher.mDragLayer != null) {
            mLauncher.mDragLayer.clearAnimation();
            mLauncher.mDragLayer.requestLayout();
            mLauncher.mDragLayer.invalidate();
        }
        if (mLauncher.mWorkspace != null) {
            mLauncher.mWorkspace.clearAnimation();
            mLauncher.mWorkspace.requestLayout();
            mLauncher.mWorkspace.invalidate();
        }
        if (mLauncher.mHotseat != null) {
            mLauncher.mHotseat.clearAnimation();
            mLauncher.mHotseat.refreshLayoutAfterWake();
        }
    }
}
