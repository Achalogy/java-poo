import java.util.Scanner;

class Perrito {
  String nombre;

  public void ladrar() {
    System.out.println("Guau!");
  }

  public void saludar() {
    System.out.println("Hola mi nombre es " + nombre);
  }
}

public class App {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Perrito perrito = new Perrito();

    System.err.print("Nombre: ");
    perrito.nombre = entrada.nextLine();
    System.err.println("");

    System.err.println("Hola, soy " + perrito.nombre + " ¿que quieres que haga?");

    int opt;

    while (true) {
      do {
        System.out.println("1. Ladrar");
        System.out.println("2. Saludar");
        System.out.println("3. Salir del programa");
        System.out.print("> ");
        opt = entrada.nextInt();
      } while (opt < 1 || opt > 3);

      switch (opt) {
        case 1:
          perrito.ladrar();
          break;
        case 2:
          perrito.saludar();
          break;
        case 3:
          entrada.close();
          return;
      }

      entrada.nextLine();
    }
  }
}
