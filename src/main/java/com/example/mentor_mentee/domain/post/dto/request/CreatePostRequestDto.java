package com.example.mentor_mentee.domain.post.dto.request;

import lombok.*;

@Getter
@Builder
public class CreatePostRequestDto {
    private final String title;
    private final String content;
}
//    <기존방식>
//    public PostRequestDto(String title, String content){
//        this.title = title;
//        this.content = content;
//    }
