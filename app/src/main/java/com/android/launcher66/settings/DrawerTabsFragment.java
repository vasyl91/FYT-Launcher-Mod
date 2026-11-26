package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.AccentPainter;
import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.CreatorPrefs;
import com.android.launcher66.DrawerTabs;
import com.android.launcher66.DrawerTabsStore;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.util.ArrayList;
import java.util.List;

/**
 * The tab creator of the app drawer (F5), opened from "App drawer": "Tabs".
 *
 * <p>One list with two categories. "Tabs" holds the tabs, each on a row, and a "+" button at the right of its title (it
 * adds a tab, {@link DrawerTabDialogs#showAdd}). The main tab is first: a star on the tile where the others have their
 * three bars, it cannot be dragged or deleted. The others are dragged by their handle (up and down, nothing moves before
 * the main tab: {@link DrawerTabs#move}), deleted with the bin after a question, and edited with the gear at the right
 * end of the row ({@link DrawerTabDialogs#showEdit}). The handles, the names and the gears are in the same columns on
 * every row, and the margins are those of the settings (16 dp). A name that does not fit runs as a marquee.
 *
 * <p>"Miscellaneous" holds "Apps in several tabs" (a tap steps through the three rules; under the chosen one a line for
 * each tab that keeps its apps in the main tab, where the flag applies) and "Tab bar placement" (top or bottom). Every
 * change is stored at once ({@link DrawerTabsStore}). Back goes to "App drawer" in the creator.
 */
public class DrawerTabsFragment extends Fragment implements DrawerTabDialogs.Host {

    private static final int TYPE_HEADER_TABS = 0;
    private static final int TYPE_TAB = 1;
    private static final int TYPE_HEADER_MISC = 2;
    private static final int TYPE_REPEAT = 3;
    private static final int TYPE_POSITION = 4;

    private SharedPreferences prefs;
    private DrawerTabs model;
    private RowsAdapter adapter;
    private ItemTouchHelper touch;
    private AlertDialog dialog;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // the creator's screen keeps the place it was left at (SettingsScrollMemory)
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new SettingsFragmentSecond()).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drawer_tabs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = requireContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        model = DrawerTabsStore.load(prefs, installedPackages());
        RecyclerView list = view.findViewById(R.id.drawer_tabs_list);
        list.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RowsAdapter();
        list.setAdapter(adapter);
        touch = new ItemTouchHelper(new Moves());
        touch.attachToRecyclerView(list);
        // the accent of the settings on every row as it is attached (AccentPainter)
        AccentPainter.attach(list);
        list.setClipToPadding(false);
        if (!LauncherApplication.isFytDevice()) {
            SettingsSystemBars.pad(view);
        }
    }

    @Override
    public void onDestroyView() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog = null;
        super.onDestroyView();
    }

    private static List<String> installedPackages() {
        List<String> packages = new ArrayList<>();
        for (AppInfo info : AllAppsList.snapshot()) {
            if (info != null && info.getPackageName() != null) {
                packages.add(info.getPackageName());
            }
        }
        return packages;
    }

    // ------------------------------------------------------------------ DrawerTabDialogs.Host

    @Override
    public void changed() {
        if (adapter != null) {
            adapter.rebuild();
        }
    }

    @Override
    public void openApps(int tab) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, DrawerAppsFragment.newInstance(tab, false)).commit();
    }

    /**
     * A drag moves the tab at the adapter position {@code from} to {@code to}; false when the rules do not allow it
     * (the main tab does not move and nothing goes before it). The list of all the tabs starts with the main tab at 0,
     * the adapter's list has the category's title before it.
     */
    boolean moveTab(int from, int to) {
        if (!model.move(from - 1, to - 1)) {
            return false;
        }
        adapter.tabs = model.ids();
        adapter.notifyItemMoved(from, to);
        return true;
    }

    /** The ids of the tabs in the order the list shows them, the main tab first. */
    List<Integer> tabIds() {
        return new ArrayList<>(model.ids());
    }

    // ------------------------------------------------------------------ the rows

    private String tabName(int id) {
        return model.nameOf(id, getString(R.string.drawer_tab_main), getString(R.string.drawer_tab_default));
    }

    private boolean barAtTop() {
        return !"bottom".equals(CreatorPrefs.of(prefs).getString(Keys.DRAWER_TAB_BAR_POSITION, "top"));
    }

    private int repeatLabel(DrawerTabs.Repeat repeat) {
        switch (repeat) {
            case EXCEPT_MAIN: return R.string.drawer_tabs_repeat_except_main;
            case NONE: return R.string.drawer_tabs_repeat_none;
            default: return R.string.drawer_tabs_repeat_all;
        }
    }

    /** The rule chosen and, under it, a line for every tab that keeps its apps in the main tab. */
    String repeatSummary() {
        StringBuilder text = new StringBuilder(getString(repeatLabel(model.repeat())));
        for (int id : model.tabsKeepingInMain()) {
            text.append('\n').append(getString(R.string.drawer_tabs_keep_line, tabName(id)));
        }
        return text.toString();
    }

    private final class RowsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        /** The ids of the tabs in the list, the main tab first. */
        private List<Integer> tabs = model.ids();

        @SuppressLint("NotifyDataSetChanged")
        void rebuild() {
            tabs = model.ids();
            notifyDataSetChanged();
        }

        // position 0: the category "Tabs"; then the tabs; then "Miscellaneous", the rule, the placement
        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return TYPE_HEADER_TABS;
            }
            if (position <= tabs.size()) {
                return TYPE_TAB;
            }
            return TYPE_HEADER_MISC + (position - tabs.size() - 1);
        }

        @Override
        public int getItemCount() {
            return tabs.size() + 4;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            switch (type) {
                case TYPE_HEADER_TABS:
                case TYPE_HEADER_MISC:
                    return new HeaderHolder(inflater.inflate(R.layout.item_drawer_tabs_header, parent, false));
                case TYPE_TAB:
                    return new TabHolder(inflater.inflate(R.layout.item_drawer_tab, parent, false));
                default:
                    return new SettingHolder(inflater.inflate(R.layout.item_drawer_tabs_setting, parent, false));
            }
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            int type = getItemViewType(position);
            if (holder instanceof HeaderHolder) {
                HeaderHolder header = (HeaderHolder) holder;
                boolean tabsHeader = type == TYPE_HEADER_TABS;
                header.title.setText(tabsHeader ? R.string.drawer_tabs : R.string.misc_category);
                header.add.setVisibility(tabsHeader ? View.VISIBLE : View.GONE);
                header.add.setContentDescription(getString(R.string.add_drawer_tab));
                header.add.setOnClickListener(v -> dialog = DrawerTabDialogs.showAdd(requireContext(), model, prefs,
                        DrawerTabsFragment.this));
            } else if (holder instanceof TabHolder) {
                bindTab((TabHolder) holder, tabs.get(position - 1));
            } else {
                SettingHolder row = (SettingHolder) holder;
                if (type == TYPE_REPEAT) {
                    row.title.setText(R.string.drawer_tabs_repeat);
                    row.summary.setText(repeatSummary());
                    row.itemView.setOnClickListener(v -> {
                        DrawerTabs.Repeat[] all = DrawerTabs.Repeat.values();
                        model.setRepeat(all[(model.repeat().ordinal() + 1) % all.length]);
                        DrawerTabsStore.save(prefs, model);
                        rebuild();
                    });
                } else {
                    row.title.setText(R.string.drawer_tab_bar_position);
                    row.summary.setText(barAtTop() ? R.string.drawer_tab_bar_top : R.string.drawer_tab_bar_bottom);
                    row.itemView.setOnClickListener(v -> {
                        prefs.edit().putString(Keys.DRAWER_TAB_BAR_POSITION, barAtTop() ? "bottom" : "top").apply();
                        rebuild();
                    });
                }
            }
        }

        @SuppressLint("ClickableViewAccessibility")
        private void bindTab(TabHolder row, int id) {
            boolean main = id == DrawerTabs.MAIN;
            row.name.setText(tabName(id));
            row.name.setSelected(true);   // a name that is too long runs
            row.icon.setVisibility(main ? View.GONE : View.VISIBLE);
            row.star.setVisibility(main ? View.VISIBLE : View.GONE);
            // the main tab keeps the room of the bin, so that the gears are in one column
            row.delete.setVisibility(main ? View.INVISIBLE : View.VISIBLE);
            row.delete.setEnabled(!main);
            row.delete.setOnClickListener(v -> dialog = DrawerTabDialogs.confirmDelete(requireContext(), model, prefs, id,
                    DrawerTabsFragment.this));
            row.edit.setOnClickListener(v -> dialog = DrawerTabDialogs.showEdit(requireContext(), model, prefs, id,
                    DrawerTabsFragment.this));
            row.handle.setOnTouchListener((v, event) -> {
                if (!main && event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    touch.startDrag(row);
                }
                return false;
            });
        }
    }

    private static final class HeaderHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final ImageButton add;

        HeaderHolder(View item) {
            super(item);
            title = item.findViewById(R.id.drawer_tabs_header_title);
            add = item.findViewById(R.id.drawer_tabs_add);
        }
    }

    private static final class TabHolder extends RecyclerView.ViewHolder {
        final View handle;
        final View icon;
        final View star;
        final TextView name;
        final ImageButton delete;
        final ImageButton edit;

        TabHolder(View item) {
            super(item);
            handle = item.findViewById(R.id.tab_handle);
            icon = item.findViewById(R.id.tab_handle_icon);
            star = item.findViewById(R.id.tab_handle_star);
            name = item.findViewById(R.id.tab_name);
            delete = item.findViewById(R.id.tab_delete);
            edit = item.findViewById(R.id.tab_edit);
        }
    }

    private static final class SettingHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final TextView summary;

        SettingHolder(View item) {
            super(item);
            title = item.findViewById(R.id.setting_title);
            summary = item.findViewById(R.id.setting_summary);
        }
    }

    /**
     * Up and down only, by the handle at once. Only the tabs after the main one are dragged, and only over each other:
     * nothing goes before the main tab. The order is stored when the finger is lifted.
     */
    private final class Moves extends ItemTouchHelper.SimpleCallback {
        Moves() {
            super(0, 0);
        }

        @Override
        public int getMovementFlags(@NonNull RecyclerView list, @NonNull RecyclerView.ViewHolder holder) {
            return movable(holder) ? makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) : 0;
        }

        private boolean movable(RecyclerView.ViewHolder holder) {
            int position = holder.getBindingAdapterPosition();
            return holder instanceof TabHolder && position > 1;   // position 1 is the main tab
        }

        @Override
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override
        public boolean canDropOver(@NonNull RecyclerView list, @NonNull RecyclerView.ViewHolder current,
                                   @NonNull RecyclerView.ViewHolder target) {
            return movable(target);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView list, @NonNull RecyclerView.ViewHolder from,
                              @NonNull RecyclerView.ViewHolder to) {
            return moveTab(from.getBindingAdapterPosition(), to.getBindingAdapterPosition());
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder holder, int direction) {
        }

        @Override
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder holder, int actionState) {
            super.onSelectedChanged(holder, actionState);
            if (holder != null && actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                holder.itemView.setAlpha(0.8f);
            }
        }

        @Override
        public void clearView(@NonNull RecyclerView list, @NonNull RecyclerView.ViewHolder holder) {
            super.clearView(list, holder);
            holder.itemView.setAlpha(1f);
            DrawerTabsStore.save(prefs, model);
        }
    }
}
