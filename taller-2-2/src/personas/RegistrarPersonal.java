package personas;

import java.util.Scanner;
import entidades.CPersona;
import utils.Utils;

public class RegistrarPersonal {
  public static void main(String Args[]) {
    Scanner input = new Scanner(System.in);
    int tamano = 0;
    int p = 0;

    System.out.print("Ingrese el tamaño del arreglo personas: ");
    tamano = input.nextInt();

    CPersona personas[] = new CPersona[tamano];

    String menuOptions[] = { "Agregar persona", "Total de salarios minimos", "Personas con IMC no saludable", "Salir" };

    while (true) {
      int option = Utils.printMenu(menuOptions);

      switch (option) {
        case 1:
          if (p == tamano) {
            System.out.println("Ya no se pueden agregar más personas, máximo alcanzado.");
            break;
          }
          personas[p] = crearPersona();
          p++;
          break;
        case 2:
          float totalSMinimos = 0;
          for (int i = 0; i < p; i++) {
            totalSMinimos += personas[i].salariosMinimos();
          }
          System.out.printf("La empresa debe de pagar: %.1f salarios mínimos\n", totalSMinimos);
          Utils.pause();
          break;
        case 3:
          for (int i = 0; i < p; i++) {
            float imc = personas[i].calcularIMC();
            if (imc < 18.5 || imc > 24.9) {
              System.out.println(personas[i].getNombre() + " no tiene un IMC saludable");
              System.out.println("Sexo:             " + personas[i].getSexo());
              System.out.println("Cedula:           " + personas[i].getCedula());
              System.out.printf("Salarios Mínimos: %.1f\n\n", personas[i].salariosMinimos());
            }
          }
          Utils.pause();
          break;
        case 4:
          return;
      }
    }
  }

  public static CPersona crearPersona() {
    String nombre;
    short edad;
    int cedula;
    char sexo;
    float peso;
    float altura;
    float salario;
    char sexValidChars[] = { 'f', 'F', 'm', 'M' };
    Scanner input = new Scanner(System.in);

    System.out.print("Nombre de la persona:  ");
    nombre = input.nextLine();
    System.out.print("Edad de la persona:    ");
    edad = input.nextShort();
    System.out.print("Cedula de la persona:  ");
    cedula = input.nextInt();
    System.out.print("Peso de la persona:    ");
    peso = input.nextFloat();
    System.out.print("Altura de la persona:  ");
    altura = input.nextFloat();
    System.out.print("Salario de la persona: ");
    salario = input.nextInt();
    sexo = ("" +
        Utils.askForChar("Sexo de la persona:    ", sexValidChars)).toUpperCase().charAt(0);

    CPersona persona = new CPersona(nombre, edad, cedula, sexo, peso, altura, salario);

    System.out.println(persona.getNombre() + " cread@ con exito");

    Utils.pause();

    return persona;
  }
}
