package com.plimadev.virtus.service;

import com.plimadev.virtus.dto.RegisterUserRequest;
import com.plimadev.virtus.dto.UserProfileResponse;
import com.plimadev.virtus.model.Character;
import com.plimadev.virtus.model.User;
import com.plimadev.virtus.repository.CharacterRepository;
import com.plimadev.virtus.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CharacterRepository characterRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, CharacterRepository characterRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserProfileResponse registerUser(RegisterUserRequest request){
        if(userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already in use");
        }
        if(userRepository.existsByUsername(request.username())){
            throw new IllegalArgumentException("Username already in use");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPasswordHash(passwordEncoder.encode(request.password()));

        Character character = new Character();
        character.setName(request.characterName());
        character.setUser(user);

        //cascades to character ?
        userRepository.save(user);

        return new UserProfileResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCharacter(),
                user.getCreatedAt()
        );


    }
}
