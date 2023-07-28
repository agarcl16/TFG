package com.ecodeup.apirest.repository;

import com.ecodeup.apirest.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, Integer> {

    List<Vuelo> findByOrigen(String origen);
}
