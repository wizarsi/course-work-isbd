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
@Table(name = "coasts")
public class Coast extends BaseEntity{
    @Column
    private String currencyRecipient;

    @Column
    private String currencySender;

    @Column
    private int exchangeRate;
}
