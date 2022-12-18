package com.example.courseworkisbd.service;

import com.example.courseworkisbd.dto.FootballClubDto;
import com.example.courseworkisbd.entity.Coach;
import com.example.courseworkisbd.entity.FootballClub;
import com.example.courseworkisbd.entity.FootballLeague;
import com.example.courseworkisbd.entity.SportDirector;
import com.example.courseworkisbd.repository.FootballClubRepository;
import com.example.courseworkisbd.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FootballClubService {
    private FootballClubRepository footballClubRepository;
    private UserServiceImpl userService;

    public FootballClubService(FootballClubRepository footballClubRepository, UserServiceImpl userService) {
        this.footballClubRepository = footballClubRepository;
        this.userService = userService;
    }

    public FootballClub findByFootballClubName(FootballClubDto footballClubDto) {
        return footballClubRepository.findByName(footballClubDto.getName());
    }

    public void saveFootballClub(FootballClubDto footballClubDto) {
        FootballClub footballClub = new FootballClub();
        footballClub.setName(footballClubDto.getName());
        footballClub.setBudget(footballClub.getBudget());
        footballClub.setWonMatches(footballClubDto.getWonMatches());
        FootballLeague footballLeague = new FootballLeague();
        footballLeague.setName(footballClubDto.getLeague());
        List<FootballLeague> footballLeagues = new ArrayList<>();
        footballLeagues.add(footballLeague);
        footballClub.setFootballLeagues(footballLeagues);
        Coach coach = new Coach();
        coach.setName(footballClubDto.getCoach());
        footballClub.setCoach(coach);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        SportDirector sportDirector = userService.getSportDirectorByEmail(login);
        footballClub.setSportDirector(sportDirector);
        footballClubRepository.save(footballClub);
    }

    public List<FootballClubDto> findAllFootballClubsDto() {
        List<FootballClub> footballClubs = footballClubRepository.findAll();
        return footballClubs.stream().map((club) -> convertEntityToDto(club))
                .collect(Collectors.toList());
    }

    private FootballClubDto convertEntityToDto(FootballClub footballClub) {
        FootballClubDto footballClubDto = new FootballClubDto();
        footballClubDto.setName(footballClub.getName());
        System.out.println(   footballClub.getFootballLeagues().size()
);
        footballClubDto.setLeague(footballClub.getFootballLeagues().get(0).getName());
        footballClubDto.setBudget(footballClub.getBudget());
        footballClubDto.setWonMatches(footballClub.getWonMatches());
        footballClubDto.setSportDirector(footballClub.getSportDirector().getName());
        footballClubDto.setCoach(footballClub.getCoach().getName());
        footballClubDto.setPlayersCount(footballClub.getPlayersCount());
        return footballClubDto;
    }
}