package com.example.wanted.repository;

import com.example.wanted.entity.Recruiting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruitingRespository extends JpaRepository<Recruiting, Long> {
    List<Recruiting> findByContentContains(String content);
    Optional<Recruiting> findById(Long id);
}
