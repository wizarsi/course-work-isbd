package com.example.courseworkisbd.controller;

import com.example.courseworkisbd.dto.FootballClubDto;
import com.example.courseworkisbd.dto.SportDirectorDto;
import com.example.courseworkisbd.entity.FootballClub;
import com.example.courseworkisbd.entity.FootballLeague;
import com.example.courseworkisbd.entity.SportDirector;
import com.example.courseworkisbd.repository.FootballClubRepository;
import com.example.courseworkisbd.service.FootballClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FootballClubController {
    private FootballClubService footballClubService;

    public FootballClubController(FootballClubService footballClubService) {
        this.footballClubService = footballClubService;
    }

    @GetMapping("/team_add")
    public String teamAddPage(Model model){
        FootballClubDto footballClubDto = new FootballClubDto();
        model.addAttribute("footballClubDto", footballClubDto);
        return "team_add";
    }

    @GetMapping("/teams")
    public String teams(Model model){
        List<FootballClubDto> footballClubs = footballClubService.findAllFootballClubsDto();
        model.addAttribute("footballClubs", footballClubs);
        return "teams";
    }

    @PostMapping("/team/add")
    public String registration(@Valid @ModelAttribute("footballClubDto") FootballClubDto footballClubDto,
                               BindingResult result,
                               Model model){
        FootballClub existing = footballClubService.findByFootballClubName(footballClubDto);
        if (existing != null) {
            result.rejectValue("name", null, "There is already an football club registered with that name");
        }
        /*if (result.hasErrors()) {
            model.addAttribute("footballClubDto", footballClubDto);
            System.out.println("blin");

            return "team_add";
        }*/
        footballClubService.saveFootballClub(footballClubDto);
        return "team_add";
    }

}
