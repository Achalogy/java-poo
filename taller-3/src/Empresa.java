import java.util.Scanner;

import entidades.CEmpleado;
import utils.Utils;

public class Empresa {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int cantEmpleados = 0;
    double totalNomina = 0;

    System.out.println("Salario mínimo: " + CEmpleado.SALARIOMIN);
    System.out.print("Cantidad de empleados: ");
    cantEmpleados = input.nextInt();

    Utils.clearConsole();

    CEmpleado empleadosEmpresa[] = new CEmpleado[cantEmpleados];

    for (int i = 0; i < cantEmpleados; i++) {
      empleadosEmpresa[i] = crearEmpleado(input);
    }

    for (int i = 0; i < cantEmpleados; i++) {
      System.out.println("Empleado #" + (i + 1));
      mostrarEmpleado(empleadosEmpresa[i]);
    }

    System.out.print("\nBono para tus empleados: ");
    CEmpleado.setBonoEmpleados(input.nextDouble());
    Utils.clearConsole();

    totalNomina = calcularTotalNomina(empleadosEmpresa, cantEmpleados, input);

    System.out.println("Total Nómina:           " + totalNomina);
    System.out.println("Total a pagar del SENA: " + totalNomina * 0.04);

    Utils.pause();
  }

  public static double calcularTotalNomina(CEmpleado empleadosEmpresa[], int cantEmpleados, Scanner input) {
    double totalNomina = 0.0;
    char validChars[] = { 'y', 'Y', 'n', 'N' };
    char cumplio = ' ';

    for (int i = 0; i < cantEmpleados; i++) {
      System.out.println("Empleado #" + (i + 1));
      mostrarEmpleado(empleadosEmpresa[i]);
      cumplio = Utils.askForChar("¿El empleado ya cumplio años? (Y/n)", validChars);
      double nominaEmpleado = 0.0;

      if (cumplio == 'y' || cumplio == 'Y') {
        System.out.print("\nEl empleado cumplio años, cantidad de regalo: ");
        double regalo = input.nextDouble();
        nominaEmpleado = empleadosEmpresa[i].calcularTotalNomina(regalo);
      } else {
        nominaEmpleado = empleadosEmpresa[i].calcularTotalNomina();
      }

      totalNomina += nominaEmpleado;

      System.out.println("\nNomina Empleado: " + nominaEmpleado);

      Utils.pause();
    }

    return totalNomina;
  }

  public static CEmpleado crearEmpleado(Scanner input) {
    CEmpleado empleado = new CEmpleado();

    int cantSalariosM = 0;

    input.nextLine();
    System.out.print("\nEnvie el nombre del Empleado: ");
    empleado.setNombre(input.nextLine());
    System.out.print("Envie la cédula del Empleado: ");
    empleado.setCedula(input.nextLong());
    System.out.print("Envie la cantidad de salarios mínimos que gana el Empleado: ");
    cantSalariosM = input.nextInt();

    empleado.setSalario(CEmpleado.SALARIOMIN * cantSalariosM);
    Utils.pause();

    return empleado;
  }

  public static void mostrarEmpleado(CEmpleado empleado) {
    System.out.println("Nombre del empleado:  " + empleado.getNombre());
    System.out.println("Cédula del empleado:  " + empleado.getCedula());
    System.out.println("Salario del empleado: " + empleado.getSalario() + "\n");
  }
}
