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
        Entrada = sc.nextLine().trim();
        
        if (!Entrada.isEmpty() && Entrada.matches("[0-9]+")) {
            break;
        }
        System.out.println("POPR FAVOR INGRESE UN DIGITO NUMERICO");
    }
    return Integer.parseInt(Entrada);
}

  // VALIDAR CEDULA Y TELEFONO
    public String ValidarCedulaYTelefono(Scanner sc, int n1, int n2) {
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
        else{
        System.out.println("ERROR: INGRESE 10 DIGITOS NUMÉRICOS SIN ESPCACIOS");
        }
    }
    
    return Validar;
   }

   // VALIDAR NOMBRE Y APELLIDO
   public String ValidarNombreYApellido(Scanner sc) {
    String nombre;
    
    while (true) {
        nombre = sc.nextLine().trim().replaceAll("\\s+", " ");
        
        if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") && nombre.length() >= 2 && nombre.length() <= 15) {
            break;
        }
        System.out.println("ERROR: SOLO LETRAS, SIN NÚMEROS NI CARACTERES ESPECIALES, MÁXIMO 15 CARACTERES");
    }
    
    return nombre;
   }
}
