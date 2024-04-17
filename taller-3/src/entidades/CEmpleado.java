package entidades;

public class CEmpleado {
  private String nombre;
  private long cedula;
  private double salario;
  public static final double SALARIOMIN = 1300000;
  private static double bonoEmpleados;

  public CEmpleado() {

  }

  public CEmpleado(String nombre, long cedula, double salario) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.salario = salario;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setCedula(long cedula) {
    this.cedula = cedula;
  }

  public long getCedula() {
    return cedula;
  }

  public void setSalario(double salario) {
    if (salario < SALARIOMIN) {
      System.out.println("Se ha reemplazado el salario por un salario mínimo.");
      this.salario = SALARIOMIN;
    } else
      this.salario = salario;
  }

  public double getSalario() {
    return salario;
  }

  public static void setBonoEmpleados(double bonoEmpleados) {
    CEmpleado.bonoEmpleados = bonoEmpleados;
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
    return totalDevengado() * 0.75;
  }

  private double calcularDescuentoPension() {
    return calcularIBC() * 0.03875;
  }

  private double calcularDescuentoSalud() {
    return calcularIBC() * 0.045;
  }

  private double calcularDescuentoFS() {
    if (this.salario > SALARIOMIN * 4)
      return calcularIBC() * 0.01;
    else
      return 0;
  }

  private double calcularDescuentoTotal() {
    return calcularDescuentoPension() + calcularDescuentoSalud() + calcularDescuentoFS();
  }

  public double calcularTotalNomina() {
    return totalDevengado() - calcularDescuentoTotal();
  }

  public double calcularTotalNomina(double regaloCumple) {
    return totalDevengado() - calcularDescuentoTotal() + bonoEmpleados + regaloCumple;
  }
}
