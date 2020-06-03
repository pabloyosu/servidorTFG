package com.pabliyosu.servidorSpring;

import javax.persistence.*;
import java.util.Date;

//Tabla carreras
@Entity
@Table(name="carrera")
public class Carrera {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date fecha;

    @Column
    private Date inicio;

    @Column(name="final")
    private Date fnl;

    @Column
    private int duracion;

    @Column
    private float precio;

    //Referenciar id_usuario a carreras
    @OneToOne(targetEntity = Usuario.class,fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    //Referenciar id_bici a carrera
    @OneToOne(targetEntity = Bicicleta.class,fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_bici", referencedColumnName = "id")
    private Bicicleta bicicleta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFnl() {
        return fnl;
    }

    public void setFnl(Date fnl) {
        this.fnl = fnl;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
