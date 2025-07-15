package com.android.launcher66.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.R;

import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_PICTURE = 1;
    private static final int TYPE_DESCRIPTION = 2;
    
    private final List<GuideItem> items;
    
    public GuideAdapter(List<GuideItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_TITLE) {
            View view = inflater.inflate(R.layout.guide_title_item, parent, false);
            return new TitleViewHolder(view);
        } else if (viewType == TYPE_PICTURE) {
            View view = inflater.inflate(R.layout.guide_item, parent, false);
            return new PictureViewHolder(view);
        } else if (viewType == TYPE_DESCRIPTION) {
            View view = inflater.inflate(R.layout.guide_description_item, parent, false);
            return new DescriptionViewHolder(view);
        }
        throw new IllegalArgumentException("Invalid view type: " + viewType);
    }
    
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).bind((TitleItem) items.get(position));
        } else if (holder instanceof PictureViewHolder) {
            ((PictureViewHolder) holder).bind((PictureItem) items.get(position));
        } else if (holder instanceof DescriptionViewHolder) {
            ((DescriptionViewHolder) holder).bind((DescriptionItem) items.get(position));
        }
    }
    
    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof TitleItem) {
            return TYPE_TITLE;
        } else if (items.get(position) instanceof PictureItem) {
            return TYPE_PICTURE;
        } else if (items.get(position) instanceof DescriptionItem) {
            return TYPE_DESCRIPTION;
        }
        return super.getItemViewType(position);
    }
    
    @Override
    public int getItemCount() {
        return items.size();
    }
    
    static class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        
        TitleViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.guide_title);
        }
        
        void bind(TitleItem item) {
            titleView.setText(item.getTitle());
        }
    }
    
    static class PictureViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView descriptionView;
        
        PictureViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.guide_image);
            descriptionView = itemView.findViewById(R.id.guide_description);
        }
        
        void bind(PictureItem item) {
            imageView.setImageResource(item.getImageResId());
            descriptionView.setText(item.getDescription());
        }
    }

    static class DescriptionViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionView;

        DescriptionViewHolder(View itemView) {
            super(itemView);
            descriptionView = itemView.findViewById(R.id.guide_description_text);
        }

        void bind(DescriptionItem item) {
            descriptionView.setText(item.getDescription());
        }
    }
}