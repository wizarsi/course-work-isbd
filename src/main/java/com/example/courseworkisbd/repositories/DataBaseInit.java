package com.example.courseworkisbd.repositories;

import com.example.courseworkisbd.entities.SportDirector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataBaseInit implements CommandLineRunner {
    private SportDirectorRepository sportDirectorRepository;
    private PasswordEncoder passwordEncoder;

    public DataBaseInit(SportDirectorRepository sportDirectorRepository, PasswordEncoder passwordEncoder) {
        this.sportDirectorRepository = sportDirectorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.sportDirectorRepository.deleteAll();

        // Crete users
        SportDirector dan = new SportDirector("dan",passwordEncoder.encode("dan123"),"USER","");
        SportDirector admin = new SportDirector("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        SportDirector manager = new SportDirector("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<SportDirector> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.sportDirectorRepository.saveAll(users);
    }
}
