import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class CrearEstructura{
    public static void CrearClientes()
    {
        ImportarClientes ic = new ImportarClientes();
        ImportarContratos i = new ImportarContratos();
        Menu m = new Menu();

        Stack<cliente> VectorClientes = new Stack<>();
        LinkedList<ContratoRenting> VectorContratos = new LinkedList<>();

        VectorClientes = ic.Importar();
        VectorContratos = i.Importar();

        VectorClientes = m.Clientes(VectorClientes, VectorContratos);
    }

    public static void CrearVehiculo(){
        Menu m = new Menu();
        ImportarVehiculos i = new ImportarVehiculos();
        ImportarContratos ic = new ImportarContratos();

        Queue<Vehiculo> VectorVehiculos = new LinkedList<>();
        LinkedList<ContratoRenting> VectorContratos = new LinkedList<>();

        VectorVehiculos = i.Importar();
        VectorContratos = ic.Importar();

        VectorVehiculos = m.Vehiculos(VectorVehiculos, VectorContratos);
    }

    public static void CrearContratos(){
        Menu m = new Menu();
        ImportarClientes i = new ImportarClientes();
        ImportarVehiculos iv = new ImportarVehiculos();
        ImportarContratos ic = new ImportarContratos();

        Stack<cliente> VectorClientes = new Stack<>();
        Queue<Vehiculo> VectorVehiculos = new LinkedList<>();
        LinkedList<ContratoRenting> VectorContratos = new LinkedList<>();

        VectorClientes = i.Importar();
        VectorVehiculos = iv.Importar();
        VectorContratos = ic.Importar();

        VectorContratos = m.Contratos(VectorContratos, VectorClientes, VectorVehiculos);
    }

    public static void Informe()
    {
        ImportarClientes ic = new ImportarClientes();
        ImportarVehiculos iv = new ImportarVehiculos();
        ImportarContratos ict = new ImportarContratos();
        InformeGeneral informe = new InformeGeneral();

        Stack<cliente> VectorClientes = ic.Importar();
        Queue<Vehiculo> VectorVehiculos = iv.Importar();
        LinkedList<ContratoRenting> VectorContratos = ict.Importar();

        informe.GenerarInforme(VectorClientes, VectorVehiculos, VectorContratos);
    }
}
        System.out.println("NO DISPONIBLE");
    }
}
