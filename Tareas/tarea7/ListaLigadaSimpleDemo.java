public class ListaLigadaSimpleDemo {

  public static void main(String[] args) {
    ListaLigadaSimpleADT<Gato> lista = new ListaLigadaSimpleADT<>();

    System.out.println("Vacía: " + lista.isEmpty());
    System.out.println("Tamaño: " + lista.getSize());

    Gato bigT = new Gato("The big T", 3, 5.0, "Negro", 10);
    Gato bayo = new Gato("Bayo", 4, 5.5, "Amarillo", 9);
    Gato misi = new Gato("Misi", 2, 3.5, "Gris", 12);
    Gato romeo = new Gato("Romeo", 1, 4.0, "Blanco", 14);
    Gato teto = new Gato("TETO", 5, 6.0, "Naranja", 8);
    Gato viktor = new Gato("VIKTOR", 6, 6.5, "Gris", 7);
    Gato bella = new Gato("Bella", 2, 3.8, "Beige", 11);

    lista.add(bigT);
    lista.addLast(bayo);
    lista.addFirst(misi);
    System.out.print("Tras agregar inicio/final: ");
    lista.traverse();
    System.out.println("Tamaño: " + lista.getSize());

    lista.addAfter(new Gato("The big T", 3, 5.0, "Negro", 10), romeo);
    System.out.print("Tras agregar Romeo después de The big T: ");
    lista.traverse();

    lista.addAfter(viktor, teto);

    System.out.println("Buscar Romeo, posición: " + lista.search(new Gato("Romeo", 1, 4.0, "Blanco", 14)));
    System.out.println("Buscar VIKTOR, posición: " + lista.search(new Gato("VIKTOR", 6, 6.5, "Gris", 7)));

    lista.update(new Gato("Romeo", 1, 4.0, "Blanco", 14), bella);
    System.out.print("Tras actualizar Romeo por Bella: ");
    lista.traverse();

    System.out.println("Eliminado primero: " + lista.removeFirst());
    System.out.print("Lista: ");
    lista.traverse();

    System.out.println("Eliminado final: " + lista.removeLast());
    System.out.print("Lista: ");
    lista.traverse();

    System.out.println("Tamaño final: " + lista.getSize());
    System.out.println("Vacía: " + lista.isEmpty());
  }
}
