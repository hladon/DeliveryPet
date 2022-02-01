package com.controller;

import com.model.Cargo;
import com.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    CargoService service;

    @PostMapping(value = "getPrice")
    public String getPrice(@RequestBody Cargo cargo){
        return "get price "+cargo;
    }

    @PostMapping(value = "send")
    public String sendCargo(@RequestBody Cargo cargo){
        return "sendCargo " +cargo;
    }

    @GetMapping(value = "receive")
    public String getCargo(@RequestParam int id){
        return "getCargo " +id;
    }

}
