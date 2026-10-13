package com.hackathon2.Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {

        if (!validarNombre(nombre) || !validarNombre(apellido)) {
            throw new IllegalArgumentException(
                    "El nombre y apellido no pueden estar vacíos"
            );
        }
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();

        if(validarTelefono(telefono)){
            this.telefono = telefono;
        }

    }//constructor 1 Contacto

    public Contacto(String nombre, String apellido) {
        if (!validarNombre(nombre) || !validarNombre(apellido)) {
            throw new IllegalArgumentException(
                    "El nombre y apellido no pueden estar vacíos"
            );
        }

        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
    }// constructor 2 Contacto

    public boolean validarNombre(String nombre){
        if(nombre == null || nombre.isBlank()){
            System.out.println("El nombre o apellido no tiene el formato correcto");
            return false;
        }
        return true;
    }// validarNombre

    public boolean validarTelefono(String telefono){
        String regex = "^(\\+\\d{1,3}[- ]?)?\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefono);
        if (matcher.matches() && !telefono.isBlank()) {
            System.out.println("El número de teléfono es válido.");
            return true;
        } else {
            System.out.println("El número de teléfono no es válido.");
            return false;
        }
    }// validarTelefono

    // Dos contactos son iguales si tienen el mismo nombre y apellido
    public boolean existeContacto(Object obj){

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto otro = (Contacto) obj;
        return this.nombre.trim().equalsIgnoreCase(otro.nombre.trim()) &&
                this.apellido.trim().equalsIgnoreCase(otro.apellido.trim());

    }

    public String getNombre() {
        return nombre;
    }// getNombre

    public void setNombre(String nombre) {
        if(validarNombre(nombre)){
            this.nombre = nombre;
        }
    }// setNombre

    public String getApellido() {
        return apellido;
    }// getApellido

    public void setApellido(String apellido) {
        if (validarNombre(apellido)){
            this.apellido = apellido;
        }
    }// setApellido

    public String getTelefono() {
        return telefono;
    }// getTelefono

    public void setTelefono(String telefono) {
        if(validarTelefono(telefono)){
            this.telefono = telefono;
        }
    }// setTelefono

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }// toString

}// class Contacto