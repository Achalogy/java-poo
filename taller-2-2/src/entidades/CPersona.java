package entidades;

public class CPersona {
  private String nombre;
  private short edad;
  private int cedula;
  private char sexo;
  private float peso;
  private float altura;
  private float salario;

  public CPersona() {

  }

  public CPersona(String nombre, short edad, char sexo) {
    this.nombre = nombre;
    this.edad = edad;
    this.cedula = 0;
    this.sexo = sexo;
    this.peso = 0;
    this.altura = 0;
    this.salario = 0;
  }

  public CPersona(String nombre,
      short edad,
      int cedula,
      char sexo,
      float peso,
      float altura,
      float salario) {
    this.nombre = nombre;
    this.edad = edad;
    this.cedula = cedula;
    this.sexo = sexo;
    this.peso = peso;
    this.altura = altura;
    this.salario = salario;
  }

  public void setAltura(short altura) {
    this.altura = altura;
  }

  public void setCedula(int cedula) {
    this.cedula = cedula;
  }

  public void setEdad(short edad) {
    this.edad = edad;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPeso(short peso) {
    this.peso = peso;
  }

  public void setSalario(int salario) {
    this.salario = salario;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }

  public int getCedula() {
    return cedula;
  }

  public String getNombre() {
    return nombre;
  }

  public char getSexo() {
    return sexo;
  }

  public float calcularIMC() {
    return this.peso / (this.altura * this.altura);
  }

  public boolean esMayorDeEdad() {
    return this.edad >= 18;
  }

  public float salariosMinimos() {
    return salario / 1300000;
  }
}
