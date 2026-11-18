package com.android.launcher66.settings;

import android.view.View;

import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/** Keeps and gives back the position of a settings screen's list (the rule is SettingsScrollMemory's). */
final class SettingsScroll {

    private SettingsScroll() {
    }

    /** The screen is left (its onPause()): its position is kept, unless it is left for the other screen. */
    static void keep(PreferenceFragmentCompat screen, int number) {
        if (screen.getActivity() != null && screen.getActivity().isFinishing()) {
            SettingsScrollMemory.forget();   // the settings are closed
            return;
        }
        RecyclerView list = screen.getListView();
        if (list == null || !(list.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        LinearLayoutManager layout = (LinearLayoutManager) list.getLayoutManager();
        int item = layout.findFirstVisibleItemPosition();
        View first = item >= 0 ? layout.findViewByPosition(item) : null;
        int offset = first != null ? first.getTop() - list.getPaddingTop() : 0;
        SettingsScrollMemory.left(number, item, offset);
    }

    /**
     * The screen's list is new (its onViewCreated()): it starts at the kept position, set before its first
     * layout, so it is drawn there the first time and nothing moves.
     */
    static void restore(PreferenceFragmentCompat screen, int number) {
        SettingsScrollMemory.Position kept = SettingsScrollMemory.takeFor(number);
        RecyclerView list = screen.getListView();
        if (kept == null || list == null || !(list.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) list.getLayoutManager()).scrollToPositionWithOffset(kept.item, kept.offset);
    }
}
