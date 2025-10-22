package com.example.mentor_mentee.domain.Comment.controller;

import com.example.mentor_mentee.domain.Comment.dto.request.CommentRequestDto;
import com.example.mentor_mentee.domain.Comment.dto.response.CommentResponseDto;
import com.example.mentor_mentee.domain.Comment.entity.Comment;
import com.example.mentor_mentee.domain.Comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor            //필요한 필드(final, @NonNull 이 붙은 필드 변수)만 받는 생성자 생성
@RestController                    // 해당 클래스가 Web 요청담당하는 컨트롤러 기능 수행
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto responsDto = commentService.createComment(commentRequestDto);
        return responsDto;
    }

    @GetMapping
    public String getAllComments(){
        return "댓글 리스트 조회 완료";
    }

    @GetMapping("/{comment-id}")
    public String getCommentById(@PathVariable(value = "comment-id") Long id){
        return id +"번 댓글 조회 완료";
    }

    @PutMapping("/{comment-id}")
    public String updateComment(@PathVariable(value = "comment-id") Long id){
        return id +"번 댓글 수정 완료";
    }

    @DeleteMapping("/{comment-id}")
    public String deleteComment(@PathVariable(value = "comment-id") Long id){
        return id +"번 댓글 삭제 완료";
    }
}
