package com.example.courseworkisbd.service;

import com.example.courseworkisbd.dto.PlayerDto;
import com.example.courseworkisbd.dto.TransferRequestDto;
import com.example.courseworkisbd.entity.*;
import com.example.courseworkisbd.repository.PlayerRepository;
import com.example.courseworkisbd.repository.TransferRepository;
import com.example.courseworkisbd.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {
    private PlayerRepository playerRepository;
    private TransferRepository transferRepository;
    private FootballClubService footballClubService;

    public TransferService(PlayerRepository playerRepository, TransferRepository transferRepository,FootballClubService footballClubService) {
        this.playerRepository = playerRepository;
        this.transferRepository = transferRepository;
        this.footballClubService = footballClubService;

    }

    public List<TransferRequestDto> findAllTransfersDto() {
        List<TransferRequest> transferRequests = transferRepository.findAll();
        return transferRequests.stream().map((transferRequest) -> convertEntityToDto(transferRequest))
                .collect(Collectors.toList());
    }


    private TransferRequestDto convertEntityToDto(TransferRequest transferRequest) {
        TransferRequestDto transferRequestDto = new TransferRequestDto();
        transferRequestDto.setValue(transferRequest.getValue());
        transferRequestDto.setCurrency(transferRequest.getCurrency());
        transferRequestDto.setPosition(transferRequest.getPlayer().getPosition());
        transferRequestDto.setName(transferRequest.getPlayer().getName());
        transferRequestDto.setSurname(transferRequest.getPlayer().getSurname());
        transferRequestDto.setFootballClub(transferRequest.getFootballClub().getName());
        transferRequestDto.setAge(transferRequest.getPlayer().getAge());
        return transferRequestDto;
    }

    public void saveTransferRequest(TransferRequestDto transferRequestDto, SportDirector sportDirector) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setFootballClub(footballClubService.findFootballClubBySportDirector(sportDirector));
        transferRequest.setPlayer(playerRepository.findByNameAndSurname(transferRequestDto.getName(), transferRequestDto.getSurname()));
        transferRequest.setValue(transferRequestDto.getValue());
        transferRequest.setCurrency(sportDirector.getFootballClub().getCurrency());
        transferRepository.save(transferRequest);
    }

}
