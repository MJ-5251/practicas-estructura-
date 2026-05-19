import java.util.LinkedList;
import java.util.Scanner;

public class ContratoRentingMetodos {
    public LinkedList<ContratoRenting> llenar(LinkedList<ContratoRenting> lista, Scanner sc){
        ContratoRenting c = new ContratoRenting();

        System.out.println("Ingrese el id del contrato");
        if(lista == null)
        {
        c.setIdContrato("1000");
        }
        else{
            int numero = Integer.parseInt(lista.getLast().getIdContrato());
            c.setIdContrato(String.valueOf(numero + 1));
        }

        System.out.println("Ingrese la cedula del cliente");
        c.setCedulaCliente(sc.next());

        System.out.println("Ingrese la placa del vehiculo");
        c.setPlacaVehiculo(sc.next());

        System.out.println("Ingrese la fecha de inicio");
        c.setFechaInicio(sc.next());

        System.out.println("Ingrese la fecha de fin");
        c.setFechaFin(sc.next());

        System.out.println("Ingrese el total de dias");
        c.setTotalDias(sc.nextInt());

        System.out.println("Ingrese el valor total");
        c.setValorTotal(sc.nextFloat());
        
        c.setEstado("ACTIVO");

        lista.add(c);

        return lista;
    }

    public LinkedList<ContratoRenting> Modificar(LinkedList<ContratoRenting> lista, Scanner sc){
        System.out.println("Ingrese el id del contrato a modificar");
        String id = sc.next();
        for (ContratoRenting c : lista) {
            if (c.getIdContrato().equals(id)) {

                //System.out.println("Ingrese la fecha de inicio");
                //c.setFechaInicio(sc.next());

                System.out.println("Ingrese la fecha de fin");
                c.setFechaFin(sc.next());

                System.out.println("Ingrese el total de dias");
                c.setTotalDias(sc.nextInt());

                System.out.println("Ingrese el valor total");
                c.setValorTotal(sc.nextFloat());
            }
        }
        return lista;
    }

    
    
}
