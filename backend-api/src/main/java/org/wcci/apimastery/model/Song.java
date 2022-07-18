package org.wcci.apimastery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String link;
    private String duration;
    private String comment;
    private int rating;
//    @ManyToOne
//    private Collection<Album> albums;

    public Song(String title, String link, String duration, String comment, int rating) {
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.comment = comment;
        this.rating = rating;
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

    public String getDuration() {
        return duration;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}
