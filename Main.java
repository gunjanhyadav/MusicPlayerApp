package com.gunjan;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>(); // combine all song album albums = album1 and 2
    public static void main(String[] args) {
        Album album = new Album("Album1","Arijit Singh");

        album.addSong("Tum hi ho",4.5);
        album.addSong("Rabta",3.5);
        album.addSong("Kitni hasse hogi",5.0);
        albums.add(album);

        album = new Album("Album2","A R Rahman");

        album.addSong("Jai ho",4.5);
        album.addSong("Dil se",3.5);
        album.addSong("Maula mere maula",4.5);
        albums.add(album);

        //linked list for playlist
        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Tum hi ho",playList_1);
        albums.get(0).addToPlayList("Kitni hasse hogi",playList_1);
        albums.get(1).addToPlayList("Maula mere maula",playList_1);
        albums.get(1).addToPlayList("Jai ho",playList_1);

        //play song method in playlist
        play(playList_1);
    }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size()==0){// if list is empty
            System.out.println("This playlist have no song");
        }
        else{//current position of iterator
            System.out.println("Now playing "+ listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0://to quit
                    System.out.println("playlist is complete");
                    quit = true;
                    break;
                case 1: //to play next
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing"+listIterator.next().toString());
                    }
                    else{
                        System.out.println(" no song available, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2 : // to play previous
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing"+listIterator.previous().toString());
                    }
                    else{
                        System.out.println("we are at the first song");
                        forward = false;
                    }
                    break;
                case 3 : //to replay current song
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("We are at the start of the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing"+ listIterator.next().toString());
                            forward  = true;
                        }
                        else{
                            System.out.println("we have reached to the end of the list");
                        }
                    }
                    break;
                case 4 :
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing"+ listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious())
                            System.out.println("now playing"+listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("available options\npress");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all the available options\n"+
                "6 - delete the current song\n");
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("---------------------------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------------");
    }
}