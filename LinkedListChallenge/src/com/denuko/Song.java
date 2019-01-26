package com.denuko;

public class Song {

    private String title;
    private String duration;

    public Song(String title) {
        this.title = title;
    }

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
