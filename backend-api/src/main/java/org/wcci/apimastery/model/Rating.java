package org.wcci.apimastery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long id;
    private int rating;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Song song;

    public Rating(int rating) {
        this.rating = rating;
        this.album = album;
        this.song = song;
    }
    public Rating(){

    }

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public Album getAlbum() {
        return album;
    }

    public Song getSong() {
        return song;
    }
}
