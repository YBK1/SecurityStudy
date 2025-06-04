package com.study.securitystudy.domain.user.controller;

import com.study.securitystudy.domain.user.dto.request.SignUpRequestDto;
import com.study.securitystudy.domain.user.dto.response.TokenResponseDto;
import com.study.securitystudy.domain.user.service.UserService;
import com.study.securitystudy.global.ApiResponse;
import com.study.securitystudy.global.auth.service.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.study.securitystudy.domain.user.message.UserSuccessMessage.*;


@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CookieService cookieService;

    @GetMapping("/signup")
    public ApiResponse signup(@Valid @RequestBody SignUpRequestDto signUpRequest, HttpServletResponse response) {
        TokenResponseDto tokenResponseDto = userService.signUp(signUpRequest);

        // HttpServletResponse를 통해서 헤더와 쿠키에 토큰을 담아서 보낼것이다.
        response.setHeader("accessToken", tokenResponseDto.getAccessToken());
        response.addCookie(cookieService.createCookie("refreshToken", tokenResponseDto.getRefreshToken()));

        return ApiResponse.success(HttpStatus.CREATED, SIGN_UP_SUCCESS.getMessage());
    }
}
