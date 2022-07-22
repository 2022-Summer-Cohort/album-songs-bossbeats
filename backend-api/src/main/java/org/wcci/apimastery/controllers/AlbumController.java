package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.model.Album;
import org.wcci.apimastery.model.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.SongRepository;

@RestController
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;


    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo){
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;

    }
    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums(){
        return albumRepo.findAll();
    }


    @GetMapping("/api/albums/{id}")
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
    public Album addComment(@RequestBody String commentToAdd, @PathVariable Long id){
        Album albumToEdit = albumRepo.findById(id).get();
        albumToEdit.addComment(commentToAdd);
        albumRepo.save(albumToEdit);
        return albumToEdit;
    }
    @PostMapping("/api/albums/{id}/addRating")
    public Album addRating(@RequestBody Integer ratingToAdd, @PathVariable Long id){
        Album albumToEdit = albumRepo.findById(id).get();
        albumToEdit.addRating(ratingToAdd);
        albumRepo.save(albumToEdit);
        return albumToEdit;
    }
    
    @PostMapping("/api/albums")
    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd){
        albumRepo.save(albumToAdd);
        return albumRepo.findAll();
    }

    @DeleteMapping("api/albums/{id}")
    public Iterable<Album> deleteAlbumById(@PathVariable Long id){
        albumRepo.deleteById(id);
        return albumRepo.findAll();
    }

    @PatchMapping("/api/albums/{id}")
    public Iterable<Album> changeAlbumName(@PathVariable Long id, @RequestBody String newAlbumName){
        Album albumToChange = albumRepo.findById(id).get();
        albumToChange.changeAlbumName(newAlbumName);
        albumRepo.save(albumToChange);
        return albumRepo.findAll();
    }
}
