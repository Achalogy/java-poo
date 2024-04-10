import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int option = 0;

      System.out.println("1. Contar Vocales");
      System.out.println("2. Crear figuras");
      System.out.println("3. Palindromos");
      System.out.println("4. Suma Diagonal");
      System.out.println("5. Gestión de notas");
      System.out.println("6. Salir");

      option = sc.nextInt();

      switch (option) {
        case 1:
          contarVocales();
          break;
        case 2:
          figuras();
          break;
        case 3:
          palindromos();
          break;
        case 4:
          sumaMatriz();
          break;
        case 5:
          gestionNotas();
          break;
        case 6:
          return;

        default:
          break;
      }
    }
  }

  public static void contarVocales() {
    Scanner sc = new Scanner(System.in);
    String palabra = "";
    int cantVocales = 0;

    System.out.print("Envie la Palabra en minusculas: ");
    palabra = sc.nextLine();

    for (int i = 0; i < palabra.length(); i++) {
      char c = palabra.charAt(i);
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        cantVocales++;
    }

    System.out.println("Hay " + cantVocales + " vocales");
  }

  public static void figuras() {
    Scanner sc = new Scanner(System.in);
    int tamano = 0;

    System.out.print("Tamaño: ");

    tamano = sc.nextInt();

    for (int i = 1; i <= tamano; i++) {
      System.out.println("*".repeat(i));
    }
    System.out.println("");
    for (int i = tamano; i >= 1; i--) {
      System.out.println("*".repeat(i));
    }
  }

  public static void palindromos() {
    Scanner sc = new Scanner(System.in);
    String palabra = "";
    boolean flag = true;

    System.out.print("Ingrese la palabra: ");

    palabra = sc.nextLine().toLowerCase();

    for (int i = 0; i < (int) palabra.length() / 2; i++) {
      if (palabra.charAt(i) != palabra.charAt(palabra.length() - (i + 1))) {
        flag = false;
        break;
      }
    }

    if (flag) {
      System.out.println("La palabra " + palabra + " es palindroma");
    } else {
      System.out.println("La palabra " + palabra + " no es palindroma");
    }
  }

  public static void sumaMatriz() {
    Scanner sc = new Scanner(System.in);
    int[][] matriz = new int[3][3];
    int suma = 0;

    System.out.println("Ingrese una matriz 3x3 separada por espacios: ");
    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        matriz[y][x] = sc.nextInt();
      }
    }

    for (int a = 0; a < 3; a++) {
      suma += matriz[a][a];
    }

    System.out.println("La suma es: " + suma);
  }

  public static void gestionNotas() {
    Scanner sc = new Scanner(System.in);
    int cantEstudiantes = 0;
    int cantExamenes = 0;
    int mejorPromedio = 0;
    int peorPromedio = 100;

    System.out.print("Cantidad de estudiantes: ");
    cantEstudiantes = sc.nextInt();
    System.out.print("Cantidad de examenes: ");
    cantExamenes = sc.nextInt();

    int[] promedios = new int[cantEstudiantes];

    for (int i = 0; i < cantEstudiantes; i++) {
      System.out
          .println(
              "Ingrese los examenes del estudiante #" + (i + 1) + ": ");

      for (int a = 0; a < cantExamenes; a++) {
        promedios[i] += sc.nextInt();
      }

      promedios[i] /= cantExamenes;

      mejorPromedio = Math.max(promedios[i], mejorPromedio);
      peorPromedio = Math.min(promedios[i], peorPromedio);

      System.out.println("Promedio: " + promedios[i]);
      System.out.print("Estado: ");
      if (promedios[i] >= 60) {
        System.out.println("Aprobado");
      } else {
        System.out.println("Reprobado");
      }
    }
    System.out.println("El mejor promedio es " + mejorPromedio);
    System.out.println("El peor promedio es " + peorPromedio);
  }
}