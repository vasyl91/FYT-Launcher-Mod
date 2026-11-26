package com.android.launcher66.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.AllAppsList;
import com.android.launcher66.AppInfo;
import com.android.launcher66.DrawerAppList;
import com.android.launcher66.DrawerTabs;
import com.android.launcher66.DrawerTabsStore;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.LauncherModel;
import com.android.launcher66.R;
import com.android.launcher66.ThemeAccent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The lists of apps of the drawer's tabs: "Select apps" for one tab (L1, titled with the tab's name) and "Hide apps"
 * (L2). The title is on the left of the header, the button with three dots on the right; it opens a small window with
 * "Show hidden apps". Below is the list: each row has only the name and a checkbox, and a tap anywhere on the row
 * ticks it. The rules of what is listed and what a tick does are those of {@link DrawerAppList}; every tick is stored
 * at once ({@link DrawerTabsStore#save}, {@code apply()}).
 *
 * <p>Back goes to where the list was opened from: the tab creator's screen, or, when the settings were opened by the
 * drawer for this list alone ({@link #intent}), the drawer: the activity is closed.
 */
public class DrawerAppsFragment extends Fragment {

    private static final String ARG_TAB = "tab";
    private static final String ARG_FROM_DRAWER = "from_drawer";
    private static final String STATE_SHOW_HIDDEN = "show_hidden";
    /** The extra of the intent that opens the settings on this list alone (the tab's id, or {@link DrawerAppList#HIDDEN}). */
    public static final String EXTRA_TAB = "com.android.launcher66.DRAWER_APPS_TAB";

    private SharedPreferences prefs;
    private DrawerTabs model;
    private DrawerAppList list;
    private RowsAdapter adapter;
    private PopupWindow menu;
    private int accent;

    /** The list of one tab ({@code tab}), or of the hidden apps ({@link DrawerAppList#HIDDEN}). */
    public static DrawerAppsFragment newInstance(int tab, boolean fromDrawer) {
        DrawerAppsFragment fragment = new DrawerAppsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAB, tab);
        args.putBoolean(ARG_FROM_DRAWER, fromDrawer);
        fragment.setArguments(args);
        return fragment;
    }

    /** The intent that opens the settings on this list alone, for the drawer (the dialog of a tab, F6). */
    public static Intent intent(Context context, int tab) {
        return new Intent(context, SettingsActivity.class).putExtra(EXTRA_TAB, tab);
    }

    private int tab() {
        return requireArguments().getInt(ARG_TAB, DrawerAppList.HIDDEN);
    }

    private boolean fromDrawer() {
        return requireArguments().getBoolean(ARG_FROM_DRAWER, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                goBack();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void goBack() {
        if (fromDrawer()) {
            requireActivity().finish();
            return;
        }
        SettingsScrollMemory.betweenScreens();
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragmentSecond()).commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drawer_apps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = requireContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        accent = ThemeAccent.color(context);
        List<DrawerAppList.App> apps = installedApps();
        List<String> packages = new ArrayList<>();
        for (DrawerAppList.App app : apps) {
            packages.add(app.pkg);
        }
        model = DrawerTabsStore.load(prefs, packages);
        list = new DrawerAppList(model, tab(), apps);
        if (savedInstanceState != null) {
            list.setShowHidden(savedInstanceState.getBoolean(STATE_SHOW_HIDDEN, false));
        }

        TextView title = view.findViewById(R.id.drawer_apps_title);
        title.setText(list.isHiddenList() ? getString(R.string.hide_apps)
                : model.nameOf(tab(), getString(R.string.drawer_tab_main), getString(R.string.drawer_tab_default)));
        view.findViewById(R.id.drawer_apps_more).setOnClickListener(this::showMenu);

        RecyclerView rows = view.findViewById(R.id.drawer_apps_list);
        rows.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RowsAdapter();
        rows.setAdapter(adapter);
        rows.setClipToPadding(false);
        if (!LauncherApplication.isFytDevice()) {
            applyInsets(view);
        }
    }

    /** As the other screens of the settings: the room of the status bar and the navigation bar (not on a FYT unit). */
    private static void applyInsets(View root) {
        SettingsActivity activity = SettingsActivity.getSettingsActivity();
        if (activity == null) {
            return;
        }
        int top = activity.getStatusBarHeight() + activity.getActionBarHeight();
        int navigation = activity.getNavigationBarHeight();
        if (SettingsActivity.isPortrait) {
            root.setPadding(root.getPaddingLeft(), top, root.getPaddingRight(), navigation);
        } else {
            root.setPadding(root.getPaddingLeft(), top, root.getPaddingRight() + navigation, root.getPaddingBottom());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (list != null) {
            outState.putBoolean(STATE_SHOW_HIDDEN, list.showHidden());
        }
    }

    @Override
    public void onDestroyView() {
        if (menu != null) {
            menu.dismiss();
            menu = null;
        }
        super.onDestroyView();
    }

    /** The apps installed in the drawer's order, one per package: the model keeps its apps by their packages. */
    private static List<DrawerAppList.App> installedApps() {
        ArrayList<AppInfo> source = AllAppsList.snapshot();
        List<AppInfo> sorted = new ArrayList<>();
        for (AppInfo info : source) {
            if (info != null && info.title != null && info.getPackageName() != null && !info.getPackageName().isEmpty()) {
                sorted.add(info);
            }
        }
        Collections.sort(sorted, LauncherModel.getAppNameComparator());
        List<DrawerAppList.App> apps = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (AppInfo info : sorted) {
            if (seen.add(info.getPackageName())) {
                apps.add(new DrawerAppList.App(info.getPackageName(), info.title.toString()));
            }
        }
        return apps;
    }

    /** The window under the three dots: "Show hidden apps" on a light surface, in the top right corner. */
    private void showMenu(View anchor) {
        if (menu != null && menu.isShowing()) {
            menu.dismiss();
            return;
        }
        Context context = anchor.getContext();
        View content = LayoutInflater.from(context).inflate(R.layout.popup_drawer_apps_menu, null);
        CheckBox check = content.findViewById(R.id.drawer_menu_check);
        check.setChecked(list.showHidden());
        CompoundButtonCompat.setButtonTintList(check, ColorStateList.valueOf(accent));
        PopupWindow popup = new PopupWindow(content, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        GradientDrawable surface = new GradientDrawable();
        surface.setColor(Color.parseColor("#fff2f2f2"));
        surface.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6,
                context.getResources().getDisplayMetrics()));
        popup.setBackgroundDrawable(surface);
        popup.setElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8,
                context.getResources().getDisplayMetrics()));
        // a tap anywhere on the row is the tap of the checkbox; the window closes and the list changes
        content.setOnClickListener(v -> {
            list.setShowHidden(!list.showHidden());
            popup.dismiss();
            adapter.refresh();
        });
        menu = popup;
        popup.showAsDropDown(anchor, 0, 0, Gravity.END);
    }

    private final class RowsAdapter extends RecyclerView.Adapter<RowsAdapter.Holder> {
        private List<DrawerAppList.App> rows = list.rows();

        @SuppressWarnings("NotifyDataSetChanged")
        void refresh() {
            rows = list.rows();
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_app, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            DrawerAppList.App app = rows.get(position);
            holder.name.setText(app.label);
            if (SettingsActivity.dialogTextView > 0) {
                holder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, SettingsActivity.dialogTextView);
            }
            holder.check.setChecked(list.isChecked(app.pkg));
            CompoundButtonCompat.setButtonTintList(holder.check, ColorStateList.valueOf(accent));
            holder.itemView.setOnClickListener(v -> {
                int at = holder.getBindingAdapterPosition();
                if (at == RecyclerView.NO_POSITION) {
                    return;
                }
                list.toggle(rows.get(at).pkg);
                DrawerTabsStore.save(prefs, model);
                notifyItemChanged(at);
            });
        }

        @Override
        public int getItemCount() {
            return rows.size();
        }

        final class Holder extends RecyclerView.ViewHolder {
            final TextView name;
            final CheckBox check;

            Holder(View item) {
                super(item);
                name = item.findViewById(R.id.drawer_app_name);
                check = item.findViewById(R.id.drawer_app_check);
            }
        }
    }
}
