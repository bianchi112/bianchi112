package com.logintest.logintest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        // 현재 인증된 사용자의 정보를 얻어옵니다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // 실제로는 여기에서 사용자를 인증하고 세션 등을 관리하게 됩니다.
        // 현재는 간단히 로그인 성공 메시지를 반환합니다.
        return ResponseEntity.ok("Login success for user: " + username);
    }
}
