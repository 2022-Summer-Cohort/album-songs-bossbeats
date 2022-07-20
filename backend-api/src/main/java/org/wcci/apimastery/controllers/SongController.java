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

@RestController
public class SongController {
    private SongRepository songRepo;
    private AlbumRepository albumRepo;
    private CommentRepository commentRepo;
    private RatingRepository ratingRepo;

    public SongController(SongRepository songRepo, AlbumRepository albumRepo, CommentRepository commentRepo, RatingRepository ratingRepo) {
        this.songRepo = songRepo;
        this.albumRepo = albumRepo;
        this.commentRepo = commentRepo;
        this.ratingRepo = ratingRepo;
    }

   @DeleteMapping("api/songs/{id}")
        public Iterable<Album> deleteSong(@PathVariable Long id){
            Song songToDelete = songRepo.findById(id).get();
            songRepo.delete(songToDelete);
            return albumRepo.findAll();
       }


    @PostMapping("/api/songs/{id}/addComment")
        public Song addCommentToSong(@RequestBody Comment commentToAdd, @PathVariable Long id){
            Song songToEdit = songRepo.findById(id).get();
            Comment comment1 = new Comment(commentToAdd.getComment(), songToEdit);
            commentRepo.save(comment1);
            return songToEdit;
        }

        @PostMapping("/api/songs/{id}/addRating")
    public Song addRatingToSong(@RequestBody Rating ratingToAdd, @PathVariable Long id){
            Song songToEdit = songRepo.findById(id).get();
            Rating rating1 = new Rating(ratingToAdd.getRating(),songToEdit);
            ratingRepo.save(rating1);
            return songToEdit;
        }

}
