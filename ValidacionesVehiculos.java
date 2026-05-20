import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ValidacionesVehiculos {

    public String ValidarPlaca(Scanner sc) {
    String Placa;
    
    while (true) {
        Placa = sc.nextLine().trim().replaceAll("\\s+", "").toUpperCase();
        
        if (Placa.matches("[a-zA-Z]{3}[0-9]{3}")) {
            break;
        }
        System.out.println("ERROR: FORMATO INVÁLIDO, EJEMPLO VÁLIDO: ABC123");
    }
    
    return Placa;
    }

    public int ValidarModelo(Scanner sc)
    {
        validaciones v = new validaciones();
        int Modelo;
        while (true) {
              Modelo = v.ValidarEntero(sc);
              if(String.valueOf(Modelo).length() == 4)
              {
                break;
              }
              System.out.println("ERROR: INGRESE UN MODELO VALIDO DE 4 DIGITOS, EJEMPLO : 2026");
        }
        return Modelo;
    }

    public float ValidarFloat(Scanner sc) {
    String Entrada = "";
    while (true) {
        Entrada = sc.nextLine().trim().replaceAll("\\s+", "");
        
        if (!Entrada.isEmpty() && Entrada.matches("[0-9]+(\\.[0-9]+)?")) {
            float Numero = Float.parseFloat(Entrada);
            if (Numero > 0) {
                break;
            }
        }
        System.out.println("POR FAVOR INGRESE UN VALOR NUMERICO POSITIVO");
    }
    return Float.parseFloat(Entrada);
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

    // VALIDAR PLACA REPETIDA
   public String PlacaRepetida(Scanner sc, Queue<Vehiculo> Vehiculos)
   {
    String Placa;
    boolean encontrado = false;
    validaciones v = new validaciones();
    while (true) {
        Placa = ValidarPlaca(sc);
        for (Vehiculo o : Vehiculos) {
            if(Placa.equals(o.getPlaca()) && !o.isEliminado())
            {
                encontrado = true;
            }
        }
        if(encontrado){
            System.out.println("YA EXISTE UN VEHICULO REGISTRADO CON ESA PLACA");
            System.out.println("1.INGRESAR UNA NUEVA");
            System.out.println("2. SALIR");
            int opc = v.ValidarRango(1, 2, sc);
            if(opc == 2)
            {
                return Placa = "SALIR";
            }
            else{
                System.out.println("INGRESE LA NUEVA PLACA");
            }
            encontrado = false;
        }
        else
        {
           break;
        }
    }
    return Placa;
   }

   // VALIDAR CLIENTE EXISTENTE
   public String ClienteExistente(Stack<cliente> VectorClientes, Scanner sc)
   {
      ValidacionesClientes v = new ValidacionesClientes();
      String Cedula;
      // LEER CEDULA
      Cedula = v.ValidarSoloNumeros(sc, 7, 11);

      // VERIFICAR QUE EXISTA
      for (cliente o : VectorClientes) {
         if(o.getCedulaCliente().equals(Cedula) && !o.isEliminado)
         {
            return Cedula = "SALIR";
         }
      }
      return Cedula;
   }

   // VALIDAR VEHIUCLO EXISTENTE
   public String VehiucloExistente(Queue<Vehiculo> VectorVehiculos, Scanner sc)
   {
      String Placa;
      // LEER CEDULA
      Placa = ValidarPlaca(sc);
      // VERIFICAR QUE EXISTA
      for (Vehiculo o : VectorVehiculos) {
         if(o.getPlacaVehiculo().equals(Placa) && !o.isEliminado)
         {
            return Placa = "SALIR";
         }
      }
      return Placa;
   }
}
