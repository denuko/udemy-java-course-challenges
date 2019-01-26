package com.denuko;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean addSong(Song song) {

        if (findSongPosition(song.getTitle()) > -1) {
            System.out.println("Song already in album");

            return false;
        }

        this.songs.add(song);

        return true;
    }

    public boolean updateSong(Song song, Song newSong) {
        int position = findSongPosition(song.getTitle());
        if (position > -1) {
            updateSong(position, newSong);

            return true;
        }

        System.out.println("Song " + song.getTitle() + " not found");

        return false;
    }

    private void updateSong(int position, Song newSong) {
        this.songs.set(position, newSong);
    }

    public boolean removeSong(Song song) {
        int position = findSongPosition(song.getTitle());
        if (position > -1) {

            removeSong(position);

            return true;
        }

        System.out.println("Song " + song.getTitle() + " not found");

        return false;
    }

    private void removeSong(int position) {
        this.songs.remove(position);
    }

    public boolean findSong(Song song) {
        if (findSongPosition(song.getTitle()) > -1) {
            return true;
        }

        return false;
    }

    private int findSongPosition(String songTitle) {
        for (int i = 0; i < this.songs.size(); i++) {
            Song checkedSong = this.songs.get(i);
            if (checkedSong.getTitle().equals(songTitle)) {

                return i;
            }
        }

        return -1;
    }

    private Song findSong(String songTitle) {
        for (int i = 0; i < this.songs.size(); i++) {
            Song checkedSong = this.songs.get(i);
            if (checkedSong.getTitle().equals(songTitle)) {

                return checkedSong;
            }
        }

        return null;
    }

    // ALTERNATIVE WAY To ADD SONG TO PLAYLIST BY ALBUM TRACK No
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;

        if ((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));

            return true;
        }

        System.out.println("This album does not have a track " + trackNumber);

        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);

        if (checkedSong != null) {
            playList.add(checkedSong);

            return true;
        }

        System.out.println("The song "  + title + " is not in this album");

        return false;
    }
}
