package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.activity.OnBackPressedCallback;
import androidx.preference.PreferenceManager;

import com.google.android.flexbox.FlexboxLayout;
import com.android.launcher66.R;

public class CreatorFragmentDrawView extends Fragment {

    // Fragment that opens DrawView.java where user can create the layout

    private final Helpers helpers = new Helpers();
    private Context mContext;
    private View rooView;
    private SharedPreferences sharedPrefs;

    int margin;
    int mapMinWidth = SettingsActivity.calculatedMapMinWidth;
    int mapMinHeight = SettingsActivity.calculatedMapMinHeight;
    int dateMinWidth = SettingsActivity.calculatedDateMinWidth;
    int dateMinHeight = SettingsActivity.calculatedDateMinHeight;
    int musicMinWidth = SettingsActivity.calculatedMusicMinWidth;
    int musicMinHeight = SettingsActivity.calculatedMusicMinHeight;
    int radioMinWidth = SettingsActivity.calculatedRadioMinWidth;
    int radioMinHeight = SettingsActivity.calculatedRadioMinHeight;
    int mapTopLeftX, mapTopLeftY, mapTopRightX, mapTopRightY, mapBottomRightX, mapBottomRightY, mapBottomLeftX, mapBottomLeftY;
    int dateTopLeftX, dateTopLeftY, dateTopRightX, dateTopRightY, dateBottomRightX, dateBottomRightY, dateBottomLeftX, dateBottomLeftY;
    int musicTopLeftX, musicTopLeftY, musicTopRightX, musicTopRightY, musicBottomRightX, musicBottomRightY, musicBottomLeftX, musicBottomLeftY;
    int radioTopLeftX, radioTopLeftY, radioTopRightX, radioTopRightY, radioBottomRightX, radioBottomRightY, radioBottomLeftX, radioBottomLeftY;

    boolean map, date, music, radio, stats; 
    boolean overlappingMargins = false;

    public CreatorFragmentDrawView() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        mContext = container.getContext();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        boolean leftBar = sharedPrefs.getBoolean("left_bar", false);
        map = sharedPrefs.getBoolean("user_map", false);
        date = sharedPrefs.getBoolean("user_date", true);
        music = sharedPrefs.getBoolean("user_music", true);
        radio = sharedPrefs.getBoolean("user_radio", true); 
        stats = sharedPrefs.getBoolean("user_stats", true);       
        checkIfOverlappingMargins();
        if (overlappingMargins) {
            resetPrefs();
        }
        if (leftBar) {
            if (helpers.hasLeftBarChanged()) {
                resetPrefs(); 
                helpers.setLeftBarChanged(false); 
            }            
            rooView = inflater.inflate(R.layout.creator_left, container, false);
        } else {
            rooView = inflater.inflate(R.layout.creator, container, false);
        }
        ConstraintLayout layout = rooView.findViewById(R.id.creator_second);
        DrawView canvas = new DrawView(inflater, rooView, mContext);
        layout.addView(canvas);
        return rooView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                helpers.setBackFromCreator(true);
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentSecond()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void resetPrefs() {
        margin = Integer.valueOf(sharedPrefs.getString("layout_margin", "10")); 
        if (margin < 0) {
            margin = 10;
        }
        SharedPreferences.Editor editor = sharedPrefs.edit(); 
        if (map) {
            editor.putInt("mapTopLeftX", margin);  
            editor.putInt("mapTopLeftY", margin + dateMinHeight + margin); 
            editor.putInt("mapTopRightX", margin + mapMinWidth);    
            editor.putInt("mapTopRightY", margin + dateMinHeight + margin); 
            editor.putInt("mapBottomRightX", margin + mapMinWidth);   
            editor.putInt("mapBottomRightY", margin + dateMinHeight + margin + mapMinHeight);  
            editor.putInt("mapBottomLeftX", margin);  
            editor.putInt("mapBottomLeftY", margin + dateMinHeight + margin + mapMinHeight);
        }
        if (date) {
            editor.putInt("dateTopLeftX", margin);  
            editor.putInt("dateTopLeftY", margin);          
            editor.putInt("dateTopRightX", margin + dateMinWidth);    
            editor.putInt("dateTopRightY", margin); 
            editor.putInt("dateBottomRightX", margin + dateMinWidth);  
            editor.putInt("dateBottomRightY", margin + dateMinHeight); 
            editor.putInt("dateBottomLeftX", margin);  
            editor.putInt("dateBottomLeftY", margin + dateMinHeight);
        }

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (music) {
                editor.putInt("musicTopLeftX", margin);  
                editor.putInt("musicTopLeftY", margin + dateMinHeight + margin + mapMinHeight + margin);         
                editor.putInt("musicTopRightX", margin + musicMinWidth);  
                editor.putInt("musicTopRightY", margin + dateMinHeight + margin + mapMinHeight + margin); 
                editor.putInt("musicBottomRightX", margin + musicMinWidth);  
                editor.putInt("musicBottomRightY", margin + dateMinHeight + margin + mapMinHeight + margin + musicMinHeight); 
                editor.putInt("musicBottomLeftX", margin);  
                editor.putInt("musicBottomLeftY", margin + dateMinHeight + margin + mapMinHeight + margin + musicMinHeight);            
            }
            if (radio) {
                editor.putInt("radioTopLeftX", margin + musicMinWidth + margin);  
                editor.putInt("radioTopLeftY", margin + dateMinHeight + margin + mapMinHeight + margin);         
                editor.putInt("radioTopRightX", margin + musicMinWidth + margin + radioMinWidth);  
                editor.putInt("radioTopRightY", margin + dateMinHeight + margin + mapMinHeight + margin); 
                editor.putInt("radioBottomRightX", margin + musicMinWidth + margin + radioMinWidth);  
                editor.putInt("radioBottomRightY", margin + dateMinHeight + margin + mapMinHeight + margin + radioMinHeight); 
                editor.putInt("radioBottomLeftX", margin + musicMinWidth + margin);  
                editor.putInt("radioBottomLeftY", margin + dateMinHeight + margin + mapMinHeight + margin + radioMinHeight);            
            }
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (music) {
                editor.putInt("musicTopLeftX", margin + mapMinWidth + margin);  
                editor.putInt("musicTopLeftY", margin + radioMinHeight + margin);         
                editor.putInt("musicTopRightX", margin + mapMinWidth + margin + musicMinWidth);  
                editor.putInt("musicTopRightY", margin + radioMinHeight + margin); 
                editor.putInt("musicBottomRightX", margin + mapMinWidth + margin + musicMinWidth);  
                editor.putInt("musicBottomRightY", margin + radioMinHeight + margin + musicMinHeight); 
                editor.putInt("musicBottomLeftX", margin + mapMinWidth + margin);  
                editor.putInt("musicBottomLeftY", margin + radioMinHeight + margin + musicMinHeight);            
            }
            if (radio) {
                editor.putInt("radioTopLeftX", margin + dateMinWidth + margin);
                editor.putInt("radioTopLeftY", margin);
                editor.putInt("radioTopRightX", margin + dateMinWidth + margin  + radioMinWidth);   
                editor.putInt("radioTopRightY", margin); 
                editor.putInt("radioBottomRightX", margin + dateMinWidth + margin  + radioMinWidth);  
                editor.putInt("radioBottomRightY", margin + radioMinHeight); 
                editor.putInt("radioBottomLeftX", margin + dateMinWidth + margin); 
                editor.putInt("radioBottomLeftY", margin + radioMinHeight);         
            }
        }

        if (stats) {
            editor.putInt("statsTopLeftX", 20);
            editor.putInt("statsTopLeftY", 20);         
        }
        editor.apply();
    }

    private void checkIfOverlappingMargins() {
        int height = getResources().getDisplayMetrics().heightPixels;
        int width = getResources().getDisplayMetrics().widthPixels;
        int pipScreen = Integer.parseInt(sharedPrefs.getString("pip_screen", "1")) - 1;
        margin = Integer.valueOf(sharedPrefs.getString("layout_margin", "10"));   
            if (map && pipScreen == 0) { 
            mapTopLeftX = sharedPrefs.getInt("mapTopLeftX", margin);
            mapTopLeftY = sharedPrefs.getInt("mapTopLeftY", margin + dateMinHeight + margin);        
            mapTopRightX = sharedPrefs.getInt("mapTopRightX", mapTopLeftX + mapMinWidth);    
            mapTopRightY = sharedPrefs.getInt("mapTopRightY", mapTopLeftY);
            mapBottomRightX = sharedPrefs.getInt("mapBottomRightX", mapTopRightX);
            mapBottomRightY = sharedPrefs.getInt("mapBottomRightY", mapTopRightY + mapMinHeight);
            mapBottomLeftX = sharedPrefs.getInt("mapBottomLeftX", mapTopLeftX);
            mapBottomLeftY = sharedPrefs.getInt("mapBottomLeftY", mapTopLeftY + mapMinHeight);

            if (mapTopLeftX < margin || mapTopLeftY < margin 
                || mapTopRightX > (width - margin) || mapTopRightY < margin 
                || mapBottomRightX > (width - margin) || mapBottomRightY > (height - margin) 
                || mapBottomLeftX < margin || mapBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            } 
        }

        if (date) {
            dateTopLeftX = sharedPrefs.getInt("dateTopLeftX", margin);  
            dateTopLeftY = sharedPrefs.getInt("dateTopLeftY", margin);          
            dateTopRightX = sharedPrefs.getInt("dateTopRightX", dateTopLeftX + dateMinWidth);    
            dateTopRightY = sharedPrefs.getInt("dateTopRightY", dateTopLeftY);
            dateBottomRightX = sharedPrefs.getInt("dateBottomRightX", dateTopRightX);
            dateBottomRightY = sharedPrefs.getInt("dateBottomRightY", dateTopRightY + dateMinHeight);
            dateBottomLeftX = sharedPrefs.getInt("dateBottomLeftX", dateTopLeftX);
            dateBottomLeftY = sharedPrefs.getInt("dateBottomLeftY", dateTopLeftY + dateMinHeight);

            if (dateTopLeftX < margin || dateTopLeftY < margin 
                || dateTopRightX > (width - margin) || dateTopRightY < margin 
                || dateBottomRightX > (width - margin) || dateBottomRightY > (height - margin) 
                || dateBottomLeftX < margin || dateBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            } 
        }

        if (music) {
            musicTopLeftX = sharedPrefs.getInt("musicTopLeftX", margin + mapMinWidth + margin); 
            musicTopLeftY = sharedPrefs.getInt("musicTopLeftY", margin + radioMinHeight + margin);          
            musicTopRightX = sharedPrefs.getInt("musicTopRightX", musicTopLeftX + musicMinWidth);    
            musicTopRightY = sharedPrefs.getInt("musicTopRightY", musicTopLeftY);
            musicBottomRightX = sharedPrefs.getInt("musicBottomRightX", musicTopRightX);
            musicBottomRightY = sharedPrefs.getInt("musicBottomRightY", musicTopRightY + musicMinHeight);
            musicBottomLeftX = sharedPrefs.getInt("musicBottomLeftX", musicTopLeftX);
            musicBottomLeftY = sharedPrefs.getInt("musicBottomLeftY", musicTopLeftY + musicMinHeight);

            if (musicTopLeftX < margin || musicTopLeftY < margin
                || musicTopRightX > (width - margin) || musicTopRightY < margin 
                || musicBottomRightX > (width - margin) || musicBottomRightY > (height - margin) 
                || musicBottomLeftX < margin || musicBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            } 
        } 

        if (radio) {
            radioTopLeftX = sharedPrefs.getInt("radioTopLeftX", margin + dateMinWidth + margin);
            radioTopLeftY = sharedPrefs.getInt("radioTopLeftY", margin);          
            radioTopRightX = sharedPrefs.getInt("radioTopRightX", radioTopLeftX + radioMinWidth);    
            radioTopRightY = sharedPrefs.getInt("radioTopRightY", radioTopLeftY);
            radioBottomRightX = sharedPrefs.getInt("radioBottomRightX", radioTopRightX);
            radioBottomRightY = sharedPrefs.getInt("radioBottomRightY", radioTopRightY + radioMinHeight);
            radioBottomLeftX = sharedPrefs.getInt("radioBottomLeftX", radioTopLeftX);
            radioBottomLeftY = sharedPrefs.getInt("radioBottomLeftY", radioTopLeftY + radioMinHeight);

            if (radioTopLeftX < margin || radioTopLeftY < margin
                || radioTopRightX > (width - margin) || radioTopRightY < margin 
                || radioBottomRightX > (width - margin) || radioBottomRightY > (height - margin) 
                || radioBottomLeftX < margin || radioBottomLeftY > (height - margin)) {
                overlappingMargins = true;
            } 
        }  
    }
}