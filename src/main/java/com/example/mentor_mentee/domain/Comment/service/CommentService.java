package com.example.mentor_mentee.domain.Comment.service;

import com.example.mentor_mentee.domain.Comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.Comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.Comment.entity.Comment;
import com.example.mentor_mentee.domain.Comment.repository.CommentRepository;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentResponseDto createComment(Long postId, CommentRequestDto commentRequestDto) {
        //1. PostId가 식별자인 Post를 조회
        Post post = postRepository.findById(postId).orElse(null);
        //2. comment 생성
        Comment comment = Comment.builder()
                .content(commentRequestDto.getContent())
                .post(post)
                .build();
        //3. comment 저장 및 반환
        Comment savedComment = commentRepository.save(comment);

        //3. 새로 생성한 comment 객체 데이터에 필요한 부분을 CommentRequestDto에 넣어  CommentResponseDto객체 생성
        return CommentResponseDto.builder()
                .id(savedComment.getId())
                .content(savedComment.getContent())
                .build();
    }

    public String deleteComment(Long postId, Long commentId) {
        //1. postId가 식별자인 Post가 존재하는지 확인
        Post post = postRepository.findById(postId).orElse(null);
        if(post == null) {
            return postId +"번 게시글이 존재하지 않아요!";
        }

        //2. 조건에 따라 comment 삭제 여부 결정
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if(comment == null){
            return commentId +"번 댓글이 존재하지 않아요!";
        }
        if(post.getComments().contains(comment)){
            commentRepository.delete(comment);
            return commentId +"번 댓글이 삭제되었습니다.";
        }else{
            return commentId +"번 댓글은 "+ postId + "번 게시글의 댓글이 아닙니다.";
        }

    }
}

