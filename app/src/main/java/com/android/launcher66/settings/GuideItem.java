package com.android.launcher66.settings;

public interface GuideItem {}

class TitleItem implements GuideItem {
    private final String title;

    public TitleItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class PictureItem implements GuideItem {
    private final int imageResId;
    private final String description;

    public PictureItem(int imageResId, String description) {
        this.imageResId = imageResId;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }
}

class DescriptionItem implements GuideItem {
    private final String description;

    public DescriptionItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}