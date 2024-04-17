package ru.gb.issue_service;

import lombok.Data;

import java.util.UUID;

@Data
public class Issue {
    private UUID id;
    private Book book;
    private Reader reader;
}
