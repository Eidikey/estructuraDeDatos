public class ArrayADT<T> {
  private int longitud;
  private Object[] datos;

  public ArrayADT(int l) {
    this.longitud = l;
    this.datos = new Object[longitud];
  }

  public T obtenerElemento(int indice) {
    if (indice >= 0 && indice < longitud) {
      return (T) datos[indice];
    } else {
      System.out.println("Indice fuera de rango");
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public void insertarElemento(int indice, T elemento) {
    if (indice >= 0 && indice < longitud) {
      datos[indice] = elemento;
    } else {
      System.out.println("Indice fuera de rango");
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public int longitud() {
    return longitud;
  }

  public void rellenar(T elemento) {
    for (int i = 0; i < longitud; i++) {
      datos[i] = elemento;
    }
  }

  public void imprimir() {
    System.out.print("[");
    for (int i = 0; i < longitud; i++) {
      System.out.print(datos[i] + ",");
    }

    System.out.println("]");
  }

}
