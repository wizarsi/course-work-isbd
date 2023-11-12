package com.example.courseworkisbd.controller;

import com.example.courseworkisbd.dto.PlayerDto;
import com.example.courseworkisbd.entity.FootballClub;
import com.example.courseworkisbd.entity.Player;
import com.example.courseworkisbd.entity.SportDirector;
import com.example.courseworkisbd.service.FootballClubService;
import com.example.courseworkisbd.service.PlayerService;
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

import static com.example.courseworkisbd.controller.util.Paths.*;

@Controller
public class PlayerController {
    private PlayerService playerService;
    private UserServiceImpl userService;
    private FootballClubService footballClubService;

    public PlayerController(PlayerService playerService, UserServiceImpl userService,FootballClubService footballClubService) {
        this.playerService = playerService;
        this.userService = userService;
        this.footballClubService =footballClubService;
    }

    @GetMapping(PLAYER_ADD)
    public String playerAddPage(Model model) {
        PlayerDto playerDto = new PlayerDto();
        model.addAttribute("playerDto", playerDto);
        return "player_add";
    }

    @GetMapping(PLAYERS)
    public String players(Model model) {
        List<PlayerDto> players = playerService.findAllPlayersDto();
        model.addAttribute("players", players);
        return "players";
    }

    @GetMapping(MYTEAM)
    public String myTeam(Model model) {
        List<PlayerDto> players = playerService.findAllPlayersDtoBySportDirector();
        model.addAttribute("myTeam", players);
        return "myteam";
    }

    @PostMapping(PLAYERS)
    public String addPlayer(@Valid @ModelAttribute("playerDto") PlayerDto playerDto,
                            BindingResult result, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        SportDirector sportDirector = userService.getSportDirectorByEmail(login);
        if (footballClubService.findFootballClubBySportDirector(sportDirector)!= null){
            playerService.savePlayerBySportDirector(playerDto,sportDirector);
        }
        return "index";
    }



}
