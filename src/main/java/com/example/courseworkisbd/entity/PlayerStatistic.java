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
@Table(name = "player_statistics")
public class PlayerStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "won_matches", nullable = false)
    private int wonMatches;

    @Column(name = "count_matches", nullable = false)
    private int countMatches;

    @Column(name = "count_trophies", nullable = false)
    private int countTrophies;

    @Column(name = "count_assists", nullable = false)
    private int countAssists;

    @Column(name = "count_goals", nullable = false)
    private int countGoals;

    @Column(name = "red_cards", nullable = false)
    private int redCards;

    @Override
    public String toString() {
        return wonMatches +
                ":" + countMatches +
                ":" + countTrophies +
                ":" + countAssists +
                ":" + countGoals +
                ":" + redCards;
    }

    public PlayerStatistic(String stat) {
        String[] ints = stat.split(":");
        this.wonMatches = Integer.getInteger(ints[0]);
        this.countMatches = Integer.getInteger(ints[1]);
        this.countTrophies = Integer.getInteger(ints[2]);
        this.countAssists = Integer.getInteger(ints[3]);
        this.countGoals = Integer.getInteger(ints[4]);
        this.redCards = Integer.getInteger(ints[5]);
    }
}
