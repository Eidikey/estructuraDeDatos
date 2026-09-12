import java.util.HashSet;
import java.util.Set;

public class VisitantesWeb {
  // Declaramos nuestro Set para guardar las IPs
  private Set<String> visitantesUnicos;

  public VisitantesWeb() {
    // Usamos HashSet porque es muy rápido para buscar y agregar datos
    visitantesUnicos = new HashSet<>();
  }

  // Método que ejemplifica el caso de uso
  public void registrarVisita(String ip) {
    // El método .add() de un Set devuelve 'true' si el elemento es nuevo,
    // y 'false' si ya existía en la colección.
    boolean esNuevo = visitantesUnicos.add(ip);

    if (esNuevo) {
      System.out.println("NUEVO: Visita registrada de " + ip);
    } else {
      System.out.println("DUPLICADO: La IP " + ip + " ya visitó la página hoy. Ignorada.");
    }
  }

  public int obtenerTotalVisitantes() {
    return visitantesUnicos.size();
  }

  public void mostrarVisitantes() {
    System.out.println("IPs únicas registradas: " + visitantesUnicos);
  }
}
