package com.example.wanted.dto;

import com.example.wanted.entity.User;
import com.example.wanted.entity.Recruiting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitingRequestDto {

    private Long id;
    private String position;
    private int compensation;
    private String content;
    private String type;
    private String company;

    public Recruiting toEntity() {
        return Recruiting.builder()
                .id(id)
                .position(position)
                .compensation(compensation)
                .content(content)
                .type(type)
                .company(company)
                .build();
    }
}
