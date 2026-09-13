public class Test {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE CONJUNTO ADT ===");

        // Probar Constructor y agregarElemento (y validación de duplicados)
        ConjuntoADT<Integer> conjuntoA = new ConjuntoADT<>();
        conjuntoA.agregarElemento(10);
        conjuntoA.agregarElemento(20);
        conjuntoA.agregarElemento(30);
        conjuntoA.agregarElemento(20); // Duplicado: no debería agregarse
        
        System.out.println("\n--- Conjunto A ---");
        System.out.println(conjuntoA);

        // Probar longitud y contieneElemento
        System.out.println("Longitud del Conjunto A: " + conjuntoA.longitud());
        System.out.println("¿El Conjunto A contiene el 20?: " + conjuntoA.contieneElemento(20));
        System.out.println("¿El Conjunto A contiene el 99?: " + conjuntoA.contieneElemento(99));

        // Probar eliminarElemento
        conjuntoA.eliminarElemento(20);
        System.out.println("\n--- Conjunto A después de eliminar el 20 ---");
        System.out.println(conjuntoA);

        // Creamos un Conjunto B para probar las operaciones entre conjuntos
        ConjuntoADT<Integer> conjuntoB = new ConjuntoADT<>();
        conjuntoB.agregarElemento(10);
        conjuntoB.agregarElemento(30);
        conjuntoB.agregarElemento(40);
        
        System.out.println("\n--- Conjunto B ---");
        System.out.println(conjuntoB);

        // Probar Equals
        ConjuntoADT<Integer> conjuntoC = new ConjuntoADT<>();
        conjuntoC.agregarElemento(10);
        conjuntoC.agregarElemento(30);
        
        System.out.println("\n--- Pruebas de Equals y Subconjuntos ---");
        System.out.println("¿Conjunto B es igual a Conjunto C?: " + conjuntoB.Equals(conjuntoC));

        // Probar esSubConjunto
        System.out.println("¿Conjunto C es subconjunto de Conjunto B?: " + conjuntoC.esSubConjunto(conjuntoB));

        // Probar Union
        ConjuntoADT<Integer> resultadoUnion = conjuntoA.union(conjuntoB);
        System.out.println("\n--- Operaciones de Conjuntos ---");
        System.out.println("Unión (A U B): " + resultadoUnion);

        // Probar Interseccion
        ConjuntoADT<Integer> resultadoInterseccion = conjuntoA.interseccion(conjuntoB);
        System.out.println("Intersección (A ∩ B): " + resultadoInterseccion);

        // Probar Diferencia
        ConjuntoADT<Integer> resultadoDiferencia = conjuntoA.diferencia(conjuntoB);
        System.out.println("Diferencia (A - B): " + resultadoDiferencia);
    }
}
