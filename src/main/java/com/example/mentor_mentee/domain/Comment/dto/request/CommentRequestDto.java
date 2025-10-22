package com.example.mentor_mentee.domain.Comment.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentRequestDto {
    private final String content;
}
