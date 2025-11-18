package com.example.mentor_mentee.domain.post.entity;

import com.example.mentor_mentee.domain.Comment.entity.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity                 //이 클래스를 테이블과 매핑되는 엔티티로 인식하게
@Getter
@Builder                //빌더 패턴을 자동 생성해 가독성 있게 객체 생성
@AllArgsConstructor     //모든 필드를 매개변수로 받는 전체 생성자 자동생성
@NoArgsConstructor      //매개변수 없는 기본 생성자 자동 생성
@Table(name= "post")    //엔티티가 매핑될 테이블 이름 지정
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //순번

    @Column(nullable = false)
    private String title;   //제목

    @Column(nullable = false)
    private String content; //내용

    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
