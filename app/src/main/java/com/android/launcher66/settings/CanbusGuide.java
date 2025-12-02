package com.android.launcher66.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.R;
import com.fyt.skin.SkinAttribute;
import com.fyt.skin.SkinUtils;

import java.util.ArrayList;
import java.util.List;

public class CanbusGuide extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentSecond()).commit();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.guide_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.codes_guide)); 
        }
        
        RecyclerView recyclerView = view.findViewById(R.id.pictures_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<GuideItem> items = new ArrayList<>();
        items.add(new TitleItem(getString(R.string.codes_guide_initial_reading_title)));
        items.add(new DescriptionItem(getString(R.string.codes_guide_initial_reading_one)));
        items.add(new PictureItem(R.drawable.logger_guide, getString(R.string.codes_guide_initial_reading_two)));
        items.add(new DescriptionItem(getString(R.string.codes_guide_initial_reading_three)));
        items.add(new TitleItem(getString(R.string.codes_guide_detailed_reading_title)));
        items.add(new DescriptionItem(getString(R.string.codes_guide_detailed_reading)));
        items.add(new TitleItem(getString(R.string.codes_guide_miscellaneous_title)));
        items.add(new DescriptionItem(getString(R.string.codes_guide_miscellaneous)));
        
        GuideAdapter adapter = new GuideAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();    
        SkinAttribute skinAttribute = SkinUtils.getSkinAttr();
        if (skinAttribute != null) {
            skinAttribute.clear();
        }
    }
}