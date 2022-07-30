package org.wcci.apimastery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String img;
    private String link;
    private String duration;
    @ElementCollection
    private Collection<String> comments;
    @ElementCollection
    private Collection<Integer> ratings;
    @ManyToOne
    @JsonIgnore
    private Album album;
    private String albumName;
    private double avgRating;


    public Song(String title, String img, Album album, String link, String duration) {
        this.title = title;
        this.img = img;
        this.album = album;
        this.albumName = album.getAlbumName();
        this.link = link;
        this.duration = duration;
        this.avgRating = 0.0;
    }
    public Song(String title, Album album){
        this.title = title;
        this.album = album;
    }

    public Song(){

    }

    public String getImg() {
        return img;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public Album getAlbum() {
        return album;
    }

    public String getDuration() {
        return duration;
    }

    public Collection<String> getComments() {
        return comments;
    }

    public Collection<Integer> getRatings() {
        return ratings;
    }

    public void addComment(String comment){
        comments.add(comment);
    }
    public void addRating(Integer rating){
        ratings.add(rating);
        double sum =0;
        for(int i : ratings){

            sum+=i;
        }
        avgRating = sum/ratings.size();
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void changeSongName(String newSongName){
        title = newSongName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(title, song.title) && Objects.equals(link, song.link) && Objects.equals(duration, song.duration) && Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, link, duration, album);
    }
}
