public class NodoTarea {
  public static void main(String[] args) {
    // Inicio de la lista enlazada
    Nodo<String> head = new Nodo<>("Al");
    head.setSiguiente(new Nodo<>("B"));
    head.getSiguiente().setSiguiente(new Nodo<>("C"));
    head.getSiguiente().getSiguiente().setSiguiente(new Nodo<>("De"));
    head.getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo<>("Mc"));
    head.getSiguiente().getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo<>("Zi"));

    System.out.println("=== PRUEBAS ===");
    System.out.println("Estado inicial de la lista enlazada:" + head);
    System.out.println(" -Primer dato de la lista: " + head.getDato());

    // Bucle para llegar al ultimo nodo
    Nodo<String> cursor = head;
    while (cursor.getSiguiente() != null) {
      cursor = cursor.getSiguiente();
    }
    System.out.println(" -Ultima posicion: " + cursor);

    // Bucle para buscar "De"
    cursor = head;
    while (!cursor.getDato().equals("De")) {
      cursor = cursor.getSiguiente();
    }
    Nodo<String> nodoIntermedio = new Nodo<>("Fe");
    nodoIntermedio.setSiguiente(cursor.getSiguiente());
    cursor.setSiguiente(nodoIntermedio);
    System.out.println(" -Insertatamos 'Fe' entre 'De' y 'Mc': " + head);

    // Bucle para llegar al ultimo nodo y agregar uno nuevo
    cursor = head;
    while (cursor.getSiguiente() != null) {
      cursor = cursor.getSiguiente();
    }
    cursor.setSiguiente(new Nodo<>("Zz"));
    System.out.println(" -Agregamos 'Zz' al final de la lista: " + head);

    // Insertar "Aa" al inicio de la lista
    Nodo<String> nodoInicial = new Nodo<>("Aa", head);
    head = nodoInicial;
    System.out.println(" -Insertamos 'Aa' al inicio de la lista: " + head);
  }
}
