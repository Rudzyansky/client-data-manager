package ru.ft.cdm.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Card {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;

    private Short pinCode;
}
