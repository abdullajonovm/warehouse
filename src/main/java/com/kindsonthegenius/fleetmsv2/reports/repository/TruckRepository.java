package com.kindsonthegenius.fleetmsv2.reports.repository;

import com.kindsonthegenius.fleetmsv2.reports.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer> {
    Truck findFirstByOrderByIdDesc();
}
