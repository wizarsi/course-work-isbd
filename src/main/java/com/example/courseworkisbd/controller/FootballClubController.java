package com.example.courseworkisbd.controller;

import com.example.courseworkisbd.dto.FootballClubDto;
import com.example.courseworkisbd.entity.FootballClub;
import com.example.courseworkisbd.entity.SportDirector;
import com.example.courseworkisbd.service.FootballClubService;
import com.example.courseworkisbd.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import java.util.List;

import static com.example.courseworkisbd.controller.util.Paths.TEAMS;
import static com.example.courseworkisbd.controller.util.Paths.TEAM_ADD;

@Controller
public class FootballClubController {
    private final FootballClubService footballClubService;
    private final UserServiceImpl userService;

    public FootballClubController(FootballClubService footballClubService, UserServiceImpl userService) {
        this.footballClubService = footballClubService;
        this.userService = userService;
    }

    @GetMapping(TEAM_ADD)
    public String teamAddPage(Model model){
        model.addAttribute("footballClubDto", new FootballClubDto());
        return "team_add";
    }

    @GetMapping(TEAMS)
    public String teams(Model model){
        List<FootballClubDto> footballClubs = footballClubService.findAllFootballClubsDto();
        model.addAttribute("footballClubs", footballClubs);
        return "teams";
    }

    @PostMapping(TEAMS)
    public String registration(@Valid @ModelAttribute("footballClubDto") FootballClubDto footballClubDto,
                               BindingResult result,
                               Model model){
        if (result.hasErrors()) {
            return "team_add";
        }

        FootballClub existing = footballClubService.findFootballClubByName(footballClubDto.getName());
        if (existing != null) {
            return "index";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        SportDirector sportDirector = userService.getSportDirectorByEmail(login);
        if (footballClubService.findFootballClubBySportDirector(sportDirector) != null) {
            return "index";
        }

        footballClubService.saveFootballClub(footballClubDto);
        return "index";
    }
}
