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
    private static final int TYPE_SPOTIFY = 3;
    
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
        } else if (viewType == TYPE_SPOTIFY) {
            View view = inflater.inflate(R.layout.spotify_item, parent, false);
            return new SpotifyViewHolder(view);
        }
        throw new IllegalArgumentException("Invalid view type: " + viewType);
    }
    
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder) {
            case TitleViewHolder titleViewHolder ->
                    titleViewHolder.bind((TitleItem) items.get(position));
            case PictureViewHolder pictureViewHolder ->
                    pictureViewHolder.bind((PictureItem) items.get(position));
            case DescriptionViewHolder descriptionViewHolder ->
                    descriptionViewHolder.bind((DescriptionItem) items.get(position));
            case SpotifyViewHolder spotifyViewHolder ->
                    spotifyViewHolder.bind((SpotifyItem) items.get(position));
            default -> {
            }
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
        } else if (items.get(position) instanceof SpotifyItem) {
            return TYPE_SPOTIFY;
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
    
    static class SpotifyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        
        SpotifyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.spotify_image);
        }
        
        void bind(SpotifyItem item) {
            imageView.setImageResource(item.getImageResId());
        }
    }
}