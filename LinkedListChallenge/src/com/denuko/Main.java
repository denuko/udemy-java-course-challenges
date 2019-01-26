package com.denuko;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Song> playlist = new LinkedList<>();
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Song cryOfAchilles = new Song("Cry Of Achilles", "6:31");
        Song lover = new Song("Lover", "5:17");
        Song fortressSong = new Song("Fortress", "7:34");

        Album fortress = new Album("Fortress", "Alter Bridge");
        fortress.addSong(cryOfAchilles);
        fortress.addSong(lover);
        fortress.addSong(fortressSong);
        albums.add(fortress);

        Song metalingus = new Song("Metalingus", "4:20");
        Album oneDayRemains = new Album("One Day Remains", "Alter Bridge");
        oneDayRemains.addSong(metalingus);
        albums.add(oneDayRemains);

        Song deceiverOfTheGodsSong = new Song("Deceiver Of The Gods", "4:19");
        Song bloodEagle = new Song("Blood Eagle", "3:16");
        Album deceiverOfTheGods = new Album("Deceiver Of The Gods", "Amon Amarth");
        deceiverOfTheGods.addSong(deceiverOfTheGodsSong);
        deceiverOfTheGods.addSong(bloodEagle);
        albums.add(deceiverOfTheGods);

        deceiverOfTheGods.addToPlayList(deceiverOfTheGodsSong.getTitle(), playlist);
        deceiverOfTheGods.addToPlayList("Shape Shifter", playlist);
        oneDayRemains.addToPlayList(metalingus.getTitle(), playlist);
        fortress.addToPlayList(lover.getTitle(), playlist);
        fortress.addToPlayList(cryOfAchilles.getTitle(), playlist);
//        fortress.addToPlayList(lover.getTitle(), playlist);
//        addSongToPlaylist(deceiverOfTheGodsSong);
//        addSongToPlaylist(new Song("Shape Shifter", "4:03"));
//        addSongToPlaylist(metalingus);
//        addSongToPlaylist(lover);
//        addSongToPlaylist(cryOfAchilles);
//        addSongToPlaylist(lover);

        play();
    }

    private static void play() {
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> playlistIterator = playlist.listIterator();
        Song currentSong;

        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist");
            quit = true;
        } else {
            System.out.println("Now listening to " + playlistIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Quit playlist");
                    quit = true;

                    break;

                case 1:
                    forward = skipNext(playlistIterator, forward);

                    break;

                case 2:
                    forward = skipPrevious(playlistIterator, forward);

                    break;

                case 3:
                    currentSong = getCurrentSong(playlistIterator, forward);
                    System.out.println("Replay " + currentSong.toString());

                    break;
                case 4:
                    printPlaylist();

                    break;
                case 5:
                    currentSong = getCurrentSong(playlistIterator, forward);
                    String songTitle = currentSong.toString();
                    playlistIterator.remove();
                    System.out.println("Removed " + songTitle + " from playlist");

                    if (forward) {
                        forward = skipNext(playlistIterator, true);
                    } else {
                        forward = skipPrevious(playlistIterator, false);
                    }

                    break;
                case 6:
                    printMenu();

                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - quit\n" +
                "1 - skip forward\n" +
                "2 - skip backwards\n" +
                "3 - replay current song\n" +
                "4 - list all songs\n" +
                "5 - remove current song from playlist\n" +
                "6 - print menu options\n");
    }

    private static void printPlaylist() {
        Iterator<Song> songIterator = playlist.iterator();
        Song currentSong;
        System.out.println("======================================");
        while (songIterator.hasNext()) {
            currentSong = songIterator.next();
            System.out.println("Track " + (playlist.indexOf(currentSong) + 1) + ": " + currentSong.toString());
        }
        System.out.println("======================================");
    }

//    public static boolean addSongToPlaylist(Song song) {
//        if (playlist.indexOf(song) > -1) {
//            System.out.println("Song '" + song.toString() + "' already in playlist");
//
//            return false;
//        }
//
//        Iterator<Album> albumIterator = albums.iterator();
//        while (albumIterator.hasNext()) {
//            Album album = albumIterator.next();
//            int position = album.getSongs().indexOf(song);
//            if (position > -1) {
//                playlist.add(song);
//
//                System.out.println("Song '" + song.toString() + "' [album: " + album.getName() + "] added in playlist");
//
//                return true;
//            }
//        }
//
//        System.out.println("Song '" + song.toString() + "' not found in albums");
//
//        return false;
//    }

    private static boolean skipNext(ListIterator<Song> playlistIterator, boolean forward) {
        if (!forward) {
            if (playlistIterator.hasNext()) {
                playlistIterator.next();
            }
            forward = true;
        }

        if (playlistIterator.hasNext()) {
            System.out.println("Now listening to " + playlistIterator.next().toString());
        } else {
            System.out.println("Reached the end of the playlist");
            forward = false;
        }

        return forward;
    }

    private static boolean skipPrevious(ListIterator<Song> playlistIterator, boolean forward) {
        if (forward) {
            if (playlistIterator.hasPrevious()) {
                playlistIterator.previous();
            }
            forward = false;
        }

        if (playlistIterator.hasPrevious()) {
            System.out.println("Now listening " + playlistIterator.previous().toString());
        } else {
            System.out.println("We are at the start of the playlist");
            forward = true;
        }

        return forward;
    }

    private static Song getCurrentSong(ListIterator<Song> playlistIterator, boolean forward) {
        Song currentSong;

        if (forward) {
            if (playlistIterator.hasPrevious()) {
                playlistIterator.previous();
            }

            currentSong = playlistIterator.next();

        } else {
            if (playlistIterator.hasNext()) {
                playlistIterator.next();
            }

            currentSong = playlistIterator.previous();
        }

        return currentSong;
    }
}
