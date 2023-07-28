package com.ecodeup.apirest.controller;

import java.util.List;

import com.ecodeup.apirest.entity.ReservaVuelo;
import com.ecodeup.apirest.service.ReservaVueloService;
import com.ecodeup.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/reservaVuelo")
@CrossOrigin(origins = "*")
public class ReservaVueloController {

    @Autowired
    private ReservaVueloService reservaVueloService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ReservaVuelo> obtenerReserva() {
        return reservaVueloService.findAll();
    }

    @PostMapping
    public ReservaVuelo crearReserva(@RequestBody ReservaVuelo reservaVuelo) {
        return reservaVueloService.save(reservaVuelo);
    }

    @GetMapping("/{user}")
    public List<ReservaVuelo> obtenerReservasByUser(@PathVariable Integer user){
        return reservaVueloService.fingByUser(userService.get(user));
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable Integer id) {
        reservaVueloService.delete(id);
    }
}
