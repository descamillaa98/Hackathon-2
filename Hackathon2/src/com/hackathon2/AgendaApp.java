package com.hackathon2;

import com.hackathon2.Entities.Agenda;
import com.hackathon2.Entities.Contacto;

import java.util.Scanner;

public class AgendaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la capacidad máxima de la agenda: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Agenda agenda = new Agenda(capacidad);
        int opcion = 0;

        do {
            System.out.println("\n==================================");
            System.out.println("      MENÚ DE GESTIÓN DE AGENDA   ");
            System.out.println("==================================");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar si existe contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Verificar si la agenda está llena");
            System.out.println("8. Mostrar espacios libres");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombreAdd = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellidoAdd = scanner.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telAdd = scanner.nextLine();
                    try {
                        Contacto nuevo = new Contacto(nombreAdd, apellidoAdd, telAdd);
                        agenda.aniadirContacto(nuevo);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese nombre: ");
                    String nombreEx = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellidoEx = scanner.nextLine();
                    Contacto cEx = new Contacto(nombreEx, apellidoEx);
                    agenda.existeContacto(cEx);
                    break;

                case 3:
                    agenda.listarContactos();
                    break;

                case 4:
                    System.out.print("Ingrese nombre: ");
                    String nombreB = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellidoB = scanner.nextLine();
                    agenda.buscaContacto(nombreB, apellidoB);
                    break;

                case 5:
                    System.out.print("Ingrese nombre del contacto a eliminar: ");
                    String nombreDel = scanner.nextLine();
                    System.out.print("Ingrese apellido del contacto a eliminar: ");
                    String apellidoDel = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto(nombreDel, apellidoDel));
                    break;

                case 6:
                    System.out.print("Ingrese nombre del contacto: ");
                    String nombreMod = scanner.nextLine();
                    System.out.print("Ingrese apellido del contacto: ");
                    String apellidoMod = scanner.nextLine();
                    System.out.print("Ingrese el nuevo teléfono: ");
                    String nuevoTel = scanner.nextLine();
                    agenda.modificarTelefono(nombreMod, apellidoMod, nuevoTel);
                    break;

                case 7:
                    agenda.agendaLlena();
                    break;

                case 8:
                    System.out.println("Espacios libres disponibles: " + agenda.espacioLibres());
                    break;

                case 9:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}
