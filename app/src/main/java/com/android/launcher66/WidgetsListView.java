package com.android.launcher66;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * The drawer's "Widgets" as a list of apps (G1 of round 28, built in round 29): a search field on top, then one row for
 * each app that has widgets or shortcuts, with its icon, its name and "1 widget, 3 shortcuts"; a tap opens the row
 * (one at a time: opening one closes the one open) and shows the app's widgets one under the other, centred, then its
 * shortcuts in rows. The letter scroller of the vertical drawer is at the right.
 *
 * <p>The look (the owner on the A55, 2026-11-27, and G1's brief): a widget is its preview alone, as large as it is drawn,
 * with no card of the old pager round it; under it, centred, each on its line, its name, its size in cells and its
 * description where it has one. A shortcut is its icon, its name and "Shortcut" in the accent colour. The rows are 90 %
 * as wide as the search field and centred under it ({@link #LIST_SHARE}).
 *
 * <p>The widgets and shortcuts are the pager's own cells ({@link Host#makeCell}): a PagedViewWidget with its
 * PendingAddWidgetInfo or PendingAddShortcutInfo, its press and long press as on a page of the pager, so they are dragged
 * to the home screen as from there; their previews are loaded off the main thread ({@link Host#loadPreview}). The
 * grouping, the order and the search are {@link WidgetGroups}'s. Main thread.
 */
public final class WidgetsListView extends FrameLayout {

    /** What the list needs of the drawer. */
    interface Host {
        /** A cell for one widget ({@code AppWidgetProviderInfo}) or shortcut ({@code ResolveInfo}), as the pager makes it. */
        View makeCell(Object rawInfo, ViewGroup parent, int width, int height);

        /** Loads the cell's preview off the main thread, once it is laid out. */
        void loadPreview(View cell, Object rawInfo);

        /** The icon of an app, or null. */
        Drawable appIcon(String packageName);

        /** The name of an app. */
        String appLabel(String packageName);

        /** The name of a widget or a shortcut. */
        String entryLabel(Object rawInfo);

        /** The package a widget or a shortcut belongs to. */
        String packageOf(Object rawInfo);

        /** Whether it is a shortcut (not a widget). */
        boolean isShortcut(Object rawInfo);

        /** A widget's size in cells {columns, rows}, or null for a shortcut. */
        int[] entrySpan(Object rawInfo);

        /** A widget's description (Android 12 and later), or null. */
        CharSequence entryDescription(Object rawInfo);
    }

    /** The rows' width against the search field's (the owner, 2026-11-27). */
    static final float LIST_SHARE = 0.9f;

    private static final int TYPE_APP = 0;
    private static final int TYPE_CONTENT = 1;

    private final AppSearchBar mSearch;
    private final RecyclerView mList;
    private final LetterScroller mScroller;
    private final LinearLayoutManager mManager;
    private final Adapter mAdapter = new Adapter();
    private final float mDensity;
    private Host mHost;
    private final List<Object> mRaw = new ArrayList<>();
    private List<WidgetGroups.Group> mGroups = Collections.emptyList();
    private String mQuery = "";
    private String mExpanded;

    public WidgetsListView(Context context) {
        this(context, null);
    }

    public WidgetsListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDensity = context.getResources().getDisplayMetrics().density;
        LinearLayout column = new LinearLayout(context);
        column.setOrientation(LinearLayout.VERTICAL);
        mSearch = new AppSearchBar(context);
        mSearch.setHint(R.string.search_widgets_hint);
        mSearch.setListener(this::setQuery);
        column.addView(mSearch, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        FrameLayout listFrame = new FrameLayout(context);
        mList = new RecyclerView(context);
        mManager = new LinearLayoutManager(context);
        mList.setLayoutManager(mManager);
        mList.setAdapter(mAdapter);
        mList.setClipToPadding(false);
        int pad = Math.round(8 * mDensity);
        // The sides are set from the search field's width once it is laid out (alignToSearch)
        mList.setPadding(pad * 2, pad, pad * 2, pad);
        mList.setOverScrollMode(OVER_SCROLL_NEVER);
        listFrame.addView(mList, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        mScroller = new LetterScroller(context);
        mScroller.setListener(this::scrollToFraction);
        listFrame.addView(mScroller, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.END));
        mList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                followList();
            }
        });
        mList.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> followList());
        column.addView(listFrame, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0, 1f));
        addView(column, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        mSearch.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> alignToSearch());
    }

    /**
     * The rows {@link #LIST_SHARE} as wide as the search field's box and centred under it: the same padding on both sides
     * of the list (it was larger on the right, for the letter scroller, and the rows stood off the field's middle).
     */
    private void alignToSearch() {
        int box = mSearch.getWidth() - mSearch.getPaddingLeft() - mSearch.getPaddingRight();
        int width = mList.getWidth() > 0 ? mList.getWidth() : mSearch.getWidth();
        if (box <= 0 || width <= 0) {
            return;
        }
        int side = WidgetGroups.sidePadding(width, box, LIST_SHARE);
        if (mList.getPaddingLeft() != side || mList.getPaddingRight() != side) {
            mList.setPadding(side, mList.getPaddingTop(), side, mList.getPaddingBottom());
        }
    }

    void setHost(Host host) {
        mHost = host;
    }

    /** The drawer's widgets and shortcuts (AppsCustomizePagedView.mWidgets). */
    void setWidgets(List<Object> widgetsAndShortcuts) {
        mRaw.clear();
        mRaw.addAll(widgetsAndShortcuts);
        regroup();
    }

    void setQuery(String query) {
        mQuery = query == null ? "" : query;
        regroup();
    }

    /** The list as it was opened: no search, no row open, at its top (the drawer was closed). */
    void reset() {
        mSearch.clear();
        mQuery = "";
        mExpanded = null;
        regroup();
        mList.scrollToPosition(0);
    }

    private void regroup() {
        if (mHost == null) {
            mGroups = Collections.emptyList();
            mAdapter.notifyDataSetChanged();
            return;
        }
        List<WidgetGroups.Entry> entries = new ArrayList<>(mRaw.size());
        for (Object raw : mRaw) {
            String pkg = mHost.packageOf(raw);
            if (pkg == null) {
                continue;
            }
            entries.add(new WidgetGroups.Entry(pkg, mHost.appLabel(pkg), mHost.entryLabel(raw), mHost.isShortcut(raw),
                    raw));
        }
        mGroups = WidgetGroups.group(entries, Locale.getDefault(), mQuery);
        mScroller.setAlphabet(LetterIndex.alphabet(WidgetGroups.titles(mGroups)));
        if (mExpanded != null && indexOf(mExpanded) < 0) {
            mExpanded = null;
        }
        mAdapter.notifyDataSetChanged();
    }

    private int indexOf(String packageName) {
        for (int i = 0; i < mGroups.size(); i++) {
            if (mGroups.get(i).packageName.equals(packageName)) {
                return i;
            }
        }
        return -1;
    }

    /** A tap on an app's row: it opens, and the one open closes; a tap on the open one closes it. */
    void toggle(String packageName) {
        mExpanded = packageName.equals(mExpanded) ? null : packageName;
        mAdapter.notifyDataSetChanged();
        int index = indexOf(packageName);
        if (mExpanded != null && index >= 0) {
            mManager.scrollToPositionWithOffset(index, 0);
        }
    }

    /** The app whose row is open, or null (a test asks). */
    String expanded() {
        return mExpanded;
    }

    /** The groups shown now (a test asks). */
    List<WidgetGroups.Group> groups() {
        return mGroups;
    }

    RecyclerView list() {
        return mList;
    }

    private void followList() {
        int range = mList.computeVerticalScrollRange();
        int extent = mList.computeVerticalScrollExtent();
        mScroller.setVisibility(ScrollFraction.scrolls(range, extent) && !mGroups.isEmpty() ? VISIBLE : GONE);
        mScroller.setFraction(ScrollFraction.of(mList.computeVerticalScrollOffset(), range, extent));
        int first = mManager.findFirstVisibleItemPosition();
        int group = mAdapter.groupAt(first);
        if (group >= 0 && group < mGroups.size()) {
            mScroller.setBubbleLetter(LetterIndex.letterOf(mGroups.get(group).appLabel));
        }
    }

    private void scrollToFraction(float fraction) {
        int range = mList.computeVerticalScrollRange();
        int extent = mList.computeVerticalScrollExtent();
        int dy = ScrollFraction.offsetFor(fraction, range, extent) - mList.computeVerticalScrollOffset();
        if (dy != 0) {
            mList.scrollBy(0, dy);
        }
    }

    /** A line of text centred under a preview. */
    private void addLine(LinearLayout parent, CharSequence text, int color, float sp, boolean bold) {
        if (text == null || text.length() == 0) {
            return;
        }
        TextView line = new TextView(getContext());
        line.setText(text);
        line.setTextColor(color);
        line.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
        line.setGravity(Gravity.CENTER_HORIZONTAL);
        if (bold) {
            line.setTypeface(line.getTypeface(), Typeface.BOLD);
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        lp.topMargin = dp(4);
        parent.addView(line, lp);
    }

    private int dp(float value) {
        return Math.round(value * mDensity);
    }

    /** The height of an app's row: 17 % of the screen's shorter side. */
    private int rowHeight() {
        android.util.DisplayMetrics dm = getResources().getDisplayMetrics();
        return Math.max(dp(56), Math.round(Math.min(dm.widthPixels, dm.heightPixels) * 0.17f));
    }

    private GradientDrawable card() {
        GradientDrawable card = new GradientDrawable();
        card.setColor((ContextCompat.getColor(getContext(), R.color.dark_surface) & 0x00ffffff) | 0xe0000000);
        card.setCornerRadius(dp(12));
        return card;
    }

    private final class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public int getItemCount() {
            return mGroups.size() + (mExpanded != null && indexOf(mExpanded) >= 0 ? 1 : 0);
        }

        /** The group of a position: the open group's content is right after its row. */
        int groupAt(int position) {
            int open = mExpanded == null ? -1 : indexOf(mExpanded);
            if (open >= 0 && position > open) {
                return position == open + 1 ? open : position - 1;
            }
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            int open = mExpanded == null ? -1 : indexOf(mExpanded);
            return open >= 0 && position == open + 1 ? TYPE_CONTENT : TYPE_APP;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = viewType == TYPE_APP ? appRow(parent.getContext()) : new LinearLayout(parent.getContext());
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(LayoutParams.MATCH_PARENT,
                    viewType == TYPE_APP ? rowHeight() : LayoutParams.WRAP_CONTENT);
            lp.bottomMargin = dp(8);
            view.setLayoutParams(lp);
            return new RecyclerView.ViewHolder(view) {
            };
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            WidgetGroups.Group group = mGroups.get(groupAt(position));
            if (getItemViewType(position) == TYPE_APP) {
                bindApp((LinearLayout) holder.itemView, group);
            } else {
                bindContent((LinearLayout) holder.itemView, group);
            }
        }
    }

    private LinearLayout appRow(Context context) {
        LinearLayout row = new LinearLayout(context);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(dp(12), 0, dp(12), 0);
        row.setBackground(card());
        ImageView icon = new ImageView(context);
        icon.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int iconSize = Math.round(rowHeight() * 0.6f);
        row.addView(icon, new LinearLayout.LayoutParams(iconSize, iconSize));
        LinearLayout text = new LinearLayout(context);
        text.setOrientation(LinearLayout.VERTICAL);
        TextView name = new TextView(context);
        name.setTextColor(Color.WHITE);
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        name.setSingleLine(true);
        TextView counts = new TextView(context);
        counts.setTextColor(ContextCompat.getColor(context, R.color.gray_medium));
        counts.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        text.addView(name);
        text.addView(counts);
        LinearLayout.LayoutParams textLp = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
        textLp.setMarginStart(dp(12));
        row.addView(text, textLp);
        TextView arrow = new TextView(context);
        arrow.setTextColor(Color.WHITE);
        arrow.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        row.addView(arrow, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        return row;
    }

    private void bindApp(LinearLayout row, WidgetGroups.Group group) {
        ImageView icon = (ImageView) row.getChildAt(0);
        LinearLayout text = (LinearLayout) row.getChildAt(1);
        TextView arrow = (TextView) row.getChildAt(2);
        icon.setImageDrawable(mHost == null ? null : mHost.appIcon(group.packageName));
        ((TextView) text.getChildAt(0)).setText(group.appLabel);
        // "1 widget, 3 shortcuts": the plural form of each count in the language, a count of none left out (G1)
        android.content.res.Resources res = getResources();
        ((TextView) text.getChildAt(1)).setText(WidgetGroups.counts(group.widgetCount(), group.shortcutCount(),
                res.getQuantityString(R.plurals.widget_count, group.widgetCount()),
                res.getQuantityString(R.plurals.shortcut_count, group.shortcutCount()),
                getContext().getString(R.string.list_separator)));
        boolean open = group.packageName.equals(mExpanded);
        arrow.setText(open ? "⌃" : "⌄");
        row.setOnClickListener(v -> toggle(group.packageName));
    }

    /** The open app's widgets one under the other, centred, then its shortcuts in rows, six at most in a row. */
    private void bindContent(LinearLayout content, WidgetGroups.Group group) {
        content.removeAllViews();
        content.setOrientation(LinearLayout.VERTICAL);
        content.setGravity(Gravity.CENTER_HORIZONTAL);
        content.setPadding(dp(8), dp(8), dp(8), dp(8));
        content.setBackground(card());
        if (mHost == null) {
            return;
        }
        android.util.DisplayMetrics dm = getResources().getDisplayMetrics();
        int room = Math.max(1, mList.getWidth() - mList.getPaddingLeft() - mList.getPaddingRight() - dp(16));
        int width = Math.min(room, Math.round(dm.widthPixels * 0.7f));
        int height = Math.round(dm.heightPixels * 0.4f);
        for (WidgetGroups.Entry entry : group.widgets) {
            // The preview alone (at most the box; the cell takes the preview's own size once it is loaded), then its name,
            // its size in cells and its description, each centred on its line
            View cell = mHost.makeCell(entry.payload, content, width, height);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, height);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            content.addView(cell, lp);
            cell.post(() -> mHost.loadPreview(cell, entry.payload));
            addLine(content, mHost.entryLabel(entry.payload), Color.WHITE, 16, true);
            int[] span = mHost.entrySpan(entry.payload);
            if (span != null) {
                addLine(content, getContext().getString(R.string.widget_dims_format, span[0], span[1]),
                        ContextCompat.getColor(getContext(), R.color.gray_medium), 14, false);
            }
            CharSequence description = mHost.entryDescription(entry.payload);
            if (description != null && description.length() > 0) {
                addLine(content, description, ContextCompat.getColor(getContext(), R.color.gray_medium), 14, false);
            }
            View gap = new View(getContext());
            content.addView(gap, new LinearLayout.LayoutParams(1, dp(16)));
        }
        if (!group.shortcuts.isEmpty()) {
            FlexboxLayout shortcuts = new FlexboxLayout(getContext());
            shortcuts.setFlexWrap(FlexWrap.WRAP);
            shortcuts.setJustifyContent(JustifyContent.SPACE_EVENLY);
            int cellWidth = Math.max(1, room / 6);
            int cellHeight = Math.round(cellWidth * 1.3f);
            int iconSize = Math.round(cellWidth * 0.7f);
            for (WidgetGroups.Entry entry : group.shortcuts) {
                // Its icon, its name and "Shortcut" in the accent colour (G1)
                LinearLayout item = new LinearLayout(getContext());
                item.setOrientation(LinearLayout.VERTICAL);
                item.setGravity(Gravity.CENTER_HORIZONTAL);
                View cell = mHost.makeCell(entry.payload, item, iconSize, iconSize);
                LinearLayout.LayoutParams cellLp = new LinearLayout.LayoutParams(iconSize, iconSize);
                cellLp.gravity = Gravity.CENTER_HORIZONTAL;
                item.addView(cell, cellLp);
                addLine(item, mHost.entryLabel(entry.payload), Color.WHITE, 14, false);
                addLine(item, getContext().getString(R.string.widget_list_shortcut), ThemeAccent.color(getContext()), 12,
                        false);
                FlexboxLayout.LayoutParams itemLp = new FlexboxLayout.LayoutParams(cellWidth,
                        LayoutParams.WRAP_CONTENT);
                itemLp.bottomMargin = dp(12);
                shortcuts.addView(item, itemLp);
                cell.post(() -> mHost.loadPreview(cell, entry.payload));
            }
            content.addView(shortcuts, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }
    }
}
