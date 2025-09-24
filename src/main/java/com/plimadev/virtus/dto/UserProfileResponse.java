package com.plimadev.virtus.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record UserProfileResponse(
        Long id,
        String username,
        String email,
        Character character,
        LocalDateTime createdAt
) {}
