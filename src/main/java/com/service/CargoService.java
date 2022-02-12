package com.service;

import com.exeptions.CityNotExistExсeption;
import com.model.Cargo;
import com.model.Status;
import com.repository.CargoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoService {
    final int COST_PER_KM=10;
    Logger logger = LoggerFactory.getLogger(CargoService.class);
    @Autowired
    CargoRepository repository;

    public int getDeliveryCost(Cargo cargo) {
        Integer distance=repository.findDistance(cargo.getDeparture(),cargo.getDestination());
        if(distance==null)
            throw new CityNotExistExсeption("Some of the city doesn`t exist or has wrong name");
        int weight= (cargo.getWeightInKg()>=cargo.getVolumeInLitres()) ? cargo.getWeightInKg() : cargo.getVolumeInLitres();
        return distance*weight*COST_PER_KM/100;
    }

    public String receive(int id) {
        Optional<Cargo> cargo = repository.findById(id);
        if (cargo.isEmpty() )
            return "Such delivery doesn`t exist";
        Cargo sendCargo=cargo.get();
        sendCargo.setStatus(Status.RECEIVED);
        repository.save(sendCargo);
        return cargo.toString();
    }

    public String send(Cargo cargo) {
        cargo.setStatus(Status.TRANSPORT);
        repository.save(cargo);
        return "Cargo was send";
    }
}
