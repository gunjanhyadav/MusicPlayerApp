package com.gunjan;

public class Song {
    String title;
    double duration;
    public Song(String title, double duration){
        this.title = title;
        this.duration = duration;
    }
    public Song(){

    }
    // methods to get title and duration
    public String getTitle(){
        return title;
    }
    public double getDuration(){
        return duration;
    }

    //method to print song detail
    @Override
    public String toString() {
        return "Song{" + "title="+title +'\''+",duration="+duration+'}';
    }
}
