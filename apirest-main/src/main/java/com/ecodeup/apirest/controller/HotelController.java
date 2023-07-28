package com.ecodeup.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecodeup.apirest.entity.Hotel;
import com.ecodeup.apirest.service.HotelService;
@RestController
@RequestMapping("/api/hoteles")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> obtenerHoteles() {
        return hotelService.findAll();
    }

    @GetMapping("/{ubi}")
    public List<Hotel> obtenerHotelesUbi(@PathVariable String ubi) {
        return hotelService.findByUbicacion(ubi);
    }

    @PostMapping
    public Hotel crearHotel(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }


    @DeleteMapping("/{id}")
    public void eliminarHotel(@PathVariable Integer id) {
        hotelService.delete(id);
    }
}
