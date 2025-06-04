package com.study.securitystudy.domain.user.message;

import lombok.Getter;

@Getter
public enum UserSuccessMessage {
    SIGN_UP_SUCCESS("회원가입 성공"),
    GET_CHILD_INFO_SUCCESS("자녀 정보 조회 성공"),
    GET_USER_DETAIL_INFO_SUCCESS("내 정보 상세 조회 성공"),
    USER_ID_VALIDATION_SUCCESS("사용 가능한 아이디입니다."),
    NEARBY_USERS_FOUND("주변 사용자들 조회 성공"),
    USER_LEVEL_SEARCH_SUCCESS("회원 레벨 조회 성공"),
    USER_SIMPLE_INFO_SEARCH_SUCCESS("회원의 간단한 정보 조회 성공")
    ;

    private final String message;

    UserSuccessMessage(String message) {
        this.message = message;
    }
}
