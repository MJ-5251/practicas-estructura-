import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class CrearEstructura{
    public static void CrearClientes()
    {
        ImportarCliente i = new ImportarCliente();
        Menu m = new Menu();
        Stack<cliente> VectorClientes = new Stack<>();
        Queue<Vehiculo> VectorVehiculos = new LinkedList<>();
        LinkedList<ContratoRenting> VectorContratos = new LinkedList<>();

        VectorClientes = i.Importar();
        VectorClientes = m.Clientes(VectorClientes);
    }

    public static void CrearVehiculo(){
        Menu m = new Menu();
        Queue<Vehiculo> VectorVehiculos = new LinkedList<>();
        LinkedList<ContratoRenting> VectorContratos = new LinkedList<>();
        VectorVehiculos = m.Vehiculos(VectorVehiculos);
    }

    public static void CrearContratos(){
        Menu m = new Menu();
        LinkedList<ContratoRenting> VectorContratos = new LinkedList<>();
        VectorContratos = m.Contratos(VectorContratos);
    }

    public static void Informe()
    {
        System.out.println("NO DISPONIBLE");
    }
}
