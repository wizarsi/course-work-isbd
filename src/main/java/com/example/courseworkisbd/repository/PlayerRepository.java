package com.example.courseworkisbd.repository;

import com.example.courseworkisbd.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name);
}
