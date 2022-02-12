package com.controller;

import com.model.Cargo;
import com.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    CargoService service;

    @PostMapping(value = "price")
    public String getPrice(@Valid @RequestBody Cargo cargo){
        return  String.valueOf(service.getDeliveryCost(cargo));
    }

    @PostMapping(value = "send")
    public String sendCargo(@Valid @RequestBody Cargo cargo){
        return service.send(cargo);
    }

    @GetMapping(value = "receive")
    public String getCargo(@PathVariable int id){
        return service.receive(id);
    }

}
