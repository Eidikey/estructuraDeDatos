/**
 * ListaLigadaSimpleDemo
 * Pruebas de cada operacion comentada en ListaLigadaSimpleADT:
 * insertar (inicio, final, orden), longitud, buscar, eliminar,
 * imprimir, invertir, unir, dividir y borrar.
 */
public class ListaLigadaSimpleDemo {

  private static void check(boolean cond, String nombre) {
    System.out.println((cond ? "OK   " : "FALLO ") + nombre);
  }

  public static void main(String[] args) {
    // 1. Insertar al inicio / al final + imprimir + longitud
    ListaLigadaSimpleADT<Integer> l = new ListaLigadaSimpleADT<>();
    check(l.estaVacia() && l.longitud() == 0, "lista nueva vacia, longitud 0");

    l.insertarAlInicio(10); // [10]
    l.insertarAlInicio(5); // [5 -> 10]
    l.insertarAlFinal(20); // [5 -> 10 -> 20]
    l.insertarAlFinal(30); // [5 -> 10 -> 20 -> 30]
    System.out.println("Lista tras inserciones: " + l);
    check(l.longitud() == 4, "longitud 4, es " + l.longitud());
    check(l.getInicio().getDato() == 5, "inicio es 5");

    // 2. Insertar en orden
    ListaLigadaSimpleADT<Integer> ordenada = new ListaLigadaSimpleADT<>();
    ordenada.insertarEnOrden(30);
    ordenada.insertarEnOrden(10);
    ordenada.insertarEnOrden(20);
    ordenada.insertarEnOrden(5);
    System.out.println("Insercion en orden: " + ordenada);
    check(ordenada.toString().equals("[5 -> 10 -> 20 -> 30]"), "queda [5 -> 10 -> 20 -> 30]");

    // 3. Buscar elemento (existe y no existe)
    Nodo<Integer> hallado = l.buscarElemento(20);
    Nodo<Integer> ausente = l.buscarElemento(99);
    check(hallado != null && hallado.getDato() == 20, "buscar 20 lo encuentra");
    check(ausente == null, "buscar 99 regresa null (NIL)");
    check(l.contiene(10) && !l.contiene(99), "contiene 10, no contiene 99");

    // 4. Eliminar elemento (inicio, medio, final, inexistente)
    check(l.eliminarElemento(5), "elimina inicio (5): " + l);
    check(l.eliminarElemento(20), "elimina medio (20): " + l);
    check(l.eliminarElemento(30), "elimina final (30): " + l);
    check(l.toString().equals("[10]"), "solo queda [10], es " + l);
    check(!l.eliminarElemento(99), "eliminar 99 inexistente regresa false");
    check(l.longitud() == 1, "longitud 1 tras eliminaciones");

    // 5. Invertir
    ListaLigadaSimpleADT<Integer> inv = new ListaLigadaSimpleADT<>();
    inv.insertarAlFinal(1);
    inv.insertarAlFinal(2);
    inv.insertarAlFinal(3);
    System.out.println("Antes de invertir: " + inv);
    inv.invertir();
    System.out.println("Despues de invertir: " + inv);
    check(inv.toString().equals("[3 -> 2 -> 1]"), "invertir [1,2,3] -> [3,2,1]");
    ListaLigadaSimpleADT<Integer> una = new ListaLigadaSimpleADT<>();
    una.insertarAlFinal(7);
    una.invertir();
    check(una.toString().equals("[7]"), "invertir lista de 1 no cambia");
    new ListaLigadaSimpleADT<Integer>().invertir();
    check(true, "invertir lista vacia no truena");

    // 6. Unir dos o mas listas
    ListaLigadaSimpleADT<Integer> a = new ListaLigadaSimpleADT<>();
    a.insertarAlFinal(1);
    a.insertarAlFinal(2);
    ListaLigadaSimpleADT<Integer> b = new ListaLigadaSimpleADT<>();
    b.insertarAlFinal(3);
    b.insertarAlFinal(4);
    ListaLigadaSimpleADT<Integer> c = new ListaLigadaSimpleADT<>();
    c.insertarAlFinal(5);
    ListaLigadaSimpleADT<Integer> union2 = ListaLigadaSimpleADT.unir(a, b);
    ListaLigadaSimpleADT<Integer> union3 = ListaLigadaSimpleADT.unir(a, b, c);
    System.out.println("Union de 2: " + union2);
    System.out.println("Union de 3: " + union3);
    check(union2.toString().equals("[1 -> 2 -> 3 -> 4]"), "unir 2 listas");
    check(union3.toString().equals("[1 -> 2 -> 3 -> 4 -> 5]"), "unir 3 listas");
    check(a.toString().equals("[1 -> 2]"), "unir no modifica originales");

    // 7. Dividir en dos
    ListaLigadaSimpleADT<Integer> original = new ListaLigadaSimpleADT<>();
    original.insertarAlFinal(1);
    original.insertarAlFinal(2);
    original.insertarAlFinal(3);
    original.insertarAlFinal(4);
    ListaLigadaSimpleADT<Integer>[] partes = original.dividir(2);
    System.out.println("Original: " + original + " | Parte1: " + partes[0] + " | Parte2: " + partes[1]);
    check(partes[0].toString().equals("[1 -> 2]"), "dividir parte 1 [1 -> 2]");
    check(partes[1].toString().equals("[3 -> 4]"), "dividir parte 2 [3 -> 4]");

    // 8. Borrar la lista
    original.borrarLista();
    check(original.estaVacia() && original.longitud() == 0, "borrar deja longitud 0 y vacia");
    System.out.println("Tras borrar: " + original);

    System.out.println("Fin de pruebas.");
  }
}
