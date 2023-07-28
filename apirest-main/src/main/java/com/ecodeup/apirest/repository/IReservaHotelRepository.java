package com.ecodeup.apirest.repository;

import com.ecodeup.apirest.entity.ReservaHotel;
import com.ecodeup.apirest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaHotelRepository extends JpaRepository<ReservaHotel, Integer> {
    List<ReservaHotel> findByUser(User user);
}
