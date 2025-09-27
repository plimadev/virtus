package com.plimadev.virtus.service;

import com.plimadev.virtus.dto.CharacterResponse;
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
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }
        if(userRepository.existsByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username already in use");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));

        Character character = new Character();
        character.setName(request.getCharacterName());
        character.setUser(user);

        user.setCharacter(character);

        //cascades to character ?
        userRepository.save(user);

        return new UserProfileResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                new CharacterResponse(user.getCharacter().getId(), user.getCharacter().getName()),
                user.getCreatedAt()
        );

    }

    public UserProfileResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserProfileResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                new CharacterResponse(user.getCharacter().getId(), user.getCharacter().getName()),
                user.getCreatedAt()
        );
    }
}
