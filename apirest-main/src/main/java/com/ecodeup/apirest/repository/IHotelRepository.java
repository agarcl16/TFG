package com.ecodeup.apirest.repository;

import com.ecodeup.apirest.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByUbicacion(String ubicacion);
}
