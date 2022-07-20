package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.model.Album;
import org.wcci.apimastery.model.Comment;
import org.wcci.apimastery.model.Rating;
import org.wcci.apimastery.model.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.CommentRepository;
import org.wcci.apimastery.repositories.RatingRepository;
import org.wcci.apimastery.repositories.SongRepository;

import java.util.Collection;
import java.util.Optional;

@RestController
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private CommentRepository commentRepo;
    private RatingRepository ratingRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo, CommentRepository commentRepo, RatingRepository ratingRepo){
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.commentRepo = commentRepo;
        this.ratingRepo = ratingRepo;
    }
    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums(){
        return albumRepo.findAll();
    }
    @GetMapping("api/albums/{id}")
    public Album retrieveAlbumById(@PathVariable Long id){
        return albumRepo.findById(id).get();
    }

    @GetMapping("api/albums/{id}/songs")
    public Iterable<Song> retrieveSongsByAlbum(@PathVariable Long id){
        return albumRepo.findById(id).get().getSongs();
    }

    @PostMapping("api/albums/{id}/songs/addSong")
    public Album addSong(@RequestBody Song songToAdd, @PathVariable Long id){
        Album albumToEdit = albumRepo.findById(id).get();
        Song song1 = new Song(songToAdd.getTitle(),albumToEdit, songToAdd.getLink(), songToAdd.getDuration());
        songRepo.save(song1);
        return albumRepo.findById(id).get();
    }

    @PostMapping("/api/albums/{id}/addComment")
    public Album addComment(@RequestBody Comment commentToAdd, @PathVariable Long id){
        Album albumToEdit = albumRepo.findById(id).get();
        Comment comment1 = new Comment(commentToAdd.getComment(), albumToEdit);
        commentRepo.save(comment1);
        return albumToEdit;
    }
    @PostMapping("/api/albums/{id}/addRating")
    public Album addRating(@RequestBody Rating ratingToAdd, @PathVariable Long id){
        ratingRepo.save(ratingToAdd);
        Album albumToEdit = albumRepo.findById(id).get();
        albumToEdit.getRatings().add(ratingToAdd);
        albumRepo.save(albumToEdit);
        return albumToEdit;
    }
    
    @PostMapping("/api/albums")
    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd){
        albumRepo.save(albumToAdd);
        return albumRepo.findAll();
    }
}
