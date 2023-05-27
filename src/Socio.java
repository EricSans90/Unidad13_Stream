import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class Socio implements Comparable<Socio> {
    private String dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaAlta;
    private double cuota;
    private int numFamiliares;

    public Socio(String dni, String nombre, LocalDate fechaNacimiento, LocalDate fechaAlta, double cuota, int numFamiliares) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.cuota = cuota;
        this.numFamiliares = numFamiliares;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public double getCuota() {
        return cuota;
    }

    public int getNumFamiliares() {
        return numFamiliares;
    }

    @Override
    public boolean equals(Object obj) {
        //verificamos si los objetos son la misma referencia
        if (this == obj) {
            return true;
        }
        //verificamos si el objeto pasado es null o no pertenece a la clase Socio
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        //Comparamos dni
        Socio socio = (Socio) obj;
        return dni.equals(socio.dni);
    }

    @Override
    public int compareTo(Socio socio) {
        return dni.compareTo(socio.dni);
    }

    @Override
    public String toString() {
        return "Socio{ dni='" + dni + '\'' + ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento + ", fechaAlta=" + fechaAlta +
                ", cuota=" + cuota + ", numFamiliares=" + numFamiliares + '}';
    }

    public static void main(String[] args) {
        Socio[] socios = new Socio[5];

        socios[0] = new Socio("12345678A", "Armando Pérez Dueñas", LocalDate.of(1985, 8, 15), LocalDate.of(2023, 1, 1), 50.0, 2);
        socios[1] = new Socio("23456789B", "María García Guerra", LocalDate.of(1990, 3, 20), LocalDate.of(2023, 2, 15), 60.0, 1);
        socios[2] = new Socio("34567890C", "Pedro López Paz", LocalDate.of(1988, 6, 10), LocalDate.of(2022, 11, 5), 145.0, 3);
        socios[3] = new Socio("45678901D", "Ana Rodríguez Vidal", LocalDate.of(1992, 11, 25), LocalDate.of(2023, 4, 20), 55.0, 0);
        socios[4] = new Socio("56789012E", "Carlos Sánchez Senen", LocalDate.of(1987, 9, 5), LocalDate.of(2023, 3, 10), 105.0, 2);

        System.out.println("Clientes ordenados por DNI");
        Stream<Socio> streamOrdenadosPorDNI = Arrays.stream(socios)
                .sorted();
        streamOrdenadosPorDNI.forEach(System.out::println);
        System.out.println();

        System.out.println("Clientes con cuota mayor a 100€");
        Stream<Socio> streamCuotaMayor100 = Arrays.stream(socios)
                .filter(socio -> socio.getCuota() > 100);
        streamCuotaMayor100.forEach(System.out::println);
        System.out.println();

        System.out.println("Clientes con nombre que empieza por \"A\"");
        Stream<Socio> streamNombresConA = Arrays.stream(socios)
                .filter(socio -> socio.getNombre().startsWith("A"));
        streamNombresConA.forEach(System.out::println);
        System.out.println();
    }
}