package com.example.courseworkisbd.repository;

import com.example.courseworkisbd.entity.Player;
import com.example.courseworkisbd.entity.SportDirector;
import com.example.courseworkisbd.entity.TransferRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<TransferRequest, Long> {

}
