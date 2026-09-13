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
            
            for (int i = 0; i < args.length; i++) {
              
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de logs.");
        }
    }
}
