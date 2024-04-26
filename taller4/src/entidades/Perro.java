package entidades;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.catalog.CatalogFeatures.Feature;

import entidades.Persona;

public class Perro {
  private String raza;
  private Date fechaNacimiento;
  private float peso;
  private String nombre;
  private Date fechaAdopcion;
  private Persona dueno;

  public Perro(String raza, Date fechaNacimiento, float peso, String nombre) {
    this.raza = raza;
    this.fechaNacimiento = fechaNacimiento;
    this.peso = peso;
    this.nombre = nombre;

    this.fechaAdopcion = null;
  }

  public void setRaza(String raza) {
    this.raza = raza;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setPeso(float peso) {
    this.peso = peso;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setFechaAdopcion(Date fechaAdopcion) {
    this.fechaAdopcion = fechaAdopcion;
  }

  public String getRaza() {
    return raza;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public float getPeso() {
    return peso;
  }

  public String getNombre() {
    return nombre;
  }

  public Date getFechaAdopcion() {
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
    long msNacimiento = fechaNacimiento.getTime();
    long daysDif = (msActual - msNacimiento) / msToDays;

    float yearsDif = (float) daysDif / 365;

    return yearsDif;
  }
}