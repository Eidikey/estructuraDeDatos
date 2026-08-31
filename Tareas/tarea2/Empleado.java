public class Empleado {
  private final int numeroDeTrabajador;
  private final String nombres;
  private final String paterno;
  private final String materno;
  private final int horasExtra;
  private final double sueldoBase;
  private final int anioIngreso;

  public static final double PRECIO_HORA_EXTRA = 276.5;
  public static final double PORCENTAJE_PRESTACION = 0.03;

  public Empleado(int numeroDeTrabajador, String nombres, String paterno, String materno,
      int horasExtra, double sueldoBase, int anioIngreso) {
    this.numeroDeTrabajador = numeroDeTrabajador;
    this.nombres = nombres;
    this.paterno = paterno;
    this.materno = materno;
    this.horasExtra = horasExtra;
    this.sueldoBase = sueldoBase;
    this.anioIngreso = anioIngreso;
  }

  public int getNumeroDeTrabajador() {
    return numeroDeTrabajador;
  }

  public String getNombreCompleto() {
    return nombres + " " + paterno + " " + materno;
  }

  public int getHorasExtra() {
    return horasExtra;
  }

  public double getSueldoBase() {
    return sueldoBase;
  }

  public int getAnioIngreso() {
    return anioIngreso;
  }

  public int calcularAntiguedad(int anioActual) {
    return anioActual - anioIngreso;
  }

  public double calcularPagoHorasExtra() {
    return horasExtra * PRECIO_HORA_EXTRA;
  }

  public double calcularPrestacion(int anioActual) {
    return sueldoBase * PORCENTAJE_PRESTACION * calcularAntiguedad(anioActual);
  }

  public double calcularSueldo(int anioActual) {
    return sueldoBase + calcularPagoHorasExtra() + calcularPrestacion(anioActual);
  }

  @Override
  public String toString() {
    return "Empleado{numeroDeTrabajador=" + numeroDeTrabajador
        + ", nombres='" + nombres + '\''
        + ", paterno='" + paterno + '\''
        + ", materno='" + materno + '\''
        + ", horasExtra=" + horasExtra
        + ", sueldoBase=" + sueldoBase
        + ", anioIngreso=" + anioIngreso
        + '}';
  }
}