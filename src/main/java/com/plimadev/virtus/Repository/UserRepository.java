package com.plimadev.virtus.Repository;

import com.plimadev.virtus.Entity.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
