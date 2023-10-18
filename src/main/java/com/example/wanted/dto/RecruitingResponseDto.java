package com.example.wanted.dto;

import com.example.wanted.entity.User;
import com.example.wanted.entity.Recruiting;
import com.example.wanted.entity.User;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitingResponseDto {

    private Long id;
    private String position;
    private int compensation;
    private String content;
    private String type;
    private String company;

    public static RecruitingResponseDto of(Recruiting recruiting) {
        return RecruitingResponseDto.builder()
                .id(recruiting.getId())
                .position(recruiting.getPosition())
                .compensation(recruiting.getCompensation())
                .content(recruiting.getContent())
                .type(recruiting.getType())
                .company(recruiting.getCompany())
                .build();


    }
}

