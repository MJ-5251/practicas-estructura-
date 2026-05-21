import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ValidacionesContratos {
       // VALIDAR CLIENTE EXISTENTE
   public String ClienteExistente(Stack<cliente> VectorClientes, Scanner sc)
   {
      ValidacionesClientes v = new ValidacionesClientes();
      String Cedula;
      // LEER CEDULA
      Cedula = v.ValidarSoloNumeros(sc, 7, 11);

      // VERIFICAR QUE EXISTA
      for (cliente o : VectorClientes) {
         if(o.getCedula().equals(Cedula) && !o.isEliminado())
         {
            return Cedula;
         }
      }
      return Cedula = "SALIR";
   }

   // VALIDAR VEHIUCLO EXISTENTE
   public String VehiucloExistente(Queue<Vehiculo> VectorVehiculos, Scanner sc)
   {
      ValidacionesVehiculos v = new ValidacionesVehiculos();
      String Placa;
      // LEER CEDULA
      Placa = v.ValidarPlaca(sc);
      // VERIFICAR QUE EXISTA
      for (Vehiculo o : VectorVehiculos) {
         if(o.getPlaca().equals(Placa) && !o.isEliminado())
         {
            return Placa;
         }
      }
      return Placa = "SALIR";;
   }

   // VALIDAR FECHA
    public String ValidarFecha(Scanner sc) {
    String fecha;
    
    while (true) {
        fecha = sc.nextLine().trim().replaceAll("\\s+", "");
        
        if (fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            String[] partes = fecha.split("/");
            int Dia = Integer.parseInt(partes[0]);
            int Mes = Integer.parseInt(partes[1]);
            int Anio = Integer.parseInt(partes[2]);
            
            if (Mes >= 1 && Mes <= 12 && Anio >= 2000 && Anio <= 2100) {
                
                int MaxDias;
                if (Mes == 2) {
                    if ((Anio % 4 == 0 && Anio % 100 != 0) || (Anio % 400 == 0)) {
                        MaxDias = 29;
                    } else {
                        MaxDias = 28;
                    }
                } else if (Mes == 4 || Mes == 6 || Mes == 9 || Mes == 11) {
                    MaxDias = 30;
                } else {
                    MaxDias = 31;
                }
                
                if (Dia >= 1 && Dia <= MaxDias) {
                    break;
                }
            }
        }
        System.out.println("ERROR: FECHA INVÁLIDA, FORMATO DD/MM/AAAA, EJEMPLO: 15/05/2024");
    }
    return fecha;
    }

    // VALIDAR VIGENCIA DE CONTRATOS
   public boolean VigenciaContratos(LinkedList<ContratoRenting> VectorContratos, String Cedula)
   {
     boolean eliminar = true;
     for (ContratoRenting c : VectorContratos) {
        if(c.getCedulaCliente().equals(Cedula) && !c.isEliminado() && c.getEstado().equals("ACTIVO"))
        {
            eliminar = false;
        }
     }
     return eliminar;
   }
}
