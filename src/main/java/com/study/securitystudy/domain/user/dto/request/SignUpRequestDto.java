package com.study.securitystudy.domain.user.dto.request;

import com.study.securitystudy.domain.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class SignUpRequestDto {
    @NotBlank(message = "ID는 필수 입력 항목입니다.")
    private final String username;
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private final String password;
    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private final String name;
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    private final String email;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
