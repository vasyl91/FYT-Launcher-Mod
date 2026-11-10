package com.yanzhenjie.recyclerview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.yanzhenjie.recyclerview.x.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DefaultLoadMoreView extends LinearLayout implements SwipeRecyclerView.LoadMoreView, View.OnClickListener {
    private SwipeRecyclerView.LoadMoreListener mLoadMoreListener;
    private ProgressBar mProgressBar;
    private TextView mTvMessage;

    public DefaultLoadMoreView(Context context) {
        this(context, null);
    }

    public DefaultLoadMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setGravity(17);
        setVisibility(8);
        setMinimumHeight((int) (((double) (getResources().getDisplayMetrics().density * 60.0f)) + 0.5d));
        inflate(getContext(), R.layout.x_recycler_view_load_more, this);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.mTvMessage = (TextView) findViewById(R.id.tv_load_more_message);
        setOnClickListener(this);
    }

    @Override // com.yanzhenjie.recyclerview.SwipeRecyclerView.LoadMoreView
    public void onLoading() {
        setVisibility(0);
        this.mProgressBar.setVisibility(0);
        this.mTvMessage.setVisibility(0);
        this.mTvMessage.setText(R.string.x_recycler_load_more_message);
    }

    @Override // com.yanzhenjie.recyclerview.SwipeRecyclerView.LoadMoreView
    public void onLoadFinish(boolean z, boolean z2) {
        if (!z2) {
            setVisibility(0);
            if (z) {
                this.mProgressBar.setVisibility(8);
                this.mTvMessage.setVisibility(0);
                this.mTvMessage.setText(R.string.x_recycler_data_empty);
                return;
            } else {
                this.mProgressBar.setVisibility(8);
                this.mTvMessage.setVisibility(0);
                this.mTvMessage.setText(R.string.x_recycler_more_not);
                return;
            }
        }
        setVisibility(4);
    }

    @Override // com.yanzhenjie.recyclerview.SwipeRecyclerView.LoadMoreView
    public void onWaitToLoadMore(SwipeRecyclerView.LoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
        setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.mTvMessage.setVisibility(0);
        this.mTvMessage.setText(R.string.x_recycler_click_load_more);
    }

    @Override // com.yanzhenjie.recyclerview.SwipeRecyclerView.LoadMoreView
    public void onLoadError(int i, String str) {
        setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.mTvMessage.setVisibility(0);
        TextView textView = this.mTvMessage;
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(R.string.x_recycler_load_error);
        }
        textView.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SwipeRecyclerView.LoadMoreListener loadMoreListener = this.mLoadMoreListener;
        if (loadMoreListener != null) {
            loadMoreListener.onLoadMore();
        }
    }
}
