package com.example.courseworkisbd.repository;


import com.example.courseworkisbd.entity.FootballClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballClubRepository extends JpaRepository<FootballClub, Long> {
    FootballClub findByName(String name);
}
