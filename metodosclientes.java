import java.util.Scanner;
import java.util.Stack;
public class metodosclientes {

    public Stack<cliente> Llenar(Stack<cliente> clientes, Scanner sc) {
        boolean continuar = true;
        validaciones v = new validaciones();
        ValidacionesClientes vc = new ValidacionesClientes();
        while (continuar) {
        cliente c = new cliente();
        System.out.println("INGRESE LA CEDULA");
        c.setCedula(vc.CedulaRepetida(sc, clientes));
        System.out.println("INGRESE EL NOMBRE");
        c.setNombre(vc.ValidarNombreYApellido(sc));
        System.out.println("INGRESE EL APELLIDO");
        c.setApellido(vc.ValidarNombreYApellido(sc));
        System.out.println("INGRESE EL TELEFONO DEL CLIENTE");
        c.setTelefono(vc.ValidarCedulaYTelefono(sc, 10, 10));
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
        return clientes;
    }

    public Stack<cliente> Modificar ( Stack<cliente> clientes, Scanner sc){
        ValidacionesClientes v = new ValidacionesClientes();
        System.out.println("Ingrese la cedula del cliente a modificar");
        String cedula = v.ValidarCedulaYTelefono(sc, 7, 11);
        Stack<cliente> aux = new Stack<>();
        boolean encontrado = false;
        while (!clientes.isEmpty()) {
            cliente c = clientes.pop();
            if (c.getCedula().equals(cedula)) {
                encontrado = true;
                System.out.println("Ingrese el nuevo nombre del cliente");
                c.setNombre(v.ValidarNombreYApellido(sc));

                System.out.println("Ingrese el nuevo apellido del cliente");
                c.setApellido(v.ValidarNombreYApellido(sc));

                System.out.println("Ingrese el nuevo telefono del cliente");
                c.setTelefono(v.ValidarCedulaYTelefono(sc, 10, 10));

                System.out.println("Ingrese la nueva direccion del cliente");
                c.setDireccion(v.ValidarDireccion(sc));
            }
            aux.push(c);
        }
        while (!aux.isEmpty()) {
            clientes.push(aux.pop());
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado");
        }
        return clientes;
    }

    public Stack<cliente> Eliminar (Stack<cliente> clientes, Scanner sc){
        ValidacionesClientes v = new ValidacionesClientes();
        System.out.println("Ingrese la cedula del cliente a eliminar");
        String cedula = v.ValidarCedulaYTelefono(sc, 7, 11);

        boolean eliminado = clientes.removeIf(c -> c.getCedula().equals(cedula));

        if (eliminado) {
        System.out.println("Cliente eliminado");
        } else {
        System.out.println("Cliente no encontrado");
        }
        return clientes;
    }

    public Stack<cliente> Buscar (Stack<cliente> clientes, Scanner sc){
        ValidacionesClientes v = new ValidacionesClientes();
        System.out.println("Ingrese la cedula del cliente a buscar");
        String cedula = v.ValidarCedulaYTelefono(sc, 7, 11);
        boolean encontrado = false;
        for (cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
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
        return clientes;
    }
    
}
