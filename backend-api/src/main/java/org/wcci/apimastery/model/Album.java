package org.wcci.apimastery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private long id;
    private String albumName;
    private String artistName;
    private String imgUrl;
    @OneToMany (mappedBy = "album")
    private Collection<Song> songs;

    private String recordLabel;
    @OneToMany (mappedBy = "album")
    private Collection<Comment> comments;
    @OneToMany (mappedBy = "album")
    private Collection<Rating> ratings;


    public Album(String albumName, String artistName, String imgUrl,String recordLabel,Comment[] comments, Rating[] ratings, Song...songs) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.imgUrl = imgUrl;
        this.recordLabel = recordLabel;
        this.songs = Arrays.asList(songs);
        this.ratings = Arrays.asList(ratings);
        this.comments = Arrays.asList(comments);

    }

    public Album() {
    }

    public long getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }


}
