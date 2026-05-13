import java.util.Stack;

public class CrearEstructura{
    public static void CrearClientes()
    {
        ImportarCliente i = new ImportarCliente();
        Menu m = new Menu();
        Stack<cliente> VectorClientes = new Stack<>();
        VectorClientes = i.Importar();
        VectorClientes = m.Clientes(VectorClientes);
    }
}
