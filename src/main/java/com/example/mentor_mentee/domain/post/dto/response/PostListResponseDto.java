package com.example.mentor_mentee.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String contentSummary; //짧은 바디내용
    private Integer commentCount;
}
