package com.awesome.typing1.global.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"code", "message", "result"})
public class ApiResponse<T> {

    private final String code; // HTTP 상태 코드나 사용자 정의 코드
    private final String message; // API 요청에 대한 설명이나 상태 메시지
    @JsonInclude(JsonInclude.Include.NON_NULL) // result 값은 null이 아닐 때만 응답에 포함시킨다.
    private T result; // 결과 데이터. (보통 dto -> json 파싱 될 예정)

    public static <T> ApiResponse<T> onSuccess(T result) { // 성공한 경우 응답 생성
        return new ApiResponse<>(String.valueOf(HttpStatus.OK.value()), HttpStatus.OK.getReasonPhrase(), result);
    }

    public static <T> ApiResponse<T> onSuccess(HttpStatus status, T result) { // 성공한 경우 응답 생성 (상태 코드 지정 가능)
        return new ApiResponse<>(String.valueOf(status.value()), status.getReasonPhrase(), result);
    }

    public static <T> ApiResponse<T> onFailure(String code, String message, T result) { // 실패한 경우 응답 생성
        return new ApiResponse<>(code, message, result);
    }

    public static <T> ApiResponse<T> onFailure(String statusCode, String message) { // 실패한 경우 응답 생성 (데이터 없음)
        return new ApiResponse<>(statusCode, message, null);
    }

}