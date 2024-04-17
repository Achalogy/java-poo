package entidades;

public class Empleado {
  private String nombre;
  private long cedula;
  private double salario;
  public static final double SALARIOMIN = 1300000;
  private static double bomoEmpleados;

  public Empleado() {

  }

  public Empleado(String nombre, long cedula, double salario) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.salario = salario;
  }

  private double subsidioTransporte() {
    if (this.salario <= SALARIOMIN * 2)
      return 90000;
    else
      return 0;
  }

  private double totalDevengado() {
    return this.salario + subsidioTransporte();
  }

  private double calcularIBC() {
    
  }
}
