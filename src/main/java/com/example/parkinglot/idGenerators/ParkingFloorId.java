package com.example.parkinglot.idGenerators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingFloorId {

    private static AtomicLong idCounter = new AtomicLong();

    public static Long nextId() {
        return idCounter.getAndIncrement();
    }
}
