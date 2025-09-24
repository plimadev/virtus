package com.plimadev.virtus.Repository;

import com.plimadev.virtus.Entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
