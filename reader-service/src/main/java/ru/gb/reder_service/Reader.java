package ru.gb.reder_service;

import lombok.Data;

import java.util.UUID;

@Data
public class Reader {
    private UUID id;
    private String name;
}
