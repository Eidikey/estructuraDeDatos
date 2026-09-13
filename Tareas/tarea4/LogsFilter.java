import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LogsFilter {
  public static void main(String[] args) {
    ConjuntoADT<String> ipsUnicas = new ConjuntoADT<>();

    try {
      List<String> lineas = Files.readAllLines(Paths.get("access.log"), StandardCharsets.UTF_8);
      for (String linea : lineas) {
        if (!linea.trim().isEmpty()) {
          String ip = linea.split(" ")[0];
          ipsUnicas.agregarElemento(ip);
        }
      }

      System.out.println("--- Filtrado de logs completo ---");
      System.out.println("Total de lineas leidas: " + lineas.size());
      System.out.println("Cantidad de visitantes UNICOS: " + ipsUnicas.longitud());
      System.out.println("\nLista de IPs únicas encontradas:");
      System.out.println(ipsUnicas);

    } catch (IOException e) {
      System.err.println("Error al leer el archivo de logs.");
    }
  }
}
