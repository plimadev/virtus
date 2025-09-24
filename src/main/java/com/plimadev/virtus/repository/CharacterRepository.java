package com.plimadev.virtus.repository;

import com.plimadev.virtus.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
