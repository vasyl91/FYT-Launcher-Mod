package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeightWatcher extends LinearLayout {
    private static final int BACKGROUND_COLOR = Color.parseColor("#400000");
    private static final int MSG_START = 1;
    private static final int MSG_STOP = 2;
    private static final int MSG_UPDATE = 3;
    private static final int RAM_GRAPH_PSS_COLOR = Color.parseColor("#663400");
    private static final int RAM_GRAPH_RSS_COLOR = Color.parseColor("#670000");
    private static final int TEXT_COLOR = -1;
    private static final int UPDATE_RATE = 5000;
    Handler mHandler;
    private MemoryTracker mMemoryService;

    static int indexOf(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public WeightWatcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message m) {
                switch (m.what) {
                    case 1:
                        WeightWatcher.this.mHandler.sendEmptyMessage(3);
                        break;
                    case 2:
                        WeightWatcher.this.mHandler.removeMessages(3);
                        break;
                    case 3:
                        int[] pids = WeightWatcher.this.mMemoryService.getTrackedProcesses();
                        int N = WeightWatcher.this.getChildCount();
                        if (pids.length != N) {
                            WeightWatcher.this.initViews();
                        } else {
                            int i = 0;
                            while (true) {
                                if (i < N) {
                                    ProcessWatcher pw = (ProcessWatcher) WeightWatcher.this.getChildAt(i);
                                    if (WeightWatcher.indexOf(pids, pw.getPid()) < 0) {
                                        WeightWatcher.this.initViews();
                                    } else {
                                        pw.update();
                                        i++;
                                    }
                                }
                            }
                        }
                        WeightWatcher.this.mHandler.sendEmptyMessageDelayed(3, 5000L);
                        break;
                }
            }
        };
        ServiceConnection connection = new ServiceConnection() { 
            @Override
            public void onServiceConnected(ComponentName className, IBinder service) {
                WeightWatcher.this.mMemoryService = ((MemoryTracker.MemoryTrackerInterface) service).getService();
                WeightWatcher.this.initViews();
            }

            @Override
            public void onServiceDisconnected(ComponentName className) {
                WeightWatcher.this.mMemoryService = null;
            }
        };
        context.bindService(new Intent(context, (Class<?>) MemoryTracker.class), connection, 1);
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(BACKGROUND_COLOR);
    }

    public void initViews() {
        removeAllViews();
        int[] processes = this.mMemoryService.getTrackedProcesses();
        for (int i : processes) {
            ProcessWatcher v = new ProcessWatcher(this, getContext());
            v.setPid(i);
            addView(v);
        }
    }

    public WeightWatcher(Context context) {
        this(context, null);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mHandler.sendEmptyMessage(1);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.sendEmptyMessage(2);
    }

    public class ProcessWatcher extends LinearLayout {
        private MemoryTracker.ProcessMemInfo mMemInfo;
        int mPid;
        GraphView mRamGraph;
        TextView mText;

        public ProcessWatcher(WeightWatcher weightWatcher, Context context) {
            this(context, null);
        }

        public ProcessWatcher(Context context, AttributeSet attrs) {
            super(context, attrs);
            float dp = getResources().getDisplayMetrics().density;
            this.mText = new TextView(getContext());
            this.mText.setTextColor(-1);
            this.mText.setTextSize(0, 10.0f * dp);
            this.mText.setGravity(19);
            int p = (int) (2.0f * dp);
            setPadding(p, 0, p, 0);
            this.mRamGraph = new GraphView(this, getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, (int) (14.0f * dp), 1.0f);
            addView(this.mText, params);
            params.leftMargin = (int) (4.0f * dp);
            params.weight = 0.0f;
            params.width = (int) (200.0f * dp);
            addView(this.mRamGraph, params);
        }

        public void setPid(int pid) {
            this.mPid = pid;
            this.mMemInfo = WeightWatcher.this.mMemoryService.getMemInfo(this.mPid);
            if (this.mMemInfo == null) {
                Log.v("WeightWatcher", "Missing info for pid " + this.mPid + ", removing view: " + this);
                WeightWatcher.this.initViews();
            }
        }

        public int getPid() {
            return this.mPid;
        }

        public String getUptimeString() {
            long sec = this.mMemInfo.getUptime() / 1000;
            StringBuilder sb = new StringBuilder();
            long days = sec / 86400;
            if (days > 0) {
                sec -= 86400 * days;
                sb.append(days);
                sb.append("d");
            }
            long hours = sec / 3600;
            if (hours > 0) {
                sec -= 3600 * hours;
                sb.append(hours);
                sb.append("h");
            }
            long mins = sec / 60;
            if (mins > 0) {
                sec -= 60 * mins;
                sb.append(mins);
                sb.append("m");
            }
            sb.append(sec);
            sb.append("s");
            return sb.toString();
        }

        public void update() {
            String str;
            TextView textView = this.mText;
            StringBuilder append = new StringBuilder("(").append(this.mPid);
            if (this.mPid == Process.myPid()) {
                str = "/A";
            } else {
                str = "/S";
            }
            textView.setText(append.append(str).append(") up ").append(getUptimeString()).append(" P=").append(this.mMemInfo.currentPss).append(" U=").append(this.mMemInfo.currentUss).toString());
            this.mRamGraph.invalidate();
        }

        public class GraphView extends View {
            Paint headPaint;
            Paint pssPaint;
            Paint ussPaint;

            public GraphView(Context context, AttributeSet attrs) {
                super(context, attrs);
                this.pssPaint = new Paint();
                this.pssPaint.setColor(WeightWatcher.RAM_GRAPH_PSS_COLOR);
                this.ussPaint = new Paint();
                this.ussPaint.setColor(WeightWatcher.RAM_GRAPH_RSS_COLOR);
                this.headPaint = new Paint();
                this.headPaint.setColor(Color.parseColor("#000001"));
            }

            public GraphView(ProcessWatcher processWatcher, Context context) {
                this(context, null);
            }

            @Override
            public void onDraw(Canvas c) {
                int w = c.getWidth();
                int h = c.getHeight();
                if (ProcessWatcher.this.mMemInfo != null) {
                    int N = ProcessWatcher.this.mMemInfo.pss.length;
                    float barStep = w / N;
                    float barWidth = Math.max(1.0f, barStep);
                    float scale = h / ((float) ProcessWatcher.this.mMemInfo.max);
                    for (int i = 0; i < N; i++) {
                        float x = i * barStep;
                        c.drawRect(x, h - (((float) ProcessWatcher.this.mMemInfo.pss[i]) * scale), x + barWidth, h, this.pssPaint);
                        c.drawRect(x, h - (((float) ProcessWatcher.this.mMemInfo.uss[i]) * scale), x + barWidth, h, this.ussPaint);
                    }
                    float x2 = ProcessWatcher.this.mMemInfo.head * barStep;
                    c.drawRect(x2, 0.0f, x2 + barWidth, h, this.headPaint);
                }
            }
        }
    }
}
