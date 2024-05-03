package entidades;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import utils.Utils;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CentroAdopcion {
  private String nombre;
  private ArrayList<Perro> internos;
  private ArrayList<Persona> clientes;

  public CentroAdopcion(String nombre) {
    this.nombre = nombre;
    this.clientes = new ArrayList<>();
    this.internos = new ArrayList<>();

    loadFromFile();
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void mostrarInternos() {
    System.out.println("Lista de Mascotas en adopción: ");
    for (Perro p : this.internos) {
      if (p.calcularEdad() > 1 && p.getDueno() == null) {
        System.out.println("  - " + p.getNombre());
        System.out.println("  edad:       " + p.calcularEdad() + " años");
        System.out.println("  nacimiento: " + p.getFechaNacimiento().getTime().toString());
        System.out.println("  raza:       " + p.getRaza());
        System.out.println("  peso:       " + p.getPeso() + "kg");
      }
    }
    System.out.println("--------------------------\n");
  }

  public void rescatarMascota(Perro perro) {
    this.internos.add(perro);
  }

  public void darEnAdopcion(Perro perro, Persona persona) {
    persona.adoptarMascota(perro);
    this.internos.remove(perro);
    agregarCliente(persona);
  }

  public Persona buscarCliente(String cedula) {
    for (Persona p : this.clientes) {
      if (p.getCedula().equals(cedula)) {
        return p;
      }
    }
    return null;
  }

  public void agregarCliente(Persona cliente) {
    for (Persona p : this.clientes) {
      if (p.getCedula().equals(cliente.getCedula())) {
        return;
      }
    }

    this.clientes.add(cliente);
  }

  public Perro buscarPerro(String nombre) {
    for (Perro p : this.internos) {
      if (p.calcularEdad() > 1 && p.getDueno() == null && p.getNombre().equals(nombre)) {
        return p;
      }
    }
    return null;
  }

  public void mostrarAdopciones() {
    for (Persona c : this.clientes) {
      c.mostrarMascotas();
    }
  }

  public void saveToFile() {
    try {
      ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("adopcion.bin"));

      file.writeObject(this.internos);
      file.close();

      System.out.println("Se han guardado correctamente los datos.");
    } catch (Exception e) {
      e.printStackTrace();
      Utils.writeLog(e);
      System.out.println("No se pudo guardar el archivo");
    }
  }

  public void loadFromFile() {
    try {
      ObjectInputStream file = new ObjectInputStream(new FileInputStream("adopcion.bin"));

      this.internos = (ArrayList<Perro>) file.readObject();

      file.close();
    } catch (Exception e) {
      e.printStackTrace();
      Utils.writeLog(e);
      System.out.println("No se pudo cargar el archivo");
    }
  }
}
