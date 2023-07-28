package com.ecodeup.apirest.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservaVuelo")
public class ReservaVuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;

    @Column(name = "personas")
    private Long personas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Long getPersonas() {
        return personas;
    }

    public void setPersonas(Long personas) {
        this.personas = personas;
    }

    public ReservaVuelo() {
    }

    public ReservaVuelo(User user, Vuelo vuelo, Long personas) {
        this.user = user;
        this.vuelo = vuelo;
        this.personas = personas;
    }
}
