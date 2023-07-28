package com.ecodeup.apirest.service;

import java.util.List;

import com.ecodeup.apirest.entity.ReservaHotel;
import com.ecodeup.apirest.repository.IReservaHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecodeup.apirest.entity.User;

@Service
public class ReservaHotelService {
    @Autowired
    private IReservaHotelRepository reservaHotelRepository;

    public List<ReservaHotel> findAll(){
        return reservaHotelRepository.findAll();
    }

    public ReservaHotel save(ReservaHotel user) {
        return reservaHotelRepository.save(user);
    }

    public ReservaHotel get(Integer id) {
        return reservaHotelRepository.findById(id).get();
    }

    public void delete(Integer id) {
        reservaHotelRepository.deleteById(id);
    }

    public List<ReservaHotel> fingByUser(User user) {
        return reservaHotelRepository.findByUser(user);
    }
}
