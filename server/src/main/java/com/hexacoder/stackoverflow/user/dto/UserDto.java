package com.hexacoder.stackoverflow.user.dto;

import com.hexacoder.stackoverflow.question.entity.Question;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.validation.Valid;
import javax.validation.constraints.*;

import static java.time.LocalDateTime.*;

@Getter
public class UserDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Post{
        @Valid
        @NotBlank(message = "닉네임을 입력하세요.")
        private String nickname;

        @Valid
        @Email
        @NotBlank(message = "이메일을 입력하세요.")
        private String email;

        @Valid
        @NotBlank(message = "패스워드를 입력하세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
        private String password;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch{
        @Positive
        private long userId;
        @Valid
        private String nickname;
        @Valid
        private String password;
    }
    @Getter
    @AllArgsConstructor
    public static class Response{
        @Positive
        private long userId;
        private String nickname;
        private String email;
        private LocalDateTime createdAt;

    }
}
