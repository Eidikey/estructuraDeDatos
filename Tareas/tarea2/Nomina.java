import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Nomina {

  public static void main(String[] args) {
    List<String> lineas;
    try {
      lineas = Files.readAllLines(Paths.get("junio.dat"), StandardCharsets.UTF_8);
    } catch (IOException e) {
      System.err.println("No se pudo leer el archivo junio.dat");
      e.printStackTrace();
      return;
    }

    int numeroTrabajadores = lineas.size() - 1;
    ArrayADT<Empleado> empleados = new ArrayADT<>(numeroTrabajadores);

    for (int i = 1; i < lineas.size(); i++) {
      String[] partes = lineas.get(i).split(",", -1);

      int numeroDeTrabajador = Integer.parseInt(partes[0].trim());
      String nombres = partes[1].trim();
      String paterno = partes[2].trim();
      String materno = partes[3].trim();
      int horasExtra = Integer.parseInt(partes[4].trim());
      double sueldoBase = Double.parseDouble(partes[5].trim());
      int aIngreso = Integer.parseInt(partes[6].trim());

      empleados.insertarElemento(i - 1,
          new Empleado(numeroDeTrabajador, nombres, paterno, materno,
              horasExtra, sueldoBase, aIngreso));
    }

    int aActual = 2026;

    int indiceMayorAntiguedad = 0;
    int indiceMenorAntiguedad = 0;
    for (int i = 1; i < empleados.longitud(); i++) {
      if (empleados.obtenerElemento(i).calcularAntiguedad(aActual)
          > empleados.obtenerElemento(indiceMayorAntiguedad).calcularAntiguedad(aActual)) {
        indiceMayorAntiguedad = i;
      }
      if (empleados.obtenerElemento(i).calcularAntiguedad(aActual)
          < empleados.obtenerElemento(indiceMenorAntiguedad).calcularAntiguedad(aActual)) {
        indiceMenorAntiguedad = i;
      }
    }

    Empleado mayor = empleados.obtenerElemento(indiceMayorAntiguedad);
    Empleado menor = empleados.obtenerElemento(indiceMenorAntiguedad);

    System.out.println("Trabajador con MAYOR antigüedad: "
        + mayor.getNombreCompleto() + " ("
        + mayor.calcularAntiguedad(aActual) + " años)");
    System.out.println("Trabajador con MENOR antigüedad: "
        + menor.getNombreCompleto() + " ("
        + menor.calcularAntiguedad(aActual) + " años)");

    System.out.println();
    System.out.printf("%-8s %-30s %-10s %-12s %-10s %-12s %-12s%n",
        "No.", "Nombre", "Horas Ext.", "Sueldo Base", "Antigüedad", "Horas Ext.", "Sueldo a Pagar");
    System.out.printf("%-8s %-30s %-10s %-12s %-10s %-12s %-12s%n",
        "", "", "", "", "(años)", "(importe)", "");
    System.out.println("-------------------------------------------------------------------------");
    for (int i = 0; i < empleados.longitud(); i++) {
      Empleado e = empleados.obtenerElemento(i);
      System.out.printf("%-8d %-30s %-10d %-12.2f %-10d %-12.2f %-12.2f%n",
          e.getNumeroDeTrabajador(),
          e.getNombreCompleto(),
          e.getHorasExtra(),
          e.getSueldoBase(),
          e.calcularAntiguedad(aActual),
          e.calcularPagoHorasExtra(),
          e.calcularSueldo(aActual));
    }
  }
}
