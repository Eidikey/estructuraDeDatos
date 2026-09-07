public class Array2D<T> {
  private int ren;
  private int col;
  private Object[][] datos;

  public Array2D(int ren, int col) {
    this.ren = ren;
    this.col = col;
    this.datos = new Object[ren][col];
  }

  public void rellenar(T dato) {
    for (int i = 0; i < ren; i++) {
      for (int j = 0; j < col; j++) {
        datos[i][j] = dato;
      }
    }
  }

  public int obtenerRenglones() {
    return ren;
  }

  public int obtenerColumnas() {
    return col;
  }

  public void establecerElemento(int ren, int col, T dato) {
    if (ren >= 0 && ren < this.ren && col >= 0 && col < this.col) {
      datos[ren][col] = dato;
    } else {
      System.out.println("Indice fuera de rango");
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public T obtenerElemento(int ren, int col) {
    if (ren >= 0 && ren < this.ren && col >= 0 && col < this.col) {
      return (T) datos[ren][col];
    } else {
      System.out.println("Indice fuera de rango");
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ren; i++) {
      sb.append("[");
      for (int j = 0; j < col; j++) {
        sb.append(datos[i][j]);
        if (j < col - 1)
          sb.append(", ");
      }
      sb.append("]\n");
    }
    return sb.toString();
  }
}
