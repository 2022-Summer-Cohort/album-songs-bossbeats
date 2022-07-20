package org.wcci.apimastery.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String comment;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Song song;

    public Comment(String comment, Album album) {
        this.album = album;
        this.comment = comment;
    }

    public Comment(String comment, Song song) {
        this.comment = comment;
        this.song = song;
    }

    public Comment(){

    }
    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Album getAlbum() {
        return album;
    }

    public Song getSong() {
        return song;
    }
}
