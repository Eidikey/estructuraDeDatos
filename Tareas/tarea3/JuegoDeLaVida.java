import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JuegoDeLaVida {
  private Array2D<Integer> tablero;
  private int generaciones;

  public JuegoDeLaVida(String archivo) throws IOException {
    List<String> lineas = Files.readAllLines(Paths.get(archivo));
    String[] encabezado = lineas.get(0).split(",");
    int ren = Integer.parseInt(encabezado[0].trim());
    int col = Integer.parseInt(encabezado[1].trim());
    this.generaciones = Integer.parseInt(encabezado[2].trim());
    this.tablero = new Array2D<>(ren, col);

    for (int i = 1; i <= ren; i++) {
      String[] partes = lineas.get(i).split(",");
      for (int j = 0; j < col; j++) {
        tablero.establecerElemento(i - 1, j, Integer.parseInt(partes[j].trim()));
      }
    }
  }

  private int contarVecinosVivos(int fila, int col) {
    int contador = 0;
    for (int i = fila - 1; i <= fila + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (i == fila && j == col)
          continue;
        if (i >= 0 && i < tablero.obtenerRenglones() &&
            j >= 0 && j < tablero.obtenerColumnas()) {
          contador += tablero.obtenerElemento(i, j);
        }
      }
    }
    return contador;
  }

  private void siguienteGeneracion() {
    int ren = tablero.obtenerRenglones();
    int col = tablero.obtenerColumnas();
    Array2D<Integer> nuevo = new Array2D<>(ren, col);
    nuevo.rellenar(0);

    for (int i = 0; i < ren; i++) {
      for (int j = 0; j < col; j++) {
        int vecinos = contarVecinosVivos(i, j);
        int estado = tablero.obtenerElemento(i, j);

        if (estado == 1) {
          if (vecinos == 2 || vecinos == 3) {
            nuevo.establecerElemento(i, j, 1);
          }
        } else {
          if (vecinos == 3) {
            nuevo.establecerElemento(i, j, 1);
          }
        }
      }
    }
    tablero = nuevo;
  }

  public void jugar() {
    System.out.println("Generacion 0:");
    System.out.println(tablero);
    for (int g = 1; g <= generaciones; g++) {
      siguienteGeneracion();
      System.out.println("Generacion " + g + ":");
      System.out.println(tablero);
    }
  }

  public static void main(String[] args) throws IOException {
    JuegoDeLaVida juego = new JuegoDeLaVida("poblacion_inicial.csv");
    juego.jugar();
  }
}
