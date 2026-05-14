import java.util.Scanner;
public class principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CrearEstructura c = new CrearEstructura();
        System.out.println("Bienvenido");
        boolean salir = true;
        while (salir) {
        System.out.println("1. Gestion de clientes");
        System.out.println("2. Gestion de vehiculos");
        System.out.println("3. Gestion de contratos de renting");
        System.out.println("4. Imprimir informe general");
        System.out.println("5. Salir del sistema");
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                c.CrearClientes();
                break;
            case 2:
                c.CrearVehiculo();
                break;
            case 3:
                c.CrearContratos();
                break;
            case 4:
                c.Informe();
                break;
            case 5:
                salir = false;
                break;
            default:
                System.out.println("opcion no valida");
                break;

        }
    }
}
    
}
