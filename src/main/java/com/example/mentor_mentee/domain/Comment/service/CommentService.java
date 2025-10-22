package com.example.mentor_mentee.domain.Comment.service;

import com.example.mentor_mentee.domain.Comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.Comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.Comment.entity.Comment;
import com.example.mentor_mentee.domain.Comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        //1. CommentRequestDto에 있는 값으로 comment클래스 객체 생성
        Comment comment = Comment.builder()
                .content(requestDto.getContent())
                .build();
        //2. 새로 생성한 comment 객체 db에 저장
        Comment savedComment = commentRepository.save(comment);

        //3. 새로 생성한 comment 객체 데이터에 필요한 부분을 CommentRequestDto에 넣어  CommentResponseDto객체 생성
        return CommentResponseDto.builder()
                .id(savedComment.getId())
                .content(savedComment.getContent())
                .build();
    }
}
