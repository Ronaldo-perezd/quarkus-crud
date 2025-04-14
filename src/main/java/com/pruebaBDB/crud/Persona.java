package com.pruebaBDB.crud;

import jakarta.validation.constraints.NotBlank;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.validation.constraints.Email;
import jakarta.persistence.Entity;

@Entity
public class Persona extends PanacheEntity {

    @NotBlank(message = "El nombre es obligatorio")
    public String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    public String email;

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }    
}