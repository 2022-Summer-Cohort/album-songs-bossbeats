package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.model.Album;

import org.wcci.apimastery.model.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.SongRepository;

@RestController
public class SongController {
    private SongRepository songRepo;
    private AlbumRepository albumRepo;


    public SongController(SongRepository songRepo, AlbumRepository albumRepo) {
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;

    }

//   @DeleteMapping("api/songs/{id}")
//        public Iterable<Album> deleteSong(@PathVariable Long id){
//            Song songToDelete = songRepo.findById(id).get();
//            songRepo.delete(songToDelete);
//            return albumRepo.findAll();
//       }


    @PostMapping("/api/songs/{id}/addComment")
        public Song addCommentToSong(@RequestBody String commentToAdd, @PathVariable Long id){
            Song songToEdit = songRepo.findById(id).get();
            songToEdit.addComment(commentToAdd);
            songRepo.save(songToEdit);
            return songToEdit;
        }

    @PostMapping("/api/songs/{id}/addRating")
    public Song addRatingToSong(@RequestBody Integer ratingToAdd, @PathVariable Long id){
        Song songToEdit = songRepo.findById(id).get();
        songToEdit.addRating(ratingToAdd);
        songRepo.save(songToEdit);
        return songToEdit;
    }

    @DeleteMapping("/api/songs/{id}")
    public Album deleteSong(@PathVariable Long id){
        Song songToBeDeleted = songRepo.findById(id).get();
        Album tempAlbum = songToBeDeleted.getAlbum();
        songRepo.deleteById(id);
        return tempAlbum;
    }    

    @PatchMapping("/api/songs/{id}/changeSongName")
    public Album changeSongName(@PathVariable Long id, @RequestBody String newSongName){
        Song tempSong = songRepo.findById(id).get();
        tempSong.changeSongName(newSongName);
        songRepo.save(tempSong);
        Album tempAlbum = tempSong.getAlbum();
        return tempAlbum;
    }
}
