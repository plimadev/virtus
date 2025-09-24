package com.plimadev.virtus.dto;

import java.time.LocalDateTime;

public record RegisterUserRequest(
        String username,
        String email,
        String password,
        String characterName
) {}
