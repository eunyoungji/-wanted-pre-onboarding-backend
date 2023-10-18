//package com.example.wanted.dto;
//
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class SignupRequestDto {
//
//    @NotBlank
//    private String username;
//
//    @NotBlank
//    @Size(min=4, max=15, message = "비밀번호는 최소 4자리 이상부터 15자리 까지 가능합니다.")
//    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]*$", message = "비밀번호는 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자로 구성되어야 합니다.")
//    private String password;
//
//    private String nickname;
//
//    private boolean admin = false;
//    private String adminToken = "";
//
//
//}