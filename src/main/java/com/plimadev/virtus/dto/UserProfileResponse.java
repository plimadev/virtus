package com.plimadev.virtus.dto;

import com.plimadev.virtus.model.Character;
import java.time.LocalDateTime;

public record UserProfileResponse(
        Long id,
        String username,
        String email,
        CharacterResponse character,
        LocalDateTime createdAt
) {}
