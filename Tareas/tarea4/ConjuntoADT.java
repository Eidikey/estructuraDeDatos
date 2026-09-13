import java.util.ArrayList;

public class ConjuntoADT<T> {
  private ArrayList<T> elementos;

  public ConjuntoADT() {
    this.elementos = new ArrayList<>();
  }

  public int longitud() {
    return elementos.size();
  }

  public boolean contieneElemento(T elemento) {
    return elementos.contains(elemento);
  }

  public void agregarElemento(T elemento) {
    if (!this.contieneElemento(elemento)) {
      elementos.add(elemento);
    }
  }

  public void eliminarElemento(T elemento) {
    T tmp = elemento;
    if (this.contieneElemento(tmp)){
      this.elementos.remove(tmp);
    } else {
      System.out.println("El elemento que se desea eliminar no existe");
    }
  }

  public boolean Equals (ConjuntoADT<T> otroConjunto) {
    if (this.longitud() != otroConjunto.longitud()) {
      return false;
    } 

    for (int i = 0; i < this.elementos.size(); i++) {
      T elementoActual = this.elementos.get(i);
      if (!otroConjunto.contieneElemento(elementoActual)) {
        return false;
      }
    }
    return true;
  }

  public boolean esSubConjunto(ConjuntoADT<T> otroConjunto) {
    for (int i = 0; i < this.elementos.size(); i++) {
      T elementoActual = this.elementos.get(i);
      if (!otroConjunto.contieneElemento(elementoActual)) {
        return false;
      }
    }
    return true;
  }

  public ConjuntoADT<T> union(ConjuntoADT<T> otroConjunto) {
    ConjuntoADT<T> resultante = new ConjuntoADT<T>();
    for (int i = 0; i < this.elementos.size(); i++) {
      T elementoActual = this.elementos.get(i);
      resultante.agregarElemento(elementoActual);
    }
    for (int i = 0; i < otroConjunto.longitud(); i++) {
     T elementoActual = otroConjunto.getElementos().get(i);
     resultante.agregarElemento(elementoActual);
    }
 
    return resultante;
  }
 
  public ConjuntoADT<T> interseccion (ConjuntoADT<T> otroConjunto){
    ConjuntoADT <T> resultante = new ConjuntoADT<T>();
    for (int i = 0; i < this.elementos.size(); i++) {
      T elementoActual = this.elementos.get(i);
      if (otroConjunto.contieneElemento(this.elementos.get(i))) {
        resultante.agregarElemento(elementoActual);
      }
    }
    return resultante;
  }

  public ConjuntoADT <T> diferencia (ConjuntoADT<T> otroConjunto) {
    ConjuntoADT <T> resultante = new ConjuntoADT<T>();
    for (int i = 0; i < this.elementos.size(); i++) {
      T elementoActual = this.elementos.get(i);
      if (!otroConjunto.contieneElemento(elementoActual)) {
        resultante.agregarElemento(elementoActual);
      }
    }
    return resultante;
  }

  @Override
  public String toString() {
    return "ConjuntoADT{" +
        "elementos=" + elementos +
        '}';
  }

  public ArrayList<T> getElementos() {
    return elementos;
  }

  public void setElementos(ArrayList<T> elementos) {
    this.elementos = elementos;
  }
}
