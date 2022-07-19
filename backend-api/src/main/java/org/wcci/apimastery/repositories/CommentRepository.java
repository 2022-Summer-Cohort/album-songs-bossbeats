package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
