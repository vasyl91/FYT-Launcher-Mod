package com.android.launcher66;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabWidget;

public class FocusOnlyTabWidget extends TabWidget {
    public FocusOnlyTabWidget(Context context) {
        super(context);
    }

    public FocusOnlyTabWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FocusOnlyTabWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public View getSelectedTab() {
        int count = getTabCount();
        for (int i = 0; i < count; i++) {
            View v = getChildTabViewAt(i);
            if (v.isSelected()) {
                return v;
            }
        }
        return null;
    }

    public int getChildTabIndex(View v) {
        int tabCount = getTabCount();
        for (int i = 0; i < tabCount; i++) {
            if (getChildTabViewAt(i) == v) {
                return i;
            }
        }
        return -1;
    }

    public void setCurrentTabToFocusedTab() {
        View tab = null;
        int index = -1;
        int count = getTabCount();
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            View v = getChildTabViewAt(i);
            if (!v.hasFocus()) {
                i++;
            } else {
                tab = v;
                index = i;
                break;
            }
        }
        if (index > -1) {
            super.setCurrentTab(index);
            super.onFocusChange(tab, true);
        }
    }

    public void superOnFocusChange(View v, boolean hasFocus) {
        super.onFocusChange(v, hasFocus);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == this && hasFocus && getTabCount() > 0) {
            getSelectedTab().requestFocus();
        }
    }
}
