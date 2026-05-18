import java.util.Scanner;

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
}
