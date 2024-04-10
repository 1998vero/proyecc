
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el número de trabajadores:");
        int numTrabajadores = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea después de nextInt()

        Trabajador[] trabajadores = new Trabajador[numTrabajadores];
        
        for (int i = 0; i < numTrabajadores; i++) {
            System.out.println("\nIngrese los datos del trabajador " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Sueldo Bruto: ");
            double sueldoBruto = scanner.nextDouble();
            scanner.nextLine();  // Consumir el salto de línea después de nextDouble()
            System.out.print("Categoría del trabajador (A/B/C): ");
            char categoria = scanner.nextLine().charAt(0);

            trabajadores[i] = new Trabajador(nombre, apellidos, sueldoBruto, categoria);
        }
        
        System.out.println("\nResumen de trabajadores y aumentos salariales:");
        for (int i = 0; i < numTrabajadores; i++) {
            double aumento = trabajadores[i].calcularAumento();
            double nuevoSueldo = trabajadores[i].getSueldoBruto() + aumento;
            System.out.println("Nombre: " + trabajadores[i].getNombre() + " " + trabajadores[i].getApellidos() +
                               " - Sueldo Bruto: " + trabajadores[i].getSueldoBruto() +
                               " - Categoría: " + trabajadores[i].getCategoria() +
                               " - Aumento: " + aumento +
                               " - Nuevo Sueldo: " + nuevoSueldo);
        }
        
        scanner.close();
    }
}

class Trabajador {
    private String nombre;
    private String apellidos;
    private double sueldoBruto;
    private char categoria;

    public Trabajador(String nombre, String apellidos, double sueldoBruto, char categoria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldoBruto = sueldoBruto;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public char getCategoria() {
        return categoria;
    }

    public double calcularAumento() {
        switch (categoria) {
            case 'A':
                return sueldoBruto * 0.1;  // Aumento del 10% para categoría A
            case 'B':
                return sueldoBruto * 0.08;  // Aumento del 8% para categoría B
            case 'C':
                return sueldoBruto * 0.05;  // Aumento del 5% para categoría C
            default:
                return 0;  // Categoría no válida, no hay aumento
        }
    }
}
