public class DemoNodo {
  public static void main(String[] args) {
    System.out.println("Hola demo nodo");
    Nodo<Integer> head = new Nodo<>();
    head.setDato(20);
    head.setSiguiente(new Nodo<>(30));
    head.getSiguiente().setSiguiente(new Nodo<>(40));
    head.getSiguiente().getSiguiente().setSiguiente(new Nodo<>(50));
    System.out.println(head);
    System.out.println("imprimir el dato segundo elemento(30)");
    System.out.println(head.getSiguiente().getDato());

    Nodo<Integer> tmp = new Nodo<>(10, head.getSiguiente());
    // tmp.setSiguiente(head.getSiguiente());
    head = tmp;

    System.out.println(head);

    Nodo<Integer> cursor = head;

    while (cursor.getSiguiente() != null) {
    cursor = cursor.getSiguiente();
    System.out.println("Cursor: " + cursor);
    }

  }

}
