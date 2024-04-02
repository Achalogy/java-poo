import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    String[] menuOptions = { "Contar vocales", "Figuras", "Verificación de palindromos",
        "Suma de la diagonal de matrices", "Sistema de gestión de notas" };

    while (true) {
      int opt = printMenu(menuOptions);
      clearConsole();

      switch (opt) {
        case 1:
          contarVocales();
          break;
        case 2:
          figuras();
          break;
        case 3:
          palindromo();
          break;
        case 4:
          sumaMatriz();
          break;
        case 5:
          gestionNotas();
          break;

        default:
          input.close();
          return;
      }
      pause();
    }
  }

  public static void contarVocales() {
    Scanner input = new Scanner(System.in);

    System.out.print("Ingrese la palabra en minusculas: ");

    String palabra = input.nextLine();

    int[] vocales = new int[5];

    for (int i = 0; i < palabra.length(); i++) {
      char c = palabra.charAt(i);

      switch (c) {
        case 'a':
          vocales[0]++;
          break;
        case 'e':
          vocales[1]++;
          break;
        case 'i':
          vocales[2]++;
          break;
        case 'o':
          vocales[3]++;
          break;
        case 'u':
          vocales[4]++;
          break;
      }
    }

    System.out.println("Cantidad de repeticiones de (a): " + vocales[0]);
    System.out.println("Cantidad de repeticiones de (e): " + vocales[1]);
    System.out.println("Cantidad de repeticiones de (i): " + vocales[2]);
    System.out.println("Cantidad de repeticiones de (o): " + vocales[3]);
    System.out.println("Cantidad de repeticiones de (u): " + vocales[4]);
  }

  public static void figuras() {
    Scanner input = new Scanner(System.in);
    System.out.print("El tamaño del que quieres los triángulos: ");

    int tam = input.nextInt();

    for (int i = 1; i <= tam; i++) {
      System.out.println("*".repeat(i));
    }
    System.out.println("");
    for (int i = tam; i >= 1; i--) {
      System.out.println("*".repeat(i));
    }
  }

  public static void palindromo() {
    Scanner input = new Scanner(System.in);

    System.out.print("Ingrese la palabra en minusculas: ");

    String palabra = input.nextLine().toLowerCase();

    String left = palabra.substring(0, (int) palabra.length() / 2);
    String right = palabra.substring(((int) palabra.length() / 2) + (palabra.length() % 2));

    boolean esPalindromo = left.equals(right);

    System.out.print("La palabra " + palabra);
    if (esPalindromo)
      System.out.println(" es palindromo");
    else
      System.out.println(" no es palindromo");
  }

  public static void sumaMatriz() {
    Scanner input = new Scanner(System.in);
    int[][] matriz = new int[3][3];
    int suma = 0;

    System.out.println("Ingrese una matriz 3x3, cada numero separado por espacios o por saltos de linea: ");
    for (int y = 0; y < 3; y++)
      for (int x = 0; x < 3; x++)
        matriz[y][x] = input.nextInt();

    for (int y = 0; y < 3; y++)
      for (int x = 0; x < 3; x++)
        if (y == x)
          suma += matriz[y][x];

    System.out.println("La suma de las diagonales es: " + suma);
  }

  public static void gestionNotas() {
    Scanner input = new Scanner(System.in);
    int cEstudiantes = 0;
    int cExamenes = 0;

    System.out.print("Cantidad de estudiantes: ");
    cEstudiantes = input.nextInt();
    System.out.print("Cantidad de examenes: ");
    cExamenes = input.nextInt();

    int mejorPromedio = 0;
    int peorpromedio = 100;

    int[] promedios = new int[cEstudiantes];

    for (int e = 0; e < cEstudiantes; e++) {
      clearConsole();
      System.out
          .println(
              "Ingrese los " + cExamenes + " examenes del estudiante #" + (e + 1) + " separados por saltos de linea");
      for (int ex = 0; ex < cExamenes; ex++) {
        int nota = 0;

        do {
          System.out.print("Examen #" + (ex + 1) + ": ");
          nota = input.nextInt();
        } while (nota < 0 || nota > 100);

        promedios[e] += nota;
      }
      promedios[e] /= cExamenes;

      mejorPromedio = Math.max(mejorPromedio, promedios[e]);
      peorpromedio = Math.min(peorpromedio, promedios[e]);

      System.out.print("El promedio del estudiante #" + (e + 1) + " es de " + promedios[e]);
      if (promedios[e] >= 60)
        System.out.println(", el estudiante esta aprobado.");
      else
        System.out.println(", el estudiante esta reprobado.");
      pause();
    }

    System.out.println("El mejor promedio es " + mejorPromedio);
    System.out.println("El peor promedio es " + peorpromedio);
  }

  public static int printMenu(String[] menuOptions) {
    int opt = 0;
    Scanner input = new Scanner(System.in);

    do {
      clearConsole();
      for (int i = 0; i < menuOptions.length; i++) {
        System.out.println((i + 1) + ". " + menuOptions[i]);
      }
      System.err.print("> ");
      opt = input.nextInt();
      System.err.println("");
    } while (opt < 1 || opt > menuOptions.length);

    return opt;
  }

  public static void clearConsole() {
    for (int i = 0; i < 1000; i++) {
      System.out.println("\b");
    }
  }

  public static void pause() {
    Scanner input = new Scanner(System.in);

    System.out.print("\nPulse enter para continuar...");
    input.nextLine();
    clearConsole();
  }
}