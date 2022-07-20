package org.wcci.apimastery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String link;
    private String duration;
    @ElementCollection
    private Collection<String> comments;
    @ElementCollection
    private Collection<Integer> ratings;
    @ManyToOne
    @JsonIgnore
    private Album album;


    public Song(String title, Album album, String link, String duration) {
        this.title = title;
        this.album = album;
        this.link = link;
        this.duration = duration;

    }

    public Song(){

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
    }
}
