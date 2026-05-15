import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Menu
{
   public Stack<cliente> Clientes(Stack<cliente> VectorCliente)
   {
      Scanner sc = new Scanner(System.in);
      metodosclientes m = new metodosclientes();
      validaciones v = new validaciones();
      boolean continuar = true;
      while (continuar) {
      System.out.println("1. REGISTAR CLIENTE");
      System.out.println("2. MODIFICAR CLIENTE");
      System.out.println("3. ELIMINAR CLIENTE");
      System.out.println("4. BUSCAR CLIENTE");
      System.out.println("5. VOLVER AL MENÚ PRINCIPAL");
      int opc = v.ValidarEntero(sc);

      switch (opc) {
        case 1:
             VectorCliente = m.Llenar(VectorCliente, sc);
            break;
        case 2:
             VectorCliente = m.Modificar(VectorCliente, sc);
            break;
        case 3:
            VectorCliente = m.Eliminar(VectorCliente, sc);
            break;
        case 4:
            m.Buscar(VectorCliente, sc);
            break;
        case 5:
             continuar = false;
            break;
        default:
            System.out.println("OPCIÓN INVALIDA");
            break;
        }
      }
        return VectorCliente;
    }

   public Queue<Vehiculo> Vehiculos(Queue<Vehiculo> VectorVehiculos)
   {
      Scanner sc = new Scanner(System.in);
      MetodosVehiculo m = new MetodosVehiculo();
      validaciones v = new validaciones();
      boolean continuar = true;
      while (continuar) {
      System.out.println("1. REGISTAR VEHÍCULO");
      System.out.println("2. MODIFICAR VEHÍCULO");
      System.out.println("3. ELIMINAR VEHÍCULO");
      System.out.println("4. BUSCAR VEHÍCULO");
      System.out.println("5. VOLVER AL MENÚ PRINCIPAL");
      int opc = v.ValidarEntero(sc);

      switch (opc) {
        case 1:
             VectorVehiculos = m.Registrar(VectorVehiculos);
            break;
        case 2:
             VectorVehiculos = m.Modificar(VectorVehiculos);
            break;
        case 3:
            VectorVehiculos = m.Eliminar(VectorVehiculos);
            break;
        case 4:
            m.Buscar(VectorVehiculos);
            break;
        case 5:
             continuar = false;
            break;
        default:
            System.out.println("OPCIÓN INVALIDA");
            break;
        }
      }
       return VectorVehiculos;
    }

   public LinkedList<ContratoRenting> Contratos(LinkedList<ContratoRenting> VectorContratos)
   {
      Scanner sc = new Scanner(System.in);
      ContratoRentingMetodos m = new ContratoRentingMetodos();
      validaciones v = new validaciones();
      boolean continuar = true;
      while (continuar) {
      System.out.println("1. REGISTAR NUEVO CONTRATO");
      System.out.println("2. MODIFICAR CONTRATO");
      System.out.println("3. FINALIZAR CONTRATO");
      System.out.println("4. BUSCAR CONTRATO");
      System.out.println("5. VOLVER AL MENÚ PRINCIPAL");
      int opc = v.ValidarEntero(sc);

      switch (opc) {
        case 1:
             VectorContratos = m.llenar(VectorContratos, sc);
            break;
        case 2:
             VectorContratos = m.Modificar(VectorContratos, sc);
            break;
        case 3:
            System.out.println("NO DISPONIBLE");
            break;
        case 4:
            System.out.println("NO DISPONIBLE");
            break;
        case 5:
             continuar = false;
            break;
        default:
            System.out.println("OPCIÓN INVALIDA");
            break;
        }
      }
        return VectorContratos;
    }
}