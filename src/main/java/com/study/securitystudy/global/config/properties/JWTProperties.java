package com.study.securitystudy.global.config.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "spring.jwt")
public class JWTProperties {
    private String secret;
}
