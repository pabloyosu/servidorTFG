package com.pabliyosu.servidorSpring;

import javax.persistence.*;

//Listado usuario
@Entity
@Table(name = "usuario")
public class Usuario  {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String contrasenia;

    @Column
    private String paypal;

    @Column
    private String email;

    @Column
    private Double saldo;

    @Column
    private boolean admin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPaypal() {
        return paypal;
    }

    public void setPaypal(String paypal) {
        this.paypal = paypal;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", paypal='" + paypal + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}