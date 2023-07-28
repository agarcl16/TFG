package com.ecodeup.apirest.controller;

import java.util.List;

import com.ecodeup.apirest.entity.ReservaHotel;
import com.ecodeup.apirest.entity.User;
import com.ecodeup.apirest.service.ReservaHotelService;
import com.ecodeup.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/reservaHotel")
@CrossOrigin(origins = "*")
public class ReservaHotelController {

    @Autowired
    private ReservaHotelService reservaHotelService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ReservaHotel> obtenerReservas() {
        return reservaHotelService.findAll();
    }

    @GetMapping("/{user}")
    public List<ReservaHotel> obtenerReservasByUser(@PathVariable Integer user){
        return reservaHotelService.fingByUser(userService.get(user));
    }

    @PostMapping
    public ReservaHotel crearReserva(@RequestBody ReservaHotel reservaHotel) {
        return reservaHotelService.save(reservaHotel);
    }


    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable Integer id) {
        reservaHotelService.delete(id);
    }
}
