public class Main {

    public static void main(String[] args) {
        VisitantesWeb miSitio = new VisitantesWeb();

        System.out.println("--- SIMULANDO TRÁFICO WEB ---");
        // Estas son exactamente las IPs de tu diapositiva
        miSitio.registrarVisita("192.168.1.10");
        miSitio.registrarVisita("192.168.1.25");
        miSitio.registrarVisita("192.168.1.10"); // Repetida
        miSitio.registrarVisita("192.168.1.32");
        miSitio.registrarVisita("192.168.1.25"); // Repetida

        System.out.println("\n--- RESULTADOS DEL FILTRADO ---");
        miSitio.mostrarVisitantes();

        System.out.println("\n--- EJECUTANDO PRUEBAS ---");
        int totalCalculado = miSitio.obtenerTotalVisitantes();
        int totalEsperado = 3; // Porque de 5 visitas, 2 eran repetidas

        if (totalCalculado == totalEsperado) {
            System.out.println("✅ PRUEBA EXITOSA: El Set filtró los duplicados correctamente.");
            System.out.println("Se esperaban " + totalEsperado + " visitantes únicos y se obtuvieron " + totalCalculado + ".");
        } else {
            System.out.println("❌ PRUEBA FALLIDA: Hay un error en el conteo.");
            System.out.println("Se esperaban " + totalEsperado + " pero se obtuvieron " + totalCalculado + ".");
        }
    }
}