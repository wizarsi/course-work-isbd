package com.example.courseworkisbd.controller;

import com.example.courseworkisbd.dto.PlayerDto;
import com.example.courseworkisbd.entity.Player;
import com.example.courseworkisbd.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player_add")
    public String playerAddPage(Model model) {
        PlayerDto playerDto = new PlayerDto();
        model.addAttribute("playerDto", playerDto);
        return "player_add";
    }

    @GetMapping("/players")
    public String players(Model model) {
        List<PlayerDto> players = playerService.findAllPlayersDto();
        model.addAttribute("players", players);
        return "players";
    }

    @GetMapping("/myTeam")
    public String myTeam(Model model) {
        List<PlayerDto> players = playerService.findAllPlayersDtoBySportDirector();
        model.addAttribute("myTeam", players);
        return "myTeam";
    }

    @PostMapping("/players/add")
    public String addPlayer(@Valid @ModelAttribute("playerDto") PlayerDto playerDto,
                            BindingResult result, Model model) {
        playerService.savePlayer(playerDto);
        return "player_add";
    }



}
