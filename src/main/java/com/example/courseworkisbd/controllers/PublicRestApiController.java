package com.example.courseworkisbd.controllers;

import com.example.courseworkisbd.entities.SportDirector;
import com.example.courseworkisbd.repositories.SportDirectorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    private SportDirectorRepository sportDirectorRepository;

    public PublicRestApiController(SportDirectorRepository sportDirectorRepository) {
        this.sportDirectorRepository = sportDirectorRepository;
    }

    @GetMapping("test1")
    public String test1() {
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2() {
        return "API Test 2";
    }

    @GetMapping("users")
    public List<SportDirector> users() {
        return this.sportDirectorRepository.findAll();
    }

}
