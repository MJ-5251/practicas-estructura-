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
}
