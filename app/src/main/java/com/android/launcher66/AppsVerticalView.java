package com.android.launcher66;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * The app drawer scrolling vertically (the owner, 2026-11-25, the default): the apps in the columns of "App drawer: Columns",
 * as many rows in view as "Rows" says, in one list that scrolls, with the fast scroller of the letters ({@link LetterScroller})
 * on its right.
 *
 * <p>It shows what the pager shows, the same icons ({@code apps_customize_application}, {@code PagedViewIcon}) in the same
 * look and text size, from the same list (AppsCustomizePagedView keeps the one source, sorted). A tap and a long press are
 * the pager's: this view only passes them on ({@link Host}), so the drag to the home screen is the one the pager has.
 * Main thread.
 */
public final class AppsVerticalView extends FrameLayout {

    /** What the pager does with the icons of this list. */
    interface Host {
        void onIconClick(View icon);

        boolean onIconLongClick(View icon);

        void onIconTouch(View icon, android.view.MotionEvent event);

        PagedViewIcon.PressedCallback pressedCallback();
    }

    /** How an item view is made and filled: the pager's icon, or another in a test. */
    interface IconBinder {
        View create(ViewGroup parent);

        void bind(View icon, AppInfo info, Host host);
    }

    private final RecyclerView mList;
    private final LetterScroller mScroller;
    private final GridLayoutManager mManager;
    private final Adapter mAdapter = new Adapter();
    private final List<AppInfo> mApps = new ArrayList<>();
    private final List<String> mTitles = new ArrayList<>();
    private Host mHost;
    private IconBinder mBinder = new PagerIcons();
    private int mColumns = 4;
    private int mRows = 7;

    public AppsVerticalView(Context context) {
        this(context, null);
    }

    public AppsVerticalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClipChildren(false);
        mList = new RecyclerView(context);
        mManager = new GridLayoutManager(context, mColumns);
        mList.setLayoutManager(mManager);
        mList.setAdapter(mAdapter);
        mList.setClipToPadding(false);
        mList.setOverScrollMode(OVER_SCROLL_NEVER);
        mList.setHasFixedSize(true);
        mList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                int first = mManager.findFirstVisibleItemPosition();
                if (first >= 0) {
                    mScroller.setCurrent(LetterIndex.letterAt(mTitles, first));
                }
            }
        });
        addView(mList, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        mScroller = new LetterScroller(context);
        mScroller.setListener(this::scrollToLetter);
        addView(mScroller, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.END));
    }

    void setHost(Host host) {
        mHost = host;
    }

    void setBinder(IconBinder binder) {
        mBinder = binder;
        mAdapter.notifyDataSetChanged();
    }

    /** The columns and the rows in view ("App drawer: Columns" and "Rows"). */
    void setGrid(int columns, int rows) {
        int c = Math.max(1, columns);
        int r = Math.max(1, rows);
        if (c != mColumns || r != mRows) {
            mColumns = c;
            mRows = r;
            mManager.setSpanCount(c);
            mAdapter.notifyDataSetChanged();
        }
    }

    /** The padding of the list, as the pages of the pager have theirs. */
    void setContentPadding(int left, int top, int right, int bottom) {
        mList.setPadding(left, top, right, bottom);
    }

    /** The apps of the drawer, sorted as the pager keeps them; the letters of the scroller follow. */
    void setApps(List<AppInfo> apps) {
        mApps.clear();
        mTitles.clear();
        for (AppInfo info : apps) {
            mApps.add(info);
            mTitles.add(info.title == null ? "" : info.title.toString());
        }
        mScroller.setAlphabet(LetterIndex.alphabet(mTitles));
        mAdapter.notifyDataSetChanged();
    }

    int itemCount() {
        return mApps.size();
    }

    int columns() {
        return mColumns;
    }

    /** The list back at its top (the drawer was closed). */
    void scrollToTop() {
        mList.scrollToPosition(0);
        mScroller.setCurrent(LetterIndex.letterAt(mTitles, 0));
    }

    /** The finger on the scroller is on a letter: the list goes to the row of its first app. */
    void scrollToLetter(String letter) {
        int position = LetterIndex.positionOf(mTitles, letter);
        if (position >= 0) {
            mManager.scrollToPositionWithOffset(position, 0);
        }
    }

    /** The first position of the list that shows (a test asks). */
    int firstVisible() {
        return mManager.findFirstVisibleItemPosition();
    }

    RecyclerView list() {
        return mList;
    }

    LetterScroller scroller() {
        return mScroller;
    }

    private int itemHeight() {
        int room = mList.getHeight() - mList.getPaddingTop() - mList.getPaddingBottom();
        return room > 0 ? Math.max(1, room / mRows) : ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    private final class Holder extends RecyclerView.ViewHolder {
        Holder(View view) {
            super(view);
        }
    }

    private final class Adapter extends RecyclerView.Adapter<Holder> {
        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View icon = mBinder.create(parent);
            icon.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, itemHeight()));
            return new Holder(icon);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            int height = itemHeight();
            if (lp != null && lp.height != height) {
                lp.height = height;
                holder.itemView.setLayoutParams(lp);
            }
            mBinder.bind(holder.itemView, mApps.get(position), mHost);
        }

        @Override
        public int getItemCount() {
            return mApps.size();
        }
    }

    /** The pager's own icons: the layout, the click, the long press and the touch of the pager. */
    private final class PagerIcons implements IconBinder {
        @Override
        public View create(ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.apps_customize_application, parent, false);
        }

        @Override
        public void bind(View icon, AppInfo info, Host host) {
            PagedViewIcon view = (PagedViewIcon) icon;
            view.applyFromApplicationInfo(info, true, host == null ? null : host.pressedCallback());
            if (host != null) {
                view.setOnClickListener(host::onIconClick);
                view.setOnLongClickListener(host::onIconLongClick);
                view.setOnTouchListener((v, e) -> {
                    host.onIconTouch(v, e);
                    return false;
                });
            }
        }
    }
}
