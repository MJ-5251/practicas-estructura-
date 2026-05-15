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

  public String ValidarCedula(Scanner sc) {
    String Cedula;
    
    while (true) {
        Cedula = sc.nextLine().trim().replaceAll("\\s+", "");
        
        if (Cedula.matches("[0-9]+") && Cedula.length() >= 7 && Cedula.length() <= 11) {
            break;
        }
        System.out.println("ERROR: INGRESE DE 7 A 11 DIGITOS NUMÉRICOS SIN ESPCACIOS");
    }
    
    return Cedula;
}
}
