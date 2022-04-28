package com.kindsonthegenius.fleetmsv2.fleet.services;

import com.kindsonthegenius.fleetmsv2.fleet.models.Vehicle;
import com.kindsonthegenius.fleetmsv2.fleet.repositories.VehicleRepository;
import com.kindsonthegenius.fleetmsv2.reports.model.Truck;
import com.kindsonthegenius.fleetmsv2.reports.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private TruckRepository truckRepository;
	
	//Get All Vehicles
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}	
	
	//Get Vehicle By Id
	public Vehicle findById(int id) {
		return vehicleRepository.findById(id).orElse(null);
	}	
	
	//Delete Vehicle
	public void delete(int id) {
		Truck truck = truckRepository.findFirstByOrderByIdDesc();
		truck.setTruckCount(truck.getTruckCount()-1);
		truckRepository.save(truck);

		vehicleRepository.deleteById(id);
	}
	
	//Update Vehicle
	public void save(Vehicle vehicle) {
		Truck truck = truckRepository.findFirstByOrderByIdDesc();
		truck.setTruckCount(truck.getTruckCount()+1);
		truckRepository.save(truck);
		vehicleRepository.save(vehicle);
	}

}
