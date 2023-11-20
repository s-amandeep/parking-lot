package com.example.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
public class Ticket extends BaseModel {
    private Vehicle vehicle;
    private Long spotId;
    private Date entryTime;
    private Long entryGateId;
}
