import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class metodosclientes {

    public Stack<cliente> Llenar(Stack<cliente> clientes, Scanner sc) {
        boolean continuar = true;
        String Cedula;
        validaciones v = new validaciones();
        ValidacionesClientes vc = new ValidacionesClientes();
        ExportarClientes e = new ExportarClientes();
        while (continuar) {
        cliente c = new cliente();
        System.out.println("INGRESE LA CEDULA");
        Cedula = vc.CedulaRepetida(sc, clientes);
        if(Cedula.equals("SALIR"))
        {
            e.ExportarArchivo(clientes);
            return clientes;
        }
        else{
         c.setCedula(Cedula);
        }
        
        System.out.println("INGRESE EL NOMBRE");
        c.setNombre(v.ValidarSoloLetras(sc, 2, 15));
        System.out.println("INGRESE EL APELLIDO");
        c.setApellido(v.ValidarSoloLetras(sc, 2, 15));
        System.out.println("INGRESE EL TELEFONO DEL CLIENTE");
        c.setTelefono(vc.ValidarSoloNumeros(sc, 10, 10));
        System.out.println("INGRESE LA DIRECCION DEL CLIENTE");
        c.setDireccion(vc.ValidarDireccion(sc));
        c.setLicenciaConduccion(c.getCedula());
        clientes.push(c);

        System.out.println("DESEA REGISTRAR OTRO CLIENTE");
        System.out.println("1. SI");
        System.out.println("2. NO");
        int opc = v. ValidarRango(1, 2, sc);
        if(opc == 2)
       {
        continuar = false;
       }
        
        }
        e.ExportarArchivo(clientes);
        return clientes;
    }

    public Stack<cliente> Modificar ( Stack<cliente> clientes, Scanner sc){
        ValidacionesClientes vc = new ValidacionesClientes();
        validaciones v = new validaciones();
        ExportarClientes e = new ExportarClientes();
        System.out.println("Ingrese la cedula del cliente a modificar");
        String cedula = vc.ValidarSoloNumeros(sc, 7, 11);
        boolean encontrado = false;
            for (cliente c : clientes) {
            if (c.getCedula().equals(cedula) && !c.isEliminado()) {
                encontrado = true;
                System.out.println("Ingrese el nuevo nombre del cliente");
                c.setNombre(v.ValidarSoloLetras(sc, 2, 15));

                System.out.println("Ingrese el nuevo apellido del cliente");
                c.setApellido(v.ValidarSoloLetras(sc, 2, 15));

                System.out.println("Ingrese el nuevo telefono del cliente");
                c.setTelefono(vc.ValidarSoloNumeros(sc, 10, 10));

                System.out.println("Ingrese la nueva direccion del cliente");
                c.setDireccion(vc.ValidarDireccion(sc));
             }
            }
        if (!encontrado) {
            System.out.println("Cliente no encontrado");
        }
        e.ExportarArchivo(clientes);
        return clientes;
    }

    public Stack<cliente> Eliminar (Stack<cliente> clientes, LinkedList<ContratoRenting> VectorContratos, Scanner sc){
        ValidacionesClientes v = new ValidacionesClientes();
        ExportarClientes e = new ExportarClientes();
        ExportarContratos  ec = new ExportarContratos();
        System.out.println("Ingrese la cedula del cliente a eliminar");
        String cedula = v.ValidarSoloNumeros(sc, 7, 11);
        boolean eliminado = false;

        for (cliente c : clientes) {
            if(c.getCedula().equals(cedula) && !c.isEliminado())
            {
                boolean eliminar = v.VigenciaContratos(VectorContratos, cedula);
                if(eliminar)
                {
                 // ELIMINAR CLIENTE
                  c.setEliminado(false);
                  eliminado = true;

                  // ELIMINAR CONTRATOS RELACIONADOS CON EL CLIENTE
                  for (ContratoRenting o : VectorContratos) {
                      if(o.getCedulaCliente().equals(cedula))
                      {
                        o.setEliminado(false);
                      }
                  }
                  ec.ExportarArchivo(VectorContratos);
                }
                else{
                    System.out.println("CLIENTE TIENE UN CONTRATO VIGENTE, POR FAVOR PRIMERO TERMINE EL CONTRATO");
                    break;
                }
           }
            if (eliminado) {
             System.out.println("Cliente eliminado");
            } else {
            System.out.println("Cliente no encontrado");
            }
        }
        e.ExportarArchivo(clientes);
        return clientes;
    }
    
    public static void Buscar (Stack<cliente> clientes, Scanner sc){
        ValidacionesClientes v = new ValidacionesClientes();
        System.out.println("Ingrese la cedula del cliente a buscar");
        String cedula = v.ValidarSoloNumeros(sc, 7, 11);
        boolean encontrado = false;
        for (cliente c : clientes) {
            if (c.getCedula().equals(cedula) && !c.isEliminado()) {
                System.out.println("Cliente encontrado:");
                System.out.println("Cedula: " + c.getCedula());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                System.out.println("Telefono: " + c.getTelefono());
                System.out.println("Direccion: " + c.getDireccion());
                System.out.println("Licencia de conduccion: " + c.getLicenciaConduccion());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado");
        }
    }
    
}
