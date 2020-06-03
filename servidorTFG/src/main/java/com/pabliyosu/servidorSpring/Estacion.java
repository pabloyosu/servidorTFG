package com.pabliyosu.servidorSpring;


import javax.persistence.*;

//Listado estaciones
@Entity
@Table(name = "estaciones")
public class Estacion {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private double longitud;

    @Column
    private double latitud;

    @Column
    private String calle;

    @Column(name = "bicis_disponibles")
    private int bicisDisponibles;

    @Column(name = "anclajes_disponibles")
    private int anclajesDiponibles;

    @Column
    private int capacidad;

    @Column(name = "estacion_abierta")
    private Boolean estacionAbierta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getBicisDisponibles() {
        return bicisDisponibles;
    }

    public void setBicisDisponibles(int bicisDisponibles) {
        this.bicisDisponibles = bicisDisponibles;
    }

    public int getAnclajesDiponibles() {
        return anclajesDiponibles;
    }

    public void setAnclajesDiponibles(int anclajesDiponibles) {
        this.anclajesDiponibles = anclajesDiponibles;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getEstacionAbierta() {
        return estacionAbierta;
    }

    public void setEstacionAbierta(Boolean estacionAbierta) {
        this.estacionAbierta = estacionAbierta;
    }
}
