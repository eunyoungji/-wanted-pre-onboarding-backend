package com.example.wanted.service;

import com.example.wanted.dto.RecruitingListResponseDto;
import com.example.wanted.dto.RecruitingRequestDto;
import com.example.wanted.dto.RecruitingResponseDto;
import com.example.wanted.entity.User;
import com.example.wanted.entity.UserRoleEnum;
import com.example.wanted.entity.Recruiting;
import com.example.wanted.repository.RecruitingRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional

public class RecruitingServiceImpl implements RecruitingService {
    private final RecruitingRespository recruitingRespository;

    // 채용 공고 작성
    @Override
    public RecruitingResponseDto createRecruiting (RecruitingRequestDto requestDto, User user) {
        Recruiting recruiting = requestDto.toEntity();
        recruiting.setUser(user);
        recruitingRespository.save(recruiting);

        return RecruitingResponseDto.of(recruiting);
    }

    // 채용 공고 전체 조회
    @Override
    @Transactional(readOnly = true)
    public RecruitingListResponseDto selectRecruitings() {
        return RecruitingListResponseDto.builder()
                .recruitingResponseDtos(recruitingRespository.findAll().stream().map(RecruitingResponseDto::of).toList())
                .build();
    }

    // 채용 공고 상세 조회

    @Override
    @Transactional(readOnly = true)
    public RecruitingResponseDto selectRecruiting(Long id) {
        Recruiting recruiting = findRecruiting(id);
        return RecruitingResponseDto.of(recruiting);

    }

    // 특정 채용 공고 찾기
    private Recruiting findRecruiting(Long id) {
        return recruitingRespository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채용 공고입니다."));
    }

    // 채용 공고 수정
    @Override
    public RecruitingResponseDto updateRecruiting(Long id, RecruitingRequestDto requestDto, User user) {
        String username = findRecruiting(id).getUser().getUsername();
        Recruiting recruiting = findRecruiting(id);
        if (!(username.equals(user.getUsername()))) {
            throw new IllegalArgumentException("채용 공고 작성자만 수정할 수 있습니다.");
        }
        recruiting.setContent(requestDto.getContent());
        recruiting.setPosition(requestDto.getPosition());
        recruiting.setType(requestDto.getType());
        recruiting.setCompany(requestDto.getCompany());
        recruiting.setCompensation(requestDto.getCompensation());

        return RecruitingResponseDto.of(recruiting);
    }

    // 채용 공고 삭제
    @Override
    public void deleteRecruiting(Long id, User user) {
        Recruiting recruiting = findRecruiting(id);
        if (!recruiting.getUser().equals(user)) {
            throw new IllegalArgumentException("채용 공고 작성자만 삭제할 수 있습니다.");
        }

        recruitingRespository.delete(recruiting);

    }
}
