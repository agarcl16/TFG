package com.ecodeup.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecodeup.apirest.entity.Hotel;
import com.ecodeup.apirest.repository.IHotelRepository;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private IHotelRepository hotelRepository;

    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    public List<Hotel> findByUbicacion(String ubicacion){
        return hotelRepository.findByUbicacion(ubicacion);
    }

    public Hotel save(Hotel user) {
        return hotelRepository.save(user);
    }

    public Hotel get(Integer id) {
        return hotelRepository.findById(id).get();
    }

    public void delete(Integer id) {
        hotelRepository.deleteById(id);
    }
}
