package com.example.wanted.controller;

import com.example.wanted.dto.ApiResponseDto;
import com.example.wanted.dto.RecruitingRequestDto;
import com.example.wanted.dto.RecruitingResponseDto;
import com.example.wanted.entity.User;
import com.example.wanted.entity.User;
import com.example.wanted.security.UserDetailsImpl;
import com.example.wanted.service.RecruitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recruitings")
public class RecruitingController {
    private final RecruitingService recruitingService;

    // 채용 공고 작성
    @PostMapping("/create")
    public RecruitingResponseDto createRecruiting(@RequestBody RecruitingRequestDto requestDto,  @AuthenticationPrincipal UserDetailsImpl userDetails)  {
        return recruitingService.createRecruiting(requestDto, userDetails.getUser());
    }

    // 채용 공고 전체 조회
    @GetMapping("/read")
    public ResponseEntity selectRecruitings() {
        List<RecruitingResponseDto> responseDto = recruitingService.selectRecruitings().getRecruitingResponseDtos();
        return ResponseEntity.ok().body(responseDto);
    }

    // 채용 공고 상세 조회
    @GetMapping("/read/{id}")
    public ResponseEntity selectRecruiting(@PathVariable Long id) {
        RecruitingResponseDto responseDto = recruitingService.selectRecruiting(id);
        return ResponseEntity.ok().body(responseDto);
    }

    // 채용 공고 수정
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponseDto> updateRecruiting(@PathVariable Long id, @RequestBody RecruitingRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            RecruitingResponseDto result = recruitingService.updateRecruiting(id, requestDto, userDetails.getUser());
            return ResponseEntity.ok().body(new ApiResponseDto("수정이 완료되었습니다.", HttpStatus.OK.value()));
        } catch (RejectedExecutionException e) {
            return ResponseEntity.badRequest().body(new ApiResponseDto("작성자만 수정할 수 있습니다.", HttpStatus.BAD_REQUEST.value()));
        }
    }

    // 채용 공고 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponseDto> deleteRecruiting(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id) {
        try {
            recruitingService.deleteRecruiting(id, userDetails.getUser());
            return ResponseEntity.ok().body(new ApiResponseDto("삭제되었습니다.", HttpStatus.OK.value()));
        } catch (RejectedExecutionException c) {
            return ResponseEntity.badRequest().body(new ApiResponseDto("작성자만 삭제할 수 있습니다.", HttpStatus.BAD_REQUEST.value()));
        }
    }
}
