import java.util.Scanner;
import java.util.Stack;
public class metodosclientes {

    public Stack<cliente> Llenar(Stack<cliente> clientes, Scanner sc) {
        cliente c = new cliente();
        validaciones v = new validaciones();
        c.setCedula(v.pedirCampo("Ingrese la cedula del cliente:", sc));
        c.setNombre(v.pedirCampo("Ingrese el nombre del cliente:", sc));
        c.setApellido(v.pedirCampo("Ingrese el apellido del cliente:", sc));
        c.setTelefono(v.pedirCampo("Ingrese el telefono del cliente:", sc));
        c.setDireccion(v.pedirCampo("Ingrese la direccion del cliente:", sc));

        clientes.push(c);
        return clientes;
    }

    public Stack<cliente> Modificar ( Stack<cliente> clientes, Scanner sc){
        System.out.println("Ingrese la cedula del cliente a modificar");
        String cedula = sc.nextLine();
        Stack<cliente> aux = new Stack<>();
        boolean encontrado = false;
        while (!clientes.isEmpty()) {
            cliente c = clientes.pop();
            if (c.getCedula().equals(cedula)) {
                encontrado = true;
                System.out.println("Ingrese el nuevo nombre del cliente");
                c.setNombre(sc.next());

                System.out.println("Ingrese el nuevo apellido del cliente");
                c.setApellido(sc.next());

                System.out.println("Ingrese el nuevo telefono del cliente");
                c.setTelefono(sc.next());

                System.out.println("Ingrese la nueva direccion del cliente");
                c.setDireccion(sc.next());

                System.out.println("Ingrese la nueva licencia de conduccion del cliente");
                c.setLicenciaConduccion(sc.next());
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
        System.out.println("Ingrese la cedula del cliente a eliminar");
        String cedula = sc.nextLine();

        boolean eliminado = clientes.removeIf(c -> c.getCedula().equals(cedula));

        if (eliminado) {
        System.out.println("Cliente eliminado");
        } else {
        System.out.println("Cliente no encontrado");
        }
        return clientes;
    }

    public Stack<cliente> Buscar (Stack<cliente> clientes, Scanner sc){
        System.out.println("Ingrese la cedula del cliente a buscar");
        String cedula = sc.nextLine();
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
