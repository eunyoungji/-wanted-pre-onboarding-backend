package com.example.wanted.service;

import com.example.wanted.dto.RecruitingListResponseDto;
import com.example.wanted.dto.RecruitingRequestDto;
import com.example.wanted.dto.RecruitingResponseDto;
import com.example.wanted.entity.User;

public interface RecruitingService {

    // 채용 공고 작성

    RecruitingResponseDto createRecruiting (RecruitingRequestDto requestDto, User user);


    // 채용 공고 전체 조회
    RecruitingListResponseDto selectRecruitings();

    // 채용 공고 상세 조회
    RecruitingResponseDto selectRecruiting(Long id);

    // 채용 공고 수정
    RecruitingResponseDto updateRecruiting(Long id, RecruitingRequestDto requestDto, User user);

    // 채용 공고 삭제
    void deleteRecruiting(Long id, User user);


}
