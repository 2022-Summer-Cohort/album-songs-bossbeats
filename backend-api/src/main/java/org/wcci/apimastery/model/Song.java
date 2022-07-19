package org.wcci.apimastery.model;

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
    @OneToMany(mappedBy = "song")
    private Collection<Comment> comments;
    @OneToMany(mappedBy = "song")
    private Collection<Rating> ratings;
    @ManyToOne
    private Album album;

    public Song(String title, Album album, String link, String duration, Comment[] comments, Rating[] ratings) {
        this.title = title;
        this.album = album;
        this.link = link;
        this.duration = duration;
        this.comments = Arrays.asList(comments);
        this.ratings = Arrays.asList(ratings);
    }
    public Song(String title, Album album, String link, String duration){
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

    public Collection<Comment> getComments() {
        return comments;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }
}
