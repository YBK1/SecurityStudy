package com.study.securitystudy.domain.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenResponseDto {
    private final String accessToken;
    private final String refreshToken;
}
