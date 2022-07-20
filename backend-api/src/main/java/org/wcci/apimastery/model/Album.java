package org.wcci.apimastery.model;

import javax.persistence.*;
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
    @ElementCollection
    private Collection<String> comments;
    @ElementCollection
    private Collection<Integer> ratings;


    public Album(String albumName, String artistName, String imgUrl,String recordLabel, Song...songs) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.imgUrl = imgUrl;
        this.recordLabel = recordLabel;
        this.songs = Arrays.asList(songs);



    }

    public Album(String albumName, String artistName, String imgUrl, String recordLabel) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.imgUrl = imgUrl;
        this.recordLabel = recordLabel;
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

    public Collection<String> getComments() {
        return comments;
    }
    public void addComment(String comment){
        comments.add(comment);
    }
    public Collection<Integer> getRatings() {
        return ratings;
    }

    public void addRating(Integer rating){
        ratings.add(rating);
    }
}
