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
        Album album1 = new Album("Dark Side of the Moon", "Pink Floyd", "./src/Images/Dark_Side_of_the_Moon.png", "Harvest, Capitol");
        albumRepo.save(album1);
        Album album2 = new Album("Aashiqui 2", "Arijit Singh", "./src/Images/Aashiqui_2.jpeg", "T-Series");
        albumRepo.save(album2);
        Album album3 = new Album("Brand New Eyes", "Paramore", "./src/Images/Paramore_-_Brand_New_Eyes.png", "Fueled by Ramen");
        albumRepo.save(album3);
        Album album4 = new Album("HumbleQuest", "Maren Morris", "./src/Images/humblequest.jpeg", "Columbia Nashville");
        albumRepo.save(album4);
        Album album5 = new Album("Certified Lover Boy", "Drake", "./src/Images/Drake-certified-Lover-Boy.webp","OVO, Republic");
        albumRepo.save(album5);
        Album album6 = new Album("Versus", "Emarosa", "./src/Images/Emarosa_Versus,_2014.jpeg", "Rise");
        albumRepo.save(album6);
        Album album7 = new Album("Wings","BTS", "./src/Images/BTS,_Wings.jpeg","Big Hit, Loen, Pony Canyon");
        albumRepo.save(album7);

        Song song1 = new Song("Money", "./src/Images/money_pinkFloyd.png", album1, "https://www.youtube.com/watch?v=09EVVJOfhKg", "5:00");
        songRepo.save(song1);
        Song song2 = new Song("Time", "./src/Images/time_PinkFLoyd.png", album1, "https://www.youtube.com/watch?v=JwYX52BP2Sk", "7:03");
        songRepo.save(song2);
        Song song3 = new Song("Tum Hi Ho", "./src/Images/tum_aashiqui.png", album2, "https://www.youtube.com/watch?v=NUo8CKI34o4","4:22");
        songRepo.save(song3);
        Song song4 = new Song("Meri Aashiqui","./src/Images/meri_aashiqui.png", album2, "https://www.youtube.com/watch?v=YipYZY3mmO0", "4:26");
        songRepo.save(song4);
        Song song5 = new Song("Careful", "./src/Images/careful_paramore.png", album3, "https://www.youtube.com/watch?v=F-VYVSHZBrQ", "3:50");
        songRepo.save(song5);
        Song song6 = new Song("Brick by Boring Brick", "./src/Images/brick_paramore.png", album3, "https://www.youtube.com/watch?v=9C_raiwz3n0", "4:14");
        songRepo.save(song6);
        Song song7 = new Song("Nervous", "./src/Images/nervous_maren.png", album4, "https://www.youtube.com/watch?v=zkFVgehEOZs","2:55");
        songRepo.save(song7);
        Song song8 = new Song("Background Music", "./src/Images/background_maren.png", album4, "https://www.youtube.com/watch?v=Jk5kiAURAeU", "3:34");
        songRepo.save(song8);
        Song song9 = new Song("TSU", "./src/Images/tsu_drake.png", album5, "https://www.youtube.com/watch?v=fhEqtynX_xc","5:08");
        songRepo.save(song9);
        Song song10 = new Song("Champagne Poetry", "./src/Images/poetry_drake.png", album5, "https://www.youtube.com/watch?v=IxVuT8cgccM", "5:36");
        songRepo.save(song10);
        Song song11 = new Song("Cliff Notes", "./src/Images/cliffNotes_emarosa.png", album6, "https://www.youtube.com/watch?v=xtscs5Am3qM", "3:46");
        songRepo.save(song11);
        Song song12 = new Song("Say Hello to the Bad Guy","./src/Images/sayHello_emarosa.png",album6,"https://www.youtube.com/watch?v=7-doOW26PVY", "3:56");
        songRepo.save(song12);
        Song song13 = new Song("Blood Sweat & Tears", "./src/Images/bloodSweatTears_bts.png", album7, "https://www.youtube.com/watch?v=hmE9f-TEutc", "3:37");
        songRepo.save(song13);
        Song song14= new Song("Begin", "./src/Images/begin_bts.png", album7,"https://www.youtube.com/watch?v=m5_J7xuYxzs","3:50");
        songRepo.save(song14);

















    }
}
