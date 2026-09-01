public class Empleado {
  private final int numeroDeTrabajador;
  private final String nombres;
  private final String paterno;
  private final String materno;
  private final int horasExtra;
  private final double sueldoBase;
  private final int aIngreso;

  public static final double PRECIO_HORA_EXTRA = 276.5;
  public static final double PORCENTAJE_PRESTACION = 0.03;

  // a = año
  public Empleado(int numeroDeTrabajador, String nombres, String paterno, String materno,
      int horasExtra, double sueldoBase, int aIngreso) {
    this.numeroDeTrabajador = numeroDeTrabajador;
    this.nombres = nombres;
    this.paterno = paterno;
    this.materno = materno;
    this.horasExtra = horasExtra;
    this.sueldoBase = sueldoBase;
    this.aIngreso = aIngreso;
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

  public int getAIngreso() {
    return aIngreso;
  }

  public int calcularAntiguedad(int aActual) {
    return aActual - aIngreso;
  }

  public double calcularPagoHorasExtra() {
    return horasExtra * PRECIO_HORA_EXTRA;
  }

  public double calcularPrestacion(int aActual) {
    return sueldoBase * PORCENTAJE_PRESTACION * calcularAntiguedad(aActual);
  }

  public double calcularSueldo(int aActual) {
    return sueldoBase + calcularPagoHorasExtra() + calcularPrestacion(aActual);
  }

  @Override
  public String toString() {
    return "Empleado{numeroDeTrabajador=" + numeroDeTrabajador
        + ", nombres='" + nombres + '\''
        + ", paterno='" + paterno + '\''
        + ", materno='" + materno + '\''
        + ", horasExtra=" + horasExtra
        + ", sueldoBase=" + sueldoBase
        + ", añoIngreso=" + aIngreso
        + '}';
  }
}
