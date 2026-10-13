package com.hackathon2.Entities;
import java.util.Arrays;
import java.util.Comparator;

public class Agenda {

    private Contacto[] contactos;
    private int cantidad;
    private int contadorContactos = 0;

    public Agenda() {
        this(10);
    }// constructor 1 Agenda

    public Agenda(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero"
            );
        }

        this.cantidad = cantidad;
        this.contactos = new Contacto[cantidad];
        this.contadorContactos = 0;
    }// constructor 2 Agenda

    // Verificar si existe un contacto
    public boolean existeContacto(Contacto c) {

        for (int i = 0; i < contadorContactos; i++) {
            if (contactos[i].existeContacto(c)) {
                System.out.println("El teléfono del contacto es: " + contactos[i].getTelefono());
                return true;
            }
        }
        System.out.println("El contacto no existe");
        return false;
    }

    // Añadir contacto
    public void aniadirContacto(Contacto c) {

        if (c == null ||
                c.getNombre() == null ||
                c.getApellido() == null ||
                c.getNombre().isBlank() ||
                c.getApellido().isBlank()) {

            System.out.println("El contacto tiene datos inválidos");
            return;
        }

        if (existeContacto(c)) {
            System.out.println("El contacto ya existe");
            return;
        }

        if (agendaLlena()) {
            //System.out.println("La agenda está llena");
            return;
        }

        contactos[contadorContactos] = c;
        contadorContactos++;

        System.out.println("Contacto añadido correctamente");
    }

    public void listarContactos() {

        if (contadorContactos == 0) {
            System.out.println("La agenda está vacía");
            return;
        }

        Contacto[] ordenados =
                Arrays.copyOf(contactos, contadorContactos);

        Arrays.sort(ordenados,
                Comparator.comparing(
                        Contacto::getNombre,
                        String.CASE_INSENSITIVE_ORDER
                ).thenComparing(
                        Contacto::getApellido,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        for (Contacto contacto : ordenados) {
            System.out.println(
                    contacto.getNombre() + " " +
                            contacto.getApellido() + " - " +
                            contacto.getTelefono()
            );
        }
    }// listarContactos

        public void buscaContacto(String nombre, String apellido) {

        for (int i = 0; i < contadorContactos; i++) {

            Contacto c = contactos[i];

            if (c.getNombre().equalsIgnoreCase(nombre.trim()) &&
                    c.getApellido().equalsIgnoreCase(apellido.trim())) {

                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }

        System.out.println("Contacto no encontrado");
    }// buscaContacto

    // Eliminar contacto
    public void eliminarContacto(Contacto c) {

        for (int i = 0; i < contadorContactos; i++) {

            if (contactos[i].existeContacto(c)) {

                for (int j = i; j < contadorContactos - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }

                contactos[contadorContactos - 1] = null;
                contadorContactos--;

                System.out.println("Contacto eliminado correctamente");
                return;
            }
        }

        System.out.println("El contacto no existe");
    }

    // Modificar teléfono
    public void modificarTelefono(
            String nombre,
            String apellido,
            String nuevoTelefono) {

        for (int i = 0; i < contadorContactos; i++) {

            Contacto c = contactos[i];

            if (c.getNombre().equalsIgnoreCase(nombre.trim()) &&
                    c.getApellido().equalsIgnoreCase(apellido.trim())) {

                c.setTelefono(nuevoTelefono);

                System.out.println("Teléfono actualizado");
                return;
            }
        }

        System.out.println("Contacto no encontrado");
    }

    public boolean agendaLlena() {
        if (contadorContactos == cantidad) {
            System.out.println("No hay espacio disponible para nuevos contactos");
            return true;
        } else {
            System.out.println("Si hay espacio disponible para nuevos contactos");
            return false;
        }
    }// agendaLlena

    public int espacioLibres() {
        return cantidad - contadorContactos;
    }// espacioLibres

    //Getters & Setters

    public Contacto[] getContactos() {
        return contactos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getContadorContactos() {
        return contadorContactos;
    }

}
