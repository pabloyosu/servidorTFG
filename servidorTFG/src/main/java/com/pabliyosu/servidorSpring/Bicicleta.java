package com.pabliyosu.servidorSpring;

import javax.persistence.*;
import java.util.List;

//Tabla bicicleta
@Entity
@Table(name = "bici")
public class Bicicleta {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private Boolean estado;

    @Column
    private double longitud;

    @Column
    private double latitud;

    @Column
    private int bateria;

    //Referenciar id estacion
    @OneToOne(targetEntity = Estacion.class,fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_estacion", referencedColumnName = "id")
    private Estacion estacion;

    @Column(name="estado_enum")
    private String estadoEnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public String getEstadoEnum() {
        return estadoEnum;
    }

    public void setEstadoEnum(String estadoEnum) {
        this.estadoEnum = estadoEnum;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "id=" + id +
                ", estado=" + estado +
                ", lng=" + longitud +
                ", lat=" + latitud +
                ", bateria=" + bateria +
                ", estacion=" + estacion +
                ", estadoEnum='" + estadoEnum + '\'' +
                '}';
    }
}
