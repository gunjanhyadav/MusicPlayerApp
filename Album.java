package com.gunjan;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){

    }
    //method to find song in Songs album
    public Song findSong(String title){

        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
    //add song method for album
    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            songs.add(new Song(title,duration)); // add new song to playlist
            //System.out.println(title+"successfully added to the list");
            return true;
        }
        else{
           // System.out.println("Song with name"+title+"already exist");
            return false;
        }
    }
    //add song to playlist which is existed in album
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber-1;
        if(index>0 && index<= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
       // System.out.println("this album does not have song with tracknumber " +trackNumber);
        return false;
    }
    //method which take title as an input to add song in playlist
    public boolean addToPlayList(String title,LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
       // System.out.println(title+"there is no such song in album");
        return false;
    }

}
