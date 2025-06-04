package com.study.securitystudy.global.auth.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class JWTUtil {
    private SecretKey secretKey;

//    @Value("${spring.jwt.secret}")
//    private String secret;
//    public JWTUtil() {
//        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
//    }

    // @Value를 사용하는 방식이 위처럼도 가능한데
    // 위처럼 하면 중복제거의 장점이 있고 아래처럼 하면 테스트시 입력이 가능하니까 편함

    public JWTUtil(@Value("${spring.jwt.secret}")String secret) {
        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }
}
