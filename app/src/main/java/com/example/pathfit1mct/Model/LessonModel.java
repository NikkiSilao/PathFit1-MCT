package com.example.pathfit1mct.Model;

public class LessonModel {
    private final int numberResId;
    private final int titleResId;
    private final int subtitleResId;

    public LessonModel(int iconResId, int titleResId, int subtitleResId) {
        this.numberResId = iconResId;
        this.titleResId = titleResId;
        this.subtitleResId = subtitleResId;
    }

    public int getNumberResId() {
        return numberResId;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public int getSubtitleResId() {
        return subtitleResId;
    }
}
