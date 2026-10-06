public class ListaLigadaSimpleADT<T> {
  private Nodo<T> inicio;

  public ListaLigadaSimpleADT() {
    this.inicio = null;
  }

  /** L.inicio: acceso de lectura al nodo inicial. */
  public Nodo<T> getInicio() {
    return inicio;
  }

  public boolean estaVacia() {
    return inicio == null;
  }

  // Longitud(L): cuenta nodos desde L.inicio hasta NIL.
  public int longitud() {
    int s = 0;
    Nodo<T> x = inicio;
    while (x != null) {
      s = s + 1;
      x = x.getSiguiente();
    }
    return s;
  }

  // InsertarAlInicio(L, x): x.siguiente = L.inicio; L.inicio = x.
  public void insertarAlInicio(T dato) {
    Nodo<T> x = new Nodo<>(dato, inicio);
    inicio = x;
  }

  public void insertarAlFinal(T dato) {
    Nodo<T> x = new Nodo<>(dato);
    if (inicio == null) {
      inicio = x;
      return;
    }
    Nodo<T> cursor = inicio;
    while (cursor.getSiguiente() != null) {
      cursor = cursor.getSiguiente();
    }
    cursor.setSiguiente(x);
  }

  // Insercion en orden ascendente. Requiere datos Comparables.
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void insertarEnOrden(T dato) {
    if (!(dato instanceof Comparable)) {
      throw new IllegalArgumentException("insertarEnOrden requiere dato Comparable, recibido: " + dato);
    }
    Comparable<T> k = (Comparable<T>) dato;
    Nodo<T> x = new Nodo<>(dato);
    if (inicio == null || k.compareTo(inicio.getDato()) <= 0) {
      x.setSiguiente(inicio);
      inicio = x;
      return;
    }
    Nodo<T> cursor = inicio;
    while (cursor.getSiguiente() != null
        && ((Comparable<T>) cursor.getSiguiente().getDato()).compareTo(dato) < 0) {
      cursor = cursor.getSiguiente();
    }
    x.setSiguiente(cursor.getSiguiente());
    cursor.setSiguiente(x);
  }

  // BuscarElemento(L, k): recorre desde L.inicio, regresa el nodo o null (NIL).
  public Nodo<T> buscarElemento(T k) {
    Nodo<T> x = inicio;
    while (x != null) {
      if (k == null ? x.getDato() == null : k.equals(x.getDato())) {
        return x;
      }
      x = x.getSiguiente();
    }
    return null;
  }

  public boolean contiene(T k) {
    return buscarElemento(k) != null;
  }

  // Eliminar elemento: quita la primera ocurrencia de k.
  public boolean eliminarElemento(T k) {
    if (inicio == null) {
      return false;
    }
    if (k == null ? inicio.getDato() == null : k.equals(inicio.getDato())) {
      inicio = inicio.getSiguiente();
      return true;
    }
    Nodo<T> cursor = inicio;
    while (cursor.getSiguiente() != null) {
      Nodo<T> candidato = cursor.getSiguiente();
      if (k == null ? candidato.getDato() == null : k.equals(candidato.getDato())) {
        cursor.setSiguiente(candidato.getSiguiente());
        return true;
      }
      cursor = cursor.getSiguiente();
    }
    return false;
  }

  // Imprimir la lista.
  public void imprimirLista() {
    System.out.println(this);
  }

  // Unir: agrega al final una copia de los elementos de 'otra'.
  public void unirLista(ListaLigadaSimpleADT<T> otra) {
    if (otra == null || otra.inicio == null) {
      return;
    }
    Nodo<T> cursor = otra.inicio;
    while (cursor != null) {
      insertarAlFinal(cursor.getDato());
      cursor = cursor.getSiguiente();
    }
  }

  // Unir dos o mas listas en una sola (nueva lista con copias).
  @SafeVarargs
  public static <T> ListaLigadaSimpleADT<T> unir(ListaLigadaSimpleADT<T>... listas) {
    ListaLigadaSimpleADT<T> resultado = new ListaLigadaSimpleADT<>();
    if (listas == null) {
      return resultado;
    }
    for (ListaLigadaSimpleADT<T> l : listas) {
      if (l != null) {
        resultado.unirLista(l);
      }
    }
    return resultado;
  }

  // Dividir la lista en dos por indice: [0, indice) y [indice, fin).
  // El indice se ajusta al rango [0, longitud()].
  @SuppressWarnings("unchecked")
  public ListaLigadaSimpleADT<T>[] dividir(int indice) {
    int n = longitud();
    if (indice < 0) {
      indice = 0;
    }
    if (indice > n) {
      indice = n;
    }
    ListaLigadaSimpleADT<T> primera = new ListaLigadaSimpleADT<>();
    ListaLigadaSimpleADT<T> segunda = new ListaLigadaSimpleADT<>();
    Nodo<T> cursor = inicio;
    int i = 0;
    while (cursor != null) {
      if (i < indice) {
        primera.insertarAlFinal(cursor.getDato());
      } else {
        segunda.insertarAlFinal(cursor.getDato());
      }
      cursor = cursor.getSiguiente();
      i++;
    }
    return (ListaLigadaSimpleADT<T>[]) new ListaLigadaSimpleADT<?>[] { primera, segunda };
  }

  // Invertir(L): invierte los enlaces in situ.
  public void invertir() {
    if (inicio == null) {
      return;
    }
    Nodo<T> x = inicio;
    Nodo<T> y = inicio.getSiguiente();
    while (y != null) {
      Nodo<T> tmp = y.getSiguiente();
      y.setSiguiente(x);
      if (x == inicio) {
        x.setSiguiente(null);
      }
      x = y;
      y = tmp;
    }
    inicio = x;
  }

  // Borrar la lista.
  public void borrarLista() {
    inicio = null;
  }

  @Override
  public String toString() {
    if (inicio == null) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder("[");
    Nodo<T> cursor = inicio;
    while (cursor != null) {
      sb.append(cursor.getDato());
      if (cursor.getSiguiente() != null) {
        sb.append(" -> ");
      }
      cursor = cursor.getSiguiente();
    }
    sb.append("]");
    return sb.toString();
  }
}
