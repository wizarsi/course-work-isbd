package com.example.courseworkisbd.repositories;

import com.example.courseworkisbd.entities.SportDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportDirectorRepository extends JpaRepository<SportDirector, Long> {
    SportDirector findByUsername(String username);
}
