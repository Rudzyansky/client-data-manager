package ru.ft.cdm.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CardDto {
    private final long number;
    private final short pin;
}
