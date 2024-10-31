package doit.week4hw.controller.dto;

public record OrderCreateRequest (
    Long item,
    int count
){}
