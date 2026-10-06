public class ListaLigadaSimpleADT<T> {
  private Nodo<T> inicio;

  public ListaLigadaSimpleADT() {
    this.inicio = null;
  }

  public boolean isEmpty() {
    return inicio == null;
  }

  public int getSize() {
    int total = 0;
    Nodo<T> cursor = inicio;
    while (cursor != null) {
      total = total + 1;
      cursor = cursor.getSiguiente();
    }
    return total;
  }

  public void add(T value) {
    addLast(value);
  }

  public void addLast(T value) {
    Nodo<T> nuevo = new Nodo<>(value);
    if (inicio == null) {
      inicio = nuevo;
      return;
    }
    Nodo<T> cursor = inicio;
    while (cursor.getSiguiente() != null) {
      cursor = cursor.getSiguiente();
    }
    cursor.setSiguiente(nuevo);
  }

  public void addFirst(T value) {
    Nodo<T> nuevo = new Nodo<>(value, inicio);
    inicio = nuevo;
  }

  public void addAfter(T reference, T value) {
    Nodo<T> cursor = inicio;
    while (cursor != null) {
      if (reference == null ? cursor.getDato() == null : reference.equals(cursor.getDato())) {
        Nodo<T> nuevo = new Nodo<>(value, cursor.getSiguiente());
        cursor.setSiguiente(nuevo);
        return;
      }
      cursor = cursor.getSiguiente();
    }
    System.out.println("Referencia no encontrada: " + reference);
  }

  public T removeFirst() {
    if (inicio == null) {
      System.out.println("Lista vacía, no se puede eliminar el primero");
      return null;
    }
    T dato = inicio.getDato();
    inicio = inicio.getSiguiente();
    return dato;
  }

  public T removeLast() {
    if (inicio == null) {
      System.out.println("Lista vacía, no se puede eliminar el final");
      return null;
    }
    if (inicio.getSiguiente() == null) {
      T dato = inicio.getDato();
      inicio = null;
      return dato;
    }
    Nodo<T> cursor = inicio;
    while (cursor.getSiguiente().getSiguiente() != null) {
      cursor = cursor.getSiguiente();
    }
    T dato = cursor.getSiguiente().getDato();
    cursor.setSiguiente(null);
    return dato;
  }

  public int search(T value) {
    Nodo<T> cursor = inicio;
    int posicion = 1;
    while (cursor != null) {
      if (value == null ? cursor.getDato() == null : value.equals(cursor.getDato())) {
        return posicion;
      }
      cursor = cursor.getSiguiente();
      posicion++;
    }
    return -1;
  }

  public boolean update(T target, T value) {
    Nodo<T> cursor = inicio;
    while (cursor != null) {
      if (target == null ? cursor.getDato() == null : target.equals(cursor.getDato())) {
        cursor.setDato(value);
        return true;
      }
      cursor = cursor.getSiguiente();
    }
    return false;
  }

  public void traverse() {
    if (inicio == null) {
      System.out.println("Lista vacía");
      return;
    }
    Nodo<T> cursor = inicio;
    while (cursor != null) {
      System.out.print(cursor.getDato());
      if (cursor.getSiguiente() != null) {
        System.out.print(" -> ");
      }
      cursor = cursor.getSiguiente();
    }
    System.out.println();
  }
}
