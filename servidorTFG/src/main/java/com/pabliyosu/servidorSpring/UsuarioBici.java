package com.pabliyosu.servidorSpring;

import javax.persistence.*;
import java.util.Date;

//Union usuario y bici
@Entity
@Table(name = "usuario_bici")
public class UsuarioBici {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(targetEntity = Bicicleta.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_bici", referencedColumnName = "id")
    private Bicicleta bicicleta;

    @Column
    private Date fecha;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
