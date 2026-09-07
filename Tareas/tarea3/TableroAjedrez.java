// TABLERO AJEDREZ
//    - El tablero(Array2D) debe almacenar los caracteres unicode de las piezas
//    - Solo debe mostrar el tablero inicial. NO DEBE SER FUNCIONAL.
//    - Debe imprimir en consola de comandos este tablero inicial como se ve en la imagen anexa.
public class TableroAjedrez {
  public static void main(String[] args) {
    Array2D<Character> tablero = new Array2D<>(8, 8);

    // Piezas negras (arriba)
    char[] filaTorresNegras = { '\u265C', '\u265E', '\u265D', '\u265B', '\u265A', '\u265D', '\u265E', '\u265C' };
    char peonNegro = '\u265F';

    // Piezas blancas (abajo)
    char[] filaTorresBlancas = { '\u2656', '\u2658', '\u2657', '\u2655', '\u2654', '\u2657', '\u2658', '\u2656' };
    char peonBlanco = '\u2659';

    // Fila 0: piezas negras
    for (int j = 0; j < 8; j++) {
      tablero.establecerElemento(0, j, filaTorresNegras[j]);
    }

    // Fila 1: peones negros
    for (int j = 0; j < 8; j++) {
      tablero.establecerElemento(1, j, peonNegro);
    }

    // Filas 2-5: vacías (ya inicializadas con null por el constructor)
    // Fila 6: peones blancos
    for (int j = 0; j < 8; j++) {
      tablero.establecerElemento(6, j, peonBlanco);
    }

    // Fila 7: piezas blancas
    for (int j = 0; j < 8; j++) {
      tablero.establecerElemento(7, j, filaTorresBlancas[j]);
    }

    // Imprimir tablero
    System.out.println("  a b c d e f g h");
    for (int i = 0; i < 8; i++) {
      System.out.print((8 - i) + " ");
      for (int j = 0; j < 8; j++) {
        Character pieza = tablero.obtenerElemento(i, j);
        System.out.print((pieza == null ? '.' : pieza) + " ");
      }
      System.out.println((8 - i));
    }
    System.out.println("  a b c d e f g h");
  }
}
