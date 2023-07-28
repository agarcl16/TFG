package com.ecodeup.apirest.service;

import java.util.List;

import com.ecodeup.apirest.entity.ReservaVuelo;
import com.ecodeup.apirest.entity.User;
import com.ecodeup.apirest.repository.IReservaVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaVueloService {
    @Autowired
    private IReservaVueloRepository reservaVueloRepository;

    public List<ReservaVuelo> findAll(){
        return reservaVueloRepository.findAll();
    }

    public ReservaVuelo save(ReservaVuelo user) {
        return reservaVueloRepository.save(user);
    }

    public ReservaVuelo get(Integer id) {
        return reservaVueloRepository.findById(id).get();
    }

    public void delete(Integer id) {
        reservaVueloRepository.deleteById(id);
    }

    public List<ReservaVuelo> fingByUser(User user) {
        return reservaVueloRepository.findByUser(user);
    }
}
