import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class ContratoRentingMetodos {
    public LinkedList<ContratoRenting> llenar(LinkedList<ContratoRenting> lista, Stack<cliente> VectorClientes, Queue<Vehiculo> VectorVehiculos, Scanner sc){
        ContratoRenting c = new ContratoRenting();
        ValidacionesContratos vc = new ValidacionesContratos();
        validaciones  v = new validaciones();
        ValidacionesVehiculos  vh = new ValidacionesVehiculos();
        ExportarContratos e = new ExportarContratos();
        boolean continuar = true;

        while (continuar) {
            if(lista == null)
          {
         c.setIdContrato("1000");
         }
         else{
               int numero = Integer.parseInt(lista.getLast().getIdContrato());
             c.setIdContrato(String.valueOf(numero + 1));
         }
          System.out.println("SU ID ES: " + c.getIdContrato());

         System.out.println("INGRESE LA CEDULA DEL CLIENTE");
         String Cedula = vc.ClienteExistente(VectorClientes, sc);
            if(Cedula.equals("SALIR"))
            {
            System.out.println("NO EXISTE CLIENTE CON ESE NUMERO DE CEDULA, POR FAVOR INTENTE DE NUEVO O REGISTRE PRIMERO EL CLIENTE");
            e.ExportarArchivo(lista);
            return lista;
            }
            else{
            c.setCedulaCliente(Cedula);
            }

         System.out.println("INGRESE LA PLACA DEL VEHICULO");
          String Placa = vc.VehiucloExistente(VectorVehiculos, sc);
            if(Placa.equals("SALIR"))
            {
            System.out.println("NO EXISTE VEHICULO CON ESA  PLACA, POR FAVOR INTENTE DE NUEVO O REGISTRE PRIMERO EL VEHCIULO");
            e.ExportarArchivo(lista);
            return lista;
            }
           else{
            c.setPlacaVehiculo(Placa);
            }

        System.out.println("INGRESE LA FECHA DE INICIO");
            c.setFechaInicio(vc.ValidarFecha(sc));

        System.out.println("INGRESE LA FECHA DE FIN");
            c.setFechaFin(vc.ValidarFecha(sc));

        System.out.println("INGRESE EL TOTAL DE DIAS");
            c.setTotalDias(v.ValidarEntero(sc));

         System.out.println("INGRESE EL VALOR TOTAL");
            c.setValorTotal(vh.ValidarFloat(sc));
        
            c.setEstado("ACTIVO");
            lista.add(c);
         
            System.out.println("DESEA REGISTRAR OTRO CONTRATO");
            System.out.println("1. SI");
            System.out.println("2. NO");
            int opc = v. ValidarRango(1, 2, sc);
             if(opc == 2)
             {
            continuar = false;
             }
        }
        e.ExportarArchivo(lista);
        return lista; 
    }

    public LinkedList<ContratoRenting> Modificar(LinkedList<ContratoRenting> lista, Scanner sc){
        ValidacionesContratos vc = new ValidacionesContratos();
        validaciones  v = new validaciones();
        ValidacionesVehiculos vh = new ValidacionesVehiculos();
        ExportarContratos e = new ExportarContratos();
        System.out.println("INGRESE EL ID DEL CONTRATO A MODIFICAR");
        String id = v.v.ValidarEntero(sc);
        for (ContratoRenting c : lista) {
            if (c.getIdContrato().equals(id) && !c.isEliminado()) {

                //System.out.println("Ingrese la fecha de inicio");
                //c.setFechaInicio(sc.next());

                System.out.println("INGRESE LA FECHA DE FIN");
                c.setFechaFin(vc.ValidarFecha(sc));

                System.out.println("INGRESE EL TOTAL DE DIAS");
                c.setTotalDias(v.ValidarEntero(sc));

                System.out.println("INGRESE EL VALOR TOTAL");
                c.setValorTotal(vh.ValidarFloat(sc));
            }
        }
        e.ExportarArchivo(lista);
        return lista;
    }

    
    
}
