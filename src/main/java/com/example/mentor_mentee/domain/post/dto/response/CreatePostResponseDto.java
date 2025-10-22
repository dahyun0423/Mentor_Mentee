package com.example.mentor_mentee.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePostResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final Long views;
}
