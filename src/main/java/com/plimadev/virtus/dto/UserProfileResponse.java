package com.plimadev.virtus.dto;

import com.plimadev.virtus.model.Character;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record UserProfileResponse(
        Long id,
        String username,
        String email,
        Character character,
        LocalDateTime createdAt
) {}
