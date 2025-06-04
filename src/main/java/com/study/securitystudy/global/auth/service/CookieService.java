package com.study.securitystudy.global.auth.service;

import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CookieService {
    // 만료시간 일주일
    private static final int REFRESH_TOKEN_EXPIRY = 7 * 24 * 60 * 60;

    public Cookie createCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true); // JS에서 접근 못하게
        cookie.setSecure(true); // HTTPS에서만 전송
        cookie.setPath("/"); // 모든 경로에서 유효
        cookie.setMaxAge(REFRESH_TOKEN_EXPIRY); // 유효 시간 설정
        // cookie.setDomain("security.com"); // 도메인 필요시 설정
        // SameSite 속성은 Java 기본 Cookie에는 직접 설정 불가능하지만, 응답 헤더로 설정 가능 (필요시 추가)
        return cookie;
    }
}
