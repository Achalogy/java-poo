package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Perro implements Serializable{
  private String raza;
  private Calendar fechaNacimiento;
  private float peso;
  private String nombre;
  private Calendar fechaAdopcion;
  private Persona dueno;

  public Perro(String raza, Calendar fechaNacimiento, float peso, String nombre) {
    this.raza = raza;
    this.fechaNacimiento = fechaNacimiento;
    this.peso = peso;
    this.nombre = nombre;

    this.fechaAdopcion = null;
  }

  public void setRaza(String raza) {
    this.raza = raza;
  }

  public void setFechaNacimiento(Calendar fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setPeso(float peso) {
    this.peso = peso;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setFechaAdopcion(Calendar fechaAdopcion) {
    this.fechaAdopcion = fechaAdopcion;
  }

  public String getRaza() {
    return raza;
  }

  public Calendar getFechaNacimiento() {
    return fechaNacimiento;
  }

  public float getPeso() {
    return peso;
  }

  public String getNombre() {
    return nombre;
  }

  public Calendar getFechaAdopcion() {
    return fechaAdopcion;
  }

  public void setDueno(Persona dueno) {
    this.dueno = dueno;
  }

  public Persona getDueno() {
    return dueno;
  }

  public float calcularEdad() {
    Calendar fecha = new GregorianCalendar();
    long msToDays = 1000L * 60L * 60L * 24L;
    long msActual = fecha.getTime().getTime();
    long msNacimiento = fechaNacimiento.getTime().getTime();
    long daysDif = (msActual - msNacimiento) / msToDays;

    float yearsDif = (float) daysDif / 365;

    return yearsDif;
  }
}