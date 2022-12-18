package com.example.courseworkisbd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="football_clubs")
public class FootballClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coach", referencedColumnName = "id")
    private Coach coach;

    @Column(nullable = false)
    private int playersCount;

    @Column(nullable = false)
    private int trophiesCount;

    @Column(nullable = false)
    private int budget;

    @Column(nullable = false)
    private int rating;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sport_director", referencedColumnName = "id")
    private SportDirector sportDirector;
}
