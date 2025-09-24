package com.plimadev.virtus.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "characters")
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int level = 1;
    private int xp = 0;
    private int gold = 0;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

}
