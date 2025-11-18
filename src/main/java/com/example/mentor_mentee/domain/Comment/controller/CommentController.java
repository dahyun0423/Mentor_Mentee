package com.example.mentor_mentee.domain.Comment.controller;

import com.example.mentor_mentee.domain.Comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.Comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.Comment.entity.Comment;
import com.example.mentor_mentee.domain.Comment.service.CommentService;
import com.example.mentor_mentee.domain.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor            //필요한 필드(final, @NonNull 이 붙은 필드 변수)만 받는 생성자 생성
@RestController                    // 해당 클래스가 Web 요청담당하는 컨트롤러 기능 수행
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    @PostMapping("/{post-id}")
    public CommentResponseDto createComment(@PathVariable(value = "post-id") Long postId, @RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto responseDto = commentService.createComment(postId, commentRequestDto);
        return responseDto;
    }

    @DeleteMapping("/{comment-id}")
    public String deleteComment(@PathVariable(value = "post-id")Long postId, @PathVariable(value = "comment-id") Long commentId) {
        return commentService.deleteComment(postId, commentId);
    }
}