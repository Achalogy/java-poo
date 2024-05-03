package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Persona {
  private String nombre;
  private int edad;
  private String residencia;
  private String cedula;
  private ArrayList<Perro> mascotas;

  public Persona(String nombre, int edad, String residencia, String cedula) {
    this.nombre = nombre;
    this.edad = edad;
    this.residencia = residencia;
    this.cedula = cedula;

    this.mascotas = new ArrayList<>();
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setResidencia(String residencia) {
    this.residencia = residencia;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public String getResidencia() {
    return residencia;
  }

  public String getCedula() {
    return cedula;
  }

  public void adoptarMascota(Perro perro) {
    Calendar fecha = new GregorianCalendar();
    mascotas.add(perro);

    perro.setDueno(this);
    perro.setFechaAdopcion(fecha);
  }

  private Perro buscarMascota(String nombre) {
    for (Perro p : mascotas) {
      if (p.getNombre().equals(nombre)) {
        return p;
      }
    }

    return null;
  }

  public void cambiarNombreMascota(String nombreAnterior, String nombreNuevo) {
    Perro p = buscarMascota(nombreAnterior);

    if (p != null) {
      System.out.println("Ahora " + nombreAnterior + " se llama " + nombreNuevo);
      p.setNombre(nombreNuevo);
      return;
    }

    System.out.println("No se encontró a una mascota con el nombre " + nombreAnterior);
  }

  public void mostrarMascotas() {
    System.out.println("Lista de Mascotas de " + this.nombre + ": ");
    for (Perro p : this.mascotas) {
      System.out.println("  - " + p.getNombre());
      System.out.println("  edad:       " + p.calcularEdad() + " años");
      System.out.println("  adoptado:   " + p.getFechaAdopcion().getTime().toString());
      System.out.println("  nacimiento: " + p.getFechaNacimiento().getTime().toString());
      System.out.println("  raza:       "+ p.getRaza());
      System.out.println("  peso:       " + p.getPeso() + "kg");
    }
    System.out.println("--------------------------\n");
  }
}
