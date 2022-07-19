package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
