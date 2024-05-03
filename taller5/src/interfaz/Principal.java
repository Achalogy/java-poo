package interfaz;

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
        "Guardar en un archivo",
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
          String cedula = Utils.getStringMaxLength(10);

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
            String nombrePerrito = Utils.scLine();

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
            String cedula = Utils.getStringMaxLength(10);

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
            String nombrePerrito = Utils.scLine();
            System.out.print("Y el nombre que le deseas poner: ");
            String nuevoNombrePerrito = Utils.scLine();

            cliente.cambiarNombreMascota(nombrePerrito, nuevoNombrePerrito);
            Utils.pause();
          }
        }
          break;
        case 4:
          PAJ.mostrarAdopciones();
          Utils.pause();
          break;

        case 5:
          PAJ.saveToFile();
          Utils.pause();
          break;

        default:
          return;
      }
    }

  }

  public static Perro pedirDatosPerro(Scanner input, CentroAdopcion centro) {
    System.out.println("Bienvenido al formulario de adopción de " + centro.getNombre() + " :D");

    System.out.print("Nombre del perro:               ");
    String nombre = Utils.scLine();
    System.out.print("Raza del perro:                 ");
    String raza = Utils.scLine();
    System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
    Calendar fechaNacimiento = tomarEdadPerro();
    System.out.print("Peso del perro:                 ");
    int peso = Utils.scInt();

    return new Perro(raza, fechaNacimiento, peso, nombre);
  }

  public static Calendar tomarEdadPerro() {
    try {
      Calendar fechaNacimiento = Utils.scCalendar();
      float years = Utils.getAgeInYears(fechaNacimiento);

      if (years > 30)
        throw new Exception("Este perro es demasiado viejo para estar vivo");
      return fechaNacimiento;
    } catch (Exception e) {
      System.out.print("\n" + e.getMessage() + ": ");
      Utils.writeLog(e);
      return tomarEdadPerro();
    }

  }

  public static Persona pedirDatosPersona(Scanner input) {
    System.out.print("Nombre del usuario:     ");
    String nombre = Utils.scLine();
    System.out.print("Edad del usuario:       ");
    int edad = Utils.scInt();

    System.out.print("Residencia del usuario: ");
    String residencia = Utils.scLine();
    System.out.print("Cedula del usuario:     ");
    String cedula = Utils.getStringMaxLength(10);

    return new Persona(nombre, edad, residencia, cedula);
  }
}
