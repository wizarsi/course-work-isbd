package com.example.courseworkisbd.controller;

import com.example.courseworkisbd.dto.PlayerDto;
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
    private final PlayerService playerService;
    private final UserServiceImpl userService;
    private final FootballClubService footballClubService;

    public PlayerController(PlayerService playerService, UserServiceImpl userService, FootballClubService footballClubService) {
        this.playerService = playerService;
        this.userService = userService;
        this.footballClubService = footballClubService;
    }

    @GetMapping(PLAYER_ADD)
    public String playerAddPage(Model model) {
        model.addAttribute("playerDto", new PlayerDto());
        return "player_add";
    }

    @GetMapping(PLAYERS)
    public String players(Model model) {
        List<PlayerDto> players = playerService.findAllPlayersDto();
        model.addAttribute("players", players);
        return "players";
    }

    @PostMapping(PLAYERS)
    public String addPlayer(@Valid @ModelAttribute("playerDto") PlayerDto playerDto,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "player_add";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        SportDirector sportDirector = userService.getSportDirectorByEmail(login);
        if (footballClubService.findFootballClubBySportDirector(sportDirector) != null) {
            playerService.savePlayerBySportDirector(playerDto, sportDirector);
        }
        return "index";
    }
}
