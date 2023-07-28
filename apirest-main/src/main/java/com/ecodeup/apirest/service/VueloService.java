package com.ecodeup.apirest.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodeup.apirest.entity.Vuelo;
import com.ecodeup.apirest.repository.IVueloRepository;

@Service
public class VueloService {
    @Autowired
    private IVueloRepository vueloRepository;

    public List<Vuelo> findAll(){
        return vueloRepository.findAll();
    }

    public Vuelo save(Vuelo user) {
        return vueloRepository.save(user);
    }

    public List<Vuelo> findByOriDest(String origen, String destino, Date fecha){
        List<Vuelo> vuelosReturn = new ArrayList<>();
        List<Vuelo> vuelos =  vueloRepository.findByOrigen(origen);
        for(Vuelo vuelo : vuelos){
            if(vuelo.getDestino().equals(destino)&&vuelo.getFecha().equals(fecha)) vuelosReturn.add(vuelo);
        }
        return vuelosReturn;
    }
    public Vuelo get(Integer id) {
        return vueloRepository.findById(id).get();
    }

    public void delete(Integer id) {
        vueloRepository.deleteById(id);
    }
}
