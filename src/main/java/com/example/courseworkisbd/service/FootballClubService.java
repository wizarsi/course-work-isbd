package com.example.courseworkisbd.service;

import com.example.courseworkisbd.dto.FootballClubDto;
import com.example.courseworkisbd.entity.FootballClub;
import com.example.courseworkisbd.repository.FootballClubRepository;
import com.example.courseworkisbd.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class FootballClubService {
    private FootballClubRepository footballClubRepository;

    public FootballClubService(FootballClubRepository footballClubRepository) {
        this.footballClubRepository = footballClubRepository;
    }

    public FootballClub findByFootballClubName(FootballClubDto footballClubDto) {
        return footballClubRepository.findByName(footballClubDto.getName());
    }

    public void saveFooballClub(FootballClubDto footballClubDto) {
        FootballClub footballClub = new FootballClub();
        footballClub.setName(footballClubDto.getName());
        footballClub.setBudget(footballClub.getBudget());
        footballClub.setTrophiesCount(footballClubDto.getTrophiesCount());
        footballClubRepository.save(footballClub);
    }
}
