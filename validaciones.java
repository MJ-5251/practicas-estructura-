import java.util.Scanner;

public class validaciones {
    
    public String pedirCampo(String mensaje, Scanner sc) {
        String valor;
        do {
            System.out.println(mensaje);
            valor = sc.nextLine().trim();
            if (valor.isBlank()) {
                System.out.println("Este campo es requerido. Intente de nuevo.");
            }
        } while (valor.isBlank());
        return valor;
    }

    public boolean ValidarDimension(String opt) {
        while (opt.length() > 1) {
            System.out.println("Solo puede agregar Y or N");
            return false;

        }
        return true;

    }

    public boolean ValidarTexto(String texto) {
        return texto.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ{} ]+");
    }
    
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
        
        if (!Entrada.isEmpty() && Entrada.matches("[0-9]+") && Entrada.length() <= 5) {
            break;
        }
        System.out.println("POR FAVOR INGRESE UN DIGITO NUMERICO");
    }
    return Integer.parseInt(Entrada);
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
 
}
