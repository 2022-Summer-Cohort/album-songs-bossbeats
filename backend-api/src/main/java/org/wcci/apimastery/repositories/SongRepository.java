package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.model.Song;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
    Optional<Song> findByAlbum(String albumName);
}
