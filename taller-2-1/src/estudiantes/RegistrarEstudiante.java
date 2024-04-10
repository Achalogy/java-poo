package estudiantes;

import java.util.Scanner;

import entidades.CEstudiante;

public class RegistrarEstudiante {
  public static void main(String Args[]) {
    CEstudiante estudiantes[] = new CEstudiante[3];
    double promedio = 0.0;
    double promedioPrueba = 0.0;
    int cantPrueba = 0;

    for (int i = 0; i < estudiantes.length; i++) {
      CEstudiante estudiante = crearEstudiante(i, false);
      actualizarPromedioyRevisar(estudiante);

      estudiantes[i] = estudiante;
    }

    for (int i = 0; i < estudiantes.length; i++) {
      promedio += estudiantes[i].getPromedio();
      if (estudiantes[i].definirPruebaAcademica()) {
        cantPrueba++;
        promedioPrueba += estudiantes[i].getPromedio();
      }
    }

    promedio /= estudiantes.length;
    promedioPrueba /= cantPrueba;

    System.out.println("El promedio total de los 3 estudiantes es: " + promedio);

    System.out
        .println("Cantidad total de estudiantes en prueba: " + cantPrueba);

    System.out
        .println("Promedio de los estudiantes en prueba: " + promedioPrueba);

  }

  public static CEstudiante crearEstudiante(int i, boolean usarSetters) {

    String nombre = "";
    int num = 0;
    double promedio = 0.0;

    Scanner input = new Scanner(System.in);

    System.out.print("Nombre del estudiante #" + (i + 1) + ":          ");
    nombre = input.nextLine();
    System.out.print("Numero del estudiante #" + (i + 1) + ":          ");
    num = input.nextInt();
    System.out.print("Promedio del estudiante #" + (i + 1) + ":        ");
    promedio = input.nextDouble();

    if (usarSetters) {
      CEstudiante estudiante = new CEstudiante();
      estudiante.setNombre(nombre);
      estudiante.setNumero(num);
      estudiante.setPromedio(promedio);
      return estudiante;
    } else {
      CEstudiante estudiante = new CEstudiante(nombre, num, promedio);
      return estudiante;
    }
  }

  public static void actualizarPromedioyRevisar(CEstudiante estudiante) {
    double promedioActual = 0.0;
    boolean estaEnPrueba = false;

    Scanner input = new Scanner(System.in);

    estaEnPrueba = estudiante.definirPruebaAcademica();

    System.out.print("Promedio Actual del estudiante #1: ");
    promedioActual = input.nextDouble();

    estudiante.actualizarPromedio(promedioActual);

    if (estaEnPrueba)
      System.out
          .println("El estudiante estaba en prueba academica actualmente, promedio = " + estudiante.getPromedio());
    else
      System.out
          .println("El estudiante no estaba en prueba academica actualmente, promedio = " + estudiante.getPromedio());

    estaEnPrueba = estudiante.definirPruebaAcademica();

    if (estaEnPrueba)
      System.out.println("El estudiante esta en prueba academica actualmente, promedio = " + estudiante.getPromedio());
    else
      System.out
          .println("El estudiante no esta en prueba academica actualmente, promedio = " + estudiante.getPromedio());
  }
}
