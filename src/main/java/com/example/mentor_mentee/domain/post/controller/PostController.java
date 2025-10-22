package com.example.mentor_mentee.domain.post.controller;

import com.example.mentor_mentee.domain.post.dto.request.CreatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.request.UpdatePostRequestDto;
import com.example.mentor_mentee.domain.post.dto.response.PostResponseDto;
import com.example.mentor_mentee.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController  //해당 클래스가 Web 요청을 담당하는 컨트롤러 기능을 수행
@RequestMapping("/api/posts")  //요청 기본 엔드포인트(url)를 지정
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostResponseDto createPost(@RequestBody CreatePostRequestDto createPostRequestDto) {
        PostResponseDto responseDto = postService.createPost(createPostRequestDto);
        return responseDto;
    }

    @GetMapping
    public String getAllPosts(){
        return "게시글 리스트 조회 완료";
    }

    @GetMapping("/{post-id}") //비공개 게시글이라면 사용자의 아이디와 같이 일치한지 아닌지 처리를 해서 사용자의 아이디를 받는 경우도 있다.
    public PostResponseDto getPostById(@PathVariable(value = "post-id") Long id){
        PostResponseDto responseDto = postService.readPost(id);  //crud에 따라 read를 쓴고!
        return responseDto;
    }

    @PutMapping("/{post-id}")
    public PostResponseDto updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto ,@PathVariable(value = "post-id") Long id){
        PostResponseDto responseDto = postService.updatePost(updatePostRequestDto, id);
        return responseDto;
    }

    @DeleteMapping("/{post-id}")
    public String deletePost(@PathVariable(value = "post-id") Long id){
        String responseDto = postService.deletePost(id);
        return responseDto;
    }
}
