package interfaz;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import entidades.CentroAdopcion;
import entidades.Perro;
import entidades.Persona;
import utils.Utils;

public class Principal {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    CentroAdopcion PAJ = new CentroAdopcion("Protección Animal Javeriana");

    String menu[] = { "Rescatar un perro", "Adoptar un perro", "Cambiar el nombre de su mascota", "Ver base de datos",
        "Salir" };

    while (true) {
      int opt = Utils.printMenu(menu);

      switch (opt) {
        case 1:
          Perro perro = pedirDatosPerro(input, PAJ);
          PAJ.rescatarMascota(perro);

          System.out.println("Perro rescatado con exito!");
          Utils.pause();
          break;
        case 2: {
          System.out.println("Bienvenido al programa de adopción de " + PAJ.getNombre());
          System.out.print("\nCedula:     ");
          String cedula = input.nextLine();

          System.out.println("Estamos comprobando si ya estas en la base de datos...");
          Utils.pause();

          Persona cliente = PAJ.buscarCliente(cedula);

          if (cliente == null) {
            System.out.println(
                "Lo sentimos pero no estas registrado en nuestra base de datos, podrias llenar el siguiente formulario?");
            cliente = pedirDatosPersona(input);

            PAJ.agregarCliente(cliente);
            System.out.println("Registro exitoso!");

            cliente = PAJ.buscarCliente(cedula);
          }

          System.out.println("\nEstos son los perritos que tenemos en adopción en este momento: ");
          PAJ.mostrarInternos();
          System.out.println("\n");

          Perro perritoAdoptar = null;

          while (perritoAdoptar == null) {
            System.out.print("Dime el nombre del perrito que quieras: ");
            String nombrePerrito = input.nextLine();

            perritoAdoptar = PAJ.buscarPerro(nombrePerrito);
          }

          PAJ.darEnAdopcion(perritoAdoptar, cliente);
          System.out.println("Felicitaciones, has adoptado a " + perritoAdoptar.getNombre());

          Utils.pause();
          break;
        }
        case 3: {
          System.out.println("Bienvenido al programa de adopción de " + PAJ.getNombre());
          Persona cliente = null;

          while (cliente == null) {
            System.out.print("Permitame su cedula (-1 para salir):     ");
            String cedula = input.nextLine();

            if (cedula.equals("-1"))
              break;

            cliente = PAJ.buscarCliente(cedula);

            if (cliente == null) {
              System.out.println("Lo sentimos, esta cedula no esta registrada :(");
            }
          }

          if (cliente != null) {
            cliente.mostrarMascotas();
            System.out.println("\n");

            System.out.print("Nombre actual de la mascota a la que le deseas cambiar el nombre: ");
            String nombrePerrito = input.nextLine();
            System.out.print("Y el nombre que le deseas poner: ");
            String nuevoNombrePerrito = input.nextLine();

            cliente.cambiarNombreMascota(nombrePerrito, nuevoNombrePerrito);
            Utils.pause();
          }
        }
          break;
        case 4:
          PAJ.mostrarAdopciones();
          Utils.pause();
          break;

        default:
          return;
      }
    }

  }

  public static Perro pedirDatosPerro(Scanner input, CentroAdopcion centro) {
    Calendar fechaNacimiento = Calendar.getInstance();
    DateFormat format = new SimpleDateFormat("dd/MM/yyy");

    System.out.println("Bienvenido al formulario de adopción de " + centro.getNombre() + " :D");

    System.out.print("Nombre del perro:               ");
    String nombre = input.nextLine();
    System.out.print("Raza del perro:                 ");
    String raza = input.nextLine();
    System.out.print("Fecha de nacimiento (dd/mm/yy): ");
    String fNacimiento = input.nextLine();
    System.out.print("Peso del perro:                 ");
    int peso = input.nextInt();

    input.nextLine(); // Limpiar buffer

    try {
      fechaNacimiento.setTime(format.parse(fNacimiento));
    } catch (ParseException e) {
      e.getStackTrace();
    }

    return new Perro(raza, fechaNacimiento.getTime(), peso, nombre);
  }

  public static Persona pedirDatosPersona(Scanner input) {
    System.out.print("Nombre del usuario:     ");
    String nombre = input.nextLine();
    System.out.print("Edad del usuario:       ");
    int edad = input.nextInt();

    input.nextLine(); // Limpiar buffer

    System.out.print("Residencia del usuario: ");
    String residencia = input.nextLine();
    System.out.print("Cedula del usuario:     ");
    String cedula = input.nextLine();

    return new Persona(nombre, edad, residencia, cedula);
  }
}
