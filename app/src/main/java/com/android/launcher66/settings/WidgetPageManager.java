package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.PreferenceManager;

import com.android.launcher66.CellLayout;
import com.android.launcher66.Launcher;
import com.android.launcher66.Workspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Manages widget page assignments and automatically relocates widgets to prevent gaps.
 */
public class WidgetPageManager {
    private static final String TAG = "WidgetPageManager";
    
    private final Context mContext;
    private final String mWidgetKey;
    
    /**
     * Callback interface for notifying when preferences are updated
     */
    public interface OnPreferencesUpdatedListener {
        void onPreferencesUpdated();
    }
    
    private OnPreferencesUpdatedListener mListener;
    
    // All widget keys that can be relocated
    private static final String[] ALL_WIDGET_KEYS = {
        Keys.MUSIC_SCREEN,
        Keys.DATE_SCREEN,
        Keys.RADIO_SCREEN,
        Keys.PIP_DUAL_SCREEN,
        Keys.PIP_FIRST_SCREEN,
        Keys.PIP_SECOND_SCREEN,
        Keys.PIP_THIRD_SCREEN,
        Keys.PIP_FOURTH_SCREEN,
        Keys.STATS_SCREEN
    };
    
    public WidgetPageManager(Context context, String widgetKey) {
        mContext = context;
        mWidgetKey = widgetKey;
    }
    
    /**
     * Set a listener to be notified when preferences are updated
     */
    public void setOnPreferencesUpdatedListener(OnPreferencesUpdatedListener listener) {
        mListener = listener;
    }
    
    /**
     * Validates and saves a new page number for the widget.
     * Automatically relocates other widgets to prevent gaps.
     * 
     * @param value The desired page number (1-based)
     * @return true if the value was saved, false if rejected
     */
    public boolean validateAndSavePage(int value) {
        // Clamp value between 1 and 99
        value = Math.max(1, Math.min(99, value));
        
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return false;
        
        Workspace workspace = launcher.getWorkspace();
        if (workspace == null) return false;
        
        int pageCount = workspace.getChildCount();
        int currentPageIndex = getCurrentWidgetPageIndex();
        int highestIndex = getHighestPageIndex();
        
        Log.i(TAG, "Current value: " + value + ", page count: " + pageCount + ", highest index: " + highestIndex);
        Log.i(TAG, "Key: " + mWidgetKey + ", located on page:" + (currentPageIndex + 1));
        
        // Adjust value if needed
        if (value > pageCount && value > highestIndex && pageCount >= highestIndex) {
            value = highestIndex + 2;
            Log.i(TAG, "New current value: " + value);
        }
        int newPageIndex = value - 1;
        
        // Cancel if widget is the only element on current page and trying to move to a NEW page beyond current count
        // BUT allow moving to existing pages or if it won't create a gap
        if (currentPageIndex >= 1 && currentPageIndex != newPageIndex) {
            Log.i(TAG, "Checking if widget is alone on page " + (currentPageIndex + 1));
            
            // Check if current page is the last page
            boolean isLastPage = (currentPageIndex + 1) == workspace.getChildCount();
            
            // Only block if:
            // 1. Moving to a NEW page that doesn't exist yet (newPageIndex >= pageCount)
            // 2. AND widget is alone on the last page
            // 3. AND moving would create a gap
            if (isLastPage && newPageIndex >= pageCount) {
                CellLayout currentLayout = (CellLayout) workspace.getChildAt(currentPageIndex);
                
                if (currentLayout != null) {
                    ViewGroup container = currentLayout.getShortcutsAndWidgets();
                    ArrayList<String> customContent = new ArrayList<>();
                    boolean regularContent = false;
                    
                    if (container != null) {
                        for (int i = 0; i < container.getChildCount(); i++) {
                            View child = container.getChildAt(i);
                            if (!currentLayout.isUserWidget(child)) {
                                regularContent = true;
                            }
                            if (currentLayout.isUserWidget(child)) {
                                String widgetName = currentLayout.getUserWidgetKey(child);
                                customContent.add(widgetName);
                            }
                        }
                    }
                    
                    // Check if this widget is alone on the page
                    if (!regularContent && customContent.size() == 1) {
                        if (customContent.get(0).equals(mWidgetKey) && !checkCustomElements(mWidgetKey)) {
                            // Check if the move would create a gap
                            if (wouldCreateGapWhenMovingFromLastPage(currentPageIndex, newPageIndex)) {
                                Log.i(TAG, "Cancelled page change: widget is the only element on last page (" + (currentPageIndex + 1) + "), and moving to page " + value + " would create a gap");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        // Apply the change and auto-relocate other widgets
        Log.i(TAG, "Apply pref value and relocate widgets if needed");
        return applyAndRelocateWidgets(newPageIndex);
    }
    
    /**
     * Applies the page change and automatically relocates other widgets to eliminate gaps.
     */
    private boolean applyAndRelocateWidgets(int newPageIndex) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
        if (sp == null) return false;
        
        // Get all current widget positions
        Map<String, Integer> widgetPositions = new HashMap<>();
        for (String key : ALL_WIDGET_KEYS) {
            int pageIndex = sp.getInt(key, 1) - 1;
            widgetPositions.put(key, pageIndex);
        }
        
        // Update the current widget's position
        widgetPositions.put(mWidgetKey, newPageIndex);
        
        // Get all pages that have regular content
        ArrayList<Integer> pagesWithRegularContent = getPagesWithRegularContent();
        
        // Combine widget pages and regular content pages
        ArrayList<Integer> allOccupiedPages = new ArrayList<>();
        allOccupiedPages.add(0); // Page 0 always exists
        allOccupiedPages.addAll(widgetPositions.values());
        allOccupiedPages.addAll(pagesWithRegularContent);
        
        // Remove duplicates and sort
        ArrayList<Integer> uniquePages = new ArrayList<>();
        for (Integer page : allOccupiedPages) {
            if (!uniquePages.contains(page) && page >= 0) {
                uniquePages.add(page);
            }
        }
        Collections.sort(uniquePages);
        
        Log.i(TAG, "Occupied pages before relocation: " + uniquePages);
        
        // Check if there are gaps
        boolean hasGaps = false;
        if (uniquePages.size() > 1) {
            int minPage = uniquePages.get(0);
            int maxPage = uniquePages.get(uniquePages.size() - 1);
            for (int page = minPage; page <= maxPage; page++) {
                if (!uniquePages.contains(page)) {
                    hasGaps = true;
                    Log.i(TAG, "Gap detected at page " + (page + 1));
                    break;
                }
            }
        }
        
        // If there are gaps, relocate widgets
        if (hasGaps) {
            Map<String, Integer> newPositions = relocateWidgetsToEliminateGaps(
                widgetPositions, pagesWithRegularContent);
            
            // Save all new positions
            SharedPreferences.Editor editor = sp.edit();
            for (Map.Entry<String, Integer> entry : newPositions.entrySet()) {
                int pageNumber = entry.getValue() + 1; // Convert to 1-based
                editor.putInt(entry.getKey(), pageNumber);
                Log.i(TAG, "Relocated " + entry.getKey() + " to page " + pageNumber);
            }
            editor.apply();
            
            // Notify listener that preferences were updated
            if (mListener != null) {
                mListener.onPreferencesUpdated();
            }
        } else {
            // No gaps, just save the current widget's position
            sp.edit().putInt(mWidgetKey, newPageIndex + 1).apply();
            Log.i(TAG, "No gaps detected, saved " + mWidgetKey + " to page " + (newPageIndex + 1));
        }
        
        return true;
    }
    
    /**
     * Relocates widgets to eliminate gaps between pages.
     */
    private Map<String, Integer> relocateWidgetsToEliminateGaps(
            Map<String, Integer> currentPositions, ArrayList<Integer> pagesWithRegularContent) {
        
        Map<String, Integer> newPositions = new HashMap<>(currentPositions);
        
        // Create a list of all occupied pages (widgets + regular content)
        ArrayList<Integer> allOccupied = new ArrayList<>();
        allOccupied.add(0); // Page 0 always exists
        allOccupied.addAll(currentPositions.values());
        allOccupied.addAll(pagesWithRegularContent);
        
        // Remove duplicates and sort
        ArrayList<Integer> uniqueOccupied = new ArrayList<>();
        for (Integer page : allOccupied) {
            if (!uniqueOccupied.contains(page) && page >= 0) {
                uniqueOccupied.add(page);
            }
        }
        Collections.sort(uniqueOccupied);
        
        // Create a mapping from old page indices to new consecutive indices
        Map<Integer, Integer> pageMapping = new HashMap<>();
        for (int i = 0; i < uniqueOccupied.size(); i++) {
            pageMapping.put(uniqueOccupied.get(i), i);
        }
        
        Log.i(TAG, "Page mapping for relocation: " + pageMapping);
        
        // Apply mapping to all widgets
        for (Map.Entry<String, Integer> entry : currentPositions.entrySet()) {
            String widgetKey = entry.getKey();
            int oldPage = entry.getValue();
            
            // Only relocate if this page is being compressed
            if (pageMapping.containsKey(oldPage)) {
                int newPage = pageMapping.get(oldPage);
                if (newPage != oldPage) {
                    newPositions.put(widgetKey, newPage);
                    Log.i(TAG, "Will relocate " + widgetKey + " from page " + 
                          (oldPage + 1) + " to page " + (newPage + 1));
                }
            }
        }
        
        return newPositions;
    }
    
    /**
     * Get all pages that have regular (non-widget) content.
     */
    private ArrayList<Integer> getPagesWithRegularContent() {
        ArrayList<Integer> pages = new ArrayList<>();
        
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return pages;
        
        Workspace workspace = launcher.getWorkspace();
        if (workspace == null) return pages;
        
        for (int i = 0; i < workspace.getChildCount(); i++) {
            CellLayout layout = (CellLayout) workspace.getChildAt(i);
            if (layout != null && hasRegularContent(layout)) {
                pages.add(i);
            }
        }
        
        return pages;
    }
    
    /**
     * Check if moving widget from the last page would create a gap.
     * This is specifically for when a widget is alone on the last page.
     */
    private boolean wouldCreateGapWhenMovingFromLastPage(int currentPageIndex, int newPageIndex) {
        if (currentPageIndex < 0 || currentPageIndex == newPageIndex) return false;
        
        // If moving to an earlier page or adjacent page, no gap is created
        if (newPageIndex <= currentPageIndex + 1) return false;
        
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
        if (sp == null) return false;
        
        Launcher launcher = Launcher.getLauncher();
        Workspace workspace = launcher != null ? launcher.getWorkspace() : null;
        
        // Collect all widget page indices AFTER this move
        ArrayList<Integer> occupiedPages = new ArrayList<>();
        
        // Page 0 is always considered occupied (has system content)
        occupiedPages.add(0);
        
        // Add all widget pages, simulating the move
        addWidgetPages(sp, occupiedPages, currentPageIndex, newPageIndex);
        
        // Check for physical pages with regular content
        if (workspace != null) {
            for (int i = 0; i < workspace.getChildCount(); i++) {
                // Skip the current page since we're moving away from it
                if (i == currentPageIndex) continue;
                
                CellLayout layout = (CellLayout) workspace.getChildAt(i);
                if (layout != null && hasRegularContent(layout)) {
                    occupiedPages.add(i);
                }
            }
        }
        
        // Remove duplicates and sort
        Set<Integer> uniquePages = new HashSet<>(occupiedPages);
        occupiedPages = new ArrayList<>(uniquePages);
        Collections.sort(occupiedPages);
        
        Log.i(TAG, "Simulated occupied pages after move from " + (currentPageIndex + 1) + " to " + (newPageIndex + 1) + ": " + occupiedPages);
        
        // Check for gaps: are there any missing pages between min and max?
        if (occupiedPages.size() < 2) {
            return false; // Can't have a gap with 0 or 1 occupied pages
        }
        
        int minPage = occupiedPages.get(0);
        int maxPage = occupiedPages.get(occupiedPages.size() - 1);
        
        for (int page = minPage; page <= maxPage; page++) {
            if (!occupiedPages.contains(page)) {
                Log.i(TAG, "Gap detected: page " + (page + 1) + " would be empty");
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Check if a page has regular (non-widget) content.
     */
    private boolean hasRegularContent(CellLayout layout) {
        ViewGroup container = layout.getShortcutsAndWidgets();
        if (container == null) return false;
        
        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);
            if (!layout.isUserWidget(child)) {
                return true; // Found regular content
            }
        }
        return false;
    }
    
    /**
     * Add all widget pages to the occupied list, simulating a move for one widget.
     */
    private void addWidgetPages(SharedPreferences sp, ArrayList<Integer> occupiedPages, 
                                int currentPageIndex, int newPageIndex) {
        // If this is the widget being moved, use the new page index
        if (mWidgetKey.equals(Keys.MUSIC_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.MUSIC_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.DATE_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.DATE_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.RADIO_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.RADIO_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.PIP_DUAL_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.PIP_DUAL_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.PIP_FIRST_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.PIP_FIRST_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.PIP_SECOND_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.PIP_SECOND_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.PIP_THIRD_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.PIP_THIRD_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.PIP_FOURTH_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.PIP_FOURTH_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
        
        if (mWidgetKey.equals(Keys.STATS_SCREEN)) {
            occupiedPages.add(newPageIndex);
        } else {
            int page = sp.getInt(Keys.STATS_SCREEN, 1) - 1;
            if (page >= 0) occupiedPages.add(page);
        }
    }
    
    /**
     * Get the current page index (0-based) for this widget.
     * 
     * @return The page index, or -1 if not found
     */
    public int getCurrentWidgetPageIndex() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
        if (sp == null) return -1;
        
        return sp.getInt(mWidgetKey, 1) - 1;
    }
    
    /**
     * Get the highest page index across all widgets.
     * 
     * @return The highest page index, or -1 if none found
     */
    private int getHighestPageIndex() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
        if (sp == null) return -1;
        
        ArrayList<Integer> screensPrefs = new ArrayList<>();
        
        for (String key : ALL_WIDGET_KEYS) {
            screensPrefs.add(sp.getInt(key, 1) - 1);
        }
        
        if (!screensPrefs.isEmpty()) {
            return Collections.max(screensPrefs);
        }
        return -1;
    }

    private boolean checkCustomElements(String mWidgetKey) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
        if (sp == null) return false;
        
        ArrayList<Integer> screensPrefs = new ArrayList<>();
        
        for (String key : ALL_WIDGET_KEYS) {
            screensPrefs.add(sp.getInt(key, 1) - 1);
        }
        
        if (!screensPrefs.contains(getCurrentWidgetPageIndex())) {
            return true;
        }
        return false;
    }
}