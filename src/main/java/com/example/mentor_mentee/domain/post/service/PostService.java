package com.example.mentor_mentee.domain.post.service;


import com.example.mentor_mentee.domain.post.dto.request.CreatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.CreatePostResponseDto;
import com.example.mentor_mentee.domain.post.entity.Post;
import com.example.mentor_mentee.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto) {
        // 1. PostRequestDto에 있는 값으로 post클래스 객체 생성
        Post post = Post.builder().title(createPostRequestDto.getTitle()).content(createPostRequestDto.getContent()).build();

        //2. 새로 생성한 post 객체 DB에 저장
        Post savedPost = postRepository.save(post);

        //3. 새로 생성한 post 객체 데이터에 필요한 부분을 PostRequestDto에 넣어서 PostResponseDto 객체 생성
        return CreatePostResponseDto.builder()
                .id(savedPost.getId())
                .title(savedPost.getTitle())
                .content(savedPost.getContent())
                .views(savedPost.getViews())
                .build();
    }

    public CreatePostResponseDto readPost(Long postId) {
        //1. postId를 통해서 Post 조회 (findById), 예외처리 필요
        Post post = postRepository.findById(postId).orElse(null);

        // 2. postResponseDto에 해당 Post 내용을 담아서 반환
        return CreatePostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .views(post.getViews())
                .build();
    }
}
