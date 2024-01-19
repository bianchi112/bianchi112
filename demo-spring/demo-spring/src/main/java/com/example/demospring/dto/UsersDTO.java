package com.example.demospring.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // JPA에게 이 클래스가 엔터티임을 알림
@Table(name = "users")
public class UsersDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username") // 컬럼으로 매핑
    private String username;

    @Column(name = "email")
    private String email;



}
