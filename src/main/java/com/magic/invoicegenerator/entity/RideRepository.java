package com.magic.invoicegenerator.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    Map<Integer, List<Ride>> rideRepository;

    public RideRepository() {
        this.rideRepository = new HashMap<>();
    }

    public void add(Integer userId, List<Ride> rideList) {
        this.rideRepository.put(userId, rideList);
    }

    public List<Ride> getList(Integer userId) {
        return this.rideRepository.get(userId);
    }
}
