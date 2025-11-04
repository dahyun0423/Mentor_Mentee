package com.example.mentor_mentee.domain.Comment.entity;

import com.example.mentor_mentee.domain.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity         //이 클래스를 테이블과 매핑되는 엔티티로 인식하게
@Getter
@Builder       //빌더 패턴을 자동 생성해 가독성 있게 객체를 생성
@NoArgsConstructor      //매개변수 없는 기본 생성자 자동 생성
@AllArgsConstructor    // 모든 필드를 매개변수로 받는 전체 생성자를 자동 생성
@Table(name = "comment")        //엔티티가 매핑될 테이블 이름을 지정
public class Comment {

    @Id //순번
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String content;  //내용

    //N:1 관계
    @ManyToOne(fetch = FetchType.LAZY)          //FetchType.LAZY : 지연로딩
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

}
