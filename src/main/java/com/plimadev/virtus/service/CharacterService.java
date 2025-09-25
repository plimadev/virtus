package com.plimadev.virtus.service;

import com.plimadev.virtus.model.Character;
import com.plimadev.virtus.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;


    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character updateCharacterName(Long characterId, String newName){
        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalStateException("Character not found"));

        character.setName(newName);
        return characterRepository.save(character);
    }
}
