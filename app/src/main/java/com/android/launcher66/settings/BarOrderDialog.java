package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.BarOrder;
import com.android.launcher66.BarOrderLayout;
import com.android.launcher66.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The row "Order of the bar's elements" in "Bars" and its dialog (the owner, 2026-11-20): the horizontal bar's
 * elements the settings and the orientation leave (BarOrder.shown), each with a drag handle on a tile; the top of the
 * list is the left of the bar, the bottom its right.
 *
 * <p>The rule (the owner, 2026-11-20): <b>one row, and the list it opens is the one of the orientation the screen is
 * in now.</b> The launcher is mostly seen in one orientation, so the other one's order is not shown beside it. The
 * settings are not created again when the screen turns (configChanges), so a turn with the dialog open shows it again
 * with the new orientation's list ({@link #onOrientationChanged}); moves not yet confirmed with OK are dropped. An element is dragged by its handle at once, or by its row after
 * a long press. OK stores the order of the orientation the settings are shown in (BarOrder.merge: a hidden element
 * keeps its place), "Default" puts the old order back. The bar is built again when the settings are left
 * (Helpers.setBarSettingsChanged). The dialog is in the settings' colours (SettingsDialogs).
 */
final class BarOrderDialog {

    private final PreferenceFragmentCompat fragment;
    private final SharedPreferences prefs;
    private final Helpers helpers;
    private Preference row;
    private AlertDialog dialog;

    BarOrderDialog(PreferenceFragmentCompat fragment, SharedPreferences prefs, Helpers helpers) {
        this.fragment = fragment;
        this.prefs = prefs;
        this.helpers = helpers;
    }

    /** Shows the order in the row and opens the dialog on a tap. */
    void bind() {
        row = fragment.findPreference(Keys.HORIZONTAL_BAR_ORDER);
        if (row == null) {
            return;
        }
        updateSummary();
        row.setOnPreferenceClickListener(preference -> {
            show();
            return true;
        });
    }

    /** The row's summary: the names of the elements shown, in their order (after a change of what is shown too). */
    void updateSummary() {
        if (row == null || !fragment.isAdded()) {
            return;
        }
        List<String> names = new ArrayList<>();
        for (BarOrder.Element e : BarOrderLayout.shown(prefs, portrait())) {
            names.add(fragment.getString(nameOf(e)));
        }
        row.setSummary(String.join(" · ", names));
    }

    /** The screen turned: the row names the new orientation's order, and an open dialog shows its list. */
    void onOrientationChanged() {
        updateSummary();
        if (dialog != null && dialog.isShowing() && fragment.isAdded()) {
            show();
        }
    }

    /** With the fragment's view: a dialog must not outlive it. */
    void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog = null;
    }

    private boolean portrait() {
        return fragment.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    static int nameOf(BarOrder.Element element) {
        switch (element) {
            case DRAWER: return R.string.bar_element_drawer;
            case APPS: return R.string.bar_element_apps;
            case MUSIC: return R.string.bar_element_music;
            case DATE: return R.string.bar_element_date;
            default: return R.string.bar_element_weather;
        }
    }

    void show() {
        Context context = fragment.requireContext();
        boolean portrait = portrait();
        AlertDialog.Builder builder = SettingsDialogs.builder(context);
        View view = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_bar_order, null);
        TextView hint = view.findViewById(R.id.bar_order_hint);
        hint.setTextSize(TypedValue.COMPLEX_UNIT_SP, SettingsActivity.dialogTextView);
        RecyclerView list = view.findViewById(R.id.bar_order_list);
        list.setLayoutManager(new LinearLayoutManager(builder.getContext()));
        Adapter adapter = new Adapter(BarOrderLayout.shown(prefs, portrait));
        list.setAdapter(adapter);
        ItemTouchHelper touch = new ItemTouchHelper(new Moves(adapter));
        touch.attachToRecyclerView(list);
        adapter.dragger = touch;

        dismiss();
        dialog = builder.setTitle(R.string.horizontal_bar_order)
                .setView(view)
                .setPositiveButton(android.R.string.ok, (d, which) -> save(portrait, adapter.items(), adapter.reset))
                .setNeutralButton(R.string.color_picker_default, null)
                .setNegativeButton(android.R.string.cancel, (d, which) -> d.dismiss())
                .create();
        dialog.show();
        // "Default" sets the list back without closing the dialog; OK stores it
        Button reset = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
        if (reset != null) {
            reset.setOnClickListener(v -> adapter.setItems(defaultShown(portrait), true));
        }
        if (dialog.getWindow() != null) {
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            boolean landscape = dm.widthPixels > dm.heightPixels;
            dialog.getWindow().setLayout(Math.round(dm.widthPixels * (landscape ? 0.5f : 0.9f)),
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private List<BarOrder.Element> defaultShown(boolean portrait) {
        List<BarOrder.Element> now = BarOrderLayout.shown(prefs, portrait);
        List<BarOrder.Element> shown = new ArrayList<>();
        for (BarOrder.Element e : BarOrder.DEFAULT) {
            if (now.contains(e)) {
                shown.add(e);
            }
        }
        return shown;
    }

    /** Stores the order of this orientation; nothing stored where it is the default order. */
    void save(boolean portrait, List<BarOrder.Element> shown, boolean fromDefault) {
        List<BarOrder.Element> base = fromDefault ? BarOrder.DEFAULT : BarOrderLayout.order(prefs, portrait);
        List<BarOrder.Element> order = BarOrder.merge(base, shown);
        SharedPreferences.Editor edit = prefs.edit();
        if (order.equals(BarOrder.DEFAULT)) {
            edit.remove(BarOrderLayout.key(portrait));
        } else {
            edit.putString(BarOrderLayout.key(portrait), BarOrder.format(order));
        }
        edit.apply();
        helpers.setBarSettingsChanged(true);
        updateSummary();
    }

    /** The list of the elements; {@link #move} is what a drag does. */
    static final class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
        private final List<BarOrder.Element> items;
        ItemTouchHelper dragger;
        /** "Default" was pressed: the order is the default one with this list's moves. */
        boolean reset;

        Adapter(List<BarOrder.Element> items) {
            this.items = new ArrayList<>(items);
        }

        List<BarOrder.Element> items() {
            return new ArrayList<>(items);
        }

        @SuppressLint("NotifyDataSetChanged")
        void setItems(List<BarOrder.Element> order, boolean fromDefault) {
            items.clear();
            items.addAll(order);
            reset = reset || fromDefault;
            notifyDataSetChanged();
        }

        void move(int from, int to) {
            if (from < to) {
                for (int i = from; i < to; i++) {
                    Collections.swap(items, i, i + 1);
                }
            } else {
                for (int i = from; i > to; i--) {
                    Collections.swap(items, i, i - 1);
                }
            }
            notifyItemMoved(from, to);
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bar_order, parent, false));
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.name.setText(nameOf(items.get(position)));
            holder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, SettingsActivity.dialogTextView);
            holder.handle.setOnTouchListener((v, event) -> {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN && dragger != null) {
                    dragger.startDrag(holder);
                }
                return false;
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        static final class Holder extends RecyclerView.ViewHolder {
            final View handle;
            final TextView name;

            Holder(View item) {
                super(item);
                handle = item.findViewById(R.id.bar_order_handle);
                name = item.findViewById(R.id.bar_order_name);
            }
        }
    }

    /** Up and down only, by the handle at once or by the row after a long press; nothing is swiped away. */
    private static final class Moves extends ItemTouchHelper.SimpleCallback {
        private final Adapter adapter;

        Moves(Adapter adapter) {
            super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
            this.adapter = adapter;
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder from,
                              @NonNull RecyclerView.ViewHolder to) {
            adapter.move(from.getBindingAdapterPosition(), to.getBindingAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        }

        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder holder, int actionState) {
            super.onSelectedChanged(holder, actionState);
            if (holder != null && actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                holder.itemView.setAlpha(0.8f);
            }
        }

        @Override
        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder holder) {
            super.clearView(recyclerView, holder);
            holder.itemView.setAlpha(1f);
        }
    }
}
