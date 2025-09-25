package com.plimadev.virtus.controller;

import com.plimadev.virtus.dto.RegisterUserRequest;
import com.plimadev.virtus.dto.UserProfileResponse;
import com.plimadev.virtus.model.Character;
import com.plimadev.virtus.service.CharacterService;
import com.plimadev.virtus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;
    private final CharacterService characterService;


    public UserController(UserService userService, CharacterService characterService) {
        this.userService = userService;
        this.characterService = characterService;

    }

    @PostMapping("/users/register")
    public ResponseEntity<UserProfileResponse> registerUser(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.status(201).body(userService.registerUser(request));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserProfile((id)));
    }

    @PatchMapping("/characters/{id}/name")
    public ResponseEntity<Character> updateCharacterName(
            @PathVariable Long id,
            @RequestBody String newName
    ) {
        return ResponseEntity.ok(characterService.updateCharacterName(id, newName));
    }


}
