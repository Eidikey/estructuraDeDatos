import java.util.Objects;

public class Gato {
  private String nombre;
  private int edad;
  private double peso;
  private String color;
  private int horasDormidas;

  public Gato(String nombre, int edad, double peso, String color, int horasDormidas) {
    this.nombre = nombre;
    this.edad = edad;
    this.peso = peso;
    this.color = color;
    this.horasDormidas = horasDormidas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getHorasDormidas() {
    return horasDormidas;
  }

  public void setHorasDormidas(int horasDormidas) {
    this.horasDormidas = horasDormidas;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Gato otro = (Gato) obj;
    return edad == otro.edad
        && Double.compare(peso, otro.peso) == 0
        && horasDormidas == otro.horasDormidas
        && Objects.equals(nombre, otro.nombre)
        && Objects.equals(color, otro.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, edad, peso, color, horasDormidas);
  }

  @Override
  public String toString() {
    return "Gato{nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", color=" + color + ", horasDormidas=" + horasDormidas + "}";
  }
}
