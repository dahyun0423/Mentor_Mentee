package com.example.mentor_mentee.domain.post.dto.response;

import com.example.mentor_mentee.domain.Comment.dto.response.CommentResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final Integer commentCount;
    private final List<CommentResponseDto> comments;
//    private final Long views;
}
