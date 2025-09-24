package com.plimadev.virtus.service;

import com.plimadev.virtus.repository.CharacterRepository;
import com.plimadev.virtus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CharacterRepository characterRepository;
    private final PasswordEncoder passwordEncoder;


}
