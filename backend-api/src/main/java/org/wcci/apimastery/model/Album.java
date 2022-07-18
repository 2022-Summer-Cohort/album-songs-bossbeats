package org.wcci.apimastery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imgUrl;
    @OneToMany (mappedBy = albums)
    private Collection<Songs> songs;
    private String recordLabel;
    @OneToMany (mappedBy = albums)
    private Collection<Comments> comments;
    @OneToMany (mappedBy = albums)
    private Collection<Ratings> ratings;

    public Album(String name, String imgUrl, Collection<Songs> songs, String recordLabel, Collection<Comments> comments, Collection<Ratings> ratings) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.songs = songs;
        this.recordLabel = recordLabel;
        this.comments = comments;
        this.ratings = ratings;
    }

    public Album() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Collection<Songs> getSongs() {
        return songs;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public Collection<Comments> getComments() {
        return comments;
    }

    public Collection<Ratings> getRatings() {
        return ratings;
    }
}
