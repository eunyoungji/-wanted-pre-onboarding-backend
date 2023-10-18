package com.example.wanted.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitingListResponseDto {
    private List<RecruitingResponseDto> recruitingResponseDtos;
}
