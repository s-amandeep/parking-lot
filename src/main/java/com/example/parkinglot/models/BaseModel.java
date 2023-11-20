package com.example.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.xml.crypto.Data;
import java.util.Date;

@SuperBuilder
@Getter
@Setter
public abstract class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
