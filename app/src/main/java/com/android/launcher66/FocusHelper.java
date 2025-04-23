package com.android.launcher66;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FocusHelper {
    private static TabHost findTabHostParent(View v) {
        ViewParent p = v.getParent();
        while (p != null && !(p instanceof TabHost)) {
            p = p.getParent();
        }
        return (TabHost) p;
    }

    static boolean handleAppsCustomizeTabKeyEvent(View v, int keyCode, KeyEvent e) {
        final TabHost tabHost = findTabHostParent(v);
        final ViewGroup contents = tabHost.getTabContentView();
        final View shop = tabHost.findViewById(R.id.market_button);

        final int action = e.getAction();
        final boolean handleKeyEvent = (action != KeyEvent.ACTION_UP);
        boolean wasHandled = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (handleKeyEvent) {
                    // Select the shop button if we aren't on it
                    if (v != shop) {
                        shop.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (handleKeyEvent) {
                    // Select the content view (down is handled by the tab key handler otherwise)
                    if (v == shop) {
                        contents.requestFocus();
                        wasHandled = true;
                    }
                }
                break;
            default: break;
        }
        return wasHandled;
    }

    private static ViewGroup getAppsCustomizePage(ViewGroup container, int index) {
        ViewGroup page = (ViewGroup) ((PagedView) container).getPageAt(index);
        if (page instanceof CellLayout) {
            return ((CellLayout) page).getShortcutsAndWidgets();
        }
        return page;
    }

    static boolean handlePagedViewGridLayoutWidgetKeyEvent(PagedViewWidget w, int keyCode,
            KeyEvent e) {

        final PagedViewGridLayout parent = (PagedViewGridLayout) w.getParent();
        final PagedView container = (PagedView) parent.getParent();
        final TabHost tabHost = findTabHostParent(container);
        final TabWidget tabs = tabHost.getTabWidget();
        final int widgetIndex = parent.indexOfChild(w);
        final int widgetCount = parent.getChildCount();
        final int pageIndex = ((PagedView) container).indexToPage(container.indexOfChild(parent));
        final int pageCount = container.getChildCount();
        final int cellCountX = parent.getCellCountX();
        final int cellCountY = parent.getCellCountY();
        final int x = widgetIndex % cellCountX;
        final int y = widgetIndex / cellCountX;

        final int action = e.getAction();
        final boolean handleKeyEvent = (action != KeyEvent.ACTION_UP);
        ViewGroup newParent = null;
        // Now that we load items in the bg asynchronously, we can't just focus
        // child siblings willy-nilly
        View child = null;
        boolean wasHandled = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (handleKeyEvent) {
                    // Select the previous widget or the last widget on the previous page
                    if (widgetIndex > 0) {
                        parent.getChildAt(widgetIndex - 1).requestFocus();
                    } else {
                        if (pageIndex > 0) {
                            newParent = getAppsCustomizePage(container, pageIndex - 1);
                            if (newParent != null) {
                                child = newParent.getChildAt(newParent.getChildCount() - 1);
                                if (child != null) child.requestFocus();
                            }
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (handleKeyEvent) {
                    // Select the next widget or the first widget on the next page
                    if (widgetIndex < (widgetCount - 1)) {
                        parent.getChildAt(widgetIndex + 1).requestFocus();
                    } else {
                        if (pageIndex < (pageCount - 1)) {
                            newParent = getAppsCustomizePage(container, pageIndex + 1);
                            if (newParent != null) {
                                child = newParent.getChildAt(0);
                                if (child != null) child.requestFocus();
                            }
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (handleKeyEvent) {
                    // Select the closest icon in the previous row, otherwise select the tab bar
                    if (y > 0) {
                        int newWidgetIndex = ((y - 1) * cellCountX) + x;
                        child = parent.getChildAt(newWidgetIndex);
                        if (child != null) child.requestFocus();
                    } else {
                        tabs.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (handleKeyEvent) {
                    // Select the closest icon in the previous row, otherwise do nothing
                    if (y < (cellCountY - 1)) {
                        int newWidgetIndex = Math.min(widgetCount - 1, ((y + 1) * cellCountX) + x);
                        child = parent.getChildAt(newWidgetIndex);
                        if (child != null) child.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                if (handleKeyEvent) {
                    // Simulate a click on the widget
                    View.OnClickListener clickListener = (View.OnClickListener) container;
                    clickListener.onClick(w);
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_PAGE_UP:
                if (handleKeyEvent) {
                    // Select the first item on the previous page, or the first item on this page
                    // if there is no previous page
                    if (pageIndex > 0) {
                        newParent = getAppsCustomizePage(container, pageIndex - 1);
                        if (newParent != null) {
                            child = newParent.getChildAt(0);
                        }
                    } else {
                        child = parent.getChildAt(0);
                    }
                    if (child != null) child.requestFocus();
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_PAGE_DOWN:
                if (handleKeyEvent) {
                    // Select the first item on the next page, or the last item on this page
                    // if there is no next page
                    if (pageIndex < (pageCount - 1)) {
                        newParent = getAppsCustomizePage(container, pageIndex + 1);
                        if (newParent != null) {
                            child = newParent.getChildAt(0);
                        }
                    } else {
                        child = parent.getChildAt(widgetCount - 1);
                    }
                    if (child != null) child.requestFocus();
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_HOME:
                if (handleKeyEvent) {
                    // Select the first item on this page
                    child = parent.getChildAt(0);
                    if (child != null) child.requestFocus();
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_END:
                if (handleKeyEvent) {
                    // Select the last item on this page
                    parent.getChildAt(widgetCount - 1).requestFocus();
                }
                wasHandled = true;
                break;
            default: break;
        }
        return wasHandled;
    }

    static boolean handleAppsCustomizeKeyEvent(View v, int keyCode, KeyEvent e) {
        ViewGroup parentLayout;
        ViewGroup itemContainer;
        int countX;
        int countY;
        if (v.getParent() instanceof ShortcutAndWidgetContainer) {
            itemContainer = (ViewGroup) v.getParent();
            parentLayout = (ViewGroup) itemContainer.getParent();
            countX = ((CellLayout) parentLayout).getCountX();
            countY = ((CellLayout) parentLayout).getCountY();
        } else {
            itemContainer = parentLayout = (ViewGroup) v.getParent();
            countX = ((PagedViewGridLayout) parentLayout).getCellCountX();
            countY = ((PagedViewGridLayout) parentLayout).getCellCountY();
        }

        // Note we have an extra parent because of the
        // PagedViewCellLayout/PagedViewCellLayoutChildren relationship
        final PagedView container = (PagedView) parentLayout.getParent();
        final TabHost tabHost = findTabHostParent(container);
        final TabWidget tabs = tabHost.getTabWidget();
        final int iconIndex = itemContainer.indexOfChild(v);
        final int itemCount = itemContainer.getChildCount();
        final int pageIndex = ((PagedView) container).indexToPage(container.indexOfChild(parentLayout));
        final int pageCount = container.getChildCount();

        final int x = iconIndex % countX;
        final int y = iconIndex / countX;

        final int action = e.getAction();
        final boolean handleKeyEvent = (action != KeyEvent.ACTION_UP);
        ViewGroup newParent = null;
        // Side pages do not always load synchronously, so check before focusing child siblings
        // willy-nilly
        View child = null;
        boolean wasHandled = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (handleKeyEvent) {
                    // Select the previous icon or the last icon on the previous page
                    if (iconIndex > 0) {
                        itemContainer.getChildAt(iconIndex - 1).requestFocus();
                    } else {
                        if (pageIndex > 0) {
                            newParent = getAppsCustomizePage(container, pageIndex - 1);
                            if (newParent != null) {
                                container.snapToPage(pageIndex - 1);
                                child = newParent.getChildAt(newParent.getChildCount() - 1);
                                if (child != null) child.requestFocus();
                            }
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (handleKeyEvent) {
                    // Select the next icon or the first icon on the next page
                    if (iconIndex < (itemCount - 1)) {
                        itemContainer.getChildAt(iconIndex + 1).requestFocus();
                    } else {
                        if (pageIndex < (pageCount - 1)) {
                            newParent = getAppsCustomizePage(container, pageIndex + 1);
                            if (newParent != null) {
                                container.snapToPage(pageIndex + 1);
                                child = newParent.getChildAt(0);
                                if (child != null) child.requestFocus();
                            }
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (handleKeyEvent) {
                    // Select the closest icon in the previous row, otherwise select the tab bar
                    if (y > 0) {
                        int newiconIndex = ((y - 1) * countX) + x;
                        itemContainer.getChildAt(newiconIndex).requestFocus();
                    } else {
                        tabs.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (handleKeyEvent) {
                    // Select the closest icon in the previous row, otherwise do nothing
                    if (y < (countY - 1)) {
                        int newiconIndex = Math.min(itemCount - 1, ((y + 1) * countX) + x);
                        itemContainer.getChildAt(newiconIndex).requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                if (handleKeyEvent) {
                    // Simulate a click on the icon
                    View.OnClickListener clickListener = (View.OnClickListener) container;
                    clickListener.onClick(v);
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_PAGE_UP:
                if (handleKeyEvent) {
                    // Select the first icon on the previous page, or the first icon on this page
                    // if there is no previous page
                    if (pageIndex > 0) {
                        newParent = getAppsCustomizePage(container, pageIndex - 1);
                        if (newParent != null) {
                            container.snapToPage(pageIndex - 1);
                            child = newParent.getChildAt(0);
                            if (child != null) child.requestFocus();
                        }
                    } else {
                        itemContainer.getChildAt(0).requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_PAGE_DOWN:
                if (handleKeyEvent) {
                    // Select the first icon on the next page, or the last icon on this page
                    // if there is no next page
                    if (pageIndex < (pageCount - 1)) {
                        newParent = getAppsCustomizePage(container, pageIndex + 1);
                        if (newParent != null) {
                            container.snapToPage(pageIndex + 1);
                            child = newParent.getChildAt(0);
                            if (child != null) child.requestFocus();
                        }
                    } else {
                        itemContainer.getChildAt(itemCount - 1).requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_HOME:
                if (handleKeyEvent) {
                    // Select the first icon on this page
                    itemContainer.getChildAt(0).requestFocus();
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_END:
                if (handleKeyEvent) {
                    // Select the last icon on this page
                    itemContainer.getChildAt(itemCount - 1).requestFocus();
                }
                wasHandled = true;
                break;
            default: break;
        }
        return wasHandled;
    }

    static boolean handleTabKeyEvent(AccessibleTabView v, int keyCode, KeyEvent e) {
        if (!LauncherAppState.getInstance().isScreenLarge()) return false;

        final FocusOnlyTabWidget parent = (FocusOnlyTabWidget) v.getParent();
        final TabHost tabHost = findTabHostParent(parent);
        final ViewGroup contents = tabHost.getTabContentView();
        final int tabCount = parent.getTabCount();
        final int tabIndex = parent.getChildTabIndex(v);

        final int action = e.getAction();
        final boolean handleKeyEvent = (action != KeyEvent.ACTION_UP);
        boolean wasHandled = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (handleKeyEvent) {
                    // Select the previous tab
                    if (tabIndex > 0) {
                        parent.getChildTabViewAt(tabIndex - 1).requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (handleKeyEvent) {
                    // Select the next tab, or if the last tab has a focus right id, select that
                    if (tabIndex < (tabCount - 1)) {
                        parent.getChildTabViewAt(tabIndex + 1).requestFocus();
                    } else {
                        if (v.getNextFocusRightId() != View.NO_ID) {
                            tabHost.findViewById(v.getNextFocusRightId()).requestFocus();
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                // Do nothing
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (handleKeyEvent) {
                    // Select the content view
                    contents.requestFocus();
                }
                wasHandled = true;
                break;
            default: break;
        }
        return wasHandled;
    }

    static boolean handleHotseatButtonKeyEvent(View v, int keyCode, KeyEvent e, int orientation) {
        final ViewGroup parent = (ViewGroup) v.getParent();
        final ViewGroup launcher = (ViewGroup) parent.getParent();
        final Workspace workspace = (Workspace) launcher.findViewById(R.id.workspace);
        final int buttonIndex = parent.indexOfChild(v);
        final int buttonCount = parent.getChildCount();
        final int pageIndex = workspace.getCurrentPage();

        // NOTE: currently we don't special case for the phone UI in different
        // orientations, even though the hotseat is on the side in landscape mode.  This
        // is to ensure that accessibility consistency is maintained across rotations.

        final int action = e.getAction();
        final boolean handleKeyEvent = (action != KeyEvent.ACTION_UP);
        boolean wasHandled = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (handleKeyEvent) {
                    // Select the previous button, otherwise snap to the previous page
                    if (buttonIndex > 0) {
                        parent.getChildAt(buttonIndex - 1).requestFocus();
                    } else {
                        workspace.snapToPage(pageIndex - 1);
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (handleKeyEvent) {
                    // Select the next button, otherwise snap to the next page
                    if (buttonIndex < (buttonCount - 1)) {
                        parent.getChildAt(buttonIndex + 1).requestFocus();
                    } else {
                        workspace.snapToPage(pageIndex + 1);
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (handleKeyEvent) {
                    // Select the first bubble text view in the current page of the workspace
                    final CellLayout layout = (CellLayout) workspace.getChildAt(pageIndex);
                    final ShortcutAndWidgetContainer children = layout.getShortcutsAndWidgets();
                    final View newIcon = getIconInDirection(layout, children, -1, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    } else {
                        workspace.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                // Do nothing
                wasHandled = true;
                break;
            default: break;
        }
        return wasHandled;
    }

    private static ShortcutAndWidgetContainer getCellLayoutChildrenForIndex(ViewGroup container, int i) {
        ViewGroup parent = (ViewGroup) container.getChildAt(i);
        return (ShortcutAndWidgetContainer) parent.getChildAt(0);
    }

    private static ArrayList<View> getCellLayoutChildrenSortedSpatially(CellLayout layout, ViewGroup parent) {
        final int cellCountX = layout.getCountX();
        int count = parent.getChildCount();
        ArrayList<View> views = new ArrayList<>();
        for (int j = 0; j < count; j++) {
            views.add(parent.getChildAt(j));
        }
        Collections.sort(views, new Comparator<View>() { 
            @Override
            public int compare(View lhs, View rhs) {
                CellLayout.LayoutParams llp = (CellLayout.LayoutParams) lhs.getLayoutParams();
                CellLayout.LayoutParams rlp = (CellLayout.LayoutParams) rhs.getLayoutParams();
                int lvIndex = (llp.cellY * cellCountX) + llp.cellX;
                int rvIndex = (rlp.cellY * cellCountX) + rlp.cellX;
                return lvIndex - rvIndex;
            }
        });
        return views;
    }

    private static View findIndexOfIcon(ArrayList<View> views, int i, int delta) {
        int count = views.size();
        int newI = i + delta;
        while (newI >= 0 && newI < count) {
            View newV = views.get(newI);
            if ((newV instanceof BubbleTextView) || (newV instanceof FolderIcon)) {
                return newV;
            }
            newI += delta;
        }
        return null;
    }

    private static View getIconInDirection(CellLayout layout, ViewGroup parent, int i, int delta) {
        ArrayList<View> views = getCellLayoutChildrenSortedSpatially(layout, parent);
        return findIndexOfIcon(views, i, delta);
    }

    private static View getIconInDirection(CellLayout layout, ViewGroup parent, View v, int delta) {
        ArrayList<View> views = getCellLayoutChildrenSortedSpatially(layout, parent);
        return findIndexOfIcon(views, views.indexOf(v), delta);
    }

    private static View getClosestIconOnLine(CellLayout layout, ViewGroup parent, View v, int lineDelta) {
        boolean satisfiesRow;
        ArrayList<View> views = getCellLayoutChildrenSortedSpatially(layout, parent);
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) v.getLayoutParams();
        int cellCountY = layout.getCountY();
        int row = lp.cellY;
        int newRow = row + lineDelta;
        if (newRow >= 0 && newRow < cellCountY) {
            float closestDistance = Float.MAX_VALUE;
            int closestIndex = -1;
            int index = views.indexOf(v);
            int endIndex = lineDelta < 0 ? -1 : views.size();
            while (index != endIndex) {
                View newV = views.get(index);
                CellLayout.LayoutParams tmpLp = (CellLayout.LayoutParams) newV.getLayoutParams();
                if (lineDelta < 0) {
                    satisfiesRow = tmpLp.cellY < row;
                } else {
                    satisfiesRow = tmpLp.cellY > row;
                }
                if (satisfiesRow && ((newV instanceof BubbleTextView) || (newV instanceof FolderIcon))) {
                    float tmpDistance = (float) Math.sqrt(Math.pow(tmpLp.cellX - lp.cellX, 2.0d) + Math.pow(tmpLp.cellY - lp.cellY, 2.0d));
                    if (tmpDistance < closestDistance) {
                        closestIndex = index;
                        closestDistance = tmpDistance;
                    }
                }
                if (index <= endIndex) {
                    index++;
                } else {
                    index--;
                }
            }
            if (closestIndex > -1) {
                return views.get(closestIndex);
            }
        }
        return null;
    }

    static boolean handleIconKeyEvent(View v, int keyCode, KeyEvent e) {
        ShortcutAndWidgetContainer parent = (ShortcutAndWidgetContainer) v.getParent();
        final CellLayout layout = (CellLayout) parent.getParent();
        final Workspace workspace = (Workspace) layout.getParent();
        final ViewGroup launcher = (ViewGroup) workspace.getParent();
        final ViewGroup tabs = (ViewGroup) launcher.findViewById(R.id.qsb_bar);
        final ViewGroup hotseat = (ViewGroup) launcher.findViewById(R.id.hotseat);
        int pageIndex = workspace.indexOfChild(layout);
        int pageCount = workspace.getChildCount();

        final int action = e.getAction();
        final boolean handleKeyEvent = (action != KeyEvent.ACTION_UP);
        boolean wasHandled = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (handleKeyEvent) {
                    // Select the previous icon or the last icon on the previous page if possible
                    View newIcon = getIconInDirection(layout, parent, v, -1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    } else {
                        if (pageIndex > 0) {
                            parent = getCellLayoutChildrenForIndex(workspace, pageIndex - 1);
                            newIcon = getIconInDirection(layout, parent,
                                    parent.getChildCount(), -1);
                            if (newIcon != null) {
                                newIcon.requestFocus();
                            } else {
                                // Snap to the previous page
                                workspace.snapToPage(pageIndex - 1);
                            }
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (handleKeyEvent) {
                    // Select the next icon or the first icon on the next page if possible
                    View newIcon = getIconInDirection(layout, parent, v, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    } else {
                        if (pageIndex < (pageCount - 1)) {
                            parent = getCellLayoutChildrenForIndex(workspace, pageIndex + 1);
                            newIcon = getIconInDirection(layout, parent, -1, 1);
                            if (newIcon != null) {
                                newIcon.requestFocus();
                            } else {
                                // Snap to the next page
                                workspace.snapToPage(pageIndex + 1);
                            }
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (handleKeyEvent) {
                    // Select the closest icon in the previous line, otherwise select the tab bar
                    View newIcon = getClosestIconOnLine(layout, parent, v, -1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                        wasHandled = true;
                    } else {
                        tabs.requestFocus();
                    }
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (handleKeyEvent) {
                    // Select the closest icon in the next line, otherwise select the button bar
                    View newIcon = getClosestIconOnLine(layout, parent, v, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                        wasHandled = true;
                    } else if (hotseat != null) {
                        hotseat.requestFocus();
                    }
                }
                break;
            case KeyEvent.KEYCODE_PAGE_UP:
                if (handleKeyEvent) {
                    // Select the first icon on the previous page or the first icon on this page
                    // if there is no previous page
                    if (pageIndex > 0) {
                        parent = getCellLayoutChildrenForIndex(workspace, pageIndex - 1);
                        View newIcon = getIconInDirection(layout, parent, -1, 1);
                        if (newIcon != null) {
                            newIcon.requestFocus();
                        } else {
                            // Snap to the previous page
                            workspace.snapToPage(pageIndex - 1);
                        }
                    } else {
                        View newIcon = getIconInDirection(layout, parent, -1, 1);
                        if (newIcon != null) {
                            newIcon.requestFocus();
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_PAGE_DOWN:
                if (handleKeyEvent) {
                    // Select the first icon on the next page or the last icon on this page
                    // if there is no previous page
                    if (pageIndex < (pageCount - 1)) {
                        parent = getCellLayoutChildrenForIndex(workspace, pageIndex + 1);
                        View newIcon = getIconInDirection(layout, parent, -1, 1);
                        if (newIcon != null) {
                            newIcon.requestFocus();
                        } else {
                            // Snap to the next page
                            workspace.snapToPage(pageIndex + 1);
                        }
                    } else {
                        View newIcon = getIconInDirection(layout, parent,
                                parent.getChildCount(), -1);
                        if (newIcon != null) {
                            newIcon.requestFocus();
                        }
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_HOME:
                if (handleKeyEvent) {
                    // Select the first icon on this page
                    View newIcon = getIconInDirection(layout, parent, -1, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_END:
                if (handleKeyEvent) {
                    // Select the last icon on this page
                    View newIcon = getIconInDirection(layout, parent,
                            parent.getChildCount(), -1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            default: break;
        }
        return wasHandled;
    }

    static boolean handleFolderKeyEvent(View v, int keyCode, KeyEvent e) {
        ShortcutAndWidgetContainer parent = (ShortcutAndWidgetContainer) v.getParent();
        final CellLayout layout = (CellLayout) parent.getParent();
        final ScrollView scrollView = (ScrollView) layout.getParent();
        final Folder folder = (Folder) scrollView.getParent();
        View title = folder.mFolderName;

        final int action = e.getAction();
        final boolean handleKeyEvent = (action != KeyEvent.ACTION_UP);
        boolean wasHandled = false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (handleKeyEvent) {
                    // Select the previous icon
                    View newIcon = getIconInDirection(layout, parent, v, -1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (handleKeyEvent) {
                    // Select the next icon
                    View newIcon = getIconInDirection(layout, parent, v, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    } else {
                        title.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (handleKeyEvent) {
                    // Select the closest icon in the previous line
                    View newIcon = getClosestIconOnLine(layout, parent, v, -1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (handleKeyEvent) {
                    // Select the closest icon in the next line
                    View newIcon = getClosestIconOnLine(layout, parent, v, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    } else {
                        title.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_HOME:
                if (handleKeyEvent) {
                    // Select the first icon on this page
                    View newIcon = getIconInDirection(layout, parent, -1, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            case KeyEvent.KEYCODE_MOVE_END:
                if (handleKeyEvent) {
                    // Select the last icon on this page
                    View newIcon = getIconInDirection(layout, parent,
                            parent.getChildCount(), -1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    }
                }
                wasHandled = true;
                break;
            default: break;
        }
        return wasHandled;
    }
}
