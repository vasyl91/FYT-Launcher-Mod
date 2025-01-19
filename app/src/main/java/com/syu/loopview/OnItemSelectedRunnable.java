package com.syu.loopview;

final class OnItemSelectedRunnable implements Runnable {
    final LoopView loopView;

    OnItemSelectedRunnable(LoopView loopview) {
        this.loopView = loopview;
    }

    @Override
    public final void run() {
        this.loopView.onItemSelectedListener.onItemSelected(this.loopView.getSelectedItem());
    }
}
