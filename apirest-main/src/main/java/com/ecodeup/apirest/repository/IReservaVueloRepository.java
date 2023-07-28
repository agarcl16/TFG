package com.ecodeup.apirest.repository;

import com.ecodeup.apirest.entity.ReservaVuelo;
import com.ecodeup.apirest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaVueloRepository extends JpaRepository<ReservaVuelo, Integer> {
    List<ReservaVuelo> findByUser(User user);
}
