package com.example.mentor_mentee.domain.Comment.repository;

import com.example.mentor_mentee.domain.Comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(long id);
    boolean existsById(long id);
    void deleteById(long id);

}
