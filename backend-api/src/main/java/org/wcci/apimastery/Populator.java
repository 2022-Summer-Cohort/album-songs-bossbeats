package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.model.Album;
import org.wcci.apimastery.model.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.SongRepository;

@Component
public class Populator implements CommandLineRunner {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;


    public Populator(AlbumRepository albumRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Album album1 = new Album("Dark Side of the Moon", "Pink Floyd", "./src/Images/Dark_Side_of_the_Moon.png", "record Label");
        albumRepo.save(album1);
        Album album2 = new Album("Aashiqui 2", "Arijit Singh", "./src/Images/Aashiqui_2.jpeg", "recordlabel");
        albumRepo.save(album2);
        Album album3 = new Album("Brand New Eyes", "Paramore", "./src/Images/Paramore_-_Brand_New_Eyes.png", "recordlabel");
        albumRepo.save(album3);
        Album album4 = new Album("HumbleQuest", "Maren Morris", "./src/Images/humblequest.jpeg", "recordlabel");
        albumRepo.save(album4);
        Album album5 = new Album("Certified Lover Boy", "Drake", "./src/Images/Drake-certified-Lover-Boy.webp","recordlable");
        albumRepo.save(album5);
        Album album6 = new Album("Versus", "Emarosa", "./src/Images/Emarosa_Versus,_2014.jpeg", "recordlabel");
        albumRepo.save(album6);
        Album album7 = new Album("Wings","BTS", "./src/Images/BTS,_Wings.jpeg","recordlabel");
        albumRepo.save(album7);

        Song song1 = new Song("Money",album1, "/", "5:00");
        songRepo.save(song1);
        Song song2 = new Song("Time", album1, "/", "7:03");
        songRepo.save(song2);
        Song song3 = new Song("Tum Hi Ho", album2, "/","4:22");
        songRepo.save(song3);
        Song song4 = new Song("Meri Aashiqui", album2, "/", "4:26");
        songRepo.save(song4);
        Song song5 = new Song("Careful",album3, "/", "3:50");
        songRepo.save(song5);
        Song song6 = new Song("Brick by Boring Brick", album3, "/", "4:14");
        songRepo.save(song6);
        Song song7 = new Song("Nervous", album4, "/","2:55");
        songRepo.save(song7);
        Song song8 = new Song("Background Music", album4, "/", "3:34");
        songRepo.save(song8);
        Song song9 = new Song("TSU",album5, "/","5:08");
        songRepo.save(song9);
        Song song10 = new Song("Champagne Poetry", album5, "/", "5:36");
        songRepo.save(song10);
        Song song11 = new Song("Cliff Notes", album6, "/", "3:46");
        songRepo.save(song11);
        Song song12 = new Song("Say Hello to the Bad Guy",album6,"/", "3:56");
        songRepo.save(song12);
        Song song13 = new Song("Blood Sweat & Tears", album7, "/", "3:37");
        songRepo.save(song13);
        Song song14= new Song("Begin", album7,"/","3:50");
        songRepo.save(song14);

















    }
}
