package com.example.mentor_mentee.domain.Comment.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {
    private final Long id;
    private final String content;
}
