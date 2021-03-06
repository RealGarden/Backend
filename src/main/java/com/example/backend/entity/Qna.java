package com.example.backend.entity;

import com.example.backend.entity.member.Member;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qnaInx;

    @CreationTimestamp
    private Date registerDate;

    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String title;

    @Column(nullable = false,columnDefinition = "text")
    private String contents;

    @Column(nullable = false)
    private int type;

    @Column(nullable = true)
    private int pw;

    @Column(nullable = false,columnDefinition = "char(5)")
    private String status;
    @Column(nullable = true,columnDefinition = "text")
    private String answer;

    @ManyToOne
    @JoinColumn(name="memberIdx")
    private Member member;
}