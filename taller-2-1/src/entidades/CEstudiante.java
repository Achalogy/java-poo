package entidades;

import utils.Utils;

public class CEstudiante {
  private String nombre;
  private int numero;
  private double promedio;

  public CEstudiante(String nombre, int numero, double promedio) {
    this.nombre = nombre;
    this.numero = numero;
    this.promedio = promedio;
  }

  public CEstudiante() {

  }

  public String getNombre() {
    return nombre;
  }

  public int getNumero() {
    return numero;
  }

  public double getPromedio() {
    return promedio;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setPromedio(double promedio) {
    this.promedio = promedio;
  }

  public void actualizarPromedio(double promedioSemestre) {
    if (promedioSemestre < 0 || promedioSemestre > 5.0) {
      System.out.println("=============================================================");
      System.out.println("Error, no es posible añadir un promedio menor a 0 o mayor a 5");
      System.out.println("=============================================================\n");
      return;
    }

    this.promedio = (this.promedio + promedioSemestre) / 2;
  }

  public boolean definirPruebaAcademica() {
    return this.promedio < 3.2;
  }

}
