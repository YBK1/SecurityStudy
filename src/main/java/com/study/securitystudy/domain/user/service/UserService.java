package com.study.securitystudy.domain.user.service;

import com.study.securitystudy.domain.user.dto.repository.UserRepository;
import com.study.securitystudy.domain.user.dto.request.SignUpRequestDto;
import com.study.securitystudy.domain.user.dto.response.TokenResponseDto;
import com.study.securitystudy.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public TokenResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        String encodedPassword = bCryptPasswordEncoder.encode(signUpRequestDto.getPassword());
        User user = signUpRequestDto.toEntity();
        userRepository.save(user);

        return createToken(user.getUsername(), user.getName(), user.getEmail());
    }

    private TokenResponseDto createToken(String username, String name, String email){

        return new TokenResponseDto("temp", "temp");
    }
}
