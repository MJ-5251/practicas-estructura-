import java.util.Scanner;

public class validaciones {
     
     public int ValidarRango(int n1, int n2, Scanner sc) {
        int numero;
        numero = ValidarEntero(sc);
        while (numero < n1 || numero > n2) {
            System.out.println("POR FAVOR INGRESE UN RANGO DE " + n1 + " HASTA " + n2);
            numero = ValidarEntero(sc);
        }
        return numero;
    }

    public int ValidarEntero(Scanner sc) {
    String Entrada = "";
    while (true) {
        Entrada = sc.nextLine().trim().replaceAll("\\s+", "");
        
        if (!Entrada.isEmpty() && Entrada.matches("[0-9]+") && Entrada.length() <= 10) {
            break;
        }
        System.out.println("POR FAVOR INGRESE UN DIGITO NUMERICO");
    }
    return Integer.parseInt(Entrada);
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

    
 // VALIDAR NOMBRE ,APELLIDO Y MODELO VEHICULO
   public String ValidarSoloLetras(Scanner sc, int n1, int n2) {
    String Validar;
    
    while (true) {
        Validar = sc.nextLine().trim().replaceAll("\\s+", " ");
        
        if (Validar.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") && Validar.length() >= n1 && Validar.length() <= n2) {
            break;
        }
        System.out.println("ERROR: SOLO LETRAS, SIN NÚMEROS NI CARACTERES ESPECIALES, MÁXIMO " + n2 + " CARACTERES");
    }
    
    return Validar;
   }
 
         // VALIDAR CEDULA, TELEFONO Y ID CONTRATO
    public String ValidarSoloNumeros(Scanner sc, int n1, int n2) {
    String Validar;
    
    while (true) {
        Validar = sc.nextLine().trim().replaceAll("\\s+", "");
        
        if (Validar.matches("[0-9]+") && Validar.length() >= n1 && Validar.length() <= n2) {
            break;
        }
        if(n1 == 7)
        {
        System.out.println("ERROR: INGRESE DE 7 A 11 DIGITOS NUMÉRICOS SIN ESPCACIOS");
        }
        else if(n1 == 10){
        System.out.println("ERROR: INGRESE 10 DIGITOS NUMÉRICOS SIN ESPCACIOS");
        }
        else
        {
            System.out.println("ERROR : INGRESE MINIMO 5 DIGITOS NUMERICOS SIN ESPACIOS");
        }
    }
    
    return Validar;
   }


}
