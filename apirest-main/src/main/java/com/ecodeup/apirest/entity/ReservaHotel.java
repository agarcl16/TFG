package com.ecodeup.apirest.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reservaHotel")
public class ReservaHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "fechaDesde")
    private Date fechaDesde;

    @Column(name = "fechaHasta")
    private Date fechaHasta;

    @Column(name = "personas")
    private Long personas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Long getPersonas() {
        return personas;
    }

    public void setPersonas(Long personas) {
        this.personas = personas;
    }

    public ReservaHotel() {
    }

    public ReservaHotel(User user, Hotel hotel, Date fechaDesde, Date fechaHasta, Long personas) {
        this.user = user;
        this.hotel = hotel;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.personas = personas;
    }
}
