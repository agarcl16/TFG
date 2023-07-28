package com.ecodeup.apirest.controller;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecodeup.apirest.entity.Vuelo;
import com.ecodeup.apirest.service.VueloService;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private VueloService vueloService;


    @GetMapping
    public List<Vuelo> obtenerVuelos() {
        return vueloService.findAll();
    }

    @GetMapping("/{origen}/{destino}/{fecha}")
    public List<Vuelo> obtenerVuelosUbi(@PathVariable String origen, @PathVariable String destino, @PathVariable Date fecha) {
        return vueloService.findByOriDest(origen, destino, fecha);
    }

    @PostMapping
    public Vuelo crearVuelo(@RequestBody Vuelo vuelo) {
        return vueloService.save(vuelo);
    }


    @DeleteMapping("/{id}")
    public void eliminarVuelo(@PathVariable Integer id) {
        vueloService.delete(id);
    }
}
