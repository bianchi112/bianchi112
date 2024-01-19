package com.example.demospring.dao;

import com.example.demospring.dto.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Spring Data JPA 에서 제공하는 JpaRepository 인터페이스 확장
// JpaRepository는 자동으로 기본적인 CRUD 메서드 제공
public interface UsersRepository extends JpaRepository<UsersDTO, Long> {
    // 사용자 이름(username)으로 사용자 찾기
    UsersDTO findByUsername(String username);

    // 이메일(email)로 사용자 찾기
    UsersDTO findByEmail(String email);

    // 특정 이름이나 이메일을 가진 사용자 찾기 (예: 이름 또는 이메일이 일부 일치하는 경우)
    List<UsersDTO> findByUsernameContainingOrEmailContaining(String username, String email);

    // 다양한 다른 쿼리 메서드 추가 가능

    // 예시: 사용자 이름과 이메일로 사용자 찾기
    UsersDTO findByUsernameAndEmail(String username, String email);
}
